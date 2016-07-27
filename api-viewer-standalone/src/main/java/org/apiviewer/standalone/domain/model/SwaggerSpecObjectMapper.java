package org.apiviewer.standalone.domain.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author hitesh.bargujar
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SwaggerSpecObjectMapper {

    private String apiVersion;

    private List<APIS> apis;

    private INFO info;

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public List<APIS> getApis() {
        return apis;
    }

    public void setApis(List<APIS> apis) {
        this.apis = apis;
    }

    public INFO getInfo() {
        return info;
    }

    public void setInfo(INFO info) {
        this.info = info;
    }

    /**
     * @author hitesh.bargujar
     *
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class APIS {
        private String path;

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }
    }

    /**
     * @author hitesh.bargujar
     *
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class INFO {
        private String title;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
