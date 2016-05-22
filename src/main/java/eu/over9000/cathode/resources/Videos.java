package eu.over9000.cathode.resources;

import eu.over9000.cathode.Result;
import eu.over9000.cathode.data.Video;
import eu.over9000.cathode.data.VideoList;
import eu.over9000.cathode.data.parameters.OffsetPagination;
import eu.over9000.cathode.data.parameters.TopVideoOptions;

/**
 * <pre>
 * /videos/:id                                 GET			getVideo(String id);
 * /videos/followed                            GET			getFollowed(OffsetPagination pagination);
 * /videos/top                                 GET			getTopVideos(TopVideoOptions options, OffsetPagination pagination);
 * </pre>
 */
public interface Videos {
	String PATH = "videos";

	Result<Video> getVideo(String id);

	Result<VideoList> getTopVideos(TopVideoOptions options, OffsetPagination pagination);

	Result<VideoList> getFollowed(OffsetPagination pagination);

}
