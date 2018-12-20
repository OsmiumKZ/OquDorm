package kz.osmium.util;

import kz.osmium.request.DormGET;
import org.eclipse.jetty.http.HttpStatus;

import static spark.Spark.*;

public class MethodsHTTP {

    public static void config(){

        getAPI();
    }

    /**
     * GET запросы.
     */
    private static void getAPI() {

        path("/api", () ->
                get("/auth", "application/json", (request, response) -> {
                            if (DomainHTTP.getDorm(request.host()))
                                return DormGET.getAuth(request, response);
                            else {

                                response.status(404);

                                return HttpStatus.getCode(404).getMessage();
                            }
                        }
                ));
    }
}
