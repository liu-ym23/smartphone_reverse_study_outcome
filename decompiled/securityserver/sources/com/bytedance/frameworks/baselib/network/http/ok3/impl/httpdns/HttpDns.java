package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import a.a;
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

/* JADX INFO: loaded from: classes.dex */
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

    static {
        mThreadPool = Executors.newFixedThreadPool(6);
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
        WeakHandler r2 = new WeakHandler(mHttpDnsHandlerThread.getLooper(), this);
        mHttpDnsHandler = r2;
        mSdkVersion = "4.2.228.16-pico";
        this.mHostResolveManager = new HostResolveManager(r2);
    }

    public static /* synthetic */ String access$000() {
        return TAG;
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

    private DnsResult getHardCodeIpResult(String r4) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "try to look up hardcode ips");
    L6:
        if (this.mHardCodeIps.containsKey(r4) == false) goto L21;
        DnsResult r0 = new DnsResult();
        Iterator<String> r3 = this.mHardCodeIps.get(r4).iterator();
    L9:
        if (r3.hasNext() == false) goto L19;
        String r5 = r3.next();
        if (IPAddressUtils.isValidIpv6(r5) == true) goto L12;
        if (IPAddressUtils.isValidIpv4(r5) == true) goto L15;
        if (Logger.debug() == false) goto L9;
        a.y("find a invalid hardcode ip: ", r5, TAG);
        goto L9
    L15:
        r0.ipv4List.add(r5);
        goto L9
    L12:
        r0.ipv6List.add(r5);
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

    public static HttpDns getService() {
        if (mInstance != null) goto L16;
        monitor-enter(HttpDns.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L11;
        mInstance = new HttpDns();     // Catch: Throwable -> L9
    L11:
        monitor-exit(HttpDns.class);     // Catch: Throwable -> L9
    L16:
        return mInstance;
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

    private DnsResult lookupHttpDnsCache(String r6, boolean r7) {
        if (Logger.debug() == false) goto L5;
        a.y("look up httpdns cache for host ", r6, TAG);
    L5:
        DnsRecord r5 = this.mHostResolveManager.getHttpDnsCache(r6);
        if (r5 != null) goto L8;
        return null;
    L8:
        DnsResult r0 = new DnsResult();
        r0.ipv4List = r5.getIpv4List();
        r0.ipv6List = r5.getIpv6List();
        if (r7 == false) goto L15;
        long r3 = r5.getTTL() * 1000;
        if ((r5.getFetchTime() + r3) <= System.currentTimeMillis()) goto L14;
        r0.source = DnsResult.Source.HTTPDNS_REQUEST;
        return r0;
    L14:
        return null;
    L15:
        long r8 = r5.getTTL() * 1000;
        if ((r5.getFetchTime() + r8) <= System.currentTimeMillis()) goto L18;
        r0.source = DnsResult.Source.HTTPDNS_CACHE;
    L19:
        return r0;
    L18:
        r0.source = DnsResult.Source.HTTPDNS_STALE_CACHE;
        goto L19
    }

    private DnsResult lookupLocalDnsCache(String r3, boolean r4) {
        if (Logger.debug() == false) goto L5;
        a.y("lookup localdns cache for host ", r3, TAG);
    L5:
        DnsResult r0 = new DnsResult();
        DnsRecord r2 = this.mHostResolveManager.getLocalDnsCache(r3);
        if (r2 != null) goto L9;
        return null;
    L9:
        r0.ipv4List = r2.getIpv4List();
        r0.ipv6List = r2.getIpv6List();
        if (r4 == false) goto L12;
        r0.source = DnsResult.Source.LOCALDNS_REQUEST;
    L13:
        return r0;
    L12:
        r0.source = DnsResult.Source.LOCALDNS_CACHE;
        goto L13
    }

    private Future<Void> submitHttpDnsAndLocalDnsResolve(String r8, List<Boolean> r9, boolean r10) {
        DnsRecord r0 = this.mHostResolveManager.getLocalDnsCache(r8);
        if (r0 == null) goto L6;
        long r1 = r0.getFetchTime();
        if (((r0.getTTL() * 1000) + r1) <= (System.currentTimeMillis() + ((long) this.mHttpDnsPreferInterval.get()))) goto L6;
    L10:
        if (this.mHostResolveManager.isHttpDnsResolving(r8) == true) goto L12;
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L17:
        if (this.mHostResolveManager.isHttpDnsResolving(r8) == false) goto L21;
        Future<Void> r11 = this.mHostResolveManager.getHttpDnsResolvingFuture(r8);     // Catch: Throwable -> L19
    L22:
        monitor-exit(this);     // Catch: Throwable -> L19
        return r11;
    L21:
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L19
        r12.add(r8);     // Catch: Throwable -> L19
        r11 = submitHttpDnsResolve(r12, DnsRecord.CacheStaleReason.CACHE_UNSET, r10);     // Catch: Throwable -> L19
        goto L22
    L12:
        if (Logger.debug() == false) goto L29;
        a.y("httpdns is resolving for host ", r8, TAG);
    L29:
        return this.mHostResolveManager.getHttpDnsResolvingFuture(r8);
    L6:
        r9.set(0, Boolean.TRUE);
        if (this.mHostResolveManager.isLocalDnsResolving(r8) == true) goto L10;
        submitLocalDnsResolve(r8);
        goto L10
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

    private synchronized Future<Void> submitLocalDnsResolve(String r6) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mHostResolveManager.isLocalDnsResolving(r6) == false) goto L15;
        if (Logger.debug() == false) goto L11;
        Logger.d(TAG, "localdns is resolving for host : " + r6);     // Catch: Throwable -> L9
    L11:
        Future<Void> r7 = this.mHostResolveManager.getLocalDnsResolvingFuture(r6);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r7;
    L15:
        if (Logger.debug() == false) goto L17;
        Logger.d(TAG, "submit localdns resolve host : " + r6);     // Catch: Throwable -> L9
    L17:
        Future<Void> r0 = null;
        r0 = mThreadPool.submit(new LocalDnsResolveCall(r6, this.mHostResolveManager, mHttpDnsHandler));     // Catch: Throwable -> L9 RejectedExecutionException -> L20
        this.mHostResolveManager.addLocalDnsResolvingFuture(r6, r0);     // Catch: Throwable -> L9 RejectedExecutionException -> L20
    L22:
        monitor-exit(this);
        return r0;
    L20:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L9
        goto L22
    }

    public void addHttpDnsStaleCacheHost(String r1) {
        this.mHostResolveManager.addHttpDnsStaleCacheHost(r1);
    }

    public void batchRefreshHttpDnsStaleCache(List<String> r4) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "batchRefreshHttpDnsStaleCache for host " + r4);
    L5:
        submitHttpDnsResolve(r4, DnsRecord.CacheStaleReason.REFRESH_BATCH, false);
    }

    public synchronized void doHttpDnsPreload(DnsRecord.CacheStaleReason r5) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.mHttpDnsDepend != null) goto L6;
    L36:
        monitor-exit(this);
        return;
    L6:
        if (ProcessUtils.isMainProcessByProcessFlag(this.mHttpDnsDepend.getContext()) == false) goto L36;
        ConcurrentSkipListSet<String> r0 = this.mPreResolveHosts;     // Catch: Throwable -> L17
        if (r0 == null) goto L36;
        if (r0.size() == 0) goto L36;
        if (this.mPreResolveHosts.size() > 10) goto L36;
        if (Logger.debug() == false) goto L19;
        Logger.d(TAG, "do httpdns preload");     // Catch: Throwable -> L17
    L19:
        Iterator<String> r1 = this.mPreResolveHosts.iterator();     // Catch: Throwable -> L17
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L17
    L21:
        if (r1.hasNext() == false) goto L27;
        String r3 = r1.next();     // Catch: Throwable -> L17
        if (this.mHostResolveManager.isHttpDnsResolving(r3) == true) goto L21;
        r2.add(r3);     // Catch: Throwable -> L17
        goto L21
    L27:
        if (r2.size() != 0) goto L31;
        monitor-exit(this);
        return;
    L31:
        if (Logger.debug() == false) goto L33;
        Logger.d(TAG, "httpdns batch preload for : " + r2);     // Catch: Throwable -> L17
    L33:
        submitHttpDnsResolve(r2, r5, false);     // Catch: Throwable -> L17
        monitor-exit(this);
    }

    public IHttpDnsDepend getHttpDnsDepend() {
        return this.mHttpDnsDepend;
    }

    public String getHttpDnsDomain() {
        return this.mHttpDnsDomain;
    }

    public ConcurrentSkipListSet<String> getHttpDnsDomainHardCodeIps() {
        return this.mHttpdnsDomainHardCodeIps;
    }

    public HandlerThread getHttpDnsHandlerThread() {
        return mHttpDnsHandlerThread;
    }

    public AtomicInteger getHttpDnsPreferInterval() {
        return this.mHttpDnsPreferInterval;
    }

    public AtomicInteger getHttpDnsRefreshStaleCacheInterval() {
        return this.mHttpDnsRefreshStaleCacheInterval;
    }

    public DnsResult getHttpDnsResultForHostAsync(String r7, IHttpDnsCallback r8) {
        if (Logger.debug() == false) goto L6;
        a.y("HttpDns::getHttpDnsResultForHostAsync for host ", r7, TAG);
    L6:
        if (invalidConfigure(r7) == false) goto L9;
        return null;
    L9:
        if (isHttpDnsPrefer().get() == false) goto L17;
        DnsResult r0 = lookupHttpDnsCache(r7, false);
        if (r0 != null) goto L13;
        ArrayList r1 = new ArrayList();
        r1.add(0, Boolean.FALSE);
        submitHttpDnsAndLocalDnsResolve(r7, r1, false);
        HostResolveJob r3 = new HostResolveJob(r7, r8, ((Boolean) r1.get(0)).booleanValue());
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

    public DnsResult getHttpDnsResultForHostSyncBlock(String r8) {
        if (Logger.debug() == false) goto L6;
        a.y("getHttpDnsResultForHostSyncBlock for host : ", r8, TAG);
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
        r2.add(0, Boolean.FALSE);
        DnsResult r3 = getDnsResultInHttpDnsPreferTime(submitHttpDnsAndLocalDnsResolve(r8, r2, true), r8, ((Boolean) r2.get(0)).booleanValue());
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

    public DnsResult getHttpDnsResultForHostSyncNonBlock(String r4) {
        if (Logger.debug() == false) goto L6;
        a.y("getHttpDnsResultForHostSyncNonBlock for host : ", r4, TAG);
    L6:
        if (invalidConfigure(r4) == false) goto L10;
        return null;
    L10:
        if (isHttpDnsPrefer().get() == false) goto L28;
        DnsResult r0 = lookupHttpDnsCache(r4, false);
        if (r0 == null) goto L15;
        return r0;
    L15:
        if (this.mHostResolveManager.isHttpDnsResolving(r4) == true) goto L27;
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L18:
        if (this.mHostResolveManager.isHttpDnsResolving(r4) == true) goto L22;
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L20
        r1.add(r4);     // Catch: Throwable -> L20
        submitHttpDnsResolve(r1, DnsRecord.CacheStaleReason.CACHE_UNSET, false);     // Catch: Throwable -> L20
    L22:
        monitor-exit(this);     // Catch: Throwable -> L20
    L27:
        return lookupLocalDnsCache(r4, false);
    L28:
        DnsResult r2 = lookupLocalDnsCache(r4, false);
        if (r2 == null) goto L32;
        return r2;
    L32:
        if (this.mHostResolveManager.isLocalDnsResolving(r4) == true) goto L44;
        monitor-enter(this);
    L37:
        th = move-exception;
        throw th;
    L35:
        if (this.mHostResolveManager.isLocalDnsResolving(r4) == true) goto L39;
        submitLocalDnsResolve(r4);     // Catch: Throwable -> L37
    L39:
        monitor-exit(this);     // Catch: Throwable -> L37
    L44:
        return lookupHttpDnsCache(r4, false);
    }

    public AtomicInteger getLocalDnsCacheTTL() {
        return this.mLocalDnsCacheTTL;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r14) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "httpdns handler handle msg in " + Thread.currentThread().getName());
    L5:
        if (r14 == null) goto L253;
        Object r8 = r14.obj;
        if ((r8 instanceof HttpDns) == false) goto L9;
    L229:
    L25:
        th = move-exception;
        th.printStackTrace();
        return;
    L19:
        if ((r8 instanceof HttpDns) == false) goto L40;
        if (r14.what != 2) goto L40;
        if (Logger.debug() == false) goto L27;
        Logger.d(TAG, "MSG_HTTPDNS_PREFER_TIMEOUT");     // Catch: Throwable -> L25
    L27:
        HostResolveJob r15 = (HostResolveJob) r14.getData().getSerializable(MSG_HTTPDNS_PREFER_TIMEOUT_JOB_KEY);     // Catch: Throwable -> L25
        if (r15 != null) goto L34;
        if (Logger.debug() == false) goto L247;
        Logger.d(TAG, "MSG_HTTPDNS_PREFER_TIMEOUT job is null");     // Catch: Throwable -> L25
        return;
    L247:
        return;
    L34:
        if (this.mHostResolveManager.shouldHttpDnsTimeoutCallback(r15) == true) goto L36;
        return;
    L36:
        if (Logger.debug() == false) goto L38;
        Logger.d(TAG, "httpdns request not return in httpdns prefer time for host : " + r15.getHost());     // Catch: Throwable -> L25
    L38:
        callbackDnsResultInMainthread(r15, lookupLocalDnsCache(r15.getHost(), r15.isLocalDnsExpired()));     // Catch: Throwable -> L25
        this.mHostResolveManager.removeHttpDnsJob(r15);     // Catch: Throwable -> L25
        return;
    L40:
        if ((r8 instanceof HttpDnsResolveCall) == true) goto L42;
    L72:
        int r12 = 0;
        if ((r8 instanceof LocalDnsResolveCall) == false) goto L106;
        if (r14.what != 1) goto L106;
        if (Logger.debug() == false) goto L79;
        Logger.d(TAG, "MSG_LOCALDNS_COMPLETED");     // Catch: Throwable -> L25
    L79:
        String r16 = r14.getData().getString(LocalDnsResolveCall.MSG_LOCALDNS_COMPLETED_HOST_KEY);     // Catch: Throwable -> L25
        if (r16 != null) goto L86;
        if (Logger.debug() == false) goto L249;
        Logger.d(TAG, "MSG_HTTPDNS_COMPLETED host is null");     // Catch: Throwable -> L25
        return;
    L249:
        return;
    L86:
        if (this.mHostResolveManager.shouldLocalDnsCallback(r16) == true) goto L88;
        return;
    L88:
        if (Logger.debug() == false) goto L90;
        Logger.d(TAG, "localdns returned in localdns timeout for host : ".concat(r16));     // Catch: Throwable -> L25
    L90:
        Iterator<HostResolveJob> r0 = this.mHostResolveManager.getLocalDnsJobs(r16).iterator();     // Catch: Throwable -> L25
    L92:
        if (r0.hasNext() == false) goto L278;
        HostResolveJob r1 = r0.next();     // Catch: Throwable -> L25
        DnsResult r2 = lookupLocalDnsCache(r16, true);     // Catch: Throwable -> L25
        if (r2 != null) goto L100;
        DnsResult r3 = lookupHttpDnsCache(r16, false);     // Catch: Throwable -> L25
        if (r3 != null) goto L98;
        submitHttpDnsTaskForLocalDnsPreferReq(r1);     // Catch: Throwable -> L25
        this.mHostResolveManager.addHttpDnsJob(r1.getHost(), r1);     // Catch: Throwable -> L25
    L103:
        this.mHostResolveManager.removeLocalDnsJob(r1);     // Catch: Throwable -> L25
        goto L92
    L98:
        callbackDnsResultInMainthread(r1, r3);     // Catch: Throwable -> L25
        goto L103
    L100:
        if (Logger.debug() == false) goto L102;
        Logger.d(TAG, "localdns request is returned in timeout for " + r16);     // Catch: Throwable -> L25
    L102:
        callbackDnsResultInMainthread(r1, r2);     // Catch: Throwable -> L25
        goto L103
    L278:
        return;
    L106:
        if ((r8 instanceof HttpDns) == false) goto L132;
        if (r14.what != 3) goto L132;
        if (Logger.debug() == false) goto L112;
        Logger.d(TAG, "MSG_LOCALDNS_REQUEST_TIMEOUT");     // Catch: Throwable -> L25
    L112:
        HostResolveJob r17 = (HostResolveJob) r14.getData().getSerializable(MSG_DNS_TIMEOUT_JOB_KEY);     // Catch: Throwable -> L25
        if (r17 != null) goto L119;
        if (Logger.debug() == false) goto L250;
        Logger.d(TAG, "MSG_HTTPDNS_PREFER_TIMEOUT job is null");     // Catch: Throwable -> L25
        return;
    L250:
        return;
    L119:
        if (this.mHostResolveManager.shouldLocalDnsTimeoutCallback(r17) == true) goto L121;
        return;
    L121:
        if (Logger.debug() == false) goto L123;
        Logger.d(TAG, "local request not return in localdns timeout for host : " + r17.getHost());     // Catch: Throwable -> L25
    L123:
        DnsResult r4 = lookupHttpDnsCache(r17.getHost(), false);     // Catch: Throwable -> L25
        if (r4 == null) goto L127;
        callbackDnsResultInMainthread(r17, r4);     // Catch: Throwable -> L25
    L130:
        this.mHostResolveManager.removeLocalDnsJob(r17);     // Catch: Throwable -> L25
        return;
    L127:
        if (this.mHostResolveManager.isHttpDnsResolving(r17.getHost()) == true) goto L129;
        submitHttpDnsTaskForLocalDnsPreferReq(r17);     // Catch: Throwable -> L25
    L129:
        this.mHostResolveManager.addHttpDnsJob(r17.getHost(), r17);     // Catch: Throwable -> L25
    L132:
        if ((r8 instanceof HttpDns) == false) goto L148;
        if (r14.what != 4) goto L148;
        if (Logger.debug() == false) goto L138;
        Logger.d(TAG, "MSG_HTTPDNS_REQUEST_TIMEOUT");     // Catch: Throwable -> L25
    L138:
        HostResolveJob r18 = (HostResolveJob) r14.getData().getSerializable(MSG_DNS_TIMEOUT_JOB_KEY);     // Catch: Throwable -> L25
        if (r18 != null) goto L145;
        if (Logger.debug() == false) goto L251;
        Logger.d(TAG, "MSG_HTTPDNS_PREFER_TIMEOUT job is null");     // Catch: Throwable -> L25
        return;
    L251:
        return;
    L145:
        if (this.mHostResolveManager.shouldHttpDnsTimeoutCallback(r18) == false) goto L259;
        callbackDnsResultInMainthread(r18, null);     // Catch: Throwable -> L25
        this.mHostResolveManager.removeHttpDnsJob(r18);     // Catch: Throwable -> L25
        return;
    L259:
        return;
    L148:
        if ((r8 instanceof HttpDns) == false) goto L173;
        if (r14.what != 5) goto L173;
        if (Logger.debug() == false) goto L154;
        Logger.d(TAG, "MSG_LOAD_LOCAL_HARDCODEIPS");     // Catch: Throwable -> L25
    L154:
        String r19 = this.mHttpDnsDepend.getContext().getSharedPreferences(HTTPDNS_HARDCODEIP_SP_NAME, 0).getString(HTTPDNS_HARDCODEIP_SP_KEY, "");     // Catch: Throwable -> L25
        if (TextUtils.isEmpty(r19) == true) goto L168;
        this.mHttpdnsDomainHardCodeIps.clear();     // Catch: Throwable -> L25
        JSONArray r5 = new JSONArray(r19);     // Catch: Throwable -> L25 JSONException -> L164
    L159:
        if (r12 >= r5.length()) goto L279;
        String r110 = r5.optString(r12);     // Catch: Throwable -> L25 JSONException -> L164
        if (TextUtils.isEmpty(r110) == true) goto L163;
        this.mHttpdnsDomainHardCodeIps.add(r110);     // Catch: Throwable -> L25 JSONException -> L164
    L163:
        r12 = r12 + 1;
        goto L159
    L279:
        return;
    L165:
        if (Logger.debug() == false) goto L261;
        Logger.d(TAG, "local httpdns hardcode ips not exists, use default");     // Catch: Throwable -> L25
        return;
    L261:
        return;
    L168:
        if (this.mHttpDnsDepend.getHardCodeIps() != null) goto L170;
        return;
    L170:
        if (this.mHttpdnsDomainHardCodeIps.size() != 0) goto L264;
        this.mHttpdnsDomainHardCodeIps.addAll(Arrays.asList(this.mHttpDnsDepend.getHardCodeIps()));     // Catch: Throwable -> L25
        return;
    L264:
        return;
    L173:
        if ((r8 instanceof HttpDns) == false) goto L181;
        if (r14.what != 6) goto L181;
        if (Logger.debug() == false) goto L179;
        Logger.d(TAG, "network changed");     // Catch: Throwable -> L25
    L179:
        this.mHostResolveManager.onNetworkChanged(getService().getHttpDnsDepend().getContext());     // Catch: Throwable -> L25
        return;
    L181:
        if ((r8 instanceof HttpDns) == false) goto L189;
        if (r14.what != 7) goto L189;
        if (Logger.debug() == false) goto L187;
        Logger.d(TAG, "activity resume, detect ipv6 reachable");     // Catch: Throwable -> L25
    L187:
        submitIpv6Detect();     // Catch: Throwable -> L25
        return;
    L189:
        if ((r8 instanceof DnsRecord) == false) goto L216;
        String r13 = r14.getData().getString(DnsRecord.MSG_DNSRECORD_HOST);     // Catch: Throwable -> L25
        if (TextUtils.isEmpty(r13) == false) goto L197;
        if (Logger.debug() == false) goto L252;
        Logger.d(TAG, "DnsRecord refresh host is null");     // Catch: Throwable -> L25
        return;
    L252:
        return;
    L197:
        switch(r14.what) {
            case 10: goto L212;
            case 11: goto L208;
            case 12: goto L204;
            case 13: goto L200;
            default: goto L268;
        };     // Catch: Throwable -> L25
    L268:
        return;
    L200:
        if (Logger.debug() == false) goto L202;
        Logger.d(TAG, "remove httpdns cache for host : " + r13);     // Catch: Throwable -> L25
    L202:
        getService().removeHttpDnsCache(r13);     // Catch: Throwable -> L25
        return;
    L204:
        if (Logger.debug() == false) goto L206;
        Logger.d(TAG, "add host : " + r13 + " to stale cache host list");     // Catch: Throwable -> L25
    L206:
        getService().addHttpDnsStaleCacheHost(r13);     // Catch: Throwable -> L25
        return;
    L208:
        if (Logger.debug() == false) goto L210;
        Logger.d(TAG, "remove localdns cache for host : " + r13);     // Catch: Throwable -> L25
    L210:
        getService().removeLocalDnsStaleCache(r13);     // Catch: Throwable -> L25
        return;
    L212:
        if (Logger.debug() == false) goto L214;
        Logger.d(TAG, "refresh httpdns cache for host : " + r13);     // Catch: Throwable -> L25
    L214:
        getService().refreshHttpDnsCache(r13);     // Catch: Throwable -> L25
        return;
    L216:
        if ((r8 instanceof HostResolveManager) == false) goto L224;
        if (r14.what != 20) goto L224;
        if (Logger.debug() == false) goto L222;
        Logger.d(TAG, "reset httpdns domain failed count");     // Catch: Throwable -> L25
    L222:
        this.mHostResolveManager.resetHttpDnsDomainFailedCnt();     // Catch: Throwable -> L25
        return;
    L224:
        if (Logger.debug() == false) goto L274;
        Logger.d(TAG, "HTTPDNS-CollectResult handler thread receive a unknown message : " + r14);     // Catch: Throwable -> L25
        return;
    L274:
        return;
    L42:
        if (r14.what != 3) goto L72;
        if (Logger.debug() == false) goto L46;
        Logger.d(TAG, "MSG_HTTPDNS_COMPLETED");     // Catch: Throwable -> L25
    L46:
        ArrayList<String> r111 = r14.getData().getStringArrayList(HttpDnsResolveCall.MSG_HTTPDDNS_COMPLETED_HOSTS_KEY);     // Catch: Throwable -> L25
        if (r111 == null) goto L49;
        Iterator<String> r6 = r111.iterator();     // Catch: Throwable -> L25
    L54:
        if (r6.hasNext() == false) goto L277;
        String r7 = r6.next();     // Catch: Throwable -> L25
        if (this.mHostResolveManager.shouldHttpDnsCallback(r7) == false) goto L54;
        if (Logger.debug() == false) goto L61;
        Logger.d(TAG, "httpdns returned in httpdns prefer time for host : " + r111);     // Catch: Throwable -> L25
    L61:
        Iterator<HostResolveJob> r9 = this.mHostResolveManager.getHttpDnsJobs(r7).iterator();     // Catch: Throwable -> L25
    L63:
        if (r9.hasNext() == false) goto L54;
        HostResolveJob r10 = r9.next();     // Catch: Throwable -> L25
        DnsResult r11 = lookupHttpDnsCache(r7, true);     // Catch: Throwable -> L25
        if (getService().isHttpDnsPrefer().get() == false) goto L69;
        if (r11 != null) goto L69;
        r11 = lookupLocalDnsCache(r7, r10.isLocalDnsExpired());     // Catch: Throwable -> L25
    L69:
        if (Logger.debug() == false) goto L71;
        Logger.d(TAG, "httpdns request is returned in prefer time for " + r7);     // Catch: Throwable -> L25
    L71:
        callbackDnsResultInMainthread(r10, r11);     // Catch: Throwable -> L25
        this.mHostResolveManager.removeHttpDnsJob(r10);     // Catch: Throwable -> L25
        goto L63
    L277:
        return;
    L49:
        if (Logger.debug() == false) goto L248;
        Logger.d(TAG, "MSG_HTTPDNS_COMPLETED hostlist is null");     // Catch: Throwable -> L25
        return;
    L248:
        return;
    L9:
        if ((r8 instanceof HttpDnsResolveCall) == true) goto L229;
        if ((r8 instanceof LocalDnsResolveCall) == true) goto L229;
        if ((r8 instanceof DnsRecord) == true) goto L229;
        if ((r8 instanceof HostResolveManager) == true) goto L229;
        return;
    }

    public AtomicBoolean isHttpDnsPrefer() {
        return this.mIsHttpDnsPrefer;
    }

    public void onNetworkChanged() {
        Message r0 = Message.obtain();
        r0.obj = this;
        r0.what = 6;
        mHttpDnsHandler.sendMessage(r0);
    }

    public void onResume() {
        Message r0 = Message.obtain();
        r0.obj = this;
        r0.what = 7;
        mHttpDnsHandler.sendMessage(r0);
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

    public void refreshHttpDnsCache(String r3) {
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

    public void removeHttpDnsCache(String r2) {
        if (HttpDnsUtil.isValidHost(r2) == true) goto L5;
        return;
    L5:
        if (this.mHostResolveManager.isHttpDnsResolving(r2) == true) goto L9;
        this.mHostResolveManager.removeHttpDnsCache(r2);
        return;
    }

    public void removeLocalDnsStaleCache(String r3) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "removeLocalDnsStaleCache");
    L6:
        if (HttpDnsUtil.isValidHost(r3) == false) goto L9;
        this.mHostResolveManager.removeLocalDnsCache(r3);
        return;
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

    public void setHttpDnsHardCodeIps(JSONArray r5) {
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

    public synchronized Future<Void> submitHttpDnsResolve(List<String> r9, DnsRecord.CacheStaleReason r10, boolean r11) {
        monitor-enter(this);
        Future<Void> r0 = null;
        if (r9 == null) goto L45;
    L20:
        th = move-exception;
        throw th;
    L6:
        if (r9.size() == 0) goto L45;
        int r1 = 0;
    L10:
        if (r1 >= r9.size()) goto L25;
        if (this.mHostResolveManager.isHttpDnsResolving(r9.get(r1)) == false) goto L23;
        if (r11 == true) goto L15;
    L22:
        r9.remove(r9.get(r1));     // Catch: Throwable -> L20
        goto L23
    L15:
        if (r9.size() != 1) goto L22;
        if (r1 != 0) goto L22;
        r0 = this.mHostResolveManager.getHttpDnsResolvingFuture(r9.get(r1));     // Catch: Throwable -> L20
        if (Logger.debug() == false) goto L22;
        Logger.d(TAG, "sync block request for " + r9.get(r1) + " is resolving");     // Catch: Throwable -> L20
    L23:
        r1 = r1 + 1;     // Catch: Throwable -> L20
        goto L10
    L25:
        if (r9.size() != 0) goto L29;
        monitor-exit(this);
        return r0;
    L29:
        if (Logger.debug() == false) goto L52;
        Logger.d(TAG, "submit httpdns resolve for host : " + r9);     // Catch: Throwable -> L20
    L52:
        r0 = mThreadPool.submit(new HttpDnsResolveCall(HttpDnsUtil.transHostList2String(r9), mSdkVersion, this.mHostResolveManager, r10, mHttpDnsHandler));     // Catch: Throwable -> L20 RejectedExecutionException -> L38
        Iterator<String> r12 = r9.iterator();     // Catch: Throwable -> L20 RejectedExecutionException -> L38
    L33:
        if (r12.hasNext() == false) goto L42;
        String r13 = r12.next();     // Catch: Throwable -> L20 RejectedExecutionException -> L38
        this.mHostResolveManager.addHttpDnsResolvingFuture(r13, r0);     // Catch: Throwable -> L20 RejectedExecutionException -> L38
        if (this.mIsHttpDnsPrefer.get() == false) goto L33;
        this.mHostResolveManager.removeHttpDnsStaleCacheHost(r13);     // Catch: Throwable -> L20 RejectedExecutionException -> L38
    L42:
        monitor-exit(this);
        return r0;
    L38:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L20
        if (Logger.debug() == false) goto L42;
        Logger.d(TAG, "submit httpdns resolve for host : " + r9 + " was rejected");     // Catch: Throwable -> L20
    L45:
        if (Logger.debug() == false) goto L47;
        Logger.d(TAG, "httpdns resolve hostlist is null.");     // Catch: Throwable -> L20
    L47:
        monitor-exit(this);
        return null;
    }

    public void submitIpv6Detect() {
        mThreadPool.submit(new Ipv6DetectCall());     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
