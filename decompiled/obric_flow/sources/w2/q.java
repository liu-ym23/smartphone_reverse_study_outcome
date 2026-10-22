package w2;

import ai.j0;

/* JADX INFO: loaded from: classes2.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f22702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f22703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f22704c;
    public final int d;

    public q(int r5, int r10, int r11, int r12) {
        this.f22702a = r5;
        this.f22703b = r10;
        this.f22704c = r11;
        this.d = r12;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof q) == true) goto L8;
        return false;
    L8:
        q r10 = (q) r5;
        int r11 = r10.f22702a;
        if (this.f22702a == r11) goto L12;
        return false;
    L12:
        if (this.f22703b == r10.f22703b) goto L15;
        return false;
    L15:
        if (this.f22704c == r10.f22704c) goto L18;
        return false;
    L18:
        if (Float.compare(0.0f, 0.0f) == 0) goto L21;
        return false;
    L21:
        if (this.d == r10.d) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r5 = Integer.hashCode(this.f22702a) * 31;
        int r10 = k5.d.a(this.f22703b, r5);
        int r11 = k5.d.a(this.f22704c, r10);
        int r12 = k5.d.a(3, (Float.hashCode(0.0f) + r11) * 31);
        return Integer.hashCode(this.d) + r12;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("WidgetConfig(borderMargin=");
        r5.append(this.f22702a);
        r5.append(", fgStrokeWidth=");
        r5.append(this.f22703b);
        r5.append(", fgStrokeColor=");
        r5.append(this.f22704c);
        r5.append(", cornerRadius=0.0, noOutlineBoxType=3, defaultHeight=");
        return j0.n(r5, this.d, ')');
    }
}
