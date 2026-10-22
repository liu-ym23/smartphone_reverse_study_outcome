package yb;

import com.lynx.tasm.behavior.v0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f23243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f23244c;
    public final boolean d;

    public c(long r5, String r10, String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "fileName");
        Intrinsics.checkNotNullParameter(r11, "from");
        this.f23242a = r10;
        this.f23243b = r5;
        this.f23244c = r11;
        this.d = r12;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof c) == true) goto L8;
        return false;
    L8:
        c r11 = (c) r10;
        String r5 = r11.f23242a;
        if (Intrinsics.areEqual(this.f23242a, r5) == true) goto L12;
        return false;
    L12:
        if (this.f23243b == r11.f23243b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f23244c, r11.f23244c) == true) goto L18;
        return false;
    L18:
        if (this.d == r11.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r5 = androidx.constraintlayout.motion.widget.a.c(v0.a(this.f23242a.hashCode() * 31, this.f23243b), 31, this.f23244c);
        return Boolean.hashCode(this.d) + r5;
    }

    public final String toString() {
        return "{file:" + this.f23242a + ",duration:" + this.f23243b + ",from:" + this.f23244c + "},is_disabled=" + this.d;
    }
}
