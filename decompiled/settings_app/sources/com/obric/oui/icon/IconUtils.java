package com.obric.oui.icon;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: IconUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J>\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\rJ5\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/icon/IconUtils;", "", "()V", "createCircularDrawableWithBorder", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "drawable", "iconWidthDp", "", "iconHeightDp", "borderWidthDp", "borderColor", "", "drawableToBitmap", "Landroid/graphics/Bitmap;", "targetWidthDp", "targetHeightDp", "(Landroid/content/Context;Landroid/graphics/drawable/Drawable;Ljava/lang/Float;Ljava/lang/Float;)Landroid/graphics/Bitmap;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IconUtils {
    public static final IconUtils INSTANCE = null;

    static {
        INSTANCE = new IconUtils();
    }

    private IconUtils() {
    }

    public static /* synthetic */ Drawable createCircularDrawableWithBorder$default(IconUtils r9, Context r10, Drawable r11, float r12, float r13, float r14, int r15, int r16, Object r17) {
        if ((r16 & 4) == 0) goto L5;
        float r5 = 36.0f;
    L7:
        if ((r16 & 8) == 0) goto L9;
        float r6 = 36.0f;
    L11:
        if ((r16 & 16) == 0) goto L13;
        float r7 = 0.6f;
    L15:
        if ((r16 & 32) == 0) goto L17;
        int r8 = -3355444;
    L19:
        return r9.createCircularDrawableWithBorder(r10, r11, r5, r6, r7, r8);
    L17:
        r8 = r15;
        goto L19
    L13:
        r7 = r14;
        goto L15
    L9:
        r6 = r13;
        goto L11
    L5:
        r5 = r12;
        goto L7
    }

    public final Drawable createCircularDrawableWithBorder(Context r10, Drawable r11, float r12, float r13, float r14, int r15) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "drawable");
        int r16 = (int) (r14 * r10.getResources().getDisplayMetrics().density);
        GradientDrawable r0 = new GradientDrawable();
        r0.setShape(1);
        r0.setStroke(r16, r15);
        r0.setColor(0);
        if (r12 > 0.0f) goto L5;
    L8:
        Bitmap r9 = drawableToBitmap$default(this, r10, r11, null, null, 12, null);
    L9:
        RoundedBitmapDrawable r17 = RoundedBitmapDrawableFactory.create(r10.getResources(), r9);
        r17.setCircular(true);
        Intrinsics.checkNotNullExpressionValue(r17, "create(context.resources…ular = true\n            }");
        return new LayerDrawable(new Drawable[]{r17, r0});
    L5:
        if (r13 <= 0.0f) goto L8;
        r9 = drawableToBitmap(r10, r11, Float.valueOf(r12), Float.valueOf(r13));
        goto L9
    }

    static /* synthetic */ Bitmap drawableToBitmap$default(IconUtils r1, Context r2, Drawable r3, Float r4, Float r5, int r6, Object r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L9;
        r5 = null;
    L9:
        return r1.drawableToBitmap(r2, r3, r4, r5);
    }

    private final Bitmap drawableToBitmap(Context r2, Drawable r3, Float r4, Float r5) {
        if ((r3 instanceof BitmapDrawable) == false) goto L8;
        if (r4 != null) goto L8;
        if (r5 != null) goto L8;
        Bitmap r1 = ((BitmapDrawable) r3).getBitmap();
        Intrinsics.checkNotNullExpressionValue(r1, "drawable.bitmap");
        return r1;
    L8:
        float r6 = r2.getResources().getDisplayMetrics().density;
        Integer r7 = null;
        if (r4 != null) goto L11;
        Integer r8 = null;
    L13:
        if (r8 != null) goto L15;
        int r9 = RangesKt.coerceAtLeast(r3.getIntrinsicWidth(), 1);
    L16:
        if (r5 == null) goto L19;
        r7 = Integer.valueOf((int) (r5.floatValue() * r6));
    L19:
        if (r7 != null) goto L21;
        int r10 = RangesKt.coerceAtLeast(r3.getIntrinsicHeight(), 1);
    L22:
        Bitmap r11 = Bitmap.createBitmap(r9, r10, Bitmap.Config.ARGB_8888);
        Canvas r12 = new Canvas(r11);
        r3.setBounds(0, 0, r12.getWidth(), r12.getHeight());
        r3.draw(r12);
        Intrinsics.checkNotNullExpressionValue(r11, "bitmap");
        return r11;
    L21:
        r10 = r7.intValue();
        goto L22
    L15:
        r9 = r8.intValue();
        goto L16
    L11:
        r8 = Integer.valueOf((int) (r4.floatValue() * r6));
        goto L13
    }
}
