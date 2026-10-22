package com.obric.oui.popover;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Outline;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.bytedanceos.security.invokeHistory.InvokeHistoryActivity;
import com.obric.common.oui.R;
import com.obric.oui.animation.easy.ViewPropertySpringAnimator;
import com.obric.oui.animation.easy.ViewPropertySpringAnimatorExtKt;
import com.obric.oui.animation.engine.DynamicAnimation;
import com.obric.oui.animation.engine.FloatPropertyCompat;
import com.obric.oui.common.style.OUILayoutHelper;
import com.obric.oui.common.style.Shadow;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.popover.menu.OPopoverMenuView;
import com.obric.oui.utils.AnimUtils;
import com.obric.oui.utils.KtExt;
import com.obric.oui.utils.ViewUtil;
import com.obric.oui.utils.log.L;
import com.obric.oui.window.OWindowConfigController;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: OPopover.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b7\b\u0016\u0018\u0000 ¦\u00012\u00020\u0001:\f¤\u0001¥\u0001¦\u0001§\u0001¨\u0001©\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010[\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\\2\u0006\u0010]\u001a\u00020\u000f2\u0006\u0010^\u001a\u00020\u000fH\u0003J$\u0010_\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\\2\u0006\u0010]\u001a\u00020\u000f2\u0006\u0010^\u001a\u00020\u000fH\u0002J\u0010\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020\u0014H\u0003JA\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020\u00142\u0006\u0010f\u001a\u00020\u000f2\u0006\u0010g\u001a\u00020\u000f2\u0006\u0010h\u001a\u00020\u000f2\b\b\u0002\u0010i\u001a\u00020\u00142\b\b\u0002\u0010j\u001a\u00020\u0014H\u0001¢\u0006\u0002\bkJ\b\u0010l\u001a\u00020aH\u0002J\b\u0010m\u001a\u00020aH\u0016J\u0006\u0010n\u001a\u00020aJ\u0006\u0010o\u001a\u00020\u000fJ&\u0010p\u001a\u00020a2\u0006\u0010q\u001a\u00020\t2\u0006\u0010f\u001a\u00020\u000f2\u0006\u0010e\u001a\u00020\u00142\u0006\u0010r\u001a\u00020sJ\u0006\u0010t\u001a\u00020\u000fJ\u0006\u0010u\u001a\u00020\u000fJ\u0006\u0010v\u001a\u00020\u001bJ\u0006\u0010w\u001a\u00020\u000fJ\u0006\u0010x\u001a\u00020\u000fJ\u0010\u0010y\u001a\u00020\u000f2\u0006\u0010f\u001a\u00020\u000fH\u0004J\u0006\u0010z\u001a\u00020\tJ\b\u0010{\u001a\u00020aH\u0002J\u0006\u0010|\u001a\u00020aJ\b\u0010}\u001a\u00020aH\u0002J\b\u0010~\u001a\u00020aH\u0002J\u0006\u0010\u007f\u001a\u00020aJ0\u0010\u0080\u0001\u001a\u00020a2\u0006\u0010q\u001a\u00020\t2\u0006\u0010f\u001a\u00020\u000f2\u0006\u0010]\u001a\u00020\u000f2\u0006\u0010^\u001a\u00020\u000f2\u0007\u0010\u0081\u0001\u001a\u00020\u001dJ\u0012\u0010\u0082\u0001\u001a\u00020a2\u0007\u0010\u0083\u0001\u001a\u00020\u000fH\u0007J\u0010\u0010\u0084\u0001\u001a\u00020a2\u0007\u0010\u0085\u0001\u001a\u00020\u0014J\u0014\u0010\u0086\u0001\u001a\u00020a2\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010\tH\u0002J+\u0010\u0088\u0001\u001a\u00020a2\u0006\u0010q\u001a\u00020\t2\u0006\u0010f\u001a\u00020\u000f2\u0006\u0010e\u001a\u00020\u00142\b\b\u0002\u0010j\u001a\u00020\u0014H\u0003J\u0019\u0010\u0089\u0001\u001a\u00020a2\u0007\u0010\u008a\u0001\u001a\u00020\u00112\u0007\u0010\u008b\u0001\u001a\u00020\u0011J\t\u0010\u008c\u0001\u001a\u00020aH\u0002J\u0010\u0010\u008d\u0001\u001a\u00020a2\u0007\u0010\u008e\u0001\u001a\u00020\u0014J\u0017\u0010\u008f\u0001\u001a\u00020a2\u0006\u0010f\u001a\u00020\u000fH\u0000¢\u0006\u0003\b\u0090\u0001J\u0010\u0010\u0091\u0001\u001a\u00020a2\u0007\u0010\u0092\u0001\u001a\u00020\u0014J\u0010\u0010\u0093\u0001\u001a\u00020a2\u0007\u0010\u0094\u0001\u001a\u00020\u000fJ\u001b\u0010\u0095\u0001\u001a\u00020a2\u0007\u0010\u0087\u0001\u001a\u00020\t2\u0007\u0010\u0094\u0001\u001a\u00020\u000fH\u0002J\u0010\u0010\u0096\u0001\u001a\u00020a2\u0007\u0010\u0097\u0001\u001a\u00020HJ\u0010\u0010\u0098\u0001\u001a\u00020a2\u0007\u0010\u0099\u0001\u001a\u00020\u000fJ\u0010\u0010\u009a\u0001\u001a\u00020a2\u0007\u0010\u009b\u0001\u001a\u00020\u000fJ-\u0010\u009c\u0001\u001a\u00020a2\b\u0010q\u001a\u0004\u0018\u00010\t2\u0006\u0010f\u001a\u00020\u000f2\u0006\u0010e\u001a\u00020\u00142\b\b\u0002\u0010j\u001a\u00020\u0014H\u0007JH\u0010\u009c\u0001\u001a\u00020a2\b\u0010q\u001a\u0004\u0018\u00010\t2\u0006\u0010f\u001a\u00020\u000f2\u0006\u0010e\u001a\u00020\u00142\u0007\u0010\u009d\u0001\u001a\u00020\u001d2\u0007\u0010\u0099\u0001\u001a\u00020\u000f2\u0007\u0010\u009b\u0001\u001a\u00020\u000f2\b\b\u0002\u0010j\u001a\u00020\u0014H\u0007J7\u0010\u009c\u0001\u001a\u00020a2\b\u0010q\u001a\u0004\u0018\u00010\t2\u0006\u0010f\u001a\u00020\u000f2\u0007\u0010\u009d\u0001\u001a\u00020\u001d2\u0007\u0010\u009e\u0001\u001a\u00020\u000f2\b\b\u0002\u0010j\u001a\u00020\u0014H\u0007J-\u0010\u009f\u0001\u001a\u00020a2\b\u0010q\u001a\u0004\u0018\u00010\t2\u0007\u0010 \u0001\u001a\u00020\u000f2\u0007\u0010¡\u0001\u001a\u00020\u000f2\u0006\u0010f\u001a\u00020\u000fH\u0016J)\u0010¢\u0001\u001a\u00020a2\u0006\u0010q\u001a\u00020\t2\u0006\u0010f\u001a\u00020\u000f2\u0006\u0010]\u001a\u00020\u000f2\u0006\u0010^\u001a\u00020\u000fH\u0016J\t\u0010£\u0001\u001a\u00020aH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010,\u001a\u00020\u000f8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u000e\u0010/\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u00010HX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020LX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010NX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010P\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020SX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010W\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0004\n\u0002\u0010XR\u0012\u0010Y\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0004\n\u0002\u0010XR\u000e\u0010Z\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006ª\u0001"}, d2 = {"Lcom/obric/oui/popover/OPopover;", "Landroid/widget/PopupWindow;", "builder", "Lcom/obric/oui/popover/OPopover$Builder;", "(Lcom/obric/oui/popover/OPopover$Builder;)V", "activity", "Landroid/app/Activity;", "animFloatP", "Lcom/obric/oui/animation/engine/FloatPropertyCompat;", "Landroid/view/View;", "animSet", "Landroid/animation/AnimatorSet;", "bubbleText", "", "bubbleTextRes", "", "customInAnimator", "Landroid/animation/Animator;", "customOutAnimator", "enableAutoDismiss", "", "hasCome", "isAlreadyDismiss", "isHideVirtualKey", "Ljava/lang/Boolean;", "mAlignArrowPadding", "mAnimTime", "", "mArrowOffset", "", "mAutoDismissDelayMillis", "mBgColor", "mBorderColor", "mBorderWidth", "mBubbleOffset", "mClickListener", "Lcom/obric/oui/popover/OPopover$OnBubbleClickListener;", "mCornerRadius", "mDismissListener", "Lcom/obric/oui/popover/OPopover$OnBubbleDismissListener;", "mDismissRunnable", "Ljava/lang/Runnable;", "mFocusable", "mGetLocationInWindow", "mGravity", "getMGravity", "()I", "mHeight", "mIsFirstShow", "mIsShowInDialog", "mLayoutClickable", "mNeedArrow", "mNeedOverShoot", "mNeedShadow", "mOBubbleLayout", "Lcom/obric/oui/popover/OPopoverLayout;", "mOnClickMaintain", "mOutsideTouchable", "mPadding", "mParentHeight", "mParentWidth", "mShadowColor", "mShadowRadius", "mShadowSpaceTop", "mShowAsDropDown", "mShowElevationShadow", "mShowListener", "Lcom/obric/oui/popover/OPopover$OnBubbleShowListener;", "mShowWithAnimation", "mSubText", "mSubTextColor", "mTargetLocation", "Landroid/graphics/Point;", "mTextColor", "mTextSize", "mTextView", "Lcom/obric/oui/popover/PopoverTextView;", "mTypeFace", "Landroid/graphics/Typeface;", "mUseDefaultView", "mView", "mWidth", "mWindowFrame", "Landroid/view/ViewGroup;", "mXOffset", "mYOffset", "padding", "shadowDx", "Ljava/lang/Float;", "shadowDy", "transparentBg", "addShadowFrame", "Lkotlin/Pair;", MaterialConfigFormatNames.X, MaterialConfigFormatNames.Y, "addShadowFrameIfNeeded", "animatorEasyInOut", "", "isIn", "calTargetPosition", "", "isMiddle", "gravity", "anchorWidth", "anchorHeight", "ignoreAlign", "hasAdapted", "calTargetPosition$OUI_standardRelease", "clearFakeAnchorViewIfNecessary", "dismiss", "dismissDirectly", "getArrowHeight", "getBubblePosition", "anchor", "position", "Landroid/graphics/Rect;", "getBubbledHeight", "getBubbledWidth", "getInAnimTime", "getMeasuredHeight", "getMeasuredWidth", "getOrientation", "getPopoverView", "hideSystemUi", "hideView", "initContentView", "measure", "onDestroy", "popupAtLocation", "arrowOffSet", "setAdjustHeight", "adjustHeight", "setAlignArrowPadding", "align", "setBubbleLayout", "view", "setBubblePositionAndShow", "setCustomAnimator", "inAnimator", "outAnimator", "setDefaultView", "setEnableAutoDismiss", "value", "setGravity", "setGravity$OUI_standardRelease", "setIsShowInDialog", "isShowInDialog", "setMaxContentHeight", "maxHeight", "setMaxContentHeightIfPossible", "setTargetLocation", "targetLocation", "setXOffset", "xOffset", "setYOffset", "yOffset", InvokeHistoryActivity.PREF_SHOW, "arrowOffset", "offset", "showAsDropDown", "xoff", "yoff", "showAtLocation", "showDirectly", "Builder", "CommonFloatProperty", "Companion", "OnBubbleClickListener", "OnBubbleDismissListener", "OnBubbleShowListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OPopover extends PopupWindow {
    public static final Companion Companion = null;
    public static final long OPACITY_LONG = 120;
    public static final long OPACITY_SHORT = 90;
    private static final float POPUP_WINDOW_ELEVATION = 50.0f;
    public static final long SCALE_LONG = 420;
    public static final long SCALE_SHORT = 120;
    private static final String TAG = "OPopover";
    private static final boolean USE_OUI_SHADOW = true;
    private static volatile int currentShowBubbleNumbers;
    private static boolean shouldForceDismiss;
    private Activity activity;
    private final FloatPropertyCompat<View> animFloatP;
    private AnimatorSet animSet;
    private String bubbleText;
    private int bubbleTextRes;
    private Animator customInAnimator;
    private Animator customOutAnimator;
    private boolean enableAutoDismiss;
    private boolean hasCome;
    private boolean isAlreadyDismiss;
    private Boolean isHideVirtualKey;
    private boolean mAlignArrowPadding;
    private long mAnimTime;
    private float mArrowOffset;
    private long mAutoDismissDelayMillis;
    private int mBgColor;
    private int mBorderColor;
    private int mBorderWidth;
    private float mBubbleOffset;
    private OnBubbleClickListener mClickListener;
    private float mCornerRadius;
    private OnBubbleDismissListener mDismissListener;
    private final Runnable mDismissRunnable;
    private boolean mFocusable;
    private boolean mGetLocationInWindow;
    private int mGravity;
    private int mHeight;
    private boolean mIsFirstShow;
    private boolean mIsShowInDialog;
    private boolean mLayoutClickable;
    private boolean mNeedArrow;
    private boolean mNeedOverShoot;
    private boolean mNeedShadow;
    private OPopoverLayout mOBubbleLayout;
    private boolean mOnClickMaintain;
    private boolean mOutsideTouchable;
    private float mPadding;
    private int mParentHeight;
    private int mParentWidth;
    private int mShadowColor;
    private float mShadowRadius;
    private int mShadowSpaceTop;
    private boolean mShowAsDropDown;
    private boolean mShowElevationShadow;
    private OnBubbleShowListener mShowListener;
    private boolean mShowWithAnimation;
    private String mSubText;
    private int mSubTextColor;
    private Point mTargetLocation;
    private int mTextColor;
    private float mTextSize;
    private PopoverTextView mTextView;
    private Typeface mTypeFace;
    private boolean mUseDefaultView;
    private View mView;
    private int mWidth;
    private ViewGroup mWindowFrame;
    private int mXOffset;
    private int mYOffset;
    private int padding;
    private Float shadowDx;
    private Float shadowDy;
    private boolean transparentBg;

    /* JADX INFO: compiled from: OPopover.kt */
    @Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b8\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\bF\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010°\u0001\u001a\u00020\u00002\u0007\u0010±\u0001\u001a\u00020\u000fJ\b\u0010²\u0001\u001a\u00030³\u0001J\u0010\u0010´\u0001\u001a\u00020\u00002\u0007\u0010µ\u0001\u001a\u00020\u000fJ\u0010\u0010¶\u0001\u001a\u00020\u00002\u0007\u0010·\u0001\u001a\u00020\u0015J\u0010\u0010¸\u0001\u001a\u00020\u00002\u0007\u0010¹\u0001\u001a\u00020\tJ\u0010\u0010º\u0001\u001a\u00020\u00002\u0007\u0010·\u0001\u001a\u00020\u0015J\u0012\u0010»\u0001\u001a\u00020\u00002\t\b\u0001\u0010¼\u0001\u001a\u00020!J\u0010\u0010½\u0001\u001a\u00020\u00002\u0007\u0010¾\u0001\u001a\u00020!J\u0010\u0010¿\u0001\u001a\u00020\u00002\u0007\u0010À\u0001\u001a\u00020!J\u0010\u0010Á\u0001\u001a\u00020\u00002\u0007\u0010Â\u0001\u001a\u00020-J\u0010\u0010Ã\u0001\u001a\u00020\u00002\u0007\u0010Ä\u0001\u001a\u00020!J\u0010\u0010\f\u001a\u00020\u00002\b\b\u0001\u0010\b\u001a\u00020\tJ\u0010\u0010Å\u0001\u001a\u00020\u00002\u0007\u0010Æ\u0001\u001a\u00020\u000fJ\u0010\u0010Ç\u0001\u001a\u00020\u00002\u0007\u0010È\u0001\u001a\u00020\u000fJ\u0010\u0010É\u0001\u001a\u00020\u00002\u0007\u0010Ê\u0001\u001a\u00020!J\u0012\u0010Ë\u0001\u001a\u00020\u00002\u0007\u0010Ì\u0001\u001a\u00020!H\u0007J\u0010\u0010Í\u0001\u001a\u00020\u00002\u0007\u0010Î\u0001\u001a\u00020\u000fJ\u0010\u0010Ï\u0001\u001a\u00020\u00002\u0007\u0010Ð\u0001\u001a\u00020\u000fJ\u0010\u0010Ñ\u0001\u001a\u00020\u00002\u0007\u0010Ò\u0001\u001a\u00020\u000fJ\u0010\u0010Ó\u0001\u001a\u00020\u00002\u0007\u0010Ò\u0001\u001a\u00020\u000fJ\u0012\u0010Ô\u0001\u001a\u00020\u00002\u0007\u0010Ò\u0001\u001a\u00020\u000fH\u0007J\u0010\u0010Õ\u0001\u001a\u00020\u00002\u0007\u0010Ò\u0001\u001a\u00020\u000fJ\u0010\u0010Ö\u0001\u001a\u00020\u00002\u0007\u0010×\u0001\u001a\u000206J\u0010\u0010Ø\u0001\u001a\u00020\u00002\u0007\u0010×\u0001\u001a\u00020<J\u0010\u0010Ù\u0001\u001a\u00020\u00002\u0007\u0010×\u0001\u001a\u00020uJ\u0010\u0010Ú\u0001\u001a\u00020\u00002\u0007\u0010Û\u0001\u001a\u00020\u000fJ\u0010\u0010Ü\u0001\u001a\u00020\u00002\u0007\u0010Ý\u0001\u001a\u00020\tJ\u0010\u0010Þ\u0001\u001a\u00020\u00002\u0007\u0010¼\u0001\u001a\u00020!J\u0010\u0010ß\u0001\u001a\u00020\u00002\u0007\u0010à\u0001\u001a\u00020\u000fJ\u0010\u0010á\u0001\u001a\u00020\u00002\u0007\u0010â\u0001\u001a\u00020\u000fJ\u0010\u0010ã\u0001\u001a\u00020\u00002\u0007\u0010Â\u0001\u001a\u00020-J\u0010\u0010ä\u0001\u001a\u00020\u00002\u0007\u0010¼\u0001\u001a\u00020!J\u0010\u0010å\u0001\u001a\u00020\u00002\u0007\u0010¼\u0001\u001a\u00020!J\u0010\u0010æ\u0001\u001a\u00020\u00002\u0007\u0010ç\u0001\u001a\u00020\tJ\u0011\u0010è\u0001\u001a\u00020\u00002\b\u0010é\u0001\u001a\u00030\u008a\u0001J\u0010\u0010ê\u0001\u001a\u00020\u00002\u0007\u0010ë\u0001\u001a\u00020\u000fJ\u0011\u0010ì\u0001\u001a\u00020\u00002\b\u0010í\u0001\u001a\u00030\u0093\u0001J\u0012\u0010î\u0001\u001a\u00020\u00002\u0007\u0010ï\u0001\u001a\u00020!H\u0007J\u0010\u0010ð\u0001\u001a\u00020\u00002\u0007\u0010¹\u0001\u001a\u00020!J\u0010\u0010ñ\u0001\u001a\u00020\u00002\u0007\u0010¹\u0001\u001a\u00020!J\u0019\u0010ò\u0001\u001a\u00020\u00002\u0007\u0010ó\u0001\u001a\u00020\t2\u0007\u0010ô\u0001\u001a\u00020\tJ\u0010\u0010õ\u0001\u001a\u00020\u00002\u0007\u0010ö\u0001\u001a\u00020\tJ\u0010\u0010÷\u0001\u001a\u00020\u00002\u0007\u0010÷\u0001\u001a\u00020\u000fJ\u0010\u0010ª\u0001\u001a\u00020\u00002\u0007\u0010ø\u0001\u001a\u00020\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b\u001c\u0010\rR\u001a\u0010\u001d\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\u001a\u0010)\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010#\"\u0004\b+\u0010%R\u001a\u0010,\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010#\"\u0004\b4\u0010%R\u001c\u00105\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010;\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010A\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0011\"\u0004\bC\u0010\u0013R\u001a\u0010D\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0011\"\u0004\bF\u0010\u0013R\u001a\u0010G\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010#\"\u0004\bI\u0010%R\u001a\u0010J\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010#\"\u0004\bL\u0010%R\u001a\u0010M\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0011\"\u0004\bO\u0010\u0013R\u001a\u0010P\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0011\"\u0004\bR\u0010\u0013R\u001a\u0010S\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u0011\"\u0004\bU\u0010\u0013R\u001a\u0010V\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u0011\"\u0004\bX\u0010\u0013R\u001a\u0010Y\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u0011\"\u0004\b[\u0010\u0013R\u001a\u0010\\\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\u0011\"\u0004\b^\u0010\u0013R\u001a\u0010_\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u0011\"\u0004\ba\u0010\u0013R\u001a\u0010b\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010\u0011\"\u0004\bd\u0010\u0013R\u001a\u0010e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010\u000b\"\u0004\bg\u0010\rR\u001a\u0010h\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010#\"\u0004\bj\u0010%R\u001a\u0010k\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010\u000b\"\u0004\bm\u0010\rR\u001a\u0010n\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010\u0011\"\u0004\bp\u0010\u0013R\u001a\u0010q\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010\u0011\"\u0004\bs\u0010\u0013R\u001c\u0010t\u001a\u0004\u0018\u00010uX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u001a\u0010z\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010\u0011\"\u0004\b|\u0010\u0013R\u001a\u0010}\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010/\"\u0004\b\u007f\u00101R\u001d\u0010\u0080\u0001\u001a\u00020!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010#\"\u0005\b\u0082\u0001\u0010%R\u001d\u0010\u0083\u0001\u001a\u00020!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0001\u0010#\"\u0005\b\u0085\u0001\u0010%R\u001d\u0010\u0086\u0001\u001a\u00020\tX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0001\u0010\u000b\"\u0005\b\u0088\u0001\u0010\rR\"\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u008a\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R\u001d\u0010\u008f\u0001\u001a\u00020\u000fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010\u0011\"\u0005\b\u0091\u0001\u0010\u0013R\"\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001\"\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001d\u0010\u0098\u0001\u001a\u00020!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0099\u0001\u0010#\"\u0005\b\u009a\u0001\u0010%R\u001d\u0010\u009b\u0001\u001a\u00020!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009c\u0001\u0010#\"\u0005\b\u009d\u0001\u0010%R\u001d\u0010\u009e\u0001\u001a\u00020!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009f\u0001\u0010#\"\u0005\b \u0001\u0010%R$\u0010¡\u0001\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0015\n\u0003\u0010¦\u0001\u001a\u0006\b¢\u0001\u0010£\u0001\"\u0006\b¤\u0001\u0010¥\u0001R$\u0010§\u0001\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0015\n\u0003\u0010¦\u0001\u001a\u0006\b¨\u0001\u0010£\u0001\"\u0006\b©\u0001\u0010¥\u0001R\u001d\u0010ª\u0001\u001a\u00020\u000fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b«\u0001\u0010\u0011\"\u0005\b¬\u0001\u0010\u0013R\u001d\u0010\u00ad\u0001\u001a\u00020\u000fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b®\u0001\u0010\u0011\"\u0005\b¯\u0001\u0010\u0013¨\u0006ù\u0001"}, d2 = {"Lcom/obric/oui/popover/OPopover$Builder;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "cornerRadius", "", "getCornerRadius", "()F", "setCornerRadius", "(F)V", "mAlignArrowPadding", "", "getMAlignArrowPadding", "()Z", "setMAlignArrowPadding", "(Z)V", "mAnimTime", "", "getMAnimTime", "()J", "setMAnimTime", "(J)V", "mArrowOffset", "getMArrowOffset", "setMArrowOffset", "mAutoDismissDelayMillis", "getMAutoDismissDelayMillis", "setMAutoDismissDelayMillis", "mBgColor", "", "getMBgColor", "()I", "setMBgColor", "(I)V", "mBorderColor", "getMBorderColor", "setMBorderColor", "mBorderWidth", "getMBorderWidth", "setMBorderWidth", "mBubbleText", "", "getMBubbleText", "()Ljava/lang/String;", "setMBubbleText", "(Ljava/lang/String;)V", "mBubbleTextRes", "getMBubbleTextRes", "setMBubbleTextRes", "mClickListener", "Lcom/obric/oui/popover/OPopover$OnBubbleClickListener;", "getMClickListener", "()Lcom/obric/oui/popover/OPopover$OnBubbleClickListener;", "setMClickListener", "(Lcom/obric/oui/popover/OPopover$OnBubbleClickListener;)V", "mDismissListener", "Lcom/obric/oui/popover/OPopover$OnBubbleDismissListener;", "getMDismissListener", "()Lcom/obric/oui/popover/OPopover$OnBubbleDismissListener;", "setMDismissListener", "(Lcom/obric/oui/popover/OPopover$OnBubbleDismissListener;)V", "mFocusable", "getMFocusable", "setMFocusable", "mGetLocationInWindow", "getMGetLocationInWindow", "setMGetLocationInWindow", "mGravity", "getMGravity", "setMGravity", "mHeight", "getMHeight", "setMHeight", "mHideVirtualKey", "getMHideVirtualKey", "setMHideVirtualKey", "mLayoutClickable", "getMLayoutClickable", "setMLayoutClickable", "mNeedAddColor", "getMNeedAddColor", "setMNeedAddColor", "mNeedArrow", "getMNeedArrow", "setMNeedArrow", "mNeedOverShoot", "getMNeedOverShoot", "setMNeedOverShoot", "mNeedShadow", "getMNeedShadow", "setMNeedShadow", "mOnClickMaintain", "getMOnClickMaintain", "setMOnClickMaintain", "mOutsideTouchable", "getMOutsideTouchable", "setMOutsideTouchable", "mPadding", "getMPadding", "setMPadding", "mShadowColor", "getMShadowColor", "setMShadowColor", "mShadowRadius", "getMShadowRadius", "setMShadowRadius", "mShowAsDropDown", "getMShowAsDropDown", "setMShowAsDropDown", "mShowElevationShadow", "getMShowElevationShadow", "setMShowElevationShadow", "mShowListener", "Lcom/obric/oui/popover/OPopover$OnBubbleShowListener;", "getMShowListener", "()Lcom/obric/oui/popover/OPopover$OnBubbleShowListener;", "setMShowListener", "(Lcom/obric/oui/popover/OPopover$OnBubbleShowListener;)V", "mShowWithAnimation", "getMShowWithAnimation", "setMShowWithAnimation", "mSubText", "getMSubText", "setMSubText", "mSubTextColor", "getMSubTextColor", "setMSubTextColor", "mTextColor", "getMTextColor", "setMTextColor", "mTextSize", "getMTextSize", "setMTextSize", "mTypeFace", "Landroid/graphics/Typeface;", "getMTypeFace", "()Landroid/graphics/Typeface;", "setMTypeFace", "(Landroid/graphics/Typeface;)V", "mUseDefaultView", "getMUseDefaultView", "setMUseDefaultView", "mView", "Landroid/view/View;", "getMView", "()Landroid/view/View;", "setMView", "(Landroid/view/View;)V", "mWidth", "getMWidth", "setMWidth", "mXOffset", "getMXOffset", "setMXOffset", "mYOffset", "getMYOffset", "setMYOffset", "shadowDx", "getShadowDx", "()Ljava/lang/Float;", "setShadowDx", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "shadowDy", "getShadowDy", "setShadowDy", "transparentBg", "getTransparentBg", "setTransparentBg", "useAlphaAnim", "getUseAlphaAnim", "setUseAlphaAnim", "alignArrowPadding", "align", "build", "Lcom/obric/oui/popover/OPopover;", "onClickMaintain", "maintain", "setAnimTime", DBHelper.COL_TIME, "setArrowOffset", "offset", "setAutoDismissDelayMillis", "setBgColor", "color", "setBorderColor", "borderColor", "setBorderWidth", "borderWidth", "setBubbleText", "str", "setBubbleTextRes", "resId", "setFocusable", "focusable", "setGetLocationInWindow", "getLocationInWindow", "setGravity", "gravity", "setHeight", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "setHideVirtualKey", "hide", "setLayoutClickable", "clickable", "setNeedArrow", "need", "setNeedOverShoot", "setNeedPath", "setNeedShadow", "setOnClickListener", "listener", "setOnDismissListener", "setOnShowListener", "setOutSideTouchable", "touchable", "setPadding", "padding", "setShadowColor", "setShowElevationShadow", InvokeHistoryActivity.PREF_SHOW, "setShowWithAnim", "withAnim", "setSubText", "setSubTextColor", "setTextColor", "setTextSize", "textSize", "setTypeface", "tf", "setUseDefaultView", "useDefault", "setView", "view", "setWidth", MaterialConfigFormatNames.WIDTH, "setXOffset", "setYOffset", "shadowOffset", "dx", "dy", "shadowRadius", "radius", "showAsDropDown", "transparent", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {
        private Activity activity;
        private float cornerRadius;
        private boolean mAlignArrowPadding;
        private long mAnimTime;
        private float mArrowOffset;
        private long mAutoDismissDelayMillis;
        private int mBgColor;
        private int mBorderColor;
        private int mBorderWidth;
        private String mBubbleText;
        private int mBubbleTextRes;
        private OnBubbleClickListener mClickListener;
        private OnBubbleDismissListener mDismissListener;
        private boolean mFocusable;
        private boolean mGetLocationInWindow;
        private int mGravity;
        private int mHeight;
        private boolean mHideVirtualKey;
        private boolean mLayoutClickable;
        private boolean mNeedAddColor;
        private boolean mNeedArrow;
        private boolean mNeedOverShoot;
        private boolean mNeedShadow;
        private boolean mOnClickMaintain;
        private boolean mOutsideTouchable;
        private float mPadding;
        private int mShadowColor;
        private float mShadowRadius;
        private boolean mShowAsDropDown;
        private boolean mShowElevationShadow;
        private OnBubbleShowListener mShowListener;
        private boolean mShowWithAnimation;
        private String mSubText;
        private int mSubTextColor;
        private int mTextColor;
        private float mTextSize;
        private Typeface mTypeFace;
        private boolean mUseDefaultView;
        private View mView;
        private int mWidth;
        private int mXOffset;
        private int mYOffset;
        private Float shadowDx;
        private Float shadowDy;
        private boolean transparentBg;
        private boolean useAlphaAnim;

        @Deprecated(message = "do nothing")
        public final Builder setHeight(int r1) {
            return this;
        }

        @Deprecated(message = "No op", replaceWith = @ReplaceWith(expression = "Not supported anymore", imports = {}))
        public final Builder setNeedPath(boolean r1) {
            return this;
        }

        @Deprecated(message = "Use OPopoverEntranceMenuView.Builder#setWidthLevel instead")
        public final Builder setWidth(int r1) {
            return this;
        }

        public Builder(Activity r3) {
            Intrinsics.checkNotNullParameter(r3, "activity");
            this.activity = r3;
            this.mBgColor = ContextCompat.getColor(r3, R.color.oui_toast_background);
            this.mAnimTime = 800;
            this.mAutoDismissDelayMillis = Long.MIN_VALUE;
            this.mBubbleText = "";
            this.mTextSize = 13.0f;
            this.mTextColor = ContextCompat.getColor(this.activity, R.color.oui_toast_text);
            this.mPadding = 12.0f;
            this.mOutsideTouchable = true;
            this.mShadowColor = -16777216;
            this.mShadowRadius = 2.0f;
            this.mNeedAddColor = true;
            this.mShowElevationShadow = true;
            this.mLayoutClickable = true;
            this.mSubText = "";
            this.mSubTextColor = ContextCompat.getColor(this.activity, R.color.oui_toast_text);
            this.mShowWithAnimation = true;
        }

        public final Activity getActivity() {
            return this.activity;
        }

        public final void setActivity(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.activity = r2;
        }

        public final boolean getMFocusable() {
            return this.mFocusable;
        }

        public final void setMFocusable(boolean r1) {
            this.mFocusable = r1;
        }

        public final int getMGravity() {
            return this.mGravity;
        }

        public final void setMGravity(int r1) {
            this.mGravity = r1;
        }

        public final float getMArrowOffset() {
            return this.mArrowOffset;
        }

        public final void setMArrowOffset(float r1) {
            this.mArrowOffset = r1;
        }

        public final int getMBgColor() {
            return this.mBgColor;
        }

        public final void setMBgColor(int r1) {
            this.mBgColor = r1;
        }

        public final boolean getMNeedOverShoot() {
            return this.mNeedOverShoot;
        }

        public final void setMNeedOverShoot(boolean r1) {
            this.mNeedOverShoot = r1;
        }

        public final boolean getMHideVirtualKey() {
            return this.mHideVirtualKey;
        }

        public final void setMHideVirtualKey(boolean r1) {
            this.mHideVirtualKey = r1;
        }

        public final int getMXOffset() {
            return this.mXOffset;
        }

        public final void setMXOffset(int r1) {
            this.mXOffset = r1;
        }

        public final int getMYOffset() {
            return this.mYOffset;
        }

        public final void setMYOffset(int r1) {
            this.mYOffset = r1;
        }

        public final long getMAnimTime() {
            return this.mAnimTime;
        }

        public final void setMAnimTime(long r1) {
            this.mAnimTime = r1;
        }

        public final long getMAutoDismissDelayMillis() {
            return this.mAutoDismissDelayMillis;
        }

        public final void setMAutoDismissDelayMillis(long r1) {
            this.mAutoDismissDelayMillis = r1;
        }

        public final boolean getMUseDefaultView() {
            return this.mUseDefaultView;
        }

        public final void setMUseDefaultView(boolean r1) {
            this.mUseDefaultView = r1;
        }

        public final View getMView() {
            return this.mView;
        }

        public final void setMView(View r1) {
            this.mView = r1;
        }

        public final int getMWidth() {
            return this.mWidth;
        }

        public final void setMWidth(int r1) {
            this.mWidth = r1;
        }

        public final int getMHeight() {
            return this.mHeight;
        }

        public final void setMHeight(int r1) {
            this.mHeight = r1;
        }

        public final String getMBubbleText() {
            return this.mBubbleText;
        }

        public final void setMBubbleText(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.mBubbleText = r2;
        }

        public final int getMBubbleTextRes() {
            return this.mBubbleTextRes;
        }

        public final void setMBubbleTextRes(int r1) {
            this.mBubbleTextRes = r1;
        }

        public final float getMTextSize() {
            return this.mTextSize;
        }

        public final void setMTextSize(float r1) {
            this.mTextSize = r1;
        }

        public final Typeface getMTypeFace() {
            return this.mTypeFace;
        }

        public final void setMTypeFace(Typeface r1) {
            this.mTypeFace = r1;
        }

        public final int getMTextColor() {
            return this.mTextColor;
        }

        public final void setMTextColor(int r1) {
            this.mTextColor = r1;
        }

        public final OnBubbleClickListener getMClickListener() {
            return this.mClickListener;
        }

        public final void setMClickListener(OnBubbleClickListener r1) {
            this.mClickListener = r1;
        }

        public final OnBubbleDismissListener getMDismissListener() {
            return this.mDismissListener;
        }

        public final void setMDismissListener(OnBubbleDismissListener r1) {
            this.mDismissListener = r1;
        }

        public final OnBubbleShowListener getMShowListener() {
            return this.mShowListener;
        }

        public final void setMShowListener(OnBubbleShowListener r1) {
            this.mShowListener = r1;
        }

        public final boolean getMNeedArrow() {
            return this.mNeedArrow;
        }

        public final void setMNeedArrow(boolean r1) {
            this.mNeedArrow = r1;
        }

        public final float getMPadding() {
            return this.mPadding;
        }

        public final void setMPadding(float r1) {
            this.mPadding = r1;
        }

        public final boolean getMOutsideTouchable() {
            return this.mOutsideTouchable;
        }

        public final void setMOutsideTouchable(boolean r1) {
            this.mOutsideTouchable = r1;
        }

        public final boolean getMNeedShadow() {
            return this.mNeedShadow;
        }

        public final void setMNeedShadow(boolean r1) {
            this.mNeedShadow = r1;
        }

        public final int getMShadowColor() {
            return this.mShadowColor;
        }

        public final void setMShadowColor(int r1) {
            this.mShadowColor = r1;
        }

        public final boolean getMAlignArrowPadding() {
            return this.mAlignArrowPadding;
        }

        public final void setMAlignArrowPadding(boolean r1) {
            this.mAlignArrowPadding = r1;
        }

        public final float getMShadowRadius() {
            return this.mShadowRadius;
        }

        public final void setMShadowRadius(float r1) {
            this.mShadowRadius = r1;
        }

        public final boolean getMNeedAddColor() {
            return this.mNeedAddColor;
        }

        public final void setMNeedAddColor(boolean r1) {
            this.mNeedAddColor = r1;
        }

        public final boolean getMGetLocationInWindow() {
            return this.mGetLocationInWindow;
        }

        public final void setMGetLocationInWindow(boolean r1) {
            this.mGetLocationInWindow = r1;
        }

        public final boolean getMShowElevationShadow() {
            return this.mShowElevationShadow;
        }

        public final void setMShowElevationShadow(boolean r1) {
            this.mShowElevationShadow = r1;
        }

        public final int getMBorderWidth() {
            return this.mBorderWidth;
        }

        public final void setMBorderWidth(int r1) {
            this.mBorderWidth = r1;
        }

        public final int getMBorderColor() {
            return this.mBorderColor;
        }

        public final void setMBorderColor(int r1) {
            this.mBorderColor = r1;
        }

        public final boolean getTransparentBg() {
            return this.transparentBg;
        }

        public final void setTransparentBg(boolean r1) {
            this.transparentBg = r1;
        }

        public final boolean getUseAlphaAnim() {
            return this.useAlphaAnim;
        }

        public final void setUseAlphaAnim(boolean r1) {
            this.useAlphaAnim = r1;
        }

        public final float getCornerRadius() {
            return this.cornerRadius;
        }

        /* JADX INFO: renamed from: setCornerRadius, reason: collision with other method in class */
        public final void m433setCornerRadius(float r1) {
            this.cornerRadius = r1;
        }

        public final Float getShadowDx() {
            return this.shadowDx;
        }

        public final void setShadowDx(Float r1) {
            this.shadowDx = r1;
        }

        public final Float getShadowDy() {
            return this.shadowDy;
        }

        public final void setShadowDy(Float r1) {
            this.shadowDy = r1;
        }

        public final boolean getMShowAsDropDown() {
            return this.mShowAsDropDown;
        }

        public final void setMShowAsDropDown(boolean r1) {
            this.mShowAsDropDown = r1;
        }

        public final boolean getMOnClickMaintain() {
            return this.mOnClickMaintain;
        }

        public final void setMOnClickMaintain(boolean r1) {
            this.mOnClickMaintain = r1;
        }

        public final boolean getMLayoutClickable() {
            return this.mLayoutClickable;
        }

        public final void setMLayoutClickable(boolean r1) {
            this.mLayoutClickable = r1;
        }

        public final String getMSubText() {
            return this.mSubText;
        }

        public final void setMSubText(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.mSubText = r2;
        }

        public final int getMSubTextColor() {
            return this.mSubTextColor;
        }

        public final void setMSubTextColor(int r1) {
            this.mSubTextColor = r1;
        }

        public final boolean getMShowWithAnimation() {
            return this.mShowWithAnimation;
        }

        public final void setMShowWithAnimation(boolean r1) {
            this.mShowWithAnimation = r1;
        }

        public final Builder setShowElevationShadow(boolean r1) {
            this.mShowElevationShadow = r1;
            return this;
        }

        public final Builder setFocusable(boolean r1) {
            this.mFocusable = r1;
            return this;
        }

        public final Builder setOutSideTouchable(boolean r1) {
            this.mOutsideTouchable = r1;
            return this;
        }

        public final Builder setPadding(float r1) {
            this.mPadding = r1;
            return this;
        }

        public final Builder setBorderColor(int r1) {
            this.mBorderColor = r1;
            return this;
        }

        public final Builder setBorderWidth(int r1) {
            this.mBorderWidth = r1;
            return this;
        }

        public final Builder setNeedArrow(boolean r1) {
            this.mNeedArrow = r1;
            return this;
        }

        public final Builder setOnClickListener(OnBubbleClickListener r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            this.mClickListener = r2;
            return this;
        }

        public final Builder setOnShowListener(OnBubbleShowListener r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            this.mShowListener = r2;
            return this;
        }

        public final Builder setOnDismissListener(OnBubbleDismissListener r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            this.mDismissListener = r2;
            return this;
        }

        public final Builder setTextColor(int r1) {
            this.mTextColor = r1;
            return this;
        }

        public final Builder setTypeface(Typeface r2) {
            Intrinsics.checkNotNullParameter(r2, "tf");
            this.mTypeFace = r2;
            return this;
        }

        public final Builder setTextSize(float r1) {
            this.mTextSize = r1;
            return this;
        }

        public final Builder setBubbleTextRes(int r1) {
            this.mBubbleTextRes = r1;
            return this;
        }

        public final Builder setBubbleText(String r2) {
            Intrinsics.checkNotNullParameter(r2, "str");
            this.mBubbleText = r2;
            return this;
        }

        public final Builder setSubText(String r2) {
            Intrinsics.checkNotNullParameter(r2, "str");
            this.mSubText = r2;
            return this;
        }

        public final Builder setSubTextColor(int r1) {
            this.mSubTextColor = r1;
            return this;
        }

        public final Builder setShowWithAnim(boolean r1) {
            this.mShowWithAnimation = r1;
            return this;
        }

        public final Builder setGravity(int r2) {
            this.mGravity = OPopover.Companion.adaptGravity$OUI_standardRelease(r2);
            return this;
        }

        public final Builder setArrowOffset(float r1) {
            this.mArrowOffset = r1;
            return this;
        }

        public final Builder setBgColor(int r1) {
            this.mBgColor = r1;
            return this;
        }

        public final Builder setNeedOverShoot(boolean r1) {
            this.mNeedOverShoot = r1;
            return this;
        }

        public final Builder setHideVirtualKey(boolean r1) {
            this.mHideVirtualKey = r1;
            return this;
        }

        public final Builder setXOffset(int r1) {
            this.mXOffset = r1;
            return this;
        }

        public final Builder setYOffset(int r1) {
            this.mYOffset = r1;
            return this;
        }

        public final Builder setAnimTime(long r1) {
            this.mAnimTime = r1;
            return this;
        }

        public final Builder setAutoDismissDelayMillis(long r1) {
            this.mAutoDismissDelayMillis = r1;
            return this;
        }

        public final Builder setUseDefaultView(boolean r1) {
            this.mUseDefaultView = r1;
            return this;
        }

        public final Builder setView(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.mView = r2;
            return this;
        }

        public final Builder setNeedShadow(boolean r1) {
            this.mNeedShadow = r1;
            return this;
        }

        public final Builder setShadowColor(int r1) {
            this.mShadowColor = r1;
            return this;
        }

        public final Builder setGetLocationInWindow(boolean r1) {
            this.mGetLocationInWindow = r1;
            return this;
        }

        public final Builder alignArrowPadding(boolean r1) {
            this.mAlignArrowPadding = r1;
            return this;
        }

        public final Builder shadowRadius(float r1) {
            this.mShadowRadius = r1;
            return this;
        }

        public final Builder shadowOffset(float r1, float r2) {
            this.shadowDx = Float.valueOf(r1);
            this.shadowDy = Float.valueOf(r2);
            return this;
        }

        public final Builder transparentBg(boolean r1) {
            this.transparentBg = r1;
            return this;
        }

        public final Builder setCornerRadius(float r1) {
            this.cornerRadius = r1;
            return this;
        }

        public final Builder showAsDropDown(boolean r1) {
            this.mShowAsDropDown = r1;
            return this;
        }

        public final Builder onClickMaintain(boolean r1) {
            this.mOnClickMaintain = r1;
            return this;
        }

        public final Builder setLayoutClickable(boolean r1) {
            this.mLayoutClickable = r1;
            return this;
        }

        public final OPopover build() {
            return new OPopover(this);
        }
    }

    /* JADX INFO: compiled from: OPopover.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/obric/oui/popover/OPopover$CommonFloatProperty;", "", "value", "", "(F)V", "getValue", "()F", "setValue", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class CommonFloatProperty {
        private float value;

        public CommonFloatProperty(float r1) {
            this.value = r1;
        }

        public final float getValue() {
            return this.value;
        }

        public final void setValue(float r1) {
            this.value = r1;
        }
    }

    /* JADX INFO: compiled from: OPopover.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0013J\b\u0010\u0014\u001a\u00020\u000fH\u0007J\u0010\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/oui/popover/OPopover$Companion;", "", "()V", "OPACITY_LONG", "", "OPACITY_SHORT", "POPUP_WINDOW_ELEVATION", "", "SCALE_LONG", "SCALE_SHORT", "TAG", "", "USE_OUI_SHADOW", "", "currentShowBubbleNumbers", "", "shouldForceDismiss", "adaptGravity", "originGravity", "adaptGravity$OUI_standardRelease", "getCurrentShowBubbleNumbers", "setShouldForceDismiss", "", "forceDismiss", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final int adaptGravity$OUI_standardRelease(int r1) {
            if (r1 != 8388611) goto L5;
            return 3;
        L5:
            if (r1 != 8388613) goto L11;
            return 5;
        L11:
            return r1;
        }

        private Companion() {
        }

        @JvmStatic
        public final int getCurrentShowBubbleNumbers() {
            return OPopover.access$getCurrentShowBubbleNumbers$cp();
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
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/popover/OPopover$OnBubbleClickListener;", "", "clickBubble", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnBubbleClickListener {
        void clickBubble();
    }

    /* JADX INFO: compiled from: OPopover.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/popover/OPopover$OnBubbleDismissListener;", "", "bubbleDismiss", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnBubbleDismissListener {
        void bubbleDismiss();
    }

    /* JADX INFO: compiled from: OPopover.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/popover/OPopover$OnBubbleShowListener;", "", "bubbleShow", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnBubbleShowListener {
        void bubbleShow();
    }

    /* JADX INFO: renamed from: com.obric.oui.popover.OPopover$setBubbleLayout$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OPopover.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/oui/popover/OPopover$setBubbleLayout$2", "Landroid/view/ViewOutlineProvider;", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C02932 extends ViewOutlineProvider {
        final /* synthetic */ OPopover this$0;

        C02932(OPopover r1) {
            this.this$0 = r1;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View r5, Outline r6) {
            OPopoverLayout r7 = OPopover.access$getMOBubbleLayout$p(this.this$0);
            OPopoverLayout r0 = null;
            if (r7 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
            r7 = null;
        L5:
            OPopoverLayout r2 = OPopover.access$getMOBubbleLayout$p(this.this$0);
            if (r2 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
            r2 = null;
        L8:
            float r3 = r2.getMWidth();
            OPopoverLayout r4 = OPopover.access$getMOBubbleLayout$p(this.this$0);
            if (r4 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
            r4 = null;
        L11:
            r7.calculateBubbleArrowMatrix(r3, r4.getMHeight());
            if (r6 == null) goto L24;
            OPopoverLayout r8 = OPopover.access$getMOBubbleLayout$p(this.this$0);     // Catch: Exception -> L20
            if (r8 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");     // Catch: Exception -> L20
        L18:
            r6.setConvexPath(r0.getFullPath());     // Catch: Exception -> L20
            return;
        L17:
            r0 = r8;
        L20:
            Log.e(OPopover.TAG, "set convex path failed.");
            return;
        }
    }

    public static /* synthetic */ void $r8$lambda$ADSz87x5mncZ1Cv56GYA0sMw9G4(ViewGroup r0, float r1, float r2, float r3, float r4, float r5, float r6, DynamicAnimation r7, float r8, float r9) {
        m430animatorEasyInOut$lambda5$lambda4(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ boolean $r8$lambda$_FnOsdqHV5hIn391tEGAYO0WzCE(OPopover r0, View r1, MotionEvent r2) {
        return m429addShadowFrame$lambda10(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$hqIIllRv1iUBojTb1o8_wUnfL-Q, reason: not valid java name */
    public static /* synthetic */ void m427$r8$lambda$hqIIllRv1iUBojTb1o8_wUnfLQ(OPopover r0) {
        m431mDismissRunnable$lambda2(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$vZ1dIe-GWvlTUJ7aq9JXP8wQcHY, reason: not valid java name */
    public static /* synthetic */ void m428$r8$lambda$vZ1dIeGWvlTUJ7aq9JXP8wQcHY(OPopover r0, View r1) {
        m432setBubbleLayout$lambda0(r0, r1);
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final int getCurrentShowBubbleNumbers() {
        return Companion.getCurrentShowBubbleNumbers();
    }

    private final void setBubblePositionAndShow(View r8, int r9, boolean r10) {
        setBubblePositionAndShow$default(this, r8, r9, r10, false, 8, null);
    }

    public final int[] calTargetPosition$OUI_standardRelease(boolean r10, int r11, int r12, int r13) {
        return calTargetPosition$OUI_standardRelease$default(this, r10, r11, r12, r13, false, false, 48, null);
    }

    public final int[] calTargetPosition$OUI_standardRelease(boolean r10, int r11, int r12, int r13, boolean r14) {
        return calTargetPosition$OUI_standardRelease$default(this, r10, r11, r12, r13, r14, false, 32, null);
    }

    public final void show(View r9, int r10, float r11, int r12) {
        show$default(this, r9, r10, r11, r12, false, 16, null);
    }

    public final void show(View r8, int r9, boolean r10) {
        show$default(this, r8, r9, r10, false, 8, null);
    }

    public final void show(View r11, int r12, boolean r13, float r14, int r15, int r16) {
        show$default(this, r11, r12, r13, r14, r15, r16, false, 64, null);
    }

    public OPopover(Builder r4) {
        Intrinsics.checkNotNullParameter(r4, "builder");
        this.mShadowColor = -16777216;
        this.mAnimTime = 200;
        this.mAutoDismissDelayMillis = 5000;
        this.mUseDefaultView = true;
        this.bubbleText = "";
        this.mTextSize = 13.0f;
        this.mNeedArrow = true;
        this.mPadding = 12.0f;
        this.mOutsideTouchable = true;
        this.enableAutoDismiss = true;
        this.mShadowRadius = 2.0f;
        this.mLayoutClickable = true;
        this.mSubText = "";
        this.mSubTextColor = -7829368;
        this.mShowWithAnimation = true;
        this.mIsFirstShow = true;
        this.activity = r4.getActivity();
        this.mGravity = r4.getMGravity();
        this.mArrowOffset = r4.getMArrowOffset();
        this.mBgColor = r4.getMBgColor();
        this.mNeedOverShoot = r4.getMNeedOverShoot();
        this.isHideVirtualKey = Boolean.valueOf(r4.getMHideVirtualKey());
        this.mXOffset = r4.getMXOffset();
        this.mYOffset = r4.getMYOffset();
        this.mAnimTime = r4.getMAnimTime();
        this.mAutoDismissDelayMillis = r4.getMAutoDismissDelayMillis();
        this.mUseDefaultView = r4.getMUseDefaultView();
        this.mView = r4.getMView();
        this.mHeight = r4.getMHeight();
        this.mWidth = r4.getMWidth();
        this.bubbleText = r4.getMBubbleText();
        this.bubbleTextRes = r4.getMBubbleTextRes();
        this.mTextSize = r4.getMTextSize();
        this.mTextColor = r4.getMTextColor();
        this.mTypeFace = r4.getMTypeFace();
        this.mClickListener = r4.getMClickListener();
        this.mDismissListener = r4.getMDismissListener();
        this.mShowListener = r4.getMShowListener();
        this.mNeedArrow = r4.getMNeedArrow();
        this.mPadding = r4.getMPadding();
        this.mOutsideTouchable = r4.getMOutsideTouchable();
        this.mFocusable = r4.getMFocusable();
        this.mNeedShadow = r4.getMNeedShadow();
        this.mShadowColor = r4.getMShadowColor();
        this.mAlignArrowPadding = r4.getMAlignArrowPadding();
        this.mShadowRadius = r4.getMShadowRadius();
        this.mGetLocationInWindow = r4.getMGetLocationInWindow();
        this.mShowElevationShadow = r4.getMShowElevationShadow();
        this.mBorderWidth = r4.getMBorderWidth();
        this.mBorderColor = r4.getMBorderColor();
        this.transparentBg = r4.getTransparentBg();
        this.mCornerRadius = r4.getCornerRadius();
        this.shadowDx = r4.getShadowDx();
        this.shadowDy = r4.getShadowDy();
        this.mShowAsDropDown = r4.getMShowAsDropDown();
        this.mOnClickMaintain = r4.getMOnClickMaintain();
        this.mLayoutClickable = r4.getMLayoutClickable();
        this.mSubText = r4.getMSubText();
        this.mSubTextColor = r4.getMSubTextColor();
        this.mShowWithAnimation = r4.getMShowWithAnimation();
        setWidth(-2);
        setHeight(-2);
        setFocusable(this.mFocusable);
        setOutsideTouchable(this.mOutsideTouchable);
        setClippingEnabled(false);
        setInputMethodMode(1);
        setSoftInputMode(16);
        if (this.mUseDefaultView == true) goto L10;
        View r1 = this.mView;
        if (r1 == null) goto L10;
        setBubbleLayout(r1);
        OPopoverLayout r2 = this.mOBubbleLayout;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r2 = null;
    L9:
        r2.setUseDefaultView(false);
    L11:
        initContentView();
        setFocusable(true);
        this.mDismissRunnable = new OPopover$$ExternalSyntheticLambda0(this);
        this.animFloatP = new OPopover$animFloatP$1();
        return;
    L10:
        setDefaultView();
        goto L11
    }

    public static final /* synthetic */ int access$getCurrentShowBubbleNumbers$cp() {
        return currentShowBubbleNumbers;
    }

    public static final /* synthetic */ OnBubbleDismissListener access$getMDismissListener$p(OPopover r0) {
        return r0.mDismissListener;
    }

    public static final /* synthetic */ OPopoverLayout access$getMOBubbleLayout$p(OPopover r0) {
        return r0.mOBubbleLayout;
    }

    public static final /* synthetic */ OnBubbleShowListener access$getMShowListener$p(OPopover r0) {
        return r0.mShowListener;
    }

    public static final /* synthetic */ void access$setShouldForceDismiss$cp(boolean r0) {
        shouldForceDismiss = r0;
    }

    private final int getMGravity() {
        return Companion.adaptGravity$OUI_standardRelease(this.mGravity);
    }

    private final void initContentView() {
        boolean r1 = true;
        if (Intrinsics.areEqual(this.isHideVirtualKey, true) == false) goto L5;
        hideSystemUi();
    L5:
        OPopoverLayout r2 = null;
        if (this.mBgColor == 0) goto L11;
        OPopoverLayout r0 = this.mOBubbleLayout;
        if (r0 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r0 = null;
    L10:
        r0.setMBgColor(this.mBgColor);
    L11:
        OPopoverLayout r3 = this.mOBubbleLayout;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r3 = null;
    L14:
        r3.setBubbleOrientation(getOrientation(getMGravity()));
        if (this.mPadding == 0.0f) goto L18;
        r1 = false;
    L18:
        if (r1 == true) goto L23;
        OPopoverLayout r4 = this.mOBubbleLayout;
        if (r4 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r4 = null;
    L22:
        r4.setMPadding(this.padding);
    L23:
        OPopoverLayout r5 = this.mOBubbleLayout;
        if (r5 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r5 = null;
    L26:
        r5.getShadowConfig().setColor(this.mShadowColor);
        OPopoverLayout r6 = this.mOBubbleLayout;
        if (r6 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r6 = null;
    L29:
        r6.getShadowConfig().setRadius(this.mShadowRadius);
        OPopoverLayout r7 = this.mOBubbleLayout;
        if (r7 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r7 = null;
    L32:
        r7.setBorderColor(this.mBorderColor);
        OPopoverLayout r8 = this.mOBubbleLayout;
        if (r8 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r8 = null;
    L35:
        r8.setBorderWidth(this.mBorderWidth);
        OPopoverLayout r9 = this.mOBubbleLayout;
        if (r9 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
    L39:
        r2.setTransparentBg(this.transparentBg);
        return;
    L38:
        r2 = r9;
        goto L39
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

    public final void setXOffset(int r1) {
        this.mXOffset = r1;
    }

    public final void setYOffset(int r1) {
        this.mYOffset = r1;
    }

    public final void setAlignArrowPadding(boolean r1) {
        this.mAlignArrowPadding = r1;
    }

    private final void setDefaultView() {
        PopoverTextView r3 = null;
        PopoverTextView r0 = new PopoverTextView(this.activity, null, 2, null);
        this.mTextView = r0;
        if (this.mTextColor == 0) goto L5;
        r0.setTextColor(this.mTextColor);
    L7:
        if (this.mTypeFace == null) goto L12;
        PopoverTextView r1 = this.mTextView;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r1 = null;
    L11:
        r1.setTypeface(this.mTypeFace);
    L12:
        PopoverTextView r2 = this.mTextView;
        if (r2 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r2 = null;
    L15:
        r2.setTextSize(1, 14.0f);
        PopoverTextView r4 = this.mTextView;
        if (r4 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r4 = null;
    L18:
        r4.setTextAlignment(5);
        PopoverTextView r5 = this.mTextView;
        if (r5 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r5 = null;
    L21:
        r5.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        PopoverTextView r6 = this.mTextView;
        if (r6 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r6 = null;
    L24:
        PopoverTextView r7 = this.mTextView;
        if (r7 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r7 = null;
    L27:
        r6.setLineHeight(OUnitExtensionKt.vdp(r7, 20));
        PopoverTextView r8 = this.mTextView;
        if (r8 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r8 = null;
    L30:
        r8.setGravity(17);
        PopoverTextView r9 = this.mTextView;
        if (r9 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r9 = null;
    L33:
        PopoverTextView r10 = this.mTextView;
        if (r10 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r10 = null;
    L36:
        r9.setMaxWidth(OUnitExtensionKt.vdp(r10, 276));
        PopoverTextView r11 = this.mTextView;
        if (r11 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r11 = null;
    L39:
        r11.setEllipsize(TextUtils.TruncateAt.END);
        PopoverTextView r12 = this.mTextView;
        if (r12 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r12 = null;
    L42:
        setBubbleLayout(r12);
        if (this.isHideVirtualKey != null) goto L45;
        this.isHideVirtualKey = true;
    L45:
        boolean r13 = false;
        if (TextUtils.isEmpty(this.bubbleText) == true) goto L58;
        if (Intrinsics.areEqual(this.mSubText, "") == false) goto L53;
        PopoverTextView r14 = this.mTextView;
        if (r14 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r14 = null;
    L52:
        r14.setText(this.bubbleText);
        goto L58
    L53:
        SpannableString r15 = new SpannableString(this.bubbleText + '\n' + this.mSubText);
        r15.setSpan(new StyleSpan(0), 0, this.bubbleText.length(), 33);
        r15.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER), 0, this.bubbleText.length(), 33);
        r15.setSpan(new AbsoluteSizeSpan(14, true), 0, this.bubbleText.length(), 33);
        r15.setSpan(new ForegroundColorSpan(this.mSubTextColor), this.bubbleText.length() + 1, r15.length(), 33);
        r15.setSpan(new AbsoluteSizeSpan(14, true), this.bubbleText.length() + 1, r15.length(), 33);
        r15.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER), this.bubbleText.length() + 1, r15.length(), 33);
        PopoverTextView r16 = this.mTextView;
        if (r16 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r16 = null;
    L56:
        r16.setText(r15, TextView.BufferType.SPANNABLE);
    L58:
        if (this.bubbleTextRes == 0) goto L64;
        PopoverTextView r17 = this.mTextView;
        if (r17 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r17 = null;
    L62:
        r17.setText(this.bubbleTextRes);
    L64:
        if (this.mTextSize != 0.0f) goto L66;
        r13 = true;
    L66:
        if (r13 == true) goto L72;
        PopoverTextView r18 = this.mTextView;
        if (r18 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L71:
        r3.setTextSize(1, this.mTextSize);
        goto L72
    L70:
        r3 = r18;
    L72:
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        return;
    L5:
        r0.setTextColor(ContextCompat.getColor(this.activity, R.color.oui_toast_text));
        goto L7
    }

    private final void setBubbleLayout(View r7) {
        OPopoverLayout r0 = new OPopoverLayout(this.activity);
        this.mOBubbleLayout = r0;
        r0.setBackgroundColor(0);
        OPopoverLayout r3 = null;
        if (this.mUseDefaultView == true) goto L5;
        OPopoverLayout r1 = this.mOBubbleLayout;
        if (r1 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r1 = null;
    L17:
        r1.setCornerRadiusDp(OPopoverLayout.Companion.getCORNER_RADIUS_DP());
    L19:
        if (this.mCornerRadius != 0.0f) goto L21;
        boolean r2 = true;
    L22:
        if (r2 == true) goto L27;
        OPopoverLayout r4 = this.mOBubbleLayout;
        if (r4 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r4 = null;
    L26:
        r4.setCornerRadius(this.mCornerRadius);
    L27:
        OPopoverLayout r5 = this.mOBubbleLayout;
        if (r5 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r5 = null;
    L30:
        r5.setSubText(this.mSubText);
        OPopoverLayout r6 = this.mOBubbleLayout;
        if (r6 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r6 = null;
    L33:
        r6.setGravity(17);
        OPopoverLayout r8 = this.mOBubbleLayout;
        if (r8 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r8 = null;
    L36:
        r8.addView(r7);
        ViewGroup.MarginLayoutParams r9 = new ViewGroup.MarginLayoutParams(-2, -2);
        OPopoverLayout r10 = this.mOBubbleLayout;
        if (r10 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r10 = null;
    L39:
        r10.setLayoutParams(r9);
        if (this.mBgColor == 0) goto L45;
        OPopoverLayout r11 = this.mOBubbleLayout;
        if (r11 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r11 = null;
    L44:
        r11.setMBgColor(this.mBgColor);
    L45:
        OPopoverLayout r12 = this.mOBubbleLayout;
        if (r12 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r12 = null;
    L48:
        r12.setMNeedArrow(this.mNeedArrow);
        OPopoverLayout r13 = this.mOBubbleLayout;
        if (r13 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r13 = null;
    L51:
        r13.setMNeedShadow(this.mNeedShadow);
        OPopoverLayout r14 = this.mOBubbleLayout;
        if (r14 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r14 = null;
    L54:
        r14.getShadowConfig().setColor(this.mShadowColor);
        if (this.shadowDx == null) goto L61;
        OPopoverLayout r15 = this.mOBubbleLayout;
        if (r15 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r15 = null;
    L59:
        OPopoverLayout.ShadowConfig r16 = r15.getShadowConfig();
        Float r17 = this.shadowDx;
        Intrinsics.checkNotNull(r17);
        r16.setDx(r17.floatValue());
    L61:
        if (this.shadowDy == null) goto L67;
        OPopoverLayout r18 = this.mOBubbleLayout;
        if (r18 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r18 = null;
    L65:
        OPopoverLayout.ShadowConfig r19 = r18.getShadowConfig();
        Float r20 = this.shadowDy;
        Intrinsics.checkNotNull(r20);
        r19.setDy(r20.floatValue());
    L67:
        if (this.mLayoutClickable == false) goto L75;
        OPopoverLayout r21 = this.mOBubbleLayout;
        if (r21 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r21 = null;
    L71:
        r21.setClickable(true);
        OPopoverLayout r22 = this.mOBubbleLayout;
        if (r22 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r22 = null;
    L74:
        r22.setOnClickListener(new OPopover$$ExternalSyntheticLambda1(this));
    L79:
        OPopoverLayout r23 = this.mOBubbleLayout;
        if (r23 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r23 = null;
    L82:
        OPopoverLayout r24 = r23;
        this.mWindowFrame = r24;
        if (r24 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("mWindowFrame");
    L86:
        setContentView(r3);
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        return;
    L85:
        r3 = r24;
        goto L86
    L75:
        OPopoverLayout r25 = this.mOBubbleLayout;
        if (r25 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r25 = null;
    L78:
        r25.setClickable(false);
        goto L79
    L21:
        r2 = false;
        goto L22
    L5:
        if (Intrinsics.areEqual(this.mSubText, "") == false) goto L10;
        OPopoverLayout r26 = this.mOBubbleLayout;
        if (r26 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r26 = null;
    L9:
        r26.setCornerRadiusDp(OPopoverLayout.Companion.getCORNER_RADIUS_SINGLE_DP());
        goto L19
    L10:
        OPopoverLayout r27 = this.mOBubbleLayout;
        if (r27 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r27 = null;
    L13:
        r27.setCornerRadiusDp(OPopoverLayout.Companion.getCORNER_RADIUS_DOUBLE_DP());
        goto L19
    }

    /* JADX INFO: renamed from: setBubbleLayout$lambda-0, reason: not valid java name */
    private static final void m432setBubbleLayout$lambda0(OPopover r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        OnBubbleClickListener r2 = r0.mClickListener;
        if (r2 == null) goto L7;
        r2.clickBubble();
    L7:
        if (r0.mOnClickMaintain == true) goto L10;
        r0.dismiss();
        return;
    }

    protected final int getOrientation(int r3) {
        int r2 = Companion.adaptGravity$OUI_standardRelease(r3);
        if (r2 != 3) goto L5;
        return 2;
    L5:
        if (r2 == 5) goto L15;
        if (r2 != 48) goto L9;
        return 3;
    L9:
        if (r2 != 80) goto L15;
        return 0;
    L15:
        return 1;
    }

    public final void setGravity$OUI_standardRelease(int r3) {
        OPopoverLayout r0 = this.mOBubbleLayout;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r0 = null;
    L5:
        r0.setBubbleOrientation(getOrientation(Companion.adaptGravity$OUI_standardRelease(r3)));
    }

    public static /* synthetic */ void show$default(OPopover r6, View r7, int r8, float r9, int r10, boolean r11, int r12, Object r13) {
        if (r13 != null) goto L9;
        if ((r12 & 16) == 0) goto L6;
        r11 = false;
    L6:
        r6.show(r7, r8, r9, r10, r11);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: show");
    }

    public final void show(View r2, int r3, float r4, int r5, boolean r6) {
        int r7 = Companion.adaptGravity$OUI_standardRelease(r3);
        if (r7 != 48) goto L5;
    L7:
        this.mXOffset = r5;
    L8:
        this.mArrowOffset = r4;
        show(r2, r7, false, r6);
        return;
    L5:
        if (r7 == 80) goto L7;
        goto L7
    }

    public static /* synthetic */ void show$default(OPopover r9, View r10, int r11, boolean r12, float r13, int r14, int r15, boolean r16, int r17, Object r18) {
        if (r18 != null) goto L10;
        if ((r17 & 64) == 0) goto L6;
        boolean r8 = false;
    L7:
        r9.show(r10, r11, r12, r13, r14, r15, r8);
        return;
    L6:
        r8 = r16;
        goto L7
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: show");
    }

    public final void show(View r2, int r3, boolean r4, float r5, int r6, int r7, boolean r8) {
        int r9 = Companion.adaptGravity$OUI_standardRelease(r3);
        this.mXOffset = r6;
        this.mYOffset = r7;
        this.mArrowOffset = r5;
        show(r2, r9, r4, r8);
    }

    public static /* synthetic */ void show$default(OPopover r0, View r1, int r2, boolean r3, boolean r4, int r5, Object r6) {
        if (r6 != null) goto L9;
        if ((r5 & 8) == 0) goto L6;
        r4 = false;
    L6:
        r0.show(r1, r2, r3, r4);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: show");
    }

    public final void show(View r7, int r8, boolean r9, boolean r10) {
        int r11 = Companion.adaptGravity$OUI_standardRelease(r8);
        if (this.activity.isFinishing() == true) goto L35;
        if (r7 != null) goto L6;
        return;
    L6:
        if (r7.getWindowToken() == null) goto L38;
        this.mParentHeight = r7.getMeasuredHeight();
        this.mParentWidth = r7.getMeasuredWidth();
        getContentView().removeCallbacks(this.mDismissRunnable);
        this.mGravity = r11;
        OPopoverLayout r0 = this.mOBubbleLayout;
        OPopoverLayout r1 = null;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r0 = null;
    L11:
        this.padding = r0.getPadding();
        if (isShowing() == true) goto L33;
        int r2 = getOrientation(r11);
        measure();
        if (r9 == false) goto L23;
        if (r11 != 48) goto L18;
    L20:
        int r4 = getMeasuredWidth();
    L21:
        this.mBubbleOffset = r4 / 2.0f;
    L25:
        OPopoverLayout r5 = this.mOBubbleLayout;
        if (r5 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
    L29:
        r1.setBubbleParams(r2, this.mBubbleOffset + this.mArrowOffset);
        setBubblePositionAndShow(r7, r11, r9, r10);
        this.isAlreadyDismiss = false;
        if (this.mAutoDismissDelayMillis <= 0) goto L32;
        getContentView().postDelayed(this.mDismissRunnable, this.mAutoDismissDelayMillis);
    L32:
        currentShowBubbleNumbers++;
        return;
    L28:
        r1 = r5;
        goto L29
    L18:
        if (r11 == 80) goto L20;
        r4 = getMeasuredHeight();
        goto L21
    L23:
        if (this.hasCome == true) goto L25;
        this.mArrowOffset += this.padding;
        this.hasCome = true;
        goto L25
    L33:
        super.dismiss();
        return;
    L38:
        return;
    }

    @Deprecated(message = "这个函数只是为了dou+修一个UI问题，通常不要使用，如果使用请先联系zhangzhehua")
    public final void setAdjustHeight(int r1) {
        OPopoverLayout r0 = this.mOBubbleLayout;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r0 = null;
    L5:
        r0.setMAdjustHeight(r1);
    }

    public final void getBubblePosition(View r8, int r9, boolean r10, Rect r11) {
        Intrinsics.checkNotNullParameter(r8, "anchor");
        Intrinsics.checkNotNullParameter(r11, "position");
        int r12 = Companion.adaptGravity$OUI_standardRelease(r9);
        int[] r1 = new int[2];
        Point r2 = this.mTargetLocation;
        if (r2 == null) goto L5;
        Intrinsics.checkNotNull(r2);
        r1[0] = r2.x;
        r1[1] = r2.y;
    L10:
        if (r12 != 3) goto L12;
        if (r10 == false) goto L32;
        int r13 = (r8.getMeasuredHeight() - getMeasuredHeight()) / 2;
    L33:
        r11.left = (r1[0] + this.mXOffset) - getMeasuredWidth();
        r11.right = r1[0] + this.mXOffset;
        r11.top = ((r1[1] + this.mYOffset) + r13) + OUnitExtensionKt.vdp(r8, 1.3f);
        r11.bottom = (((r1[1] + this.mYOffset) + r8.getHeight()) - r13) - OUnitExtensionKt.vdp(r8, 1.3f);
        return;
    L32:
        r13 = 0;
        goto L33
    L12:
        if (r12 != 5) goto L14;
        if (r10 == false) goto L28;
        int r14 = (r8.getMeasuredHeight() - getMeasuredHeight()) / 2;
    L29:
        r11.left = (r1[0] + this.mXOffset) + r8.getWidth();
        r11.right = ((r1[0] + this.mXOffset) + r8.getWidth()) + getMeasuredWidth();
        r11.top = ((r1[1] + this.mYOffset) + r14) + OUnitExtensionKt.vdp(r8, 1.3f);
        r11.bottom = (((r1[1] + this.mYOffset) + r8.getHeight()) - r14) - OUnitExtensionKt.vdp(r8, 1.3f);
        return;
    L28:
        r14 = 0;
        goto L29
    L14:
        if (r12 != 48) goto L16;
        if (r10 == false) goto L24;
        int r15 = (r8.getMeasuredWidth() - getMeasuredWidth()) / 2;
    L25:
        r11.left = ((r1[0] + this.mXOffset) + r15) + OUnitExtensionKt.vdp(r8, 1.4f);
        r11.right = (((r1[0] + this.mXOffset) + r8.getWidth()) - r15) - OUnitExtensionKt.vdp(r8, 1.4f);
        r11.top = ((r1[1] + this.mYOffset) - OUnitExtensionKt.vdp(r8, 1.3f)) - getMeasuredHeight();
        r11.bottom = (r1[1] + this.mYOffset) - OUnitExtensionKt.vdp(r8, 1.3f);
        return;
    L24:
        r15 = 0;
        goto L25
    L16:
        if (r12 != 80) goto L38;
        if (r10 == false) goto L20;
        int r16 = (r8.getMeasuredWidth() - getMeasuredWidth()) / 2;
    L21:
        r11.left = ((r1[0] + this.mXOffset) + r16) + OUnitExtensionKt.vdp(r8, 1.4f);
        r11.right = (((r1[0] + this.mXOffset) + r8.getWidth()) - r16) - OUnitExtensionKt.vdp(r8, 1.4f);
        r11.top = ((r1[1] + this.mYOffset) + r8.getHeight()) + OUnitExtensionKt.vdp(r8, 1.3f);
        r11.bottom = (((r1[1] + this.mYOffset) + r8.getHeight()) + getMeasuredHeight()) + OUnitExtensionKt.vdp(r8, 1.3f);
        return;
    L20:
        r16 = 0;
        goto L21
    L38:
        return;
    L5:
        String r3 = r8.getContext().getResources().getConfiguration().toString();
        Intrinsics.checkNotNullExpressionValue(r3, "anchor.context.resources.configuration.toString()");
        if (StringsKt.contains$default(r3, "hw-magic-windows", false, 2, null) == false) goto L8;
        r8.getLocationInWindow(r1);
        goto L10
    L8:
        r8.getLocationOnScreen(r1);
        goto L10
    }

    static /* synthetic */ void setBubblePositionAndShow$default(OPopover r0, View r1, int r2, boolean r3, boolean r4, int r5, Object r6) {
        if (r6 != null) goto L9;
        if ((r5 & 8) == 0) goto L6;
        r4 = false;
    L6:
        r0.setBubblePositionAndShow(r1, r2, r3, r4);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setBubblePositionAndShow");
    }

    private final void setBubblePositionAndShow(View r11, int r12, boolean r13, boolean r14) {
        int r3 = Companion.adaptGravity$OUI_standardRelease(r12);
        int[] r15 = new int[2];
        Point r0 = this.mTargetLocation;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        r15[0] = r0.x;
        r15[1] = r0.y;
    L9:
        int[] r16 = calTargetPosition$OUI_standardRelease(r13, r3, r11.getMeasuredWidth(), r11.getMeasuredHeight(), false, r14);
        if (this.mShowAsDropDown == false) goto L12;
        showAsDropDown(r11, r16[0], r16[1] - r11.getMeasuredHeight(), 0);
    L13:
        this.mIsFirstShow = false;
        clearFakeAnchorViewIfNecessary();
        return;
    L12:
        showAtLocation(r11, 0, Math.max(0, r15[0] + r16[0]), Math.max(0, r15[1] + r16[1]));
        goto L13
    L6:
        if (this.mGetLocationInWindow == false) goto L8;
        r11.getLocationInWindow(r15);
        goto L9
    L8:
        r11.getLocationOnScreen(r15);
        goto L9
    }

    public static /* synthetic */ int[] calTargetPosition$OUI_standardRelease$default(OPopover r9, boolean r10, int r11, int r12, int r13, boolean r14, boolean r15, int r16, Object r17) {
        if (r17 != null) goto L14;
        if ((r16 & 16) == 0) goto L6;
        boolean r7 = false;
    L8:
        if ((r16 & 32) == 0) goto L10;
        boolean r8 = false;
    L12:
        return r9.calTargetPosition$OUI_standardRelease(r10, r11, r12, r13, r7, r8);
    L10:
        r8 = r15;
        goto L12
    L6:
        r7 = r14;
        goto L8
    L14:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: calTargetPosition");
    }

    public final int[] calTargetPosition$OUI_standardRelease(boolean r8, int r9, int r10, int r11, boolean r12, boolean r13) {
        int[] r1 = new int[2];
        if (this.mAlignArrowPadding == false) goto L14;
        if (r8 == true) goto L14;
        if (r12 == true) goto L14;
        int r14 = getMGravity();
        if (r14 == 3) goto L13;
        if (r14 == 5) goto L13;
        if (r14 == 48) goto L12;
        if (r14 != 80) goto L14;
    L12:
        this.mXOffset -= getArrowHeight();
    L13:
        this.mYOffset -= getArrowHeight();
    L14:
        int r15 = Companion.adaptGravity$OUI_standardRelease(r9);
        if (r15 == 3) goto L36;
        if (r15 == 5) goto L31;
        if (r15 == 48) goto L26;
        if (r15 == 80) goto L21;
    L40:
        return r1;
    L21:
        if ((r8 | r13) == false) goto L23;
        int r16 = (r10 - getMeasuredWidth()) / 2;
    L24:
        r1[0] = this.mXOffset + r16;
        r1[1] = this.mYOffset + r11;
        goto L40
    L23:
        r16 = 0;
        goto L24
    L26:
        if ((r8 | r13) == false) goto L28;
        int r17 = (r10 - getMeasuredWidth()) / 2;
    L29:
        r1[0] = this.mXOffset + r17;
        r1[1] = (-getMeasuredHeight()) + this.mYOffset;
        goto L40
    L28:
        r17 = 0;
        goto L29
    L31:
        if ((r8 | r13) == false) goto L33;
        int r18 = (r11 - getMeasuredHeight()) / 2;
    L34:
        r1[0] = this.mXOffset + r10;
        r1[1] = this.mYOffset + r18;
        goto L40
    L33:
        r18 = 0;
        goto L34
    L36:
        if ((r8 | r13) == false) goto L38;
        int r19 = (r11 - getMeasuredHeight()) / 2;
    L39:
        r1[0] = this.mXOffset - getMeasuredWidth();
        r1[1] = this.mYOffset + r19;
        goto L40
    L38:
        r19 = 0;
        goto L39
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View r9, int r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r9, "anchor");
        int r13 = Companion.adaptGravity$OUI_standardRelease(r10);
        Pair<Integer, Integer> r1 = addShadowFrameIfNeeded(r11, r12);     // Catch: Exception -> L19
        if (this.mIsShowInDialog == false) goto L13;
        View r2 = r9.getRootView();     // Catch: Exception -> L19
        Context r4 = r9.getContext();     // Catch: Exception -> L19
        Intrinsics.checkNotNullExpressionValue(r4, "anchor.context");     // Catch: Exception -> L19
        int r5 = OUnitExtensionKt.getScreenWidth(r4);     // Catch: Exception -> L19
        Context r6 = r9.getContext();     // Catch: Exception -> L19
        Intrinsics.checkNotNullExpressionValue(r6, "anchor.context");     // Catch: Exception -> L19
        int r0 = OUnitExtensionKt.getScreenHeight(r6);     // Catch: Exception -> L19
        int r7 = OWindowConfigController.getStatusBarHeight(r9.getContext());     // Catch: Exception -> L19
        int r8 = OWindowConfigController.INSTANCE.getNavigationBarHeight(r9.getContext());     // Catch: Exception -> L19
        if (r2.getWidth() >= r5) goto L8;
        float r14 = (r5 - r2.getWidth()) / 2.0f;     // Catch: Exception -> L19
    L9:
        int r15 = MathKt.roundToInt(r14);     // Catch: Exception -> L19
        if (r2.getHeight() >= r0) goto L12;
        int r3 = ((r0 - r2.getHeight()) + r7) + r8;     // Catch: Exception -> L19
    L14:
        super.showAtLocation(r9, r13, (r11 - r1.getFirst().intValue()) - r15, (r12 - r1.getSecond().intValue()) - r3);     // Catch: Exception -> L19
        this.isAlreadyDismiss = false;     // Catch: Exception -> L19
        if (this.mShowWithAnimation == false) goto L17;
        animatorEasyInOut(true);     // Catch: Exception -> L19
        return;
    L17:
        showDirectly();     // Catch: Exception -> L19
        return;
    L12:
        r3 = 0;
        goto L14
    L8:
        r14 = 0.0f;
        goto L9
    L13:
        r3 = 0;
        r15 = 0;
    L19:
        e = move-exception;
        L.e(TAG, "showAtLocation, error", e);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View r3, int r4, int r5, int r6) {
        int r7 = Companion.adaptGravity$OUI_standardRelease(r6);
        Pair<Integer, Integer> r0 = addShadowFrameIfNeeded(r4, r5);     // Catch: Exception -> L8
        super.showAsDropDown(r3, r4 - r0.getFirst().intValue(), r5 - r0.getSecond().intValue(), r7);     // Catch: Exception -> L8
        this.isAlreadyDismiss = false;     // Catch: Exception -> L8
        if (this.mShowWithAnimation == false) goto L6;
        animatorEasyInOut(true);     // Catch: Exception -> L8
    L11:
        return;
    L6:
        showDirectly();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        L.e(TAG, "showAsDropDown, error", e);
    }

    public final void popupAtLocation(View r3, int r4, int r5, int r6, float r7) {
        Intrinsics.checkNotNullParameter(r3, "anchor");
        int r8 = Companion.adaptGravity$OUI_standardRelease(r4);
        this.mGravity = r8;     // Catch: Exception -> L10
        this.mArrowOffset = r7;     // Catch: Exception -> L10
        OPopoverLayout r9 = this.mOBubbleLayout;     // Catch: Exception -> L10
        if (r9 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");     // Catch: Exception -> L10
        r9 = null;
    L6:
        r9.setBubbleParams(getOrientation(r8), this.mBubbleOffset + this.mArrowOffset);     // Catch: Exception -> L10
        showAtLocation(r3, 0, r5, r6);     // Catch: Exception -> L10
        if (this.mAutoDismissDelayMillis <= 0) goto L13;
        getContentView().postDelayed(this.mDismissRunnable, this.mAutoDismissDelayMillis);     // Catch: Exception -> L10
        return;
    L13:
        return;
    }

    public final void hideView() {
        ViewGroup r1 = this.mWindowFrame;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mWindowFrame");
        r1 = null;
    L5:
        r1.setVisibility(8);
    }

    private final void hideSystemUi() {
        if (Intrinsics.areEqual(this.isHideVirtualKey, false) == false) goto L5;
        return;
    L5:
        getContentView().setSystemUiVisibility(4102);
    }

    private final void measure() {
        int r0 = this.mWidth;
        if (r0 != 0) goto L5;
    L7:
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        return;
    L5:
        if (this.mHeight == 0) goto L7;
        int r1 = View.MeasureSpec.makeMeasureSpec(r0, 1073741824);
        int r2 = View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824);
        getContentView().measure(r1, r2);
    }

    public final void setTargetLocation(Point r2) {
        Intrinsics.checkNotNullParameter(r2, "targetLocation");
        this.mTargetLocation = r2;
    }

    public final void onDestroy() {
        AnimatorSet r0 = this.animSet;
        if (r0 == null) goto L6;
        r0.removeAllListeners();
    L6:
        AnimatorSet r1 = this.animSet;
        if (r1 == null) goto L10;
        r1.cancel();
    L10:
        this.animSet = null;
        clearFakeAnchorViewIfNecessary();
        if (this.activity.isFinishing() == true) goto L15;
        if (isShowing() == false) goto L15;
    L20:
        super.dismiss();     // Catch: Exception -> L19
        return;
    L22:
        return;
    L15:
        if (shouldForceDismiss == true) goto L20;
    }

    public final int getMeasuredHeight() {
        measure();
        return getContentView().getMeasuredHeight();
    }

    public final int getMeasuredWidth() {
        measure();
        return getContentView().getMeasuredWidth();
    }

    public final int getBubbledHeight() {
        measure();
        int r0 = getContentView().getMeasuredHeight();
        OPopoverLayout r1 = this.mOBubbleLayout;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r1 = null;
    L6:
        return r0 - (r1.getPadding() * 4);
    }

    public final int getBubbledWidth() {
        measure();
        int r0 = getContentView().getMeasuredWidth();
        OPopoverLayout r1 = this.mOBubbleLayout;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r1 = null;
    L6:
        return r0 - (r1.getPadding() * 4);
    }

    public final View getPopoverView() {
        OPopoverLayout r0 = this.mOBubbleLayout;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r0 = null;
    L6:
        return r0;
    }

    public final int getArrowHeight() {
        OPopoverLayout r0 = this.mOBubbleLayout;
        if (r0 == null) goto L7;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r0 = null;
    L9:
        return r0.getArrowHeight();
    L7:
        return 0;
    }

    public final void setMaxContentHeight(int r4) {
        OPopoverLayout r0 = this.mOBubbleLayout;
        if (r0 == null) goto L18;
        if (r4 <= 0) goto L19;
        OPopoverLayout r1 = null;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r0 = null;
    L9:
        int r5 = RangesKt.coerceAtLeast(r4 - (r0.getArrowHeight() * 2), 0);
        OPopoverLayout r2 = this.mOBubbleLayout;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r2 = null;
    L12:
        setMaxContentHeightIfPossible(r2, r5);
        OPopoverLayout r6 = this.mOBubbleLayout;
        if (r6 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
    L16:
        r1.requestLayout();
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        return;
    L15:
        r1 = r6;
        goto L16
    L19:
        return;
    }

    private final void setMaxContentHeightIfPossible(View r2, int r3) {
        if ((r2 instanceof OPopoverMenuView) == false) goto L6;
        ((OPopoverMenuView) r2).setPopoverMaxHeight(r3);
    L6:
        if ((r2 instanceof ViewGroup) == false) goto L11;
        Iterator<View> r4 = ViewGroupKt.getChildren((ViewGroup) r2).iterator();
    L9:
        if (r4.hasNext() == false) goto L13;
        setMaxContentHeightIfPossible(r4.next(), r3);
        goto L9
    L13:
        return;
    }

    /* JADX INFO: renamed from: mDismissRunnable$lambda-2, reason: not valid java name */
    private static final void m431mDismissRunnable$lambda2(OPopover r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        if (r1.enableAutoDismiss == false) goto L6;
        r1.animatorEasyInOut(false);
        return;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (this.isAlreadyDismiss == true) goto L6;
        animatorEasyInOut(false);
        getContentView().removeCallbacks(this.mDismissRunnable);
        this.mXOffset = 0;
        this.mYOffset = 0;
        return;
    }

    public final void setEnableAutoDismiss(boolean r1) {
        this.enableAutoDismiss = r1;
    }

    public final void dismissDirectly() {
        if (this.isAlreadyDismiss == true) goto L9;
        currentShowBubbleNumbers--;
        ViewGroup r0 = this.mWindowFrame;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mWindowFrame");
        r0 = null;
    L7:
        r0.setVisibility(8);
        onDestroy();
        getContentView().removeCallbacks(this.mDismissRunnable);
        this.mXOffset = 0;
        this.mYOffset = 0;
        return;
    }

    private final void showDirectly() {
        ViewGroup r0 = this.mWindowFrame;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mWindowFrame");
        r0 = null;
    L5:
        r0.setVisibility(0);
        OnBubbleShowListener r2 = this.mShowListener;
        if (r2 == null) goto L10;
        r2.bubbleShow();
        return;
    }

    /* JADX WARN: Type inference failed for: r12v2, types: [T, com.obric.oui.animation.easy.ViewPropertySpringAnimator] */
    private final void animatorEasyInOut(final boolean r22) {
        final ViewGroup r2 = this.mWindowFrame;
        OPopoverLayout r3 = null;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mWindowFrame");
        r2 = null;
    L5:
        int r4 = -1;
        if (r22 == true) goto L8;
        currentShowBubbleNumbers--;
        this.isAlreadyDismiss = true;
    L8:
        this.animSet = new AnimatorSet();
        int r6 = getMGravity();
        if (r6 != 3) goto L11;
        float r7 = r2.getX() + r2.getMeasuredWidth();
        float r8 = r2.getY();
        OPopoverLayout r11 = this.mOBubbleLayout;
        if (r11 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
    L35:
        float r5 = r3.getBubbleOffset();
    L36:
        float r9 = r5 + r8;
    L37:
        View r10 = r2.getChildAt(0);
        if (r10 != null) goto L40;
        float r12 = 0.0f;
    L41:
        r2.setPivotY(r9);
        r2.setPivotX(r7 + r12);
        float r13 = 1.0f;
        PathInterpolator r14 = new PathInterpolator(0.32f, 0.94f, 0.6f, 1.0f);
        PathInterpolator r15 = new PathInterpolator(0.0f, 0.0f, 1.0f, 1.0f);
        if (r22 == false) goto L44;
        float r16 = 0.0f;
    L45:
        if (r22 == false) goto L47;
        float r17 = 1.0f;
    L49:
        if (r2.getAlpha() != 0.0f) goto L51;
        boolean r18 = true;
    L52:
        if (r18 == false) goto L54;
    L59:
        ObjectAnimator r19 = ObjectAnimator.ofFloat(r2, "alpha", new float[]{r16, r17});
        if (r22 == false) goto L62;
        PathInterpolator r20 = r14;
    L63:
        r19.setInterpolator(r20);
        if (r22 == false) goto L66;
        long r110 = 300;
    L67:
        r19.setDuration(r110);
        r2.setVisibility(0);
        final Ref.ObjectRef r21 = new Ref.ObjectRef();
        if (r22 == false) goto L75;
        Animator r23 = this.customInAnimator;
        if (r23 == null) goto L75;
        AnimatorSet r24 = this.animSet;
        if (r24 == null) goto L117;
        r24.play(r23);
    L117:
        AnimatorSet r25 = this.animSet;
        if (r25 == null) goto L121;
        r25.addListener(new AnonymousClass2(r22, r2, this, r21));
    L121:
        AnimatorSet r0 = this.animSet;
        if (r0 == null) goto L126;
        r0.start();
        return;
    L126:
        return;
    L75:
        if (r22 == true) goto L82;
        Animator r26 = this.customOutAnimator;
        if (r26 == null) goto L82;
        AnimatorSet r27 = this.animSet;
        if (r27 == null) goto L117;
        r27.play(r26);
    L82:
        AnimatorSet r28 = this.animSet;
        if (r28 == null) goto L87;
        r28.play(r19);
    L87:
        if (r22 == false) goto L89;
        float r29 = 0.5f;
    L90:
        if (r22 == false) goto L92;
        float r111 = 1.0f;
    L94:
        if (getMGravity() == 48) goto L97;
        r4 = 1;
    L97:
        if (r22 == false) goto L99;
        float r30 = -OUnitExtensionKt.vdpFloat(r2, 10);
    L100:
        float r31 = r4;
        final float r112 = r30 * r31;
        if (r22 == false) goto L103;
        float r32 = 0.0f;
    L104:
        final float r113 = r32 * r31;
        if (r22 == false) goto L107;
        final float r33 = 0.0f;
    L108:
        if (r22 == false) goto L110;
        final float r34 = 10000.0f;
    L111:
        ViewGroup r35 = r2;
        if (ViewPropertySpringAnimatorExtKt.spring(r35).isRunning() == true) goto L114;
        r2.setScaleX(r29);
        r2.setScaleY(r29);
        r2.setTranslationY(r112);
        r2.setTag(R.id.o_popover_anim_p, new CommonFloatProperty(r33));
    L114:
        if (r22 == false) goto L116;
        r13 = 0.8f;
    L116:
        ?? r114 = ViewPropertySpringAnimator.animateProperty$default(ViewPropertySpringAnimatorExtKt.spring(r35).defaultDampingRatio(r13).defaultStiffness(439.0f), this.animFloatP, r34, null, 4, null);
        final ViewGroup r36 = r2;
        final float r37 = r29;
        final float r38 = r111;
        r114.setUpdateListener(new OPopover$$ExternalSyntheticLambda2(r36, r33, r34, r37, r38, r112, r113));
        r21.element = r114;
        goto L117
    L110:
        r34 = 0.0f;
        goto L111
    L107:
        r33 = 10000.0f;
        goto L108
    L103:
        r32 = -OUnitExtensionKt.vdpFloat(r2, 10);
        goto L104
    L99:
        r30 = 0.0f;
        goto L100
    L92:
        r111 = 0.5f;
        goto L94
    L89:
        r29 = 1.0f;
        goto L90
    L66:
        r110 = 100;
        goto L67
    L62:
        r20 = r15;
        goto L63
    L54:
        if (r2.getAlpha() != 1.0f) goto L56;
        boolean r115 = true;
    L57:
        if (r115 == true) goto L59;
        r16 = r2.getAlpha();
        goto L59
    L56:
        r115 = false;
        goto L57
    L51:
        r18 = false;
        goto L52
    L47:
        r17 = 0.0f;
        goto L49
    L44:
        r16 = 1.0f;
        goto L45
    L40:
        r12 = r10.getX();
        goto L41
    L34:
        r3 = r11;
        goto L35
    L11:
        if (r6 == 5) goto L26;
        if (r6 != 48) goto L14;
        float r39 = r2.getX();
        OPopoverLayout r40 = this.mOBubbleLayout;
        if (r40 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
    L25:
        r7 = r39 + r3.getBubbleOffset();
        r9 = (r2.getY() + r2.getMeasuredHeight()) - r2.getPaddingBottom();
        goto L37
    L24:
        r3 = r40;
        goto L25
    L14:
        if (r6 == 80) goto L16;
        r9 = 0.0f;
        r7 = 0.0f;
        goto L37
    L16:
        float r41 = r2.getX();
        OPopoverLayout r42 = this.mOBubbleLayout;
        if (r42 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
    L20:
        r7 = r41 + r3.getBubbleOffset();
        r9 = r2.getY() + r2.getPaddingTop();
        goto L37
    L19:
        r3 = r42;
        goto L20
    L26:
        r7 = r2.getX();
        r8 = r2.getY();
        OPopoverLayout r116 = this.mOBubbleLayout;
        if (r116 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
    L30:
        r5 = r3.getBubbleOffset();
        goto L36
    L29:
        r3 = r116;
        goto L30
    }

    /* JADX INFO: renamed from: animatorEasyInOut$lambda-5$lambda-4, reason: not valid java name */
    private static final void m430animatorEasyInOut$lambda5$lambda4(ViewGroup r1, float r2, float r3, float r4, float r5, float r6, float r7, DynamicAnimation r8, float r9, float r10) {
        Intrinsics.checkNotNullParameter(r1, "$view");
        KtExt r11 = KtExt.INSTANCE;
        Object r12 = r1.getTag(R.id.o_popover_anim_p);
        if (r12 != null) goto L6;
    L4:
        r12 = null;
    L8:
        if (((CommonFloatProperty) r12) == null) goto L11;
        float r13 = AnimUtils.getAnimFraction(r9, r2, r3);
        float r14 = r4 + ((r5 - r4) * r13);
        r1.setScaleX(r14);
        r1.setScaleY(r14);
        r1.setTranslationY(r6 + ((r7 - r6) * r13));
        return;
    L11:
        return;
    L6:
        if ((r12 instanceof CommonFloatProperty) == false) goto L4;
        goto L4
    }

    private final void clearFakeAnchorViewIfNecessary() {
        ViewGroup r3 = ViewUtil.INSTANCE.getActivityContentView(this.activity);
        if (r3 == null) goto L15;
        Sequence<View> r0 = ViewGroupKt.getChildren(r3);
        if (r0 == null) goto L17;
        Sequence r1 = SequencesKt.filter(r0, AnonymousClass1.INSTANCE);
        if (r1 == null) goto L18;
        Iterator r2 = r1.iterator();
    L13:
        if (r2.hasNext() == false) goto L19;
        r3.removeView((View) r2.next());
        L.d(TAG, "remove fake anchor view");
        goto L13
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }

    private final Pair<Integer, Integer> addShadowFrameIfNeeded(int r1, int r2) {
        return addShadowFrame(r1, r2);
    }

    private final Pair<Integer, Integer> addShadowFrame(int r18, int r19) {
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
        return new Pair(Integer.valueOf(r18), Integer.valueOf(this.mShadowSpaceTop));
    L12:
        r6 = r2;
    L15:
        View r4 = LayoutInflater.from(this.activity).inflate(R.layout.o_layout_popover_shadow_frame, null);
        if (r4 == null) goto L52;
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
        List<Shadow> r12 = OUILayoutHelper.extractShadowInfo(this.activity, R.style.OUIShadow_3);
        Intrinsics.checkNotNullExpressionValue(r12, MaterialConfigFormatNames.SHADOWS);
        Iterator<T> r13 = r12.iterator();
        int r14 = 0;
        int r15 = 0;
        int r16 = 0;
        int r17 = 0;
    L31:
        if (r13.hasNext() == false) goto L45;
        Shadow r110 = (Shadow) r13.next();
        if ((r110.getRadius() - r110.getOffsetX()) <= r16) goto L36;
        r16 = MathKt.roundToInt(r110.getRadius() - r110.getOffsetX());
    L36:
        if ((r110.getRadius() + r110.getOffsetX()) <= r17) goto L39;
        r17 = MathKt.roundToInt(r110.getRadius() + r110.getOffsetX());
    L39:
        if ((r110.getRadius() - r110.getOffsetY()) <= r14) goto L42;
        r14 = MathKt.roundToInt(r110.getRadius() - r110.getOffsetY());
    L42:
        if ((r110.getRadius() + r110.getOffsetY()) <= r15) goto L31;
        r15 = MathKt.roundToInt(r110.getRadius() + r110.getOffsetY());
        goto L31
    L45:
        SingleChildFrameLayout r20 = new SingleChildFrameLayout(this.activity, null, 2, null);
        Context r111 = getContentView().getContext();
        Intrinsics.checkNotNullExpressionValue(r111, "contentView.context");
        r20.setLayoutParams(new ViewGroup.MarginLayoutParams(OUnitExtensionKt.getScreenWidth(r111), -2));
        r20.addView(r5, new FrameLayout.LayoutParams(-2, -2));
        r20.setClipChildren(false);
        r20.setClipToPadding(false);
        r20.setPadding(0, r14, 0, r15);
        r5.setX(r18);
        r20.setOnTouchListener(new OPopover$$ExternalSyntheticLambda3(this));
        this.mShadowSpaceTop = r14;
        SingleChildFrameLayout r21 = r20;
        this.mWindowFrame = r21;
        r21.setVisibility(4);
        ViewGroup r22 = this.mWindowFrame;
        if (r22 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("mWindowFrame");
    L49:
        setContentView(r6);
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        Context r23 = getContentView().getContext();
        Intrinsics.checkNotNullExpressionValue(r23, "contentView.context");
        setWidth(OUnitExtensionKt.getScreenWidth(r23));
        return new Pair(Integer.valueOf(r18), Integer.valueOf(r14));
    L48:
        r6 = r22;
        goto L49
    L52:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.popover.SingleChildFrameLayout");
    }

    /* JADX INFO: renamed from: addShadowFrame$lambda-10, reason: not valid java name */
    private static final boolean m429addShadowFrame$lambda10(OPopover r2, View r3, MotionEvent r4) {
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
}
