package obric.time;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import com.GlobalProxyLancet;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes5.dex */
public class NetWorkMonitor {
    public static final String TAG = "NetWorkMonitor";
    private NetworkCallback mCallback;
    private ConnectivityManager mConnectivityManager;
    private Context mContext;
    private boolean mNetworkAvailable;
    private ConnectivityManager.NetworkCallback mNetworkCallback;
    private BroadcastReceiver mNetworkReceiver;

    interface NetworkCallback {
        void onNetworkAvailable();

        void onNetworkLost();
    }

    static /* synthetic */ void access$000(NetWorkMonitor r0, boolean r1) {
        r0.onNetwortStateChanged(r1);
    }

    NetWorkMonitor(Context r1, NetworkCallback r2) {
        if (r1 == null) goto L7;
        this.mContext = r1;
        this.mCallback = r2;
        this.mConnectivityManager = (ConnectivityManager) r1.getSystemService("connectivity");
        this.mNetworkAvailable = isConnected(r1);
        registerNetworkCallbackOrReceiver();
        return;
    L7:
        throw new IllegalArgumentException("context must not be null for network monitor.");
    }

    public static boolean isConnected(Context r1) {
        ConnectivityManager r2 = (ConnectivityManager) r1.getSystemService("connectivity");
        NetworkCapabilities r3 = r2.getNetworkCapabilities(r2.getActiveNetwork());
        if (r3 != null) goto L5;
    L7:
        return false;
    L5:
        if (r3.hasCapability(16) == false) goto L7;
        return true;
    }

    private static NetworkInfo getCurrentActiveNetwork(Context r1) {
        ConnectivityManager r2 = (ConnectivityManager) r1.getSystemService("connectivity");     // Catch: Exception -> L7
        if (r2 == null) goto L13;
        NetworkInfo r3 = r2.getActiveNetworkInfo();     // Catch: Exception -> L7
        if (r3 == null) goto L14;
        return r3;
    L14:
        return null;
    L13:
        return null;
    L7:
        e = move-exception;
        OLog.w(TAG, e.getMessage());
        return null;
    }

    boolean isNetworkAvailable() {
        return this.mNetworkAvailable;
    }

    void destroy() {
        unregisterNetworkCallbackOrReceiver();
        this.mCallback = null;
        this.mContext = null;
        this.mConnectivityManager = null;
        this.mNetworkAvailable = false;
    }

    private void registerNetworkCallbackOrReceiver() {
        registerNetworkCallback();
    }

    private void registerNetworkCallback() {
        this.mNetworkCallback = new AnonymousClass1(this);
        this.mConnectivityManager.registerDefaultNetworkCallback(this.mNetworkCallback);
    }

    private void registerNetworkReceiver() {
        this.mNetworkReceiver = new AnonymousClass2(this);
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.mNetworkReceiver, r0, 2);
    }

    private void unregisterNetworkCallbackOrReceiver() {
        ConnectivityManager.NetworkCallback r0 = this.mNetworkCallback;
        if (r0 == null) goto L5;
        this.mConnectivityManager.unregisterNetworkCallback(r0);
        this.mNetworkCallback = null;
        return;
    L5:
        ConnectivityManager.NetworkCallback r1 = this.mNetworkCallback;
        if (r1 == null) goto L8;
        this.mConnectivityManager.unregisterNetworkCallback(r1);
        this.mNetworkCallback = null;
        return;
    L8:
        this.mContext.unregisterReceiver(this.mNetworkReceiver);
        this.mNetworkReceiver = null;
    }

    private void onNetwortStateChanged(boolean r2) {
        if (this.mNetworkAvailable == r2) goto L6;
        this.mNetworkAvailable = r2;
        postNetworkState(r2);
        return;
    }

    private void postNetworkState(boolean r1) {
        NetworkCallback r0 = this.mCallback;
        if (r0 == null) goto L8;
        if (r1 == false) goto L6;
        r0.onNetworkAvailable();
        return;
    L6:
        r0.onNetworkLost();
        return;
    }
}
