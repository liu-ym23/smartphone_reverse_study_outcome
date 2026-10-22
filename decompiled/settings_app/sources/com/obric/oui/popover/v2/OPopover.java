package com.obric.oui.popover.v2;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.icu.lang.UProperty;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewGroupKt;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.material.MaterialConfig;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.popover.SingleChildFrameLayout;
import com.obric.oui.utils.ViewUtil;
import com.obric.oui.utils.log.L;
import com.obric.oui.window.OWindowConfigController;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: OPopover.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b7\b\u0016\u0018\u0000 Ó\u00012\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\nÒ\u0001Ó\u0001Ô\u0001Õ\u0001Ö\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J(\u0010\u009a\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u009b\u00012\u0007\u0010\u009c\u0001\u001a\u00020\u00132\u0007\u0010\u009d\u0001\u001a\u00020\u0013H\u0003J(\u0010\u009e\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u009b\u00012\u0007\u0010\u009c\u0001\u001a\u00020\u00132\u0007\u0010\u009d\u0001\u001a\u00020\u0013H\u0002J\n\u0010\u009f\u0001\u001a\u00030 \u0001H\u0002J\n\u0010¡\u0001\u001a\u00030 \u0001H\u0016J\b\u0010¢\u0001\u001a\u00030 \u0001J\n\u0010£\u0001\u001a\u00030 \u0001H\u0016J\u000f\u0010¤\u0001\u001a\u00020\u0013H\u0000¢\u0006\u0003\b¥\u0001J\t\u0010¦\u0001\u001a\u000202H\u0002J\u0007\u0010§\u0001\u001a\u00020\u0016J\u0007\u0010¨\u0001\u001a\u00020\u0013J\u0007\u0010©\u0001\u001a\u00020\u0013J\u0007\u0010ª\u0001\u001a\u000208J\n\u0010«\u0001\u001a\u00030 \u0001H\u0002J\n\u0010¬\u0001\u001a\u00030 \u0001H\u0002J\u0014\u0010\u00ad\u0001\u001a\u00020\n2\t\u0010®\u0001\u001a\u0004\u0018\u000108H\u0002J\t\u0010¯\u0001\u001a\u00020\nH\u0016J\n\u0010°\u0001\u001a\u00030 \u0001H\u0002J\b\u0010±\u0001\u001a\u00030 \u0001J\n\u0010²\u0001\u001a\u00030 \u0001H\u0016J\n\u0010³\u0001\u001a\u00030 \u0001H\u0016J\n\u0010´\u0001\u001a\u00030 \u0001H\u0016J\n\u0010µ\u0001\u001a\u00030 \u0001H\u0016J\t\u0010¶\u0001\u001a\u00020\u0013H\u0016J\u0013\u0010·\u0001\u001a\u00030 \u00012\u0007\u0010¸\u0001\u001a\u000208H\u0002J\u001a\u0010¹\u0001\u001a\u00030 \u00012\u0007\u0010º\u0001\u001a\u00020\u00072\u0007\u0010»\u0001\u001a\u00020\u0007J\u0010\u0010¼\u0001\u001a\u00030 \u00012\u0006\u0010T\u001a\u00020\nJ\u0011\u0010½\u0001\u001a\u00030 \u00012\u0007\u0010¾\u0001\u001a\u00020\nJ\u0011\u0010¿\u0001\u001a\u00030 \u00012\u0007\u0010À\u0001\u001a\u00020\u0013J\u0011\u0010Á\u0001\u001a\u00030 \u00012\u0007\u0010Â\u0001\u001a\u00020\nJ\u0011\u0010Ã\u0001\u001a\u00030 \u00012\u0007\u0010Ä\u0001\u001a\u00020\u0013J\u0011\u0010Å\u0001\u001a\u00030 \u00012\u0007\u0010Æ\u0001\u001a\u00020\u001fJ\u0011\u0010Ç\u0001\u001a\u00030 \u00012\u0007\u0010Æ\u0001\u001a\u00020/J\u0011\u0010È\u0001\u001a\u00030 \u00012\u0007\u0010Æ\u0001\u001a\u000206J\u0011\u0010É\u0001\u001a\u00030 \u00012\u0007\u0010Ê\u0001\u001a\u00020\u0013J\u0011\u0010Ë\u0001\u001a\u00030 \u00012\u0007\u0010Ì\u0001\u001a\u00020\u0013J0\u0010Í\u0001\u001a\u00030 \u00012\t\u0010Î\u0001\u001a\u0004\u0018\u0001082\u0007\u0010Ï\u0001\u001a\u00020\u00132\u0007\u0010Ð\u0001\u001a\u00020\u00132\u0007\u0010À\u0001\u001a\u00020\u0013H\u0016J.\u0010Ñ\u0001\u001a\u00030 \u00012\u0007\u0010Î\u0001\u001a\u0002082\u0007\u0010À\u0001\u001a\u00020\u00132\u0007\u0010\u009c\u0001\u001a\u00020\u00132\u0007\u0010\u009d\u0001\u001a\u00020\u0013H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\u000e\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010-\u001a\u00020\u00138\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00103\u001a\u00020\u00138\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010<\u001a\u000202X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010A\u001a\u000202X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010>\"\u0004\bC\u0010@R\u0014\u0010D\u001a\u00020\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u001c\u0010G\u001a\u0004\u0018\u00010HX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0014\u0010M\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bN\u0010OR\u0014\u0010P\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010OR\u0014\u0010R\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bS\u0010OR$\u0010U\u001a\u00020)2\u0006\u0010T\u001a\u00020)8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u0014\u0010Z\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\\R\u0014\u0010]\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b^\u0010\u000fR\u0014\u0010_\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b`\u0010OR\u0014\u0010a\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010\u000fR\u0016\u0010c\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bd\u0010eR\u0016\u0010f\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bg\u0010eR\u001c\u0010h\u001a\u00020\u00138VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010O\"\u0004\bj\u0010kR\u0014\u0010l\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bm\u0010OR&\u0010n\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020q0p0oX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\br\u0010sR\u001a\u0010t\u001a\u00020\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010O\"\u0004\bv\u0010kR\u001a\u0010w\u001a\u00020\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010O\"\u0004\by\u0010kR\u001a\u0010z\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010\u000f\"\u0004\b|\u0010}R\u001b\u0010~\u001a\u00020\nX\u0096\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b\u007f\u0010\u000f\"\u0005\b\u0080\u0001\u0010}R\u0016\u0010\u0081\u0001\u001a\u00020\nX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0082\u0001\u0010\u000fR\u0016\u0010\u0083\u0001\u001a\u0002028VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0084\u0001\u0010>R\u0016\u0010\u0085\u0001\u001a\u00020\u00138WX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0086\u0001\u0010OR\u0016\u0010\u0087\u0001\u001a\u0002028VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0088\u0001\u0010>R\u0016\u0010\u0089\u0001\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u008a\u0001\u0010\u000fR\u0016\u0010\u008b\u0001\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u008c\u0001\u0010OR)\u0010\u008d\u0001\u001a\u00020;2\u0006\u0010T\u001a\u00020;8V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001d\u0010\u0092\u0001\u001a\u00020\u0013X\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0001\u0010O\"\u0005\b\u0094\u0001\u0010kR\u001d\u0010\u0095\u0001\u001a\u00020\u0013X\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0096\u0001\u0010O\"\u0005\b\u0097\u0001\u0010kR\u000f\u0010\u0098\u0001\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0099\u0001\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006×\u0001"}, d2 = {"Lcom/obric/oui/popover/v2/OPopover;", "Landroid/widget/PopupWindow;", "Lcom/obric/oui/popover/v2/OPopoverBase;", "builder", "Lcom/obric/oui/popover/v2/OPopover$Builder;", "(Lcom/obric/oui/popover/v2/OPopover$Builder;)V", "customInAnimator", "Landroid/animation/Animator;", "customOutAnimator", "enableAutoDismiss", "", "isAlreadyDismiss", "isHideVirtualKey", "Ljava/lang/Boolean;", "isPopoverBubbleLayoutInitialized", "()Z", "mActivity", "Landroid/app/Activity;", "mAnchorViewHeight", "", "mAnchorViewWidth", "mAnimTime", "", "mAutoDismissDelayMillis", "mBgColor", "mBorderColor", "mBorderWidth", "mContext", "Landroid/content/Context;", "mCoverPreviousWhenStacked", "mDismissListener", "Lcom/obric/oui/popover/v2/OPopover$OnBubbleDismissListener;", "mDismissRunnable", "Ljava/lang/Runnable;", "mDisplayOrientation", "mFocusable", "mGetLocationInWindow", "mHeight", "mIsFirstShow", "mIsShowInDialog", "mOBubbleLayout", "Lcom/obric/oui/popover/v2/OPopoverLayout;", "mOutsideTouchable", "mShadowEnabled", "mShadowSpaceTop", "mShadowStyle", "mShowListener", "Lcom/obric/oui/popover/v2/OPopover$OnBubbleShowListener;", "mSpacingForShadow", "mStackAlphaPrevious", "", "mStackCoverColor", "mStackScalePrevious", "mStartDismissListener", "Lcom/obric/oui/popover/v2/OPopover$OnBubbleStartDismissListener;", "mView", "Landroid/view/View;", "mWidth", "mWindowFrame", "Landroid/view/ViewGroup;", "popoverAnchorCenterX", "getPopoverAnchorCenterX", "()F", "setPopoverAnchorCenterX", "(F)V", "popoverAnchorCenterY", "getPopoverAnchorCenterY", "setPopoverAnchorCenterY", "popoverAnimationDurationMillis", "getPopoverAnimationDurationMillis", "()J", "popoverAnimator", "Landroid/animation/AnimatorSet;", "getPopoverAnimator", "()Landroid/animation/AnimatorSet;", "setPopoverAnimator", "(Landroid/animation/AnimatorSet;)V", "popoverBgColor", "getPopoverBgColor", "()I", "popoverBorderColor", "getPopoverBorderColor", "popoverBorderWidth", "getPopoverBorderWidth", "value", "popoverBubbleLayout", "getPopoverBubbleLayout", "()Lcom/obric/oui/popover/v2/OPopoverLayout;", "setPopoverBubbleLayout", "(Lcom/obric/oui/popover/v2/OPopoverLayout;)V", "popoverContext", "getPopoverContext", "()Landroid/content/Context;", "popoverCoverPreviousWhenStacked", "getPopoverCoverPreviousWhenStacked", "popoverDisplayOrientation", "getPopoverDisplayOrientation", "popoverEnableBubbleMaterial", "getPopoverEnableBubbleMaterial", "popoverEnterAnimator", "getPopoverEnterAnimator", "()Landroid/animation/Animator;", "popoverExitAnimator", "getPopoverExitAnimator", "popoverGravity", "getPopoverGravity", "setPopoverGravity", "(I)V", "popoverHeight", "getPopoverHeight", "popoverMaterials", "Lkotlin/Function1;", "", "Lcom/obric/oui/material/MaterialConfig;", "getPopoverMaterials", "()Lkotlin/jvm/functions/Function1;", "popoverPopupOriginX", "getPopoverPopupOriginX", "setPopoverPopupOriginX", "popoverPopupOriginY", "getPopoverPopupOriginY", "setPopoverPopupOriginY", "popoverPushedToStack", "getPopoverPushedToStack", "setPopoverPushedToStack", "(Z)V", "popoverRemovedFromStack", "getPopoverRemovedFromStack", "setPopoverRemovedFromStack", "popoverShowWithAnimation", "getPopoverShowWithAnimation", "popoverStackAlphaPrevious", "getPopoverStackAlphaPrevious", "popoverStackCoverColor", "getPopoverStackCoverColor", "popoverStackScalePrevious", "getPopoverStackScalePrevious", "popoverTransparentBg", "getPopoverTransparentBg", "popoverWidth", "getPopoverWidth", "popoverWindowFrame", "getPopoverWindowFrame", "()Landroid/view/ViewGroup;", "setPopoverWindowFrame", "(Landroid/view/ViewGroup;)V", "popoverXOffset", "getPopoverXOffset", "setPopoverXOffset", "popoverYOffset", "getPopoverYOffset", "setPopoverYOffset", "transparentBg", "useWindowCoords", "addShadowFrame", "Lkotlin/Pair;", MaterialConfigFormatNames.X, "y", "addShadowFrameIfNeeded", "clearFakeAnchorViewIfNecessary", "", "dismiss", "dismissDirectly", "finishPopoverDismissInternal", "getDisplayRotationDegrees", "getDisplayRotationDegrees$OUI_standardRelease", "getElevationPx", "getInAnimTime", "getMeasuredHeight", "getMeasuredWidth", "getPopoverView", "hideSystemUi", "initContentView", "isAnchorFromPopupWindow", "anchorRoot", "isPopoverShowing", "measure", "onDestroy", "onPopoverShownInternal", "onPopoverStartDismissInternal", "playPopoverEnterAnimationInternal", "playPopoverExitAnimationInternal", "resolvePopoverAnimationGravityInternal", "setBubbleLayout", "view", "setCustomAnimator", "inAnimator", "outAnimator", "setEnableAutoDismiss", "setGetLocationInWindow", "getLocationInWindow", "setGravity", "gravity", "setIsShowInDialog", "isShowInDialog", "setMaxContentHeight", "maxHeight", "setOnDismissListener", "listener", "setOnShowListener", "setOnStartDismissListener", "setXOffset", "xOffset", "setYOffset", "yOffset", "showAsDropDown", "anchor", "xoff", "yoff", "showAtLocation", "Builder", "Companion", "OnBubbleDismissListener", "OnBubbleShowListener", "OnBubbleStartDismissListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OPopover extends PopupWindow implements OPopoverBase<OPopover> {
    public static final Companion Companion = null;
    private static final String TAG = "OPopover";
    private static boolean shouldForceDismiss;
    private Animator customInAnimator;
    private Animator customOutAnimator;
    private boolean enableAutoDismiss;
    private boolean isAlreadyDismiss;
    private Boolean isHideVirtualKey;
    private Activity mActivity;
    private int mAnchorViewHeight;
    private int mAnchorViewWidth;
    private long mAnimTime;
    private long mAutoDismissDelayMillis;
    private int mBgColor;
    private int mBorderColor;
    private int mBorderWidth;
    private Context mContext;
    private boolean mCoverPreviousWhenStacked;
    private OnBubbleDismissListener mDismissListener;
    private final Runnable mDismissRunnable;
    private int mDisplayOrientation;
    private boolean mFocusable;
    private boolean mGetLocationInWindow;
    private int mHeight;
    private boolean mIsFirstShow;
    private boolean mIsShowInDialog;
    private OPopoverLayout mOBubbleLayout;
    private boolean mOutsideTouchable;
    private boolean mShadowEnabled;
    private int mShadowSpaceTop;
    private int mShadowStyle;
    private OnBubbleShowListener mShowListener;
    private boolean mSpacingForShadow;
    private float mStackAlphaPrevious;
    private int mStackCoverColor;
    private float mStackScalePrevious;
    private OnBubbleStartDismissListener mStartDismissListener;
    private View mView;
    private int mWidth;
    private ViewGroup mWindowFrame;
    private float popoverAnchorCenterX;
    private float popoverAnchorCenterY;
    private final long popoverAnimationDurationMillis;
    private AnimatorSet popoverAnimator;
    private final boolean popoverEnableBubbleMaterial;
    private int popoverGravity;
    private final Function1<Boolean, MaterialConfig[]> popoverMaterials;
    private int popoverPopupOriginX;
    private int popoverPopupOriginY;
    private boolean popoverPushedToStack;
    private boolean popoverRemovedFromStack;
    private final boolean popoverShowWithAnimation;
    private int popoverXOffset;
    private int popoverYOffset;
    private boolean transparentBg;
    private boolean useWindowCoords;

    /* JADX INFO: compiled from: OPopover.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/popover/v2/OPopover$Builder;", "Lcom/obric/oui/popover/v2/OPopoverBuilderDelegate;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder extends OPopoverBuilderDelegate<Builder> {
        public Builder(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            super(r2);
        }
    }

    /* JADX INFO: compiled from: OPopover.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0002\b\nJ\u0010\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/popover/v2/OPopover$Companion;", "", "()V", "TAG", "", "shouldForceDismiss", "", "adaptGravity", "", "originGravity", "adaptGravity$OUI_standardRelease", "setShouldForceDismiss", "", "forceDismiss", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final int adaptGravity$OUI_standardRelease(int r5) {
            boolean r1 = true;
            if ((r5 & GravityCompat.START) != 8388611) goto L5;
            boolean r4 = true;
        L7:
            if ((r5 & GravityCompat.END) == 8388613) goto L10;
            r1 = false;
        L10:
            if (r4 == false) goto L12;
            r5 = ((-8388612) & r5) | 3;
        L12:
            if (r1 == true) goto L14;
            return r5;
        L14:
            return ((-8388614) & r5) | 5;
        L5:
            r4 = false;
            goto L7
        }

        private Companion() {
        }

        public static /* synthetic */ void setShouldForceDismiss$default(Companion r0, boolean r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = true;
        L5:
            r0.setShouldForceDismiss(r1);
        }

        public final void setShouldForceDismiss(boolean r1) {
            OPopover.access$setShouldForceDismiss$cp(r1);
        }
    }

    /* JADX INFO: compiled from: OPopover.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/popover/v2/OPopover$OnBubbleDismissListener;", "", "bubbleDismiss", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnBubbleDismissListener {
        void bubbleDismiss();
    }

    /* JADX INFO: compiled from: OPopover.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/popover/v2/OPopover$OnBubbleShowListener;", "", "bubbleShow", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnBubbleShowListener {
        void bubbleShow();
    }

    /* JADX INFO: compiled from: OPopover.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/popover/v2/OPopover$OnBubbleStartDismissListener;", "", "bubbleStartDismiss", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnBubbleStartDismissListener {
        void bubbleStartDismiss();
    }

    /* JADX INFO: renamed from: $r8$lambda$dmRUnXz-WNroEqGZ8pLwpYpDHNA, reason: not valid java name */
    public static /* synthetic */ void m1301$r8$lambda$dmRUnXzWNroEqGZ8pLwpYpDHNA(OPopover r0) {
        m1303mDismissRunnable$lambda3(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$oD6BKGUVT3ejE5vm1gsw4hmpi1w(OPopover r0, View r1, MotionEvent r2) {
        return m1302addShadowFrame$lambda8(r0, r1, r2);
    }

    static {
        Companion = new Companion(null);
    }

    public OPopover(Builder r4) {
        Intrinsics.checkNotNullParameter(r4, "builder");
        this.popoverShowWithAnimation = r4.getMShowWithAnimation();
        this.popoverAnimationDurationMillis = r4.getMAnimTime();
        this.mAnimTime = 200;
        this.mAutoDismissDelayMillis = 5000;
        this.mOutsideTouchable = true;
        this.enableAutoDismiss = true;
        this.mShadowEnabled = true;
        this.mShadowStyle = R.style.OUIShadow_Oui_Shadow_Regular;
        this.mIsFirstShow = true;
        this.popoverAnchorCenterX = Float.NaN;
        this.popoverAnchorCenterY = Float.NaN;
        this.mCoverPreviousWhenStacked = true;
        this.mStackCoverColor = Color.parseColor("#08000000");
        this.mStackAlphaPrevious = 0.3f;
        this.mStackScalePrevious = 0.98f;
        this.popoverEnableBubbleMaterial = r4.getMEnableBubbleMaterial();
        this.popoverMaterials = r4.getMMaterials();
        this.mContext = r4.getContext();
        setPopoverGravity(r4.getMGravity());
        this.mDisplayOrientation = r4.getMDisplayOrientation();
        this.mActivity = OWindowConfigController.INSTANCE.getActivity(this.mContext);
        this.mBgColor = r4.getMBgColor();
        this.isHideVirtualKey = Boolean.valueOf(r4.getMHideVirtualKey());
        setPopoverXOffset(r4.getMXOffset());
        setPopoverYOffset(r4.getMYOffset());
        this.mAnimTime = r4.getMAnimTime();
        this.mAutoDismissDelayMillis = r4.getMAutoDismissDelayMillis();
        this.mView = r4.getMView();
        this.mHeight = r4.getMHeight();
        this.mWidth = r4.getMWidth();
        this.mStartDismissListener = r4.getMStartDismissListener();
        this.mDismissListener = r4.getMDismissListener();
        this.mShowListener = r4.getMShowListener();
        this.mOutsideTouchable = r4.getMOutsideTouchable();
        this.mFocusable = r4.getMFocusable();
        this.mGetLocationInWindow = r4.getMGetLocationInWindow();
        this.mBorderWidth = r4.getMBorderWidth();
        this.mBorderColor = r4.getMBorderColor();
        this.transparentBg = r4.getTransparentBg();
        this.mShadowEnabled = r4.getMShadowEnabled();
        this.mShadowStyle = r4.getShadowStyle();
        this.mSpacingForShadow = r4.getMSpacingForShadow();
        this.mCoverPreviousWhenStacked = r4.getMCoverPreviousWhenStacked();
        this.mStackCoverColor = r4.getMStackCoverColor();
        this.mStackAlphaPrevious = r4.getMStackAlphaPrevious();
        this.mStackScalePrevious = r4.getMStackScalePrevious();
        setWidth(-2);
        setHeight(-2);
        setFocusable(this.mFocusable);
        setOutsideTouchable(this.mOutsideTouchable);
        setClippingEnabled(false);
        setInputMethodMode(1);
        setSoftInputMode(16);
        setBubbleLayout(requirePopoverContentView(this.mView));
        initContentView();
        setFocusable(true);
        this.mDismissRunnable = new OPopover$$ExternalSyntheticLambda1(this);
    }

    public static final /* synthetic */ int access$getMShadowStyle$p(OPopover r0) {
        return r0.mShadowStyle;
    }

    public static final /* synthetic */ void access$setShouldForceDismiss$cp(boolean r0) {
        shouldForceDismiss = r0;
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
    public boolean getPopoverAnimationIsWindowMode() {
        return OPopoverBase.DefaultImpls.getPopoverAnimationIsWindowMode(this);
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
    public Animator getPopoverEnterAnimator() {
        return this.customInAnimator;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public Animator getPopoverExitAnimator() {
        return this.customOutAnimator;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverGravity(int r1) {
        this.popoverGravity = r1;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverGravity() {
        return Companion.adaptGravity$OUI_standardRelease(this.popoverGravity);
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
    public Context getPopoverContext() {
        return this.mContext;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverDisplayOrientation() {
        return this.mDisplayOrientation;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverBgColor() {
        return this.mBgColor;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverBorderWidth() {
        return this.mBorderWidth;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverBorderColor() {
        return this.mBorderColor;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public boolean getPopoverTransparentBg() {
        return this.transparentBg;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverWidth() {
        return this.mWidth;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverHeight() {
        return this.mHeight;
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
        return this.mCoverPreviousWhenStacked;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int getPopoverStackCoverColor() {
        return this.mStackCoverColor;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public float getPopoverStackAlphaPrevious() {
        return this.mStackAlphaPrevious;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public float getPopoverStackScalePrevious() {
        return this.mStackScalePrevious;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public OPopoverLayout getPopoverBubbleLayout() {
        OPopoverLayout r0 = this.mOBubbleLayout;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        return null;
    L6:
        return r0;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverBubbleLayout(OPopoverLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.mOBubbleLayout = r2;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public ViewGroup getPopoverWindowFrame() {
        ViewGroup r0 = this.mWindowFrame;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mWindowFrame");
        return null;
    L6:
        return r0;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void setPopoverWindowFrame(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.mWindowFrame = r2;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public boolean isPopoverBubbleLayoutInitialized() {
        if (this.mOBubbleLayout == null) goto L5;
        return true;
    L5:
        return false;
    }

    private final void initContentView() {
        if (Intrinsics.areEqual(this.isHideVirtualKey, true) == false) goto L5;
        hideSystemUi();
    L5:
        OPopoverLayout r1 = null;
        if (this.mBgColor == 0) goto L11;
        OPopoverLayout r0 = this.mOBubbleLayout;
        if (r0 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r0 = null;
    L10:
        r0.setBgColor(this.mBgColor);
    L11:
        OPopoverLayout r2 = this.mOBubbleLayout;
        if (r2 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r2 = null;
    L15:
        if (r2.isEnableMaterial() == true) goto L23;
        OPopoverLayout r3 = this.mOBubbleLayout;
        if (r3 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r3 = null;
    L19:
        r3.setBorderColor(this.mBorderColor);
        OPopoverLayout r4 = this.mOBubbleLayout;
        if (r4 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r4 = null;
    L22:
        r4.setBorderWidth(this.mBorderWidth);
    L23:
        OPopoverLayout r5 = this.mOBubbleLayout;
        if (r5 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
    L27:
        r1.setTransparentBg(this.transparentBg);
        return;
    L26:
        r1 = r5;
        goto L27
    }

    public final void setCustomAnimator(Animator r2, Animator r3) {
        Intrinsics.checkNotNullParameter(r2, "inAnimator");
        Intrinsics.checkNotNullParameter(r3, "outAnimator");
        this.customInAnimator = r2;
        this.customOutAnimator = r3;
    }

    public final long getInAnimTime() {
        return this.mAnimTime;
    }

    public final int getDisplayRotationDegrees$OUI_standardRelease() {
        return getDisplayRotationDegreesInternal();
    }

    public final void setXOffset(int r1) {
        setXOffsetInternal(r1);
    }

    public final void setYOffset(int r1) {
        setYOffsetInternal(r1);
    }

    public final void setGetLocationInWindow(boolean r1) {
        this.mGetLocationInWindow = r1;
    }

    public final void setOnShowListener(OnBubbleShowListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.mShowListener = r2;
    }

    public final void setOnStartDismissListener(OnBubbleStartDismissListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.mStartDismissListener = r2;
    }

    public final void setOnDismissListener(OnBubbleDismissListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.mDismissListener = r2;
    }

    private final void setBubbleLayout(View r5) {
        setPopoverBubbleLayout(OPopoverBase.DefaultImpls.createPopoverBubbleLayout$default(this, r5, 0, 2, null));
        ViewGroup.MarginLayoutParams r6 = new ViewGroup.MarginLayoutParams(-2, -2);
        getPopoverBubbleLayout().setLayoutParams(r6);
        setPopoverWindowFrame(getPopoverBubbleLayout());
        setContentView(getPopoverWindowFrame());
        View r7 = getContentView();
        Intrinsics.checkNotNullExpressionValue(r7, "contentView");
        measurePopoverContent(r7, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View r18, int r19, int r20, int r21) {
        View r1 = r18;
        Intrinsics.checkNotNullParameter(r1, "anchor");
        View r4 = r18.getRootView();
        OWindowConfigController r5 = OWindowConfigController.INSTANCE;
        Context r6 = r18.getContext();
        Intrinsics.checkNotNullExpressionValue(r6, "anchor.context");
        Activity r7 = r5.getActivity(r6);
        boolean r8 = isAnchorFromPopupWindow(r4);
        if (this.mCoverPreviousWhenStacked == true) goto L5;
        this.mCoverPreviousWhenStacked = r8;
    L5:
        int r9 = Companion.adaptGravity$OUI_standardRelease(r19);
        beforeShowInStackIfNeeded();     // Catch: Exception -> L44
        Pair<Integer, Integer> r10 = addShadowFrameIfNeeded(r20, r21);     // Catch: Exception -> L44
        if (this.mGetLocationInWindow == false) goto L9;
    L12:
        boolean r11 = true;
    L13:
        this.useWindowCoords = r11;     // Catch: Exception -> L44
        int[] r13 = new int[2];     // Catch: Exception -> L44
        if (r11 == false) goto L19;
        r1.getLocationInWindow(r13);     // Catch: Exception -> L44
        if (r8 == false) goto L20;
        if (r7 == null) goto L20;
        int r12 = r13[0];     // Catch: Exception -> L44
        int r14 = r13[1];     // Catch: Exception -> L44
        r7.getWindow().getDecorView().getLocationOnScreen(r13);     // Catch: Exception -> L44
        int r15 = r13[0];     // Catch: Exception -> L44
        int r16 = r13[1];     // Catch: Exception -> L44
        r4.getLocationOnScreen(r13);     // Catch: Exception -> L44
        r13[0] = (r12 + r13[0]) - r15;     // Catch: Exception -> L44
        r13[1] = (r14 + r13[1]) - r16;     // Catch: Exception -> L44
    L20:
        setPopoverAnchorCenterX(r13[0] + (r18.getWidth() / 2.0f));     // Catch: Exception -> L44
        setPopoverAnchorCenterY(r13[1] + (r18.getHeight() / 2.0f));     // Catch: Exception -> L44
        if (this.mIsShowInDialog == false) goto L30;
        View r17 = r18.getRootView();     // Catch: Exception -> L44
        Context r110 = r18.getContext();     // Catch: Exception -> L44
        Intrinsics.checkNotNullExpressionValue(r110, "anchor.context");     // Catch: Exception -> L44
        int r111 = OUnitExtensionKt.getScreenWidth(r110);     // Catch: Exception -> L44
        Context r112 = r18.getContext();     // Catch: Exception -> L44
        Intrinsics.checkNotNullExpressionValue(r112, "anchor.context");     // Catch: Exception -> L44
        int r22 = OUnitExtensionKt.getAppScreenHeight(r112);     // Catch: Exception -> L44
        int r113 = OWindowConfigController.getStatusBarHeight(r18.getContext());     // Catch: Exception -> L44
        int r114 = OWindowConfigController.INSTANCE.getNavigationBarHeight(r18.getContext());     // Catch: Exception -> L44
        if (r17.getWidth() >= r111) goto L25;
        float r115 = (r111 - r17.getWidth()) / 2.0f;     // Catch: Exception -> L44
    L26:
        int r116 = MathKt.roundToInt(r115);     // Catch: Exception -> L44
        if (r17.getHeight() >= r22) goto L29;
        int r23 = ((r22 - r17.getHeight()) + r113) + r114;     // Catch: Exception -> L44
    L31:
        int r2 = (r20 - r10.getFirst().intValue()) - r116;     // Catch: Exception -> L44
        int r3 = (r21 - r10.getSecond().intValue()) - r23;     // Catch: Exception -> L44
        setPopoverPopupOriginX(r2);     // Catch: Exception -> L44
        setPopoverPopupOriginY(r3);     // Catch: Exception -> L44
        setElevation(getElevationPx());     // Catch: Exception -> L44
        if (this.mIsShowInDialog == true) goto L39;
        if (r7 == null) goto L39;
        if (Intrinsics.areEqual(r18.getWindowToken(), r7.getWindow().getDecorView().getWindowToken()) == true) goto L38;
        if (r8 == true) goto L38;
        r1 = r18.getRootView();     // Catch: Exception -> L44
        Intrinsics.checkNotNullExpressionValue(r1, "anchor.rootView");     // Catch: Exception -> L44
    L38:
        r1 = r7.getWindow().getDecorView();     // Catch: Exception -> L44
        Intrinsics.checkNotNullExpressionValue(r1, "activity.window.decorView");     // Catch: Exception -> L44
    L39:
        super.showAtLocation(r1, r9, r2, r3);     // Catch: Exception -> L44
        afterShowInStackIfNeeded();     // Catch: Exception -> L44
        setElevation(0.0f);     // Catch: Exception -> L44
        getContentView().setElevation(0.0f);     // Catch: Exception -> L44
        this.mIsFirstShow = false;     // Catch: Exception -> L44
        this.isAlreadyDismiss = false;     // Catch: Exception -> L44
        if (shouldAnimatePopoverVisibilityInternal() == false) goto L42;
        playPopoverEnterAnimationInternal();     // Catch: Exception -> L44
        return;
    L42:
        showPopoverWithoutAnimationInternal();     // Catch: Exception -> L44
        return;
    L29:
        r23 = 0;
        goto L31
    L25:
        r115 = 0.0f;
        goto L26
    L30:
        r23 = 0;
        r116 = 0;
        goto L31
    L19:
        r1.getLocationOnScreen(r13);     // Catch: Exception -> L44
        goto L20
    L9:
        if (this.mIsShowInDialog == true) goto L12;
        r11 = false;
    L44:
        e = move-exception;
        L.e(TAG, "showAtLocation, error", e);
    }

    private final boolean isAnchorFromPopupWindow(View r7) {
        if (r7 != null) goto L5;
        return false;
    L5:
        String r0 = r7.getClass().getName();
        if (Intrinsics.areEqual(r0, "android.widget.PopupWindow$PopupDecorView") == false) goto L39;
        return true;
    L39:
        boolean r1 = Class.forName("android.widget.PopupWindow$PopupDecorView").isInstance(r7);     // Catch: Throwable -> L10
    L11:
        if (r1 == false) goto L37;
        return true;
    L37:
        IBinder r2 = r7.getWindowToken();     // Catch: Throwable -> L36
        IBinder r3 = r7.getApplicationWindowToken();     // Catch: Throwable -> L36
        if (r2 == null) goto L19;
        if (r3 == null) goto L19;
        if (Intrinsics.areEqual(r2, r3) == true) goto L19;
        boolean r4 = true;
    L20:
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        if ((r8 instanceof WindowManager.LayoutParams) == false) goto L23;
        WindowManager.LayoutParams r9 = (WindowManager.LayoutParams) r8;
    L24:
        if (r9 != null) goto L27;
    L25:
        boolean r10 = false;
    L31:
        if (r4 == false) goto L34;
        if (r10 == false) goto L34;
        return true;
    L34:
        Intrinsics.checkNotNullExpressionValue(r0, "className");
        return StringsKt.contains$default(r0, "PopupDecorView", false, 2, null);
    L27:
        if (r9.type != 1002) goto L29;
    L30:
        r10 = true;
        goto L31
    L29:
        if (r9.type != 1000) goto L25;
    L23:
        r9 = null;
    L19:
        r4 = false;
    L10:
        r1 = false;
        goto L11
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View r9, int r10, int r11, int r12) {
        int r13 = Companion.adaptGravity$OUI_standardRelease(r12);
        beforeShowInStackIfNeeded();     // Catch: Exception -> L29
        Pair<Integer, Integer> r0 = addShadowFrameIfNeeded(r10, r11);     // Catch: Exception -> L29
        if (this.mGetLocationInWindow == false) goto L6;
    L9:
        boolean r1 = true;
    L10:
        this.useWindowCoords = r1;     // Catch: Exception -> L29
        if (r9 != null) goto L13;
        Unit r2 = null;
    L18:
        if (r2 != null) goto L20;
        OPopover r3 = this;     // Catch: Exception -> L29
        setPopoverAnchorCenterX(Float.NaN);     // Catch: Exception -> L29
        setPopoverAnchorCenterY(Float.NaN);     // Catch: Exception -> L29
    L20:
        super.showAsDropDown(r9, r10 - r0.getFirst().intValue(), r11 - r0.getSecond().intValue(), r13);     // Catch: Exception -> L29
        afterShowInStackIfNeeded();     // Catch: Exception -> L29
        this.mIsFirstShow = false;     // Catch: Exception -> L29
        int[] r14 = new int[2];     // Catch: Exception -> L29
        if (this.useWindowCoords == false) goto L23;
        getContentView().getLocationInWindow(r14);     // Catch: Exception -> L29
    L24:
        setPopoverPopupOriginX(r14[0]);     // Catch: Exception -> L29
        setPopoverPopupOriginY(r14[1]);     // Catch: Exception -> L29
        this.isAlreadyDismiss = false;     // Catch: Exception -> L29
        if (shouldAnimatePopoverVisibilityInternal() == false) goto L27;
        playPopoverEnterAnimationInternal();     // Catch: Exception -> L29
        return;
    L27:
        showPopoverWithoutAnimationInternal();     // Catch: Exception -> L29
        return;
    L23:
        getContentView().getLocationOnScreen(r14);     // Catch: Exception -> L29
        goto L24
    L13:
        int[] r5 = new int[2];     // Catch: Exception -> L29
        if (r1 == false) goto L16;
        r9.getLocationInWindow(r5);     // Catch: Exception -> L29
    L17:
        setPopoverAnchorCenterX(r5[0] + (r9.getWidth() / 2.0f));     // Catch: Exception -> L29
        setPopoverAnchorCenterY(r5[1] + (r9.getHeight() / 2.0f));     // Catch: Exception -> L29
        r2 = Unit.INSTANCE;     // Catch: Exception -> L29
        goto L18
    L16:
        r9.getLocationOnScreen(r5);     // Catch: Exception -> L29
        goto L17
    L6:
        if (this.mIsShowInDialog == true) goto L9;
        r1 = false;
    L29:
        e = move-exception;
        L.e(TAG, "showAsDropDown, error", e);
    }

    private final void hideSystemUi() {
        if (Intrinsics.areEqual(this.isHideVirtualKey, false) == false) goto L5;
        return;
    L5:
        getContentView().setSystemUiVisibility(UProperty.JOINING_GROUP);
    }

    private final void measure() {
        View r0 = getContentView();
        Intrinsics.checkNotNullExpressionValue(r0, "contentView");
        measurePopoverContent(r0, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public final void onDestroy() {
        cancelPopoverAnimatorInternal();
        clearFakeAnchorViewIfNecessary();
        onDestroyInStackIfNeeded();
        Activity r0 = OWindowConfigController.INSTANCE.getActivity(this.mContext);
        if (r0 != null) goto L5;
    L14:
        super.dismiss();     // Catch: Exception -> L13
        return;
    L16:
        return;
    L5:
        if (r0.isFinishing() == true) goto L9;
        if (isShowing() == true) goto L14;
    L9:
        if (shouldForceDismiss == true) goto L14;
    }

    public final int getMeasuredHeight() {
        if (this.mIsFirstShow == false) goto L6;
        measure();
        return getContentView().getMeasuredHeight();
    L6:
        OPopoverLayout r1 = this.mOBubbleLayout;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r1 = null;
    L10:
        return r1.getMeasuredHeight();
    }

    public final int getMeasuredWidth() {
        if (this.mIsFirstShow == false) goto L6;
        measure();
        return getContentView().getMeasuredWidth();
    L6:
        OPopoverLayout r1 = this.mOBubbleLayout;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r1 = null;
    L10:
        return r1.getMeasuredWidth();
    }

    public final View getPopoverView() {
        OPopoverLayout r0 = this.mOBubbleLayout;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r0 = null;
    L6:
        return r0;
    }

    public final void setMaxContentHeight(int r3) {
        if (this.mOBubbleLayout == null) goto L8;
        if (r3 <= 0) goto L9;
        View r0 = getContentView();
        Intrinsics.checkNotNullExpressionValue(r0, "contentView");
        setPopoverMaxContentHeight(r3, r0, Integer.MIN_VALUE, Integer.MIN_VALUE);
        return;
    L9:
        return;
    }

    /* JADX INFO: renamed from: mDismissRunnable$lambda-3, reason: not valid java name */
    private static final void m1303mDismissRunnable$lambda3(OPopover r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        if (r1.enableAutoDismiss == false) goto L6;
        r1.dismiss();
        return;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (this.isAlreadyDismiss == false) goto L5;
        return;
    L5:
        if (shouldAnimatePopoverVisibilityInternal() == false) goto L7;
        playPopoverExitAnimationInternal();
    L8:
        getContentView().removeCallbacks(this.mDismissRunnable);
        setPopoverXOffset(0);
        setPopoverYOffset(0);
        return;
    L7:
        finishPopoverDismissInternal();
        goto L8
    }

    public final void setEnableAutoDismiss(boolean r1) {
        this.enableAutoDismiss = r1;
    }

    public final void dismissDirectly() {
        if (this.isAlreadyDismiss == true) goto L9;
        ViewGroup r0 = this.mWindowFrame;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mWindowFrame");
        r0 = null;
    L7:
        r0.setVisibility(8);
        finishPopoverDismissInternal();
        getContentView().removeCallbacks(this.mDismissRunnable);
        setPopoverXOffset(0);
        setPopoverYOffset(0);
        return;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void onPopoverShownInternal() {
        setAnimationStyle(0);
        OnBubbleShowListener r1 = this.mShowListener;
        if (r1 == null) goto L7;
        r1.bubbleShow();
        return;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public int resolvePopoverAnimationGravityInternal() {
        return getPopoverGravity();
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void onPopoverStartDismissInternal() {
        setAnimationStyle(0);
        this.isAlreadyDismiss = true;
        OnBubbleStartDismissListener r1 = this.mStartDismissListener;
        if (r1 == null) goto L7;
        r1.bubbleStartDismiss();
        return;
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void playPopoverEnterAnimationInternal() {
        setAnimationStyle(0);
        OPopoverBase.DefaultImpls.playPopoverEnterAnimationInternal(this);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void playPopoverExitAnimationInternal() {
        setAnimationStyle(0);
        OPopoverBase.DefaultImpls.playPopoverExitAnimationInternal(this);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public void finishPopoverDismissInternal() {
        setPopoverAnimator(null);
        OnBubbleDismissListener r0 = this.mDismissListener;
        if (r0 == null) goto L6;
        r0.bubbleDismiss();
    L6:
        onDestroy();
    }

    private final void clearFakeAnchorViewIfNecessary() {
        if (this.mActivity != null) goto L5;
        return;
    L5:
        ViewUtil r0 = ViewUtil.INSTANCE;
        Activity r3 = this.mActivity;
        Intrinsics.checkNotNull(r3);
        ViewGroup r4 = r0.getActivityContentView(r3);
        if (r4 == null) goto L18;
        Sequence<View> r1 = ViewGroupKt.getChildren(r4);
        if (r1 == null) goto L20;
        Sequence r2 = SequencesKt.filter(r1, AnonymousClass1.INSTANCE);
        if (r2 == null) goto L21;
        Iterator r5 = r2.iterator();
    L16:
        if (r5.hasNext() == false) goto L22;
        r4.removeView((View) r5.next());
        L.d(TAG, "remove fake anchor view");
        goto L16
    L22:
        return;
    L21:
        return;
    L20:
        return;
    }

    private final Pair<Integer, Integer> addShadowFrameIfNeeded(int r2, int r3) {
        if (this.mShadowEnabled == false) goto L6;
        return addShadowFrame(r2, r3);
    L6:
        return new Pair(0, 0);
    }

    private final float getElevationPx() {
        int r0 = this.mShadowStyle;
        if (r0 == 0) goto L16;
        float r1 = resolvePopoverShadowSpace(r0);
        if (r1 > 0.0f) goto L12;
        L r2 = L.INSTANCE;
        if (r2.isBlocked(8) == true) goto L10;
        r2.getImpl().writeLog(TAG, 8, Intrinsics.stringPlus("surfaceInsets elevation resolved to 0, fallback to default. shadowStyleRes=", Integer.valueOf(access$getMShadowStyle$p(this))), null);
    L10:
        return 0.0f;
    L12:
        if (this.mSpacingForShadow == false) goto L15;
        return 0.0f;
    L15:
        return r1;
    L16:
        return 0.0f;
    }

    private final Pair<Integer, Integer> addShadowFrame(int r19, int r20) {
        ViewGroup r6 = null;
        if (this.mIsFirstShow == true) goto L15;
        ViewGroup r1 = this.mWindowFrame;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mWindowFrame");
        r1 = null;
    L8:
        if ((r1 instanceof SingleChildFrameLayout) == false) goto L15;
        ViewGroup r2 = this.mWindowFrame;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mWindowFrame");
    L13:
        r6.setVisibility(4);
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        Context r3 = getContentView().getContext();
        Intrinsics.checkNotNullExpressionValue(r3, "contentView.context");
        setWidth(OUnitExtensionKt.getScreenWidth(r3));
        return new Pair(Integer.valueOf(r19), Integer.valueOf(this.mShadowSpaceTop));
    L12:
        r6 = r2;
    L15:
        View r4 = LayoutInflater.from(this.mContext).inflate(R.layout.o_layout_popover_shadow_frame, null);
        if (r4 == null) goto L44;
        SingleChildFrameLayout r5 = (SingleChildFrameLayout) r4;
        OPopoverLayout r7 = this.mOBubbleLayout;
        if (r7 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r7 = null;
    L20:
        r5.addView(r7, new FrameLayout.LayoutParams(-2, -2));
        OPopoverLayout r8 = this.mOBubbleLayout;
        if (r8 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r8 = null;
    L23:
        r5.setShadowCornerRadius(MathKt.roundToInt(r8.getCornerRadius()));
        OPopoverLayout r9 = this.mOBubbleLayout;
        if (r9 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r9 = null;
    L26:
        int r10 = r9.getArrowHeight();
        OPopoverLayout r11 = this.mOBubbleLayout;
        if (r11 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r11 = null;
    L29:
        r5.setShadowInsets(r10, r11.getArrowHeight());
        int r12 = this.mShadowStyle;
        if (r12 != 0) goto L34;
        r12 = R.style.OUIShadow_Oui_Shadow_Thick;
    L34:
        if (this.mSpacingForShadow == false) goto L36;
        OPopoverBase.ShadowPadding r13 = resolvePopoverShadowPadding(r12);
    L37:
        r13.getLeft();
        int r14 = r13.getTop();
        r13.getRight();
        int r15 = r13.getBottom();
        SingleChildFrameLayout r16 = new SingleChildFrameLayout(this.mContext, null, 2, null);
        Context r17 = getContentView().getContext();
        Intrinsics.checkNotNullExpressionValue(r17, "contentView.context");
        r16.setLayoutParams(new ViewGroup.MarginLayoutParams(OUnitExtensionKt.getScreenWidth(r17), -2));
        r16.addView(r5, new FrameLayout.LayoutParams(-2, -2));
        r16.setClipChildren(false);
        r16.setClipToPadding(false);
        r16.setPadding(0, r14, 0, r15);
        r5.setX(r19);
        r16.setOnTouchListener(new OPopover$$ExternalSyntheticLambda0(this));
        this.mShadowSpaceTop = r14;
        SingleChildFrameLayout r18 = r16;
        this.mWindowFrame = r18;
        r18.setVisibility(4);
        ViewGroup r21 = this.mWindowFrame;
        if (r21 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("mWindowFrame");
    L41:
        setContentView(r6);
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        Context r22 = getContentView().getContext();
        Intrinsics.checkNotNullExpressionValue(r22, "contentView.context");
        setWidth(OUnitExtensionKt.getScreenWidth(r22));
        return new Pair(Integer.valueOf(r19), Integer.valueOf(r14));
    L40:
        r6 = r21;
        goto L41
    L36:
        r13 = new OPopoverBase.ShadowPadding(0, 0, 0, 0, 15, null);
        goto L37
    L44:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.popover.SingleChildFrameLayout");
    }

    /* JADX INFO: renamed from: addShadowFrame$lambda-8, reason: not valid java name */
    private static final boolean m1302addShadowFrame$lambda8(OPopover r2, View r3, MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        if (r4.getAction() != 0) goto L12;
        ViewUtil r5 = ViewUtil.INSTANCE;
        OPopoverLayout r0 = r2.mOBubbleLayout;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r0 = null;
    L7:
        Intrinsics.checkNotNullExpressionValue(r4, "event");
        if (r5.isEventOutsideView$OUI_standardRelease(r0, r4) == false) goto L13;
        r2.dismiss();
        return false;
    L13:
        return false;
    L12:
        return false;
    }

    public final void setIsShowInDialog(boolean r1) {
        this.mIsShowInDialog = r1;
    }

    public final void setGravity(int r1) {
        setGravityInternal(r1);
    }

    @Override // com.obric.oui.popover.v2.OPopoverBase
    public boolean isPopoverShowing() {
        return isShowing();
    }
}
