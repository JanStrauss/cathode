package eu.over9000.cathode.endpoints;

import eu.over9000.cathode.Result;
import eu.over9000.cathode.data.*;
import eu.over9000.cathode.data.parameters.Direction;
import eu.over9000.cathode.data.parameters.GetFollowsSortBy;
import eu.over9000.cathode.data.parameters.OffsetPagination;
import eu.over9000.cathode.data.parameters.PutFollowsOptions;

/**
 * <pre>
 * /user										GET				getUser();
 * /users/:user									GET				getUser(String userName);
 * /users/:user/blocks							GET				getBlocks(String userName);
 * /users/:user/blocks/:target					DELETE			deleteBlock(String userName, String targetName);
 * /users/:user/blocks/:target					PUT				putBlock(String userName, String targetName);
 * /users/:user/follows/channels				GET				getFollows(String userName, OffsetPagination pagination, Direction direction, GetFollowsSortBy sortby);
 * /users/:user/follows/channels/:target		PUT				putFollows(String userName, String targetName, PutFollowsOptions options);
 * /users/:user/follows/channels/:target		DELETE			deleteFollows(String userName, String targetName);
 * /users/:user/follows/channels/:target		GET				getFollows(String userName, String targetName);
 * /users/:user/subscriptions/:channel			GET				getSubscription(String userName, String channelName);
 * </pre>
 */
public interface Users {

	String PATH = "users";

	Result<User> getUser();

	Result<User> getUser(String userName);

	Result<BlockList> getBlocks(String userName);

	Result<Void> deleteBlock(String userName, String targetName);

	Result<Block> putBlock(String userName, String targetName);

	Result<FollowList> getFollows(String userName, OffsetPagination pagination, Direction direction, GetFollowsSortBy sortby);

	Result<Follow> getFollows(String userName, String targetName);

	Result<Follow> putFollows(String userName, String targetName, PutFollowsOptions options);

	Result<Void> deleteFollows(String userName, String targetName);

	Result<Subscription> getSubscription(String userName, String channelName);


}
