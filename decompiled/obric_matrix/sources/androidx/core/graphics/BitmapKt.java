package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Point;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0086\b\u001a7\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a)\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010H\u0086\bø\u0001\u0000\u001a\u0015\u0010\u0011\u001a\u00020\b*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0013H\u0086\n\u001a\u0015\u0010\u0011\u001a\u00020\b*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0014H\u0086\n\u001a\u001d\u0010\u0015\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H\u0086\n\u001a'\u0010\u0018\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\bH\u0086\b\u001a'\u0010\u001a\u001a\u00020\u000f*\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\b\b\u0001\u0010\u001b\u001a\u00020\u0003H\u0086\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001c"}, d2 = {"createBitmap", "Landroid/graphics/Bitmap;", "width", "", "height", "config", "Landroid/graphics/Bitmap$Config;", "hasAlpha", "", "colorSpace", "Landroid/graphics/ColorSpace;", "applyCanvas", "block", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "", "Lkotlin/ExtensionFunctionType;", "contains", "p", "Landroid/graphics/Point;", "Landroid/graphics/PointF;", "get", "x", "y", "scale", "filter", "set", TypedValues.Custom.S_COLOR, "core-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class BitmapKt {
    public static final Bitmap applyCanvas(Bitmap r1, l<? super Canvas, f0> r2) {
        o.f(r1, "<this>");
        o.f(r2, "block");
        r2.invoke(new Canvas(r1));
        return r1;
    }

    public static final boolean contains(Bitmap r4, Point r5) {
        o.f(r4, "<this>");
        o.f(r5, "p");
        int r0 = r4.getWidth();
        int r1 = r5.x;
        if (r1 < 0) goto L6;
        if (r1 >= r0) goto L6;
        boolean r2 = true;
    L7:
        if (r2 == false) goto L14;
        int r6 = r5.y;
        if (r6 < 0) goto L14;
        if (r6 >= r4.getHeight()) goto L14;
        return true;
    L14:
        return false;
    L6:
        r2 = false;
        goto L7
    }

    public static final boolean contains(Bitmap r3, PointF r4) {
        o.f(r3, "<this>");
        o.f(r4, "p");
        float r0 = r4.x;
        if (r0 >= 0.0f) goto L5;
    L11:
        return false;
    L5:
        if (r0 >= r3.getWidth()) goto L11;
        float r5 = r4.y;
        if (r5 < 0.0f) goto L11;
        if (r5 >= r3.getHeight()) goto L11;
        return true;
    }

    public static final Bitmap createBitmap(int r1, int r2, Bitmap.Config r3) {
        o.f(r3, "config");
        Bitmap r4 = Bitmap.createBitmap(r1, r2, r3);
        o.e(r4, "createBitmap(width, height, config)");
        return r4;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final Bitmap createBitmap(int r1, int r2, Bitmap.Config r3, boolean r4, ColorSpace r5) {
        o.f(r3, "config");
        o.f(r5, "colorSpace");
        Bitmap r6 = Bitmap.createBitmap(r1, r2, r3, r4, r5);
        o.e(r6, "createBitmap(width, heig…ig, hasAlpha, colorSpace)");
        return r6;
    }

    public static /* synthetic */ Bitmap createBitmap$default(int r0, int r1, Bitmap.Config r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L5;
        r2 = Bitmap.Config.ARGB_8888;
    L5:
        o.f(r2, "config");
        Bitmap r5 = Bitmap.createBitmap(r0, r1, r2);
        o.e(r5, "createBitmap(width, height, config)");
        return r5;
    }

    public static /* synthetic */ Bitmap createBitmap$default(int r0, int r1, Bitmap.Config r2, boolean r3, ColorSpace r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r2 = Bitmap.Config.ARGB_8888;
    L6:
        if ((r5 & 8) == 0) goto L9;
        r3 = true;
    L9:
        if ((r5 & 16) == 0) goto L11;
        r4 = ColorSpace.get(ColorSpace.Named.SRGB);
        o.e(r4, "get(ColorSpace.Named.SRGB)");
    L11:
        o.f(r2, "config");
        o.f(r4, "colorSpace");
        Bitmap r7 = Bitmap.createBitmap(r0, r1, r2, r3, r4);
        o.e(r7, "createBitmap(width, heig…ig, hasAlpha, colorSpace)");
        return r7;
    }

    public static final int get(Bitmap r1, int r2, int r3) {
        o.f(r1, "<this>");
        return r1.getPixel(r2, r3);
    }

    public static final Bitmap scale(Bitmap r1, int r2, int r3, boolean r4) {
        o.f(r1, "<this>");
        Bitmap r5 = Bitmap.createScaledBitmap(r1, r2, r3, r4);
        o.e(r5, "createScaledBitmap(this, width, height, filter)");
        return r5;
    }

    public static /* synthetic */ Bitmap scale$default(Bitmap r0, int r1, int r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = true;
    L5:
        o.f(r0, "<this>");
        Bitmap r6 = Bitmap.createScaledBitmap(r0, r1, r2, r3);
        o.e(r6, "createScaledBitmap(this, width, height, filter)");
        return r6;
    }

    public static final void set(Bitmap r1, int r2, int r3, @ColorInt int r4) {
        o.f(r1, "<this>");
        r1.setPixel(r2, r3, r4);
    }
}
