package biubiubiu.me.fftest;

import android.content.Context;

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
        return null;
    }
}
