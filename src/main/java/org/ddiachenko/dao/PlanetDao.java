package org.ddiachenko.dao;

import org.ddiachenko.entity.Planet;

public interface PlanetDao {

    boolean createPlanet(Planet planet);
    boolean updatePlanet(Planet planet);
    Planet getPlanetById(String planetId);
    void deletePlanetById(String planetId);

}