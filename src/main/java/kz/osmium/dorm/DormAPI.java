package kz.osmium.dorm;

import kz.osmium.dorm.request.DormGET;
import kz.osmium.dorm.request.DormPOST;
import kz.osmium.dorm.request.DormPUT;
import kz.osmium.util.DomainHTTP;
import org.eclipse.jetty.http.HttpStatus;

import static spark.Spark.*;

public class DormAPI {

    public static void addAPI() {

        getAPI();
        postAPI();
        putAPI();
    }

    /**
     * GET запросы.
     */
    private static void getAPI() {

        path("/api", () -> {
            get("/db", "application/json", (request, response) -> {
                        if (DomainHTTP.getDorm(request.host()))
                            return DormGET.getDB(response);
                        else {

                            response.status(404);

                            return HttpStatus.getCode(404).getMessage();
                        }
                    }
            );

            path("/request", () -> {
                        get("/list", "application/json", (request, response) -> {
                                    if (DomainHTTP.getDorm(request.host()))
                                        return DormGET.getRequestList(request, response);
                                    else {

                                        response.status(404);

                                        return HttpStatus.getCode(404).getMessage();
                                    }
                                }
                        );
                        get("/id/:id", "application/json", (request, response) -> {
                                    if (DomainHTTP.getDorm(request.host()))
                                        return DormGET.getRequestAccount(request, response);
                                    else {

                                        response.status(404);

                                        return HttpStatus.getCode(404).getMessage();
                                    }
                                }
                        );
                    }
            );

            get("/resident", "application/json", (request, response) -> {
                        if (DomainHTTP.getDorm(request.host()))
                            return DormGET.getResident(request, response);
                        else {

                            response.status(404);

                            return HttpStatus.getCode(404).getMessage();
                        }
                    }
            );

            path("/report", () ->{
                get("/all", "application/json", (request, response) -> {
                            if (DomainHTTP.getDorm(request.host()))
                                return DormGET.getReportAll(request, response);
                            else {

                                response.status(404);

                                return HttpStatus.getCode(404).getMessage();
                            }
                        }
                );

                get("/active", "application/json", (request, response) -> {
                            if (DomainHTTP.getDorm(request.host()))
                                return DormGET.getReportActive(request, response);
                            else {

                                response.status(404);

                                return HttpStatus.getCode(404).getMessage();
                            }
                        }
                );
            });
        });
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

    /**
     * PUT запросы.
     */
    private static void putAPI() {

        path("/api", () ->
                path("/request", () ->
                        path("/id", () ->
                                put("/:id", "application/json", (request, response) -> {
                                            if (DomainHTTP.getDorm(request.host()))
                                                return DormPUT.putRequestStatus(request, response);
                                            else {

                                                response.status(404);

                                                return HttpStatus.getCode(404).getMessage();
                                            }
                                        }
                                )
                        )
                )
        );
    }
}
