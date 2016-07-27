package org.apiviewer.standalone.service.impl;

import org.apiviewer.standalone.dao.StandAloneAPIDao;
import org.apiviewer.standalone.dao.StandAloneAPIEntity;
import org.apiviewer.standalone.dao.StandAloneAPIEntityCollection;
import org.apiviewer.standalone.domain.model.StandAloneAPICollection;
import org.apiviewer.standalone.domain.model.StandAloneAPIModel;
import org.apiviewer.standalone.service.StandAloneAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class StandAloneAPIServiceImpl implements StandAloneAPIService {

    @Autowired
    private StandAloneAPIDao daoService;

    @Autowired
    private Converter<StandAloneAPIModel, StandAloneAPIEntity> entityConversionService;

    @Autowired
    private Converter<StandAloneAPIEntityCollection, StandAloneAPICollection> collectionConversionService;

    @Override
    public void addStandAloneAPI(StandAloneAPIModel model) {
        daoService.addStandAloneAPI(entityConversionService.convert(model));
    }

    @Override
    public StandAloneAPICollection getStandAloneAPIs() {
        return collectionConversionService.convert(daoService.getStandAloneAPIs());
    }
}
