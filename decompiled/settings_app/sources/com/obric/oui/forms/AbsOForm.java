package com.obric.oui.forms;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AbsOForm.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u001a\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH&J\u0015\u0010\f\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\nH\u0007¢\u0006\u0002\b!J6\u0010\"\u001a\u00020\u001f2\b\b\u0002\u0010#\u001a\u00020\n2\b\b\u0002\u0010$\u001a\u00020\n2\b\b\u0002\u0010%\u001a\u00020\n2\b\b\u0002\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u0007R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R6\u0010\u0011\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0012j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013`\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006("}, d2 = {"Lcom/obric/oui/forms/AbsOForm;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isInScrollView", "", "()Z", "setInScrollView", "(Z)V", "lastScrollX", "", "lastScrollY", "textWatchers", "Ljava/util/ArrayList;", "Ljava/lang/ref/WeakReference;", "Landroid/text/TextWatcher;", "Lkotlin/collections/ArrayList;", "getTextWatchers", "()Ljava/util/ArrayList;", "setTextWatchers", "(Ljava/util/ArrayList;)V", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "getInterEditText", "Landroid/widget/EditText;", "", "b", "setInScrollView1", "setTextFading", "leftFading", "topFading", "rightFading", "bottomFading", "fadingLength", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsOForm extends ConstraintLayout {
    private boolean isInScrollView;
    private float lastScrollX;
    private float lastScrollY;
    private ArrayList<WeakReference<TextWatcher>> textWatchers;

    public AbsOForm(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public AbsOForm(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public abstract EditText getInterEditText();

    public /* synthetic */ AbsOForm(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public AbsOForm(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.textWatchers = new ArrayList();
    }

    protected final ArrayList<WeakReference<TextWatcher>> getTextWatchers() {
        return this.textWatchers;
    }

    protected final void setTextWatchers(ArrayList<WeakReference<TextWatcher>> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.textWatchers = r2;
    }

    public final boolean isInScrollView() {
        return this.isInScrollView;
    }

    public final void setInScrollView(boolean r1) {
        this.isInScrollView = r1;
    }

    public final void setInScrollView1(boolean r1) {
        this.isInScrollView = r1;
    }

    public static /* synthetic */ void setTextFading$default(AbsOForm r7, boolean r8, boolean r9, boolean r10, boolean r11, int r12, int r13, Object r14) {
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
        if ((r7 instanceof OFormEditText) == false) goto L6;
        ((OFormEditText) r7).setTextFading(r8, r9, r10, r11, r12);
        return;
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
        Intrinsics.checkNotNull(r3);
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
