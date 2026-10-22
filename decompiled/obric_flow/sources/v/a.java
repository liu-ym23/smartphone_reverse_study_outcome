package v;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.h;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f22470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f22471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f22472c;
    public final Interpolator d;
    public final float e;
    public Float f;
    public float g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f22473h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f22474i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f22475j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f22476k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f22477l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public PointF f22478m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public PointF f22479n;

    public a(h r5, Object r10, Object r11, Interpolator r12, float r13, Float r14) {
        this.g = -3987645.8f;
        this.f22473h = -3987645.8f;
        this.f22474i = 784923401;
        this.f22475j = 784923401;
        this.f22476k = Float.MIN_VALUE;
        this.f22477l = Float.MIN_VALUE;
        this.f22478m = null;
        this.f22479n = null;
        this.f22470a = r5;
        this.f22471b = r10;
        this.f22472c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
    }

    public final float a() {
        h r5 = this.f22470a;
        if (r5 != null) goto L6;
        return 1.0f;
    L6:
        if (this.f22477l != Float.MIN_VALUE) goto L12;
        if (this.f != null) goto L10;
        this.f22477l = 1.0f;
        goto L12
    L10:
        float r10 = b();
        this.f22477l = ((this.f.floatValue() - this.e) / (r5.f1267l - r5.f1266k)) + r10;
    L12:
        return this.f22477l;
    }

    public final float b() {
        h r5 = this.f22470a;
        if (r5 != null) goto L7;
        return 0.0f;
    L7:
        if (this.f22476k != Float.MIN_VALUE) goto L10;
        float r10 = r5.f1266k;
        this.f22476k = (this.e - r10) / (r5.f1267l - r10);
    L10:
        return this.f22476k;
    }

    public final boolean c() {
        if (this.d != null) goto L5;
        return true;
    L5:
        return false;
    }

    public final String toString() {
        return "Keyframe{startValue=" + this.f22471b + ", endValue=" + this.f22472c + ", startFrame=" + this.e + ", endFrame=" + this.f + ", interpolator=" + this.d + '}';
    }

    public a(Object r5) {
        this.g = -3987645.8f;
        this.f22473h = -3987645.8f;
        this.f22474i = 784923401;
        this.f22475j = 784923401;
        this.f22476k = Float.MIN_VALUE;
        this.f22477l = Float.MIN_VALUE;
        this.f22478m = null;
        this.f22479n = null;
        this.f22470a = null;
        this.f22471b = r5;
        this.f22472c = r5;
        this.d = null;
        this.e = Float.MIN_VALUE;
        this.f = Float.valueOf(Float.MAX_VALUE);
    }
}
