package com.ss.android.account.group_onekey.e;

import com.bytedance.bdlocation.client.LocationInfoConst;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11780a = null;

    static {
        f11780a = new a();
    }

    private a() {
    }

    public final int a(String r1) {
        o.g(r1, "loginScene");
        if (o.a("share_login", r1) == false) goto L6;
        return 300000;
    L6:
        return LocationInfoConst.HALF_MINUTES;
    }
}
