package kz.osmium.account;

import kz.osmium.account.request.AccountGET;
import kz.osmium.util.DomainHTTP;
import kz.osmium.util.token.RuleToken;
import kz.osmium.util.token.Token;
import org.eclipse.jetty.http.HttpStatus;

import static spark.Spark.get;
import static spark.Spark.path;

public class AccountAPI {

    public static void addAPI() {

        getAPI();
    }

    /**
     * GET запросы.
     */
    private static void getAPI() {

        path("/api", () -> {
            path("/auth", () -> {
                get("/user", "application/json", (request, response) -> {
                            if (DomainHTTP.getDorm(request.host()))
                                return AccountGET.getAuth(request, response);
                            else {

                                response.status(404);

                                return HttpStatus.getCode(404).getMessage();
                            }
                        }
                );

                get("/admin", "application/json", (request, response) -> {
                            if (DomainHTTP.getDorm(request.host()))
                                return AccountGET.getAdmin(request, response);
                            else {

                                response.status(404);

                                return HttpStatus.getCode(404).getMessage();
                            }
                        }
                );
            });

            get("/account", "application/json", (request, response) -> {
                        if (DomainHTTP.getDorm(request.host())) {
                            if (Token.checkToken(request.headers("token"), RuleToken.ADMIN)) {
                                return AccountGET.getAccount(request, response);
                            } else {

                                response.status(401);

                                return HttpStatus.getCode(401).getMessage();
                            }
                        } else {

                            response.status(404);

                            return HttpStatus.getCode(404).getMessage();
                        }
                    }
            );
        });
    }
}
