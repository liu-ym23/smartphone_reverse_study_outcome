package com.google.common.collect;

import java.util.function.IntFunction;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ImmutableList$$ExternalSyntheticLambda0 implements IntFunction {
    public final /* synthetic */ ImmutableList f$0;

    public /* synthetic */ ImmutableList$$ExternalSyntheticLambda0(ImmutableList r1) {
        this.f$0 = r1;
    }

    @Override // java.util.function.IntFunction
    public final Object apply(int r1) {
        return this.f$0.get(r1);
    }
}
