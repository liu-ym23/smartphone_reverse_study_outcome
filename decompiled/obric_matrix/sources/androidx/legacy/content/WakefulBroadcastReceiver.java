package androidx.legacy.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.Log;
import android.util.SparseArray;

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
        SparseArray<PowerManager.WakeLock> r0 = sActiveWakeLocks;
        monitor-enter(r0);
        PowerManager.WakeLock r1 = r0.get(r6);     // Catch: Throwable -> L15
        if (r1 == null) goto L12;
        r1.release();     // Catch: Throwable -> L15
        r0.remove(r6);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return true;
    L12:
        Log.w("WakefulBroadcastReceiv.", "No active wake lock id #" + r6);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return true;
    L15:
        th = move-exception;
        throw th;
    }

    public static ComponentName startWakefulService(Context r5, Intent r6) {
        SparseArray<PowerManager.WakeLock> r0 = sActiveWakeLocks;
        monitor-enter(r0);
        int r1 = mNextId;     // Catch: Throwable -> L15
        int r2 = r1 + 1;     // Catch: Throwable -> L15
        mNextId = r2;     // Catch: Throwable -> L15
        if (r2 > 0) goto L7;
        mNextId = 1;     // Catch: Throwable -> L15
    L7:
        r6.putExtra(EXTRA_WAKE_LOCK_ID, r1);     // Catch: Throwable -> L15
        ComponentName r7 = r5.startService(r6);     // Catch: Throwable -> L15
        if (r7 == null) goto L10;
        PowerManager.WakeLock r8 = ((PowerManager) r5.getSystemService("power")).newWakeLock(1, "androidx.core:wake:" + r7.flattenToShortString());     // Catch: Throwable -> L15
        r8.setReferenceCounted(false);     // Catch: Throwable -> L15
        r8.acquire(60000);     // Catch: Throwable -> L15
        r0.put(r1, r8);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return r7;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return null;
    L15:
        th = move-exception;
        throw th;
    }
}
