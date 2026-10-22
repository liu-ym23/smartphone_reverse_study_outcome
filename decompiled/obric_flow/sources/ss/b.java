package ss;

import ib.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f22008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m.b f22009c;
    public final r9.c d;

    public b(String r5, d r10, m.b r11, r9.c r12) {
        Intrinsics.checkNotNullParameter(r5, "gridMode");
        Intrinsics.checkNotNullParameter(r10, "pageColumns");
        Intrinsics.checkNotNullParameter(r11, "pageGutter");
        Intrinsics.checkNotNullParameter(r12, "pageMargin");
        this.f22007a = r5;
        this.f22008b = r10;
        this.f22009c = r11;
        this.d = r12;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r10 = (b) r5;
        String r11 = r10.f22007a;
        if (Intrinsics.areEqual(this.f22007a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f22008b, r10.f22008b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f22009c, r10.f22009c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f22007a.hashCode() * 31;
        int r10 = (this.f22008b.hashCode() + r5) * 31;
        int r11 = (this.f22009c.hashCode() + r10) * 31;
        return this.d.hashCode() + r11;
    }

    public final String toString() {
        return "PageGridConfig(gridMode=" + this.f22007a + ", pageColumns=" + this.f22008b + ", pageGutter=" + this.f22009c + ", pageMargin=" + this.d + ')';
    }
}
