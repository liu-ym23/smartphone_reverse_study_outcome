package com.loc;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class e1 extends i1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f7265c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private h0 f7266d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Object[] f7267e;

    public e1(Context r1, i1 r2, h0 r3, String r4, Object... r5) {
        super(r2);
        this.f7265c = r4;
        this.f7266d = r3;
        this.f7267e = r5;
    }

    private String d() {
        return String.format(u5.u(this.f7265c), this.f7267e);
    L4:
        th = move-exception;
        th.printStackTrace();
        v.m(th, "ofm", "gpj");
        return "";
    }

    @Override // com.loc.i1
    protected final byte[] b(byte[] r3) {
        String r4 = u5.g(r3);
        if (TextUtils.isEmpty(r4) == false) goto L7;
        return null;
    L7:
        return u5.o("{\"pinfo\":\"" + u5.g(this.f7266d.b(u5.o(d()))) + "\",\"els\":[" + r4 + "]}");
    }
}
