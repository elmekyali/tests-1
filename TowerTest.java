package com.nespresso.exercise.pisa;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TowerTest {

    @Test
    public void towerFloorIsSizedAsRequired() {
        final Tower tower = new Tower();
        tower.addFloor(5);
        assertEquals("XXXXX", tower.printFloor(0));

        tower.addFloor(3);
        assertEquals("XXX", tower.printFloor(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void floorsHigherUpMustBeTheSameOrSmallerThanTheFloorBelow() {
        final Tower tower = new Tower();
        tower.addFloor(3);
        tower.addFloor(5);
    }

    @Test
    public void aFloorCanHaveAWindowInTheMiddle() {
        final Tower tower = new Tower();
        tower.addFloorWithWindows(3, 1);
        assertEquals("X0X", tower.printFloor(0));
    }

    @Test
    public void multipleWindowsAreGroupedTogether() {
        final Tower tower = new Tower();
        tower.addFloorWithWindows(7,2);
        assertEquals("XX00XXX", tower.printFloor(0));

        tower.addFloorWithWindows(7,3);
        assertEquals("XX000XX", tower.printFloor(1));
    }

    @Test
    public void aFloorMustHaveAtLeastOneWallPerSide() {
        final Tower tower = new Tower();
        tower.addFloorWithWindows(7,7);
        assertEquals("X00000X", tower.printFloor(0));
    }

    @Test
    public void aFloorBelowAnotherFloorMustSpaceWindowGroupsLargerThanThree() {
        final Tower tower = new Tower();

        tower.addFloorWithWindows(7,4);
        assertEquals("X0000XX", tower.printFloor(0));

        tower.addFloor(7);
        assertEquals("X000X0X", tower.printFloor(0));
    }

    @Test
    public void aFloorBelowTwoOtherFloorsMustSpaceWindowGroupsLargerThanTwo() {
        final Tower tower = new Tower();
        tower.addFloorWithWindows(7,4);
        assertEquals("X0000XX", tower.printFloor(0));

        tower.addFloor(7);
        tower.addFloor(7);
        assertEquals("X00X00X", tower.printFloor(0));
    }

    @Test
    public void aFloorBelowMoreThanThreeOtherFloorsMustOnlyHaveSingleWindows() {
        final Tower tower = new Tower();
        tower.addFloorWithWindows(7,4);
        assertEquals("X0000XX", tower.printFloor(0));

        tower.addFloor(7);
        tower.addFloor(7);
        tower.addFloor(7);
        assertEquals("X0X0X0X", tower.printFloor(0));

        tower.addFloor(7);
        assertEquals("X0X0X0X", tower.printFloor(0));
    }


}
