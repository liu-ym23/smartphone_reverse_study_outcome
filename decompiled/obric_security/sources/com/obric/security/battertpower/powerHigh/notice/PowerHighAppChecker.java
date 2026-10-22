package com.obric.security.battertpower.powerHigh.notice;

import android.content.Context;
import com.obric.olog.OLog;
import java.util.HashSet;

/* JADX INFO: loaded from: classes4.dex */
public class PowerHighAppChecker {
    public PowerHighAppChecker() {
    }

    public static boolean isSkip(Context context, String packageName, HashSet<String> allowBgPowerAppsSet) {
        if (isSystemApp(context, packageName) == false) goto L7;
        OLog.d("PowerHighAppsManager", "powerHighAppChecker- " + packageName + "是系统应用，不会通知");
        return true;
    L7:
        if (allowBgPowerAppsSet.contains(packageName) == false) goto L10;
        OLog.d("PowerHighAppsManager", "powerHighAppChecker- " + packageName + "是白名单应用，不会通知");
        return true;
    L10:
        return false;
    }

    public static boolean isSystemApp(Context context, String packageName) {
        if ((context.getPackageManager().getApplicationInfo(packageName, 0).flags & 129) == 0) goto L11;
        return true;
    L11:
        return false;
    L12:
        return false;
    }
}
