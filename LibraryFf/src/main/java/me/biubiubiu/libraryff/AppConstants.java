package me.biubiubiu.libraryff;

import android.content.Context;

import java.net.URLEncoder;

/**
 * Created by ccheng on 7/15/14.
 */
public class AppConstants {
    public static final String KEY_CONFIG = "KEY_CONFIG";

//    public static final String DEMO_CHAPTER_URL = "http://wap.cmread.com/r/384560291/384560451/index.htm?vt=9&cm=M2040002";
    public static final String DEMO_CHAPTER_URL = "http://wap.cmread.com/r/384560291/384560451/index.htm?vt=9&cm=M2040039";
    public static final String ENCODED_DEMO_CHAPTER_URL = URLEncoder.encode(DEMO_CHAPTER_URL);
}
