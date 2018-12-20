package kz.osmium.dorm;

import kz.osmium.account.request.AccountGET;
import kz.osmium.dorm.request.DormGET;
import kz.osmium.util.DomainHTTP;
import org.eclipse.jetty.http.HttpStatus;

import static spark.Spark.get;
import static spark.Spark.path;

public class DormAPI {

    public static void addAPI(){

        getAPI();
    }

    /**
     * GET запросы.
     */
    private static void getAPI() {

        path("/api", () ->
                get("/db", "application/json", (request, response) -> {
                            if (DomainHTTP.getDorm(request.host()))
                                return DormGET.getDB(request, response);
                            else {

                                response.status(404);

                                return HttpStatus.getCode(404).getMessage();
                            }
                        }
                ));
    }
}
