package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes.dex */
public class BottomSheetDialog extends AppCompatDialog {
    private BottomSheetBehavior<FrameLayout> behavior;

    @NonNull
    private BottomSheetBehavior.BottomSheetCallback bottomSheetCallback;
    boolean cancelable;
    private boolean canceledOnTouchOutside;
    private boolean canceledOnTouchOutsideSet;
    private FrameLayout container;
    boolean dismissWithAnimation;

    public BottomSheetDialog(@NonNull Context r2) {
        this(r2, 0);
    }

    private FrameLayout ensureContainerAndBehavior() {
        if (this.container != null) goto L6;
        FrameLayout r0 = (FrameLayout) View.inflate(getContext(), R.layout.design_bottom_sheet_dialog, null);
        this.container = r0;
        BottomSheetBehavior<FrameLayout> r1 = BottomSheetBehavior.from((FrameLayout) r0.findViewById(R.id.design_bottom_sheet));
        this.behavior = r1;
        r1.addBottomSheetCallback(this.bottomSheetCallback);
        this.behavior.setHideable(this.cancelable);
    L6:
        return this.container;
    }

    private static int getThemeResId(@NonNull Context r2, int r3) {
        if (r3 != 0) goto L8;
        TypedValue r4 = new TypedValue();
        if (r2.getTheme().resolveAttribute(R.attr.bottomSheetDialogTheme, r4, true) == false) goto L7;
        return r4.resourceId;
    L7:
        return R.style.Theme_Design_Light_BottomSheetDialog;
    L8:
        return r3;
    }

    private View wrapInBottomSheet(int r3, @Nullable View r4, @Nullable ViewGroup.LayoutParams r5) {
        ensureContainerAndBehavior();
        CoordinatorLayout r0 = (CoordinatorLayout) this.container.findViewById(R.id.coordinator);
        if (r3 == 0) goto L6;
        if (r4 != null) goto L6;
        r4 = getLayoutInflater().inflate(r3, r0, false);
    L6:
        FrameLayout r6 = (FrameLayout) this.container.findViewById(R.id.design_bottom_sheet);
        r6.removeAllViews();
        if (r5 != null) goto L9;
        r6.addView(r4);
    L10:
        r0.findViewById(R.id.touch_outside).setOnClickListener(new AnonymousClass1(this));
        ViewCompat.setAccessibilityDelegate(r6, new AnonymousClass2(this));
        r6.setOnTouchListener(new AnonymousClass3(this));
        return this.container;
    L9:
        r6.addView(r4, r5);
        goto L10
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        BottomSheetBehavior<FrameLayout> r0 = getBehavior();
        if (this.dismissWithAnimation == true) goto L5;
    L8:
        super.cancel();
        return;
    L5:
        if (r0.getState() == 5) goto L8;
        r0.setState(5);
    }

    @NonNull
    public BottomSheetBehavior<FrameLayout> getBehavior() {
        if (this.behavior != null) goto L6;
        ensureContainerAndBehavior();
    L6:
        return this.behavior;
    }

    public boolean getDismissWithAnimation() {
        return this.dismissWithAnimation;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle r1) {
        super.onCreate(r1);
        Window r0 = getWindow();
        if (r0 == null) goto L6;
        r0.clearFlags(67108864);
        r0.addFlags(Integer.MIN_VALUE);
        r0.setLayout(-1, -1);
        return;
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> r0 = this.behavior;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getState() != 5) goto L9;
        this.behavior.setState(4);
        return;
    }

    public void removeDefaultCallback() {
        this.behavior.removeBottomSheetCallback(this.bottomSheetCallback);
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean r2) {
        super.setCancelable(r2);
        if (this.cancelable == r2) goto L8;
        this.cancelable = r2;
        BottomSheetBehavior<FrameLayout> r1 = this.behavior;
        if (r1 == null) goto L9;
        r1.setHideable(r2);
        return;
    L9:
        return;
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean r3) {
        super.setCanceledOnTouchOutside(r3);
        if (r3 == true) goto L5;
    L7:
        this.canceledOnTouchOutside = r3;
        this.canceledOnTouchOutsideSet = true;
        return;
    L5:
        if (this.cancelable == true) goto L7;
        this.cancelable = true;
        goto L7
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(@LayoutRes int r2) {
        super.setContentView(wrapInBottomSheet(r2, null, null));
    }

    public void setDismissWithAnimation(boolean r1) {
        this.dismissWithAnimation = r1;
    }

    public boolean shouldWindowCloseOnTouchOutside() {
        if (this.canceledOnTouchOutsideSet == true) goto L6;
        TypedArray r0 = getContext().obtainStyledAttributes(new int[]{android.R.attr.windowCloseOnTouchOutside});
        this.canceledOnTouchOutside = r0.getBoolean(0, true);
        r0.recycle();
        this.canceledOnTouchOutsideSet = true;
    L6:
        return this.canceledOnTouchOutside;
    }

    public BottomSheetDialog(@NonNull Context r1, @StyleRes int r2) {
        super(r1, getThemeResId(r1, r2));
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new AnonymousClass4(this);
        supportRequestWindowFeature(1);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(View r3) {
        super.setContentView(wrapInBottomSheet(0, r3, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(View r2, ViewGroup.LayoutParams r3) {
        super.setContentView(wrapInBottomSheet(0, r2, r3));
    }

    public BottomSheetDialog(@NonNull Context r1, boolean r2, DialogInterface.OnCancelListener r3) {
        super(r1, r2, r3);
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new AnonymousClass4(this);
        supportRequestWindowFeature(1);
        this.cancelable = r2;
    }
}
