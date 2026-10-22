package kotlin.n0.d;

/* JADX INFO: loaded from: classes2.dex */
public class f0 {
    public f0() {
    }

    public kotlin.s0.g a(l r1) {
        return r1;
    }

    public kotlin.s0.d b(Class r1) {
        return new e(r1);
    }

    public kotlin.s0.f c(Class r1, String r2) {
        return new u(r1, r2);
    }

    public kotlin.s0.h d(r r1) {
        return r1;
    }

    public kotlin.s0.j e(v r1) {
        return r1;
    }

    public kotlin.s0.k f(x r1) {
        return r1;
    }

    public String g(k r1) {
        String r0 = r1.getClass().getGenericInterfaces()[0].toString();
        if (r0.startsWith("kotlin.jvm.functions.") == true) goto L5;
        return r0;
    L5:
        return r0.substring(21);
    }

    public String h(q r1) {
        return g(r1);
    }
}
