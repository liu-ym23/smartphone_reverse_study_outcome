package t;

import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinearInterpolator f22037a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static SparseArrayCompat f22038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ko.r f22039c = null;

    static {
        f22037a = new LinearInterpolator();
        f22039c = ko.r.r(new String[]{"t", "s", "e", "o", "i", "h", "to", "ti"});
    }

    public static v.a a(com.airbnb.lottie.parser.moshi.a r16, com.airbnb.lottie.h r17, float r18, b0 r19, boolean r20) {
        if (r20 == false) goto L68;
        r16.d();
        Interpolator r5 = null;
        PointF r10 = null;
        PointF r11 = null;
        Object r12 = null;
        Object r13 = null;
        PointF r14 = null;
        PointF r15 = null;
        float r110 = 0.0f;
    L5:
        boolean r21 = false;
    L7:
        if (r16.g() == false) goto L21;
        switch(r16.L(f22039c)) {
            case 0: goto L20;
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L14;
            case 6: goto L12;
            case 7: goto L11;
            default: goto L10;
        };
    L11:
        r14 = m.b(r16, r18);
        goto L7
    L12:
        r15 = m.b(r16, r18);
        goto L7
    L14:
        if (r16.p() != 1) goto L5;
        r21 = true;
        goto L7
    L16:
        r11 = m.b(r16, r18);
        goto L7
    L17:
        r10 = m.b(r16, r18);
        goto L7
    L18:
        r12 = r19.a(r16, r18);
        goto L7
    L19:
        r13 = r19.a(r16, r18);
        goto L7
    L20:
        r110 = (float) r16.n();
        goto L7
    L10:
        r16.N();
        goto L7
    L21:
        r16.f();
        if (r21 == false) goto L24;
        Interpolator r111 = f22037a;
        Object r112 = r13;
    L65:
        v.a r22 = new v.a(r17, r13, r112, r111, r110, null);
        r22.f22478m = r15;
        r22.f22479n = r14;
        return r22;
    L24:
        if (r10 == null) goto L64;
        if (r11 == null) goto L64;
        float r23 = -r18;
        r10.x = u.e.b(r10.x, r23, r18);
        r10.y = u.e.b(r10.y, -100.0f, 100.0f);
        r11.x = u.e.b(r11.x, r23, r18);
        float r24 = u.e.b(r11.y, -100.0f, 100.0f);
        r11.y = r24;
        float r25 = r10.x;
        float r26 = r10.y;
        float r27 = r11.x;
        PathMeasure r113 = u.f.f22191a;
        if (r25 == 0.0f) goto L29;
        int r28 = (int) (527 * r25);
    L31:
        if (r26 == 0.0f) goto L34;
        r28 = (int) ((r28 * 31) * r26);
    L34:
        if (r27 == 0.0f) goto L37;
        r28 = (int) ((r28 * 31) * r27);
    L37:
        if (r24 == 0.0f) goto L40;
        r28 = (int) ((r28 * 31) * r24);
    L40:
        monitor-enter(n.class);
    L61:
        th = move-exception;
        throw th;
    L42:
        if (f22038b != null) goto L44;
        f22038b = new SparseArrayCompat();     // Catch: Throwable -> L61
    L44:
        WeakReference r29 = (WeakReference) f22038b.get(r28);     // Catch: Throwable -> L61
        monitor-exit(n.class);     // Catch: Throwable -> L61
        if (r29 == null) goto L48;
        r5 = (Interpolator) r29.get();
    L48:
        if (r29 == null) goto L50;
        if (r5 == null) goto L50;
    L59:
        r111 = r5;
    L60:
        r112 = r12;
    L50:
        r5 = PathInterpolatorCompat.create(r10.x / r18, r10.y / r18, r11.x / r18, r11.y / r18);
        WeakReference r30 = new WeakReference(r5);     // Catch: ArrayIndexOutOfBoundsException -> L69
        monitor-enter(n.class);     // Catch: ArrayIndexOutOfBoundsException -> L69
        f22038b.put(r28, r30);     // Catch: Throwable -> L56
        monitor-exit(n.class);     // Catch: Throwable -> L56
    L56:
        th = move-exception;
        throw th;     // Catch: ArrayIndexOutOfBoundsException -> L69
    L29:
        r28 = 17;
    L64:
        r111 = f22037a;
        goto L60
    L68:
        return new v.a(r19.a(r16, r18));
    }
}
