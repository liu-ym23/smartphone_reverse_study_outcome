package d.c.i.f;

import android.graphics.Bitmap;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    private static final c o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f15992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f15993c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f15994d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f15995e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f15996f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f15997g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Bitmap.Config f15998h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final d.c.i.i.c f15999i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final d.c.i.t.a f16000j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Object f16001k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f16002l;
    public final boolean m;
    public final Rect n;

    static {
        o = b().a();
    }

    public c(d r2) {
        this.f15991a = r2.i();
        this.f15992b = r2.g();
        this.f15993c = r2.j();
        this.f15994d = r2.m();
        this.f15995e = r2.e();
        this.f15996f = r2.h();
        this.f15998h = r2.b();
        this.f15999i = r2.d();
        this.f15997g = r2.l();
        this.f16000j = r2.c();
        this.f16001k = r2.f();
        this.f16002l = r2.n();
        this.m = r2.o();
        this.n = r2.k();
    }

    public static c a() {
        return o;
    }

    public static d b() {
        return new d();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L47:
        return false;
    L8:
        if (c.class != r5.getClass()) goto L47;
        c r6 = (c) r5;
        if (this.f15992b == r6.f15992b) goto L14;
        return false;
    L14:
        if (this.f15994d == r6.f15994d) goto L17;
        return false;
    L17:
        if (this.f15995e == r6.f15995e) goto L20;
        return false;
    L20:
        if (this.f15996f == r6.f15996f) goto L23;
        return false;
    L23:
        if (this.f15997g == r6.f15997g) goto L26;
        return false;
    L26:
        if (this.f15998h == r6.f15998h) goto L29;
        return false;
    L29:
        if (this.f15999i == r6.f15999i) goto L32;
        return false;
    L32:
        if (this.f16000j == r6.f16000j) goto L35;
        return false;
    L35:
        if (this.f16001k == r6.f16001k) goto L38;
        return false;
    L38:
        if (this.f16002l == r6.f16002l) goto L41;
        return false;
    L41:
        if (this.m == r6.m) goto L44;
        return false;
    L44:
        if (this.n == r6.n) goto L46;
        return false;
    L46:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((((((this.f15991a * 31) + (this.f15992b ? 1 : 0)) * 31) + (this.f15994d ? 1 : 0)) * 31) + (this.f15995e ? 1 : 0)) * 31) + (this.f15996f ? 1 : 0)) * 31) + (this.f15997g ? 1 : 0)) * 31) + this.f15998h.ordinal()) * 31;
        d.c.i.i.c r1 = this.f15999i;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        d.c.i.t.a r5 = this.f16000j;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        Object r8 = this.f16001k;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (((((r7 + r9) * 31) + (this.f16002l ? 1 : 0)) * 31) + (this.m ? 1 : 0)) * 31;
        Rect r11 = this.n;
        if (r11 == null) goto L18;
        r2 = r11.hashCode();
    L18:
        return r10 + r2;
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%b-%s-%s-%s-%s-%b-%b-%s", new Object[]{Integer.valueOf(this.f15991a), Boolean.valueOf(this.f15992b), Boolean.valueOf(this.f15994d), Boolean.valueOf(this.f15995e), Boolean.valueOf(this.f15996f), Boolean.valueOf(this.f15997g), this.f15998h.name(), this.f15999i, this.f16000j, this.f16001k, Boolean.valueOf(this.f16002l), Boolean.valueOf(this.m), this.n});
    }
}
