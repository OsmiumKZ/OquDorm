package kz.osmium.dorm.util.gson;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class DormAll {
    @SerializedName("dorms")
    private List<Dorm> dorms = new ArrayList<>();
    @SerializedName("floors")
    private List<Floor> floors = new ArrayList<>();
    @SerializedName("kitchens")
    private List<Kitchen> kitchens = new ArrayList<>();
    @SerializedName("names")
    private List<Name> names = new ArrayList<>();
    @SerializedName("restrooms")
    private List<Restroom> restroom = new ArrayList<>();
    @SerializedName("rooms")
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
