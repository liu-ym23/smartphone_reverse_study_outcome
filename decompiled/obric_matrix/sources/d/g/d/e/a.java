package d.g.d.e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import kotlin.n0.d.o;
import kotlin.r0.e;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16933a = null;

    static {
        f16933a = new a();
    }

    private a() {
    }

    private final Bitmap b(Context r2, Drawable r3, Float r4, Float r5) {
        if ((r3 instanceof BitmapDrawable) == false) goto L9;
        if (r4 != null) goto L9;
        if (r5 != null) goto L9;
        Bitmap r1 = ((BitmapDrawable) r3).getBitmap();
        String r6 = "drawable.bitmap";
    L7:
        o.e(r1, r6);
        return r1;
    L9:
        Resources r7 = r2.getResources();
        o.e(r7, "context.resources");
        float r8 = r7.getDisplayMetrics().density;
        if (r4 == null) goto L12;
        int r9 = (int) (r4.floatValue() * r8);
    L13:
        if (r5 == null) goto L15;
        int r10 = (int) (r5.floatValue() * r8);
    L16:
        r1 = Bitmap.createBitmap(r9, r10, Bitmap.Config.ARGB_8888);
        Canvas r11 = new Canvas(r1);
        r3.setBounds(0, 0, r11.getWidth(), r11.getHeight());
        r3.draw(r11);
        r6 = "bitmap";
        goto L7
    L15:
        r10 = e.c(r3.getIntrinsicHeight(), 1);
        goto L16
    L12:
        r9 = e.c(r3.getIntrinsicWidth(), 1);
        goto L13
    }

    static /* synthetic */ Bitmap c(a r1, Context r2, Drawable r3, Float r4, Float r5, int r6, Object r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L9;
        r5 = null;
    L9:
        return r1.b(r2, r3, r4, r5);
    }

    public final Drawable a(Context r10, Drawable r11, float r12, float r13, float r14, int r15) {
        o.f(r10, "context");
        o.f(r11, "drawable");
        Resources r0 = r10.getResources();
        o.e(r0, "context.resources");
        int r16 = (int) (r14 * r0.getDisplayMetrics().density);
        GradientDrawable r1 = new GradientDrawable();
        r1.setShape(1);
        r1.setStroke(r16, r15);
        r1.setColor(0);
        if (r12 > 0.0f) goto L5;
    L8:
        Bitmap r9 = c(this, r10, r11, null, null, 12, null);
    L9:
        RoundedBitmapDrawable r17 = RoundedBitmapDrawableFactory.create(r10.getResources(), r9);
        r17.setCircular(true);
        o.e(r17, "RoundedBitmapDrawableFac…ular = true\n            }");
        return new LayerDrawable(new Drawable[]{r17, r1});
    L5:
        if (r13 <= 0.0f) goto L8;
        r9 = b(r10, r11, Float.valueOf(r12), Float.valueOf(r13));
        goto L9
    }
}
