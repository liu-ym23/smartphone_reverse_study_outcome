package com.bytedance.privacy.pcc.h.b;

import com.google.gson.m;
import com.google.gson.o;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5465a;

    private e(String r1) {
        this.f5465a = r1;
    }

    public static e b(String r3) {
        m r4 = o.c(r3).c();
        int r0 = r4.v("code").a();
        if (r0 != 0) goto L11;
        if (r4.z("log_id") == false) goto L7;
        String r5 = r4.v("log_id").l();
    L9:
        return new e(r5);
    L7:
        r5 = "";
        goto L9
    L11:
        throw new Exception("unexpected server code=" + r0);
    }

    public String a() {
        return this.f5465a;
    }
}
