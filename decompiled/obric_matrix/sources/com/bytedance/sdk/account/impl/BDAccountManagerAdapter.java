package com.bytedance.sdk.account.impl;

import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class BDAccountManagerAdapter {
    private static volatile boolean hadInit = false;

    static {
    }

    public BDAccountManagerAdapter() {
    }

    public static void init() {
        if (hadInit == false) goto L6;
        return;
    L6:
        monitor-enter(BDAccountManagerAdapter.class);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (hadInit == false) goto L11;
        monitor-exit(BDAccountManagerAdapter.class);     // Catch: Throwable -> L14
        return;
    L11:
        ArrayList r1 = new ArrayList(Arrays.asList(i.x0));     // Catch: Throwable -> L14
        r1.add(new com.ss.android.i.l.a("weixin"));     // Catch: Throwable -> L14
        r1.add(new com.ss.android.i.l.a("huawei"));     // Catch: Throwable -> L14
        r1.add(new com.ss.android.i.l.a("xiaomi"));     // Catch: Throwable -> L14
        r1.add(new com.ss.android.i.l.a("flyme"));     // Catch: Throwable -> L14
        r1.add(new com.ss.android.i.l.a("qq_weibo"));     // Catch: Throwable -> L14
        r1.add(new com.ss.android.i.l.a("sina_weibo"));     // Catch: Throwable -> L14
        r1.add(new com.ss.android.i.l.a("qzone_sns"));     // Catch: Throwable -> L14
        r1.add(new com.ss.android.i.l.a("toutiao"));     // Catch: Throwable -> L14
        r1.add(new com.ss.android.i.l.a("toutiao_v2"));     // Catch: Throwable -> L14
        r1.add(new com.ss.android.i.l.a("aweme"));     // Catch: Throwable -> L14
        r1.add(new com.ss.android.i.l.a("aweme_v2"));     // Catch: Throwable -> L14
        r1.add(new com.ss.android.i.l.a("live_stream"));     // Catch: Throwable -> L14
        r1.add(new com.ss.android.i.l.a("telecom"));     // Catch: Throwable -> L14
        r1.add(new com.ss.android.i.l.a("renren_sns"));     // Catch: Throwable -> L14
        r1.add(new com.ss.android.i.l.a("kaixin_sns"));     // Catch: Throwable -> L14
        r1.add(new com.ss.android.i.l.a("flipchat"));     // Catch: Throwable -> L14
        r1.add(new com.ss.android.i.l.a("gogokid"));     // Catch: Throwable -> L14
        r1.add(new com.ss.android.i.l.a("cn_internet_id_auth"));     // Catch: Throwable -> L14
        i.x0 = (com.ss.android.i.l.a[]) r1.toArray(new com.ss.android.i.l.a[0]);     // Catch: Throwable -> L14
        hadInit = true;     // Catch: Throwable -> L14
        monitor-exit(BDAccountManagerAdapter.class);     // Catch: Throwable -> L14
    }
}
