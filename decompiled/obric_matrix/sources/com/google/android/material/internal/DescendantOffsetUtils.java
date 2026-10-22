package com.google.android.material.internal;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class DescendantOffsetUtils {
    private static final ThreadLocal<Matrix> matrix = null;
    private static final ThreadLocal<RectF> rectF = null;

    static {
        matrix = new ThreadLocal();
        rectF = new ThreadLocal();
    }

    public DescendantOffsetUtils() {
    }

    public static void getDescendantRect(@NonNull ViewGroup r3, @NonNull View r4, @NonNull Rect r5) {
        r5.set(0, 0, r4.getWidth(), r4.getHeight());
        offsetDescendantRect(r3, r4, r5);
    }

    private static void offsetDescendantMatrix(ViewParent r2, @NonNull View r3, @NonNull Matrix r4) {
        Object r0 = r3.getParent();
        if ((r0 instanceof View) == false) goto L6;
        if (r0 == r2) goto L6;
        View r1 = (View) r0;
        offsetDescendantMatrix(r2, r1, r4);
        r4.preTranslate(-r1.getScrollX(), -r1.getScrollY());
    L6:
        r4.preTranslate(r3.getLeft(), r3.getTop());
        if (r3.getMatrix().isIdentity() == true) goto L10;
        r4.preConcat(r3.getMatrix());
        return;
    }

    public static void offsetDescendantRect(@NonNull ViewGroup r3, @NonNull View r4, @NonNull Rect r5) {
        ThreadLocal<Matrix> r0 = matrix;
        Matrix r1 = r0.get();
        if (r1 != null) goto L5;
        r1 = new Matrix();
        r0.set(r1);
    L6:
        offsetDescendantMatrix(r3, r4, r1);
        ThreadLocal<RectF> r6 = rectF;
        RectF r7 = r6.get();
        if (r7 != null) goto L9;
        r7 = new RectF();
        r6.set(r7);
    L9:
        r7.set(r5);
        r1.mapRect(r7);
        r5.set((int) (r7.left + 0.5f), (int) (r7.top + 0.5f), (int) (r7.right + 0.5f), (int) (r7.bottom + 0.5f));
        return;
    L5:
        r1.reset();
        goto L6
    }
}
