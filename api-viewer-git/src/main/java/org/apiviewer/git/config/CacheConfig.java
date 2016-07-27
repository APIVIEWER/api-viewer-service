package org.apiviewer.git.config;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.guava.GuavaCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.cache.CacheBuilder;

@Configuration
public class CacheConfig {

	public static final String REPOSITORY_CACHE = "gitRepo";

	@Value("${cache.ghRepository.ttl: 60}")
	private String ghRepositoryTimeToLive;

	@Value("${cache.ghRepository.maxsize: 2000}")
	private String ghRepositoryMaxSize;

	@Bean
	public CacheManager cacheManager() {
		SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
		simpleCacheManager.setCaches(Arrays.asList(buildGhRepoCache()));
		return simpleCacheManager;
	}

	private GuavaCache buildGhRepoCache() {
		return new GuavaCache(REPOSITORY_CACHE,
				CacheBuilder.newBuilder().expireAfterAccess(Long.parseLong(ghRepositoryTimeToLive), TimeUnit.MINUTES)
						.maximumSize(Long.parseLong(ghRepositoryMaxSize)).build());
	}

}
