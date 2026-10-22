package com.slardaros.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
class SlardarServiceProxy implements ServiceConnection {
    private static final int MAX_RETRY_COUNT = 0;
    private static final long RETRY_DELAY = 1000;
    private BindCallback mBindCallback;
    private AtomicBoolean mConnected;
    private Context mContext;
    private Handler mHandler;
    private Messenger mMessenger;
    private AtomicInteger mRetryCount;
    private boolean mUnbindMySelf;

    interface BindCallback {
        void onTeaServiceConnected();

        void onTeaServiceDisconnected();
    }

    private static final class InternalHolder {
        public static final SlardarServiceProxy sServiceProxy = null;

        private InternalHolder() {
        }

        static {
            sServiceProxy = new SlardarServiceProxy(null);
        }
    }

    /* synthetic */ SlardarServiceProxy(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ boolean access$000(SlardarServiceProxy r0) {
        return r0.bindSlardarService();
    }

    public void onProfile(AppProfile r6, Messenger r7) {
    L8:
        e = move-exception;
        OLog.e(Constants.TAG, "SlardarServiceProxy onProfile ex: " + e);
        return;
    L3:
        if (isServiceConnected() == false) goto L13;
        Message r0 = new Message();     // Catch: Exception -> L8
        Bundle r1 = new Bundle();     // Catch: Exception -> L8
        r0.setData(r1);     // Catch: Exception -> L8
        if (this.mMessenger == null) goto L14;
        r0.what = 1004;     // Catch: Exception -> L8
        Parcel r2 = Parcel.obtain();     // Catch: Exception -> L8
        OLog.d("SlardarAgent_profle", r6.toString());     // Catch: Exception -> L8
        r6.writeToParcel(r2, 0);     // Catch: Exception -> L8
        r2.setDataPosition(0);     // Catch: Exception -> L8
        r1.putByteArray("key_data", r2.marshall());     // Catch: Exception -> L8
        r0.replyTo = r7;     // Catch: Exception -> L8
        this.mMessenger.send(r0);     // Catch: Exception -> L8
        return;
    L14:
        return;
    }

    public void onAbResult(Bundle r2) {
    L8:
        e = move-exception;
        OLog.e(Constants.TAG, "SlardarServiceProxy onAbResult ex: " + e);
        return;
    L3:
        if (isServiceConnected() == false) goto L13;
        Message r0 = new Message();     // Catch: Exception -> L8
        r0.setData(r2);     // Catch: Exception -> L8
        if (this.mMessenger == null) goto L14;
        r0.what = 1006;     // Catch: Exception -> L8
        this.mMessenger.send(r0);     // Catch: Exception -> L8
        return;
    L14:
        return;
    }

    private SlardarServiceProxy() {
        this.mConnected = new AtomicBoolean(false);
        this.mRetryCount = new AtomicInteger(0);
        this.mUnbindMySelf = false;
    }

    public boolean bindService(Context r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        this.mContext = r4;
        if (this.mConnected.get() == false) goto L12;
        if (this.mMessenger == null) goto L12;
        notifyBindCallback(true);
        return true;
    L12:
        if (bindSlardarService() == false) goto L15;
        OLog.i(Constants.TAG, "Connecting slardar service");
        return true;
    L15:
        OLog.i(Constants.TAG, "Can't connect to slardar service");
        unbindService();
        return false;
    }

    public void setBindCallback(BindCallback r1) {
        this.mBindCallback = r1;
    }

    public boolean isServiceConnected() {
        if (this.mConnected.get() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mMessenger == null) goto L7;
        return true;
    }

    private boolean bindSlardarService() {
        Intent r0 = new Intent(Constants.SLARDAR_SERVICE_ACTION);
        Context r1 = this.mContext;
        if (r1 == null) goto L5;
        PackageManager r2 = r1.getPackageManager();
    L7:
        if (r2 != null) goto L10;
        OLog.e(Constants.TAG, "Can not resolve slardarosclient app! packageManager is null ");
        return false;
    L10:
        List<ResolveInfo> r3 = r2.queryIntentServices(r0, 0);
        if (r3 != null) goto L14;
        return false;
    L14:
        if (r3.isEmpty() == false) goto L18;
        OLog.e(Constants.TAG, "Can not resolve slardarosclient app! We got empty list!");
        return false;
    L18:
        if (r3.size() <= 1) goto L21;
        OLog.e(Constants.TAG, "can not resolve slardarosclient app! We got several results!");
        return false;
    L21:
        r0.setPackage(r3.get(0).serviceInfo.packageName);
        return this.mContext.bindService(r0, this, 1);
    L5:
        r2 = null;
        goto L7
    }

    public void unbindService() {
        this.mUnbindMySelf = true;
        if (isServiceConnected() == false) goto L11;
        this.mContext.unbindService(this);     // Catch: Exception -> L6
        this.mConnected.set(false);     // Catch: Exception -> L6
        this.mMessenger = null;     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        OLog.e(Constants.TAG, "SlardarServiceProxy unbind ex: " + e.getMessage());
        return;
    }

    public boolean onEvent(List<AgentEvent> r14) {
    L47:
        e = move-exception;
        OLog.e(Constants.TAG, "SlardarServiceProxy onEvent ex: " + e);
        return false;
    L4:
        if (isServiceConnected() == false) goto L68;
        ArrayList<? extends Parcelable> r1 = new ArrayList();     // Catch: Exception -> L47
        ArrayList<? extends Parcelable> r2 = new ArrayList();     // Catch: Exception -> L47
        ArrayList<? extends Parcelable> r3 = new ArrayList();     // Catch: Exception -> L47
        ArrayList<? extends Parcelable> r4 = new ArrayList();     // Catch: Exception -> L47
        Iterator<AgentEvent> r5 = r14.iterator();     // Catch: Exception -> L47
    L7:
        if (r5.hasNext() == false) goto L30;
        AgentEvent r6 = r5.next();     // Catch: Exception -> L47
        String r8 = null;
        if ((r6 instanceof SlardarEvent) == true) goto L11;
        if ((r6 instanceof ErrorEvent) == true) goto L18;
        if ((r6 instanceof InfoEvent) == true) goto L21;
        if ((r6 instanceof MetricEvent) == false) goto L7;
        OLog.d(SlardarAgent.TAG, "MetricEvent");     // Catch: Exception -> L47
        MetricEvent r7 = (MetricEvent) r6;     // Catch: Exception -> L47
        Bundle r9 = new Bundle();     // Catch: Exception -> L47
        r9.putString("key_event", r7.getEvent());     // Catch: Exception -> L47
        if (r7.getJsonParams() == null) goto L28;
        r8 = r7.getJsonParams().toString();     // Catch: Exception -> L47
    L28:
        r9.putString("key_params", r8);     // Catch: Exception -> L47
        r4.add(r9);     // Catch: Exception -> L47
        goto L7
    L21:
        OLog.d(SlardarAgent.TAG, "InfoEvent");     // Catch: Exception -> L47
        InfoEvent r10 = (InfoEvent) r6;     // Catch: Exception -> L47
        Bundle r11 = new Bundle();     // Catch: Exception -> L47
        r11.putString(Constants.MESSAGE_INFO_LOGID, r10.getLogId());     // Catch: Exception -> L47
        r11.putString(Constants.MESSAGE_INFO_LOGTYPE, r10.getLogType());     // Catch: Exception -> L47
        r11.putString(Constants.MESSAGE_INFO_LOGPATH, r10.getLogPath());     // Catch: Exception -> L47
        r11.putBoolean(Constants.MESSAGE_INFO_DELETE, r10.isDelete());     // Catch: Exception -> L47
        r3.add(r11);     // Catch: Exception -> L47
        goto L7
    L18:
        OLog.d(SlardarAgent.TAG, "ErrorEvent");     // Catch: Exception -> L47
        ErrorEvent r12 = (ErrorEvent) r6;     // Catch: Exception -> L47
        Bundle r13 = new Bundle();     // Catch: Exception -> L47
        r13.putString(Constants.MESSAGE_ERROR_TAG, r12.getTag());     // Catch: Exception -> L47
        r13.putString(Constants.MESSAGE_ERROR_TYPE, r12.getType());     // Catch: Exception -> L47
        r13.putString(Constants.MESSAGE_ERROR_SUMMARY, r12.getSummary());     // Catch: Exception -> L47
        r13.putString(Constants.MESSAGE_ERROR_LOGPATH, r12.getLogPath());     // Catch: Exception -> L47
        r13.putBoolean(Constants.MESSAGE_ERROR_DELETE, r12.isDelete());     // Catch: Exception -> L47
        r13.putString(Constants.MESSAGE_ERROR_PACKAGE, r12.getPackageName());     // Catch: Exception -> L47
        r13.putLong(Constants.MESSAGE_ERROR_BOOTTIME, System.currentTimeMillis() - SystemClock.elapsedRealtime());     // Catch: Exception -> L47
        r13.putLong(Constants.MESSAGE_ERROR_TIMESTAMP, System.currentTimeMillis());     // Catch: Exception -> L47
        r13.putBoolean(Constants.MESSAGE_ERROR_CATCHLOG, r12.isCatchLog());     // Catch: Exception -> L47
        r2.add(r13);     // Catch: Exception -> L47
        goto L7
    L11:
        OLog.d(SlardarAgent.TAG, "SlardarEvent");     // Catch: Exception -> L47
        SlardarEvent r15 = (SlardarEvent) r6;     // Catch: Exception -> L47
        Bundle r16 = new Bundle();     // Catch: Exception -> L47
        r16.putString("key_event", r15.getEvent());     // Catch: Exception -> L47
        if (r15.getJsonParams() == null) goto L15;
        r8 = r15.getJsonParams().toString();     // Catch: Exception -> L47
    L15:
        r16.putString("key_params", r8);     // Catch: Exception -> L47
        r16.putBoolean("key_instant", r15.isInstant());     // Catch: Exception -> L47
        r16.putLong("key_timestamp", r15.getTimestamp());     // Catch: Exception -> L47
        r1.add(r16);     // Catch: Exception -> L47
        goto L7
    L30:
        if (this.mMessenger != null) goto L34;
        BaseHandler.getSlardarHandler().onEvents(r14);     // Catch: Exception -> L47
        return true;
    L34:
        if (r1.size() <= 0) goto L37;
        Message r17 = new Message();     // Catch: Exception -> L47
        Bundle r18 = new Bundle();     // Catch: Exception -> L47
        r17.setData(r18);     // Catch: Exception -> L47
        r17.what = 1001;     // Catch: Exception -> L47
        r18.putParcelableArrayList("key_data", r1);     // Catch: Exception -> L47
        this.mMessenger.send(r17);     // Catch: Exception -> L47
    L37:
        if (r2.size() <= 0) goto L40;
        Message r19 = new Message();     // Catch: Exception -> L47
        Bundle r20 = new Bundle();     // Catch: Exception -> L47
        r19.setData(r20);     // Catch: Exception -> L47
        OLog.d(Constants.TAG, "errorBundlers : " + r2.toString());     // Catch: Exception -> L47
        r19.what = 1002;     // Catch: Exception -> L47
        r20.putParcelableArrayList("key_data", r2);     // Catch: Exception -> L47
        r19.setData(r20);     // Catch: Exception -> L47
        this.mMessenger.send(r19);     // Catch: Exception -> L47
    L40:
        if (r3.size() <= 0) goto L43;
        Message r110 = new Message();     // Catch: Exception -> L47
        Bundle r21 = new Bundle();     // Catch: Exception -> L47
        r110.setData(r21);     // Catch: Exception -> L47
        r110.what = 1003;     // Catch: Exception -> L47
        r21.putParcelableArrayList("key_data", r3);     // Catch: Exception -> L47
        this.mMessenger.send(r110);     // Catch: Exception -> L47
    L43:
        if (r4.size() <= 0) goto L67;
        Message r111 = new Message();     // Catch: Exception -> L47
        Bundle r22 = new Bundle();     // Catch: Exception -> L47
        r111.setData(r22);     // Catch: Exception -> L47
        r111.what = 1007;     // Catch: Exception -> L47
        r22.putParcelableArrayList("key_data", r4);     // Catch: Exception -> L47
        this.mMessenger.send(r111);     // Catch: Exception -> L47
        return true;
    L67:
        return true;
    L68:
        return false;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName r2, IBinder r3) {
        this.mRetryCount.set(0);
        this.mMessenger = new Messenger(r3);
        notifyBindCallback(true);
        this.mConnected.set(true);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName r4) {
        this.mConnected.set(false);
        this.mMessenger = null;
        OLog.d(Constants.TAG, "onServiceDisconnected");
        if (this.mUnbindMySelf == true) goto L9;
        OLog.i(Constants.TAG, "SlardarServiceProxy retry times: " + this.mRetryCount.get());
        if (this.mRetryCount.getAndIncrement() >= 0) goto L7;
        this.mHandler.postDelayed(new AnonymousClass1(this), 1000);
        return;
    L7:
        OLog.e(Constants.TAG, "SlardarServiceProxy connected to slardar service error with " + this.mRetryCount.get() + " times retry.");
        return;
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName r1) {
        onServiceDisconnected(r1);
    }

    private void notifyBindCallback(boolean r1) {
        BindCallback r0 = this.mBindCallback;
        if (r0 == null) goto L8;
        if (r1 == false) goto L6;
        r0.onTeaServiceConnected();
        return;
    L6:
        r0.onTeaServiceDisconnected();
        return;
    }

    public static SlardarServiceProxy getSlardarServiceProxy(Handler r2) {
        if (InternalHolder.sServiceProxy.mHandler != null) goto L11;
        if (r2 == null) goto L9;
        if (r2.getLooper() == Looper.getMainLooper()) goto L9;
        InternalHolder.sServiceProxy.mHandler = r2;
    L9:
        throw new RuntimeException("A handler needed by SlardarServiceProxy and handler should runs in the non-main thread");
    L11:
        return InternalHolder.sServiceProxy;
    }
}
