package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
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

    private ImageViewUtils() {
    }

    public static void animateTransform(@NonNull ImageView r0, @Nullable Matrix r1) {
        r0.animateTransform(r1);
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
