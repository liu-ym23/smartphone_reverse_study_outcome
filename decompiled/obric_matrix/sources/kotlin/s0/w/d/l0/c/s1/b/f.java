package kotlin.s0.w.d.l0.c.s1.b;

import java.lang.annotation.Annotation;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f implements kotlin.s0.w.d.l0.e.a.n0.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f19128b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.g.f f19129a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public final f a(Object r1, kotlin.s0.w.d.l0.g.f r2) {
            kotlin.n0.d.o.f(r1, "value");
            if (d.g(r1.getClass()) == false) goto L6;
            return new q(r2, (Enum) r1);
        L6:
            if ((r1 instanceof Annotation) == false) goto L9;
            return new g(r2, (Annotation) r1);
        L9:
            if ((r1 instanceof Object[]) == false) goto L12;
            return new j(r2, (Object[]) r1);
        L12:
            if ((r1 instanceof Class) == false) goto L15;
            return new m(r2, (Class) r1);
        L15:
            return new s(r2, r1);
        }
    }

    static {
        f19128b = new a(null);
    }

    private f(kotlin.s0.w.d.l0.g.f r1) {
        this.f19129a = r1;
    }

    public /* synthetic */ f(kotlin.s0.w.d.l0.g.f r1, kotlin.n0.d.g r2) {
        this(r1);
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.b
    public kotlin.s0.w.d.l0.g.f getName() {
        return this.f19129a;
    }
}
