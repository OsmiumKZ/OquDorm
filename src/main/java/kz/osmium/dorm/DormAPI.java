package kz.osmium.dorm;

import kz.osmium.dorm.request.DormGET;
import kz.osmium.dorm.request.DormPOST;
import kz.osmium.util.DomainHTTP;
import org.eclipse.jetty.http.HttpStatus;

import static spark.Spark.*;

public class DormAPI {

    public static void addAPI(){

        getAPI();
        postAPI();
    }

    /**
     * GET запросы.
     */
    private static void getAPI() {

        path("/api", () ->
                get("/db", "application/json", (request, response) -> {
                            if (DomainHTTP.getDorm(request.host()))
                                return DormGET.getDB(response);
                            else {

                                response.status(404);

                                return HttpStatus.getCode(404).getMessage();
                            }
                        }
                ));
    }

    /**
     * POST запросы.
     */
    private static void postAPI() {

        path("/api", () ->
                post("/request", "application/json", (request, response) -> {
                            if (DomainHTTP.getDorm(request.host()))
                                return DormPOST.postRequest(request, response);
                            else {

                                response.status(404);

                                return HttpStatus.getCode(404).getMessage();
                            }
                        }
                ));
    }
}
