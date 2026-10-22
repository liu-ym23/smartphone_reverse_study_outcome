package com.obric.oui.indicator;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final boolean a(ViewPager r1) {
        o.f(r1, "$this$isNotEmpty");
        PagerAdapter r2 = r1.getAdapter();
        if (r2 == null) goto L5;
        int r3 = r2.getCount();
    L6:
        if (r3 <= 0) goto L9;
        return true;
    L9:
        return false;
    L5:
        r3 = 0;
        goto L6
    }
}
