package iotpanel.CE.repositories;

import iotpanel.CE.model.RFID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RFIDRepository extends JpaRepository<RFID,String> {
}
