/*
 * Copyright (c) 2020. Hamed  CE
 *
 */

package iotpanel.CE.repositories;

import iotpanel.CE.model.SensorValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface SensorValuesRepository extends JpaRepository<SensorValues,String> {

    @Query(value = "SELECT * FROM sensor_values WHERE sensor = :sensorID", nativeQuery = true)
    Iterable<SensorValues> findValuesbySensor(String sensorID);

    @Query(value = "SELECT * FROM sensor_values WHERE sensor = :sensorID ORDER BY insertdate DESC  LIMIT 1", nativeQuery = true)
    SensorValues findLastValue(String sensorID);

}
