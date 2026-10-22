package com.obric.oui.titlebar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.bytedance.apm.trace.fps.RealFpsTracer;
import com.obric.common.oui.R;
import com.obric.oui.button.OIconButton;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.titlebar.behavior.BaseBehavior;
import com.obric.oui.titlebar.behavior.HeaderBehavior;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: OUnitedTitleBar.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\u0018\u0000 \u007f2\u00020\u00012\u00020\u0002:\u0006~\u007f\u0080\u0001\u0081\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010U\u001a\u00020V2\b\u0010W\u001a\u0004\u0018\u00010;J\u000e\u0010X\u001a\u00020V2\u0006\u0010Y\u001a\u00020\tJ\u0014\u0010Z\u001a\u0004\u0018\u00010\r2\b\u0010[\u001a\u0004\u0018\u00010\rH\u0002J\u0014\u0010\\\u001a\u0004\u0018\u00010]2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010\\\u001a\u0004\u0018\u00010]2\b\u0010^\u001a\u0004\u0018\u00010_H\u0014J\f\u0010`\u001a\u0006\u0012\u0002\b\u00030aH\u0016J\u0006\u0010b\u001a\u00020\tJ\u0006\u0010c\u001a\u00020\tJ\u0006\u0010d\u001a\u00020\tJ\b\u0010e\u001a\u00020\tH\u0002J\b\u0010f\u001a\u00020\tH\u0002J\u0006\u0010g\u001a\u00020\tJ\u0006\u0010h\u001a\u00020\tJ\u0006\u0010i\u001a\u00020\tJ\u0006\u0010j\u001a\u00020\u0017J\u0006\u0010k\u001a\u00020\u0017J\u001a\u0010l\u001a\u00020V2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0006\u0010m\u001a\u00020\u0017J\u0012\u0010n\u001a\u0004\u0018\u00010\u001e2\b\u0010o\u001a\u0004\u0018\u00010\u001eJ\u0006\u0010p\u001a\u00020VJ\u0010\u0010q\u001a\u00020V2\b\u0010W\u001a\u0004\u0018\u00010;J\u0006\u0010r\u001a\u00020VJ\u000e\u0010s\u001a\u00020V2\u0006\u0010t\u001a\u00020\u0017J\u000e\u0010#\u001a\u00020V2\u0006\u0010u\u001a\u00020\rJ\u000e\u0010v\u001a\u00020\u00172\u0006\u0010w\u001a\u00020\u0017J\u000e\u0010x\u001a\u00020V2\u0006\u0010y\u001a\u000204J\u000e\u0010H\u001a\u00020V2\u0006\u0010u\u001a\u00020\rJ\u0006\u0010z\u001a\u00020VJ\b\u0010{\u001a\u00020\u0017H\u0002J\u0010\u0010|\u001a\u00020\u00172\b\u0010[\u001a\u0004\u0018\u00010\rJ\b\u0010}\u001a\u00020VH\u0002R\u0014\u0010\b\u001a\u00020\tX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u000e\u0010\u0015\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020\u0017X\u0082D¢\u0006\u0002\n\u0000R\u0016\u0010,\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u00020\t8\u0002X\u0083D¢\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u000b\"\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u000104X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0016\u00109\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010=\u001a\u0004\u0018\u00010>X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001c\u0010C\u001a\u0004\u0018\u00010>X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010@\"\u0004\bE\u0010BR\u001c\u0010F\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\"\"\u0004\bH\u0010$R\u001c\u0010I\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010(\"\u0004\bK\u0010*R\u001a\u0010L\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u000b\"\u0004\bN\u00102R\u001c\u0010O\u001a\u0004\u0018\u00010PX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010T¨\u0006\u0082\u0001"}, d2 = {"Lcom/obric/oui/titlebar/OUnitedTitleBar;", "Landroid/widget/FrameLayout;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$AttachedBehavior;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "INVALID_SCROLL_RANGE", "", "getINVALID_SCROLL_RANGE", "()I", "bottomAction", "Landroid/view/View;", "getBottomAction", "()Landroid/view/View;", "setBottomAction", "(Landroid/view/View;)V", "divider", "getDivider", "setDivider", "downScrollRange", "haveChildWithInterpolator", "", "inDebug", "getInDebug", "()Z", "setInDebug", "(Z)V", "lastInsets", "Landroidx/core/view/WindowInsetsCompat;", "leftAction", "Landroid/view/ViewGroup;", "getLeftAction", "()Landroid/view/ViewGroup;", "setLeftAction", "(Landroid/view/ViewGroup;)V", "leftActionSrc", "Landroid/graphics/drawable/Drawable;", "getLeftActionSrc", "()Landroid/graphics/drawable/Drawable;", "setLeftActionSrc", "(Landroid/graphics/drawable/Drawable;)V", "liftOnScroll", "liftOnScrollTargetView", "Ljava/lang/ref/WeakReference;", "liftOnScrollTargetViewId", "mCollapsePosition", "getMCollapsePosition", "setMCollapsePosition", "(I)V", "mOnHeaderFlingUnConsumedListener", "Lcom/obric/oui/titlebar/OUnitedTitleBar$OnHeaderFlingUnConsumedListener;", "getMOnHeaderFlingUnConsumedListener", "()Lcom/obric/oui/titlebar/OUnitedTitleBar$OnHeaderFlingUnConsumedListener;", "setMOnHeaderFlingUnConsumedListener", "(Lcom/obric/oui/titlebar/OUnitedTitleBar$OnHeaderFlingUnConsumedListener;)V", "mOnOffsetChangeListeners", "", "Lcom/obric/oui/titlebar/OUnitedTitleBar$OnOffsetChangeListener;", "mPendingAction", "mTvSubTitle", "Landroid/widget/TextView;", "getMTvSubTitle", "()Landroid/widget/TextView;", "setMTvSubTitle", "(Landroid/widget/TextView;)V", "mTvTitle", "getMTvTitle", "setMTvTitle", "rightAction", "getRightAction", "setRightAction", "rightActionSrc", "getRightActionSrc", "setRightActionSrc", "textInitPos", "getTextInitPos", "setTextInitPos", "titleText", "", "getTitleText", "()Ljava/lang/String;", "setTitleText", "(Ljava/lang/String;)V", "addOnOffsetChangeListener", "", "listener", "dispatchOffsetChange", "offset", "findLiftOnScrollTargetView", "defaultScrollingView", "generateLayoutParams", "Lcom/obric/oui/titlebar/behavior/BaseBehavior$LayoutParams;", "p", "Landroid/view/ViewGroup$LayoutParams;", "getBehavior", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "getDownNestedPreScrollRange", "getDownNestedScrollRange", "getPendingAction", "getScrollRange", "getSnapRange", "getTopInset", "getTotalScrollRange", "getUpNestedPreScrollRange", "hasChildWithInterpolator", "hasScrollableChildren", "init", "isLiftOnScroll", "onWindowInsetChanged", "insets", "registerTransform", "removeOnOffsetChangeListener", "resetPendingAction", "setExpanded", "expanded", "view", "setLiftedState", "lifted", "setOnHeaderFlingUnConsumedListener", "onHeaderFlingUnConsumedListener", "setupView", "shouldDrawStatusBarForeground", "shouldLift", "updateWillNotDraw", "Behavior", "Companion", "OnHeaderFlingUnConsumedListener", "OnOffsetChangeListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OUnitedTitleBar extends FrameLayout implements CoordinatorLayout.AttachedBehavior {
    private static final int ACTION_MARGIN_TOP = 0;
    private static final int COLLAPSE_HEIGHT = 0;
    public static final int COLLAPSE_ON_CENTER = 0;
    public static final int COLLAPSE_ON_LEFT = 1;
    public static final float COLLAPSE_TEXT_SIZE_ON_CENTER = 16.0f;
    public static final float COLLAPSE_TEXT_SIZE_ON_LEFT = 20.0f;
    public static final Companion Companion = null;
    private static final int EXPANDED_HEIGHT = 0;
    public static final float EXPANDED_TEXT_SIZE = 40.0f;
    public static final int PENDING_ACTION_ANIMATED = 16;
    public static final int PENDING_ACTION_ANIMATE_ENABLED = 4;
    public static final int PENDING_ACTION_COLLAPSED = 1;
    public static final int PENDING_ACTION_EXPANDED = 16;
    public static final int PENDING_ACTION_FORCE = 8;
    public static final int PENDING_ACTION_NONE = 0;
    private static final int TITLE_COLLAPSE_MARGIN_BOTTOM_ON_CENTER = 0;
    private static final int TITLE_COLLAPSE_MARGIN_BOTTOM_ON_LEFT = 0;
    private static final int TITLE_EXPANDED_MARGIN_BOTTOM = 0;
    private final int INVALID_SCROLL_RANGE;
    private View bottomAction;
    private View divider;
    private int downScrollRange;
    private final boolean haveChildWithInterpolator;
    private boolean inDebug;
    private WindowInsetsCompat lastInsets;
    private ViewGroup leftAction;
    private Drawable leftActionSrc;
    private final boolean liftOnScroll;
    private WeakReference<View> liftOnScrollTargetView;
    private final int liftOnScrollTargetViewId;
    private int mCollapsePosition;
    private OnHeaderFlingUnConsumedListener mOnHeaderFlingUnConsumedListener;
    private List<OnOffsetChangeListener> mOnOffsetChangeListeners;
    private int mPendingAction;
    private TextView mTvSubTitle;
    private TextView mTvTitle;
    private ViewGroup rightAction;
    private Drawable rightActionSrc;
    private int textInitPos;
    private String titleText;

    /* JADX INFO: compiled from: OUnitedTitleBar.kt */
    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0019\n\u0002\u0010\u0015\n\u0002\b\f\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u001b\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ,\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 H\u0002J,\u0010!\u001a\u00020\u001a2\b\u0010\"\u001a\u0004\u0018\u00010\u001c2\b\u0010#\u001a\u0004\u0018\u00010\u00022\u0006\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u0012H\u0002J\u0012\u0010&\u001a\u00020\u000f2\b\u0010'\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010(\u001a\u00020\u000f2\b\u0010\"\u001a\u0004\u0018\u00010\u001c2\b\u0010#\u001a\u0004\u0018\u00010\u0002J2\u0010)\u001a\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010*\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020 H\u0016J\u0010\u0010.\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u0002H\u0016J\u0010\u0010/\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u0002H\u0016J\u001c\u00100\u001a\u00020\u001a2\b\u0010\"\u001a\u0004\u0018\u00010\u001c2\b\u0010#\u001a\u0004\u0018\u00010\u0002H\u0016J \u00101\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u0012H\u0016J8\u00103\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u000b2\u0006\u00104\u001a\u00020 2\u0006\u0010-\u001a\u00020 2\u0006\u00105\u001a\u00020\u000fH\u0016J0\u00106\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u000b2\u0006\u00104\u001a\u00020 2\u0006\u0010-\u001a\u00020 H\u0016J8\u00107\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u00122\u0006\u00109\u001a\u00020\u00122\u0006\u00105\u001a\u00020:H\u0016J@\u0010;\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u00122\u0006\u0010=\u001a\u00020\u00122\u0006\u0010>\u001a\u00020\u00122\u0006\u0010?\u001a\u00020\u0012H\u0016J0\u0010@\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010A\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\u0012H\u0016J \u0010C\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u000bH\u0016J4\u0010D\u001a\u00020\u00122\b\u0010\"\u001a\u0004\u0018\u00010\u001c2\b\u0010#\u001a\u0004\u0018\u00010\u00022\u0006\u0010E\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u0012H\u0016R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u0012X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006F"}, d2 = {"Lcom/obric/oui/titlebar/OUnitedTitleBar$Behavior;", "Lcom/obric/oui/titlebar/behavior/HeaderBehavior;", "Lcom/obric/oui/titlebar/OUnitedTitleBar;", "()V", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mLastNestedScrollingChildRef", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "mOffsetAnimator", "Landroid/animation/ValueAnimator;", "mShouldDispatchFling", "", "mSkipNestedPreScroll", "mTempFlingDispatchConsumed", "", "mTempFlingMaxOffset", "mTempFlingMinOffset", "mWasFlung", "offsetDelta", "getOffsetDelta", "()I", "animateOffsetTo", "", "coordinatorLayout", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "child", "offset", RealFpsTracer.SCROLL_VELOCITY, "", "animateToOffset", "parent", "header", "target", "duration", "canDragView", "view", "checkSnap", "fling", "layout", "minOffset", "maxOffset", "velocityY", "getMaxDragOffset", "getScrollRangeForDragFling", "onFlingFinished", "onLayoutChild", "layoutDirection", "onNestedFling", "velocityX", "consumed", "onNestedPreFling", "onNestedPreScroll", "dx", "dy", "", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onStartNestedScroll", "directTargetChild", "nestedScrollAxes", "onStopNestedScroll", "setHeaderTopBottomOffset", "newOffset", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Behavior extends HeaderBehavior<OUnitedTitleBar> {
        private WeakReference<View> mLastNestedScrollingChildRef;
        private ValueAnimator mOffsetAnimator;
        private boolean mShouldDispatchFling;
        private boolean mSkipNestedPreScroll;
        private int mTempFlingDispatchConsumed;
        private int mTempFlingMaxOffset;
        private int mTempFlingMinOffset;
        private boolean mWasFlung;
        private final int offsetDelta;

        public static /* synthetic */ void $r8$lambda$svrYgPqzLlLkx7DO8ICBzCUuy_U(Behavior r0, CoordinatorLayout r1, OUnitedTitleBar r2, ValueAnimator r3) {
            m1427animateToOffset$lambda0(r0, r1, r2, r3);
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* bridge */ /* synthetic */ boolean canDragView(View r1) {
            return canDragView((OUnitedTitleBar) r1);
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* bridge */ /* synthetic */ boolean fling(CoordinatorLayout r1, View r2, int r3, int r4, float r5) {
            return fling(r1, (OUnitedTitleBar) r2, r3, r4, r5);
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* bridge */ /* synthetic */ int getMaxDragOffset(View r1) {
            return getMaxDragOffset((OUnitedTitleBar) r1);
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* bridge */ /* synthetic */ int getScrollRangeForDragFling(View r1) {
            return getScrollRangeForDragFling((OUnitedTitleBar) r1);
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* bridge */ /* synthetic */ void onFlingFinished(CoordinatorLayout r1, View r2) {
            onFlingFinished(r1, (OUnitedTitleBar) r2);
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior, com.obric.oui.titlebar.behavior.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout r1, View r2, int r3) {
            return onLayoutChild(r1, (OUnitedTitleBar) r2, r3);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onNestedFling(CoordinatorLayout r1, View r2, View r3, float r4, float r5, boolean r6) {
            return onNestedFling(r1, (OUnitedTitleBar) r2, r3, r4, r5, r6);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onNestedPreFling(CoordinatorLayout r1, View r2, View r3, float r4, float r5) {
            return onNestedPreFling(r1, (OUnitedTitleBar) r2, r3, r4, r5);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout r1, View r2, View r3, int r4, int r5, int[] r6) {
            onNestedPreScroll(r1, (OUnitedTitleBar) r2, r3, r4, r5, r6);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout r1, View r2, View r3, int r4, int r5, int r6, int r7) {
            onNestedScroll(r1, (OUnitedTitleBar) r2, r3, r4, r5, r6, r7);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout r1, View r2, View r3, View r4, int r5) {
            return onStartNestedScroll(r1, (OUnitedTitleBar) r2, r3, r4, r5);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout r1, View r2, View r3) {
            onStopNestedScroll(r1, (OUnitedTitleBar) r2, r3);
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* bridge */ /* synthetic */ int setHeaderTopBottomOffset(CoordinatorLayout r1, View r2, int r3, int r4, int r5) {
            return setHeaderTopBottomOffset(r1, (OUnitedTitleBar) r2, r3, r4, r5);
        }

        public final int getOffsetDelta() {
            return this.offsetDelta;
        }

        public Behavior() {
        }

        public Behavior(Context r1, AttributeSet r2) {
            super(r1, r2);
        }

        public boolean canDragView(OUnitedTitleBar r4) {
            WeakReference<View> r0 = this.mLastNestedScrollingChildRef;
            if (r0 == null) goto L15;
            Intrinsics.checkNotNull(r0);
            View r1 = r0.get();
            if (r1 != null) goto L7;
        L13:
            return false;
        L7:
            if (r1.isShown() == false) goto L13;
            if (ViewCompat.canScrollVertically(r1, -1) == true) goto L13;
            int r3 = getTopAndBottomOffset();
            Intrinsics.checkNotNull(r4);
            if (r3 <= (-OUnitedTitleBar.access$getScrollRange(r4))) goto L13;
            return true;
        L15:
            return true;
        }

        public int getMaxDragOffset(OUnitedTitleBar r1) {
            Intrinsics.checkNotNullParameter(r1, "view");
            return -OUnitedTitleBar.access$getScrollRange(r1);
        }

        public int getScrollRangeForDragFling(OUnitedTitleBar r1) {
            Intrinsics.checkNotNullParameter(r1, "view");
            return OUnitedTitleBar.access$getScrollRange(r1);
        }

        public int setHeaderTopBottomOffset(CoordinatorLayout r8, OUnitedTitleBar r9, int r10, int r11, int r12) {
            int r0 = getTopAndBottomOffset();
            if (this.mShouldDispatchFling == false) goto L5;
            r11 = Math.max(this.mTempFlingMinOffset, r11);
            r12 = Math.min(this.mTempFlingMaxOffset, r12);
        L5:
            int r13 = super.setHeaderTopBottomOffset(r8, r9, r10, r11, r12);
            if (r9 == null) goto L9;
            r9.dispatchOffsetChange(getTopAndBottomOffset());
        L9:
            int r14 = 0;
            if (this.mShouldDispatchFling == false) goto L20;
            if (r9 != null) goto L13;
            OnHeaderFlingUnConsumedListener r15 = null;
        L14:
            if (r15 == null) goto L20;
            int r16 = ((r10 - r0) + r13) - this.mTempFlingDispatchConsumed;
            if (r16 == 0) goto L18;
            Intrinsics.checkNotNull(r9);
            OnHeaderFlingUnConsumedListener r17 = r9.getMOnHeaderFlingUnConsumedListener();
            Intrinsics.checkNotNull(r17);
            r14 = r17.onFlingUnConsumed(r9, r10, r16);
        L18:
            this.mTempFlingDispatchConsumed += -r14;
            goto L20
        L13:
            r15 = r9.getMOnHeaderFlingUnConsumedListener();
        L20:
            return r13 + r14;
        }

        public boolean fling(CoordinatorLayout r7, OUnitedTitleBar r8, int r9, int r10, float r11) {
            Intrinsics.checkNotNullParameter(r8, "layout");
            if (r11 >= 0.0f) goto L5;
            this.mShouldDispatchFling = true;
            this.mTempFlingDispatchConsumed = 0;
            this.mTempFlingMinOffset = r9;
            this.mTempFlingMaxOffset = r10;
            r9 = Integer.MIN_VALUE;
            r10 = Integer.MAX_VALUE;
        L5:
            OUnitedTitleBar r2 = r8;
            return super.fling(r7, r2, r9, r10, r11);
        }

        public void onFlingFinished(CoordinatorLayout r2, OUnitedTitleBar r3) {
            this.mShouldDispatchFling = false;
            checkSnap(r2, r3);
        }

        public final boolean checkSnap(CoordinatorLayout r5, OUnitedTitleBar r6) {
            int r0 = getTopAndBottomOffset();
            Intrinsics.checkNotNull(r6);
            int r1 = -OUnitedTitleBar.access$getSnapRange(r6);
            if (r0 <= r1) goto L11;
            if (r0 >= 0) goto L11;
            if (r0 < ((r1 + 0) / 2)) goto L9;
            r1 = 0;
        L9:
            animateOffsetTo(r5, r6, r1, 0.0f);
            return true;
        L11:
            return false;
        }

        public boolean onLayoutChild(CoordinatorLayout r3, OUnitedTitleBar r4, int r5) {
            Intrinsics.checkNotNullParameter(r3, "parent");
            Intrinsics.checkNotNullParameter(r4, "child");
            OUnitedTitleBar r0 = r4;
            boolean r6 = super.onLayoutChild(r3, r0, r5);
            if (OUnitedTitleBar.access$getMPendingAction$p(r4) != 0) goto L5;
        L10:
            r4.dispatchOffsetChange(getTopAndBottomOffset());
            return r6;
        L5:
            if ((OUnitedTitleBar.access$getMPendingAction$p(r4) & 1) == 0) goto L8;
            setHeaderTopBottomOffset(r3, r0, -OUnitedTitleBar.access$getScrollRange(r4));
            goto L10
        L8:
            if ((OUnitedTitleBar.access$getMPendingAction$p(r4) & 16) == 0) goto L10;
            setHeaderTopBottomOffset(r3, r0, 0);
            goto L10
        }

        private final void animateOffsetTo(CoordinatorLayout r3, OUnitedTitleBar r4, int r5, float r6) {
            int r0 = Math.abs(getTopBottomOffsetForScrollingSibling() - r5);
            float r7 = Math.abs(r6);
            if (r7 <= 0.0f) goto L5;
            int r8 = Math.round(1000 * (r0 / r7));
        L6:
            animateToOffset(r3, r4, r5, r8);
            return;
        L5:
            Intrinsics.checkNotNull(r4);
            r8 = (int) (((r0 / r4.getHeight()) + 1) * 150);
            goto L6
        }

        private final void animateToOffset(final CoordinatorLayout r4, final OUnitedTitleBar r5, int r6, int r7) {
            int r0 = getTopAndBottomOffset();
            if (r0 != r6) goto L7;
            ValueAnimator r1 = this.mOffsetAnimator;
            if (r1 == null) goto L7;
            Intrinsics.checkNotNull(r1);
            r1.cancel();
        L7:
            ValueAnimator r2 = this.mOffsetAnimator;
            if (r2 != null) goto L10;
            ValueAnimator r3 = new ValueAnimator();
            this.mOffsetAnimator = r3;
            Intrinsics.checkNotNull(r3);
            r3.setInterpolator(new AccelerateDecelerateInterpolator());
            ValueAnimator r8 = this.mOffsetAnimator;
            Intrinsics.checkNotNull(r8);
            r8.addUpdateListener(new OUnitedTitleBar$Behavior$$ExternalSyntheticLambda0(this, r4, r5));
        L11:
            ValueAnimator r9 = this.mOffsetAnimator;
            Intrinsics.checkNotNull(r9);
            r9.setDuration(r7);
            ValueAnimator r10 = this.mOffsetAnimator;
            Intrinsics.checkNotNull(r10);
            r10.setIntValues(new int[]{r0, r6});
            ValueAnimator r11 = this.mOffsetAnimator;
            Intrinsics.checkNotNull(r11);
            r11.start();
            return;
        L10:
            Intrinsics.checkNotNull(r2);
            r2.cancel();
            goto L11
        }

        /* JADX INFO: renamed from: animateToOffset$lambda-0, reason: not valid java name */
        private static final void m1427animateToOffset$lambda0(Behavior r1, CoordinatorLayout r2, OUnitedTitleBar r3, ValueAnimator r4) {
            Intrinsics.checkNotNullParameter(r1, "this$0");
            Intrinsics.checkNotNullParameter(r4, "animation");
            OUnitedTitleBar r5 = r3;
            Object r6 = r4.getAnimatedValue();
            if (r6 == null) goto L7;
            r1.setHeaderTopBottomOffset(r2, r5, ((Integer) r6).intValue());
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }

        public boolean onStartNestedScroll(CoordinatorLayout r2, OUnitedTitleBar r3, View r4, View r5, int r6) {
            Intrinsics.checkNotNullParameter(r2, "coordinatorLayout");
            Intrinsics.checkNotNullParameter(r3, "child");
            Intrinsics.checkNotNullParameter(r4, "directTargetChild");
            Intrinsics.checkNotNullParameter(r5, "target");
            if ((r6 & 2) > 0) goto L5;
        L9:
            boolean r7 = false;
        L10:
            if (r7 == false) goto L14;
            ValueAnimator r8 = this.mOffsetAnimator;
            if (r8 == null) goto L14;
            Intrinsics.checkNotNull(r8);
            r8.cancel();
        L14:
            this.mLastNestedScrollingChildRef = null;
            this.mWasFlung = false;
            this.mShouldDispatchFling = false;
            stopFling();
            return r7;
        L5:
            if (OUnitedTitleBar.access$getScrollRange(r3) <= 0) goto L9;
            if ((r2.getHeight() - r4.getHeight()) > r3.getHeight()) goto L9;
            r7 = true;
            goto L10
        }

        public void onNestedPreScroll(CoordinatorLayout r7, OUnitedTitleBar r8, View r9, int r10, int r11, int[] r12) {
            Intrinsics.checkNotNullParameter(r7, "coordinatorLayout");
            Intrinsics.checkNotNullParameter(r8, "child");
            Intrinsics.checkNotNullParameter(r9, "target");
            Intrinsics.checkNotNullParameter(r12, "consumed");
            if (r11 > 0) goto L5;
            return;
        L5:
            if (this.mSkipNestedPreScroll == true) goto L9;
            OUnitedTitleBar r2 = r8;
            r12[1] = scroll(r7, r2, r11, -OUnitedTitleBar.access$getScrollRange(r8), 0);
            return;
        }

        public void onNestedScroll(CoordinatorLayout r7, OUnitedTitleBar r8, View r9, int r10, int r11, int r12, int r13) {
            Intrinsics.checkNotNullParameter(r7, "coordinatorLayout");
            Intrinsics.checkNotNullParameter(r8, "child");
            Intrinsics.checkNotNullParameter(r9, "target");
            if (r13 >= 0) goto L5;
            scroll(r7, r8, r13, -OUnitedTitleBar.access$getScrollRange(r8), 0);
            boolean r14 = true;
        L6:
            this.mSkipNestedPreScroll = r14;
            return;
        L5:
            r14 = false;
            goto L6
        }

        public void onStopNestedScroll(CoordinatorLayout r2, OUnitedTitleBar r3, View r4) {
            Intrinsics.checkNotNullParameter(r2, "coordinatorLayout");
            Intrinsics.checkNotNullParameter(r3, "child");
            Intrinsics.checkNotNullParameter(r4, "target");
            if (this.mWasFlung == true) goto L5;
            checkSnap(r2, r3);
        L5:
            this.mSkipNestedPreScroll = false;
            this.mLastNestedScrollingChildRef = new WeakReference(r4);
        }

        public boolean onNestedPreFling(CoordinatorLayout r7, OUnitedTitleBar r8, View r9, float r10, float r11) {
            Intrinsics.checkNotNullParameter(r7, "coordinatorLayout");
            Intrinsics.checkNotNullParameter(r8, "child");
            Intrinsics.checkNotNullParameter(r9, "target");
            if (r11 > 0.0f) goto L5;
            return false;
        L5:
            if (getTopAndBottomOffset() <= (-OUnitedTitleBar.access$getScrollRange(r8))) goto L10;
            fling(r7, r8, -OUnitedTitleBar.access$getScrollRange(r8), 0, -r11);
            this.mWasFlung = true;
            return true;
        L10:
            return false;
        }

        public boolean onNestedFling(CoordinatorLayout r1, OUnitedTitleBar r2, View r3, float r4, float r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r1, "coordinatorLayout");
            Intrinsics.checkNotNullParameter(r2, "child");
            Intrinsics.checkNotNullParameter(r3, "target");
            this.mWasFlung = true;
            return false;
        }
    }

    /* JADX INFO: compiled from: OUnitedTitleBar.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0006R\u000e\u0010\u0010\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0014\u0010\u0019\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0014\u0010\u001b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006¨\u0006\u001d"}, d2 = {"Lcom/obric/oui/titlebar/OUnitedTitleBar$Companion;", "", "()V", "ACTION_MARGIN_TOP", "", "getACTION_MARGIN_TOP", "()I", "COLLAPSE_HEIGHT", "getCOLLAPSE_HEIGHT", "COLLAPSE_ON_CENTER", "COLLAPSE_ON_LEFT", "COLLAPSE_TEXT_SIZE_ON_CENTER", "", "COLLAPSE_TEXT_SIZE_ON_LEFT", "EXPANDED_HEIGHT", "getEXPANDED_HEIGHT", "EXPANDED_TEXT_SIZE", "PENDING_ACTION_ANIMATED", "PENDING_ACTION_ANIMATE_ENABLED", "PENDING_ACTION_COLLAPSED", "PENDING_ACTION_EXPANDED", "PENDING_ACTION_FORCE", "PENDING_ACTION_NONE", "TITLE_COLLAPSE_MARGIN_BOTTOM_ON_CENTER", "getTITLE_COLLAPSE_MARGIN_BOTTOM_ON_CENTER", "TITLE_COLLAPSE_MARGIN_BOTTOM_ON_LEFT", "getTITLE_COLLAPSE_MARGIN_BOTTOM_ON_LEFT", "TITLE_EXPANDED_MARGIN_BOTTOM", "getTITLE_EXPANDED_MARGIN_BOTTOM", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final int getCOLLAPSE_HEIGHT() {
            return OUnitedTitleBar.access$getCOLLAPSE_HEIGHT$cp();
        }

        public final int getEXPANDED_HEIGHT() {
            return OUnitedTitleBar.access$getEXPANDED_HEIGHT$cp();
        }

        public final int getACTION_MARGIN_TOP() {
            return OUnitedTitleBar.access$getACTION_MARGIN_TOP$cp();
        }

        public final int getTITLE_EXPANDED_MARGIN_BOTTOM() {
            return OUnitedTitleBar.access$getTITLE_EXPANDED_MARGIN_BOTTOM$cp();
        }

        public final int getTITLE_COLLAPSE_MARGIN_BOTTOM_ON_CENTER() {
            return OUnitedTitleBar.access$getTITLE_COLLAPSE_MARGIN_BOTTOM_ON_CENTER$cp();
        }

        public final int getTITLE_COLLAPSE_MARGIN_BOTTOM_ON_LEFT() {
            return OUnitedTitleBar.access$getTITLE_COLLAPSE_MARGIN_BOTTOM_ON_LEFT$cp();
        }
    }

    /* JADX INFO: compiled from: OUnitedTitleBar.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lcom/obric/oui/titlebar/OUnitedTitleBar$OnHeaderFlingUnConsumedListener;", "", "onFlingUnConsumed", "", "header", "Lcom/obric/oui/titlebar/OUnitedTitleBar;", "targetOffset", "unconsumed", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnHeaderFlingUnConsumedListener {
        int onFlingUnConsumed(OUnitedTitleBar r1, int r2, int r3);
    }

    /* JADX INFO: compiled from: OUnitedTitleBar.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/oui/titlebar/OUnitedTitleBar$OnOffsetChangeListener;", "", "onOffsetChanged", "", "header", "Lcom/obric/oui/titlebar/OUnitedTitleBar;", "currOffset", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnOffsetChangeListener {
        void onOffsetChanged(OUnitedTitleBar r1, int r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$GF4WYN25FeVz4OZLEx1Zc6-4O1s, reason: not valid java name */
    public static /* synthetic */ WindowInsetsCompat m1425$r8$lambda$GF4WYN25FeVz4OZLEx1Zc64O1s(OUnitedTitleBar r0, View r1, WindowInsetsCompat r2) {
        return m1426init$lambda0(r0, r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OUnitedTitleBar(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 2, 0 == true ? 1 : 0);
    }

    public final int getDownNestedPreScrollRange() {
        return 0;
    }

    public final boolean setLiftedState(boolean r1) {
        return false;
    }

    public /* synthetic */ OUnitedTitleBar(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public static final /* synthetic */ int access$getACTION_MARGIN_TOP$cp() {
        return ACTION_MARGIN_TOP;
    }

    public static final /* synthetic */ int access$getCOLLAPSE_HEIGHT$cp() {
        return COLLAPSE_HEIGHT;
    }

    public static final /* synthetic */ int access$getEXPANDED_HEIGHT$cp() {
        return EXPANDED_HEIGHT;
    }

    public static final /* synthetic */ int access$getMPendingAction$p(OUnitedTitleBar r0) {
        return r0.mPendingAction;
    }

    public static final /* synthetic */ int access$getScrollRange(OUnitedTitleBar r0) {
        return r0.getScrollRange();
    }

    public static final /* synthetic */ int access$getSnapRange(OUnitedTitleBar r0) {
        return r0.getSnapRange();
    }

    public static final /* synthetic */ int access$getTITLE_COLLAPSE_MARGIN_BOTTOM_ON_CENTER$cp() {
        return TITLE_COLLAPSE_MARGIN_BOTTOM_ON_CENTER;
    }

    public static final /* synthetic */ int access$getTITLE_COLLAPSE_MARGIN_BOTTOM_ON_LEFT$cp() {
        return TITLE_COLLAPSE_MARGIN_BOTTOM_ON_LEFT;
    }

    public static final /* synthetic */ int access$getTITLE_EXPANDED_MARGIN_BOTTOM$cp() {
        return TITLE_EXPANDED_MARGIN_BOTTOM;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateLayoutParams(r1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return generateLayoutParams(r1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ FrameLayout.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateLayoutParams(r1);
    }

    public OUnitedTitleBar(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        init(r2, r3);
        this.INVALID_SCROLL_RANGE = -1;
        this.downScrollRange = -1;
    }

    static {
        Companion = new Companion(null);
        COLLAPSE_HEIGHT = 56;
        EXPANDED_HEIGHT = 240;
        ACTION_MARGIN_TOP = 12;
        TITLE_EXPANDED_MARGIN_BOTTOM = 92;
        TITLE_COLLAPSE_MARGIN_BOTTOM_ON_CENTER = 17;
        TITLE_COLLAPSE_MARGIN_BOTTOM_ON_LEFT = 14;
    }

    public final ViewGroup getLeftAction() {
        return this.leftAction;
    }

    public final void setLeftAction(ViewGroup r1) {
        this.leftAction = r1;
    }

    public final ViewGroup getRightAction() {
        return this.rightAction;
    }

    public final void setRightAction(ViewGroup r1) {
        this.rightAction = r1;
    }

    public final TextView getMTvTitle() {
        return this.mTvTitle;
    }

    public final void setMTvTitle(TextView r1) {
        this.mTvTitle = r1;
    }

    public final TextView getMTvSubTitle() {
        return this.mTvSubTitle;
    }

    public final void setMTvSubTitle(TextView r1) {
        this.mTvSubTitle = r1;
    }

    public final View getBottomAction() {
        return this.bottomAction;
    }

    public final void setBottomAction(View r1) {
        this.bottomAction = r1;
    }

    public final String getTitleText() {
        return this.titleText;
    }

    public final void setTitleText(String r1) {
        this.titleText = r1;
    }

    public final Drawable getLeftActionSrc() {
        return this.leftActionSrc;
    }

    public final void setLeftActionSrc(Drawable r1) {
        this.leftActionSrc = r1;
    }

    public final Drawable getRightActionSrc() {
        return this.rightActionSrc;
    }

    public final void setRightActionSrc(Drawable r1) {
        this.rightActionSrc = r1;
    }

    public final View getDivider() {
        return this.divider;
    }

    public final void setDivider(View r1) {
        this.divider = r1;
    }

    public final OnHeaderFlingUnConsumedListener getMOnHeaderFlingUnConsumedListener() {
        return this.mOnHeaderFlingUnConsumedListener;
    }

    public final void setMOnHeaderFlingUnConsumedListener(OnHeaderFlingUnConsumedListener r1) {
        this.mOnHeaderFlingUnConsumedListener = r1;
    }

    public final int getMCollapsePosition() {
        return this.mCollapsePosition;
    }

    public final void setMCollapsePosition(int r1) {
        this.mCollapsePosition = r1;
    }

    public final void addOnOffsetChangeListener(OnOffsetChangeListener r2) {
        if (this.mOnOffsetChangeListeners != null) goto L5;
        this.mOnOffsetChangeListeners = new ArrayList();
    L5:
        if (r2 == null) goto L10;
        List<OnOffsetChangeListener> r0 = this.mOnOffsetChangeListeners;
        Intrinsics.checkNotNull(r0);
        if (r0.contains(r2) == true) goto L11;
        List<OnOffsetChangeListener> r1 = this.mOnOffsetChangeListeners;
        Intrinsics.checkNotNull(r1);
        r1.add(r2);
        return;
    L11:
        return;
    }

    public final void removeOnOffsetChangeListener(OnOffsetChangeListener r1) {
        List<OnOffsetChangeListener> r0 = this.mOnOffsetChangeListeners;
        if (r0 == null) goto L7;
        TypeIntrinsics.asMutableCollection(r0).remove(r1);
        return;
    }

    public final void setExpanded(boolean r1) {
        if (r1 == false) goto L4;
        int r2 = 16;
    L5:
        this.mPendingAction = r2;
        requestLayout();
        return;
    L4:
        r2 = 1;
        goto L5
    }

    public final void dispatchOffsetChange(int r3) {
        List<OnOffsetChangeListener> r0 = this.mOnOffsetChangeListeners;
        if (r0 == null) goto L8;
        Intrinsics.checkNotNull(r0);
        Iterator<OnOffsetChangeListener> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        r1.next().onOffsetChanged(this, r3);
        goto L6
    L10:
        return;
    }

    public final void setOnHeaderFlingUnConsumedListener(OnHeaderFlingUnConsumedListener r2) {
        Intrinsics.checkNotNullParameter(r2, "onHeaderFlingUnConsumedListener");
        this.mOnHeaderFlingUnConsumedListener = r2;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected BaseBehavior.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return new BaseBehavior.LayoutParams(r1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public BaseBehavior.LayoutParams generateLayoutParams(AttributeSet r2) {
        return new BaseBehavior.LayoutParams(getContext(), r2);
    }

    private final void init(Context r3, AttributeSet r4) {
        TypedArray r5 = r3.obtainStyledAttributes(r4, R.styleable.OUnitedTitleBar);
        Intrinsics.checkNotNullExpressionValue(r5, "context.obtainStyledAttr…tyleable.OUnitedTitleBar)");
        this.titleText = r5.getString(R.styleable.OUnitedTitleBar_oui_united_title);
        this.mCollapsePosition = r5.getInt(R.styleable.OUnitedTitleBar_oui_title_collapse_position, 0);
        this.leftActionSrc = r5.getDrawable(R.styleable.OUnitedTitleBar_oui_left_action_src);
        this.rightActionSrc = r5.getDrawable(R.styleable.OUnitedTitleBar_oui_right_action_src);
        r5.recycle();
        FrameLayout.inflate(r3, R.layout.o_united_titlebar, this);
        this.leftAction = (ViewGroup) findViewById(R.id.fl_left_container);
        this.rightAction = (ViewGroup) findViewById(R.id.fl_right_container);
        this.mTvTitle = (TextView) findViewById(R.id.tv_title_container);
        this.mTvSubTitle = (TextView) findViewById(R.id.tv_subtitle_container);
        this.bottomAction = findViewById(R.id.fl_bottom_container);
        this.divider = findViewById(R.id.divider);
        TextView r6 = this.mTvTitle;
        if (r6 == null) goto L6;
        r6.setText(this.titleText);
    L6:
        ViewCompat.setOnApplyWindowInsetsListener(this, new OUnitedTitleBar$$ExternalSyntheticLambda0(this));
        setupView();
        registerTransform();
    }

    /* JADX INFO: renamed from: init$lambda-0, reason: not valid java name */
    private static final WindowInsetsCompat m1426init$lambda0(OUnitedTitleBar r0, View r1, WindowInsetsCompat r2) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        WindowInsetsCompat r3 = r0.onWindowInsetChanged(r2);
        Intrinsics.checkNotNull(r3);
        return r3;
    }

    public final boolean getInDebug() {
        return this.inDebug;
    }

    public final void setInDebug(boolean r1) {
        this.inDebug = r1;
    }

    public final void setupView() {
        if (this.leftActionSrc == null) goto L6;
        Context r3 = getContext();
        Intrinsics.checkNotNullExpressionValue(r3, "context");
        OIconButton r0 = new OIconButton(r3, null, 0, 0, null, 28, null);
        r0.setImageDrawable(getLeftActionSrc());
        setLeftAction(r0);
    L6:
        if (this.rightActionSrc == null) goto L8;
        Context r4 = getContext();
        Intrinsics.checkNotNullExpressionValue(r4, "context");
        OIconButton r1 = new OIconButton(r4, null, 0, 0, null, 28, null);
        r1.setImageDrawable(getRightActionSrc());
        setRightAction(r1);
    L8:
        setBackgroundColor(getResources().getColor(R.color.Transparent));
        if (this.inDebug == false) goto L23;
        ViewGroup r2 = this.leftAction;
        if (r2 == null) goto L14;
        r2.setBackgroundColor(getResources().getColor(R.color.oui_blue_2));
    L14:
        ViewGroup r5 = this.rightAction;
        if (r5 == null) goto L18;
        r5.setBackgroundColor(getResources().getColor(R.color.oui_blue_2));
    L18:
        setBackgroundColor(getResources().getColor(R.color.oui_red_2));
        TextView r6 = this.mTvTitle;
        if (r6 == null) goto L24;
        r6.setBackgroundColor(getResources().getColor(R.color.oui_yellow_1));
        return;
    L24:
        return;
    }

    public final void registerTransform() {
        addOnOffsetChangeListener(new AnonymousClass1(this));
    }

    public final int getTextInitPos() {
        return this.textInitPos;
    }

    public final void setTextInitPos(int r1) {
        this.textInitPos = r1;
    }

    public final int getINVALID_SCROLL_RANGE() {
        return this.INVALID_SCROLL_RANGE;
    }

    public final void setLeftAction(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        ViewGroup r0 = this.leftAction;
        if (r0 == null) goto L6;
        r0.removeAllViews();
    L6:
        ViewGroup r1 = this.leftAction;
        if (r1 == null) goto L11;
        r1.addView(r2);
        return;
    }

    public final void setRightAction(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        ViewGroup r0 = this.rightAction;
        if (r0 == null) goto L6;
        r0.removeAllViews();
    L6:
        ViewGroup r1 = this.rightAction;
        if (r1 == null) goto L11;
        r1.addView(r2);
        return;
    }

    private final int getSnapRange() {
        return OUnitExtensionKt.vdp(this, 56);
    }

    public final boolean isLiftOnScroll() {
        return this.liftOnScroll;
    }

    public final boolean hasScrollableChildren() {
        if (getTotalScrollRange() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final int getDownNestedScrollRange() {
        return getTotalScrollRange();
    }

    public final int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    public final boolean shouldLift(View r1) {
        View r0 = findLiftOnScrollTargetView(r1);
        if (r0 == null) goto L6;
        r1 = r0;
    L6:
        if (r1 != null) goto L8;
    L12:
        return false;
    L8:
        if (r1.canScrollVertically(-1) == false) goto L10;
    L11:
        return true;
    L10:
        if (r1.getScrollY() <= 0) goto L12;
        goto L11
    }

    private final View findLiftOnScrollTargetView(View r4) {
        if (this.liftOnScrollTargetView != null) goto L19;
        int r0 = this.liftOnScrollTargetViewId;
        if (r0 == (-1)) goto L19;
        if (r4 == null) goto L8;
        View r5 = r4.findViewById(r0);
    L9:
        if (r5 == null) goto L11;
    L17:
        if (r5 == null) goto L19;
        this.liftOnScrollTargetView = new WeakReference(r5);
        goto L19
    L11:
        if ((getParent() instanceof ViewGroup) == false) goto L17;
        ViewParent r6 = getParent();
        if (r6 == null) goto L16;
        r5 = ((ViewGroup) r6).findViewById(this.liftOnScrollTargetViewId);
        goto L17
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L8:
        r5 = null;
    L19:
        WeakReference<View> r3 = this.liftOnScrollTargetView;
        if (r3 != null) goto L23;
        return null;
    L23:
        return r3.get();
    }

    public final int getTopInset() {
        WindowInsetsCompat r0 = this.lastInsets;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r0);
        return r0.getSystemWindowInsetTop();
    L5:
        return 0;
    }

    private final void updateWillNotDraw() {
        setWillNotDraw(!shouldDrawStatusBarForeground());
    }

    private final boolean shouldDrawStatusBarForeground() {
        if (getTopInset() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final WindowInsetsCompat onWindowInsetChanged(WindowInsetsCompat r3) {
        if (ViewCompat.getFitsSystemWindows(this) == false) goto L5;
        WindowInsetsCompat r0 = r3;
    L7:
        if (ObjectsCompat.equals(this.lastInsets, r0) == true) goto L9;
        this.lastInsets = r0;
        updateWillNotDraw();
        requestLayout();
    L9:
        return r3;
    L5:
        r0 = null;
        goto L7
    }

    public final int getPendingAction() {
        return this.mPendingAction;
    }

    public final void resetPendingAction() {
        this.mPendingAction = 0;
    }

    public final boolean hasChildWithInterpolator() {
        return this.haveChildWithInterpolator;
    }

    private final int getScrollRange() {
        return OUnitExtensionKt.vdp(this, EXPANDED_HEIGHT - COLLAPSE_HEIGHT);
    }

    public final int getTotalScrollRange() {
        return OUnitExtensionKt.vdp(this, EXPANDED_HEIGHT - COLLAPSE_HEIGHT);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    public CoordinatorLayout.Behavior<?> getBehavior() {
        return new BaseBehavior.Behavior();
    }
}
