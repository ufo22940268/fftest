package me.biubiubiu.libraryff;

import android.content.Context;

import biubiubiu.me.fftest.NetUtil;

/**
* Created by ccheng on 7/14/14.
*/
public class ConfigResult extends ChapterResult {

    public static ConfigResult readConfig(Context context) {
        ConfigResult object = ComplexPreferences.getComplexPreferences(context)
                .getObject(AppConstants.KEY_CONFIG, ConfigResult.class);
        if (object == null) {
            throw new IllegalStateException("config is null");
        }
        return object;
    }

    public String getSmsTo(Context context) {
        switch (NetUtil.getProvidersName(context)) {
            case NetUtil.TYPE_CMCC:
                return getSmsTo();
            case NetUtil.TYPE_LT:
                return getLtSmsto();
            case NetUtil.TYPE_DX:
                return getDxSmsto();
        }

        throw new IllegalStateException();
    }

    public String getSmsContent(Context context) {
        switch (NetUtil.getProvidersName(context)) {
            case NetUtil.TYPE_CMCC:
                return getCmccContent();
            case NetUtil.TYPE_LT:
                return getNoCmccContent();
            case NetUtil.TYPE_DX:
                return getNoCmccContent();
        }

        throw new IllegalStateException();
    }
}
