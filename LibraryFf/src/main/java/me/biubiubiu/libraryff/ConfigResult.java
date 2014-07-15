package me.biubiubiu.libraryff;

import android.content.Context;

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
}
