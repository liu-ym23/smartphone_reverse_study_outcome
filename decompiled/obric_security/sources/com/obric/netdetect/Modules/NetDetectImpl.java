package com.obric.netdetect.Modules;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.AsyncTask;
import android.os.Message;
import com.obric.netdetect.API.Callback.DnsResolverCallback;
import com.obric.netdetect.API.Callback.HttpProbeCallback;
import com.obric.netdetect.API.Callback.IpProbeCallback;
import com.obric.netdetect.API.Callback.NetworkInfoCallback;
import com.obric.netdetect.API.Callback.NetworkQualityCallback;
import com.obric.netdetect.API.Callback.PingCallback;
import com.obric.netdetect.API.NetDetectConfig;
import com.obric.netdetect.Modules.DnsProbe.DnsResolverResult;
import com.obric.netdetect.Modules.DnsProbe.DnsResolverTask;
import com.obric.netdetect.Modules.HttpProbe.HttpProbeResult;
import com.obric.netdetect.Modules.HttpProbe.HttpProbeTask;
import com.obric.netdetect.Modules.IpProbe.IpProbeResult;
import com.obric.netdetect.Modules.IpProbe.IpProbeTask;
import com.obric.netdetect.Modules.NetworkInfo.NetworkInfoResult;
import com.obric.netdetect.Modules.NetworkInfo.NetworkInfoTask;
import com.obric.netdetect.Modules.NetworkQuality.NetworkQualityResult;
import com.obric.netdetect.Modules.NetworkQuality.NetworkQualityTask;
import com.obric.netdetect.Modules.PingProbe.PingProbeTask;
import com.obric.netdetect.Modules.PingProbe.PingResult;
import com.obric.netdetect.Utils.CodeConverter;
import com.obric.netdetect.Utils.NetDetectLog;
import com.obric.netdetect.Utils.NetworkUtils;
import java.net.InetAddress;

/* JADX INFO: loaded from: classes3.dex */
public class NetDetectImpl {
    private static final String TAG = "NetDetectImpl";
    private ConnectivityManager mConnectivityManager;
    private Context mContext;
    private Network mMobileNetwork;
    private NetDetectConfig mNetDetectConfig;
    private ConnectivityManager.NetworkCallback mNetworkCallback;
    private NetworkRequest mNetworkRequest;
    private NetworkUtils mNetworkUtils;
    private Network mWifiNetwork;

    static /* synthetic */ void access$000(NetDetectImpl r0, Network r1, boolean r2) {
        r0.updateNetwork(r1, r2);
    }

    public NetDetectImpl(Context r3, NetDetectConfig r4) {
        this.mNetworkRequest = new NetworkRequest.Builder().addCapability(12).build();
        this.mNetworkCallback = new AnonymousClass1(this);
        this.mContext = r3;
        this.mNetDetectConfig = r4;
        ConnectivityManager r5 = (ConnectivityManager) r3.getSystemService("connectivity");
        this.mConnectivityManager = r5;
        r5.registerNetworkCallback(this.mNetworkRequest, this.mNetworkCallback);
        this.mNetworkUtils = new NetworkUtils(this.mConnectivityManager);
        NetDetectLog.setNetDetectLogLevel(this.mNetDetectConfig.logLevel);
    }

    public boolean updateNetDetectConfig(NetDetectConfig r1) {
        this.mNetDetectConfig = r1;
        NetDetectLog.setNetDetectLogLevel(r1.logLevel);
        return true;
    }

    private void handleMessage(Message r11) {
        Network r0 = getNetwork(r11.arg1);
        switch(r11.what) {
            case 1: goto L51;
            case 2: goto L41;
            case 3: goto L26;
            case 4: goto L20;
            case 5: goto L14;
            case 6: goto L5;
            default: goto L79;
        };
    L5:
        IpProbeCallback r1 = (IpProbeCallback) r11.obj;
        if (r1 != null) goto L9;
        NetDetectLog.e(TAG, "ip callback is null.");
        return;
    L9:
        if (r11.arg1 == 1) goto L11;
        NetDetectLog.e(TAG, "detect network not support for ip_conflict_probe. network type: " + CodeConverter.convertNetDetectType(r11.arg1));
        r1.onIpProbeResult(new IpProbeResult(r11.arg1, 1, null, null));
        return;
    L11:
        if (r0 != null) goto L13;
        NetDetectLog.e(TAG, "detect network is not available, network type: " + CodeConverter.convertNetDetectType(r11.arg1));
        r1.onIpProbeResult(new IpProbeResult(r11.arg1, 1, null, null));
        return;
    L13:
        InetAddress r2 = this.mNetworkUtils.getIpv4InetAddress(r0);
        String r3 = this.mNetworkUtils.getIface(r11.arg1);
        NetDetectLog.d(TAG, "start ip probe task, network type: " + CodeConverter.convertNetDetectType(r11.arg1) + " ip: " + r2.getHostAddress());
        new IpProbeTask(r1, this.mNetDetectConfig, r11.arg1, r2.getHostAddress()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{r3});
        return;
    L14:
        NetworkInfoCallback r4 = (NetworkInfoCallback) r11.obj;
        if (r4 != null) goto L17;
        NetDetectLog.e(TAG, "network info callback is null.");
        return;
    L17:
        if (r0 != null) goto L19;
        NetDetectLog.e(TAG, "detect network is not available, network type: " + CodeConverter.convertNetDetectType(r11.arg1));
        r4.onNetworkInfoResult(NetworkInfoResult.failed(r11.arg1, 1));
        return;
    L19:
        NetDetectLog.d(TAG, "start network info task, network type: " + CodeConverter.convertNetDetectType(r11.arg1));
        new NetworkInfoTask(this.mContext, r4, r0).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Integer[]{Integer.valueOf(r11.arg1)});
        return;
    L20:
        NetworkQualityCallback r5 = (NetworkQualityCallback) r11.obj;
        if (r5 != null) goto L23;
        NetDetectLog.e(TAG, "network quality callback is null.");
        return;
    L23:
        if (r0 != null) goto L25;
        NetDetectLog.e(TAG, "detect network is not available, network type: " + CodeConverter.convertNetDetectType(r11.arg1));
        r5.onNetworkQualityResult(NetworkQualityResult.failed(r11.arg1, 1));
        return;
    L25:
        NetDetectLog.d(TAG, "start network quality task, network type: " + CodeConverter.convertNetDetectType(r11.arg1));
        new NetworkQualityTask(this.mContext, r5).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Integer[]{Integer.valueOf(r11.arg1)});
        return;
    L26:
        PingCallback r6 = (PingCallback) r11.obj;
        if (r6 != null) goto L30;
        NetDetectLog.e(TAG, "ping callback is null.");
        return;
    L30:
        if (r11.arg1 == 1) goto L32;
        NetDetectLog.e(TAG, "detect network not support ping. network type: " + CodeConverter.convertNetDetectType(r11.arg1));
        r6.onPingResult(PingResult.failed(r11.arg1, null, 0, -7));
        return;
    L32:
        if (r0 != null) goto L34;
        NetDetectLog.e(TAG, "detect network is not available, network type: " + CodeConverter.convertNetDetectType(r11.arg1));
        r6.onPingResult(PingResult.failed(r11.arg1, null, 0, -6));
        return;
    L34:
        InetAddress r7 = this.mNetworkUtils.getGatewayIpv4InetAddress(r0);
        if (r7 != null) goto L37;
        NetDetectLog.e(TAG, "detect gateway ipv4 is null.");
        r6.onPingResult(PingResult.failed(r11.arg1, null, 0, -8));
        return;
    L37:
        String r8 = r7.getHostAddress();
        if (r8 != null) goto L40;
        NetDetectLog.e(TAG, "detect gateway ipv4str is null.");
        r6.onPingResult(PingResult.failed(r11.arg1, null, 0, -8));
        return;
    L40:
        NetDetectLog.d(TAG, "start ping probe task, gateway ipv4: " + r8 + " timeout: " + this.mNetDetectConfig.pingProbeTimeout + "ms count: " + this.mNetDetectConfig.pingProbeCount);
        new PingProbeTask(r11.arg1, this.mNetDetectConfig, r6).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{r8});
        return;
    L41:
        HttpProbeCallback r9 = (HttpProbeCallback) r11.obj;
        if (r9 != null) goto L44;
        NetDetectLog.e(TAG, "http callback is null");
        return;
    L44:
        if (r0 != null) goto L47;
        NetDetectLog.e(TAG, "detect network is not available, network type: " + CodeConverter.convertNetDetectType(r11.arg1));
        r9.onHttpProbeResult(HttpProbeResult.failed(r11.arg1, null, HttpProbeResult.FAILED_RESPONSE_CODE, 1));
        return;
    L47:
        if (this.mNetDetectConfig.useHttps == false) goto L49;
        String r10 = this.mNetDetectConfig.httpsProbeUrl;
    L50:
        NetDetectLog.d(TAG, "start http/https probe task, use https: " + this.mNetDetectConfig.useHttps + " url: " + r10 + " timeout: " + this.mNetDetectConfig.httpProbeTimeout + "ms");
        new HttpProbeTask(r11.arg1, r0, this.mNetDetectConfig, r9).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{r10});
        return;
    L49:
        r10 = this.mNetDetectConfig.httpProbeUrl;
        goto L50
    L51:
        DnsResolverCallback r12 = (DnsResolverCallback) r11.obj;
        if (r12 != null) goto L54;
        NetDetectLog.e(TAG, "dns callback is null");
        return;
    L54:
        if (r0 != null) goto L56;
        NetDetectLog.e(TAG, "detect network is not available, network type: " + CodeConverter.convertNetDetectType(r11.arg1));
        r12.onDnsResolverResult(DnsResolverResult.failed(r11.arg1, null, 1));
        return;
    L56:
        NetDetectLog.d(TAG, "start dns resolve task, hostname: " + this.mNetDetectConfig.hostUrl + " type: " + this.mNetDetectConfig.dnsType + " timeout: " + this.mNetDetectConfig.dnsResolveTimeout + "ms");
        new DnsResolverTask(r11.arg1, r0, this.mNetDetectConfig, r12).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{this.mNetDetectConfig.hostUrl});
        return;
    }

    public void sendMessageWithParam(int r3, int r4, Object r5) {
        handleMessage(Message.obtain(null, r3, r4, 0, r5));
    }

    private void updateNetwork(Network r4, boolean r5) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (r5 == false) goto L17;
        NetworkInfo r6 = this.mConnectivityManager.getNetworkInfo(r4);
        if (r6 != null) goto L9;
        return;
    L9:
        int r7 = r6.getType();
        if (r7 != 0) goto L12;
        NetDetectLog.d(TAG, "add mobile network, netId: " + r4.toString());
        this.mMobileNetwork = r4;
        return;
    L12:
        if (r7 != 1) goto L27;
        NetDetectLog.d(TAG, "add wifi network, netId: " + r4.toString());
        this.mWifiNetwork = r4;
        return;
    L27:
        return;
    L17:
        if (r4.equals(this.mWifiNetwork) == false) goto L20;
        NetDetectLog.d(TAG, "remove wifi network, netId: " + r4.toString());
        this.mWifiNetwork = null;
        return;
    L20:
        if (r4.equals(this.mMobileNetwork) == false) goto L26;
        NetDetectLog.d(TAG, "remove mobile network, netId: " + r4.toString());
        this.mMobileNetwork = null;
        return;
    }

    private Network getNetwork(int r2) {
        if (r2 == 1) goto L14;
        if (r2 == 2) goto L9;
        return null;
    L9:
        if (this.mMobileNetwork != null) goto L12;
        this.mMobileNetwork = getNetworkForType(0);
    L12:
        return this.mMobileNetwork;
    L14:
        if (this.mWifiNetwork != null) goto L17;
        this.mWifiNetwork = getNetworkForType(1);
    L17:
        return this.mWifiNetwork;
    }

    private Network getNetworkForType(int r7) {
        Network[] r0 = this.mConnectivityManager.getAllNetworks();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L15;
        Network r3 = r0[r2];
        NetworkCapabilities r4 = this.mConnectivityManager.getNetworkCapabilities(r3);
        if (r4 != null) goto L7;
    L9:
        NetworkInfo r5 = this.mConnectivityManager.getNetworkInfo(r3);
        if (r5 == null) goto L14;
        if (r5.getType() != r7) goto L14;
        return r3;
    L14:
        r2 = r2 + 1;
        goto L3
    L7:
        if (r4.hasCapability(4) == false) goto L9;
    L15:
        return null;
    }
}
