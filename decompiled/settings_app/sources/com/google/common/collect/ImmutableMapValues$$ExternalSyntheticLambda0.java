package com.google.common.collect;

import java.util.Map;
import java.util.function.Function;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ImmutableMapValues$$ExternalSyntheticLambda0 implements Function {
    public /* synthetic */ ImmutableMapValues$$ExternalSyntheticLambda0() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object r1) {
        return ((Map.Entry) r1).getValue();
    }
}
