package org.example;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class OpenSiteTest extends Main {
    @Test
    public void functionalTest() {
        assertEquals(driver.getTitle(), "My Project for Team Punk");
    }
}