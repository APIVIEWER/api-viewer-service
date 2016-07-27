package org.apiviewer.app.resources;

import java.util.List;

import org.apiviewer.standalone.domain.model.ApiUIDefinitionModel;
import org.apiviewer.standalone.service.ApiViewerQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/apis")
public class ApiViewerResource {

	@Autowired
	private ApiViewerQueryService apiViewerQueryService;

	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<ApiUIDefinitionModel> getApis() {

		return apiViewerQueryService.getApis();

	}

}
