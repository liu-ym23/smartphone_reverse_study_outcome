package com.obric.matrix.platform.sdk.ones.ws;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class MatrixWsHelperKt {
    public static final /* synthetic */ String access$getKey(int r0, int r1) {
        return getKey(r0, r1);
    }

    private static final String getKey(int r1, int r2) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r1);
        r0.append('_');
        r0.append(r2);
        return r0.toString();
    }
}
