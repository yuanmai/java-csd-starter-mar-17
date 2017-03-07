package csd.starter;

/**
 * Created by whb on 2017/3/6.
 */
public class Venue {
    private String name;// 球场名称
    private Double lat;// 球场所在地理位置经度
    private Double lng;// 球场所在地理位置经度

    public Venue(String name, Double lat, Double lng) {
        this.name = name;
        this.lat = lat;
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLng() {
        return lng;
    }
}
