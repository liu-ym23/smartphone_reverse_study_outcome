package com.obric.oui.avatar;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OAvatarInParam {
    public final boolean equals(Object r1) {
        if (this != r1) goto L4;
        return true;
    L4:
        if ((r1 instanceof OAvatarInParam) == false) goto L12;
        ((OAvatarInParam) r1).getClass();
        if (Intrinsics.a(null, null) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.a(null, null) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.a(null, null) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(0);
    }

    public final String toString() {
        return "OAvatarInParam(avatarSize=null, shape=null, avatarBitmapQueue=null, overLapSizePx=0)";
    }
}
