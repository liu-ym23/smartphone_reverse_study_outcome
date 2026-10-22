package com.android.settings.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.GlobalProxyLancet;
import com.android.settings.BytedanceEventReceiver;
import com.android.settings.EventType;
import com.android.settings.PreferenceMgr;
import com.obric.olog.OLog;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes2.dex */
public class OTAUpdateManager {
    private static final String ACTION_NEW_MESSAGE = "com.obric.updater.update_message";
    private static final int BIND_SERVICE = 1;
    private static final String EXTRA_MESSAGE_COUNT = "extra_update_count";
    private static final String TAG = "OTAUpdateManager";
    private static OTAUpdateManager mOTAUpdateManager;
    private BroadcastReceiver mBroadcastReceiver;
    private Context mContext;
    private boolean mHasUpdatePackage;
    private IBinder mIBinder;
    private ServiceConnection mServiceConnection;

    static {
    }

    static /* synthetic */ IBinder access$000(OTAUpdateManager r0) {
        return r0.mIBinder;
    }

    static /* synthetic */ IBinder access$002(OTAUpdateManager r0, IBinder r1) {
        r0.mIBinder = r1;
        return r1;
    }

    static /* synthetic */ boolean access$100(OTAUpdateManager r0) {
        return r0.mHasUpdatePackage;
    }

    static /* synthetic */ boolean access$102(OTAUpdateManager r0, boolean r1) {
        r0.mHasUpdatePackage = r1;
        return r1;
    }

    static /* synthetic */ Context access$200(OTAUpdateManager r0) {
        return r0.mContext;
    }

    static /* synthetic */ void access$300(OTAUpdateManager r0, Context r1, boolean r2) {
        r0.setShowBytedanceUpdateBadge(r1, r2);
    }

    static /* synthetic */ void access$400(OTAUpdateManager r0) {
        r0.unBindQueryService();
    }

    private OTAUpdateManager(Context r2) {
        this.mHasUpdatePackage = false;
        this.mServiceConnection = new AnonymousClass1(this);
        this.mBroadcastReceiver = new AnonymousClass2(this);
        this.mContext = r2;
        bindQueryService();
        registerBroadCast();
    }

    public static OTAUpdateManager getInstance(Context r1) {
        if (mOTAUpdateManager != null) goto L6;
        mOTAUpdateManager = new OTAUpdateManager(r1);
    L6:
        return mOTAUpdateManager;
    }

    private void bindQueryService() {
        OLog.d(TAG, "bindQueryService()");
        Intent r2 = new Intent();     // Catch: Throwable -> L7
        r2.setClassName("com.obric.updater", "com.obric.updater.service.QueryService");     // Catch: Throwable -> L7
        boolean r3 = this.mContext.bindService(r2, this.mServiceConnection, 1);     // Catch: Throwable -> L7
        if (r3 == false) goto L13;
    L9:
        if (r3 == true) goto L17;
        this.mHasUpdatePackage = false;
        setShowBytedanceUpdateBadge(this.mContext, false);
        return;
    L17:
        return;
    L13:
        OLog.w(TAG, " bind service com.obric.updater return false");     // Catch: Throwable -> L12
    L8:
        OLog.w(TAG, " bind service com.obric.updater fail");
    L7:
        r3 = false;
        goto L8
    }

    private void unBindQueryService() {
        OLog.d(TAG, "unBindQueryService");
        this.mContext.unbindService(this.mServiceConnection);
    }

    private void registerBroadCast() {
        OLog.d(TAG, "registerBroadCast");
        IntentFilter r0 = new IntentFilter();
        r0.addAction(ACTION_NEW_MESSAGE);
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.mBroadcastReceiver, r0, 2);
    }

    private void unRegisterBroadCast() {
        OLog.d(TAG, "unRegisterBroadCast");
        this.mContext.unregisterReceiver(this.mBroadcastReceiver);
    }

    private void setShowBytedanceUpdateBadge(Context r2, boolean r3) {
        OLog.d(TAG, "setShowBytedanceUpdateBadge as " + r3);
        PreferenceMgr.getInstance(r2).putBoolean(BytedanceEventReceiver.KEY_SHOW_OTA_UPDATABLE_BADGE, r3);
        EventBus.getDefault().post(new EventType.OTABadgeUpdateEvent(r3));
    }
}
