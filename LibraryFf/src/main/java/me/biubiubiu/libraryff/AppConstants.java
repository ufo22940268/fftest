package me.biubiubiu.libraryff;

import android.content.Context;

import java.net.URLEncoder;

/**
 * Created by ccheng on 7/15/14.
 */
public class AppConstants {
    public static final String KEY_CONFIG = "KEY_CONFIG";

    public static final String DEMO_INDEX_URL = "http://wap.cmread.com/r/p/catalogdata.jsp?vt=9&bid=374428803&page=3&orderType=asc&pageSize=10";
    public static final String DEMO_CHAPTER_URL = "http://wap.cmread.com/r/374428803/374428825/index.htm?vt=9&cm=M2040009";
//    public static final String DEMO_CHAPTER_URL = "http://wap.cmread.com/r/384560291/384560451/index.htm?vt=9&cm=M2040039";
    public static final String ENCODED_DEMO_CHAPTER_URL = URLEncoder.encode(DEMO_CHAPTER_URL);
}
