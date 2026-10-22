package com.bytedance.feedbackerlib.m;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class n {
    @Nullable
    public static String a(@NonNull Context r4) {
        ActivityManager r5 = (ActivityManager) r4.getApplicationContext().getSystemService("activity");
        if (r5 != null) goto L5;
        return null;
    L5:
        List<ActivityManager.RunningAppProcessInfo> r6 = r5.getRunningAppProcesses();
        if (r6 != null) goto L8;
        return null;
    L8:
        Iterator<ActivityManager.RunningAppProcessInfo> r7 = r6.iterator();
    L10:
        if (r7.hasNext() == false) goto L15;
        ActivityManager.RunningAppProcessInfo r1 = r7.next();
        if (r1.pid != Process.myPid()) goto L10;
        return r1.processName;
    L15:
        return null;
    }

    @RequiresApi(api = 17)
    public static boolean b(@NonNull Context r0) {
        return b.c(r0);
    }
}
