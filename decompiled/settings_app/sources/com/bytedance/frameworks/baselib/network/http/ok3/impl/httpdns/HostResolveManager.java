package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.frameworks.baselib.network.http.util.LRUCache;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class HostResolveManager {
    public static final int MSG_REMOVE_HTTPDNSDOMAIN_DARKROME = 20;
    private static final String TAG = "HostResolveManager";
    private final int BATCH_REFRESH_CNT;
    private final long TIME_IN_DARKROOM;
    private AtomicInteger mDetectedHardCodeipsCnt;
    private final Handler mHandler;
    private LRUCache<String, DnsRecord> mHttpDnsCacheMap;
    private AtomicInteger mHttpDnsDomainFailedCnt;
    private ConcurrentMap<String, ConcurrentSkipListSet<HostResolveJob>> mHttpDnsResolveJobs;
    private ConcurrentMap<String, Future<Void>> mHttpDnsResolvingFutureMap;
    private ConcurrentSkipListSet<String> mHttpDnsStaleCacheHosts;
    private NetworkUtils.NetworkType mLastNetType;
    private ConcurrentMap<String, DnsRecord> mLocalDnsCacheMap;
    private ConcurrentMap<String, ConcurrentSkipListSet<HostResolveJob>> mLocalDnsResolveJobs;
    private ConcurrentMap<String, Future<Void>> mLocalDnsResolvingFutureMap;

    static {
    }

    public HostResolveManager(Handler r3) {
        this.mHttpDnsCacheMap = new LRUCache(100);
        this.mLocalDnsCacheMap = new ConcurrentHashMap();
        this.mHttpDnsResolvingFutureMap = new ConcurrentHashMap();
        this.mLocalDnsResolvingFutureMap = new ConcurrentHashMap();
        this.mHttpDnsResolveJobs = new ConcurrentHashMap();
        this.mLocalDnsResolveJobs = new ConcurrentHashMap();
        this.mHttpDnsStaleCacheHosts = new ConcurrentSkipListSet();
        this.mDetectedHardCodeipsCnt = new AtomicInteger(0);
        this.mHttpDnsDomainFailedCnt = new AtomicInteger(0);
        this.mLastNetType = NetworkUtils.NetworkType.NONE;
        this.TIME_IN_DARKROOM = 180000;
        this.BATCH_REFRESH_CNT = 10;
        this.mHandler = r3;
    }

    public void onNetworkChanged(Context r5) {
        NetworkUtils.NetworkType r6 = NetworkUtils.getNetworkType(r5);
        if (r6 != this.mLastNetType) goto L5;
    L32:
        this.mLastNetType = r6;
        return;
    L5:
        if (Logger.debug() == false) goto L7;
        Logger.d(TAG, "network changed, clear cache and re-batch-preload preload hosts, current net type is " + r6);
    L7:
        Map<String, DnsRecord> r0 = this.mHttpDnsCacheMap.map();
        monitor-enter(r0);
        Iterator<Map.Entry<String, DnsRecord>> r1 = this.mHttpDnsCacheMap.map().entrySet().iterator();     // Catch: Throwable -> L29
    L11:
        if (r1.hasNext() == false) goto L18;
        Map.Entry<String, DnsRecord> r2 = r1.next();     // Catch: Throwable -> L29
        if (r2 == null) goto L11;
        if (HttpDns.getService().isHttpDnsPrefer().get() == true) goto L16;
        r2.getValue().removeHttpDnsRemoveTask();     // Catch: Throwable -> L29
        goto L11
    L16:
        r2.getValue().removeHttpDnsRefreshTask();     // Catch: Throwable -> L29
        goto L11
    L18:
        this.mHttpDnsCacheMap.evictAll();     // Catch: Throwable -> L29
        monitor-exit(r0);     // Catch: Throwable -> L29
        Iterator<Map.Entry<String, DnsRecord>> r3 = this.mLocalDnsCacheMap.entrySet().iterator();
    L22:
        if (r3.hasNext() == false) goto L26;
        Map.Entry<String, DnsRecord> r4 = r3.next();
        if (r4 == null) goto L22;
        r4.getValue().removeLocalDnsRemoveTask();
        goto L22
    L26:
        this.mLocalDnsCacheMap.clear();
        if (r6 == NetworkUtils.NetworkType.NONE) goto L32;
        HttpDns.getService().doHttpDnsPreload(DnsRecord.CacheStaleReason.CACHE_STALE_NETCHANGED);
        HttpDns.getService().submitIpv6Detect();
    L29:
        th = move-exception;
        throw th;
    }

    public void addHttpDnsCache(String r3, DnsRecord r4) {
        DnsRecord r0 = getHttpDnsCache(r3);
        if (r0 == null) goto L9;
        if (HttpDns.getService().isHttpDnsPrefer().get() == false) goto L7;
        r0.removeHttpDnsRefreshTask();
        goto L9
    L7:
        r0.removeHttpDnsRemoveTask();
    L9:
        if (HttpDns.getService().isHttpDnsPrefer().get() == false) goto L11;
        r4.addHttpDnsRefreshTask();
    L12:
        Map<String, DnsRecord> r1 = this.mHttpDnsCacheMap.map();
        monitor-enter(r1);
        this.mHttpDnsCacheMap.put(r3, r4);     // Catch: Throwable -> L17
        monitor-exit(r1);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    L11:
        r4.addHttpDnsRemoveTask();
        goto L12
    }

    public void removeHttpDnsCache(String r3) {
        DnsRecord r0 = getHttpDnsCache(r3);
        if (r0 != null) goto L5;
        return;
    L5:
        if (HttpDns.getService().isHttpDnsPrefer().get() == false) goto L7;
        r0.removeHttpDnsRefreshTask();
    L8:
        Map<String, DnsRecord> r1 = this.mHttpDnsCacheMap.map();
        monitor-enter(r1);
        this.mHttpDnsCacheMap.remove(r3);     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    L7:
        r0.removeHttpDnsRemoveTask();
        goto L8
    }

    public DnsRecord getHttpDnsCache(String r2) {
        Map<String, DnsRecord> r0 = this.mHttpDnsCacheMap.map();
        monitor-enter(r0);
        DnsRecord r1 = this.mHttpDnsCacheMap.get(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void addLocalDnsCache(String r2, DnsRecord r3) {
        DnsRecord r0 = getLocalDnsCache(r2);
        if (r0 == null) goto L5;
        r0.removeLocalDnsRemoveTask();
    L5:
        r3.addLocalDnsRemoveTask();
        this.mLocalDnsCacheMap.put(r2, r3);
    }

    public void removeLocalDnsCache(String r2) {
        DnsRecord r0 = getLocalDnsCache(r2);
        if (r0 == null) goto L6;
        r0.removeLocalDnsRemoveTask();
        this.mLocalDnsCacheMap.remove(r2);
        return;
    }

    public DnsRecord getLocalDnsCache(String r2) {
        if (this.mLocalDnsCacheMap.containsKey(r2) == true) goto L5;
        return null;
    L5:
        return this.mLocalDnsCacheMap.get(r2);
    }

    public boolean isHttpDnsResolving(String r1) {
        return this.mHttpDnsResolvingFutureMap.containsKey(r1);
    }

    public void addHttpDnsResolvingFuture(String r1, Future<Void> r2) {
        this.mHttpDnsResolvingFutureMap.put(r1, r2);
    }

    public void removeHttpDnsResolvingFuture(String r1) {
        this.mHttpDnsResolvingFutureMap.remove(r1);
    }

    public Future<Void> getHttpDnsResolvingFuture(String r2) {
        if (this.mHttpDnsResolvingFutureMap.containsKey(r2) == true) goto L5;
        return null;
    L5:
        return this.mHttpDnsResolvingFutureMap.get(r2);
    }

    public void addLocalDnsResolvingFuture(String r1, Future<Void> r2) {
        this.mLocalDnsResolvingFutureMap.put(r1, r2);
    }

    public void removeLocalDnsResolvingFuture(String r1) {
        this.mLocalDnsResolvingFutureMap.remove(r1);
    }

    public boolean isLocalDnsResolving(String r1) {
        return this.mLocalDnsResolvingFutureMap.containsKey(r1);
    }

    public Future<Void> getLocalDnsResolvingFuture(String r2) {
        if (this.mLocalDnsResolvingFutureMap.containsKey(r2) == true) goto L5;
        return null;
    L5:
        return this.mLocalDnsResolvingFutureMap.get(r2);
    }

    public synchronized void addHttpDnsJob(String r2, HostResolveJob r3) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mHttpDnsResolveJobs.containsKey(r2) == false) goto L6;
        this.mHttpDnsResolveJobs.get(r2).add(r3);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L6:
        ConcurrentSkipListSet<HostResolveJob> r0 = new ConcurrentSkipListSet();     // Catch: Throwable -> L9
        r0.add(r3);     // Catch: Throwable -> L9
        this.mHttpDnsResolveJobs.put(r2, r0);     // Catch: Throwable -> L9
        goto L7
    }

    public ConcurrentSkipListSet<HostResolveJob> getHttpDnsJobs(String r1) {
        return this.mHttpDnsResolveJobs.get(r1);
    }

    public boolean shouldHttpDnsCallback(String r1) {
        return this.mHttpDnsResolveJobs.containsKey(r1);
    }

    public boolean shouldHttpDnsTimeoutCallback(HostResolveJob r3) {
        if (this.mHttpDnsResolveJobs.containsKey(r3.getHost()) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mHttpDnsResolveJobs.get(r3.getHost()).contains(r3) == false) goto L7;
        return true;
    }

    public void removeHttpDnsJob(HostResolveJob r3) {
        String r0 = r3.getHost();
        if (this.mHttpDnsResolveJobs.containsKey(r0) == false) goto L8;
        this.mHttpDnsResolveJobs.get(r0).remove(r3);
        if (this.mHttpDnsResolveJobs.get(r0).isEmpty() == false) goto L9;
        this.mHttpDnsResolveJobs.remove(r0);
        return;
    L9:
        return;
    }

    public synchronized void addLocalDnsJob(String r2, HostResolveJob r3) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mLocalDnsResolveJobs.containsKey(r2) == false) goto L6;
        this.mLocalDnsResolveJobs.get(r2).add(r3);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L6:
        ConcurrentSkipListSet<HostResolveJob> r0 = new ConcurrentSkipListSet();     // Catch: Throwable -> L9
        r0.add(r3);     // Catch: Throwable -> L9
        this.mLocalDnsResolveJobs.put(r2, r0);     // Catch: Throwable -> L9
        goto L7
    }

    public ConcurrentSkipListSet<HostResolveJob> getLocalDnsJobs(String r1) {
        return this.mLocalDnsResolveJobs.get(r1);
    }

    public boolean shouldLocalDnsCallback(String r1) {
        return this.mLocalDnsResolveJobs.containsKey(r1);
    }

    public boolean shouldLocalDnsTimeoutCallback(HostResolveJob r3) {
        if (this.mLocalDnsResolveJobs.containsKey(r3.getHost()) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mLocalDnsResolveJobs.get(r3.getHost()).contains(r3) == false) goto L7;
        return true;
    }

    public void removeLocalDnsJob(HostResolveJob r3) {
        String r0 = r3.getHost();
        if (this.mLocalDnsResolveJobs.containsKey(r0) == false) goto L8;
        this.mLocalDnsResolveJobs.get(r0).remove(r3);
        if (this.mLocalDnsResolveJobs.get(r0).isEmpty() == false) goto L9;
        this.mLocalDnsResolveJobs.remove(r0);
        return;
    L9:
        return;
    }

    public void addHttpDnsStaleCacheHost(String r2) {
        this.mHttpDnsStaleCacheHosts.add(r2);
        if (this.mHttpDnsStaleCacheHosts.size() >= 10) goto L5;
        return;
    L5:
        ArrayList r3 = new ArrayList();
        r3.addAll(this.mHttpDnsStaleCacheHosts);
        HttpDns.getService().batchRefreshHttpDnsStaleCache(r3);
    }

    public void removeHttpDnsStaleCacheHost(String r2) {
        if (this.mHttpDnsStaleCacheHosts.contains(r2) == false) goto L6;
        this.mHttpDnsStaleCacheHosts.remove(r2);
        return;
    }

    AtomicInteger getDetectedHardCodeipsCnt() {
        return this.mDetectedHardCodeipsCnt;
    }

    void setDetectedHardCodeipsCnt() {
        this.mDetectedHardCodeipsCnt.getAndIncrement();
    }

    AtomicInteger getHttpDnsDomainFailedCnt() {
        return this.mHttpDnsDomainFailedCnt;
    }

    void addHttpDnsDomainFailedCnt() {
        this.mHttpDnsDomainFailedCnt.getAndIncrement();
        if (this.mHttpDnsDomainFailedCnt.get() < 2) goto L6;
        Message r0 = Message.obtain();
        r0.what = 20;
        r0.obj = this;
        this.mHandler.sendMessageDelayed(r0, 180000);
        return;
    }

    void resetHttpDnsDomainFailedCnt() {
        this.mHttpDnsDomainFailedCnt.set(0);
    }
}
