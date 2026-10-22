package kotlin.s0.w.d.l0.e.a.o0;

import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.a0;
import kotlin.f0;
import kotlin.i0.g0;
import kotlin.i0.m0;
import kotlin.s0.w.d.l0.e.b.x;
import kotlin.u;

/* JADX INFO: loaded from: classes2.dex */
final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, k> f19611a;

    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f19612a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ m f19613b;

        /* JADX INFO: renamed from: kotlin.s0.w.d.l0.e.a.o0.m$a$a, reason: collision with other inner class name */
        public final class C0520a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f19614a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final List<u<String, q>> f19615b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private u<String, q> f19616c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ a f19617d;

            public C0520a(a r2, String r3) {
                kotlin.n0.d.o.f(r3, "functionName");
                this.f19617d = r2;
                this.f19614a = r3;
                this.f19615b = new ArrayList();
                this.f19616c = a0.a("V", null);
            }

            public final u<String, k> a() {
                x r0 = x.f19797a;
                String r1 = this.f19617d.b();
                String r2 = this.f19614a;
                List<u<String, q>> r3 = this.f19615b;
                ArrayList r4 = new ArrayList(kotlin.i0.r.q(r3, 10));
                Iterator<T> r5 = r3.iterator();
            L4:
                if (r5.hasNext() == false) goto L6;
                r4.add((String) ((u) r5.next()).c());
                goto L4
            L6:
                String r6 = r0.k(r1, r0.j(r2, r4, this.f19616c.c()));
                q r7 = this.f19616c.d();
                List<u<String, q>> r8 = this.f19615b;
                ArrayList r9 = new ArrayList(kotlin.i0.r.q(r8, 10));
                Iterator<T> r10 = r8.iterator();
            L8:
                if (r10.hasNext() == false) goto L11;
                r9.add((q) ((u) r10.next()).d());
                goto L8
            L11:
                return a0.a(r6, new k(r7, r9));
            }

            public final void b(String r4, e... r5) {
                kotlin.n0.d.o.f(r4, WsConstants.KEY_CONNECTION_TYPE);
                kotlin.n0.d.o.f(r5, "qualifiers");
                List<u<String, q>> r3 = this.f19615b;
                if (r5.length != 0) goto L5;
                boolean r0 = true;
            L6:
                if (r0 == false) goto L8;
                q r6 = null;
            L13:
                r3.add(a0.a(r4, r6));
                return;
            L8:
                Iterable r7 = kotlin.i0.i.r0(r5);
                LinkedHashMap r1 = new LinkedHashMap(kotlin.r0.e.c(m0.d(kotlin.i0.r.q(r7, 10)), 16));
                Iterator r8 = r7.iterator();
            L10:
                if (r8.hasNext() == false) goto L12;
                g0 r2 = (g0) r8.next();
                r1.put(Integer.valueOf(r2.c()), (e) r2.d());
                goto L10
            L12:
                r6 = new q(r1);
                goto L13
            L5:
                r0 = false;
                goto L6
            }

            public final void c(String r4, e... r5) {
                kotlin.n0.d.o.f(r4, WsConstants.KEY_CONNECTION_TYPE);
                kotlin.n0.d.o.f(r5, "qualifiers");
                Iterable r6 = kotlin.i0.i.r0(r5);
                LinkedHashMap r1 = new LinkedHashMap(kotlin.r0.e.c(m0.d(kotlin.i0.r.q(r6, 10)), 16));
                Iterator r7 = r6.iterator();
            L4:
                if (r7.hasNext() == false) goto L6;
                g0 r0 = (g0) r7.next();
                r1.put(Integer.valueOf(r0.c()), (e) r0.d());
                goto L4
            L6:
                this.f19616c = a0.a(r4, new q(r1));
            }

            public final void d(kotlin.s0.w.d.l0.k.u.e r2) {
                kotlin.n0.d.o.f(r2, WsConstants.KEY_CONNECTION_TYPE);
                String r3 = r2.g();
                kotlin.n0.d.o.e(r3, "type.desc");
                this.f19616c = a0.a(r3, null);
            }
        }

        public a(m r2, String r3) {
            kotlin.n0.d.o.f(r3, "className");
            this.f19613b = r2;
            this.f19612a = r3;
        }

        public final void a(String r3, kotlin.n0.c.l<? super C0520a, f0> r4) {
            kotlin.n0.d.o.f(r3, "name");
            kotlin.n0.d.o.f(r4, "block");
            Map r0 = m.a(this.f19613b);
            C0520a r1 = new C0520a(this, r3);
            r4.invoke(r1);
            u<String, k> r2 = r1.a();
            r0.put(r2.c(), r2.d());
        }

        public final String b() {
            return this.f19612a;
        }
    }

    public m() {
        this.f19611a = new LinkedHashMap();
    }

    public static final /* synthetic */ Map a(m r0) {
        return r0.f19611a;
    }

    public final Map<String, k> b() {
        return this.f19611a;
    }
}
