package me.biubiubiu.libraryff;

import android.content.Context;

/**
* Created by ccheng on 7/15/14.
*/
public abstract class RecordConfigHandler extends MyJsonResponseHandler<ConfigResult> {

    private ComplexPreferences mComplexPreferences;

    public RecordConfigHandler(Context context) {
        super(ConfigResult.class);
        mComplexPreferences = ComplexPreferences.getComplexPreferences(context);
    }

    @Override
    protected void onSuccess(ConfigResult response) {
        mComplexPreferences.putObject(AppConstants.KEY_CONFIG, response);
        mComplexPreferences.commit();
        postGetChapter();
    }

    protected abstract void postGetChapter();
}
