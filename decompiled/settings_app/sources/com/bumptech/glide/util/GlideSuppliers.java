package com.bumptech.glide.util;

/* JADX INFO: loaded from: classes3.dex */
public final class GlideSuppliers {

    public interface GlideSupplier<T> {
        T get();
    }

    private GlideSuppliers() {
    }

    public static <T> GlideSupplier<T> memorize(final GlideSupplier<T> r1) {
        return new AnonymousClass1(r1);
    }
}
