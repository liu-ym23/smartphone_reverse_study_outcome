package d.b.r;

import java.lang.annotation.Annotation;

/* JADX INFO: loaded from: classes.dex */
final class b0 implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a0 f14330a = null;

    static {
        f14330a = new b0();
    }

    b0() {
    }

    static Annotation[] a(Annotation[] r4) {
        if (f0.n(r4, a0.class) == false) goto L5;
        return r4;
    L5:
        Annotation[] r0 = new Annotation[r4.length + 1];
        r0[0] = f14330a;
        System.arraycopy(r4, 0, r0, 1, r4.length);
        return r0;
    }

    @Override // java.lang.annotation.Annotation
    public Class<? extends Annotation> annotationType() {
        return a0.class;
    }

    @Override // java.lang.annotation.Annotation
    public boolean equals(Object r1) {
        return r1 instanceof a0;
    }

    @Override // java.lang.annotation.Annotation
    public int hashCode() {
        return 0;
    }

    @Override // java.lang.annotation.Annotation
    public String toString() {
        return "@" + a0.class.getName() + "()";
    }
}
