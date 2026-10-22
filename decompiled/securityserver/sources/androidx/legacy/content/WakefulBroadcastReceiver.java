package androidx.legacy.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.Log;
import android.util.SparseArray;
import com.bytedance.apm.battery.config.BatteryTypeInf;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class WakefulBroadcastReceiver extends BroadcastReceiver {
    private static final String EXTRA_WAKE_LOCK_ID = "androidx.contentpager.content.wakelockid";
    private static int mNextId;
    private static final SparseArray<PowerManager.WakeLock> sActiveWakeLocks = null;

    static {
        sActiveWakeLocks = new SparseArray();
        mNextId = 1;
    }

    public WakefulBroadcastReceiver() {
    }

    public static boolean completeWakefulIntent(Intent r5) {
        int r6 = r5.getIntExtra(EXTRA_WAKE_LOCK_ID, 0);
        if (r6 != 0) goto L5;
        return false;
    L5:
        SparseArray<PowerManager.WakeLock> r1 = sActiveWakeLocks;
        monitor-enter(r1);
        PowerManager.WakeLock r2 = r1.get(r6);     // Catch: Throwable -> L12
        if (r2 == null) goto L14;
        r2.release();     // Catch: Throwable -> L12
        r1.remove(r6);     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        return true;
    L14:
        Log.w("WakefulBroadcastReceiv.", "No active wake lock id #" + r6);     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        return true;
    L12:
        th = move-exception;
        throw th;
    }

    public static ComponentName startWakefulService(Context r5, Intent r6) {
        SparseArray<PowerManager.WakeLock> r1 = sActiveWakeLocks;
        monitor-enter(r1);
        int r2 = mNextId;     // Catch: Throwable -> L7
        int r3 = r2 + 1;     // Catch: Throwable -> L7
        mNextId = r3;     // Catch: Throwable -> L7
        if (r3 > 0) goto L9;
        mNextId = 1;     // Catch: Throwable -> L7
    L9:
        r6.putExtra(EXTRA_WAKE_LOCK_ID, r2);     // Catch: Throwable -> L7
        ComponentName r7 = r5.startService(r6);     // Catch: Throwable -> L7
        if (r7 != null) goto L14;
        monitor-exit(r1);     // Catch: Throwable -> L7
        return null;
    L14:
        PowerManager.WakeLock r8 = ((PowerManager) r5.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK)).newWakeLock(1, "androidx.core:wake:" + r7.flattenToShortString());     // Catch: Throwable -> L7
        r8.setReferenceCounted(false);     // Catch: Throwable -> L7
        r8.acquire(60000);     // Catch: Throwable -> L7
        r1.put(r2, r8);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return r7;
    L7:
        th = move-exception;
        throw th;
    }
}
