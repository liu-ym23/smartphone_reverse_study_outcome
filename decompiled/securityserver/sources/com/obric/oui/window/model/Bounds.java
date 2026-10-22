package com.obric.oui.window.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Bounds {
    public final boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (r3 == null) goto L7;
        Class<?> r2 = r3.getClass();
    L9:
        if ((!Bounds.class.equals(r2)) == false) goto L12;
        return false;
    L12:
        if (r3 == null) goto L16;
        Bounds r4 = (Bounds) r3;
        return true;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.window.model.Bounds");
    L7:
        r2 = null;
        goto L9
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "Bounds { [0,0,0,0] }";
    }
}
