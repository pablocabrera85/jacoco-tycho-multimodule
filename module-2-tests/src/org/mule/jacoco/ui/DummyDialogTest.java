package org.mule.jacoco.ui;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.mule.jacoco.DummyClass;

public class DummyDialogTest {

    @Test
    public void testNotEquals() {
        DummyDialog one = new DummyDialog();
        DummyDialog two = new DummyDialog();
        DummyClass data = new DummyClass();
        two.setData(data);
        assertNotEquals(one, two);
    }
}
