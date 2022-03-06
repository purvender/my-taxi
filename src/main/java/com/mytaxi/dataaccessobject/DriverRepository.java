package com.mytaxi.dataaccessobject;

import com.mytaxi.domainobject.DriverDO;
import com.mytaxi.domainvalue.OnlineStatus;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Database Access Object for driver table.
 * <p/>
 */
public interface DriverRepository extends MongoRepository<DriverDO, String>
{

    List<DriverDO> findByOnlineStatus(OnlineStatus onlineStatus);
    
    DriverDO findByIdAndOnlineStatus (String id, OnlineStatus onlineStatus);
    
    DriverDO findByUsernameAndPassword (String username, String password);
}
