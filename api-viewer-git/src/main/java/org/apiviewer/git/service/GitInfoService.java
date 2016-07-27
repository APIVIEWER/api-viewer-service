package org.apiviewer.git.service;

import org.apiviewer.git.domain.model.GitRepoModel;

public interface GitInfoService {

	GitRepoModel getGitRepoInfoByRepoName(String gitRepoName);

}
