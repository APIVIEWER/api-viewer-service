package org.apiviewer.git.service.impl;

import org.apiviewer.git.config.CacheConfig;
import org.apiviewer.git.dao.GithubClient;
import org.apiviewer.git.domain.model.GitRepoModel;
import org.apiviewer.git.service.GitInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class GitInfoServiceImpl implements GitInfoService {

	@Autowired
	private GithubClient gitClient;

	@Override
	@Cacheable(cacheNames = CacheConfig.REPOSITORY_CACHE, key = "gitRepoName")
	public GitRepoModel getGitRepoInfoByRepoName(String gitRepoName) {
		return gitClient.getGitInfo(gitRepoName);
	}

}
