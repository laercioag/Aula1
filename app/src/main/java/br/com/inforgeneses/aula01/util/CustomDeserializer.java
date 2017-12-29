package br.com.inforgeneses.aula01.util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

public class CustomDeserializer implements JsonDeserializer<Collection<?>> {

    @Override
    public Collection<?> deserialize(JsonElement json, Type typeOfT,
                                     JsonDeserializationContext context) throws JsonParseException {
        Type realType = ((ParameterizedType)typeOfT).getActualTypeArguments()[0];

        return parseAsArrayList(json, realType);
    }


    @SuppressWarnings("unchecked")
    private <T> ArrayList<T> parseAsArrayList(JsonElement json, T type) {
        ArrayList<T> newArray = new ArrayList<>();
        Gson gson = new Gson();

        JsonArray array= json.getAsJsonArray();

        for (JsonElement json2 : array) {
            T object = (T) gson.fromJson(json2, (Class<?>) type);
            newArray.add(object);
        }

        return newArray;
    }
}
