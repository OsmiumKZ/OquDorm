package kz.osmium.dorm.util.gson;

import com.google.gson.annotations.SerializedName;

public class DormAll {
    @SerializedName("dorms")
    private final Dorm dorms;
    @SerializedName("floors")
    private final Floor floors;
    @SerializedName("kitchens")
    private final Kitchen kitchens;
    @SerializedName("names")
    private final Name names;
    @SerializedName("reports")
    private final Restroom restroom;
    @SerializedName("rooms")
    private final Room rooms;

    public DormAll(Dorm dorms, Floor floors, Kitchen kitchens, Name names, Restroom restroom, Room rooms) {
        this.dorms = dorms;
        this.floors = floors;
        this.kitchens = kitchens;
        this.names = names;
        this.restroom = restroom;
        this.rooms = rooms;
    }
}
