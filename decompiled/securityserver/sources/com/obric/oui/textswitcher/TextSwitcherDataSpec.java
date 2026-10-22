package com.obric.oui.textswitcher;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class TextSwitcherDataSpec {
    public final boolean equals(Object r1) {
        if (this != r1) goto L4;
        return true;
    L4:
        if ((r1 instanceof TextSwitcherDataSpec) == false) goto L8;
        ((TextSwitcherDataSpec) r1).getClass();
        if (Intrinsics.a(null, null) == true) goto L13;
        return false;
    L13:
        return true;
    L8:
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(0);
    }

    public final String toString() {
        return "TextSwitcherDataSpec(textList=null, fromIndex=0)";
    }
}
