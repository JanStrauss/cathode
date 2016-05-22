package eu.over9000.cathode.resources;

import eu.over9000.cathode.PaginationUtility;
import eu.over9000.cathode.Result;
import eu.over9000.cathode.Twitch;
import eu.over9000.cathode.data.*;
import eu.over9000.cathode.data.parameters.*;
import javafx.scene.image.Image;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.function.Supplier;

public class CathodeTest {

	private Twitch twitch;

	public CathodeTest() {
		final String clientId = System.getenv("twitch_client_id");
		final String authToken = System.getenv("twitch_auth_token");

		System.out.println(System.getProperties().stringPropertyNames());

		twitch = new Twitch(clientId, authToken);
	}

	@Test
	public void tryImages() {
		final Result<Image> x = twitch.imageUtil.getStreamPreview("beyondthesummit", ImageSize.LARGE_PREVIEW, Image::new);
		final Result<Image> y = twitch.imageUtil.getGameBox("Dota 2", ImageSize.LARGE_GAME_BOX, Image::new);
		final Result<Image> z = twitch.imageUtil.getGameLogo("League of Legends", ImageSize.LARGE_GAME_LOGO, Image::new);
		final Result<Image> w = twitch.imageUtil.getOther("https://static-cdn.jtvnw.net/jtv_user_pictures/beyondthesummit-profile_image-d3d31e2a3b0f1e0a-300x300.jpeg", Image::new);

		Assert.assertTrue(x.isOk());
		Assert.assertTrue(y.isOk());
		Assert.assertTrue(z.isOk());
		Assert.assertTrue(w.isOk());
	}

	@Test
	public void tryPanels() {
		final Result<PanelList> result = twitch.undocumented.getPanels("rocketbeanstv");
		result.print();
		Assert.assertTrue(result.isOk());
	}

	@Test
	public void tryChannels() {
		final Result<Channel> result0 = twitch.channels.getChannel();
		final Result<Channel> result1 = twitch.channels.getChannel("forsenlol");
		final Result<Channel> result2 = twitch.channels.putChannel("sykpl3x", new ChannelOptions("lorem ipsum dolor", null));
		final Result<Channel> result3 = twitch.channels.putChannel("sykpl3x", new ChannelOptions(null, "Diablo 3"));

		result0.print();
		result1.print();
		result2.print();
		result3.print();

		Assert.assertTrue(result0.isOk());
		Assert.assertTrue(result1.isOk());
		Assert.assertTrue(result2.isOk());
		Assert.assertTrue(result3.isOk());
	}

	@Test
	public void tryVideos() {
		final Result<VideoList> result = twitch.videos.getFollowed(new OffsetPagination(10));
		//final Result<VideoList> result1 = twitch.videos.getTopVideos(new TopVideoOptions(), new OffsetPagination(10));
		//final Result<Video> result2 = twitch.videos.getVideo("v64403799");

		result.print();
		//result1.print();
		//result2.print();

		Assert.assertTrue(result.isOk());
		//Assert.assertTrue(result1.isOk());
		//Assert.assertTrue(result2.isOk());
	}

	@Test
	public void tryUsers() {
		final Result<Block> result = twitch.users.putBlock("sykpl3x", "teebeutel1222");
		final Result<BlockList> result1 = twitch.users.getBlocks("sykpl3x");
		final Result<Void> result2 = twitch.users.deleteBlock("sykpl3x", "teebeutel1222");
		final Result<BlockList> result3 = twitch.users.getBlocks("sykpl3x");
		final Result<FollowList> result4 = twitch.users.getFollows("sykpl3x", new OffsetPagination(), new Direction(), new GetFollowsSortBy());

		result.print();
		result1.print();
		result2.print();
		result3.print();
		result4.print();

		Assert.assertTrue(result.isOk());
		Assert.assertTrue(result1.isOk());
		Assert.assertTrue(result2.isOk());
		Assert.assertTrue(result3.isOk());
		Assert.assertTrue(result4.isOk());
	}

	@Test
	public void tryTeams() {
		final Result<Team> result = twitch.teams.getTeam("esl");
		final Result<TeamList> result1 = twitch.teams.getTeams(new OffsetPagination(15));

		result.print();
		result1.print();

		Assert.assertTrue(result.isOk());
		Assert.assertTrue(result1.isOk());
	}

	@Test
	public void trySearch() {

		final Result<ChannelList> result = twitch.search.getChannels(new SearchChannelOptions("forsen"), new OffsetPagination(10));
		final Result<GameList> result1 = twitch.search.getGames(new SearchGamesOptions("battlefield"));
		final Result<StreamList> result2 = twitch.search.getStreams(new SearchStreamsOptions("previouslyrecorded"), new OffsetPagination(10));

		result.print();
		result1.print();
		result2.print();

		Assert.assertTrue(result.isOk());
		Assert.assertTrue(result1.isOk());
		Assert.assertTrue(result2.isOk());
	}

	@Test
	public void tryRoot() {
		final Result<RootBox> result = twitch.root.getRoot();

		result.print();

		Assert.assertTrue(result.isOk());
	}

	@Test
	public void tryGames() {
		final OffsetPagination p = new OffsetPagination(25);
		final Result<TopGameList> result = twitch.games.getTopGames(p);

		result.ifOk(list -> list.getTop().forEach(game -> System.out.println(game.getGame().getName() + " = " + game.getViewers())));

		Assert.assertTrue(result.isOk());
	}

	@Test
	public void tryFeed() {
		final CursorPagination p = new CursorPagination(5);
		final Result<PostList> result = twitch.feed.getPosts("sykpl3x", p);
		Assert.assertTrue(result.isOk());

		final String id = result.getResultRaw().getPosts().get(0).getId();

		final Result<Post> result1 = twitch.feed.getPost("sykpl3x", id);
		Assert.assertTrue(result1.isOk());

		final Result<PostBox> result2 = twitch.feed.postPost("sykpl3x", new PostOptions("ayayay"));
		Assert.assertTrue(result2.isOk());

		final String id_new = result2.getResultRaw().getPost().getId();

		final Result<Reaction> result3 = twitch.feed.postReaction("sykpl3x", id_new, new ReactionOption(25));
		Assert.assertTrue(result3.isOk());

		final Result<Void> result4 = twitch.feed.deleteReaction("sykpl3x", id_new, new ReactionOption(25));
		Assert.assertTrue(result4.isOk());

		final Result<Void> result5 = twitch.feed.deletePost("sykpl3x", id_new);
		Assert.assertTrue(result5.isOk());

		result.print();
		result1.print();
		result2.print();
		result3.print();
		result4.print();
		result5.print();
	}

	public static void main(final String[] args) {

	}

	@Test
	public void tryChat() {
		final Result<Badges> result = twitch.chat.getBadges("forsenlol");
		final Result<ChannelEmoticonList> result1 = twitch.chat.getEmoticons("forsenlol");
		final Result<EmoticonList> result2 = twitch.chat.getEmoticons();
		final Result<EmoticonImages> result3 = twitch.chat.getEmoticonImages(new Emotesets("128", "77", "5993"));

		result.print();
		result1.print();
		result2.print();
		result3.print();

		Assert.assertTrue(result.isOk());
		Assert.assertTrue(result1.isOk());
		Assert.assertTrue(result2.isOk());
		Assert.assertTrue(result3.isOk());
	}

	@Test
	public void tryIngests() {
		final Result<IngestList> result = twitch.ingests.getIngests();

		result.print();

		Assert.assertTrue(result.isOk());
	}

	@Test
	public void tryCursorPagination() {
		final CursorPagination pagination = new CursorPagination(75);

		final Supplier<Result<FollowList>> responseSupplier = () -> twitch.channels.getFollows("oluwakanyins", pagination, null);

		final Result<List<Follow>> q = PaginationUtility.collectPaginated(pagination, responseSupplier);

		q.handle(list -> list.forEach(follow -> System.out.println(follow.getUser().getDisplayName())), Throwable::printStackTrace);

		Assert.assertTrue(q.isOk());
	}

	@Test
	public void tryOffsetPagination() {
		final OffsetPagination pagination = new OffsetPagination(100);
		final StreamsQuery query = new StreamsQuery("Dota 2", null, null, null);

		final Supplier<Result<StreamList>> responseSupplier = () -> twitch.streams.getStreams(query, pagination);

		final Result<List<Stream>> q = PaginationUtility.collectPaginated(pagination, responseSupplier);

		q.handle(list -> list.forEach(stream -> System.out.println(stream.getChannel().getName())), Throwable::printStackTrace);

		Assert.assertTrue(q.isOk());
	}

}