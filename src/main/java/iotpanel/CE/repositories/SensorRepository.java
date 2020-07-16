

package iotpanel.CE.repositories;

import iotpanel.CE.model.Sensor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public interface SensorRepository extends CrudRepository<Sensor,String> {
    

}
