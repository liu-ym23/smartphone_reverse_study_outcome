package kotlin.s0.w.d.l0.c.s1.b;

import com.bytedance.common.wschannel.WsConstants;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z implements kotlin.s0.w.d.l0.e.a.n0.x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f19158a = null;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public final z a(Type r3) {
            kotlin.n0.d.o.f(r3, WsConstants.KEY_CONNECTION_TYPE);
            boolean r2 = r3 instanceof Class;
            if (r2 == false) goto L8;
            Class r0 = (Class) r3;
            if (r0.isPrimitive() == false) goto L8;
            return new x(r0);
        L8:
            if ((r3 instanceof GenericArrayType) == true) goto L18;
            if (r2 == false) goto L14;
            if (((Class) r3).isArray() == true) goto L18;
        L14:
            if ((r3 instanceof WildcardType) == false) goto L21;
            return new c0((WildcardType) r3);
        L21:
            return new n(r3);
        L18:
            return new k(r3);
        }
    }

    static {
        f19158a = new a(null);
    }

    public z() {
    }

    protected abstract Type R();

    public boolean equals(Object r2) {
        if ((r2 instanceof z) == true) goto L5;
    L7:
        return false;
    L5:
        if (kotlin.n0.d.o.a(R(), ((z) r2).R()) == false) goto L7;
        return true;
    }

    public int hashCode() {
        return R().hashCode();
    }

    @Override // kotlin.s0.w.d.l0.e.a.n0.d
    public kotlin.s0.w.d.l0.e.a.n0.a i(kotlin.s0.w.d.l0.g.c r1) {
        return kotlin.s0.w.d.l0.e.a.n0.x.a.a(this, r1);
    }

    public String toString() {
        return getClass().getName() + ": " + R();
    }
}
