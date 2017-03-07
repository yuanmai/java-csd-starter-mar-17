package csd.starter;

/**
 * Created by whb on 2017/3/6.
 */
public class Member {
    private String name;// 用户名
    private Double lat;// 用户目前所在地理位置经度
    private Double lng;// 用户目前所在地理位置经度

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }
}
