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
import com.obric.oui.material.MaterialConfigFormatNames;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotificationLabel.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001BB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0017J\b\u00101\u001a\u00020/H\u0016J\u0012\u00102\u001a\u00020/2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0002J \u00103\u001a\u00020\u000e2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0007H\u0007J\b\u00108\u001a\u00020/H\u0014J\u0010\u00109\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020;H\u0016J\u0010\u0010<\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020;H\u0016J\r\u0010=\u001a\u00020/H\u0000¢\u0006\u0002\b>J\u000e\u0010?\u001a\u00020/2\u0006\u00100\u001a\u00020\u0017J\u0012\u0010@\u001a\u00020/2\b\u0010A\u001a\u0004\u0018\u00010\u001dH\u0016R\u0014\u0010\t\u001a\u00020\nX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0012R(\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010!\u001a\u0004\u0018\u00010\"@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u0006C"}, d2 = {"Lcom/obric/oui/push/NotificationLabel;", "Landroidx/cardview/widget/CardView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "dismissSettling", "", "getDismissSettling", "()Z", "setDismissSettling", "(Z)V", "dragCallback", "Landroidx/customview/widget/ViewDragHelper$Callback;", "dragDismissListeners", "Ljava/util/ArrayList;", "Lcom/obric/oui/push/NotificationLabel$GestureListener;", "Lkotlin/collections/ArrayList;", "interceptingEvents", "getInterceptingEvents", "setInterceptingEvents", "mOnClickListener", "Landroid/view/View$OnClickListener;", "openSettling", "getOpenSettling", "setOpenSettling", "value", "Landroid/view/ViewGroup;", "parent", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "viewDragHelper", "Landroidx/customview/widget/ViewDragHelper;", "getViewDragHelper", "()Landroidx/customview/widget/ViewDragHelper;", "setViewDragHelper", "(Landroidx/customview/widget/ViewDragHelper;)V", "addOnDragDismissListener", "", "dragDismissListener", "computeScroll", "ensureViewDragHelper", "isPointInChildBounds", "child", "Landroid/view/View;", MaterialConfigFormatNames.X, "y", "onAttachedToWindow", "onInterceptTouchEvent", "event", "Landroid/view/MotionEvent;", "onTouchEvent", "removeAllListeners", "removeAllListeners$OUI_standardRelease", "removeOnDragDismissListener", "setOnClickListener", "l", "GestureListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NotificationLabel extends CardView {
    private final String TAG;
    private boolean dismissSettling;
    private final ViewDragHelper.Callback dragCallback;
    private final ArrayList<GestureListener> dragDismissListeners;
    private boolean interceptingEvents;
    private View.OnClickListener mOnClickListener;
    private boolean openSettling;
    private ViewGroup parent;
    private ViewDragHelper viewDragHelper;

    /* JADX INFO: compiled from: NotificationLabel.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/push/NotificationLabel$GestureListener;", "", "onDragDismiss", "", "onDragOpen", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface GestureListener {
        void onDragDismiss();

        void onDragOpen();
    }

    public NotificationLabel(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public NotificationLabel(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ NotificationLabel(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ View.OnClickListener access$getMOnClickListener$p(NotificationLabel r0) {
        return r0.mOnClickListener;
    }

    public NotificationLabel(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.TAG = "NotificationLabel";
        this.dragCallback = new NotificationLabel$dragCallback$1(this);
        this.dragDismissListeners = new ArrayList();
    }

    public final String getTAG() {
        return this.TAG;
    }

    @Override // android.view.View, android.view.ViewParent
    public final ViewGroup getParent() {
        return this.parent;
    }

    public final void setParent(ViewGroup r1) {
        this.parent = r1;
        ensureViewDragHelper(r1);
    }

    public final ViewDragHelper getViewDragHelper() {
        return this.viewDragHelper;
    }

    public final void setViewDragHelper(ViewDragHelper r1) {
        this.viewDragHelper = r1;
    }

    public final boolean getDismissSettling() {
        return this.dismissSettling;
    }

    public final void setDismissSettling(boolean r1) {
        this.dismissSettling = r1;
    }

    public final boolean getOpenSettling() {
        return this.openSettling;
    }

    public final void setOpenSettling(boolean r1) {
        this.openSettling = r1;
    }

    private final void ensureViewDragHelper(ViewGroup r3) {
        if (this.viewDragHelper != null) goto L7;
        if (r3 == null) goto L8;
        this.viewDragHelper = ViewDragHelper.create(r3, 1.0f, this.dragCallback);
        return;
    L8:
        return;
    }

    public final boolean getInterceptingEvents() {
        return this.interceptingEvents;
    }

    public final void setInterceptingEvents(boolean r1) {
        this.interceptingEvents = r1;
    }

    public final boolean isPointInChildBounds(View r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "child");
        Rect r0 = new Rect();
        ViewGroupUtils.getDescendantRect(this.parent, r2, r0);
        return r0.contains(r3, r4);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        boolean r0 = this.interceptingEvents;
        int r1 = r6.getActionMasked();
        if (r1 != 0) goto L5;
        r0 = isPointInChildBounds(this, (int) r6.getX(), (int) r6.getY());
        this.interceptingEvents = r0;
        Log.i(this.TAG, Intrinsics.stringPlus("intercept: ", Boolean.valueOf(r0)));
    L11:
        if (r0 == false) goto L14;
        ensureViewDragHelper(this.parent);
        ViewDragHelper r5 = this.viewDragHelper;
        Intrinsics.checkNotNull(r5);
        return r5.shouldInterceptTouchEvent(r6);
    L14:
        return false;
    L5:
        if (r1 != 1) goto L7;
    L9:
        this.interceptingEvents = false;
        goto L11
    L7:
        if (r1 == 3) goto L9;
        goto L9
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        ViewDragHelper r1 = this.viewDragHelper;
        if (r1 == null) goto L9;
        if (r1 == null) goto L11;
        r1.processTouchEvent(r2);
        return true;
    L11:
        return true;
    L9:
        return false;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r1) {
        this.mOnClickListener = r1;
    }

    public final void addOnDragDismissListener(GestureListener r2) {
        Intrinsics.checkNotNullParameter(r2, "dragDismissListener");
        this.dragDismissListeners.add(r2);
    }

    public final void removeOnDragDismissListener(GestureListener r2) {
        Intrinsics.checkNotNullParameter(r2, "dragDismissListener");
        this.dragDismissListeners.remove(r2);
    }

    public final void removeAllListeners$OUI_standardRelease() {
        this.dragDismissListeners.clear();
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewDragHelper r0 = this.viewDragHelper;
        if (r0 == null) goto L19;
        Intrinsics.checkNotNull(r0);
        if (r0.continueSettling(true) == false) goto L7;
        Log.d(this.TAG, "scrolling");
        invalidate();
        return;
    L7:
        Log.d(this.TAG, "settled");
        if (this.dismissSettling == false) goto L14;
        this.dismissSettling = false;
        Log.i(this.TAG, "onDrag dismiss");
        Iterator<T> r2 = this.dragDismissListeners.iterator();
    L11:
        if (r2.hasNext() == false) goto L24;
        ((GestureListener) r2.next()).onDragDismiss();
        goto L11
    L24:
        return;
    L14:
        if (this.openSettling == false) goto L23;
        this.openSettling = false;
        Log.i(this.TAG, "onDrag open");
        Iterator<T> r3 = this.dragDismissListeners.iterator();
    L17:
        if (r3.hasNext() == false) goto L25;
        ((GestureListener) r3.next()).onDragOpen();
        goto L17
    L25:
        return;
    L23:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }
}
