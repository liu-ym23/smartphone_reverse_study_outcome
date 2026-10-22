package zm;

import android.text.Layout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextUtils;
import androidx.core.view.ViewCompat;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class q {
    public boolean A;
    public boolean B;
    public String C;
    public String D;
    public boolean E;
    public int F;
    public com.lynx.tasm.behavior.ui.r G;
    public int H;
    public int I;
    public int J;
    public int K;
    public float L;
    public an.a M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f23514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f23515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f23516c;
    public int d;
    public int e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f23517h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f23518i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f23519j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f23520k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f23521l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f23522m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f23523n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public u f23524o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f23525p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f23526q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f23527r;
    public boolean s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f23528t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f23529u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f23530v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f23531w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f23532x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f23533y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float[] f23534z;

    public q() {
        this.f23514a = -1;
        this.f23515b = -1;
        this.f23516c = null;
        this.d = 3;
        this.e = 0;
        this.f = -1;
        this.g = 0;
        this.f23517h = 0;
        this.f23518i = 0;
        this.f23519j = 0;
        this.f23520k = 1.0E21f;
        this.f23521l = 1.0E21f;
        this.f23522m = 0.0f;
        this.f23523n = 0.0f;
        this.f23524o = null;
        this.f23525p = 0.0f;
        this.f23526q = false;
        this.f23527r = false;
        this.s = false;
        this.f23528t = false;
        this.f23529u = null;
        this.f23530v = false;
        this.f23531w = 0.0f;
        this.f23532x = 0.0f;
        this.f23533y = 1.0f;
        this.A = false;
        this.B = false;
        this.C = null;
        this.D = null;
        this.E = false;
        this.F = 0;
        this.I = 4;
        this.J = 0;
        this.K = 0;
        this.L = 0.0f;
        this.M = null;
    }

    public final Layout.Alignment a(boolean r5) {
        int r10 = this.d;
        if (r10 != 0) goto L17;
        int r11 = this.e;
        if (r11 != 0) goto L11;
        if (r5 == false) goto L10;
        return Layout.Alignment.ALIGN_OPPOSITE;
    L10:
        return Layout.Alignment.ALIGN_NORMAL;
    L11:
        if (r11 != 3) goto L15;
        return Layout.Alignment.ALIGN_NORMAL;
    L15:
        return Layout.Alignment.ALIGN_OPPOSITE;
    L17:
        if (r10 != 2) goto L31;
        int r12 = this.e;
        if (r12 != 0) goto L25;
        if (r5 == false) goto L24;
        return Layout.Alignment.ALIGN_NORMAL;
    L24:
        return Layout.Alignment.ALIGN_OPPOSITE;
    L25:
        if (r12 != 3) goto L29;
        return Layout.Alignment.ALIGN_OPPOSITE;
    L29:
        return Layout.Alignment.ALIGN_NORMAL;
    L31:
        if (r10 != 1) goto L35;
        return Layout.Alignment.ALIGN_CENTER;
    L35:
        return Layout.Alignment.ALIGN_NORMAL;
    }

    public final q b() {
        q r5 = new q();
        r5.f23514a = this.f23514a;
        r5.f23515b = this.f23515b;
        r5.f23516c = this.f23516c;
        r5.d = this.d;
        r5.f = this.f;
        r5.g = this.g;
        r5.f23517h = this.f23517h;
        r5.f23518i = this.f23518i;
        r5.f23519j = this.f23519j;
        r5.f23520k = this.f23520k;
        r5.f23521l = this.f23521l;
        r5.f23522m = this.f23522m;
        r5.f23523n = this.f23523n;
        r5.f23524o = this.f23524o;
        r5.f23525p = this.f23525p;
        r5.f23526q = this.f23526q;
        r5.f23527r = this.f23527r;
        r5.s = this.s;
        r5.f23528t = this.f23528t;
        r5.f23529u = this.f23529u;
        r5.G = this.G;
        r5.H = this.H;
        r5.I = this.I;
        r5.J = this.J;
        r5.L = this.L;
        r5.K = this.K;
        r5.e = this.e;
        r5.f23530v = this.f23530v;
        r5.f23532x = this.f23532x;
        r5.f23531w = this.f23531w;
        r5.f23533y = this.f23533y;
        r5.f23534z = this.f23534z;
        r5.F = this.F;
        r5.A = this.A;
        r5.B = this.B;
        r5.C = this.C;
        r5.D = this.D;
        r5.E = this.E;
        return r5;
    }

    public final TextDirectionHeuristic c() {
        int r5 = this.e;
        if (r5 != 0) goto L7;
        return TextDirectionHeuristics.FIRSTSTRONG_LTR;
    L7:
        if (r5 != 3) goto L11;
        return TextDirectionHeuristics.LTR;
    L11:
        return TextDirectionHeuristics.RTL;
    }

    public final int d() {
        int r5 = this.g;
        if (r5 == 1) goto L7;
        if (r5 < 6) goto L10;
        if (r5 <= 10) goto L7;
    L10:
        if (r5 == 1) goto L19;
        if (r5 < 6) goto L14;
        if (r5 <= 10) goto L19;
    L14:
        int r10 = this.f23517h;
        if (r10 != 2) goto L17;
        return r10;
    L17:
        return 0;
    L19:
        return 1;
    L7:
        if (this.f23517h != 2) goto L10;
        return 3;
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof q) == true) goto L5;
        return false;
    L5:
        q r10 = (q) r5;
        if (this.f23514a == r10.f23514a) goto L8;
    L89:
        return false;
    L8:
        if (this.f23515b != r10.f23515b) goto L89;
        Integer r11 = r10.f23516c;
        Integer r12 = this.f23516c;
        if (r12 == null) goto L13;
        if (r11 == null) goto L13;
        boolean r13 = r12.equals(r11);
    L17:
        if (r13 == false) goto L89;
        if (this.d != r10.d) goto L89;
        if (this.f != r10.f) goto L89;
        if (this.g != r10.g) goto L89;
        if (this.f23517h != r10.f23517h) goto L89;
        if (this.f23518i != r10.f23518i) goto L89;
        if (this.f23519j != r10.f23519j) goto L89;
        if (com.lynx.tasm.utils.a.k(this.f23520k, r10.f23520k) == false) goto L89;
        if (com.lynx.tasm.utils.a.k(this.f23521l, r10.f23521l) == false) goto L89;
        if (com.lynx.tasm.utils.a.k(this.f23522m, r10.f23522m) == false) goto L89;
        if (com.lynx.tasm.utils.a.k(this.f23523n, r10.f23523n) == false) goto L89;
        if (Objects.equals(this.f23524o, r10.f23524o) == false) goto L89;
        if (this.f23525p != r10.f23525p) goto L89;
        if (this.f23526q != r10.f23526q) goto L89;
        if (this.s != r10.s) goto L89;
        if (this.f23527r != r10.f23527r) goto L89;
        if (this.f23528t != r10.f23528t) goto L89;
        if (TextUtils.equals(this.f23529u, r10.f23529u) == false) goto L89;
        if (Objects.equals(this.G, r10.G) == false) goto L89;
        if (this.H != r10.H) goto L89;
        if (this.e != r10.e) goto L89;
        if (this.J != r10.J) goto L89;
        if (this.I != r10.I) goto L89;
        if (this.K != r10.K) goto L89;
        if (com.lynx.tasm.utils.a.k(this.L, r10.L) == false) goto L89;
        if (this.f23530v != r10.f23530v) goto L89;
        if (com.lynx.tasm.utils.a.k(this.f23532x, r10.f23532x) == false) goto L89;
        if (com.lynx.tasm.utils.a.k(this.f23531w, r10.f23531w) == false) goto L89;
        if (com.lynx.tasm.utils.a.k(this.f23533y, r10.f23533y) == false) goto L89;
        if (Arrays.equals(this.f23534z, r10.f23534z) == false) goto L89;
        if (this.F != r10.F) goto L89;
        if (this.A != r10.A) goto L89;
        if (this.B != r10.B) goto L89;
        if (this.E != r10.E) goto L89;
        if (TextUtils.equals(this.C, r10.C) == false) goto L89;
        if (TextUtils.equals(this.D, r10.D) == false) goto L89;
        return true;
    L13:
        if (r12 != null) goto L16;
        if (r11 != null) goto L16;
        r13 = true;
    L16:
        r13 = false;
        goto L17
    }

    public final int hashCode() {
        int r5 = ((this.f23514a * 31) + this.f23515b) * 31;
        Integer r10 = this.f23516c;
        if (r10 == null) goto L5;
        int r11 = r10.intValue();
    L6:
        int r12 = (Float.floatToIntBits(this.f23523n) + ((Float.floatToIntBits(this.f23522m) + ((Float.floatToIntBits(this.f23521l) + ((Float.floatToIntBits(this.f23520k) + ((((((((((((r5 + r11) * 31) + this.d) * 31) + this.f) * 31) + this.g) * 31) + this.f23518i) * 31) + this.f23519j) * 31)) * 31)) * 31)) * 31)) * 31;
        u r13 = this.f23524o;
        int r14 = 0;
        if (r13 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (((((((((Float.floatToIntBits(this.f23525p) + ((r12 + r15) * 31)) * 31) + (this.f23526q ? 1 : 0)) * 31) + (this.s ? 1 : 0)) * 31) + (this.f23527r ? 1 : 0)) * 31) + (this.f23528t ? 1 : 0)) * 31;
        String r17 = this.f23529u;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        com.lynx.tasm.behavior.ui.r r20 = this.G;
        if (r20 != null) goto L17;
        int r21 = 0;
    L18:
        int r22 = (((((Float.floatToIntBits(this.L) + ((((((((r19 + r21) * 31) + this.H) * 31) + this.I) * 31) + this.J) * 31)) * 31) + this.K) * 31) + this.e) * 31;
        an.a r23 = this.M;
        if (r23 != null) goto L21;
        int r24 = 0;
    L22:
        int r25 = (Float.floatToIntBits(this.f23533y) + ((Float.floatToIntBits(this.f23531w) + ((Float.floatToIntBits(this.f23532x) + ((((r22 + r24) * 961) + (this.f23530v ? 1 : 0)) * 31)) * 31)) * 31)) * 31;
        float[] r26 = this.f23534z;
        if (r26 != null) goto L25;
        int r27 = 0;
    L26:
        int r28 = (((((((r25 + r27) * 31) + this.F) * 31) + (this.A ? 1 : 0)) * 31) + (this.B ? 1 : 0)) * 31;
        String r29 = this.C;
        if (r29 != null) goto L29;
        int r30 = 0;
    L30:
        int r31 = (r28 + r30) * 31;
        String r32 = this.D;
        if (r32 == null) goto L35;
        r14 = r32.hashCode();
    L35:
        return ((r31 + r14) * 31) + (this.E ? 1 : 0);
    L29:
        r30 = r29.hashCode();
        goto L30
    L25:
        r27 = r26.hashCode();
        goto L26
    L21:
        r24 = r23.hashCode();
        goto L22
    L17:
        r21 = r20.hashCode();
        goto L18
    L13:
        r18 = r17.hashCode();
        goto L14
    L9:
        r15 = r13.hashCode();
        goto L10
    L5:
        r11 = ViewCompat.MEASURED_STATE_MASK;
        goto L6
    }
}
