package kotlin.s0.w.d.l0.i;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i extends kotlin.s0.w.d.l0.i.a implements Serializable {

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f20339a = null;

        static {
            int[] r0 = new int[z.c.values().length];
            f20339a = r0;
            r0[z.c.o.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f20339a[z.c.n.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static abstract class b<MessageType extends i, BuilderType extends b> extends kotlin.s0.w.d.l0.i.a.AbstractC0550a<BuilderType> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private kotlin.s0.w.d.l0.i.d f20340f;

        protected b() {
            this.f20340f = kotlin.s0.w.d.l0.i.d.f20305f;
        }

        public /* bridge */ /* synthetic */ Object clone() {
            return k();
        }

        public BuilderType k() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        public final kotlin.s0.w.d.l0.i.d m() {
            return this.f20340f;
        }

        public abstract BuilderType n(MessageType r1);

        public final BuilderType o(kotlin.s0.w.d.l0.i.d r1) {
            this.f20340f = r1;
            return this;
        }
    }

    public static abstract class c<MessageType extends d<MessageType>, BuilderType extends c<MessageType, BuilderType>> extends b<MessageType, BuilderType> implements Object<MessageType> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private h<e> f20341g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f20342h;

        protected c() {
            this.f20341g = h.g();
        }

        static /* synthetic */ h p(c r0) {
            return r0.q();
        }

        private h<e> q() {
            this.f20341g.q();
            this.f20342h = false;
            return this.f20341g;
        }

        private void r() {
            if (this.f20342h == true) goto L6;
            this.f20341g = this.f20341g.b();
            this.f20342h = true;
            return;
        }

        protected final void t(MessageType r1) {
            r();
            this.f20341g.r(d.q(r1));
        }
    }

    public static abstract class d<MessageType extends d<MessageType>> extends i implements Object<MessageType> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final h<e> f20343f;

        protected class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Iterator<Map.Entry<e, Object>> f20344a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private Map.Entry<e, Object> f20345b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final boolean f20346c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ d f20347d;

            private a(d r2, boolean r3) {
                this.f20347d = r2;
                Iterator<Map.Entry<e, Object>> r4 = d.q(r2).p();
                this.f20344a = r4;
                if (r4.hasNext() == false) goto L5;
                this.f20345b = r4.next();
            L5:
                this.f20346c = r3;
            }

            /* synthetic */ a(d r1, boolean r2, a r3) {
                this(r1, r2);
            }

            public void a(int r4, kotlin.s0.w.d.l0.i.f r5) {
            L2:
                Map.Entry<e, Object> r0 = this.f20345b;
                if (r0 == null) goto L19;
                if (r0.getKey().d() >= r4) goto L24;
                e r1 = this.f20345b.getKey();
                if (this.f20346c == true) goto L9;
            L13:
                h.z(r1, this.f20345b.getValue(), r5);
            L15:
                if (this.f20344a.hasNext() == false) goto L17;
                Map.Entry<e, Object> r2 = this.f20344a.next();
            L18:
                this.f20345b = r2;
                goto L2
            L17:
                r2 = null;
                goto L18
            L9:
                if (r1.i() != z.c.o) goto L13;
                if (r1.isRepeated() == true) goto L13;
                r5.f0(r1.d(), (q) this.f20345b.getValue());
                goto L15
            L24:
                return;
            }
        }

        protected d() {
            this.f20343f = h.t();
        }

        protected d(c<MessageType, ?> r1) {
            this.f20343f = c.p(r1);
        }

        static /* synthetic */ h q(d r0) {
            return r0.f20343f;
        }

        private void z(f<MessageType, ?> r1) {
            if (r1.b() != a()) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }

        @Override // kotlin.s0.w.d.l0.i.i
        protected void l() {
            this.f20343f.q();
        }

        @Override // kotlin.s0.w.d.l0.i.i
        protected boolean o(kotlin.s0.w.d.l0.i.e r7, kotlin.s0.w.d.l0.i.f r8, g r9, int r10) {
            return i.i(this.f20343f, a(), r7, r8, r9, r10);
        }

        protected boolean r() {
            return this.f20343f.n();
        }

        protected int s() {
            return this.f20343f.k();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> Type t(f<MessageType, Type> r2) {
            z(r2);
            Object r1 = this.f20343f.h(r2.f20356d);
            if (r1 != null) goto L7;
            return r2.f20354b;
        L7:
            return (Type) r2.a(r1);
        }

        public final <Type> Type u(f<MessageType, List<Type>> r2, int r3) {
            z(r2);
            return (Type) r2.e(this.f20343f.i(r2.f20356d, r3));
        }

        public final <Type> int v(f<MessageType, List<Type>> r1) {
            z(r1);
            return this.f20343f.j(r1.f20356d);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> boolean w(f<MessageType, Type> r1) {
            z(r1);
            return this.f20343f.m(r1.f20356d);
        }

        protected d<MessageType>.a y() {
            return new a(this, false, null);
        }
    }

    static final class e implements h.b<e> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final j.b<?> f20348f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final int f20349g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final z.b f20350h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final boolean f20351i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final boolean f20352j;

        e(j.b<?> r1, int r2, z.b r3, boolean r4, boolean r5) {
            this.f20348f = r1;
            this.f20349g = r2;
            this.f20350h = r3;
            this.f20351i = r4;
            this.f20352j = r5;
        }

        public int a(e r1) {
            return this.f20349g - r1.f20349g;
        }

        public j.b<?> b() {
            return this.f20348f;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object r1) {
            return a((e) r1);
        }

        @Override // kotlin.s0.w.d.l0.i.h.b
        public int d() {
            return this.f20349g;
        }

        @Override // kotlin.s0.w.d.l0.i.h.b
        public q.a e(q.a r1, q r2) {
            return ((b) r1).n((i) r2);
        }

        @Override // kotlin.s0.w.d.l0.i.h.b
        public z.b f() {
            return this.f20350h;
        }

        @Override // kotlin.s0.w.d.l0.i.h.b
        public z.c i() {
            return this.f20350h.a();
        }

        @Override // kotlin.s0.w.d.l0.i.h.b
        public boolean isPacked() {
            return this.f20352j;
        }

        @Override // kotlin.s0.w.d.l0.i.h.b
        public boolean isRepeated() {
            return this.f20351i;
        }
    }

    public static class f<ContainingType extends q, Type> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ContainingType f20353a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Type f20354b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final q f20355c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final e f20356d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final Method f20357e;

        f(ContainingType r3, Type r4, q r5, e r6, Class r7) {
            if (r3 == null) goto L17;
            if (r6.f() != z.b.r) goto L10;
            if (r5 != null) goto L10;
            throw new IllegalArgumentException("Null messageDefaultInstance");
        L10:
            this.f20353a = r3;
            this.f20354b = r4;
            this.f20355c = r5;
            this.f20356d = r6;
            if (j.a.class.isAssignableFrom(r7) == false) goto L13;
            Method r8 = i.j(r7, "valueOf", new Class[]{Integer.TYPE});
        L14:
            this.f20357e = r8;
            return;
        L13:
            r8 = null;
            goto L14
        L17:
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }

        Object a(Object r3) {
            if (this.f20356d.isRepeated() == false) goto L13;
            if (this.f20356d.i() != z.c.n) goto L11;
            ArrayList r0 = new ArrayList();
            Iterator r4 = ((List) r3).iterator();
        L8:
            if (r4.hasNext() == false) goto L10;
            r0.add(e(r4.next()));
            goto L8
        L10:
            return r0;
        L11:
            return r3;
        L13:
            return e(r3);
        }

        public ContainingType b() {
            return this.f20353a;
        }

        public q c() {
            return this.f20355c;
        }

        public int d() {
            return this.f20356d.d();
        }

        Object e(Object r4) {
            if (this.f20356d.i() == z.c.n) goto L5;
            return r4;
        L5:
            return i.k(this.f20357e, null, new Object[]{(Integer) r4});
        }

        Object f(Object r2) {
            if (this.f20356d.i() == z.c.n) goto L5;
            return r2;
        L5:
            return Integer.valueOf(((j.a) r2).d());
        }
    }

    protected i() {
    }

    protected i(b r1) {
    }

    static /* synthetic */ boolean i(h r0, q r1, kotlin.s0.w.d.l0.i.e r2, kotlin.s0.w.d.l0.i.f r3, g r4, int r5) {
        return p(r0, r1, r2, r3, r4, r5);
    }

    static Method j(Class r4, String r5, Class... r6) {
        return r4.getMethod(r5, r6);
    L4:
        e = move-exception;
        String r7 = String.valueOf(String.valueOf(r4.getName()));
        String r8 = String.valueOf(String.valueOf(r5));
        StringBuilder r1 = new StringBuilder((r7.length() + 45) + r8.length());
        r1.append("Generated message class \"");
        r1.append(r7);
        r1.append("\" missing method \"");
        r1.append(r8);
        r1.append("\".");
        throw new RuntimeException(r1.toString(), e);
    }

    static Object k(Method r0, Object r1, Object... r2) {
        return r0.invoke(r1, r2);
    L15:
        e = move-exception;
        throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
    L4:
        e = move-exception;
        Throwable r3 = e.getCause();
        if ((r3 instanceof RuntimeException) == true) goto L14;
        if ((r3 instanceof Error) == false) goto L12;
        throw ((Error) r3);
    L12:
        throw new RuntimeException("Unexpected exception thrown by generated accessor method.", r3);
    L14:
        throw ((RuntimeException) r3);
    }

    public static <ContainingType extends q, Type> f<ContainingType, Type> m(ContainingType r13, q r14, j.b<?> r15, int r16, z.b r17, boolean r18, Class r19) {
        return new f(r13, Collections.emptyList(), r14, new e(r15, r16, r17, true, r18), r19);
    }

    public static <ContainingType extends q, Type> f<ContainingType, Type> n(ContainingType r8, Type r9, q r10, j.b<?> r11, int r12, z.b r13, Class r14) {
        return new f(r8, r9, r10, new e(r11, r12, r13, false, false), r14);
    }

    private static <MessageType extends q> boolean p(h<e> r5, MessageType r6, kotlin.s0.w.d.l0.i.e r7, kotlin.s0.w.d.l0.i.f r8, g r9, int r10) {
        int r0 = z.b(r10);
        f r11 = r9.b(r6, z.a(r10));
        if (r11 != null) goto L6;
    L4:
        boolean r3 = false;
        boolean r1 = true;
    L15:
        if (r1 == true) goto L17;
        if (r3 == false) goto L31;
        int r12 = r7.j(r7.A());
        if (r11.f20356d.f() != z.b.u) goto L28;
    L22:
        if (r7.e() <= 0) goto L30;
        j.a r13 = r11.f20356d.b().a(r7.n());
        if (r13 == null) goto L25;
        r5.a(r11.f20356d, r11.f(r13));
        goto L22
    L25:
        return true;
    L30:
        r7.i(r12);
    L57:
        return true;
    L28:
        if (r7.e() <= 0) goto L30;
        r5.a(r11.f20356d, h.u(r7, r11.f20356d.f(), false));
        goto L28
    L31:
        int r2 = a.f20339a[r11.f20356d.i().ordinal()];
        if (r2 != 1) goto L34;
        q.a r14 = null;
        if (r11.f20356d.isRepeated() == true) goto L46;
        q r15 = (q) r5.h(r11.f20356d);
        if (r15 == null) goto L46;
        r14 = r15.c();
    L46:
        if (r14 != null) goto L49;
        r14 = r11.c().f();
    L49:
        if (r11.f20356d.f() != z.b.q) goto L51;
        r7.r(r11.d(), r14, r9);
    L52:
        Object r16 = r14.build();
    L54:
        if (r11.f20356d.isRepeated() == false) goto L56;
        r5.a(r11.f20356d, r11.f(r16));
        goto L57
    L56:
        r5.v(r11.f20356d, r11.f(r16));
        goto L57
    L51:
        r7.v(r14, r9);
        goto L52
    L34:
        if (r2 == 2) goto L36;
        r16 = h.u(r7, r11.f20356d.f(), false);
        goto L54
    L36:
        int r17 = r7.n();
        j.a r18 = r11.f20356d.b().a(r17);
        if (r18 != null) goto L40;
        r8.o0(r10);
        r8.y0(r17);
        return true;
    L40:
        r16 = r18;
        goto L54
    L17:
        return r7.P(r10, r8);
    L6:
        if (r0 != h.l(r11.f20356d.f(), false)) goto L8;
        r1 = false;
        r3 = false;
        goto L15
    L8:
        e r4 = r11.f20356d;
        if (r4.f20351i == false) goto L4;
        if (r4.f20350h.c() == false) goto L4;
        if (r0 != h.l(r11.f20356d.f(), true)) goto L4;
        r1 = false;
        r3 = true;
        goto L15
    }

    @Override // kotlin.s0.w.d.l0.i.q
    public s<? extends q> h() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    protected void l() {
    }

    protected boolean o(kotlin.s0.w.d.l0.i.e r1, kotlin.s0.w.d.l0.i.f r2, g r3, int r4) {
        return r1.P(r4, r2);
    }
}
