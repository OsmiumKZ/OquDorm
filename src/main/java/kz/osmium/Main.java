package kz.osmium;

import kz.osmium.util.MethodsHTTP;

import static spark.Spark.*;

public class Main {

    /**
     * Запускает WebSocket
     * Port и запросы настроенны именно в этом методе.
     */
    public static void main(String[] args) {
        /* Изменяет port. */
        port(getHerokuAssignedPort());

        /* Конфигурация WebSocket */
        config();

        /* Разрешаю лок. серверу доступ к API */
        preferences();

        /* Конфигурация API */
        MethodsHTTP.config();
    }

    /**
     * Конфигурация WebSocket
     */
    private static void config() {

        after("/api/*", (req, res) -> res.type("application/json"));
    }

    /**
     * Настройка сервера "Access-Control-Allow-Origin"
     */
    private static void preferences() {

        options("/*",
                (request, response) -> {

                    String accessControlRequestHeaders = request
                            .headers("Access-Control-Request-Headers");
                    if (accessControlRequestHeaders != null) {
                        response.header("Access-Control-Allow-Headers",
                                accessControlRequestHeaders);
                    }

                    String accessControlRequestMethod = request
                            .headers("Access-Control-Request-Method");
                    if (accessControlRequestMethod != null) {
                        response.header("Access-Control-Allow-Methods",
                                accessControlRequestMethod);
                    }

                    return "OK";
                });

        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));
    }

    /**
     * Настройка port'а
     * С heroku.com приходит ответ зарег. порта для WebSocket'а
     *
     * @return если сервер запущен на стороне heroku.com, то будет использован port от heroku.com.
     */
    private static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();

        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }

        return 4567;
    }
}
