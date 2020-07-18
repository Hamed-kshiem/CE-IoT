/*
 * Copyright (c) 2020. Hamed  CE
 *
 */

package iotpanel.CE.repositories;

import iotpanel.CE.model.LastLogin;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.repository.CrudRepository;

public interface LastLoginREspository extends CrudRepository<LastLogin,String> {
}
