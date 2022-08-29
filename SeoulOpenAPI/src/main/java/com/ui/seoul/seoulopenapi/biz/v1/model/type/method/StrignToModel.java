package com.ui.seoul.seoulopenapi.biz.v1.model.type.method;

import com.google.gson.Gson;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class StrignToModel {
    public static class Builder {
        private String s;
        public static Builder newInstance() {
            return new Builder();
        }

        public Builder setString(String s) {
            this.s = s;
            return this;
        }

        public Builder ofJsonObject(String getName) {
            this.s = new JSONObject(this.s).getJSONObject(getName).toString();
            return this;
        }

        public Builder ofJsonArray(String getName) {
            this.s = new JSONObject(this.s).getJSONArray(getName).toString();
            return this;
        }

        public <T> T ofModel(Class<T> t) {
            return new Gson().fromJson(this.s, t);
        }

        public <T> List<T> ofListModel(Class<T> model) {
            List<T> convert = new Gson().fromJson(this.s, List.class);
            List<T> res = new ArrayList<>();
            System.out.println("ofListModel = "+convert);
            for (T e : convert) {
                System.out.println("ofModel for = "+e);
//                res.add(new Gson().fromJson(e.toString(), model));
                res.add(new ModelMapper().map(e, model));
            }
            return res;
        }
    }

}
