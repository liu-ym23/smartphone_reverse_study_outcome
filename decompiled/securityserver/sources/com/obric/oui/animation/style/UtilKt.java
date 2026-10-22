package com.obric.oui.animation.style;

import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class UtilKt {
    public static final ArrayList a(View r5) {
        Intrinsics.f(r5, "view");
        ArrayList r0 = new ArrayList();
        if ((r5 instanceof ViewGroup) == false) goto L8;
        ViewGroup r6 = (ViewGroup) r5;
        int r1 = r6.getChildCount();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L10;
        View r3 = r6.getChildAt(r2);
        Intrinsics.e(r3, "child");
        r0.addAll(a(r3));
        r2 = r2 + 1;
    L10:
        return r0;
    L8:
        if ((r5 instanceof EditText) == false) goto L10;
        r0.add(r5);
        goto L10
    }
}
