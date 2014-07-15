package biubiubiu.me.fftest;

import android.app.Activity;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;

/**
 * Created by ccheng on 7/15/14.
 */
public class NetUtil {
    public static final int TYPE_CMCC = 0;
    public static final int TYPE_LT = 1;
    public static final int TYPE_DX = 2;

    static void clearCookie(Activity myActivity) {
        CookieSyncManager.createInstance(myActivity);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.removeAllCookie();
    }

    public static int getProvidersName(Context context) {
        int ProvidersName = TYPE_CMCC;
        // 返回唯一的用户ID;就是这张卡的编号神马的
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String IMSI = telephonyManager.getSubscriberId();
        // IMSI号前面3位460是国家，紧接着后面2位00 02是中国移动，01是中国联通，03是中国电信。
        System.out.println(IMSI);
        if (IMSI.startsWith("46000") || IMSI.startsWith("46002")) {
            ProvidersName = TYPE_CMCC;
        } else if (IMSI.startsWith("46001")) {
            ProvidersName = TYPE_LT;
        } else if (IMSI.startsWith("46003")) {
            ProvidersName = TYPE_DX;
        }
        return ProvidersName;
    }
}
