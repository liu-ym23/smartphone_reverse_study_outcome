package com.bytedance.badger;

import kotlin.b0;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes.dex */
final class e extends q implements kotlin.n0.c.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f2551f = null;

    static {
        f2551f = new e();
    }

    e() {
        super(0);
    }

    @Override // kotlin.n0.c.a
    public Object invoke() {
        Object r1 = com.bytedance.news.common.service.manager.d.a(IBadger.class);
        if (r1 == null) goto L7;
        return (BadgerCore) r1;
    L7:
        throw new b0("null cannot be cast to non-null type com.bytedance.badger.BadgerCore");
    }
}
