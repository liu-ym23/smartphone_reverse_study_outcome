package com.obric.oui.animation.style;

import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Util.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004¨\u0006\b"}, d2 = {"findAllEditTexts", "", "Landroid/widget/EditText;", "view", "Landroid/view/View;", "hideSoftKeyboard", "", "rootView", "OUIAnimation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class UtilKt {
    public static final List<EditText> findAllEditTexts(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        ArrayList r0 = new ArrayList();
        if ((r5 instanceof ViewGroup) == false) goto L8;
        ViewGroup r6 = (ViewGroup) r5;
        int r1 = r6.getChildCount();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L10;
        int r3 = r2 + 1;
        View r4 = r6.getChildAt(r2);
        Intrinsics.checkNotNullExpressionValue(r4, "child");
        r0.addAll(findAllEditTexts(r4));
        r2 = r3;
    L10:
        return r0;
    L8:
        if ((r5 instanceof EditText) == false) goto L10;
        r0.add(r5);
        goto L10
    }

    public static final void hideSoftKeyboard(View r3) {
        Intrinsics.checkNotNullParameter(r3, "rootView");
        List<EditText> r0 = findAllEditTexts(r3);
        Object r4 = r3.getContext().getSystemService("input_method");
        if (r4 == null) goto L12;
        InputMethodManager r5 = (InputMethodManager) r4;
        Iterator<EditText> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        EditText r2 = r1.next();
        if (r5.isActive(r2) == false) goto L6;
        r5.hideSoftInputFromWindow(r2.getWindowToken(), 0);
        goto L6
    L10:
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }
}
