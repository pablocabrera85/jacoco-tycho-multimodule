package org.mule.jacoco;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.Tag;

@Epic("Allure examples")
@Feature("Junit 4 support")
public class DummyClassTest {

    @Story("MyStory1")
    @Tag("useless")
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

    @Tag("useless")
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
