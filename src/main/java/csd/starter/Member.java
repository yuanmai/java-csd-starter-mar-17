package csd.starter;

import java.util.Map;

/**
 * Created by shenzx on 3/5/17.
 */
public class Member {
    private String id;
    private String name;
    private int[] location;
    private boolean isPremium;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int[] getLocation() {
        return location;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(int[] location) {
        this.location = location;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }
}
