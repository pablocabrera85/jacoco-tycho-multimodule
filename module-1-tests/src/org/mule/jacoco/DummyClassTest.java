package org.mule.jacoco;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class DummyClassTest {

    @Test
    public void testEquals() {
        DummyClass one = new DummyClass();
        DummyClass two = new DummyClass();
        assertEquals(one, two);
    }

    @Test
    public void testNotEquals() {
        DummyClass one = new DummyClass();
        DummyClass two = new DummyClass();
        two.setName("foo");
        two.setId("1");
        assertNotEquals(one, two);
    }

    @Test
    public void testHasCodeEquals() {
        DummyClass one = new DummyClass();
        DummyClass two = new DummyClass();
        assertEquals(one.hashCode(), two.hashCode());
    }

    @Test
    public void testHashCodeNotEquals() {
        DummyClass one = new DummyClass();
        DummyClass two = new DummyClass();
        two.setName("foo");
        two.setId("1");
        assertNotEquals(one.hashCode(), two.hashCode());
    }
}
