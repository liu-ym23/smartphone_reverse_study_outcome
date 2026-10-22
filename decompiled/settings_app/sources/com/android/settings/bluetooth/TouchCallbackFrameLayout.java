package com.android.settings.bluetooth;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TouchCallbackFrameLayout.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bJ\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/android/settings/bluetooth/TouchCallbackFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "listeners", "", "Landroid/view/View$OnTouchListener;", "addOnTouchListener", "", "listener", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "removeOnTouchListener", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TouchCallbackFrameLayout extends FrameLayout {
    private final List<View.OnTouchListener> listeners;

    public TouchCallbackFrameLayout(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public TouchCallbackFrameLayout(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ TouchCallbackFrameLayout(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public TouchCallbackFrameLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.listeners = new ArrayList();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r4) {
        Iterator<T> r0 = this.listeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        ((View.OnTouchListener) r0.next()).onTouch(this, r4);
        goto L4
    L7:
        return super.onTouchEvent(r4);
    }

    public final void addOnTouchListener(View.OnTouchListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.listeners.add(r2);
    }

    public final void removeOnTouchListener(View.OnTouchListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.listeners.remove(r2);
    }
}
