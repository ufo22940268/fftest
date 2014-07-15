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
        // ����Ψһ���û�ID;�������ſ��ı�������
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String IMSI = telephonyManager.getSubscriberId();
        // IMSI��ǰ��3λ460�ǹ��ң������ź���2λ00 02���й��ƶ���01���й���ͨ��03���й����š�
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
