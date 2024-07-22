package com.entertainment;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TelevisionTest {

    private Television tv;

    @Before
    public void setUP() {
        tv = new Television();
    }

    @Test
    public void changeChannel_shouldStoreValue_whenValid_upperBound() throws Exception {
        tv.changeChannel(999);
        assertEquals(999, tv.get.CurrentChannel());
    }

    @Test
    public void changeChannel_shouldStoreValue_whenValid_lowerBound() throws Exception {
        tv.changeChannel(1);
        assertEquals(1, tv.getCurrentChannel());

    }

    // ToDo - we still need to check -1 and 101
    @Test
    public void setVolume_shouldThrowIllegalArguementException_whenInvalid_lowerBound() {
        tv.setVolume(-1);       // should throw exception

    }

    @Test
    public void setVolume_shouldStoreValue_whenValid() {
        tv.setVolume(0);
        assertEquals(tv.getVolume(), 0, tv.getVolume());

    }
}