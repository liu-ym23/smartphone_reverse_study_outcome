package com.obric.oui.window.floating;

import android.os.IBinder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import androidx.core.graphics.Insets;
import com.obric.oui.blur.BlurConfig;
import com.obric.oui.material.MaterialConfig;
import com.obric.oui.material.OMaterialExtBaseKt;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.utils.log.L;
import com.obric.oui.window.OWindowConfigController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OFloatingWindowHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bJ\b\u0010\u001e\u001a\u00020\u0019H\u0002J\u0006\u0010\u001f\u001a\u00020\u0019J\u0006\u0010 \u001a\u00020\u0019J\"\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u000e2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00190$J\b\u0010&\u001a\u00020\u0019H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/obric/oui/window/floating/OFloatingWindowHelper;", "", "targetView", "Landroid/view/View;", "(Landroid/view/View;)V", "currentBlurRadius", "", "gravity", "", "getGravity", "()I", "setGravity", "(I)V", "isAddedToWindowManager", "", "isFloatingType", "()Z", "setFloatingType", "(Z)V", "mParentGroup", "Landroid/view/ViewGroup;", "parentAttachStateChangeListener", "com/obric/oui/window/floating/OFloatingWindowHelper$parentAttachStateChangeListener$1", "Lcom/obric/oui/window/floating/OFloatingWindowHelper$parentAttachStateChangeListener$1;", "applyBlur", "", "maskView", "maskMaterialConfig", "Lcom/obric/oui/material/MaterialConfig;", "srcType", "attachToWindowManager", "onAttachedToWindow", "removeFromWindowManager", "setupInsets", "fitInset", "updateLayout", "Lkotlin/Function1;", "Landroidx/core/graphics/Insets;", "updateHeight", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OFloatingWindowHelper {
    private float currentBlurRadius;
    private int gravity;
    private boolean isAddedToWindowManager;
    private boolean isFloatingType;
    private ViewGroup mParentGroup;
    private final OFloatingWindowHelper$parentAttachStateChangeListener$1 parentAttachStateChangeListener;
    private final View targetView;

    public static /* synthetic */ WindowInsets $r8$lambda$4QZMkxUqVHvRZw_OG0fzQtcDVzw(OFloatingWindowHelper r0, Function1 r1, View r2, WindowInsets r3) {
        return m587setupInsets$lambda5(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$8CDD6DQTZwzOSw1m_lnRx-0IFL4, reason: not valid java name */
    public static /* synthetic */ void m585$r8$lambda$8CDD6DQTZwzOSw1m_lnRx0IFL4(OFloatingWindowHelper r0) {
        m586attachToWindowManager$lambda7(r0);
    }

    public static /* synthetic */ void $r8$lambda$zvgdpBna7nWC7ybCskR5LCjeqiM(OFloatingWindowHelper r0) {
        m588setupInsets$lambda5$lambda3$lambda2$lambda1(r0);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.obric.oui.window.floating.OFloatingWindowHelper$parentAttachStateChangeListener$1] */
    public OFloatingWindowHelper(View r2) {
        Intrinsics.checkNotNullParameter(r2, "targetView");
        this.targetView = r2;
        this.gravity = 1;
        this.parentAttachStateChangeListener = new OFloatingWindowHelper$parentAttachStateChangeListener$1(this);
    }

    public final boolean isFloatingType() {
        return this.isFloatingType;
    }

    public final void setFloatingType(boolean r1) {
        this.isFloatingType = r1;
    }

    public final int getGravity() {
        return this.gravity;
    }

    public final void setGravity(int r1) {
        this.gravity = r1;
    }

    public final void onAttachedToWindow() {
        if (this.isFloatingType == true) goto L5;
        return;
    L5:
        if (this.isAddedToWindowManager == true) goto L9;
        attachToWindowManager();
        return;
    }

    public final void applyBlur(View r2, MaterialConfig r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "maskView");
        Intrinsics.checkNotNullParameter(r3, "maskMaterialConfig");
        BlurConfig r0 = r3.getBlurConfig();
        Intrinsics.checkNotNull(r0);
        float r1 = r0.getBlurRadius();
        this.currentBlurRadius = r1;
        if (r1 <= 0.0f) goto L5;
        OMaterialHelper.setCommonGradientBlur(r2, r3, r4);
    L6:
        OMaterialExtBaseKt.setMaterialBackdropTarget(r2, r2);
        return;
    L5:
        OMaterialHelper.setEffectSrc(r2, 0);
        goto L6
    }

    public final void setupInsets(boolean r2, final Function1<? super Insets, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "updateLayout");
        if (r2 == false) goto L6;
        OWindowConfigController r4 = OWindowConfigController.INSTANCE;
        r3.invoke(OWindowConfigController.getSystemBarInsets(this.targetView, null));
        this.targetView.setOnApplyWindowInsetsListener(new OFloatingWindowHelper$$ExternalSyntheticLambda0(this, r3));
        return;
    }

    /* JADX INFO: renamed from: setupInsets$lambda-5, reason: not valid java name */
    private static final WindowInsets m587setupInsets$lambda5(final OFloatingWindowHelper r1, Function1 r2, View r3, WindowInsets r4) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$updateLayout");
        Intrinsics.checkNotNullParameter(r3, "$noName_0");
        Intrinsics.checkNotNullParameter(r4, "insets");
        if (r1.isFloatingType == true) goto L5;
    L13:
        OWindowConfigController r5 = OWindowConfigController.INSTANCE;
        r2.invoke(OWindowConfigController.getSystemBarInsets(r1.targetView, r4));
    L14:
        return r4;
    L5:
        if (r1.isAddedToWindowManager == false) goto L13;
        ViewGroup r6 = r1.mParentGroup;
        if (r6 == null) goto L14;
        WindowInsets r7 = r6.getRootWindowInsets();
        if (r7 == null) goto L14;
        OWindowConfigController r0 = OWindowConfigController.INSTANCE;
        ViewGroup r8 = r1.mParentGroup;
        Intrinsics.checkNotNull(r8);
        r2.invoke(OWindowConfigController.getSystemBarInsets(r8, r7));
        r1.targetView.post(new OFloatingWindowHelper$$ExternalSyntheticLambda1(r1));
        goto L14
    }

    /* JADX INFO: renamed from: setupInsets$lambda-5$lambda-3$lambda-2$lambda-1, reason: not valid java name */
    private static final void m588setupInsets$lambda5$lambda3$lambda2$lambda1(OFloatingWindowHelper r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.updateHeight();
    }

    private final void attachToWindowManager() {
        if (this.isAddedToWindowManager == false) goto L5;
        return;
    L5:
        this.targetView.post(new OFloatingWindowHelper$$ExternalSyntheticLambda2(this));
    }

    /* JADX INFO: renamed from: attachToWindowManager$lambda-7, reason: not valid java name */
    private static final void m586attachToWindowManager$lambda7(OFloatingWindowHelper r8) {
        Intrinsics.checkNotNullParameter(r8, "this$0");
        if (r8.targetView.isAttachedToWindow() == true) goto L5;
        return;
    L5:
        if ((r8.targetView.getParent() instanceof ViewGroup) == false) goto L40;
        ViewParent r0 = r8.targetView.getParent();
        if (r0 == null) goto L36;
        ViewGroup r1 = (ViewGroup) r0;
        r8.mParentGroup = r1;
        if (r1 == null) goto L12;
        r1.removeView(r8.targetView);
    L12:
        ViewGroup r2 = r8.mParentGroup;
        if (r2 == null) goto L16;
        r2.addOnAttachStateChangeListener(r8.parentAttachStateChangeListener);
    L16:
        Object r3 = r8.targetView.getContext().getSystemService("window");
        if (r3 == null) goto L34;
        WindowManager r4 = (WindowManager) r3;
        WindowManager.LayoutParams r7 = new WindowManager.LayoutParams(-1, -2, 1000, 16778024, -3);
        r7.gravity = r8.gravity;
        ViewGroup r5 = r8.mParentGroup;
        if (r5 != null) goto L21;
        IBinder r6 = null;
    L22:
        r7.token = r6;
        r4.addView(r8.targetView, r7);     // Catch: Exception -> L31
        r8.isAddedToWindowManager = true;     // Catch: Exception -> L31
        ViewGroup r9 = r8.mParentGroup;     // Catch: Exception -> L31
        if (r9 != null) goto L27;
        return;
    L27:
        if (r9.getRootWindowInsets() == null) goto L42;
        r8.targetView.requestApplyInsets();     // Catch: Exception -> L31
        return;
    L42:
        return;
    L31:
        e = move-exception;
        L.e("OFloatingWindowHelper", Intrinsics.stringPlus("Failed to add view to WindowManager: ", e.getMessage()));
        return;
    L21:
        r6 = r5.getWindowToken();
        goto L22
    L34:
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    L36:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final void removeFromWindowManager() {
        if (this.isAddedToWindowManager == false) goto L18;
        Object r0 = this.targetView.getContext().getSystemService("window");     // Catch: Exception -> L9
        if (r0 == null) goto L8;
        ((WindowManager) r0).removeViewImmediate(this.targetView);     // Catch: Exception -> L9
    L11:
        this.isAddedToWindowManager = false;
        ViewGroup r1 = this.mParentGroup;
        if (r1 == null) goto L15;
        r1.removeOnAttachStateChangeListener(this.parentAttachStateChangeListener);
    L15:
        this.mParentGroup = null;
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");     // Catch: Exception -> L9
    L9:
        e = move-exception;
        L.e("OFloatingWindowHelper", Intrinsics.stringPlus("Failed to remove view from WindowManager: ", e.getMessage()));
        goto L11
    }

    private final void updateHeight() {
        if (this.isAddedToWindowManager == false) goto L17;
        Object r0 = this.targetView.getContext().getSystemService("window");
        if (r0 == null) goto L16;
        WindowManager r1 = (WindowManager) r0;
        ViewGroup.LayoutParams r2 = this.targetView.getLayoutParams();
        if ((r2 instanceof WindowManager.LayoutParams) == false) goto L9;
        WindowManager.LayoutParams r3 = (WindowManager.LayoutParams) r2;
    L10:
        int r4 = this.targetView.getMeasuredHeight();
        if (r3 != null) goto L13;
        return;
    L13:
        if (r3.height == r4) goto L19;
        r3.height = r4;
        r1.updateViewLayout(this.targetView, r3);
        return;
    L19:
        return;
    L9:
        r3 = null;
        goto L10
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }
}
