package com.obric.oui.popover.v2;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import com.obric.common.oui.R;
import com.obric.oui.material.MaterialConfig;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.material.OMaterialExtBaseKt;
import com.obric.oui.popover.FakeAnchorView;
import com.obric.oui.popover.SingleChildFrameLayout;
import com.obric.oui.window.OWindowConfigController;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: OPopoverModal.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b8\b\u0016\u0018\u0000 ½\u00012\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0002½\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J(\u0010\u0085\u0001\u001a\u000f\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"0\u0086\u00012\u0007\u0010\u0087\u0001\u001a\u00020\"2\u0007\u0010\u0088\u0001\u001a\u00020\"H\u0002J(\u0010\u0089\u0001\u001a\u000f\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"0\u0086\u00012\u0007\u0010\u0087\u0001\u001a\u00020\"2\u0007\u0010\u0088\u0001\u001a\u00020\"H\u0002J\t\u0010\u008a\u0001\u001a\u00020\u0016H\u0002J\u0007\u0010\u008b\u0001\u001a\u00020\u0016J\u0007\u0010\u008c\u0001\u001a\u00020\u0016J\u0012\u0010\u008d\u0001\u001a\u00020\u00162\u0007\u0010\u008e\u0001\u001a\u00020\u0012H\u0002J\u000b\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0012H\u0002J\t\u0010\u0090\u0001\u001a\u00020\u0016H\u0016J\u0007\u0010\u0091\u0001\u001a\u00020\u0010J\u000f\u0010\u0092\u0001\u001a\u00020\"H\u0000¢\u0006\u0003\b\u0093\u0001J\t\u0010\u0094\u0001\u001a\u00020\u0016H\u0002J\t\u0010\u0095\u0001\u001a\u00020\u0016H\u0002J\t\u0010\u0096\u0001\u001a\u00020\u0018H\u0016J\u0019\u0010\u0097\u0001\u001a\u00020\u00162\u0007\u0010\u0098\u0001\u001a\u00020\"2\u0007\u0010\u0099\u0001\u001a\u00020\"J\t\u0010\u009a\u0001\u001a\u00020\u0016H\u0014J\u0007\u0010\u009b\u0001\u001a\u00020\u0016J\t\u0010\u009c\u0001\u001a\u00020\u0016H\u0014J\t\u0010\u009d\u0001\u001a\u00020\u0016H\u0016J\t\u0010\u009e\u0001\u001a\u00020\u0016H\u0016J\t\u0010\u009f\u0001\u001a\u00020\u0016H\u0002J\u001e\u0010 \u0001\u001a\u0004\u0018\u00010\u00122\u000b\b\u0002\u0010¡\u0001\u001a\u0004\u0018\u00010\u0012H\u0000¢\u0006\u0003\b¢\u0001J\t\u0010£\u0001\u001a\u00020\"H\u0016J\t\u0010¤\u0001\u001a\u00020\u0016H\u0002J\u0012\u0010¥\u0001\u001a\u00020\u00162\u0007\u0010¦\u0001\u001a\u00020\u0010H\u0002J\u0010\u0010§\u0001\u001a\u00020\u00162\u0007\u0010¨\u0001\u001a\u00020\u0018J\u0018\u0010©\u0001\u001a\u00020\u00162\u0007\u0010ª\u0001\u001a\u00020\"H\u0000¢\u0006\u0003\b«\u0001J\u0010\u0010¬\u0001\u001a\u00020\u00162\u0007\u0010\u00ad\u0001\u001a\u00020\"J\u0012\u0010®\u0001\u001a\u00020\u00162\t\u0010¯\u0001\u001a\u0004\u0018\u00010\tJ\u0012\u0010°\u0001\u001a\u00020\u00162\t\u0010¯\u0001\u001a\u0004\u0018\u00010\u000bJ\u0012\u0010±\u0001\u001a\u00020\u00162\t\u0010¯\u0001\u001a\u0004\u0018\u00010\rJ\u0018\u0010²\u0001\u001a\u00020\u00162\u000f\u0010¯\u0001\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015J\u0018\u0010³\u0001\u001a\u00020\u00162\u000f\u0010¯\u0001\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015J\u0010\u0010´\u0001\u001a\u00020\u00162\u0007\u0010µ\u0001\u001a\u00020\u0018J\u0010\u0010¶\u0001\u001a\u00020\u00162\u0007\u0010·\u0001\u001a\u00020\"J\u0010\u0010¸\u0001\u001a\u00020\u00162\u0007\u0010¹\u0001\u001a\u00020\"J\t\u0010º\u0001\u001a\u00020\u0016H\u0003J8\u0010»\u0001\u001a\u00020\u00162\u0007\u0010¼\u0001\u001a\u00020\u00102\u000b\b\u0002\u0010¡\u0001\u001a\u0004\u0018\u00010\u00122\u0007\u0010ª\u0001\u001a\u00020\"2\u0007\u0010\u0087\u0001\u001a\u00020\"2\u0007\u0010\u0088\u0001\u001a\u00020\"R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0019R\u001e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u00020\"8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u00020(X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020(X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,R\u0014\u00100\u001a\u00020\u001dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0014\u00103\u001a\u00020\u0018X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0019R\u001c\u00105\u001a\u0004\u0018\u000106X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0014\u0010;\u001a\u00020\"X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0014\u0010>\u001a\u00020\"X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010=R\u0014\u0010@\u001a\u00020\"X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010=R\u001a\u0010B\u001a\u00020CX\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u000e\u0010H\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010I\u001a\u00020J8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bK\u0010LR\u0014\u0010M\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u0010\u0019R\u0014\u0010O\u001a\u00020\"X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010=R\u0014\u0010Q\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u0010\u0019R\u001a\u0010S\u001a\u00020\"X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010=\"\u0004\bU\u0010VR\u0014\u0010W\u001a\u00020\"X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u0010=R&\u0010Y\u001a\u0014\u0012\u0004\u0012\u00020\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\\0[0ZX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010^R\u001a\u0010_\u001a\u00020\"X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010=\"\u0004\ba\u0010VR\u001a\u0010b\u001a\u00020\"X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010=\"\u0004\bd\u0010VR\u001a\u0010e\u001a\u00020\u0018X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010\u0019\"\u0004\bg\u0010hR\u001a\u0010i\u001a\u00020\u0018X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010\u0019\"\u0004\bk\u0010hR\u0014\u0010l\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bm\u0010\u0019R\u0014\u0010n\u001a\u00020(X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bo\u0010*R\u0016\u0010p\u001a\u00020\"8WX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bq\u0010=R\u0014\u0010r\u001a\u00020(X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bs\u0010*R\u0014\u0010t\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u0010\u0019R\u0014\u0010v\u001a\u00020\"X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bw\u0010=R\u001a\u0010x\u001a\u00020\u0012X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R\u001a\u0010}\u001a\u00020\"X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010=\"\u0004\b\u007f\u0010VR\u001d\u0010\u0080\u0001\u001a\u00020\"X\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010=\"\u0005\b\u0082\u0001\u0010VR\u000f\u0010\u0083\u0001\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0084\u0001\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006¾\u0001"}, d2 = {"Lcom/obric/oui/popover/v2/OPopoverModal;", "Landroid/widget/FrameLayout;", "Lcom/obric/oui/popover/v2/OPopoverBase;", "builder", "Lcom/obric/oui/popover/v2/OPopover$Builder;", "(Lcom/obric/oui/popover/v2/OPopover$Builder;)V", "autoDismissRunnable", "Ljava/lang/Runnable;", "bubbleDismissListener", "Lcom/obric/oui/popover/v2/OPopover$OnBubbleDismissListener;", "bubbleShowListener", "Lcom/obric/oui/popover/v2/OPopover$OnBubbleShowListener;", "bubbleStartDismissListener", "Lcom/obric/oui/popover/v2/OPopover$OnBubbleStartDismissListener;", "currentAnchorRef", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "currentHostParent", "Landroid/view/ViewGroup;", "detachedCleanupRunnable", "dismissListener", "Lkotlin/Function0;", "", "isPopoverBubbleLayoutInitialized", "", "()Z", "<set-?>", "isShowing", "mAutoDismissDelayMillis", "", "mEnableBackPressDismiss", "mOutsideTouchable", "mShadowEnabled", "mShadowStyle", "", "mSpacingForShadow", "mView", "mainHandler", "Landroid/os/Handler;", "popoverAnchorCenterX", "", "getPopoverAnchorCenterX", "()F", "setPopoverAnchorCenterX", "(F)V", "popoverAnchorCenterY", "getPopoverAnchorCenterY", "setPopoverAnchorCenterY", "popoverAnimationDurationMillis", "getPopoverAnimationDurationMillis", "()J", "popoverAnimationIsWindowMode", "getPopoverAnimationIsWindowMode", "popoverAnimator", "Landroid/animation/AnimatorSet;", "getPopoverAnimator", "()Landroid/animation/AnimatorSet;", "setPopoverAnimator", "(Landroid/animation/AnimatorSet;)V", "popoverBgColor", "getPopoverBgColor", "()I", "popoverBorderColor", "getPopoverBorderColor", "popoverBorderWidth", "getPopoverBorderWidth", "popoverBubbleLayout", "Lcom/obric/oui/popover/v2/OPopoverLayout;", "getPopoverBubbleLayout", "()Lcom/obric/oui/popover/v2/OPopoverLayout;", "setPopoverBubbleLayout", "(Lcom/obric/oui/popover/v2/OPopoverLayout;)V", "popoverContentView", "popoverContext", "Landroid/content/Context;", "getPopoverContext", "()Landroid/content/Context;", "popoverCoverPreviousWhenStacked", "getPopoverCoverPreviousWhenStacked", "popoverDisplayOrientation", "getPopoverDisplayOrientation", "popoverEnableBubbleMaterial", "getPopoverEnableBubbleMaterial", "popoverGravity", "getPopoverGravity", "setPopoverGravity", "(I)V", "popoverHeight", "getPopoverHeight", "popoverMaterials", "Lkotlin/Function1;", "", "Lcom/obric/oui/material/MaterialConfig;", "getPopoverMaterials", "()Lkotlin/jvm/functions/Function1;", "popoverPopupOriginX", "getPopoverPopupOriginX", "setPopoverPopupOriginX", "popoverPopupOriginY", "getPopoverPopupOriginY", "setPopoverPopupOriginY", "popoverPushedToStack", "getPopoverPushedToStack", "setPopoverPushedToStack", "(Z)V", "popoverRemovedFromStack", "getPopoverRemovedFromStack", "setPopoverRemovedFromStack", "popoverShowWithAnimation", "getPopoverShowWithAnimation", "popoverStackAlphaPrevious", "getPopoverStackAlphaPrevious", "popoverStackCoverColor", "getPopoverStackCoverColor", "popoverStackScalePrevious", "getPopoverStackScalePrevious", "popoverTransparentBg", "getPopoverTransparentBg", "popoverWidth", "getPopoverWidth", "popoverWindowFrame", "getPopoverWindowFrame", "()Landroid/view/ViewGroup;", "setPopoverWindowFrame", "(Landroid/view/ViewGroup;)V", "popoverXOffset", "getPopoverXOffset", "setPopoverXOffset", "popoverYOffset", "getPopoverYOffset", "setPopoverYOffset", "removeOnDismiss", "showListener", "addShadowFrame", "Lkotlin/Pair;", MaterialConfigFormatNames.X, MaterialConfigFormatNames.Y, "addShadowFrameIfNeeded", "cleanupFakeAnchorIfNeeded", "dismiss", "dismissDirectly", "ensureAttachedToParent", "targetParent", "findDecorViewParent", "finishPopoverDismissInternal", "getContentView", "getDisplayRotationDegrees", "getDisplayRotationDegrees$OUI_standardRelease", "initContentView", "interceptBackPressedIfNeeded", "isPopoverShowing", "measurePopup", "widthMeasureSpec", "heightMeasureSpec", "onAttachedToWindow", "onDestroy", "onDetachedFromWindow", "onPopoverShownInternal", "onPopoverStartDismissInternal", "performDetachedCleanup", "resolveHostParent", "parent", "resolveHostParent$OUI_standardRelease", "resolvePopoverAnimationGravityInternal", "restoreWindowCallback", "setBubbleLayout", "view", "setEnableAutoDismiss", "enabled", "setGravity", "gravity", "setGravity$OUI_standardRelease", "setMaxContentHeight", "maxHeight", "setOnBubbleDismissListener", "listener", "setOnBubbleShowListener", "setOnBubbleStartDismissListener", "setOnDismissListener", "setOnShowListener", "setRemoveOnDismiss", "remove", "setXOffset", "xOffset", "setYOffset", "yOffset", "setupOutsideTouchHandler", "showAtLocation", "anchor", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OPopoverModal extends FrameLayout implements OPopoverBase<OPopoverModal> {
    public static final Companion Companion = null;
    private static final Map<Activity, Companion.BackPressManager> backPressManagerByActivity = null;
    private final Runnable autoDismissRunnable;
    private OPopover.OnBubbleDismissListener bubbleDismissListener;
    private OPopover.OnBubbleShowListener bubbleShowListener;
    private OPopover.OnBubbleStartDismissListener bubbleStartDismissListener;
    private WeakReference<View> currentAnchorRef;
    private ViewGroup currentHostParent;
    private final Runnable detachedCleanupRunnable;
    private Function0<Unit> dismissListener;
    private boolean isShowing;
    private final long mAutoDismissDelayMillis;
    private final boolean mEnableBackPressDismiss;
    private final boolean mOutsideTouchable;
    private final boolean mShadowEnabled;
    private final int mShadowStyle;
    private final boolean mSpacingForShadow;
    private final View mView;
    private final Handler mainHandler;
    private float popoverAnchorCenterX;
    private float popoverAnchorCenterY;
    private final long popoverAnimationDurationMillis;
    private final boolean popoverAnimationIsWindowMode;
    private AnimatorSet popoverAnimator;
    private final int popoverBgColor;
    private final int popoverBorderColor;
    private final int popoverBorderWidth;
    public OPopoverLayout popoverBubbleLayout;
    private ViewGroup popoverContentView;
    private final boolean popoverCoverPreviousWhenStacked;
    private final int popoverDisplayOrientation;
    private final boolean popoverEnableBubbleMaterial;
    private int popoverGravity;
    private final int popoverHeight;
    private final Function1<Boolean, MaterialConfig[]> popoverMaterials;
    private int popoverPopupOriginX;
    private int popoverPopupOriginY;
    private boolean popoverPushedToStack;
    private boolean popoverRemovedFromStack;
    private final boolean popoverShowWithAnimation;
    private final float popoverStackAlphaPrevious;
    private final int popoverStackCoverColor;
    private final float popoverStackScalePrevious;
    private final boolean popoverTransparentBg;
    private final int popoverWidth;
    public ViewGroup popoverWindowFrame;
    private int popoverXOffset;
    private int popoverYOffset;
    private boolean removeOnDismiss;
    private Function0<Unit> showListener;

    /* JADX INFO: compiled from: OPopoverModal.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/popover/v2/OPopoverModal$Companion;", "", "()V", "backPressManagerByActivity", "", "Landroid/app/Activity;", "Lcom/obric/oui/popover/v2/OPopoverModal$Companion$BackPressManager;", "cleanupBackPressManagerLocked", "", "activity", "installBackPressCallbackIfNeeded", "registerShowingPopover", "popover", "Lcom/obric/oui/popover/v2/OPopoverModal;", "topShowingPopoverLocked", "unregisterShowingPopover", "BackPressManager", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: OPopoverModal.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006¢\u0006\u0002\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/obric/oui/popover/v2/OPopoverModal$Companion$BackPressManager;", "", "originalCallback", "Landroid/view/Window$Callback;", "proxyCallback", "showingPopovers", "", "Ljava/lang/ref/WeakReference;", "Lcom/obric/oui/popover/v2/OPopoverModal;", "(Landroid/view/Window$Callback;Landroid/view/Window$Callback;Ljava/util/List;)V", "getOriginalCallback", "()Landroid/view/Window$Callback;", "getProxyCallback", "getShowingPopovers", "()Ljava/util/List;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        private static final class BackPressManager {
            private final Window.Callback originalCallback;
            private final Window.Callback proxyCallback;
            private final List<WeakReference<OPopoverModal>> showingPopovers;

            public BackPressManager(Window.Callback r2, Window.Callback r3, List<WeakReference<OPopoverModal>> r4) {
                Intrinsics.checkNotNullParameter(r2, "originalCallback");
                Intrinsics.checkNotNullParameter(r3, "proxyCallback");
                Intrinsics.checkNotNullParameter(r4, "showingPopovers");
                this.originalCallback = r2;
                this.proxyCallback = r3;
                this.showingPopovers = r4;
            }

            public final Window.Callback getOriginalCallback() {
                return this.originalCallback;
            }

            public final Window.Callback getProxyCallback() {
                return this.proxyCallback;
            }

            public /* synthetic */ BackPressManager(Window.Callback r1, Window.Callback r2, ArrayList r3, int r4, DefaultConstructorMarker r5) {
                if ((r4 & 4) == 0) goto L5;
                r3 = new ArrayList();
            L5:
                this(r1, r2, r3);
            }

            public final List<WeakReference<OPopoverModal>> getShowingPopovers() {
                return this.showingPopovers;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public static final /* synthetic */ void access$installBackPressCallbackIfNeeded(Companion r0, Activity r1) {
            r0.installBackPressCallbackIfNeeded(r1);
        }

        public static final /* synthetic */ void access$registerShowingPopover(Companion r0, Activity r1, OPopoverModal r2) {
            r0.registerShowingPopover(r1, r2);
        }

        public static final /* synthetic */ OPopoverModal access$topShowingPopoverLocked(Companion r0, Activity r1) {
            return r0.topShowingPopoverLocked(r1);
        }

        public static final /* synthetic */ void access$unregisterShowingPopover(Companion r0, Activity r1, OPopoverModal r2) {
            r0.unregisterShowingPopover(r1, r2);
        }

        private final synchronized void cleanupBackPressManagerLocked(Activity r4) {
            monitor-enter(this);
            BackPressManager r0 = (BackPressManager) OPopoverModal.access$getBackPressManagerByActivity$cp().get(r4);     // Catch: Throwable -> L15
            if (r0 != null) goto L7;
            monitor-exit(this);
            return;
        L7:
            CollectionsKt.removeAll(r0.getShowingPopovers(), OPopoverModal$Companion$cleanupBackPressManagerLocked$1.INSTANCE);     // Catch: Throwable -> L15
            if (r0.getShowingPopovers().isEmpty() == true) goto L10;
        L13:
            monitor-exit(this);
            return;
        L10:
            if (r4.getWindow().getCallback() != r0.getProxyCallback()) goto L12;
            r4.getWindow().setCallback(r0.getOriginalCallback());     // Catch: Throwable -> L15
        L12:
            OPopoverModal.access$getBackPressManagerByActivity$cp().remove(r4);     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            throw th;
        }

        private final synchronized OPopoverModal topShowingPopoverLocked(Activity r5) {
            monitor-enter(this);
            cleanupBackPressManagerLocked(r5);     // Catch: Throwable -> L22
            BackPressManager r6 = (BackPressManager) OPopoverModal.access$getBackPressManagerByActivity$cp().get(r5);     // Catch: Throwable -> L22
            if (r6 != null) goto L8;
            monitor-exit(this);
            return null;
        L8:
            int r1 = r6.getShowingPopovers().size() - 1;     // Catch: Throwable -> L22
            if (r1 < 0) goto L20;
        L10:
            int r2 = r1 - 1;     // Catch: Throwable -> L22
            OPopoverModal r3 = r6.getShowingPopovers().get(r1).get();     // Catch: Throwable -> L22
            if (r3 == null) goto L17;
            if (r3.isShowing() == false) goto L17;
            monitor-exit(this);
            return r3;
        L17:
            if (r2 < 0) goto L20;
            r1 = r2;
        L20:
            monitor-exit(this);
            return null;
        L22:
            th = move-exception;
            throw th;
        }

        private final synchronized void installBackPressCallbackIfNeeded(final Activity r10) {
            monitor-enter(this);
            cleanupBackPressManagerLocked(r10);     // Catch: Throwable -> L14
            if (OPopoverModal.access$getBackPressManagerByActivity$cp().containsKey(r10) == false) goto L7;
            monitor-exit(this);
            return;
        L7:
            final Window.Callback r2 = r10.getWindow().getCallback();     // Catch: Throwable -> L14
            if (r2 != null) goto L11;
            monitor-exit(this);
            return;
        L11:
            Window.Callback r0 = new OPopoverModal$Companion$installBackPressCallbackIfNeeded$proxyCallback$1(r2, r10);     // Catch: Throwable -> L14
            OPopoverModal.access$getBackPressManagerByActivity$cp().put(r10, new BackPressManager(r2, r0, null, 4, null));     // Catch: Throwable -> L14
            r10.getWindow().setCallback(r0);     // Catch: Throwable -> L14
            monitor-exit(this);
            return;
        L14:
            th = move-exception;
            throw th;
        }

        private final synchronized void registerShowingPopover(Activity r3, final OPopoverModal r4) {
            monitor-enter(this);
            BackPressManager r5 = (BackPressManager) OPopoverModal.access$getBackPressManagerByActivity$cp().get(r3);     // Catch: Throwable -> L10
            if (r5 != null) goto L7;
            monitor-exit(this);
            return;
        L7:
            CollectionsKt.removeAll(r5.getShowingPopovers(), new OPopoverModal$Companion$registerShowingPopover$1(r4));     // Catch: Throwable -> L10
            r5.getShowingPopovers().add(new WeakReference(r4));     // Catch: Throwable -> L10
            monitor-exit(this);
            return;
        L10:
            th = move-exception;
            throw th;
        }

        private final synchronized void unregisterShowingPopover(Activity r3, final OPopoverModal r4) {
            monitor-enter(this);
            BackPressManager r0 = (BackPressManager) OPopoverModal.access$getBackPressManagerByActivity$cp().get(r3);     // Catch: Throwable -> L10
            if (r0 != null) goto L7;
            monitor-exit(this);
            return;
        L7:
            CollectionsKt.removeAll(r0.getShowingPopovers(), new OPopoverModal$Companion$unregisterShowingPopover$1(r4));     // Catch: Throwable -> L10
            cleanupBackPressManagerLocked(r3);     // Catch: Throwable -> L10
            monitor-exit(this);
            return;
        L10:
            th = move-exception;
            throw th;
        }
    }

    public static /* synthetic */ void $r8$lambda$ITU9Ed6CarBy8avOtltjHwx6qMA(OPopoverModal r0) {
        m451detachedCleanupRunnable$lambda1(r0);
    }

    public static /* synthetic */ void $r8$lambda$MCQp3jlraLT3JF5u1jkgjomIbxU(OPopoverModal r0) {
        m450autoDismissRunnable$lambda0(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$OsmWkCSgCCxskat0xeKT9e45K4k(OPopoverModal r0, View r1, MotionEvent r2) {
        return m452setupOutsideTouchHandler$lambda2(r0, r1, r2);
    }

    public OPopoverModal(OPopover.Builder r5) {
        Intrinsics.checkNotNullParameter(r5, "builder");
        super(r5.getContext());
        this.popoverShowWithAnimation = r5.getMShowWithAnimation();
        this.popoverAnimationDurationMillis = r5.getMAnimTime();
        this.popoverGravity = OPopover.Companion.adaptGravity$OUI_standardRelease(r5.getMGravity());
        this.popoverXOffset = r5.getMXOffset();
        this.popoverYOffset = r5.getMYOffset();
        this.mAutoDismissDelayMillis = r5.getMAutoDismissDelayMillis();
        this.mOutsideTouchable = r5.getMOutsideTouchable();
        this.mEnableBackPressDismiss = r5.getMEnableBackPressDismiss();
        this.mShadowEnabled = r5.getMShadowEnabled();
        this.mShadowStyle = r5.getShadowStyle();
        this.mSpacingForShadow = r5.getMSpacingForShadow();
        View r0 = requirePopoverContentView(r5.getMView());
        this.mView = r0;
        this.bubbleStartDismissListener = r5.getMStartDismissListener();
        this.bubbleDismissListener = r5.getMDismissListener();
        this.bubbleShowListener = r5.getMShowListener();
        this.removeOnDismiss = true;
        this.popoverAnchorCenterX = Float.NaN;
        this.popoverAnchorCenterY = Float.NaN;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.popoverDisplayOrientation = r5.getMDisplayOrientation();
        this.popoverBgColor = r5.getMBgColor();
        this.popoverBorderWidth = r5.getMBorderWidth();
        this.popoverBorderColor = r5.getMBorderColor();
        this.popoverTransparentBg = r5.getTransparentBg();
        this.popoverWidth = r5.getMWidth();
        this.popoverHeight = r5.getMHeight();
        this.popoverEnableBubbleMaterial = r5.getMEnableBubbleMaterial();
        this.popoverMaterials = r5.getMMaterials();
        this.popoverCoverPreviousWhenStacked = r5.getMCoverPreviousWhenStacked();
        this.popoverStackCoverColor = r5.getMStackCoverColor();
        this.popoverStackAlphaPrevious = r5.getMStackAlphaPrevious();
        this.popoverStackScalePrevious = r5.getMStackScalePrevious();
        this.autoDismissRunnable = new OPopoverModal$$ExternalSyntheticLambda0(this);
        this.detachedCleanupRunnable = new OPopoverModal$$ExternalSyntheticLambda1(this);
        setVisibility(8);
        setClipChildren(false);
        setClipToPadding(false);
        setClickable(true);
        setFocusable(true);
        setBackgroundColor(0);
        setBubbleLayout(r0);
        initContentView();
        setupOutsideTouchHandler();
    }

    public static final /* synthetic */ Map access$getBackPressManagerByActivity$cp() {
        return backPressManagerByActivity;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void afterShowInStackIfNeeded() {
        OPopoverBase.DefaultImpls.afterShowInStackIfNeeded(this);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void beforeShowInStackIfNeeded() {
        OPopoverBase.DefaultImpls.beforeShowInStackIfNeeded(this);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void cancelPopoverAnimatorInternal() {
        OPopoverBase.DefaultImpls.cancelPopoverAnimatorInternal(this);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public OPopoverLayout createPopoverBubbleLayout(View r1, int r2) {
        return OPopoverBase.DefaultImpls.createPopoverBubbleLayout(this, r1, r2);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public View getContentViewInternal() {
        return OPopoverBase.DefaultImpls.getContentViewInternal(this);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getDisplayRotationDegreesInternal() {
        return OPopoverBase.DefaultImpls.getDisplayRotationDegreesInternal(this);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public Animator getPopoverEnterAnimator() {
        return OPopoverBase.DefaultImpls.getPopoverEnterAnimator(this);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public Animator getPopoverExitAnimator() {
        return OPopoverBase.DefaultImpls.getPopoverExitAnimator(this);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void measurePopoverContent(View r1, int r2, int r3) {
        OPopoverBase.DefaultImpls.measurePopoverContent(this, r1, r2, r3);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void measurePopupInternal(int r1, int r2) {
        OPopoverBase.DefaultImpls.measurePopupInternal(this, r1, r2);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void onDestroyInStackIfNeeded() {
        OPopoverBase.DefaultImpls.onDestroyInStackIfNeeded(this);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void playPopoverEnterAnimationInternal() {
        OPopoverBase.DefaultImpls.playPopoverEnterAnimationInternal(this);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void playPopoverExitAnimationInternal() {
        OPopoverBase.DefaultImpls.playPopoverExitAnimationInternal(this);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public View requirePopoverContentView(View r1) {
        return OPopoverBase.DefaultImpls.requirePopoverContentView(this, r1);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void resetPopoverAnimatedViewState(View r1) {
        OPopoverBase.DefaultImpls.resetPopoverAnimatedViewState(this, r1);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public float resolvePopoverPivot(float r1, int r2, float r3) {
        return OPopoverBase.DefaultImpls.resolvePopoverPivot(this, r1, r2, r3);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public OPopoverBase.ShadowPadding resolvePopoverShadowPadding(int r1) {
        return OPopoverBase.DefaultImpls.resolvePopoverShadowPadding(this, r1);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public float resolvePopoverShadowSpace(int r1) {
        return OPopoverBase.DefaultImpls.resolvePopoverShadowSpace(this, r1);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setGravityInternal(int r1) {
        OPopoverBase.DefaultImpls.setGravityInternal(this, r1);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setMaxContentHeightInternal(int r1, View r2) {
        OPopoverBase.DefaultImpls.setMaxContentHeightInternal(this, r1, r2);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverMaxContentHeight(int r1, View r2, int r3, int r4) {
        OPopoverBase.DefaultImpls.setPopoverMaxContentHeight(this, r1, r2, r3, r4);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setXOffsetInternal(int r1) {
        OPopoverBase.DefaultImpls.setXOffsetInternal(this, r1);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setYOffsetInternal(int r1) {
        OPopoverBase.DefaultImpls.setYOffsetInternal(this, r1);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public boolean shouldAnimatePopoverVisibilityInternal() {
        return OPopoverBase.DefaultImpls.shouldAnimatePopoverVisibilityInternal(this);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void showPopoverDirectlyInternal(ViewGroup r1, Function0<Unit> r2) {
        OPopoverBase.DefaultImpls.showPopoverDirectlyInternal(this, r1, r2);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void showPopoverWithoutAnimationInternal() {
        OPopoverBase.DefaultImpls.showPopoverWithoutAnimationInternal(this);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public AnimatorSet startPopoverVisibilityAnimationInternal(boolean r8, int r9, boolean r10, Animator r11, Function0<Unit> r12, Function0<Unit> r13) {
        return OPopoverBase.DefaultImpls.startPopoverVisibilityAnimationInternal(this, r8, r9, r10, r11, r12, r13);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void updatePopoverPivotInternal() {
        OPopoverBase.DefaultImpls.updatePopoverPivotInternal(this);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public boolean getPopoverShowWithAnimation() {
        return this.popoverShowWithAnimation;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public long getPopoverAnimationDurationMillis() {
        return this.popoverAnimationDurationMillis;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public boolean getPopoverAnimationIsWindowMode() {
        return this.popoverAnimationIsWindowMode;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverGravity() {
        return this.popoverGravity;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverGravity(int r1) {
        this.popoverGravity = r1;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverXOffset() {
        return this.popoverXOffset;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverXOffset(int r1) {
        this.popoverXOffset = r1;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverYOffset() {
        return this.popoverYOffset;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverYOffset(int r1) {
        this.popoverYOffset = r1;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public OPopoverLayout getPopoverBubbleLayout() {
        OPopoverLayout r0 = this.popoverBubbleLayout;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("popoverBubbleLayout");
        return null;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverBubbleLayout(OPopoverLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.popoverBubbleLayout = r2;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public ViewGroup getPopoverWindowFrame() {
        ViewGroup r0 = this.popoverWindowFrame;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("popoverWindowFrame");
        return null;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverWindowFrame(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.popoverWindowFrame = r2;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public AnimatorSet getPopoverAnimator() {
        return this.popoverAnimator;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverAnimator(AnimatorSet r1) {
        this.popoverAnimator = r1;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public float getPopoverAnchorCenterX() {
        return this.popoverAnchorCenterX;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverAnchorCenterX(float r1) {
        this.popoverAnchorCenterX = r1;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public float getPopoverAnchorCenterY() {
        return this.popoverAnchorCenterY;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverAnchorCenterY(float r1) {
        this.popoverAnchorCenterY = r1;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverPopupOriginX() {
        return this.popoverPopupOriginX;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverPopupOriginX(int r1) {
        this.popoverPopupOriginX = r1;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverPopupOriginY() {
        return this.popoverPopupOriginY;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverPopupOriginY(int r1) {
        this.popoverPopupOriginY = r1;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public boolean getPopoverPushedToStack() {
        return this.popoverPushedToStack;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverPushedToStack(boolean r1) {
        this.popoverPushedToStack = r1;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public boolean getPopoverRemovedFromStack() {
        return this.popoverRemovedFromStack;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverRemovedFromStack(boolean r1) {
        this.popoverRemovedFromStack = r1;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public boolean isPopoverBubbleLayoutInitialized() {
        if (this.popoverBubbleLayout == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public Context getPopoverContext() {
        Context r1 = getContext();
        Intrinsics.checkNotNullExpressionValue(r1, "context");
        return r1;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverDisplayOrientation() {
        return this.popoverDisplayOrientation;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverBgColor() {
        return this.popoverBgColor;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverBorderWidth() {
        return this.popoverBorderWidth;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverBorderColor() {
        return this.popoverBorderColor;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public boolean getPopoverTransparentBg() {
        return this.popoverTransparentBg;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverWidth() {
        return this.popoverWidth;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverHeight() {
        return this.popoverHeight;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public boolean getPopoverEnableBubbleMaterial() {
        return this.popoverEnableBubbleMaterial;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public Function1<Boolean, MaterialConfig[]> getPopoverMaterials() {
        return this.popoverMaterials;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public boolean getPopoverCoverPreviousWhenStacked() {
        return this.popoverCoverPreviousWhenStacked;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverStackCoverColor() {
        return this.popoverStackCoverColor;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public float getPopoverStackAlphaPrevious() {
        return this.popoverStackAlphaPrevious;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public float getPopoverStackScalePrevious() {
        return this.popoverStackScalePrevious;
    }

    public final boolean isShowing() {
        return this.isShowing;
    }

    /* JADX INFO: renamed from: autoDismissRunnable$lambda-0, reason: not valid java name */
    private static final void m450autoDismissRunnable$lambda0(OPopoverModal r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        if (r1.isShowing == false) goto L6;
        r1.dismiss();
        return;
    }

    /* JADX INFO: renamed from: detachedCleanupRunnable$lambda-1, reason: not valid java name */
    private static final void m451detachedCleanupRunnable$lambda1(OPopoverModal r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        if (r1.isAttachedToWindow() == false) goto L5;
        return;
    L5:
        if (r1.getParent() != null) goto L9;
        r1.performDetachedCleanup();
        return;
    }

    private final void setBubbleLayout(View r2) {
        setPopoverBubbleLayout(createPopoverBubbleLayout(r2, 2));
        OMaterialExtBaseKt.setMaterialBackdropTarget(getPopoverBubbleLayout(), this);
    }

    private final void initContentView() {
        if (getPopoverBgColor() == 0) goto L6;
        getPopoverBubbleLayout().setBgColor(getPopoverBgColor());
    L6:
        if (getPopoverBubbleLayout().isEnableMaterial() == true) goto L8;
        getPopoverBubbleLayout().setBorderColor(getPopoverBgColor());
        getPopoverBubbleLayout().setBorderWidth(getPopoverBorderWidth());
    L8:
        getPopoverBubbleLayout().setTransparentBg(getPopoverTransparentBg());
    }

    private final void setupOutsideTouchHandler() {
        setOnTouchListener(new OPopoverModal$$ExternalSyntheticLambda2(this));
    }

    /* JADX INFO: renamed from: setupOutsideTouchHandler$lambda-2, reason: not valid java name */
    private static final boolean m452setupOutsideTouchHandler$lambda2(OPopoverModal r1, View r2, MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        if (r1.isShowing == true) goto L6;
        return false;
    L6:
        if (r3.getAction() == 0) goto L8;
        return false;
    L8:
        if (r1.mOutsideTouchable == false) goto L13;
        r1.dismiss();
        return true;
    L13:
        return true;
    }

    public final void setOnDismissListener(Function0<Unit> r1) {
        this.dismissListener = r1;
    }

    public final void setOnShowListener(Function0<Unit> r1) {
        this.showListener = r1;
    }

    public final void setOnBubbleShowListener(OPopover.OnBubbleShowListener r1) {
        this.bubbleShowListener = r1;
    }

    public final void setOnBubbleStartDismissListener(OPopover.OnBubbleStartDismissListener r1) {
        this.bubbleStartDismissListener = r1;
    }

    public final void setOnBubbleDismissListener(OPopover.OnBubbleDismissListener r1) {
        this.bubbleDismissListener = r1;
    }

    public final void setRemoveOnDismiss(boolean r1) {
        this.removeOnDismiss = r1;
    }

    public final void setEnableAutoDismiss(boolean r5) {
        removeCallbacks(this.autoDismissRunnable);
        if (r5 == false) goto L8;
        long r0 = this.mAutoDismissDelayMillis;
        if (r0 <= 0) goto L9;
        postDelayed(this.autoDismissRunnable, r0);
        return;
    L9:
        return;
    }

    public final void setXOffset(int r1) {
        setXOffsetInternal(r1);
    }

    public final void setYOffset(int r1) {
        setYOffsetInternal(r1);
    }

    public final View getContentView() {
        return getContentViewInternal();
    }

    public final void measurePopup(int r1, int r2) {
        measurePopupInternal(r1, r2);
    }

    public final int getDisplayRotationDegrees$OUI_standardRelease() {
        return getDisplayRotationDegreesInternal();
    }

    public static /* synthetic */ ViewGroup resolveHostParent$OUI_standardRelease$default(OPopoverModal r0, ViewGroup r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L7;
        r1 = null;
    L7:
        return r0.resolveHostParent$OUI_standardRelease(r1);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resolveHostParent");
    }

    public final ViewGroup resolveHostParent$OUI_standardRelease(ViewGroup r1) {
        if (r1 == null) goto L4;
        return r1;
    L4:
        return findDecorViewParent();
    }

    public final void setGravity$OUI_standardRelease(int r1) {
        setGravityInternal(r1);
    }

    public static /* synthetic */ void showAtLocation$default(OPopoverModal r6, View r7, ViewGroup r8, int r9, int r10, int r11, int r12, Object r13) {
        if (r13 != null) goto L9;
        if ((r12 & 2) == 0) goto L6;
        r8 = null;
    L6:
        r6.showAtLocation(r7, r8, r9, r10, r11);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showAtLocation");
    }

    public final void showAtLocation(View r7, ViewGroup r8, int r9, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r7, "anchor");
        ViewGroup r12 = resolveHostParent$OUI_standardRelease(r8);
        if (r12 != null) goto L5;
        return;
    L5:
        ensureAttachedToParent(r12);
        this.currentHostParent = r12;
        this.currentAnchorRef = new WeakReference(r7);
        if (r9 == 0) goto L8;
        setGravity$OUI_standardRelease(r9);
    L8:
        bringToFront();
        setVisibility(0);
        removeCallbacks(this.autoDismissRunnable);
        long r0 = this.mAutoDismissDelayMillis;
        if (r0 <= 0) goto L12;
        postDelayed(this.autoDismissRunnable, r0);
    L12:
        if (this.isShowing == false) goto L15;
        getPopoverWindowFrame().setVisibility(0);
        updatePopoverPivotInternal();
        return;
    L15:
        this.isShowing = true;
        interceptBackPressedIfNeeded();
        beforeShowInStackIfNeeded();
        Pair<Integer, Integer> r1 = addShadowFrameIfNeeded(r10, r11);
        int[] r3 = new int[2];
        r7.getLocationInWindow(r3);
        setPopoverAnchorCenterX(r3[0] + (r7.getWidth() / 2.0f));
        setPopoverAnchorCenterY(r3[1] + (r7.getHeight() / 2.0f));
        int[] r13 = new int[2];
        r12.getLocationInWindow(r13);
        int r14 = r10 - r1.getFirst().intValue();
        int r15 = r11 - r1.getSecond().intValue();
        setPopoverPopupOriginX(r14 + getPopoverXOffset());
        setPopoverPopupOriginY(r15 + getPopoverYOffset());
        ViewGroup.LayoutParams r16 = getPopoverWindowFrame().getLayoutParams();
        if (r16 == null) goto L23;
        FrameLayout.LayoutParams r17 = (FrameLayout.LayoutParams) r16;
        r17.gravity = 51;
        r17.topMargin = getPopoverPopupOriginY() - r13[1];
        getPopoverWindowFrame().setLayoutParams(r17);
        afterShowInStackIfNeeded();
        if (shouldAnimatePopoverVisibilityInternal() == true) goto L20;
        showPopoverWithoutAnimationInternal();
        return;
    L20:
        playPopoverEnterAnimationInternal();
        return;
    L23:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    public final void dismiss() {
        if (this.isShowing == true) goto L5;
        return;
    L5:
        removeCallbacks(this.autoDismissRunnable);
        if (shouldAnimatePopoverVisibilityInternal() == true) goto L8;
        finishPopoverDismissInternal();
        return;
    L8:
        playPopoverExitAnimationInternal();
    }

    public final void dismissDirectly() {
        if (this.isShowing == true) goto L5;
        return;
    L5:
        removeCallbacks(this.autoDismissRunnable);
        finishPopoverDismissInternal();
    }

    public final void onDestroy() {
        dismissDirectly();
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int resolvePopoverAnimationGravityInternal() {
        return getPopoverGravity() & 112;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void onPopoverShownInternal() {
        OPopover.OnBubbleShowListener r0 = this.bubbleShowListener;
        if (r0 == null) goto L6;
        r0.bubbleShow();
    L6:
        Function0<Unit> r1 = this.showListener;
        if (r1 == null) goto L11;
        r1.invoke();
        return;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void onPopoverStartDismissInternal() {
        OPopover.OnBubbleStartDismissListener r0 = this.bubbleStartDismissListener;
        if (r0 == null) goto L7;
        r0.bubbleStartDismiss();
        return;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void finishPopoverDismissInternal() {
        ViewGroup r0 = null;
        setPopoverAnimator(null);
        this.isShowing = false;
        restoreWindowCallback();
        setVisibility(8);
        getPopoverWindowFrame().setVisibility(4);
        OPopoverBase.DefaultImpls.resetPopoverAnimatedViewState$default(this, null, 1, null);
        cleanupFakeAnchorIfNeeded();
        onDestroyInStackIfNeeded();
        if (this.removeOnDismiss == false) goto L10;
        ViewParent r1 = getParent();
        if ((r1 instanceof ViewGroup) == false) goto L7;
        r0 = (ViewGroup) r1;
    L7:
        if (r0 == null) goto L10;
        r0.removeView(this);
    L10:
        OPopover.OnBubbleDismissListener r2 = this.bubbleDismissListener;
        if (r2 == null) goto L14;
        r2.bubbleDismiss();
    L14:
        Function0<Unit> r3 = this.dismissListener;
        if (r3 == null) goto L19;
        r3.invoke();
        return;
    }

    private final void interceptBackPressedIfNeeded() {
        if (this.mEnableBackPressDismiss == true) goto L5;
        return;
    L5:
        OWindowConfigController r0 = OWindowConfigController.INSTANCE;
        Context r1 = getContext();
        Intrinsics.checkNotNullExpressionValue(r1, "context");
        Activity r2 = r0.getActivity(r1);
        if (r2 != null) goto L8;
        return;
    L8:
        Companion r3 = Companion;
        Companion.access$installBackPressCallbackIfNeeded(r3, r2);
        Companion.access$registerShowingPopover(r3, r2, this);
    }

    private final void restoreWindowCallback() {
        OWindowConfigController r0 = OWindowConfigController.INSTANCE;
        Context r1 = getContext();
        Intrinsics.checkNotNullExpressionValue(r1, "context");
        Activity r2 = r0.getActivity(r1);
        if (r2 != null) goto L5;
        return;
    L5:
        Companion.access$unregisterShowingPopover(Companion, r2, this);
    }

    private final void cleanupFakeAnchorIfNeeded() {
        WeakReference<View> r0 = this.currentAnchorRef;
        if (r0 != null) goto L5;
        View r1 = null;
    L7:
        if ((r1 instanceof FakeAnchorView) == false) goto L15;
        ViewParent r2 = ((FakeAnchorView) r1).getParent();
        if ((r2 instanceof ViewGroup) == false) goto L11;
        ViewGroup r3 = (ViewGroup) r2;
    L12:
        if (r3 == null) goto L15;
        r3.removeView(r1);
        goto L15
    L11:
        r3 = null;
    L15:
        this.currentAnchorRef = null;
        this.currentHostParent = null;
        return;
    L5:
        r1 = r0.get();
        goto L7
    }

    private final void performDetachedCleanup() {
        cancelPopoverAnimatorInternal();
        this.isShowing = false;
        setVisibility(8);
        getPopoverWindowFrame().setVisibility(4);
        OPopoverBase.DefaultImpls.resetPopoverAnimatedViewState$default(this, null, 1, null);
        cleanupFakeAnchorIfNeeded();
        onDestroyInStackIfNeeded();
    }

    private final void ensureAttachedToParent(ViewGroup r3) {
        if (getParent() != r3) goto L5;
        return;
    L5:
        ViewParent r0 = getParent();
        if ((r0 instanceof ViewGroup) == false) goto L8;
        ViewGroup r1 = (ViewGroup) r0;
    L9:
        if (r1 == null) goto L12;
        r1.removeView(this);
    L12:
        r3.addView(this, new ViewGroup.LayoutParams(-1, -1));
        return;
    L8:
        r1 = null;
        goto L9
    }

    private final ViewGroup findDecorViewParent() {
        Context r0 = getContext();
    L4:
        if ((r0 instanceof ContextWrapper) == false) goto L16;
        if ((r0 instanceof Activity) == true) goto L7;
        r0 = ((ContextWrapper) r0).getBaseContext();
        goto L4
    L7:
        Window r3 = ((Activity) r0).getWindow();
        if (r3 != null) goto L10;
        View r4 = null;
    L12:
        if ((r4 instanceof ViewGroup) == true) goto L14;
        return null;
    L14:
        return (ViewGroup) r4;
    L10:
        r4 = r3.getDecorView();
        goto L12
    L16:
        Context r5 = getContext();
        if ((r5 instanceof Activity) == false) goto L19;
        Activity r6 = (Activity) r5;
    L20:
        if (r6 != null) goto L22;
    L21:
        View r7 = null;
    L27:
        if ((r7 instanceof ViewGroup) == true) goto L29;
        return null;
    L29:
        return (ViewGroup) r7;
    L22:
        Window r8 = r6.getWindow();
        if (r8 == null) goto L21;
        r7 = r8.getDecorView();
        goto L27
    L19:
        r6 = null;
        goto L20
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        restoreWindowCallback();
        super.onDetachedFromWindow();
        removeCallbacks(this.autoDismissRunnable);
        this.mainHandler.removeCallbacks(this.detachedCleanupRunnable);
        this.mainHandler.post(this.detachedCleanupRunnable);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        this.mainHandler.removeCallbacks(this.detachedCleanupRunnable);
        super.onAttachedToWindow();
    }

    public final void setMaxContentHeight(int r3) {
        OPopoverBase.DefaultImpls.setMaxContentHeightInternal$default(this, r3, null, 2, null);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public boolean isPopoverShowing() {
        return this.isShowing;
    }

    private final Pair<Integer, Integer> addShadowFrameIfNeeded(int r2, int r3) {
        if (this.mShadowEnabled == false) goto L6;
        return addShadowFrame(r2, r3);
    L6:
        return new Pair(0, 0);
    }

    private final Pair<Integer, Integer> addShadowFrame(int r12, int r13) {
        View r14 = LayoutInflater.from(getContext()).inflate(R.layout.o_layout_popover_shadow_frame, this, false);
        if (r14 == null) goto L11;
        SingleChildFrameLayout r15 = (SingleChildFrameLayout) r14;
        r15.addView(getPopoverBubbleLayout(), new FrameLayout.LayoutParams(-2, -2));
        r15.setShadowCornerRadius(MathKt.roundToInt(getPopoverBubbleLayout().getCornerRadius()));
        r15.setShadowInsets(getPopoverBubbleLayout().getArrowHeight(), getPopoverBubbleLayout().getArrowHeight());
        r15.setClipChildren(false);
        r15.setClipToPadding(false);
        if (this.mSpacingForShadow == false) goto L7;
        OPopoverBase.ShadowPadding r0 = resolvePopoverShadowPadding(this.mShadowStyle);
    L8:
        this.popoverContentView = r15;
        Context r4 = getContext();
        Intrinsics.checkNotNullExpressionValue(r4, "context");
        SingleChildFrameLayout r1 = new SingleChildFrameLayout(r4, null, 2, null);
        r1.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -2));
        r1.addView(r15, new FrameLayout.LayoutParams(-2, -2));
        r1.setClipChildren(false);
        r1.setClipToPadding(false);
        r1.setPadding(0, r0.getTop(), 0, r0.getBottom());
        r15.setX(r12);
        setPopoverWindowFrame(r1);
        getPopoverWindowFrame().setVisibility(4);
        addView(getPopoverWindowFrame(), new FrameLayout.LayoutParams(-1, -2));
        return new Pair(Integer.valueOf(r12), Integer.valueOf(r0.getTop()));
    L7:
        r0 = new OPopoverBase.ShadowPadding(0, 0, 0, 0, 15, null);
        goto L8
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.popover.SingleChildFrameLayout");
    }

    static {
        Companion = new Companion(null);
        backPressManagerByActivity = new LinkedHashMap();
    }
}
