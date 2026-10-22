package kotlin.s0.w.d.l0.g;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.n0.c.l;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final f f20263e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Pattern f20264f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final l<String, f> f20265g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f20266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient c f20267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private transient d f20268c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private transient f f20269d;

    static class a implements l<String, f> {
        a() {
        }

        public f a(String r1) {
            return f.j(r1);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f invoke(String r1) {
            return a(r1);
        }
    }

    static {
        f20263e = f.n("<root>");
        f20264f = Pattern.compile("\\.");
        f20265g = new a();
    }

    public d(String r1) {
        if (r1 == null) goto L5;
        this.f20266a = r1;
        return;
    L5:
        a(2);
        throw null;
    }

    d(String r2, c r3) {
        if (r2 == null) goto L9;
        if (r3 == null) goto L7;
        this.f20266a = r2;
        this.f20267b = r3;
        return;
    L7:
        a(1);
        throw null;
    L9:
        a(0);
        throw null;
    }

    private d(String r1, d r2, f r3) {
        if (r1 == null) goto L5;
        this.f20266a = r1;
        this.f20268c = r2;
        this.f20269d = r3;
        return;
    L5:
        a(3);
        throw null;
    }

    private static /* synthetic */ void a(int r8) {
        switch(r8) {
            case 4: goto L4;
            case 5: goto L4;
            case 6: goto L4;
            case 7: goto L4;
            case 8: goto L4;
            case 9: goto L3;
            case 10: goto L4;
            case 11: goto L4;
            case 12: goto L4;
            case 13: goto L4;
            case 14: goto L4;
            case 15: goto L3;
            case 16: goto L3;
            case 17: goto L4;
            default: goto L3;
        };
    L3:
        String r0 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L6:
        switch(r8) {
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L8;
            case 7: goto L8;
            case 8: goto L8;
            case 9: goto L7;
            case 10: goto L8;
            case 11: goto L8;
            case 12: goto L8;
            case 13: goto L8;
            case 14: goto L8;
            case 15: goto L7;
            case 16: goto L7;
            case 17: goto L8;
            default: goto L7;
        };
    L7:
        int r2 = 3;
    L9:
        Object[] r3 = new Object[r2];
        if (r8 == 1) goto L17;
        switch(r8) {
            case 4: goto L16;
            case 5: goto L16;
            case 6: goto L16;
            case 7: goto L16;
            case 8: goto L16;
            case 9: goto L15;
            case 10: goto L16;
            case 11: goto L16;
            case 12: goto L16;
            case 13: goto L16;
            case 14: goto L16;
            case 15: goto L14;
            case 16: goto L13;
            case 17: goto L16;
            default: goto L12;
        };
    L12:
        r3[0] = "fqName";
    L18:
        switch(r8) {
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L25;
            case 7: goto L24;
            case 8: goto L24;
            case 9: goto L19;
            case 10: goto L23;
            case 11: goto L23;
            case 12: goto L22;
            case 13: goto L22;
            case 14: goto L21;
            case 15: goto L19;
            case 16: goto L19;
            case 17: goto L20;
            default: goto L19;
        };
    L19:
        r3[1] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
    L27:
        switch(r8) {
            case 4: goto L32;
            case 5: goto L32;
            case 6: goto L32;
            case 7: goto L32;
            case 8: goto L32;
            case 9: goto L31;
            case 10: goto L32;
            case 11: goto L32;
            case 12: goto L32;
            case 13: goto L32;
            case 14: goto L32;
            case 15: goto L30;
            case 16: goto L29;
            case 17: goto L32;
            default: goto L28;
        };
    L28:
        r3[2] = "<init>";
        goto L32
    L29:
        r3[2] = "topLevel";
        goto L32
    L30:
        r3[2] = "startsWith";
        goto L32
    L31:
        r3[2] = "child";
    L32:
        String r1 = String.format(r0, r3);
        switch(r8) {
            case 4: goto L36;
            case 5: goto L36;
            case 6: goto L36;
            case 7: goto L36;
            case 8: goto L36;
            case 9: goto L37;
            case 10: goto L36;
            case 11: goto L36;
            case 12: goto L36;
            case 13: goto L36;
            case 14: goto L36;
            case 15: goto L37;
            case 16: goto L37;
            case 17: goto L36;
            default: goto L37;
        };
    L37:
        throw new IllegalArgumentException(r1);
    L36:
        throw new IllegalStateException(r1);
    L20:
        r3[1] = "toString";
        goto L27
    L21:
        r3[1] = "pathSegments";
        goto L27
    L22:
        r3[1] = "shortNameOrSpecial";
        goto L27
    L23:
        r3[1] = "shortName";
        goto L27
    L24:
        r3[1] = "parent";
        goto L27
    L25:
        r3[1] = "toSafe";
        goto L27
    L26:
        r3[1] = "asString";
        goto L27
    L13:
        r3[0] = "shortName";
        goto L18
    L14:
        r3[0] = "segment";
        goto L18
    L15:
        r3[0] = "name";
        goto L18
    L16:
        r3[0] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
        goto L18
    L17:
        r3[0] = "safe";
        goto L18
    L8:
        r2 = 2;
        goto L9
    L4:
        r0 = "@NotNull method %s.%s must not return null";
        goto L6
    }

    private void d() {
        int r0 = this.f20266a.lastIndexOf(46);
        if (r0 < 0) goto L5;
        this.f20269d = f.j(this.f20266a.substring(r0 + 1));
        this.f20268c = new d(this.f20266a.substring(0, r0));
        return;
    L5:
        this.f20269d = f.j(this.f20266a);
        this.f20268c = c.f20260c.j();
    }

    public static d m(f r3) {
        if (r3 != null) goto L4;
        a(16);
        throw null;
    L4:
        return new d(r3.b(), c.f20260c.j(), r3);
    }

    public String b() {
        String r0 = this.f20266a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        a(4);
        throw null;
    }

    public d c(f r3) {
        if (r3 != null) goto L4;
        a(9);
        throw null;
    L4:
        if (e() == false) goto L6;
        String r0 = r3.b();
    L8:
        return new d(r0, this, r3);
    L6:
        r0 = this.f20266a + "." + r3.b();
        goto L8
    }

    public boolean e() {
        return this.f20266a.isEmpty();
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof d) == true) goto L9;
        return false;
    L9:
        if (this.f20266a.equals(((d) r4).f20266a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public boolean f() {
        if (this.f20267b == null) goto L5;
    L8:
        return true;
    L5:
        if (b().indexOf(60) < 0) goto L8;
        return false;
    }

    public d g() {
        d r0 = this.f20268c;
        if (r0 == null) goto L9;
        if (r0 == null) goto L6;
        return r0;
    L6:
        a(7);
        throw null;
    L9:
        if (e() == true) goto L16;
        d();
        d r2 = this.f20268c;
        if (r2 == null) goto L13;
        return r2;
    L13:
        a(8);
        throw null;
    L16:
        throw new IllegalStateException("root");
    }

    public List<f> h() {
        if (e() == false) goto L5;
        List<f> r1 = Collections.emptyList();
    L6:
        if (r1 == null) goto L8;
        return r1;
    L8:
        a(14);
        throw null;
    L5:
        r1 = kotlin.i0.i.Q(f20264f.split(this.f20266a), f20265g);
        goto L6
    }

    public int hashCode() {
        return this.f20266a.hashCode();
    }

    public f i() {
        f r0 = this.f20269d;
        if (r0 == null) goto L9;
        if (r0 == null) goto L6;
        return r0;
    L6:
        a(10);
        throw null;
    L9:
        if (e() == true) goto L16;
        d();
        f r2 = this.f20269d;
        if (r2 == null) goto L13;
        return r2;
    L13:
        a(11);
        throw null;
    L16:
        throw new IllegalStateException("root");
    }

    public f j() {
        if (e() == false) goto L9;
        f r2 = f20263e;
        if (r2 == null) goto L7;
        return r2;
    L7:
        a(12);
        throw null;
    L9:
        f r3 = i();
        if (r3 == null) goto L12;
        return r3;
    L12:
        a(13);
        throw null;
    }

    public boolean k(f r5) {
        if (r5 != null) goto L4;
        a(15);
        throw null;
    L4:
        if (e() == false) goto L6;
        return false;
    L6:
        int r0 = this.f20266a.indexOf(46);
        String r2 = this.f20266a;
        String r6 = r5.b();
        if (r0 != (-1)) goto L10;
        r0 = this.f20266a.length();
    L10:
        return r2.regionMatches(0, r6, 0, r0);
    }

    public c l() {
        c r0 = this.f20267b;
        if (r0 == null) goto L8;
        if (r0 == null) goto L6;
        return r0;
    L6:
        a(5);
        throw null;
    L8:
        c r1 = new c(this);
        this.f20267b = r1;
        if (r1 == null) goto L11;
        return r1;
    L11:
        a(6);
        throw null;
    }

    public String toString() {
        if (e() == false) goto L5;
        String r1 = f20263e.b();
    L6:
        if (r1 == null) goto L8;
        return r1;
    L8:
        a(17);
        throw null;
    L5:
        r1 = this.f20266a;
        goto L6
    }
}
