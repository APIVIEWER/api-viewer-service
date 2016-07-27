package org.apiviewer.standalone.domain.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author hitesh.bargujar
 */
public class StandAloneAPIModel implements Serializable {

	private static final long serialVersionUID = -8115319843197737712L;

	@NotBlank(message = "{error.validation.message.name}")
	private String nickName;

	@NotBlank(message = "{error.validation.message.apiDocLocation}")
	private String apiDocLocation;

	private String gitRepoName;

	public StandAloneAPIModel() {

	}

	public StandAloneAPIModel(String nickName, String apiDocLocation, String gitRepoName) {
		this.nickName = nickName;
		this.apiDocLocation = apiDocLocation;
		this.gitRepoName = gitRepoName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getApiDocLocation() {
		return apiDocLocation;
	}

	public void setApiDocLocation(String apiDocLocation) {
		this.apiDocLocation = apiDocLocation;
	}

	/**
	 * builder class for StandAloneAPIModel
	 * 
	 * @author hitesh.bargujar
	 */
	public static class StandAloneAPIModelBuilder {

		private String nestedName;

		private String nestedApiDocLocation;

		private String gitRepoName;

		public StandAloneAPIModelBuilder setApiName(String name) {
			this.nestedName = name;
			return this;
		}

		public StandAloneAPIModelBuilder setApiDocLocation(String apiDocLocation) {
			this.nestedApiDocLocation = apiDocLocation;
			return this;
		}

		public StandAloneAPIModelBuilder setGitRepoName(String gitRepoName) {
			this.gitRepoName = gitRepoName;
			return this;
		}

		public StandAloneAPIModel createAPIStandAloneModel() {
			return new StandAloneAPIModel(nestedName, nestedApiDocLocation, gitRepoName);
		}
	}

	public String getGitRepoName() {
		return gitRepoName;
	}

	public void setGitRepoName(String gitRepoName) {
		this.gitRepoName = gitRepoName;
	}
}
