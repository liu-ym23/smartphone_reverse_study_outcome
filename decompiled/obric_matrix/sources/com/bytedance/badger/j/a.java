package com.bytedance.badger.j;

import com.bytedance.badger.monitor.CollectStage;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class a extends RuntimeException {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f2605f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f2606g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final CollectStage f2607h;

    public a(String r3, int r4, CollectStage r5) {
        o.g(r3, "errorMessage");
        o.g(r5, "collectStage");
        super("errorMessage: " + r3 + ", errorCode: " + r4 + ", stage: " + r5);
        this.f2605f = r3;
        this.f2606g = r4;
        this.f2607h = r5;
    }

    public final CollectStage a() {
        return this.f2607h;
    }

    public final int b() {
        return this.f2606g;
    }

    public final String c() {
        return this.f2605f;
    }
}
