package org.apiviewer.standalone.service;

import java.util.List;

import org.apiviewer.standalone.domain.model.ApiUIDefinitionModel;

public interface ApiViewerQueryService {

	public List<ApiUIDefinitionModel> getApis();

}
