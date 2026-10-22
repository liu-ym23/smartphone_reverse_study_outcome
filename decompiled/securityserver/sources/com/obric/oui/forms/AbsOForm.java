package com.obric.oui.forms;

import android.text.TextWatcher;
import android.view.MotionEvent;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class AbsOForm extends ConstraintLayout {
    public ArrayList b;
    public float c;
    public float e;
    public boolean f;

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r7) {
        if (r7 == null) goto L36;
        if (this.f == false) goto L36;
        float r0 = r7.getX();
        float r1 = r7.getY();
        int r2 = r7.getAction();
        if (r2 != 0) goto L8;
        this.c = r1;
        goto L36
    L8:
        if (r2 != 1) goto L10;
        super.requestDisallowInterceptTouchEvent(false);
        goto L36
    L10:
        if (r2 != 2) goto L12;
        EditText r3 = getInterEditText();
        Intrinsics.c(r3);
        if (r0 <= this.e) goto L20;
        if (r3.canScrollHorizontally(-1) == false) goto L20;
    L31:
        super.requestDisallowInterceptTouchEvent(true);
    L32:
        this.e = r0;
        this.c = r1;
    L20:
        if (r0 >= this.e) goto L24;
        if (r3.canScrollHorizontally(1) == true) goto L31;
    L24:
        if (r1 >= this.c) goto L28;
        if (r3.canScrollVertically(1) == true) goto L31;
    L28:
        if (r1 <= this.c) goto L32;
        if (r3.canScrollVertically(-1) == false) goto L32;
    L12:
        if (r2 != 3) goto L36;
        super.requestDisallowInterceptTouchEvent(false);
    L36:
        return super.dispatchTouchEvent(r7);
    }

    @NotNull
    public abstract EditText getInterEditText();

    @NotNull
    public final ArrayList<WeakReference<TextWatcher>> getTextWatchers() {
        return this.b;
    }

    public final void setInScrollView(boolean r1) {
        this.f = r1;
    }

    @JvmName
    public final void setInScrollView1(boolean r1) {
        this.f = r1;
    }

    public final void setTextWatchers(@NotNull ArrayList<WeakReference<TextWatcher>> r2) {
        Intrinsics.f(r2, "<set-?>");
        this.b = r2;
    }
}
