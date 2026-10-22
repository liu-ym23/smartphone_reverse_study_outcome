package d.b.r;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
abstract class r<T> {

    class a extends r<Iterable<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ r f14491a;

        a(r r1) {
            this.f14491a = r1;
        }

        @Override // d.b.r.r
        /* bridge */ /* synthetic */ void a(d.b.r.t r1, Object r2) {
            d(r1, (Iterable) r2);
        }

        void d(d.b.r.t r3, Iterable<T> r4) {
            if (r4 != null) goto L4;
            return;
        L4:
            Iterator<T> r5 = r4.iterator();
        L6:
            if (r5.hasNext() == false) goto L8;
            T r0 = r5.next();
            this.f14491a.a(r3, r0);
            goto L6
        }
    }

    class b extends r<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ r f14492a;

        b(r r1) {
            this.f14492a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d.b.r.r
        void a(d.b.r.t r5, Object r6) {
            if (r6 != null) goto L4;
            return;
        L4:
            int r0 = 0;
            int r1 = Array.getLength(r6);
        L5:
            if (r0 >= r1) goto L7;
            this.f14492a.a(r5, Array.get(r6, r0));
            r0 = r0 + 1;
            goto L5
        }
    }

    static final class c<T> extends r<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d.b.r.f<T, String> f14493a;

        c(d.b.r.f<T, String> r2) {
            f0.a(r2, "converter == null");
            this.f14493a = r2;
        }

        @Override // d.b.r.r
        void a(d.b.r.t r3, T r4) {
            if (r4 != null) goto L9;
            return;
        L9:
            r3.l(Boolean.parseBoolean(this.f14493a.a(r4)));     // Catch: IOException -> L6
            return;
        L6:
            e = move-exception;
            throw new RuntimeException("Unable to convert " + r4 + " to AddCommonParam", e);
        }
    }

    static final class d<T> extends r<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f14494a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f14495b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f14496c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final d.b.r.f<T, d.b.r.k0.j> f14497d;

        d(Method r1, int r2, boolean r3, d.b.r.f<T, d.b.r.k0.j> r4) {
            this.f14494a = r1;
            this.f14495b = r2;
            this.f14496c = r3;
            this.f14497d = r4;
        }

        @Override // d.b.r.r
        void a(d.b.r.t r5, T r6) {
            if (r6 == null) goto L5;
            r5.m(this.f14497d.a(r6));
            return;
        L12:
            e = move-exception;
            throw f0.r(this.f14494a, e, this.f14495b, "Unable to convert " + r6 + " to RequestBody", new Object[0]);
        L5:
            if (this.f14496c == false) goto L8;
            return;
        L8:
            throw f0.q(this.f14494a, this.f14495b, "Body parameter value must not be null.", new Object[0]);
        }
    }

    static final class e extends r<p000j.e0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final e f14498a = null;

        static {
            f14498a = new e();
        }

        e() {
        }

        @Override // d.b.r.r
        /* bridge */ /* synthetic */ void a(d.b.r.t r1, p000j.e0 r2) {
            d(r1, r2);
        }

        void d(d.b.r.t r1, p000j.e0 r2) {
            if (r2 == null) goto L6;
            r1.n(r2);
            r1.t();
            return;
        L6:
            throw new IllegalArgumentException("Body parameter value must not be null.");
        }
    }

    static final class f extends r<p000j.e0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final p000j.v f14499a;

        f(p000j.v r1) {
            this.f14499a = r1;
        }

        @Override // d.b.r.r
        /* bridge */ /* synthetic */ void a(d.b.r.t r1, p000j.e0 r2) {
            d(r1, r2);
        }

        void d(d.b.r.t r1, p000j.e0 r2) {
            if (r2 != null) goto L4;
            return;
        L4:
            r1.e(this.f14499a, r2);
            r1.t();
        }
    }

    static final class g extends r<Map<String, p000j.e0>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f14500a;

        g(String r1) {
            this.f14500a = r1;
        }

        @Override // d.b.r.r
        /* bridge */ /* synthetic */ void a(d.b.r.t r1, Map<String, p000j.e0> r2) {
            d(r1, r2);
        }

        void d(d.b.r.t r7, Map<String, p000j.e0> r8) {
            if (r8 == null) goto L18;
            Iterator<Map.Entry<String, p000j.e0>> r9 = r8.entrySet().iterator();
        L5:
            if (r9.hasNext() == false) goto L15;
            Map.Entry<String, p000j.e0> r0 = r9.next();
            String r1 = r0.getKey();
            if (r1 == null) goto L14;
            p000j.e0 r2 = r0.getValue();
            if (r2 == null) goto L12;
            r7.e(p000j.v.j(new String[]{"Content-Disposition", "form-data; name=\"" + r1 + "\"", "Content-Transfer-Encoding", this.f14500a}), r2);
            goto L5
        L12:
            throw new IllegalArgumentException("Part map contained null value for key '" + r1 + "'.");
        L14:
            throw new IllegalArgumentException("Part map contained null key.");
        L15:
            r7.t();
            return;
        L18:
            throw new IllegalArgumentException("Part map was null.");
        }
    }

    static final class h extends r<j.z.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final h f14501a = null;

        static {
            f14501a = new h();
        }

        h() {
        }

        @Override // d.b.r.r
        /* bridge */ /* synthetic */ void a(d.b.r.t r1, j.z.b r2) {
            d(r1, r2);
        }

        void d(d.b.r.t r1, j.z.b r2) {
            if (r2 == null) goto L4;
            r1.f(r2);
        L4:
            r1.t();
        }
    }

    static final class i<T> extends r<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d.b.r.f<T, Object> f14502a;

        i(d.b.r.f<T, Object> r2) {
            f0.a(r2, "converter == null");
            this.f14502a = r2;
        }

        @Override // d.b.r.r
        void a(d.b.r.t r3, T r4) {
            if (r4 != null) goto L9;
            return;
        L9:
            r3.o(this.f14502a.a(r4));     // Catch: IOException -> L6
            return;
        L6:
            e = move-exception;
            throw new RuntimeException("Unable to convert " + r4 + " to ExtraInfo", e);
        }
    }

    static final class j<T> extends r<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f14503a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d.b.r.f<T, String> f14504b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f14505c;

        j(String r2, d.b.r.f<T, String> r3, boolean r4) {
            f0.a(r2, "name == null");
            this.f14503a = r2;
            this.f14504b = r3;
            this.f14505c = r4;
        }

        @Override // d.b.r.r
        void a(d.b.r.t r2, T r3) {
            if (r3 != null) goto L4;
            return;
        L4:
            String r4 = this.f14504b.a(r3);
            if (r4 != null) goto L7;
            return;
        L7:
            r2.a(this.f14503a, r4, this.f14505c);
        }
    }

    static final class k<T> extends r<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f14506a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f14507b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final d.b.r.f<T, String> f14508c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f14509d;

        k(Method r1, int r2, d.b.r.f<T, String> r3, boolean r4) {
            this.f14506a = r1;
            this.f14507b = r2;
            this.f14508c = r3;
            this.f14509d = r4;
        }

        @Override // d.b.r.r
        /* bridge */ /* synthetic */ void a(d.b.r.t r1, Object r2) {
            d(r1, (Map) r2);
        }

        void d(d.b.r.t r7, Map<String, T> r8) {
            if (r8 == null) goto L22;
            Iterator<Map.Entry<String, T>> r9 = r8.entrySet().iterator();
        L6:
            if (r9.hasNext() == false) goto L20;
            Map.Entry<String, T> r1 = r9.next();
            String r2 = r1.getKey();
            if (r2 == null) goto L19;
            T r3 = r1.getValue();
            if (r3 == null) goto L17;
            String r4 = this.f14508c.a(r3);
            if (r4 == null) goto L15;
            r7.a(r2, r4, this.f14509d);
            goto L6
        L15:
            throw f0.q(this.f14506a, this.f14507b, "Field map value '" + r3 + "' converted to null by " + this.f14508c.getClass().getName() + " for key '" + r2 + "'.", new Object[0]);
        L17:
            throw f0.q(this.f14506a, this.f14507b, "Field map contained null value for key '" + r2 + "'.", new Object[0]);
        L19:
            throw f0.q(this.f14506a, this.f14507b, "Field map contained null key.", new Object[0]);
        L20:
            return;
        L22:
            throw f0.q(this.f14506a, this.f14507b, "Field map was null.", new Object[0]);
        }
    }

    static final class l<T> extends r<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f14510a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d.b.r.f<T, String> f14511b;

        l(String r2, d.b.r.f<T, String> r3) {
            f0.a(r2, "name == null");
            this.f14510a = r2;
            this.f14511b = r3;
        }

        @Override // d.b.r.r
        void a(d.b.r.t r2, T r3) {
            if (r3 != null) goto L4;
            return;
        L4:
            String r4 = this.f14511b.a(r3);
            if (r4 != null) goto L7;
            return;
        L7:
            r2.b(this.f14510a, r4);
        }
    }

    static final class m<T> extends r<List<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d.b.r.f<T, d.b.r.h0.b> f14512a;

        m(d.b.r.f<T, d.b.r.h0.b> r1) {
            this.f14512a = r1;
        }

        @Override // d.b.r.r
        /* bridge */ /* synthetic */ void a(d.b.r.t r1, Object r2) {
            d(r1, (List) r2);
        }

        void d(d.b.r.t r3, List<T> r4) {
            if (r4 != null) goto L4;
            return;
        L4:
            Iterator<T> r5 = r4.iterator();
        L6:
            if (r5.hasNext() == false) goto L8;
            T r0 = r5.next();
            d.b.r.h0.b r1 = this.f14512a.a(r0);
            r3.b(r1.a(), r1.b());
            goto L6
        }
    }

    static final class n<T> extends r<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f14513a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f14514b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final d.b.r.f<T, String> f14515c;

        n(Method r1, int r2, d.b.r.f<T, String> r3) {
            this.f14513a = r1;
            this.f14514b = r2;
            this.f14515c = r3;
        }

        @Override // d.b.r.r
        /* bridge */ /* synthetic */ void a(d.b.r.t r1, Object r2) {
            d(r1, (Map) r2);
        }

        void d(d.b.r.t r5, Map<String, T> r6) {
            if (r6 == null) goto L18;
            Iterator<Map.Entry<String, T>> r7 = r6.entrySet().iterator();
        L6:
            if (r7.hasNext() == false) goto L16;
            Map.Entry<String, T> r1 = r7.next();
            String r2 = r1.getKey();
            if (r2 == null) goto L15;
            T r3 = r1.getValue();
            if (r3 == null) goto L13;
            r5.b(r2, this.f14515c.a(r3));
            goto L6
        L13:
            throw f0.q(this.f14513a, this.f14514b, "Header map contained null value for key '" + r2 + "'.", new Object[0]);
        L15:
            throw f0.q(this.f14513a, this.f14514b, "Header map contained null key.", new Object[0]);
        L16:
            return;
        L18:
            throw f0.q(this.f14513a, this.f14514b, "Header map was null.", new Object[0]);
        }
    }

    static final class o<T> extends r<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d.b.r.f<T, String> f14516a;

        o(d.b.r.f<T, String> r2) {
            f0.a(r2, "converter == null");
            this.f14516a = r2;
        }

        @Override // d.b.r.r
        void a(d.b.r.t r3, T r4) {
            if (r4 != null) goto L9;
            return;
        L9:
            r3.p(Integer.parseInt(this.f14516a.a(r4)));     // Catch: IOException -> L6
            return;
        L6:
            e = move-exception;
            throw new RuntimeException("Unable to convert " + r4 + " to MaxLength", e);
        }
    }

    static final class p<T> extends r<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f14517a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d.b.r.f<T, String> f14518b;

        p(String r2, d.b.r.f<T, String> r3) {
            f0.a(r2, "name == null");
            this.f14517a = r2;
            this.f14518b = r3;
        }

        @Override // d.b.r.r
        void a(d.b.r.t r2, T r3) {
            if (r3 == null) goto L6;
            r2.q(this.f14517a, this.f14518b.a(r3));
            return;
        L6:
            throw new IllegalArgumentException("Method parameter \"" + this.f14517a + "\" value must not be null.");
        }
    }

    static final class q<T> extends r<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f14519a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f14520b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f14521c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final d.b.r.f<T, d.b.r.k0.j> f14522d;

        q(Method r1, int r2, String r3, d.b.r.f<T, d.b.r.k0.j> r4) {
            this.f14519a = r1;
            this.f14520b = r2;
            this.f14521c = r3;
            this.f14522d = r4;
        }

        @Override // d.b.r.r
        void a(d.b.r.t r4, T r5) {
            if (r5 != null) goto L10;
            return;
        L10:
            r4.c(this.f14521c, this.f14522d.a(r5));
            return;
        L7:
            e = move-exception;
            throw f0.q(this.f14519a, this.f14520b, "Unable to convert " + r5 + " to RequestBody", new Object[]{e});
        }
    }

    /* JADX INFO: renamed from: d.b.r.r$r, reason: collision with other inner class name */
    static final class C0392r<T> extends r<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f14523a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f14524b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final d.b.r.f<T, d.b.r.k0.j> f14525c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f14526d;

        C0392r(Method r1, int r2, d.b.r.f<T, d.b.r.k0.j> r3, String r4) {
            this.f14523a = r1;
            this.f14524b = r2;
            this.f14525c = r3;
            this.f14526d = r4;
        }

        @Override // d.b.r.r
        /* bridge */ /* synthetic */ void a(d.b.r.t r1, Object r2) {
            d(r1, (Map) r2);
        }

        void d(d.b.r.t r6, Map<String, T> r7) {
            if (r7 == null) goto L18;
            Iterator<Map.Entry<String, T>> r8 = r7.entrySet().iterator();
        L6:
            if (r8.hasNext() == false) goto L16;
            Map.Entry<String, T> r1 = r8.next();
            String r2 = r1.getKey();
            if (r2 == null) goto L15;
            T r3 = r1.getValue();
            if (r3 == null) goto L13;
            r6.d(r2, this.f14526d, this.f14525c.a(r3));
            goto L6
        L13:
            throw f0.q(this.f14523a, this.f14524b, "Part map contained null value for key '" + r2 + "'.", new Object[0]);
        L15:
            throw f0.q(this.f14523a, this.f14524b, "Part map contained null key.", new Object[0]);
        L16:
            return;
        L18:
            throw f0.q(this.f14523a, this.f14524b, "Part map was null.", new Object[0]);
        }
    }

    static final class s<T> extends r<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f14527a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f14528b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f14529c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final d.b.r.f<T, String> f14530d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f14531e;

        s(Method r1, int r2, String r3, d.b.r.f<T, String> r4, boolean r5) {
            this.f14527a = r1;
            this.f14528b = r2;
            f0.a(r3, "name == null");
            this.f14529c = r3;
            this.f14530d = r4;
            this.f14531e = r5;
        }

        @Override // d.b.r.r
        void a(d.b.r.t r3, T r4) {
            if (r4 == null) goto L6;
            r3.g(this.f14529c, this.f14530d.a(r4), this.f14531e);
            return;
        L6:
            throw f0.q(this.f14527a, this.f14528b, "Path parameter \"" + this.f14529c + "\" value must not be null.", new Object[0]);
        }
    }

    static final class t<T> extends r<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f14532a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d.b.r.f<T, String> f14533b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f14534c;

        t(String r2, d.b.r.f<T, String> r3, boolean r4) {
            f0.a(r2, "name == null");
            this.f14532a = r2;
            this.f14533b = r3;
            this.f14534c = r4;
        }

        @Override // d.b.r.r
        void a(d.b.r.t r2, T r3) {
            if (r3 != null) goto L4;
            return;
        L4:
            String r4 = this.f14533b.a(r3);
            if (r4 != null) goto L7;
            return;
        L7:
            r2.h(this.f14532a, r4, this.f14534c);
        }
    }

    static final class u<T> extends r<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f14535a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f14536b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final d.b.r.f<T, String> f14537c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f14538d;

        u(Method r1, int r2, d.b.r.f<T, String> r3, boolean r4) {
            this.f14535a = r1;
            this.f14536b = r2;
            this.f14537c = r3;
            this.f14538d = r4;
        }

        @Override // d.b.r.r
        /* bridge */ /* synthetic */ void a(d.b.r.t r1, Object r2) {
            d(r1, (Map) r2);
        }

        void d(d.b.r.t r6, Map<String, T> r7) {
            if (r7 != null) goto L4;
            return;
        L4:
            Iterator<Map.Entry<String, T>> r8 = r7.entrySet().iterator();
        L6:
            if (r8.hasNext() == false) goto L19;
            Map.Entry<String, T> r0 = r8.next();
            String r1 = r0.getKey();
            if (r1 == null) goto L18;
            T r2 = r0.getValue();
            if (r2 == null) goto L6;
            String r3 = this.f14537c.a(r2);
            if (r3 == null) goto L16;
            r6.h(r1, r3, this.f14538d);
            goto L6
        L16:
            throw f0.q(this.f14535a, this.f14536b, "Query map value '" + r2 + "' converted to null by " + this.f14537c.getClass().getName() + " for key '" + r1 + "'.", new Object[0]);
        L18:
            throw f0.q(this.f14535a, this.f14536b, "Query map contained null key.", new Object[0]);
        }
    }

    static final class v<T> extends r<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d.b.r.f<T, String> f14539a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f14540b;

        v(d.b.r.f<T, String> r1, boolean r2) {
            this.f14539a = r1;
            this.f14540b = r2;
        }

        @Override // d.b.r.r
        void a(d.b.r.t r2, T r3) {
            if (r3 != null) goto L4;
            return;
        L4:
            r2.h(this.f14539a.a(r3), null, this.f14540b);
        }
    }

    static final class w<T> extends r<T> {
        w() {
        }

        @Override // d.b.r.r
        void a(d.b.r.t r2, T r3) {
            if (r3 != null) goto L5;
            return;
        L5:
            if ((r3 instanceof d.b.r.i0.h0.b) == false) goto L9;
            r2.r(((d.b.r.i0.h0.b) r3).a());
            return;
        L9:
            throw new RuntimeException("wrong type:" + r3.getClass() + ",not implement QueryParamObject");
        }
    }

    static final class x extends r<Object> {
        x(Method r1, int r2) {
        }

        @Override // d.b.r.r
        void a(d.b.r.t r1, Object r2) {
            r1.s(r2);
        }
    }

    static final class y<T> extends r<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Class<T> f14541a;

        y(Class<T> r1) {
            this.f14541a = r1;
        }

        @Override // d.b.r.r
        void a(d.b.r.t r1, T r2) {
            r1.i(this.f14541a, r2);
        }
    }

    r() {
    }

    abstract void a(d.b.r.t r1, T r2);

    final r<Object> b() {
        return new b(this);
    }

    final r<Iterable<T>> c() {
        return new a(this);
    }
}
