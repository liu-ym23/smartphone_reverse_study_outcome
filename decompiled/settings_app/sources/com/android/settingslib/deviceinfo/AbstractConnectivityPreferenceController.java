package com.android.settingslib.deviceinfo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import com.GlobalProxyLancet;
import com.android.settingslib.core.AbstractPreferenceController;
import com.android.settingslib.core.lifecycle.Lifecycle;
import com.android.settingslib.core.lifecycle.LifecycleObserver;
import com.android.settingslib.core.lifecycle.events.OnStart;
import com.android.settingslib.core.lifecycle.events.OnStop;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractConnectivityPreferenceController extends AbstractPreferenceController implements LifecycleObserver, OnStart, OnStop {
    private static final int EVENT_UPDATE_CONNECTIVITY = 600;
    private final BroadcastReceiver mConnectivityReceiver;
    private Handler mHandler;

    private static class ConnectivityEventHandler extends Handler {
        private WeakReference<AbstractConnectivityPreferenceController> mPreferenceController;

        public ConnectivityEventHandler(AbstractConnectivityPreferenceController r2) {
            this.mPreferenceController = new WeakReference(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r3) {
            AbstractConnectivityPreferenceController r2 = this.mPreferenceController.get();
            if (r2 != null) goto L6;
            return;
        L6:
            if (r3.what != 600) goto L10;
            r2.updateConnectivity();
            return;
        L10:
            throw new IllegalStateException("Unknown message " + r3.what);
        }
    }

    protected abstract String[] getConnectivityIntents();

    protected abstract void updateConnectivity();

    static /* synthetic */ Handler access$000(AbstractConnectivityPreferenceController r0) {
        return r0.getHandler();
    }

    public AbstractConnectivityPreferenceController(Context r1, Lifecycle r2) {
        super(r1);
        this.mConnectivityReceiver = new AnonymousClass1(this);
        if (r2 == null) goto L6;
        r2.addObserver(this);
        return;
    }

    @Override // com.android.settingslib.core.lifecycle.events.OnStop
    public void onStop() {
        this.mContext.unregisterReceiver(this.mConnectivityReceiver);
    }

    @Override // com.android.settingslib.core.lifecycle.events.OnStart
    public void onStart() {
        IntentFilter r2 = new IntentFilter();
        String[] r0 = getConnectivityIntents();
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        r2.addAction(r0[r3]);
        r3 = r3 + 1;
        goto L3
    L5:
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.mConnectivityReceiver, r2, "android.permission.CHANGE_NETWORK_STATE", null, 2);
    }

    private Handler getHandler() {
        if (this.mHandler != null) goto L6;
        this.mHandler = new ConnectivityEventHandler(this);
    L6:
        return this.mHandler;
    }
}
