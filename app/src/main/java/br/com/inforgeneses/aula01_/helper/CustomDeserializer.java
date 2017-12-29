package br.com.inforgeneses.aula01_.helper;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class CustomDeserializer<T> implements JsonDeserializer<T> {

    @Override
    public T deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Log.d(CustomDeserializer.class.getSimpleName(), json.toString());
        JsonElement itens = json.getAsJsonObject().get("itens");


        return new Gson().fromJson(itens, typeOfT);
    }
}
