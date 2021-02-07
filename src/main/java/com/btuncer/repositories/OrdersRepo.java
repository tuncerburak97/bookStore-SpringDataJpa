package com.btuncer.repositories;

import com.btuncer.entities.Orders;
import org.springframework.data.repository.CrudRepository;
import java.util.*;

public interface OrdersRepo extends CrudRepository<Orders,Integer> {

    public List<Orders> findByUsersName(String name);


}
