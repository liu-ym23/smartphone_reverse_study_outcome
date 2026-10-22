package com.ss.ttuploader;

import com.bytedance.ttnet.TTNetInit;
import com.ss.ttuploader.net.HTTPDNS;
import com.ss.ttuploader.net.IPCache;
import com.ss.ttuploader.net.TTUploadDNSInfo;
import com.ss.ttuploader.net.TTUploadDNSParser;
import com.ss.ttuploader.net.TTUploadDNSParserListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class TTUploadResolver implements TTUploadDNSParserListener {
    public static final int DNS_TYPE_IS_VERSION_1 = 1;
    public static final int DNS_TYPE_IS_VERSION_2 = 2;
    public static final int HOST_MAX_CACHE_TIME = 60000;
    private static final int MAX_CACHED = 128;
    private static final String TAG = "TTUploadResolver";
    private static final Hashtable<String, HostInfo> mCacheHosts = null;
    public static volatile int mDNSVersion = 1;
    public static volatile int mIsUseTTnetDNS;
    private String mError;
    private HostInfo mHostInfo;
    private volatile String mHostName;
    private volatile String[] mIPStr;
    private volatile boolean mRet;
    private Thread mThread;
    private int mUseDNSType;

    static class HostInfo {
        public String ip;
        public long time;

        HostInfo() {
        }
    }

    static class ParserHost implements Runnable {
        String mHostName;
        TTUploadResolver mResolver;

        public ParserHost(TTUploadResolver r2, String r3) {
            this.mResolver = null;
            this.mResolver = r2;
            this.mHostName = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            InetAddress r3 = null;
            if (TTUploadResolver.mIsUseTTnetDNS == 1) goto L24;
        L12:
            boolean r0 = false;
        L13:
            if (r0 == false) goto L22;
        L18:
            if (r3 == null) goto L20;
            String r1 = r3.getHostAddress();
            TTUploadResolver.access$102(this.mResolver, new String[1]);
            TTUploadResolver.access$100(this.mResolver)[0] = r1;
            HostInfo r2 = new HostInfo();
            r2.time = System.currentTimeMillis();
            r2.ip = r1;
            TTUploadResolver.putHostInfo(this.mHostName, r2);
            r2.time = System.currentTimeMillis();
        L20:
            TTUploadResolver.access$202(this.mResolver, true);
            return;
        L22:
            r3 = InetAddress.getByName(this.mHostName);     // Catch: UnknownHostException -> L16
        L16:
            e = move-exception;
            e.printStackTrace();
            TTUploadResolver.access$002(this.mResolver, e.getMessage());
            goto L18
        L24:
            List<InetAddress> r4 = TTNetInit.dnsLookup(this.mHostName);     // Catch: Throwable -> L10
            if (r4 == null) goto L12;
            if (r4.get(0) == null) goto L12;
            r3 = r4.get(0);     // Catch: Throwable -> L10
            r0 = true;
        L10:
            th = move-exception;
            th.printStackTrace();
            goto L12
        }
    }

    static {
        mCacheHosts = new Hashtable();
    }

    public TTUploadResolver() {
        this.mRet = false;
        this.mThread = null;
        this.mUseDNSType = mDNSVersion;
    }

    static /* synthetic */ String access$002(TTUploadResolver r0, String r1) {
        r0.mError = r1;
        return r1;
    }

    static /* synthetic */ String[] access$100(TTUploadResolver r0) {
        return r0.mIPStr;
    }

    static /* synthetic */ String[] access$102(TTUploadResolver r0, String[] r1) {
        r0.mIPStr = r1;
        return r1;
    }

    static /* synthetic */ boolean access$202(TTUploadResolver r0, boolean r1) {
        r0.mRet = r1;
        return r1;
    }

    private void getAddressInfoVersion_1(String r8) {
        this.mHostName = r8;
        if (r8 != null) goto L5;
    L24:
        this.mRet = true;
        return;
    L5:
        if (r8.length() < 1) goto L24;
        if ("".equals(r8) == true) goto L24;
        if (isIP(this.mHostName) == false) goto L11;
        this.mIPStr = new String[1];
        this.mIPStr[0] = this.mHostName;
        goto L24
    L11:
        Hashtable<String, HostInfo> r1 = mCacheHosts;
        HostInfo r3 = r1.get(r8);
        this.mHostInfo = r3;
        if (r3 != null) goto L14;
    L26:
        Thread r9 = new Thread(new ParserHost(this, this.mHostName));     // Catch: Exception -> L22
        this.mThread = r9;     // Catch: Exception -> L22
        r9.start();     // Catch: Exception -> L22
        return;
    L22:
        e = move-exception;
        this.mRet = true;
        this.mError = e.getMessage();
        return;
    L14:
        if (r3.ip != null) goto L16;
    L19:
        r1.remove(r8);
        this.mHostInfo = null;
        goto L26
    L16:
        if ((System.currentTimeMillis() - this.mHostInfo.time) >= 60000) goto L19;
        this.mIPStr = new String[1];
        this.mIPStr[0] = this.mHostInfo.ip;
        this.mRet = true;
    }

    private void getAddressInfoVersion_2(String r9) {
        TTUploadLog.d(TAG, "----add host to parser");
        this.mHostName = r9;
        TTUploadDNSInfo r1 = IPCache.getInstance().get(r9);
        if (r1 == null) goto L15;
        if (r1.mIpList == null) goto L15;
        long r2 = System.currentTimeMillis();
        TTUploadLog.d(TAG, String.format("get result from cache expiredT:%d curT:%d ", new Object[]{Long.valueOf(r1.mExpiredTime), Long.valueOf(r2)}));
        if (r1.mExpiredTime > r2) goto L9;
        TTUploadLog.d(TAG, String.format("has expired try call parse:", new Object[0]));
        TTUploadDNSParser.getInstance().addHost(r9, null);
    L9:
        String[] r3 = r1.mIpList.split(",");
        if (r3 == null) goto L15;
        if (r3.length <= 0) goto L15;
        this.mIPStr = new String[1];
        this.mIPStr[0] = r3[0];
        this.mRet = true;
        TTUploadLog.d(TAG, String.format("get result from cache suc, ip:%s ", new Object[]{r3[0]}));
    L15:
        if (this.mRet == true) goto L18;
        TTUploadLog.d(TAG, "****add host to parser");
        TTUploadDNSParser.getInstance().addHost(r9, this);
        return;
    }

    public static final boolean isIP(String r4) {
        if (r4.length() < 7) goto L9;
        if (r4.length() > 15) goto L9;
        return Pattern.compile("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}").matcher(r4).find();
    L9:
        if (r4.charAt(0) == '[') goto L11;
        return false;
    L11:
        if (r4.charAt(r4.length() - 1) == ']') goto L13;
        return false;
    L13:
        return true;
    }

    static synchronized void putHostInfo(String r10, HostInfo r11) {
        monitor-enter(TTUploadResolver.class);
        long r1 = System.currentTimeMillis();     // Catch: Throwable -> L22
        Hashtable<String, HostInfo> r3 = mCacheHosts;     // Catch: Throwable -> L22
        Object r6 = null;
        if (r3.size() <= 128) goto L15;
        Iterator<Map.Entry<String, HostInfo>> r4 = r3.entrySet().iterator();     // Catch: Throwable -> L22
        Object r5 = null;
    L8:
        if (r4.hasNext() == false) goto L14;
        HostInfo r7 = r4.next().getValue();     // Catch: Throwable -> L22
        r6 = (String) r4.next().getKey();     // Catch: Throwable -> L22
        if (r7 == null) goto L8;
        long r8 = r7.time;     // Catch: Throwable -> L22
        if (r8 >= r1) goto L8;
        r5 = r7;
        r1 = r8;
        goto L8
    L14:
        Object r2 = r6;
        r6 = r5;
    L16:
        if (r6 == null) goto L19;
        if (r2 == null) goto L19;
        mCacheHosts.remove(r2);     // Catch: Throwable -> L22
    L19:
        mCacheHosts.put(r10, r11);     // Catch: Throwable -> L22
        monitor-exit(TTUploadResolver.class);
        return;
    L15:
        r2 = null;
    L22:
        th = move-exception;
        throw th;
    }

    public static void setDNSServer(String r0, String r1) {
        HTTPDNS.setDNSServerHost(r0, r1);
    }

    public static void setDNSType(int r3, int r4, int r5, int r6, int r7) {
        if (r3 == 1) goto L6;
        if (r3 == 2) goto L6;
        return;
    L6:
        TTUploadDNSParser.setIntValue(0, r4);
        TTUploadDNSParser.setIntValue(1, r5);
        TTUploadDNSParser.setIntValue(3, r6);
        TTUploadDNSParser.setIntValue(2, r7);
        mDNSVersion = r3;
    }

    public static void setEnableTTNetDNS(int r0) {
        mIsUseTTnetDNS = r0;
    }

    public void freeAddress() {
        if (this.mUseDNSType != 1) goto L11;
        Thread r0 = this.mThread;
        if (r0 == null) goto L11;
        r0.interrupt();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
    L11:
        if (this.mUseDNSType != 2) goto L21;
        TTUploadDNSParser.getInstance().removeHost(this.mHostName, this);     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public String getAddress() {
        if (this.mRet == true) goto L5;
    L9:
        return null;
    L5:
        if (this.mIPStr == null) goto L9;
        if (this.mIPStr[0] == null) goto L9;
        return this.mIPStr[0];
    }

    public void getAddressInfo(String r3) {
        int r0 = this.mUseDNSType;
        if (r0 != 1) goto L5;
    L8:
        getAddressInfoVersion_1(r3);
        return;
    L5:
        if (r0 != 2) goto L8;
        getAddressInfoVersion_2(r3);
    }

    public int isSuccess() {
        if (this.mRet == true) goto L5;
        return 0;
    L5:
        if (this.mIPStr != null) goto L7;
    L9:
        return -1;
    L7:
        if (this.mIPStr[0] == null) goto L9;
        return 1;
    }

    @Override // com.ss.ttuploader.net.TTUploadDNSParserListener
    public void onCompletion(int r1, String r2, String r3, long r4, String r6) {
        TTUploadLog.d(TAG, String.format("notify result host:%s iplist:%s ", new Object[]{r2, r3}));
        if (this.mRet == true) goto L15;
        if (r3 == null) goto L13;
        if (r2 == null) goto L13;
        if (r2.equals(this.mHostName) == false) goto L13;
        String[] r5 = r3.split(",");
        if (r5 == null) goto L13;
        if (r5.length <= 0) goto L13;
        this.mIPStr = new String[1];
        this.mIPStr[0] = r5[0];
    L13:
        this.mRet = true;
        return;
    }
}
