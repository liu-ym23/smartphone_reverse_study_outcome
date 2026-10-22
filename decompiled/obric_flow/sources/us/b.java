package us;

import android.graphics.Rect;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f22454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f22455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f22456c;
    public final int d;

    public b(Rect r5) {
        Intrinsics.checkNotNullParameter(r5, SVGRenderEngine.RECT);
        int r10 = r5.left;
        int r11 = r5.top;
        int r12 = r5.right;
        int r13 = r5.bottom;
        this.f22454a = r10;
        this.f22455b = r11;
        this.f22456c = r12;
        this.d = r13;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L5;
        return true;
    L5:
        if (r5 != null) goto L7;
        Class<?> r10 = null;
    L9:
        if (Intrinsics.areEqual(b.class, r10) == true) goto L11;
        return false;
    L11:
        if (r5 == null) goto L26;
        b r11 = (b) r5;
        if (this.f22454a == r11.f22454a) goto L16;
        return false;
    L16:
        if (this.f22455b == r11.f22455b) goto L19;
        return false;
    L19:
        if (this.f22456c == r11.f22456c) goto L22;
        return false;
    L22:
        if (this.d == r11.d) goto L24;
        return false;
    L24:
        return true;
    L26:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.window.model.Bounds");
    L7:
        r10 = r5.getClass();
        goto L9
    }

    public final int hashCode() {
        return (((((this.f22454a * 31) + this.f22455b) * 31) + this.f22456c) * 31) + this.d;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder();
        r5.append(b.class.getSimpleName());
        r5.append(" { [");
        r5.append(this.f22454a);
        r5.append(',');
        r5.append(this.f22455b);
        r5.append(',');
        r5.append(this.f22456c);
        r5.append(',');
        return androidx.constraintlayout.motion.widget.a.s(r5, this.d, "] }");
    }
}
