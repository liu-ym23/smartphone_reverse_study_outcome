package com.google.common.math;

import java.util.function.ObjIntConsumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class Stats$$ExternalSyntheticLambda7 implements ObjIntConsumer {
    public /* synthetic */ Stats$$ExternalSyntheticLambda7() {
    }

    @Override // java.util.function.ObjIntConsumer
    public final void accept(Object r3, int r4) {
        ((StatsAccumulator) r3).add(r4);
    }
}
