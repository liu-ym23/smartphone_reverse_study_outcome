package xe;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f23109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f23110b;

    public d(int r5, int r10) {
        this.f23109a = r5;
        this.f23110b = r10;
    }

    public final boolean equals(Object r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (this != r5) goto L9;
        return true;
    L9:
        if ((r5 instanceof d) == false) goto L15;
        d r10 = (d) r5;
        if (r10.f23109a != this.f23109a) goto L15;
        if (r10.f23110b != this.f23110b) goto L15;
        return true;
    L15:
        return false;
    }

    public final int hashCode() {
        int r5 = this.f23110b + 16;
        return this.f23109a << r5;
    }
}
