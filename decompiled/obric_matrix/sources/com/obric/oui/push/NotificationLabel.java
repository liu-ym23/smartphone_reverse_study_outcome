package com.obric.oui.push;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.ViewGroupUtils;
import androidx.core.app.NotificationCompat;
import androidx.customview.widget.ViewDragHelper;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001QB'\b\u0007\u0012\u0006\u0010K\u001a\u00020J\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010L\u0012\b\b\u0002\u0010N\u001a\u00020\t¢\u0006\u0004\bO\u0010PJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u0019\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u001a\u0010\u0019R$\u0010\"\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010(\u001a\u00020#8\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\"\u0010/\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00103\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010*\u001a\u0004\b1\u0010,\"\u0004\b2\u0010.R.\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u00104\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010\u0006R\u0016\u0010<\u001a\u00020:8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010;R&\u0010B\u001a\u0012\u0012\u0004\u0012\u00020>0=j\b\u0012\u0004\u0012\u00020>`?8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010E\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\"\u0010I\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010*\u001a\u0004\bG\u0010,\"\u0004\bH\u0010.¨\u0006R"}, d2 = {"Lcom/obric/oui/push/NotificationLabel;", "Landroidx/cardview/widget/CardView;", "Landroid/view/ViewGroup;", "parent", "Lkotlin/f0;", "b", "(Landroid/view/ViewGroup;)V", "Landroid/view/View;", "child", "", "x", "y", "", "c", "(Landroid/view/View;II)Z", "Landroid/view/MotionEvent;", NotificationCompat.CATEGORY_EVENT, "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "onTouchEvent", "Landroid/view/View$OnClickListener;", "l", "setOnClickListener", "(Landroid/view/View$OnClickListener;)V", "computeScroll", "()V", "onAttachedToWindow", "Landroidx/customview/widget/ViewDragHelper;", "h", "Landroidx/customview/widget/ViewDragHelper;", "getViewDragHelper", "()Landroidx/customview/widget/ViewDragHelper;", "setViewDragHelper", "(Landroidx/customview/widget/ViewDragHelper;)V", "viewDragHelper", "", "f", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "i", "Z", "getDismissSettling", "()Z", "setDismissSettling", "(Z)V", "dismissSettling", "j", "getOpenSettling", "setOpenSettling", "openSettling", "value", "g", "Landroid/view/ViewGroup;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "Landroidx/customview/widget/ViewDragHelper$Callback;", "Landroidx/customview/widget/ViewDragHelper$Callback;", "dragCallback", "Ljava/util/ArrayList;", "Lcom/obric/oui/push/NotificationLabel$a;", "Lkotlin/collections/ArrayList;", "n", "Ljava/util/ArrayList;", "dragDismissListeners", "k", "Landroid/view/View$OnClickListener;", "mOnClickListener", "m", "getInterceptingEvents", "setInterceptingEvents", "interceptingEvents", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class NotificationLabel extends CardView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f11315f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ViewGroup f11316g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ViewDragHelper f11317h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f11318i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f11319j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private View.OnClickListener f11320k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final ViewDragHelper.Callback f11321l;
    private boolean m;
    private final ArrayList<a> n;

    public interface a {
        void a();

        void b();
    }

    public NotificationLabel(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    public NotificationLabel(Context r2, AttributeSet r3, int r4) {
        o.f(r2, "context");
        super(r2, r3, r4);
        this.f11315f = "NotificationLabel";
        this.f11321l = new NotificationLabel$dragCallback$1(this);
        this.n = new ArrayList();
    }

    public /* synthetic */ NotificationLabel(Context r1, AttributeSet r2, int r3, int r4, g r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ View.OnClickListener a(NotificationLabel r0) {
        return r0.f11320k;
    }

    private final void b(ViewGroup r3) {
        if (this.f11317h != null) goto L7;
        if (r3 == null) goto L8;
        this.f11317h = ViewDragHelper.create(r3, 1.0f, this.f11321l);
        return;
    L8:
        return;
    }

    @SuppressLint({"RestrictedApi"})
    public final boolean c(View r2, int r3, int r4) {
        o.f(r2, "child");
        Rect r0 = new Rect();
        ViewGroupUtils.getDescendantRect(this.f11316g, r2, r0);
        return r0.contains(r3, r4);
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewDragHelper r0 = this.f11317h;
        if (r0 == null) goto L19;
        o.c(r0);
        if (r0.continueSettling(true) == false) goto L7;
        Log.d(this.f11315f, "scrolling");
        invalidate();
        return;
    L7:
        Log.d(this.f11315f, "settled");
        if (this.f11318i == false) goto L14;
        this.f11318i = false;
        Log.i(this.f11315f, "onDrag dismiss");
        Iterator<T> r2 = this.n.iterator();
    L11:
        if (r2.hasNext() == false) goto L24;
        ((a) r2.next()).a();
        goto L11
    L24:
        return;
    L14:
        if (this.f11319j == false) goto L23;
        this.f11319j = false;
        Log.i(this.f11315f, "onDrag open");
        Iterator<T> r3 = this.n.iterator();
    L17:
        if (r3.hasNext() == false) goto L25;
        ((a) r3.next()).b();
        goto L17
    L25:
        return;
    L23:
        return;
    }

    public final boolean getDismissSettling() {
        return this.f11318i;
    }

    public final boolean getInterceptingEvents() {
        return this.m;
    }

    public final boolean getOpenSettling() {
        return this.f11319j;
    }

    @Override // android.view.View, android.view.ViewParent
    public final ViewGroup getParent() {
        return this.f11316g;
    }

    public final String getTAG() {
        return this.f11315f;
    }

    public final ViewDragHelper getViewDragHelper() {
        return this.f11317h;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r6) {
        o.f(r6, NotificationCompat.CATEGORY_EVENT);
        boolean r0 = this.m;
        int r1 = r6.getActionMasked();
        if (r1 != 0) goto L5;
        r0 = c(this, (int) r6.getX(), (int) r6.getY());
        this.m = r0;
        Log.i(this.f11315f, "intercept: " + this.m);
    L11:
        if (r0 == false) goto L14;
        b(this.f11316g);
        ViewDragHelper r5 = this.f11317h;
        o.c(r5);
        return r5.shouldInterceptTouchEvent(r6);
    L14:
        return false;
    L5:
        if (r1 != 1) goto L7;
    L9:
        this.m = false;
        goto L11
    L7:
        if (r1 == 3) goto L9;
        goto L9
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r2) {
        o.f(r2, NotificationCompat.CATEGORY_EVENT);
        ViewDragHelper r1 = this.f11317h;
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
        this.f11318i = r1;
    }

    public final void setInterceptingEvents(boolean r1) {
        this.m = r1;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r1) {
        this.f11320k = r1;
    }

    public final void setOpenSettling(boolean r1) {
        this.f11319j = r1;
    }

    public final void setParent(ViewGroup r1) {
        this.f11316g = r1;
        b(r1);
    }

    public final void setViewDragHelper(ViewDragHelper r1) {
        this.f11317h = r1;
    }
}
