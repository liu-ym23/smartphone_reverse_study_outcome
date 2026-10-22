package d.c.i.d;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.DisplayMetrics;
import androidx.core.view.ViewCompat;
import d.c.c.d.i;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f {

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f15914a = null;

        static {
            int[] r0 = new int[Bitmap.Config.values().length];
            f15914a = r0;
            r0[Bitmap.Config.RGB_565.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f15914a[Bitmap.Config.ALPHA_8.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f15914a[Bitmap.Config.ARGB_4444.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f15914a[Bitmap.Config.ARGB_8888.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public f() {
    }

    private static void a(Bitmap r2, int r3, int r4, int r5, int r6) {
        boolean r0 = true;
        if ((r3 + r5) > r2.getWidth()) goto L5;
        boolean r7 = true;
    L6:
        i.c(r7, "x + width must be <= bitmap.width()");
        if ((r4 + r6) <= r2.getHeight()) goto L10;
        r0 = false;
    L10:
        i.c(r0, "y + height must be <= bitmap.height()");
        return;
    L5:
        r7 = false;
        goto L6
    }

    private static void b(int r3, int r4) {
        boolean r0 = true;
        if (r3 <= 0) goto L5;
        boolean r5 = true;
    L6:
        i.c(r5, "width must be > 0");
        if (r4 > 0) goto L10;
        r0 = false;
    L10:
        i.c(r0, "height must be > 0");
        return;
    L5:
        r5 = false;
        goto L6
    }

    private static void c(int r3, int r4) {
        boolean r0 = true;
        if (r3 < 0) goto L5;
        boolean r5 = true;
    L6:
        i.c(r5, "x must be >= 0");
        if (r4 >= 0) goto L10;
        r0 = false;
    L10:
        i.c(r0, "y must be >= 0");
        return;
    L5:
        r5 = false;
        goto L6
    }

    private d.c.c.h.a<Bitmap> f(int r8, int r9, Bitmap.Config r10, boolean r11, Object r12) {
        return k(null, r8, r9, r10, r11, r12);
    }

    private d.c.c.h.a<Bitmap> k(DisplayMetrics r1, int r2, int r3, Bitmap.Config r4, boolean r5, Object r6) {
        b(r2, r3);
        d.c.c.h.a<Bitmap> r0 = l(r2, r3, r4);
        Bitmap r7 = r0.N();
        if (r1 == null) goto L6;
        r7.setDensity(r1.densityDpi);
    L6:
        if (Build.VERSION.SDK_INT < 12) goto L9;
        r7.setHasAlpha(r5);
    L9:
        if (r4 != Bitmap.Config.ARGB_8888) goto L12;
        if (r5 == true) goto L12;
        r7.eraseColor(ViewCompat.MEASURED_STATE_MASK);
    L12:
        return r0;
    }

    private static Bitmap.Config m(Bitmap r1) {
        Bitmap.Config r0 = Bitmap.Config.ARGB_8888;
        Bitmap.Config r2 = r1.getConfig();
        if (r2 == null) goto L12;
        int r3 = a.f15914a[r2.ordinal()];
        if (r3 == 1) goto L11;
        if (r3 == 2) goto L14;
        return Bitmap.Config.ARGB_8888;
    L14:
        return Bitmap.Config.ALPHA_8;
    L11:
        return Bitmap.Config.RGB_565;
    L12:
        return r0;
    }

    private static void n(Bitmap r2, Bitmap r3) {
        r3.setDensity(r2.getDensity());
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 12) goto L6;
        r3.setHasAlpha(r2.hasAlpha());
    L6:
        if (r0 < 19) goto L9;
        r3.setPremultiplied(r2.isPremultiplied());
        return;
    }

    public d.c.c.h.a<Bitmap> d(int r2, int r3, Bitmap.Config r4) {
        return e(r2, r3, r4, null);
    }

    public d.c.c.h.a<Bitmap> e(int r1, int r2, Bitmap.Config r3, Object r4) {
        return l(r1, r2, r3);
    }

    public d.c.c.h.a<Bitmap> g(Bitmap r2) {
        return j(r2, null);
    }

    public d.c.c.h.a<Bitmap> h(Bitmap r17, int r18, int r19, int r20, int r21, Matrix r22, boolean r23, Object r24) {
        i.h(r17, "Source bitmap cannot be null");
        c(r18, r19);
        b(r20, r21);
        a(r17, r18, r19, r20, r21);
        Rect r7 = new Rect(r18, r19, r18 + r20, r19 + r21);
        RectF r8 = new RectF(0.0f, 0.0f, r20, r21);
        Bitmap.Config r6 = m(r17);
        if (r22 != null) goto L5;
    L20:
        d.c.c.h.a<Bitmap> r4 = f(r20, r21, r6, r17.hasAlpha(), r24);
        n(r17, r4.N());
        Canvas r9 = new Canvas(r4.N());
        Paint r3 = null;
    L21:
        r9.drawBitmap(r17, r7, r8, r3);
        r9.setBitmap(null);
        return r4;
    L5:
        if (r22.isIdentity() == true) goto L20;
        boolean r1 = !r22.rectStaysRect();
        RectF r5 = new RectF();
        r22.mapRect(r5, r8);
        int r11 = Math.round(r5.width());
        int r12 = Math.round(r5.height());
        if (r1 == false) goto L10;
        r6 = Bitmap.Config.ARGB_8888;
    L10:
        Bitmap.Config r13 = r6;
        if (r1 == false) goto L13;
    L16:
        boolean r14 = true;
    L17:
        r4 = f(r11, r12, r13, r14, r24);
        n(r17, r4.N());
        r9 = new Canvas(r4.N());
        r9.translate(-r5.left, -r5.top);
        r9.concat(r22);
        r3 = new Paint();
        r3.setFilterBitmap(r23);
        if (r1 == false) goto L21;
        r3.setAntiAlias(true);
        goto L21
    L13:
        if (r17.hasAlpha() == true) goto L16;
        r14 = false;
        goto L17
    }

    public d.c.c.h.a<Bitmap> i(Bitmap r10, int r11, int r12, int r13, int r14, Object r15) {
        return h(r10, r11, r12, r13, r14, null, false, r15);
    }

    public d.c.c.h.a<Bitmap> j(Bitmap r8, Object r9) {
        return i(r8, 0, 0, r8.getWidth(), r8.getHeight(), r9);
    }

    public abstract d.c.c.h.a<Bitmap> l(int r1, int r2, Bitmap.Config r3);
}
