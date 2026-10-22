package com.obric.oui.common.util;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends TouchDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<TouchDelegate> f10946a;

    public i(View r2, Rect r3) {
        o.f(r2, "view");
        o.f(r3, "emptyRect");
        super(r3, r2);
        this.f10946a = new ArrayList();
    }

    public /* synthetic */ i(View r1, Rect r2, int r3, kotlin.n0.d.g r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = new Rect();
    L5:
        this(r1, r2);
    }

    public final void a(TouchDelegate r2) {
        o.f(r2, "delegate");
        this.f10946a.add(r2);
    }

    @Override // android.view.TouchDelegate
    public boolean onTouchEvent(MotionEvent r6) {
        o.f(r6, NotificationCompat.CATEGORY_EVENT);
        float r0 = r6.getX();
        float r1 = r6.getY();
        Iterator<T> r5 = this.f10946a.iterator();
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
