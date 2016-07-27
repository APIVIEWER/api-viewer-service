package org.apiviewer.standalone.rest;

import org.apiviewer.standalone.domain.model.StandAloneAPICollection;
import org.apiviewer.standalone.domain.model.StandAloneAPIModel;
import org.apiviewer.standalone.service.StandAloneAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/standalone-api"})
public class StandAloneAPIResource {

    @Autowired
    private StandAloneAPIService service;

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void addStandAloneApi(@RequestBody StandAloneAPIModel body) {
        service.addStandAloneAPI(body);
    }

    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public StandAloneAPICollection getStandAloneAPIs() {
        return service.getStandAloneAPIs();
    }
}
