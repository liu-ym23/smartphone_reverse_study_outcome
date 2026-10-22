package com.bytedance.badger.i;

import com.bytedance.badger.monitor.TriggerStage;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.d.o;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes.dex */
final class c extends q implements l {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ TriggerStage f2593f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ com.bytedance.badger.data.e f2594g;

    c(TriggerStage r1, com.bytedance.badger.data.e r2) {
        this.f2593f = r1;
        this.f2594g = r2;
        super(1);
    }

    @Override // kotlin.n0.c.l
    public Object invoke(Object r8) {
        Throwable r5 = (Throwable) r8;
        o.g(r5, "e");
        com.bytedance.badger.d.c("BadgerNetworkHandler", "sendFollowUpRequest - failed to send follow-up request", r5);
        com.bytedance.badger.monitor.a.f2633a.a(this.f2593f, 0, 0, r5, this.f2594g);
        return f0.f18324a;
    }
}
