package org.ddiachenko.service;

import org.ddiachenko.dao.PlanetDaoImpl;
import org.ddiachenko.entity.Planet;

public class PlanetCrudService {

    private final PlanetDaoImpl planetDao = new PlanetDaoImpl();

    public boolean createPlane(Planet planet){
        return planetDao.createPlanet(planet);
    }

    public boolean updatePlane(Planet planet){
        return planetDao.updatePlanet(planet);
    }

    public void deletePlane(Long id){
        planetDao.deletePlanetById(id);
    }

    public Planet findPlanetById(String id){
        return planetDao.getPlanetById(id);
    }
    
}