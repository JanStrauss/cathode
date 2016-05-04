
/**
 * <pre>
 * /                                           GET
 *
 * /channel                                    GET
 * /channels/:channel                          GET
 * /channels/:channel                          PUT
 * /channels/:channel/commercial               POST
 * /channels/:channel/editors                  GET
 * /channels/:channel/follows                  GET
 * /channels/:channel/stream_key               DELETE
 * /channels/:channel/subscriptions            GET
 * /channels/:channel/subscriptions/:user      GET
 * /channels/:channel/teams                    GET
 * /channels/:channel/videos                   GET
 *
 * /chat/:channel                              GET
 * /chat/:channel/badges                       GET
 * /chat/emoticons                             GET
 * /chat/emoticon_images                       GET
 *
 * /feed/:channel/posts                        GET
 * /feed/:channel/posts                        POST
 * /feed/:channel/posts/:id                    DELETE
 * /feed/:channel/posts/:id                    GET
 * /feed/:channel/posts/:id/reactions          DELETE
 * /feed/:channel/posts/:id/reactions          POST
 *
 * /games/top                                  GET
 *
 * /ingests                                    GET
 *
 * /search/channels                            GET
 * /search/games                               GET
 * /search/streams                             GET
 *
 * /streams                                    GET
 * /streams/:channel/                          GET
 * /streams/featured                           GET
 * /streams/followed                           GET
 * /streams/summary                            GET
 *
 * /teams                                      GET
 * /teams/:team                                GET
 *
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
 *
 * /videos/:id                                 GET
 * /videos/followed                            GET
 * /videos/top                                 GET
 * </pre>
 */
package eu.over9000.cathode.endpoints;