package com.android.settings.bluetooth;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import com.GlobalProxyLancet;
import com.android.settingslib.SliceBroadcastRelay;
import com.obric.olog.OLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConnectingStateHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u000e\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/android/settings/bluetooth/ConnectingStateHandler;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "TAG", "", "getActivity", "()Landroid/app/Activity;", "context", "Landroid/content/Context;", "lastState", "", SliceBroadcastRelay.EXTRA_RECEIVER, "com/android/settings/bluetooth/ConnectingStateHandler$receiver$1", "Lcom/android/settings/bluetooth/ConnectingStateHandler$receiver$1;", "onInvisible", "", "onVisible", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ConnectingStateHandler {
    private final String TAG;
    private final Activity activity;
    private final Context context;
    private int lastState;
    private final ConnectingStateHandler$receiver$1 receiver;

    /* JADX WARN: Type inference failed for: r1v1, types: [com.android.settings.bluetooth.ConnectingStateHandler$receiver$1] */
    public ConnectingStateHandler(Activity r3) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        this.activity = r3;
        Context r4 = r3.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r4, "getApplicationContext(...)");
        this.context = r4;
        this.TAG = "ConnectingStateHandler";
        this.lastState = -1;
        this.receiver = new ConnectingStateHandler$receiver$1(this);
        this.lastState = LocalBluetoothManager.getInstance(r4).getBluetoothAdapter().getConnectionState();
        OLog.i("ConnectingStateHandler", "init: " + this.lastState);
    }

    public static final /* synthetic */ String access$getTAG$p(ConnectingStateHandler r0) {
        return r0.TAG;
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final void onVisible() {
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.context, this.receiver, new IntentFilter("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED"), 2);
    }

    public final void onInvisible() {
        this.context.unregisterReceiver(this.receiver);
    }
}
