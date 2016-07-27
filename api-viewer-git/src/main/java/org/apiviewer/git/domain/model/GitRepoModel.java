package org.apiviewer.git.domain.model;

import java.io.Serializable;

public class GitRepoModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private String branches;

	private String contributors;

	private String prs;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranches() {
		return branches;
	}

	public void setBranches(String branches) {
		this.branches = branches;
	}

	public String getContributors() {
		return contributors;
	}

	public void setContributors(String contributors) {
		this.contributors = contributors;
	}

	public String getPrs() {
		return prs;
	}

	public void setPrs(String prs) {
		this.prs = prs;
	}

}
