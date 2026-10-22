package l.b.a;

/* JADX INFO: loaded from: classes2.dex */
public class b1 extends t implements z {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final byte[] f21518f;

    public b1(String r2) {
        this(r2, false);
    }

    public b1(String r1, boolean r2) {
        if (r2 == true) goto L5;
    L9:
        this.f21518f = l.b.h.g.e(r1);
        return;
    L5:
        if (w(r1) == true) goto L9;
        throw new IllegalArgumentException("string contains illegal characters");
    }

    b1(byte[] r1) {
        this.f21518f = r1;
    }

    public static boolean w(String r5) {
        int r0 = r5.length() - 1;
    L3:
        if (r0 < 0) goto L34;
        char r2 = r5.charAt(r0);
        if (r2 > 127) goto L6;
        if ('a' > r2) goto L13;
        if (r2 > 'z') goto L13;
    L33:
        r0 = r0 - 1;
    L13:
        if ('A' > r2) goto L18;
        if (r2 <= 'Z') goto L33;
    L18:
        if ('0' > r2) goto L23;
        if (r2 <= '9') goto L33;
    L23:
        if (r2 == ' ') goto L33;
        if (r2 == ':') goto L33;
        if (r2 == '=') goto L33;
        if (r2 == '?') goto L33;
        switch(r2) {
            case 39: goto L33;
            case 40: goto L33;
            case 41: goto L33;
            default: goto L31;
        };
    L31:
        switch(r2) {
            case 43: goto L33;
            case 44: goto L33;
            case 45: goto L33;
            case 46: goto L33;
            case 47: goto L33;
            default: goto L32;
        };
    L32:
        return false;
    L6:
        return false;
    L34:
        return true;
    }

    @Override // l.b.a.z
    public String c() {
        return l.b.h.g.b(this.f21518f);
    }

    @Override // l.b.a.n
    public int hashCode() {
        return l.b.h.a.j(this.f21518f);
    }

    @Override // l.b.a.t
    boolean n(t r2) {
        if ((r2 instanceof b1) == true) goto L7;
        return false;
    L7:
        return l.b.h.a.a(this.f21518f, ((b1) r2).f21518f);
    }

    @Override // l.b.a.t
    void o(r r2, boolean r3) {
        r2.n(r3, 19, this.f21518f);
    }

    @Override // l.b.a.t
    int p() {
        return (c2.a(this.f21518f.length) + 1) + this.f21518f.length;
    }

    @Override // l.b.a.t
    boolean t() {
        return false;
    }

    public String toString() {
        return c();
    }
}
