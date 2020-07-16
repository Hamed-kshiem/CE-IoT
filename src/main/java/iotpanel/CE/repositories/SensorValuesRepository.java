/*
 * Copyright (c) 2020. Hamed  CE
 *
 */

package iotpanel.CE.repositories;

import iotpanel.CE.model.SensorValues;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SensorValuesRepository extends CrudRepository<SensorValues,String> {

    @Query(value = "SELECT * FROM sensor_values WHERE sensor = :sensorID", nativeQuery = true)
    Iterable<SensorValues> findValuesbySensor(String sensorID);

}
