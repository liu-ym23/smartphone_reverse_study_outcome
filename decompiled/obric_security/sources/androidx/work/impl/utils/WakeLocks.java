package androidx.work.impl.utils;

import android.content.Context;
import android.os.PowerManager;
import androidx.work.Logger;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.ss.android.message.log.PushLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WakeLocks.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u001c\u0010\u0004\u001a\u00060\u0005R\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"TAG", "", "checkWakeLocks", "", "newWakeLock", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "context", "Landroid/content/Context;", PushLog.KEY_TAG, "work-runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class WakeLocks {
    private static final String TAG = null;

    static {
        String r0 = Logger.tagWithPrefix("WakeLocks");
        Intrinsics.checkNotNullExpressionValue(r0, "tagWithPrefix(\"WakeLocks\")");
        TAG = r0;
    }

    public static final PowerManager.WakeLock newWakeLock(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, PushLog.KEY_TAG);
        Object r4 = r2.getApplicationContext().getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.os.PowerManager");
        String r5 = "WorkManager: " + r3;
        PowerManager.WakeLock r6 = ((PowerManager) r4).newWakeLock(1, r5);
        WakeLocksHolder r0 = WakeLocksHolder.INSTANCE;
        monitor-enter(r0);
        String r7 = WakeLocksHolder.INSTANCE.getWakeLocks().put(r6, r5);     // Catch: Throwable -> L8
        monitor-exit(r0);
        Intrinsics.checkNotNullExpressionValue(r6, "wakeLock");
        return r6;
    L8:
        th = move-exception;
        throw th;
    }

    public static final void checkWakeLocks() {
        LinkedHashMap r0 = new LinkedHashMap();
        WakeLocksHolder r1 = WakeLocksHolder.INSTANCE;
        monitor-enter(r1);
        r0.putAll(WakeLocksHolder.INSTANCE.getWakeLocks());     // Catch: Throwable -> L17
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(r1);
        Iterator r3 = r0.entrySet().iterator();
    L8:
        if (r3.hasNext() == false) goto L16;
        Map.Entry r4 = (Map.Entry) r3.next();
        PowerManager.WakeLock r5 = (PowerManager.WakeLock) r4.getKey();
        String r6 = (String) r4.getValue();
        boolean r7 = false;
        if (r5 != null) goto L12;
    L14:
        if (r7 == false) goto L8;
        Logger.get().warning(TAG, "WakeLock held for " + r6);
        goto L8
    L12:
        if (r5.isHeld() != true) goto L14;
        r7 = true;
        goto L14
    L16:
        return;
    L17:
        th = move-exception;
        throw th;
    }
}
