package d.a.a.i;

import d.a.a.j.b0;
import java.io.Closeable;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
public class b implements Closeable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final o f12384f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public m f12385g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f12386h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private DateFormat f12387i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final e f12388j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected l f12389k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private l[] f12390l;
    private int m;
    private List<a> n;
    public int o;
    protected List<d.a.a.i.q.c> p;
    protected List<d.a.a.i.q.b> q;
    public d.a.a.i.q.e r;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final l f12391a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f12392b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public d.a.a.i.q.d f12393c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public l f12394d;

        public a(l r1, String r2) {
            this.f12391a = r1;
            this.f12392b = r2;
        }

        static /* synthetic */ String a(a r0) {
            return r0.f12392b;
        }

        static /* synthetic */ l b(a r0) {
            return r0.f12391a;
        }
    }

    public b(e r2, m r3) {
        this.f12386h = d.a.a.a.f12372i;
        this.m = 0;
        this.o = 0;
        this.p = null;
        this.q = null;
        this.r = null;
        this.f12388j = r2;
        this.f12385g = r3;
        this.f12384f = r3.f12446b;
        char r1 = r2.f12407d;
        char r4 = 26;
        if (r1 != '{') goto L11;
        int r5 = r2.f12408e + 1;
        r2.f12408e = r5;
        if (r5 >= r2.r) goto L8;
        r4 = r2.q.charAt(r5);
    L8:
        r2.f12407d = r4;
        int r6 = 12;
    L9:
        r2.f12404a = r6;
        return;
    L11:
        if (r1 != '[') goto L17;
        int r7 = r2.f12408e + 1;
        r2.f12408e = r7;
        if (r7 >= r2.r) goto L16;
        r4 = r2.q.charAt(r7);
    L16:
        r2.f12407d = r4;
        r6 = 14;
        goto L9
    L17:
        r2.s();
    }

    public b(String r2, m r3, int r4) {
        this(new e(r2, r4), r3);
    }

    public List<d.a.a.i.q.c> A() {
        if (this.p != null) goto L6;
        this.p = new ArrayList(2);
    L6:
        return this.p;
    }

    protected a C() {
        List<a> r1 = this.n;
        return r1.get(r1.size() - 1);
    }

    public void E(Object r9) {
        List<a> r10 = this.n;
        if (r10 != null) goto L5;
        return;
    L5:
        int r11 = r10.size();
        int r1 = 0;
    L6:
        if (r1 >= r11) goto L26;
        a r2 = this.n.get(r1);
        d.a.a.i.q.d r3 = r2.f12393c;
        if (r3 == null) goto L25;
        l r4 = r2.f12394d;
        Object r5 = null;
        if (r4 == null) goto L13;
        Object r6 = r4.f12439a;
    L14:
        String r7 = a.a(r2);
        if (r7.startsWith("$") == false) goto L23;
        int r8 = 0;
    L18:
        if (r8 >= this.m) goto L24;
        if (r7.equals(this.f12390l[r8].toString()) == false) goto L22;
        r5 = this.f12390l[r8].f12439a;
    L22:
        r8 = r8 + 1;
    L24:
        r3.g(r6, r5);
        goto L25
    L23:
        r5 = a.b(r2).f12439a;
        goto L24
    L13:
        r6 = null;
    L25:
        r1 = r1 + 1;
        goto L6
    }

    public Object F() {
        return L(null);
    }

    public Object L(Object r7) {
        e r0 = this.f12388j;
        int r1 = r0.f12404a;
        if (r1 == 2) goto L65;
        boolean r4 = true;
        if (r1 == 3) goto L59;
        if (r1 != 4) goto L9;
        String r8 = r0.X();
        this.f12388j.t(16);
        if ((this.f12388j.f12406c & d.f12402l.f12403f) == 0) goto L57;
        e r6 = new e(r8);
    L54:
        th = move-exception;
        r6.e();
        throw th;
    L49:
        if (r6.K(true) == false) goto L53;
        Date r9 = r6.o.getTime();     // Catch: Throwable -> L54
        r6.e();
        return r9;
    L53:
        r6.e();
    L57:
        return r8;
    L9:
        if (r1 == 12) goto L40;
        if (r1 != 14) goto L13;
        Collection r2 = new d.a.a.b();
    L18:
        Q(r2, r7);
        return r2;
    L13:
        switch(r1) {
            case 6: goto L36;
            case 7: goto L34;
            case 8: goto L32;
            case 9: goto L26;
            default: goto L14;
        };
    L14:
        switch(r1) {
            case 20: goto L22;
            case 21: goto L20;
            case 22: goto L17;
            case 23: goto L32;
            default: goto L16;
        };
    L17:
        r0.s();
        r2 = new TreeSet();
        goto L18
    L20:
        r0.s();
        r2 = new HashSet();
        goto L18
    L16:
        throw new d.a.a.d("syntax error, " + this.f12388j.i());
    L22:
        if (r0.l() == false) goto L25;
        return null;
    L25:
        throw new d.a.a.d("syntax error, " + this.f12388j.i());
    L26:
        r0.t(18);
        e r3 = this.f12388j;
        if (r3.f12404a != 18) goto L31;
        r3.t(10);
        a(10);
        long r5 = this.f12388j.k().longValue();
        a(2);
        a(11);
        return new Date(r5);
    L31:
        throw new d.a.a.d("syntax error, " + this.f12388j.i());
    L32:
        r0.s();
        return null;
    L34:
        r0.t(16);
        return Boolean.FALSE;
    L36:
        r0.t(16);
        return Boolean.TRUE;
    L40:
        if ((r0.f12406c & d.u.f12403f) == 0) goto L42;
        d.a.a.e r10 = new d.a.a.e(new LinkedHashMap());
    L44:
        return d0(r10, r7);
    L42:
        r10 = new d.a.a.e();
        goto L44
    L59:
        if ((r0.f12406c & d.n.f12403f) != 0) goto L62;
        r4 = false;
    L62:
        Number r11 = r0.f(r4);
    L63:
        this.f12388j.s();
        return r11;
    L65:
        r11 = r0.k();
        goto L63
    }

    public void M(Type r2, Collection r3) {
        N(r2, r3, null);
    }

    public void N(Type r10, Collection r11, Object r12) {
        e r1 = this.f12388j;
        int r2 = r1.f12404a;
        if (r2 != 21) goto L5;
    L6:
        r1.s();
    L7:
        e r3 = this.f12388j;
        if (r3.f12404a != 14) goto L55;
        if (Integer.TYPE != r10) goto L13;
        d.a.a.i.q.f r4 = d.a.a.j.k.f12490a;
        int r5 = 2;
    L12:
        r3.t(r5);
    L16:
        l r6 = this.f12389k;
        if (this.f12388j.t == true) goto L19;
        j0(r6, r11, r12);
    L19:
        int r13 = 0;
    L56:
        e r7 = this.f12388j;     // Catch: Throwable -> L51
        int r8 = r7.f12404a;     // Catch: Throwable -> L51
        if (r8 == 16) goto L22;
        if (r8 == 15) goto L26;
        Object r9 = null;
        if (Integer.TYPE != r10) goto L32;
        Object r14 = d.a.a.j.k.f12490a.a(this, null, null);     // Catch: Throwable -> L51
    L31:
        r11.add(r14);     // Catch: Throwable -> L51
    L47:
        e r15 = this.f12388j;     // Catch: Throwable -> L51
        if (r15.f12404a != 16) goto L50;
        r15.s();     // Catch: Throwable -> L51
    L50:
        r13 = r13 + 1;
        goto L56
    L32:
        if (String.class != r10) goto L41;
        if (r8 != 4) goto L35;
        r14 = r7.X();     // Catch: Throwable -> L51
        this.f12388j.t(16);     // Catch: Throwable -> L51
        goto L31
    L35:
        Object r16 = F();     // Catch: Throwable -> L51
        if (r16 == null) goto L39;
        r9 = r16.toString();     // Catch: Throwable -> L51
    L39:
        r14 = r9;
        goto L31
    L41:
        if (r8 != 8) goto L43;
        r7.s();     // Catch: Throwable -> L51
    L44:
        r11.add(r9);     // Catch: Throwable -> L51
        if (this.o != 1) goto L47;
        g(r11);     // Catch: Throwable -> L51
        goto L47
    L43:
        r9 = r4.a(this, r10, Integer.valueOf(r13));     // Catch: Throwable -> L51
        goto L44
    L26:
        this.f12389k = r6;
        r7.t(16);
        return;
    L22:
        r7.s();     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        this.f12389k = r6;
        throw th;
    L13:
        if (String.class != r10) goto L15;
        r4 = b0.f12473a;
        r3.t(4);
        goto L16
    L15:
        r4 = this.f12385g.c(r10);
        r3 = this.f12388j;
        r5 = 12;
        goto L12
    L55:
        throw new d.a.a.d("exepct '[', but " + f.a(this.f12388j.f12404a) + ", " + this.f12388j.i());
    L5:
        if (r2 != 22) goto L7;
        goto L6
    }

    public final void O(Collection r2) {
        Q(r2, null);
    }

    public final void Q(Collection r17, Object r18) {
        e r2 = this.f12388j;
        int r3 = r2.f12404a;
        if (r3 != 21) goto L5;
    L6:
        r2.s();
        r3 = this.f12388j.f12404a;
    L8:
        if (r3 != 14) goto L144;
        boolean r4 = this.f12388j.t;
        l r5 = this.f12389k;
        if (r4 == true) goto L145;
        j0(r5, r17, r18);
    L145:
        e r6 = this.f12388j;     // Catch: Throwable -> L139
        char r7 = r6.f12407d;     // Catch: Throwable -> L139
        if (r7 == '\"') goto L28;
        if (r7 != ']') goto L19;
        r6.q();     // Catch: Throwable -> L139
        this.f12388j.t(16);     // Catch: Throwable -> L139
        if (r4 == true) goto L156;
        this.f12389k = r5;
        return;
    L156:
        return;
    L19:
        if (r7 != '{') goto L25;
        int r8 = r6.f12408e + 1;     // Catch: Throwable -> L139
        r6.f12408e = r8;     // Catch: Throwable -> L139
        if (r8 < r6.r) goto L23;
        char r9 = 26;
    L24:
        r6.f12407d = r9;     // Catch: Throwable -> L139
        this.f12388j.f12404a = 12;     // Catch: Throwable -> L139
    L26:
        boolean r10 = false;
    L31:
        int r11 = 0;
    L32:
        if (r10 == false) goto L60;
        e r12 = this.f12388j;     // Catch: Throwable -> L139
        if (r12.f12407d != '\"') goto L60;
        String r13 = r12.Q('\"');     // Catch: Throwable -> L139
        e r14 = this.f12388j;     // Catch: Throwable -> L139
        char r15 = r14.f12407d;     // Catch: Throwable -> L139
        if (r15 != ',') goto L47;
        int r16 = r14.f12408e + 1;     // Catch: Throwable -> L139
        r14.f12408e = r16;     // Catch: Throwable -> L139
        if (r16 < r14.r) goto L40;
        char r19 = 26;
    L41:
        r14.f12407d = r19;     // Catch: Throwable -> L139
        r17.add(r13);     // Catch: Throwable -> L139
        if (this.o != 1) goto L44;
        g(r17);     // Catch: Throwable -> L139
    L44:
        if (r19 == '\"') goto L138;
        this.f12388j.s();     // Catch: Throwable -> L139
        r10 = false;
    L138:
        r11 = r11 + 1;
        goto L32
    L40:
        r19 = r14.q.charAt(r16);     // Catch: Throwable -> L139
        goto L41
    L47:
        if (r15 == ']') goto L48;
        r14.s();     // Catch: Throwable -> L139
        goto L60
    L48:
        int r20 = r14.f12408e + 1;     // Catch: Throwable -> L139
        r14.f12408e = r20;     // Catch: Throwable -> L139
        if (r20 < r14.r) goto L51;
        char r21 = 26;
    L52:
        r14.f12407d = r21;     // Catch: Throwable -> L139
        r17.add(r13);     // Catch: Throwable -> L139
        if (this.o != 1) goto L55;
        g(r17);     // Catch: Throwable -> L139
    L55:
        this.f12388j.t(16);     // Catch: Throwable -> L139
        if (r4 == true) goto L157;
        this.f12389k = r5;
        return;
    L157:
        return;
    L51:
        r21 = r14.q.charAt(r20);     // Catch: Throwable -> L139
    L60:
        e r22 = this.f12388j;     // Catch: Throwable -> L139
    L61:
        int r23 = r22.f12404a;     // Catch: Throwable -> L139
        if (r23 != 16) goto L64;
        this.f12388j.s();     // Catch: Throwable -> L139
        r22 = this.f12388j;     // Catch: Throwable -> L139
        goto L61
    L64:
        Object r24 = null;
        if (r23 != 2) goto L67;
        Number r25 = this.f12388j.k();     // Catch: Throwable -> L139
        e r110 = this.f12388j;     // Catch: Throwable -> L139
        Number r26 = r25;
    L115:
        r110.t(16);     // Catch: Throwable -> L139
        Object r27 = r26;
    L117:
        r17.add(r27);     // Catch: Throwable -> L139
        if (this.o != 1) goto L120;
        g(r17);     // Catch: Throwable -> L139
    L120:
        e r28 = this.f12388j;     // Catch: Throwable -> L139
        if (r28.f12404a != 16) goto L138;
        char r111 = r28.f12407d;     // Catch: Throwable -> L139
        if (r111 != '\"') goto L126;
        r28.f12405b = r28.f12408e;     // Catch: Throwable -> L139
        r28.P();     // Catch: Throwable -> L139
        goto L138
    L126:
        if (r111 < '0') goto L131;
        if (r111 > '9') goto L131;
        r28.f12405b = r28.f12408e;     // Catch: Throwable -> L139
        r28.N();     // Catch: Throwable -> L139
    L131:
        if (r111 != '{') goto L137;
        r28.f12404a = 12;     // Catch: Throwable -> L139
        int r112 = r28.f12408e + 1;     // Catch: Throwable -> L139
        r28.f12408e = r112;     // Catch: Throwable -> L139
        if (r112 < r28.r) goto L135;
        char r29 = 26;
    L136:
        r28.f12407d = r29;     // Catch: Throwable -> L139
        goto L138
    L135:
        r29 = r28.q.charAt(r112);     // Catch: Throwable -> L139
        goto L136
    L137:
        r28.s();     // Catch: Throwable -> L139
        goto L138
    L67:
        if (r23 == 3) goto L110;
        if (r23 != 4) goto L70;
        String r30 = this.f12388j.X();     // Catch: Throwable -> L139
        this.f12388j.t(16);     // Catch: Throwable -> L139
        r24 = r30;
        if ((this.f12388j.f12406c & d.f12402l.f12403f) != 0) goto L106;
    L85:
        r27 = r24;
        goto L117
    L106:
        e r31 = new e(r30);     // Catch: Throwable -> L139
        Object r32 = r30;
        if (r31.K(true) == false) goto L109;
        r32 = r31.o.getTime();     // Catch: Throwable -> L139
    L109:
        r31.e();     // Catch: Throwable -> L139
        r24 = r32;
        goto L85
    L70:
        if (r23 != 6) goto L72;
        Boolean r33 = Boolean.TRUE;     // Catch: Throwable -> L139
        e r34 = this.f12388j;     // Catch: Throwable -> L139
        Boolean r35 = r33;
    L102:
        r34.t(16);     // Catch: Throwable -> L139
        r24 = r35;
        goto L85
    L72:
        if (r23 != 7) goto L74;
        Boolean r36 = Boolean.FALSE;     // Catch: Throwable -> L139
        r34 = this.f12388j;     // Catch: Throwable -> L139
        r35 = r36;
        goto L102
    L74:
        if (r23 == 8) goto L100;
        if (r23 == 12) goto L96;
        if (r23 == 20) goto L94;
        if (r23 != 23) goto L81;
        e r37 = this.f12388j;     // Catch: Throwable -> L139
    L92:
        r37.t(4);     // Catch: Throwable -> L139
        goto L85
    L81:
        if (r23 != 14) goto L83;
        d.a.a.b r38 = new d.a.a.b();     // Catch: Throwable -> L139
        Q(r38, Integer.valueOf(r11));     // Catch: Throwable -> L139
        r24 = r38;
        goto L85
    L83:
        if (r23 == 15) goto L86;
        r24 = F();     // Catch: Throwable -> L139
        goto L85
    L86:
        this.f12388j.t(16);     // Catch: Throwable -> L139
        if (r4 == true) goto L158;
        this.f12389k = r5;
        return;
    L158:
        return;
    L94:
        throw new d.a.a.d("unclosed jsonArray");     // Catch: Throwable -> L139
    L96:
        if ((this.f12388j.f12406c & d.u.f12403f) == 0) goto L98;
        d.a.a.e r39 = new d.a.a.e(new LinkedHashMap());     // Catch: Throwable -> L139
    L99:
        r24 = d0(r39, Integer.valueOf(r11));     // Catch: Throwable -> L139
        goto L85
    L98:
        r39 = new d.a.a.e();     // Catch: Throwable -> L139
        goto L99
    L100:
        r37 = this.f12388j;     // Catch: Throwable -> L139
        goto L92
    L110:
        e r40 = this.f12388j;     // Catch: Throwable -> L139
        if ((r40.f12406c & d.n.f12403f) == 0) goto L113;
        Number r41 = r40.f(true);     // Catch: Throwable -> L139
    L114:
        r110 = this.f12388j;     // Catch: Throwable -> L139
        r26 = r41;
        goto L115
    L113:
        r41 = r40.f(false);     // Catch: Throwable -> L139
        goto L114
    L23:
        r9 = r6.q.charAt(r8);     // Catch: Throwable -> L139
        goto L24
    L25:
        r6.t(12);     // Catch: Throwable -> L139
        goto L26
    L28:
        if ((r6.f12406c & d.f12402l.f12403f) != 0) goto L30;
        r10 = true;
        goto L31
    L30:
        r6.t(4);     // Catch: Throwable -> L139
    L139:
        th = move-exception;
        if (r4 == true) goto L142;
        this.f12389k = r5;
    L142:
        throw th;
    L144:
        throw new d.a.a.d("syntax error, expect [, actual " + f.a(r3) + ", pos " + this.f12388j.f12405b);
    L5:
        if (r3 != 22) goto L8;
        goto L6
    }

    public d.a.a.e S() {
        if ((this.f12388j.f12406c & d.u.f12403f) == 0) goto L5;
        d.a.a.e r0 = new d.a.a.e(new LinkedHashMap());
    L7:
        return (d.a.a.e) d0(r0, null);
    L5:
        r0 = new d.a.a.e();
        goto L7
    }

    public <T> T V(Class<T> r2) {
        return (T) Y(r2, null);
    }

    public <T> T X(Type r2) {
        return (T) Y(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T Y(Type r4, Object r5) {
        e r0 = this.f12388j;
        int r1 = r0.f12404a;
        if (r1 != 8) goto L7;
        r0.s();
        return null;
    L7:
        if (r1 != 4) goto L24;
        if (r4 != byte[].class) goto L13;
        T r6 = (T) r0.a();
        this.f12388j.s();
        return r6;
    L13:
        if (r4 != char[].class) goto L24;
        String r7 = r0.X();
        this.f12388j.s();
        return (T) r7.toCharArray();
    L24:
        return (T) this.f12385g.c(r4).a(this, r4, r5);
    L22:
        e = move-exception;
        throw e;
    L19:
        e = move-exception;
        throw new d.a.a.d(e.getMessage(), e);
    }

    public final void a(int r4) {
        e r0 = this.f12388j;
        if (r0.f12404a != r4) goto L7;
        r0.s();
        return;
    L7:
        throw new d.a.a.d("syntax error, expect " + f.a(r4) + ", actual " + f.a(this.f12388j.f12404a));
    }

    protected void b(a r3) {
        if (this.n != null) goto L5;
        this.n = new ArrayList(2);
    L5:
        this.n.add(r3);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        e r0 = this.f12388j;     // Catch: Throwable -> L9
        if (r0.f12404a != 20) goto L8;
        r0.e();
        return;
    L8:
        throw new d.a.a.d("not close json text, token : " + f.a(this.f12388j.f12404a));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        this.f12388j.e();
        throw th;
    }

    public final Object d0(Map r20, Object r21) {
        e r3 = this.f12388j;
        int r4 = r3.f12404a;
        if (r4 != 8) goto L7;
        r3.s();
        return null;
    L7:
        if (r4 == 12) goto L13;
        if (r4 == 16) goto L13;
        throw new d.a.a.d("syntax error, expect {, actual " + f.a(r4) + ", " + r3.i());
    L13:
        if ((r20 instanceof d.a.a.e) == false) goto L15;
        Map r5 = ((d.a.a.e) r20).t();
        boolean r11 = true;
    L17:
        if ((r3.f12406c & d.f12402l.f12403f) == 0) goto L19;
        boolean r12 = true;
    L20:
        boolean r13 = r3.t;
        l r14 = this.f12389k;
        boolean r15 = false;
    L399:
        char r6 = r3.f12407d;     // Catch: Throwable -> L395
        if (r6 == '\"') goto L27;
        if (r6 == '}') goto L27;
        r3.W();     // Catch: Throwable -> L395
        r6 = r3.f12407d;     // Catch: Throwable -> L395
    L27:
        if (r6 != ',') goto L30;
        r3.q();     // Catch: Throwable -> L395
        r3.W();     // Catch: Throwable -> L395
        r6 = r3.f12407d;     // Catch: Throwable -> L395
        goto L27
    L30:
        char r7 = 26;
        if (r6 != '\"') goto L41;
        Object r8 = r3.S(this.f12384f, '\"');     // Catch: Throwable -> L395
        Object r9 = r8;
        if (r3.f12407d == ':') goto L39;
        r3.W();     // Catch: Throwable -> L395
        if (r3.f12407d != ':') goto L38;
        r9 = r8;
        goto L39
    L38:
        throw new d.a.a.d("expect ':' at " + r3.f12405b + ", name " + r8);     // Catch: Throwable -> L395
    L39:
        boolean r10 = false;
    L99:
        if (r10 == true) goto L122;
        int r16 = r3.f12408e + 1;     // Catch: Throwable -> L395
        r3.f12408e = r16;     // Catch: Throwable -> L395
        if (r16 < r3.r) goto L103;
        char r17 = 26;
    L104:
        r3.f12407d = r17;     // Catch: Throwable -> L395
    L106:
        if (r17 > ' ') goto L123;
        if (r17 == ' ') goto L120;
        if (r17 == '\n') goto L120;
        if (r17 == '\r') goto L120;
        if (r17 == '\t') goto L120;
        if (r17 == '\f') goto L120;
        if (r17 != '\b') goto L123;
    L120:
        r3.q();     // Catch: Throwable -> L395
        r17 = r3.f12407d;     // Catch: Throwable -> L395
    L123:
        r3.f12411h = 0;     // Catch: Throwable -> L395
        if (r9 != "@type") goto L168;
        if (r3.m(d.v) == true) goto L168;
        String r18 = r3.S(this.f12384f, '\"');     // Catch: Throwable -> L395
        Class<?> r19 = d.a.a.k.d.C(r18, this.f12385g.f12447c);     // Catch: Throwable -> L395
        if (r19 != null) goto L131;
        r20.put("@type", r18);     // Catch: Throwable -> L395
        goto L399
    L131:
        r3.t(16);     // Catch: Throwable -> L395
        if (r3.f12404a != 13) goto L152;
        r3.t(16);     // Catch: Throwable -> L395
        d.a.a.i.q.f r0 = this.f12385g.c(r19);     // Catch: Exception -> L149 Throwable -> L395
        if ((r0 instanceof g) == false) goto L137;
        Object r110 = ((g) r0).b(this, r19);     // Catch: Exception -> L149 Throwable -> L395
    L138:
        if (r110 == null) goto L140;
    L146:
        if (r13 == true) goto L148;
        this.f12389k = r14;
    L148:
        return r110;
    L140:
        if (r19 != Cloneable.class) goto L143;
        r110 = new HashMap();     // Catch: Exception -> L149 Throwable -> L395
        goto L146
    L143:
        if ("java.util.Collections$EmptyMap".equals(r18) == false) goto L145;
        r110 = Collections.emptyMap();     // Catch: Exception -> L149 Throwable -> L395
        goto L146
    L145:
        r110 = r19.newInstance();     // Catch: Exception -> L149 Throwable -> L395
        goto L146
    L137:
        r110 = null;
    L149:
        e = move-exception;
        throw new d.a.a.d("create instance error", e);     // Catch: Throwable -> L395
    L152:
        this.o = 2;     // Catch: Throwable -> L395
        if (this.f12389k == null) goto L158;
        if ((r21 instanceof Integer) == true) goto L158;
        i0();     // Catch: Throwable -> L395
    L158:
        if (r20.size() <= 0) goto L163;
        Object r1 = d.a.a.k.d.a(r20, r19, this.f12385g);     // Catch: Throwable -> L395
        g0(r1);     // Catch: Throwable -> L395
        if (r13 == true) goto L162;
        this.f12389k = r14;
    L162:
        return r1;
    L163:
        Object r2 = this.f12385g.c(r19).a(this, r19, r21);     // Catch: Throwable -> L395
        if (r13 == true) goto L166;
        this.f12389k = r14;
    L166:
        return r2;
    L168:
        if (r9 != "$ref") goto L213;
        if (r14 == null) goto L213;
        if (r3.m(d.v) == true) goto L213;
        r3.t(4);     // Catch: Throwable -> L395
        if (r3.f12404a != 4) goto L212;
        String r22 = r3.X();     // Catch: Throwable -> L395
        r3.t(13);     // Catch: Throwable -> L395
        if ("@".equals(r22) == false) goto L185;
        l r23 = this.f12389k;     // Catch: Throwable -> L395
        Object r24 = r23.f12439a;     // Catch: Throwable -> L395
        if ((r24 instanceof Object[]) == false) goto L179;
    L188:
        Object r25 = r24;
    L204:
        if (r3.f12404a != 13) goto L210;
        r3.t(16);     // Catch: Throwable -> L395
        if (r13 == true) goto L208;
        this.f12389k = r14;
    L208:
        return r25;
    L210:
        throw new d.a.a.d("syntax error, " + r3.i());     // Catch: Throwable -> L395
    L179:
        if ((r24 instanceof Collection) == true) goto L188;
        l r26 = r23.f12440b;     // Catch: Throwable -> L395
        if (r26 == null) goto L202;
        r25 = r26.f12439a;     // Catch: Throwable -> L395
    L202:
        r25 = null;
        goto L204
    L185:
        if ("..".equals(r22) == false) goto L192;
        r24 = r14.f12439a;     // Catch: Throwable -> L395
        if (r24 != null) goto L188;
        b(new a(r14, r22));     // Catch: Throwable -> L395
        int r27 = 1;
    L190:
        this.o = r27;     // Catch: Throwable -> L395
        goto L202
    L192:
        if ("$".equals(r22) == false) goto L201;
        l r28 = r14;
    L194:
        l r29 = r28.f12440b;     // Catch: Throwable -> L395
        if (r29 == null) goto L197;
        r28 = r29;
        goto L194
    L197:
        Object r30 = r28.f12439a;     // Catch: Throwable -> L395
        if (r30 == null) goto L200;
        r25 = r30;
        goto L204
    L200:
        b(new a(r28, r22));     // Catch: Throwable -> L395
        r27 = 1;
        goto L190
    L201:
        b(new a(r14, r22));     // Catch: Throwable -> L395
        r27 = 1;
        goto L190
    L212:
        throw new d.a.a.d("illegal ref, " + f.a(r3.f12404a));     // Catch: Throwable -> L395
    L213:
        if (r13 == true) goto L219;
        if (r15 == true) goto L219;
        l r31 = j0(this.f12389k, r20, r21);     // Catch: Throwable -> L395
        if (r14 != null) goto L218;
        r14 = r31;
    L218:
        char r32 = '\"';
        r15 = true;
    L220:
        if (r17 != r32) goto L230;
        String r33 = r3.Q(r32);     // Catch: Throwable -> L395
        Object r34 = r33;
        if (r12 == false) goto L227;
        e r35 = new e(r33);     // Catch: Throwable -> L395
        Object r36 = r33;
        if (r35.K(true) == false) goto L226;
        r36 = r35.o.getTime();     // Catch: Throwable -> L395
    L226:
        r35.e();     // Catch: Throwable -> L395
        r34 = r36;
    L227:
        if (r5 == null) goto L236;
        r5.put(r9, r34);     // Catch: Throwable -> L395
    L237:
        r11 = r11;
    L329:
        char r37 = r3.f12407d;     // Catch: Throwable -> L395
        if (r37 == ',') goto L335;
        if (r37 == '}') goto L335;
        r3.W();     // Catch: Throwable -> L395
        r37 = r3.f12407d;     // Catch: Throwable -> L395
    L335:
        if (r37 != ',') goto L342;
        int r38 = r3.f12408e + 1;     // Catch: Throwable -> L395
        r3.f12408e = r38;     // Catch: Throwable -> L395
        if (r38 < r3.r) goto L339;
        char r39 = 26;
    L340:
        r3.f12407d = r39;     // Catch: Throwable -> L395
    L388:
        r11 = r11;
        goto L399
    L339:
        r39 = r3.q.charAt(r38);     // Catch: Throwable -> L395
        goto L340
    L342:
        if (r37 != '}') goto L376;
        int r40 = r3.f12408e + 1;     // Catch: Throwable -> L395
        r3.f12408e = r40;     // Catch: Throwable -> L395
        if (r40 < r3.r) goto L346;
        char r41 = 26;
    L347:
        r3.f12407d = r41;     // Catch: Throwable -> L395
        r3.f12411h = 0;     // Catch: Throwable -> L395
        if (r41 != ',') goto L356;
        int r42 = r3.f12408e + 1;     // Catch: Throwable -> L395
        r3.f12408e = r42;     // Catch: Throwable -> L395
        if (r42 < r3.r) goto L352;
        char r43 = 26;
    L353:
        r3.f12407d = r43;     // Catch: Throwable -> L395
        int r44 = 16;
    L354:
        r3.f12404a = r44;     // Catch: Throwable -> L395
    L370:
        if (r13 == true) goto L372;
        j0(this.f12389k, r20, r21);     // Catch: Throwable -> L395
    L372:
        if (r13 == true) goto L374;
        this.f12389k = r14;
    L374:
        return r20;
    L352:
        r43 = r3.q.charAt(r42);     // Catch: Throwable -> L395
        goto L353
    L356:
        if (r41 != '}') goto L363;
        int r45 = r3.f12408e + 1;     // Catch: Throwable -> L395
        r3.f12408e = r45;     // Catch: Throwable -> L395
        if (r45 < r3.r) goto L360;
        char r46 = 26;
    L361:
        r3.f12407d = r46;     // Catch: Throwable -> L395
        r44 = 13;
        goto L354
    L360:
        r46 = r3.q.charAt(r45);     // Catch: Throwable -> L395
        goto L361
    L363:
        if (r41 != ']') goto L369;
        int r47 = r3.f12408e + 1;     // Catch: Throwable -> L395
        r3.f12408e = r47;     // Catch: Throwable -> L395
        if (r47 < r3.r) goto L367;
        char r48 = 26;
    L368:
        r3.f12407d = r48;     // Catch: Throwable -> L395
        r3.f12404a = 15;     // Catch: Throwable -> L395
        goto L370
    L367:
        r48 = r3.q.charAt(r47);     // Catch: Throwable -> L395
        goto L368
    L369:
        r3.s();     // Catch: Throwable -> L395
        goto L370
    L346:
        r41 = r3.q.charAt(r40);     // Catch: Throwable -> L395
        goto L347
    L376:
        throw new d.a.a.d("syntax error, " + r3.i());     // Catch: Throwable -> L395
    L236:
        r20.put(r9, r34);     // Catch: Throwable -> L395
        goto L237
    L230:
        if (r17 < '0') goto L234;
        if (r17 > '9') goto L234;
    L235:
        r34 = r3.O();     // Catch: Throwable -> L395
    L234:
        if (r17 == '-') goto L235;
        if (r17 != '[') goto L269;
        r3.f12404a = 14;     // Catch: Throwable -> L395
        int r49 = r3.f12408e + 1;     // Catch: Throwable -> L395
        r3.f12408e = r49;     // Catch: Throwable -> L395
        if (r49 < r3.r) goto L243;
        char r50 = 26;
    L244:
        r3.f12407d = r50;     // Catch: Throwable -> L395
        ArrayList r51 = new ArrayList();     // Catch: Throwable -> L395
        if (r21 != null) goto L247;
    L249:
        boolean r52 = false;
    L250:
        if (r52 == true) goto L252;
        k0(r14);     // Catch: Throwable -> L395
    L252:
        Q(r51, r9);     // Catch: Throwable -> L395
        d.a.a.b r53 = new d.a.a.b(r51);     // Catch: Throwable -> L395
        if (r5 == null) goto L255;
        r5.put(r9, r53);     // Catch: Throwable -> L395
    L256:
        int r54 = r3.f12404a;     // Catch: Throwable -> L395
        if (r54 == 13) goto L258;
        if (r54 != 16) goto L267;
        r11 = r11;
        goto L388
    L267:
        throw new d.a.a.d("syntax error, " + r3.i());     // Catch: Throwable -> L395
    L258:
        r3.t(16);     // Catch: Throwable -> L395
        if (r13 == true) goto L261;
        this.f12389k = r14;
    L261:
        return r20;
    L255:
        r20.put(r9, r53);     // Catch: Throwable -> L395
        goto L256
    L247:
        if (r21.getClass() != Integer.class) goto L249;
        r52 = true;
        goto L250
    L243:
        r50 = r3.q.charAt(r49);     // Catch: Throwable -> L395
        goto L244
    L269:
        if (r17 != '{') goto L318;
        int r55 = r3.f12408e + 1;     // Catch: Throwable -> L395
        r3.f12408e = r55;     // Catch: Throwable -> L395
        if (r55 < r3.r) goto L273;
        char r56 = 26;
    L274:
        r3.f12407d = r56;     // Catch: Throwable -> L395
        r3.f12404a = 12;     // Catch: Throwable -> L395
        boolean r57 = r21 instanceof Integer;     // Catch: Throwable -> L395
        if ((d.u.f12403f & r3.f12406c) == 0) goto L277;
        Map r58 = new d.a.a.e(new LinkedHashMap());     // Catch: Throwable -> L395
    L278:
        if (r13 == true) goto L281;
        if (r57 == true) goto L281;
        l r59 = j0(r14, r58, r9);     // Catch: Throwable -> L395
    L283:
        if (this.r == null) goto L290;
        if (r9 == null) goto L286;
        String r60 = r9.toString();     // Catch: Throwable -> L395
    L287:
        Type r61 = this.r.c(r20, r60);     // Catch: Throwable -> L395
        if (r61 == null) goto L291;
        Object r62 = this.f12385g.c(r61).a(this, r61, r9);     // Catch: Throwable -> L395
        boolean r111 = true;
    L292:
        if (r111 == true) goto L294;
        r62 = d0(r58, r9);     // Catch: Throwable -> L395
    L294:
        if (r59 == null) goto L298;
        if (r58 == r62) goto L298;
        r59.f12439a = r20;     // Catch: Throwable -> L395
    L298:
        if (this.o != 1) goto L300;
        l(r20, r9.toString());     // Catch: Throwable -> L395
    L300:
        if (r5 == null) goto L302;
        r5.put(r9, r62);     // Catch: Throwable -> L395
    L303:
        if (r57 == false) goto L305;
        j0(r14, r62, r9);     // Catch: Throwable -> L395
    L305:
        int r63 = r3.f12404a;     // Catch: Throwable -> L395
        if (r63 == 13) goto L307;
        if (r63 == 16) goto L388;
        throw new d.a.a.d("syntax error, " + r3.i());     // Catch: Throwable -> L395
    L307:
        r3.t(16);     // Catch: Throwable -> L395
        if (r13 == true) goto L310;
        this.f12389k = r14;     // Catch: Throwable -> L395
    L310:
        if (r13 == true) goto L312;
        this.f12389k = r14;
    L312:
        return r20;
    L302:
        r20.put(r9, r62);     // Catch: Throwable -> L395
    L291:
        r62 = null;
        r111 = false;
        goto L292
    L286:
        r60 = null;
        goto L287
    L290:
        r11 = r11;
    L281:
        r59 = null;
        goto L283
    L277:
        r58 = new d.a.a.e();     // Catch: Throwable -> L395
        goto L278
    L273:
        r56 = r3.q.charAt(r55);     // Catch: Throwable -> L395
        goto L274
    L318:
        r11 = r11;
        if (r17 != 't') goto L325;
        if (r3.q.startsWith("true", r3.f12408e) == false) goto L329;
        r3.f12408e += 3;     // Catch: Throwable -> L395
        r3.q();     // Catch: Throwable -> L395
        Boolean r64 = Boolean.TRUE;     // Catch: Throwable -> L395
    L323:
        r20.put(r9, r64);     // Catch: Throwable -> L395
        goto L329
    L325:
        if (r17 == 'f') goto L327;
        r3.s();     // Catch: Throwable -> L395
        Object r65 = F();     // Catch: Throwable -> L395
        if (r20.getClass() != d.a.a.e.class) goto L380;
        r9 = r9.toString();     // Catch: Throwable -> L395
    L380:
        r20.put(r9, r65);     // Catch: Throwable -> L395
        int r66 = r3.f12404a;     // Catch: Throwable -> L395
        if (r66 == 13) goto L382;
        if (r66 == 16) goto L388;
        throw new d.a.a.d("syntax error, " + r3.i());     // Catch: Throwable -> L395
    L382:
        r3.t(16);     // Catch: Throwable -> L395
        if (r13 == true) goto L385;
        this.f12389k = r14;
    L385:
        return r20;
    L327:
        if (r3.q.startsWith("false", r3.f12408e) == false) goto L329;
        r3.f12408e += 4;     // Catch: Throwable -> L395
        r3.q();     // Catch: Throwable -> L395
        r64 = Boolean.FALSE;     // Catch: Throwable -> L395
    L219:
        r32 = '\"';
        goto L220
    L103:
        r17 = r3.q.charAt(r16);     // Catch: Throwable -> L395
        goto L104
    L122:
        r17 = r3.f12407d;     // Catch: Throwable -> L395
        goto L123
    L41:
        if (r6 == '}') goto L42;
        if (r6 != '\'') goto L60;
        Object r67 = r3.S(this.f12384f, '\'');     // Catch: Throwable -> L395
        if (r3.f12407d == ':') goto L56;
        r3.W();     // Catch: Throwable -> L395
    L56:
        if (r3.f12407d != ':') goto L59;
        r9 = r67;
        goto L39
    L59:
        throw new d.a.a.d("expect ':' at " + r3.f12405b);     // Catch: Throwable -> L395
    L60:
        if (r6 == 26) goto L394;
        if (r6 == ',') goto L392;
        if (r6 < '0') goto L68;
        if (r6 > '9') goto L68;
    L69:
        r3.f12411h = 0;     // Catch: Throwable -> L395
        r3.N();     // Catch: Throwable -> L395
        if (r3.f12404a != 2) goto L73;
        Object r68 = r3.k();     // Catch: NumberFormatException -> L81 Throwable -> L395
    L74:
        if (r11 == false) goto L77;
        r68 = r68.toString();     // Catch: NumberFormatException -> L81 Throwable -> L395
    L77:
        if (r3.f12407d != ':') goto L80;
        r9 = r68;
        goto L39
    L80:
        throw new d.a.a.d("parse number key error, " + r3.i());     // Catch: Throwable -> L395
    L73:
        r68 = r3.f(true);     // Catch: NumberFormatException -> L81 Throwable -> L395
        goto L74
    L82:
        throw new d.a.a.d("parse number key error, " + r3.i());     // Catch: Throwable -> L395
    L68:
        if (r6 == '-') goto L69;
        if (r6 != '{') goto L86;
    L94:
        r3.s();     // Catch: Throwable -> L395
        r9 = F();     // Catch: Throwable -> L395
        if (r11 == false) goto L97;
        r9 = r9.toString();     // Catch: Throwable -> L395
    L97:
        r10 = true;
        goto L99
    L86:
        if (r6 == '[') goto L94;
        Object r69 = r3.T(this.f12384f);     // Catch: Throwable -> L395
        r3.W();     // Catch: Throwable -> L395
        char r70 = r3.f12407d;     // Catch: Throwable -> L395
        r9 = r69;
        if (r70 != ':') goto L93;
        if (r11 == false) goto L39;
        r9 = r69.toString();     // Catch: Throwable -> L395
        goto L39
    L93:
        throw new d.a.a.d("expect ':' at " + r3.f12408e + ", actual " + r70);     // Catch: Throwable -> L395
    L392:
        throw new d.a.a.d("syntax error, " + r3.i());     // Catch: Throwable -> L395
    L394:
        throw new d.a.a.d("syntax error, " + r3.i());     // Catch: Throwable -> L395
    L42:
        int r71 = r3.f12408e + 1;     // Catch: Throwable -> L395
        r3.f12408e = r71;     // Catch: Throwable -> L395
        if (r71 >= r3.r) goto L46;
        r7 = r3.q.charAt(r71);     // Catch: Throwable -> L395
    L46:
        r3.f12407d = r7;     // Catch: Throwable -> L395
        r3.f12411h = 0;     // Catch: Throwable -> L395
        r3.t(16);     // Catch: Throwable -> L395
        if (r13 == true) goto L49;
        this.f12389k = r14;
    L49:
        return r20;
    L395:
        th = move-exception;
        if (r13 == true) goto L398;
        this.f12389k = r14;
    L398:
        throw th;
    L19:
        r12 = false;
        goto L20
    L15:
        r5 = null;
        r11 = false;
        goto L17
    }

    protected void g(Collection r5) {
        if ((r5 instanceof List) == false) goto L5;
        a r0 = C();
        n r2 = new n(this, (List) r5, r5.size() - 1);
    L6:
        r0.f12393c = r2;
        r0.f12394d = this.f12389k;
        this.o = 0;
        return;
    L5:
        r0 = C();
        r2 = new n(r5);
        goto L6
    }

    public void g0(Object r11) {
        Class<?> r0 = r11.getClass();
        d.a.a.i.q.f r1 = this.f12385g.c(r0);
        if ((r1 instanceof g) == false) goto L5;
        g r2 = (g) r1;
    L6:
        int r3 = this.f12388j.f12404a;
        if (r3 == 12) goto L12;
        if (r3 == 16) goto L12;
        throw new d.a.a.d("syntax error, expect {, actual " + f.a(r3));
    L12:
        String r4 = this.f12388j.R(this.f12384f);
        if (r4 != null) goto L20;
        e r6 = this.f12388j;
        int r7 = r6.f12404a;
        if (r7 == 13) goto L16;
        if (r7 != 16) goto L20;
    L16:
        r6.t(16);
        return;
    L20:
        if (r2 == null) goto L22;
        d.a.a.i.q.d r8 = r2.f(r4);
    L24:
        if (r8 == null) goto L25;
        d.a.a.k.a r5 = r8.f12460a;
        Class<?> r9 = r5.f12534l;
        Type r10 = r5.m;
        if (r9 != Integer.TYPE) goto L37;
    L35:
        this.f12388j.u(':');
        Object r12 = d.a.a.j.k.f12490a.a(this, r10, null);
    L43:
        r8.g(r11, r12);
        e r13 = this.f12388j;
        int r14 = r13.f12404a;
        if (r14 == 16) goto L12;
        if (r14 != 13) goto L12;
        r13.t(16);
        return;
    L37:
        if (r9 != String.class) goto L40;
        this.f12388j.u(':');
        r12 = h0();
        goto L43
    L40:
        if (r9 == Long.TYPE) goto L35;
        d.a.a.i.q.f r15 = this.f12385g.b(r9, r10);
        this.f12388j.u(':');
        r12 = r15.a(this, r10, null);
        goto L43
    L25:
        e r16 = this.f12388j;
        if ((r16.f12406c & d.o.f12403f) == 0) goto L32;
        r16.u(':');
        F();
        e r17 = this.f12388j;
        if (r17.f12404a != 13) goto L12;
        r17.s();
        return;
    L32:
        throw new d.a.a.d("setter not found, class " + r0.getName() + ", property " + r4);
    L22:
        r8 = null;
        goto L24
    L5:
        r2 = null;
        goto L6
    }

    public String h0() {
        e r0 = this.f12388j;
        int r1 = r0.f12404a;
        if (r1 != 4) goto L29;
        String r2 = r0.X();
        e r3 = this.f12388j;
        char r4 = r3.f12407d;
        char r5 = 26;
        if (r4 != ',') goto L12;
        int r6 = r3.f12408e + 1;
        r3.f12408e = r6;
        if (r6 >= r3.r) goto L10;
        r5 = r3.q.charAt(r6);
    L10:
        r3.f12407d = r5;
        this.f12388j.f12404a = 16;
    L27:
        return r2;
    L12:
        if (r4 != ']') goto L20;
        int r7 = r3.f12408e + 1;
        r3.f12408e = r7;
        if (r7 >= r3.r) goto L17;
        r5 = r3.q.charAt(r7);
    L17:
        r3.f12407d = r5;
        e r8 = this.f12388j;
        int r9 = 15;
    L18:
        r8.f12404a = r9;
        goto L27
    L20:
        if (r4 != '}') goto L26;
        int r10 = r3.f12408e + 1;
        r3.f12408e = r10;
        if (r10 >= r3.r) goto L25;
        r5 = r3.q.charAt(r10);
    L25:
        r3.f12407d = r5;
        r8 = this.f12388j;
        r9 = 13;
        goto L18
    L26:
        r3.s();
        goto L27
    L29:
        if (r1 != 2) goto L32;
        String r11 = r0.v();
        this.f12388j.t(16);
        return r11;
    L32:
        Object r12 = F();
        if (r12 != null) goto L37;
        return null;
    L37:
        return r12.toString();
    }

    protected void i0() {
        this.f12389k = this.f12389k.f12440b;
        l[] r0 = this.f12390l;
        int r1 = this.m;
        r0[r1 - 1] = null;
        this.m = r1 - 1;
    }

    protected l j0(l r3, Object r4, Object r5) {
        if (this.f12388j.t == false) goto L6;
        return null;
    L6:
        this.f12389k = new l(r3, r4, r5);
        int r6 = this.m;
        this.m = r6 + 1;
        l[] r7 = this.f12390l;
        if (r7 != null) goto L10;
        this.f12390l = new l[8];
    L12:
        l[] r8 = this.f12390l;
        l r2 = this.f12389k;
        r8[r6] = r2;
        return r2;
    L10:
        if (r6 < r7.length) goto L12;
        l[] r9 = new l[(r7.length * 3) / 2];
        System.arraycopy(r7, 0, r9, 0, r7.length);
        this.f12390l = r9;
        goto L12
    }

    public void k0(l r2) {
        if (this.f12388j.t == false) goto L5;
        return;
    L5:
        this.f12389k = r2;
    }

    protected void l(Map r2, Object r3) {
        n r0 = new n(r2, r3);
        a r4 = C();
        r4.f12393c = r0;
        r4.f12394d = this.f12389k;
        this.o = 0;
    }

    public DateFormat s() {
        if (this.f12387i != null) goto L6;
        SimpleDateFormat r0 = new SimpleDateFormat(this.f12386h, this.f12388j.n);
        this.f12387i = r0;
        r0.setTimeZone(this.f12388j.m);
    L6:
        return this.f12387i;
    }

    public List<d.a.a.i.q.b> x() {
        if (this.q != null) goto L6;
        this.q = new ArrayList(2);
    L6:
        return this.q;
    }
}
