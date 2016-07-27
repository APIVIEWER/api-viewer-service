package org.apiviewer.standalone.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apiviewer.standalone.dao.StandAloneAPIDao;
import org.apiviewer.standalone.dao.StandAloneAPIEntity;
import org.apiviewer.standalone.dao.StandAloneAPIEntityCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

/**
 * @author hitesh.bargujar
 */
@Repository
public class StanaAloneAPIDaoImpl
                implements StandAloneAPIDao {

    @Autowired
    private MongoOperations mongo;

    @Override
    public void addStandAloneAPI(StandAloneAPIEntity entity) {
        mongo.save(entity);
    }

    @Override
    public StandAloneAPIEntityCollection getStandAloneAPIs() {
        List<StandAloneAPIEntity> entities = mongo.findAll(StandAloneAPIEntity.class);

        StandAloneAPIEntityCollection entityCollection = new StandAloneAPIEntityCollection();
        entityCollection.setEntities(new ArrayList<StandAloneAPIEntity>());
        entityCollection.getEntities().addAll(
            entities);

        return entityCollection;
    }
}
