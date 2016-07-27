package org.apiviewer.standalone.service;

import org.apiviewer.standalone.domain.model.StandAloneAPICollection;
import org.apiviewer.standalone.domain.model.StandAloneAPIModel;

public interface StandAloneAPIService {

	void addStandAloneAPI(StandAloneAPIModel model);
	
	StandAloneAPICollection getStandAloneAPIs();
	
}
