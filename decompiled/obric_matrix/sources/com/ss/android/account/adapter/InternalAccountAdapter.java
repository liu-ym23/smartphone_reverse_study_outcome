package com.ss.android.account.adapter;

import android.content.Context;
import com.bytedance.sdk.account.impl.BDAccountManagerAdapter;
import d.b.s.a.d0.a;
import d.b.s.a.d0.b;
import d.b.s.a.d0.c;
import d.b.s.a.d0.f;
import d.b.s.a.d0.i;
import d.b.s.a.d0.j;
import d.b.s.a.d0.l;
import d.b.s.a.d0.o;
import d.b.s.a.d0.p;
import d.b.s.a.d0.q;

/* JADX INFO: loaded from: classes2.dex */
public class InternalAccountAdapter {
    public InternalAccountAdapter() {
    }

    public static void init(Context r2) {
        BDAccountManagerAdapter.init();
        a.f14705a.put("weixin", new p());
        a.f14705a.put("qzone_sns", new i());
        a.f14705a.put("sina_weibo", new o());
        a.f14705a.put("aweme", new c());
        a.f14705a.put("toutiao", new l());
        a.f14705a.put("aweme_v2", new c());
        a.f14705a.put("toutiao_v2", new l());
        a.f14705a.put("taptap", new j());
        a.f14705a.put("live_stream", new f());
        a.f14705a.put("video_article", new q());
        a.f14705a.put("cn_internet_id_auth", new b());
        d.b.s.a.a0.a.a("InternalAccountAdapter", "call init");
    }
}
