package com.google.common.collect;

import java.util.function.Function;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class CollectCollectors$$ExternalSyntheticLambda12 implements Function {
    public /* synthetic */ CollectCollectors$$ExternalSyntheticLambda12() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object r1) {
        return ((CollectCollectors.EnumMapAccumulator) r1).toImmutableMap();
    }
}
