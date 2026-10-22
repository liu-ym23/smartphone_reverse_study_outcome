package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
class ImageViewUtils {
    private static Field sDrawMatrixField = null;
    private static boolean sDrawMatrixFieldFetched = false;
    private static boolean sTryHiddenAnimateTransform = true;

    static {
    }

    private ImageViewUtils() {
    }

    static void animateTransform(@NonNull ImageView r4, @Nullable Matrix r5) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 29) goto L6;
        r4.animateTransform(r5);
        return;
    L6:
        if (r5 != null) goto L11;
        Drawable r6 = r4.getDrawable();
        if (r6 == null) goto L34;
        r6.setBounds(0, 0, (r4.getWidth() - r4.getPaddingLeft()) - r4.getPaddingRight(), (r4.getHeight() - r4.getPaddingTop()) - r4.getPaddingBottom());
    L25:
        r4.invalidate();
        return;
    L34:
        return;
    L11:
        if (r0 < 21) goto L13;
        hiddenAnimateTransform(r4, r5);
        return;
    L13:
        Drawable r1 = r4.getDrawable();
        if (r1 == null) goto L36;
        r1.setBounds(0, 0, r1.getIntrinsicWidth(), r1.getIntrinsicHeight());
        Matrix r2 = null;
        fetchDrawMatrixField();
        Field r3 = sDrawMatrixField;
        if (r3 != null) goto L29;
    L23:
        if (r2 == null) goto L25;
        r2.set(r5);
        goto L25
    L29:
        Matrix r7 = (Matrix) r3.get(r4);     // Catch: IllegalAccessException -> L28
        if (r7 == null) goto L31;
    L22:
        r2 = r7;
        goto L23
    L31:
        r2 = new Matrix();     // Catch: IllegalAccessException -> L27
        sDrawMatrixField.set(r4, r2);     // Catch: IllegalAccessException -> L28
        goto L23
    }

    private static void fetchDrawMatrixField() {
        if (sDrawMatrixFieldFetched == false) goto L9;
        return;
    L9:
        Field r1 = ImageView.class.getDeclaredField("mDrawMatrix");     // Catch: NoSuchFieldException -> L8
        sDrawMatrixField = r1;     // Catch: NoSuchFieldException -> L8
        r1.setAccessible(true);     // Catch: NoSuchFieldException -> L8
    L6:
        sDrawMatrixFieldFetched = true;
    }

    @RequiresApi(21)
    @SuppressLint({"NewApi"})
    private static void hiddenAnimateTransform(@NonNull ImageView r1, @Nullable Matrix r2) {
        if (sTryHiddenAnimateTransform == false) goto L10;
        r1.animateTransform(r2);     // Catch: NoSuchMethodError -> L6
        return;
    L6:
        sTryHiddenAnimateTransform = false;
        return;
    }
}
