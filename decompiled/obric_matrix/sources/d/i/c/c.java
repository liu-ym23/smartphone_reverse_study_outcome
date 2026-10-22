package d.i.c;

import android.content.Context;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static BatteryManager f17037a;

    static {
        new IntentFilter("android.intent.action.BATTERY_CHANGED");
    }

    public c() {
    }

    private static BatteryManager a(Context r3) {
        if (f17037a != null) goto L20;
        monitor-enter(c.class);
    L16:
        th = move-exception;
        throw th;
    L7:
        if (f17037a == null) goto L9;
    L14:
        monitor-exit(c.class);     // Catch: Throwable -> L16
        goto L20
    L9:
        if (Build.VERSION.SDK_INT < 21) goto L11;
        f17037a = (BatteryManager) r3.getSystemService("batterymanager");     // Catch: Throwable -> L16
        goto L14
    L11:
        monitor-exit(c.class);     // Catch: Throwable -> L16
        return null;
    L20:
        return f17037a;
    }

    public static float b(Context r4) {
        if (Build.VERSION.SDK_INT < 21) goto L32;
        if (r4 == null) goto L32;
        BatteryManager r5 = a(r4);
        if (r5 != null) goto L9;
        return -1.0f;
    L9:
        float r6 = r5.getLongProperty(2);
        if (r6 < (-1.0E7f)) goto L32;
        if (r6 > 1.0E7f) goto L32;
        if (d.c() == true) goto L28;
        if (d.b() == true) goto L28;
        if (d.a() == false) goto L26;
        if (r6 > 10000.0f) goto L24;
        return r6;
    L24:
        return r6 / 1000.0f;
    L26:
        return r6 / 1000.0f;
    L28:
        if (r6 >= (-10000.0f)) goto L31;
        r6 = r6 / 1000.0f;
    L31:
        return -r6;
    L32:
        return -1.0f;
    }
}
