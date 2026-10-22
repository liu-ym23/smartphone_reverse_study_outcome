package com.obric.oui.textswitcher;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class TextSwitcherSpec {
    public final boolean equals(Object r1) {
        if (this != r1) goto L4;
        return true;
    L4:
        if ((r1 instanceof TextSwitcherSpec) == false) goto L16;
        ((TextSwitcherSpec) r1).getClass();
        if (Intrinsics.a(null, null) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.a(null, null) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.a(null, null) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.a(null, null) == true) goto L14;
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
        return 0;
    }

    public final String toString() {
        return "TextSwitcherSpec(textSpec=null, animationSpec=null, triggerSpec=null, dataSpec=null, viewFactory=null, isSupportMarquee=false)";
    }
}
