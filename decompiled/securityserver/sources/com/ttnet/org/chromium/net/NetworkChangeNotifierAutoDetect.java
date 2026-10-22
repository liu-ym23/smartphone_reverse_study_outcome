package com.ttnet.org.chromium.net;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.ttnet.org.chromium.base.ApplicationStatus;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.StrictModeContext;
import com.ttnet.org.chromium.base.TraceEvent;
import com.ttnet.org.chromium.base.compat.ApiHelperForM;
import com.ttnet.org.chromium.base.compat.ApiHelperForO;
import com.ttnet.org.chromium.base.compat.ApiHelperForP;
import com.ttnet.org.chromium.build.BuildConfig;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"NewApi"})
public class NetworkChangeNotifierAutoDetect extends BroadcastReceiver {
    private static final String TAG = "NetworkChangeNotifierAutoDetect";
    private static final int UNKNOWN_LINK_SPEED = -1;
    private ConnectivityManagerDelegate mConnectivityManagerDelegate;
    private ConnectivityManager.NetworkCallback mDefaultNetworkCallback;
    private final Handler mHandler;
    private boolean mIgnoreNextBroadcast;
    private final NetworkConnectivityIntentFilter mIntentFilter;
    private final Looper mLooper;
    private MyNetworkCallback mNetworkCallback;
    private NetworkRequest mNetworkRequest;
    private NetworkState mNetworkState;
    private final Observer mObserver;
    private boolean mRegisterNetworkCallbackFailed;
    private boolean mRegistered;
    private final RegistrationPolicy mRegistrationPolicy;
    private boolean mShouldSignalObserver;
    private WifiManagerDelegate mWifiManagerDelegate;

    @RequiresApi(28)
    public class AndroidRDefaultNetworkCallback extends ConnectivityManager.NetworkCallback {
        LinkProperties mLinkProperties;
        NetworkCapabilities mNetworkCapabilities;
        final /* synthetic */ NetworkChangeNotifierAutoDetect this$0;

        private AndroidRDefaultNetworkCallback(NetworkChangeNotifierAutoDetect r1) {
            this.this$0 = r1;
        }

        private NetworkState getNetworkState(Network r13) {
            int r2 = -1;
            if (this.mNetworkCapabilities.hasTransport(1) == false) goto L5;
        L28:
            int r5 = 1;
        L17:
            int r6 = -1;
        L30:
            return new NetworkState(true, r5, r6, !this.mNetworkCapabilities.hasCapability(11), String.valueOf(NetworkChangeNotifierAutoDetect.networkToNetId(r13)), null, ApiHelperForP.isPrivateDnsActive(this.mLinkProperties), ApiHelperForP.getPrivateDnsServerName(this.mLinkProperties));
        L5:
            if (this.mNetworkCapabilities.hasTransport(5) == true) goto L28;
            if (this.mNetworkCapabilities.hasTransport(0) == false) goto L14;
            NetworkInfo r0 = NetworkChangeNotifierAutoDetect.access$600(this.this$0).getRawNetworkInfo(r13);
            if (r0 == null) goto L12;
            r2 = r0.getSubtype();
        L12:
            r6 = r2;
            r5 = 0;
            goto L30
        L14:
            if (this.mNetworkCapabilities.hasTransport(3) == false) goto L19;
            int r1 = 9;
        L16:
            r5 = r1;
            goto L17
        L19:
            if (this.mNetworkCapabilities.hasTransport(2) == false) goto L22;
            r1 = 7;
            goto L16
        L22:
            if (this.mNetworkCapabilities.hasTransport(4) == false) goto L27;
            NetworkInfo r3 = NetworkChangeNotifierAutoDetect.access$600(this.this$0).getNetworkInfo(r13);
            if (r3 == null) goto L26;
            r1 = r3.getType();
            goto L16
        L26:
            r1 = 17;
            goto L16
        L27:
            r5 = -1;
            r6 = -1;
            goto L30
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network r1) {
            this.mLinkProperties = null;
            this.mNetworkCapabilities = null;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network r1, NetworkCapabilities r2) {
            this.mNetworkCapabilities = r2;
            if (NetworkChangeNotifierAutoDetect.access$300(this.this$0) == true) goto L5;
            return;
        L5:
            if (this.mLinkProperties != null) goto L7;
            return;
        L7:
            if (this.mNetworkCapabilities == null) goto L12;
            NetworkChangeNotifierAutoDetect.access$500(this.this$0, getNetworkState(r1));
            return;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(Network r1, LinkProperties r2) {
            this.mLinkProperties = r2;
            if (NetworkChangeNotifierAutoDetect.access$300(this.this$0) == true) goto L5;
            return;
        L5:
            if (this.mLinkProperties != null) goto L7;
            return;
        L7:
            if (this.mNetworkCapabilities == null) goto L12;
            NetworkChangeNotifierAutoDetect.access$500(this.this$0, getNetworkState(r1));
            return;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network r10) {
            this.mLinkProperties = null;
            this.mNetworkCapabilities = null;
            if (NetworkChangeNotifierAutoDetect.access$300(this.this$0) == false) goto L6;
            NetworkChangeNotifierAutoDetect.access$500(this.this$0, new NetworkState(false, -1, -1, false, null, null, false, ""));
            return;
        }

        public /* synthetic */ AndroidRDefaultNetworkCallback(NetworkChangeNotifierAutoDetect r1, AnonymousClass1 r2) {
            this(r1);
        }
    }

    public static class ConnectivityManagerDelegate {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final ConnectivityManager mConnectivityManager;

        public ConnectivityManagerDelegate(Context r2) {
            this.mConnectivityManager = (ConnectivityManager) r2.getSystemService("connectivity");
        }

        private NetworkInfo processActiveNetworkInfo(NetworkInfo r3) {
            if (r3 != null) goto L6;
            return null;
        L6:
            if (r3.isConnected() == false) goto L9;
            return r3;
        L9:
            if (r3.getDetailedState() == NetworkInfo.DetailedState.BLOCKED) goto L12;
            return null;
        L12:
            if (ApplicationStatus.getStateForApplication() == 1) goto L14;
            return null;
        L14:
            return r3;
        }

        @VisibleForTesting
        public Network[] getAllNetworksUnfiltered() {
            Network[] r0 = this.mConnectivityManager.getAllNetworks();     // Catch: Throwable -> L4
        L5:
            if (r0 == null) goto L7;
            return r0;
        L7:
            return new Network[0];
        L4:
            r0 = null;
            goto L5
        }

        public int getConnectionType(Network r1) {
            NetworkInfo r0 = getNetworkInfo(r1);
            if (r0 != null) goto L5;
            return 6;
        L5:
            if (r0.isConnected() == true) goto L7;
            return 6;
        L7:
            return NetworkChangeNotifierAutoDetect.access$000(r0.getType(), r0.getSubtype());
        }

        public Network getDefaultNetwork() {
            Network r1 = ApiHelperForM.getActiveNetwork(this.mConnectivityManager);     // Catch: Throwable -> L5
        L6:
            if (r1 == null) goto L34;
            return r1;
        L34:
            NetworkInfo r2 = this.mConnectivityManager.getActiveNetworkInfo();     // Catch: Throwable -> L33
            if (r2 != null) goto L11;
            return null;
        L11:
            Network[] r3 = NetworkChangeNotifierAutoDetect.access$100(this, null);
            int r4 = r3.length;
            int r6 = 0;
        L12:
            if (r6 >= r4) goto L32;
            Network r7 = r3[r6];
            NetworkInfo r8 = getRawNetworkInfo(r7);
            if (r8 == null) goto L31;
            if (r8.getType() != r2.getType()) goto L18;
        L19:
            if (r1 == null) goto L28;
            NetworkInfo.DetailedState r9 = r8.getDetailedState();
            NetworkInfo.DetailedState r10 = NetworkInfo.DetailedState.CONNECTING;
            if (r9 == r10) goto L31;
            NetworkInfo r11 = getRawNetworkInfo(r1);
            if (r11 == null) goto L28;
            if (r11.getDetailedState() != r10) goto L28;
            r1 = null;
        L28:
            if (r1 == null) goto L30;
            Log.e(NetworkChangeNotifierAutoDetect.access$200(), "defaultNetwork != null", new Object[0]);
        L30:
            r1 = r7;
            goto L31
        L18:
            if (r8.getType() == 17) goto L19;
        L31:
            r6 = r6 + 1;
            goto L12
        L32:
            return r1;
        L33:
            return null;
        L5:
            r1 = null;
            goto L6
        }

        @VisibleForTesting
        public NetworkCapabilities getNetworkCapabilities(Network r3) {
            int r0 = 0;
        L4:
            if (r0 >= 2) goto L8;
            return this.mConnectivityManager.getNetworkCapabilities(r3);
        L7:
            r0 = r0 + 1;
            goto L4
        L8:
            return null;
        }

        public NetworkInfo getNetworkInfo(Network r3) {
            NetworkInfo r4 = getRawNetworkInfo(r3);
            if (r4 != null) goto L5;
            return r4;
        L5:
            if (r4.getType() != 17) goto L13;
            return this.mConnectivityManager.getActiveNetworkInfo();
        L8:
            return null;
        L13:
            return r4;
        }

        public NetworkState getNetworkState(WifiManagerDelegate r23) {
            NetworkInfo r1 = null;
            Network r2 = getDefaultNetwork();     // Catch: Throwable -> L11
            NetworkInfo r3 = getNetworkInfo(r2);     // Catch: Throwable -> L36
            if (r3 != null) goto L7;
        L10:
            r1 = r3;
            goto L12
        L7:
            if (r3.getType() != 17) goto L10;
            r1 = this.mConnectivityManager.getActiveNetworkInfo();     // Catch: Throwable -> L36
        L12:
            NetworkInfo r4 = processActiveNetworkInfo(r1);
            if (r4 == null) goto L15;
            if (r2 == null) goto L34;
            NetworkCapabilities r0 = getNetworkCapabilities(r2);
            int r5 = 0;
            if (r0 != null) goto L20;
        L22:
            boolean r8 = false;
        L23:
            DnsStatus r6 = AndroidNetworkLibrary.getDnsStatus(r2);
            if (r6 == null) goto L26;
            ArrayList r10 = new ArrayList();
            byte[][] r7 = r6.getDnsServers();     // Catch: UnknownHostException -> L37
            int r9 = r7.length;     // Catch: UnknownHostException -> L37
        L29:
            if (r5 >= r9) goto L33;
            r10.add(InetAddress.getByAddress(r7[r5]));     // Catch: UnknownHostException -> L37
            r5 = r5 + 1;
        L33:
            return new NetworkState(true, r4.getType(), r4.getSubtype(), r8, String.valueOf(NetworkChangeNotifierAutoDetect.networkToNetId(r2)), r10, r6.getPrivateDnsActive(), r6.getPrivateDnsServerName());
        L26:
            return new NetworkState(true, r4.getType(), r4.getSubtype(), r8, String.valueOf(NetworkChangeNotifierAutoDetect.networkToNetId(r2)), null, false, "");
        L20:
            if (r0.hasCapability(11) == true) goto L22;
            r8 = true;
            goto L23
        L34:
            r4.getType();
            return new NetworkState(true, r4.getType(), r4.getSubtype(), false, null, null, false, "");
        L15:
            return new NetworkState(false, -1, -1, false, null, null, false, "");
        L11:
            r2 = null;
            goto L12
        }

        public NetworkInfo getRawNetworkInfo(Network r2) {
            return this.mConnectivityManager.getNetworkInfo(r2);
        L4:
            return this.mConnectivityManager.getNetworkInfo(r2);
        L6:
            return null;
        }

        @RequiresApi(28)
        public void registerDefaultNetworkCallback(ConnectivityManager.NetworkCallback r1, Handler r2) {
            ApiHelperForO.registerDefaultNetworkCallback(this.mConnectivityManager, r1, r2);     // Catch: Throwable -> L4
            return;
        }

        public void registerNetworkCallback(NetworkRequest r1, ConnectivityManager.NetworkCallback r2, Handler r3) {
            ApiHelperForO.registerNetworkCallback(this.mConnectivityManager, r1, r2, r3);     // Catch: Throwable -> L4
            return;
        }

        public void unregisterNetworkCallback(ConnectivityManager.NetworkCallback r1) {
            this.mConnectivityManager.unregisterNetworkCallback(r1);     // Catch: Throwable -> L4
            return;
        }

        @VisibleForTesting
        public boolean vpnAccessible(Network r2) {
            Socket r1 = new Socket();
            StrictModeContext r0 = StrictModeContext.allowAllVmPolicies();     // Catch: Throwable -> L8 IOException -> L22
            r2.bindSocket(r1);     // Catch: Throwable -> L13
            if (r0 == null) goto L30;
            r0.close();     // Catch: Throwable -> L8 IOException -> L22
        L30:
            r1.close();     // Catch: IOException -> L25
            return true;
        L38:
            return true;
        L13:
            th = move-exception;
            if (r0 != null) goto L28;
        L19:
            throw th;     // Catch: Throwable -> L8 IOException -> L22
        L28:
            r0.close();     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            th.addSuppressed(th);     // Catch: Throwable -> L8 IOException -> L22
        L22:
            r1.close();     // Catch: IOException -> L27
            return false;
        L8:
            th = move-exception;
            r1.close();     // Catch: IOException -> L26
        L21:
            throw th;
        L39:
            return false;
        }

        public ConnectivityManagerDelegate() {
            this.mConnectivityManager = null;
        }
    }

    public class DefaultNetworkCallback extends ConnectivityManager.NetworkCallback {
        final /* synthetic */ NetworkChangeNotifierAutoDetect this$0;

        private DefaultNetworkCallback(NetworkChangeNotifierAutoDetect r1) {
            this.this$0 = r1;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network r1) {
            if (NetworkChangeNotifierAutoDetect.access$300(this.this$0) == false) goto L6;
            NetworkChangeNotifierAutoDetect.access$400(this.this$0);
            return;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network r1, NetworkCapabilities r2) {
            onAvailable(null);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(Network r1, LinkProperties r2) {
            onAvailable(null);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network r1) {
            onAvailable(null);
        }

        public /* synthetic */ DefaultNetworkCallback(NetworkChangeNotifierAutoDetect r1, AnonymousClass1 r2) {
            this(r1);
        }
    }

    public class MyNetworkCallback extends ConnectivityManager.NetworkCallback {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private Network mVpnInPlace;
        final /* synthetic */ NetworkChangeNotifierAutoDetect this$0;

        private MyNetworkCallback(NetworkChangeNotifierAutoDetect r1) {
            this.this$0 = r1;
        }

        private boolean ignoreConnectedInaccessibleVpn(Network r2, NetworkCapabilities r3) {
            if (r3 != null) goto L4;
            r3 = NetworkChangeNotifierAutoDetect.access$600(this.this$0).getNetworkCapabilities(r2);
        L4:
            if (r3 != null) goto L6;
        L11:
            return true;
        L6:
            if (r3.hasTransport(4) == true) goto L8;
        L10:
            return false;
        L8:
            if (NetworkChangeNotifierAutoDetect.access$600(this.this$0).vpnAccessible(r2) == true) goto L10;
            goto L10
        }

        private boolean ignoreConnectedNetwork(Network r2, NetworkCapabilities r3) {
            if (ignoreNetworkDueToVpn(r2) == false) goto L5;
        L8:
            return true;
        L5:
            if (ignoreConnectedInaccessibleVpn(r2, r3) == true) goto L8;
            return false;
        }

        private boolean ignoreNetworkDueToVpn(Network r1) {
            Network r0 = this.mVpnInPlace;
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.equals(r1) == true) goto L7;
            return true;
        }

        public long getVpnNetId() {
            Network r2 = this.mVpnInPlace;
            if (r2 != null) goto L6;
            return -1;
        L6:
            return NetworkChangeNotifierAutoDetect.networkToNetId(r2);
        }

        public void initializeVpnInPlace() {
            Network[] r0 = NetworkChangeNotifierAutoDetect.access$100(NetworkChangeNotifierAutoDetect.access$600(this.this$0), null);
            this.mVpnInPlace = null;
            if (r0.length != 1) goto L10;
            NetworkCapabilities r1 = NetworkChangeNotifierAutoDetect.access$600(this.this$0).getNetworkCapabilities(r0[0]);
            if (r1 != null) goto L7;
            return;
        L7:
            if (r1.hasTransport(4) == false) goto L12;
            this.mVpnInPlace = r0[0];
            return;
        L12:
            return;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network r9) {
            TraceEvent r0 = TraceEvent.scoped("NetworkChangeNotifierCallback::onAvailable");
            NetworkCapabilities r1 = NetworkChangeNotifierAutoDetect.access$600(this.this$0).getNetworkCapabilities(r9);     // Catch: Throwable -> L18
            if (ignoreConnectedNetwork(r9, r1) == false) goto L8;
            if (r0 == null) goto L38;
            r0.close();
            return;
        L38:
            return;
        L8:
            boolean r2 = false;
            if (r1 != null) goto L12;
        L21:
            final boolean r6 = r2;
            if (r6 == false) goto L24;
            this.mVpnInPlace = r9;     // Catch: Throwable -> L18
        L24:
            final long r3 = NetworkChangeNotifierAutoDetect.networkToNetId(r9);     // Catch: Throwable -> L18
            final int r5 = NetworkChangeNotifierAutoDetect.access$600(this.this$0).getConnectionType(r9);     // Catch: Throwable -> L18
            this.this$0.runOnThread(new AnonymousClass1(this, r3, r5, r6));     // Catch: Throwable -> L18
            if (r0 == null) goto L39;
            r0.close();
            return;
        L39:
            return;
        L12:
            if (r1.hasTransport(4) == false) goto L21;
            Network r4 = this.mVpnInPlace;     // Catch: Throwable -> L18
            if (r4 != null) goto L16;
        L20:
            r2 = true;
            goto L21
        L16:
            if (r9.equals(r4) == true) goto L21;
        L18:
            th = move-exception;
            if (r0 != null) goto L36;
        L33:
            throw th;
        L36:
            r0.close();     // Catch: Throwable -> L31
        L31:
            th = move-exception;
            th.addSuppressed(th);
            goto L33
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network r8, NetworkCapabilities r9) {
            TraceEvent r0 = TraceEvent.scoped("NetworkChangeNotifierCallback::onCapabilitiesChanged");
        L14:
            th = move-exception;
            if (r0 != null) goto L27;
        L26:
            throw th;
        L27:
            r0.close();     // Catch: Throwable -> L24
        L24:
            th = move-exception;
            th.addSuppressed(th);
            goto L26
        L4:
            if (ignoreConnectedNetwork(r8, r9) == false) goto L8;
            if (r0 == null) goto L31;
            r0.close();
            return;
        L31:
            return;
        L8:
            final long r3 = NetworkChangeNotifierAutoDetect.networkToNetId(r8);     // Catch: Throwable -> L14
            final int r5 = NetworkChangeNotifierAutoDetect.access$600(this.this$0).getConnectionType(r8);     // Catch: Throwable -> L14
            Network r10 = this.mVpnInPlace;     // Catch: Throwable -> L14
            if (r10 != null) goto L11;
        L16:
            boolean r11 = false;
        L13:
            final boolean r6 = r11;
            this.this$0.runOnThread(new AnonymousClass2(this, r3, r5, r6));     // Catch: Throwable -> L14
            if (r0 == null) goto L32;
            r0.close();
            return;
        L32:
            return;
        L11:
            if (r10.equals(r8) == false) goto L16;
            r11 = true;
            goto L13
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLosing(Network r4, int r5) {
            TraceEvent r6 = TraceEvent.scoped("NetworkChangeNotifierCallback::onLosing");
        L12:
            th = move-exception;
            if (r6 != null) goto L21;
        L18:
            throw th;
        L21:
            r6.close();     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            th.addSuppressed(th);
            goto L18
        L4:
            if (ignoreConnectedNetwork(r4, null) == false) goto L8;
            if (r6 == null) goto L23;
            r6.close();
            return;
        L23:
            return;
        L8:
            final long r0 = NetworkChangeNotifierAutoDetect.networkToNetId(r4);     // Catch: Throwable -> L12
            this.this$0.runOnThread(new AnonymousClass3(this, r0));     // Catch: Throwable -> L12
            if (r6 == null) goto L24;
            r6.close();
            return;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(final Network r6) {
            TraceEvent r0 = TraceEvent.scoped("NetworkChangeNotifierCallback::onLost");
        L13:
            th = move-exception;
            if (r0 != null) goto L31;
        L30:
            throw th;
        L31:
            r0.close();     // Catch: Throwable -> L28
        L28:
            th = move-exception;
            th.addSuppressed(th);
            goto L30
        L4:
            if (ignoreNetworkDueToVpn(r6) == false) goto L8;
            if (r0 == null) goto L36;
            r0.close();
            return;
        L36:
            return;
        L8:
            Network r1 = this.mVpnInPlace;     // Catch: Throwable -> L13
            int r2 = 0;
            if (r1 != null) goto L11;
        L15:
            final boolean r3 = false;
        L16:
            this.this$0.runOnThread(new AnonymousClass4(this, r6, r3));     // Catch: Throwable -> L13
            if (this.mVpnInPlace == null) goto L22;
            this.mVpnInPlace = null;     // Catch: Throwable -> L13
            Network[] r7 = NetworkChangeNotifierAutoDetect.access$100(NetworkChangeNotifierAutoDetect.access$600(this.this$0), r6);     // Catch: Throwable -> L13
            int r4 = r7.length;     // Catch: Throwable -> L13
        L19:
            if (r2 >= r4) goto L21;
            onAvailable(r7[r2]);     // Catch: Throwable -> L13
            r2 = r2 + 1;     // Catch: Throwable -> L13
            goto L19
        L21:
            final int r8 = this.this$0.getCurrentNetworkState().getConnectionType();     // Catch: Throwable -> L13
            this.this$0.runOnThread(new AnonymousClass5(this, r8));     // Catch: Throwable -> L13
        L22:
            if (r0 == null) goto L37;
            r0.close();
            return;
        L37:
            return;
        L11:
            if (r1.equals(r6) == false) goto L15;
            r3 = true;
            goto L16
        }

        public /* synthetic */ MyNetworkCallback(NetworkChangeNotifierAutoDetect r1, AnonymousClass1 r2) {
            this(r1);
        }
    }

    public static class NetworkConnectivityIntentFilter extends IntentFilter {
        public NetworkConnectivityIntentFilter() {
            addAction("android.net.conn.CONNECTIVITY_CHANGE");
        }
    }

    public static class NetworkState {
        private final boolean mConnected;
        private final List<InetAddress> mDnsServers;
        private final boolean mIsMetered;
        private final boolean mIsPrivateDnsActive;
        private final String mNetworkIdentifier;
        private final String mPrivateDnsServerName;
        private final int mSubtype;
        private final int mType;

        public NetworkState(boolean r1, int r2, int r3, boolean r4, String r5, List<InetAddress> r6, boolean r7, String r8) {
            this.mConnected = r1;
            this.mType = r2;
            this.mSubtype = r3;
            this.mIsMetered = r4;
            if (r5 != null) goto L5;
            r5 = "";
        L5:
            this.mNetworkIdentifier = r5;
            if (r6 != null) goto L8;
            r6 = new ArrayList();
        L8:
            this.mDnsServers = r6;
            this.mIsPrivateDnsActive = r7;
            if (r8 != null) goto L11;
            r8 = "";
        L11:
            this.mPrivateDnsServerName = r8;
        }

        public int getConnectionCost() {
            if (isMetered() == false) goto L6;
            return 2;
        L6:
            return 1;
        }

        public int getConnectionSubtype() {
            if (isConnected() == true) goto L6;
            return 1;
        L6:
            int r0 = getNetworkType();
            if (r0 == 0) goto L12;
            if (r0 == 4) goto L12;
            if (r0 == 5) goto L12;
            return 0;
        L12:
            switch(getNetworkSubType()) {
                case 1: goto L40;
                case 2: goto L38;
                case 3: goto L36;
                case 4: goto L35;
                case 5: goto L33;
                case 6: goto L31;
                case 7: goto L29;
                case 8: goto L27;
                case 9: goto L25;
                case 10: goto L23;
                case 11: goto L22;
                case 12: goto L20;
                case 13: goto L18;
                case 14: goto L16;
                case 15: goto L14;
                default: goto L13;
            };
        L13:
            return 0;
        L14:
            return 17;
        L16:
            return 16;
        L18:
            return 18;
        L20:
            return 13;
        L22:
            return 4;
        L23:
            return 12;
        L25:
            return 15;
        L27:
            return 14;
        L29:
            return 6;
        L31:
            return 11;
        L33:
            return 10;
        L35:
            return 5;
        L36:
            return 9;
        L38:
            return 8;
        L40:
            return 7;
        }

        public int getConnectionType() {
            if (isConnected() == true) goto L7;
            return 6;
        L7:
            return NetworkChangeNotifierAutoDetect.access$000(getNetworkType(), getNetworkSubType());
        }

        public List<InetAddress> getDnsServers() {
            return this.mDnsServers;
        }

        public String getNetworkIdentifier() {
            return this.mNetworkIdentifier;
        }

        public int getNetworkSubType() {
            return this.mSubtype;
        }

        public int getNetworkType() {
            return this.mType;
        }

        public String getPrivateDnsServerName() {
            return this.mPrivateDnsServerName;
        }

        public boolean isConnected() {
            return this.mConnected;
        }

        public boolean isMetered() {
            return this.mIsMetered;
        }

        public boolean isPrivateDnsActive() {
            return this.mIsPrivateDnsActive;
        }
    }

    public interface Observer {
        void onConnectionCostChanged(int r1);

        void onConnectionSubtypeChanged(int r1);

        void onConnectionTypeChanged(int r1);

        void onNetworkConnect(long r1, int r3, boolean r4);

        void onNetworkDisconnect(long r1, boolean r3);

        void onNetworkSoonToDisconnect(long r1);

        void purgeActiveNetworkList(long[] r1);
    }

    public static abstract class RegistrationPolicy {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private NetworkChangeNotifierAutoDetect mNotifier;

        public RegistrationPolicy() {
        }

        public abstract void destroy();

        public void init(NetworkChangeNotifierAutoDetect r1) {
            this.mNotifier = r1;
        }

        public final void register() {
            this.mNotifier.register();
        }

        public final void unregister() {
            this.mNotifier.unregister();
        }
    }

    public static class WifiManagerDelegate {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final Context mContext;

        @GuardedBy
        private boolean mHasWifiPermission;

        @GuardedBy
        private boolean mHasWifiPermissionComputed;
        private final Object mLock;

        @GuardedBy
        private WifiManager mWifiManager;

        public WifiManagerDelegate(Context r2) {
            this.mLock = new Object();
            this.mContext = r2;
        }

        @GuardedBy
        private WifiInfo getWifiInfoLocked() {
            return this.mWifiManager.getConnectionInfo();
        L4:
            return this.mWifiManager.getConnectionInfo();
        L6:
            return null;
        }

        @GuardedBy
        @SuppressLint({"WifiManagerPotentialLeak"})
        private boolean hasPermissionLocked() {
            if (this.mHasWifiPermissionComputed == false) goto L7;
            return this.mHasWifiPermission;
        L7:
            if (this.mContext.getPackageManager().checkPermission("android.permission.ACCESS_WIFI_STATE", this.mContext.getPackageName()) != 0) goto L9;
            boolean r0 = true;
        L10:
            this.mHasWifiPermission = r0;
            if (r0 == false) goto L13;
            WifiManager r1 = (WifiManager) this.mContext.getSystemService("wifi");
        L14:
            this.mWifiManager = r1;
            this.mHasWifiPermissionComputed = true;
            return this.mHasWifiPermission;
        L13:
            r1 = null;
            goto L14
        L9:
            r0 = false;
            goto L10
        }

        public String getWifiSsid() {
            return "";
        }

        public WifiManagerDelegate() {
            this.mLock = new Object();
            this.mContext = null;
        }
    }

    public NetworkChangeNotifierAutoDetect(Observer r3, RegistrationPolicy r4) {
        Looper r0 = Looper.myLooper();
        this.mLooper = r0;
        this.mHandler = new Handler(r0);
        this.mObserver = r3;
        this.mConnectivityManagerDelegate = new ConnectivityManagerDelegate(ContextUtils.getApplicationContext());
        AnonymousClass1 r1 = null;
        this.mNetworkCallback = new MyNetworkCallback(this, r1);
        this.mNetworkRequest = new NetworkRequest.Builder().addCapability(12).removeCapability(15).build();
        this.mDefaultNetworkCallback = new AndroidRDefaultNetworkCallback(this, r1);
        this.mNetworkState = getCurrentNetworkState();
        this.mIntentFilter = new NetworkConnectivityIntentFilter();
        this.mIgnoreNextBroadcast = false;
        this.mShouldSignalObserver = false;
        this.mRegistrationPolicy = r4;
        r4.init(this);
        this.mShouldSignalObserver = true;
    }

    public static /* synthetic */ void a(NetworkChangeNotifierAutoDetect r0, Runnable r1) {
        r0.lambda$runOnThread$0(r1);
    }

    public static /* synthetic */ int access$000(int r0, int r1) {
        return convertToConnectionType(r0, r1);
    }

    public static /* synthetic */ Network[] access$100(ConnectivityManagerDelegate r0, Network r1) {
        return getAllNetworksFiltered(r0, r1);
    }

    public static /* synthetic */ boolean access$1100(NetworkChangeNotifierAutoDetect r0) {
        return r0.mIgnoreNextBroadcast;
    }

    public static /* synthetic */ boolean access$1102(NetworkChangeNotifierAutoDetect r0, boolean r1) {
        r0.mIgnoreNextBroadcast = r1;
        return r1;
    }

    public static /* synthetic */ String access$200() {
        return TAG;
    }

    public static /* synthetic */ boolean access$300(NetworkChangeNotifierAutoDetect r0) {
        return r0.mRegistered;
    }

    public static /* synthetic */ void access$400(NetworkChangeNotifierAutoDetect r0) {
        r0.connectionTypeChanged();
    }

    public static /* synthetic */ void access$500(NetworkChangeNotifierAutoDetect r0, NetworkState r1) {
        r0.connectionTypeChangedTo(r1);
    }

    public static /* synthetic */ ConnectivityManagerDelegate access$600(NetworkChangeNotifierAutoDetect r0) {
        return r0.mConnectivityManagerDelegate;
    }

    public static /* synthetic */ Observer access$700(NetworkChangeNotifierAutoDetect r0) {
        return r0.mObserver;
    }

    private void assertOnThread() {
        if (BuildConfig.ENABLE_ASSERTS == true) goto L5;
        return;
    L5:
        if (onThread() == false) goto L8;
        return;
    L8:
        throw new IllegalStateException("Must be called on NetworkChangeNotifierAutoDetect thread.");
    }

    private void connectionTypeChanged() {
        connectionTypeChangedTo(getCurrentNetworkState());
    }

    private void connectionTypeChangedTo(NetworkState r3) {
        if (r3.getConnectionType() == this.mNetworkState.getConnectionType()) goto L5;
    L12:
        this.mObserver.onConnectionTypeChanged(r3.getConnectionType());
    L14:
        if (r3.getConnectionType() == this.mNetworkState.getConnectionType()) goto L16;
    L17:
        this.mObserver.onConnectionSubtypeChanged(r3.getConnectionSubtype());
    L19:
        if (r3.getConnectionCost() == this.mNetworkState.getConnectionCost()) goto L21;
        this.mObserver.onConnectionCostChanged(r3.getConnectionCost());
    L21:
        this.mNetworkState = r3;
        return;
    L16:
        if (r3.getConnectionSubtype() == this.mNetworkState.getConnectionSubtype()) goto L19;
    L5:
        if (r3.getNetworkIdentifier().equals(this.mNetworkState.getNetworkIdentifier()) == false) goto L12;
        if (r3.getDnsServers().equals(this.mNetworkState.getDnsServers()) == false) goto L12;
        if (r3.isPrivateDnsActive() != this.mNetworkState.isPrivateDnsActive()) goto L12;
        if (r3.getPrivateDnsServerName().equals(this.mNetworkState.getPrivateDnsServerName()) == true) goto L14;
        goto L12
    }

    private static int convertToConnectionType(int r4, int r5) {
        if (r4 == 0) goto L21;
        if (r4 == 1) goto L18;
        if (r4 == 4) goto L21;
        if (r4 == 5) goto L21;
        if (r4 != 6) goto L11;
        return 5;
    L11:
        if (r4 != 7) goto L13;
        return 7;
    L13:
        if (r4 == 9) goto L15;
        return 0;
    L15:
        return 1;
    L18:
        return 2;
    L21:
        if (r5 == 20) goto L28;
        switch(r5) {
            case 1: goto L26;
            case 2: goto L26;
            case 3: goto L25;
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L25;
            case 7: goto L26;
            case 8: goto L25;
            case 9: goto L25;
            case 10: goto L25;
            case 11: goto L26;
            case 12: goto L25;
            case 13: goto L24;
            case 14: goto L25;
            case 15: goto L25;
            default: goto L23;
        };
    L23:
        return 0;
    L24:
        return 5;
    L25:
        return 4;
    L26:
        return 3;
    L28:
        return 8;
    }

    private static Network[] getAllNetworksFiltered(ConnectivityManagerDelegate r7, Network r8) {
        Network[] r0 = r7.getAllNetworksUnfiltered();
        int r1 = r0.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r1) goto L24;
        Network r4 = r0[r2];
        if (r4 == null) goto L22;
        if (r4.equals(r8) == true) goto L22;
        NetworkCapabilities r5 = r7.getNetworkCapabilities(r4);
        if (r5 == null) goto L22;
        if (r5.hasCapability(12) == false) goto L22;
        if (r5.hasTransport(4) == true) goto L18;
        r0[r3] = r4;
        r3 = r3 + 1;
        goto L22
    L18:
        if (r7.vpnAccessible(r4) == false) goto L22;
        return new Network[]{r4};
    L22:
        r2 = r2 + 1;
        goto L3
    L24:
        return (Network[]) Arrays.copyOf(r0, r3);
    }

    private /* synthetic */ void lambda$runOnThread$0(Runnable r1) {
        if (this.mRegistered == false) goto L6;
        r1.run();
        return;
    }

    public static long networkToNetId(Network r2) {
        return ApiHelperForM.getNetworkHandle(r2);
    }

    private boolean onThread() {
        if (this.mLooper != Looper.myLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    public void destroy() {
        assertOnThread();
        this.mRegistrationPolicy.destroy();
        unregister();
    }

    public NetworkState getCurrentNetworkState() {
        return this.mConnectivityManagerDelegate.getNetworkState(this.mWifiManagerDelegate);
    }

    public long getDefaultNetId() {
        Network r2 = this.mConnectivityManagerDelegate.getDefaultNetwork();
        if (r2 != null) goto L6;
        return -1;
    L6:
        return networkToNetId(r2);
    }

    public long[] getNetworksAndTypes() {
        Network[] r0 = getAllNetworksFiltered(this.mConnectivityManagerDelegate, null);
        long[] r1 = new long[r0.length * 2];
        int r2 = r0.length;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r3 >= r2) goto L5;
        Network r5 = r0[r3];
        int r6 = r4 + 1;
        r1[r4] = networkToNetId(r5);
        r4 = r4 + 2;
        r1[r6] = this.mConnectivityManagerDelegate.getConnectionType(r5);
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }

    @VisibleForTesting
    public RegistrationPolicy getRegistrationPolicy() {
        return this.mRegistrationPolicy;
    }

    public long getVpnNetId() {
        MyNetworkCallback r2 = this.mNetworkCallback;
        if (r2 != null) goto L6;
        return -1;
    L6:
        return r2.getVpnNetId();
    }

    @VisibleForTesting
    public boolean isReceiverRegisteredForTesting() {
        return this.mRegistered;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r1, Intent r2) {
        runOnThread(new AnonymousClass1(this));
    }

    public void register() {
        assertOnThread();
        if (this.mRegistered == false) goto L7;
        connectionTypeChanged();
        return;
    L7:
        if (this.mShouldSignalObserver == false) goto L9;
        connectionTypeChanged();
    L9:
        ConnectivityManager.NetworkCallback r0 = this.mDefaultNetworkCallback;
        if (r0 != null) goto L41;
    L14:
        int r2 = 0;
        if (this.mDefaultNetworkCallback == null) goto L43;
    L23:
        this.mRegistered = true;
        MyNetworkCallback r1 = this.mNetworkCallback;
        if (r1 == null) goto L46;
        r1.initializeVpnInPlace();
        this.mConnectivityManagerDelegate.registerNetworkCallback(this.mNetworkRequest, this.mNetworkCallback, this.mHandler);     // Catch: RuntimeException -> L28
    L30:
        if (this.mRegisterNetworkCallbackFailed == false) goto L32;
        return;
    L32:
        if (this.mShouldSignalObserver == false) goto L48;
        Network[] r3 = getAllNetworksFiltered(this.mConnectivityManagerDelegate, null);
        long[] r4 = new long[r3.length];
    L35:
        if (r2 >= r3.length) goto L37;
        r4[r2] = networkToNetId(r3[r2]);
        r2 = r2 + 1;
        goto L35
    L37:
        this.mObserver.purgeActiveNetworkList(r4);
        return;
    L48:
        return;
    L28:
        this.mRegisterNetworkCallbackFailed = true;
        this.mNetworkCallback = null;
        goto L30
    L46:
        return;
    L43:
    L22:
        this.mIgnoreNextBroadcast = false;
        goto L23
    L17:
        if (ContextUtils.getApplicationContext().registerReceiver(this, this.mIntentFilter) == null) goto L19;
        boolean r5 = true;
    L20:
        this.mIgnoreNextBroadcast = r5;     // Catch: RuntimeException -> L22
        goto L23
    L19:
        r5 = false;
        goto L20
    L41:
        this.mConnectivityManagerDelegate.registerDefaultNetworkCallback(r0, this.mHandler);     // Catch: RuntimeException -> L13
    L13:
        this.mDefaultNetworkCallback = null;
        goto L14
    }

    public boolean registerNetworkCallbackFailed() {
        return this.mRegisterNetworkCallbackFailed;
    }

    public void runOnThread(Runnable r4) {
        if (onThread() == false) goto L5;
        r4.run();
        return;
    L5:
        this.mHandler.post(new a(1, this, r4));
    }

    public void setConnectivityManagerDelegateForTests(ConnectivityManagerDelegate r1) {
        this.mConnectivityManagerDelegate = r1;
    }

    public void setWifiManagerDelegateForTests(WifiManagerDelegate r1) {
        this.mWifiManagerDelegate = r1;
    }

    public void unregister() {
        assertOnThread();
        if (this.mRegistered == true) goto L5;
        return;
    L5:
        this.mRegistered = false;
        MyNetworkCallback r0 = this.mNetworkCallback;
        if (r0 == null) goto L8;
        this.mConnectivityManagerDelegate.unregisterNetworkCallback(r0);
    L8:
        ConnectivityManager.NetworkCallback r1 = this.mDefaultNetworkCallback;
        if (r1 == null) goto L11;
        this.mConnectivityManagerDelegate.unregisterNetworkCallback(r1);
        return;
    L11:
        ContextUtils.getApplicationContext().unregisterReceiver(this);
    }
}
