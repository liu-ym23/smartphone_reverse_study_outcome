package d.b.r.h0;

import com.bytedance.bdlocation.client.LocationInfoConst;
import d.b.r.f0;
import d.b.r.k0.j;
import d.b.r.q;
import d.b.r.y;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import p000j.e0;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f14364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f14365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private URI f14366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<b> f14367d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final j f14368e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final e0 f14369f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f14370g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f14371h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f14372i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f14373j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f14374k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f14375l;
    private Object m;
    private final String n;
    private final Map<Class<?>, Object> o;
    private int p;
    private boolean q;
    private boolean r;
    private y s;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f14376a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f14377b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        List<b> f14378c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        j f14379d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        e0 f14380e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f14381f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f14382g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f14383h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f14384i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f14385j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f14386k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Object f14387l;
        String m;
        y n;
        Map<Class<?>, Object> o;
        boolean p;
        boolean q;

        public a() {
            this.f14376a = "GET";
        }

        a(c r3) {
            this.f14376a = c.a(r3);
            this.f14377b = c.b(r3);
            LinkedList r0 = new LinkedList();
            this.f14378c = r0;
            r0.addAll(c.j(r3));
            this.f14379d = c.k(r3);
            this.f14380e = c.l(r3);
            this.f14381f = c.m(r3);
            this.f14382g = c.n(r3);
            this.f14383h = c.o(r3);
            this.f14384i = c.p(r3);
            this.f14385j = c.q(r3);
            this.f14386k = c.c(r3);
            this.f14387l = c.d(r3);
            this.m = c.e(r3);
            this.n = c.f(r3);
            this.o = c.g(r3);
            this.p = c.h(r3);
            this.q = c.i(r3);
        }

        public c a() {
            if (this.f14377b == null) goto L7;
            return new c(this);
        L7:
            throw new IllegalStateException("url == null");
        }

        public a b(List<b> r1) {
            this.f14378c = r1;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v0, types: [d.b.r.k0.j] */
        /* JADX WARN: Type inference failed for: r4v1, types: [d.b.r.k0.j] */
        /* JADX WARN: Type inference failed for: r4v2, types: [d.b.r.k0.c] */
        public a c(String r3, j r4) {
            Objects.requireNonNull(r3, "method == null");
            if (r3.length() == 0) goto L17;
            if (r4 != 0) goto L6;
        L10:
            if (r4 == 0) goto L12;
        L14:
            this.f14376a = r3;
            this.f14379d = r4;
            return this;
        L12:
            if (f0.t(r3) == false) goto L14;
            r4 = new d.b.r.k0.c();
            r4.k("body", "null");
            goto L14
        L6:
            if (f0.s(r3) == true) goto L10;
            throw new IllegalArgumentException("method " + r3 + " must not have a request body.");
        L17:
            throw new IllegalArgumentException("method.length() == 0");
        }

        public a d(j r2) {
            c("POST", r2);
            return this;
        }

        public a e(int r1) {
            this.f14381f = r1;
            return this;
        }

        public a f(int r1) {
            this.f14382g = r1;
            return this;
        }

        public a g(Object r1) {
            this.f14387l = r1;
            return this;
        }

        public a h(String r2) {
            Objects.requireNonNull(r2, "url == null");
            this.f14377b = r2;
            return this;
        }
    }

    c(a r3) {
        this.p = 0;
        String r0 = r3.f14377b;
        Objects.requireNonNull(r0, "URL must not be null.");
        this.f14365b = r0;
        String r1 = r3.f14376a;
        Objects.requireNonNull(r1, "Method must not be null.");
        this.f14364a = r1;
        if (r3.f14378c != null) goto L5;
        List<b> r2 = Collections.emptyList();
    L6:
        this.f14367d = r2;
        this.f14368e = r3.f14379d;
        this.f14369f = r3.f14380e;
        this.f14370g = r3.f14381f;
        this.f14371h = r3.f14382g;
        this.f14372i = r3.f14383h;
        this.f14373j = r3.f14384i;
        this.f14374k = r3.f14385j;
        this.f14375l = r3.f14386k;
        this.m = r3.f14387l;
        this.n = r3.m;
        this.s = r3.n;
        this.o = r3.o;
        this.q = r3.p;
        this.r = r3.q;
        return;
    L5:
        r2 = Collections.unmodifiableList(new ArrayList(r3.f14378c));
        goto L6
    }

    public c(String r2, String r3, List<b> r4, j r5, e0 r6, int r7, int r8, boolean r9, int r10, boolean r11, int r12, Object r13, String r14, Map<Class<?>, Object> r15) {
        this.p = 0;
        Objects.requireNonNull(r2, "Method must not be null.");
        Objects.requireNonNull(r3, "URL must not be null.");
        this.f14364a = r2;
        this.f14365b = r3;
        if (r4 != null) goto L5;
        List<b> r16 = Collections.emptyList();
    L6:
        this.f14367d = r16;
        this.f14368e = r5;
        this.f14369f = r6;
        this.f14370g = r7;
        this.f14371h = r8;
        this.f14372i = r9;
        this.f14373j = r10;
        this.f14374k = r11;
        this.f14375l = r12;
        this.m = r13;
        this.n = r14;
        this.o = r15;
        return;
    L5:
        r16 = Collections.unmodifiableList(new ArrayList(r4));
        goto L6
    }

    private URI F() {
        if (q.a() == false) goto L18;
        if (this.f14366c != null) goto L16;
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.f14366c != null) goto L10;
        this.f14366c = P(this.f14365b);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);     // Catch: Throwable -> L12
    L16:
        return this.f14366c;
    L18:
        return P(this.f14365b);
    }

    private static URI P(String r2) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.isEmpty() == true) goto L17;
        return new URI(r2);
    L8:
        return URI.create(r2.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
    L11:
        return r(r2);
    L17:
        return null;
    }

    static /* synthetic */ String a(c r0) {
        return r0.f14364a;
    }

    static /* synthetic */ String b(c r0) {
        return r0.f14365b;
    }

    static /* synthetic */ int c(c r0) {
        return r0.f14375l;
    }

    static /* synthetic */ Object d(c r0) {
        return r0.m;
    }

    static /* synthetic */ String e(c r0) {
        return r0.n;
    }

    static /* synthetic */ y f(c r0) {
        return r0.s;
    }

    static /* synthetic */ Map g(c r0) {
        return r0.o;
    }

    static /* synthetic */ boolean h(c r0) {
        return r0.q;
    }

    static /* synthetic */ boolean i(c r0) {
        return r0.r;
    }

    static /* synthetic */ List j(c r0) {
        return r0.f14367d;
    }

    static /* synthetic */ j k(c r0) {
        return r0.f14368e;
    }

    static /* synthetic */ e0 l(c r0) {
        return r0.f14369f;
    }

    static /* synthetic */ int m(c r0) {
        return r0.f14370g;
    }

    static /* synthetic */ int n(c r0) {
        return r0.f14371h;
    }

    static /* synthetic */ boolean o(c r0) {
        return r0.f14372i;
    }

    static /* synthetic */ int p(c r0) {
        return r0.f14373j;
    }

    static /* synthetic */ boolean q(c r0) {
        return r0.f14374k;
    }

    private static URI r(String r2) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.isEmpty() == true) goto L18;
        int r0 = r2.indexOf("?");     // Catch: Exception -> L11
        if (r0 <= 0) goto L9;
        r2 = r2.substring(0, r0);     // Catch: Exception -> L11
    L9:
        return URI.create(r2);
    L11:
        e = move-exception;
        throw new RuntimeException(e);
    L18:
        return null;
    }

    public String A() {
        URI r0 = F();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPath();
    }

    public int B() {
        return this.f14370g;
    }

    public int C() {
        return this.p;
    }

    public e0 D() {
        return this.f14369f;
    }

    public int E() {
        return this.f14371h;
    }

    public String G() {
        return this.f14365b;
    }

    public List<b> H(String r4) {
        ArrayList r0 = null;
        if (r4 == null) goto L15;
        List<b> r3 = this.f14367d;
        if (r3 == null) goto L15;
        Iterator<b> r5 = r3.iterator();
    L9:
        if (r5.hasNext() == false) goto L15;
        b r1 = r5.next();
        if (r4.equalsIgnoreCase(r1.a()) == false) goto L9;
        if (r0 != null) goto L14;
        r0 = new ArrayList();
    L14:
        r0.add(r1);
    L15:
        return r0;
    }

    public boolean I() {
        return this.f14374k;
    }

    public boolean J() {
        return this.r;
    }

    public boolean K() {
        List<b> r2 = H("x-tt-bypass-dp");
        if (r2 != null) goto L5;
    L10:
        return false;
    L5:
        if (r2.size() <= 0) goto L10;
        if (LocationInfoConst.ALLOW_USE_LOCATION.equals(r2.get(0).b()) == false) goto L10;
        return true;
    }

    public boolean L() {
        List<b> r2 = H("x-metasec-bypass-ttnet-features");
        if (r2 != null) goto L5;
    L10:
        return false;
    L5:
        if (r2.size() <= 0) goto L10;
        if (LocationInfoConst.ALLOW_USE_LOCATION.equals(r2.get(0).b()) == false) goto L10;
        return true;
    }

    public boolean M() {
        return this.q;
    }

    public boolean N() {
        return this.f14372i;
    }

    public a O() {
        return new a(this);
    }

    public void Q(boolean r1) {
        this.r = r1;
    }

    public void R(Object r1) {
        this.m = r1;
    }

    public void S(y r1) {
        this.s = r1;
    }

    public void T(boolean r1) {
        this.q = r1;
    }

    public void U(int r1) {
        this.p = r1;
    }

    public <T> T V(Class<? extends T> r1) {
        Map<Class<?>, Object> r0 = this.o;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r1.cast(r0.get(r1));
    }

    public j s() {
        e0 r0 = this.f14369f;
        if (r0 == null) goto L7;
        return f0.c(r0);
    L7:
        return this.f14368e;
    }

    public Object t() {
        return this.m;
    }

    public b u(String r4) {
        if (r4 == null) goto L13;
        List<b> r3 = this.f14367d;
        if (r3 == null) goto L13;
        Iterator<b> r5 = r3.iterator();
    L9:
        if (r5.hasNext() == false) goto L13;
        b r1 = r5.next();
        if (r4.equalsIgnoreCase(r1.a()) == false) goto L9;
        return r1;
    L13:
        return null;
    }

    public List<b> v() {
        return this.f14367d;
    }

    public String w() {
        URI r0 = F();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getHost();
    }

    public int x() {
        return this.f14373j;
    }

    public String y() {
        return this.f14364a;
    }

    public y z() {
        return this.s;
    }
}
