package com.ttnet.org.chromium.base.supplier;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface Supplier<T> {

    /* JADX INFO: renamed from: com.ttnet.org.chromium.base.supplier.Supplier$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ boolean $assertionsDisabled = false;
    }

    static {
    }

    @Nullable
    T get();

    default boolean hasValue() {
        T r0 = get();
        if (AnonymousClass1.$assertionsDisabled == false) goto L5;
    L9:
        if (r0 == null) goto L11;
        return true;
    L11:
        return false;
    L5:
        if (r0 == get()) goto L9;
        throw new AssertionError("Value provided by #get() must not change.");
    }
}
