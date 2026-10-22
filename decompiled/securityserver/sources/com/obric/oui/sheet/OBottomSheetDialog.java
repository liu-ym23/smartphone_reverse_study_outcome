package com.obric.oui.sheet;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.securityserver.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.obric.oui.common.util.OUnitExtensionKt;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class OBottomSheetDialog extends AppCompatDialog {
    public BottomSheetBehavior b;
    public FrameLayout c;
    public FrameLayout e;
    public boolean f;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public final BottomSheetBehavior.BottomSheetCallback m;

    /* JADX INFO: renamed from: com.obric.oui.sheet.OBottomSheetDialog$4, reason: invalid class name */
    class AnonymousClass4 implements View.OnTouchListener {
        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r1, MotionEvent r2) {
            return true;
        }
    }

    public OBottomSheetDialog(Context r2) {
        super(r2, R.style.AppBottomSheetDialogTheme);
        this.i = true;
        this.j = true;
        this.l = false;
        this.m = new AnonymousClass5(this);
        supportRequestWindowFeature(1);
    }

    public final void a() {
        if (this.c != null) goto L8;
        FrameLayout r0 = (FrameLayout) View.inflate(getContext(), com.google.android.material.R.layout.design_bottom_sheet_dialog, null);
        this.c = r0;
        CoordinatorLayout r1 = (CoordinatorLayout) r0.findViewById(com.google.android.material.R.id.coordinator);
        FrameLayout r2 = (FrameLayout) this.c.findViewById(com.google.android.material.R.id.design_bottom_sheet);
        this.e = r2;
        r2.setAccessibilityPaneTitle("");
        BottomSheetBehavior r3 = BottomSheetBehavior.from(this.e);
        this.b = r3;
        r3.setBottomSheetCallback(this.m);
        this.b.setHideable(this.i);
        if (this.l == false) goto L9;
        this.b.setPeekHeight((int) (OUnitExtensionKt.b(getContext()) * 0.75f));
        return;
    L9:
        return;
    }

    public final FrameLayout b(int r3, View r4, ViewGroup.LayoutParams r5) {
        a();
        CoordinatorLayout r0 = (CoordinatorLayout) this.c.findViewById(com.google.android.material.R.id.coordinator);
        if (r3 == 0) goto L6;
        if (r4 != null) goto L6;
        r4 = getLayoutInflater().inflate(r3, r0, false);
    L6:
        this.e.removeAllViews();
        if (this.l == false) goto L10;
        if (r5 != null) goto L10;
        r5 = new FrameLayout.LayoutParams(-1, -1);
    L10:
        if (r5 != null) goto L12;
        this.e.addView(r4);
    L13:
        r0.findViewById(com.google.android.material.R.id.touch_outside).setOnClickListener(new AnonymousClass1(this));
        r0.findViewById(com.google.android.material.R.id.touch_outside).setAccessibilityDelegate(new AnonymousClass2(this));
        ViewCompat.setAccessibilityDelegate(this.e, new AnonymousClass3(this));
        this.e.setOnTouchListener(new AnonymousClass4());
        return this.c;
    L12:
        this.e.addView(r4, r5);
        goto L13
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void cancel() {
        if (this.b != null) goto L5;
        a();
    L5:
        BottomSheetBehavior r0 = this.b;
        if (this.f == true) goto L8;
    L11:
        super.cancel();
        return;
    L8:
        if (r0.getState() == 5) goto L11;
        r0.setState(5);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        Window r0 = getWindow();
        if (r0 == null) goto L6;
        r0.setStatusBarColor(0);
        r0.addFlags(Integer.MIN_VALUE);
        r0.setLayout(-1, -1);
        return;
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        BottomSheetBehavior r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getState() != 5) goto L9;
        this.b.setState(4);
        return;
    }

    @Override // android.app.Dialog
    public final void setCancelable(boolean r2) {
        super.setCancelable(r2);
        if (this.i == r2) goto L8;
        this.i = r2;
        BottomSheetBehavior r1 = this.b;
        if (r1 == null) goto L9;
        r1.setHideable(r2);
        return;
    L9:
        return;
    }

    @Override // android.app.Dialog
    public final void setCanceledOnTouchOutside(boolean r3) {
        super.setCanceledOnTouchOutside(r3);
        if (r3 == true) goto L5;
    L7:
        this.j = r3;
        this.k = true;
        return;
    L5:
        if (this.i == true) goto L7;
        this.i = true;
        goto L7
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void setContentView(int r2) {
        super.setContentView(b(r2, null, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void setContentView(View r3) {
        super.setContentView(b(0, r3, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void setContentView(View r2, ViewGroup.LayoutParams r3) {
        super.setContentView(b(0, r2, r3));
    }
}
