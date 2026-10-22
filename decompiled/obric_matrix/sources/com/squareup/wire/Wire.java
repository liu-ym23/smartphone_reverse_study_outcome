package com.squareup.wire;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0004\n\u0002\b\u0006\u001a%\u0010\u0003\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\b\u0010\u0001\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0002\u001a\u00028\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"T", "value", "defaultValue", "get", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "wire-runtime"}, k = 2, mv = {1, 1, 15})
public final class Wire {
    public static final <T> T get(T r0, T r1) {
        if (r0 == null) goto L5;
        return r0;
    L5:
        return r1;
    }
}
