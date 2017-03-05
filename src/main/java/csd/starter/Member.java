package csd.starter;

import java.util.Map;

/**
 * Created by shenzx on 3/5/17.
 */
public class Member {
    private String id;
    private String name;
    private Map.Entry<Float, Float> location;
    private boolean isPremium;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map.Entry<Float, Float> getLocation() {
        return location;
    }

    public boolean isPremium() {
        return isPremium;
    }
}
