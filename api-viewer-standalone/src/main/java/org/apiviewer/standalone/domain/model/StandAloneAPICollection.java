package org.apiviewer.standalone.domain.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author hitesh.bargujar
 *
 */
public class StandAloneAPICollection implements Serializable {

    private static final long serialVersionUID = -7357725712390548434L;

    private List<StandAloneAPIModel> standAloneAPIs;

    public List<StandAloneAPIModel> getStandAloneAPIs() {
        return standAloneAPIs;
    }
    public void setStandAloneAPIs(List<StandAloneAPIModel> standAloneAPIs) {
        this.standAloneAPIs = standAloneAPIs;
    }

}
