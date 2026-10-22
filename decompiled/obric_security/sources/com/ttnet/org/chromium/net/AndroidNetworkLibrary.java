package com.ttnet.org.chromium.net;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.net.RouteInfo;
import android.net.TrafficStats;
import android.net.TransportInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.ttnet.org.chromium.base.ApiCompatibilityUtils;
import com.ttnet.org.chromium.base.CollectionUtil;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.compat.ApiHelperForM;
import com.ttnet.org.chromium.base.compat.ApiHelperForN;
import com.ttnet.org.chromium.base.compat.ApiHelperForP;
import com.ttnet.org.chromium.base.compat.ApiHelperForQ;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketImpl;
import java.net.URLConnection;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import tmsdk.common.ErrorCode;

/* JADX INFO: loaded from: classes3.dex */
@MainDex
class AndroidNetworkLibrary {
    private static final String TAG = "AndroidNetworkLibrary";
    private static Boolean sHaveAccessLocationState;
    private static Boolean sHaveAccessNetworkState;
    private static Boolean sHaveAccessWifiState;

    interface Natives {
        void onCellularAlwaysUp(boolean r1, int r2);
    }

    public static class NetworkSecurityPolicyProxy {
        private static NetworkSecurityPolicyProxy sInstance;

        public NetworkSecurityPolicyProxy() {
        }

        static {
            sInstance = new NetworkSecurityPolicyProxy();
        }

        public static NetworkSecurityPolicyProxy getInstance() {
            return sInstance;
        }

        public static void setInstanceForTesting(NetworkSecurityPolicyProxy r0) {
            sInstance = r0;
        }

        public boolean isCleartextTrafficPermitted(String r1) {
            return ApiHelperForN.isCleartextTrafficPermitted(r1);
        }

        public boolean isCleartextTrafficPermitted() {
            return ApiHelperForM.isCleartextTrafficPermitted();
        }
    }

    private static class SetFileDescriptor {
        private static final Method sFileDescriptorSetInt = null;

        private SetFileDescriptor() {
        }

        static {
            sFileDescriptorSetInt = FileDescriptor.class.getMethod("setInt$", new Class[]{Integer.TYPE});     // Catch: Throwable -> L4
            return;
        L4:
            e = move-exception;
            throw new RuntimeException("Unable to get FileDescriptor.setInt$", e);
        }

        public static FileDescriptor createWithFd(int r5) {
            FileDescriptor r1 = new FileDescriptor();     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L8
            sFileDescriptorSetInt.invoke(r1, new Object[]{Integer.valueOf(r5)});     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L8
            return r1;
        L8:
            e = move-exception;
            throw new RuntimeException("FileDescriptor.setInt$() failed", e);
        L5:
            e = move-exception;
            throw new RuntimeException("FileDescriptor.setInt$() failed", e);
        }
    }

    private static class SocketFd extends Socket {

        private static class SocketImplFd extends SocketImpl {
            @Override // java.net.SocketImpl
            protected void close() {
            }

            @Override // java.net.SocketImpl
            protected void create(boolean r1) {
            }

            SocketImplFd(FileDescriptor r1) {
                this.fd = r1;
            }

            @Override // java.net.SocketImpl
            protected void accept(SocketImpl r1) {
                throw new RuntimeException("accept not implemented");
            }

            @Override // java.net.SocketImpl
            protected int available() {
                throw new RuntimeException("accept not implemented");
            }

            @Override // java.net.SocketImpl
            protected void bind(InetAddress r1, int r2) {
                throw new RuntimeException("accept not implemented");
            }

            @Override // java.net.SocketImpl
            protected void connect(InetAddress r1, int r2) {
                throw new RuntimeException("connect not implemented");
            }

            @Override // java.net.SocketImpl
            protected void connect(SocketAddress r1, int r2) {
                throw new RuntimeException("connect not implemented");
            }

            @Override // java.net.SocketImpl
            protected void connect(String r1, int r2) {
                throw new RuntimeException("connect not implemented");
            }

            @Override // java.net.SocketImpl
            protected InputStream getInputStream() {
                throw new RuntimeException("getInputStream not implemented");
            }

            @Override // java.net.SocketImpl
            protected OutputStream getOutputStream() {
                throw new RuntimeException("getOutputStream not implemented");
            }

            @Override // java.net.SocketImpl
            protected void listen(int r1) {
                throw new RuntimeException("listen not implemented");
            }

            @Override // java.net.SocketImpl
            protected void sendUrgentData(int r1) {
                throw new RuntimeException("sendUrgentData not implemented");
            }

            @Override // java.net.SocketOptions
            public Object getOption(int r1) {
                throw new RuntimeException("getOption not implemented");
            }

            @Override // java.net.SocketOptions
            public void setOption(int r1, Object r2) {
                throw new RuntimeException("setOption not implemented");
            }
        }

        SocketFd(FileDescriptor r2) throws IOException {
            super(new SocketImplFd(r2));
        }
    }

    public static String getWifiSSID() {
        return "";
    }

    AndroidNetworkLibrary() {
    }

    public static String getMimeTypeFromExtension(String r2) {
        return URLConnection.guessContentTypeFromName("foo." + r2);
    }

    public static boolean haveOnlyLoopbackAddresses() {
        Enumeration<NetworkInterface> r1 = NetworkInterface.getNetworkInterfaces();     // Catch: Exception -> L16
        if (r1 != null) goto L7;
        return false;
    L7:
        if (r1.hasMoreElements() == false) goto L14;
        NetworkInterface r2 = r1.nextElement();
        if (r2.isUp() == false) goto L7;
        if (r2.isLoopback() == true) goto L7;
        return false;
    L14:
        return true;
    L16:
        e = move-exception;
        Log.w(TAG, "could not get network interfaces: " + e);
        return false;
    }

    public static AndroidCertVerifyResult verifyServerCertificates(byte[][] r1, String r2, String r3) {
        return X509Util.verifyServerCertificates(r1, r2, r3);
    L6:
        return new AndroidCertVerifyResult(-1);
    L10:
        return new AndroidCertVerifyResult(-1);
    L8:
        return new AndroidCertVerifyResult(-1);
    }

    public static void addTestRootCertificate(byte[] r0) throws CertificateException, KeyStoreException, NoSuchAlgorithmException {
        X509Util.addTestRootCertificate(r0);
    }

    public static void clearTestRootCertificates() throws NoSuchAlgorithmException, CertificateException, KeyStoreException {
        X509Util.clearTestRootCertificates();
    }

    private static boolean getIsCaptivePortal() {
        ConnectivityManager r0 = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");
        if (r0 != null) goto L5;
        return false;
    L5:
        Network r2 = ApiHelperForM.getActiveNetwork(r0);
        if (r2 != null) goto L8;
        return false;
    L8:
        NetworkCapabilities r1 = r0.getNetworkCapabilities(r2);
        if (r1 != null) goto L11;
        return false;
    L11:
        if (r1.hasCapability(17) == false) goto L15;
        return true;
    L15:
        return false;
    }

    private static WifiInfo getWifiInfo() {
        if (haveAccessWifiState() == true) goto L5;
        Intent r0 = ContextUtils.getApplicationContext().registerReceiver(null, new IntentFilter("android.net.wifi.STATE_CHANGE"));
        if (r0 != null) goto L25;
        return null;
    L25:
        return (WifiInfo) r0.getParcelableExtra("wifiInfo");
    L5:
        if (Build.VERSION.SDK_INT < 31) goto L21;
        ConnectivityManager r1 = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");
        Network[] r2 = r1.getAllNetworks();
        int r3 = r2.length;
        int r4 = 0;
    L7:
        if (r4 >= r3) goto L19;
        NetworkCapabilities r5 = r1.getNetworkCapabilities(r2[r4]);
        if (r5 == null) goto L18;
        if (r5.hasTransport(1) == false) goto L18;
        TransportInfo r6 = ApiHelperForQ.getTransportInfo(r5);
        if (r6 == null) goto L18;
        if ((r6 instanceof WifiInfo) == false) goto L18;
        return (WifiInfo) r6;
    L18:
        r4 = r4 + 1;
        goto L7
    L19:
        return null;
    L21:
        return ((WifiManager) ContextUtils.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
    }

    public static void setWifiEnabled(boolean r2) {
        ((WifiManager) ContextUtils.getApplicationContext().getSystemService("wifi")).setWifiEnabled(r2);
    }

    public static int getWifiSignalLevel(int r5) {
        if (ContextUtils.getApplicationContext() != null) goto L6;
        return -1;
    L6:
        if (ContextUtils.getApplicationContext().getContentResolver() != null) goto L9;
        return -1;
    L9:
        if (TTAppSecurityManager.getInstance().isTTPRestrictionEnabled() == false) goto L12;
        int r0 = TTAppSecurityManager.getInstance().getWifiRssi();
    L21:
        if (r0 != Integer.MIN_VALUE) goto L23;
        return -1;
    L23:
        int r1 = WifiManager.calculateSignalLevel(r0, r5);
        if (r1 < 0) goto L28;
        if (r1 >= r5) goto L28;
        return r1;
    L28:
        return -1;
    L12:
        if (haveAccessWifiState() == false) goto L30;
        WifiInfo r2 = getWifiInfo();
        if (r2 != null) goto L16;
        return -1;
    L16:
        r0 = r2.getRssi();
        goto L21
    L30:
        Intent r3 = ContextUtils.getApplicationContext().registerReceiver(null, new IntentFilter("android.net.wifi.RSSI_CHANGED"));     // Catch: IllegalArgumentException -> L29
        if (r3 != null) goto L20;
        return -1;
    L20:
        r0 = r3.getIntExtra("newRssi", Integer.MIN_VALUE);
        goto L21
    }

    private static boolean isCleartextPermitted(String r1) {
        return NetworkSecurityPolicyProxy.getInstance().isCleartextTrafficPermitted(r1);
    L5:
        return NetworkSecurityPolicyProxy.getInstance().isCleartextTrafficPermitted();
    }

    private static boolean haveAccessNetworkState() {
        if (sHaveAccessNetworkState != null) goto L6;
        sHaveAccessNetworkState = Boolean.valueOf(hasPermission(ContextUtils.getApplicationContext(), "android.permission.ACCESS_NETWORK_STATE"));
    L6:
        return sHaveAccessNetworkState.booleanValue();
    }

    private static boolean haveAccessWifiState() {
        if (sHaveAccessWifiState != null) goto L6;
        sHaveAccessWifiState = Boolean.valueOf(hasPermission(ContextUtils.getApplicationContext(), "android.permission.ACCESS_WIFI_STATE"));
    L6:
        return sHaveAccessWifiState.booleanValue();
    }

    private static boolean haveAccessLocationState() {
        if (sHaveAccessLocationState != null) goto L6;
        sHaveAccessLocationState = Boolean.valueOf(hasPermission(ContextUtils.getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION"));
    L6:
        return sHaveAccessLocationState.booleanValue();
    }

    private static boolean hasPermission(Context r2, String r3) {
        if (ApiCompatibilityUtils.checkPermission(r2, r3, Process.myPid(), Process.myUid()) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static DnsStatus getDnsStatusForNetwork(long r0) {
        return getDnsStatus(Network.fromNetworkHandle(r0));
    L4:
        return null;
    }

    public static DnsStatus getCurrentDnsStatus() {
        return getDnsStatus(null);
    }

    public static DnsStatus getDnsStatus(Network r4) {
        if (haveAccessNetworkState() == true) goto L5;
        return null;
    L5:
        ConnectivityManager r0 = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");
        if (r0 != null) goto L8;
        return null;
    L8:
        if (r4 != null) goto L10;
        r4 = ApiHelperForM.getActiveNetwork(r0);
    L10:
        if (r4 != null) goto L18;
        return null;
    L18:
        LinkProperties r5 = r0.getLinkProperties(r4);     // Catch: RuntimeException -> L17
        if (r5 != null) goto L15;
        return null;
    L15:
        List<InetAddress> r1 = r5.getDnsServers();
        String r2 = r5.getDomains();
        return new DnsStatus(r1, ApiHelperForP.isPrivateDnsActive(r5), ApiHelperForP.getPrivateDnsServerName(r5), r2);
    L17:
        return null;
    }

    private static boolean reportBadDefaultNetwork() {
        ConnectivityManager r0 = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");
        if (r0 != null) goto L5;
        return false;
    L5:
        ApiHelperForM.reportNetworkConnectivity(r0, null, false);
        return true;
    }

    private static void alwaysUpCellularOnThreadPool() {
        final ConnectivityManager r0 = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");
        if (r0 != null) goto L6;
        AndroidNetworkLibraryJni.get().onCellularAlwaysUp(false, 7);
        return;
    L6:
        NetworkRequest r2 = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
        r0.requestNetwork(r2, new AnonymousClass1(r0));     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        AndroidNetworkLibraryJni.get().onCellularAlwaysUp(false, 9);
    }

    public static int[] getDhcpInfo() {
        if (TTAppSecurityManager.getInstance().isUserPrivacyRestrictionEnabled() == true) goto L5;
        WifiManager r0 = (WifiManager) ContextUtils.getApplicationContext().getSystemService("wifi");     // Catch: Throwable -> L12
        if (r0 == null) goto L15;
        DhcpInfo r1 = r0.getDhcpInfo();     // Catch: Throwable -> L12
        if (r1 == null) goto L15;
        return new int[]{r1.ipAddress, r1.gateway};
    L15:
        return new int[0];
    L12:
        th = move-exception;
        th.printStackTrace();
        goto L15
    L5:
        return new int[0];
    }

    public static String[][] getAllRouteInfo() {
        if (haveAccessNetworkState() == true) goto L30;
        return null;
    L30:
        ConnectivityManager r0 = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");     // Catch: Throwable -> L27
        if (r0 != null) goto L8;
        return null;
    L8:
        Network[] r2 = r0.getAllNetworks();     // Catch: Throwable -> L27
        ArrayList r3 = new ArrayList();     // Catch: Throwable -> L27
        int r4 = r2.length;     // Catch: Throwable -> L27
        int r6 = 0;
    L10:
        if (r6 >= r4) goto L25;
        LinkProperties r9 = r0.getLinkProperties(r2[r6]);     // Catch: Throwable -> L27
        if (r9 == null) goto L24;
        Iterator<RouteInfo> r10 = r9.getRoutes().iterator();     // Catch: Throwable -> L27
    L16:
        if (r10.hasNext() == false) goto L24;
        RouteInfo r11 = r10.next();     // Catch: Throwable -> L27
        String[] r12 = new String[4];     // Catch: Throwable -> L27
        if (r11.getDestination() == null) goto L21;
        r12[0] = r11.getDestination().getAddress().getHostAddress();     // Catch: Throwable -> L27
        r12[1] = Integer.toString(r11.getDestination().getPrefixLength());     // Catch: Throwable -> L27
    L21:
        if (r11.getGateway() == null) goto L23;
        r12[2] = r11.getGateway().getHostAddress();     // Catch: Throwable -> L27
    L23:
        r12[3] = r11.getInterface();     // Catch: Throwable -> L27
        r3.add(r12);     // Catch: Throwable -> L27
    L24:
        r6 = r6 + 1;     // Catch: Throwable -> L27
        goto L10
    L25:
        return (String[][]) r3.toArray((String[][]) Array.newInstance(String.class, new int[]{0, 0}));
    L27:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    private static String getNetworkOperator() {
        if (TTAppSecurityManager.getInstance().isTTPRestrictionEnabled() == true) goto L5;
        TelephonyManager r1 = (TelephonyManager) ContextUtils.getApplicationContext().getSystemService("phone");     // Catch: Throwable -> L11
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getNetworkOperator();
    L11:
        th = move-exception;
        th.printStackTrace();
        return "";
    L5:
        return TTAppSecurityManager.getInstance().getNetworkOperator();
    }

    private static String getSimOperator() {
        if (TTAppSecurityManager.getInstance().isTTPRestrictionEnabled() == true) goto L5;
        TelephonyManager r1 = (TelephonyManager) ContextUtils.getApplicationContext().getSystemService("phone");     // Catch: Throwable -> L11
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getSimOperator();
    L11:
        th = move-exception;
        th.printStackTrace();
        return "";
    L5:
        return TTAppSecurityManager.getInstance().getSimOperator();
    }

    private static boolean checkIsVpnOn() {
        ConnectivityManager r0 = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");
        if (r0 != null) goto L5;
        return false;
    L5:
        Network[] r2 = r0.getAllNetworks();
        int r3 = 0;
    L7:
        if (r3 >= r2.length) goto L15;
        if (r0.getNetworkInfo(r2[r3]).isConnected() == false) goto L14;
        if (r0.getNetworkCapabilities(r2[r3]).hasTransport(4) == false) goto L14;
        return true;
    L14:
        r3 = r3 + 1;
        goto L7
    L15:
        return false;
    }

    public static int getCurrentAccessPointChannel() {
        if (TTAppSecurityManager.getInstance().isTTPRestrictionEnabled() == true) goto L5;
        WifiInfo r0 = getWifiInfo();
        if (r0 != null) goto L11;
        return -1;
    L11:
        return frequencyToChannel(r0.getFrequency());
    L5:
        return frequencyToChannel(TTAppSecurityManager.getInstance().getWifiFrequency());
    }

    public static int[] getAllAccessPointChannels() {
        if (haveAccessLocationState() == false) goto L25;
        if (haveAccessWifiState() == false) goto L25;
        WifiManager r0 = (WifiManager) ContextUtils.getApplicationContext().getSystemService("wifi");
        if (r0 == null) goto L10;
        List<ScanResult> r1 = r0.getScanResults();
        if (r1 == null) goto L23;
        if (r1.isEmpty() == true) goto L23;
        ArrayList r2 = new ArrayList();
        Iterator<ScanResult> r3 = r1.iterator();
    L18:
        if (r3.hasNext() == false) goto L21;
        r2.add(Integer.valueOf(frequencyToChannel(r3.next().frequency)));
        goto L18
    L21:
        return CollectionUtil.integerListToIntArray(r2);
    L23:
        return new int[0];
    L10:
        return new int[0];
    L25:
        return new int[0];
    }

    private static int frequencyToChannel(int r1) {
        if (r1 != 2484) goto L6;
        return 14;
    L6:
        if (r1 >= 2484) goto L10;
        return (r1 - 2407) / 5;
    L10:
        if (r1 < 4910) goto L16;
        if (r1 > 4980) goto L16;
        return (r1 + ErrorCode.ERR_RESPONSE) / 5;
    L16:
        if (r1 >= 5925) goto L20;
        return (r1 + ErrorCode.ERR_RECEIVE) / 5;
    L20:
        if (r1 != 5935) goto L24;
        return 2;
    L24:
        if (r1 > 45000) goto L28;
        return (r1 - 5950) / 5;
    L28:
        if (r1 >= 58320) goto L30;
        return -1;
    L30:
        if (r1 <= 70200) goto L32;
        return -1;
    L32:
        return (r1 - 56160) / 2160;
    }

    private static void tagSocket(int r4, int r5, int r6) throws IOException {
        int r0 = TrafficStats.getThreadStatsTag();
        if (r6 == r0) goto L6;
        TrafficStats.setThreadStatsTag(r6);
    L6:
        if (r5 == (-1)) goto L8;
        ThreadStatsUid.set(r5);
    L8:
        ParcelFileDescriptor r7 = ParcelFileDescriptor.adoptFd(r4);
        SocketFd r3 = new SocketFd(r7.getFileDescriptor());
        TrafficStats.tagSocket(r3);
        r3.close();
        if (r7 == null) goto L11;
        r7.detachFd();
    L11:
        if (r6 == r0) goto L13;
        TrafficStats.setThreadStatsTag(r0);
    L13:
        if (r5 == (-1)) goto L16;
        ThreadStatsUid.clear();
        return;
    }
}
