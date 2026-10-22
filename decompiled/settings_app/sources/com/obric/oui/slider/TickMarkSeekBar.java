package com.obric.oui.slider;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.core.content.ContextCompat;
import com.android.settings.search.IndexDatabaseHelper;
import com.obric.common.oea.foundation.animation.builder.ValueAnimatable;
import com.obric.common.oea.foundation.animation.manager.AnimationManager;
import com.obric.common.oea.foundation.animation.spec.AnimationSpecKt;
import com.obric.common.oea.foundation.animation.spec.spring.FloatSpringSpec;
import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.common.oui.R;
import com.obric.oui.common.style.Shadow;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.utils.ViewUtil;
import com.obric.oui.utils.log.L;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: TickMarkSeekBar.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b7\b\u0016\u0018\u0000 °\u00012\u00020\u0001:\u0004°\u0001±\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010V\u001a\u00020WH\u0002J\u0010\u0010X\u001a\u00020\n2\u0006\u0010Y\u001a\u00020\nH\u0002J\u0010\u0010Z\u001a\u00020\n2\u0006\u0010[\u001a\u00020\nH\u0002J\b\u0010\\\u001a\u00020WH\u0002J\u0012\u0010]\u001a\u00020W2\b\u0010^\u001a\u0004\u0018\u000106H\u0002J\b\u0010_\u001a\u00020\nH\u0002J\b\u0010`\u001a\u00020\nH\u0002J\b\u0010a\u001a\u00020\nH\u0002J\u001f\u0010b\u001a\u00020W2\u0006\u0010c\u001a\u00020d2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020d0fH\u0082\bJ\u0010\u0010g\u001a\u00020W2\u0006\u0010h\u001a\u00020iH\u0002J\u0018\u0010j\u001a\u00020W2\u0006\u0010k\u001a\u00020l2\u0006\u0010h\u001a\u00020iH\u0002J\u0010\u0010m\u001a\u00020W2\u0006\u0010h\u001a\u00020iH\u0003J\u0010\u0010n\u001a\u00020W2\u0006\u0010h\u001a\u00020iH\u0002J\u0010\u0010o\u001a\u00020W2\u0006\u0010h\u001a\u00020iH\u0002J\b\u0010p\u001a\u00020\u0007H\u0002J\b\u0010q\u001a\u00020\nH\u0002J\b\u0010r\u001a\u00020\nH\u0002J\u0010\u0010s\u001a\u00020W2\u0006\u0010t\u001a\u00020lH\u0016J\u0006\u0010u\u001a\u00020\u0017J\b\u0010v\u001a\u00020\u0017H\u0002J\u0010\u0010w\u001a\u00020\u00172\u0006\u0010Y\u001a\u00020\nH\u0002J\u0014\u0010x\u001a\u0004\u0018\u0001062\b\u0010^\u001a\u0004\u0018\u000106H\u0002J\u0012\u0010y\u001a\u00020W2\b\u0010z\u001a\u0004\u0018\u00010{H\u0014J\u0010\u0010|\u001a\u00020W2\u0006\u0010h\u001a\u00020iH\u0014J\u0018\u0010}\u001a\u00020W2\u0006\u0010~\u001a\u00020\u00072\u0006\u0010\u007f\u001a\u00020\u0007H\u0014J\u0013\u0010\u0080\u0001\u001a\u00020\u00172\b\u0010^\u001a\u0004\u0018\u000106H\u0016J\t\u0010\u0081\u0001\u001a\u00020WH\u0002J\t\u0010\u0082\u0001\u001a\u00020WH\u0002J\t\u0010\u0083\u0001\u001a\u00020WH\u0002J\u0012\u0010\u0084\u0001\u001a\u00020\u00072\u0007\u0010\u0085\u0001\u001a\u00020\u0007H\u0002J\u000f\u0010\u0086\u0001\u001a\u00020W2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u0087\u0001\u001a\u00020W2\u0007\u0010\u0088\u0001\u001a\u00020\u0017J\u0011\u0010\u0089\u0001\u001a\u00020W2\u0006\u0010K\u001a\u00020\u0007H\u0016J$\u0010\u008a\u0001\u001a\u00020W2\u0006\u0010#\u001a\u00020\u00172\b\b\u0002\u0010K\u001a\u00020\u00072\t\b\u0002\u0010\u008b\u0001\u001a\u00020\u0007J\u000f\u0010\u008c\u0001\u001a\u00020W2\u0006\u0010+\u001a\u00020\u0007J\u000f\u0010\u008d\u0001\u001a\u00020W2\u0006\u0010-\u001a\u00020\u0007J\u0012\u0010\u008e\u0001\u001a\u00020W2\t\u0010\u008f\u0001\u001a\u0004\u0018\u000100J\u0012\u0010\u0090\u0001\u001a\u00020W2\t\b\u0001\u0010\u0091\u0001\u001a\u00020\u0007J\u0012\u0010\u0092\u0001\u001a\u00020W2\t\b\u0001\u0010\u0093\u0001\u001a\u00020\u0007J\u001d\u0010\u0094\u0001\u001a\u00020W2\t\b\u0001\u0010\u0095\u0001\u001a\u00020\u00072\t\b\u0001\u0010\u0091\u0001\u001a\u00020\u0007J\u001d\u0010\u0096\u0001\u001a\u00020W2\t\b\u0001\u0010\u0097\u0001\u001a\u00020\u00072\t\b\u0001\u0010\u0093\u0001\u001a\u00020\u0007J\u0012\u0010\u0098\u0001\u001a\u00020W2\t\b\u0001\u0010\u0099\u0001\u001a\u00020\u0007J\u0011\u0010\u009a\u0001\u001a\u00020W2\b\b\u0001\u00109\u001a\u00020\u0007J\u0012\u0010\u009b\u0001\u001a\u00020W2\u0007\u0010\u009c\u0001\u001a\u00020\u0007H\u0016J\u001b\u0010\u009b\u0001\u001a\u00020W2\u0007\u0010\u009c\u0001\u001a\u00020\u00072\u0007\u0010\u009d\u0001\u001a\u00020\u0017H\u0016J\u0012\u0010\u009e\u0001\u001a\u00020W2\t\b\u0001\u0010\u009f\u0001\u001a\u00020\u0007J\u0011\u0010 \u0001\u001a\u00020W2\b\b\u0001\u0010?\u001a\u00020\u0007J\u0012\u0010¡\u0001\u001a\u00020W2\t\b\u0001\u0010¢\u0001\u001a\u00020\u0007J\u0012\u0010£\u0001\u001a\u00020W2\t\b\u0001\u0010¢\u0001\u001a\u00020\u0007J\u0011\u0010¤\u0001\u001a\u00020\n2\u0006\u0010Y\u001a\u00020\nH\u0002J\u001f\u0010¥\u0001\u001a\u00020\u00172\u0007\u0010¦\u0001\u001a\u00020\n2\u000b\b\u0002\u0010§\u0001\u001a\u0004\u0018\u00010UH\u0002J\u0010\u0010¨\u0001\u001a\u00020W2\u0007\u0010©\u0001\u001a\u00020\u0017J\u0011\u0010ª\u0001\u001a\u00020W2\u0006\u0010^\u001a\u000206H\u0003J\u0012\u0010«\u0001\u001a\u00020W2\u0007\u0010¬\u0001\u001a\u00020\nH\u0002J\u0018\u0010\u00ad\u0001\u001a\u00020\n*\u00020\n2\t\b\u0002\u0010®\u0001\u001a\u00020\u0007H\u0002J\r\u0010¯\u0001\u001a\u00020\n*\u00020\u0007H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n8B@BX\u0082\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u00178F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0011\"\u0004\b*\u0010\u0013R\u000e\u0010+\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020;X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010O\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bP\u0010QR\u000e\u0010T\u001a\u00020UX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006²\u0001"}, d2 = {"Lcom/obric/oui/slider/TickMarkSeekBar;", "Landroidx/appcompat/widget/AppCompatSeekBar;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroundHeight", "", "centerY", "clipPath", "Landroid/graphics/Path;", "value", "currentProgress", "getCurrentProgress", "()F", "setCurrentProgress", "(F)V", "currentProgressVelocity", "currentTargetProgress", "debugLogEnabled", "", "enableMoveThumbOnDownOutside", "getEnableMoveThumbOnDownOutside", "()Z", "setEnableMoveThumbOnDownOutside", "(Z)V", "hasDirectionLocked", "isDraggingHorizontally", "isFirstFrame", "isInternalUpdating", "isPress", "isPressThumb", "isStyleSegmented", "isThumbOnTouchDown", "isThumbOnTouchEvent", "mBackgroundColor", "mCurrentTickIndex", "mTouchProgressOffset", "getMTouchProgressOffset", "setMTouchProgressOffset", "maxVisibleProgress", "measureHeightPx", "minVisibleProgress", "mirrorForRtl", "onSeekBarChangeListenerExt", "Lcom/obric/oui/slider/TickMarkSeekBar$OnSeekBarChangeListenerExt;", "paddingHorizontal", "paint", "Landroid/graphics/Paint;", "path", "pendingDownTrackEvent", "Landroid/view/MotionEvent;", "progressAnimator", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "progressColor", "rectF", "Landroid/graphics/RectF;", "seekBarVibrateHelper", "Lcom/obric/oui/slider/SeekBarVibrateHelper;", "thumbAnimator", "thumbColor", "thumbNormalScale", "thumbPressScale", "thumbScale", "thumbScaleVelocity", "thumbShadow", "Lcom/obric/oui/common/style/Shadow;", "thumbSize", "thumbStrokeColor", "thumbStrokeRectF", "thumbStrokeWidth", "tickColor", "tickMarkCount", "tickRadius", "touchDownX", "touchDownY", "touchSlop", "getTouchSlop", "()I", "touchSlop$delegate", "Lkotlin/Lazy;", "trackDownIfNoMoveRunnable", "Ljava/lang/Runnable;", "anchorPoint", "", "calculateScaleByX", "rawX", "calculateXByScale", "scale", "cancelPendingDownTrack", "cancelTouchByInternalUpdate", "event", "currentThumbCenterX", "currentThumbRadius", "currentThumbSize", "debugLog", "stage", "", "message", "Lkotlin/Function0;", "drawBackground", "canvas", "Landroid/graphics/Canvas;", "drawCustomProgress", "d", "Landroid/graphics/drawable/Drawable;", "drawProgress", "drawThumb", "drawTickMark", "getCompatMinValue", "getTrackEndX", "getTrackStartX", "invalidateDrawable", "dr", "isDebugLogEnabled", "isLayoutRtlForProgress", "isTouchAtTrackEdge", "obtainTouchEventForNativeProgress", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDraw", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onTouchEvent", "onTrackDownIfNoMove", "refreshDimensionCache", "resetTouchTrackingState", "resolveSegmentedProgressByIndex", "index", "setBackgroundHeight", "setDebugLogEnabled", IndexDatabaseHelper.IndexColumns.ENABLED, "setDefaultTickMarkCount", "setIsSegmented", "initTickPosition", "setMaxVisibleProgress", "setMinVisibleProgress", "setOnSeekBarChangeListenerExt", "l", "setProcessBackgroundColor", "backgroundColorResId", "setProcessBackgroundColorInt", "backgroundColor", "setProcessColor", "processColorResId", "setProcessColorInt", "processColor", "setProcessProgressColor", "progressColorResId", "setProcessProgressColorInt", "setProgress", "progress", "animate", "setThumbColor", "thumbColorResId", "setThumbColorInt", "setTickColor", "color", "setTickColorInt", "toLogicalTrackX", "toggleProgressChangedAnim", "newProgress", "endAction", "toggleThumbScaleAnim", "toPress", "trackTouchEvent", "updateTouchProgressOffsetOnDown", "downX", "round", "decimals", "toRealValue", "Companion", "OnSeekBarChangeListenerExt", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class TickMarkSeekBar extends AppCompatSeekBar {
    public static final Companion Companion = null;
    private static final long DOWN_NO_MOVE_TRACK_DELAY_MS = 150;
    private static final String TAG = "TickSeekBar";
    private static volatile boolean globalDebugLogEnabled;
    private float backgroundHeight;
    private final float centerY;
    private final Path clipPath;
    private float currentProgress;
    private float currentProgressVelocity;
    private float currentTargetProgress;
    private boolean debugLogEnabled;
    private boolean enableMoveThumbOnDownOutside;
    private boolean hasDirectionLocked;
    private boolean isDraggingHorizontally;
    private boolean isFirstFrame;
    private boolean isInternalUpdating;
    private boolean isPress;
    private boolean isPressThumb;
    private boolean isStyleSegmented;
    private boolean isThumbOnTouchDown;
    private boolean isThumbOnTouchEvent;
    private int mBackgroundColor;
    private int mCurrentTickIndex;
    private float mTouchProgressOffset;
    private int maxVisibleProgress;
    private int measureHeightPx;
    private int minVisibleProgress;
    private boolean mirrorForRtl;
    private OnSeekBarChangeListenerExt onSeekBarChangeListenerExt;
    private final float paddingHorizontal;
    private final Paint paint;
    private final Path path;
    private MotionEvent pendingDownTrackEvent;
    private AnimationManager progressAnimator;
    private int progressColor;
    private final RectF rectF;
    private final SeekBarVibrateHelper seekBarVibrateHelper;
    private AnimationManager thumbAnimator;
    private int thumbColor;
    private final float thumbNormalScale;
    private final float thumbPressScale;
    private float thumbScale;
    private float thumbScaleVelocity;
    private Shadow thumbShadow;
    private final float thumbSize;
    private int thumbStrokeColor;
    private final RectF thumbStrokeRectF;
    private float thumbStrokeWidth;
    private int tickColor;
    private int tickMarkCount;
    private final float tickRadius;
    private float touchDownX;
    private float touchDownY;
    private final Lazy touchSlop$delegate;
    private final Runnable trackDownIfNoMoveRunnable;

    /* JADX INFO: compiled from: TickMarkSeekBar.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/slider/TickMarkSeekBar$Companion;", "", "()V", "DOWN_NO_MOVE_TRACK_DELAY_MS", "", "TAG", "", "globalDebugLogEnabled", "", "getGlobalDebugLogEnabled", "()Z", "setGlobalDebugLogEnabled", "(Z)V", "actionToString", "action", "", "enableGlobalDebugLog", "", IndexDatabaseHelper.IndexColumns.ENABLED, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public static final /* synthetic */ String access$actionToString(Companion r0, int r1) {
            return r0.actionToString(r1);
        }

        public final boolean getGlobalDebugLogEnabled() {
            return TickMarkSeekBar.access$getGlobalDebugLogEnabled$cp();
        }

        public final void setGlobalDebugLogEnabled(boolean r1) {
            TickMarkSeekBar.access$setGlobalDebugLogEnabled$cp(r1);
        }

        @JvmStatic
        public final void enableGlobalDebugLog(boolean r1) {
            setGlobalDebugLogEnabled(r1);
        }

        private final String actionToString(int r1) {
            if (r1 != 0) goto L4;
            return "DOWN";
        L4:
            if (r1 != 1) goto L6;
            return "UP";
        L6:
            if (r1 != 2) goto L8;
            return "MOVE";
        L8:
            if (r1 != 3) goto L10;
            return "CANCEL";
        L10:
            if (r1 != 5) goto L12;
            return "POINTER_DOWN";
        L12:
            if (r1 != 6) goto L21;
            return "POINTER_UP";
        L21:
            return String.valueOf(r1);
        }
    }

    /* JADX INFO: compiled from: TickMarkSeekBar.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0010\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/slider/TickMarkSeekBar$OnSeekBarChangeListenerExt;", "", "onProgressChanged", "", "seekBar", "Landroid/widget/SeekBar;", "progress", "", "fromUser", "", "onSegmentedPositionChanged", "index", "", "onStartTrackingTouch", "onStopTrackingTouch", "onTouchDown", "onTouchUp", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnSeekBarChangeListenerExt {

        /* JADX INFO: compiled from: TickMarkSeekBar.kt */
        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class DefaultImpls {
            public static void onTouchDown(OnSeekBarChangeListenerExt r0, SeekBar r1) {
                Intrinsics.checkNotNullParameter(r0, "this");
            }

            public static void onTouchUp(OnSeekBarChangeListenerExt r0, SeekBar r1, float r2) {
                Intrinsics.checkNotNullParameter(r0, "this");
            }
        }

        void onProgressChanged(SeekBar r1, float r2, boolean r3);

        void onSegmentedPositionChanged(int r1);

        void onStartTrackingTouch(SeekBar r1);

        void onStopTrackingTouch(SeekBar r1);

        void onTouchDown(SeekBar r1);

        void onTouchUp(SeekBar r1, float r2);
    }

    public static /* synthetic */ void $r8$lambda$2s97K8WQtJLWId8dAATjDkwrfpM(TickMarkSeekBar r0, int r1) {
        m1395anchorPoint$lambda32(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$u0SGW8NzFNB6V-e3Di9ZuOg3dvY, reason: not valid java name */
    public static /* synthetic */ void m1394$r8$lambda$u0SGW8NzFNB6Ve3Di9ZuOg3dvY(TickMarkSeekBar r0) {
        m1396trackDownIfNoMoveRunnable$lambda0(r0);
    }

    static {
        Companion = new Companion(null);
    }

    public TickMarkSeekBar(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public TickMarkSeekBar(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    @JvmStatic
    public static final void enableGlobalDebugLog(boolean r1) {
        Companion.enableGlobalDebugLog(r1);
    }

    public /* synthetic */ TickMarkSeekBar(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ float access$getCurrentProgress(TickMarkSeekBar r0) {
        return r0.getCurrentProgress();
    }

    public static final /* synthetic */ float access$getCurrentTargetProgress$p(TickMarkSeekBar r0) {
        return r0.currentTargetProgress;
    }

    public static final /* synthetic */ boolean access$getGlobalDebugLogEnabled$cp() {
        return globalDebugLogEnabled;
    }

    public static final /* synthetic */ OnSeekBarChangeListenerExt access$getOnSeekBarChangeListenerExt$p(TickMarkSeekBar r0) {
        return r0.onSeekBarChangeListenerExt;
    }

    public static final /* synthetic */ SeekBarVibrateHelper access$getSeekBarVibrateHelper$p(TickMarkSeekBar r0) {
        return r0.seekBarVibrateHelper;
    }

    public static final /* synthetic */ float access$getThumbScale$p(TickMarkSeekBar r0) {
        return r0.thumbScale;
    }

    public static final /* synthetic */ int access$getTickMarkCount$p(TickMarkSeekBar r0) {
        return r0.tickMarkCount;
    }

    public static final /* synthetic */ boolean access$isStyleSegmented$p(TickMarkSeekBar r0) {
        return r0.isStyleSegmented;
    }

    public static final /* synthetic */ void access$setCurrentProgress(TickMarkSeekBar r0, float r1) {
        r0.setCurrentProgress(r1);
    }

    public static final /* synthetic */ void access$setCurrentProgressVelocity$p(TickMarkSeekBar r0, float r1) {
        r0.currentProgressVelocity = r1;
    }

    public static final /* synthetic */ void access$setGlobalDebugLogEnabled$cp(boolean r0) {
        globalDebugLogEnabled = r0;
    }

    public static final /* synthetic */ void access$setMCurrentTickIndex$p(TickMarkSeekBar r0, int r1) {
        r0.mCurrentTickIndex = r1;
    }

    public static final /* synthetic */ void access$setThumbScale$p(TickMarkSeekBar r0, float r1) {
        r0.thumbScale = r1;
    }

    public static final /* synthetic */ void access$setThumbScaleVelocity$p(TickMarkSeekBar r0, float r1) {
        r0.thumbScaleVelocity = r1;
    }

    public static final /* synthetic */ float access$toRealValue(TickMarkSeekBar r0, int r1) {
        return r0.toRealValue(r1);
    }

    public TickMarkSeekBar(final Context r17, AttributeSet r18, int r19) {
        Intrinsics.checkNotNullParameter(r17, "context");
        super(r17, r18, r19);
        this.tickMarkCount = -1;
        TickMarkSeekBar r3 = this;
        this.backgroundHeight = OUnitExtensionKt.vdp(r3, 6);
        this.centerY = OUnitExtensionKt.vdp(r3, 16);
        this.thumbNormalScale = 1.0f;
        this.thumbPressScale = 1.22f;
        this.thumbSize = OUnitExtensionKt.vdp(r3, 18);
        this.thumbScale = 1.0f;
        this.minVisibleProgress = -1;
        this.maxVisibleProgress = -1;
        this.tickRadius = OUnitExtensionKt.vdp(r3, 2);
        Paint r5 = new Paint();
        this.paint = r5;
        this.clipPath = new Path();
        this.rectF = new RectF();
        this.thumbStrokeRectF = new RectF();
        this.path = new Path();
        this.mCurrentTickIndex = -1;
        this.seekBarVibrateHelper = new SeekBarVibrateHelper();
        this.thumbShadow = new Shadow(Color.parseColor("#00000000"), 0.0f, 0.0f, 0.0f, 0.0f, null, 0.0f, 96, null);
        this.isFirstFrame = true;
        this.paddingHorizontal = OUnitExtensionKt.vdp(r3, 12);
        this.touchSlop$delegate = LazyKt.lazy(new TickMarkSeekBar$touchSlop$2(r17));
        this.trackDownIfNoMoveRunnable = new TickMarkSeekBar$$ExternalSyntheticLambda1(this);
        this.enableMoveThumbOnDownOutside = true;
        refreshDimensionCache();
        TypedArray r6 = r17.getTheme().obtainStyledAttributes(r18, R.styleable.TickMarkSeekBar, r19, 0);
        this.backgroundHeight = r6.getDimensionPixelSize(R.styleable.TickMarkSeekBar_seekbarHeight, OUnitExtensionKt.vdp(r3, 6));
        this.mBackgroundColor = r6.getColor(R.styleable.TickMarkSeekBar_seekbarBackgroundColor, ContextCompat.getColor(r17, R.color.oui_basic_line_2));
        this.progressColor = r6.getColor(R.styleable.TickMarkSeekBar_seekbarProgressColor, ContextCompat.getColor(r17, R.color.oui_functional_blue_6));
        this.thumbColor = r6.getColor(R.styleable.TickMarkSeekBar_seekbarThumbColor, ContextCompat.getColor(r17, R.color.oui_on_accent_default));
        this.thumbStrokeColor = r6.getColor(R.styleable.TickMarkSeekBar_seekbarThumbStrokeColor, ContextCompat.getColor(r17, R.color.oui_basic_line_1));
        this.tickColor = r6.getColor(R.styleable.TickMarkSeekBar_seekbarTickColor, ContextCompat.getColor(r17, R.color.oui_basic_line_2));
        setEnableMoveThumbOnDownOutside(r6.getBoolean(R.styleable.TickMarkSeekBar_seekbarEnableMoveThumbOnDownOutside, true));
        this.mirrorForRtl = r6.getBoolean(R.styleable.TickMarkSeekBar_seekbarMirrorForRtl, false);
        r6.recycle();
        setOnSeekBarChangeListenerExt(null);
        r5.setStyle(Paint.Style.FILL);
        ViewUtil.INSTANCE.applyShadowStyleFromResource(r17, R.style.OUIShadow_1, this.thumbShadow);
        setCurrentProgress(getProgress());
    }

    private final float getCurrentProgress() {
        return this.currentProgress;
    }

    private final void setCurrentProgress(float r1) {
        this.currentProgress = r1;
    }

    private final int getTouchSlop() {
        return ((Number) this.touchSlop$delegate.getValue()).intValue();
    }

    /* JADX INFO: renamed from: trackDownIfNoMoveRunnable$lambda-0, reason: not valid java name */
    private static final void m1396trackDownIfNoMoveRunnable$lambda0(TickMarkSeekBar r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.onTrackDownIfNoMove();
    }

    public final void setDebugLogEnabled(boolean r3) {
        this.debugLogEnabled = r3;
        if (isDebugLogEnabled() == false) goto L7;
        L.d(TAG, "[config][" + Integer.toHexString(System.identityHashCode(this)) + "] " + ("instanceDebug=" + r3 + ", globalDebug=" + globalDebugLogEnabled));
        return;
    }

    public final boolean isDebugLogEnabled() {
        if (this.debugLogEnabled == false) goto L5;
    L8:
        return true;
    L5:
        if (globalDebugLogEnabled == true) goto L8;
        return false;
    }

    private final void debugLog(String r3, Function0<String> r4) {
        if (isDebugLogEnabled() == true) goto L5;
        return;
    L5:
        L.d(TAG, "[" + r3 + "][" + Integer.toHexString(System.identityHashCode(this)) + "] " + r4.invoke());
    }

    private final void onTrackDownIfNoMove() {
        if (this.isPress == false) goto L23;
        if (this.isInternalUpdating == true) goto L23;
        if (this.hasDirectionLocked == true) goto L23;
        if (this.isDraggingHorizontally == true) goto L23;
        if (this.isThumbOnTouchDown == true) goto L23;
        MotionEvent r0 = this.pendingDownTrackEvent;
        this.pendingDownTrackEvent = null;
        removeCallbacks(this.trackDownIfNoMoveRunnable);
        if (r0 != null) goto L17;
        return;
    L17:
        if (isDebugLogEnabled() == false) goto L20;
        L.d(TAG, "[delayed-track-run][" + Integer.toHexString(System.identityHashCode(this)) + "] " + ("action=" + Companion.access$actionToString(Companion, r0.getAction()) + ", x=" + r0.getX() + ", progress=" + getProgress() + ", currentProgress=" + getCurrentProgress()));
    L20:
        trackTouchEvent(r0);
        r0.recycle();
        return;
    L23:
        if (isDebugLogEnabled() == false) goto L26;
        L.d(TAG, "[delayed-track-skip][" + Integer.toHexString(System.identityHashCode(this)) + "] " + ("isPress=" + this.isPress + ", isInternalUpdating=" + this.isInternalUpdating + ", hasDirectionLocked=" + this.hasDirectionLocked + ", isDraggingHorizontally=" + this.isDraggingHorizontally + ", isThumbOnTouchDown=" + this.isThumbOnTouchDown));
    L26:
        cancelPendingDownTrack();
    }

    private final void cancelPendingDownTrack() {
        MotionEvent r0 = this.pendingDownTrackEvent;
        if (r0 == null) goto L6;
        r0.recycle();
    L6:
        this.pendingDownTrackEvent = null;
        removeCallbacks(this.trackDownIfNoMoveRunnable);
    }

    public final boolean getEnableMoveThumbOnDownOutside() {
        return this.enableMoveThumbOnDownOutside;
    }

    public final void setEnableMoveThumbOnDownOutside(boolean r1) {
        this.enableMoveThumbOnDownOutside = r1;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        refreshDimensionCache();
    }

    private final void refreshDimensionCache() {
        TickMarkSeekBar r0 = this;
        this.measureHeightPx = OUnitExtensionKt.vdp(r0, 32);
        this.thumbStrokeWidth = OUnitExtensionKt.vdpFloat(r0, 0.5d);
    }

    @Override // androidx.appcompat.widget.AppCompatSeekBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "canvas");     // Catch: Throwable -> L9
        if (this.isFirstFrame == false) goto L6;
        this.isFirstFrame = false;     // Catch: Throwable -> L9
        setCurrentProgress(getProgress());     // Catch: Throwable -> L9
    L6:
        drawBackground(r2);     // Catch: Throwable -> L9
        drawTickMark(r2);     // Catch: Throwable -> L9
        drawProgress(r2);     // Catch: Throwable -> L9
        drawThumb(r2);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private final float currentThumbCenterX() {
        float r0 = getWidth();
        float r1 = this.paddingHorizontal;
        float r2 = this.thumbSize;
        return (r1 + (r2 / 2.0f)) + ((getCurrentProgress() / getMax()) * (((r0 - r1) - r1) - r2));
    }

    private final float currentThumbSize() {
        return this.thumbSize * this.thumbScale;
    }

    private final float currentThumbRadius() {
        return (this.thumbSize * this.thumbScale) / 2.0f;
    }

    private final void drawBackground(Canvas r7) {
        r7.save();
        float r0 = this.backgroundHeight / 2;
        this.rectF.set(this.paddingHorizontal, this.centerY - r0, getWidth() - this.paddingHorizontal, this.centerY + r0);
        this.clipPath.reset();
        this.clipPath.addRoundRect(this.rectF, r0, r0, Path.Direction.CW);
        this.paint.setColor(this.mBackgroundColor);
        r7.drawPath(this.clipPath, this.paint);
        r7.restore();
        if (this.isStyleSegmented == false) goto L6;
        drawTickMark(r7);
        return;
    }

    private final void drawProgress(Canvas r10) {
        int r0 = r10.save();
        if (getProgressDrawable() == null) goto L5;
        Drawable r1 = getProgressDrawable();
        Intrinsics.checkNotNullExpressionValue(r1, "progressDrawable");
        drawCustomProgress(r1, r10);
    L6:
        r10.restoreToCount(r0);
        return;
    L5:
        float r2 = this.backgroundHeight / 2;
        float r3 = currentThumbCenterX();
        float r4 = currentThumbRadius();
        RectF r5 = this.rectF;
        float r6 = this.paddingHorizontal;
        float r7 = this.centerY;
        r5.set(r6, r7 - r2, r3, r7 + r2);
        this.path.reset();
        this.path.addRoundRect(this.rectF, new float[]{r2, r2, 0.0f, 0.0f, 0.0f, 0.0f, r2, r2}, Path.Direction.CW);
        this.paint.setColor(this.progressColor);
        this.clipPath.reset();
        this.clipPath.addCircle(r3, this.centerY, r4, Path.Direction.CW);
        r10.clipOutPath(this.clipPath);
        r10.drawPath(this.path, this.paint);
        goto L6
    }

    private final void drawCustomProgress(Drawable r5, Canvas r6) {
        r6.translate(0.0f, getPaddingTop());
        r5.setBounds(new Rect(0, (getMeasuredHeight() / 2) - (r5.getIntrinsicHeight() / 2), getMeasuredWidth(), (getMeasuredHeight() / 2) + (r5.getIntrinsicHeight() / 2)));
        r5.draw(r6);
    }

    private final void drawTickMark(Canvas r9) {
        if (this.tickMarkCount > 0) goto L5;
        return;
    L5:
        if (this.isStyleSegmented == false) goto L11;
        float r0 = getWidth();
        float r1 = this.paddingHorizontal;
        float r2 = ((r0 - r1) - r1) - this.thumbSize;
        int r3 = this.tickMarkCount;
        float r4 = r2 / (r3 - 1);
        int r5 = 0;
    L7:
        if (r5 >= r3) goto L12;
        int r6 = r5 + 1;
        float r7 = this.paddingHorizontal;
        float r8 = this.thumbSize;
        float r10 = (r7 + (r8 / 2.0f)) + (r5 * r4);
        float r11 = (this.centerY + (r8 / 2.0f)) - this.tickRadius;
        this.paint.setColor(this.tickColor);
        r9.drawCircle(r10, r11, this.tickRadius, this.paint);
        r5 = r6;
        goto L7
    L12:
        return;
    }

    private final void drawThumb(Canvas r8) {
        if (this.thumbColor != 0) goto L5;
        return;
    L5:
        r8.save();
        float r0 = currentThumbSize();
        float r1 = currentThumbCenterX();
        this.paint.setColor(this.thumbColor);
        float r2 = r0 / 2.0f;
        float r5 = this.centerY;
        this.rectF.set(r1 - r2, r5 - r2, r1 + r2, r5 + r2);
        r8.drawRoundRect(this.rectF, r2, r2, this.paint);
        r8.restore();
        r8.save();
        ViewUtil.INSTANCE.drawShadowLayer(r8, this.thumbShadow, this.rectF, r2);
        r8.restore();
        float r3 = this.thumbStrokeWidth / 2.0f;
        this.thumbStrokeRectF.set(this.rectF);
        float r4 = -r3;
        this.thumbStrokeRectF.inset(r4, r4);
        Paint.Style r6 = this.paint.getStyle();
        float r7 = this.paint.getStrokeWidth();
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(this.thumbStrokeWidth);
        this.paint.setColor(this.thumbStrokeColor);
        float r9 = r2 + r3;
        r8.drawRoundRect(this.thumbStrokeRectF, r9, r9, this.paint);
        this.paint.setStrokeWidth(r7);
        this.paint.setStyle(r6);
    }

    @Override // android.widget.AbsSeekBar, android.view.View
    public boolean onTouchEvent(MotionEvent r23) {
        if (isEnabled() == true) goto L5;
        return false;
    L5:
        String r4 = ", touchOffset=";
        String r9 = "action=";
        if (isDebugLogEnabled() == false) goto L22;
        StringBuilder r2 = new StringBuilder("[touch-enter][").append(Integer.toHexString(System.identityHashCode(this))).append("] ");
        StringBuilder r14 = new StringBuilder("action=");
        Companion r15 = Companion;
        if (r23 != null) goto L11;
        int r7 = -1;
    L12:
        StringBuilder r8 = r14.append(Companion.access$actionToString(r15, r7)).append(", x=");
        if (r23 != null) goto L15;
        Float r16 = null;
    L16:
        StringBuilder r10 = r8.append(r16).append(", y=");
        if (r23 != null) goto L19;
        Float r17 = null;
    L20:
        L.d(TAG, r2.append(r10.append(r17).append(", progress=").append(getProgress()).append(", currentProgress=").append(getCurrentProgress()).append(", isPress=").append(this.isPress).append(", isInternalUpdating=").append(this.isInternalUpdating).append(", touchOffset=").append(getMTouchProgressOffset()).toString()).toString());
        goto L22
    L19:
        r17 = Float.valueOf(r23.getY());
        goto L20
    L15:
        r16 = Float.valueOf(r23.getX());
        goto L16
    L11:
        r7 = r23.getActionMasked();
    L22:
        if (this.isInternalUpdating == true) goto L24;
        int r3 = (int) (((int) this.paddingHorizontal) + (this.thumbSize / 2));
        setPadding(r3, 0, r3, 0);
        if (r23 != null) goto L36;
        Integer r5 = null;
    L37:
        if (r23 != null) goto L39;
        Integer r11 = null;
    L41:
        if (r11 == null) goto L50;
        if (r11.intValue() != 0) goto L50;
        cancelPendingDownTrack();
        this.mTouchProgressOffset = 0.0f;
        this.touchDownX = r23.getX();
        this.touchDownY = r23.getY();
        this.hasDirectionLocked = false;
        this.isDraggingHorizontally = false;
        if (isDebugLogEnabled() == false) goto L50;
        L.d(TAG, "[touch-down-init][" + Integer.toHexString(System.identityHashCode(this)) + "] " + ("x=" + r23.getX() + ", y=" + r23.getY() + ", progress=" + getProgress() + ", currentProgress=" + getCurrentProgress() + ", thumbCenter=" + currentThumbCenterX()));
    L50:
        if (r5 != null) goto L53;
    L54:
        if (r5 != null) goto L57;
    L59:
        this.isPress = false;
        this.isThumbOnTouchDown = false;
        this.isThumbOnTouchEvent = false;
        cancelPendingDownTrack();
        invalidate();
        r4 = ", touchOffset=";
        r11 = r11;
        r9 = "action=";
        boolean r6 = false;
    L151:
        MotionEvent r12 = obtainTouchEventForNativeProgress(r23);
        if (r12 != null) goto L154;
        MotionEvent r13 = r23;
    L155:
        boolean r18 = super.onTouchEvent(r13);
        if (isDebugLogEnabled() == true) goto L158;
        String r19 = r9;
    L171:
        if (r12 == null) goto L175;
        r12.recycle();
        Unit r20 = Unit.INSTANCE;
    L175:
        if (this.isInternalUpdating == false) goto L177;
        cancelTouchByInternalUpdate(r23);
        boolean r110 = true;
    L178:
        if (r23 == null) goto L215;
        int r21 = r23.getAction();
        if (this.isInternalUpdating == true) goto L214;
        if (r21 == 0) goto L192;
        if (r21 != 2) goto L195;
        if (this.isThumbOnTouchDown == false) goto L189;
    L190:
        trackTouchEvent(r23);
        goto L195
    L189:
        if (this.isDraggingHorizontally == true) goto L190;
    L195:
        if (r21 == 1) goto L200;
        if (r21 != 3) goto L214;
    L200:
        if (isDebugLogEnabled() == false) goto L204;
        L.d(TAG, "[touch-finish][" + Integer.toHexString(System.identityHashCode(this)) + "] " + (r19 + Companion.access$actionToString(Companion, r21) + ", progress=" + getProgress() + ", currentProgress=" + getCurrentProgress() + ", isStyleSegmented=" + this.isStyleSegmented + r4 + getMTouchProgressOffset()));
    L204:
        if (r21 == 1) goto L206;
    L213:
        resetTouchTrackingState();
        goto L214
    L206:
        if (this.isStyleSegmented == false) goto L208;
        anchorPoint();
    L209:
        OnSeekBarChangeListenerExt r1 = this.onSeekBarChangeListenerExt;
        if (r1 == null) goto L213;
        r1.onTouchUp(this, toRealValue(getProgress()));
        Unit r22 = Unit.INSTANCE;
        goto L213
    L208:
        toggleProgressChangedAnim$default(this, getProgress(), null, 2, null);
        goto L209
    L192:
        if (this.isThumbOnTouchDown == false) goto L195;
        trackTouchEvent(r23);
    L214:
        Unit r24 = Unit.INSTANCE;
        Unit r25 = Unit.INSTANCE;
    L215:
        this.isInternalUpdating = false;
        setPadding(0, 0, 0, 0);
        if (isDebugLogEnabled() == false) goto L223;
        StringBuilder r26 = new StringBuilder("[touch-exit][").append(Integer.toHexString(System.identityHashCode(this))).append("] ");
        StringBuilder r27 = new StringBuilder(r19);
        Companion r28 = Companion;
        if (r11 != null) goto L221;
        int r29 = -1;
    L222:
        L.d(TAG, r26.append(r27.append(Companion.access$actionToString(r28, r29)).append(", progress=").append(getProgress()).append(", currentProgress=").append(getCurrentProgress()).append(", forceBreakTouch=").append(r110).toString()).toString());
        goto L223
    L221:
        r29 = r11.intValue();
    L223:
        if (r110 == false) goto L226;
        return false;
    L226:
        return r18;
    L177:
        r110 = r6;
        goto L178
    L158:
        StringBuilder r30 = new StringBuilder("[touch-super-result][").append(Integer.toHexString(System.identityHashCode(this))).append("] ");
        if (r12 != null) goto L161;
        MotionEvent r31 = r23;
    L162:
        r19 = r9;
        StringBuilder r32 = new StringBuilder(r19);
        Companion r33 = Companion;
        if (r31 != null) goto L165;
        int r34 = -1;
    L166:
        StringBuilder r35 = r32.append(Companion.access$actionToString(r33, r34)).append(", usedCorrectedEvent=");
        if (r12 == null) goto L169;
        boolean r36 = true;
    L170:
        L.d(TAG, r30.append(r35.append(r36).append(", progress=").append(getProgress()).append(", currentProgress=").append(getCurrentProgress()).append(", result=").append(r18).toString()).toString());
        goto L171
    L169:
        r36 = false;
        goto L170
    L165:
        r34 = r31.getActionMasked();
        goto L166
    L161:
        r31 = r12;
        goto L162
    L154:
        r13 = r12;
        goto L155
    L57:
        if (r5.intValue() != 2) goto L59;
    L60:
        this.isPress = true;
        float r111 = currentThumbCenterX();
        float r112 = this.thumbSize;
        float r37 = (r111 - (r112 / 2.0f)) - 30.0f;
        float r113 = (r111 + (r112 / 2.0f)) + 30.0f;
        if (getEnableMoveThumbOnDownOutside() == false) goto L77;
        float r114 = r23.getX();
        if (r37 <= r114) goto L65;
    L67:
        boolean r115 = false;
    L68:
        if (r115 == false) goto L77;
        this.isThumbOnTouchEvent = true;
        if (isDebugLogEnabled() == false) goto L77;
        StringBuilder r38 = new StringBuilder("[thumb-hit-area][").append(Integer.toHexString(System.identityHashCode(this))).append("] ");
        StringBuilder r116 = new StringBuilder("action=");
        Companion r39 = Companion;
        if (r11 != null) goto L75;
        int r40 = -1;
    L76:
        L.d(TAG, r38.append(r116.append(Companion.access$actionToString(r39, r40)).append(", x=").append(r23.getX()).append(", thumbLeft=").append(r37).append(", thumbRight=").append(r113).toString()).toString());
    L78:
        if (r5 != null) goto L81;
    L118:
        r6 = false;
    L119:
        if (r11 == null) goto L144;
        if (r11.intValue() != 2) goto L144;
        if (this.hasDirectionLocked == true) goto L144;
        float r41 = Math.abs(r23.getX() - this.touchDownX);
        float r42 = Math.abs(r23.getY() - this.touchDownY);
        if (r41 <= getTouchSlop()) goto L128;
    L129:
        this.hasDirectionLocked = true;
        if (r41 <= r42) goto L132;
        boolean r43 = true;
    L133:
        this.isDraggingHorizontally = r43;
        cancelPendingDownTrack();
        if (isDebugLogEnabled() == false) goto L138;
        L.d(TAG, "[direction-lock][" + Integer.toHexString(System.identityHashCode(this)) + "] " + ("dx=" + r41 + ", dy=" + r42 + ", touchSlop=" + getTouchSlop() + ", isDraggingHorizontally=" + this.isDraggingHorizontally + ", isThumbOnTouchDown=" + this.isThumbOnTouchDown));
    L138:
        if (this.isDraggingHorizontally == false) goto L141;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L144
    L141:
        if (this.isThumbOnTouchDown == true) goto L144;
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L144
    L132:
        r43 = false;
        goto L133
    L128:
        if (r42 > getTouchSlop()) goto L129;
    L144:
        if (this.isThumbOnTouchDown == false) goto L146;
    L149:
        boolean r44 = true;
    L150:
        toggleThumbScaleAnim(r44);
        invalidate();
        goto L151
    L146:
        if (this.isThumbOnTouchEvent == true) goto L149;
        r44 = false;
        goto L150
    L81:
        if (r5.intValue() != 0) goto L118;
        float r45 = r23.getX();
        if (r37 <= r45) goto L85;
    L87:
        boolean r46 = false;
    L88:
        if (r46 == false) goto L98;
        this.isThumbOnTouchDown = true;
        updateTouchProgressOffsetOnDown(r23.getX());
        getParent().requestDisallowInterceptTouchEvent(true);
        OnSeekBarChangeListenerExt r47 = this.onSeekBarChangeListenerExt;
        if (r47 == null) goto L94;
        r47.onTouchDown(this);
        Unit r48 = Unit.INSTANCE;
    L94:
        if (isDebugLogEnabled() == false) goto L104;
        L.d(TAG, "[touch-down-thumb][" + Integer.toHexString(System.identityHashCode(this)) + "] " + ("x=" + r23.getX() + ", offset=" + getMTouchProgressOffset() + ", progress=" + getProgress() + ", currentProgress=" + getCurrentProgress()));
    L104:
        r6 = false;
    L105:
        if (r6 == true) goto L119;
        if (getEnableMoveThumbOnDownOutside() == false) goto L119;
        if (this.isThumbOnTouchDown == true) goto L119;
        this.mTouchProgressOffset = 0.0f;
        OnSeekBarChangeListenerExt r49 = this.onSeekBarChangeListenerExt;
        if (r49 == null) goto L114;
        r49.onTouchDown(this);
        Unit r50 = Unit.INSTANCE;
    L114:
        this.pendingDownTrackEvent = MotionEvent.obtain(r23);
        postDelayed(this.trackDownIfNoMoveRunnable, 150);
        if (isDebugLogEnabled() == false) goto L119;
        L.d(TAG, "[delayed-track-schedule][" + Integer.toHexString(System.identityHashCode(this)) + "] " + ("x=" + r23.getX() + ", y=" + r23.getY() + ", delayMs=150"));
        goto L119
    L98:
        if (getEnableMoveThumbOnDownOutside() == true) goto L104;
        this.isPress = false;
        this.isThumbOnTouchDown = false;
        this.isThumbOnTouchEvent = false;
        r23.setAction(1);
        if (isDebugLogEnabled() == false) goto L103;
        L.d(TAG, "[touch-down-outside-break][" + Integer.toHexString(System.identityHashCode(this)) + "] " + ("x=" + r23.getX() + ", enableMoveThumbOnDownOutside=" + getEnableMoveThumbOnDownOutside()));
    L103:
        r6 = true;
        goto L105
    L85:
        if (r45 > r113) goto L87;
        r46 = true;
        goto L88
    L75:
        r40 = r11.intValue();
        goto L76
    L65:
        if (r114 > r113) goto L67;
        r115 = true;
    L77:
        r11 = r11;
        goto L78
    L53:
        if (r5.intValue() == 0) goto L60;
    L39:
        r11 = Integer.valueOf(r23.getActionMasked());
        goto L41
    L36:
        r5 = Integer.valueOf(r23.getAction());
        goto L37
    L24:
        if (isDebugLogEnabled() == false) goto L31;
        StringBuilder r51 = new StringBuilder("[touch-break-internal-update][").append(Integer.toHexString(System.identityHashCode(this))).append("] ");
        StringBuilder r52 = new StringBuilder("action=");
        Companion r53 = Companion;
        if (r23 != null) goto L29;
        int r54 = -1;
    L30:
        L.d(TAG, r51.append(r52.append(Companion.access$actionToString(r53, r54)).append(", progress=").append(getProgress()).append(", currentProgress=").append(getCurrentProgress()).toString()).toString());
        goto L31
    L29:
        r54 = r23.getActionMasked();
    L31:
        cancelTouchByInternalUpdate(r23);
        return false;
    }

    private final MotionEvent obtainTouchEventForNativeProgress(MotionEvent r13) {
        if (r13 != null) goto L6;
        return null;
    L6:
        if (r13.getAction() == 0) goto L11;
        if (r13.getAction() == 2) goto L11;
        return null;
    L11:
        if (this.isThumbOnTouchDown == false) goto L13;
    L14:
        boolean r3 = true;
        if (this.mTouchProgressOffset != 0.0f) goto L17;
        boolean r1 = true;
    L18:
        if (r1 == false) goto L21;
    L19:
        return null;
    L21:
        if (isTouchAtTrackEdge(r13.getX()) == true) goto L23;
        int r8 = getMax() - getCompatMinValue();
        if (r8 > 0) goto L30;
        return null;
    L30:
        float r2 = calculateScaleByX(r13.getX());
        float r9 = RangesKt.coerceIn((this.mTouchProgressOffset / r8) + r2, 0.0f, 1.0f);
        float r10 = calculateXByScale(r9);
        if (r10 == r13.getX()) goto L34;
        r3 = false;
    L34:
        if (r3 == false) goto L37;
        return null;
    L37:
        if (isDebugLogEnabled() == false) goto L40;
        L.d(TAG, "[native-event-correct][" + Integer.toHexString(System.identityHashCode(this)) + "] " + ("rawX=" + r13.getX() + ", scale=" + r2 + ", nativeScale=" + r9 + ", nativeX=" + r10 + ", offset=" + getMTouchProgressOffset() + ", range=" + r8));
    L40:
        MotionEvent r12 = MotionEvent.obtain(r13);
        r12.offsetLocation(r10 - r13.getX(), 0.0f);
        return r12;
    L23:
        if (isDebugLogEnabled() == false) goto L26;
        L.d(TAG, "[native-event-skip-edge][" + Integer.toHexString(System.identityHashCode(this)) + "] " + ("x=" + r13.getX() + ", logicalX=" + toLogicalTrackX(r13.getX()) + ", trackStart=" + getTrackStartX() + ", trackEnd=" + getTrackEndX() + ", offset=" + getMTouchProgressOffset()));
    L26:
        return null;
    L17:
        r1 = false;
        goto L18
    L13:
        if (this.isThumbOnTouchEvent == false) goto L19;
        goto L14
    }

    private final float calculateXByScale(float r6) {
        float r0 = this.paddingHorizontal + (this.thumbSize / 2.0f);
        float r1 = (getWidth() - this.paddingHorizontal) - (this.thumbSize / 2.0f);
        float r2 = ((r1 - r0) * RangesKt.coerceIn(r6, 0.0f, 1.0f)) + r0;
        if (isLayoutRtlForProgress() == true) goto L5;
        return r2;
    L5:
        if (this.mirrorForRtl == true) goto L7;
        return r2;
    L7:
        return (r0 + r1) - r2;
    }

    public final void toggleThumbScaleAnim(boolean r8) {
        if (this.isPressThumb != r8) goto L5;
        return;
    L5:
        this.isPressThumb = r8;
        AnimationManager r0 = this.thumbAnimator;
        if (r0 == null) goto L9;
        AnimationManager.cancelAnimation$default(r0, false, 1, null);
    L9:
        ValueAnimatable.Builder r1 = new ValueAnimatable.Builder();
        float r3 = this.thumbScale;
        if (r8 == false) goto L12;
        float r9 = this.thumbPressScale;
    L13:
        this.thumbAnimator = r1.of(r3, r9, AnimationSpecKt.spring$default(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_SHORT_4, 0, 4, null), Float.valueOf(this.thumbScaleVelocity)).onUpdate(new C03051(this)).build().start();
        return;
    L12:
        r9 = this.thumbNormalScale;
        goto L13
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void onMeasure(int r2, int r3) {
        super.onMeasure(r2, View.MeasureSpec.makeMeasureSpec(this.measureHeightPx, 1073741824));
    }

    public void setDefaultTickMarkCount(int r1) {
        this.tickMarkCount = r1;
        this.mCurrentTickIndex = -1;
        invalidate();
    }

    public final void setBackgroundHeight(float r1) {
        this.backgroundHeight = r1;
        invalidate();
    }

    public final void setProcessColorInt(int r1, int r2) {
        this.progressColor = r1;
        this.mBackgroundColor = r2;
        invalidate();
    }

    public final void setProcessBackgroundColorInt(int r1) {
        this.mBackgroundColor = r1;
        invalidate();
    }

    public final void setProcessProgressColorInt(int r1) {
        this.progressColor = r1;
        invalidate();
    }

    public final void setProcessColor(int r2, int r3) {
        this.progressColor = ContextCompat.getColor(getContext(), r2);
        this.mBackgroundColor = ContextCompat.getColor(getContext(), r3);
        invalidate();
    }

    public final void setProcessBackgroundColor(int r2) {
        this.mBackgroundColor = ContextCompat.getColor(getContext(), r2);
        invalidate();
    }

    public final void setProcessProgressColor(int r2) {
        this.progressColor = ContextCompat.getColor(getContext(), r2);
        invalidate();
    }

    public final void setTickColorInt(int r1) {
        this.tickColor = r1;
        invalidate();
    }

    public final void setTickColor(int r2) {
        this.tickColor = ContextCompat.getColor(getContext(), r2);
        invalidate();
    }

    public final void setMinVisibleProgress(int r1) {
        this.minVisibleProgress = r1;
        setCurrentProgress(getCurrentProgress());
        invalidate();
    }

    public final void setMaxVisibleProgress(int r1) {
        this.maxVisibleProgress = r1;
        setCurrentProgress(getCurrentProgress());
        invalidate();
    }

    public final void setThumbColorInt(int r1) {
        this.thumbColor = r1;
        invalidate();
    }

    public final void setThumbColor(int r2) {
        this.thumbColor = ContextCompat.getColor(getContext(), r2);
        invalidate();
    }

    public static /* synthetic */ void setIsSegmented$default(TickMarkSeekBar r1, boolean r2, int r3, int r4, int r5, Object r6) {
        if (r6 != null) goto L12;
        if ((r5 & 2) == 0) goto L7;
        r3 = 0;
    L7:
        if ((r5 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        r1.setIsSegmented(r2, r3, r4);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setIsSegmented");
    }

    public final void setIsSegmented(boolean r1, int r2, int r3) {
        this.isStyleSegmented = r1;
        if (r1 == false) goto L5;
        setProgressDrawable(null);
        this.mCurrentTickIndex = r3;
        this.tickMarkCount = r2;
        setProgress(resolveSegmentedProgressByIndex(r3));
    L6:
        anchorPoint();
        invalidate();
        return;
    L5:
        this.tickMarkCount = -1;
        this.mCurrentTickIndex = -1;
        goto L6
    }

    @Override // android.widget.ProgressBar, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "dr");
        super.invalidateDrawable(r2);
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int r4) {
        super.setProgress(r4);
        if (isDebugLogEnabled() == false) goto L6;
        L.d(TAG, "[setProgress][" + Integer.toHexString(System.identityHashCode(this)) + "] " + ("progress=" + r4 + ", isPress=" + this.isPress + ", currentProgress=" + getCurrentProgress() + ", currentTargetProgress=" + this.currentTargetProgress));
    L6:
        this.isThumbOnTouchDown = true;
        if (this.isPress == false) goto L9;
        this.isInternalUpdating = true;
    L9:
        toggleProgressChangedAnim$default(this, r4, null, 2, null);
        this.isThumbOnTouchDown = false;
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int r4, boolean r5) {
        super.setProgress(r4, r5);
        if (isDebugLogEnabled() == false) goto L7;
        L.d(TAG, "[setProgressWithAnimate][" + Integer.toHexString(System.identityHashCode(this)) + "] " + ("progress=" + r4 + ", animate=" + r5 + ", isPress=" + this.isPress + ", currentProgress=" + getCurrentProgress() + ", currentTargetProgress=" + this.currentTargetProgress));
    L7:
        if (r5 == true) goto L10;
        this.isThumbOnTouchDown = true;
    L10:
        if (this.isPress == false) goto L12;
        this.isInternalUpdating = true;
    L12:
        toggleProgressChangedAnim$default(this, r4, null, 2, null);
        this.isThumbOnTouchDown = false;
    }

    public final void setOnSeekBarChangeListenerExt(OnSeekBarChangeListenerExt r1) {
        this.onSeekBarChangeListenerExt = r1;
        super.setOnSeekBarChangeListener(new AnonymousClass1(this));
    }

    static /* synthetic */ boolean toggleProgressChangedAnim$default(TickMarkSeekBar r0, float r1, Runnable r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L7;
        r2 = null;
    L7:
        return r0.toggleProgressChangedAnim(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toggleProgressChangedAnim");
    }

    private final boolean toggleProgressChangedAnim(float r9, final Runnable r10) {
        if (getCurrentProgress() != r9) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return false;
    L9:
        if (this.isThumbOnTouchDown == false) goto L11;
    L28:
        AnimationManager r1 = this.progressAnimator;
        if (r1 == null) goto L32;
        AnimationManager.cancelAnimation$default(r1, false, 1, null);
    L32:
        setCurrentProgress(r9);
        this.currentTargetProgress = getCurrentProgress();
        invalidate();
        if (r10 == null) goto L36;
        r10.run();
    L36:
        return true;
    L11:
        if (this.isThumbOnTouchEvent == true) goto L28;
        if (this.currentTargetProgress != r9) goto L16;
        boolean r2 = true;
    L17:
        if (r2 == true) goto L23;
        AnimationManager r3 = this.progressAnimator;
        if (r3 == null) goto L22;
        AnimationManager.cancelAnimation$default(r3, false, 1, null);
    L22:
        this.currentTargetProgress = r9;
        ValueAnimatable.Builder r11 = new ValueAnimatable.Builder();
        float r4 = getCurrentProgress();
        float r5 = this.currentTargetProgress;
        FloatSpringSpec r6 = AnimationSpecKt.spring$default(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_SHORT_4, 0, 4, null);
        r6.setAccuracy(0.1f);
        Unit r7 = Unit.INSTANCE;
        this.progressAnimator = r11.of(r4, r5, r6, Float.valueOf(this.currentProgressVelocity)).onUpdate(new AnonymousClass2(this)).onEnd(new AnonymousClass3(r10)).build().start();
        invalidate();
    L27:
        return true;
    L23:
        setCurrentProgress(r9);
        this.currentTargetProgress = r9;
        invalidate();
        if (r10 == null) goto L27;
        r10.run();
        goto L27
    L16:
        r2 = false;
        goto L17
    L5:
        r0 = false;
        goto L6
    }

    public final float getMTouchProgressOffset() {
        return this.mTouchProgressOffset;
    }

    public final void setMTouchProgressOffset(float r1) {
        this.mTouchProgressOffset = r1;
    }

    private final void updateTouchProgressOffsetOnDown(float r7) {
        int r0 = getCompatMinValue();
        int r1 = getMax() - r0;
        if (r1 > 0) goto L6;
        this.mTouchProgressOffset = 0.0f;
        return;
    L6:
        float r2 = calculateScaleByX(r7);
        this.mTouchProgressOffset = getCurrentProgress() - ((r1 * r2) + r0);
        if (isDebugLogEnabled() == false) goto L11;
        L.d(TAG, "[touch-offset-update][" + Integer.toHexString(System.identityHashCode(this)) + "] " + ("downX=" + r7 + ", scale=" + r2 + ", minValue=" + r0 + ", range=" + r1 + ", currentProgress=" + getCurrentProgress() + ", touchOffset=" + getMTouchProgressOffset()));
        return;
    }

    private final float calculateScaleByX(float r5) {
        float r0 = getTrackStartX();
        float r1 = getTrackEndX() - r0;
        if (r1 > 0.0f) goto L6;
        return 0.0f;
    L6:
        return RangesKt.coerceIn((toLogicalTrackX(r5) - r0) / r1, 0.0f, 1.0f);
    }

    private final float getTrackStartX() {
        return this.paddingHorizontal + (this.thumbSize / 2.0f);
    }

    private final float getTrackEndX() {
        return (getWidth() - this.paddingHorizontal) - (this.thumbSize / 2.0f);
    }

    private final float toLogicalTrackX(float r4) {
        float r0 = getTrackStartX();
        float r1 = getTrackEndX();
        if (isLayoutRtlForProgress() == true) goto L5;
        return r4;
    L5:
        if (this.mirrorForRtl == true) goto L7;
        return r4;
    L7:
        return (r0 + r1) - r4;
    }

    private final boolean isTouchAtTrackEdge(float r8) {
        float r0 = toLogicalTrackX(r8);
        boolean r2 = true;
        if (r0 > getTrackStartX()) goto L5;
        boolean r1 = true;
    L7:
        if (r0 < getTrackEndX()) goto L9;
        boolean r4 = true;
    L10:
        if (r1 == true) goto L14;
        if (r4 == true) goto L14;
        r2 = false;
    L14:
        if (r2 == true) goto L16;
    L19:
        return r2;
    L16:
        if (isDebugLogEnabled() == false) goto L19;
        L.d(TAG, "[track-edge-hit][" + Integer.toHexString(System.identityHashCode(this)) + "] " + ("rawX=" + r8 + ", logicalX=" + r0 + ", hitStart=" + r1 + ", hitEnd=" + r4 + ", trackStart=" + getTrackStartX() + ", trackEnd=" + getTrackEndX()));
        goto L19
    L9:
        r4 = false;
        goto L10
    L5:
        r1 = false;
        goto L7
    }

    private final boolean isLayoutRtlForProgress() {
        if (getLayoutDirection() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private final int getCompatMinValue() {
        return getMin();
    }

    private final void trackTouchEvent(MotionEvent r6) {
        int r0 = getCompatMinValue();
        int r1 = getMax() - r0;
        if (r1 > 0) goto L6;
        return;
    L6:
        if (isTouchAtTrackEdge(r6.getX()) == false) goto L11;
        if (toLogicalTrackX(r6.getX()) > getTrackStartX()) goto L11;
        float r2 = r0;
    L17:
        if (isDebugLogEnabled() == false) goto L20;
        L.d(TAG, "[track-touch][" + Integer.toHexString(System.identityHashCode(this)) + "] " + ("x=" + r6.getX() + ", logicalX=" + toLogicalTrackX(r6.getX()) + ", progress=" + getProgress() + ", currentProgress=" + getCurrentProgress() + ", newProgress=" + r2 + ", minValue=" + r0 + ", max=" + getMax() + ", touchOffset=" + getMTouchProgressOffset()));
    L20:
        toggleProgressChangedAnim$default(this, r2, null, 2, null);
        return;
    L11:
        if (isTouchAtTrackEdge(r6.getX()) == true) goto L13;
    L15:
        float r3 = this.mTouchProgressOffset + (calculateScaleByX(r6.getX()) * r1);
        float r4 = r0;
        r2 = RangesKt.coerceIn(r3 + r4, r4, getMax());
        goto L17
    L13:
        if (toLogicalTrackX(r6.getX()) < getTrackEndX()) goto L15;
        r2 = getMax();
        goto L17
    }

    private final void anchorPoint() {
        if (this.isStyleSegmented == false) goto L35;
        final int r1 = 0;
        IntRange r0 = RangesKt.until(0, this.tickMarkCount);
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<Integer> r3 = r0.iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        r2.add(Integer.valueOf(resolveSegmentedProgressByIndex(((IntIterator) r3).nextInt())));
        goto L6
    L8:
        ArrayList r4 = r2;
        Iterator<Integer> r5 = CollectionsKt.getIndices(r4).iterator();
        if (r5.hasNext() == true) goto L11;
        Integer r6 = null;
    L21:
        Integer r7 = r6;
        if (r7 == null) goto L25;
        r1 = r7.intValue();
    L25:
        int r8 = ((Number) r4.get(r1)).intValue();
        Runnable r9 = new TickMarkSeekBar$$ExternalSyntheticLambda0(this, r1);
        boolean r10 = toggleProgressChangedAnim(r8, r9);
        if (isDebugLogEnabled() == false) goto L29;
        L.d(TAG, "[anchor-point][" + Integer.toHexString(System.identityHashCode(this)) + "] " + ("closestTickIndex=" + r1 + ", closestProgress=" + r8 + ", currentProgress=" + getCurrentProgress() + ", result=" + r10));
    L29:
        if (r10 == true) goto L36;
        r9.run();
        return;
    L36:
        return;
    L11:
        Integer r11 = r5.next();
        if (r5.hasNext() == true) goto L14;
    L13:
        r6 = r11;
        goto L21
    L14:
        int r12 = Math.abs(((Number) r4.get(r11.intValue())).intValue() - getProgress());
    L15:
        Integer r13 = r5.next();
        int r14 = Math.abs(((Number) r4.get(r13.intValue())).intValue() - getProgress());
        if (r12 <= r14) goto L19;
        r11 = r13;
        r12 = r14;
    L19:
        if (r5.hasNext() == true) goto L15;
    }

    /* JADX INFO: renamed from: anchorPoint$lambda-32, reason: not valid java name */
    private static final void m1395anchorPoint$lambda32(TickMarkSeekBar r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.mCurrentTickIndex = r2;
        OnSeekBarChangeListenerExt r0 = r1.onSeekBarChangeListenerExt;
        if (r0 == null) goto L6;
        r0.onSegmentedPositionChanged(r2);
    L6:
        r1.invalidate();
    }

    private final int resolveSegmentedProgressByIndex(int r4) {
        int r0 = this.tickMarkCount;
        if (r0 > 1) goto L6;
        return 0;
    L6:
        if (r4 > 0) goto L10;
        return getCompatMinValue();
    L10:
        if (r4 >= (r0 - 1)) goto L12;
        int r1 = getCompatMinValue();
        return MathKt.roundToInt(r1 + ((getMax() - r1) * (r4 / (this.tickMarkCount - 1))));
    L12:
        return getMax();
    }

    private final float toRealValue(int r4) {
        return round$default(this, r4 / 100, 0, 1, null);
    }

    static /* synthetic */ float round$default(TickMarkSeekBar r0, float r1, int r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L7;
        r2 = 2;
    L7:
        return r0.round(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: round");
    }

    private final float round(float r4, int r5) {
        String r3 = String.format(Locale.CHINA, "%." + r5 + 'f', Arrays.copyOf(new Object[]{Float.valueOf(r4)}, 1));
        Intrinsics.checkNotNullExpressionValue(r3, "format(locale, this, *args)");
        return Float.parseFloat(r3);
    }

    private final void cancelTouchByInternalUpdate(MotionEvent r5) {
        if (isDebugLogEnabled() == false) goto L10;
        StringBuilder r0 = new StringBuilder("[internal-update-cancel][").append(Integer.toHexString(System.identityHashCode(this))).append("] ");
        StringBuilder r1 = new StringBuilder("action=");
        Companion r2 = Companion;
        if (r5 != null) goto L8;
        int r3 = -1;
    L9:
        L.d(TAG, r0.append(r1.append(Companion.access$actionToString(r2, r3)).append(", progress=").append(getProgress()).append(", currentProgress=").append(getCurrentProgress()).append(", touchOffset=").append(getMTouchProgressOffset()).toString()).toString());
        goto L10
    L8:
        r3 = r5.getActionMasked();
    L10:
        this.isPress = false;
        resetTouchTrackingState();
        if (r5 == null) goto L14;
        MotionEvent r6 = MotionEvent.obtain(r5);
        r6.setAction(3);
        super.onTouchEvent(r6);
        r6.recycle();
    L14:
        this.isInternalUpdating = false;
    }

    private final void resetTouchTrackingState() {
        if (isDebugLogEnabled() == false) goto L6;
        L.d(TAG, "[reset-touch-state][" + Integer.toHexString(System.identityHashCode(this)) + "] " + ("isThumbOnTouchDown=" + this.isThumbOnTouchDown + ", isThumbOnTouchEvent=" + this.isThumbOnTouchEvent + ", hasDirectionLocked=" + this.hasDirectionLocked + ", isDraggingHorizontally=" + this.isDraggingHorizontally));
    L6:
        this.isThumbOnTouchDown = false;
        this.isThumbOnTouchEvent = false;
        this.hasDirectionLocked = false;
        this.isDraggingHorizontally = false;
        cancelPendingDownTrack();
        toggleThumbScaleAnim(false);
        getParent().requestDisallowInterceptTouchEvent(false);
    }
}
