package com.bytedanceos.clearmemory;

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
import com.bytedanceos.securitycenter.SharedPreferUtil;
import com.obric.olog.OLog;
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
    private static final String TAG = "ClearProcessService";
    private ActivityManager mActivityManager;
    private Handler mHandler;
    private long mMem;
    private List<RunningState.MergedItem> mMergedItems;
    private Messenger mMessenger;
    private RunningState mRunningState;

    private class ClearProcessHandler extends Handler {
        final /* synthetic */ ClearProcessService this$0;

        ClearProcessHandler(final ClearProcessService this$0, Looper looper) {
            this.this$0 = this$0;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            int r0 = msg.what;
            if (r0 != 1) goto L5;
            OLog.i(ClearProcessService.TAG, "handleMessage: SCAN_RUNNING_PROCESS start");
            ClearProcessService r1 = this.this$0;
            monitor-enter(r1);
            ClearProcessService r2 = this.this$0;     // Catch: Throwable -> L38
            ClearProcessService.access$002(r2, ClearProcessService.access$100(r2));     // Catch: Throwable -> L38
            monitor-exit(r1);     // Catch: Throwable -> L38
            Message r3 = Message.obtain(null, 100);
            Bundle r4 = new Bundle();
            r4.putLong(ClearProcessService.REFRESH_MEM_EXTRA_MEM, ClearProcessService.access$200(this.this$0));
            r4.putLong(ClearProcessService.REFRESH_MEM_EXTRA_LAST_CLEAN_TIME, ClearProcessService.getLastCleanTime(this.this$0));
            r3.obj = r4;
            msg.replyTo.send(r3);     // Catch: RemoteException -> L35
            return;
        L35:
            e = move-exception;
            e.printStackTrace();
            return;
        L38:
            th = move-exception;
            throw th;
        L5:
            if (r0 != 2) goto L7;
            OLog.i(ClearProcessService.TAG, "handleMessage: CLEAN_PROCESSES start");
            ClearProcessService r5 = this.this$0;
            monitor-enter(r5);
        L25:
            th = move-exception;
            throw th;
        L15:
            if (ClearProcessService.access$000(this.this$0) != null) goto L17;
        L23:
            monitor-exit(r5);     // Catch: Throwable -> L25
            return;
        L17:
            if (ClearProcessService.access$000(this.this$0).size() <= 0) goto L23;
            ClearProcessService.notifyClearProcessState(1);     // Catch: Throwable -> L25
            Iterator r6 = ClearProcessService.access$000(this.this$0).iterator();     // Catch: Throwable -> L25
        L20:
            if (r6.hasNext() == false) goto L22;
            RunningState.MergedItem r7 = (RunningState.MergedItem) r6.next();     // Catch: Throwable -> L25
            RunningStateHelper.getInstance().stopPackage(r7, false);     // Catch: Throwable -> L25
            goto L20
        L22:
            ClearProcessService.access$000(this.this$0).clear();     // Catch: Throwable -> L25
            ClearProcessService.notifyClearProcessState(0);     // Catch: Throwable -> L25
            goto L23
        L7:
            if (r0 != 3) goto L51;
            long r8 = ((Bundle) msg.obj).getLong(ClearProcessService.CLEAN_DONE_TIME, 0);
            if (r8 <= 0) goto L48;
            ClearProcessService.saveCleanTime(this.this$0, r8);
            return;
        L48:
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
        long r3 = 0;
        if (r1 == null) goto L17;
        Iterator<RunningState.MergedItem> r4 = r1.iterator();
        long r5 = 0;
    L6:
        if (r4.hasNext() == false) goto L16;
        RunningState.MergedItem r6 = r4.next();
        if (r6.mMergeSize <= 0) goto L6;
        r6.enSureTaskPersist(getPackageManager());
        if (r6.mIsRecommendClear == false) goto L6;
        if (r6.mIsTaskPersist == true) goto L6;
        r5 = r5 + r6.mMergeSize;
        r2.add(r6);
        goto L6
    L16:
        r3 = r5;
    L17:
        this.mMem = r3;
        return r2;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        OLog.i(TAG, "onCreate: start HandlerThread");
        this.mRunningState = RunningState.getInstance(getApplicationContext());
        HandlerThread r0 = new HandlerThread("clear_process");
        r0.start();
        if (r0.getLooper() == null) goto L5;
        this.mHandler = new ClearProcessHandler(this, r0.getLooper());
    L5:
        this.mMessenger = new Messenger(this.mHandler);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mMessenger.getBinder();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        OLog.i(TAG, "onDestroy: cleanup");
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

    public static void notifyClearProcessState(int state) {
        IBinder r0 = ServiceManager.getService("activity");     // Catch: Exception -> L6
        if (r0 == null) goto L9;
        Parcel r1 = Parcel.obtain();     // Catch: Exception -> L6
        r1.writeInt(state);     // Catch: Exception -> L6
        r0.transact(1012, r1, null, 0);     // Catch: Exception -> L6
        r1.recycle();     // Catch: Exception -> L6
        return;
    L9:
        return;
    }

    public static void saveCleanTime(Context context, long time) {
        SharedPreferUtil.commitAsynchronously(PreferenceManager.getDefaultSharedPreferences(context).edit().putLong(LAST_CLEAN_PROCESSES_TIME, time));
    }

    public static long getLastCleanTime(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong(LAST_CLEAN_PROCESSES_TIME, 0);
    }
}
