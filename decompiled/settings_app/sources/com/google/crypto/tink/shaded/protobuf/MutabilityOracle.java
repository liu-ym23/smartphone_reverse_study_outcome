package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: loaded from: classes4.dex */
interface MutabilityOracle {
    public static final MutabilityOracle IMMUTABLE = null;

    void ensureMutable();

    static {
        IMMUTABLE = new AnonymousClass1();
    }
}
