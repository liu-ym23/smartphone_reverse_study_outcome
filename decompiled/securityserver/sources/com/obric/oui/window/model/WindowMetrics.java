package com.obric.oui.window.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class WindowMetrics {
    public final boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (r3 != null) goto L7;
        return false;
    L7:
        if ((!WindowMetrics.class.equals(r3.getClass())) == true) goto L13;
        WindowMetrics r4 = (WindowMetrics) r3;
        return Intrinsics.a(null, null);
    L13:
        return false;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        throw null;
    }
}
