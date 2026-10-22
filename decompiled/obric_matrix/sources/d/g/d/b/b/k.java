package d.g.d.b.b;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static TypedValue f16793a;

    public static int a(Context r3, int r4) {
        if (f16793a != null) goto L6;
        f16793a = new TypedValue();
    L6:
        if (r3.getTheme().resolveAttribute(r4, f16793a, true) == true) goto L10;
        return 0;
    L10:
        return TypedValue.complexToDimensionPixelSize(f16793a.data, h.a(r3));
    }

    public static float b(Context r0, int r1) {
        return c(r0.getTheme(), r1);
    }

    public static float c(Resources.Theme r2, int r3) {
        if (f16793a != null) goto L6;
        f16793a = new TypedValue();
    L6:
        if (r2.resolveAttribute(r3, f16793a, true) == true) goto L10;
        return -1.0f;
    L10:
        return f16793a.getFloat();
    }

    public static TypedArray d(Resources r0, Resources.Theme r1, AttributeSet r2, int[] r3) {
        if (r1 != null) goto L5;
        return r0.obtainAttributes(r2, r3);
    L5:
        return r1.obtainStyledAttributes(r2, r3, 0, 0);
    }
}
