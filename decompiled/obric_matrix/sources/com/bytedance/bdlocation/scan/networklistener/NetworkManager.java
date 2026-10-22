package com.bytedance.bdlocation.scan.networklistener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.annotation.NonNull;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class NetworkManager {
    public static String TAG = "NetworkManager";
    private ConnectivityManager mConnMgr;
    private volatile boolean mIsRegister;
    private List<WifiChangeListener> mListeners;
    private NetworkCallbackImpl mNetworkCallback;
    private NetworkChangeReceiver mReceiver;

    /* JADX INFO: renamed from: com.bytedance.bdlocation.scan.networklistener.NetworkManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class SingletonHolder {
        private static NetworkManager instance;

        static {
            instance = new NetworkManager(null);
        }

        private SingletonHolder() {
        }

        static /* synthetic */ NetworkManager access$000() {
            return instance;
        }
    }

    static {
    }

    private NetworkManager() {
        this.mListeners = new ArrayList();
        this.mReceiver = new NetworkChangeReceiver();
    }

    /* synthetic */ NetworkManager(AnonymousClass1 r1) {
        this();
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent INVOKEVIRTUAL_com_bytedance_bdlocation_scan_networklistener_NetworkManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r1, BroadcastReceiver r2, IntentFilter r3) {
        return r1.registerReceiver(r2, r3);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3);
    }

    public static NetworkManager getInstance() {
        return SingletonHolder.access$000();
    }

    public List<WifiChangeListener> getListener() {
        return this.mListeners;
    }

    public void notifyWifiChanged(@NonNull Network r4, @NonNull NetworkCapabilities r5) {
        List<WifiChangeListener> r0 = this.mListeners;     // Catch: Exception -> L13
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.size() <= 0) goto L24;
        Iterator<WifiChangeListener> r3 = this.mListeners.iterator();     // Catch: Exception -> L13
    L8:
        if (r3.hasNext() == false) goto L25;
        WifiChangeListener r1 = r3.next();     // Catch: Exception -> L13
        if (Build.VERSION.SDK_INT < 21) goto L8;
        r1.notifyWifiChanged(r4, r5);     // Catch: Exception -> L13
        goto L8
    L25:
        return;
    L24:
        return;
    L13:
        e = move-exception;
        Logger.e("notifyWifiChanged error", e);
    }

    public void notifyWifiChangedTwo(NetworkInfo r2) {
        List<WifiChangeListener> r0 = this.mListeners;     // Catch: Exception -> L11
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.size() <= 0) goto L19;
        Iterator<WifiChangeListener> r1 = this.mListeners.iterator();     // Catch: Exception -> L11
    L8:
        if (r1.hasNext() == false) goto L20;
        r1.next().notifyWifiChangedTwo(r2);     // Catch: Exception -> L11
        goto L8
    L20:
        return;
    L19:
        return;
    L11:
        e = move-exception;
        Logger.e("notifyWifiChangedTwo error", e);
    }

    public void registerObserver(Context r4) {
        Logger.i("WifiCollect:register network mIsRegister is:" + this.mIsRegister);
        if (this.mIsRegister == false) goto L10;
        return;
    L10:
        IntentFilter r0 = new IntentFilter();     // Catch: Throwable -> L7
        r0.addAction("android.net.conn.CONNECTIVITY_CHANGE");     // Catch: Throwable -> L7
        this.mReceiver.doRegister(true);     // Catch: Throwable -> L7
        INVOKEVIRTUAL_com_bytedance_bdlocation_scan_networklistener_NetworkManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r4, this.mReceiver, r0);     // Catch: Throwable -> L7
        this.mIsRegister = true;     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Logger.e("WifiCollect register network change error", th);
    }

    public void setListener(WifiChangeListener r1) {
        this.mListeners.add(r1);
    }

    public void unRegisterObserver(Context r3) {
        Logger.i("WifiCollect:unregister network mIsRegister is:" + this.mIsRegister);
        if (this.mIsRegister == true) goto L5;
        return;
    L5:
        if (r3 == null) goto L15;
        NetworkChangeReceiver r0 = this.mReceiver;     // Catch: Exception -> L10
        if (r0 == null) goto L16;
        r3.unregisterReceiver(r0);     // Catch: Exception -> L10
        this.mIsRegister = false;     // Catch: Exception -> L10
        return;
    L16:
        return;
    L10:
        e = move-exception;
        Logger.e("WifiCollect:unregister network change error", e);
        return;
    }
}
