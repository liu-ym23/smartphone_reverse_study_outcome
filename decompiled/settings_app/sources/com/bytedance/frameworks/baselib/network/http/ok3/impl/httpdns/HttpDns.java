package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.OkHttp3AppMonitor;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.HttpDnsUtil;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.IPAddressUtils;
import com.bytedance.frameworks.baselib.network.http.util.ProcessUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class HttpDns implements WeakHandler.IHandler {
    private static final int CORE_POOL_SIZE = 6;
    public static final String HTTPDNS_HARDCODEIP_SP_KEY = "httpdns_hardcodeips";
    public static final String HTTPDNS_HARDCODEIP_SP_NAME = "dispatchersdk_httpdns_hardcodeips";
    private static final String MSG_CALLBACK_DNSRESULT_JOB_KEY = "callback_dnsresult_job_key";
    public static final String MSG_CALLBACK_DNSRESULT_KEY = "callback_dnsresult_key";
    private static final int MSG_CALLBACK_DNS_RESULT = 1;
    private static final String MSG_DNS_TIMEOUT_JOB_KEY = "dns_timeout_job_key";
    private static final int MSG_HTTPDNS_PREFER_TIMEOUT = 2;
    private static final String MSG_HTTPDNS_PREFER_TIMEOUT_JOB_KEY = "httpdns_timeout_job_key";
    private static final int MSG_HTTPDNS_REQUEST_TIMEOUT = 4;
    private static final int MSG_LOAD_LOCAL_HARDCODEIPS = 5;
    private static final int MSG_LOCALDNS_REQUEST_TIMEOUT = 3;
    private static final int MSG_ON_NETWORK_CHANGED = 6;
    private static final int MSG_ON_RESUME = 7;
    private static String TAG = "HttpDns";
    private static WeakHandler mHttpDnsHandler;
    private static HandlerThread mHttpDnsHandlerThread;
    private static volatile HttpDns mInstance;
    private static String mSdkVersion;
    private static ExecutorService mThreadPool;
    private AtomicInteger mEnableCompareLocalDnsHttpDns;
    private AtomicBoolean mEnableHttpDns;
    private ConcurrentMap<String, CopyOnWriteArrayList<String>> mHardCodeIps;
    private boolean mHasSetHttpDnsDepend;
    private final HostResolveManager mHostResolveManager;
    private volatile IHttpDnsDepend mHttpDnsDepend;
    private volatile String mHttpDnsDomain;
    private AtomicInteger mHttpDnsPreferInterval;
    private AtomicInteger mHttpDnsRefreshStaleCacheInterval;
    private AtomicInteger mHttpDnsTimeout;
    private ConcurrentSkipListSet<String> mHttpdnsDomainHardCodeIps;
    private AtomicBoolean mIsHttpDnsPrefer;
    private AtomicInteger mLocalDnsCacheTTL;
    private AtomicInteger mLocalDnsTimeout;
    private Handler mMainThreadHandler;
    private final OkHttp3AppMonitor mOkHttp3AppMonitor;
    private ConcurrentSkipListSet<String> mPreResolveHosts;

    static /* synthetic */ String access$000() {
        return TAG;
    }

    static {
        mThreadPool = Executors.newFixedThreadPool(6);
    }

    public static HttpDns getService() {
        if (mInstance != null) goto L15;
        monitor-enter(HttpDns.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new HttpDns();     // Catch: Throwable -> L11
    L9:
        monitor-exit(HttpDns.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    private HttpDns() {
        this.mEnableHttpDns = new AtomicBoolean(true);
        this.mIsHttpDnsPrefer = new AtomicBoolean(false);
        this.mHttpdnsDomainHardCodeIps = new ConcurrentSkipListSet();
        this.mHardCodeIps = new ConcurrentHashMap();
        this.mPreResolveHosts = new ConcurrentSkipListSet();
        this.mLocalDnsCacheTTL = new AtomicInteger(30);
        this.mHttpDnsPreferInterval = new AtomicInteger(2000);
        this.mHttpDnsRefreshStaleCacheInterval = new AtomicInteger(60);
        this.mEnableCompareLocalDnsHttpDns = new AtomicInteger(0);
        this.mHttpDnsTimeout = new AtomicInteger(5);
        this.mLocalDnsTimeout = new AtomicInteger(5);
        this.mOkHttp3AppMonitor = new OkHttp3AppMonitor();
        this.mHasSetHttpDnsDepend = false;
        final Looper r1 = Looper.getMainLooper();
        this.mMainThreadHandler = new AnonymousClass1(this, r1);
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "HttpDns constructor");
    L5:
        HandlerThread r0 = new HandlerThread("TTOK-HTTPDNS");
        mHttpDnsHandlerThread = r0;
        r0.start();
        mHttpDnsHandler = new WeakHandler(mHttpDnsHandlerThread.getLooper(), this);
        mSdkVersion = "4.2.211.1-rc.0";
        this.mHostResolveManager = new HostResolveManager(mHttpDnsHandler);
    }

    public void setHttpDnsDepend(IHttpDnsDepend r3) {
        if (this.mHasSetHttpDnsDepend == true) goto L5;
        if (r3 != null) goto L10;
    L33:
        this.mHttpDnsDepend = null;
        throw new IllegalArgumentException("you must set correct httpdns depend");
    L10:
        if (r3.getContext() == null) goto L33;
        if (TextUtils.isEmpty(r3.getHttpDnsDomain()) == true) goto L33;
        if (r3.getAppId() == null) goto L33;
        this.mHttpDnsDepend = r3;
        if (TextUtils.isEmpty(this.mHttpDnsDomain) == false) goto L18;
        this.mHttpDnsDomain = r3.getHttpDnsDomain();
    L18:
        this.mHasSetHttpDnsDepend = true;
        submitIpv6Detect();
        this.mOkHttp3AppMonitor.registerAppMonitorListener(r3.getContext());
        if (this.mPreResolveHosts.size() < 1) goto L21;
        doHttpDnsPreload(DnsRecord.CacheStaleReason.PRELOAD_BATCH);
    L31:
        Message r4 = Message.obtain();
        r4.what = 5;
        r4.obj = this;
        mHttpDnsHandler.sendMessage(r4);
        return;
    L21:
        if (this.mHttpDnsDepend.getPreloadDomains() == null) goto L28;
        if (this.mHttpDnsDepend.getPreloadDomains().length <= 0) goto L28;
        if (this.mHttpDnsDepend.getPreloadDomains().length > 10) goto L28;
        this.mPreResolveHosts.addAll(Arrays.asList(this.mHttpDnsDepend.getPreloadDomains()));
        doHttpDnsPreload(DnsRecord.CacheStaleReason.PRELOAD_BATCH);
    L28:
        if (Logger.debug() == false) goto L31;
        Logger.d(TAG, "httpdns preload domains's number must less than 10, httpdns preload is skipped.");
        goto L31
    L5:
        if (Logger.debug() == false) goto L35;
        Logger.d(TAG, "you have set httpdns depend before.");
        return;
    }

    public DnsResult getHttpDnsResultForHostSyncBlock(String r8) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "getHttpDnsResultForHostSyncBlock for host : " + r8);
    L6:
        if (invalidConfigure(r8) == false) goto L9;
        return null;
    L9:
        boolean r0 = r8.equals(this.mHttpDnsDomain);
        if (this.mIsHttpDnsPrefer.get() == false) goto L16;
        if (r0 == true) goto L16;
        DnsResult r1 = lookupHttpDnsCache(r8, false);
        if (r1 == null) goto L15;
        return r1;
    L15:
        ArrayList r2 = new ArrayList();
        r2.add(0, false);
        DnsResult r3 = getDnsResultInHttpDnsPreferTime(submitHttpDnsAndLocalDnsResolve(r8, r2, true), r8, r2.get(0).booleanValue());
    L39:
        if (r3 == null) goto L41;
        return r3;
    L41:
        return getHardCodeIpResult(r8);
    L16:
        DnsResult r4 = lookupLocalDnsCache(r8, false);
        if (r4 == null) goto L20;
        return r4;
    L20:
        if (this.mHostResolveManager.isLocalDnsResolving(r8) == false) goto L22;
        Future<Void> r5 = this.mHostResolveManager.getLocalDnsResolvingFuture(r8);
    L23:
        if (r5 != null) goto L29;
        DnsResult r6 = getHttpDnsResultForLocalDnsPreferRequest(r8, r0);
        if (r6 == null) goto L27;
        return r6;
    L27:
        return getHardCodeIpResult(r8);
    L29:
        if (r5.isDone() == false) goto L42;
        DnsResult r7 = lookupLocalDnsCache(r8, true);
        if (r7 != null) goto L33;
        r3 = getHttpDnsResultForLocalDnsPreferRequest(r8, r0);
    L33:
        r3 = r7;
        goto L39
    L42:
        r5.get(((long) this.mLocalDnsTimeout.get()) * 1000, TimeUnit.MILLISECONDS);     // Catch: Exception -> L38
        r7 = lookupLocalDnsCache(r8, true);     // Catch: Exception -> L38
        if (r7 != null) goto L33;
        r3 = getHttpDnsResultForLocalDnsPreferRequest(r8, r0);     // Catch: Exception -> L38
    L38:
        r3 = getHttpDnsResultForLocalDnsPreferRequest(r8, r0);
        goto L39
    L22:
        r5 = submitLocalDnsResolve(r8);
        goto L23
    }

    private DnsResult getHardCodeIpResult(String r5) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "try to look up hardcode ips");
    L6:
        if (this.mHardCodeIps.containsKey(r5) == false) goto L21;
        DnsResult r0 = new DnsResult();
        Iterator<String> r4 = this.mHardCodeIps.get(r5).iterator();
    L9:
        if (r4.hasNext() == false) goto L19;
        String r6 = r4.next();
        if (IPAddressUtils.isValidIpv6(r6) == true) goto L12;
        if (IPAddressUtils.isValidIpv4(r6) == true) goto L15;
        if (Logger.debug() == false) goto L9;
        Logger.d(TAG, "find a invalid hardcode ip: " + r6);
        goto L9
    L15:
        r0.ipv4List.add(r6);
        goto L9
    L12:
        r0.ipv6List.add(r6);
        goto L9
    L19:
        r0.source = DnsResult.Source.HARDCODE_IPS;
        return r0;
    L21:
        return null;
    }

    private DnsResult getHttpDnsResultForLocalDnsPreferRequest(String r7, boolean r8) {
        if (r8 == false) goto L6;
        return null;
    L6:
        if (this.mHostResolveManager.isHttpDnsResolving(r7) == false) goto L8;
        Future<Void> r9 = this.mHostResolveManager.getHttpDnsResolvingFuture(r7);
    L9:
        if (r9 != null) goto L12;
        return null;
    L12:
        if (r9.isDone() == true) goto L19;
        r9.get(((long) this.mHttpDnsTimeout.get()) * 1000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L16
        return lookupHttpDnsCache(r7, true);
    L20:
        return null;
    L19:
        return lookupHttpDnsCache(r7, true);
    L8:
        ArrayList r10 = new ArrayList();
        r10.add(r7);
        r9 = submitHttpDnsResolve(r10, DnsRecord.CacheStaleReason.CACHE_UNSET, true);
        goto L9
    }

    public DnsResult getHttpDnsResultForHostSyncNonBlock(String r4) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "getHttpDnsResultForHostSyncNonBlock for host : " + r4);
    L6:
        if (invalidConfigure(r4) == false) goto L10;
        return null;
    L10:
        if (isHttpDnsPrefer().get() == false) goto L27;
        DnsResult r0 = lookupHttpDnsCache(r4, false);
        if (r0 == null) goto L15;
        return r0;
    L15:
        if (this.mHostResolveManager.isHttpDnsResolving(r4) == true) goto L26;
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L18:
        if (this.mHostResolveManager.isHttpDnsResolving(r4) == true) goto L20;
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L22
        r1.add(r4);     // Catch: Throwable -> L22
        submitHttpDnsResolve(r1, DnsRecord.CacheStaleReason.CACHE_UNSET, false);     // Catch: Throwable -> L22
    L20:
        monitor-exit(this);     // Catch: Throwable -> L22
    L26:
        return lookupLocalDnsCache(r4, false);
    L27:
        DnsResult r2 = lookupLocalDnsCache(r4, false);
        if (r2 == null) goto L31;
        return r2;
    L31:
        if (this.mHostResolveManager.isLocalDnsResolving(r4) == true) goto L42;
        monitor-enter(this);
    L38:
        th = move-exception;
        throw th;
    L34:
        if (this.mHostResolveManager.isLocalDnsResolving(r4) == true) goto L36;
        submitLocalDnsResolve(r4);     // Catch: Throwable -> L38
    L36:
        monitor-exit(this);     // Catch: Throwable -> L38
    L42:
        return lookupHttpDnsCache(r4, false);
    }

    public DnsResult getHttpDnsResultForHostAsync(String r7, IHttpDnsCallback r8) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "HttpDns::getHttpDnsResultForHostAsync for host " + r7);
    L6:
        if (invalidConfigure(r7) == false) goto L9;
        return null;
    L9:
        if (isHttpDnsPrefer().get() == false) goto L17;
        DnsResult r0 = lookupHttpDnsCache(r7, false);
        if (r0 != null) goto L13;
        ArrayList r1 = new ArrayList();
        r1.add(0, false);
        submitHttpDnsAndLocalDnsResolve(r7, r1, false);
        HostResolveJob r3 = new HostResolveJob(r7, r8, r1.get(0).booleanValue());
        this.mHostResolveManager.addHttpDnsJob(r7, r3);
        Message r9 = Message.obtain();
        r9.what = 2;
        r9.obj = this;
        Bundle r10 = new Bundle();
        r10.putSerializable(MSG_HTTPDNS_PREFER_TIMEOUT_JOB_KEY, r3);
        r9.setData(r10);
        mHttpDnsHandler.sendMessageDelayed(r9, this.mHttpDnsPreferInterval.get());
    L24:
        return null;
    L13:
        if (Logger.debug() == false) goto L15;
        Logger.d(TAG, "returned httpdns cache, wouldn't callback");
    L15:
        return r0;
    L17:
        DnsResult r2 = lookupLocalDnsCache(r7, false);
        if (r2 == null) goto L21;
        return r2;
    L21:
        if (this.mHostResolveManager.isLocalDnsResolving(r7) == true) goto L23;
        submitLocalDnsResolve(r7);
    L23:
        HostResolveJob r4 = new HostResolveJob(r7, r8, true);
        this.mHostResolveManager.addLocalDnsJob(r7, r4);
        Message r11 = Message.obtain();
        r11.what = 3;
        r11.obj = this;
        Bundle r12 = new Bundle();
        r12.putSerializable(MSG_DNS_TIMEOUT_JOB_KEY, r4);
        r11.setData(r12);
        mHttpDnsHandler.sendMessageDelayed(r11, ((long) this.mLocalDnsTimeout.get()) * 1000);
        goto L24
    }

    private boolean invalidConfigure(String r3) {
        if (this.mHasSetHttpDnsDepend == true) goto L9;
        if (Logger.debug() == false) goto L7;
        Logger.d(TAG, "you have not set httpdns depend");
    L7:
        return true;
    L9:
        if (this.mEnableHttpDns.get() == true) goto L15;
        if (Logger.debug() == false) goto L13;
        Logger.d(TAG, "httpdns was unabled by tnc");
    L13:
        return true;
    L15:
        if (HttpDnsUtil.isValidHost(r3) == true) goto L21;
        if (Logger.debug() == false) goto L19;
        Logger.d(TAG, "illegal host");
    L19:
        return true;
    L21:
        if (IPAddressUtils.isValidIpv4(r3) == true) goto L28;
        if (IPAddressUtils.isValidIpv6(r3) == true) goto L28;
        return false;
    L28:
        if (Logger.debug() == false) goto L30;
        Logger.d(TAG, "host is ipaddress");
    L30:
        return true;
    }

    synchronized void doHttpDnsPreload(DnsRecord.CacheStaleReason r5) {
        monitor-enter(this);
    L36:
        th = move-exception;
        throw th;
    L4:
        if (this.mHttpDnsDepend != null) goto L6;
    L34:
        monitor-exit(this);
        return;
    L6:
        if (ProcessUtils.isMainProcessByProcessFlag(this.mHttpDnsDepend.getContext()) == false) goto L34;
        ConcurrentSkipListSet<String> r0 = this.mPreResolveHosts;     // Catch: Throwable -> L36
        if (r0 == null) goto L34;
        if (r0.size() == 0) goto L34;
        if (this.mPreResolveHosts.size() > 10) goto L34;
        if (Logger.debug() == false) goto L17;
        Logger.d(TAG, "do httpdns preload");     // Catch: Throwable -> L36
    L17:
        Iterator<String> r1 = this.mPreResolveHosts.iterator();     // Catch: Throwable -> L36
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L36
    L19:
        if (r1.hasNext() == false) goto L25;
        String r3 = r1.next();     // Catch: Throwable -> L36
        if (this.mHostResolveManager.isHttpDnsResolving(r3) == true) goto L19;
        r2.add(r3);     // Catch: Throwable -> L36
        goto L19
    L25:
        if (r2.size() != 0) goto L29;
        monitor-exit(this);
        return;
    L29:
        if (Logger.debug() == false) goto L31;
        Logger.d(TAG, "httpdns batch preload for : " + r2);     // Catch: Throwable -> L36
    L31:
        submitHttpDnsResolve(r2, r5, false);     // Catch: Throwable -> L36
        monitor-exit(this);
    }

    void refreshHttpDnsCache(String r3) {
        if (HttpDnsUtil.isValidHost(r3) == true) goto L5;
        return;
    L5:
        if (this.mHostResolveManager.isHttpDnsResolving(r3) == false) goto L7;
        return;
    L7:
        if (this.mIsHttpDnsPrefer.get() == false) goto L12;
        ArrayList r0 = new ArrayList();
        r0.add(r3);
        submitHttpDnsResolve(r0, DnsRecord.CacheStaleReason.CACHE_STALE_EXPIRED, false);
        return;
    }

    void removeHttpDnsCache(String r2) {
        if (HttpDnsUtil.isValidHost(r2) == true) goto L5;
        return;
    L5:
        if (this.mHostResolveManager.isHttpDnsResolving(r2) == true) goto L9;
        this.mHostResolveManager.removeHttpDnsCache(r2);
        return;
    }

    void addHttpDnsStaleCacheHost(String r1) {
        this.mHostResolveManager.addHttpDnsStaleCacheHost(r1);
    }

    void batchRefreshHttpDnsStaleCache(List<String> r4) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "batchRefreshHttpDnsStaleCache for host " + r4);
    L5:
        submitHttpDnsResolve(r4, DnsRecord.CacheStaleReason.REFRESH_BATCH, false);
    }

    void removeLocalDnsStaleCache(String r3) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "removeLocalDnsStaleCache");
    L6:
        if (HttpDnsUtil.isValidHost(r3) == false) goto L9;
        this.mHostResolveManager.removeLocalDnsCache(r3);
        return;
    }

    public void onServerConfigChanged(JSONObject r8) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "onServerConfigChanged");
    L6:
        if (this.mHttpDnsDepend == null) goto L65;
        if (r8 == null) goto L80;
        int r0 = r8.optInt("ttnet_http_dns_enabled", -1);
        boolean r2 = false;
        if (r0 < 0) goto L16;
        AtomicBoolean r4 = this.mEnableHttpDns;
        if (r0 != 1) goto L14;
        boolean r1 = true;
    L15:
        r4.set(r1);
        goto L16
    L14:
        r1 = false;
    L16:
        String r3 = r8.optString("ttnet_tt_http_dns_domain");
        if (TextUtils.isEmpty(r3) == true) goto L19;
        this.mHttpDnsDomain = r3;
    L19:
        JSONArray r5 = r8.optJSONArray("ttnet_tt_http_dns_preload_batch_host");
        if (r5 == null) goto L28;
        this.mPreResolveHosts.clear();
        int r6 = 0;
    L23:
        if (r6 >= r5.length()) goto L28;
        String r7 = r5.optString(r6);
        if (TextUtils.isEmpty(r7) == true) goto L27;
        this.mPreResolveHosts.add(r7);
    L27:
        r6 = r6 + 1;
    L28:
        int r9 = r8.optInt("localdns_cache_ttl", -1);
        if (r9 < 0) goto L31;
        this.mLocalDnsCacheTTL.set(r9);
    L31:
        int r10 = r8.optInt("httpdns_prefer_time_ms", -1);
        if (r10 < 0) goto L34;
        this.mHttpDnsPreferInterval.set(r10);
    L34:
        int r11 = r8.optInt("httpdns_stale_cache_interval", -1);
        if (r11 < 0) goto L37;
        this.mHttpDnsRefreshStaleCacheInterval.set(r11);
    L37:
        int r12 = r8.optInt("enable_compare_localdns_httpdns", -1);
        if (r12 < 0) goto L40;
        this.mEnableCompareLocalDnsHttpDns.set(r12);
    L40:
        int r13 = r8.optInt("ttnet_http_dns_prefer", -1);
        if (r13 < 0) goto L46;
        AtomicBoolean r14 = this.mIsHttpDnsPrefer;
        if (r13 != 1) goto L45;
        r2 = true;
    L45:
        r14.set(r2);
    L46:
        int r15 = r8.optInt("ttnet_http_dns_timeout", -1);
        if (r15 < 0) goto L49;
        this.mHttpDnsTimeout.set(r15);
    L49:
        int r16 = r8.optInt("ttnet_local_dns_time_out", -1);
        if (r16 < 0) goto L52;
        this.mLocalDnsTimeout.set(r16);
    L52:
        JSONObject r17 = r8.optJSONObject("ttnet_http_dns_addr");
        if (r17 == null) goto L79;
        this.mHardCodeIps.clear();
        Iterator<String> r18 = r17.keys();
    L56:
        if (r18.hasNext() == false) goto L81;
        String r19 = r18.next();
        String r20 = r17.optString(r19);
        if (TextUtils.isEmpty(r19) == true) goto L56;
        if (TextUtils.isEmpty(r20) == true) goto L56;
        String[] r21 = r20.split(",");
        if (r19.equals(this.mHttpDnsDomain) == true) goto L63;
        this.mHardCodeIps.put(r19, new CopyOnWriteArrayList(Arrays.asList(r21)));
        goto L56
    L63:
        this.mHttpdnsDomainHardCodeIps.clear();
        this.mHttpdnsDomainHardCodeIps.addAll(Arrays.asList(r21));
        goto L56
    L81:
        return;
    L79:
        return;
    L80:
        return;
    }

    private Future<Void> submitHttpDnsAndLocalDnsResolve(String r8, List<Boolean> r9, boolean r10) {
        DnsRecord r0 = this.mHostResolveManager.getLocalDnsCache(r8);
        if (r0 != null) goto L5;
    L6:
        r9.set(0, true);
        if (this.mHostResolveManager.isLocalDnsResolving(r8) == true) goto L10;
        submitLocalDnsResolve(r8);
    L10:
        if (this.mHostResolveManager.isHttpDnsResolving(r8) == true) goto L12;
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L17:
        if (this.mHostResolveManager.isHttpDnsResolving(r8) == false) goto L19;
        Future<Void> r11 = this.mHostResolveManager.getHttpDnsResolvingFuture(r8);     // Catch: Throwable -> L23
    L20:
        monitor-exit(this);     // Catch: Throwable -> L23
        return r11;
    L19:
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L23
        r12.add(r8);     // Catch: Throwable -> L23
        r11 = submitHttpDnsResolve(r12, DnsRecord.CacheStaleReason.CACHE_UNSET, r10);     // Catch: Throwable -> L23
        goto L20
    L12:
        if (Logger.debug() == false) goto L28;
        Logger.d(TAG, "httpdns is resolving for host " + r8);
    L28:
        return this.mHostResolveManager.getHttpDnsResolvingFuture(r8);
    L5:
        if ((r0.getFetchTime() + (r0.getTTL() * 1000)) > (System.currentTimeMillis() + ((long) this.mHttpDnsPreferInterval.get()))) goto L10;
        goto L6
    }

    synchronized Future<Void> submitHttpDnsResolve(List<String> r9, DnsRecord.CacheStaleReason r10, boolean r11) {
        monitor-enter(this);
        Future<Void> r0 = null;
        if (r9 == null) goto L43;
    L47:
        th = move-exception;
        throw th;
    L6:
        if (r9.size() == 0) goto L43;
        int r1 = 0;
    L10:
        if (r1 >= r9.size()) goto L23;
        if (this.mHostResolveManager.isHttpDnsResolving(r9.get(r1)) == false) goto L21;
        if (r11 == true) goto L15;
    L20:
        r9.remove(r9.get(r1));     // Catch: Throwable -> L47
        goto L21
    L15:
        if (r9.size() != 1) goto L20;
        if (r1 != 0) goto L20;
        r0 = this.mHostResolveManager.getHttpDnsResolvingFuture(r9.get(r1));     // Catch: Throwable -> L47
        if (Logger.debug() == false) goto L20;
        Logger.d(TAG, "sync block request for " + r9.get(r1) + " is resolving");     // Catch: Throwable -> L47
    L21:
        r1 = r1 + 1;     // Catch: Throwable -> L47
        goto L10
    L23:
        if (r9.size() != 0) goto L27;
        monitor-exit(this);
        return r0;
    L27:
        if (Logger.debug() == false) goto L50;
        Logger.d(TAG, "submit httpdns resolve for host : " + r9);     // Catch: Throwable -> L47
    L50:
        r0 = mThreadPool.submit(new HttpDnsResolveCall(HttpDnsUtil.transHostList2String(r9), mSdkVersion, this.mHostResolveManager, r10, mHttpDnsHandler));     // Catch: RejectedExecutionException -> L36 Throwable -> L47
        Iterator<String> r12 = r9.iterator();     // Catch: RejectedExecutionException -> L36 Throwable -> L47
    L31:
        if (r12.hasNext() == false) goto L40;
        String r13 = r12.next();     // Catch: RejectedExecutionException -> L36 Throwable -> L47
        this.mHostResolveManager.addHttpDnsResolvingFuture(r13, r0);     // Catch: RejectedExecutionException -> L36 Throwable -> L47
        if (this.mIsHttpDnsPrefer.get() == false) goto L31;
        this.mHostResolveManager.removeHttpDnsStaleCacheHost(r13);     // Catch: RejectedExecutionException -> L36 Throwable -> L47
    L40:
        monitor-exit(this);
        return r0;
    L36:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L47
        if (Logger.debug() == false) goto L40;
        Logger.d(TAG, "submit httpdns resolve for host : " + r9 + " was rejected");     // Catch: Throwable -> L47
    L43:
        if (Logger.debug() == false) goto L45;
        Logger.d(TAG, "httpdns resolve hostlist is null.");     // Catch: Throwable -> L47
    L45:
        monitor-exit(this);
        return null;
    }

    private synchronized Future<Void> submitLocalDnsResolve(String r6) {
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (this.mHostResolveManager.isLocalDnsResolving(r6) == false) goto L13;
        if (Logger.debug() == false) goto L9;
        Logger.d(TAG, "localdns is resolving for host : " + r6);     // Catch: Throwable -> L22
    L9:
        Future<Void> r7 = this.mHostResolveManager.getLocalDnsResolvingFuture(r6);     // Catch: Throwable -> L22
        monitor-exit(this);
        return r7;
    L13:
        if (Logger.debug() == false) goto L15;
        Logger.d(TAG, "submit localdns resolve host : " + r6);     // Catch: Throwable -> L22
    L15:
        Future<Void> r0 = null;
        r0 = mThreadPool.submit(new LocalDnsResolveCall(r6, this.mHostResolveManager, mHttpDnsHandler));     // Catch: RejectedExecutionException -> L18 Throwable -> L22
        this.mHostResolveManager.addLocalDnsResolvingFuture(r6, r0);     // Catch: RejectedExecutionException -> L18 Throwable -> L22
    L20:
        monitor-exit(this);
        return r0;
    L18:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L22
        goto L20
    }

    private DnsResult getDnsResultInHttpDnsPreferTime(Future<Void> r5, String r6, boolean r7) {
        if (Logger.debug() == false) goto L36;
        Logger.d(TAG, "getDnsResultInHttpDnsPreferTime");
    L36:
        if (r5 != null) goto L12;
        if (Logger.debug() == false) goto L10;
        Logger.d(TAG, "httpdns future is null");     // Catch: TimeoutException -> L23 ExecutionException -> L27 InterruptedException -> L31
    L10:
        return lookupLocalDnsCache(r6, r7);
    L12:
        if (r5.isDone() == true) goto L14;
        r5.get(getService().getHttpDnsPreferInterval().get(), TimeUnit.MILLISECONDS);     // Catch: TimeoutException -> L23 ExecutionException -> L27 InterruptedException -> L31
        DnsResult r8 = lookupHttpDnsCache(r6, true);     // Catch: TimeoutException -> L23 ExecutionException -> L27 InterruptedException -> L31
        if (r8 == null) goto L42;
        return r8;
    L42:
        return lookupLocalDnsCache(r6, r7);
    L14:
        if (Logger.debug() == false) goto L16;
        Logger.d(TAG, "httpdns future is done");     // Catch: TimeoutException -> L23 ExecutionException -> L27 InterruptedException -> L31
    L16:
        DnsResult r9 = lookupHttpDnsCache(r6, true);     // Catch: TimeoutException -> L23 ExecutionException -> L27 InterruptedException -> L31
        if (r9 == null) goto L38;
        return r9;
    L38:
        return lookupLocalDnsCache(r6, r7);
    L32:
        if (Logger.debug() == false) goto L35;
        Logger.d(TAG, "httpdns InterruptedException, look up localdns");
    L35:
        return lookupLocalDnsCache(r6, r7);
    L28:
        if (Logger.debug() == false) goto L41;
        Logger.d(TAG, "httpdns ExecutionException, look up localdns");
    L41:
        return lookupLocalDnsCache(r6, r7);
    L24:
        if (Logger.debug() == false) goto L40;
        Logger.d(TAG, "httpdns timeout in httpdns prefer time, look up localdns");
    L40:
        return lookupLocalDnsCache(r6, r7);
    }

    private DnsResult lookupLocalDnsCache(String r4, boolean r5) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "lookup localdns cache for host " + r4);
    L5:
        DnsResult r0 = new DnsResult();
        DnsRecord r3 = this.mHostResolveManager.getLocalDnsCache(r4);
        if (r3 != null) goto L9;
        return null;
    L9:
        r0.ipv4List = r3.getIpv4List();
        r0.ipv6List = r3.getIpv6List();
        if (r5 == false) goto L12;
        r0.source = DnsResult.Source.LOCALDNS_REQUEST;
    L13:
        return r0;
    L12:
        r0.source = DnsResult.Source.LOCALDNS_CACHE;
        goto L13
    }

    private DnsResult lookupHttpDnsCache(String r6, boolean r7) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "look up httpdns cache for host " + r6);
    L5:
        DnsRecord r5 = this.mHostResolveManager.getHttpDnsCache(r6);
        if (r5 != null) goto L8;
        return null;
    L8:
        DnsResult r0 = new DnsResult();
        r0.ipv4List = r5.getIpv4List();
        r0.ipv6List = r5.getIpv6List();
        if (r7 == false) goto L16;
        if (((r5.getTTL() * 1000) + r5.getFetchTime()) <= System.currentTimeMillis()) goto L14;
        r0.source = DnsResult.Source.HTTPDNS_REQUEST;
        return r0;
    L14:
        return null;
    L16:
        if (((r5.getTTL() * 1000) + r5.getFetchTime()) <= System.currentTimeMillis()) goto L18;
        r0.source = DnsResult.Source.HTTPDNS_CACHE;
    L19:
        return r0;
    L18:
        r0.source = DnsResult.Source.HTTPDNS_STALE_CACHE;
        goto L19
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r13) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "httpdns handler handle msg in " + Thread.currentThread().getName());
    L5:
        if (r13 != null) goto L7;
        return;
    L7:
        if ((r13.obj instanceof HttpDns) == false) goto L9;
    L230:
    L225:
        th = move-exception;
        th.printStackTrace();
        return;
    L19:
        if ((r13.obj instanceof HttpDns) == false) goto L38;
        if (r13.what != 2) goto L38;
        if (Logger.debug() == false) goto L25;
        Logger.d(TAG, "MSG_HTTPDNS_PREFER_TIMEOUT");     // Catch: Throwable -> L225
    L25:
        HostResolveJob r14 = (HostResolveJob) r13.getData().getSerializable(MSG_HTTPDNS_PREFER_TIMEOUT_JOB_KEY);     // Catch: Throwable -> L225
        if (r14 != null) goto L32;
        if (Logger.debug() == false) goto L246;
        Logger.d(TAG, "MSG_HTTPDNS_PREFER_TIMEOUT job is null");     // Catch: Throwable -> L225
        return;
    L246:
        return;
    L32:
        if (this.mHostResolveManager.shouldHttpDnsTimeoutCallback(r14) == true) goto L34;
        return;
    L34:
        if (Logger.debug() == false) goto L36;
        Logger.d(TAG, "httpdns request not return in httpdns prefer time for host : " + r14.getHost());     // Catch: Throwable -> L225
    L36:
        callbackDnsResultInMainthread(r14, lookupLocalDnsCache(r14.getHost(), r14.isLocalDnsExpired()));     // Catch: Throwable -> L225
        this.mHostResolveManager.removeHttpDnsJob(r14);     // Catch: Throwable -> L225
        return;
    L38:
        if ((r13.obj instanceof HttpDnsResolveCall) == true) goto L40;
    L70:
        int r11 = 0;
        if ((r13.obj instanceof LocalDnsResolveCall) == false) goto L104;
        if (r13.what != 1) goto L104;
        if (Logger.debug() == false) goto L77;
        Logger.d(TAG, "MSG_LOCALDNS_COMPLETED");     // Catch: Throwable -> L225
    L77:
        String r15 = r13.getData().getString(LocalDnsResolveCall.MSG_LOCALDNS_COMPLETED_HOST_KEY);     // Catch: Throwable -> L225
        if (r15 != null) goto L84;
        if (Logger.debug() == false) goto L248;
        Logger.d(TAG, "MSG_HTTPDNS_COMPLETED host is null");     // Catch: Throwable -> L225
        return;
    L248:
        return;
    L84:
        if (this.mHostResolveManager.shouldLocalDnsCallback(r15) == true) goto L86;
        return;
    L86:
        if (Logger.debug() == false) goto L88;
        Logger.d(TAG, "localdns returned in localdns timeout for host : " + r15);     // Catch: Throwable -> L225
    L88:
        Iterator<HostResolveJob> r0 = this.mHostResolveManager.getLocalDnsJobs(r15).iterator();     // Catch: Throwable -> L225
    L90:
        if (r0.hasNext() == false) goto L277;
        HostResolveJob r1 = r0.next();     // Catch: Throwable -> L225
        DnsResult r2 = lookupLocalDnsCache(r15, true);     // Catch: Throwable -> L225
        if (r2 != null) goto L98;
        DnsResult r3 = lookupHttpDnsCache(r15, false);     // Catch: Throwable -> L225
        if (r3 != null) goto L96;
        submitHttpDnsTaskForLocalDnsPreferReq(r1);     // Catch: Throwable -> L225
        this.mHostResolveManager.addHttpDnsJob(r1.getHost(), r1);     // Catch: Throwable -> L225
    L101:
        this.mHostResolveManager.removeLocalDnsJob(r1);     // Catch: Throwable -> L225
        goto L90
    L96:
        callbackDnsResultInMainthread(r1, r3);     // Catch: Throwable -> L225
        goto L101
    L98:
        if (Logger.debug() == false) goto L100;
        Logger.d(TAG, "localdns request is returned in timeout for " + r15);     // Catch: Throwable -> L225
    L100:
        callbackDnsResultInMainthread(r1, r2);     // Catch: Throwable -> L225
        goto L101
    L277:
        return;
    L104:
        if ((r13.obj instanceof HttpDns) == false) goto L130;
        if (r13.what != 3) goto L130;
        if (Logger.debug() == false) goto L110;
        Logger.d(TAG, "MSG_LOCALDNS_REQUEST_TIMEOUT");     // Catch: Throwable -> L225
    L110:
        HostResolveJob r16 = (HostResolveJob) r13.getData().getSerializable(MSG_DNS_TIMEOUT_JOB_KEY);     // Catch: Throwable -> L225
        if (r16 != null) goto L117;
        if (Logger.debug() == false) goto L249;
        Logger.d(TAG, "MSG_HTTPDNS_PREFER_TIMEOUT job is null");     // Catch: Throwable -> L225
        return;
    L249:
        return;
    L117:
        if (this.mHostResolveManager.shouldLocalDnsTimeoutCallback(r16) == true) goto L119;
        return;
    L119:
        if (Logger.debug() == false) goto L121;
        Logger.d(TAG, "local request not return in localdns timeout for host : " + r16.getHost());     // Catch: Throwable -> L225
    L121:
        DnsResult r4 = lookupHttpDnsCache(r16.getHost(), false);     // Catch: Throwable -> L225
        if (r4 == null) goto L125;
        callbackDnsResultInMainthread(r16, r4);     // Catch: Throwable -> L225
    L128:
        this.mHostResolveManager.removeLocalDnsJob(r16);     // Catch: Throwable -> L225
        return;
    L125:
        if (this.mHostResolveManager.isHttpDnsResolving(r16.getHost()) == true) goto L127;
        submitHttpDnsTaskForLocalDnsPreferReq(r16);     // Catch: Throwable -> L225
    L127:
        this.mHostResolveManager.addHttpDnsJob(r16.getHost(), r16);     // Catch: Throwable -> L225
    L130:
        if ((r13.obj instanceof HttpDns) == false) goto L146;
        if (r13.what != 4) goto L146;
        if (Logger.debug() == false) goto L136;
        Logger.d(TAG, "MSG_HTTPDNS_REQUEST_TIMEOUT");     // Catch: Throwable -> L225
    L136:
        HostResolveJob r17 = (HostResolveJob) r13.getData().getSerializable(MSG_DNS_TIMEOUT_JOB_KEY);     // Catch: Throwable -> L225
        if (r17 != null) goto L143;
        if (Logger.debug() == false) goto L250;
        Logger.d(TAG, "MSG_HTTPDNS_PREFER_TIMEOUT job is null");     // Catch: Throwable -> L225
        return;
    L250:
        return;
    L143:
        if (this.mHostResolveManager.shouldHttpDnsTimeoutCallback(r17) == false) goto L258;
        callbackDnsResultInMainthread(r17, null);     // Catch: Throwable -> L225
        this.mHostResolveManager.removeHttpDnsJob(r17);     // Catch: Throwable -> L225
        return;
    L258:
        return;
    L146:
        if ((r13.obj instanceof HttpDns) == false) goto L171;
        if (r13.what != 5) goto L171;
        if (Logger.debug() == false) goto L152;
        Logger.d(TAG, "MSG_LOAD_LOCAL_HARDCODEIPS");     // Catch: Throwable -> L225
    L152:
        String r18 = this.mHttpDnsDepend.getContext().getSharedPreferences(HTTPDNS_HARDCODEIP_SP_NAME, 0).getString(HTTPDNS_HARDCODEIP_SP_KEY, "");     // Catch: Throwable -> L225
        if (TextUtils.isEmpty(r18) == true) goto L166;
        this.mHttpdnsDomainHardCodeIps.clear();     // Catch: Throwable -> L225
        JSONArray r5 = new JSONArray(r18);     // Catch: JSONException -> L162 Throwable -> L225
    L157:
        if (r11 >= r5.length()) goto L278;
        String r19 = r5.optString(r11);     // Catch: JSONException -> L162 Throwable -> L225
        if (TextUtils.isEmpty(r19) == true) goto L161;
        this.mHttpdnsDomainHardCodeIps.add(r19);     // Catch: JSONException -> L162 Throwable -> L225
    L161:
        r11 = r11 + 1;
        goto L157
    L278:
        return;
    L163:
        if (Logger.debug() == false) goto L260;
        Logger.d(TAG, "local httpdns hardcode ips not exists, use default");     // Catch: Throwable -> L225
        return;
    L260:
        return;
    L166:
        if (this.mHttpDnsDepend.getHardCodeIps() != null) goto L168;
        return;
    L168:
        if (this.mHttpdnsDomainHardCodeIps.size() != 0) goto L263;
        this.mHttpdnsDomainHardCodeIps.addAll(Arrays.asList(this.mHttpDnsDepend.getHardCodeIps()));     // Catch: Throwable -> L225
        return;
    L263:
        return;
    L171:
        if ((r13.obj instanceof HttpDns) == false) goto L179;
        if (r13.what != 6) goto L179;
        if (Logger.debug() == false) goto L177;
        Logger.d(TAG, "network changed");     // Catch: Throwable -> L225
    L177:
        this.mHostResolveManager.onNetworkChanged(getService().getHttpDnsDepend().getContext());     // Catch: Throwable -> L225
        return;
    L179:
        if ((r13.obj instanceof HttpDns) == false) goto L187;
        if (r13.what != 7) goto L187;
        if (Logger.debug() == false) goto L185;
        Logger.d(TAG, "activity resume, detect ipv6 reachable");     // Catch: Throwable -> L225
    L185:
        submitIpv6Detect();     // Catch: Throwable -> L225
        return;
    L187:
        if ((r13.obj instanceof DnsRecord) == false) goto L214;
        String r12 = r13.getData().getString(DnsRecord.MSG_DNSRECORD_HOST);     // Catch: Throwable -> L225
        if (TextUtils.isEmpty(r12) == false) goto L195;
        if (Logger.debug() == false) goto L251;
        Logger.d(TAG, "DnsRecord refresh host is null");     // Catch: Throwable -> L225
        return;
    L251:
        return;
    L195:
        switch(r13.what) {
            case 10: goto L210;
            case 11: goto L206;
            case 12: goto L202;
            case 13: goto L198;
            default: goto L267;
        };     // Catch: Throwable -> L225
    L267:
        return;
    L198:
        if (Logger.debug() == false) goto L200;
        Logger.d(TAG, "remove httpdns cache for host : " + r12);     // Catch: Throwable -> L225
    L200:
        getService().removeHttpDnsCache(r12);     // Catch: Throwable -> L225
        return;
    L202:
        if (Logger.debug() == false) goto L204;
        Logger.d(TAG, "add host : " + r12 + " to stale cache host list");     // Catch: Throwable -> L225
    L204:
        getService().addHttpDnsStaleCacheHost(r12);     // Catch: Throwable -> L225
        return;
    L206:
        if (Logger.debug() == false) goto L208;
        Logger.d(TAG, "remove localdns cache for host : " + r12);     // Catch: Throwable -> L225
    L208:
        getService().removeLocalDnsStaleCache(r12);     // Catch: Throwable -> L225
        return;
    L210:
        if (Logger.debug() == false) goto L212;
        Logger.d(TAG, "refresh httpdns cache for host : " + r12);     // Catch: Throwable -> L225
    L212:
        getService().refreshHttpDnsCache(r12);     // Catch: Throwable -> L225
        return;
    L214:
        if ((r13.obj instanceof HostResolveManager) == false) goto L222;
        if (r13.what != 20) goto L222;
        if (Logger.debug() == false) goto L220;
        Logger.d(TAG, "reset httpdns domain failed count");     // Catch: Throwable -> L225
    L220:
        this.mHostResolveManager.resetHttpDnsDomainFailedCnt();     // Catch: Throwable -> L225
        return;
    L222:
        if (Logger.debug() == false) goto L273;
        Logger.d(TAG, "HTTPDNS-CollectResult handler thread receive a unknown message : " + r13);     // Catch: Throwable -> L225
        return;
    L273:
        return;
    L40:
        if (r13.what != 3) goto L70;
        if (Logger.debug() == false) goto L44;
        Logger.d(TAG, "MSG_HTTPDNS_COMPLETED");     // Catch: Throwable -> L225
    L44:
        ArrayList<String> r110 = r13.getData().getStringArrayList(HttpDnsResolveCall.MSG_HTTPDDNS_COMPLETED_HOSTS_KEY);     // Catch: Throwable -> L225
        if (r110 == null) goto L47;
        Iterator<String> r6 = r110.iterator();     // Catch: Throwable -> L225
    L52:
        if (r6.hasNext() == false) goto L276;
        String r7 = r6.next();     // Catch: Throwable -> L225
        if (this.mHostResolveManager.shouldHttpDnsCallback(r7) == false) goto L52;
        if (Logger.debug() == false) goto L59;
        Logger.d(TAG, "httpdns returned in httpdns prefer time for host : " + r110);     // Catch: Throwable -> L225
    L59:
        Iterator<HostResolveJob> r8 = this.mHostResolveManager.getHttpDnsJobs(r7).iterator();     // Catch: Throwable -> L225
    L61:
        if (r8.hasNext() == false) goto L52;
        HostResolveJob r9 = r8.next();     // Catch: Throwable -> L225
        DnsResult r10 = lookupHttpDnsCache(r7, true);     // Catch: Throwable -> L225
        if (getService().isHttpDnsPrefer().get() == false) goto L67;
        if (r10 != null) goto L67;
        r10 = lookupLocalDnsCache(r7, r9.isLocalDnsExpired());     // Catch: Throwable -> L225
    L67:
        if (Logger.debug() == false) goto L69;
        Logger.d(TAG, "httpdns request is returned in prefer time for " + r7);     // Catch: Throwable -> L225
    L69:
        callbackDnsResultInMainthread(r9, r10);     // Catch: Throwable -> L225
        this.mHostResolveManager.removeHttpDnsJob(r9);     // Catch: Throwable -> L225
        goto L61
    L276:
        return;
    L47:
        if (Logger.debug() == false) goto L247;
        Logger.d(TAG, "MSG_HTTPDNS_COMPLETED hostlist is null");     // Catch: Throwable -> L225
        return;
    L247:
        return;
    L9:
        if ((r13.obj instanceof HttpDnsResolveCall) == true) goto L230;
        if ((r13.obj instanceof LocalDnsResolveCall) == true) goto L230;
        if ((r13.obj instanceof DnsRecord) == true) goto L230;
        if ((r13.obj instanceof HostResolveManager) == true) goto L230;
    }

    private void submitHttpDnsTaskForLocalDnsPreferReq(HostResolveJob r6) {
        ArrayList r0 = new ArrayList();
        r0.add(r6.getHost());
        submitHttpDnsResolve(r0, DnsRecord.CacheStaleReason.CACHE_UNSET, false);
        Message r1 = Message.obtain();
        r1.what = 4;
        r1.obj = this;
        Bundle r2 = new Bundle();
        r2.putSerializable(MSG_DNS_TIMEOUT_JOB_KEY, r6);
        r1.setData(r2);
        mHttpDnsHandler.sendMessageDelayed(r1, ((long) this.mHttpDnsTimeout.get()) * 1000);
    }

    private void callbackDnsResultInMainthread(HostResolveJob r4, DnsResult r5) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "doDnsResultCallback for host " + r4.getHost());
    L5:
        Message r0 = Message.obtain();
        r0.obj = this;
        r0.what = 1;
        Bundle r1 = new Bundle();
        r1.putSerializable(MSG_CALLBACK_DNSRESULT_JOB_KEY, r4);
        r1.putSerializable(MSG_CALLBACK_DNSRESULT_KEY, r5);
        r0.setData(r1);
        this.mMainThreadHandler.sendMessage(r0);
    }

    AtomicInteger getHttpDnsPreferInterval() {
        return this.mHttpDnsPreferInterval;
    }

    AtomicInteger getLocalDnsCacheTTL() {
        return this.mLocalDnsCacheTTL;
    }

    AtomicInteger getHttpDnsRefreshStaleCacheInterval() {
        return this.mHttpDnsRefreshStaleCacheInterval;
    }

    public IHttpDnsDepend getHttpDnsDepend() {
        return this.mHttpDnsDepend;
    }

    String getHttpDnsDomain() {
        return this.mHttpDnsDomain;
    }

    ConcurrentSkipListSet<String> getHttpDnsDomainHardCodeIps() {
        return this.mHttpdnsDomainHardCodeIps;
    }

    void setHttpDnsHardCodeIps(JSONArray r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.length() <= 0) goto L18;
        this.mHttpdnsDomainHardCodeIps.clear();
        int r1 = 0;
    L7:
        if (r1 >= r5.length()) goto L12;
        String r2 = r5.optString(r1);
        if (TextUtils.isEmpty(r2) == true) goto L11;
        this.mHttpdnsDomainHardCodeIps.add(r2);
    L11:
        r1 = r1 + 1;
        goto L7
    L12:
        SharedPreferences.Editor r4 = this.mHttpDnsDepend.getContext().getSharedPreferences(HTTPDNS_HARDCODEIP_SP_NAME, 0).edit();
        r4.putString(HTTPDNS_HARDCODEIP_SP_KEY, String.valueOf(r5));
        r4.apply();
        return;
    }

    public AtomicBoolean isHttpDnsPrefer() {
        return this.mIsHttpDnsPrefer;
    }

    public void onResume() {
        Message r0 = Message.obtain();
        r0.obj = this;
        r0.what = 7;
        mHttpDnsHandler.sendMessage(r0);
    }

    public void onNetworkChanged() {
        Message r0 = Message.obtain();
        r0.obj = this;
        r0.what = 6;
        mHttpDnsHandler.sendMessage(r0);
    }

    void submitIpv6Detect() {
        mThreadPool.submit(new Ipv6DetectCall());     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public HandlerThread getHttpDnsHandlerThread() {
        return mHttpDnsHandlerThread;
    }
}
