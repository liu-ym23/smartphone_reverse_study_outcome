package d.b.r;

import android.text.TextUtils;
import com.obric.matrix.common_api.INetworkApi;
import d.b.r.i0.g0;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.OPTIONS;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.QueryName;
import retrofit2.http.Streaming;
import retrofit2.http.Tag;
import retrofit2.http.Url;

/* JADX INFO: loaded from: classes.dex */
final class u<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final boolean f14561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final d.b.r.h0.a.InterfaceC0388a f14562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final List<d.b.r.j0.a> f14563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Executor f14564d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f14565e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f14566f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final String f14567g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final boolean f14568h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final int f14569i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final boolean f14570j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final int f14571k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final Object f14572l;
    final Method m;
    final d.b.r.g0.a n;
    private final h o;
    public f<d.b.r.k0.i, T> p;
    final String q;
    private final String r;
    private final boolean s;
    private final boolean t;
    private final boolean u;
    private final r<?>[] v;
    private final List<d.b.r.h0.b> w;
    private final String x;
    private y y;
    private final boolean z;

    static final class a<T> {
        private static final Pattern L = null;
        private static final Pattern M = null;
        boolean A;
        boolean B;
        String C;
        List<d.b.r.h0.b> D;
        String E;
        Set<String> F;
        String G;
        r<?>[] H;
        f<d.b.r.k0.i, T> I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        boolean f14573J;
        boolean K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final v f14574a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Method f14575b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Annotation[] f14576c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Annotation[][] f14577d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final Type[] f14578e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final y f14579f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f14580g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        String f14581h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f14582i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f14583j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        boolean f14584k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f14585l;
        boolean m;
        Object n;
        int o;
        boolean p;
        boolean q;
        boolean r;
        boolean s;
        boolean t;
        boolean u;
        boolean v;
        boolean w;
        boolean x;
        String y;
        boolean z;

        static {
            L = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
            M = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");
        }

        a(v r4, Method r5, y r6) {
            this.f14580g = 1;
            this.f14581h = "";
            this.f14582i = false;
            this.f14583j = -1;
            this.f14584k = true;
            this.f14585l = 0;
            this.m = false;
            this.n = null;
            this.o = 3;
            this.f14574a = r4;
            this.f14575b = r5;
            this.f14576c = r5.getAnnotations();
            this.f14578e = r5.getGenericParameterTypes();
            this.f14577d = r5.getParameterAnnotations();
            this.f14579f = r6;
        }

        private r<?> a(Type r1) {
            if (p000j.e0.class.isAssignableFrom(f0.j(r1)) == true) goto L5;
            return null;
        L5:
            return r.e.f14498a;
        }

        private static Class<?> b(Class<?> r1) {
            if (Boolean.TYPE != r1) goto L7;
            return Boolean.class;
        L7:
            if (Byte.TYPE != r1) goto L11;
            return Byte.class;
        L11:
            if (Character.TYPE != r1) goto L15;
            return Character.class;
        L15:
            if (Double.TYPE != r1) goto L19;
            return Double.class;
        L19:
            if (Float.TYPE != r1) goto L23;
            return Float.class;
        L23:
            if (Integer.TYPE != r1) goto L27;
            return Integer.class;
        L27:
            if (Long.TYPE != r1) goto L31;
            return Long.class;
        L31:
            if (Short.TYPE != r1) goto L34;
            return Short.class;
        L34:
            return r1;
        }

        private p000j.v d(String r3, String r4) {
            return p000j.v.j(new String[]{"Content-Disposition", "form-data; name=\"" + r3 + "\"", "Content-Transfer-Encoding", r4});
        }

        private List<d.b.r.h0.b> e(String[] r9) {
            ArrayList r0 = new ArrayList();
            int r1 = r9.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L16;
            String r4 = r9[r3];
            int r5 = r4.indexOf(58);
            if (r5 == (-1)) goto L15;
            if (r5 == 0) goto L15;
            if (r5 == (r4.length() - 1)) goto L15;
            String r6 = r4.substring(0, r5);
            String r7 = r4.substring(r5 + 1).trim();
            if (INetworkApi.CONTENT_TYPE.equalsIgnoreCase(r6) == false) goto L12;
            this.E = r7;
        L13:
            r3 = r3 + 1;
            goto L3
        L12:
            r0.add(new d.b.r.h0.b(r6, r7));
        L15:
            throw f0.o(this.f14575b, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", new Object[]{r4});
        L16:
            return r0;
        }

        private void f(String r4, String r5, boolean r6) {
            String r0 = this.y;
            if (r0 != null) goto L31;
            this.y = r4;
            if (r4 == null) goto L8;
            this.G = h(r4);
        L8:
            if (this.G == null) goto L10;
            this.m = true;
        L10:
            this.z = r6;
            if (r5.isEmpty() == false) goto L13;
            return;
        L13:
            int r7 = r5.indexOf(63);
            if (r7 != (-1)) goto L16;
        L28:
            this.C = r5;
            this.F = k(r5);
            return;
        L16:
            if (r7 >= (r5.length() - 1)) goto L28;
            String r8 = r5.substring(r7 + 1);     // Catch: IllegalArgumentException -> L23
            if (L.matcher(r8).find() == false) goto L28;
            throw f0.o(this.f14575b, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", new Object[]{r8});     // Catch: IllegalArgumentException -> L23
        L23:
            e = move-exception;
            if (e.getMessage().contains("URL query string") == false) goto L28;
            throw e;
        L31:
            throw f0.o(this.f14575b, "Only one HTTP method is allowed. Found: %s and %s.", new Object[]{r0, r4});
        }

        private void g(Annotation r5) {
            if ((r5 instanceof d.b.r.i0.c) == false) goto L7;
            String r6 = ((d.b.r.i0.c) r5).value();
            String r0 = "DELETE";
        L5:
            f(r0, r6, false);
            return;
        L7:
            if ((r5 instanceof d.b.r.i0.h) == false) goto L10;
            r6 = ((d.b.r.i0.h) r5).value();
            r0 = "GET";
            goto L5
        L10:
            if ((r5 instanceof d.b.r.i0.i) == false) goto L13;
            r6 = ((d.b.r.i0.i) r5).value();
            r0 = "HEAD";
            goto L5
        L13:
            if ((r5 instanceof d.b.r.i0.s) == false) goto L17;
            String r7 = ((d.b.r.i0.s) r5).value();
            String r1 = "PATCH";
        L15:
            f(r1, r7, true);
            return;
        L17:
            if ((r5 instanceof d.b.r.i0.t) == false) goto L20;
            r7 = ((d.b.r.i0.t) r5).value();
            r1 = "POST";
            goto L15
        L20:
            if ((r5 instanceof d.b.r.i0.u) == false) goto L23;
            r7 = ((d.b.r.i0.u) r5).value();
            r1 = "PUT";
            goto L15
        L23:
            if ((r5 instanceof d.b.r.i0.r) == false) goto L26;
            r6 = ((d.b.r.i0.r) r5).value();
            r0 = "OPTIONS";
            goto L5
        L26:
            if ((r5 instanceof d.b.r.i0.j) == false) goto L29;
            d.b.r.i0.j r8 = (d.b.r.i0.j) r5;
            f(r8.method(), r8.path(), r8.hasBody());
            return;
        L29:
            if ((r5 instanceof d.b.r.i0.n) == false) goto L36;
            String[] r9 = ((d.b.r.i0.n) r5).value();
            if (r9.length == 0) goto L34;
            this.D = e(r9);
            return;
        L34:
            throw f0.o(this.f14575b, "@Headers annotation is empty.", new Object[0]);
        L36:
            if ((r5 instanceof d.b.r.i0.q) == false) goto L43;
            if (this.A == true) goto L41;
            this.B = true;
            return;
        L41:
            throw f0.o(this.f14575b, "Only one encoding annotation is allowed.", new Object[0]);
        L43:
            if ((r5 instanceof d.b.r.i0.g) == false) goto L50;
            if (this.B == true) goto L48;
            this.A = true;
            this.K = ((d.b.r.i0.g) r5).enableRecord();
            return;
        L48:
            throw f0.o(this.f14575b, "Only one encoding annotation is allowed.", new Object[0]);
        L50:
            if ((r5 instanceof d.b.r.i0.e0) == false) goto L53;
            this.f14582i = true;
            return;
        L53:
            if ((r5 instanceof d.b.r.i0.y) == false) goto L56;
            this.f14580g = ((d.b.r.i0.y) r5).value();
            return;
        L56:
            if ((r5 instanceof d.b.r.i0.d0) == false) goto L59;
            this.f14581h = ((d.b.r.i0.d0) r5).value();
            return;
        L59:
            if ((r5 instanceof d.b.r.i0.c0) == false) goto L71;
            this.o = ((d.b.r.i0.c0) r5).value();
            return;
        }

        static String h(String r1) {
            Matcher r2 = L.matcher(r1);     // Catch: IllegalArgumentException -> L8
            if (r2.find() == false) goto L6;
            return r2.group(1);
        L6:
            return null;
        L11:
            return null;
        }

        private r<?> i(int r9, Type r10, Annotation[] r11, boolean r12) {
            if (r11 == null) goto L18;
            int r2 = r11.length;
            r<?> r4 = null;
            int r3 = 0;
        L5:
            if (r3 >= r2) goto L19;
            Annotation r5 = r11[r3];
            r<?> r6 = j(r9, r10, r11, r5);
            if (r6 == null) goto L9;
        L11:
            if (r6 == null) goto L15;
            if (r4 != null) goto L17;
            r4 = r6;
            goto L15
        L17:
            throw f0.q(this.f14575b, r9, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
        L15:
            r3 = r3 + 1;
            goto L5
        L9:
            if (s.j() == false) goto L11;
            r6 = m(r9, r10, r11, r5);
        L19:
            if (r4 != null) goto L27;
            if (r12 == false) goto L26;
            if (f0.j(r10) != kotlin.k0.d.class) goto L26;
            this.f14573J = true;     // Catch: NoClassDefFoundError -> L28
            return null;
        L26:
            throw f0.q(this.f14575b, r9, "No Retrofit annotation found.", new Object[0]);
        L27:
            return r4;
        L18:
            r4 = null;
            goto L19
        }

        private r<?> j(int r8, Type r9, Annotation[] r10, Annotation r11) {
            if ((r11 instanceof g0) == false) goto L42;
            r(r8, r9);
            if (this.w == true) goto L40;
            if (this.s == true) goto L38;
            if (this.t == true) goto L36;
            if (this.C != null) goto L34;
            if (this.u == true) goto L32;
            if (this.v == true) goto L30;
            this.w = true;
            if (r9 == String.class) goto L28;
            if (r9 == URI.class) goto L28;
            if ((r9 instanceof Class) == false) goto L26;
            if ("android.net.Uri".equals(((Class) r9).getName()) == true) goto L28;
        L26:
            throw f0.q(this.f14575b, r8, "@Url must be String, java.net.URI, or android.net.Uri type.", new Object[0]);
        L28:
            return new r.x(this.f14575b, r8);
        L30:
            throw f0.q(this.f14575b, r8, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
        L32:
            throw f0.q(this.f14575b, r8, "A @Url parameter must not come after a @QueryName.", new Object[0]);
        L34:
            throw f0.q(this.f14575b, r8, "@Url cannot be used with @%s URL", new Object[]{this.y});
        L36:
            throw f0.q(this.f14575b, r8, "A @Url parameter must not come after a @Query.", new Object[0]);
        L38:
            throw f0.q(this.f14575b, r8, "@Path parameters may not be used with @Url.", new Object[0]);
        L40:
            throw f0.q(this.f14575b, r8, "Multiple @Url method annotations found.", new Object[0]);
        L42:
            if ((r11 instanceof d.b.r.i0.x) == false) goto L66;
            r(r8, r9);
            if (this.t == true) goto L64;
            if (this.w == true) goto L62;
            if (this.C == null) goto L60;
            if (this.u == true) goto L58;
            if (this.v == true) goto L56;
            this.s = true;
            d.b.r.i0.x r12 = (d.b.r.i0.x) r11;
            String r3 = r12.value();
            q(r8, r3);
            return new r.s(this.f14575b, r8, r3, this.f14574a.t(r9, r10), r12.encode());
        L56:
            throw f0.q(this.f14575b, r8, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
        L58:
            throw f0.q(this.f14575b, r8, "A @Path parameter must not come after a @QueryName.", new Object[0]);
        L60:
            throw f0.q(this.f14575b, r8, "@Path can only be used with relative url on @%s", new Object[]{this.y});
        L62:
            throw f0.q(this.f14575b, r8, "@Path parameters may not be used with @Url.", new Object[0]);
        L64:
            throw f0.q(this.f14575b, r8, "A @Path parameter must not come after a @Query.", new Object[0]);
        L66:
            if ((r11 instanceof d.b.r.i0.z) == false) goto L82;
            r(r8, r9);
            d.b.r.i0.z r13 = (d.b.r.i0.z) r11;
            String r0 = r13.value();
            boolean r14 = r13.encode();
            Class<?> r1 = f0.j(r9);
            this.t = true;
            if (Iterable.class.isAssignableFrom(r1) == false) goto L76;
            if ((r9 instanceof ParameterizedType) == false) goto L74;
            return new r.t(r0, this.f14574a.t(f0.i(0, (ParameterizedType) r9), r10), r14).c();
        L74:
            throw f0.q(this.f14575b, r8, r1.getSimpleName() + " must include generic type (e.g., " + r1.getSimpleName() + "<String>)", new Object[0]);
        L76:
            if (r1.isArray() == false) goto L80;
            return new r.t(r0, this.f14574a.t(b(r1.getComponentType()), r10), r14).b();
        L80:
            return new r.t(r0, this.f14574a.t(r9, r10), r14);
        L82:
            if ((r11 instanceof d.b.r.i0.b0) == false) goto L98;
            r(r8, r9);
            boolean r15 = ((d.b.r.i0.b0) r11).encoded();
            Class<?> r2 = f0.j(r9);
            this.u = true;
            if (Iterable.class.isAssignableFrom(r2) == false) goto L92;
            if ((r9 instanceof ParameterizedType) == false) goto L90;
            return new r.v(this.f14574a.t(f0.i(0, (ParameterizedType) r9), r10), r15).c();
        L90:
            throw f0.q(this.f14575b, r8, r2.getSimpleName() + " must include generic type (e.g., " + r2.getSimpleName() + "<String>)", new Object[0]);
        L92:
            if (r2.isArray() == false) goto L96;
            return new r.v(this.f14574a.t(b(r2.getComponentType()), r10), r15).b();
        L96:
            return new r.v(this.f14574a.t(r9, r10), r15);
        L98:
            if ((r11 instanceof d.b.r.i0.a0) == false) goto L114;
            r(r8, r9);
            Class<?> r4 = f0.j(r9);
            this.v = true;
            if (Map.class.isAssignableFrom(r4) == false) goto L112;
            Type r16 = f0.k(r9, r4, Map.class);
            if ((r16 instanceof ParameterizedType) == false) goto L110;
            ParameterizedType r17 = (ParameterizedType) r16;
            Type r5 = f0.i(0, r17);
            if (String.class != r5) goto L108;
            return new r.u(this.f14575b, r8, this.f14574a.t(f0.i(1, r17), r10), ((d.b.r.i0.a0) r11).encode());
        L108:
            throw f0.q(this.f14575b, r8, "@QueryMap keys must be of type String: " + r5, new Object[0]);
        L110:
            throw f0.q(this.f14575b, r8, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L112:
            throw f0.q(this.f14575b, r8, "@QueryMap parameter type must be Map.", new Object[0]);
        L114:
            if ((r11 instanceof d.b.r.i0.k) == false) goto L130;
            r(r8, r9);
            String r18 = ((d.b.r.i0.k) r11).value();
            Class<?> r6 = f0.j(r9);
            if (Iterable.class.isAssignableFrom(r6) == false) goto L124;
            if ((r9 instanceof ParameterizedType) == false) goto L122;
            return new r.l(r18, this.f14574a.t(f0.i(0, (ParameterizedType) r9), r10)).c();
        L122:
            throw f0.q(this.f14575b, r8, r6.getSimpleName() + " must include generic type (e.g., " + r6.getSimpleName() + "<String>)", new Object[0]);
        L124:
            if (r6.isArray() == false) goto L128;
            return new r.l(r18, this.f14574a.t(b(r6.getComponentType()), r10)).b();
        L128:
            return new r.l(r18, this.f14574a.t(r9, r10));
        L130:
            if ((r11 instanceof d.b.r.i0.l) == false) goto L146;
            Class<?> r19 = f0.j(r9);
            if (List.class.isAssignableFrom(r19) == false) goto L144;
            Type r20 = f0.k(r9, r19, List.class);
            if ((r20 instanceof ParameterizedType) == false) goto L142;
            Type r21 = f0.i(0, (ParameterizedType) r20);
            if (d.b.r.h0.b.class != r21) goto L140;
            return new r.m(this.f14574a.g(r21, r10));
        L140:
            throw f0.q(this.f14575b, r8, "@HeaderList keys must be of type retrofit.client.Header: " + r21, new Object[0]);
        L142:
            throw f0.q(this.f14575b, r8, "List must include generic types (e.g., List<Header>)", new Object[0]);
        L144:
            throw f0.q(this.f14575b, r8, "@HeaderList parameter type must be List.", new Object[0]);
        L146:
            if ((r11 instanceof d.b.r.i0.m) == false) goto L162;
            r(r8, r9);
            Class<?> r110 = f0.j(r9);
            if (Map.class.isAssignableFrom(r110) == false) goto L160;
            Type r22 = f0.k(r9, r110, Map.class);
            if ((r22 instanceof ParameterizedType) == false) goto L158;
            ParameterizedType r23 = (ParameterizedType) r22;
            Type r111 = f0.i(0, r23);
            if (String.class != r111) goto L156;
            return new r.n(this.f14575b, r8, this.f14574a.t(f0.i(1, r23), r10));
        L156:
            throw f0.q(this.f14575b, r8, "@HeaderMap keys must be of type String: " + r111, new Object[0]);
        L158:
            throw f0.q(this.f14575b, r8, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L160:
            throw f0.q(this.f14575b, r8, "@HeaderMap parameter type must be Map.", new Object[0]);
        L162:
            if ((r11 instanceof d.b.r.i0.e) == false) goto L182;
            r(r8, r9);
            if (this.A == false) goto L180;
            d.b.r.i0.e r112 = (d.b.r.i0.e) r11;
            String r7 = r112.value();
            boolean r113 = r112.encode();
            this.p = true;
            Class<?> r24 = f0.j(r9);
            if (Iterable.class.isAssignableFrom(r24) == false) goto L174;
            if ((r9 instanceof ParameterizedType) == false) goto L172;
            return new r.j(r7, this.f14574a.t(f0.i(0, (ParameterizedType) r9), r10), r113).c();
        L172:
            throw f0.q(this.f14575b, r8, r24.getSimpleName() + " must include generic type (e.g., " + r24.getSimpleName() + "<String>)", new Object[0]);
        L174:
            if (r24.isArray() == false) goto L178;
            return new r.j(r7, this.f14574a.t(b(r24.getComponentType()), r10), r113).b();
        L178:
            return new r.j(r7, this.f14574a.t(r9, r10), r113);
        L180:
            throw f0.q(this.f14575b, r8, "@Field parameters can only be used with form encoding.", new Object[0]);
        L182:
            if ((r11 instanceof d.b.r.i0.f) == false) goto L202;
            r(r8, r9);
            if (this.A == false) goto L200;
            Class<?> r25 = f0.j(r9);
            if (Map.class.isAssignableFrom(r25) == false) goto L198;
            Type r26 = f0.k(r9, r25, Map.class);
            if ((r26 instanceof ParameterizedType) == false) goto L196;
            ParameterizedType r27 = (ParameterizedType) r26;
            Type r28 = f0.i(0, r27);
            if (String.class != r28) goto L194;
            f<T, String> r29 = this.f14574a.t(f0.i(1, r27), r10);
            this.p = true;
            return new r.k(this.f14575b, r8, r29, ((d.b.r.i0.f) r11).encode());
        L194:
            throw f0.q(this.f14575b, r8, "@FieldMap keys must be of type String: " + r28, new Object[0]);
        L196:
            throw f0.q(this.f14575b, r8, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L198:
            throw f0.q(this.f14575b, r8, "@FieldMap parameter type must be Map.", new Object[0]);
        L200:
            throw f0.q(this.f14575b, r8, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
        L202:
            if ((r11 instanceof d.b.r.i0.v) == false) goto L213;
            if (this.B == false) goto L211;
            d.b.r.i0.v r114 = (d.b.r.i0.v) r11;
            this.q = true;
            r<?> r30 = n(r9, r114.value(), r114.encoding());
            if (r30 == null) goto L209;
            return r30;
        L209:
            return new r.q(this.f14575b, r8, r114.value(), this.f14574a.p(r9, r10, this.f14576c));
        L211:
            throw f0.q(this.f14575b, r8, "@Part parameters can only be used with multipart encoding.", new Object[0]);
        L213:
            if ((r11 instanceof d.b.r.i0.w) == false) goto L236;
            r(r8, r9);
            if (this.B == false) goto L234;
            this.q = true;
            Class<?> r31 = f0.j(r9);
            if (Map.class.isAssignableFrom(r31) == false) goto L232;
            Type r32 = f0.k(r9, r31, Map.class);
            if ((r32 instanceof ParameterizedType) == false) goto L230;
            ParameterizedType r33 = (ParameterizedType) r32;
            Type r34 = f0.i(0, r33);
            if (String.class != r34) goto L228;
            r<?> r35 = o(r33, r11);
            if (r35 == null) goto L226;
            return r35;
        L226:
            return new r.C0392r(this.f14575b, r8, this.f14574a.p(f0.i(1, r33), r10, this.f14576c), ((d.b.r.i0.w) r11).encoding());
        L228:
            throw f0.q(this.f14575b, r8, "@PartMap keys must be of type String: " + r34, new Object[0]);
        L230:
            throw f0.q(this.f14575b, r8, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L232:
            throw f0.q(this.f14575b, r8, "@PartMap parameter type must be Map.", new Object[0]);
        L234:
            throw f0.q(this.f14575b, r8, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
        L236:
            if ((r11 instanceof d.b.r.i0.b) == false) goto L258;
            r(r8, r9);
            if (this.A == true) goto L256;
            if (this.B == true) goto L256;
            if (this.r == true) goto L254;
            r<?> r115 = a(r9);
            if (r115 == null) goto L314;
            this.r = true;
            return r115;
        L314:
            f<T, d.b.r.k0.j> r36 = this.f14574a.p(r9, r10, this.f14576c);     // Catch: RuntimeException -> L250
            this.r = true;
            return new r.d(this.f14575b, r8, this.m, r36);
        L250:
            e = move-exception;
            throw f0.r(this.f14575b, e, r8, "Unable to create @Body converter for %s", new Object[]{r9});
        L254:
            throw f0.q(this.f14575b, r8, "Multiple @Body method annotations found.", new Object[0]);
        L256:
            throw f0.q(this.f14575b, r8, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
        L258:
            if ((r11 instanceof d.b.r.i0.p) == false) goto L266;
            if (this.x == true) goto L264;
            this.x = true;
            String r116 = ((d.b.r.i0.p) r11).value();
            p(r8, r116);
            return new r.p(r116, this.f14574a.t(r9, r10));
        L264:
            throw f0.q(this.f14575b, r8, "Multiple @Method method annotations found.", new Object[0]);
        L266:
            if ((r11 instanceof d.b.r.i0.o) == false) goto L274;
            return new r.o(this.f14574a.t(r9, r10));
        L270:
            e = move-exception;
            throw f0.r(this.f14575b, e, r8, "Unable to create @MaxLength converter for %s", new Object[]{r9});
        L274:
            if ((r11 instanceof d.b.r.i0.a) == false) goto L283;
            this.f14585l = ((d.b.r.i0.a) r11).level();
            return new r.c(this.f14574a.t(r9, r10));
        L279:
            e = move-exception;
            throw f0.r(this.f14575b, e, r8, "Unable to create @AddCommonParam converter for %s", new Object[]{r9});
        L283:
            if ((r11 instanceof d.b.r.i0.d) == false) goto L291;
            return new r.i(this.f14574a.o(r9, r10));
        L287:
            e = move-exception;
            throw f0.r(this.f14575b, e, r8, "Unable to create @ExtraInfo converter for %s", new Object[]{r9});
        L291:
            if ((r11 instanceof d.b.r.i0.h0.a) == false) goto L299;
            if (d.b.r.i0.h0.b.class.isAssignableFrom(f0.j(r9)) == false) goto L297;
            return new r.w();
        L297:
            throw f0.q(this.f14575b, r8, "Unable to create @QueryObject for %s not QueryParamObject type", new Object[]{r9});
        L299:
            if ((r11 instanceof d.b.r.i0.f0) == false) goto L312;
            r(r8, r9);
            Class<?> r37 = f0.j(r9);
            int r117 = r8 - 1;
        L301:
            if (r117 < 0) goto L311;
            r<?> r118 = this.H[r117];
            if ((r118 instanceof r.y) == false) goto L309;
            if (((r.y) r118).f14541a.equals(r37) == false) goto L309;
            throw f0.q(this.f14575b, r8, "@Tag type " + r37.getName() + " is duplicate of parameter #" + (r117 + 1) + " and would always overwrite its value.", new Object[0]);
        L309:
            r117 = r117 - 1;
            goto L301
        L311:
            return new r.y(r37);
        L312:
            return null;
        }

        static Set<String> k(String r2) {
            LinkedHashSet r0 = new LinkedHashSet();
            Matcher r3 = L.matcher(r2);     // Catch: IllegalArgumentException -> L9
        L5:
            if (r3.find() == false) goto L8;
            r0.add(r3.group(1));     // Catch: IllegalArgumentException -> L9
        L8:
            return r0;
        }

        private void l(Annotation r5) {
            if ((r5 instanceof DELETE) == false) goto L7;
            String r6 = ((DELETE) r5).value();
            String r0 = "DELETE";
        L5:
            f(r0, r6, false);
            return;
        L7:
            if ((r5 instanceof GET) == false) goto L10;
            r6 = ((GET) r5).value();
            r0 = "GET";
            goto L5
        L10:
            if ((r5 instanceof HEAD) == false) goto L13;
            r6 = ((HEAD) r5).value();
            r0 = "HEAD";
            goto L5
        L13:
            if ((r5 instanceof PATCH) == false) goto L17;
            String r7 = ((PATCH) r5).value();
            String r1 = "PATCH";
        L15:
            f(r1, r7, true);
            return;
        L17:
            if ((r5 instanceof POST) == false) goto L20;
            r7 = ((POST) r5).value();
            r1 = "POST";
            goto L15
        L20:
            if ((r5 instanceof PUT) == false) goto L23;
            r7 = ((PUT) r5).value();
            r1 = "PUT";
            goto L15
        L23:
            if ((r5 instanceof OPTIONS) == false) goto L26;
            r6 = ((OPTIONS) r5).value();
            r0 = "OPTIONS";
            goto L5
        L26:
            if ((r5 instanceof HTTP) == false) goto L29;
            HTTP r8 = (HTTP) r5;
            f(r8.method(), r8.path(), r8.hasBody());
            return;
        L29:
            if ((r5 instanceof Headers) == false) goto L36;
            String[] r9 = ((Headers) r5).value();
            if (r9.length == 0) goto L34;
            this.D = e(r9);
            return;
        L34:
            throw f0.o(this.f14575b, "@Headers annotation is empty.", new Object[0]);
        L36:
            if ((r5 instanceof Multipart) == false) goto L43;
            if (this.A == true) goto L41;
            this.B = true;
            return;
        L41:
            throw f0.o(this.f14575b, "Only one encoding annotation is allowed.", new Object[0]);
        L43:
            if ((r5 instanceof FormUrlEncoded) == false) goto L50;
            if (this.B == true) goto L48;
            this.A = true;
            return;
        L48:
            throw f0.o(this.f14575b, "Only one encoding annotation is allowed.", new Object[0]);
        L50:
            if ((r5 instanceof Streaming) == false) goto L59;
            this.f14582i = true;
            return;
        }

        private r<?> m(int r11, Type r12, Annotation[] r13, Annotation r14) {
            if ((r14 instanceof Url) == false) goto L42;
            r(r11, r12);
            if (this.w == true) goto L40;
            if (this.s == true) goto L38;
            if (this.t == true) goto L36;
            if (this.u == true) goto L34;
            if (this.v == true) goto L32;
            if (this.C != null) goto L30;
            this.w = true;
            if (r12 == String.class) goto L28;
            if (r12 == URI.class) goto L28;
            if ((r12 instanceof Class) == false) goto L26;
            if ("android.net.Uri".equals(((Class) r12).getName()) == true) goto L28;
        L26:
            throw f0.q(this.f14575b, r11, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
        L28:
            return new r.x(this.f14575b, r11);
        L30:
            throw f0.q(this.f14575b, r11, "@Url cannot be used with @%s URL", new Object[]{this.y});
        L32:
            throw f0.q(this.f14575b, r11, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
        L34:
            throw f0.q(this.f14575b, r11, "A @Url parameter must not come after a @QueryName.", new Object[0]);
        L36:
            throw f0.q(this.f14575b, r11, "A @Url parameter must not come after a @Query.", new Object[0]);
        L38:
            throw f0.q(this.f14575b, r11, "@Path parameters may not be used with @Url.", new Object[0]);
        L40:
            throw f0.q(this.f14575b, r11, "Multiple @Url method annotations found.", new Object[0]);
        L42:
            if ((r14 instanceof Path) == false) goto L66;
            r(r11, r12);
            if (this.t == true) goto L64;
            if (this.u == true) goto L62;
            if (this.v == true) goto L60;
            if (this.w == true) goto L58;
            if (this.C == null) goto L56;
            this.s = true;
            Path r15 = (Path) r14;
            String r7 = r15.value();
            q(r11, r7);
            return new r.s(this.f14575b, r11, r7, this.f14574a.t(r12, r13), !r15.encoded());
        L56:
            throw f0.q(this.f14575b, r11, "@Path can only be used with relative url on @%s", new Object[]{this.y});
        L58:
            throw f0.q(this.f14575b, r11, "@Path parameters may not be used with @Url.", new Object[0]);
        L60:
            throw f0.q(this.f14575b, r11, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
        L62:
            throw f0.q(this.f14575b, r11, "A @Path parameter must not come after a @QueryName.", new Object[0]);
        L64:
            throw f0.q(this.f14575b, r11, "A @Path parameter must not come after a @Query.", new Object[0]);
        L66:
            if ((r14 instanceof Query) == false) goto L82;
            r(r11, r12);
            Query r16 = (Query) r14;
            String r0 = r16.value();
            boolean r17 = r16.encoded();
            Class<?> r1 = f0.j(r12);
            this.t = true;
            if (Iterable.class.isAssignableFrom(r1) == false) goto L76;
            if ((r12 instanceof ParameterizedType) == false) goto L74;
            return new r.t(r0, this.f14574a.t(f0.i(0, (ParameterizedType) r12), r13), !r17).c();
        L74:
            throw f0.q(this.f14575b, r11, r1.getSimpleName() + " must include generic type (e.g., " + r1.getSimpleName() + "<String>)", new Object[0]);
        L76:
            if (r1.isArray() == false) goto L80;
            return new r.t(r0, this.f14574a.t(b(r1.getComponentType()), r13), !r17).b();
        L80:
            return new r.t(r0, this.f14574a.t(r12, r13), !r17);
        L82:
            if ((r14 instanceof QueryName) == false) goto L98;
            r(r11, r12);
            boolean r18 = ((QueryName) r14).encoded();
            Class<?> r2 = f0.j(r12);
            this.u = true;
            if (Iterable.class.isAssignableFrom(r2) == false) goto L92;
            if ((r12 instanceof ParameterizedType) == false) goto L90;
            return new r.v(this.f14574a.t(f0.i(0, (ParameterizedType) r12), r13), r18).c();
        L90:
            throw f0.q(this.f14575b, r11, r2.getSimpleName() + " must include generic type (e.g., " + r2.getSimpleName() + "<String>)", new Object[0]);
        L92:
            if (r2.isArray() == false) goto L96;
            return new r.v(this.f14574a.t(b(r2.getComponentType()), r13), r18).b();
        L96:
            return new r.v(this.f14574a.t(r12, r13), r18);
        L98:
            if ((r14 instanceof QueryMap) == false) goto L114;
            r(r11, r12);
            Class<?> r3 = f0.j(r12);
            this.v = true;
            if (Map.class.isAssignableFrom(r3) == false) goto L112;
            Type r19 = f0.k(r12, r3, Map.class);
            if ((r19 instanceof ParameterizedType) == false) goto L110;
            ParameterizedType r110 = (ParameterizedType) r19;
            Type r4 = f0.i(0, r110);
            if (String.class != r4) goto L108;
            return new r.u(this.f14575b, r11, this.f14574a.t(f0.i(1, r110), r13), !((QueryMap) r14).encoded());
        L108:
            throw f0.q(this.f14575b, r11, "@QueryMap keys must be of type String: " + r4, new Object[0]);
        L110:
            throw f0.q(this.f14575b, r11, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L112:
            throw f0.q(this.f14575b, r11, "@QueryMap parameter type must be Map.", new Object[0]);
        L114:
            if ((r14 instanceof Header) == false) goto L130;
            r(r11, r12);
            String r111 = ((Header) r14).value();
            Class<?> r5 = f0.j(r12);
            if (Iterable.class.isAssignableFrom(r5) == false) goto L124;
            if ((r12 instanceof ParameterizedType) == false) goto L122;
            return new r.l(r111, this.f14574a.t(f0.i(0, (ParameterizedType) r12), r13)).c();
        L122:
            throw f0.q(this.f14575b, r11, r5.getSimpleName() + " must include generic type (e.g., " + r5.getSimpleName() + "<String>)", new Object[0]);
        L124:
            if (r5.isArray() == false) goto L128;
            return new r.l(r111, this.f14574a.t(b(r5.getComponentType()), r13)).b();
        L128:
            return new r.l(r111, this.f14574a.t(r12, r13));
        L130:
            if ((r14 instanceof HeaderMap) == false) goto L146;
            r(r11, r12);
            Class<?> r112 = f0.j(r12);
            if (Map.class.isAssignableFrom(r112) == false) goto L144;
            Type r113 = f0.k(r12, r112, Map.class);
            if ((r113 instanceof ParameterizedType) == false) goto L142;
            ParameterizedType r114 = (ParameterizedType) r113;
            Type r115 = f0.i(0, r114);
            if (String.class != r115) goto L140;
            return new r.n(this.f14575b, r11, this.f14574a.t(f0.i(1, r114), r13));
        L140:
            throw f0.q(this.f14575b, r11, "@HeaderMap keys must be of type String: " + r115, new Object[0]);
        L142:
            throw f0.q(this.f14575b, r11, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L144:
            throw f0.q(this.f14575b, r11, "@HeaderMap parameter type must be Map.", new Object[0]);
        L146:
            if ((r14 instanceof Field) == false) goto L166;
            r(r11, r12);
            if (this.A == false) goto L164;
            Field r116 = (Field) r14;
            String r6 = r116.value();
            boolean r117 = r116.encoded();
            this.p = true;
            Class<?> r8 = f0.j(r12);
            if (Iterable.class.isAssignableFrom(r8) == false) goto L158;
            if ((r12 instanceof ParameterizedType) == false) goto L156;
            return new r.j(r6, this.f14574a.t(f0.i(0, (ParameterizedType) r12), r13), !r117).c();
        L156:
            throw f0.q(this.f14575b, r11, r8.getSimpleName() + " must include generic type (e.g., " + r8.getSimpleName() + "<String>)", new Object[0]);
        L158:
            if (r8.isArray() == false) goto L162;
            return new r.j(r6, this.f14574a.t(b(r8.getComponentType()), r13), !r117).b();
        L162:
            return new r.j(r6, this.f14574a.t(r12, r13), !r117);
        L164:
            throw f0.q(this.f14575b, r11, "@Field parameters can only be used with form encoding.", new Object[0]);
        L166:
            if ((r14 instanceof FieldMap) == false) goto L186;
            r(r11, r12);
            if (this.A == false) goto L184;
            Class<?> r9 = f0.j(r12);
            if (Map.class.isAssignableFrom(r9) == false) goto L182;
            Type r118 = f0.k(r12, r9, Map.class);
            if ((r118 instanceof ParameterizedType) == false) goto L180;
            ParameterizedType r119 = (ParameterizedType) r118;
            Type r10 = f0.i(0, r119);
            if (String.class != r10) goto L178;
            f<T, String> r120 = this.f14574a.t(f0.i(1, r119), r13);
            this.p = true;
            return new r.k(this.f14575b, r11, r120, !((FieldMap) r14).encoded());
        L178:
            throw f0.q(this.f14575b, r11, "@FieldMap keys must be of type String: " + r10, new Object[0]);
        L180:
            throw f0.q(this.f14575b, r11, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L182:
            throw f0.q(this.f14575b, r11, "@FieldMap parameter type must be Map.", new Object[0]);
        L184:
            throw f0.q(this.f14575b, r11, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
        L186:
            if ((r14 instanceof Part) == false) goto L197;
            if (this.B == false) goto L195;
            Part r121 = (Part) r14;
            this.q = true;
            r<?> r20 = n(r12, r121.value(), r121.encoding());
            if (r20 == null) goto L193;
            return r20;
        L193:
            return new r.q(this.f14575b, r11, r121.value(), this.f14574a.p(r12, r13, this.f14576c));
        L195:
            throw f0.q(this.f14575b, r11, "@Part parameters can only be used with multipart encoding.", new Object[0]);
        L197:
            if ((r14 instanceof PartMap) == false) goto L221;
            r(r11, r12);
            if (this.B == false) goto L219;
            this.q = true;
            Class<?> r21 = f0.j(r12);
            if (Map.class.isAssignableFrom(r21) == false) goto L217;
            Type r122 = f0.k(r12, r21, Map.class);
            if ((r122 instanceof ParameterizedType) == false) goto L215;
            ParameterizedType r123 = (ParameterizedType) r122;
            Type r22 = f0.i(0, r123);
            if (String.class != r22) goto L213;
            Type r124 = f0.i(1, r123);
            if (j.z.b.class.isAssignableFrom(f0.j(r124)) == true) goto L211;
            return new r.C0392r(this.f14575b, r11, this.f14574a.p(r124, r13, this.f14576c), ((PartMap) r14).encoding());
        L211:
            throw f0.q(this.f14575b, r11, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
        L213:
            throw f0.q(this.f14575b, r11, "@PartMap keys must be of type String: " + r22, new Object[0]);
        L215:
            throw f0.q(this.f14575b, r11, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L217:
            throw f0.q(this.f14575b, r11, "@PartMap parameter type must be Map.", new Object[0]);
        L219:
            throw f0.q(this.f14575b, r11, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
        L221:
            if ((r14 instanceof Body) == false) goto L243;
            r(r11, r12);
            if (this.A == true) goto L241;
            if (this.B == true) goto L241;
            if (this.r == true) goto L239;
            r<?> r125 = a(r12);
            if (r125 == null) goto L258;
            this.r = true;
            return r125;
        L258:
            f<T, d.b.r.k0.j> r126 = this.f14574a.p(r12, r13, this.f14576c);     // Catch: RuntimeException -> L235
            this.r = true;
            return new r.d(this.f14575b, r11, this.m, r126);
        L235:
            e = move-exception;
            throw f0.r(this.f14575b, e, r11, "Unable to create @Body converter for %s", new Object[]{r12});
        L239:
            throw f0.q(this.f14575b, r11, "Multiple @Body method annotations found.", new Object[0]);
        L241:
            throw f0.q(this.f14575b, r11, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
        L243:
            if ((r14 instanceof Tag) == false) goto L256;
            r(r11, r12);
            Class<?> r127 = f0.j(r12);
            int r128 = r11 - 1;
        L245:
            if (r128 < 0) goto L255;
            r<?> r129 = this.H[r128];
            if ((r129 instanceof r.y) == false) goto L253;
            if (((r.y) r129).f14541a.equals(r127) == false) goto L253;
            throw f0.q(this.f14575b, r11, "@Tag type " + r127.getName() + " is duplicate of parameter #" + (r128 + 1) + " and would always overwrite its value.", new Object[0]);
        L253:
            r128 = r128 - 1;
            goto L245
        L255:
            return new r.y(r127);
        L256:
            return null;
        }

        private r<?> n(Type r7, String r8, String r9) {
            Class<?> r2 = f0.j(r7);
            if (TextUtils.isEmpty(r8) == false) goto L24;
            if (Iterable.class.isAssignableFrom(r2) == false) goto L14;
            if ((r7 instanceof ParameterizedType) == true) goto L10;
            return null;
        L10:
            if (j.z.b.class.isAssignableFrom(f0.j(f0.i(0, (ParameterizedType) r7))) == true) goto L12;
        L42:
            return null;
        L12:
            return r.h.f14501a.c();
        L14:
            if (r2.isArray() == false) goto L20;
            if (j.z.b.class.isAssignableFrom(r2.getComponentType()) == false) goto L42;
            return r.h.f14501a.b();
        L20:
            if (j.z.b.class.isAssignableFrom(r2) == false) goto L42;
            return r.h.f14501a;
        L24:
            if (Iterable.class.isAssignableFrom(r2) == false) goto L33;
            if ((r7 instanceof ParameterizedType) == true) goto L29;
            return null;
        L29:
            if (p000j.e0.class.isAssignableFrom(f0.j(f0.i(0, (ParameterizedType) r7))) == false) goto L42;
            return new r.f(d(r8, r9)).c();
        L33:
            if (r2.isArray() == false) goto L39;
            if (p000j.e0.class.isAssignableFrom(b(r2.getComponentType())) == false) goto L42;
            return new r.f(d(r8, r9)).b();
        L39:
            if (p000j.e0.class.isAssignableFrom(r2) == false) goto L42;
            return new r.f(d(r8, r9));
        }

        private r<?> o(ParameterizedType r1, Annotation r2) {
            if (p000j.e0.class.isAssignableFrom(f0.j(f0.i(1, r1))) == true) goto L5;
            return null;
        L5:
            return new r.g(((d.b.r.i0.w) r2).encoding());
        }

        private void p(int r8, String r9) {
            /*  JADX ERROR: Simple mode code generation failed
                java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
                	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
                	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
                	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
                	at java.base/java.util.Objects.checkIndex(Objects.java:365)
                	at java.base/java.util.ArrayList.get(ArrayList.java:428)
                	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
                	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                */
            /*
                this = this;
                r0 = 1
                r1 = 0
                r2 = 2
                java.util.regex.Pattern r3 = d.b.r.u.a.M     // Catch: java.lang.IllegalArgumentException -> L25
                java.util.regex.Matcher r3 = r3.matcher(r9)     // Catch: java.lang.IllegalArgumentException -> L25
                boolean r3 = r3.matches()     // Catch: java.lang.IllegalArgumentException -> L25
                if (r3 == 0) goto L10
                goto L32
            L10:
                java.lang.reflect.Method r3 = r7.f14575b     // Catch: java.lang.IllegalArgumentException -> L25
                java.lang.String r4 = "@Method parameter name must match %s. Found: %s"
                java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch: java.lang.IllegalArgumentException -> L25
                java.util.regex.Pattern r6 = d.b.r.u.a.L     // Catch: java.lang.IllegalArgumentException -> L25
                java.lang.String r6 = r6.pattern()     // Catch: java.lang.IllegalArgumentException -> L25
                r5[r1] = r6     // Catch: java.lang.IllegalArgumentException -> L25
                r5[r0] = r9     // Catch: java.lang.IllegalArgumentException -> L25
                java.lang.RuntimeException r3 = d.b.r.f0.q(r3, r8, r4, r5)     // Catch: java.lang.IllegalArgumentException -> L25
                throw r3     // Catch: java.lang.IllegalArgumentException -> L25
            L25:
                r3 = move-exception
                java.lang.String r4 = r3.getMessage()
                java.lang.String r5 = "@Method parameter name must match"
                boolean r4 = r4.contains(r5)
                if (r4 != 0) goto L4f
            L32:
                java.lang.String r3 = r7.G
                if (r3 == 0) goto L4e
                boolean r3 = r3.equals(r9)
                if (r3 == 0) goto L3d
                goto L4e
            L3d:
                java.lang.reflect.Method r3 = r7.f14575b
                java.lang.Object[] r2 = new java.lang.Object[r2]
                java.lang.String r7 = r7.y
                r2[r1] = r7
                r2[r0] = r9
                java.lang.String r7 = "Method \"%s\" does not contain \"{%s}\"."
                java.lang.RuntimeException r7 = d.b.r.f0.q(r3, r8, r7, r2)
                throw r7
            L4e:
                return
            L4f:
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: d.b.r.u.a.p(int, java.lang.String):void");
        }

        private void q(int r8, String r9) {
        L8:
            e = move-exception;
            if (e.getMessage().contains("@Path parameter name must match") == false) goto L12;
            throw e;
        L12:
            if (this.F.contains(r9) == false) goto L15;
            return;
        L15:
            throw f0.q(this.f14575b, r8, "URL \"%s\" does not contain \"{%s}\".", new Object[]{this.C, r9});
        L4:
            if (M.matcher(r9).matches() == true) goto L12;
            throw f0.q(this.f14575b, r8, "@Path parameter name must match %s. Found: %s", new Object[]{L.pattern(), r9});     // Catch: IllegalArgumentException -> L8
        }

        private void r(int r3, Type r4) {
            if (f0.l(r4) == true) goto L6;
            return;
        L6:
            throw f0.q(this.f14575b, r3, "Parameter type must not include a type variable or wildcard: %s", new Object[]{r4});
        }

        u c() {
            Annotation[] r0 = this.f14576c;
            int r1 = r0.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L9;
            Annotation r4 = r0[r3];
            g(r4);
            if (s.j() == false) goto L7;
            l(r4);
        L7:
            r3 = r3 + 1;
            goto L3
        L9:
            if (this.y == null) goto L67;
            if (this.z == false) goto L13;
        L23:
            int r2 = this.f14577d.length;
            this.H = new r[r2];
            int r5 = r2 - 1;
            int r6 = 0;
        L24:
            boolean r7 = true;
            if (r6 >= r2) goto L32;
            r<?>[] r8 = this.H;
            Type r9 = this.f14578e[r6];
            Annotation[] r10 = this.f14577d[r6];
            if (r6 == r5) goto L30;
            r7 = false;
        L30:
            r8[r6] = i(r6, r9, r10, r7);
            r6 = r6 + 1;
            goto L24
        L32:
            if (this.C == null) goto L34;
        L38:
            boolean r11 = this.A;
            if (r11 == false) goto L41;
        L51:
            if (r11 == false) goto L58;
            if (this.p == true) goto L58;
            throw f0.o(this.f14575b, "Form-encoded method must contain at least one @Field.", new Object[0]);
        L58:
            if (this.B == false) goto L65;
            if (this.q == true) goto L65;
            throw f0.o(this.f14575b, "Multipart method must contain at least one @Part.", new Object[0]);
        L65:
            return new u(this);
        L41:
            if (this.B == true) goto L51;
            if (this.z == true) goto L51;
            if (this.m == true) goto L51;
            if (this.r == false) goto L51;
            throw f0.o(this.f14575b, "Non-body HTTP method cannot contain @Body.", new Object[0]);
        L34:
            if (this.w == true) goto L38;
            throw f0.o(this.f14575b, "Missing either @%s URL or @Url parameter.", new Object[]{this.y});
        L13:
            if (this.m == true) goto L23;
            if (this.B == true) goto L22;
            if (this.A == false) goto L23;
            throw f0.o(this.f14575b, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
        L22:
            throw f0.o(this.f14575b, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
        L67:
            throw f0.o(this.f14575b, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
        }
    }

    u(a r2) {
        this.f14562b = r2.f14574a.d();
        this.f14563c = r2.f14574a.i();
        this.f14564d = r2.f14574a.h();
        this.o = r2.f14574a.r();
        this.p = r2.I;
        this.q = r2.y;
        this.r = r2.C;
        this.s = r2.z;
        this.t = r2.A;
        this.u = r2.B;
        this.v = r2.H;
        this.w = r2.D;
        this.x = r2.E;
        this.f14565e = r2.f14580g;
        this.f14566f = r2.o;
        this.f14567g = r2.f14581h;
        this.f14568h = r2.f14582i;
        this.f14569i = r2.f14583j;
        this.f14570j = r2.f14584k;
        this.f14571k = r2.f14585l;
        this.f14572l = r2.n;
        this.m = r2.f14575b;
        this.n = r2.f14574a.b();
        this.f14561a = r2.f14573J;
        this.y = r2.f14579f;
        this.z = r2.K;
    }

    static u b(v r1, Method r2, y r3) {
        return new a(r1, r2, r3).c();
    }

    public y a() {
        return this.y;
    }

    public void c(y r1) {
        this.y = r1;
    }

    d.b.r.h0.c d(k r22, Object... r23) {
        t r15 = new t(this.q, this.o, this.r, this.w, this.x, this.f14565e, this.f14566f, this.f14568h, this.f14569i, this.f14570j, this.f14571k, this.f14572l, this.s, this.t, this.u, this.f14567g, this.z);
        r<?>[] r1 = this.v;
        int r2 = 0;
        if (r23 == null) goto L5;
        int r4 = r23.length;
    L7:
        if (r4 != r1.length) goto L17;
        if (this.f14561a == false) goto L11;
        r4 = r4 - 1;
    L11:
        ArrayList r5 = new ArrayList(r4);
    L12:
        if (r2 >= r4) goto L14;
        r5.add(r23[r2]);
        r1[r2].a(r15, r23[r2]);
        r2 = r2 + 1;
        goto L12
    L14:
        r15.i(o.class, new o(this.m, r5));
        return r15.j(r22);
    L17:
        throw new IllegalArgumentException("Argument count (" + r4 + ") doesn't match expected count (" + r1.length + ")");
    L5:
        r4 = 0;
        goto L7
    }

    T e(d.b.r.k0.i r1) {
        return this.p.a(r1);
    }
}
