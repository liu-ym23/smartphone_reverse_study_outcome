package com.bytedance.blockframework.contract;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AbstractBlock.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003R\u001a\u0010\u0002\u001a\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0003¨\u0006\u0007"}, d2 = {"Lcom/bytedance/blockframework/contract/BlockImplWrapper;", "", "impl", "(Ljava/lang/Object;)V", "getImpl", "()Ljava/lang/Object;", "setImpl", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BlockImplWrapper {
    private volatile Object impl;

    public final Object getImpl() {
        return this.impl;
    }

    public final void setImpl(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.impl = r2;
    }

    public BlockImplWrapper(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "impl");
        this.impl = r2;
    }
}
