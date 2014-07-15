package biubiubiu.me.fftest;

import android.app.Activity;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;

/**
 * Created by ccheng on 7/15/14.
 */
public class NetUtil {
    static void clearCookie(Activity myActivity) {
        CookieSyncManager.createInstance(myActivity);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.removeAllCookie();
    }
}
