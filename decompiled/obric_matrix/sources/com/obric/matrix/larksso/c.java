package com.obric.matrix.larksso;

import com.bytedance.mpaas.app.AppInfoProvider;
import com.bytedance.news.common.service.manager.d;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u0003\u001a\u00020\u0006R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/matrix/larksso/InitConfigHelper;", "", "()V", "initConfig", "Lcom/obric/matrix/larksso/LarkSSOImpl$ConfigInfo;", "getInitConfig", "", "larksso_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f9116a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static LarkSSOImpl.b f9117b;

    static {
        f9116a = new c();
    }

    private c() {
    }

    public final LarkSSOImpl.b a() {
        return f9117b;
    }

    public final void b() {
        AppInfoProvider r5 = (AppInfoProvider) d.a(AppInfoProvider.class);
        String r1 = r5.getAid();
        o.e(r1, "appInfoProvider.aid");
        int r2 = Integer.parseInt(r1);
        String r3 = com.obric.matrix.ostracker_api.b.c();
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        String r4 = r5.getUpdateVersionCode();
        o.e(r4, "appInfoProvider.updateVersionCode");
        String r6 = r5.getChannel();
        o.e(r6, "appInfoProvider.channel");
        f9117b = new LarkSSOImpl.b(r2, r3, r4, r6);
    }
}
