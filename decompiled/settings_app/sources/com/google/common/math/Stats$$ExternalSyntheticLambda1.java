package com.google.common.math;

import java.util.function.ObjLongConsumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class Stats$$ExternalSyntheticLambda1 implements ObjLongConsumer {
    public /* synthetic */ Stats$$ExternalSyntheticLambda1() {
    }

    @Override // java.util.function.ObjLongConsumer
    public final void accept(Object r1, long r2) {
        ((StatsAccumulator) r1).add(r2);
    }
}
