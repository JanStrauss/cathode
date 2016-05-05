package eu.over9000.cathode.endpoints;

import eu.over9000.cathode.Result;
import eu.over9000.cathode.data.*;
import eu.over9000.cathode.data.parameters.OffsetPagination;
import eu.over9000.cathode.data.parameters.PutFollowsOptions;

/**
 * <pre>
 * /user										GET
 * /users/:user									GET
 * /users/:user/blocks							GET
 * /users/:user/blocks/:target					DELETE
 * /users/:user/blocks/:target					PUT
 * /users/:user/follows/channels				GET
 * /users/:user/follows/channels/:target		PUT
 * /users/:user/follows/channels/:target		DELETE
 * /users/:user/follows/channels/:target		GET
 * /users/:user/subscriptions/:channel			GET
 * </pre>
 */
public interface Users {

	String PATH = "users";

	Result<User> getUser();

	Result<User> getUser(String userName);

	Result<BlockList> getBlocks(String userName);

	Result<Void> deleteBlock(String userName, String targetName);

	Result<Block> putBlock(String userName, String targetName);

	Result<FollowList> getFollows(String userName, OffsetPagination pagination);

	Result<Follow> getFollows(String userName, String targetName);

	Result<Follow> putFollows(String userName, String targetName, PutFollowsOptions options);

	Result<Void> deleteFollows(String userName, String targetName);

	Result<Subscription> getSubscription(String userName, String channelName);


}
