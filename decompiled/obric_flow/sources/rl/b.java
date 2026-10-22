package rl;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f21787b;

    public b(String r5, HashMap r10) {
        this.f21786a = r5;
        this.f21787b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r10 = (b) r5;
        String r11 = r10.f21786a;
        if (Intrinsics.areEqual(this.f21786a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f21787b, r10.f21787b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f21786a.hashCode() * 31;
        return this.f21787b.hashCode() + r5;
    }

    public final String toString() {
        return "WebUrlAndHeaders(url=" + this.f21786a + ", headers=" + this.f21787b + ")";
    }
}
