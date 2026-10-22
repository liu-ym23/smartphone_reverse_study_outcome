package zm;

import com.lynx.tasm.behavior.shadow.MeasureMode;

/* JADX INFO: loaded from: classes2.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a0 f23464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MeasureMode f23465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MeasureMode f23466c;
    public final float d;
    public final float e;
    public final int f;
    public final boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f23467h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f23468i;

    public b0(CharSequence r5, q r10, MeasureMode r11, MeasureMode r12, float r13, float r14, int r15, boolean r16, boolean r17, boolean r18) {
        this.f23464a = new a0(r5, r10);
        this.d = r13;
        this.e = r14;
        this.f23465b = r11;
        this.f23466c = r12;
        this.f = r15;
        this.g = r16;
        this.f23467h = r17;
        this.f23468i = r18;
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof b0) == true) goto L5;
        return false;
    L5:
        b0 r10 = (b0) r5;
        a0 r11 = r10.f23464a;
        if (this.f23464a.equals(r11) == true) goto L8;
    L25:
        return false;
    L8:
        if (this.f23465b != r10.f23465b) goto L25;
        if (this.f23466c != r10.f23466c) goto L25;
        if (this.d != r10.d) goto L25;
        if (this.e != r10.e) goto L25;
        if (this.f != r10.f) goto L25;
        if (this.g != r10.g) goto L25;
        if (this.f23467h != r10.f23467h) goto L25;
        if (this.f23468i != r10.f23468i) goto L25;
        return true;
    }

    public final int hashCode() {
        int r5 = this.f23464a.hashCode() * 31;
        int r10 = (this.f23465b.hashCode() + r5) * 31;
        int r11 = (this.f23466c.hashCode() + r10) * 31;
        int r12 = (Float.floatToIntBits(this.d) + r11) * 31;
        return ((((((((Float.floatToIntBits(this.e) + r12) * 31) + this.f) * 31) + (this.g ? 1 : 0)) * 31) + (this.f23467h ? 1 : 0)) * 31) + (this.f23468i ? 1 : 0);
    }

    public final String toString() {
        return this.f23464a.f23459a + " " + this.d + " " + this.e;
    }
}
