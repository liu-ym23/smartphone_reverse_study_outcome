package com.obric.oui.panel;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.securityserver.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class BottomSheetDialog extends AppCompatDialog {
    public BottomSheetBehavior b;
    public FrameLayout c;
    public FrameLayout e;
    public boolean f;
    public boolean i;
    public boolean j;
    public boolean k;
    public final ArrayList l;
    public final BottomSheetBehavior.BottomSheetCallback m;

    /* JADX INFO: renamed from: com.obric.oui.panel.BottomSheetDialog$4, reason: invalid class name */
    class AnonymousClass4 implements View.OnTouchListener {
        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r1, MotionEvent r2) {
            return true;
        }
    }

    public BottomSheetDialog(Context r4, int r5) {
        if (r5 != 0) goto L7;
        TypedValue r6 = new TypedValue();
        if (r4.getTheme().resolveAttribute(R.attr.bottomSheetDialogTheme, r6, true) == false) goto L6;
        r5 = r6.resourceId;
        goto L7
    L6:
        r5 = R.style.Theme_Design_Light_BottomSheetDialog;
    L7:
        super(r4, r5);
        this.f = true;
        this.i = true;
        this.k = false;
        this.l = new ArrayList();
        final OBasePanelDialog r0 = (OBasePanelDialog) this;
        this.m = new AnonymousClass5(r0);
        supportRequestWindowFeature(1);
    }

    public final void a() {
        if (this.c != null) goto L16;
        FrameLayout r0 = (FrameLayout) View.inflate(getContext(), R.layout.o_bottom_sheet_dialog, null);
        this.c = r0;
        CoordinatorLayout r1 = (CoordinatorLayout) r0.findViewById(R.id.coordinator);
        FrameLayout r2 = (FrameLayout) this.c.findViewById(R.id.design_bottom_sheet);
        this.e = r2;
        r2.setAccessibilityPaneTitle("");
        ViewGroup.LayoutParams r3 = this.e.getLayoutParams();
        if ((r3 instanceof CoordinatorLayout.LayoutParams) == false) goto L15;
        CoordinatorLayout.Behavior r4 = ((CoordinatorLayout.LayoutParams) r3).getBehavior();
        if ((r4 instanceof BottomSheetBehavior) == false) goto L13;
        BottomSheetBehavior r5 = (BottomSheetBehavior) r4;
        this.b = r5;
        BottomSheetBehavior.BottomSheetCallback r6 = this.m;
        r5.getClass();
        Log.w("BottomSheetBehavior", "BottomSheetBehavior now supports multiple callbacks. `setBottomSheetCallback()` removes all existing callbacks, including ones set internally by library authors, which may result in unintended behavior. This may change in the future. Please use `addBottomSheetCallback()` and `removeBottomSheetCallback()` instead to set your own callbacks.");
        ArrayList r7 = r5.y;
        r7.clear();
        if (r6 == null) goto L11;
        r7.add(r6);
    L11:
        BottomSheetBehavior r8 = this.b;
        r8.l = this.f;
        return;
    L13:
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    L15:
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    public final BottomSheetBehavior b() {
        if (this.b != null) goto L6;
        a();
    L6:
        return this.b;
    }

    public final FrameLayout c(int r3, View r4, ViewGroup.LayoutParams r5) {
        a();
        CoordinatorLayout r0 = (CoordinatorLayout) this.c.findViewById(R.id.coordinator);
        if (r3 == 0) goto L6;
        if (r4 != null) goto L6;
        r4 = getLayoutInflater().inflate(r3, r0, false);
    L6:
        this.e.removeAllViews();
        if (this.k == false) goto L10;
        if (r5 != null) goto L10;
        r5 = new FrameLayout.LayoutParams(-1, -1);
    L10:
        if (r5 != null) goto L12;
        this.e.addView(r4);
    L13:
        r0.findViewById(R.id.touch_outside).setOnClickListener(new AnonymousClass1(this));
        r0.findViewById(R.id.touch_outside).setAccessibilityDelegate(new AnonymousClass2(this));
        ViewCompat.setAccessibilityDelegate(this.e, new AnonymousClass3(this));
        this.e.setOnTouchListener(new AnonymousClass4());
        return this.c;
    L12:
        this.e.addView(r4, r5);
        goto L13
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void cancel() {
        b();
        super.cancel();
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle r1) {
        super.onCreate(r1);
        Window r0 = getWindow();
        if (r0 == null) goto L6;
        r0.setStatusBarColor(0);
        r0.addFlags(Integer.MIN_VALUE);
        r0.setLayout(-1, -1);
        return;
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        BottomSheetBehavior r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.o == 5) goto L7;
        return;
    L7:
        if (this.k == false) goto L9;
        r0.setState(4);
        return;
    L9:
        r0.setState(3);
    }

    @Override // android.app.Dialog
    public final void setCancelable(boolean r2) {
        super.setCancelable(r2);
        if (this.f == r2) goto L8;
        this.f = r2;
        BottomSheetBehavior r1 = this.b;
        if (r1 == null) goto L9;
        r1.l = r2;
        return;
    L9:
        return;
    }

    @Override // android.app.Dialog
    public final void setCanceledOnTouchOutside(boolean r3) {
        super.setCanceledOnTouchOutside(r3);
        if (r3 == true) goto L5;
    L7:
        this.i = r3;
        this.j = true;
        return;
    L5:
        if (this.f == true) goto L7;
        this.f = true;
        goto L7
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(int r2) {
        super.setContentView(c(r2, null, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(View r3) {
        super.setContentView(c(0, r3, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(View r2, ViewGroup.LayoutParams r3) {
        super.setContentView(c(0, r2, r3));
    }
}
