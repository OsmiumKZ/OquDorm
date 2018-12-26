package kz.osmium.dorm.util.gson;

import com.google.gson.annotations.SerializedName;
import kz.osmium.util.DataConfig;

import java.util.ArrayList;
import java.util.List;

public class DataBase {

    /* Объект общежитий */
    @SerializedName(DataConfig.DB_DORM_DORM)
    private List<Dorm> dorms = new ArrayList<>();

    /* Объект этажей */
    @SerializedName(DataConfig.DB_DORM_FLOOR)
    private List<Floor> floors = new ArrayList<>();

    /* Объект кухнь */
    @SerializedName(DataConfig.DB_DORM_KITCHEN)
    private List<Kitchen> kitchens = new ArrayList<>();

    /* Объект названий */
    @SerializedName(DataConfig.DB_DORM_NAME)
    private List<Name> names = new ArrayList<>();

    /* Объект уборных */
    @SerializedName(DataConfig.DB_DORM_RESTROOM)
    private List<Restroom> restroom = new ArrayList<>();

    /* Объект комнат */
    @SerializedName(DataConfig.DB_DORM_ROOM)
    private List<Room> rooms = new ArrayList<>();

    public List<Dorm> getDorms() {
        return dorms;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public List<Kitchen> getKitchens() {
        return kitchens;
    }

    public List<Name> getNames() {
        return names;
    }

    public List<Restroom> getRestroom() {
        return restroom;
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
