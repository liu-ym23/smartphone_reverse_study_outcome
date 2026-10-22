package kotlin.s0.w.d.l0.c.s1.b;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public final class r extends t implements kotlin.s0.w.d.l0.e.a.n0.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Field f19150a;

    public r(Field r2) {
        kotlin.n0.d.o.f(r2, "member");
        this.f19150a = r2;
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.n
    public boolean G() {
        return W().isEnumConstant();
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.n
    public boolean O() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.s1.b.t
    public /* bridge */ /* synthetic */ Member U() {
        return W();
    }

    public Field W() {
        return this.f19150a;
    }

    public z X() {
        z.a r0 = z.f19158a;
        Type r2 = W().getGenericType();
        kotlin.n0.d.o.e(r2, "member.genericType");
        return r0.a(r2);
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.n
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.e.a.n0.x b() {
        return X();
    }
}
