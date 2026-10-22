package com.obric.oui.shadow;

import a.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Shadow {
    public final boolean equals(Object r1) {
        if (this != r1) goto L4;
        return true;
    L4:
        if ((r1 instanceof Shadow) == false) goto L16;
        ((Shadow) r1).getClass();
        if (Float.compare(0.0f, 0.0f) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(0.0f, 0.0f) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(0.0f, 0.0f) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(0.0f, 0.0f) == 0) goto L14;
        return false;
    L14:
        if (Intrinsics.a(null, null) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        return a.b(0.0f, a.b(0.0f, a.b(0.0f, a.b(0.0f, Integer.hashCode(0) * 31, 31), 31), 31), 31);
    }

    public final String toString() {
        return "Shadow(color=0, radius=0.0, offsetX=0.0, offsetY=0.0, spread=0.0, paint=null)";
    }
}
