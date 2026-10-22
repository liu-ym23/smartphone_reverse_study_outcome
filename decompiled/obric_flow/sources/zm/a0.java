package zm;

/* JADX INFO: loaded from: classes2.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CharSequence f23459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q f23460b;

    public a0(CharSequence r5, q r10) {
        this.f23459a = r5;
        this.f23460b = r10;
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof a0) == true) goto L5;
        return false;
    L5:
        a0 r10 = (a0) r5;
        CharSequence r11 = this.f23459a;
        if (r11 == null) goto L8;
    L10:
        if (r11 != null) goto L12;
    L14:
        q r12 = this.f23460b;
        if (r12 == null) goto L17;
    L19:
        if (r12 != null) goto L21;
        return true;
    L21:
        if (r12.equals(r10.f23460b) == true) goto L26;
        return false;
    L26:
        return true;
    L17:
        if (r10.f23460b == null) goto L19;
        return false;
    L12:
        if (r11.equals(r10.f23459a) == true) goto L14;
        return false;
    L8:
        if (r10.f23459a == null) goto L10;
        return false;
    }

    public final int hashCode() {
        CharSequence r5 = this.f23459a;
        int r10 = 0;
        if (r5 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        q r13 = this.f23460b;
        if (r13 == null) goto L11;
        r10 = r13.hashCode();
    L11:
        return r12 + r10;
    L5:
        r11 = r5.hashCode();
        goto L6
    }
}
