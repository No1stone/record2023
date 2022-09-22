package com.ui.seoul.seoulopenapi.biz.v1.model.type.method;

import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JsonToModel {

    private String s;

    private void setS(Object s) {
        this.s = String.valueOf(s);
    }

    private void setS(String s) {
        this.s = s;
    }

    public static JsonToModel builder(Object s) {
        JsonToModel j = new JsonToModel();
        j.setS(String.valueOf(s));
        return j;
    }

    public JsonToModel ofObject(String objName) {
        this.s = String.valueOf(new JSONObject(this.s).getJSONObject(objName));
        return this;
    }

    public <T> T ofModel(Class<T> T) {
        return new Gson().fromJson(this.s.toString(), T);
    }

    public <T> List<T> ofArrayModel(String objName, Class<T> T) {
        return new JSONObject(this.s).getJSONArray(objName).toList().stream()
                .map(e -> new Gson().fromJson(String.valueOf(e), T))
                .collect(Collectors.toList());
    }

}
