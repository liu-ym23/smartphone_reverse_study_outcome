package com.google.common.util.concurrent;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class SettableFuture<V> extends AbstractFuture.TrustedFuture<V> {
    public static <V> SettableFuture<V> create() {
        return new SettableFuture();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public boolean set(@ParametricNullness V r1) {
        return super.set(r1);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public boolean setException(Throwable r1) {
        return super.setException(r1);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public boolean setFuture(ListenableFuture<? extends V> r1) {
        return super.setFuture(r1);
    }

    private SettableFuture() {
    }
}
