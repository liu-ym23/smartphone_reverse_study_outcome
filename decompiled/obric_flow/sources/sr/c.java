package sr;

import com.obric.oui.image.OImageShape;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OImageShape f22000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f22001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f22002c;
    public Integer d;
    public boolean e;

    static {
    }

    public c(OImageShape r5, boolean r10, Integer r11, Integer r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r5, "shape");
        this.f22000a = r5;
        this.f22001b = r10;
        this.f22002c = r11;
        this.d = r12;
        this.e = r13;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r10 = (c) r5;
        OImageShape r11 = r10.f22000a;
        if (this.f22000a == r11) goto L12;
        return false;
    L12:
        if (this.f22001b == r10.f22001b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f22002c, r10.f22002c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r10.e) goto L23;
        return false;
    L23:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public final int hashCode() {
        int r5 = this.f22000a.hashCode() * 31;
        ?? r10 = 1;
        boolean r11 = this.f22001b;
        ?? r12 = r11;
        if (r11 == false) goto L5;
        r12 = 1;
    L5:
        int r13 = (r5 + r12) * 31;
        Integer r14 = this.f22002c;
        int r15 = 0;
        if (r14 != null) goto L8;
        int r16 = 0;
    L9:
        int r17 = (r13 + r16) * 31;
        Integer r18 = this.d;
        if (r18 == null) goto L13;
        r15 = r18.hashCode();
    L13:
        int r19 = (r17 + r15) * 31;
        boolean r20 = this.e;
        if (r20 == true) goto L18;
        r10 = r20;
    L18:
        return r19 + r10;
    L8:
        r16 = r14.hashCode();
        goto L9
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("OImageStyleConfig(shape=");
        r5.append(this.f22000a);
        r5.append(", strokeEnabled=");
        r5.append(this.f22001b);
        r5.append(", backgroundColor=");
        r5.append(this.f22002c);
        r5.append(", strokeColor=");
        r5.append(this.d);
        r5.append(", clipToMask=");
        return androidx.constraintlayout.motion.widget.a.w(r5, this.e, ')');
    }

    public /* synthetic */ c() {
        this(OImageShape.STANDARD, true, null, null, false);
    }
}
