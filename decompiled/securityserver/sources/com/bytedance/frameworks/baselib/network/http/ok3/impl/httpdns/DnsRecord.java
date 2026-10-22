package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import android.os.Bundle;
import android.os.Message;
import com.bytedance.common.utility.collection.WeakHandler;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DnsRecord {
    public static final String MSG_DNSRECORD_HOST = "dnsrecord_host";
    public static final int MSG_HTTPDNS_CACHE_EXPIRED = 12;
    public static final int MSG_REFRESH_HTTPDNS_STALE_CACHE = 10;
    public static final int MSG_REMOVE_HTTPDNS_STALE_CACHE = 13;
    public static final int MSG_REMOVE_LOCALDNS_STALE_CACHE = 11;
    private static final String TAG = "DnsRecord";
    private long mFetchTime;
    private final WeakHandler mHandler;
    private String mHost;
    private List<String> mIpv4List;
    private List<String> mIpv6List;
    private long mTTL;

    public static final enum CacheStaleReason extends Enum<CacheStaleReason> {
        private static final /* synthetic */ CacheStaleReason[] $VALUES = null;
        public static final CacheStaleReason CACHE_STALE_BOTH = null;
        public static final CacheStaleReason CACHE_STALE_EXPIRED = null;
        public static final CacheStaleReason CACHE_STALE_NETCHANGED = null;
        public static final CacheStaleReason CACHE_UNSET = null;
        public static final CacheStaleReason CACHE_VALID = null;
        public static final CacheStaleReason PRELOAD_BATCH = null;
        public static final CacheStaleReason REFRESH_BATCH = null;

        static {
            CacheStaleReason r0 = new CacheStaleReason("CACHE_UNSET", 0);
            CACHE_UNSET = r0;
            CacheStaleReason r1 = new CacheStaleReason("CACHE_VALID", 1);
            CACHE_VALID = r1;
            CacheStaleReason r2 = new CacheStaleReason("CACHE_STALE_BOTH", 2);
            CACHE_STALE_BOTH = r2;
            CacheStaleReason r3 = new CacheStaleReason("CACHE_STALE_NETCHANGED", 3);
            CACHE_STALE_NETCHANGED = r3;
            CacheStaleReason r4 = new CacheStaleReason("CACHE_STALE_EXPIRED", 4);
            CACHE_STALE_EXPIRED = r4;
            CacheStaleReason r5 = new CacheStaleReason("PRELOAD_BATCH", 5);
            PRELOAD_BATCH = r5;
            CacheStaleReason r6 = new CacheStaleReason("REFRESH_BATCH", 6);
            REFRESH_BATCH = r6;
            $VALUES = new CacheStaleReason[]{r0, r1, r2, r3, r4, r5, r6};
        }

        private CacheStaleReason(String r1, int r2) {
            super(r1, r2);
        }

        public static CacheStaleReason valueOf(String r1) {
            return (CacheStaleReason) Enum.valueOf(CacheStaleReason.class, r1);
        }

        public static CacheStaleReason[] values() {
            return (CacheStaleReason[]) $VALUES.clone();
        }
    }

    public DnsRecord(String r1, long r2, List<String> r4, List<String> r5, int r6) {
        this.mHost = r1;
        this.mFetchTime = r2;
        this.mIpv4List = r4;
        this.mIpv6List = r5;
        this.mTTL = r6;
        this.mHandler = new WeakHandler(HttpDns.getService().getHttpDnsHandlerThread().getLooper(), HttpDns.getService());
    }

    private void setHostToMessage(Message r3) {
        Bundle r0 = new Bundle();
        r0.putString(MSG_DNSRECORD_HOST, this.mHost);
        r3.setData(r0);
    }

    public void addHttpDnsRefreshTask() {
        Message r0 = Message.obtain();
        r0.obj = this;
        r0.what = 12;
        setHostToMessage(r0);
        this.mHandler.sendMessageDelayed(r0, this.mTTL * 1000);
        Message r1 = Message.obtain();
        r1.obj = this;
        r1.what = 10;
        setHostToMessage(r1);
        WeakHandler r2 = this.mHandler;
        long r3 = this.mTTL * 1000;
        r2.sendMessageDelayed(r1, (((long) HttpDns.getService().getHttpDnsRefreshStaleCacheInterval().get()) * 1000) + r3);
    }

    public void addHttpDnsRemoveTask() {
        Message r0 = Message.obtain();
        r0.obj = this;
        r0.what = 13;
        setHostToMessage(r0);
        this.mHandler.sendMessageDelayed(r0, this.mTTL * 1000);
    }

    public void addLocalDnsRemoveTask() {
        Message r0 = Message.obtain();
        r0.obj = this;
        r0.what = 11;
        setHostToMessage(r0);
        this.mHandler.sendMessageDelayed(r0, ((long) HttpDns.getService().getLocalDnsCacheTTL().get()) * 1000);
    }

    public long getFetchTime() {
        return this.mFetchTime;
    }

    public String getHost() {
        return this.mHost;
    }

    public List<String> getIpv4List() {
        return this.mIpv4List;
    }

    public List<String> getIpv6List() {
        return this.mIpv6List;
    }

    public long getTTL() {
        return this.mTTL;
    }

    public void removeHttpDnsRefreshTask() {
        this.mHandler.removeMessages(10);
        this.mHandler.removeMessages(12);
    }

    public void removeHttpDnsRemoveTask() {
        this.mHandler.removeMessages(13);
    }

    public void removeLocalDnsRemoveTask() {
        this.mHandler.removeMessages(11);
    }
}
