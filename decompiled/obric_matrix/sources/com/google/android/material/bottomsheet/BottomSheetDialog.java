package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
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
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.shape.MaterialShapeDrawable;

/* JADX INFO: loaded from: classes2.dex */
public class BottomSheetDialog extends AppCompatDialog {
    private BottomSheetBehavior<FrameLayout> behavior;
    private FrameLayout bottomSheet;

    @NonNull
    private BottomSheetBehavior.BottomSheetCallback bottomSheetCallback;
    boolean cancelable;
    private boolean canceledOnTouchOutside;
    private boolean canceledOnTouchOutsideSet;
    private FrameLayout container;
    private CoordinatorLayout coordinator;
    boolean dismissWithAnimation;
    private BottomSheetBehavior.BottomSheetCallback edgeToEdgeCallback;
    private boolean edgeToEdgeEnabled;

    private static class EdgeToEdgeCallback extends BottomSheetBehavior.BottomSheetCallback {
        private final WindowInsetsCompat insetsCompat;
        private final boolean lightBottomSheet;
        private final boolean lightStatusBar;

        private EdgeToEdgeCallback(@NonNull View r2, @NonNull WindowInsetsCompat r3) {
            this.insetsCompat = r3;
            if (Build.VERSION.SDK_INT >= 23) goto L5;
        L7:
            boolean r4 = false;
        L8:
            this.lightStatusBar = r4;
            MaterialShapeDrawable r0 = BottomSheetBehavior.from(r2).getMaterialShapeDrawable();
            if (r0 == null) goto L11;
            ColorStateList r1 = r0.getFillColor();
        L12:
            if (r1 == null) goto L16;
            int r5 = r1.getDefaultColor();
        L14:
            this.lightBottomSheet = MaterialColors.isColorLight(r5);
            return;
        L16:
            if ((r2.getBackground() instanceof ColorDrawable) == false) goto L18;
            r5 = ((ColorDrawable) r2.getBackground()).getColor();
            goto L14
        L18:
            this.lightBottomSheet = r4;
            return;
        L11:
            r1 = ViewCompat.getBackgroundTintList(r2);
            goto L12
        L5:
            if ((r2.getSystemUiVisibility() & 8192) == 0) goto L7;
            r4 = true;
            goto L8
        }

        /* synthetic */ EdgeToEdgeCallback(View r1, WindowInsetsCompat r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private void setPaddingForPosition(View r4) {
            if (r4.getTop() >= this.insetsCompat.getSystemWindowInsetTop()) goto L6;
            BottomSheetDialog.setLightStatusBar(r4, this.lightBottomSheet);
            r4.setPadding(r4.getPaddingLeft(), this.insetsCompat.getSystemWindowInsetTop() - r4.getTop(), r4.getPaddingRight(), r4.getPaddingBottom());
            return;
        L6:
            if (r4.getTop() == 0) goto L10;
            BottomSheetDialog.setLightStatusBar(r4, this.lightStatusBar);
            r4.setPadding(r4.getPaddingLeft(), 0, r4.getPaddingRight(), r4.getPaddingBottom());
            return;
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(@NonNull View r1, float r2) {
            setPaddingForPosition(r1);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(@NonNull View r1, int r2) {
            setPaddingForPosition(r1);
        }
    }

    public BottomSheetDialog(@NonNull Context r4) {
        this(r4, 0);
        this.edgeToEdgeEnabled = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enableEdgeToEdge}).getBoolean(0, false);
    }

    public BottomSheetDialog(@NonNull Context r3, @StyleRes int r4) {
        super(r3, getThemeResId(r3, r4));
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new AnonymousClass5(this);
        supportRequestWindowFeature(1);
        this.edgeToEdgeEnabled = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enableEdgeToEdge}).getBoolean(0, false);
    }

    protected BottomSheetDialog(@NonNull Context r2, boolean r3, DialogInterface.OnCancelListener r4) {
        super(r2, r3, r4);
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new AnonymousClass5(this);
        supportRequestWindowFeature(1);
        this.cancelable = r3;
        this.edgeToEdgeEnabled = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enableEdgeToEdge}).getBoolean(0, false);
    }

    static /* synthetic */ BottomSheetBehavior.BottomSheetCallback access$000(BottomSheetDialog r0) {
        return r0.edgeToEdgeCallback;
    }

    static /* synthetic */ BottomSheetBehavior.BottomSheetCallback access$002(BottomSheetDialog r0, BottomSheetBehavior.BottomSheetCallback r1) {
        r0.edgeToEdgeCallback = r1;
        return r1;
    }

    static /* synthetic */ BottomSheetBehavior access$100(BottomSheetDialog r0) {
        return r0.behavior;
    }

    static /* synthetic */ FrameLayout access$200(BottomSheetDialog r0) {
        return r0.bottomSheet;
    }

    private FrameLayout ensureContainerAndBehavior() {
        if (this.container != null) goto L6;
        FrameLayout r0 = (FrameLayout) View.inflate(getContext(), R.layout.design_bottom_sheet_dialog, null);
        this.container = r0;
        this.coordinator = (CoordinatorLayout) r0.findViewById(R.id.coordinator);
        FrameLayout r1 = (FrameLayout) this.container.findViewById(R.id.design_bottom_sheet);
        this.bottomSheet = r1;
        BottomSheetBehavior<FrameLayout> r2 = BottomSheetBehavior.from(r1);
        this.behavior = r2;
        r2.addBottomSheetCallback(this.bottomSheetCallback);
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

    public static void setLightStatusBar(@NonNull View r2, boolean r3) {
        if (Build.VERSION.SDK_INT < 23) goto L10;
        int r0 = r2.getSystemUiVisibility();
        if (r3 == false) goto L7;
        int r4 = r0 | 8192;
    L8:
        r2.setSystemUiVisibility(r4);
        return;
    L7:
        r4 = r0 & (-8193);
        goto L8
    }

    private View wrapInBottomSheet(int r3, @Nullable View r4, @Nullable ViewGroup.LayoutParams r5) {
        ensureContainerAndBehavior();
        CoordinatorLayout r0 = (CoordinatorLayout) this.container.findViewById(R.id.coordinator);
        if (r3 == 0) goto L7;
        if (r4 != null) goto L7;
        r4 = getLayoutInflater().inflate(r3, r0, false);
    L7:
        if (this.edgeToEdgeEnabled == false) goto L9;
        ViewCompat.setOnApplyWindowInsetsListener(this.bottomSheet, new AnonymousClass1(this));
    L9:
        this.bottomSheet.removeAllViews();
        FrameLayout r6 = this.bottomSheet;
        if (r5 != null) goto L12;
        r6.addView(r4);
    L13:
        r0.findViewById(R.id.touch_outside).setOnClickListener(new AnonymousClass2(this));
        ViewCompat.setAccessibilityDelegate(this.bottomSheet, new AnonymousClass3(this));
        this.bottomSheet.setOnTouchListener(new AnonymousClass4(this));
        return this.container;
    L12:
        r6.addView(r4, r5);
        goto L13
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

    public boolean getEdgeToEdgeEnabled() {
        return this.edgeToEdgeEnabled;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window r0 = getWindow();
        if (r0 != null) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 21) goto L7;
        return;
    L7:
        if (this.edgeToEdgeEnabled == true) goto L9;
    L11:
        boolean r1 = false;
    L12:
        FrameLayout r2 = this.container;
        if (r2 == null) goto L15;
        r2.setFitsSystemWindows(!r1);
    L15:
        CoordinatorLayout r4 = this.coordinator;
        if (r4 == null) goto L18;
        r4.setFitsSystemWindows(!r1);
    L18:
        if (r1 == false) goto L23;
        r0.getDecorView().setSystemUiVisibility(768);
        return;
    L23:
        return;
    L9:
        if (Color.alpha(r0.getNavigationBarColor()) >= 255) goto L11;
        r1 = true;
        goto L12
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    protected void onCreate(Bundle r2) {
        super.onCreate(r2);
        Window r1 = getWindow();
        if (r1 == null) goto L11;
        int r3 = Build.VERSION.SDK_INT;
        if (r3 < 21) goto L9;
        r1.setStatusBarColor(0);
        r1.addFlags(Integer.MIN_VALUE);
        if (r3 >= 23) goto L9;
        r1.addFlags(67108864);
    L9:
        r1.setLayout(-1, -1);
        return;
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    protected void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> r0 = this.behavior;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getState() != 5) goto L9;
        this.behavior.setState(4);
        return;
    }

    void removeDefaultCallback() {
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

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(@LayoutRes int r2) {
        super.setContentView(wrapInBottomSheet(r2, null, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View r3) {
        super.setContentView(wrapInBottomSheet(0, r3, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View r2, ViewGroup.LayoutParams r3) {
        super.setContentView(wrapInBottomSheet(0, r2, r3));
    }

    public void setDismissWithAnimation(boolean r1) {
        this.dismissWithAnimation = r1;
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
}
