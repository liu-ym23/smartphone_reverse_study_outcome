package u;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import java.io.Closeable;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PathMeasure f22191a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Path f22192b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Path f22193c = null;
    public static final float[] d = null;
    public static final float e = 0.0f;
    public static float f;

    static {
        f22191a = new PathMeasure();
        f22192b = new Path();
        f22193c = new Path();
        d = new float[4];
        e = (float) (Math.sqrt(2.0d) / 2.0d);
        f = -1.0f;
    }

    public static void a(Path r10, float r11, float r12, float r13) {
        PathMeasure r5 = f22191a;
        r5.setPath(r10, false);
        float r14 = r5.getLength();
        if (r11 != 1.0f) goto L9;
        if (r12 != 0.0f) goto L9;
        com.airbnb.lottie.c.a();
        return;
    L9:
        if (r14 >= 1.0f) goto L11;
    L38:
        com.airbnb.lottie.c.a();
        return;
    L11:
        if (Math.abs((r12 - r11) - 1.0f) < 0.01d) goto L38;
        float r15 = r11 * r14;
        float r16 = r12 * r14;
        float r17 = r13 * r14;
        float r18 = Math.min(r15, r16) + r17;
        float r19 = Math.max(r15, r16) + r17;
        if (r18 < r14) goto L19;
        if (r19 < r14) goto L19;
        r18 = e.c(r18, r14);
        r19 = e.c(r19, r14);
    L19:
        if (r18 >= 0.0f) goto L22;
        r18 = e.c(r18, r14);
    L22:
        if (r19 >= 0.0f) goto L25;
        r19 = e.c(r19, r14);
    L25:
        if (r18 != r19) goto L28;
        r10.reset();
        com.airbnb.lottie.c.a();
        return;
    L28:
        if (r18 < r19) goto L30;
        r18 = r18 - r14;
    L30:
        Path r20 = f22192b;
        r20.reset();
        r5.getSegment(r18, r19, r20, true);
        Path r21 = f22193c;
        if (r19 <= r14) goto L34;
        r21.reset();
        r5.getSegment(0.0f, r19 % r14, r21, true);
        r20.addPath(r21);
    L36:
        r10.set(r20);
        com.airbnb.lottie.c.a();
        return;
    L34:
        if (r18 >= 0.0f) goto L36;
        r21.reset();
        r5.getSegment(r18 + r14, r14, r21, true);
        r20.addPath(r21);
        goto L36
    }

    public static void b(Closeable r5) {
        if (r5 != null) goto L9;
        return;
    L9:
        r5.close();     // Catch: RuntimeException -> L5 Exception -> L8
        goto L12
    L11:
        return;
    L5:
        e = move-exception;
        throw e;
    }

    public static float c() {
        if (f != (-1.0f)) goto L6;
        f = Resources.getSystem().getDisplayMetrics().density;
    L6:
        return f;
    }

    public static float d(Matrix r10) {
        float[] r5 = d;
        r5[0] = 0.0f;
        r5[1] = 0.0f;
        float r11 = e;
        r5[2] = r11;
        r5[3] = r11;
        r10.mapPoints(r5);
        return (float) Math.hypot(r5[2] - r5[0], r5[3] - r5[1]);
    }

    public static void e(Canvas r5, RectF r10, Paint r11) {
        r5.saveLayer(r10, r11);
        com.airbnb.lottie.c.a();
    }
}
