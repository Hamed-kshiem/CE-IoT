package iotpanel.CE.controller;

import iotpanel.CE.model.Sensor;
import iotpanel.CE.model.SensorValues;
import iotpanel.CE.repositories.SensorRepository;
import iotpanel.CE.repositories.SensorValuesRepository;
import iotpanel.CE.socket.ChatWebSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/sensor")
public class SensorController {
    @Autowired
    SensorRepository Sensor;
    @Autowired
    SensorValuesRepository sensorValue;
    @Autowired
    ChatWebSocketHandler socketHandler;

    @RequestMapping(value = {"", "/"})
    public List<Sensor> getall() {
        return Sensor.findAll();
    }

    @GetMapping(value = {"/{id}"})
    public Optional<Sensor> getSensorByID(@PathVariable(value = "id") String Sensorid) {
        return Sensor.findById(Sensorid);
    }

    @GetMapping(value = {"/{id}/values"})
    public Set<SensorValues> getSensorValuesByID(@PathVariable(value = "id") String Sensorid) {
        return Sensor.findById(Sensorid).get().getSensorValues();
    }

    @GetMapping(value = {"/{id}/values/last"})
    public SensorValues getSensorLAstValuesByID(@PathVariable(value = "id") String Sensorid) {
        return sensorValue.findLastValue(Sensorid);
    }

    /*{
    "name":"heatedSensor",
    "location":"vienna",
    "type":"Temp",
    "active":"true",
    "release":"1594901570172",
    "value":"12",
    "nfc":"nfctag name"
}*/
    @PostMapping("/insert")
    public ResponseEntity addSensor(@RequestBody Sensor SensorBody) {
        System.out.println(SensorBody.toString());
        Sensor.save(SensorBody);
        return new ResponseEntity("Hello World!", HttpStatus.OK);
    }

    /*
    localhost:8080/sensor/insert/402881837357967c0173579691a30000/values
    {
    "value":"123",
    "insertdate":"1594901570172"
     }
*/
    @PostMapping("/insert/{id}/values")
    public Optional<SensorValues> addSensorValue(@PathVariable(value = "id") String Sensorid, @RequestBody SensorValues SensorValueBody) {
        System.out.println(SensorValueBody);
        return Sensor.findById(Sensorid).map(Sensor -> {
            SensorValueBody.setSensor(Sensor);
            return sensorValue.save(SensorValueBody);
            
        });
    }

    //localhost:8080/sensor/402881837357967c0173579691a30000/sensorvalues
    @GetMapping("/{id}/sensorvalues")
    public Iterable<SensorValues> getSensorValues(@PathVariable(value = "id") String sensorID) {
        return sensorValue.findValuesbySensor(sensorID);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Sensor> deleteSensor(@PathVariable(value = "id") String sensorID) {
        Sensor.deleteById(sensorID);
        return new ResponseEntity("Sensor was deleted", HttpStatus.MULTI_STATUS);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateSensor(@PathVariable(value = "id") String sensorID, @RequestBody Sensor SensorBody) {
        Sensor sensor = Sensor.findById(sensorID).get();
        Sensor.save(sensor);
        return new ResponseEntity("Sensor was updated", HttpStatus.MULTI_STATUS);
    }

    @GetMapping("/favsensorvalues")
    public Map<Object, Object> getFavSensors() {
        Map<Object, Object> FavSenors = new HashMap<>();
        FavSenors.put( new AbstractMap.SimpleEntry<String, String>("name", "Room 1"),  new AbstractMap.SimpleEntry<String, Integer>("value", 23));
        FavSenors.put( new AbstractMap.SimpleEntry<String, String>("name", "Room 2"),  new AbstractMap.SimpleEntry<String, Integer>("value", 15));
        FavSenors.put( new AbstractMap.SimpleEntry<String, String>("name", "Room 3"),  new AbstractMap.SimpleEntry<String, Integer>("value", 30));
        FavSenors.put( new AbstractMap.SimpleEntry<String, String>("name", "Room 4"),  new AbstractMap.SimpleEntry<String, Integer>("value", 25));
        FavSenors.put( new AbstractMap.SimpleEntry<String, String>("name", "Room 5"),  new AbstractMap.SimpleEntry<String, Integer>("value", 17));
        FavSenors.put( new AbstractMap.SimpleEntry<String, String>("name", "Room 6"),  new AbstractMap.SimpleEntry<String, Integer>("value", 8));
        FavSenors.put( new AbstractMap.SimpleEntry<String, String>("name", "Room 7"),  new AbstractMap.SimpleEntry<String, Integer>("value", 10));
        FavSenors.put( new AbstractMap.SimpleEntry<String, String>("name", "Room 8"),  new AbstractMap.SimpleEntry<String, Integer>("value", 12));

        return  FavSenors;
    }
}
