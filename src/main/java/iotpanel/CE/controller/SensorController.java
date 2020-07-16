package iotpanel.CE.controller;

import iotpanel.CE.model.Sensor;
import iotpanel.CE.model.SensorValues;
import iotpanel.CE.repositories.SensorRepository;
import iotpanel.CE.repositories.SensorValuesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/sensor")
public class SensorController {
    @Autowired
    SensorRepository Sensor ;
    @Autowired
    SensorValuesRepository sensorValue;

    @RequestMapping(value = {"","/"})
    public Iterable<Sensor> index() {
        return Sensor.findAll();
    }

    @PostMapping("/insert")
    public ResponseEntity addSensor(@RequestBody Sensor SensorBody) {
        System.out.println(SensorBody.toString());
        Sensor.save(SensorBody);
        return new ResponseEntity("Hello World!", HttpStatus.OK);
    }

    @PostMapping("/insert/{id}/values")
    public Optional<SensorValues> addSensorValue(@PathVariable(value = "id") String Sensorid, @RequestBody SensorValues SensorValueBody) {
        return Sensor.findById(Sensorid).map(Sensor -> {
            SensorValueBody.setSensor(Sensor);
            return sensorValue.save(SensorValueBody);
        });
    }

    @GetMapping("/{id}/sensorvalues")
    public Iterable<SensorValues> getSensorValues(@PathVariable(value = "id")String sensorID){
        return sensorValue.findValuesbySensor(sensorID);
    }


}
