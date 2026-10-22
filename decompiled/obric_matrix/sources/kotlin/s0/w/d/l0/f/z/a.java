package kotlin.s0.w.d.l0.f.z;

import androidx.core.os.EnvironmentCompat;
import java.util.ArrayList;
import java.util.List;
import kotlin.i0.r;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f20224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f20225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f20226c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f20227d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<Integer> f20228e;

    static {
    }

    public a(int... r4) {
        o.f(r4, "numbers");
        this.f20224a = r4;
        Integer r0 = kotlin.i0.i.A(r4, 0);
        int r1 = -1;
        if (r0 == null) goto L5;
        int r2 = r0.intValue();
    L6:
        this.f20225b = r2;
        Integer r3 = kotlin.i0.i.A(r4, 1);
        if (r3 == null) goto L9;
        int r5 = r3.intValue();
    L10:
        this.f20226c = r5;
        Integer r6 = kotlin.i0.i.A(r4, 2);
        if (r6 == null) goto L13;
        r1 = r6.intValue();
    L13:
        this.f20227d = r1;
        if (r4.length > 3) goto L16;
        List<Integer> r7 = r.g();
    L21:
        this.f20228e = r7;
        return;
    L16:
        if (r4.length > 1024) goto L19;
        r7 = r.z0(kotlin.i0.i.c(r4).subList(3, r4.length));
        goto L21
    L19:
        throw new IllegalArgumentException("BinaryVersion with length more than 1024 are not supported. Provided length " + r4.length + '.');
    L9:
        r5 = -1;
        goto L10
    L5:
        r2 = -1;
        goto L6
    }

    public final int a() {
        return this.f20225b;
    }

    public final int b() {
        return this.f20226c;
    }

    public final boolean c(int r4, int r5, int r6) {
        int r0 = this.f20225b;
        if (r0 <= r4) goto L6;
        return true;
    L6:
        if (r0 >= r4) goto L8;
        return false;
    L8:
        int r7 = this.f20226c;
        if (r7 <= r5) goto L11;
        return true;
    L11:
        if (r7 >= r5) goto L14;
        return false;
    L14:
        if (this.f20227d < r6) goto L17;
        return true;
    L17:
        return false;
    }

    public final boolean d(a r3) {
        o.f(r3, "version");
        return c(r3.f20225b, r3.f20226c, r3.f20227d);
    }

    public final boolean e(int r4, int r5, int r6) {
        int r0 = this.f20225b;
        if (r0 >= r4) goto L6;
        return true;
    L6:
        if (r0 <= r4) goto L8;
        return false;
    L8:
        int r7 = this.f20226c;
        if (r7 >= r5) goto L11;
        return true;
    L11:
        if (r7 <= r5) goto L14;
        return false;
    L14:
        if (this.f20227d > r6) goto L17;
        return true;
    L17:
        return false;
    }

    public boolean equals(Object r3) {
        if (r3 != null) goto L4;
    L14:
        return false;
    L4:
        if (o.a(getClass(), r3.getClass()) == false) goto L14;
        a r4 = (a) r3;
        if (this.f20225b != r4.f20225b) goto L14;
        if (this.f20226c != r4.f20226c) goto L14;
        if (this.f20227d != r4.f20227d) goto L14;
        if (o.a(this.f20228e, r4.f20228e) == false) goto L14;
        return true;
    }

    protected final boolean f(a r5) {
        o.f(r5, "ourVersion");
        int r0 = this.f20225b;
        if (r0 != 0) goto L10;
        if (r5.f20225b != 0) goto L15;
        if (this.f20226c != r5.f20226c) goto L15;
        return true;
    L15:
        return false;
    L10:
        if (r0 != r5.f20225b) goto L15;
        if (this.f20226c > r5.f20226c) goto L15;
        return true;
    }

    public final int[] g() {
        return this.f20224a;
    }

    public int hashCode() {
        int r0 = this.f20225b;
        int r1 = r0 + ((r0 * 31) + this.f20226c);
        int r2 = r1 + ((r1 * 31) + this.f20227d);
        return r2 + ((r2 * 31) + this.f20228e.hashCode());
    }

    public String toString() {
        int[] r9 = g();
        ArrayList r0 = new ArrayList();
        int r1 = r9.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L12;
        int r4 = r9[r3];
        if (r4 == (-1)) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == false) goto L12;
        r0.add(Integer.valueOf(r4));
        r3 = r3 + 1;
        goto L3
    L7:
        r5 = false;
    L12:
        if (r0.isEmpty() == false) goto L15;
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L15:
        return r.Z(r0, ".", null, null, 0, null, null, 62, null);
    }
}
