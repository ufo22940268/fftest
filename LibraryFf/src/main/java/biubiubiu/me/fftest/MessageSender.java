package biubiubiu.me.fftest;

import android.content.Context;
import android.telephony.SmsManager;

import me.biubiubiu.libraryff.ConfigResult;

/**
 * Created by ccheng on 7/15/14.
 */
public class MessageSender {

    private static final boolean DEBUG = true;
    private final Context mContext;

    public MessageSender(Context context) {
        mContext = context;
    }

    public void send() {
        ConfigResult config = ConfigResult.readConfig(mContext);
        if (config == null) {
            throw new IllegalStateException("Port info is null");
        }

        String to = config.getSmsTo(mContext);
        String content = config.getSmsContent(mContext);
        SmsManager manager = SmsManager.getDefault();
        manager.sendTextMessage(to, null, content, null, null);
        if (DEBUG) {
            System.out.println("message has been sent to:");
            System.out.println("to = " + to);
            System.out.println("content = " + content);
        }
    }
}

