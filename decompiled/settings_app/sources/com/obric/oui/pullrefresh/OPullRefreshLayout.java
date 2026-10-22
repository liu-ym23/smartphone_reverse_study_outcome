package com.obric.oui.pullrefresh;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.android.settings.search.IndexDatabaseHelper;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.trace.fps.RealFpsTracer;
import com.obric.common.oea.foundation.animation.builder.ValueAnimatable;
import com.obric.common.oea.foundation.animation.manager.AnimationManager;
import com.obric.common.oea.foundation.animation.spec.AnimationSpecKt;
import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.haptic.VibratorSmt;
import com.obric.oui.pullrefresh.header.ODefaultRefreshHeader;
import com.obric.oui.pullrefresh.header.ORefreshHeader;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: OPullRefreshLayout.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0015\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u009d\u00012\u00020\u00012\u00020\u0002:\u0002\u009d\u0001B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\"\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\b2\u0010\b\u0002\u0010=\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010>H\u0002J\b\u0010?\u001a\u00020;H\u0002J\u0006\u0010@\u001a\u00020;J\b\u0010A\u001a\u00020\u000bH\u0002J\u0012\u0010B\u001a\u00020\u000b2\b\u0010C\u001a\u0004\u0018\u00010DH\u0014J\u0018\u0010E\u001a\u00020\b2\u0006\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\u0013H\u0002J \u0010H\u001a\u00020;2\u0006\u0010I\u001a\u00020\u00132\u0006\u0010J\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bH\u0002J\b\u0010K\u001a\u00020;H\u0002J\u0014\u0010L\u001a\u0004\u0018\u00010\u00102\b\u0010M\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u0010N\u001a\u00020;2\b\b\u0002\u0010O\u001a\u00020\u000bJ\b\u0010P\u001a\u00020;H\u0002J\b\u0010Q\u001a\u00020DH\u0014J\u0012\u0010R\u001a\u00020D2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010R\u001a\u00020D2\b\u0010C\u001a\u0004\u0018\u00010DH\u0014J\b\u0010S\u001a\u00020\bH\u0016J\u0010\u0010T\u001a\u00020;2\u0006\u0010U\u001a\u00020\bH\u0002J\b\u0010V\u001a\u00020;H\u0014J\u0010\u0010W\u001a\u00020\u000b2\u0006\u0010X\u001a\u00020YH\u0016J0\u0010Z\u001a\u00020;2\u0006\u0010[\u001a\u00020\u000b2\u0006\u0010\\\u001a\u00020\b2\u0006\u0010]\u001a\u00020\b2\u0006\u0010^\u001a\u00020\b2\u0006\u0010_\u001a\u00020\bH\u0014J\u0018\u0010`\u001a\u00020;2\u0006\u0010a\u001a\u00020\b2\u0006\u0010b\u001a\u00020\bH\u0014J(\u0010c\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u00102\u0006\u0010d\u001a\u00020\u00132\u0006\u0010e\u001a\u00020\u00132\u0006\u0010f\u001a\u00020\u000bH\u0016J \u0010g\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u00102\u0006\u0010d\u001a\u00020\u00132\u0006\u0010e\u001a\u00020\u0013H\u0016J0\u0010h\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00102\u0006\u0010i\u001a\u00020\b2\u0006\u0010j\u001a\u00020\b2\u0006\u0010f\u001a\u00020k2\u0006\u0010l\u001a\u00020\bH\u0016J8\u0010m\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00102\u0006\u0010n\u001a\u00020\b2\u0006\u0010o\u001a\u00020\b2\u0006\u0010p\u001a\u00020\b2\u0006\u0010q\u001a\u00020\b2\u0006\u0010l\u001a\u00020\bH\u0016J@\u0010m\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00102\u0006\u0010n\u001a\u00020\b2\u0006\u0010o\u001a\u00020\b2\u0006\u0010p\u001a\u00020\b2\u0006\u0010q\u001a\u00020\b2\u0006\u0010l\u001a\u00020\b2\u0006\u0010f\u001a\u00020kH\u0016J(\u0010r\u001a\u00020;2\u0006\u0010s\u001a\u00020\u00102\u0006\u0010<\u001a\u00020\u00102\u0006\u0010t\u001a\u00020\b2\u0006\u0010l\u001a\u00020\bH\u0016J(\u0010u\u001a\u00020\u000b2\u0006\u0010s\u001a\u00020\u00102\u0006\u0010<\u001a\u00020\u00102\u0006\u0010t\u001a\u00020\b2\u0006\u0010l\u001a\u00020\bH\u0016J\u0018\u0010v\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00102\u0006\u0010l\u001a\u00020\bH\u0016J\u0010\u0010w\u001a\u00020\u000b2\u0006\u0010x\u001a\u00020YH\u0016J \u0010y\u001a\u00020\u00132\u0006\u0010z\u001a\u00020\u00132\u0006\u0010{\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u000e\u0010|\u001a\u00020;2\u0006\u0010}\u001a\u00020\bJ\u000e\u0010~\u001a\u00020;2\u0006\u0010}\u001a\u00020\bJ\u0010\u0010\u007f\u001a\u00020;2\b\u0010\u0080\u0001\u001a\u00030\u0081\u0001J\u000e\u0010\u007f\u001a\u00020;2\u0006\u0010}\u001a\u00020\bJ>\u0010\u0082\u0001\u001a\u00020;2\f\b\u0002\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u00012\f\b\u0002\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0084\u00012\f\b\u0002\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0084\u00012\u000b\b\u0002\u0010O\u001a\u0005\u0018\u00010\u0084\u0001J\u000f\u0010\u0087\u0001\u001a\u00020;2\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0088\u0001\u001a\u00020;2\u0007\u0010\u0089\u0001\u001a\u00020\u0013J\u0010\u0010\u008a\u0001\u001a\u00020;2\u0007\u0010\u008b\u0001\u001a\u00020\bJ\u0010\u0010\u008c\u0001\u001a\u00020;2\u0007\u0010\u008d\u0001\u001a\u00020\u000bJ\u001d\u0010\u008e\u0001\u001a\u00020;2\u0014\u0010\u008f\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020;0\u0090\u0001J\u0012\u0010\u008e\u0001\u001a\u00020;2\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010'J)\u0010\u0092\u0001\u001a\u00020;2 \u0010\u008f\u0001\u001a\u001b\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020;0\u0093\u0001J\u0012\u0010\u0092\u0001\u001a\u00020;2\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010)J\u0010\u0010\u0094\u0001\u001a\u00020;2\u0007\u0010\u0095\u0001\u001a\u000201J\u0012\u0010\u0096\u0001\u001a\u00020;2\u0007\u0010\u0097\u0001\u001a\u00020\rH\u0002J\u000f\u0010\u0098\u0001\u001a\u00020;2\u0006\u00109\u001a\u00020\u0013J\t\u0010\u0099\u0001\u001a\u00020;H\u0002J\u0012\u0010\u009a\u0001\u001a\u00020;2\u0007\u0010\u009b\u0001\u001a\u00020\u000bH\u0002J\t\u0010\u009c\u0001\u001a\u00020;H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001a\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001e\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001bR\u000e\u0010\u001f\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001b\"\u0004\b.\u0010/R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u00105\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b6\u00107R\u000e\u00108\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u009e\u0001"}, d2 = {"Lcom/obric/oui/pullrefresh/OPullRefreshLayout;", "Landroid/view/ViewGroup;", "Landroidx/core/view/NestedScrollingParent3;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "_isAnimatingOffset", "", "_state", "Lcom/obric/oui/pullrefresh/RefreshState;", "contentOriginalLayerType", "contentView", "Landroid/view/View;", "currentOffset", "dragDamping", "", "headerHeight", "headerInsetStart", "headerOriginalLayerType", "headerView", "initialDownX", "initialDownY", "isAnimatingOffset", "()Z", "isBeingDragged", "isPerformedHapticFeedback", "isRefreshing", "lastMotionY", "lastOnPullingDispatchTime", "", "layerTypeOverriddenForAnimation", "nestedScrollEnabledWhileAnimatingOffset", "offsetAnimationManager", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "onRefreshListener", "Lcom/obric/oui/pullrefresh/OnRefreshListener;", "onStateChangeListener", "Lcom/obric/oui/pullrefresh/OnStateChangeListener;", "parentHelper", "Landroidx/core/view/NestedScrollingParentHelper;", "refreshEnable", "getRefreshEnable", "setRefreshEnable", "(Z)V", "refreshHeader", "Lcom/obric/oui/pullrefresh/header/ORefreshHeader;", "rubberRemainder", "scrollChild", "selfOriginalLayerType", "state", "getState", "()Lcom/obric/oui/pullrefresh/RefreshState;", "touchSlop", "triggerRate", "animateOffsetTo", "", "target", "endAction", "Lkotlin/Function0;", "applyCurrentOffsetToTranslation", "autoRefresh", "canScrollUpInner", "checkLayoutParams", "p", "Landroid/view/ViewGroup$LayoutParams;", "computeRubberIncrement", PerfConsts.KEY_CURRENT_GALVANIC, "deltaPull", "dispatchOnPullingThrottled", "fraction", "offsetY", "ensureContentView", "findScrollableChild", "root", "finishRefresh", "success", "finishSpinner", "generateDefaultLayoutParams", "generateLayoutParams", "getNestedScrollAxes", "moveSpinner", "targetOffset", "onFinishInflate", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onNestedFling", "velocityX", "velocityY", "consumed", "onNestedPreFling", "onNestedPreScroll", "dx", "dy", "", "type", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScrollAccepted", "child", "axes", "onStartNestedScroll", "onStopNestedScroll", "onTouchEvent", "event", "rubberMap", RealFpsTracer.SCROLL_DISTANCE, "maxDistance", "setDefaultHeaderIconColor", "color", "setDefaultHeaderProgressBackgroundColor", "setDefaultHeaderTextColor", "colors", "Landroid/content/res/ColorStateList;", "setDefaultHeaderTexts", "pull", "", "release", "refreshing", "setDragDamping", "setHeaderInsetStartDp", "headerInsetStartDp", "setHeaderInsetStartPx", "headerInsetStartPx", "setNestedScrollEnabledWhileAnimatingOffset", IndexDatabaseHelper.IndexColumns.ENABLED, "setOnRefreshListener", "block", "Lkotlin/Function1;", "listener", "setOnStateChangeListener", "Lkotlin/Function3;", "setRefreshHeader", "header", "setState", "newState", "setTriggerRate", "startRefreshing", "updateLayerTypeForAnimation", "enable", "updateStateByOffset", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPullRefreshLayout extends ViewGroup implements NestedScrollingParent3 {
    public static final Companion Companion = null;
    private static final int MIN_OFFSET_FOR_ANIMATION_PX = 2;
    private static final long ON_PULLING_MIN_INTERVAL_MS = 16;
    private boolean _isAnimatingOffset;
    private RefreshState _state;
    private int contentOriginalLayerType;
    private View contentView;
    private int currentOffset;
    private float dragDamping;
    private int headerHeight;
    private int headerInsetStart;
    private int headerOriginalLayerType;
    private View headerView;
    private float initialDownX;
    private float initialDownY;
    private boolean isBeingDragged;
    private boolean isPerformedHapticFeedback;
    private float lastMotionY;
    private long lastOnPullingDispatchTime;
    private boolean layerTypeOverriddenForAnimation;
    private boolean nestedScrollEnabledWhileAnimatingOffset;
    private AnimationManager offsetAnimationManager;
    private OnRefreshListener onRefreshListener;
    private OnStateChangeListener onStateChangeListener;
    private final NestedScrollingParentHelper parentHelper;
    private boolean refreshEnable;
    private ORefreshHeader refreshHeader;
    private float rubberRemainder;
    private View scrollChild;
    private int selfOriginalLayerType;
    private final int touchSlop;
    private float triggerRate;

    /* JADX INFO: compiled from: OPullRefreshLayout.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/pullrefresh/OPullRefreshLayout$Companion;", "", "()V", "MIN_OFFSET_FOR_ANIMATION_PX", "", "ON_PULLING_MIN_INTERVAL_MS", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void $r8$lambda$6A0zgmJXTW6WpQ1j3818fXwnOaM(OPullRefreshLayout r0, boolean r1) {
        m1324finishRefresh$lambda8(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$EV9ERZ5bsgOFkCCyo31yccQBufY(OPullRefreshLayout r0) {
        m1323autoRefresh$lambda7(r0);
    }

    static {
        Companion = new Companion(null);
    }

    public OPullRefreshLayout(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OPullRefreshLayout(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View r1, float r2, float r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "target");
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View r1, float r2, float r3) {
        Intrinsics.checkNotNullParameter(r1, "target");
        return false;
    }

    public /* synthetic */ OPullRefreshLayout(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ void access$moveSpinner(OPullRefreshLayout r0, int r1) {
        r0.moveSpinner(r1);
    }

    public static final /* synthetic */ void access$setOffsetAnimationManager$p(OPullRefreshLayout r0, AnimationManager r1) {
        r0.offsetAnimationManager = r1;
    }

    public static final /* synthetic */ void access$setState(OPullRefreshLayout r0, RefreshState r1) {
        r0.setState(r1);
    }

    public static final /* synthetic */ void access$set_isAnimatingOffset$p(OPullRefreshLayout r0, boolean r1) {
        r0._isAnimatingOffset = r1;
    }

    public static final /* synthetic */ void access$updateLayerTypeForAnimation(OPullRefreshLayout r0, boolean r1) {
        r0.updateLayerTypeForAnimation(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OPullRefreshLayout(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.parentHelper = new NestedScrollingParentHelper(this);
        this.dragDamping = 0.8f;
        this.triggerRate = 1.0f;
        this._state = RefreshState.IDLE;
        this.touchSlop = ViewConfiguration.get(r10).getScaledTouchSlop();
        this.nestedScrollEnabledWhileAnimatingOffset = true;
        this.refreshEnable = true;
        setChildrenDrawingOrderEnabled(true);
        setClipToPadding(true);
        setClipChildren(true);
        AttributeSet r3 = null;
        Object[] r4 = 0;
        if (r11 == null) goto L25;
        TypedArray r13 = r10.obtainStyledAttributes(r11, R.styleable.OPullRefreshLayout, r12, 0);
        Intrinsics.checkNotNullExpressionValue(r13, "context.obtainStyledAttr…          0\n            )");
        this.dragDamping = RangesKt.coerceIn(r13.getFloat(R.styleable.OPullRefreshLayout_o_pr_dragDamping, 0.8f), 0.2f, 1.0f);
        this.triggerRate = RangesKt.coerceAtLeast(r13.getFloat(R.styleable.OPullRefreshLayout_o_pr_triggerRate, 1.0f), 0.5f);
        this.headerInsetStart = r13.getDimensionPixelOffset(R.styleable.OPullRefreshLayout_o_pr_headerInsetStart, 0);
        this.refreshEnable = r13.getBoolean(R.styleable.OPullRefreshLayout_o_pr_refreshEnable, true);
        String r14 = r13.getString(R.styleable.OPullRefreshLayout_o_pr_defaultHeaderTextPull);
        String r0 = r13.getString(R.styleable.OPullRefreshLayout_o_pr_defaultHeaderTextRelease);
        String r1 = r13.getString(R.styleable.OPullRefreshLayout_o_pr_defaultHeaderTextRefreshing);
        String r2 = r13.getString(R.styleable.OPullRefreshLayout_o_pr_defaultHeaderTextSuccess);
        if (r13.hasValue(R.styleable.OPullRefreshLayout_o_pr_defaultHeaderTextColor) == false) goto L7;
        Integer r5 = Integer.valueOf(r13.getColor(R.styleable.OPullRefreshLayout_o_pr_defaultHeaderTextColor, 0));
    L9:
        if (r13.hasValue(R.styleable.OPullRefreshLayout_o_pr_defaultHeaderIconColor) == false) goto L11;
        Integer r6 = Integer.valueOf(r13.getColor(R.styleable.OPullRefreshLayout_o_pr_defaultHeaderIconColor, 0));
    L13:
        if (r13.hasValue(R.styleable.OPullRefreshLayout_o_pr_defaultHeaderProgressBackgroundColor) == false) goto L15;
        Integer r7 = Integer.valueOf(r13.getColor(R.styleable.OPullRefreshLayout_o_pr_defaultHeaderProgressBackgroundColor, 0));
    L16:
        int r8 = r13.getResourceId(R.styleable.OPullRefreshLayout_o_pr_headerView, 0);
        r13.recycle();
        if (r8 == 0) goto L27;
        final View r15 = ViewGroup.inflate(r10, r8, null);
        if ((r15 instanceof ORefreshHeader) == false) goto L21;
        ORefreshHeader r9 = (ORefreshHeader) r15;
    L22:
        if (r9 == null) goto L24;
        setRefreshHeader(r9);
        goto L27
    L24:
        setRefreshHeader(new AnonymousClass1(r15));
        goto L27
    L21:
        r9 = null;
    L27:
        if (this.refreshHeader != null) goto L29;
        setRefreshHeader(new ODefaultRefreshHeader(r10, r3, 2, r4 == true ? 1 : 0));
    L29:
        setDefaultHeaderTexts(r14, r0, r1, r2);
        if (r5 == null) goto L33;
        setDefaultHeaderTextColor(r5.intValue());
    L33:
        if (r7 == null) goto L36;
        setDefaultHeaderProgressBackgroundColor(r7.intValue());
    L36:
        if (r6 == null) goto L40;
        setDefaultHeaderIconColor(r6.intValue());
        return;
    L40:
        return;
    L15:
        r7 = null;
        goto L16
    L11:
        r6 = null;
        goto L13
    L7:
        r5 = null;
        goto L9
    L25:
        r14 = null;
        r0 = null;
        r1 = null;
        r2 = null;
        r5 = null;
        r6 = null;
        r7 = null;
        goto L27
    }

    public final RefreshState getState() {
        return this._state;
    }

    public final boolean isAnimatingOffset() {
        return this._isAnimatingOffset;
    }

    public final boolean getRefreshEnable() {
        return this.refreshEnable;
    }

    public final void setRefreshEnable(boolean r1) {
        this.refreshEnable = r1;
    }

    public final void setDragDamping(float r1) {
        this.dragDamping = r1;
    }

    public final void setTriggerRate(float r1) {
        this.triggerRate = r1;
    }

    public final void setHeaderInsetStartDp(float r2) {
        this.headerInsetStart = OUnitExtensionKt.vdp(this, r2);
    }

    public final void setHeaderInsetStartPx(int r1) {
        this.headerInsetStart = r1;
    }

    public final void setOnRefreshListener(OnRefreshListener r1) {
        this.onRefreshListener = r1;
    }

    public final void setOnRefreshListener(Function1<? super OPullRefreshLayout, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "block");
        this.onRefreshListener = new OPullRefreshLayout$sam$com_obric_oui_pullrefresh_OnRefreshListener$0(r2);
    }

    public final void setOnStateChangeListener(OnStateChangeListener r1) {
        this.onStateChangeListener = r1;
    }

    public final void setOnStateChangeListener(Function3<? super OPullRefreshLayout, ? super RefreshState, ? super RefreshState, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "block");
        this.onStateChangeListener = new OPullRefreshLayout$sam$com_obric_oui_pullrefresh_OnStateChangeListener$0(r2);
    }

    public final void setRefreshHeader(ORefreshHeader r2) {
        Intrinsics.checkNotNullParameter(r2, "header");
        View r0 = this.headerView;
        if (r0 == null) goto L6;
        removeView(r0);
    L6:
        this.refreshHeader = r2;
        View r3 = r2.getView();
        this.headerView = r3;
        addView(r3, 0);
        requestLayout();
    }

    public static /* synthetic */ void setDefaultHeaderTexts$default(OPullRefreshLayout r1, CharSequence r2, CharSequence r3, CharSequence r4, CharSequence r5, int r6, Object r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        r1.setDefaultHeaderTexts(r2, r3, r4, r5);
    }

    public final void setDefaultHeaderTexts(CharSequence r2, CharSequence r3, CharSequence r4, CharSequence r5) {
        ORefreshHeader r1 = this.refreshHeader;
        if ((r1 instanceof ODefaultRefreshHeader) == false) goto L5;
        ODefaultRefreshHeader r6 = (ODefaultRefreshHeader) r1;
    L6:
        if (r6 == null) goto L10;
        r6.setTexts(r2, r3, r4, r5);
        return;
    L10:
        return;
    L5:
        r6 = null;
        goto L6
    }

    public final void setDefaultHeaderTextColor(int r2) {
        ORefreshHeader r1 = this.refreshHeader;
        if ((r1 instanceof ODefaultRefreshHeader) == false) goto L5;
        ODefaultRefreshHeader r3 = (ODefaultRefreshHeader) r1;
    L6:
        if (r3 == null) goto L10;
        r3.setTextColor(r2);
        return;
    L10:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void setDefaultHeaderTextColor(ColorStateList r2) {
        Intrinsics.checkNotNullParameter(r2, "colors");
        ORefreshHeader r1 = this.refreshHeader;
        if ((r1 instanceof ODefaultRefreshHeader) == false) goto L5;
        ODefaultRefreshHeader r3 = (ODefaultRefreshHeader) r1;
    L6:
        if (r3 == null) goto L10;
        r3.setTextColor(r2);
        return;
    L10:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void setDefaultHeaderIconColor(int r2) {
        ORefreshHeader r1 = this.refreshHeader;
        if ((r1 instanceof ODefaultRefreshHeader) == false) goto L5;
        ODefaultRefreshHeader r3 = (ODefaultRefreshHeader) r1;
    L6:
        if (r3 == null) goto L10;
        r3.setIconColor(r2);
        return;
    L10:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void setDefaultHeaderProgressBackgroundColor(int r2) {
        ORefreshHeader r1 = this.refreshHeader;
        if ((r1 instanceof ODefaultRefreshHeader) == false) goto L5;
        ODefaultRefreshHeader r3 = (ODefaultRefreshHeader) r1;
    L6:
        if (r3 == null) goto L10;
        r3.setProgressBackgroundColor(r2);
        return;
    L10:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final boolean isRefreshing() {
        if (this._state != RefreshState.REFRESHING) goto L5;
        return true;
    L5:
        return false;
    }

    public final void setNestedScrollEnabledWhileAnimatingOffset(boolean r1) {
        this.nestedScrollEnabledWhileAnimatingOffset = r1;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        ensureContentView();
        this.scrollChild = findScrollableChild(this.contentView);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return new ViewGroup.MarginLayoutParams(r1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r2) {
        return new ViewGroup.MarginLayoutParams(getContext(), r2);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return r1 instanceof ViewGroup.MarginLayoutParams;
    }

    @Override // android.view.View
    protected void onMeasure(int r5, int r6) {
        super.onMeasure(r5, r6);
        ensureContentView();
        int r0 = getMeasuredWidth();
        int r1 = getMeasuredHeight();
        if (r0 == 0) goto L19;
        if (r1 == 0) goto L21;
        int r2 = View.MeasureSpec.makeMeasureSpec((r0 - getPaddingLeft()) - getPaddingRight(), 1073741824);
        int r3 = View.MeasureSpec.makeMeasureSpec((r1 - getPaddingTop()) - getPaddingBottom(), 1073741824);
        View r4 = this.contentView;
        if (r4 == null) goto L10;
        r4.measure(r2, r3);
    L10:
        View r7 = this.headerView;
        if (r7 == null) goto L20;
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        if (r8 == null) goto L18;
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) r8;
        r7.measure(ViewGroup.getChildMeasureSpec(r5, ((getPaddingLeft() + getPaddingRight()) + r9.leftMargin) + r9.rightMargin, r9.width), ViewGroup.getChildMeasureSpec(r6, ((getPaddingTop() + getPaddingBottom()) + r9.topMargin) + r9.bottomMargin, r9.height));
        this.headerHeight = r7.getMeasuredHeight();
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L20:
        return;
    L21:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r7, int r8, int r9, int r10, int r11) {
        ensureContentView();
        int r12 = getMeasuredWidth();
        int r13 = getMeasuredHeight();
        if (r12 == 0) goto L24;
        if (r13 == 0) goto L25;
        int r14 = getPaddingLeft();
        int r15 = getPaddingTop();
        int r16 = r12 - getPaddingRight();
        int r17 = r13 - getPaddingBottom();
        View r18 = this.headerView;
        if (r18 == null) goto L12;
        ViewGroup.LayoutParams r1 = r18.getLayoutParams();
        if (r1 == null) goto L23;
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
        int r3 = r18.getMeasuredHeight();
        int r4 = r2.leftMargin + r14;
        int r5 = ((r15 - r3) + this.headerInsetStart) + r2.topMargin;
        r18.layout(r4, r5, r18.getMeasuredWidth() + r4, r3 + r5);
        goto L12
    L23:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L12:
        View r19 = this.contentView;
        if (r19 == null) goto L18;
        ViewGroup.LayoutParams r6 = r19.getLayoutParams();
        if (r6 == null) goto L21;
        ViewGroup.MarginLayoutParams r20 = (ViewGroup.MarginLayoutParams) r6;
        r19.layout(r14 + r20.leftMargin, r15 + r20.topMargin, r16 - r20.rightMargin, r17 - r20.bottomMargin);
        goto L18
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L18:
        applyCurrentOffsetToTranslation();
        return;
    L25:
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View r1, View r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "child");
        Intrinsics.checkNotNullParameter(r2, "target");
        if (isEnabled() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.refreshEnable == false) goto L9;
        if ((r3 & 2) == 0) goto L9;
        return true;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View r2, View r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "child");
        Intrinsics.checkNotNullParameter(r3, "target");
        this.parentHelper.onNestedScrollAccepted(r2, r3, r4, r5);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "target");
        this.parentHelper.onStopNestedScroll(r2, r3);
        if (r3 == 0) goto L5;
        return;
    L5:
        if (this._state == RefreshState.REFRESHING) goto L9;
        finishSpinner();
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View r1, int r2, int r3, int[] r4, int r5) {
        Intrinsics.checkNotNullParameter(r1, "target");
        Intrinsics.checkNotNullParameter(r4, "consumed");
        if (r5 == 0) goto L6;
        return;
    L6:
        if (this.refreshEnable == true) goto L9;
        return;
    L9:
        if (this.nestedScrollEnabledWhileAnimatingOffset == true) goto L14;
        if (this._isAnimatingOffset == false) goto L14;
        return;
    L14:
        if (r3 <= 0) goto L18;
        int r6 = this.currentOffset;
        if (r6 <= 0) goto L18;
        int r7 = Math.min(r3, r6);
        moveSpinner(this.currentOffset - r7);
        r4[1] = r7;
    L18:
        if (r3 < 0) goto L20;
        return;
    L20:
        if (canScrollUpInner() == false) goto L22;
        return;
    L22:
        if (this._state == RefreshState.REFRESHING) goto L29;
        int r8 = computeRubberIncrement(this.currentOffset, Math.abs(r3));
        if (r8 <= 0) goto L30;
        moveSpinner(this.currentOffset + r8);
        r4[1] = r3;
        return;
    L30:
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View r10, int r11, int r12, int r13, int r14, int r15) {
        Intrinsics.checkNotNullParameter(r10, "target");
        onNestedScroll(r10, r11, r12, r13, r14, r15, new int[2]);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View r1, int r2, int r3, int r4, int r5, int r6, int[] r7) {
        Intrinsics.checkNotNullParameter(r1, "target");
        Intrinsics.checkNotNullParameter(r7, "consumed");
        if (r6 == 0) goto L6;
        return;
    L6:
        if (this.refreshEnable == true) goto L9;
        return;
    L9:
        if (this.nestedScrollEnabledWhileAnimatingOffset == false) goto L11;
    L13:
        if (r5 < 0) goto L15;
        return;
    L15:
        if (canScrollUpInner() == false) goto L17;
        return;
    L17:
        if (isRefreshing() == true) goto L24;
        int r8 = computeRubberIncrement(this.currentOffset, Math.abs(r5));
        if (r8 <= 0) goto L25;
        moveSpinner(this.currentOffset + r8);
        r7[1] = r7[1] + r5;
        return;
    L25:
        return;
    L24:
        return;
    L11:
        if (this._isAnimatingOffset == false) goto L13;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.parentHelper.getNestedScrollAxes();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r7, "ev");
        boolean r1 = false;
        if (isEnabled() == true) goto L5;
    L57:
        return false;
    L5:
        if (this.refreshEnable == false) goto L57;
        int r0 = r7.getActionMasked();
        if (r0 != 0) goto L10;
        this.isBeingDragged = false;
        this.initialDownY = r7.getY();
        this.initialDownX = r7.getX();
        this.lastMotionY = this.initialDownY;
    L56:
        return this.isBeingDragged;
    L10:
        if (r0 != 1) goto L12;
    L53:
        this.isBeingDragged = false;
        goto L56
    L12:
        if (r0 == 2) goto L17;
        if (r0 == 3) goto L53;
    L17:
        if (this.isBeingDragged == true) goto L56;
        float r2 = r7.getY() - this.initialDownY;
        float r3 = r7.getX() - this.initialDownX;
        float r4 = Math.abs(r2);
        float r5 = Math.abs(r3);
        if (r4 <= this.touchSlop) goto L56;
        if (r4 <= r5) goto L56;
        if (this.scrollChild != null) goto L25;
    L28:
        boolean r6 = true;
    L30:
        if (r2 <= 0.0f) goto L32;
        boolean r8 = true;
    L34:
        if (r2 < 0.0f) goto L36;
    L38:
        boolean r9 = false;
    L40:
        if ((this.scrollChild instanceof NestedScrollingChild) == true) goto L42;
    L44:
        if (r8 == false) goto L47;
        if (r1 == true) goto L47;
        if (r6 == false) goto L47;
    L49:
        this.isBeingDragged = true;
        this.lastMotionY = r7.getY();
        ViewParent r10 = getParent();
        if (r10 == null) goto L56;
        r10.requestDisallowInterceptTouchEvent(true);
    L47:
        if (r9 == false) goto L56;
        if (r1 == true) goto L56;
    L42:
        if ((this.contentView instanceof CoordinatorLayout) == true) goto L44;
        r1 = true;
        goto L44
    L36:
        if (this.currentOffset <= 0) goto L38;
        r9 = true;
        goto L40
    L32:
        r8 = false;
        goto L34
    L25:
        if (canScrollUpInner() == false) goto L28;
        r6 = false;
        goto L30
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        if (isEnabled() == false) goto L62;
        if (this.refreshEnable == false) goto L62;
        int r0 = r10.getActionMasked();
        if (r0 == 0) goto L59;
        if (r0 == 1) goto L52;
        if (r0 != 2) goto L13;
        float r1 = r10.getY();
        float r3 = r1 - this.lastMotionY;
        this.lastMotionY = r1;
        if (this.isBeingDragged == true) goto L32;
        float r4 = r1 - this.initialDownY;
        float r6 = r10.getX() - this.initialDownX;
        float r7 = Math.abs(r4);
        float r8 = Math.abs(r6);
        if (r7 <= this.touchSlop) goto L32;
        if (r7 <= r8) goto L32;
        if (r4 <= 0.0f) goto L32;
        if (this.scrollChild != null) goto L26;
    L27:
        this.isBeingDragged = true;
        this.lastMotionY = r1;
        ViewParent r2 = getParent();
        if (r2 == null) goto L32;
        r2.requestDisallowInterceptTouchEvent(true);
        goto L32
    L26:
        if (canScrollUpInner() == false) goto L27;
    L32:
        if (this.isBeingDragged == true) goto L34;
    L58:
        return super.onTouchEvent(r10);
    L34:
        if (r3 < 0.0f) goto L36;
    L38:
        if (r3 >= 0.0f) goto L48;
        int r11 = Math.min((int) Math.abs(r3), this.currentOffset);
        if (r11 <= 0) goto L42;
        moveSpinner(this.currentOffset - r11);
    L42:
        this.rubberRemainder = 0.0f;
        if (((int) Math.abs(r3)) <= r11) goto L46;
        this.isBeingDragged = false;
        return false;
    L46:
        return true;
    L48:
        if (isRefreshing() == true) goto L50;
        int r12 = this.currentOffset;
        moveSpinner(r12 + computeRubberIncrement(r12, r3));
    L50:
        return true;
    L36:
        if (this.currentOffset > 0) goto L38;
        return false;
    L13:
        if (r0 != 3) goto L58;
    L52:
        if (this.isBeingDragged == false) goto L58;
        this.isBeingDragged = false;
        if (this._state == RefreshState.REFRESHING) goto L56;
        finishSpinner();
    L56:
        return true;
    L59:
        this.isBeingDragged = false;
        this.initialDownY = r10.getY();
        this.initialDownX = r10.getX();
        this.lastMotionY = this.initialDownY;
        return true;
    L62:
        return super.onTouchEvent(r10);
    }

    private final void setState(RefreshState r3) {
        RefreshState r0 = this._state;
        if (r0 != r3) goto L5;
        return;
    L5:
        this._state = r3;
        ORefreshHeader r1 = this.refreshHeader;
        if (r1 == null) goto L9;
        r1.onStateChanged(this, r0, r3);
    L9:
        OnStateChangeListener r2 = this.onStateChangeListener;
        if (r2 == null) goto L14;
        r2.onStateChanged(this, r0, r3);
        return;
    }

    private final void updateStateByOffset() {
        if (this._state != RefreshState.REFRESHING) goto L5;
        return;
    L5:
        if (this._state == RefreshState.FINISH) goto L19;
        int r0 = (int) (this.headerHeight * this.triggerRate);
        int r1 = this.currentOffset;
        if (r1 > 0) goto L10;
        RefreshState r2 = RefreshState.IDLE;
    L16:
        setState(r2);
        return;
    L10:
        if (r1 >= r0) goto L13;
        this.isPerformedHapticFeedback = false;
        r2 = RefreshState.PULL_TO_REFRESH;
        goto L16
    L13:
        if (this.isPerformedHapticFeedback == true) goto L15;
        this.isPerformedHapticFeedback = true;
        VibratorSmt.INSTANCE.performHapticFeedbackAOSP(this, 4);
    L15:
        r2 = RefreshState.RELEASE_TO_REFRESH;
        goto L16
    }

    private final void finishSpinner() {
        int r0 = this.headerHeight;
        if (r0 > 0) goto L6;
        return;
    L6:
        if (this.currentOffset >= ((int) (r0 * this.triggerRate))) goto L8;
    L12:
        animateOffsetTo(0, new C03021(this));
        return;
    L8:
        if (this._state != RefreshState.RELEASE_TO_REFRESH) goto L10;
    L11:
        startRefreshing();
        return;
    L10:
        if (this._state != RefreshState.PULL_TO_REFRESH) goto L12;
        goto L11
    }

    public final void autoRefresh() {
        if (this.refreshEnable == true) goto L6;
        return;
    L6:
        if (this._state != RefreshState.REFRESHING) goto L9;
        return;
    L9:
        if (ViewCompat.isLaidOut(this) == true) goto L12;
        post(new OPullRefreshLayout$$ExternalSyntheticLambda0(this));
        return;
    L12:
        startRefreshing();
    }

    /* JADX INFO: renamed from: autoRefresh$lambda-7, reason: not valid java name */
    private static final void m1323autoRefresh$lambda7(OPullRefreshLayout r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.autoRefresh();
    }

    private final void startRefreshing() {
        if (this.headerHeight > 0) goto L11;
        View r0 = this.headerView;
        if (r0 != null) goto L7;
        int r1 = 0;
    L8:
        this.headerHeight = r1;
        if (r1 > 0) goto L11;
        return;
    L7:
        r1 = r0.getMeasuredHeight();
    L11:
        setState(RefreshState.REFRESHING);
        animateOffsetTo(this.headerHeight, null);
        OnRefreshListener r2 = this.onRefreshListener;
        if (r2 == null) goto L16;
        r2.onRefresh(this);
        return;
    }

    public static /* synthetic */ void finishRefresh$default(OPullRefreshLayout r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        r0.finishRefresh(r1);
    }

    public final void finishRefresh(final boolean r4) {
        if (this._state != RefreshState.REFRESHING) goto L5;
    L7:
        setState(RefreshState.FINISH);
        postDelayed(new OPullRefreshLayout$$ExternalSyntheticLambda1(this, r4), 200);
        return;
    L5:
        if (this._state == RefreshState.RELEASE_TO_REFRESH) goto L7;
    }

    /* JADX INFO: renamed from: finishRefresh$lambda-8, reason: not valid java name */
    private static final void m1324finishRefresh$lambda8(final OPullRefreshLayout r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        ORefreshHeader r0 = r1.refreshHeader;
        if (r0 == null) goto L6;
        r0.onFinish(r1, r2);
    L6:
        r1.animateOffsetTo(0, new OPullRefreshLayout$finishRefresh$1$1(r1));
    }

    private final void moveSpinner(int r3) {
        int r4 = Math.max(0, r3);
        if (r4 != this.currentOffset) goto L5;
        return;
    L5:
        this.currentOffset = r4;
        applyCurrentOffsetToTranslation();
        int r5 = this.headerHeight;
        if (r5 <= 0) goto L9;
        dispatchOnPullingThrottled(RangesKt.coerceIn(this.currentOffset / r5, 0.0f, 1.0f), this.currentOffset, this.headerHeight);
    L9:
        if (this._state == RefreshState.REFRESHING) goto L11;
    L14:
        updateStateByOffset();
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L11:
        if (this.currentOffset != 0) goto L14;
        finishRefresh(true);
        ViewCompat.postInvalidateOnAnimation(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void animateOffsetTo$default(OPullRefreshLayout r0, int r1, Function0 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.animateOffsetTo(r1, r2);
    }

    private final void animateOffsetTo(int r13, final Function0<Unit> r14) {
        int r0 = this.currentOffset;
        if (r0 != r13) goto L8;
        if (r14 == null) goto L30;
        r14.invoke();
        return;
    L30:
        return;
    L8:
        int r1 = Math.abs(r0 - r13);
        if (ViewCompat.isLaidOut(this) == true) goto L11;
    L21:
        AnimationManager r2 = this.offsetAnimationManager;
        if (r2 == null) goto L25;
        AnimationManager.cancelAnimation$default(r2, false, 1, null);
    L25:
        moveSpinner(r13);
        if (r14 == null) goto L31;
        r14.invoke();
        return;
    L31:
        return;
    L11:
        if (isAttachedToWindow() == false) goto L21;
        if (r1 <= 2) goto L21;
        AnimationManager r3 = this.offsetAnimationManager;
        if (r3 == null) goto L19;
        AnimationManager.cancelAnimation$default(r3, false, 1, null);
    L19:
        this.offsetAnimationManager = ValueAnimatable.Builder.of$default(new ValueAnimatable.Builder(), this.currentOffset, r13, AnimationSpecKt.spring$default(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_2, 0, 4, null), null, 8, null).onUpdate(new C03011(this)).onEnd(new AnonymousClass2(this, r14)).build().start();
        this._isAnimatingOffset = true;
        updateLayerTypeForAnimation(true);
    }

    private final void ensureContentView() {
        if (this.contentView == null) goto L5;
        return;
    L5:
        int r0 = getChildCount();
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L14;
        int r2 = r1 + 1;
        View r3 = getChildAt(r1);
        if (r3 != this.headerView) goto L9;
        r1 = r2;
        goto L6
    L9:
        this.contentView = r3;
        return;
    }

    private final View findScrollableChild(View r5) {
        if (r5 != null) goto L5;
    L24:
        return null;
    L5:
        if (r5 == this.headerView) goto L24;
        if ((r5 instanceof ScrollView) == false) goto L10;
    L23:
        return r5;
    L10:
        if ((r5 instanceof AbsListView) == true) goto L23;
        if ((r5 instanceof NestedScrollingChild) == true) goto L23;
        if ((r5 instanceof ViewGroup) == false) goto L22;
        ViewGroup r6 = (ViewGroup) r5;
        int r1 = r6.getChildCount();
        int r2 = 0;
    L17:
        if (r2 >= r1) goto L22;
        int r3 = r2 + 1;
        View r4 = findScrollableChild(r6.getChildAt(r2));
        if (r4 != null) goto L20;
        r2 = r3;
        goto L17
    L20:
        return r4;
    L22:
        return null;
    }

    private final boolean canScrollUpInner() {
        View r2 = this.scrollChild;
        if (r2 != null) goto L6;
        return false;
    L6:
        if (r2.canScrollVertically(-1) == true) goto L8;
        return false;
    L8:
        return true;
    }

    private final void applyCurrentOffsetToTranslation() {
        float r0 = this.currentOffset;
        View r1 = this.headerView;
        boolean r2 = true;
        if (r1 != null) goto L6;
    L11:
        View r5 = this.contentView;
        if (r5 != null) goto L15;
        return;
    L15:
        if (r5.getTranslationY() == r0) goto L18;
        r2 = false;
    L18:
        if (r2 == true) goto L21;
        r5.setTranslationY(r0);
        return;
    L21:
        return;
    L6:
        if (r1.getTranslationY() != r0) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == true) goto L11;
        r1.setTranslationY(r0);
        goto L11
    L8:
        r4 = false;
        goto L9
    }

    private final void dispatchOnPullingThrottled(float r7, int r8, int r9) {
        long r0 = SystemClock.uptimeMillis();
        if ((r0 - this.lastOnPullingDispatchTime) >= 16) goto L8;
        if (r8 == 0) goto L8;
        if (r8 == r9) goto L8;
        boolean r2 = false;
    L9:
        if (r2 == true) goto L11;
        return;
    L11:
        this.lastOnPullingDispatchTime = r0;
        ORefreshHeader r1 = this.refreshHeader;
        if (r1 == null) goto L16;
        r1.onPulling(this, r7, r8, r9);
        return;
    L16:
        return;
    L8:
        r2 = true;
        goto L9
    }

    private final void updateLayerTypeForAnimation(boolean r5) {
        View r0 = this.headerView;
        View r1 = this.contentView;
        int r2 = 0;
        if (r5 == false) goto L23;
        if (this.layerTypeOverriddenForAnimation == true) goto L15;
        this.layerTypeOverriddenForAnimation = true;
        this.selfOriginalLayerType = getLayerType();
        if (r0 != null) goto L9;
        int r6 = 0;
    L10:
        this.headerOriginalLayerType = r6;
        if (r1 == null) goto L14;
        r2 = r1.getLayerType();
    L14:
        this.contentOriginalLayerType = r2;
        goto L15
    L9:
        r6 = r0.getLayerType();
    L15:
        setLayerType(2, null);
        if (r0 == null) goto L19;
        r0.setLayerType(2, null);
    L19:
        if (r1 == null) goto L34;
        r1.setLayerType(2, null);
        return;
    L34:
        return;
    L23:
        if (this.layerTypeOverriddenForAnimation == false) goto L33;
        this.layerTypeOverriddenForAnimation = false;
        setLayerType(this.selfOriginalLayerType, null);
        if (r0 == null) goto L28;
        r0.setLayerType(this.headerOriginalLayerType, null);
    L28:
        if (r1 == null) goto L35;
        r1.setLayerType(this.contentOriginalLayerType, null);
        return;
    L35:
        return;
    }

    private final int computeRubberIncrement(int r3, float r4) {
        int r0 = this.headerHeight;
        if (r0 <= 0) goto L5;
        float r1 = r0 * 2.0f;
    L6:
        float r5 = r3;
        float r6 = (rubberMap(RangesKt.coerceAtLeast(r5 + r4, 0.0f), r1, this.dragDamping) - rubberMap(r5, r1, this.dragDamping)) + this.rubberRemainder;
        int r7 = (int) r6;
        this.rubberRemainder = r6 - r7;
        return r7;
    L5:
        r1 = RangesKt.coerceAtLeast(getMeasuredHeight() * 2.0f, 1.0f);
        goto L6
    }

    private final float rubberMap(float r2, float r3, float r4) {
        float r1 = RangesKt.coerceIn(r4, 0.01f, 1.0f);
        float r5 = Math.max(1.0f, r3);
        return (1.0f - (1.0f / (((r2 * r1) / r5) + 1.0f))) * r5;
    }
}
