package l.b.g.d.a;

import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f22271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f22272b;

    public b(byte[] r4) {
        this.f22271a = 0;
        if (r4.length != 4) goto L11;
        int r5 = f.d(r4);
        this.f22272b = r5;
        if (j.c(r5) == false) goto L9;
        this.f22271a = j.a(this.f22272b);
        return;
    L9:
        throw new IllegalArgumentException("byte array is not an encoded finite field");
    L11:
        throw new IllegalArgumentException("byte array is not an encoded finite field");
    }

    private static String i(int r4) {
        if (r4 != 0) goto L5;
        return BDLocationException.ERROR_TIMEOUT;
    L5:
        if (((byte) (r4 & 1)) != 1) goto L7;
        String r0 = LocationInfoConst.ALLOW_USE_LOCATION;
    L8:
        int r5 = r4 >>> 1;
        int r2 = 1;
    L9:
        if (r5 == 0) goto L15;
        if (((byte) (r5 & 1)) != 1) goto L13;
        r0 = r0 + "+x^" + r2;
    L13:
        r5 = r5 >>> 1;
        r2 = r2 + 1;
        goto L9
    L15:
        return r0;
    L7:
        r0 = "";
        goto L8
    }

    public int a(int r1, int r2) {
        return r1 ^ r2;
    }

    public String b(int r5) {
        String r0 = "";
        int r1 = 0;
    L4:
        if (r1 >= this.f22271a) goto L10;
        if ((((byte) r5) & 1) != 0) goto L8;
        StringBuilder r2 = new StringBuilder();
        String r3 = BDLocationException.ERROR_TIMEOUT;
    L9:
        r2.append(r3);
        r2.append(r0);
        r0 = r2.toString();
        r5 = r5 >>> 1;
        r1 = r1 + 1;
        goto L4
    L8:
        r2 = new StringBuilder();
        r3 = LocationInfoConst.ALLOW_USE_LOCATION;
        goto L9
    L10:
        return r0;
    }

    public int c(int r4, int r5) {
        if (r5 != 0) goto L5;
        return 1;
    L5:
        if (r4 != 0) goto L8;
        return 0;
    L8:
        if (r4 != 1) goto L10;
        return 1;
    L10:
        if (r5 >= 0) goto L12;
        r4 = f(r4);
        r5 = -r5;
    L12:
        int r1 = 1;
    L13:
        if (r5 == 0) goto L18;
        if ((r5 & 1) != 1) goto L17;
        r1 = h(r1, r4);
    L17:
        r4 = h(r4, r4);
        r5 = r5 >>> 1;
        goto L13
    L18:
        return r1;
    }

    public int d() {
        return this.f22271a;
    }

    public byte[] e() {
        return f.c(this.f22272b);
    }

    public boolean equals(Object r4) {
        if (r4 != null) goto L5;
    L13:
        return false;
    L5:
        if ((r4 instanceof b) == false) goto L13;
        b r5 = (b) r4;
        if (this.f22271a != r5.f22271a) goto L13;
        if (this.f22272b != r5.f22272b) goto L13;
        return true;
    }

    public int f(int r3) {
        return c(r3, (1 << this.f22271a) - 2);
    }

    public boolean g(int r4) {
        int r3 = this.f22271a;
        if (r3 != 31) goto L7;
        if (r4 >= 0) goto L6;
        return false;
    L6:
        return true;
    L7:
        if (r4 >= 0) goto L9;
        return false;
    L9:
        if (r4 < (1 << r3)) goto L11;
        return false;
    L11:
        return true;
    }

    public int h(int r1, int r2) {
        return j.d(r1, r2, this.f22272b);
    }

    public int hashCode() {
        return this.f22272b;
    }

    public String toString() {
        return "Finite Field GF(2^" + this.f22271a + ") = GF(2)[X]/<" + i(this.f22272b) + "> ";
    }
}
