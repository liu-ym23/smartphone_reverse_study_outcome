package com.bytedance.feedbackerlib.m;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.os.IBinder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class o {
    @Nullable
    public static Object a(@NonNull Context r2) {
        Context r3 = c(r2);
        if (r3 != null) goto L8;
        return null;
    L8:
        return d.c(r3, "mMainThread");
    L7:
        return null;
    }

    @Nullable
    public static Object b() {
        return k.f(Class.forName("android.app.ActivityThread"), "currentActivityThread", new Object[0]);
    L4:
        return null;
    }

    @Nullable
    public static Context c(@NonNull Context r1) {
        Context r2 = r1.getApplicationContext();
    L4:
        if ((r2 instanceof ContextWrapper) == false) goto L12;
        r2 = ((ContextWrapper) r2).getBaseContext();
        if (r2 != null) goto L4;
        return null;
    L12:
        return r2;
    }

    @Nullable
    public static String d() {
        Object r0 = b();
        if (r0 != null) goto L11;
        return null;
    L11:
        ApplicationInfo r1 = (ApplicationInfo) d.c(d.c(r0, "mBoundApplication"), "appInfo");     // Catch: Throwable -> L10
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.packageName;
    L10:
        return null;
    }

    @Nullable
    public static Map<IBinder, ?> e(@NonNull Context r1) {
        return (Map) d.c(a(r1), "mActivities");
    L5:
        return null;
    }
}
