/*
 * Copyright (c) 2020. Hamed  CE
 *
 */

package iotpanel.CE.repositories;

import iotpanel.CE.model.LastLogin;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LastLoginREspository extends CrudRepository<LastLogin,String> {
}
