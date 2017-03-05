package csd.starter;

/**
 * Created by CK on 2017/3/5.
 */
public class Court {
    private int id;
    private double longitude;
    private double latitude;

    public int getId() {
        return id;
    }

    public Court setId(int id) {
        this.id = id;
        return this;
    }

    public double getLongitude() {
        return longitude;
    }

    public Court setLongitude(double longitude) {
        this.longitude = longitude;
        return this;
    }

    public double getLatitude() {
        return latitude;
    }

    public Court setLatitude(double latitude) {
        this.latitude = latitude;
        return this;
    }
}
