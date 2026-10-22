package t1;

import ai.j0;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f22083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f22084b;

    public j(int r5, int r10) {
        this.f22083a = r5;
        this.f22084b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j) == true) goto L8;
        return false;
    L8:
        j r10 = (j) r5;
        int r11 = r10.f22083a;
        if (this.f22083a == r11) goto L12;
        return false;
    L12:
        if (this.f22084b == r10.f22084b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = Integer.hashCode(this.f22083a) * 31;
        return Integer.hashCode(this.f22084b) + r5;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("Reminder(minutes=");
        r5.append(this.f22083a);
        r5.append(", method=");
        return j0.n(r5, this.f22084b, ')');
    }
}
