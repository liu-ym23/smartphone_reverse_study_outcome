package d.g.d.f;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    static {
    }

    @ColorInt
    public static final int a(@ColorInt int r3, float r4) {
        if (r4 != 1.0f) goto L5;
        return r3;
    L5:
        float r5 = kotlin.r0.e.h(r4, 0.0f, 1.0f);
        return Color.argb((int) (Color.alpha(r3) * r5), Color.red(r3), Color.green(r3), Color.blue(r3));
    }

    public static final void b(View r3, l<? super View, f0> r4) {
        o.f(r4, "visitor");
        if (r3 != null) goto L6;
        return;
    L6:
        if ((r3 instanceof ViewGroup) == false) goto L13;
        int r0 = 0;
        ViewGroup r5 = (ViewGroup) r3;
        int r1 = r5.getChildCount();
    L8:
        if (r0 >= r1) goto L17;
        View r2 = r5.getChildAt(r0);
        if (r2 == null) goto L12;
        r4.invoke(r2);
    L12:
        r0 = r0 + 1;
        goto L8
    L17:
        return;
    }
}
