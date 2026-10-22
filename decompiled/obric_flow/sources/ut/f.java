package ut;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f22464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f22465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TimeUnit f22466c;

    public f(Object r5, long r10, TimeUnit r11) {
        this.f22464a = r5;
        this.f22465b = r10;
        io.reactivex.internal.functions.e.d(r11, "unit is null");
        this.f22466c = r11;
    }

    public final boolean equals(Object r10) {
        if ((r10 instanceof f) == false) goto L12;
        f r11 = (f) r10;
        Object r5 = r11.f22464a;
        if (io.reactivex.internal.functions.e.b(this.f22464a, r5) == true) goto L7;
        return false;
    L7:
        if (this.f22465b == r11.f22465b) goto L9;
        return false;
    L9:
        if (io.reactivex.internal.functions.e.b(this.f22466c, r11.f22466c) == false) goto L15;
        return true;
    L15:
        return false;
    L12:
        return false;
    }

    public final int hashCode() {
        Object r5 = this.f22464a;
        if (r5 == null) goto L5;
        int r10 = r5.hashCode();
    L6:
        long r11 = this.f22465b;
        int r12 = this.f22466c.hashCode();
        return r12 + (((r10 * 31) + ((int) (r11 ^ (r11 >>> 31)))) * 31);
    L5:
        r10 = 0;
        goto L6
    }

    public final String toString() {
        return "Timed[time=" + this.f22465b + ", unit=" + this.f22466c + ", value=" + this.f22464a + "]";
    }
}
