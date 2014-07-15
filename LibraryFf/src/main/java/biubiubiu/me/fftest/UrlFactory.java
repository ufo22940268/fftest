package biubiubiu.me.fftest;

import android.content.Context;

import java.net.URLEncoder;

import me.biubiubiu.libraryff.AppConstants;
import me.biubiubiu.libraryff.ConfigResult;

/**
 * Created by ccheng on 7/15/14.
 */
public class UrlFactory {
    private final Context mContext;

    public UrlFactory(Context context) {
        mContext = context;
    }

    public String buildCheckLoginUrl() {
        ConfigResult configResult = ConfigResult.readConfig(mContext);
        String url = String.format("http://wap.cmread.com/sso/smsautoLogin?rm=%s&redirect_uri=%s",
                configResult.selectRm(mContext), AppConstants.ENCODED_DEMO_CHAPTER_URL);
        return url;
    }
}
