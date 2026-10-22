package com.obric.oui.panel;

import android.R;
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
import com.obric.common.oui.f;
import com.obric.common.oui.g;
import com.obric.common.oui.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class BottomSheetDialog extends AppCompatDialog {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private BottomSheetBehavior<FrameLayout> f11179f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private FrameLayout f11180g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private FrameLayout f11181h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f11182i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    boolean f11183j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f11184k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f11185l;
    private boolean m;
    private final List<BottomSheetBehavior.d> n;

    @NonNull
    private BottomSheetBehavior.d o;

    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ BottomSheetDialog f11186f;

        a(BottomSheetDialog r1) {
            this.f11186f = r1;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r2) {
            BottomSheetDialog r3 = this.f11186f;
            if (r3.f11183j == true) goto L5;
            return;
        L5:
            if (r3.isShowing() == true) goto L7;
            return;
        L7:
            if (this.f11186f.shouldWindowCloseOnTouchOutside() == false) goto L12;
            this.f11186f.cancel();
            return;
        }
    }

    class b extends View.AccessibilityDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BottomSheetDialog f11187a;

        class a extends AccessibilityDelegateCompat {
            a(b r1) {
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View r2, AccessibilityNodeInfoCompat r3) {
                super.onInitializeAccessibilityNodeInfo(r2, r3);
                r3.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, "关闭面板"));
            }
        }

        b(BottomSheetDialog r1) {
            this.f11187a = r1;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View r2, AccessibilityEvent r3) {
            super.onPopulateAccessibilityEvent(r2, r3);
            int r4 = Build.VERSION.SDK_INT;
            if (r4 < 24) goto L10;
            if (this.f11187a.f11183j == false) goto L7;
            int r0 = 1;
        L8:
            r2.setImportantForAccessibility(r0);
            goto L10
        L7:
            r0 = 2;
        L10:
            if (r4 < 28) goto L12;
            r2.setScreenReaderFocusable(this.f11187a.f11183j);
        L12:
            r2.setContentDescription("关闭");
            ViewCompat.setAccessibilityDelegate(r2, new a(this));
        }
    }

    class c extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BottomSheetDialog f11188a;

        c(BottomSheetDialog r1) {
            this.f11188a = r1;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View r1, @NonNull AccessibilityNodeInfoCompat r2) {
            super.onInitializeAccessibilityNodeInfo(r1, r2);
            if (this.f11188a.f11183j == false) goto L5;
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
            BottomSheetDialog r0 = this.f11188a;
            if (r0.f11183j == false) goto L9;
            r0.cancel();
            return true;
        L9:
            return super.performAccessibilityAction(r3, r4, r5);
        }
    }

    class d implements View.OnTouchListener {
        d(BottomSheetDialog r1) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View r1, MotionEvent r2) {
            return true;
        }
    }

    class e extends BottomSheetBehavior.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BottomSheetDialog f11189a;

        e(BottomSheetDialog r1) {
            this.f11189a = r1;
        }

        @Override // com.obric.oui.panel.BottomSheetBehavior.d
        public void c(@NonNull View r2, float r3) {
            Iterator r1 = BottomSheetDialog.b(this.f11189a).iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            ((BottomSheetBehavior.d) r1.next()).c(r2, r3);
            goto L4
        }

        @Override // com.obric.oui.panel.BottomSheetBehavior.d
        public void d(@NonNull View r3, int r4) {
            Iterator r0 = BottomSheetDialog.b(this.f11189a).iterator();
        L4:
            if (r0.hasNext() == false) goto L7;
            ((BottomSheetBehavior.d) r0.next()).d(r3, r4);
            goto L4
        L7:
            if (r4 != 5) goto L11;
            this.f11189a.cancel();
            return;
        }
    }

    public BottomSheetDialog(@NonNull Context r1, @StyleRes int r2) {
        super(r1, getThemeResId(r1, r2));
        this.f11183j = true;
        this.f11184k = true;
        this.m = false;
        this.n = new ArrayList();
        this.o = new e(this);
        supportRequestWindowFeature(1);
    }

    static /* synthetic */ List b(BottomSheetDialog r0) {
        return r0.n;
    }

    private FrameLayout ensureContainerAndBehavior() {
        if (this.f11180g != null) goto L9;
        FrameLayout r0 = (FrameLayout) View.inflate(getContext(), g.f8261k, null);
        this.f11180g = r0;
        CoordinatorLayout r1 = (CoordinatorLayout) r0.findViewById(f.I);
        FrameLayout r2 = (FrameLayout) this.f11180g.findViewById(f.K);
        this.f11181h = r2;
        if (Build.VERSION.SDK_INT < 28) goto L7;
        r2.setAccessibilityPaneTitle("");
    L7:
        BottomSheetBehavior<FrameLayout> r3 = BottomSheetBehavior.f(this.f11181h);
        this.f11179f = r3;
        r3.k(this.o);
        this.f11179f.setHideable(this.f11183j);
    L9:
        return this.f11180g;
    }

    private static int getThemeResId(@NonNull Context r2, int r3) {
        if (r3 != 0) goto L8;
        TypedValue r4 = new TypedValue();
        if (r2.getTheme().resolveAttribute(com.obric.common.oui.b.f8194c, r4, true) == false) goto L7;
        return r4.resourceId;
    L7:
        return j.f8285j;
    L8:
        return r3;
    }

    private View wrapInBottomSheet(int r3, @Nullable View r4, @Nullable ViewGroup.LayoutParams r5) {
        ensureContainerAndBehavior();
        CoordinatorLayout r0 = (CoordinatorLayout) this.f11180g.findViewById(f.I);
        if (r3 == 0) goto L6;
        if (r4 != null) goto L6;
        r4 = getLayoutInflater().inflate(r3, r0, false);
    L6:
        this.f11181h.removeAllViews();
        if (this.m == false) goto L10;
        if (r5 != null) goto L10;
        r5 = new FrameLayout.LayoutParams(-1, -1);
    L10:
        FrameLayout r6 = this.f11181h;
        if (r5 != null) goto L13;
        r6.addView(r4);
    L14:
        int r7 = f.V0;
        r0.findViewById(r7).setOnClickListener(new a(this));
        r0.findViewById(r7).setAccessibilityDelegate(new b(this));
        ViewCompat.setAccessibilityDelegate(this.f11181h, new c(this));
        this.f11181h.setOnTouchListener(new d(this));
        return this.f11180g;
    L13:
        r6.addView(r4, r5);
        goto L14
    }

    public void c(boolean r1) {
        f().i(r1);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        BottomSheetBehavior<FrameLayout> r0 = f();
        if (this.f11182i == true) goto L5;
    L8:
        super.cancel();
        return;
    L5:
        if (r0.getState() == 5) goto L8;
        r0.setState(5);
    }

    public void d(BottomSheetBehavior.d r1) {
        this.n.add(r1);
    }

    public void e() {
        this.n.clear();
    }

    @NonNull
    public BottomSheetBehavior<FrameLayout> f() {
        if (this.f11179f != null) goto L6;
        ensureContainerAndBehavior();
    L6:
        return this.f11179f;
    }

    public FrameLayout g() {
        if (this.f11181h != null) goto L6;
        ensureContainerAndBehavior();
    L6:
        return this.f11181h;
    }

    public boolean getDismissWithAnimation() {
        return this.f11182i;
    }

    public void h(boolean r1) {
        this.m = r1;
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
        BottomSheetBehavior<FrameLayout> r0 = this.f11179f;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getState() != 5) goto L13;
        boolean r1 = this.m;
        BottomSheetBehavior<FrameLayout> r2 = this.f11179f;
        if (r1 == false) goto L9;
        int r3 = 4;
    L10:
        r2.setState(r3);
        return;
    L9:
        r3 = 3;
        goto L10
    }

    void removeDefaultCallback() {
        this.f11179f.h(this.o);
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean r2) {
        super.setCancelable(r2);
        if (this.f11183j == r2) goto L8;
        this.f11183j = r2;
        BottomSheetBehavior<FrameLayout> r1 = this.f11179f;
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
        this.f11184k = r3;
        this.f11185l = true;
        return;
    L5:
        if (this.f11183j == true) goto L7;
        this.f11183j = true;
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

    boolean shouldWindowCloseOnTouchOutside() {
        if (this.f11185l == true) goto L6;
        TypedArray r0 = getContext().obtainStyledAttributes(new int[]{R.attr.windowCloseOnTouchOutside});
        this.f11184k = r0.getBoolean(0, true);
        r0.recycle();
        this.f11185l = true;
    L6:
        return this.f11184k;
    }
}
