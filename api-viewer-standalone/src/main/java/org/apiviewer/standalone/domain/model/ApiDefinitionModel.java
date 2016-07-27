package org.apiviewer.standalone.domain.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author hitesh.bargujar
 *
 */
public class ApiDefinitionModel implements Serializable {

    private static final long serialVersionUID = -64911911700335372L;

    private String swaggerDefinitionServiceName;

    private List<String> swaggerDefinitionResources;

    public List<String> getSwaggerDefinitionResources() {
        return swaggerDefinitionResources;
    }

    public void setSwaggerDefinitionResources(List<String> swaggerDefinitionResources) {
        this.swaggerDefinitionResources = swaggerDefinitionResources;
    }

    public String getSwaggerDefinitionServiceName() {
        return swaggerDefinitionServiceName;
    }

    public void setSwaggerDefinitionServiceName(String swaggerDefinitionServiceName) {
        this.swaggerDefinitionServiceName = swaggerDefinitionServiceName;
    }
}
