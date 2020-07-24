

package iotpanel.CE.repositories;

import iotpanel.CE.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public interface SensorRepository extends JpaRepository<Sensor,String> {

}
