package com.obric.oui.window.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class WindowSizeWithPageSize {
    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof WindowSizeWithPageSize) == false) goto L10;
        WindowSizeWithPageSize r3 = (WindowSizeWithPageSize) r2;
        r3.getClass();
        if (Intrinsics.a(null, null) == false) goto L14;
        r3.getClass();
        if (Intrinsics.a(null, null) == true) goto L16;
        return false;
    L16:
        return true;
    L14:
        return false;
    L10:
        return false;
    }

    public final int hashCode() {
        return (0 * 31) + 0;
    }

    public final String toString() {
        return "WindowSizeWithPageSize(windowSizeClass=null, pageSize=null)";
    }
}
