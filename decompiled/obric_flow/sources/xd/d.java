package xd;

import ai.j0;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f23105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f23106b;

    public d(int r5, int r10) {
        this.f23105a = r5;
        this.f23106b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r10 = (d) r5;
        int r11 = r10.f23105a;
        if (this.f23105a == r11) goto L12;
        return false;
    L12:
        if (this.f23106b == r10.f23106b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = Integer.hashCode(this.f23105a) * 31;
        return Integer.hashCode(this.f23106b) + r5;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("ScreenInfo(width=");
        r5.append(this.f23105a);
        r5.append(", height=");
        return j0.n(r5, this.f23106b, ')');
    }
}
