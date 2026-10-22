package android.accessibilityservice;

import android.os.RemoteException;
import android.util.Log;
import android.view.accessibility.AccessibilityInteractionClient;

/* JADX INFO: loaded from: classes.dex */
public class ObricAccessibilityServiceImpl implements IObricAccessibilityService {
    private static final String TAG = "ObricAccessibilityServiceImpl";
    private final AccessibilityService mBase;

    public ObricAccessibilityServiceImpl(AccessibilityService base) {
        this.mBase = base;
    }

    public void setMinumumIntervalObric(String targetPackageName, int eventType, int interval) {
        AccessibilityInteractionClient client = AccessibilityInteractionClient.getInstance(this.mBase);
        Object r1 = client.getInstanceLock();
        monitor-enter(r1);
        IAccessibilityServiceConnection connection = AccessibilityInteractionClient.getConnection(this.mBase.getConnectionId());     // Catch: Throwable -> L10 RemoteException -> L12
        if (connection != null) goto L8;
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L8:
        connection.setMinumumIntervalObric(targetPackageName, eventType, interval);     // Catch: Throwable -> L10 RemoteException -> L12
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L12:
        e = move-exception;
        Log.e(TAG, "Failed to set minimum interval: " + e);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }
}
