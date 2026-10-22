package kotlin.s0.w.d.l0.e.a.l0.m;

import java.util.Set;
import kotlin.i0.t0;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.e.a.j0.k;
import kotlin.s0.w.d.l0.n.m0;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f19487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f19488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f19489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set<f1> f19490d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final m0 f19491e;

    /* JADX WARN: Multi-variable type inference failed */
    public a(k r2, b r3, boolean r4, Set<? extends f1> r5, m0 r6) {
        o.f(r2, "howThisTypeIsUsed");
        o.f(r3, "flexibility");
        this.f19487a = r2;
        this.f19488b = r3;
        this.f19489c = r4;
        this.f19490d = r5;
        this.f19491e = r6;
    }

    public /* synthetic */ a(k r7, b r8, boolean r9, Set r10, m0 r11, int r12, kotlin.n0.d.g r13) {
        if ((r12 & 2) == 0) goto L5;
        r8 = b.f19492f;
    L5:
        b r2 = r8;
        if ((r12 & 4) == 0) goto L8;
        r9 = false;
    L8:
        boolean r3 = r9;
        if ((r12 & 8) == 0) goto L11;
        Set r4 = null;
    L13:
        if ((r12 & 16) == 0) goto L15;
        m0 r5 = null;
    L16:
        this(r7, r2, r3, r4, r5);
        return;
    L15:
        r5 = r11;
        goto L16
    L11:
        r4 = r10;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ a b(a r3, k r4, b r5, boolean r6, Set r7, m0 r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.f19487a;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.f19488b;
    L8:
        b r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.f19489c;
    L11:
        boolean r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.f19490d;
    L14:
        Set r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.f19491e;
    L17:
        k r12 = r4;
        return r3.a(r12, r11, r0, r1, r8);
    }

    public final a a(k r7, b r8, boolean r9, Set<? extends f1> r10, m0 r11) {
        o.f(r7, "howThisTypeIsUsed");
        o.f(r8, "flexibility");
        return new a(r7, r8, r9, r10, r11);
    }

    public final m0 c() {
        return this.f19491e;
    }

    public final b d() {
        return this.f19488b;
    }

    public final k e() {
        return this.f19487a;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (this.f19487a == r6.f19487a) goto L12;
        return false;
    L12:
        if (this.f19488b == r6.f19488b) goto L15;
        return false;
    L15:
        if (this.f19489c == r6.f19489c) goto L18;
        return false;
    L18:
        if (o.a(this.f19490d, r6.f19490d) == true) goto L21;
        return false;
    L21:
        if (o.a(this.f19491e, r6.f19491e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final Set<f1> f() {
        return this.f19490d;
    }

    public final boolean g() {
        return this.f19489c;
    }

    public final a h(m0 r9) {
        return b(this, null, null, false, null, r9, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public int hashCode() {
        int r0 = ((this.f19487a.hashCode() * 31) + this.f19488b.hashCode()) * 31;
        boolean r1 = this.f19489c;
        ?? r2 = r1;
        if (r1 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = (r0 + r2) * 31;
        Set<f1> r4 = this.f19490d;
        int r5 = 0;
        if (r4 != null) goto L8;
        int r6 = 0;
    L9:
        int r7 = (r3 + r6) * 31;
        m0 r8 = this.f19491e;
        if (r8 == null) goto L14;
        r5 = r8.hashCode();
    L14:
        return r7 + r5;
    L8:
        r6 = r4.hashCode();
        goto L9
    }

    public final a i(b r10) {
        o.f(r10, "flexibility");
        return b(this, null, r10, false, null, null, 29, null);
    }

    public final a j(f1 r9) {
        o.f(r9, "typeParameter");
        Set<f1> r0 = this.f19490d;
        if (r0 == null) goto L5;
        Set r10 = t0.i(r0, r9);
    L7:
        return b(this, null, null, false, r10, null, 23, null);
    L5:
        r10 = t0.a(r9);
        goto L7
    }

    public String toString() {
        return "JavaTypeAttributes(howThisTypeIsUsed=" + this.f19487a + ", flexibility=" + this.f19488b + ", isForAnnotationParameter=" + this.f19489c + ", visitedTypeParameters=" + this.f19490d + ", defaultType=" + this.f19491e + ')';
    }
}
