package com.obric.oui.push;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.ViewGroupUtils;
import androidx.customview.widget.ViewDragHelper;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class NotificationLabel extends CardView {
    public final String b;
    public ViewGroup c;
    public ViewDragHelper e;
    public boolean f;
    public boolean i;
    public View.OnClickListener j;
    public final NotificationLabel$dragCallback$1 k;
    public boolean l;
    public final ArrayList m;

    @Metadata
    public interface GestureListener {
        void a();

        void b();
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [com.obric.oui.push.NotificationLabel$dragCallback$1] */
    @JvmOverloads
    public NotificationLabel(@NotNull Context r3, @Nullable AttributeSet r4) {
        Intrinsics.f(r3, "context");
        super(r3, r4, 0);
        this.b = "NotificationLabel";
        this.k = new NotificationLabel$dragCallback$1(this);
        this.m = new ArrayList();
    }

    @Override // android.view.View
    public final void computeScroll() {
        ViewDragHelper r0 = this.e;
        if (r0 == null) goto L21;
        boolean r1 = r0.continueSettling(true);
        String r2 = this.b;
        if (r1 == false) goto L7;
        Log.d(r2, "scrolling");
        invalidate();
        return;
    L7:
        Log.d(r2, "settled");
        boolean r3 = this.f;
        ArrayList r4 = this.m;
        if (r3 == false) goto L15;
        this.f = false;
        Log.i(r2, "onDrag dismiss");
        Iterator r5 = r4.iterator();
        if (r5.hasNext() == false) goto L24;
        ((GestureListener) r5.next()).a();
        throw null;
    L24:
        return;
    L15:
        if (this.i == false) goto L23;
        this.i = false;
        Log.i(r2, "onDrag open");
        Iterator r6 = r4.iterator();
        if (r6.hasNext() == false) goto L25;
        ((GestureListener) r6.next()).b();
        throw null;
    L25:
        return;
    L23:
        return;
    }

    public final boolean getDismissSettling() {
        return this.f;
    }

    public final boolean getInterceptingEvents() {
        return this.l;
    }

    public final boolean getOpenSettling() {
        return this.i;
    }

    @Override // android.view.View, android.view.ViewParent
    @Nullable
    public final ViewGroup getParent() {
        return this.c;
    }

    @NotNull
    public final String getTAG() {
        return this.b;
    }

    @Nullable
    public final ViewDragHelper getViewDragHelper() {
        return this.e;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r6) {
        Intrinsics.f(r6, "event");
        boolean r0 = this.l;
        int r1 = r6.getActionMasked();
        if (r1 != 0) goto L5;
        int r2 = (int) r6.getX();
        int r3 = (int) r6.getY();
        Rect r4 = new Rect();
        ViewGroupUtils.getDescendantRect(this.c, this, r4);
        r0 = r4.contains(r2, r3);
        this.l = r0;
        Log.i(this.b, "intercept: " + this.l);
    L11:
        if (r0 == false) goto L18;
        ViewGroup r5 = this.c;
        if (this.e != null) goto L16;
        if (r5 == null) goto L16;
        this.e = ViewDragHelper.create(r5, 1.0f, this.k);
    L16:
        ViewDragHelper r7 = this.e;
        Intrinsics.c(r7);
        return r7.shouldInterceptTouchEvent(r6);
    L18:
        return false;
    L5:
        if (r1 != 1) goto L7;
    L9:
        this.l = false;
        goto L11
    L7:
        if (r1 == 3) goto L9;
        goto L9
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r2) {
        Intrinsics.f(r2, "event");
        ViewDragHelper r1 = this.e;
        if (r1 == null) goto L8;
        if (r1 == null) goto L10;
        r1.processTouchEvent(r2);
        return true;
    L10:
        return true;
    L8:
        return false;
    }

    public final void setDismissSettling(boolean r1) {
        this.f = r1;
    }

    public final void setInterceptingEvents(boolean r1) {
        this.l = r1;
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener r1) {
        this.j = r1;
    }

    public final void setOpenSettling(boolean r1) {
        this.i = r1;
    }

    public final void setParent(@Nullable ViewGroup r3) {
        this.c = r3;
        if (this.e != null) goto L7;
        if (r3 == null) goto L8;
        this.e = ViewDragHelper.create(r3, 1.0f, this.k);
        return;
    L8:
        return;
    }

    public final void setViewDragHelper(@Nullable ViewDragHelper r1) {
        this.e = r1;
    }
}
