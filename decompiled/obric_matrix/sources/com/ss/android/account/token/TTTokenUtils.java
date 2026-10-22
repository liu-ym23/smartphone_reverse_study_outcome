package com.ss.android.account.token;

import android.text.TextUtils;
import com.bytedance.ttnet.s.d;
import com.ss.android.token.m;
import d.b.h.a.a.h.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class TTTokenUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f11800a = null;

    static {
        f11800a = new AtomicBoolean(false);
    }

    public TTTokenUtils() {
    }

    public static List<m> a(List<d.b.r.h0.b> r4) {
        if (r4 != null) goto L4;
        return null;
    L4:
        if (r4.isEmpty() == true) goto L28;
        ArrayList r0 = new ArrayList();
        Iterator<d.b.r.h0.b> r5 = r4.iterator();
    L8:
        if (r5.hasNext() == false) goto L16;
        d.b.r.h0.b r1 = r5.next();
        if (r1 == null) goto L8;
        if (TextUtils.isEmpty(r1.a()) == true) goto L8;
        if (TextUtils.isEmpty(r1.b()) == true) goto L8;
        r0.add(new m(r1.a(), r1.b()));
        goto L8
    L16:
        return r0;
    L28:
        return null;
    }

    public static void addTokenInterceptor() {
        if (f11800a.compareAndSet(false, true) == false) goto L11;
        d.a(new b());
        if (com.bytedance.sdk.account.settings.f.a.r() == false) goto L7;
    L8:
        g.T(new a());
    L9:
        d.b.s.a.a0.a.a("TTTokenUtils", "call addTokenInterceptor");
        return;
    L7:
        if (com.bytedance.sdk.account.settings.f.a.s() == false) goto L9;
    }
}
