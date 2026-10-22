package com.google.common.math;

import java.util.function.BiConsumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class Stats$$ExternalSyntheticLambda2 implements BiConsumer {
    public /* synthetic */ Stats$$ExternalSyntheticLambda2() {
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object r1, Object r2) {
        ((StatsAccumulator) r1).addAll((StatsAccumulator) r2);
    }
}
