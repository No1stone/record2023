package com.ui.seoul.seoulopenapi.biz.v1.model.type.method;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import javax.xml.validation.Schema;
import java.util.function.Predicate;

public class URLBuilder {
    public static class Builder {
        private String schema;
        private String preURL;
        private String port;
        private String key;
        private String apiURL;
        private String param = "";

        public static Builder newInstance() {
            return new Builder();
        }

        private Builder() {
        }

        public Builder setSchema(String schema) {
            this.schema = schema;
            return this;
        }

        public Builder setPreURL(String preURL) {
            this.preURL = preURL;
            return this;
        }

        public Builder setPort(String port) {
            this.port = port;
            return this;
        }

        public Builder setKey(String key) {
            this.key = key;
            return this;
        }

        public Builder setApiURL(String apiURL) {
            this.apiURL = apiURL;
            return this;
        }

        public Builder setParam(String param) {
            this.param += param;
            return this;
        }

        public Builder setParam(int param) {
            this.param += String.valueOf(param);
            return this;
        }

        public String seoulBuild() {
            if (this.param == null) {
                this.param = "";
            }
            return new String(this.schema + "://" + this.preURL + ":" + this.port + "/" + this.key + this.apiURL + this.param);
        }

    }

}
