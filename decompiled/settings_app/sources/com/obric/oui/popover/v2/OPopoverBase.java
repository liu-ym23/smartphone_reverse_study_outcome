package com.obric.oui.popover.v2;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.icu.text.PluralRules;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.oui.common.style.OUILayoutHelper;
import com.obric.oui.common.style.Shadow;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.material.MaterialConfig;
import com.obric.oui.popover.menu.OPopoverMenuView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: OPopoverBase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u0000 ¢\u0001*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0006¢\u0001£\u0001¤\u0001J\b\u0010j\u001a\u00020kH\u0016J\b\u0010l\u001a\u00020kH\u0016J\b\u0010m\u001a\u00020kH\u0016J\u001a\u0010n\u001a\u00020$2\u0006\u0010o\u001a\u00020p2\b\b\u0002\u0010q\u001a\u00020\u001cH\u0016J\b\u0010r\u001a\u00020kH&J\b\u0010s\u001a\u00020pH\u0016J\b\u0010t\u001a\u00020\u001cH\u0016J\b\u0010u\u001a\u00020\u0004H&J \u0010v\u001a\u00020k2\u0006\u0010w\u001a\u00020p2\u0006\u0010x\u001a\u00020\u001c2\u0006\u0010y\u001a\u00020\u001cH\u0016J\u0018\u0010z\u001a\u00020k2\u0006\u0010x\u001a\u00020\u001c2\u0006\u0010y\u001a\u00020\u001cH\u0016J\b\u0010{\u001a\u00020kH\u0016J\b\u0010|\u001a\u00020kH&J\b\u0010}\u001a\u00020kH&J\b\u0010~\u001a\u00020kH\u0017J\b\u0010\u007f\u001a\u00020kH\u0017J\u0014\u0010\u0080\u0001\u001a\u00020p2\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010pH\u0016J\u0014\u0010\u0082\u0001\u001a\u00020k2\t\b\u0002\u0010\u0081\u0001\u001a\u00020pH\u0016J\t\u0010\u0083\u0001\u001a\u00020\u001cH\u0016J$\u0010\u0084\u0001\u001a\u00020\u00072\u0007\u0010\u0085\u0001\u001a\u00020\u00072\u0007\u0010\u0086\u0001\u001a\u00020\u001c2\u0007\u0010\u0087\u0001\u001a\u00020\u0007H\u0016J\u0015\u0010\u0088\u0001\u001a\u00030\u0089\u00012\t\b\u0001\u0010\u008a\u0001\u001a\u00020\u001cH\u0016J\u0014\u0010\u008b\u0001\u001a\u00020\u00072\t\b\u0001\u0010\u008a\u0001\u001a\u00020\u001cH\u0016J\u0012\u0010\u008c\u0001\u001a\u00020k2\u0007\u0010\u008d\u0001\u001a\u00020\u001cH\u0016J\u001d\u0010\u008e\u0001\u001a\u00020k2\u0007\u0010\u008f\u0001\u001a\u00020\u001c2\t\b\u0002\u0010\u0090\u0001\u001a\u00020pH\u0016J+\u0010\u0091\u0001\u001a\u00020k2\u0007\u0010\u008f\u0001\u001a\u00020\u001c2\u0007\u0010\u0090\u0001\u001a\u00020p2\u0006\u0010x\u001a\u00020\u001c2\u0006\u0010y\u001a\u00020\u001cH\u0016J\u0012\u0010\u0092\u0001\u001a\u00020k2\u0007\u0010\u0093\u0001\u001a\u00020\u001cH\u0016J\u0012\u0010\u0094\u0001\u001a\u00020k2\u0007\u0010\u0095\u0001\u001a\u00020\u001cH\u0016J\t\u0010\u0096\u0001\u001a\u00020\u0004H\u0016J(\u0010\u0097\u0001\u001a\u00020k2\t\b\u0002\u0010\u0081\u0001\u001a\u00020_2\u0012\b\u0002\u0010\u0098\u0001\u001a\u000b\u0012\u0004\u0012\u00020k\u0018\u00010\u0099\u0001H\u0016J\t\u0010\u009a\u0001\u001a\u00020kH\u0016J]\u0010\u009b\u0001\u001a\u00020\u00162\u0007\u0010\u009c\u0001\u001a\u00020\u00042\t\b\u0002\u0010\u008d\u0001\u001a\u00020\u001c2\t\b\u0002\u0010\u009d\u0001\u001a\u00020\u00042\u000b\b\u0002\u0010\u009e\u0001\u001a\u0004\u0018\u0001042\u0012\b\u0002\u0010\u009f\u0001\u001a\u000b\u0012\u0004\u0012\u00020k\u0018\u00010\u0099\u00012\u0012\b\u0002\u0010 \u0001\u001a\u000b\u0012\u0004\u0012\u00020k\u0018\u00010\u0099\u0001H\u0016J\t\u0010¡\u0001\u001a\u00020kH\u0016R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u0018\u0010\u0006\u001a\u00020\u0007X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u00020\u0007X¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0005R\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u0016X¦\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0012\u0010\u001b\u001a\u00020\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0012\u0010\u001f\u001a\u00020\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001eR\u0012\u0010!\u001a\u00020\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u001eR\u0018\u0010#\u001a\u00020$X¦\u000e¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0012\u0010)\u001a\u00020*X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0012\u0010-\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u0005R\u0012\u0010/\u001a\u00020\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u001eR\u0012\u00101\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u0005R\u0016\u00103\u001a\u0004\u0018\u0001048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u0016\u00107\u001a\u0004\u0018\u0001048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u00106R\u0018\u00109\u001a\u00020\u001cX¦\u000e¢\u0006\f\u001a\u0004\b:\u0010\u001e\"\u0004\b;\u0010<R\u0012\u0010=\u001a\u00020\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\u001eR$\u0010?\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020B0A0@X¦\u0004¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0018\u0010E\u001a\u00020\u001cX¦\u000e¢\u0006\f\u001a\u0004\bF\u0010\u001e\"\u0004\bG\u0010<R\u0018\u0010H\u001a\u00020\u001cX¦\u000e¢\u0006\f\u001a\u0004\bI\u0010\u001e\"\u0004\bJ\u0010<R\u0018\u0010K\u001a\u00020\u0004X¦\u000e¢\u0006\f\u001a\u0004\bL\u0010\u0005\"\u0004\bM\u0010NR\u0018\u0010O\u001a\u00020\u0004X¦\u000e¢\u0006\f\u001a\u0004\bP\u0010\u0005\"\u0004\bQ\u0010NR\u0012\u0010R\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\bS\u0010\u0005R\u0012\u0010T\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\bU\u0010\tR\u0014\u0010V\u001a\u00020\u001c8gX¦\u0004¢\u0006\u0006\u001a\u0004\bW\u0010\u001eR\u0012\u0010X\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\bY\u0010\tR\u0012\u0010Z\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\u0005R\u0012\u0010\\\u001a\u00020\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b]\u0010\u001eR\u0018\u0010^\u001a\u00020_X¦\u000e¢\u0006\f\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u0018\u0010d\u001a\u00020\u001cX¦\u000e¢\u0006\f\u001a\u0004\be\u0010\u001e\"\u0004\bf\u0010<R\u0018\u0010g\u001a\u00020\u001cX¦\u000e¢\u0006\f\u001a\u0004\bh\u0010\u001e\"\u0004\bi\u0010<¨\u0006¥\u0001"}, d2 = {"Lcom/obric/oui/popover/v2/OPopoverBase;", ExifInterface.GPS_DIRECTION_TRUE, "", "isPopoverBubbleLayoutInitialized", "", "()Z", "popoverAnchorCenterX", "", "getPopoverAnchorCenterX", "()F", "setPopoverAnchorCenterX", "(F)V", "popoverAnchorCenterY", "getPopoverAnchorCenterY", "setPopoverAnchorCenterY", "popoverAnimationDurationMillis", "", "getPopoverAnimationDurationMillis", "()J", "popoverAnimationIsWindowMode", "getPopoverAnimationIsWindowMode", "popoverAnimator", "Landroid/animation/AnimatorSet;", "getPopoverAnimator", "()Landroid/animation/AnimatorSet;", "setPopoverAnimator", "(Landroid/animation/AnimatorSet;)V", "popoverBgColor", "", "getPopoverBgColor", "()I", "popoverBorderColor", "getPopoverBorderColor", "popoverBorderWidth", "getPopoverBorderWidth", "popoverBubbleLayout", "Lcom/obric/oui/popover/v2/OPopoverLayout;", "getPopoverBubbleLayout", "()Lcom/obric/oui/popover/v2/OPopoverLayout;", "setPopoverBubbleLayout", "(Lcom/obric/oui/popover/v2/OPopoverLayout;)V", "popoverContext", "Landroid/content/Context;", "getPopoverContext", "()Landroid/content/Context;", "popoverCoverPreviousWhenStacked", "getPopoverCoverPreviousWhenStacked", "popoverDisplayOrientation", "getPopoverDisplayOrientation", "popoverEnableBubbleMaterial", "getPopoverEnableBubbleMaterial", "popoverEnterAnimator", "Landroid/animation/Animator;", "getPopoverEnterAnimator", "()Landroid/animation/Animator;", "popoverExitAnimator", "getPopoverExitAnimator", "popoverGravity", "getPopoverGravity", "setPopoverGravity", "(I)V", "popoverHeight", "getPopoverHeight", "popoverMaterials", "Lkotlin/Function1;", "", "Lcom/obric/oui/material/MaterialConfig;", "getPopoverMaterials", "()Lkotlin/jvm/functions/Function1;", "popoverPopupOriginX", "getPopoverPopupOriginX", "setPopoverPopupOriginX", "popoverPopupOriginY", "getPopoverPopupOriginY", "setPopoverPopupOriginY", "popoverPushedToStack", "getPopoverPushedToStack", "setPopoverPushedToStack", "(Z)V", "popoverRemovedFromStack", "getPopoverRemovedFromStack", "setPopoverRemovedFromStack", "popoverShowWithAnimation", "getPopoverShowWithAnimation", "popoverStackAlphaPrevious", "getPopoverStackAlphaPrevious", "popoverStackCoverColor", "getPopoverStackCoverColor", "popoverStackScalePrevious", "getPopoverStackScalePrevious", "popoverTransparentBg", "getPopoverTransparentBg", "popoverWidth", "getPopoverWidth", "popoverWindowFrame", "Landroid/view/ViewGroup;", "getPopoverWindowFrame", "()Landroid/view/ViewGroup;", "setPopoverWindowFrame", "(Landroid/view/ViewGroup;)V", "popoverXOffset", "getPopoverXOffset", "setPopoverXOffset", "popoverYOffset", "getPopoverYOffset", "setPopoverYOffset", "afterShowInStackIfNeeded", "", "beforeShowInStackIfNeeded", "cancelPopoverAnimatorInternal", "createPopoverBubbleLayout", "contentView", "Landroid/view/View;", "materialSourceType", "finishPopoverDismissInternal", "getContentViewInternal", "getDisplayRotationDegreesInternal", "isPopoverShowing", "measurePopoverContent", "target", "widthMeasureSpec", "heightMeasureSpec", "measurePopupInternal", "onDestroyInStackIfNeeded", "onPopoverShownInternal", "onPopoverStartDismissInternal", "playPopoverEnterAnimationInternal", "playPopoverExitAnimationInternal", "requirePopoverContentView", "view", "resetPopoverAnimatedViewState", "resolvePopoverAnimationGravityInternal", "resolvePopoverPivot", "anchorCenter", "popupOrigin", "fallback", "resolvePopoverShadowPadding", "Lcom/obric/oui/popover/v2/OPopoverBase$ShadowPadding;", "shadowStyleRes", "resolvePopoverShadowSpace", "setGravityInternal", "gravity", "setMaxContentHeightInternal", "maxHeight", "measureTarget", "setPopoverMaxContentHeight", "setXOffsetInternal", "xOffset", "setYOffsetInternal", "yOffset", "shouldAnimatePopoverVisibilityInternal", "showPopoverDirectlyInternal", "onShown", "Lkotlin/Function0;", "showPopoverWithoutAnimationInternal", "startPopoverVisibilityAnimationInternal", "isIn", "isWindowMode", "customAnimator", "onAnimationStart", "onAnimationEnd", "updatePopoverPivotInternal", "Companion", "ShadowPadding", "StackController", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface OPopoverBase<T> {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: OPopoverBase.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J \u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0006H\u0002¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/popover/v2/OPopoverBase$Companion;", "", "()V", "setMaxContentHeightIfPossible", "", "view", "Landroid/view/View;", "maxHeight", "", "wrapForDisplayOrientation", "context", "Landroid/content/Context;", "displayOrientation", "contentView", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }

        public static final /* synthetic */ void access$setMaxContentHeightIfPossible(Companion r0, View r1, int r2) {
            r0.setMaxContentHeightIfPossible(r1, r2);
        }

        public static final /* synthetic */ View access$wrapForDisplayOrientation(Companion r0, Context r1, int r2, View r3) {
            return r0.wrapForDisplayOrientation(r1, r2, r3);
        }

        private final View wrapForDisplayOrientation(Context r3, int r4, View r5) {
            boolean r0 = true;
            if (r4 != 1) goto L5;
            float r6 = 90.0f;
        L10:
            if (r6 == 0.0f) goto L13;
            r0 = false;
        L13:
            if (r0 == false) goto L15;
            return r5;
        L15:
            OPopoverLandscapeWrapper r2 = new OPopoverLandscapeWrapper(r3);
            r2.setOrientationAngle(r6);
            r2.addView(r5);
            return r2;
        L5:
            if (r4 == 3) goto L7;
            r6 = 0.0f;
            goto L10
        L7:
            r6 = 270.0f;
            goto L10
        }

        private final void setMaxContentHeightIfPossible(View r2, int r3) {
            if ((r2 instanceof OPopoverMenuView) == false) goto L6;
            ((OPopoverMenuView) r2).setPopoverMaxHeight(r3);
        L6:
            if ((r2 instanceof ViewGroup) == false) goto L11;
            Iterator<View> r1 = ViewGroupKt.getChildren((ViewGroup) r2).iterator();
        L9:
            if (r1.hasNext() == false) goto L13;
            View r4 = r1.next();
            $$INSTANCE.setMaxContentHeightIfPossible(r4, r3);
            goto L9
        L13:
            return;
        }
    }

    /* JADX INFO: compiled from: OPopoverBase.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <T> boolean getPopoverAnimationIsWindowMode(OPopoverBase<T> r1) {
            Intrinsics.checkNotNullParameter(r1, "this");
            return true;
        }

        public static <T> Animator getPopoverEnterAnimator(OPopoverBase<T> r1) {
            Intrinsics.checkNotNullParameter(r1, "this");
            return null;
        }

        public static <T> Animator getPopoverExitAnimator(OPopoverBase<T> r1) {
            Intrinsics.checkNotNullParameter(r1, "this");
            return null;
        }

        public static <T> View requirePopoverContentView(OPopoverBase<T> r1, View r2) {
            Intrinsics.checkNotNullParameter(r1, "this");
            if (r2 == null) goto L6;
            return r2;
        L6:
            throw new IllegalArgumentException("mView must be not null".toString());
        }

        public static /* synthetic */ OPopoverLayout createPopoverBubbleLayout$default(OPopoverBase r0, View r1, int r2, int r3, Object r4) {
            if (r4 != null) goto L9;
            if ((r3 & 2) == 0) goto L7;
            r2 = 3;
        L7:
            return r0.createPopoverBubbleLayout(r1, r2);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createPopoverBubbleLayout");
        }

        public static <T> OPopoverLayout createPopoverBubbleLayout(OPopoverBase<T> r4, View r5, int r6) {
            Intrinsics.checkNotNullParameter(r4, "this");
            Intrinsics.checkNotNullParameter(r5, "contentView");
            OPopoverLayout r0 = new OPopoverLayout(r4.getPopoverContext(), r4.getPopoverEnableBubbleMaterial(), r4.getPopoverMaterials(), r6);
            r0.setBackgroundColor(0);
            r0.setGravity(17);
            r0.addView(Companion.access$wrapForDisplayOrientation(OPopoverBase.Companion, r4.getPopoverContext(), r4.getPopoverDisplayOrientation(), r5));
            r0.setCornerRadius(OUnitExtensionKt.cdpFloat(r4.getPopoverContext(), OPopoverLayout.Companion.getCORNER_RADIUS_DP()));
            if (r4.getPopoverBgColor() == 0) goto L6;
            r0.setBgColor(r4.getPopoverBgColor());
        L6:
            if (r0.isEnableMaterial() == true) goto L8;
            r0.setBorderColor(r4.getPopoverBorderColor());
            r0.setBorderWidth(r4.getPopoverBorderWidth());
        L8:
            r0.setTransparentBg(r4.getPopoverTransparentBg());
            return r0;
        }

        public static <T> void measurePopoverContent(OPopoverBase<T> r1, View r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r1, "this");
            Intrinsics.checkNotNullParameter(r2, "target");
            if (r1.getPopoverWidth() != 0) goto L5;
        L7:
            r2.measure(r3, r4);
            return;
        L5:
            if (r1.getPopoverHeight() == 0) goto L7;
            r2.measure(View.MeasureSpec.makeMeasureSpec(r1.getPopoverWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(r1.getPopoverHeight(), 1073741824));
        }

        public static <T> void setPopoverMaxContentHeight(OPopoverBase<T> r2, int r3, View r4, int r5, int r6) {
            Intrinsics.checkNotNullParameter(r2, "this");
            Intrinsics.checkNotNullParameter(r4, "measureTarget");
            if (r3 > 0) goto L5;
            return;
        L5:
            int r7 = RangesKt.coerceAtLeast(r3 - (r2.getPopoverBubbleLayout().getArrowHeight() * 2), 0);
            Companion.access$setMaxContentHeightIfPossible(OPopoverBase.Companion, r2.getPopoverBubbleLayout(), r7);
            r2.getPopoverBubbleLayout().requestLayout();
            r2.measurePopoverContent(r4, r5, r6);
        }

        public static <T> float resolvePopoverPivot(OPopoverBase<T> r1, float r2, int r3, float r4) {
            Intrinsics.checkNotNullParameter(r1, "this");
            if (Float.isNaN(r2) == false) goto L6;
            return r4;
        L6:
            return r2 - r3;
        }

        public static <T> int getDisplayRotationDegreesInternal(OPopoverBase<T> r1) {
            Intrinsics.checkNotNullParameter(r1, "this");
            int r2 = r1.getPopoverDisplayOrientation();
            if (r2 != 1) goto L5;
            return 90;
        L5:
            if (r2 == 3) goto L7;
            return 0;
        L7:
            return 270;
        }

        public static <T> void setGravityInternal(OPopoverBase<T> r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "this");
            r1.setPopoverGravity(OPopover.Companion.adaptGravity$OUI_standardRelease(r2));
        }

        public static <T> void setXOffsetInternal(OPopoverBase<T> r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "this");
            r1.setPopoverXOffset(r2);
        }

        public static <T> void setYOffsetInternal(OPopoverBase<T> r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "this");
            r1.setPopoverYOffset(r2);
        }

        public static <T> View getContentViewInternal(OPopoverBase<T> r1) {
            Intrinsics.checkNotNullParameter(r1, "this");
            return r1.getPopoverBubbleLayout();
        }

        public static <T> void measurePopupInternal(OPopoverBase<T> r1, int r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, "this");
            r1.measurePopoverContent(r1.getContentViewInternal(), r2, r3);
        }

        public static <T> void updatePopoverPivotInternal(OPopoverBase<T> r5) {
            Intrinsics.checkNotNullParameter(r5, "this");
            r5.measurePopoverContent(r5.getContentViewInternal(), 0, 0);
            r5.getPopoverWindowFrame().setPivotX(r5.resolvePopoverPivot(r5.getPopoverAnchorCenterX(), r5.getPopoverPopupOriginX(), r5.getPopoverWindowFrame().getMeasuredWidth() / 2.0f));
            r5.getPopoverWindowFrame().setPivotY(r5.resolvePopoverPivot(r5.getPopoverAnchorCenterY(), r5.getPopoverPopupOriginY(), r5.getPopoverWindowFrame().getMeasuredHeight() / 2.0f));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void showPopoverDirectlyInternal$default(OPopoverBase r0, ViewGroup r1, Function0 r2, int r3, Object r4) {
            if (r4 != null) goto L12;
            if ((r3 & 1) == 0) goto L7;
            r1 = r0.getPopoverWindowFrame();
        L7:
            if ((r3 & 2) == 0) goto L9;
            r2 = null;
        L9:
            r0.showPopoverDirectlyInternal(r1, r2);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showPopoverDirectlyInternal");
        }

        public static <T> void showPopoverDirectlyInternal(OPopoverBase<T> r1, ViewGroup r2, Function0<Unit> r3) {
            Intrinsics.checkNotNullParameter(r1, "this");
            Intrinsics.checkNotNullParameter(r2, "view");
            r1.resetPopoverAnimatedViewState(r2);
            r2.setVisibility(0);
            if (r3 == null) goto L7;
            r3.invoke();
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AnimatorSet startPopoverVisibilityAnimationInternal$default(OPopoverBase r7, boolean r8, int r9, boolean r10, Animator r11, Function0 r12, Function0 r13, int r14, Object r15) {
            if (r15 != null) goto L24;
            if ((r14 & 2) == 0) goto L6;
            r9 = r7.getPopoverGravity();
        L6:
            int r2 = r9;
            if ((r14 & 4) == 0) goto L9;
            r10 = true;
        L9:
            boolean r3 = r10;
            if ((r14 & 8) == 0) goto L12;
            Animator r4 = null;
        L14:
            if ((r14 & 16) == 0) goto L16;
            Function0 r5 = null;
        L18:
            if ((r14 & 32) == 0) goto L20;
            Function0 r6 = null;
        L22:
            return r7.startPopoverVisibilityAnimationInternal(r8, r2, r3, r4, r5, r6);
        L20:
            r6 = r13;
            goto L22
        L16:
            r5 = r12;
            goto L18
        L12:
            r4 = r11;
            goto L14
        L24:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startPopoverVisibilityAnimationInternal");
        }

        public static <T> AnimatorSet startPopoverVisibilityAnimationInternal(OPopoverBase<T> r11, boolean r12, int r13, boolean r14, Animator r15, Function0<Unit> r16, Function0<Unit> r17) {
            Intrinsics.checkNotNullParameter(r11, "this");
            r11.updatePopoverPivotInternal();
            return OPopoverAnimationHelper.INSTANCE.startVisibilityAnimation(r11.getPopoverWindowFrame(), r14, r13, r11.getPopoverWindowFrame().getPivotX(), r11.getPopoverWindowFrame().getPivotY(), r12, r15, r16, r17);
        }

        public static /* synthetic */ void resetPopoverAnimatedViewState$default(OPopoverBase r0, ViewGroup r1, int r2, Object r3) {
            if (r3 != null) goto L9;
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.getPopoverWindowFrame();
        L6:
            r0.resetPopoverAnimatedViewState(r1);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resetPopoverAnimatedViewState");
        }

        public static <T> void resetPopoverAnimatedViewState(OPopoverBase<T> r1, View r2) {
            Intrinsics.checkNotNullParameter(r1, "this");
            Intrinsics.checkNotNullParameter(r2, "view");
            r2.setAlpha(1.0f);
            r2.setScaleX(1.0f);
            r2.setScaleY(1.0f);
            r2.setTranslationY(0.0f);
        }

        public static <T> ShadowPadding resolvePopoverShadowPadding(OPopoverBase<T> r8, int r9) {
            Intrinsics.checkNotNullParameter(r8, "this");
            if (r9 == 0) goto L5;
            List<Shadow> r10 = OUILayoutHelper.extractShadowInfo(r8.getPopoverContext(), r9);
            Intrinsics.checkNotNullExpressionValue(r10, "extractShadowInfo(popoverContext, shadowStyleRes)");
            ShadowPadding r11 = new ShadowPadding(0, 0, 0, 0, 15, null);
            Iterator<T> r12 = r10.iterator();
        L8:
            if (r12.hasNext() == false) goto L10;
            Shadow r0 = (Shadow) r12.next();
            r11.setLeft(Math.max(r11.getLeft(), MathKt.roundToInt(r0.getRadius() - r0.getOffsetX())));
            r11.setTop(Math.max(r11.getTop(), MathKt.roundToInt(r0.getRadius() - r0.getOffsetY())));
            r11.setRight(Math.max(r11.getRight(), MathKt.roundToInt(r0.getRadius() + r0.getOffsetX())));
            r11.setBottom(Math.max(r11.getBottom(), MathKt.roundToInt(r0.getRadius() + r0.getOffsetY())));
            goto L8
        L10:
            return r11;
        L5:
            return new ShadowPadding(0, 0, 0, 0, 15, null);
        }

        public static <T> float resolvePopoverShadowSpace(OPopoverBase<T> r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "this");
            float r0 = 0.0f;
            if (r2 != 0) goto L5;
            return 0.0f;
        L5:
            List<Shadow> r3 = OUILayoutHelper.extractShadowInfo(r1.getPopoverContext(), r2);
            Intrinsics.checkNotNullExpressionValue(r3, "extractShadowInfo(popoverContext, shadowStyleRes)");
            Iterator<T> r4 = r3.iterator();
        L7:
            if (r4.hasNext() == false) goto L9;
            r0 = r0 + ((Shadow) r4.next()).getRadius();
            goto L7
        L9:
            return r0;
        }

        public static /* synthetic */ void setMaxContentHeightInternal$default(OPopoverBase r0, int r1, View r2, int r3, Object r4) {
            if (r4 != null) goto L9;
            if ((r3 & 2) == 0) goto L6;
            r2 = r0.getContentViewInternal();
        L6:
            r0.setMaxContentHeightInternal(r1, r2);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMaxContentHeightInternal");
        }

        public static <T> void setMaxContentHeightInternal(OPopoverBase<T> r1, int r2, View r3) {
            Intrinsics.checkNotNullParameter(r1, "this");
            Intrinsics.checkNotNullParameter(r3, "measureTarget");
            if (r1.isPopoverBubbleLayoutInitialized() == false) goto L8;
            if (r2 <= 0) goto L9;
            r1.setPopoverMaxContentHeight(r2, r3, Integer.MIN_VALUE, Integer.MIN_VALUE);
            return;
        L9:
            return;
        }

        public static <T> boolean shouldAnimatePopoverVisibilityInternal(OPopoverBase<T> r4) {
            Intrinsics.checkNotNullParameter(r4, "this");
            if (r4.getPopoverShowWithAnimation() == true) goto L5;
        L7:
            return false;
        L5:
            if (r4.getPopoverAnimationDurationMillis() <= 0) goto L7;
            return true;
        }

        public static <T> void cancelPopoverAnimatorInternal(OPopoverBase<T> r1) {
            Intrinsics.checkNotNullParameter(r1, "this");
            AnimatorSet r0 = r1.getPopoverAnimator();
            if (r0 == null) goto L6;
            r0.cancel();
        L6:
            r1.setPopoverAnimator(null);
        }

        public static <T> int resolvePopoverAnimationGravityInternal(OPopoverBase<T> r1) {
            Intrinsics.checkNotNullParameter(r1, "this");
            return r1.getPopoverGravity();
        }

        public static <T> void showPopoverWithoutAnimationInternal(final OPopoverBase<T> r3) {
            Intrinsics.checkNotNullParameter(r3, "this");
            showPopoverDirectlyInternal$default(r3, null, new C03001(r3), 1, null);
        }

        public static <T> void playPopoverEnterAnimationInternal(final OPopoverBase<T> r8) {
            Intrinsics.checkNotNullParameter(r8, "this");
            r8.cancelPopoverAnimatorInternal();
            boolean r4 = r8.getPopoverAnimationIsWindowMode();
            r8.setPopoverAnimator(r8.startPopoverVisibilityAnimationInternal(true, r8.resolvePopoverAnimationGravityInternal(), r4, r8.getPopoverEnterAnimator(), new AnonymousClass1(r8), new AnonymousClass2(r8)));
        }

        public static <T> void playPopoverExitAnimationInternal(final OPopoverBase<T> r10) {
            Intrinsics.checkNotNullParameter(r10, "this");
            r10.cancelPopoverAnimatorInternal();
            r10.onPopoverStartDismissInternal();
            boolean r4 = r10.getPopoverAnimationIsWindowMode();
            r10.setPopoverAnimator(startPopoverVisibilityAnimationInternal$default(r10, false, r10.resolvePopoverAnimationGravityInternal(), r4, r10.getPopoverExitAnimator(), null, new C02991(r10), 16, null));
        }

        public static <T> void beforeShowInStackIfNeeded(OPopoverBase<T> r7) {
            Intrinsics.checkNotNullParameter(r7, "this");
            StackController.INSTANCE.beforeShow(r7, r7.getPopoverCoverPreviousWhenStacked(), r7.getPopoverStackCoverColor(), r7.getPopoverStackAlphaPrevious(), r7.getPopoverStackScalePrevious());
        }

        public static <T> void afterShowInStackIfNeeded(OPopoverBase<T> r1) {
            Intrinsics.checkNotNullParameter(r1, "this");
            if (r1.getPopoverPushedToStack() == false) goto L5;
            return;
        L5:
            r1.setPopoverPushedToStack(true);
            StackController.INSTANCE.onShow(r1);
        }

        public static <T> void onDestroyInStackIfNeeded(OPopoverBase<T> r1) {
            Intrinsics.checkNotNullParameter(r1, "this");
            if (r1.getPopoverRemovedFromStack() == false) goto L5;
            return;
        L5:
            r1.setPopoverRemovedFromStack(true);
            StackController.INSTANCE.onDismiss(r1);
        }
    }

    /* JADX INFO: compiled from: OPopoverBase.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/obric/oui/popover/v2/OPopoverBase$ShadowPadding;", "", "left", "", "top", "right", "bottom", "(IIII)V", "getBottom", "()I", "setBottom", "(I)V", "getLeft", "setLeft", "getRight", "setRight", "getTop", "setTop", "component1", "component2", "component3", "component4", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ShadowPadding {
        private int bottom;
        private int left;
        private int right;
        private int top;

        public ShadowPadding() {
            this(0, 0, 0, 0, 15, null);
        }

        public static /* synthetic */ ShadowPadding copy$default(ShadowPadding r0, int r1, int r2, int r3, int r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.left;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.top;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.right;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.bottom;
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final int component1() {
            return this.left;
        }

        public final int component2() {
            return this.top;
        }

        public final int component3() {
            return this.right;
        }

        public final int component4() {
            return this.bottom;
        }

        public final ShadowPadding copy(int r1, int r2, int r3, int r4) {
            return new ShadowPadding(r1, r2, r3, r4);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof ShadowPadding) == true) goto L8;
            return false;
        L8:
            ShadowPadding r6 = (ShadowPadding) r5;
            if (this.left == r6.left) goto L12;
            return false;
        L12:
            if (this.top == r6.top) goto L15;
            return false;
        L15:
            if (this.right == r6.right) goto L18;
            return false;
        L18:
            if (this.bottom == r6.bottom) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.left) * 31) + Integer.hashCode(this.top)) * 31) + Integer.hashCode(this.right)) * 31) + Integer.hashCode(this.bottom);
        }

        public String toString() {
            return "ShadowPadding(left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ')';
        }

        public ShadowPadding(int r1, int r2, int r3, int r4) {
            this.left = r1;
            this.top = r2;
            this.right = r3;
            this.bottom = r4;
        }

        public /* synthetic */ ShadowPadding(int r2, int r3, int r4, int r5, int r6, DefaultConstructorMarker r7) {
            if ((r6 & 1) == 0) goto L6;
            r2 = 0;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = 0;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = 0;
        L12:
            if ((r6 & 8) == 0) goto L14;
            r5 = 0;
        L14:
            this(r2, r3, r4, r5);
        }

        public final int getLeft() {
            return this.left;
        }

        public final void setLeft(int r1) {
            this.left = r1;
        }

        public final int getTop() {
            return this.top;
        }

        public final void setTop(int r1) {
            this.top = r1;
        }

        public final int getRight() {
            return this.right;
        }

        public final void setRight(int r1) {
            this.right = r1;
        }

        public final int getBottom() {
            return this.bottom;
        }

        public final void setBottom(int r1) {
            this.bottom = r1;
        }
    }

    /* JADX INFO: compiled from: OPopoverBase.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0011\u001a\u00020\bH\u0002J.\u0010\u0012\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u00062\b\b\u0001\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000fH\u0002J\u0012\u0010\u0016\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u0006J\u0012\u0010\u0017\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u0006J\u001e\u0010\u0018\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006H\u0002R\u001e\u0010\u0003\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/oui/popover/v2/OPopoverBase$StackController;", "", "()V", "popoverStack", "", "Ljava/lang/ref/WeakReference;", "Lcom/obric/oui/popover/v2/OPopoverBase;", "beforeShow", "", PerfConsts.KEY_CURRENT_GALVANIC, "coverPreviousWhenStacked", "", "stackCoverColor", "", "stackAlphaPrevious", "", "stackScalePrevious", "cleanupStackLocked", "coverPreviousPopoverIfAny", "color", "alpha", "scale", "onDismiss", "onShow", "topLocked", "exclude", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class StackController {
        public static final StackController INSTANCE = null;
        private static final List<WeakReference<OPopoverBase<?>>> popoverStack = null;

        private StackController() {
        }

        static {
            INSTANCE = new StackController();
            popoverStack = new ArrayList();
        }

        public final synchronized void beforeShow(OPopoverBase<?> r5, boolean r6, int r7, float r8, float r9) {
            monitor-enter(this);
            Intrinsics.checkNotNullParameter(r5, PerfConsts.KEY_CURRENT_GALVANIC);     // Catch: Throwable -> L10
            OPopoverLayout.setCovered$default(r5.getPopoverBubbleLayout(), false, 0, 2, null);     // Catch: Throwable -> L10
            if (r6 == true) goto L7;
            monitor-exit(this);
            return;
        L7:
            coverPreviousPopoverIfAny(r5, r7, r8, r9);     // Catch: Throwable -> L10
            monitor-exit(this);
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public final synchronized void onShow(final OPopoverBase<?> r3) {
            monitor-enter(this);
            Intrinsics.checkNotNullParameter(r3, PerfConsts.KEY_CURRENT_GALVANIC);     // Catch: Throwable -> L6
            cleanupStackLocked();     // Catch: Throwable -> L6
            List<WeakReference<OPopoverBase<?>>> r0 = popoverStack;     // Catch: Throwable -> L6
            CollectionsKt.removeAll(r0, new OPopoverBase$StackController$onShow$1(r3));     // Catch: Throwable -> L6
            r0.add(new WeakReference(r3));     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public final synchronized void onDismiss(final OPopoverBase<?> r4) {
            monitor-enter(this);
            Intrinsics.checkNotNullParameter(r4, PerfConsts.KEY_CURRENT_GALVANIC);     // Catch: Throwable -> L9
            cleanupStackLocked();     // Catch: Throwable -> L9
            CollectionsKt.removeAll(popoverStack, new OPopoverBase$StackController$onDismiss$1(r4));     // Catch: Throwable -> L9
            OPopoverBase<?> r0 = topLocked$default(this, null, 1, null);     // Catch: Throwable -> L9
            if (r0 == null) goto L7;
            OPopoverAnimationHelper.INSTANCE.startStackTransitionAnimation(r0, true, 1.0f, 1.0f);     // Catch: Throwable -> L9
        L7:
            monitor-exit(this);
            return;
        L9:
            th = move-exception;
            throw th;
        }

        private final synchronized void cleanupStackLocked() {
            monitor-enter(this);
            CollectionsKt.removeAll(popoverStack, OPopoverBase$StackController$cleanupStackLocked$1.INSTANCE);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        static /* synthetic */ OPopoverBase topLocked$default(StackController r0, OPopoverBase r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = null;
        L6:
            return r0.topLocked(r1);
        }

        private final synchronized OPopoverBase<?> topLocked(OPopoverBase<?> r4) {
            monitor-enter(this);
            cleanupStackLocked();     // Catch: Throwable -> L19
            int r0 = popoverStack.size() - 1;     // Catch: Throwable -> L19
            if (r0 < 0) goto L16;
        L5:
            int r1 = r0 - 1;     // Catch: Throwable -> L19
            OPopoverBase<?> r2 = popoverStack.get(r0).get();     // Catch: Throwable -> L19
            if (r2 == null) goto L11;
            if (r4 == null) goto L14;
            if (r2 == r4) goto L11;
        L14:
            monitor-exit(this);
            return r2;
        L11:
            if (r1 < 0) goto L16;
            r0 = r1;
        L16:
            monitor-exit(this);
            return null;
        L19:
            th = move-exception;
            throw th;
        }

        private final synchronized void coverPreviousPopoverIfAny(OPopoverBase<?> r2, int r3, float r4, float r5) {
            monitor-enter(this);
            OPopoverBase<?> r6 = topLocked(r2);     // Catch: Throwable -> L10
            if (r6 != null) goto L7;
            monitor-exit(this);
            return;
        L7:
            OPopoverAnimationHelper.INSTANCE.startStackTransitionAnimation(r6, false, r4, r5);     // Catch: Throwable -> L10
            monitor-exit(this);
            return;
        L10:
            th = move-exception;
            throw th;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void afterShowInStackIfNeeded();

    void beforeShowInStackIfNeeded();

    void cancelPopoverAnimatorInternal();

    OPopoverLayout createPopoverBubbleLayout(View r1, int r2);

    void finishPopoverDismissInternal();

    View getContentViewInternal();

    int getDisplayRotationDegreesInternal();

    float getPopoverAnchorCenterX();

    float getPopoverAnchorCenterY();

    long getPopoverAnimationDurationMillis();

    boolean getPopoverAnimationIsWindowMode();

    AnimatorSet getPopoverAnimator();

    int getPopoverBgColor();

    int getPopoverBorderColor();

    int getPopoverBorderWidth();

    OPopoverLayout getPopoverBubbleLayout();

    Context getPopoverContext();

    boolean getPopoverCoverPreviousWhenStacked();

    int getPopoverDisplayOrientation();

    boolean getPopoverEnableBubbleMaterial();

    Animator getPopoverEnterAnimator();

    Animator getPopoverExitAnimator();

    int getPopoverGravity();

    int getPopoverHeight();

    Function1<Boolean, MaterialConfig[]> getPopoverMaterials();

    int getPopoverPopupOriginX();

    int getPopoverPopupOriginY();

    boolean getPopoverPushedToStack();

    boolean getPopoverRemovedFromStack();

    boolean getPopoverShowWithAnimation();

    float getPopoverStackAlphaPrevious();

    int getPopoverStackCoverColor();

    float getPopoverStackScalePrevious();

    boolean getPopoverTransparentBg();

    int getPopoverWidth();

    ViewGroup getPopoverWindowFrame();

    int getPopoverXOffset();

    int getPopoverYOffset();

    boolean isPopoverBubbleLayoutInitialized();

    boolean isPopoverShowing();

    void measurePopoverContent(View r1, int r2, int r3);

    void measurePopupInternal(int r1, int r2);

    void onDestroyInStackIfNeeded();

    void onPopoverShownInternal();

    void onPopoverStartDismissInternal();

    void playPopoverEnterAnimationInternal();

    void playPopoverExitAnimationInternal();

    View requirePopoverContentView(View r1);

    void resetPopoverAnimatedViewState(View r1);

    int resolvePopoverAnimationGravityInternal();

    float resolvePopoverPivot(float r1, int r2, float r3);

    ShadowPadding resolvePopoverShadowPadding(int r1);

    float resolvePopoverShadowSpace(int r1);

    void setGravityInternal(int r1);

    void setMaxContentHeightInternal(int r1, View r2);

    void setPopoverAnchorCenterX(float r1);

    void setPopoverAnchorCenterY(float r1);

    void setPopoverAnimator(AnimatorSet r1);

    void setPopoverBubbleLayout(OPopoverLayout r1);

    void setPopoverGravity(int r1);

    void setPopoverMaxContentHeight(int r1, View r2, int r3, int r4);

    void setPopoverPopupOriginX(int r1);

    void setPopoverPopupOriginY(int r1);

    void setPopoverPushedToStack(boolean r1);

    void setPopoverRemovedFromStack(boolean r1);

    void setPopoverWindowFrame(ViewGroup r1);

    void setPopoverXOffset(int r1);

    void setPopoverYOffset(int r1);

    void setXOffsetInternal(int r1);

    void setYOffsetInternal(int r1);

    boolean shouldAnimatePopoverVisibilityInternal();

    void showPopoverDirectlyInternal(ViewGroup r1, Function0<Unit> r2);

    void showPopoverWithoutAnimationInternal();

    AnimatorSet startPopoverVisibilityAnimationInternal(boolean r1, int r2, boolean r3, Animator r4, Function0<Unit> r5, Function0<Unit> r6);

    void updatePopoverPivotInternal();
}
