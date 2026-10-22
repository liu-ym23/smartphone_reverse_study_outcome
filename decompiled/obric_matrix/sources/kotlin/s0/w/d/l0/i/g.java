package kotlin.s0.w.d.l0.i;

import androidx.core.internal.view.SupportMenu;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final g f20329b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<a, i.f<?, ?>> f20330a;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f20331a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f20332b;

        a(Object r1, int r2) {
            this.f20331a = r1;
            this.f20332b = r2;
        }

        public boolean equals(Object r4) {
            if ((r4 instanceof a) == true) goto L5;
            return false;
        L5:
            a r5 = (a) r4;
            if (this.f20331a == r5.f20331a) goto L8;
            return false;
        L8:
            if (this.f20332b != r5.f20332b) goto L12;
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f20331a) * SupportMenu.USER_MASK) + this.f20332b;
        }
    }

    static {
        f20329b = new g(true);
    }

    g() {
        this.f20330a = new HashMap();
    }

    private g(boolean r1) {
        this.f20330a = Collections.emptyMap();
    }

    public static g c() {
        return f20329b;
    }

    public static g d() {
        return new g();
    }

    public final void a(i.f<?, ?> r4) {
        this.f20330a.put(new a(r4.b(), r4.d()), r4);
    }

    public <ContainingType extends q> i.f<ContainingType, ?> b(ContainingType r2, int r3) {
        return (i.f) this.f20330a.get(new a(r2, r3));
    }
}
