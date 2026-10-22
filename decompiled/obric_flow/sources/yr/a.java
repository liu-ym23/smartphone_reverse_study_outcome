package yr;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f23319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f23320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f23321c;
    public final float d;
    public final Integer e;
    public final Integer f;
    public final Integer g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f23322h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final androidx.core.view.inputmethod.a f23323i;

    public a(int r5, ArrayList r10, String r11, float r12, Integer r13, Integer r14, Integer r15, int r16, androidx.core.view.inputmethod.a r17) {
        Intrinsics.checkNotNullParameter(r10, "entries");
        this.f23319a = r5;
        this.f23320b = r10;
        this.f23321c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.f23322h = r16;
        this.f23323i = r17;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r10 = (a) r5;
        int r11 = r10.f23319a;
        if (this.f23319a == r11) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f23320b, r10.f23320b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f23321c, r10.f23321c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(Float.valueOf(this.d), Float.valueOf(r10.d)) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r10.g) == true) goto L30;
        return false;
    L30:
        if (this.f23322h == r10.f23322h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f23323i, r10.f23323i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r5 = (this.f23320b.hashCode() + (Integer.hashCode(this.f23319a) * 31)) * 31;
        int r10 = 0;
        String r11 = this.f23321c;
        if (r11 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = androidx.constraintlayout.motion.widget.a.b(this.d, (r5 + r12) * 31, 31);
        Integer r14 = this.e;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        Integer r17 = this.f;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        Integer r20 = this.g;
        if (r20 != null) goto L17;
        int r21 = 0;
    L18:
        int r22 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.f23322h, (r19 + r21) * 31, 31);
        androidx.core.view.inputmethod.a r23 = this.f23323i;
        if (r23 == null) goto L23;
        r10 = r23.hashCode();
    L23:
        return r22 + r10;
    L17:
        r21 = r20.hashCode();
        goto L18
    L13:
        r18 = r17.hashCode();
        goto L14
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r11.hashCode();
        goto L6
    }

    public final String toString() {
        return "Reel(id=" + this.f23319a + ", entries=" + this.f23320b + ", tag=" + this.f23321c + ", widthWeight=" + this.d + ", width=" + this.e + ", minWidth=" + this.f + ", tagGap=" + this.g + ", selectedIndex=" + this.f23322h + ", reelChangedListener=" + this.f23323i + ')';
    }
}
