package com.obric.oui.bouncelayout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.HorizontalScrollView;
import androidx.core.widget.NestedScrollView;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.trace.fps.RealFpsTracer;
import com.bytedanceos.securitycenter.appBgBatteryControl.AppBgBatteryControlDataHelper;
import com.obric.matrix.platform.sdk.ones.safecushion.SafeCushionConstant;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.orecyclerview.base.FluidRubberBand;
import com.obric.oui.orecyclerview.base.FluidSpringBack;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import obric.widget.calendar.MonthWeekEventsView;
import org.lsposed.hiddenapibypass.HiddenApiBypass;

/* JADX INFO: compiled from: BounceEdgeEffect.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b$\u0018\u0000 j2\u00020\u0001:\u0002jkB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020\f2\u0006\u00101\u001a\u000202H\u0016J\u0010\u00103\u001a\u00020\u001c2\u0006\u00104\u001a\u00020\tH\u0002J\b\u00105\u001a\u00020\u001cH\u0016J\u0010\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u000208H\u0002J\b\u00109\u001a\u00020\tH\u0002J\u0010\u0010:\u001a\u00020\t2\u0006\u00104\u001a\u00020\tH\u0002J\b\u0010;\u001a\u00020\tH\u0016J\b\u0010<\u001a\u00020\tH\u0002J\b\u0010=\u001a\u00020\fH\u0016J\u0010\u0010>\u001a\u00020\f2\u0006\u00104\u001a\u00020\tH\u0002J\u0010\u0010?\u001a\u00020\f2\u0006\u0010@\u001a\u00020\u0007H\u0002J\b\u0010A\u001a\u00020\fH\u0002J\u0010\u0010B\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010C\u001a\u00020\u00072\u0006\u00107\u001a\u000208H\u0002J\u0010\u0010D\u001a\u00020\u00072\u0006\u00107\u001a\u000208H\u0002J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u00107\u001a\u000208H\u0002J!\u0010E\u001a\u00020\u001c2\u0006\u0010F\u001a\u00020/2\u000e\b\u0002\u0010G\u001a\b\u0012\u0004\u0012\u00020/0HH\u0082\bJ\u0010\u0010I\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u0010J\u001a\u00020\u001c2\u0006\u0010K\u001a\u00020\u0007H\u0016J\u0010\u0010L\u001a\u00020\u001c2\u0006\u00104\u001a\u00020\tH\u0016J\u0018\u0010L\u001a\u00020\u001c2\u0006\u00104\u001a\u00020\t2\u0006\u0010M\u001a\u00020\tH\u0016J\u0018\u0010N\u001a\u00020\t2\u0006\u00104\u001a\u00020\t2\u0006\u0010M\u001a\u00020\tH\u0016J\b\u0010O\u001a\u00020\u001cH\u0016J \u0010P\u001a\u00020\u001c2\u0006\u00107\u001a\u0002082\u0006\u0010Q\u001a\u00020\u000f2\u0006\u0010R\u001a\u00020\tH\u0002J\u0018\u0010S\u001a\u00020\u001c2\u0006\u00107\u001a\u0002082\u0006\u0010Q\u001a\u00020\u000fH\u0002J\u0010\u0010T\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020/H\u0002J\b\u0010U\u001a\u00020\u001cH\u0002J\u0018\u0010V\u001a\u00020\u001c2\u0006\u00107\u001a\u0002082\u0006\u0010(\u001a\u00020\u0007H\u0002J\u0018\u0010W\u001a\u00020\u001c2\u0006\u0010X\u001a\u00020\u00072\u0006\u0010Y\u001a\u00020\u0007H\u0016J\u0018\u0010+\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\t2\u0006\u0010Z\u001a\u00020\fH\u0002J\u000e\u0010[\u001a\u00020\u001c2\u0006\u0010\\\u001a\u00020\fJ\u0018\u0010]\u001a\u00020\f2\u0006\u0010R\u001a\u00020\t2\u0006\u0010^\u001a\u00020\tH\u0002J \u0010_\u001a\u00020\f2\u0006\u0010R\u001a\u00020\t2\u0006\u0010Q\u001a\u00020\u000f2\u0006\u0010`\u001a\u00020/H\u0002J\u0006\u0010a\u001a\u00020\u001cJ\b\u0010b\u001a\u000208H\u0002J\u0010\u0010c\u001a\u00020\u001c2\u0006\u0010d\u001a\u00020\tH\u0002J\u000e\u0010e\u001a\u00020\u001c2\u0006\u0010f\u001a\u00020\tJ\u0018\u0010g\u001a\u00020\f2\u0006\u00107\u001a\u0002082\u0006\u0010Q\u001a\u00020\u000fH\u0002J\f\u0010h\u001a\u00020\t*\u00020\tH\u0002J\f\u0010i\u001a\u00020\t*\u00020\tH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R(\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010)\u001a\u00020\t2\u0006\u0010(\u001a\u00020\t@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0017\"\u0004\b+\u0010\u0019R\u000e\u0010,\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006l"}, d2 = {"Lcom/obric/oui/bouncelayout/BounceEdgeEffect;", "Landroid/widget/EdgeEffect;", "context", "Landroid/content/Context;", "target", "Landroid/view/View;", "orientation", "", "maxOverscrollPx", "", "(Landroid/content/Context;Landroid/view/View;IF)V", "abruptOppositeDeltaGuardArmed", "", "accumulatedDragDistance", "animationStartTime", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "kotlin.jvm.PlatformType", "lastPullTime", "lastPullTranslation", "lastTouchDeltaX", "getMaxOverscrollPx", "()F", "setMaxOverscrollPx", "(F)V", "onTranslationChanged", "Lkotlin/Function1;", "", "getOnTranslationChanged", "()Lkotlin/jvm/functions/Function1;", "setOnTranslationChanged", "(Lkotlin/jvm/functions/Function1;)V", "pullMultiplier", "pullMultiplierInitialized", "releaseVelocityPxPerMs", "releaseVelocityTime", "sizePx", "springBack", "Lcom/obric/oui/orecyclerview/base/FluidSpringBack;", "value", "translation", "getTranslation", "setTranslation", "useHeightForHorizontalSize", "clearActiveOrientationIfCurrent", AppBgBatteryControlDataHelper.ItemColumns.REASON, "", "draw", "canvas", "Landroid/graphics/Canvas;", "ensurePullMultiplier", "deltaDistance", SafeCushionConstant.FINISH_STATE, "getActiveOrientation", "state", "Lcom/obric/oui/bouncelayout/BounceEdgeEffect$Companion$TargetBounceState;", "getCurrentFrameIntervalMs", "getDeltaPx", "getDistance", "getReleaseVelocityPxPerMs", "isFinished", "isPulling", "isSameAxis", "otherOrientation", "isUnscrollableOnCurrentAxis", "isVerticalOrientation", "lastPullOrientation", "lastPullSign", "logFrame", "operation", "messageProvider", "Lkotlin/Function0;", "markActiveOrientation", "onAbsorb", RealFpsTracer.SCROLL_VELOCITY, "onPull", "displacement", "onPullDistance", "onRelease", "recordPullFrame", "now", "deltaPx", "recordReleaseFrame", "resetInactiveReleaseState", "resetReleaseVelocityTracker", "setActiveOrientation", "setSize", MaterialConfigFormatNames.WIDTH, MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "trackReleaseVelocity", "setUseHeightForHorizontalSize", "enable", "shouldIgnoreAbruptOppositeDelta", "targetAccumulated", "shouldSkipPullInCurrentFrame", "reasonPrefix", "stopAnimationForTouch", "targetState", "updateReleaseVelocity", "newTranslation", "updateTouchDeltaX", "deltaX", "wasOppositeReleasedInSameFrame", "dp", "px", "Companion", ExifInterface.TAG_ORIENTATION, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BounceEdgeEffect extends EdgeEffect {
    public static final Companion Companion = null;
    private static final float MAX_RELEASE_VELOCITY_PX_PER_MS = 20.0f;
    public static final int ORIENTATION_BOTTOM = 1;
    public static final int ORIENTATION_LEFT = 2;
    private static final int ORIENTATION_NONE = -1;
    public static final int ORIENTATION_RIGHT = 3;
    public static final int ORIENTATION_TOP = 0;
    private static final long RELEASE_VELOCITY_VALID_MS = 120;
    public static final String TAG = "BounceEdgeEffect";
    private static final WeakHashMap<View, Companion.TargetBounceState> targetStates = null;
    private boolean abruptOppositeDeltaGuardArmed;
    private float accumulatedDragDistance;
    private long animationStartTime;
    private final DisplayMetrics displayMetrics;
    private long lastPullTime;
    private float lastPullTranslation;
    private float lastTouchDeltaX;
    private float maxOverscrollPx;
    private Function1<? super Float, Unit> onTranslationChanged;
    private final int orientation;
    private float pullMultiplier;
    private boolean pullMultiplierInitialized;
    private float releaseVelocityPxPerMs;
    private long releaseVelocityTime;
    private int sizePx;
    private FluidSpringBack springBack;
    private final View target;
    private float translation;
    private boolean useHeightForHorizontalSize;

    /* JADX INFO: compiled from: BounceEdgeEffect.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/oui/bouncelayout/BounceEdgeEffect$Companion;", "", "()V", "MAX_RELEASE_VELOCITY_PX_PER_MS", "", "ORIENTATION_BOTTOM", "", "ORIENTATION_LEFT", "ORIENTATION_NONE", "ORIENTATION_RIGHT", "ORIENTATION_TOP", "RELEASE_VELOCITY_VALID_MS", "", "TAG", "", "targetStates", "Ljava/util/WeakHashMap;", "Landroid/view/View;", "Lcom/obric/oui/bouncelayout/BounceEdgeEffect$Companion$TargetBounceState;", "bypassHiddenApi", "", "signature", "TargetBounceState", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: BounceEdgeEffect.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u001a\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001a\u0010\u001e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001a\u0010$\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017R\u001a\u0010'\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001a\u0010*\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0015\"\u0004\b,\u0010\u0017¨\u0006-"}, d2 = {"Lcom/obric/oui/bouncelayout/BounceEdgeEffect$Companion$TargetBounceState;", "", "()V", "activeHorizontalOrientation", "", "getActiveHorizontalOrientation", "()I", "setActiveHorizontalOrientation", "(I)V", "activeVerticalOrientation", "getActiveVerticalOrientation", "setActiveVerticalOrientation", "lastHorizontalPullOrientation", "getLastHorizontalPullOrientation", "setLastHorizontalPullOrientation", "lastHorizontalPullSign", "getLastHorizontalPullSign", "setLastHorizontalPullSign", "lastHorizontalPullTime", "", "getLastHorizontalPullTime", "()J", "setLastHorizontalPullTime", "(J)V", "lastHorizontalReleaseOrientation", "getLastHorizontalReleaseOrientation", "setLastHorizontalReleaseOrientation", "lastHorizontalReleaseTime", "getLastHorizontalReleaseTime", "setLastHorizontalReleaseTime", "lastVerticalPullOrientation", "getLastVerticalPullOrientation", "setLastVerticalPullOrientation", "lastVerticalPullSign", "getLastVerticalPullSign", "setLastVerticalPullSign", "lastVerticalPullTime", "getLastVerticalPullTime", "setLastVerticalPullTime", "lastVerticalReleaseOrientation", "getLastVerticalReleaseOrientation", "setLastVerticalReleaseOrientation", "lastVerticalReleaseTime", "getLastVerticalReleaseTime", "setLastVerticalReleaseTime", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        private static final class TargetBounceState {
            private int activeHorizontalOrientation;
            private int activeVerticalOrientation;
            private int lastHorizontalPullOrientation;
            private int lastHorizontalPullSign;
            private long lastHorizontalPullTime;
            private int lastHorizontalReleaseOrientation;
            private long lastHorizontalReleaseTime;
            private int lastVerticalPullOrientation;
            private int lastVerticalPullSign;
            private long lastVerticalPullTime;
            private int lastVerticalReleaseOrientation;
            private long lastVerticalReleaseTime;

            public TargetBounceState() {
                this.activeVerticalOrientation = -1;
                this.activeHorizontalOrientation = -1;
                this.lastVerticalReleaseTime = -1;
                this.lastVerticalReleaseOrientation = -1;
                this.lastHorizontalReleaseTime = -1;
                this.lastHorizontalReleaseOrientation = -1;
                this.lastVerticalPullTime = -1;
                this.lastVerticalPullOrientation = -1;
                this.lastHorizontalPullTime = -1;
                this.lastHorizontalPullOrientation = -1;
            }

            public final int getActiveVerticalOrientation() {
                return this.activeVerticalOrientation;
            }

            public final void setActiveVerticalOrientation(int r1) {
                this.activeVerticalOrientation = r1;
            }

            public final int getActiveHorizontalOrientation() {
                return this.activeHorizontalOrientation;
            }

            public final void setActiveHorizontalOrientation(int r1) {
                this.activeHorizontalOrientation = r1;
            }

            public final long getLastVerticalReleaseTime() {
                return this.lastVerticalReleaseTime;
            }

            public final void setLastVerticalReleaseTime(long r1) {
                this.lastVerticalReleaseTime = r1;
            }

            public final int getLastVerticalReleaseOrientation() {
                return this.lastVerticalReleaseOrientation;
            }

            public final void setLastVerticalReleaseOrientation(int r1) {
                this.lastVerticalReleaseOrientation = r1;
            }

            public final long getLastHorizontalReleaseTime() {
                return this.lastHorizontalReleaseTime;
            }

            public final void setLastHorizontalReleaseTime(long r1) {
                this.lastHorizontalReleaseTime = r1;
            }

            public final int getLastHorizontalReleaseOrientation() {
                return this.lastHorizontalReleaseOrientation;
            }

            public final void setLastHorizontalReleaseOrientation(int r1) {
                this.lastHorizontalReleaseOrientation = r1;
            }

            public final long getLastVerticalPullTime() {
                return this.lastVerticalPullTime;
            }

            public final void setLastVerticalPullTime(long r1) {
                this.lastVerticalPullTime = r1;
            }

            public final int getLastVerticalPullOrientation() {
                return this.lastVerticalPullOrientation;
            }

            public final void setLastVerticalPullOrientation(int r1) {
                this.lastVerticalPullOrientation = r1;
            }

            public final int getLastVerticalPullSign() {
                return this.lastVerticalPullSign;
            }

            public final void setLastVerticalPullSign(int r1) {
                this.lastVerticalPullSign = r1;
            }

            public final long getLastHorizontalPullTime() {
                return this.lastHorizontalPullTime;
            }

            public final void setLastHorizontalPullTime(long r1) {
                this.lastHorizontalPullTime = r1;
            }

            public final int getLastHorizontalPullOrientation() {
                return this.lastHorizontalPullOrientation;
            }

            public final void setLastHorizontalPullOrientation(int r1) {
                this.lastHorizontalPullOrientation = r1;
            }

            public final int getLastHorizontalPullSign() {
                return this.lastHorizontalPullSign;
            }

            public final void setLastHorizontalPullSign(int r1) {
                this.lastHorizontalPullSign = r1;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final void bypassHiddenApi(String r2) {
            Intrinsics.checkNotNullParameter(r2, "signature");
            HiddenApiBypass.addHiddenApiExemptions(new String[]{r2});     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            Log.w(BounceEdgeEffect.TAG, Intrinsics.stringPlus("Failed to bypass hidden API restrictions for ", r2), th);
        }
    }

    /* JADX INFO: compiled from: BounceEdgeEffect.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/obric/oui/bouncelayout/BounceEdgeEffect$Orientation;", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Orientation {
    }

    private final boolean isVerticalOrientation(int r1) {
        if (r1 == 0) goto L8;
        if (r1 == 1) goto L9;
        return false;
    L9:
        return true;
    L8:
        return true;
    }

    public static final /* synthetic */ int access$getOrientation$p(BounceEdgeEffect r0) {
        return r0.orientation;
    }

    public static final /* synthetic */ View access$getTarget$p(BounceEdgeEffect r0) {
        return r0.target;
    }

    public final float getMaxOverscrollPx() {
        return this.maxOverscrollPx;
    }

    public final void setMaxOverscrollPx(float r1) {
        this.maxOverscrollPx = r1;
    }

    public BounceEdgeEffect(Context r2, View r3, int r4, float r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "target");
        super(r2);
        this.target = r3;
        this.orientation = r4;
        this.maxOverscrollPx = r5;
        this.pullMultiplier = 1.0f;
        this.abruptOppositeDeltaGuardArmed = true;
        this.animationStartTime = -1;
        this.displayMetrics = r2.getResources().getDisplayMetrics();
        this.lastPullTime = -1;
        this.releaseVelocityTime = -1;
    }

    static {
        Companion = new Companion(null);
        targetStates = new WeakHashMap();
    }

    private final Companion.TargetBounceState targetState() {
        WeakHashMap<View, Companion.TargetBounceState> r0 = targetStates;
        monitor-enter(r0);
        WeakHashMap<View, Companion.TargetBounceState> r1 = r0;     // Catch: Throwable -> L10
        View r3 = this.target;     // Catch: Throwable -> L10
        Companion.TargetBounceState r2 = r1.get(r3);     // Catch: Throwable -> L10
        if (r2 != null) goto L7;
        r2 = new Companion.TargetBounceState();     // Catch: Throwable -> L10
        r1.put(r3, r2);     // Catch: Throwable -> L10
    L7:
        Companion.TargetBounceState r4 = r2;     // Catch: Throwable -> L10
        monitor-exit(r0);
        return r4;
    L10:
        th = move-exception;
        throw th;
    }

    private final boolean isSameAxis(int r3) {
        if (isVerticalOrientation(this.orientation) == false) goto L8;
        if (r3 == 0) goto L12;
        if (r3 == 1) goto L12;
        return false;
    L12:
        return true;
    L8:
        if (r3 == 2) goto L12;
        if (r3 == 3) goto L12;
        return false;
    }

    private final int getActiveOrientation(Companion.TargetBounceState r2) {
        if (isVerticalOrientation(this.orientation) == false) goto L6;
        return r2.getActiveVerticalOrientation();
    L6:
        return r2.getActiveHorizontalOrientation();
    }

    private final void setActiveOrientation(Companion.TargetBounceState r2, int r3) {
        if (isVerticalOrientation(this.orientation) == false) goto L5;
        r2.setActiveVerticalOrientation(r3);
        return;
    L5:
        r2.setActiveHorizontalOrientation(r3);
    }

    private final void markActiveOrientation(String r5) {
        Companion.TargetBounceState r0 = targetState();
        int r1 = getActiveOrientation(r0);
        int r2 = this.orientation;
        if (r1 == r2) goto L8;
        setActiveOrientation(r0, r2);
        BounceDebugLogger r3 = BounceDebugLogger.INSTANCE;
        if (BounceDebugLogger.getEnabled() == false) goto L9;
        BounceDebugLogger.log(this.target, "activeEdgeChanged", "from=" + r1 + " to=" + this.orientation + " reason=" + r5);
        return;
    L9:
        return;
    }

    private final void clearActiveOrientationIfCurrent(String r4) {
        Companion.TargetBounceState r0 = targetState();
        if (getActiveOrientation(r0) != this.orientation) goto L8;
        setActiveOrientation(r0, -1);
        BounceDebugLogger r1 = BounceDebugLogger.INSTANCE;
        if (BounceDebugLogger.getEnabled() == false) goto L9;
        BounceDebugLogger.log(this.target, "activeEdgeCleared", "orientation=" + this.orientation + " reason=" + r4);
        return;
    L9:
        return;
    }

    private final void recordReleaseFrame(Companion.TargetBounceState r2, long r3) {
        if (isVerticalOrientation(this.orientation) == false) goto L5;
        r2.setLastVerticalReleaseTime(r3);
        r2.setLastVerticalReleaseOrientation(this.orientation);
        return;
    L5:
        r2.setLastHorizontalReleaseTime(r3);
        r2.setLastHorizontalReleaseOrientation(this.orientation);
    }

    private final boolean wasOppositeReleasedInSameFrame(Companion.TargetBounceState r6, long r7) {
        if (isVerticalOrientation(this.orientation) == false) goto L10;
        if (r6.getLastVerticalReleaseTime() != r7) goto L15;
        if (r6.getLastVerticalReleaseOrientation() == this.orientation) goto L15;
        return true;
    L15:
        return false;
    L10:
        if (r6.getLastHorizontalReleaseTime() != r7) goto L15;
        if (r6.getLastHorizontalReleaseOrientation() == this.orientation) goto L15;
        return true;
    }

    private final long lastPullTime(Companion.TargetBounceState r2) {
        if (isVerticalOrientation(this.orientation) == false) goto L6;
        return r2.getLastVerticalPullTime();
    L6:
        return r2.getLastHorizontalPullTime();
    }

    private final int lastPullOrientation(Companion.TargetBounceState r2) {
        if (isVerticalOrientation(this.orientation) == false) goto L6;
        return r2.getLastVerticalPullOrientation();
    L6:
        return r2.getLastHorizontalPullOrientation();
    }

    private final int lastPullSign(Companion.TargetBounceState r2) {
        if (isVerticalOrientation(this.orientation) == false) goto L6;
        return r2.getLastVerticalPullSign();
    L6:
        return r2.getLastHorizontalPullSign();
    }

    private final void recordPullFrame(Companion.TargetBounceState r2, long r3, float r5) {
        int r6 = (int) Math.signum(r5);
        if (r6 != 0) goto L6;
        return;
    L6:
        if (isVerticalOrientation(this.orientation) == false) goto L8;
        r2.setLastVerticalPullTime(r3);
        r2.setLastVerticalPullOrientation(this.orientation);
        r2.setLastVerticalPullSign(r6);
        return;
    L8:
        r2.setLastHorizontalPullTime(r3);
        r2.setLastHorizontalPullOrientation(this.orientation);
        r2.setLastHorizontalPullSign(r6);
    }

    private final void resetInactiveReleaseState(String r4) {
        BounceDebugLogger r0 = BounceDebugLogger.INSTANCE;
        if (BounceDebugLogger.getEnabled() == false) goto L5;
        BounceDebugLogger.log(this.target, "onReleaseSkipped", "orientation=" + this.orientation + " reason=" + r4 + " translation=" + getTranslation());
    L5:
        this.animationStartTime = -1;
        this.accumulatedDragDistance = 0.0f;
        setTranslation(0.0f, false);
        this.pullMultiplier = 1.0f;
        this.pullMultiplierInitialized = false;
        this.abruptOppositeDeltaGuardArmed = true;
        resetReleaseVelocityTracker();
        this.target.invalidate();
    }

    public final float getTranslation() {
        return this.translation;
    }

    private final void setTranslation(float r2) {
        if (this.translation != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L12;
        this.translation = r2;
        Function1<? super Float, Unit> r1 = this.onTranslationChanged;
        if (r1 == null) goto L13;
        r1.invoke(Float.valueOf(r2));
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final Function1<Float, Unit> getOnTranslationChanged() {
        return this.onTranslationChanged;
    }

    public final void setOnTranslationChanged(Function1<? super Float, Unit> r1) {
        this.onTranslationChanged = r1;
    }

    private final void ensurePullMultiplier(float r7) {
        if (this.pullMultiplierInitialized == false) goto L6;
        return;
    L6:
        if (r7 != 0.0f) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        View r2 = this.target;
        float r3 = -1.0f;
        if ((r2 instanceof NestedScrollView) == false) goto L18;
        if (this.orientation != 0) goto L18;
        if (r7 < 0.0f) goto L27;
    L26:
        r3 = 1.0f;
    L27:
        this.pullMultiplier = r3;
        this.pullMultiplierInitialized = true;
        return;
    L18:
        if ((r2 instanceof HorizontalScrollView) == false) goto L24;
        if (this.orientation != 2) goto L24;
        if (r7 >= 0.0f) goto L26;
    L24:
        if ((r2 instanceof HorizontalScrollView) == false) goto L26;
        int r8 = this.orientation;
        goto L26
    L8:
        r1 = false;
        goto L9
    }

    public final void updateTouchDeltaX(float r1) {
        this.lastTouchDeltaX = r1;
    }

    private final boolean isPulling(float r5) {
        if (r5 != 0.0f) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return false;
    L9:
        if (this.accumulatedDragDistance <= 0.0f) goto L11;
        return true;
    L11:
        ensurePullMultiplier(r5);
        if (getDeltaPx(r5) > 0.0f) goto L14;
        return false;
    L14:
        int r6 = this.orientation;
        if (r6 == 0) goto L32;
        if (r6 == 1) goto L29;
        if (r6 == 2) goto L26;
        if (r6 == 3) goto L23;
        return false;
    L23:
        if (this.target.canScrollHorizontally(1) == false) goto L34;
        return false;
    L34:
        return true;
    L26:
        if (this.target.canScrollHorizontally(-1) == false) goto L34;
        return false;
    L29:
        if (this.target.canScrollVertically(1) == false) goto L34;
        return false;
    L32:
        if (this.target.canScrollVertically(-1) == false) goto L34;
        return false;
    L5:
        r1 = false;
        goto L6
    }

    private final float getDeltaPx(float r7) {
        if ((this.target instanceof HorizontalScrollView) == false) goto L22;
        int r0 = this.orientation;
        if (r0 == 2) goto L7;
        if (r0 != 3) goto L22;
    L7:
        float r8 = Math.abs(r7) * this.sizePx;
        int r1 = this.orientation;
        boolean r3 = false;
        if (r1 == 2) goto L15;
        if (r1 == 3) goto L12;
    L10:
        r3 = true;
    L17:
        if (r3 == false) goto L20;
        return r8;
    L20:
        return -r8;
    L12:
        if (this.lastTouchDeltaX <= 0.0f) goto L17;
    L15:
        if (this.lastTouchDeltaX >= 0.0f) goto L17;
    L22:
        return (r7 * this.pullMultiplier) * this.sizePx;
    }

    private final boolean isUnscrollableOnCurrentAxis() {
        int r0 = this.orientation;
        if (r0 == 0) goto L12;
        if (r0 == 1) goto L12;
        if (this.target.canScrollHorizontally(-1) == false) goto L9;
        return false;
    L9:
        if (this.target.canScrollHorizontally(1) == false) goto L16;
        return false;
    L16:
        return true;
    L12:
        if (this.target.canScrollVertically(-1) == false) goto L14;
        return false;
    L14:
        if (this.target.canScrollVertically(1) == false) goto L16;
        return false;
    }

    private final boolean shouldIgnoreAbruptOppositeDelta(float r4, float r5) {
        if (this.accumulatedDragDistance > 0.0f) goto L5;
    L19:
        return false;
    L5:
        if (r4 >= 0.0f) goto L19;
        if (r5 > 0.0f) goto L19;
        if (this.abruptOppositeDeltaGuardArmed == false) goto L19;
        if (isUnscrollableOnCurrentAxis() == false) goto L19;
        this.abruptOppositeDeltaGuardArmed = false;
        BounceDebugLogger r0 = BounceDebugLogger.INSTANCE;
        if (BounceDebugLogger.getEnabled() == false) goto L20;
        BounceDebugLogger.log(this.target, "oppositeDeltaSkipped", "orientation=" + this.orientation + " deltaPx=" + r4 + " accumulated=" + this.accumulatedDragDistance + " target=" + r5);
        return true;
    L20:
        return true;
    }

    private final boolean shouldSkipPullInCurrentFrame(float r11, long r12, String r14) {
        if (r11 != 0.0f) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L8;
        return false;
    L8:
        Companion.TargetBounceState r4 = targetState();
        int r5 = getActiveOrientation(r4);
        if (r5 == (-1)) goto L17;
        if (r5 == this.orientation) goto L17;
        BounceDebugLogger r13 = BounceDebugLogger.INSTANCE;
        if (BounceDebugLogger.getEnabled() == false) goto L15;
        BounceDebugLogger.log(this.target, "onPullSkipped", "orientation=" + this.orientation + " activeOrientation=" + r5 + " reason=" + r14 + "ActiveEdge deltaPx=" + r11 + " translation=" + getTranslation());
    L15:
        return true;
    L17:
        if (isUnscrollableOnCurrentAxis() == false) goto L27;
        if (r11 >= 0.0f) goto L27;
        if (lastPullTime(r4) != r12) goto L27;
        if (lastPullSign(r4) <= 0) goto L27;
        BounceDebugLogger r15 = BounceDebugLogger.INSTANCE;
        if (BounceDebugLogger.getEnabled() == false) goto L26;
        BounceDebugLogger.log(this.target, "onPullSkipped", "orientation=" + this.orientation + " lastOrientation=" + lastPullOrientation(r4) + " reason=" + r14 + "OppositeInSameFrame deltaPx=" + r11 + " translation=" + getTranslation());
    L26:
        return true;
    L27:
        return false;
    L5:
        r3 = false;
        goto L6
    }

    public final void stopAnimationForTouch() {
        if (this.animationStartTime == (-1)) goto L6;
        this.accumulatedDragDistance = FluidRubberBand.Companion.distance(Math.abs(this.translation), this.maxOverscrollPx);
        this.animationStartTime = -1;
        this.abruptOppositeDeltaGuardArmed = true;
        resetReleaseVelocityTracker();
        this.target.invalidate();
        return;
    }

    private final void setTranslation(float r5, boolean r6) {
        if (r6 == false) goto L4;
        updateReleaseVelocity(r5);
    L4:
        setTranslation(r5);
        BounceDebugLogger r7 = BounceDebugLogger.INSTANCE;
        if (BounceDebugLogger.getEnabled() == false) goto L20;
        float r1 = 0.0f;
        if (access$getOrientation$p(this) != 2) goto L9;
    L12:
        float r8 = getTranslation();
    L14:
        if (access$getOrientation$p(this) != 0) goto L16;
    L17:
        r1 = getTranslation();
    L18:
        BounceDebugLogger.logContentFrame(access$getTarget$p(this), "setTranslation", r8, r1, "trackVelocity=" + r6 + " orientation=" + this.orientation);
        return;
    L16:
        if (access$getOrientation$p(this) != 1) goto L18;
    L9:
        if (access$getOrientation$p(this) == 3) goto L12;
        r8 = 0.0f;
        goto L14
    }

    private final void updateReleaseVelocity(float r7) {
        long r0 = AnimationUtils.currentAnimationTimeMillis();
        long r2 = this.lastPullTime;
        if (r2 != (-1)) goto L5;
    L7:
        this.lastPullTranslation = r7;
        this.lastPullTime = r0;
        BounceDebugLogger r1 = BounceDebugLogger.INSTANCE;
        if (BounceDebugLogger.getEnabled() == false) goto L11;
        BounceDebugLogger.log(this.target, "velocitySample", "orientation=" + this.orientation + " velocityPxPerMs=" + this.releaseVelocityPxPerMs + " translation=" + r7);
        return;
    L11:
        return;
    L5:
        if (r0 <= r2) goto L7;
        this.releaseVelocityPxPerMs = RangesKt.coerceIn((r7 - this.lastPullTranslation) / (r0 - r2), -20.0f, 20.0f);
        this.releaseVelocityTime = r0;
        goto L7
    }

    static /* synthetic */ void logFrame$default(BounceEdgeEffect r2, String r3, AnonymousClass1 r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L5;
        r4 = AnonymousClass1.INSTANCE;
    L5:
        BounceDebugLogger r7 = BounceDebugLogger.INSTANCE;
        if (BounceDebugLogger.getEnabled() == false) goto L21;
        float r0 = 0.0f;
        if (access$getOrientation$p(r2) != 2) goto L10;
    L13:
        float r8 = r2.getTranslation();
    L15:
        if (access$getOrientation$p(r2) != 0) goto L17;
    L18:
        r0 = r2.getTranslation();
    L19:
        BounceDebugLogger.logContentFrame(access$getTarget$p(r2), r3, r8, r0, (String) r4.invoke());
        return;
    L17:
        if (access$getOrientation$p(r2) != 1) goto L19;
    L10:
        if (access$getOrientation$p(r2) == 3) goto L13;
        r8 = 0.0f;
        goto L15
    }

    private final void logFrame(String r5, Function0<String> r6) {
        BounceDebugLogger r0 = BounceDebugLogger.INSTANCE;
        if (BounceDebugLogger.getEnabled() == false) goto L18;
        float r2 = 0.0f;
        if (access$getOrientation$p(this) != 2) goto L7;
    L10:
        float r1 = getTranslation();
    L12:
        if (access$getOrientation$p(this) != 0) goto L14;
    L15:
        r2 = getTranslation();
    L16:
        BounceDebugLogger.logContentFrame(access$getTarget$p(this), r5, r1, r2, r6.invoke());
        return;
    L14:
        if (access$getOrientation$p(this) != 1) goto L16;
    L7:
        if (access$getOrientation$p(this) == 3) goto L10;
        r1 = 0.0f;
        goto L12
    }

    private final float getCurrentFrameIntervalMs() {
        Display r0 = this.target.getDisplay();
        WindowManager r1 = null;
        if (r0 != null) goto L5;
        Float r2 = null;
    L7:
        if (r2 != null) goto L17;
        Object r3 = this.target.getContext().getSystemService("window");
        if ((r3 instanceof WindowManager) == false) goto L11;
        r1 = (WindowManager) r3;
    L11:
        if (r1 != null) goto L13;
    L12:
        float r4 = 0.0f;
    L19:
        if (r4 > 0.0f) goto L23;
        return 16.67f;
    L23:
        return 1000.0f / r4;
    L13:
        Display r5 = r1.getDefaultDisplay();
        if (r5 == null) goto L12;
        r4 = r5.getRefreshRate();
        goto L19
    L17:
        r4 = r2.floatValue();
        goto L19
    L5:
        r2 = Float.valueOf(r0.getRefreshRate());
        goto L7
    }

    private final float getReleaseVelocityPxPerMs() {
        long r0 = AnimationUtils.currentAnimationTimeMillis();
        long r2 = this.releaseVelocityTime;
        if (r2 != (-1)) goto L5;
    L7:
        return 0.0f;
    L5:
        if ((r0 - r2) > 120) goto L7;
        return this.releaseVelocityPxPerMs;
    }

    private final void resetReleaseVelocityTracker() {
        this.lastPullTranslation = this.translation;
        this.lastPullTime = -1;
        this.releaseVelocityPxPerMs = 0.0f;
        this.releaseVelocityTime = -1;
    }

    private final float px(float r2) {
        return TypedValue.applyDimension(1, r2, this.displayMetrics);
    }

    private final float dp(float r1) {
        return r1 / this.displayMetrics.density;
    }

    public final void setUseHeightForHorizontalSize(boolean r1) {
        this.useHeightForHorizontalSize = r1;
    }

    @Override // android.widget.EdgeEffect
    public void setSize(int r3, int r4) {
        super.setSize(r3, r4);
        int r0 = this.orientation;
        if (r0 == 2) goto L7;
        if (r0 == 3) goto L7;
    L8:
        r3 = r4;
    L9:
        this.sizePx = r3;
        return;
    L7:
        if (this.useHeightForHorizontalSize == false) goto L9;
        goto L8
    }

    @Override // android.widget.EdgeEffect
    public void onPull(float r2) {
        onPull(r2, 0.5f);
    }

    @Override // android.widget.EdgeEffect
    public void onPull(float r8, float r9) {
        if (this.sizePx > 0) goto L5;
        return;
    L5:
        if (this.maxOverscrollPx <= 0.0f) goto L62;
        BounceDebugLogger r10 = BounceDebugLogger.INSTANCE;
        if (BounceDebugLogger.getEnabled() == false) goto L10;
        BounceDebugLogger.log(this.target, "onPull", "orientation=" + this.orientation + " deltaDistance=" + r8);
    L10:
        ensurePullMultiplier(r8);
        boolean r2 = true;
        if (this.animationStartTime == (-1)) goto L13;
        this.accumulatedDragDistance = FluidRubberBand.Companion.distance(Math.abs(this.translation), this.maxOverscrollPx);
        this.animationStartTime = -1;
        this.abruptOppositeDeltaGuardArmed = true;
        resetReleaseVelocityTracker();
    L13:
        ViewParent r11 = this.target.getParent();
        if (r11 == null) goto L18;
        r11.requestDisallowInterceptTouchEvent(true);
    L18:
        if (this.accumulatedDragDistance != 0.0f) goto L20;
        boolean r12 = true;
    L21:
        if (r12 == true) goto L23;
    L26:
        float r13 = getDeltaPx(r8);
        long r4 = AnimationUtils.currentAnimationTimeMillis();
        if (shouldSkipPullInCurrentFrame(r13, r4, "onPull") == false) goto L30;
        this.target.invalidate();
        return;
    L30:
        float r14 = this.accumulatedDragDistance + r13;
        if (shouldIgnoreAbruptOppositeDelta(r13, r14) == false) goto L34;
        markActiveOrientation("skipAbruptOppositeOnPull");
        this.target.invalidate();
        return;
    L34:
        float r15 = RangesKt.coerceAtLeast(r14, 0.0f);
        this.accumulatedDragDistance = r15;
        if (r13 > 0.0f) goto L37;
    L39:
        recordPullFrame(targetState(), r4, r13);
        float r16 = FluidRubberBand.Companion.offset(this.accumulatedDragDistance, this.maxOverscrollPx);
        int r17 = this.orientation;
        if (r17 == 0) goto L48;
        if (r17 != 1) goto L43;
    L47:
        r16 = -Math.abs(r16);
    L49:
        setTranslation(r16, true);
        if (this.accumulatedDragDistance <= 0.0f) goto L52;
    L58:
        markActiveOrientation("onPull");
    L59:
        this.target.invalidate();
        return;
    L52:
        if (r16 == 0.0f) goto L55;
        r2 = false;
    L55:
        if (r2 == false) goto L58;
        clearActiveOrientationIfCurrent("onPullZero");
        goto L59
    L43:
        if (r17 == 2) goto L48;
        if (r17 == 3) goto L47;
    L48:
        r16 = Math.abs(r16);
        goto L49
    L37:
        if (r15 <= 0.0f) goto L39;
        this.abruptOppositeDeltaGuardArmed = true;
        goto L39
    L23:
        if (isPulling(r8) == true) goto L26;
        setTranslation(0.0f, false);
        resetReleaseVelocityTracker();
        return;
    L20:
        r12 = false;
        goto L21
    }

    @Override // android.widget.EdgeEffect
    public float getDistance() {
        int r0 = this.sizePx;
        if (r0 > 0) goto L7;
        return 0.0f;
    L7:
        return this.accumulatedDragDistance / r0;
    }

    @Override // android.widget.EdgeEffect
    public float onPullDistance(float r9, float r10) {
        if (this.sizePx > 0) goto L5;
    L73:
        return 0.0f;
    L5:
        if (this.maxOverscrollPx <= 0.0f) goto L73;
        BounceDebugLogger r11 = BounceDebugLogger.INSTANCE;
        if (BounceDebugLogger.getEnabled() == false) goto L10;
        BounceDebugLogger.log(this.target, "onPullDistance", "orientation=" + this.orientation + " deltaDistance=" + r9);
    L10:
        ensurePullMultiplier(r9);
        boolean r2 = true;
        if (this.animationStartTime == (-1)) goto L13;
        this.accumulatedDragDistance = FluidRubberBand.Companion.distance(Math.abs(this.translation), this.maxOverscrollPx);
        this.animationStartTime = -1;
        this.abruptOppositeDeltaGuardArmed = true;
        resetReleaseVelocityTracker();
    L13:
        ViewParent r12 = this.target.getParent();
        if (r12 == null) goto L18;
        r12.requestDisallowInterceptTouchEvent(true);
    L18:
        if (this.accumulatedDragDistance != 0.0f) goto L20;
        boolean r13 = true;
    L21:
        if (r13 == true) goto L23;
    L26:
        float r14 = getDeltaPx(r9);
        if (r9 != 0.0f) goto L29;
        boolean r4 = true;
    L30:
        if (r4 == false) goto L32;
        return 0.0f;
    L32:
        long r5 = AnimationUtils.currentAnimationTimeMillis();
        if (shouldSkipPullInCurrentFrame(r14, r5, "onPullDistance") == false) goto L36;
        this.target.invalidate();
        return r9;
    L36:
        float r6 = this.accumulatedDragDistance + r14;
        if (shouldIgnoreAbruptOppositeDelta(r14, r6) == false) goto L41;
        markActiveOrientation("skipAbruptOppositeOnPullDistance");
        this.target.invalidate();
        return r9;
    L41:
        if (r6 <= 0.0f) goto L45;
        this.accumulatedDragDistance = r6;
        if (r14 <= 0.0f) goto L46;
        this.abruptOppositeDeltaGuardArmed = true;
    L46:
        recordPullFrame(targetState(), r5, r14);
        int r15 = this.orientation;
        float r7 = 1.0f;
        if (r15 == 0) goto L61;
        if (r15 != 1) goto L50;
    L60:
        r7 = -1.0f;
        goto L61
    L50:
        if (r15 == 2) goto L61;
        if (r15 == 3) goto L60;
        float r16 = this.translation;
        if (r16 != 0.0f) goto L56;
        boolean r8 = true;
    L57:
        if (r8 == true) goto L61;
        r7 = Math.signum(r16);
        goto L61
    L56:
        r8 = false;
    L61:
        float r17 = r7 * Math.abs(FluidRubberBand.Companion.offset(this.accumulatedDragDistance, this.maxOverscrollPx));
        setTranslation(r17, true);
        if (this.accumulatedDragDistance <= 0.0f) goto L64;
    L70:
        markActiveOrientation("onPullDistance");
    L71:
        this.target.invalidate();
        return r9;
    L64:
        if (r17 == 0.0f) goto L67;
        r2 = false;
    L67:
        if (r2 == false) goto L70;
        clearActiveOrientationIfCurrent("onPullDistanceZero");
        goto L71
    L45:
        r9 = ((-this.accumulatedDragDistance) / this.sizePx) * this.pullMultiplier;
        this.accumulatedDragDistance = 0.0f;
        goto L46
    L29:
        r4 = false;
        goto L30
    L23:
        if (isPulling(r9) == true) goto L26;
        setTranslation(0.0f, false);
        resetReleaseVelocityTracker();
        return 0.0f;
    L20:
        r13 = false;
        goto L21
    }

    @Override // android.widget.EdgeEffect
    public void onRelease() {
        long r0 = AnimationUtils.currentAnimationTimeMillis();
        Companion.TargetBounceState r2 = targetState();
        int r3 = getActiveOrientation(r2);
        if (r3 == (-1)) goto L9;
        if (r3 == this.orientation) goto L9;
        resetInactiveReleaseState(Intrinsics.stringPlus("inactiveEdge activeOrientation=", Integer.valueOf(r3)));
        return;
    L9:
        if (wasOppositeReleasedInSameFrame(r2, r0) == false) goto L12;
        resetInactiveReleaseState("oppositeReleasedInSameFrame");
        return;
    L12:
        float r4 = this.translation;
        if (r4 != 0.0f) goto L15;
        boolean r5 = true;
    L16:
        if (r5 == false) goto L19;
        this.accumulatedDragDistance = 0.0f;
        this.animationStartTime = -1;
        this.abruptOppositeDeltaGuardArmed = true;
        resetReleaseVelocityTracker();
        clearActiveOrientationIfCurrent("releaseZeroTranslation");
        return;
    L19:
        float r6 = dp(r4);
        float r7 = dp(getReleaseVelocityPxPerMs());
        BounceDebugLogger r8 = BounceDebugLogger.INSTANCE;
        if (BounceDebugLogger.getEnabled() == false) goto L22;
        BounceDebugLogger.log(this.target, "onRelease", "orientation=" + this.orientation + " initialValueDp=" + r6 + " initialVelocityDpPerMs=" + r7);
    L22:
        recordReleaseFrame(r2, r0);
        markActiveOrientation("onRelease");
        this.animationStartTime = r0;
        if (this.springBack != null) goto L25;
        this.springBack = new FluidSpringBack();
    L25:
        FluidSpringBack r1 = this.springBack;
        if (r1 == null) goto L29;
        r1.absorb(r7, r6);
    L29:
        resetReleaseVelocityTracker();
        this.target.invalidate();
        return;
    L15:
        r5 = false;
        goto L16
    }

    @Override // android.widget.EdgeEffect
    public void onAbsorb(int r14) {
        if (this.maxOverscrollPx > 0.0f) goto L6;
        return;
    L6:
        if (this.animationStartTime == (-1)) goto L11;
        BounceDebugLogger r0 = BounceDebugLogger.INSTANCE;
        if (BounceDebugLogger.getEnabled() == false) goto L52;
        BounceDebugLogger.log(this.target, "onAbsorbSkipped", "orientation=" + this.orientation + " velocity=" + r14 + " reason=animationRunning");
        return;
    L52:
        return;
    L11:
        BounceDebugLogger r1 = BounceDebugLogger.INSTANCE;
        if (BounceDebugLogger.getEnabled() == false) goto L14;
        BounceDebugLogger.log(this.target, "onAbsorb", "orientation=" + this.orientation + " velocity=" + r14);
    L14:
        resetReleaseVelocityTracker();
        markActiveOrientation("onAbsorb");
        int r2 = this.orientation;
        if (r2 == 1) goto L19;
        if (r2 == 3) goto L19;
        int r15 = Math.abs(r14);
    L20:
        float r16 = dp(r15 / 1000.0f);
        long r7 = AnimationUtils.currentAnimationTimeMillis();
        this.animationStartTime = r7;
        if (this.springBack != null) goto L23;
        this.springBack = new FluidSpringBack();
    L23:
        float r9 = dp(this.translation);
        FluidSpringBack r10 = this.springBack;
        if (r10 == null) goto L27;
        r10.absorb(r16, r9);
    L27:
        if (r10 == null) goto L50;
        float r17 = getCurrentFrameIntervalMs();
        if (r17 <= 0.0f) goto L50;
        this.animationStartTime = r7 - MathKt.roundToLong(r17);
        FluidSpringBack.SpringBackValue r8 = r10.value(r17);
        setTranslation(px(r8.getValue()), false);
        BounceDebugLogger r11 = BounceDebugLogger.INSTANCE;
        if (BounceDebugLogger.getEnabled() == false) goto L48;
        if (access$getOrientation$p(this) != 2) goto L35;
    L38:
        float r3 = getTranslation();
    L40:
        if (access$getOrientation$p(this) != 0) goto L42;
    L45:
        float r12 = getTranslation();
    L46:
        BounceDebugLogger.logContentFrame(access$getTarget$p(this), "onAbsorbImmediateFrame", r3, r12, "orientation=" + this.orientation + " elapsed=" + r17 + " refreshRate=" + (1000.0f / r17) + " finished=" + r8.isFinished());
        goto L48
    L42:
        if (access$getOrientation$p(this) == 1) goto L45;
        r12 = 0.0f;
        goto L46
    L35:
        if (access$getOrientation$p(this) == 3) goto L38;
        r3 = 0.0f;
    L48:
        if (r8.isFinished() == false) goto L50;
        setTranslation(0.0f, false);
        this.animationStartTime = -1;
        this.accumulatedDragDistance = 0.0f;
        this.pullMultiplier = 1.0f;
        this.pullMultiplierInitialized = false;
        this.abruptOppositeDeltaGuardArmed = true;
        clearActiveOrientationIfCurrent("absorbImmediateFinished");
    L50:
        this.target.invalidate();
        return;
    L19:
        r15 = -Math.abs(r14);
        goto L20
    }

    @Override // android.widget.EdgeEffect
    public boolean draw(Canvas r13) {
        Intrinsics.checkNotNullParameter(r13, "canvas");
        FluidSpringBack r14 = this.springBack;
        if (this.animationStartTime == (-1)) goto L27;
        if (r14 == null) goto L27;
        long r4 = AnimationUtils.currentAnimationTimeMillis() - this.animationStartTime;
        FluidSpringBack.SpringBackValue r15 = r14.value(r4);
        setTranslation(px(r15.getValue()), false);
        BounceDebugLogger r0 = BounceDebugLogger.INSTANCE;
        if (BounceDebugLogger.getEnabled() == false) goto L23;
        if (access$getOrientation$p(this) != 2) goto L10;
    L13:
        float r1 = getTranslation();
    L15:
        if (access$getOrientation$p(this) != 0) goto L17;
    L20:
        float r8 = getTranslation();
    L21:
        BounceDebugLogger.logContentFrame(access$getTarget$p(this), "draw", r1, r8, "orientation=" + this.orientation + " elapsed=" + r4 + " finished=" + r15.isFinished());
        goto L23
    L17:
        if (access$getOrientation$p(this) == 1) goto L20;
        r8 = 0.0f;
        goto L21
    L10:
        if (access$getOrientation$p(this) == 3) goto L13;
        r1 = 0.0f;
    L23:
        if (r15.isFinished() == true) goto L26;
        this.target.invalidate();
        return true;
    L26:
        setTranslation(0.0f, false);
        this.animationStartTime = -1;
        this.accumulatedDragDistance = 0.0f;
        this.pullMultiplier = 1.0f;
        this.pullMultiplierInitialized = false;
        this.abruptOppositeDeltaGuardArmed = true;
        resetReleaseVelocityTracker();
        clearActiveOrientationIfCurrent("drawFinished");
    L27:
        return false;
    }

    @Override // android.widget.EdgeEffect
    public boolean isFinished() {
        if (this.animationStartTime == (-1)) goto L5;
        return false;
    L5:
        if (this.translation != 0.0f) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == true) goto L10;
        return false;
    L10:
        return true;
    L7:
        r4 = false;
        goto L8
    }

    @Override // android.widget.EdgeEffect
    public void finish() {
        super.finish();
        this.animationStartTime = -1;
        this.accumulatedDragDistance = 0.0f;
        setTranslation(0.0f, false);
        this.pullMultiplier = 1.0f;
        this.pullMultiplierInitialized = false;
        this.abruptOppositeDeltaGuardArmed = true;
        resetReleaseVelocityTracker();
        clearActiveOrientationIfCurrent(SafeCushionConstant.FINISH_STATE);
        this.target.invalidate();
    }
}
