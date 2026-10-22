package com.obric.oui.forms;

import android.text.TextWatcher;
import android.view.MotionEvent;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u00002\u00020\u0001J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R>\u0010\u001d\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014`\u00168\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0011R\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b\u0007\u0010\u0006¨\u0006$"}, d2 = {"Lcom/obric/oui/forms/AbsOForm;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "b", "Lkotlin/f0;", "setInScrollView1", "(Z)V", "setInScrollView", "Landroid/widget/EditText;", "getInterEditText", "()Landroid/widget/EditText;", "Landroid/view/MotionEvent;", "ev", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "", "g", "F", "lastScrollY", "Ljava/util/ArrayList;", "Ljava/lang/ref/WeakReference;", "Landroid/text/TextWatcher;", "Lkotlin/collections/ArrayList;", "f", "Ljava/util/ArrayList;", "getTextWatchers", "()Ljava/util/ArrayList;", "setTextWatchers", "(Ljava/util/ArrayList;)V", "textWatchers", "h", "lastScrollX", "i", "Z", "isInScrollView", "()Z", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public abstract class AbsOForm extends ConstraintLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ArrayList<WeakReference<TextWatcher>> f10993f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f10994g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f10995h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f10996i;

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r7) {
        if (r7 == null) goto L36;
        if (this.f10996i == false) goto L36;
        float r0 = r7.getX();
        float r1 = r7.getY();
        int r2 = r7.getAction();
        if (r2 != 0) goto L8;
        this.f10994g = r0;
    L34:
        this.f10994g = r1;
        goto L36
    L8:
        if (r2 != 1) goto L10;
    L32:
        super.requestDisallowInterceptTouchEvent(false);
        goto L36
    L10:
        if (r2 != 2) goto L12;
        EditText r3 = getInterEditText();
        o.c(r3);
        if (r0 <= this.f10995h) goto L19;
        if (r3.canScrollHorizontally(-1) == false) goto L19;
    L30:
        super.requestDisallowInterceptTouchEvent(true);
    L31:
        this.f10995h = r0;
    L19:
        if (r0 >= this.f10995h) goto L23;
        if (r3.canScrollHorizontally(1) == true) goto L30;
    L23:
        if (r1 >= this.f10994g) goto L27;
        if (r3.canScrollVertically(1) == true) goto L30;
    L27:
        if (r1 <= this.f10994g) goto L31;
        if (r3.canScrollVertically(-1) == false) goto L31;
    L12:
        if (r2 == 3) goto L32;
    L36:
        return super.dispatchTouchEvent(r7);
    }

    public abstract EditText getInterEditText();

    protected final ArrayList<WeakReference<TextWatcher>> getTextWatchers() {
        return this.f10993f;
    }

    public final void setInScrollView(boolean r1) {
        this.f10996i = r1;
    }

    public final void setInScrollView1(boolean r1) {
        this.f10996i = r1;
    }

    protected final void setTextWatchers(ArrayList<WeakReference<TextWatcher>> r2) {
        o.f(r2, "<set-?>");
        this.f10993f = r2;
    }
}
