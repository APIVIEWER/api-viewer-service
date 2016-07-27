package org.apiviewer.standalone.dao;

/**
 * @author hitesh.bargujar
 *
 */
public interface StandAloneAPIDao {

    void addStandAloneAPI(StandAloneAPIEntity entity);
    StandAloneAPIEntityCollection getStandAloneAPIs();
}
