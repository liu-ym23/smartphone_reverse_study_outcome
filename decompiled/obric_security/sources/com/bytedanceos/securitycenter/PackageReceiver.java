package com.bytedanceos.securitycenter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.UserHandle;
import bytedanceos.util.LogTag;
import com.bytedanceos.cleaner.CleanerDataHelper;
import com.bytedanceos.securitycenter.appBatteryUseOptimization.AppUseBatteryOptimizationHelper;
import com.bytedanceos.securitycenter.dynamicResolution.DynamicResolutionHelper;
import com.bytedanceos.securitycenter.networkControl.NetworkRejectHelper;
import com.bytedanceos.utils.Constants;
import com.obric.safecheck.task.PackageAddedTasks;
import com.obric.safecheck.task.PackageRemovedTasks;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class PackageReceiver extends BroadcastReceiver {
    private static final String ACTION_DOPPELGANGER_PACKAGE_ADDED = "com.settings.action_DOPPELGANGER_ADDED";
    private static final String ACTION_DOPPELGANGER_PACKAGE_REMOVED = "com.settings.action.DOPPELGANGER_REMOVED";
    private static final String EXTRA_PACKAGENAME = "extra_packagename";
    private static final String EXTRA_USERID = "extra_userid";
    private static final int INSTALLED = 1;
    private static final String TAG = "PackageReceiver";
    private static final int UNINSTALLED = 0;
    private static CleanerDataHelper sCleanerHelper;
    private static SQLiteDatabase sDb;
    private static final Object sDbExecLock = null;
    private static ExecutorService sDbExecutor;
    private static AtomicInteger sPendingTasks;

    private interface DbTask {
        void run(SQLiteDatabase db);
    }

    public PackageReceiver() {
    }

    static /* synthetic */ Object access$000() {
        return sDbExecLock;
    }

    static /* synthetic */ SQLiteDatabase access$100() {
        return sDb;
    }

    static /* synthetic */ SQLiteDatabase access$102(SQLiteDatabase r0) {
        sDb = r0;
        return r0;
    }

    static /* synthetic */ CleanerDataHelper access$200() {
        return sCleanerHelper;
    }

    static /* synthetic */ CleanerDataHelper access$202(CleanerDataHelper r0) {
        sCleanerHelper = r0;
        return r0;
    }

    static /* synthetic */ String access$300() {
        return TAG;
    }

    static /* synthetic */ AtomicInteger access$400() {
        return sPendingTasks;
    }

    static /* synthetic */ ExecutorService access$500() {
        return sDbExecutor;
    }

    static /* synthetic */ ExecutorService access$502(ExecutorService r0) {
        sDbExecutor = r0;
        return r0;
    }

    static {
        sDbExecLock = new Object();
        sPendingTasks = new AtomicInteger(0);
    }

    private static void enqueueDbTask(Context context, final DbTask task) {
        Context r2 = context.getApplicationContext();
        Object r0 = sDbExecLock;
        monitor-enter(r0);
        ExecutorService r1 = sDbExecutor;     // Catch: Throwable -> L23
        if (r1 != null) goto L7;
    L10:
        sDbExecutor = Executors.newSingleThreadExecutor();     // Catch: Throwable -> L23
    L12:
        if (sCleanerHelper != null) goto L14;
        sCleanerHelper = new CleanerDataHelper(r2);     // Catch: Throwable -> L23
    L14:
        SQLiteDatabase r3 = sDb;     // Catch: Throwable -> L23
        if (r3 != null) goto L17;
    L18:
        sDb = sCleanerHelper.getWritableDatabase();     // Catch: Throwable -> L23
    L19:
        sPendingTasks.incrementAndGet();     // Catch: Throwable -> L23
        monitor-exit(r0);     // Catch: Throwable -> L23
        sDbExecutor.execute(new AnonymousClass1(task));
        return;
    L17:
        if (r3.isOpen() == true) goto L19;
    L7:
        if (r1.isShutdown() == true) goto L10;
        if (sDbExecutor.isTerminated() == false) goto L12;
    L23:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String r0 = intent.getAction();
        Uri r1 = intent.getData();
        boolean r3 = false;
        boolean r2 = intent.getBooleanExtra("android.intent.extra.REPLACING", false);     // Catch: Exception -> L48
        if ("android.intent.action.PACKAGE_ADDED".equals(r0) == false) goto L14;
        if (r1 != null) goto L9;
        LogTag.w(TAG, "ACTION_PACKAGE_ADDED data is null");
        return;
    L9:
        String r4 = r1.getSchemeSpecificPart();
        int r5 = UserHandle.getUserId(intent.getIntExtra("android.intent.extra.UID", 0));
        NetworkRejectHelper.updatePackageInstall(context, r4, r5);
        if (r2 == true) goto L12;
        PackageAddedTasks.execute(context, r4, r5);
    L12:
        boolean r6 = 0;
        int r7 = 1;
    L37:
        if (r4 == null) goto L52;
        String r8 = TAG;
        LogTag.d(r8, " onReceive packageName = " + r4 + ", SDK_INT = " + Build.VERSION.SDK_INT);
        LogTag.d(r8, " onReceive install = " + r7 + ", isGameUpdate = " + r6);
        if (r7 != 0) goto L41;
        DynamicResolutionHelper.updatePackageInstall(context, r4, r7);
    L41:
        if (r6 == 0) goto L43;
        DynamicResolutionHelper.updateGameApp(context, r4);
    L43:
        AppUseBatteryOptimizationHelper.updatePackageInstall(context, r4, r7, r5);
        if (r7 != 1) goto L46;
        r3 = true;
    L46:
        notifyPackageInfo(context, intent, r3);
        LogTag.d(r8, " onReceive end");
        return;
    L52:
        return;
    L14:
        if ("android.intent.action.PACKAGE_REMOVED".equals(r0) == false) goto L22;
        if (r1 != null) goto L18;
        LogTag.w(TAG, "ACTION_PACKAGE_REMOVED data is null");
        return;
    L18:
        if (r2 == false) goto L20;
        return;
    L20:
        r4 = r1.getSchemeSpecificPart();
        int r9 = intent.getIntExtra("android.intent.extra.UID", 0);
        int r10 = UserHandle.getUserId(r9);
        NetworkRejectHelper.onPackageRemove(context, r4, r9);
        PackageRemovedTasks.execute(context, r4, r10);
        r5 = r10;
    L26:
        r7 = 0;
    L27:
        r6 = r7;
        goto L37
    L22:
        if (ACTION_DOPPELGANGER_PACKAGE_REMOVED.equals(r0) == false) goto L29;
        r5 = intent.getIntExtra(EXTRA_USERID, 0);
        r4 = intent.getStringExtra(EXTRA_PACKAGENAME);
        if (r4 == null) goto L26;
        PackageRemovedTasks.execute(context, r4, r5);
        goto L26
    L29:
        if (ACTION_DOPPELGANGER_PACKAGE_ADDED.equals(r0) == false) goto L34;
        r5 = intent.getIntExtra(EXTRA_USERID, 0);
        r4 = intent.getStringExtra(EXTRA_PACKAGENAME);
        if (r4 == null) goto L12;
        NetworkRejectHelper.updatePackageInstall(context, r4, r5);
        PackageAddedTasks.execute(context, r4, r5);
        goto L12
    L34:
        if (Constants.ACTION_BYTEDANCE_GAMEAPPTYPE_UPDATED.equals(r0) == false) goto L36;
        r4 = intent.getStringExtra("packagename");
        r5 = 0;
        r7 = 1;
        goto L27
    L36:
        r4 = null;
        r5 = 0;
        r7 = 0;
    L48:
        LogTag.d(TAG, " onReceive ex action" + r0);
    }

    private void notifyPackageInfo(final Context context, final Intent intent, final boolean added) {
        Uri r4 = intent.getData();
        if (r4 != null) goto L5;
        return;
    L5:
        LogTag.d(TAG, " notifyPackageInfo 1");
        final String r5 = r4.getSchemeSpecificPart();
        enqueueDbTask(context, new AnonymousClass2(this, added, r5));
    }
}
