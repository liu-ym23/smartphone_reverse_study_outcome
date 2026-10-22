package com.squareup.wire.internal;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u001c\u0010\u0003\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0080\f¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001c\u0010\u0005\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0080\f¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"", "", "other", "and", "(BI)I", "shl", "wire-runtime"}, k = 2, mv = {1, 1, 15})
public final class RuntimeUtils {
    public static final int and(byte r0, int r1) {
        return r0 & r1;
    }

    public static final int shl(byte r0, int r1) {
        return r0 << r1;
    }
}
