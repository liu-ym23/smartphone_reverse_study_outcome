package kotlin.s0.w.d.l0.c.o1;

import java.util.Map;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.n.e0;

/* JADX INFO: loaded from: classes2.dex */
public class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e0 f18903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<kotlin.s0.w.d.l0.g.f, kotlin.s0.w.d.l0.k.r.g<?>> f18904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a1 f18905c;

    public d(e0 r2, Map<kotlin.s0.w.d.l0.g.f, kotlin.s0.w.d.l0.k.r.g<?>> r3, a1 r4) {
        if (r2 == null) goto L12;
        if (r3 == null) goto L10;
        if (r4 == null) goto L8;
        this.f18903a = r2;
        this.f18904b = r3;
        this.f18905c = r4;
        return;
    L8:
        c(2);
        throw null;
    L10:
        c(1);
        throw null;
    L12:
        c(0);
        throw null;
    }

    private static /* synthetic */ void c(int r10) {
        if (r10 == 3) goto L7;
        if (r10 == 4) goto L7;
        if (r10 == 5) goto L7;
        String r3 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L9:
        if (r10 == 3) goto L13;
        if (r10 == 4) goto L13;
        if (r10 == 5) goto L13;
        int r5 = 3;
    L14:
        Object[] r6 = new Object[r5];
        if (r10 == 1) goto L23;
        if (r10 == 2) goto L22;
        if (r10 == 3) goto L21;
        if (r10 == 4) goto L21;
        if (r10 == 5) goto L21;
        r6[0] = "annotationType";
    L24:
        if (r10 == 3) goto L30;
        if (r10 == 4) goto L29;
        if (r10 == 5) goto L28;
        r6[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
    L31:
        if (r10 == 3) goto L35;
        if (r10 == 4) goto L35;
        if (r10 == 5) goto L35;
        r6[2] = "<init>";
    L35:
        String r4 = String.format(r3, r6);
        if (r10 == 3) goto L41;
        if (r10 == 4) goto L41;
        if (r10 == 5) goto L41;
        throw new IllegalArgumentException(r4);
    L41:
        throw new IllegalStateException(r4);
    L28:
        r6[1] = "getSource";
        goto L31
    L29:
        r6[1] = "getAllValueArguments";
        goto L31
    L30:
        r6[1] = "getType";
    L21:
        r6[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        goto L24
    L22:
        r6[0] = "source";
        goto L24
    L23:
        r6[0] = "valueArguments";
    L13:
        r5 = 2;
    L7:
        r3 = "@NotNull method %s.%s must not return null";
        goto L9
    }

    @Override // kotlin.s0.w.d.l0.c.o1.c
    public Map<kotlin.s0.w.d.l0.g.f, kotlin.s0.w.d.l0.k.r.g<?>> a() {
        Map<kotlin.s0.w.d.l0.g.f, kotlin.s0.w.d.l0.k.r.g<?>> r0 = this.f18904b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        c(4);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.o1.c
    public e0 b() {
        e0 r0 = this.f18903a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        c(3);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.o1.c
    public kotlin.s0.w.d.l0.g.c e() {
        return c.a.a(this);
    }

    @Override // kotlin.s0.w.d.l0.c.o1.c
    public a1 getSource() {
        a1 r0 = this.f18905c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        c(5);
        throw null;
    }

    public String toString() {
        return kotlin.s0.w.d.l0.j.c.f20438b.r(this, null);
    }
}
