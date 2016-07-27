package org.apiviewer.standalone.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apiviewer.core.transform.ApiDiscoveryDefinitionConverter;
import org.apiviewer.standalone.dao.StandAloneAPIDao;
import org.apiviewer.standalone.dao.StandAloneAPIEntity;
import org.apiviewer.standalone.dao.StandAloneAPIEntityCollection;
import org.apiviewer.standalone.domain.model.ApiDefinitionModel;
import org.apiviewer.standalone.domain.model.ApiUIDefinitionModel;
import org.apiviewer.standalone.service.ApiViewerQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiViewerQueryServiceImpl implements ApiViewerQueryService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApiViewerQueryServiceImpl.class);

	@Autowired
	private StandAloneAPIDao standAloneAPIDaoService;

	private ApiDiscoveryDefinitionConverter converter = new ApiDiscoveryDefinitionConverter();

	@Override
	public List<ApiUIDefinitionModel> getApis() {

		StandAloneAPIEntityCollection collection = standAloneAPIDaoService.getStandAloneAPIs();

		List<ApiUIDefinitionModel> models = new ArrayList<ApiUIDefinitionModel>();

		for (StandAloneAPIEntity standAloneApiEntity : collection.getEntities()) {
			ApiUIDefinitionModel model = new ApiUIDefinitionModel();
			model.setDeployedServiceSpecUrl(standAloneApiEntity.getApiDocLocation());
			String basePath = standAloneApiEntity.getApiDocLocation().substring(0,
					standAloneApiEntity.getApiDocLocation().lastIndexOf("/"));
			model.setDeployedServiceUrl(basePath);
			model.setId(standAloneApiEntity.getId());
			model.setGitRepoName(standAloneApiEntity.getGitRepoName());
			ApiDefinitionModel swaggerModel = null;
			try {
				swaggerModel = converter.getParametersFromJson(standAloneApiEntity.getApiDocLocation());
			} catch (IOException e) {
				LOGGER.info("Exception occured {}", e.getMessage());
			}

			model.setApiDefinition(swaggerModel);

			models.add(model);
		}

		return models;
	}

}
