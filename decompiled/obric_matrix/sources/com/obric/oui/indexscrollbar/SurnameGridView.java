package com.obric.oui.indexscrollbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.GridView;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001bB\u001b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/obric/oui/indexscrollbar/SurnameGridView;", "Landroid/widget/GridView;", "Landroid/view/MotionEvent;", "ev", "", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "Lcom/obric/oui/indexscrollbar/SurnameGridView$a;", "listener", "Lkotlin/f0;", "setOnPressChangeListener", "(Lcom/obric/oui/indexscrollbar/SurnameGridView$a;)V", "", "g", "I", "mTouchedPosition", "f", "Lcom/obric/oui/indexscrollbar/SurnameGridView$a;", "mPressChangeListener", "h", "mPrePosition", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class SurnameGridView extends GridView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a f11071f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f11072g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f11073h;

    public interface a {
        void a(int r1);
    }

    public SurnameGridView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.f11072g = -1;
        this.f11073h = -1;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent r5) {
        o.f(r5, "ev");
        int r0 = pointToPosition((int) r5.getX(), (int) r5.getY());
        int r1 = r5.getActionMasked();
        if (r1 != 0) goto L5;
        this.f11072g = r0;
    L15:
        if (this.f11073h == r0) goto L18;
        a r2 = this.f11071f;
        o.c(r2);
        r2.a(r0);
        this.f11073h = r0;
    L18:
        return super.onTouchEvent(r5);
    L5:
        if (r1 != 1) goto L7;
    L9:
        r0 = -1;
        goto L15
    L7:
        if (r1 != 2) goto L9;
        int r3 = this.f11072g;
        if (r3 != r0) goto L9;
        r0 = r3;
        goto L15
    }

    public final void setOnPressChangeListener(a r1) {
        this.f11071f = r1;
    }
}
