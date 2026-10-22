package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import com.bytedance.networkstackapplib.NetworkStackConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DnsResult implements Serializable {
    public List<String> ipv4List;
    public List<String> ipv6List;
    public Source source;

    public static final enum Source extends Enum<Source> {
        private static final /* synthetic */ Source[] $VALUES = null;
        public static final Source HARDCODE_IPS = null;
        public static final Source HTTPDNS_CACHE = null;
        public static final Source HTTPDNS_REQUEST = null;
        public static final Source HTTPDNS_STALE_CACHE = null;
        public static final Source LOCALDNS_CACHE = null;
        public static final Source LOCALDNS_REQUEST = null;
        public static final Source UNKNOWN = null;

        static {
            Source r0 = new Source(NetworkStackConstant.UNKNOWN_TYPE, 0);
            UNKNOWN = r0;
            Source r1 = new Source("HTTPDNS_CACHE", 1);
            HTTPDNS_CACHE = r1;
            Source r2 = new Source("HTTPDNS_STALE_CACHE", 2);
            HTTPDNS_STALE_CACHE = r2;
            Source r3 = new Source("HTTPDNS_REQUEST", 3);
            HTTPDNS_REQUEST = r3;
            Source r4 = new Source("LOCALDNS_REQUEST", 4);
            LOCALDNS_REQUEST = r4;
            Source r5 = new Source("LOCALDNS_CACHE", 5);
            LOCALDNS_CACHE = r5;
            Source r6 = new Source("HARDCODE_IPS", 6);
            HARDCODE_IPS = r6;
            $VALUES = new Source[]{r0, r1, r2, r3, r4, r5, r6};
        }

        private Source(String r1, int r2) {
            super(r1, r2);
        }

        public static Source valueOf(String r1) {
            return (Source) Enum.valueOf(Source.class, r1);
        }

        public static Source[] values() {
            return (Source[]) $VALUES.clone();
        }
    }

    public DnsResult() {
        this.ipv4List = new ArrayList();
        this.ipv6List = new ArrayList();
        this.source = Source.HTTPDNS_CACHE;
    }
}
