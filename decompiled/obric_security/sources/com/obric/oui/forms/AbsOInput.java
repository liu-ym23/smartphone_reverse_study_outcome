package com.obric.oui.forms;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AbsOInput.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0011\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H$J6\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\n2\b\b\u0002\u0010\u0019\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\n2\b\b\u0002\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0007R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/obric/oui/forms/AbsOInput;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isInScrollView", "", "()Z", "setInScrollView", "(Z)V", "lastScrollX", "", "lastScrollY", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "getInterEditText", "Landroid/widget/EditText;", "setTextFading", "", "leftFading", "topFading", "rightFading", "bottomFading", "fadingLength", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsOInput extends ConstraintLayout {
    private boolean isInScrollView;
    private float lastScrollX;
    private float lastScrollY;

    public AbsOInput(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public AbsOInput(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    protected abstract EditText getInterEditText();

    public /* synthetic */ AbsOInput(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public AbsOInput(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public final boolean isInScrollView() {
        return this.isInScrollView;
    }

    public final void setInScrollView(boolean r1) {
        this.isInScrollView = r1;
    }

    public static /* synthetic */ void setTextFading$default(AbsOInput r7, boolean r8, boolean r9, boolean r10, boolean r11, int r12, int r13, Object r14) {
        if (r14 != null) goto L22;
        if ((r13 & 1) == 0) goto L6;
        boolean r2 = false;
    L8:
        if ((r13 & 2) == 0) goto L10;
        boolean r3 = false;
    L12:
        if ((r13 & 4) == 0) goto L14;
        boolean r4 = false;
    L16:
        if ((r13 & 8) == 0) goto L18;
        boolean r5 = false;
    L19:
        r7.setTextFading(r2, r3, r4, r5, r12);
        return;
    L18:
        r5 = r11;
        goto L19
    L14:
        r4 = r10;
        goto L16
    L10:
        r3 = r9;
        goto L12
    L6:
        r2 = r8;
        goto L8
    L22:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setTextFading");
    }

    public final void setTextFading(boolean r8, boolean r9, boolean r10, boolean r11, int r12) {
        EditText r7 = getInterEditText();
        if ((r7 instanceof OEditText) == false) goto L5;
        ((OEditText) r7).setTextFading(r8, r9, r10, r11, r12);
        return;
    L5:
        r7.setFadingEdgeLength(r12);
        boolean r13 = false;
        if (r8 == true) goto L10;
        if (r10 == true) goto L10;
        boolean r14 = false;
    L11:
        r7.setHorizontalFadingEdgeEnabled(r14);
        if (r9 == true) goto L14;
        if (r11 == true) goto L14;
    L15:
        r7.setVerticalFadingEdgeEnabled(r13);
        return;
    L14:
        r13 = true;
    L10:
        r14 = true;
        goto L11
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r7) {
        if (r7 == null) goto L36;
        if (this.isInScrollView == false) goto L36;
        float r0 = r7.getX();
        float r1 = r7.getY();
        int r2 = r7.getAction();
        if (r2 != 0) goto L8;
        this.lastScrollY = r1;
        goto L36
    L8:
        if (r2 != 1) goto L10;
        super.requestDisallowInterceptTouchEvent(false);
        goto L36
    L10:
        if (r2 != 2) goto L12;
        EditText r3 = getInterEditText();
        if (r0 <= this.lastScrollX) goto L20;
        if (r3.canScrollHorizontally(-1) == false) goto L20;
    L31:
        super.requestDisallowInterceptTouchEvent(true);
    L32:
        this.lastScrollX = r0;
        this.lastScrollY = r1;
    L20:
        if (r0 >= this.lastScrollX) goto L24;
        if (r3.canScrollHorizontally(1) == true) goto L31;
    L24:
        if (r1 >= this.lastScrollY) goto L28;
        if (r3.canScrollVertically(1) == true) goto L31;
    L28:
        if (r1 <= this.lastScrollY) goto L32;
        if (r3.canScrollVertically(-1) == false) goto L32;
    L12:
        if (r2 != 3) goto L36;
        super.requestDisallowInterceptTouchEvent(false);
    L36:
        return super.dispatchTouchEvent(r7);
    }
}
