package com.obric.oui.sheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.obric.oui.common.util.f;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class OBottomSheetDialog extends AppCompatDialog {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private BottomSheetBehavior<FrameLayout> f11380f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private FrameLayout f11381g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private FrameLayout f11382h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f11383i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    boolean f11384j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f11385k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f11386l;
    private boolean m;

    @NonNull
    private BottomSheetBehavior.BottomSheetCallback n;

    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ OBottomSheetDialog f11387f;

        a(OBottomSheetDialog r1) {
            this.f11387f = r1;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r2) {
            OBottomSheetDialog r3 = this.f11387f;
            if (r3.f11384j == true) goto L5;
            return;
        L5:
            if (r3.isShowing() == true) goto L7;
            return;
        L7:
            if (this.f11387f.shouldWindowCloseOnTouchOutside() == false) goto L12;
            this.f11387f.cancel();
            return;
        }
    }

    class b extends View.AccessibilityDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OBottomSheetDialog f11388a;

        class a extends AccessibilityDelegateCompat {
            a(b r1) {
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View r2, AccessibilityNodeInfoCompat r3) {
                super.onInitializeAccessibilityNodeInfo(r2, r3);
                r3.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, "关闭面板"));
            }
        }

        b(OBottomSheetDialog r1) {
            this.f11388a = r1;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View r2, AccessibilityEvent r3) {
            super.onPopulateAccessibilityEvent(r2, r3);
            int r4 = Build.VERSION.SDK_INT;
            if (r4 < 24) goto L10;
            if (this.f11388a.f11384j == false) goto L7;
            int r0 = 1;
        L8:
            r2.setImportantForAccessibility(r0);
            goto L10
        L7:
            r0 = 2;
        L10:
            if (r4 < 28) goto L12;
            r2.setScreenReaderFocusable(this.f11388a.f11384j);
        L12:
            r2.setContentDescription("关闭");
            ViewCompat.setAccessibilityDelegate(r2, new a(this));
        }
    }

    class c extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OBottomSheetDialog f11389a;

        c(OBottomSheetDialog r1) {
            this.f11389a = r1;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View r1, @NonNull AccessibilityNodeInfoCompat r2) {
            super.onInitializeAccessibilityNodeInfo(r1, r2);
            if (this.f11389a.f11384j == false) goto L5;
            r2.addAction(1048576);
            boolean r0 = true;
        L6:
            r2.setDismissable(r0);
            return;
        L5:
            r0 = false;
            goto L6
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View r3, int r4, Bundle r5) {
            if (r4 != 1048576) goto L9;
            OBottomSheetDialog r0 = this.f11389a;
            if (r0.f11384j == false) goto L9;
            r0.cancel();
            return true;
        L9:
            return super.performAccessibilityAction(r3, r4, r5);
        }
    }

    class d implements View.OnTouchListener {
        d(OBottomSheetDialog r1) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View r1, MotionEvent r2) {
            return true;
        }
    }

    class e extends BottomSheetBehavior.BottomSheetCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OBottomSheetDialog f11390a;

        e(OBottomSheetDialog r1) {
            this.f11390a = r1;
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(@NonNull View r1, float r2) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(@NonNull View r1, int r2) {
            if (r2 != 5) goto L6;
            this.f11390a.cancel();
            return;
        }
    }

    public OBottomSheetDialog(@NonNull Context r1, @StyleRes int r2) {
        super(r1, getThemeResId(r1, r2));
        this.f11384j = true;
        this.f11385k = true;
        this.m = false;
        this.n = new e(this);
        supportRequestWindowFeature(1);
    }

    private FrameLayout ensureContainerAndBehavior() {
        if (this.f11381g != null) goto L11;
        FrameLayout r0 = (FrameLayout) View.inflate(getContext(), R.layout.design_bottom_sheet_dialog, null);
        this.f11381g = r0;
        CoordinatorLayout r1 = (CoordinatorLayout) r0.findViewById(R.id.coordinator);
        FrameLayout r2 = (FrameLayout) this.f11381g.findViewById(R.id.design_bottom_sheet);
        this.f11382h = r2;
        if (Build.VERSION.SDK_INT < 28) goto L7;
        r2.setAccessibilityPaneTitle("");
    L7:
        BottomSheetBehavior<FrameLayout> r3 = BottomSheetBehavior.from(this.f11382h);
        this.f11380f = r3;
        r3.setBottomSheetCallback(this.n);
        this.f11380f.setHideable(this.f11384j);
        if (this.m == false) goto L11;
        this.f11380f.setPeekHeight((int) (f.b(getContext()) * 0.75f));
    L11:
        return this.f11381g;
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
        CoordinatorLayout r0 = (CoordinatorLayout) this.f11381g.findViewById(R.id.coordinator);
        if (r3 == 0) goto L6;
        if (r4 != null) goto L6;
        r4 = getLayoutInflater().inflate(r3, r0, false);
    L6:
        this.f11382h.removeAllViews();
        if (this.m == false) goto L10;
        if (r5 != null) goto L10;
        r5 = new FrameLayout.LayoutParams(-1, -1);
    L10:
        FrameLayout r6 = this.f11382h;
        if (r5 != null) goto L13;
        r6.addView(r4);
    L14:
        int r7 = R.id.touch_outside;
        r0.findViewById(r7).setOnClickListener(new a(this));
        r0.findViewById(r7).setAccessibilityDelegate(new b(this));
        ViewCompat.setAccessibilityDelegate(this.f11382h, new c(this));
        this.f11382h.setOnTouchListener(new d(this));
        return this.f11381g;
    L13:
        r6.addView(r4, r5);
        goto L14
    }

    public void b(boolean r1) {
        this.m = r1;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        BottomSheetBehavior<FrameLayout> r0 = getBehavior();
        if (this.f11383i == true) goto L5;
    L8:
        super.cancel();
        return;
    L5:
        if (r0.getState() == 5) goto L8;
        r0.setState(5);
    }

    @NonNull
    public BottomSheetBehavior<FrameLayout> getBehavior() {
        if (this.f11380f != null) goto L6;
        ensureContainerAndBehavior();
    L6:
        return this.f11380f;
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
        BottomSheetBehavior<FrameLayout> r0 = this.f11380f;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getState() != 5) goto L9;
        this.f11380f.setState(4);
        return;
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean r2) {
        super.setCancelable(r2);
        if (this.f11384j == r2) goto L8;
        this.f11384j = r2;
        BottomSheetBehavior<FrameLayout> r1 = this.f11380f;
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
        this.f11385k = r3;
        this.f11386l = true;
        return;
    L5:
        if (this.f11384j == true) goto L7;
        this.f11384j = true;
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
        this.f11383i = r1;
    }

    boolean shouldWindowCloseOnTouchOutside() {
        if (this.f11386l == true) goto L6;
        TypedArray r0 = getContext().obtainStyledAttributes(new int[]{android.R.attr.windowCloseOnTouchOutside});
        this.f11385k = r0.getBoolean(0, true);
        r0.recycle();
        this.f11386l = true;
    L6:
        return this.f11385k;
    }
}
