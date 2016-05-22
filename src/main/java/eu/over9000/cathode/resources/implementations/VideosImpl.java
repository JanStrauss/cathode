package eu.over9000.cathode.resources.implementations;

import eu.over9000.cathode.Dispatcher;
import eu.over9000.cathode.Result;
import eu.over9000.cathode.data.Video;
import eu.over9000.cathode.data.VideoList;
import eu.over9000.cathode.data.parameters.OffsetPagination;
import eu.over9000.cathode.data.parameters.TopVideoOptions;
import eu.over9000.cathode.resources.Videos;

public class VideosImpl extends AbstractEndpoint implements Videos {
	public VideosImpl(final Dispatcher dispatcher) {
		super(dispatcher);
	}

	@Override
	public Result<Video> getVideo(final String id) {
		return dispatcher.performGet(Video.class, Videos.PATH + "/" + id);
	}

	@Override
	public Result<VideoList> getTopVideos(final TopVideoOptions options, final OffsetPagination pagination) {
		return dispatcher.performGet(VideoList.class, Videos.PATH + "/top", options, pagination);
	}

	@Override
	public Result<VideoList> getFollowed(final OffsetPagination pagination) {
		return dispatcher.performGet(VideoList.class, Videos.PATH + "/followed", pagination);
	}
}
