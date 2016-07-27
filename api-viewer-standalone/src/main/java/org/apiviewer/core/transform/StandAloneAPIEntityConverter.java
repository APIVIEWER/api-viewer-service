package org.apiviewer.core.transform;

import org.apiviewer.standalone.dao.StandAloneAPIEntity;
import org.apiviewer.standalone.domain.model.StandAloneAPIModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author hitesh.bargujar
 *
 */
@Component
public class StandAloneAPIEntityConverter implements Converter<StandAloneAPIModel, StandAloneAPIEntity> {

	@Override
	public StandAloneAPIEntity convert(StandAloneAPIModel source) {

		StandAloneAPIEntity entity = new StandAloneAPIEntity();
		entity.setNickName(source.getNickName());
		entity.setApiDocLocation(source.getApiDocLocation());
		entity.setGitRepoName(source.getGitRepoName());

		return entity;
	}

}
