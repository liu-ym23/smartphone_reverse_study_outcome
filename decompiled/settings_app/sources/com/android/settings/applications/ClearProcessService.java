package com.android.settings.applications;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.preference.PreferenceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ClearProcessService extends Service {
    private static final String CLEAN_DONE_TIME = "clean_done_time";
    private static final int CLEAN_PROCESSES = 2;
    private static final int CLEAN_PROCESSES_DONE = 3;
    public static final String LAST_CLEAN_PROCESSES_TIME = "last_clean_processes_time";
    private static final int NOTIFY_CLEAR_PROCESS_TRANSACTION = 1012;
    private static final int REFRESH_MEM = 100;
    private static final String REFRESH_MEM_EXTRA_LAST_CLEAN_TIME = "clean_time";
    private static final String REFRESH_MEM_EXTRA_MEM = "mem";
    private static final int SCAN_RUNNING_PROCESS = 1;
    private ActivityManager mActivityManager;
    private Handler mHandler;
    private long mMem;
    private List<RunningState.MergedItem> mMergedItems;
    private Messenger mMessenger;
    private RunningState mRunningState;

    private class ClearProcessHandler extends Handler {
        final /* synthetic */ ClearProcessService this$0;

        ClearProcessHandler(ClearProcessService r1, Looper r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r6) {
            int r0 = r6.what;
            if (r0 != 1) goto L5;
            ClearProcessService r1 = this.this$0;
            ClearProcessService.access$002(r1, ClearProcessService.access$100(r1));
            Message r2 = Message.obtain(null, 100);
            Bundle r3 = new Bundle();
            r3.putLong(ClearProcessService.REFRESH_MEM_EXTRA_MEM, ClearProcessService.access$200(this.this$0));
            r3.putLong(ClearProcessService.REFRESH_MEM_EXTRA_LAST_CLEAN_TIME, ClearProcessService.getLastCleanTime(this.this$0));
            r2.obj = r3;
            r6.replyTo.send(r2);     // Catch: RemoteException -> L31
            return;
        L31:
            e = move-exception;
            e.printStackTrace();
            return;
        L5:
            if (r0 != 2) goto L7;
            ClearProcessService r4 = this.this$0;
            monitor-enter(r4);
        L25:
            th = move-exception;
            throw th;
        L15:
            if (ClearProcessService.access$000(this.this$0) != null) goto L17;
        L23:
            monitor-exit(r4);     // Catch: Throwable -> L25
            return;
        L17:
            if (ClearProcessService.access$000(this.this$0).size() <= 0) goto L23;
            ClearProcessService.notifyClearProcessState(1);     // Catch: Throwable -> L25
            Iterator r7 = ClearProcessService.access$000(this.this$0).iterator();     // Catch: Throwable -> L25
        L20:
            if (r7.hasNext() == false) goto L22;
            RunningState.MergedItem r5 = (RunningState.MergedItem) r7.next();     // Catch: Throwable -> L25
            RunningStateHelper.getInstance().stopPackage(r5, false);     // Catch: Throwable -> L25
            goto L20
        L22:
            ClearProcessService.access$000(this.this$0).clear();     // Catch: Throwable -> L25
            ClearProcessService.notifyClearProcessState(0);     // Catch: Throwable -> L25
            goto L23
        L7:
            if (r0 != 3) goto L42;
            long r8 = ((Bundle) r6.obj).getLong(ClearProcessService.CLEAN_DONE_TIME, 0);
            if (r8 <= 0) goto L39;
            ClearProcessService.saveCleanTime(this.this$0, r8);
            return;
        L39:
            return;
        }
    }

    public ClearProcessService() {
        this.mMem = 0;
    }

    static /* synthetic */ List access$000(ClearProcessService r0) {
        return r0.mMergedItems;
    }

    static /* synthetic */ List access$002(ClearProcessService r0, List r1) {
        r0.mMergedItems = r1;
        return r1;
    }

    static /* synthetic */ List access$100(ClearProcessService r0) {
        return r0.getProcesses();
    }

    static /* synthetic */ long access$200(ClearProcessService r2) {
        return r2.mMem;
    }

    private List<RunningState.MergedItem> getProcesses() {
        ActivityManager r0 = (ActivityManager) getSystemService("activity");
        this.mActivityManager = r0;
        this.mRunningState.updateSM(r0);
        List<RunningState.MergedItem> r1 = RunningStateHelper.getInstance().mergedPackages(this.mRunningState.getCurrentMergedItems());
        ArrayList r2 = new ArrayList();
        Iterator<RunningState.MergedItem> r3 = r1.iterator();
        long r4 = 0;
    L4:
        if (r3.hasNext() == false) goto L14;
        RunningState.MergedItem r6 = r3.next();
        if (r6.mMergeSize <= 0) goto L4;
        r6.enSureTaskPersist(getPackageManager());
        if (r6.mIsRecommendClear == false) goto L4;
        if (r6.mIsTaskPersist == true) goto L4;
        r4 = r4 + r6.mMergeSize;
        r2.add(r6);
        goto L4
    L14:
        this.mMem = r4;
        return r2;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mRunningState = RunningState.getInstance(getApplicationContext());
        HandlerThread r0 = new HandlerThread("clear_process");
        r0.start();
        this.mHandler = new ClearProcessHandler(this, r0.getLooper());
        this.mMessenger = new Messenger(this.mHandler);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r1) {
        return this.mMessenger.getBinder();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        RunningStateHelper.getInstance().doDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        monitor-enter(this);
        List<RunningState.MergedItem> r0 = this.mMergedItems;     // Catch: Throwable -> L9
        if (r0 == null) goto L7;
        r0.clear();     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static void notifyClearProcessState(int r4) {
        IBinder r0 = ServiceManager.getService("activity");     // Catch: Exception -> L6
        if (r0 == null) goto L9;
        Parcel r1 = Parcel.obtain();     // Catch: Exception -> L6
        r1.writeInt(r4);     // Catch: Exception -> L6
        r0.transact(1012, r1, null, 0);     // Catch: Exception -> L6
        r1.recycle();     // Catch: Exception -> L6
        return;
    L9:
        return;
    }

    public static void saveCleanTime(Context r1, long r2) {
        PreferenceManager.getDefaultSharedPreferences(r1).edit().putLong(LAST_CLEAN_PROCESSES_TIME, r2).apply();
    }

    public static long getLastCleanTime(Context r3) {
        return PreferenceManager.getDefaultSharedPreferences(r3).getLong(LAST_CLEAN_PROCESSES_TIME, 0);
    }
}
