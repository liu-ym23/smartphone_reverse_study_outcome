package com.bytedance.android.sdk.bdticketguard;

import android.util.Pair;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class l extends g0<m> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f836d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f837e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final j f838f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f839g;

    public l(m r8, List<? extends Pair<String, String>> r9, String r10, String r11, j r12, String r13, boolean r14) {
        kotlin.n0.d.o.g(r8, "consumerRequestParam");
        kotlin.n0.d.o.g(r9, "headers");
        kotlin.n0.d.o.g(r10, "errorDesc");
        kotlin.n0.d.o.g(r11, "keyType");
        kotlin.n0.d.o.g(r12, "clientData");
        kotlin.n0.d.o.g(r13, "clientDataBase64");
        super(r8, r9, 0, 4, null);
        this.f836d = r10;
        this.f837e = r11;
        this.f838f = r12;
        this.f839g = r13;
    }

    public /* synthetic */ l(m r10, List r11, String r12, String r13, j r14, String r15, boolean r16, int r17, kotlin.n0.d.g r18) {
        if ((r17 & 64) == 0) goto L5;
        boolean r8 = false;
    L6:
        this(r10, r11, r12, r13, r14, r15, r8);
        return;
    L5:
        r8 = r16;
        goto L6
    }

    public final j d() {
        return this.f838f;
    }

    public final String e() {
        return this.f839g;
    }

    public final String f() {
        return this.f836d;
    }

    public final String g() {
        return this.f837e;
    }
}
