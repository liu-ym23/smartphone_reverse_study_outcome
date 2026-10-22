package d.c.f.f;

import androidx.annotation.ColorInt;
import d.c.c.d.i;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f15700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f15701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float[] f15702c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f15703d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f15704e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f15705f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f15706g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f15707h;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f15708f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f15709g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final /* synthetic */ a[] f15710h = null;

        static {
            a r0 = new a("OVERLAY_COLOR", 0);
            f15708f = r0;
            a r1 = new a("BITMAP_ONLY", 1);
            f15709g = r1;
            f15710h = new a[]{r0, r1};
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r1) {
            return (a) Enum.valueOf(a.class, r1);
        }

        public static a[] values() {
            return (a[]) f15710h.clone();
        }
    }

    public d() {
        this.f15700a = a.f15709g;
        this.f15701b = false;
        this.f15702c = null;
        this.f15703d = 0;
        this.f15704e = 0.0f;
        this.f15705f = 0;
        this.f15706g = 0.0f;
        this.f15707h = false;
    }

    private float[] d() {
        if (this.f15702c != null) goto L6;
        this.f15702c = new float[8];
    L6:
        return this.f15702c;
    }

    public int a() {
        return this.f15705f;
    }

    public float b() {
        return this.f15704e;
    }

    public float[] c() {
        return this.f15702c;
    }

    public int e() {
        return this.f15703d;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 != null) goto L8;
    L33:
        return false;
    L8:
        if (d.class != r4.getClass()) goto L33;
        d r5 = (d) r4;
        if (this.f15701b == r5.f15701b) goto L14;
        return false;
    L14:
        if (this.f15703d == r5.f15703d) goto L17;
        return false;
    L17:
        if (Float.compare(r5.f15704e, this.f15704e) == 0) goto L20;
        return false;
    L20:
        if (this.f15705f == r5.f15705f) goto L23;
        return false;
    L23:
        if (Float.compare(r5.f15706g, this.f15706g) == 0) goto L26;
        return false;
    L26:
        if (this.f15700a == r5.f15700a) goto L29;
        return false;
    L29:
        if (this.f15707h == r5.f15707h) goto L32;
        return false;
    L32:
        return Arrays.equals(this.f15702c, r5.f15702c);
    }

    public float f() {
        return this.f15706g;
    }

    public boolean g() {
        return this.f15701b;
    }

    public a h() {
        return this.f15700a;
    }

    public int hashCode() {
        a r0 = this.f15700a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((r2 * 31) + (this.f15701b ? 1 : 0)) * 31;
        float[] r4 = this.f15702c;
        if (r4 == null) goto L9;
        int r5 = Arrays.hashCode(r4);
    L10:
        int r6 = (((r3 + r5) * 31) + this.f15703d) * 31;
        float r7 = this.f15704e;
        if (r7 == 0.0f) goto L13;
        int r8 = Float.floatToIntBits(r7);
    L14:
        int r9 = (((r6 + r8) * 31) + this.f15705f) * 31;
        float r10 = this.f15706g;
        if (r10 == 0.0f) goto L18;
        r1 = Float.floatToIntBits(r10);
    L18:
        return ((r9 + r1) * 31) + (this.f15707h ? 1 : 0);
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public boolean i() {
        return this.f15707h;
    }

    public d j(@ColorInt int r1) {
        this.f15705f = r1;
        return this;
    }

    public d k(float r3) {
        if (r3 < 0.0f) goto L5;
        boolean r0 = true;
    L6:
        i.c(r0, "the border width cannot be < 0");
        this.f15704e = r3;
        return this;
    L5:
        r0 = false;
        goto L6
    }

    public d l(float r2) {
        Arrays.fill(d(), r2);
        return this;
    }

    public d m(@ColorInt int r1) {
        this.f15703d = r1;
        this.f15700a = a.f15708f;
        return this;
    }

    public d n(float r3) {
        if (r3 < 0.0f) goto L5;
        boolean r0 = true;
    L6:
        i.c(r0, "the padding cannot be < 0");
        this.f15706g = r3;
        return this;
    L5:
        r0 = false;
        goto L6
    }

    public d o(boolean r1) {
        this.f15701b = r1;
        return this;
    }

    public d p(a r1) {
        this.f15700a = r1;
        return this;
    }
}
