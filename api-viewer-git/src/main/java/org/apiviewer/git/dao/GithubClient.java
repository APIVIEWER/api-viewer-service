package org.apiviewer.git.dao;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.apiviewer.git.domain.model.GitRepoModel;
import org.kohsuke.github.GHIssueState;
import org.kohsuke.github.GHOrganization;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
 * @author hitesh.bargujar
 *
 */
@Component
public class GithubClient {

	private static final Logger LOGGER = LoggerFactory.getLogger(GithubClient.class);

	private GitHub gitHubClient;

	@Value("${git.auth.username}")
	private String userName;

	@Value("${git.auth.password}")
	private String password;

	@Value("${git.organization}")
	private String organizationName;

	private Set<GHRepository> repositories = new HashSet<GHRepository>();

	private Map<String, GHRepository> gitRepos = new HashMap<String, GHRepository>();

	@PostConstruct
	public void constructGitHubInfo() {
		try {
			gitHubClient = GitHub.connectUsingPassword(userName, password);
			Map<String, GHOrganization> organizations = gitHubClient.getMyOrganizations();

			if (null != organizations) {
				for (GHOrganization organization : organizations.values()) {

					if (organizationName.equals(organization.getLogin())) {

						repositories.addAll(organization.getRepositories().values());

						if (null != repositories) {

							for (GHRepository repository : repositories) {

								gitRepos.put(repository.getName(), repository);
							}
						}
					}
				}
			}
		} catch (IOException e) {
			LOGGER.info("Not able to create Github Client" + e.getMessage());
		}
	}

	public GitRepoModel getGitInfo(String gitRepoName) {

		GHRepository repository = gitRepos.get(gitRepoName);

		try {
			GitRepoModel gitInfo = new GitRepoModel();
			gitInfo.setName(repository.getName());
			if (null != repository.getBranches()) {

				gitInfo.setBranches(String.valueOf(repository.getBranches().values().size()));

			}

			if (null != repository.getPullRequests(GHIssueState.ALL)) {
				gitInfo.setPrs(String.valueOf(repository.getPullRequests(GHIssueState.ALL).size()));
			}

			return gitInfo;
		} catch (Exception e) {
			LOGGER.info("Not able to retrive Repo Info" + e.getMessage());
		}
		return null;
	}
}
