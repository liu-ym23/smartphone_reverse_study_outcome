package com.obric.oui.common.util;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class TouchDelegateComposite extends TouchDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f208a;

    public TouchDelegateComposite(View r3) {
        Rect r0 = new Rect();
        Intrinsics.f(r3, "view");
        super(r0, r3);
        this.f208a = new ArrayList();
    }

    @Override // android.view.TouchDelegate
    public final boolean onTouchEvent(MotionEvent r6) {
        Intrinsics.f(r6, "event");
        float r0 = r6.getX();
        float r1 = r6.getY();
        Iterator r5 = this.f208a.iterator();
    L3:
        boolean r3 = false;
    L5:
        if (r5.hasNext() == false) goto L10;
        TouchDelegate r4 = (TouchDelegate) r5.next();
        r6.setLocation(r0, r1);
        if (r4.onTouchEvent(r6) == true) goto L9;
        if (r3 == false) goto L3;
    L9:
        r3 = true;
        goto L5
    L10:
        return r3;
    }
}
