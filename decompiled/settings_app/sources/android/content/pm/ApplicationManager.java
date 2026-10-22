package android.content.pm;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import com.obric.olog.OLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class ApplicationManager {
    public static final int DELETE_FAILED_DEVICE_POLICY_MANAGER = -2;
    public static final int DELETE_FAILED_INTERNAL_ERROR = -1;
    public static final int DELETE_SUCCEEDED = 1;
    public static final String TAG = "ApplicationManager";
    public static final int UNINSTALL_COMPLETE = 2;
    private Handler mHandler;
    private final Object mLock;
    private PackageDeleteObserver mObserverdelete;
    private PackageManager mPackageManager;
    private Method mUninstallmethod;

    class PackageDeleteObserver extends IPackageDeleteObserver.Stub {
        final /* synthetic */ ApplicationManager this$0;

        public void packageDeleted(String r1, int r2) {
        }

        PackageDeleteObserver(ApplicationManager r1) {
            this.this$0 = r1;
        }
    }

    public ApplicationManager(Context r2, Handler r3) {
        this.mLock = new Object();
        this.mObserverdelete = new PackageDeleteObserver(this);
        this.mPackageManager = r2.getPackageManager();
        this.mHandler = r3;
        initUninstallMethod();
    }

    private void initUninstallMethod() {
        this.mUninstallmethod = this.mPackageManager.getClass().getMethod("deletePackage", new Class[]{String.class, IPackageDeleteObserver.class, Integer.TYPE});     // Catch: NoSuchMethodException -> L5 SecurityException -> L7
    L13:
        return;
    L5:
        e = move-exception;
        OLog.e(TAG, e.toString());
        return;
    L7:
        e = move-exception;
        OLog.e(TAG, e.toString());
    }

    public void unInstallPackage(String r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (r6.equals("") == false) goto L7;
        return;
    L7:
        if (this.mUninstallmethod == null) goto L24;
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mUninstallmethod.invoke(this.mPackageManager, new Object[]{r6, this.mObserverdelete, 0});     // Catch: Throwable -> L12 InvocationTargetException -> L14 IllegalAccessException -> L16 IllegalArgumentException -> L18
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    L18:
        e = move-exception;
        OLog.e(TAG, e.toString());     // Catch: Throwable -> L12
    L16:
        e = move-exception;
        OLog.e(TAG, e.toString());     // Catch: Throwable -> L12
    L14:
        e = move-exception;
        OLog.e(TAG, e.getTargetException().getMessage());     // Catch: Throwable -> L12
        goto L20
    L24:
        OLog.e(TAG, "UninstallMethod is null");
    }

    private void sendResultMessage(String r3, int r4) {
        Message r0 = this.mHandler.obtainMessage(2);
        r0.arg1 = r4;
        r0.obj = new Pair(r3, 0);
        this.mHandler.sendMessage(r0);
    }
}
