package com.btuncer.repositories;

import com.btuncer.entities.Address;
import org.springframework.data.repository.CrudRepository;
import java.util.*;

public interface AddressRepo extends CrudRepository<Address,Integer> {

    public List<Address> findByCity(String city);

}
