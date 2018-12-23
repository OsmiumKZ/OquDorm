package kz.osmium.util;

import kz.osmium.account.AccountAPI;
import kz.osmium.dorm.DormAPI;

public class MethodsHTTP {

    /**
     * Конфигурация API на WebSocket'е
     */
    public static void config() {

        AccountAPI.addAPI();
        DormAPI.addAPI();
    }
}
