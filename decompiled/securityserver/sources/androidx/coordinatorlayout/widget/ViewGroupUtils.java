package androidx.coordinatorlayout.widget;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ViewGroupUtils {
    private static final ThreadLocal<Matrix> sMatrix = null;
    private static final ThreadLocal<RectF> sRectF = null;

    static {
        sMatrix = new ThreadLocal();
        sRectF = new ThreadLocal();
    }

    private ViewGroupUtils() {
    }

    public static void getDescendantRect(ViewGroup r3, View r4, Rect r5) {
        r5.set(0, 0, r4.getWidth(), r4.getHeight());
        offsetDescendantRect(r3, r4, r5);
    }

    private static void offsetDescendantMatrix(ViewParent r2, View r3, Matrix r4) {
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

    public static void offsetDescendantRect(ViewGroup r3, View r4, Rect r5) {
        ThreadLocal<Matrix> r0 = sMatrix;
        Matrix r1 = r0.get();
        if (r1 != null) goto L5;
        r1 = new Matrix();
        r0.set(r1);
    L6:
        offsetDescendantMatrix(r3, r4, r1);
        ThreadLocal<RectF> r6 = sRectF;
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
