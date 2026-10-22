package d.b.p.a.e.h.b.b;

import d.b.p.a.h.h;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class a extends d.b.p.a.e.h.a.a.c {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f14266l;

    /* JADX INFO: renamed from: d.b.p.a.e.h.b.b.a$a, reason: collision with other inner class name */
    static class C0386a extends d.b.p.a.e.h.a.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private d.b.p.a.e.h.a.a.c f14267a;

        C0386a(d.b.p.a.e.h.a.a.c r1) {
            this.f14267a = r1;
        }

        @Override // d.b.p.a.e.h.a.a.b
        public Object a(Object r1, Method r2, Object[] r3, Object r4) {
            return h.a(this.f14267a.e(), this.f14267a);
        }

        @Override // d.b.p.a.e.h.a.a.b
        public Object b(Object r1, Method r2, Object[] r3) {
            return super.b(r1, r2, r3);
        }
    }

    public a(String r1, d.b.p.a.e.h.a.a.c r2) {
        this.f14266l = r1;
        this.f14260f.put("queryLocalInterface", new C0386a(r2));
    }

    public void i() {
        new c(this.f14266l, this).a();
    }
}
