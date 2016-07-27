package org.apiviewer.core.transform;

import java.util.ArrayList;
import java.util.List;

import org.apiviewer.standalone.dao.StandAloneAPIEntity;
import org.apiviewer.standalone.dao.StandAloneAPIEntityCollection;
import org.apiviewer.standalone.domain.model.StandAloneAPICollection;
import org.apiviewer.standalone.domain.model.StandAloneAPIModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author hitesh.bargujar
 *
 */
@Component
public class StandAloneAPICollectionConverter
		implements Converter<StandAloneAPIEntityCollection, StandAloneAPICollection> {

	@Override
	public StandAloneAPICollection convert(StandAloneAPIEntityCollection source) {

		List<StandAloneAPIEntity> entities = source.getEntities();
		StandAloneAPICollection collection = new StandAloneAPICollection();

		collection.setStandAloneAPIs(new ArrayList<StandAloneAPIModel>());

		for (StandAloneAPIEntity entity : entities) {
			StandAloneAPIModel model = new StandAloneAPIModel();
			model.setApiDocLocation(entity.getApiDocLocation());
			model.setNickName(entity.getNickName());
			model.setGitRepoName(entity.getGitRepoName());
			collection.getStandAloneAPIs().add(model);
		}

		return collection;
	}

}
