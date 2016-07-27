package org.apiviewer.standalone.domain.model;

import java.io.Serializable;

/**
 * @author hitesh.bargujar
 *
 */
public class ApiUIDefinitionModel implements Serializable {

	private static final long serialVersionUID = 7516651763618310569L;

	private String id;

	private String deployedServiceUrl;

	private String deployedServiceSpecUrl;

	private ApiDefinitionModel apiDefinition;

	private String gitRepoName;

	public String getDeployedServiceUrl() {
		return deployedServiceUrl;
	}

	public void setDeployedServiceUrl(String deployedServiceUrl) {
		this.deployedServiceUrl = deployedServiceUrl;
	}

	public String getDeployedServiceSpecUrl() {
		return deployedServiceSpecUrl;
	}

	public void setDeployedServiceSpecUrl(String deployedServiceSpecUrl) {
		this.deployedServiceSpecUrl = deployedServiceSpecUrl;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ApiDefinitionModel getApiDefinition() {
		return apiDefinition;
	}

	public void setApiDefinition(ApiDefinitionModel apiDefinition) {
		this.apiDefinition = apiDefinition;
	}

	public String getGitRepoName() {
		return gitRepoName;
	}

	public void setGitRepoName(String gitRepoName) {
		this.gitRepoName = gitRepoName;
	}

}
