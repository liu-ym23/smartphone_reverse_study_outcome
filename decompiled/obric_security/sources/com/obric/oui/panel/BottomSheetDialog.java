package com.obric.oui.panel;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.obric.common.oui.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class BottomSheetDialog extends AppCompatDialog {
    private BottomSheetBehavior<FrameLayout> behavior;
    private FrameLayout bottomSheet;
    private BottomSheetBehavior.BottomSheetCallback bottomSheetCallback;
    private final List<BottomSheetBehavior.BottomSheetCallback> callbacks;
    boolean cancelable;
    private boolean canceledOnTouchOutside;
    private boolean canceledOnTouchOutsideSet;
    private FrameLayout container;
    private CoordinatorLayout coordinator;
    boolean dismissWithAnimation;
    private boolean is69Expandable;

    public boolean isPadCompatEnabled() {
        return false;
    }

    static /* synthetic */ List access$000(BottomSheetDialog r0) {
        return r0.callbacks;
    }

    public BottomSheetDialog(Context r2) {
        this(r2, 0);
    }

    public BottomSheetDialog(Context r1, int r2) {
        super(r1, getThemeResId(r1, r2));
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.is69Expandable = false;
        this.callbacks = new ArrayList();
        this.bottomSheetCallback = new AnonymousClass5(this);
        supportRequestWindowFeature(1);
    }

    protected BottomSheetDialog(Context r1, boolean r2, DialogInterface.OnCancelListener r3) {
        super(r1, r2, r3);
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.is69Expandable = false;
        this.callbacks = new ArrayList();
        this.bottomSheetCallback = new AnonymousClass5(this);
        supportRequestWindowFeature(1);
        this.cancelable = r2;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(int r2) {
        super.setContentView(wrapInBottomSheet(r2, null, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    protected void onCreate(Bundle r1) {
        super.onCreate(r1);
        Window r0 = getWindow();
        if (r0 == null) goto L6;
        r0.setStatusBarColor(0);
        r0.addFlags(Integer.MIN_VALUE);
        r0.setLayout(-1, -1);
        return;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View r3) {
        super.setContentView(wrapInBottomSheet(0, r3, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View r2, ViewGroup.LayoutParams r3) {
        super.setContentView(wrapInBottomSheet(0, r2, r3));
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

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    protected void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> r0 = this.behavior;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getState() == 5) goto L7;
        return;
    L7:
        if (this.is69Expandable == false) goto L9;
        this.behavior.setState(4);
        return;
    L9:
        this.behavior.setState(3);
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

    public BottomSheetBehavior<FrameLayout> getBehavior() {
        if (this.behavior != null) goto L6;
        ensureContainerAndBehavior();
    L6:
        return this.behavior;
    }

    public void setDismissWithAnimation(boolean r1) {
        this.dismissWithAnimation = r1;
    }

    public boolean getDismissWithAnimation() {
        return this.dismissWithAnimation;
    }

    public boolean getIs69Expandable() {
        return this.is69Expandable;
    }

    public void setIs69Expandable(boolean r1) {
        this.is69Expandable = r1;
    }

    private FrameLayout ensureContainerAndBehavior() {
        if (this.container != null) goto L6;
        FrameLayout r0 = (FrameLayout) View.inflate(getContext(), R.layout.o_bottom_sheet_dialog, null);
        this.container = r0;
        this.coordinator = (CoordinatorLayout) r0.findViewById(R.id.coordinator);
        this.bottomSheet = (FrameLayout) this.container.findViewById(R.id.design_bottom_sheet);
        this.bottomSheet.setAccessibilityPaneTitle("");
        BottomSheetBehavior<FrameLayout> r1 = BottomSheetBehavior.from(this.bottomSheet);
        this.behavior = r1;
        r1.setBottomSheetCallback(this.bottomSheetCallback);
        this.behavior.setHideable(this.cancelable);
    L6:
        return this.container;
    }

    private View wrapInBottomSheet(int r3, View r4, ViewGroup.LayoutParams r5) {
        ensureContainerAndBehavior();
        CoordinatorLayout r0 = (CoordinatorLayout) this.container.findViewById(R.id.coordinator);
        if (r3 == 0) goto L6;
        if (r4 != null) goto L6;
        r4 = getLayoutInflater().inflate(r3, r0, false);
    L6:
        this.bottomSheet.removeAllViews();
        if (this.is69Expandable == false) goto L10;
        if (r5 != null) goto L10;
        r5 = new FrameLayout.LayoutParams(-1, -1);
    L10:
        if (r5 != null) goto L12;
        this.bottomSheet.addView(r4);
    L13:
        r0.findViewById(R.id.touch_outside).setOnClickListener(new AnonymousClass1(this));
        r0.findViewById(R.id.touch_outside).setAccessibilityDelegate(new AnonymousClass2(this));
        ViewCompat.setAccessibilityDelegate(this.bottomSheet, new AnonymousClass3(this));
        this.bottomSheet.setOnTouchListener(new AnonymousClass4(this));
        return this.container;
    L12:
        this.bottomSheet.addView(r4, r5);
        goto L13
    }

    boolean shouldWindowCloseOnTouchOutside() {
        if (this.canceledOnTouchOutsideSet == true) goto L6;
        TypedArray r0 = getContext().obtainStyledAttributes(new int[]{android.R.attr.windowCloseOnTouchOutside});
        this.canceledOnTouchOutside = r0.getBoolean(0, true);
        r0.recycle();
        this.canceledOnTouchOutsideSet = true;
    L6:
        return this.canceledOnTouchOutside;
    }

    private static int getThemeResId(Context r2, int r3) {
        if (r3 != 0) goto L8;
        TypedValue r4 = new TypedValue();
        if (r2.getTheme().resolveAttribute(R.attr.bottomSheetDialogTheme, r4, true) == false) goto L7;
        return r4.resourceId;
    L7:
        return R.style.Theme_Design_Light_BottomSheetDialog;
    L8:
        return r3;
    }

    void removeDefaultCallback() {
        this.behavior.removeBottomSheetCallback(this.bottomSheetCallback);
    }

    public FrameLayout getBottomSheet() {
        if (this.bottomSheet != null) goto L6;
        ensureContainerAndBehavior();
    L6:
        return this.bottomSheet;
    }

    public void setBottomSheetCallback(BottomSheetBehavior.BottomSheetCallback r1) {
        this.callbacks.add(r1);
    }

    public void addBottomSheetCallback(BottomSheetBehavior.BottomSheetCallback r1) {
        this.callbacks.add(r1);
    }

    public void removeBottomSheetCallback(BottomSheetBehavior.BottomSheetCallback r1) {
        this.callbacks.remove(r1);
    }

    public void clearBottomSheetCallback() {
        this.callbacks.clear();
    }

    public void adaptPortraitRLSlide(boolean r1) {
        getBehavior().setAdaptPortraitRLSlide(r1);
    }
}
