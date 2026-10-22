package com.obric.oui.popover;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.PopupWindow;
import androidx.core.content.ContextCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.bytedanceos.security.invokeHistory.InvokeHistoryActivity;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.material.MaterialConfigFormatNames;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: OMiddleArrowPopover.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b2\u0018\u0000 \u0090\u00012\u00020\u0001:\n\u008f\u0001\u0090\u0001\u0091\u0001\u0092\u0001\u0093\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020\u0011H\u0003J7\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\u00112\u0006\u0010W\u001a\u00020\f2\u0006\u0010X\u001a\u00020\f2\u0006\u0010Y\u001a\u00020\f2\b\b\u0002\u0010Z\u001a\u00020\u0011H\u0000¢\u0006\u0002\b[J\b\u0010\\\u001a\u00020RH\u0016J\u0006\u0010]\u001a\u00020RJ\u0006\u0010^\u001a\u00020\fJ&\u0010_\u001a\u00020R2\u0006\u0010`\u001a\u00020H2\u0006\u0010W\u001a\u00020\f2\u0006\u0010V\u001a\u00020\u00112\u0006\u0010a\u001a\u00020bJ\u0006\u0010c\u001a\u00020\fJ\u0006\u0010d\u001a\u00020\fJ\u0006\u0010e\u001a\u00020\u0018J\u0006\u0010f\u001a\u00020\fJ\u0006\u0010g\u001a\u00020\fJ\u0010\u0010h\u001a\u00020\f2\u0006\u0010W\u001a\u00020\fH\u0004J\u0006\u0010i\u001a\u00020HJ\b\u0010j\u001a\u00020RH\u0002J\u0006\u0010k\u001a\u00020RJ\b\u0010l\u001a\u00020RH\u0002J\b\u0010m\u001a\u00020RH\u0002J\u0006\u0010n\u001a\u00020RJ.\u0010o\u001a\u00020R2\u0006\u0010`\u001a\u00020H2\u0006\u0010W\u001a\u00020\f2\u0006\u0010p\u001a\u00020\f2\u0006\u0010q\u001a\u00020\f2\u0006\u0010r\u001a\u00020\u001aJ\u0010\u0010s\u001a\u00020R2\u0006\u0010t\u001a\u00020\fH\u0007J\u000e\u0010u\u001a\u00020R2\u0006\u0010v\u001a\u00020\u0011J\u0012\u0010w\u001a\u00020R2\b\u0010x\u001a\u0004\u0018\u00010HH\u0002J \u0010y\u001a\u00020R2\u0006\u0010`\u001a\u00020H2\u0006\u0010W\u001a\u00020\f2\u0006\u0010V\u001a\u00020\u0011H\u0002J\u0016\u0010z\u001a\u00020R2\u0006\u0010{\u001a\u00020\u000e2\u0006\u0010|\u001a\u00020\u000eJ\b\u0010}\u001a\u00020RH\u0002J\u000e\u0010~\u001a\u00020R2\u0006\u0010\u007f\u001a\u00020\u0011J\u0017\u0010\u0080\u0001\u001a\u00020R2\u0006\u0010W\u001a\u00020\fH\u0000¢\u0006\u0003\b\u0081\u0001J\u0010\u0010\u0082\u0001\u001a\u00020R2\u0007\u0010\u0083\u0001\u001a\u00020?J\u0010\u0010\u0084\u0001\u001a\u00020R2\u0007\u0010\u0085\u0001\u001a\u00020\fJ\u0010\u0010\u0086\u0001\u001a\u00020R2\u0007\u0010\u0087\u0001\u001a\u00020\fJ!\u0010\u0088\u0001\u001a\u00020R2\b\u0010`\u001a\u0004\u0018\u00010H2\u0006\u0010W\u001a\u00020\f2\u0006\u0010V\u001a\u00020\u0011J<\u0010\u0088\u0001\u001a\u00020R2\b\u0010`\u001a\u0004\u0018\u00010H2\u0006\u0010W\u001a\u00020\f2\u0006\u0010V\u001a\u00020\u00112\u0007\u0010\u0089\u0001\u001a\u00020\u001a2\u0007\u0010\u0085\u0001\u001a\u00020\f2\u0007\u0010\u0087\u0001\u001a\u00020\fJ+\u0010\u0088\u0001\u001a\u00020R2\b\u0010`\u001a\u0004\u0018\u00010H2\u0006\u0010W\u001a\u00020\f2\u0007\u0010\u0089\u0001\u001a\u00020\u001a2\u0007\u0010\u008a\u0001\u001a\u00020\fJ-\u0010\u008b\u0001\u001a\u00020R2\b\u0010`\u001a\u0004\u0018\u00010H2\u0007\u0010\u008c\u0001\u001a\u00020\f2\u0007\u0010\u008d\u0001\u001a\u00020\f2\u0006\u0010W\u001a\u00020\fH\u0016J)\u0010\u008e\u0001\u001a\u00020R2\u0006\u0010`\u001a\u00020H2\u0006\u0010W\u001a\u00020\f2\u0006\u0010p\u001a\u00020\f2\u0006\u0010q\u001a\u00020\fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010)\u001a\u00020\f8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u00010HX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010M\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0004\n\u0002\u0010NR\u0012\u0010O\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0004\n\u0002\u0010NR\u000e\u0010P\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0094\u0001"}, d2 = {"Lcom/obric/oui/popover/OMiddleArrowPopover;", "Landroid/widget/PopupWindow;", "builder", "Lcom/obric/oui/popover/OMiddleArrowPopover$Builder;", "(Lcom/obric/oui/popover/OMiddleArrowPopover$Builder;)V", "activity", "Landroid/app/Activity;", "animSet", "Landroid/animation/AnimatorSet;", "bubbleText", "", "bubbleTextRes", "", "customInAnimator", "Landroid/animation/Animator;", "customOutAnimator", "enableAutoDismiss", "", "hasCome", "isAlreadyDismiss", "isHideVirtualKey", "Ljava/lang/Boolean;", "mAlignArrowPadding", "mAnimTime", "", "mArrowOffset", "", "mAutoDismissDelayMillis", "mBgColor", "mBorderColor", "mBorderWidth", "mBubbleOffset", "mClickListener", "Lcom/obric/oui/popover/OMiddleArrowPopover$OnBubbleClickListener;", "mCornerRadius", "mDismissListener", "Lcom/obric/oui/popover/OMiddleArrowPopover$OnBubbleDismissListener;", "mDismissRunnable", "Ljava/lang/Runnable;", "mFocusable", "mGetLocationInWindow", "mGravity", "getMGravity", "()I", "mHeight", "mLayoutClickable", "mNeedArrow", "mNeedOverShoot", "mNeedShadow", "mOBubbleLayout", "Lcom/obric/oui/popover/OMiddleArrowPopoverLayout;", "mOnClickMaintain", "mOutsideTouchable", "mPadding", "mParentHeight", "mParentWidth", "mShadowColor", "mShadowRadius", "mShowAsDropDown", "mShowElevationShadow", "mShowListener", "Lcom/obric/oui/popover/OMiddleArrowPopover$OnBubbleShowListener;", "mTargetLocation", "Landroid/graphics/Point;", "mTextColor", "mTextSize", "mTextView", "Lcom/obric/oui/popover/PopoverTextView;", "mTypeFace", "Landroid/graphics/Typeface;", "mUseDefaultView", "mView", "Landroid/view/View;", "mWidth", "mXOffset", "mYOffset", "padding", "shadowDx", "Ljava/lang/Float;", "shadowDy", "transparentBg", "animatorEasyInOut", "", "isIn", "calTargetPosition", "", "isMiddle", "gravity", "anchorWidth", "anchorHeight", "ignoreAlign", "calTargetPosition$OUI_standardRelease", "dismiss", "dismissDirectly", "getArrowHeight", "getBubblePosition", "anchor", "position", "Landroid/graphics/Rect;", "getBubbledHeight", "getBubbledWidth", "getInAnimTime", "getMeasuredHeight", "getMeasuredWidth", "getOrientation", "getPopoverView", "hideSystemUi", "hideView", "initContentView", "measure", "onDestroy", "popupAtLocation", MaterialConfigFormatNames.X, MaterialConfigFormatNames.Y, "arrowOffSet", "setAdjustHeight", "adjustHeight", "setAlignArrowPadding", "align", "setBubbleLayout", "view", "setBubblePositionAndShow", "setCustomAnimator", "inAnimator", "outAnimator", "setDefaultView", "setEnableAutoDismiss", "value", "setGravity", "setGravity$OUI_standardRelease", "setTargetLocation", "targetLocation", "setXOffset", "xOffset", "setYOffset", "yOffset", InvokeHistoryActivity.PREF_SHOW, "arrowOffset", "offset", "showAsDropDown", "xoff", "yoff", "showAtLocation", "Builder", "Companion", "OnBubbleClickListener", "OnBubbleDismissListener", "OnBubbleShowListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OMiddleArrowPopover extends PopupWindow {
    public static final Companion Companion = null;
    public static final long OPACITY_LONG = 120;
    public static final long OPACITY_SHORT = 90;
    public static final long SCALE_LONG = 420;
    public static final long SCALE_SHORT = 120;
    private static final float TEXT_SIZE_DP = 0.0f;
    private static volatile int currentShowBubbleNumbers;
    private static boolean shouldForceDismiss;
    private Activity activity;
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
    private boolean mLayoutClickable;
    private boolean mNeedArrow;
    private boolean mNeedOverShoot;
    private boolean mNeedShadow;
    private OMiddleArrowPopoverLayout mOBubbleLayout;
    private boolean mOnClickMaintain;
    private boolean mOutsideTouchable;
    private float mPadding;
    private int mParentHeight;
    private int mParentWidth;
    private int mShadowColor;
    private float mShadowRadius;
    private boolean mShowAsDropDown;
    private boolean mShowElevationShadow;
    private OnBubbleShowListener mShowListener;
    private Point mTargetLocation;
    private int mTextColor;
    private float mTextSize;
    private PopoverTextView mTextView;
    private Typeface mTypeFace;
    private boolean mUseDefaultView;
    private View mView;
    private int mWidth;
    private int mXOffset;
    private int mYOffset;
    private int padding;
    private Float shadowDx;
    private Float shadowDy;
    private boolean transparentBg;

    /* JADX INFO: compiled from: OMiddleArrowPopover.kt */
    @Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b8\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\bB\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010§\u0001\u001a\u00020\u00002\u0007\u0010¨\u0001\u001a\u00020\u000fJ\b\u0010©\u0001\u001a\u00030ª\u0001J\u0010\u0010«\u0001\u001a\u00020\u00002\u0007\u0010¬\u0001\u001a\u00020\u000fJ\u0010\u0010\u00ad\u0001\u001a\u00020\u00002\u0007\u0010®\u0001\u001a\u00020\u0015J\u0010\u0010¯\u0001\u001a\u00020\u00002\u0007\u0010°\u0001\u001a\u00020\tJ\u0010\u0010±\u0001\u001a\u00020\u00002\u0007\u0010®\u0001\u001a\u00020\u0015J\u0012\u0010²\u0001\u001a\u00020\u00002\t\b\u0001\u0010³\u0001\u001a\u00020!J\u0010\u0010´\u0001\u001a\u00020\u00002\u0007\u0010µ\u0001\u001a\u00020!J\u0010\u0010¶\u0001\u001a\u00020\u00002\u0007\u0010·\u0001\u001a\u00020!J\u0010\u0010¸\u0001\u001a\u00020\u00002\u0007\u0010¹\u0001\u001a\u00020-J\u0010\u0010º\u0001\u001a\u00020\u00002\u0007\u0010»\u0001\u001a\u00020!J\u0010\u0010\f\u001a\u00020\u00002\b\b\u0001\u0010\b\u001a\u00020\tJ\u0010\u0010¼\u0001\u001a\u00020\u00002\u0007\u0010½\u0001\u001a\u00020\u000fJ\u0010\u0010¾\u0001\u001a\u00020\u00002\u0007\u0010¿\u0001\u001a\u00020\u000fJ\u0010\u0010À\u0001\u001a\u00020\u00002\u0007\u0010Á\u0001\u001a\u00020!J\u0010\u0010Â\u0001\u001a\u00020\u00002\u0007\u0010Ã\u0001\u001a\u00020!J\u0010\u0010Ä\u0001\u001a\u00020\u00002\u0007\u0010Å\u0001\u001a\u00020\u000fJ\u0010\u0010Æ\u0001\u001a\u00020\u00002\u0007\u0010Ç\u0001\u001a\u00020\u000fJ\u0010\u0010È\u0001\u001a\u00020\u00002\u0007\u0010É\u0001\u001a\u00020\u000fJ\u0010\u0010Ê\u0001\u001a\u00020\u00002\u0007\u0010É\u0001\u001a\u00020\u000fJ\u0012\u0010Ë\u0001\u001a\u00020\u00002\u0007\u0010É\u0001\u001a\u00020\u000fH\u0007J\u0010\u0010Ì\u0001\u001a\u00020\u00002\u0007\u0010É\u0001\u001a\u00020\u000fJ\u0010\u0010Í\u0001\u001a\u00020\u00002\u0007\u0010Î\u0001\u001a\u000206J\u0010\u0010Ï\u0001\u001a\u00020\u00002\u0007\u0010Î\u0001\u001a\u00020<J\u0010\u0010Ð\u0001\u001a\u00020\u00002\u0007\u0010Î\u0001\u001a\u00020uJ\u0010\u0010Ñ\u0001\u001a\u00020\u00002\u0007\u0010Ò\u0001\u001a\u00020\u000fJ\u0010\u0010Ó\u0001\u001a\u00020\u00002\u0007\u0010Ô\u0001\u001a\u00020\tJ\u0010\u0010Õ\u0001\u001a\u00020\u00002\u0007\u0010³\u0001\u001a\u00020!J\u0010\u0010Ö\u0001\u001a\u00020\u00002\u0007\u0010×\u0001\u001a\u00020\u000fJ\u0010\u0010Ø\u0001\u001a\u00020\u00002\u0007\u0010³\u0001\u001a\u00020!J\u0010\u0010Ù\u0001\u001a\u00020\u00002\u0007\u0010Ú\u0001\u001a\u00020\tJ\u0011\u0010Û\u0001\u001a\u00020\u00002\b\u0010Ü\u0001\u001a\u00030\u0081\u0001J\u0010\u0010Ý\u0001\u001a\u00020\u00002\u0007\u0010Þ\u0001\u001a\u00020\u000fJ\u0011\u0010ß\u0001\u001a\u00020\u00002\b\u0010à\u0001\u001a\u00030\u008a\u0001J\u0010\u0010á\u0001\u001a\u00020\u00002\u0007\u0010â\u0001\u001a\u00020!J\u0010\u0010ã\u0001\u001a\u00020\u00002\u0007\u0010°\u0001\u001a\u00020!J\u0010\u0010ä\u0001\u001a\u00020\u00002\u0007\u0010°\u0001\u001a\u00020!J\u0019\u0010å\u0001\u001a\u00020\u00002\u0007\u0010æ\u0001\u001a\u00020\t2\u0007\u0010ç\u0001\u001a\u00020\tJ\u0010\u0010è\u0001\u001a\u00020\u00002\u0007\u0010é\u0001\u001a\u00020\tJ\u0010\u0010ê\u0001\u001a\u00020\u00002\u0007\u0010ê\u0001\u001a\u00020\u000fJ\u0010\u0010¡\u0001\u001a\u00020\u00002\u0007\u0010ë\u0001\u001a\u00020\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b\u001c\u0010\rR\u001a\u0010\u001d\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\u001a\u0010)\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010#\"\u0004\b+\u0010%R\u001a\u0010,\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010#\"\u0004\b4\u0010%R\u001c\u00105\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010;\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010A\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0011\"\u0004\bC\u0010\u0013R\u001a\u0010D\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0011\"\u0004\bF\u0010\u0013R\u001a\u0010G\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010#\"\u0004\bI\u0010%R\u001a\u0010J\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010#\"\u0004\bL\u0010%R\u001a\u0010M\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0011\"\u0004\bO\u0010\u0013R\u001a\u0010P\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0011\"\u0004\bR\u0010\u0013R\u001a\u0010S\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u0011\"\u0004\bU\u0010\u0013R\u001a\u0010V\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u0011\"\u0004\bX\u0010\u0013R\u001a\u0010Y\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u0011\"\u0004\b[\u0010\u0013R\u001a\u0010\\\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\u0011\"\u0004\b^\u0010\u0013R\u001a\u0010_\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u0011\"\u0004\ba\u0010\u0013R\u001a\u0010b\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010\u0011\"\u0004\bd\u0010\u0013R\u001a\u0010e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010\u000b\"\u0004\bg\u0010\rR\u001a\u0010h\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010#\"\u0004\bj\u0010%R\u001a\u0010k\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010\u000b\"\u0004\bm\u0010\rR\u001a\u0010n\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010\u0011\"\u0004\bp\u0010\u0013R\u001a\u0010q\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010\u0011\"\u0004\bs\u0010\u0013R\u001c\u0010t\u001a\u0004\u0018\u00010uX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u001a\u0010z\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010#\"\u0004\b|\u0010%R\u001a\u0010}\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010\u000b\"\u0004\b\u007f\u0010\rR\"\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001d\u0010\u0086\u0001\u001a\u00020\u000fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0001\u0010\u0011\"\u0005\b\u0088\u0001\u0010\u0013R\"\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u008a\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R\u001d\u0010\u008f\u0001\u001a\u00020!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010#\"\u0005\b\u0091\u0001\u0010%R\u001d\u0010\u0092\u0001\u001a\u00020!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0001\u0010#\"\u0005\b\u0094\u0001\u0010%R\u001d\u0010\u0095\u0001\u001a\u00020!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0096\u0001\u0010#\"\u0005\b\u0097\u0001\u0010%R$\u0010\u0098\u0001\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u009d\u0001\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001\"\u0006\b\u009b\u0001\u0010\u009c\u0001R$\u0010\u009e\u0001\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u009d\u0001\u001a\u0006\b\u009f\u0001\u0010\u009a\u0001\"\u0006\b \u0001\u0010\u009c\u0001R\u001d\u0010¡\u0001\u001a\u00020\u000fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¢\u0001\u0010\u0011\"\u0005\b£\u0001\u0010\u0013R\u001d\u0010¤\u0001\u001a\u00020\u000fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¥\u0001\u0010\u0011\"\u0005\b¦\u0001\u0010\u0013¨\u0006ì\u0001"}, d2 = {"Lcom/obric/oui/popover/OMiddleArrowPopover$Builder;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "cornerRadius", "", "getCornerRadius", "()F", "setCornerRadius", "(F)V", "mAlignArrowPadding", "", "getMAlignArrowPadding", "()Z", "setMAlignArrowPadding", "(Z)V", "mAnimTime", "", "getMAnimTime", "()J", "setMAnimTime", "(J)V", "mArrowOffset", "getMArrowOffset", "setMArrowOffset", "mAutoDismissDelayMillis", "getMAutoDismissDelayMillis", "setMAutoDismissDelayMillis", "mBgColor", "", "getMBgColor", "()I", "setMBgColor", "(I)V", "mBorderColor", "getMBorderColor", "setMBorderColor", "mBorderWidth", "getMBorderWidth", "setMBorderWidth", "mBubbleText", "", "getMBubbleText", "()Ljava/lang/String;", "setMBubbleText", "(Ljava/lang/String;)V", "mBubbleTextRes", "getMBubbleTextRes", "setMBubbleTextRes", "mClickListener", "Lcom/obric/oui/popover/OMiddleArrowPopover$OnBubbleClickListener;", "getMClickListener", "()Lcom/obric/oui/popover/OMiddleArrowPopover$OnBubbleClickListener;", "setMClickListener", "(Lcom/obric/oui/popover/OMiddleArrowPopover$OnBubbleClickListener;)V", "mDismissListener", "Lcom/obric/oui/popover/OMiddleArrowPopover$OnBubbleDismissListener;", "getMDismissListener", "()Lcom/obric/oui/popover/OMiddleArrowPopover$OnBubbleDismissListener;", "setMDismissListener", "(Lcom/obric/oui/popover/OMiddleArrowPopover$OnBubbleDismissListener;)V", "mFocusable", "getMFocusable", "setMFocusable", "mGetLocationInWindow", "getMGetLocationInWindow", "setMGetLocationInWindow", "mGravity", "getMGravity", "setMGravity", "mHeight", "getMHeight", "setMHeight", "mHideVirtualKey", "getMHideVirtualKey", "setMHideVirtualKey", "mLayoutClickable", "getMLayoutClickable", "setMLayoutClickable", "mNeedAddColor", "getMNeedAddColor", "setMNeedAddColor", "mNeedArrow", "getMNeedArrow", "setMNeedArrow", "mNeedOverShoot", "getMNeedOverShoot", "setMNeedOverShoot", "mNeedShadow", "getMNeedShadow", "setMNeedShadow", "mOnClickMaintain", "getMOnClickMaintain", "setMOnClickMaintain", "mOutsideTouchable", "getMOutsideTouchable", "setMOutsideTouchable", "mPaddingDp", "getMPaddingDp", "setMPaddingDp", "mShadowColor", "getMShadowColor", "setMShadowColor", "mShadowRadius", "getMShadowRadius", "setMShadowRadius", "mShowAsDropDown", "getMShowAsDropDown", "setMShowAsDropDown", "mShowElevationShadow", "getMShowElevationShadow", "setMShowElevationShadow", "mShowListener", "Lcom/obric/oui/popover/OMiddleArrowPopover$OnBubbleShowListener;", "getMShowListener", "()Lcom/obric/oui/popover/OMiddleArrowPopover$OnBubbleShowListener;", "setMShowListener", "(Lcom/obric/oui/popover/OMiddleArrowPopover$OnBubbleShowListener;)V", "mTextColor", "getMTextColor", "setMTextColor", "mTextSize", "getMTextSize", "setMTextSize", "mTypeFace", "Landroid/graphics/Typeface;", "getMTypeFace", "()Landroid/graphics/Typeface;", "setMTypeFace", "(Landroid/graphics/Typeface;)V", "mUseDefaultView", "getMUseDefaultView", "setMUseDefaultView", "mView", "Landroid/view/View;", "getMView", "()Landroid/view/View;", "setMView", "(Landroid/view/View;)V", "mWidth", "getMWidth", "setMWidth", "mXOffset", "getMXOffset", "setMXOffset", "mYOffset", "getMYOffset", "setMYOffset", "shadowDx", "getShadowDx", "()Ljava/lang/Float;", "setShadowDx", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "shadowDy", "getShadowDy", "setShadowDy", "transparentBg", "getTransparentBg", "setTransparentBg", "useAlphaAnim", "getUseAlphaAnim", "setUseAlphaAnim", "alignArrowPadding", "align", "build", "Lcom/obric/oui/popover/OMiddleArrowPopover;", "onClickMaintain", "maintain", "setAnimTime", DBHelper.COL_TIME, "setArrowOffset", "offset", "setAutoDismissDelayMillis", "setBgColor", "color", "setBorderColor", "borderColor", "setBorderWidth", "borderWidth", "setBubbleText", "str", "setBubbleTextRes", "resId", "setFocusable", "focusable", "setGetLocationInWindow", "getLocationInWindow", "setGravity", "gravity", "setHeight", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "setHideVirtualKey", "hide", "setLayoutClickable", "clickable", "setNeedArrow", "need", "setNeedOverShoot", "setNeedPath", "setNeedShadow", "setOnClickListener", "listener", "setOnDismissListener", "setOnShowListener", "setOutSideTouchable", "touchable", "setPadding", "paddingDp", "setShadowColor", "setShowElevationShadow", InvokeHistoryActivity.PREF_SHOW, "setTextColor", "setTextSize", "textSize", "setTypeface", "tf", "setUseDefaultView", "useDefault", "setView", "view", "setWidth", MaterialConfigFormatNames.WIDTH, "setXOffset", "setYOffset", "shadowOffset", "dx", "dy", "shadowRadius", "radius", "showAsDropDown", "transparent", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
        private float mPaddingDp;
        private int mShadowColor;
        private float mShadowRadius;
        private boolean mShowAsDropDown;
        private boolean mShowElevationShadow;
        private OnBubbleShowListener mShowListener;
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

        @Deprecated(message = "No op", replaceWith = @ReplaceWith(expression = "Not supported anymore", imports = {}))
        public final Builder setNeedPath(boolean r1) {
            return this;
        }

        public Builder(Activity r3) {
            Intrinsics.checkNotNullParameter(r3, "activity");
            this.activity = r3;
            this.mAnimTime = 800;
            this.mAutoDismissDelayMillis = 5000;
            this.mUseDefaultView = true;
            this.mBubbleText = "";
            this.mTextSize = OMiddleArrowPopover.access$getTEXT_SIZE_DP$cp();
            this.mTypeFace = Typeface.defaultFromStyle(1);
            this.mNeedArrow = true;
            this.mPaddingDp = 12.0f;
            this.mOutsideTouchable = true;
            this.mShadowColor = -16777216;
            this.mShadowRadius = 2.0f;
            this.mNeedAddColor = true;
            this.cornerRadius = OMiddleArrowPopoverLayout.Companion.getCornerRadiusDp();
            this.mLayoutClickable = true;
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

        public final float getMPaddingDp() {
            return this.mPaddingDp;
        }

        public final void setMPaddingDp(float r1) {
            this.mPaddingDp = r1;
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
        public final void m425setCornerRadius(float r1) {
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
            this.mPaddingDp = r1;
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

        public final Builder setWidth(int r3) {
            this.mWidth = r3 + OUnitExtensionKt.cdp(this.activity, 14);
            return this;
        }

        public final Builder setHeight(int r3) {
            this.mHeight = r3 + OUnitExtensionKt.cdp(this.activity, 14);
            return this;
        }

        public final Builder setGravity(int r2) {
            this.mGravity = OMiddleArrowPopover.Companion.adaptGravity$OUI_standardRelease(r2);
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

        public final OMiddleArrowPopover build() {
            return new OMiddleArrowPopover(this);
        }
    }

    /* JADX INFO: compiled from: OMiddleArrowPopover.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\u0010J\b\u0010\u0011\u001a\u00020\u000bH\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/oui/popover/OMiddleArrowPopover$Companion;", "", "()V", "OPACITY_LONG", "", "OPACITY_SHORT", "SCALE_LONG", "SCALE_SHORT", "TEXT_SIZE_DP", "", "currentShowBubbleNumbers", "", "shouldForceDismiss", "", "adaptGravity", "originGravity", "adaptGravity$OUI_standardRelease", "getCurrentShowBubbleNumbers", "setShouldForceDismiss", "", "forceDismiss", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
            return OMiddleArrowPopover.access$getCurrentShowBubbleNumbers$cp();
        }

        public static /* synthetic */ void setShouldForceDismiss$default(Companion r0, boolean r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = true;
        L5:
            r0.setShouldForceDismiss(r1);
        }

        public final void setShouldForceDismiss(boolean r1) {
            OMiddleArrowPopover.access$setShouldForceDismiss$cp(r1);
        }
    }

    /* JADX INFO: compiled from: OMiddleArrowPopover.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/popover/OMiddleArrowPopover$OnBubbleClickListener;", "", "clickBubble", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnBubbleClickListener {
        void clickBubble();
    }

    /* JADX INFO: compiled from: OMiddleArrowPopover.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/popover/OMiddleArrowPopover$OnBubbleDismissListener;", "", "bubbleDismiss", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnBubbleDismissListener {
        void bubbleDismiss();
    }

    /* JADX INFO: compiled from: OMiddleArrowPopover.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/popover/OMiddleArrowPopover$OnBubbleShowListener;", "", "bubbleShow", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnBubbleShowListener {
        void bubbleShow();
    }

    /* JADX INFO: renamed from: $r8$lambda$MiXmpuQlnr9ms1NHo3bD-RzDaTU, reason: not valid java name */
    public static /* synthetic */ void m422$r8$lambda$MiXmpuQlnr9ms1NHo3bDRzDaTU(OMiddleArrowPopover r0, View r1) {
        m424setBubbleLayout$lambda0(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$gE1ZG_VQZiibnYtOBgxt6pObcoM(OMiddleArrowPopover r0) {
        m423mDismissRunnable$lambda1(r0);
    }

    @JvmStatic
    public static final int getCurrentShowBubbleNumbers() {
        return Companion.getCurrentShowBubbleNumbers();
    }

    public OMiddleArrowPopover(Builder r4) {
        Intrinsics.checkNotNullParameter(r4, "builder");
        this.mShadowColor = -16777216;
        this.mAnimTime = 200;
        this.mAutoDismissDelayMillis = 5000;
        this.mUseDefaultView = true;
        this.bubbleText = "";
        this.mTextSize = TEXT_SIZE_DP;
        this.mTypeFace = Typeface.defaultFromStyle(1);
        this.mNeedArrow = true;
        this.mOutsideTouchable = true;
        this.enableAutoDismiss = true;
        this.mShadowRadius = 2.0f;
        this.mCornerRadius = OMiddleArrowPopoverLayout.Companion.getCornerRadiusDp();
        this.mLayoutClickable = true;
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
        this.mPadding = OUnitExtensionKt.cdpFloat(this.activity, r4.getMPaddingDp());
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
        setWidth(-2);
        setHeight(-2);
        setFocusable(this.mFocusable);
        setOutsideTouchable(this.mOutsideTouchable);
        setClippingEnabled(false);
        setInputMethodMode(1);
        setSoftInputMode(16);
        if (this.mUseDefaultView == true) goto L10;
        View r0 = this.mView;
        if (r0 == null) goto L10;
        setBubbleLayout(r0);
        OMiddleArrowPopoverLayout r1 = this.mOBubbleLayout;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r1 = null;
    L9:
        r1.setUseDefaultView(false);
    L11:
        initContentView();
        this.mDismissRunnable = new OMiddleArrowPopover$$ExternalSyntheticLambda0(this);
        return;
    L10:
        setDefaultView();
        goto L11
    }

    public static final /* synthetic */ int access$getCurrentShowBubbleNumbers$cp() {
        return currentShowBubbleNumbers;
    }

    public static final /* synthetic */ OnBubbleDismissListener access$getMDismissListener$p(OMiddleArrowPopover r0) {
        return r0.mDismissListener;
    }

    public static final /* synthetic */ OnBubbleShowListener access$getMShowListener$p(OMiddleArrowPopover r0) {
        return r0.mShowListener;
    }

    public static final /* synthetic */ float access$getTEXT_SIZE_DP$cp() {
        return TEXT_SIZE_DP;
    }

    public static final /* synthetic */ void access$setShouldForceDismiss$cp(boolean r0) {
        shouldForceDismiss = r0;
    }

    private final int getMGravity() {
        return Companion.adaptGravity$OUI_standardRelease(this.mGravity);
    }

    private final void initContentView() {
        int r0 = this.mWidth;
        if (r0 != 0) goto L5;
    L7:
        boolean r1 = true;
        if (Intrinsics.areEqual(this.isHideVirtualKey, true) == false) goto L10;
        hideSystemUi();
    L10:
        OMiddleArrowPopoverLayout r2 = null;
        if (this.mBgColor == 0) goto L16;
        OMiddleArrowPopoverLayout r3 = this.mOBubbleLayout;
        if (r3 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r3 = null;
    L15:
        r3.setMBgColor(this.mBgColor);
    L16:
        OMiddleArrowPopoverLayout r4 = this.mOBubbleLayout;
        if (r4 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r4 = null;
    L19:
        r4.setBubbleOrientation(getOrientation(getMGravity()));
        if (this.mPadding == 0.0f) goto L23;
        r1 = false;
    L23:
        if (r1 == true) goto L28;
        OMiddleArrowPopoverLayout r5 = this.mOBubbleLayout;
        if (r5 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r5 = null;
    L27:
        r5.setPadding(this.mPadding);
    L28:
        OMiddleArrowPopoverLayout r6 = this.mOBubbleLayout;
        if (r6 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r6 = null;
    L31:
        r6.getShadowConfig().setColor(this.mShadowColor);
        OMiddleArrowPopoverLayout r7 = this.mOBubbleLayout;
        if (r7 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r7 = null;
    L34:
        r7.getShadowConfig().setRadius(this.mShadowRadius);
        OMiddleArrowPopoverLayout r8 = this.mOBubbleLayout;
        if (r8 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r8 = null;
    L37:
        r8.setBorderColor(this.mBorderColor);
        OMiddleArrowPopoverLayout r9 = this.mOBubbleLayout;
        if (r9 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r9 = null;
    L40:
        r9.setBorderWidth(this.mBorderWidth);
        OMiddleArrowPopoverLayout r10 = this.mOBubbleLayout;
        if (r10 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
    L44:
        r2.setTransparentBg(this.transparentBg);
        return;
    L43:
        r2 = r10;
        goto L44
    L5:
        if (this.mHeight == 0) goto L7;
        setWidth(r0);
        setHeight(this.mHeight);
        OMiddleArrowPopoverLayout.Companion.setDefaultWidthDp(getWidth());
        OMiddleArrowPopoverLayout.Companion.setDefaultHeightDp(getHeight());
        goto L7
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
        r2.setTextSize(1, TEXT_SIZE_DP);
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
        r6.setGravity(17);
        PopoverTextView r7 = this.mTextView;
        if (r7 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r7 = null;
    L27:
        r7.setMaxWidth(OUnitExtensionKt.cdp(this.activity, 276));
        PopoverTextView r8 = this.mTextView;
        if (r8 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r8 = null;
    L30:
        r8.setMaxLines(1);
        PopoverTextView r9 = this.mTextView;
        if (r9 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r9 = null;
    L33:
        r9.setEllipsize(TextUtils.TruncateAt.END);
        PopoverTextView r10 = this.mTextView;
        if (r10 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r10 = null;
    L36:
        setBubbleLayout(r10);
        if (this.isHideVirtualKey != null) goto L40;
        this.isHideVirtualKey = true;
    L40:
        if (TextUtils.isEmpty(this.bubbleText) == true) goto L46;
        PopoverTextView r11 = this.mTextView;
        if (r11 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r11 = null;
    L44:
        r11.setText(this.bubbleText);
    L46:
        if (this.bubbleTextRes == 0) goto L52;
        PopoverTextView r12 = this.mTextView;
        if (r12 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r12 = null;
    L50:
        r12.setText(this.bubbleTextRes);
    L52:
        if (this.mTextSize != 0.0f) goto L54;
        boolean r13 = true;
    L55:
        if (r13 == true) goto L61;
        PopoverTextView r14 = this.mTextView;
        if (r14 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L60:
        r3.setTextSize(1, this.mTextSize);
        goto L61
    L59:
        r3 = r14;
    L61:
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        return;
    L54:
        r13 = false;
        goto L55
    L5:
        r0.setTextColor(ContextCompat.getColor(this.activity, R.color.ConstTextInverse));
        goto L7
    }

    private final void setBubbleLayout(View r7) {
        OMiddleArrowPopoverLayout r0 = new OMiddleArrowPopoverLayout(this.activity);
        this.mOBubbleLayout = r0;
        r0.setBackgroundColor(0);
        OMiddleArrowPopoverLayout r1 = this.mOBubbleLayout;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r1 = null;
    L5:
        r1.setCornerRadius(this.mCornerRadius);
        OMiddleArrowPopoverLayout r2 = this.mOBubbleLayout;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r2 = null;
    L8:
        r2.addView(r7);
        OMiddleArrowPopoverLayout r8 = this.mOBubbleLayout;
        if (r8 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r8 = null;
    L11:
        r8.setGravity(17);
        ViewGroup.MarginLayoutParams r9 = new ViewGroup.MarginLayoutParams(-2, -2);
        OMiddleArrowPopoverLayout r3 = this.mOBubbleLayout;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r3 = null;
    L14:
        r3.setLayoutParams(r9);
        OMiddleArrowPopoverLayout r10 = this.mOBubbleLayout;
        if (r10 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r10 = null;
    L17:
        r10.setVisibility(8);
        if (this.mBgColor == 0) goto L23;
        OMiddleArrowPopoverLayout r11 = this.mOBubbleLayout;
        if (r11 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r11 = null;
    L22:
        r11.setMBgColor(this.mBgColor);
    L23:
        OMiddleArrowPopoverLayout r12 = this.mOBubbleLayout;
        if (r12 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r12 = null;
    L26:
        r12.setMNeedArrow(this.mNeedArrow);
        OMiddleArrowPopoverLayout r13 = this.mOBubbleLayout;
        if (r13 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r13 = null;
    L29:
        r13.setMNeedShadow(this.mNeedShadow);
        OMiddleArrowPopoverLayout r14 = this.mOBubbleLayout;
        if (r14 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r14 = null;
    L32:
        r14.getShadowConfig().setColor(this.mShadowColor);
        if (this.shadowDx == null) goto L39;
        OMiddleArrowPopoverLayout r15 = this.mOBubbleLayout;
        if (r15 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r15 = null;
    L37:
        OMiddleArrowPopoverLayout.ShadowConfig r16 = r15.getShadowConfig();
        Float r4 = this.shadowDx;
        Intrinsics.checkNotNull(r4);
        r16.setDx(r4.floatValue());
    L39:
        if (this.shadowDy == null) goto L45;
        OMiddleArrowPopoverLayout r17 = this.mOBubbleLayout;
        if (r17 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r17 = null;
    L43:
        OMiddleArrowPopoverLayout.ShadowConfig r18 = r17.getShadowConfig();
        Float r5 = this.shadowDy;
        Intrinsics.checkNotNull(r5);
        r18.setDy(r5.floatValue());
    L45:
        if (this.mLayoutClickable == false) goto L53;
        OMiddleArrowPopoverLayout r19 = this.mOBubbleLayout;
        if (r19 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r19 = null;
    L49:
        r19.setClickable(true);
        OMiddleArrowPopoverLayout r20 = this.mOBubbleLayout;
        if (r20 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r20 = null;
    L52:
        r20.setOnClickListener(new OMiddleArrowPopover$$ExternalSyntheticLambda1(this));
    L57:
        OMiddleArrowPopoverLayout r21 = this.mOBubbleLayout;
        if (r21 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r21 = null;
    L60:
        setContentView(r21);
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        if (this.mShowElevationShadow == false) goto L73;
        OMiddleArrowPopoverLayout r22 = this.mOBubbleLayout;
        if (r22 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r22 = null;
    L65:
        OMiddleArrowPopoverLayout r6 = this.mOBubbleLayout;
        if (r6 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r6 = null;
    L68:
        float r23 = r6.getMWidth();
        OMiddleArrowPopoverLayout r24 = this.mOBubbleLayout;
        if (r24 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r24 = null;
    L71:
        r22.calculateBubbleArrowMatrix(r23, r24.getMHeight());
        setElevation(50.0f);
        this.mNeedShadow = false;
        this.mShadowRadius = 0.0f;
        getContentView().setOutlineProvider(null);
        getContentView().setOutlineSpotShadowColor(Color.parseColor("#8C000000"));
        getContentView().setClipToOutline(true);
        return;
    L73:
        return;
    L53:
        OMiddleArrowPopoverLayout r25 = this.mOBubbleLayout;
        if (r25 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r25 = null;
    L56:
        r25.setClickable(false);
        goto L57
    }

    /* JADX INFO: renamed from: setBubbleLayout$lambda-0, reason: not valid java name */
    private static final void m424setBubbleLayout$lambda0(OMiddleArrowPopover r0, View r1) {
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
        OMiddleArrowPopoverLayout r0 = this.mOBubbleLayout;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r0 = null;
    L5:
        r0.setBubbleOrientation(getOrientation(Companion.adaptGravity$OUI_standardRelease(r3)));
    }

    public final void show(View r2, int r3, float r4, int r5) {
        int r6 = Companion.adaptGravity$OUI_standardRelease(r3);
        if (r6 != 48) goto L5;
    L7:
        this.mXOffset = r5;
    L8:
        this.mArrowOffset = r4;
        show(r2, r6, false);
        return;
    L5:
        if (r6 == 80) goto L7;
        goto L7
    }

    public final void show(View r2, int r3, boolean r4, float r5, int r6, int r7) {
        int r8 = Companion.adaptGravity$OUI_standardRelease(r3);
        this.mXOffset = r6;
        this.mYOffset = r7;
        this.mArrowOffset = r5;
        show(r2, r8, r4);
    }

    public final void show(View r7, int r8, boolean r9) {
        int r10 = Companion.adaptGravity$OUI_standardRelease(r8);
        if (this.activity.isFinishing() == true) goto L35;
        if (r7 != null) goto L6;
        return;
    L6:
        if (r7.getWindowToken() == null) goto L38;
        this.mParentHeight = r7.getMeasuredHeight();
        this.mParentWidth = r7.getMeasuredWidth();
        getContentView().removeCallbacks(this.mDismissRunnable);
        this.mGravity = r10;
        OMiddleArrowPopoverLayout r0 = this.mOBubbleLayout;
        OMiddleArrowPopoverLayout r1 = null;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r0 = null;
    L11:
        this.padding = r0.m426getPadding();
        if (isShowing() == true) goto L33;
        int r2 = getOrientation(r10);
        measure();
        if (r9 == false) goto L23;
        if (r10 != 48) goto L18;
    L20:
        int r4 = getMeasuredWidth();
    L21:
        this.mBubbleOffset = r4 / 2.0f;
    L25:
        OMiddleArrowPopoverLayout r5 = this.mOBubbleLayout;
        if (r5 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
    L29:
        r1.setBubbleParams(r2, this.mBubbleOffset + this.mArrowOffset);
        setBubblePositionAndShow(r7, r10, r9);
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
        if (r10 == 80) goto L20;
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
        OMiddleArrowPopoverLayout r0 = this.mOBubbleLayout;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r0 = null;
    L5:
        r0.setMAdjustHeight(r1);
    }

    public final void getBubblePosition(View r10, int r11, boolean r12, Rect r13) {
        Intrinsics.checkNotNullParameter(r10, "anchor");
        Intrinsics.checkNotNullParameter(r13, "position");
        int r14 = Companion.adaptGravity$OUI_standardRelease(r11);
        int[] r1 = new int[2];
        Point r2 = this.mTargetLocation;
        if (r2 == null) goto L5;
        Intrinsics.checkNotNull(r2);
        r1[0] = r2.x;
        r1[1] = r2.y;
    L10:
        if (r14 != 3) goto L12;
        if (r12 == false) goto L32;
        int r15 = (r10.getMeasuredHeight() - getMeasuredHeight()) / 2;
    L33:
        r13.left = (r1[0] + this.mXOffset) - getMeasuredWidth();
        r13.right = r1[0] + this.mXOffset;
        r13.top = ((r1[1] + this.mYOffset) + r15) + OUnitExtensionKt.vdp(r10, 1.3d);
        r13.bottom = (((r1[1] + this.mYOffset) + r10.getHeight()) - r15) - OUnitExtensionKt.vdp(r10, 1.3d);
        return;
    L32:
        r15 = 0;
        goto L33
    L12:
        if (r14 != 5) goto L14;
        if (r12 == false) goto L28;
        int r16 = (r10.getMeasuredHeight() - getMeasuredHeight()) / 2;
    L29:
        r13.left = (r1[0] + this.mXOffset) + r10.getWidth();
        r13.right = ((r1[0] + this.mXOffset) + r10.getWidth()) + getMeasuredWidth();
        r13.top = ((r1[1] + this.mYOffset) + r16) + OUnitExtensionKt.vdp(r10, 1.3d);
        r13.bottom = (((r1[1] + this.mYOffset) + r10.getHeight()) - r16) - OUnitExtensionKt.vdp(r10, 1.3d);
        return;
    L28:
        r16 = 0;
        goto L29
    L14:
        if (r14 != 48) goto L16;
        if (r12 == false) goto L24;
        int r17 = (r10.getMeasuredWidth() - getMeasuredWidth()) / 2;
    L25:
        r13.left = ((r1[0] + this.mXOffset) + r17) + OUnitExtensionKt.vdp(r10, 1.4d);
        r13.right = (((r1[0] + this.mXOffset) + r10.getWidth()) - r17) - OUnitExtensionKt.vdp(r10, 1.4d);
        r13.top = ((r1[1] + this.mYOffset) - OUnitExtensionKt.vdp(r10, 1.3d)) - getMeasuredHeight();
        r13.bottom = (r1[1] + this.mYOffset) - OUnitExtensionKt.vdp(r10, 1.3d);
        return;
    L24:
        r17 = 0;
        goto L25
    L16:
        if (r14 != 80) goto L38;
        if (r12 == false) goto L20;
        int r18 = (r10.getMeasuredWidth() - getMeasuredWidth()) / 2;
    L21:
        r13.left = ((r1[0] + this.mXOffset) + r18) + OUnitExtensionKt.vdp(r10, 1.4d);
        r13.right = (((r1[0] + this.mXOffset) + r10.getWidth()) - r18) - OUnitExtensionKt.vdp(r10, 1.4d);
        r13.top = ((r1[1] + this.mYOffset) + r10.getHeight()) + OUnitExtensionKt.vdp(r10, 1.3d);
        r13.bottom = (((r1[1] + this.mYOffset) + r10.getHeight()) + getMeasuredHeight()) + OUnitExtensionKt.vdp(r10, 1.3d);
        return;
    L20:
        r18 = 0;
        goto L21
    L38:
        return;
    L5:
        String r3 = r10.getContext().getResources().getConfiguration().toString();
        Intrinsics.checkNotNullExpressionValue(r3, "anchor.context.resources.configuration.toString()");
        if (StringsKt.contains$default(r3, "hw-magic-windows", false, 2, null) == false) goto L8;
        r10.getLocationInWindow(r1);
        goto L10
    L8:
        r10.getLocationOnScreen(r1);
        goto L10
    }

    private final void setBubblePositionAndShow(View r12, int r13, boolean r14) {
        int r3 = Companion.adaptGravity$OUI_standardRelease(r13);
        int[] r15 = new int[2];
        Point r0 = this.mTargetLocation;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        r15[0] = r0.x;
        r15[1] = r0.y;
    L9:
        int[] r16 = calTargetPosition$OUI_standardRelease$default(this, r14, r3, r12.getMeasuredWidth(), r12.getMeasuredHeight(), false, 16, null);
        if (this.mShowAsDropDown == false) goto L12;
        showAsDropDown(r12, r16[0], r16[1] - r12.getMeasuredHeight(), 0);
        return;
    L12:
        showAtLocation(r12, 0, r15[0] + r16[0], r15[1] + r16[1]);
        return;
    L6:
        if (this.mGetLocationInWindow == false) goto L8;
        r12.getLocationInWindow(r15);
        goto L9
    L8:
        r12.getLocationOnScreen(r15);
        goto L9
    }

    public static /* synthetic */ int[] calTargetPosition$OUI_standardRelease$default(OMiddleArrowPopover r6, boolean r7, int r8, int r9, int r10, boolean r11, int r12, Object r13) {
        if ((r12 & 16) == 0) goto L6;
        r11 = false;
    L6:
        return r6.calTargetPosition$OUI_standardRelease(r7, r8, r9, r10, r11);
    }

    public final int[] calTargetPosition$OUI_standardRelease(boolean r8, int r9, int r10, int r11, boolean r12) {
        int[] r1 = new int[2];
        if (this.mAlignArrowPadding == false) goto L14;
        if (r8 == true) goto L14;
        if (r12 == true) goto L14;
        int r13 = getMGravity();
        if (r13 == 3) goto L13;
        if (r13 == 5) goto L13;
        if (r13 == 48) goto L12;
        if (r13 != 80) goto L14;
    L12:
        this.mXOffset -= getArrowHeight();
    L13:
        this.mYOffset -= getArrowHeight();
    L14:
        int r14 = Companion.adaptGravity$OUI_standardRelease(r9);
        if (r14 == 3) goto L32;
        if (r14 == 5) goto L28;
        if (r14 == 48) goto L24;
        if (r14 != 80) goto L36;
        if (r8 == false) goto L22;
        int r15 = (r10 - getMeasuredWidth()) / 2;
    L23:
        r1[0] = this.mXOffset + r15;
        r1[1] = this.mYOffset + r11;
        goto L36
    L22:
        r15 = 0;
    L36:
        return r1;
    L24:
        if (r8 == false) goto L26;
        int r16 = (r10 - getMeasuredWidth()) / 2;
    L27:
        r1[0] = this.mXOffset + r16;
        r1[1] = (-getMeasuredHeight()) + this.mYOffset;
        goto L36
    L26:
        r16 = 0;
        goto L27
    L28:
        if (r8 == false) goto L30;
        int r17 = (r11 - getMeasuredHeight()) / 2;
    L31:
        r1[0] = this.mXOffset + r10;
        r1[1] = this.mYOffset + r17;
        goto L36
    L30:
        r17 = 0;
        goto L31
    L32:
        if (r8 == false) goto L34;
        int r18 = (r11 - getMeasuredHeight()) / 2;
    L35:
        r1[0] = this.mXOffset - getMeasuredWidth();
        r1[1] = this.mYOffset + r18;
        goto L36
    L34:
        r18 = 0;
        goto L35
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View r2, int r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "anchor");
        super.showAtLocation(r2, Companion.adaptGravity$OUI_standardRelease(r3), r4, r5);     // Catch: Exception -> L5
        this.isAlreadyDismiss = false;     // Catch: Exception -> L5
        animatorEasyInOut(true);     // Catch: Exception -> L5
        return;
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View r2, int r3, int r4, int r5) {
        super.showAsDropDown(r2, r3, r4, Companion.adaptGravity$OUI_standardRelease(r5));     // Catch: Exception -> L5
        this.isAlreadyDismiss = false;     // Catch: Exception -> L5
        animatorEasyInOut(true);     // Catch: Exception -> L5
        return;
    }

    public final void popupAtLocation(View r3, int r4, int r5, int r6, float r7) {
        Intrinsics.checkNotNullParameter(r3, "anchor");
        int r8 = Companion.adaptGravity$OUI_standardRelease(r4);
        this.mGravity = r8;     // Catch: Exception -> L10
        this.mArrowOffset = r7;     // Catch: Exception -> L10
        OMiddleArrowPopoverLayout r9 = this.mOBubbleLayout;     // Catch: Exception -> L10
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
        OMiddleArrowPopoverLayout r1 = this.mOBubbleLayout;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
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
        OMiddleArrowPopoverLayout r1 = this.mOBubbleLayout;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r1 = null;
    L6:
        return r0 - (r1.m426getPadding() * 4);
    }

    public final int getBubbledWidth() {
        measure();
        int r0 = getContentView().getMeasuredWidth();
        OMiddleArrowPopoverLayout r1 = this.mOBubbleLayout;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r1 = null;
    L6:
        return r0 - (r1.m426getPadding() * 4);
    }

    public final View getPopoverView() {
        OMiddleArrowPopoverLayout r0 = this.mOBubbleLayout;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r0 = null;
    L6:
        return r0;
    }

    public final int getArrowHeight() {
        OMiddleArrowPopoverLayout r0 = this.mOBubbleLayout;
        if (r0 == null) goto L7;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r0 = null;
    L9:
        return r0.getArrowHeight();
    L7:
        return 0;
    }

    /* JADX INFO: renamed from: mDismissRunnable$lambda-1, reason: not valid java name */
    private static final void m423mDismissRunnable$lambda1(OMiddleArrowPopover r1) {
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
        OMiddleArrowPopoverLayout r0 = this.mOBubbleLayout;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r0 = null;
    L7:
        r0.setVisibility(8);
        onDestroy();
        getContentView().removeCallbacks(this.mDismissRunnable);
        this.mXOffset = 0;
        this.mYOffset = 0;
        return;
    }

    private final void animatorEasyInOut(final boolean r18) {
        final OMiddleArrowPopoverLayout r2 = this.mOBubbleLayout;
        OMiddleArrowPopoverLayout r3 = null;
        if (r2 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
        r2 = null;
    L6:
        if (r18 == true) goto L8;
        currentShowBubbleNumbers--;
        this.isAlreadyDismiss = true;
    L8:
        this.animSet = new AnimatorSet();
        int r6 = getMGravity();
        float r8 = 0.0f;
        if (r6 != 3) goto L11;
        float r7 = r2.getX() + r2.getMeasuredWidth();
        float r9 = r2.getY();
        OMiddleArrowPopoverLayout r10 = this.mOBubbleLayout;
        if (r10 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
    L36:
        float r4 = r3.getBubbleOffset();
    L37:
        float r5 = r4 + r9;
    L38:
        r2.setPivotY(r5);
        r2.setPivotX(r7);
        Interpolator r11 = PathInterpolatorCompat.create(0.0f, 0.0f, 1.0f, 1.0f);
        TimeInterpolator r12 = PathInterpolatorCompat.create(0.3f, 0.0f, 0.9f, 0.6f);
        float[] r13 = new float[2];
        if (r18 == false) goto L41;
        float r14 = 0.0f;
    L42:
        r13[0] = r14;
        if (r18 == false) goto L45;
        r8 = 1.0f;
    L45:
        r13[1] = r8;
        ObjectAnimator r15 = ObjectAnimator.ofFloat(r2, "alpha", r13);
        if (r18 == false) goto L48;
        TimeInterpolator r16 = r11;
    L49:
        r15.setInterpolator(r16);
        if (r18 == false) goto L52;
        long r17 = 90;
    L53:
        r15.setDuration(r17);
        float[] r19 = new float[2];
        float r110 = 0.5f;
        if (r18 == false) goto L56;
        float r111 = 0.5f;
    L57:
        r19[0] = r111;
        float r112 = 0.8f;
        if (r18 == false) goto L60;
        float r113 = 1.0f;
    L61:
        r19[1] = r113;
        ObjectAnimator r20 = ObjectAnimator.ofFloat(r2, "scaleX", r19);
        if (r18 == false) goto L64;
        TimeInterpolator r114 = new SpringInterpolator(0.61f);
    L65:
        r20.setInterpolator(r114);
        if (r18 == false) goto L68;
        long r21 = 420;
    L69:
        r20.setDuration(r21);
        float[] r22 = new float[2];
        if (r18 == true) goto L73;
        r110 = 1.0f;
    L73:
        r22[0] = r110;
        if (r18 == false) goto L76;
        r112 = 1.0f;
    L76:
        r22[1] = r112;
        ObjectAnimator r23 = ObjectAnimator.ofFloat(r2, "scaleY", r22);
        if (r18 == false) goto L79;
        r12 = new SpringInterpolator(0.61f);
    L79:
        r23.setInterpolator(r12);
        if (r18 == false) goto L82;
        long r24 = 420;
    L83:
        r23.setDuration(r24);
        r2.setVisibility(0);
        if (r18 == false) goto L91;
        Animator r25 = this.customInAnimator;
        if (r25 == null) goto L91;
        AnimatorSet r26 = this.animSet;
        if (r26 == null) goto L108;
        r26.play(r25);
    L108:
        AnimatorSet r27 = this.animSet;
        if (r27 == null) goto L113;
        r27.addListener(new AnonymousClass1(r18, r2, this));
    L113:
        if (this.mNeedOverShoot == false) goto L119;
        if (r18 == false) goto L119;
        AnimatorSet r1 = this.animSet;
        if (r1 == null) goto L119;
        r1.setInterpolator(new OvershootInterpolator(1.0f));
    L119:
        AnimatorSet r0 = this.animSet;
        if (r0 == null) goto L124;
        r0.start();
        return;
    L124:
        return;
    L91:
        if (r18 == true) goto L98;
        Animator r28 = this.customOutAnimator;
        if (r28 == null) goto L98;
        AnimatorSet r29 = this.animSet;
        if (r29 == null) goto L108;
        r29.play(r28);
    L98:
        AnimatorSet r30 = this.animSet;
        if (r30 == null) goto L108;
        AnimatorSet.Builder r31 = r30.play(r20);
        if (r31 == null) goto L108;
        AnimatorSet.Builder r32 = r31.with(r23);
        if (r32 == null) goto L108;
        r32.with(r15);
        goto L108
    L82:
        r24 = 120;
        goto L83
    L68:
        r21 = 120;
        goto L69
    L64:
        r114 = r12;
        goto L65
    L60:
        r113 = 0.8f;
        goto L61
    L56:
        r111 = 1.0f;
        goto L57
    L52:
        r17 = 120;
        goto L53
    L48:
        r16 = r12;
        goto L49
    L41:
        r14 = 1.0f;
        goto L42
    L35:
        r3 = r10;
        goto L36
    L11:
        if (r6 != 5) goto L13;
        r7 = r2.getX();
        r9 = r2.getY();
        OMiddleArrowPopoverLayout r33 = this.mOBubbleLayout;
        if (r33 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
    L31:
        r4 = r3.getBubbleOffset();
        goto L37
    L30:
        r3 = r33;
        goto L31
    L13:
        if (r6 != 48) goto L15;
        float r34 = r2.getX();
        OMiddleArrowPopoverLayout r35 = this.mOBubbleLayout;
        if (r35 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
    L26:
        r7 = r34 + r3.getBubbleOffset();
        r5 = r2.getY() + r2.getMeasuredHeight();
        goto L38
    L25:
        r3 = r35;
        goto L26
    L15:
        if (r6 == 80) goto L17;
        r5 = 0.0f;
        r7 = 0.0f;
        goto L38
    L17:
        float r36 = r2.getX();
        OMiddleArrowPopoverLayout r37 = this.mOBubbleLayout;
        if (r37 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mOBubbleLayout");
    L21:
        r7 = r36 + r3.getBubbleOffset();
        r5 = r2.getY();
        goto L38
    L20:
        r3 = r37;
        goto L21
    }

    static {
        Companion = new Companion(null);
        TEXT_SIZE_DP = 18.0f;
    }
}
