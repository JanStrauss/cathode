package eu.over9000.cathode.endpoints;

/**
 * <pre>
 * /user                                       GET
 * /users/:user                                GET
 * /users/:user/blocks                         GET
 * /users/:user/blocks/:target                 DELETE
 * /users/:user/blocks/:target                 PUT
 * /users/:user/follows/channels               GET
 * /users/:user/follows/channels/:target		PUT
 * /users/:user/follows/channels/:target       DELETE
 * /users/:user/follows/channels/:target       GET
 * /users/:user/subscriptions/:channel         GET
 * </pre>
 */
public interface Users {
	void getBlocks(String userName);

	void putBlock(String userName, String targetName);

	void delBlock(String userName, String targetName);

	void getUser(String userName);

	void getUser();
}
