package com.obric.oui.forms;

import android.view.MotionEvent;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H$¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\"\u0010\f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/obric/oui/forms/AbsOInput;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/widget/EditText;", "getInterEditText", "()Landroid/widget/EditText;", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "h", "Z", "isInScrollView", "()Z", "setInScrollView", "(Z)V", "", "g", "F", "lastScrollX", "f", "lastScrollY", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public abstract class AbsOInput extends ConstraintLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f10997f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f10998g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f10999h;

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r7) {
        if (r7 == null) goto L36;
        if (this.f10999h == false) goto L36;
        float r0 = r7.getX();
        float r1 = r7.getY();
        int r2 = r7.getAction();
        if (r2 != 0) goto L8;
        this.f10997f = r0;
    L34:
        this.f10997f = r1;
        goto L36
    L8:
        if (r2 != 1) goto L10;
    L32:
        super.requestDisallowInterceptTouchEvent(false);
        goto L36
    L10:
        if (r2 != 2) goto L12;
        EditText r3 = getInterEditText();
        if (r0 <= this.f10998g) goto L19;
        if (r3.canScrollHorizontally(-1) == false) goto L19;
    L30:
        super.requestDisallowInterceptTouchEvent(true);
    L31:
        this.f10998g = r0;
    L19:
        if (r0 >= this.f10998g) goto L23;
        if (r3.canScrollHorizontally(1) == true) goto L30;
    L23:
        if (r1 >= this.f10997f) goto L27;
        if (r3.canScrollVertically(1) == true) goto L30;
    L27:
        if (r1 <= this.f10997f) goto L31;
        if (r3.canScrollVertically(-1) == false) goto L31;
    L12:
        if (r2 == 3) goto L32;
    L36:
        return super.dispatchTouchEvent(r7);
    }

    protected abstract EditText getInterEditText();

    public final void setInScrollView(boolean r1) {
        this.f10999h = r1;
    }
}
