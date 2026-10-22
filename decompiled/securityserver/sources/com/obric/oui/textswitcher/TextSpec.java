package com.obric.oui.textswitcher;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class TextSpec {
    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 == null) goto L8;
        Class<?> r1 = r4.getClass();
    L10:
        if ((!TextSpec.class.equals(r1)) == false) goto L12;
        return false;
    L12:
        if (r4 == null) goto L24;
        TextSpec r5 = (TextSpec) r4;
        if ((!Intrinsics.a(null, null)) == false) goto L17;
        return false;
    L17:
        if ((!true) == false) goto L20;
        return false;
    L20:
        if (Arrays.equals(null, null) == true) goto L22;
        return false;
    L22:
        return true;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.textswitcher.TextSpec");
    L8:
        r1 = null;
        goto L10
    }

    public final int hashCode() {
        return Arrays.hashCode(null);
    }

    public final String toString() {
        return "TextSpec(textColor=null, textSizeDp=null, paddingDp=" + Arrays.toString(null) + ")";
    }
}
