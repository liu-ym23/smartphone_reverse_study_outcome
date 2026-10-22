package com.obric.common.oea.foundation.animation.easy;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SpringAnimationHolder {
    public final boolean equals(Object r1) {
        if (this != r1) goto L4;
        return true;
    L4:
        if ((r1 instanceof SpringAnimationHolder) == false) goto L10;
        ((SpringAnimationHolder) r1).getClass();
        if (Intrinsics.a(null, null) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.a(null, null) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "SpringAnimationHolder(animation=null, config=null)";
    }
}
