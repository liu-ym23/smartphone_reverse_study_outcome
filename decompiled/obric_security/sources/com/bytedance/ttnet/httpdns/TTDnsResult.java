package com.bytedance.ttnet.httpdns;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class TTDnsResult {
    public int cache_source;
    public String detailed_info;
    public List<String> iplist;
    public int ret;
    public int source;

    public TTDnsResult(int r1, int r2, int r3, List<String> r4, String r5) {
        this.ret = r1;
        this.source = r2;
        this.cache_source = r3;
        this.iplist = r4;
        this.detailed_info = r5;
    }
}
