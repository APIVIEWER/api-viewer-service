package org.apiviewer.core.transform;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apiviewer.standalone.domain.model.ApiDefinitionModel;
import org.apiviewer.standalone.domain.model.SwaggerSpecObjectMapper;
import org.apiviewer.standalone.domain.model.SwaggerSpecObjectMapper.APIS;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author hitesh.bargujar
 */
@Component
public class ApiDiscoveryDefinitionConverter {

	public ApiDefinitionModel getParametersFromJson(String location) throws IOException {

		ApiDefinitionModel model = null;
		URL url = null;

		try {

			url = new URL(location);
			JsonFactory jfactory = new JsonFactory();
			JsonParser jParser = jfactory.createParser(url);
			ObjectMapper mapper = new ObjectMapper();
			SwaggerSpecObjectMapper swaggerSpecObjectMapper = mapper.readValue(jParser, SwaggerSpecObjectMapper.class);
			model = new ApiDefinitionModel();
			model.setSwaggerDefinitionServiceName(swaggerSpecObjectMapper.getInfo().getTitle());
			model.setSwaggerDefinitionResources(deriveResourceNames(swaggerSpecObjectMapper.getApis()));

		} catch (IOException e) {
			throw e;
		}

		return model;
	}

	private List<String> deriveResourceNames(List<APIS> list) {

		List<String> pathNames = new ArrayList<String>();

		for (APIS api : list) {

			String path = api.getPath();

			if (!path.contains("basic-error-controller")) {
				pathNames.add(path);
			}
		}

		return pathNames;

	}

}
