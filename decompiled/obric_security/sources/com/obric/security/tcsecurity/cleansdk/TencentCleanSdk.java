package com.obric.security.tcsecurity.cleansdk;

import android.content.Context;
import com.obric.olog.OLog;
import java.util.Locale;
import tmsdk.common.TMSDKContext;

/* JADX INFO: loaded from: classes4.dex */
public class TencentCleanSdk {
    private static Boolean isInit;

    public TencentCleanSdk() {
    }

    static {
        isInit = false;
    }

    public static void init(Context context) {
        if (isInit.booleanValue() == false) goto L5;
        return;
    L5:
        OLog.d("TencentCleanSdk", "init");
        isInit = Boolean.valueOf(TMSDKContext.init(context, null, new AnonymousClass1()));
        syncLanguageInfo(context);
        TMSDKContext.setTMSDKLogEnable(true);
        TMSDKContext.setAutoConnectionSwitch(true);
        OLog.d("TencentCleanSdk_TMSDK", " isInit = " + isInit);
    }

    public static void syncLanguageInfo(Context context) {
        Locale r4 = Locale.getDefault();
        String r0 = r4.getLanguage();
        String r1 = r4.getCountry();
        String r5 = r4.getScript();
        TMSDKContext.setLanguageInfo(r0, r1, r5);
        OLog.d("TencentCleanSdk", "syncLanguageInfo: language=" + r0 + ", region=" + r1 + ", script=" + r5);
    }

    public static Boolean getIsInit() {
        return isInit;
    }

    public static int checkLicenceSafeState() {
        return TMSDKContext.checkLicenceSafeState();
    }
}
