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

            /*
             * Получение всех данных из БД Dorm. Только общедоступная информация.
             *
             * https://*.example.com/api/db
             */
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

                        /*
                         * Получение списка всех активных заявлений для администратора.
                         *
                         * https://*.example.com/api/request/list
                         */
                        get("/list", "application/json", (request, response) -> {
                                    if (DomainHTTP.getDorm(request.host()))
                                        return DormGET.getRequestList(request, response);
                                    else {

                                        response.status(404);

                                        return HttpStatus.getCode(404).getMessage();
                                    }
                                }
                        );

                        /*
                         * Получение заявления для студента.
                         *
                         * https://*.example.com/api/request
                         * & account = <Integer>
                         */
                        get("application/json", (request, response) -> {
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

            /*
             * Получить список всех заселенных и когда-то бывших заселенных.
             *
             * https://*.example.com/api/resident
             */
            get("/resident", "application/json", (request, response) -> {
                        if (DomainHTTP.getDorm(request.host()))
                            return DormGET.getResident(request, response);
                        else {

                            response.status(404);

                            return HttpStatus.getCode(404).getMessage();
                        }
                    }
            );

            path("/report", () -> {

                /*
                 * Получить все отчеты.
                 *
                 * https://*.example.com/api/report/all
                 */
                get("/all", "application/json", (request, response) -> {
                            if (DomainHTTP.getDorm(request.host()))
                                return DormGET.getReportAll(request, response);
                            else {

                                response.status(404);

                                return HttpStatus.getCode(404).getMessage();
                            }
                        }
                );

                /*
                 * Получить отчеты активные для принятия решения администрации.
                 *
                 * https://*.example.com/api/report/active
                 */
                get("/active", "application/json", (request, response) -> {
                            if (DomainHTTP.getDorm(request.host()))
                                return DormGET.getReportActive(request, response);
                            else {

                                response.status(404);

                                return HttpStatus.getCode(404).getMessage();
                            }
                        }
                );

                /*
                 * Получить отчеты для аккаунта.
                 *
                 * https://*.example.com/api/report
                 * & account = <Integer>
                 */
                get("application/json", (request, response) -> {
                            if (DomainHTTP.getDorm(request.host()))
                                return DormGET.getReportAccount(request, response);
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

        /*
         * Создать новое заявление на бронирование комнаты.
         *
         * https://*.example.com/api/request
         * & account = <Integer>
         * & room = <Integer>
         * & period = <Integer>
         * [-] & email = <String>
         */
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

        path("/api", () -> {

                    /*
                     * Изменить статус заявления по ID студента.
                     *
                     * https://*.example.com/api/request
                     * & account = <Integer>
                     * & status = <Integer>
                     */
                    put("/request", "application/json", (request, response) -> {
                                if (DomainHTTP.getDorm(request.host()))
                                    return DormPUT.putRequestStatus(request, response);
                                else {

                                    response.status(404);

                                    return HttpStatus.getCode(404).getMessage();
                                }
                            }
                    );

                    /*
                     * Изменение статуса отчета по ID отчета.
                     *
                     * https://*.example.com/api/report
                     * & id = <Integer>
                     * & status = <Integer>
                     */
                    put("/report", "application/json", (request, response) -> {
                                if (DomainHTTP.getDorm(request.host()))
                                    return DormPUT.putReportStatus(request, response);
                                else {

                                    response.status(404);

                                    return HttpStatus.getCode(404).getMessage();
                                }
                            }
                    );
                }
        );
    }
}
