package csd.starter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by CK on 2017/3/5.
 */
public class RoleSelectorTest {

    @Test
    public void testSelectRole() {
        assertEquals("P", RoleSelector.select("p"));
        assertEquals("M", RoleSelector.select("m"));
        assertEquals("", RoleSelector.select("a"));
    }
}
