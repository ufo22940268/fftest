package biubiubiu.me.fftest;

import com.loopj.android.http.ResponseHandlerInterface;
import com.loopj.android.http.TextHttpResponseHandler;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;

import java.io.IOException;

import me.biubiubiu.libraryff.MyJsonResponseHandler;

/**
 * Created by ccheng on 7/15/14.
 */
public abstract class CheckLoginHandler extends TextHttpResponseHandler {


    @Override
    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
        System.out.println("responseString = " + responseString);
        onFailure();
    }

    protected abstract void onFailure();


    @Override
    public void onSuccess(int statusCode, Header[] headers, String responseString) {
        System.out.println("responseString = " + responseString);
        if (responseString.contains("µÇÂ¼ÑéÖ¤ÖÐ")) {
            onFailure();
        } else {
            onSuccess();
        }
    }

    protected abstract void onSuccess();
}
