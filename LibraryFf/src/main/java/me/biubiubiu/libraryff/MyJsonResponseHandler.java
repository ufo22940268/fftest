package me.biubiubiu.libraryff;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.loopj.android.http.BaseJsonHttpResponseHandler;

import org.apache.http.Header;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ccheng on 7/14/14.
 */
public abstract class MyJsonResponseHandler<T> extends BaseJsonHttpResponseHandler {

    private final Class toCls;
    private static final JsonParser parser = new JsonParser();
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    private static final Gson GSON = new GsonBuilder().registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
        @Override
        public Date deserialize(JsonElement json, java.lang.reflect.Type typeOfT, JsonDeserializationContext context)
                throws JsonParseException {
            String dateString = json.getAsString().replace("Z", "+0000");
            return DATE_FORMAT.parse(dateString, new ParsePosition(0));
        }
    }).create();

    protected MyJsonResponseHandler(Class cls) {
        toCls = cls;
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, String rawJsonResponse, Object response) {
        onSuccess((T) response);
    }

    protected abstract void onSuccess(T response);

    @Override
    public void onFailure(int statusCode, Header[] headers, Throwable throwable, String rawJsonData, Object errorResponse) {

    }

    @Override
    protected Object parseResponse(String rawJsonData, boolean isFailure) throws Throwable {
//        return new ObjectMapper().readValues(new JsonFactory().createParser(rawJsonData), toCls).next();
        return GSON.fromJson(rawJsonData, toCls);
    }
}
