package d.g.d.b.b;

import android.graphics.Paint;

/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f16809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f16810c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f16811d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f16812e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Paint f16813f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f16814g;

    public o(int r11, float r12, float r13, float r14, float r15) {
        this(r11, r12, r13, r14, r15, null, 0.0f, 96, null);
    }

    public o(int r2, float r3, float r4, float r5, float r6, Paint r7, float r8) {
        kotlin.n0.d.o.f(r7, "paint");
        this.f16808a = r2;
        this.f16809b = r3;
        this.f16810c = r4;
        this.f16811d = r5;
        this.f16812e = r6;
        this.f16813f = r7;
        this.f16814g = r8;
    }

    public /* synthetic */ o(int r11, float r12, float r13, float r14, float r15, Paint r16, float r17, int r18, kotlin.n0.d.g r19) {
        if ((r18 & 32) == 0) goto L5;
        Paint r8 = new Paint(1);
    L7:
        if ((r18 & 64) == 0) goto L9;
        float r9 = 0.0f;
    L10:
        this(r11, r12, r13, r14, r15, r8, r9);
        return;
    L9:
        r9 = r17;
        goto L10
    L5:
        r8 = r16;
        goto L7
    }

    public final int a() {
        return this.f16808a;
    }

    public final float b() {
        return this.f16814g;
    }

    public final float c() {
        return this.f16810c;
    }

    public final float d() {
        return this.f16811d;
    }

    public final Paint e() {
        return this.f16813f;
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof o) == false) goto L20;
        o r4 = (o) r3;
        if (this.f16808a == r4.f16808a) goto L8;
        return false;
    L8:
        if (Float.compare(this.f16809b, r4.f16809b) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.f16810c, r4.f16810c) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f16811d, r4.f16811d) == 0) goto L14;
        return false;
    L14:
        if (Float.compare(this.f16812e, r4.f16812e) == 0) goto L16;
        return false;
    L16:
        if (kotlin.n0.d.o.a(this.f16813f, r4.f16813f) == true) goto L18;
        return false;
    L18:
        if (Float.compare(this.f16814g, r4.f16814g) == 0) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final float f() {
        return this.f16809b;
    }

    public final float g() {
        return this.f16812e;
    }

    public final void h(int r1) {
        this.f16808a = r1;
    }

    public int hashCode() {
        int r0 = ((((((((Integer.hashCode(this.f16808a) * 31) + Float.hashCode(this.f16809b)) * 31) + Float.hashCode(this.f16810c)) * 31) + Float.hashCode(this.f16811d)) * 31) + Float.hashCode(this.f16812e)) * 31;
        Paint r1 = this.f16813f;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return ((r0 + r2) * 31) + Float.hashCode(this.f16814g);
    L5:
        r2 = 0;
        goto L7
    }

    public final void i(float r1) {
        this.f16810c = r1;
    }

    public final void j(float r1) {
        this.f16811d = r1;
    }

    public final void k(float r1) {
        this.f16809b = r1;
    }

    public final void l(float r1) {
        this.f16812e = r1;
    }

    public final boolean m() {
        if (this.f16810c == 0.0f) goto L5;
    L12:
        return true;
    L5:
        if (this.f16811d != 0.0f) goto L12;
        if (this.f16809b != 0.0f) goto L12;
        if (this.f16812e != 0.0f) goto L12;
        return false;
    }

    public String toString() {
        return "Shadow(color=" + this.f16808a + ", radius=" + this.f16809b + ", offsetX=" + this.f16810c + ", offsetY=" + this.f16811d + ", spread=" + this.f16812e + ", paint=" + this.f16813f + ", cornerRadius=" + this.f16814g + ")";
    }
}
