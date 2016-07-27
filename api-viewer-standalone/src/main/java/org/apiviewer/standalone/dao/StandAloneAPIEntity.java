package org.apiviewer.standalone.dao;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author hitesh.bargujar
 *
 */
@Document(collection = "standaloneapis")
public class StandAloneAPIEntity {

	private String id;

	private String nickName;

	private String apiDocLocation;

	private String gitRepoName;

	private String addedOn = new Date().toString();

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

	public String getAddedOn() {
		return addedOn;
	}

	public void setAddedOn(String addedOn) {
		this.addedOn = addedOn;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGitRepoName() {
		return gitRepoName;
	}

	public void setGitRepoName(String gitRepoName) {
		this.gitRepoName = gitRepoName;
	}

}
