package com.obric.oui.textswitcher;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class AnimationSpec {
    public final boolean equals(Object r1) {
        if (this != r1) goto L4;
        return true;
    L4:
        if ((r1 instanceof AnimationSpec) == false) goto L10;
        ((AnimationSpec) r1).getClass();
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
        return "AnimationSpec(inAnimation=null, outAnimation=null)";
    }
}
