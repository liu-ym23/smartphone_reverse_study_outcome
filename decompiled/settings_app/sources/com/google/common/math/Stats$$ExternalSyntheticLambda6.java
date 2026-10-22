package com.google.common.math;

import java.util.function.ObjDoubleConsumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class Stats$$ExternalSyntheticLambda6 implements ObjDoubleConsumer {
    public /* synthetic */ Stats$$ExternalSyntheticLambda6() {
    }

    @Override // java.util.function.ObjDoubleConsumer
    public final void accept(Object r1, double r2) {
        ((StatsAccumulator) r1).add(r2);
    }
}
