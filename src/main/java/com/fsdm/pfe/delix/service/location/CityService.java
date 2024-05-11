/*
 *
 *  * @project : DeliX
 *  * @created : 11/05/2024, 14:16
 *  * @modified : 11/05/2024, 14:16
 *  * @description : This file is part of the DeliX project.
 *  * @license : MIT License
 *
 */

package com.fsdm.pfe.delix.service.location;

import com.fsdm.pfe.delix.entity.location.City;

import java.util.List;

public interface CityService {
    City create(City city);
    City update(City city);
    City findById(Long id);
    City findByCode(String code);
    List<City> findAll();
    void delete(Long id);
    void deleteByCode(String code);
    List<City> saveAll(List<City> cities);
}
