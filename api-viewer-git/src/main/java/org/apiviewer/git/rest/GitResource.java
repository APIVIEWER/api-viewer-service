package org.apiviewer.git.rest;

import org.apiviewer.commons.exception.Error404;
import org.apiviewer.git.domain.model.GitRepoModel;
import org.apiviewer.git.service.GitInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/git")
public class GitResource {

	@Autowired
	private GitInfoService gitService;

	@RequestMapping(value = "/{gitRepoName}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public GitRepoModel getGitInfo(@PathVariable(value = "gitRepoName") String gitRepoName) {

		GitRepoModel gitInfo = gitService.getGitRepoInfoByRepoName(gitRepoName);

		if (null == gitInfo) {
			throw new Error404("No GH Repository Found with name: " + gitRepoName);
		}

		return gitInfo;
	}
}
