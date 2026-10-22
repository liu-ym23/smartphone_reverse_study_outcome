package kotlin.s0.w.d.l0.g;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f20260c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f20261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient c f20262b;

    static {
        f20260c = new c("");
    }

    public c(String r2) {
        if (r2 == null) goto L5;
        this.f20261a = new d(r2, this);
        return;
    L5:
        a(1);
        throw null;
    }

    public c(d r1) {
        if (r1 == null) goto L5;
        this.f20261a = r1;
        return;
    L5:
        a(2);
        throw null;
    }

    private c(d r1, c r2) {
        if (r1 == null) goto L5;
        this.f20261a = r1;
        this.f20262b = r2;
        return;
    L5:
        a(3);
        throw null;
    }

    private static /* synthetic */ void a(int r7) {
        switch(r7) {
            case 4: goto L4;
            case 5: goto L4;
            case 6: goto L4;
            case 7: goto L4;
            case 8: goto L3;
            case 9: goto L4;
            case 10: goto L4;
            case 11: goto L4;
            default: goto L3;
        };
    L3:
        String r0 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L6:
        switch(r7) {
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L8;
            case 7: goto L8;
            case 8: goto L7;
            case 9: goto L8;
            case 10: goto L8;
            case 11: goto L8;
            default: goto L7;
        };
    L7:
        int r2 = 3;
    L9:
        Object[] r3 = new Object[r2];
        switch(r7) {
            case 1: goto L16;
            case 2: goto L16;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L15;
            case 6: goto L15;
            case 7: goto L15;
            case 8: goto L14;
            case 9: goto L15;
            case 10: goto L15;
            case 11: goto L15;
            case 12: goto L13;
            case 13: goto L12;
            default: goto L11;
        };
    L11:
        r3[0] = "names";
    L18:
        switch(r7) {
            case 4: goto L25;
            case 5: goto L24;
            case 6: goto L23;
            case 7: goto L23;
            case 8: goto L19;
            case 9: goto L22;
            case 10: goto L21;
            case 11: goto L20;
            default: goto L19;
        };
    L19:
        r3[1] = "kotlin/reflect/jvm/internal/impl/name/FqName";
    L26:
        switch(r7) {
            case 1: goto L31;
            case 2: goto L31;
            case 3: goto L31;
            case 4: goto L32;
            case 5: goto L32;
            case 6: goto L32;
            case 7: goto L32;
            case 8: goto L30;
            case 9: goto L32;
            case 10: goto L32;
            case 11: goto L32;
            case 12: goto L29;
            case 13: goto L28;
            default: goto L27;
        };
    L27:
        r3[2] = "fromSegments";
        goto L32
    L28:
        r3[2] = "topLevel";
        goto L32
    L29:
        r3[2] = "startsWith";
        goto L32
    L30:
        r3[2] = "child";
        goto L32
    L31:
        r3[2] = "<init>";
    L32:
        String r1 = String.format(r0, r3);
        switch(r7) {
            case 4: goto L36;
            case 5: goto L36;
            case 6: goto L36;
            case 7: goto L36;
            case 8: goto L37;
            case 9: goto L36;
            case 10: goto L36;
            case 11: goto L36;
            default: goto L37;
        };
    L37:
        throw new IllegalArgumentException(r1);
    L36:
        throw new IllegalStateException(r1);
    L20:
        r3[1] = "pathSegments";
        goto L26
    L21:
        r3[1] = "shortNameOrSpecial";
        goto L26
    L22:
        r3[1] = "shortName";
        goto L26
    L23:
        r3[1] = "parent";
        goto L26
    L24:
        r3[1] = "toUnsafe";
        goto L26
    L25:
        r3[1] = "asString";
        goto L26
    L12:
        r3[0] = "shortName";
        goto L18
    L13:
        r3[0] = "segment";
        goto L18
    L14:
        r3[0] = "name";
        goto L18
    L15:
        r3[0] = "kotlin/reflect/jvm/internal/impl/name/FqName";
        goto L18
    L16:
        r3[0] = "fqName";
        goto L18
    L8:
        r2 = 2;
        goto L9
    L4:
        r0 = "@NotNull method %s.%s must not return null";
        goto L6
    }

    public static c k(f r1) {
        if (r1 != null) goto L4;
        a(13);
        throw null;
    L4:
        return new c(d.m(r1));
    }

    public String b() {
        String r0 = this.f20261a.b();
        if (r0 == null) goto L5;
        return r0;
    L5:
        a(4);
        throw null;
    }

    public c c(f r3) {
        if (r3 != null) goto L4;
        a(8);
        throw null;
    L4:
        return new c(this.f20261a.c(r3), this);
    }

    public boolean d() {
        return this.f20261a.e();
    }

    public c e() {
        c r0 = this.f20262b;
        if (r0 == null) goto L9;
        if (r0 == null) goto L6;
        return r0;
    L6:
        a(6);
        throw null;
    L9:
        if (d() == true) goto L16;
        c r1 = new c(this.f20261a.g());
        this.f20262b = r1;
        if (r1 == null) goto L13;
        return r1;
    L13:
        a(7);
        throw null;
    L16:
        throw new IllegalStateException("root");
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof c) == true) goto L9;
        return false;
    L9:
        if (this.f20261a.equals(((c) r4).f20261a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public List<f> f() {
        List<f> r0 = this.f20261a.h();
        if (r0 == null) goto L5;
        return r0;
    L5:
        a(11);
        throw null;
    }

    public f g() {
        f r0 = this.f20261a.i();
        if (r0 == null) goto L5;
        return r0;
    L5:
        a(9);
        throw null;
    }

    public f h() {
        f r0 = this.f20261a.j();
        if (r0 == null) goto L5;
        return r0;
    L5:
        a(10);
        throw null;
    }

    public int hashCode() {
        return this.f20261a.hashCode();
    }

    public boolean i(f r1) {
        if (r1 != null) goto L4;
        a(12);
        throw null;
    L4:
        return this.f20261a.k(r1);
    }

    public d j() {
        d r0 = this.f20261a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        a(5);
        throw null;
    }

    public String toString() {
        return this.f20261a.toString();
    }
}
