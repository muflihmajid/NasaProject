package com.CleanArc.ProjectNasa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.CleanArc.ProjectNasa.Domain.Entitas.Feed.Components.CloseApproachDatum;
import com.CleanArc.ProjectNasa.Domain.Entitas.Feed.Components.EstimatedDiameter;
import com.CleanArc.ProjectNasa.Domain.Entitas.Feed.Components.Links;
import com.CleanArc.ProjectNasa.Domain.Entitas.Feed.Components.Meteor;

@SpringBootTest
class ProjectNasaApplicationTests {
	private Meteor meteor;

	@BeforeEach
    public void setUp() {
        Links links = new Links();
        ArrayList<CloseApproachDatum> closeApproachData = new ArrayList<>();
        EstimatedDiameter estimatedDiameter = new EstimatedDiameter();
        meteor = new Meteor(links, "123", "456", "Test Meteor", "http://test.nasa", 5.6, estimatedDiameter, true, closeApproachData, false);
    }

    @Test
    public void testGetOrbitedBodies() {
        // Arrange
        CloseApproachDatum datum1 = new CloseApproachDatum();
        datum1.setOrbitingBody("Earth");
        CloseApproachDatum datum2 = new CloseApproachDatum();
        datum2.setOrbitingBody("Mars");
        meteor.closeApproachData.add(datum1);
        meteor.closeApproachData.add(datum2);

        // Act
        List<String> orbitedBodies = meteor.getOrbitedBodies();

        // Assert
        assertEquals(2, orbitedBodies.size());
        assertTrue(orbitedBodies.contains("Earth"));
        assertTrue(orbitedBodies.contains("Mars"));
    }

	@Test
    public void test() {
        // Arrange
        CloseApproachDatum datum1 = new CloseApproachDatum();
        datum1.setOrbitingBody("Earth");
        CloseApproachDatum datum2 = new CloseApproachDatum();
        datum2.setOrbitingBody("Mars");
        meteor.closeApproachData.add(datum1);
        meteor.closeApproachData.add(datum2);

        // Act
        List<String> orbitedBodies = meteor.getOrbitedBodies();

        // Assert
        assertEquals(2, orbitedBodies.size());
        assertTrue(orbitedBodies.contains("Earth"));
        assertTrue(orbitedBodies.contains("Mars"));
    }

	@Test
    public void testGetClosestApproach_NoFutureApproachFound() {
        // Arrange
        ArrayList<CloseApproachDatum> closeApproachData = new ArrayList<>();
        CloseApproachDatum datum1 = new CloseApproachDatum();
        datum1.setCloseApproachDate("2022-02-01");
        CloseApproachDatum datum2 = new CloseApproachDatum();
        datum2.setCloseApproachDate("2024-02-13");
        		
        meteor = new Meteor(null, "123", "456", "Test Meteor", "http://test.nasa", 5.6, null, true, closeApproachData, false);
		meteor.closeApproachData.add(datum1);
        meteor.closeApproachData.add(datum2);
        // Act
        String closestApproach = meteor.getClosestApproach();

        // Assert
        assertEquals("2024-02-13", closestApproach);
    }
}
