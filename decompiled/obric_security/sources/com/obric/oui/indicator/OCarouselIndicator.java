package com.obric.oui.indicator;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedanceos.security.Utils;
import com.bytedanceos.securitycenter.appBgBatteryControl.AppBgBatteryControlDataHelper;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.utils.log.L;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: OCarouselIndicator.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u0089\u00012\u00020\u0001:\b\u0089\u0001\u008a\u0001\u008b\u0001\u008c\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010/\u001a\u00020!2\f\u00100\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0007H\u0017J \u00104\u001a\u0002022\u0006\u00103\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u000207H\u0002J(\u00108\u001a\u0002022\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020?H\u0002J\u0018\u0010@\u001a\u0002022\u0006\u00109\u001a\u00020:2\u0006\u0010A\u001a\u00020<H\u0002J \u0010B\u001a\u0002022\u0006\u0010C\u001a\u00020\u00072\u0006\u0010D\u001a\u00020\u00072\u0006\u0010E\u001a\u00020?H\u0002J \u0010F\u001a\u0002022\u0006\u0010C\u001a\u00020\u00072\u0006\u0010D\u001a\u00020\u00072\u0006\u0010E\u001a\u00020?H\u0002J\b\u0010G\u001a\u000202H\u0002J\b\u0010H\u001a\u000202H\u0002J\u0010\u0010I\u001a\u0002022\u0006\u00106\u001a\u000207H\u0002J \u0010J\u001a\u0002022\u0006\u0010K\u001a\u0002072\u0006\u0010L\u001a\u0002072\u0006\u0010>\u001a\u00020?H\u0002J\u0010\u0010M\u001a\u0002022\u0006\u0010N\u001a\u00020$H\u0002J\b\u0010O\u001a\u00020PH\u0016J\u0010\u0010Q\u001a\u0002022\u0006\u00109\u001a\u00020:H\u0002J\b\u0010R\u001a\u000202H\u0002J\b\u0010S\u001a\u00020\u0018H\u0002J\u001e\u0010T\u001a\u0002022\u0006\u0010C\u001a\u00020\u00072\u0006\u0010D\u001a\u00020\u00072\u0006\u0010E\u001a\u00020?J\u0012\u0010U\u001a\u0004\u0018\u00010$2\u0006\u0010V\u001a\u00020\u0007H\u0002J\u0012\u0010W\u001a\u0002022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J \u0010X\u001a\u00020?2\u0006\u0010Y\u001a\u00020?2\u0006\u0010Z\u001a\u00020?2\u0006\u0010>\u001a\u00020?H\u0002J\b\u0010[\u001a\u000202H\u0014J\b\u0010\\\u001a\u000202H\u0014J\b\u0010]\u001a\u000202H\u0014J\b\u0010^\u001a\u000202H\u0014J\u0018\u0010_\u001a\u0002022\u0006\u00106\u001a\u0002072\u0006\u0010`\u001a\u00020aH\u0002J\u0016\u0010b\u001a\u0002022\f\u0010c\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002J\u0010\u0010d\u001a\u0002022\u0006\u00103\u001a\u00020\u0007H\u0016J\b\u0010e\u001a\u000202H\u0016J\u0018\u0010f\u001a\u0002022\u0006\u0010N\u001a\u00020$2\u0006\u0010g\u001a\u00020\u0007H\u0002J\b\u0010h\u001a\u000202H\u0002J\b\u0010i\u001a\u000202H\u0002J\u0010\u0010j\u001a\u0002022\u0006\u00103\u001a\u00020\u0007H\u0017J\u0018\u0010k\u001a\u0002022\u0006\u0010l\u001a\u00020\u00072\u0006\u0010`\u001a\u00020aH\u0002J\u0010\u0010m\u001a\u00020n2\u0006\u0010(\u001a\u00020\u0007H\u0002J\u0010\u0010o\u001a\u00020?2\u0006\u0010A\u001a\u00020<H\u0002J\u0010\u0010p\u001a\u00020?2\u0006\u0010A\u001a\u00020<H\u0002J\u000f\u0010q\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010rJ\u001e\u0010s\u001a\b\u0012\u0004\u0012\u00020u0t2\u0006\u0010v\u001a\u00020\u00072\u0006\u0010w\u001a\u00020xH\u0002J\u0012\u0010y\u001a\u0004\u0018\u00010,2\u0006\u0010z\u001a\u00020uH\u0002J\u0018\u0010{\u001a\u00020<2\u0006\u0010N\u001a\u00020$2\u0006\u00106\u001a\u000207H\u0002J\u0018\u0010|\u001a\u0002072\u0006\u0010v\u001a\u00020\u00072\u0006\u0010l\u001a\u00020\u0007H\u0002J\b\u0010}\u001a\u00020?H\u0002J\u000f\u0010~\u001a\u0002022\u0007\u0010\u007f\u001a\u00030\u0080\u0001J\u0011\u0010~\u001a\u0002022\t\b\u0001\u0010\u0081\u0001\u001a\u00020\u0007J\u0012\u0010\u0082\u0001\u001a\u00020\u00142\u0007\u0010\u0083\u0001\u001a\u00020xH\u0002J\u001a\u0010\u0084\u0001\u001a\u0002022\u0006\u00109\u001a\u00020:2\u0007\u0010\u0085\u0001\u001a\u00020\u0014H\u0002J\t\u0010\u0086\u0001\u001a\u000202H\u0002J\t\u0010\u0087\u0001\u001a\u000202H\u0002J\r\u0010\u0088\u0001\u001a\u00020\u0007*\u00020xH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R$\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010%\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00078\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001c\"\u0004\b'\u0010\u001eR$\u0010(\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010\u001eR\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u008d\u0001"}, d2 = {"Lcom/obric/oui/indicator/OCarouselIndicator;", "Lcom/obric/oui/indicator/OBaseIndicator;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "argbEvaluator", "Landroid/animation/ArgbEvaluator;", "custom", "Lcom/obric/oui/indicator/OBaseIndicator$CustomDot;", "getCustom", "()Lcom/obric/oui/indicator/OBaseIndicator$CustomDot;", "dotsTrackLayout", "Landroid/widget/LinearLayout;", "groupLayout", "Lcom/obric/oui/indicator/IndicatorGroupLayout;", "hasExplicitDotsHeight", "", "hasExplicitDotsSpacing", "hasExplicitDotsWidth", "indicatorAnimator", "Lcom/obric/oui/indicator/IndicatorAnimator;", "value", "maxVisibleDots", "getMaxVisibleDots", "()I", "setMaxVisibleDots", "(I)V", "recycledDefaultDots", "Ljava/util/ArrayDeque;", "Lcom/obric/oui/indicator/IndicatorDotView;", "renderedSlot", "", "Lcom/obric/oui/indicator/OCarouselIndicator$RenderSlot;", "selectedDotColor", "getSelectedDotColor", "setSelectedDotColor", "sizeStyle", "getSizeStyle", "setSizeStyle", "startDrawableDotView", "Lcom/obric/oui/indicator/IndicatorImageDotView;", "viewportTransitionInterpolator", "Landroid/view/animation/DecelerateInterpolator;", "acquireDefaultDotView", "reusableDefaultDots", "addDot", "", Utils.INTENT_KEY_INDEX, "applyDotColorIfVisible", "color", "state", "Lcom/obric/oui/indicator/IndicatorViewportState;", "applyDotTransitionVisualState", "dotView", "Landroid/view/View;", "sourceVisualState", "Lcom/obric/oui/indicator/IndicatorDotVisualState;", "targetVisualState", "progress", "", "applyDotVisualState", "visualState", "applyPageScroll", "selectedPosition", "nextPosition", "positionOffset", "applyScrollColors", "applySizeStyle", "applySmallPicBackgroundPadding", "applyViewportState", "applyViewportTransitionProgress", "sourceState", "targetState", "bindSlot", "slot", "buildOnPageChangedListener", "Lcom/obric/oui/indicator/OnPageChangeListenerHelper;", "cancelDotAnimation", "cancelVisibleDotAnimations", "createViewportTransitionAnimator", "dispatchManualPageScroll", "findVisibleSlot", "pageIndex", "init", "interpolate", "start", TraceStatsConsts.STATS_KEY_END, "onRefreshDotsDraws", "onRefreshDotsSize", "onRefreshDotsSpacing", "onRefreshIndicator", "rebindVisibleSlots", AppBgBatteryControlDataHelper.ItemColumns.REASON, "Lcom/obric/oui/indicator/IndicatorAnimator$RenderReason;", "recycleDefaultDots", "defaultDots", "refreshDotDraw", "refreshParentLayout", "refreshRenderedSlot", "currentItem", "refreshVisibleDotsDraws", "refreshVisibleDotsSize", "removeDot", "renderViewportState", PerfConsts.KEY_CURRENT_GALVANIC, "resolveDotLayoutProfile", "Lcom/obric/oui/indicator/OCarouselIndicator$DotLayoutProfile;", "resolveDotTargetAlpha", "resolveDotTargetScale", "resolvePicStableContentWidth", "()Ljava/lang/Integer;", "resolveRenderSlotBindings", "", "Lcom/obric/oui/indicator/OCarouselIndicator$SlotBinding;", "totalCount", "visibleRange", "Lkotlin/ranges/IntRange;", "resolveReplacementView", "binding", "resolveSlotVisualState", "resolveViewportState", "resolveViewportStepDistance", "setStartDotDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "iconResId", "shouldRebindVisibleSlots", "targetRange", "updateDotLayout", "preserveMargins", "updatePicStableContentWidth", "updateVisibleDotsSpacing", PerfConsts.PERF_DISK_FILE_SIZE, "Companion", "DotLayoutProfile", "RenderSlot", "SlotBinding", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OCarouselIndicator extends OBaseIndicator {
    public static final Companion Companion = null;
    private static final int DEFAULT_CORNER_RADIUS = 100;
    private static final float EDGE_DOT_SCALE = 0.5f;
    private static final boolean IF_DEBUG = false;
    private static final float INACTIVE_DOT_ALPHA = 0.35f;
    private static final float SIZE_STYLE_SMALL_DP = 4.0f;
    private static final float SIZE_STYLE_SMALL_SPACING_DP = 2.0f;
    private static final float SMALL_PIC_BACKGROUND_HORIZONTAL_PADDING_DP = 4.0f;
    private static final float SMALL_PIC_BACKGROUND_VERTICAL_PADDING_DP = 4.0f;
    public static final String TAG = "OCarouselIndicator";
    private final ArgbEvaluator argbEvaluator;
    private LinearLayout dotsTrackLayout;
    private IndicatorGroupLayout groupLayout;
    private boolean hasExplicitDotsHeight;
    private boolean hasExplicitDotsSpacing;
    private boolean hasExplicitDotsWidth;
    private IndicatorAnimator indicatorAnimator;
    private int maxVisibleDots;
    private final ArrayDeque<IndicatorDotView> recycledDefaultDots;
    private final List<RenderSlot> renderedSlot;
    private int selectedDotColor;
    private int sizeStyle;
    private IndicatorImageDotView startDrawableDotView;
    private final DecelerateInterpolator viewportTransitionInterpolator;

    /* JADX INFO: compiled from: OCarouselIndicator.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/indicator/OCarouselIndicator$Companion;", "", "()V", "DEFAULT_CORNER_RADIUS", "", "EDGE_DOT_SCALE", "", "IF_DEBUG", "", "INACTIVE_DOT_ALPHA", "SIZE_STYLE_SMALL_DP", "SIZE_STYLE_SMALL_SPACING_DP", "SMALL_PIC_BACKGROUND_HORIZONTAL_PADDING_DP", "SMALL_PIC_BACKGROUND_VERTICAL_PADDING_DP", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: OCarouselIndicator.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/obric/oui/indicator/OCarouselIndicator$DotLayoutProfile;", "", MaterialConfigFormatNames.WIDTH, "", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "spacing", "(FFF)V", "getHeight", "()F", "getSpacing", "getWidth", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class DotLayoutProfile {
        private final float height;
        private final float spacing;
        private final float width;

        public static /* synthetic */ DotLayoutProfile copy$default(DotLayoutProfile r0, float r1, float r2, float r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.width;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.height;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.spacing;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final float component1() {
            return this.width;
        }

        public final float component2() {
            return this.height;
        }

        public final float component3() {
            return this.spacing;
        }

        public final DotLayoutProfile copy(float r1, float r2, float r3) {
            return new DotLayoutProfile(r1, r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof DotLayoutProfile) == true) goto L8;
            return false;
        L8:
            DotLayoutProfile r6 = (DotLayoutProfile) r5;
            if (Intrinsics.areEqual(Float.valueOf(this.width), Float.valueOf(r6.width)) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(Float.valueOf(this.height), Float.valueOf(r6.height)) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(Float.valueOf(this.spacing), Float.valueOf(r6.spacing)) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Float.hashCode(this.width) * 31) + Float.hashCode(this.height)) * 31) + Float.hashCode(this.spacing);
        }

        public String toString() {
            return "DotLayoutProfile(width=" + this.width + ", height=" + this.height + ", spacing=" + this.spacing + ')';
        }

        public DotLayoutProfile(float r1, float r2, float r3) {
            this.width = r1;
            this.height = r2;
            this.spacing = r3;
        }

        public final float getWidth() {
            return this.width;
        }

        public final float getHeight() {
            return this.height;
        }

        public final float getSpacing() {
            return this.spacing;
        }
    }

    /* JADX INFO: compiled from: OCarouselIndicator.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/obric/oui/indicator/OCarouselIndicator$RenderSlot;", "", "binding", "Lcom/obric/oui/indicator/OCarouselIndicator$SlotBinding;", "view", "Landroid/view/View;", "indicator", "Lcom/obric/oui/indicator/IndicatorIcon;", "(Lcom/obric/oui/indicator/OCarouselIndicator$SlotBinding;Landroid/view/View;Lcom/obric/oui/indicator/IndicatorIcon;)V", "getBinding", "()Lcom/obric/oui/indicator/OCarouselIndicator$SlotBinding;", "getIndicator", "()Lcom/obric/oui/indicator/IndicatorIcon;", "getView", "()Landroid/view/View;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class RenderSlot {
        private final SlotBinding binding;
        private final IndicatorIcon indicator;
        private final View view;

        public static /* synthetic */ RenderSlot copy$default(RenderSlot r0, SlotBinding r1, View r2, IndicatorIcon r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.binding;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.view;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.indicator;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final SlotBinding component1() {
            return this.binding;
        }

        public final View component2() {
            return this.view;
        }

        public final IndicatorIcon component3() {
            return this.indicator;
        }

        public final RenderSlot copy(SlotBinding r1, View r2, IndicatorIcon r3) {
            Intrinsics.checkNotNullParameter(r1, "binding");
            Intrinsics.checkNotNullParameter(r2, "view");
            Intrinsics.checkNotNullParameter(r3, "indicator");
            return new RenderSlot(r1, r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof RenderSlot) == true) goto L8;
            return false;
        L8:
            RenderSlot r6 = (RenderSlot) r5;
            if (Intrinsics.areEqual(this.binding, r6.binding) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.view, r6.view) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.indicator, r6.indicator) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.binding.hashCode() * 31) + this.view.hashCode()) * 31) + this.indicator.hashCode();
        }

        public String toString() {
            return "RenderSlot(binding=" + this.binding + ", view=" + this.view + ", indicator=" + this.indicator + ')';
        }

        public RenderSlot(SlotBinding r2, View r3, IndicatorIcon r4) {
            Intrinsics.checkNotNullParameter(r2, "binding");
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "indicator");
            this.binding = r2;
            this.view = r3;
            this.indicator = r4;
        }

        public final SlotBinding getBinding() {
            return this.binding;
        }

        public final View getView() {
            return this.view;
        }

        public final IndicatorIcon getIndicator() {
            return this.indicator;
        }
    }

    /* JADX INFO: compiled from: OCarouselIndicator.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/obric/oui/indicator/OCarouselIndicator$SlotBinding;", "", "()V", "LeadingDummy", "Page", "TrailingDummy", "Lcom/obric/oui/indicator/OCarouselIndicator$SlotBinding$Page;", "Lcom/obric/oui/indicator/OCarouselIndicator$SlotBinding$LeadingDummy;", "Lcom/obric/oui/indicator/OCarouselIndicator$SlotBinding$TrailingDummy;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static abstract class SlotBinding {

        /* JADX INFO: compiled from: OCarouselIndicator.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/oui/indicator/OCarouselIndicator$SlotBinding$LeadingDummy;", "Lcom/obric/oui/indicator/OCarouselIndicator$SlotBinding;", "()V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class LeadingDummy extends SlotBinding {
            public static final LeadingDummy INSTANCE = null;

            static {
                INSTANCE = new LeadingDummy();
            }

            private LeadingDummy() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: OCarouselIndicator.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/indicator/OCarouselIndicator$SlotBinding$Page;", "Lcom/obric/oui/indicator/OCarouselIndicator$SlotBinding;", "pageIndex", "", "(I)V", "getPageIndex", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Page extends SlotBinding {
            private final int pageIndex;

            public static /* synthetic */ Page copy$default(Page r0, int r1, int r2, Object r3) {
                if ((r2 & 1) == 0) goto L6;
                r1 = r0.pageIndex;
            L6:
                return r0.copy(r1);
            }

            public final int component1() {
                return this.pageIndex;
            }

            public final Page copy(int r1) {
                return new Page(r1);
            }

            public boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof Page) == true) goto L9;
                return false;
            L9:
                if (this.pageIndex == ((Page) r4).pageIndex) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return Integer.hashCode(this.pageIndex);
            }

            public String toString() {
                return "Page(pageIndex=" + this.pageIndex + ')';
            }

            public Page(int r2) {
                super(null);
                this.pageIndex = r2;
            }

            public final int getPageIndex() {
                return this.pageIndex;
            }
        }

        /* JADX INFO: compiled from: OCarouselIndicator.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/oui/indicator/OCarouselIndicator$SlotBinding$TrailingDummy;", "Lcom/obric/oui/indicator/OCarouselIndicator$SlotBinding;", "()V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class TrailingDummy extends SlotBinding {
            public static final TrailingDummy INSTANCE = null;

            static {
                INSTANCE = new TrailingDummy();
            }

            private TrailingDummy() {
                super(null);
            }
        }

        public /* synthetic */ SlotBinding(DefaultConstructorMarker r1) {
            this();
        }

        private SlotBinding() {
        }
    }

    /* JADX INFO: compiled from: OCarouselIndicator.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[IndicatorDotVisualState.values().length];
            r0[IndicatorDotVisualState.EDGE.ordinal()] = 1;
            r0[IndicatorDotVisualState.HIDDEN.ordinal()] = 2;
            r0[IndicatorDotVisualState.ACTIVE.ordinal()] = 3;
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static /* synthetic */ void $r8$lambda$rWQ3ZeSCoMg62hnLD5e222xBvkE(RenderSlot r0, OCarouselIndicator r1, View r2) {
        m376bindSlot$lambda12(r0, r1, r2);
    }

    static {
        Companion = new Companion(null);
    }

    public OCarouselIndicator(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OCarouselIndicator(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    private final float interpolate(float r1, float r2, float r3) {
        return r1 + ((r2 - r1) * r3);
    }

    public /* synthetic */ OCarouselIndicator(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ void access$applyPageScroll(OCarouselIndicator r0, int r1, int r2, float r3) {
        r0.applyPageScroll(r1, r2, r3);
    }

    public static final /* synthetic */ void access$applyViewportState(OCarouselIndicator r0, IndicatorViewportState r1) {
        r0.applyViewportState(r1);
    }

    public static final /* synthetic */ void access$applyViewportTransitionProgress(OCarouselIndicator r0, IndicatorViewportState r1, IndicatorViewportState r2, float r3) {
        r0.applyViewportTransitionProgress(r1, r2, r3);
    }

    public static final /* synthetic */ void access$cancelVisibleDotAnimations(OCarouselIndicator r0) {
        r0.cancelVisibleDotAnimations();
    }

    public static final /* synthetic */ void access$rebindVisibleSlots(OCarouselIndicator r0, IndicatorViewportState r1, IndicatorAnimator.RenderReason r2) {
        r0.rebindVisibleSlots(r1, r2);
    }

    public static final /* synthetic */ float access$resolveViewportStepDistance(OCarouselIndicator r0) {
        return r0.resolveViewportStepDistance();
    }

    public static final /* synthetic */ boolean access$shouldRebindVisibleSlots(OCarouselIndicator r0, IntRange r1) {
        return r0.shouldRebindVisibleSlots(r1);
    }

    public OCarouselIndicator(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.renderedSlot = new ArrayList();
        this.recycledDefaultDots = new ArrayDeque();
        this.viewportTransitionInterpolator = new DecelerateInterpolator();
        this.maxVisibleDots = Integer.MAX_VALUE;
        this.selectedDotColor = ContextCompat.getColor(r2, R.color.oui_text_1);
        this.argbEvaluator = new ArgbEvaluator();
        init(r3);
        setInitComplete();
    }

    public final int getMaxVisibleDots() {
        return this.maxVisibleDots;
    }

    public final void setMaxVisibleDots(int r2) {
        if (this.maxVisibleDots == r2) goto L6;
        this.maxVisibleDots = r2;
        refreshDots();
        return;
    }

    public final int getSizeStyle() {
        return this.sizeStyle;
    }

    public final void setSizeStyle(int r2) {
        if (this.sizeStyle == r2) goto L6;
        this.sizeStyle = r2;
        applySizeStyle();
        refreshDots();
        return;
    }

    public final void setStartDotDrawable(int r3) {
        if (r3 == 0) goto L5;
        Drawable r1 = ContextCompat.getDrawable(getContext(), r3);
        if (r1 == null) goto L11;
        setStartDotDrawable(r1);
        return;
    L11:
        if (IF_DEBUG == false) goto L17;
        L.i(TAG, Intrinsics.stringPlus("setStartDotDrawable(iconResId) ignored, drawable not found for resId=", Integer.valueOf(r3)));
        return;
    L17:
        return;
    L5:
        if (IF_DEBUG == false) goto L16;
        L.i(TAG, "setStartDotDrawable(iconResId) ignored, iconResId=0");
        return;
    }

    public final void setStartDotDrawable(Drawable r5) {
        Intrinsics.checkNotNullParameter(r5, "drawable");
        Drawable.ConstantState r6 = r5.getConstantState();
        if (r6 != null) goto L6;
        L.w(TAG, "setStartDotDrawable(drawable) ignored, drawable.constantState is null");
        return;
    L6:
        Drawable r7 = r6.newDrawable(getResources()).mutate();
        Intrinsics.checkNotNullExpressionValue(r7, "constantState.newDrawable(resources).mutate()");
        Context r2 = getContext();
        Intrinsics.checkNotNullExpressionValue(r2, "context");
        this.startDrawableDotView = new IndicatorImageDotView(r2, r7);
        if (IF_DEBUG == false) goto L20;
        List<RenderSlot> r8 = this.renderedSlot;
        boolean r3 = false;
        if ((r8 instanceof Collection) == true) goto L11;
    L13:
        Iterator<T> r9 = r8.iterator();
    L15:
        if (r9.hasNext() == false) goto L19;
        if (Intrinsics.areEqual(((RenderSlot) r9.next()).getBinding(), new SlotBinding.Page(0)) == false) goto L15;
        r3 = true;
    L19:
        L.d(TAG, Intrinsics.stringPlus("Registered start drawable dot, visible=", Boolean.valueOf(r3)));
        goto L20
    L11:
        if (r8.isEmpty() == false) goto L13;
    L20:
        refreshDots();
    }

    public final int getSelectedDotColor() {
        return this.selectedDotColor;
    }

    public final void setSelectedDotColor(int r3) {
        if (getType() != 1) goto L5;
        this.selectedDotColor = -218103809;
        refreshDotsDraws();
        return;
    L5:
        if (this.selectedDotColor == r3) goto L9;
        this.selectedDotColor = r3;
        refreshDotsDraws();
        return;
    }

    private final void init(AttributeSet r10) {
        Context r1 = getContext();
        Intrinsics.checkNotNullExpressionValue(r1, "context");
        IndicatorGroupLayout r6 = new IndicatorGroupLayout(r1, null, 0, 6, null);
        r6.setGravity(17);
        this.groupLayout = r6;
        LinearLayout r2 = new LinearLayout(getContext());
        r2.setOrientation(0);
        r2.setGravity(17);
        this.dotsTrackLayout = r2;
        IndicatorGroupLayout r3 = null;
        if (getType() != 1) goto L14;
        IndicatorGroupLayout r0 = this.groupLayout;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r0 = null;
    L7:
        r0.setBgColor(ContextCompat.getColor(getContext(), R.color.carousel_indicator_bg_color));
        IndicatorGroupLayout r4 = this.groupLayout;
        if (r4 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r4 = null;
    L10:
        r4.setCornerRadius(OUnitExtensionKt.vdp(this, 100));
        IndicatorGroupLayout r5 = this.groupLayout;
        if (r5 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r5 = null;
    L13:
        r5.setDrawBackground(true);
    L18:
        IndicatorGroupLayout r7 = this.groupLayout;
        if (r7 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r7 = null;
    L21:
        r7.setPadding(getSidePadding(), 0, getSidePadding(), 0);
        IndicatorGroupLayout r8 = this.groupLayout;
        if (r8 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r8 = null;
    L24:
        LinearLayout r9 = this.dotsTrackLayout;
        if (r9 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("dotsTrackLayout");
        r9 = null;
    L27:
        r8.addView(r9, new LinearLayout.LayoutParams(-2, -2));
        IndicatorGroupLayout r11 = this.groupLayout;
        if (r11 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
    L31:
        addView(r3, new LinearLayout.LayoutParams(-2, getLayoutHeight()));
        this.indicatorAnimator = createViewportTransitionAnimator();
        if (r10 == null) goto L34;
        Context r12 = getContext();
        Intrinsics.checkNotNullExpressionValue(r12, "context");
        TypedArray r13 = r12.obtainStyledAttributes(r10, getCustom().getStyleableId(), 0, 0);
        Intrinsics.checkNotNullExpressionValue(r13, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        this.hasExplicitDotsWidth = r13.hasValue(R.styleable.OCarouselIndicator_oui_dotsWidth);
        this.hasExplicitDotsHeight = r13.hasValue(R.styleable.OCarouselIndicator_oui_dotsHeight);
        this.hasExplicitDotsSpacing = r13.hasValue(R.styleable.OCarouselIndicator_oui_dotsSpacing);
        setSelectedDotColor(r13.getColor(R.styleable.OCarouselIndicator_oui_selectedDotColor, getSelectedDotColor()));
        setMaxVisibleDots(r13.getInt(R.styleable.OCarouselIndicator_oui_maxVisibleDots, getMaxVisibleDots()));
        setSizeStyle(r13.getInt(R.styleable.OCarouselIndicator_oui_sizeStyle, 0));
        r13.recycle();
    L34:
        applySizeStyle();
        if (getType() == 1) goto L37;
        return;
    L37:
        if (this.sizeStyle != 1) goto L41;
        applySmallPicBackgroundPadding();
        return;
    L41:
        return;
    L30:
        r3 = r11;
        goto L31
    L14:
        IndicatorGroupLayout r14 = this.groupLayout;
        if (r14 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r14 = null;
    L17:
        r14.setDrawBackground(false);
        goto L18
    }

    private final IndicatorAnimator createViewportTransitionAnimator() {
        LinearLayout r1 = this.dotsTrackLayout;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("dotsTrackLayout");
        r1 = null;
    L6:
        return new IndicatorAnimator(r1, this.viewportTransitionInterpolator, new C02831(this));
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    protected void onRefreshIndicator() {
        updatePicStableContentWidth();
        OBaseIndicator.Pager r0 = getPager();
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        renderViewportState(r1, IndicatorAnimator.RenderReason.REFRESH_DOTS);
        return;
    L5:
        r1 = r0.getCurrentItem();
        goto L6
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    protected void onRefreshDotsDraws() {
        refreshVisibleDotsDraws();
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    protected void onRefreshDotsSpacing() {
        updatePicStableContentWidth();
        updateVisibleDotsSpacing();
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    protected void onRefreshDotsSize() {
        updatePicStableContentWidth();
        refreshVisibleDotsSize();
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public OnPageChangeListenerHelper buildOnPageChangedListener() {
        return new AnonymousClass1(this);
    }

    public final void dispatchManualPageScroll(int r1, int r2, float r3) {
        applyPageScroll(r1, r2, r3);
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    @Deprecated(message = "已废弃。请先更新 adapter/pageCount 对应的数据源，indicator 会自动刷新。")
    public void addDot(int r3) {
        L.w(TAG, "addDot(index=" + r3 + ") is deprecated. Update adapter/pageCount data first, then rely on observer refresh.");
        refreshDots();
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    @Deprecated(message = "已废弃。请先更新 adapter/pageCount 对应的数据源，indicator 会自动刷新。")
    public void removeDot(int r3) {
        L.w(TAG, "removeDot(index=" + r3 + ") is deprecated. Update adapter/pageCount data first, then rely on observer refresh.");
        refreshDots();
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public void refreshDotDraw(int r1) {
        refreshVisibleDotsDraws();
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public void refreshParentLayout() {
        if (getInitialized() == true) goto L6;
        setPendingRefreshParentLayout(true);
        return;
    L6:
        setPendingRefreshParentLayout(false);
        IndicatorGroupLayout r3 = null;
        if (getType() != 1) goto L18;
        IndicatorGroupLayout r0 = this.groupLayout;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r0 = null;
    L11:
        r0.setBgColor(ContextCompat.getColor(getContext(), R.color.carousel_indicator_bg_color));
        IndicatorGroupLayout r1 = this.groupLayout;
        if (r1 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r1 = null;
    L14:
        r1.setCornerRadius(OUnitExtensionKt.vdp(this, 100));
        IndicatorGroupLayout r2 = this.groupLayout;
        if (r2 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r2 = null;
    L17:
        r2.setDrawBackground(true);
    L26:
        if (getType() == 1) goto L28;
    L30:
        IndicatorGroupLayout r4 = this.groupLayout;
        if (r4 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r4 = null;
    L33:
        r4.setPadding(getSidePadding(), getVerticalSidePadding(), getSidePadding(), getVerticalSidePadding());
    L34:
        updatePicStableContentWidth();
        IndicatorGroupLayout r5 = this.groupLayout;
        if (r5 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r5 = null;
    L37:
        IndicatorGroupLayout r6 = this.groupLayout;
        if (r6 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
    L41:
        ViewGroup.LayoutParams r7 = r3.getLayoutParams();
        r7.height = getLayoutHeight();
        r5.setLayoutParams(r7);
        requestLayout();
        return;
    L40:
        r3 = r6;
        goto L41
    L28:
        if (this.sizeStyle != 1) goto L30;
        applySmallPicBackgroundPadding();
        goto L34
    L18:
        IndicatorGroupLayout r8 = this.groupLayout;
        if (r8 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r8 = null;
    L21:
        r8.setBgColor(ContextCompat.getColor(getContext(), R.color.Transparent));
        IndicatorGroupLayout r9 = this.groupLayout;
        if (r9 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r9 = null;
    L24:
        r9.setDrawBackground(false);
        goto L26
    }

    @Override // com.obric.oui.indicator.OBaseIndicator
    public OBaseIndicator.CustomDot getCustom() {
        OCarouselIndicator r0 = this;
        float r2 = OUnitExtensionKt.vdpFloat(r0, 6);
        float r3 = OUnitExtensionKt.vdpFloat(r0, 6);
        float r4 = OUnitExtensionKt.vdpFloat(r0, 4);
        int[] r5 = R.styleable.OCarouselIndicator;
        Intrinsics.checkNotNullExpressionValue(r5, TAG);
        return new OBaseIndicator.CustomDot(r2, r3, r4, r5, R.styleable.OCarouselIndicator_oui_type, R.styleable.OCarouselIndicator_oui_layoutHeight, R.styleable.OCarouselIndicator_oui_dotsWidth, R.styleable.OCarouselIndicator_oui_dotsHeight, R.styleable.OCarouselIndicator_oui_dotsSpacing, R.styleable.OCarouselIndicator_oui_dotsColor, R.styleable.OCarouselIndicator_oui_dotsCornerRadius, R.styleable.OCarouselIndicator_oui_dotsClickable, R.styleable.OCarouselIndicator_oui_dotsStrokeColor, R.styleable.OCarouselIndicator_oui_dotsStrokeWidth);
    }

    private final DotLayoutProfile resolveDotLayoutProfile(int r5) {
        DotLayoutProfile r0 = new DotLayoutProfile(getCustom().getDefaultWidth(), getCustom().getDefaultHeight(), getCustom().getDefaultSpacing());
        if (r5 != 1) goto L6;
        Context r6 = getContext();
        Intrinsics.checkNotNullExpressionValue(r6, "context");
        float r7 = OUnitExtensionKt.cdpFloat(r6, 4.0f);
        Context r3 = getContext();
        Intrinsics.checkNotNullExpressionValue(r3, "context");
        float r2 = OUnitExtensionKt.cdpFloat(r3, 4.0f);
        Context r4 = getContext();
        Intrinsics.checkNotNullExpressionValue(r4, "context");
        return new DotLayoutProfile(r7, r2, OUnitExtensionKt.cdpFloat(r4, 2.0f));
    L6:
        return r0;
    }

    private final void applySmallPicBackgroundPadding() {
        Context r0 = getContext();
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        int r1 = OUnitExtensionKt.cdp(r0, 4.0f);
        Context r3 = getContext();
        Intrinsics.checkNotNullExpressionValue(r3, "context");
        int r2 = OUnitExtensionKt.cdp(r3, 4.0f);
        IndicatorGroupLayout r4 = this.groupLayout;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r4 = null;
    L5:
        r4.setPadding(r1, r2, r1, r2);
    }

    private final void applySizeStyle() {
        DotLayoutProfile r0 = resolveDotLayoutProfile(this.sizeStyle);
        if (this.hasExplicitDotsWidth == true) goto L6;
        setDotsWidth(r0.getWidth());
    L6:
        if (this.hasExplicitDotsHeight == true) goto L9;
        setDotsHeight(r0.getHeight());
    L9:
        if (this.hasExplicitDotsSpacing == true) goto L12;
        setDotsSpacing(r0.getSpacing());
    L12:
        if (IF_DEBUG == false) goto L15;
        L.d(TAG, "sizeStyle=" + this.sizeStyle + " resolved to w=" + getDotsWidth() + " h=" + getDotsHeight() + " spacing=" + getDotsSpacing() + " explicit=[" + this.hasExplicitDotsWidth + ',' + this.hasExplicitDotsHeight + ',' + this.hasExplicitDotsSpacing + ']');
        return;
    }

    private final void renderViewportState(int r2, IndicatorAnimator.RenderReason r3) {
        IndicatorViewportState r4 = resolveViewportState(pagerCount(), r2);
        IndicatorAnimator r1 = this.indicatorAnimator;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("indicatorAnimator");
        r1 = null;
    L5:
        r1.render(r3, r4);
    }

    private final IndicatorViewportState resolveViewportState(int r1, int r2) {
        return IndicatorViewportStateKt.computeViewportState(r1, r2, this.maxVisibleDots);
    }

    private final void applyPageScroll(int r6, int r7, float r8) {
        int r0 = pagerCount();
        IndicatorViewportState r1 = resolveViewportState(r0, r6);
        IndicatorViewportState r2 = resolveViewportState(r0, r7);
        IndicatorAnimator r3 = null;
        if (Intrinsics.areEqual(r1.getVisibleRange(), r2.getVisibleRange()) == true) goto L9;
        IndicatorAnimator r4 = this.indicatorAnimator;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("indicatorAnimator");
    L8:
        renderViewportState(r3.resolveScrollViewportAnchorPosition(r6, r7, r8), IndicatorAnimator.RenderReason.SCROLL);
    L14:
        applyScrollColors(r6, r7, r8);
        invalidate();
        return;
    L7:
        r3 = r4;
        goto L8
    L9:
        IndicatorAnimator r5 = this.indicatorAnimator;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("indicatorAnimator");
    L13:
        r3.render(IndicatorAnimator.RenderReason.REFRESH_DOTS, r1);
        applyViewportTransitionProgress(r1, r2, r8);
        goto L14
    L12:
        r3 = r5;
        goto L13
    }

    private final float resolveViewportStepDistance() {
        return getDotsWidth() + (getDotsSpacing() * 2.0f);
    }

    private final void updatePicStableContentWidth() {
        Integer r0 = resolvePicStableContentWidth();
        IndicatorGroupLayout r1 = this.groupLayout;
        IndicatorGroupLayout r2 = null;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
        r1 = null;
    L6:
        if (Intrinsics.areEqual(r1.getFixedContentWidthPx(), r0) == false) goto L8;
        return;
    L8:
        IndicatorGroupLayout r3 = this.groupLayout;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("groupLayout");
    L12:
        r2.setFixedContentWidthPx(r0);
        if (IF_DEBUG == false) goto L16;
        L.d(TAG, "PIC stable content width updated, width=" + r0 + " pagerCount=" + pagerCount() + " maxVisibleDots=" + this.maxVisibleDots);
        return;
    L16:
        return;
    L11:
        r2 = r3;
        goto L12
    }

    private final Integer resolvePicStableContentWidth() {
        if (getType() == 1) goto L5;
        return null;
    L5:
        int r0 = pagerCount();
        if (r0 <= 0) goto L16;
        int r3 = this.maxVisibleDots;
        if (r0 <= r3) goto L16;
        int r1 = RangesKt.coerceAtLeast(r3, 0);
        if (r1 != 0) goto L15;
        L.w(TAG, Intrinsics.stringPlus("Skip PIC stable content width because maxVisibleDots is invalid, maxVisibleDots=", Integer.valueOf(this.maxVisibleDots)));
        return null;
    L15:
        return Integer.valueOf(MathKt.roundToInt((r1 * getDotsWidth()) + (((r1 - 1) * getDotsSpacing()) * 2.0f)));
    L16:
        return null;
    }

    private final void cancelVisibleDotAnimations() {
        Iterator<T> r0 = this.renderedSlot.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        cancelDotAnimation(((RenderSlot) r0.next()).getView());
        goto L4
    }

    private final boolean shouldRebindVisibleSlots(IntRange r8) {
        List<SlotBinding> r9 = resolveRenderSlotBindings(pagerCount(), r8);
        if (this.renderedSlot.size() == r9.size()) goto L5;
        return true;
    L5:
        Iterator<T> r10 = r9.iterator();
        int r1 = 0;
    L7:
        if (r10.hasNext() == false) goto L26;
        Object r3 = r10.next();
        int r4 = r1 + 1;
        if (r1 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        SlotBinding r5 = (SlotBinding) r3;
        RenderSlot r2 = (RenderSlot) CollectionsKt.getOrNull(this.renderedSlot, r1);
        if (r2 == null) goto L13;
        IndicatorImageDotView r6 = resolveReplacementView(r5);
        if (Intrinsics.areEqual(r2.getBinding(), r5) == false) goto L16;
        if (r6 != null) goto L19;
    L21:
        if (r6 != null) goto L25;
        if ((r2.getView() instanceof IndicatorDotView) == true) goto L25;
        return true;
    L25:
        r1 = r4;
        goto L7
    L19:
        if (r2.getView() == r6) goto L21;
        return true;
    L16:
        return true;
    L13:
        return true;
    L26:
        return false;
    }

    private final void rebindVisibleSlots(IndicatorViewportState r11, IndicatorAnimator.RenderReason r12) {
        cancelVisibleDotAnimations();
        IntRange r0 = r11.getVisibleRange();
        ArrayDeque<IndicatorDotView> r1 = new ArrayDeque();
        Iterator<T> r2 = this.renderedSlot.iterator();
    L3:
        IndicatorDotView r4 = null;
        if (r2.hasNext() == false) goto L11;
        View r3 = ((RenderSlot) r2.next()).getView();
        if ((r3 instanceof IndicatorDotView) == false) goto L8;
        r4 = (IndicatorDotView) r3;
    L8:
        if (r4 == null) goto L3;
        r1.addLast(r4);
        goto L3
    L11:
        LinearLayout r5 = this.dotsTrackLayout;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("dotsTrackLayout");
        r5 = null;
    L14:
        r5.removeAllViews();
        this.renderedSlot.clear();
        List<SlotBinding> r13 = resolveRenderSlotBindings(r11.getTotalCount(), r0);
        Iterator<T> r6 = r13.iterator();
    L16:
        if (r6.hasNext() == false) goto L31;
        SlotBinding r7 = (SlotBinding) r6.next();
        IndicatorIcon r8 = resolveReplacementView(r7);
        if (r8 != null) goto L20;
        r8 = acquireDefaultDotView(r1);
    L20:
        View r9 = (View) r8;
        ViewParent r10 = r9.getParent();
        if ((r10 instanceof ViewGroup) == false) goto L23;
        ViewGroup r14 = (ViewGroup) r10;
    L24:
        if (r14 == null) goto L27;
        r14.removeView(r9);
    L27:
        RenderSlot r15 = new RenderSlot(r7, r9, r8);
        bindSlot(r15);
        LinearLayout r16 = this.dotsTrackLayout;
        if (r16 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("dotsTrackLayout");
        r16 = null;
    L30:
        r16.addView(r15.getView());
        this.renderedSlot.add(r15);
        goto L16
    L23:
        r14 = null;
        goto L24
    L31:
        recycleDefaultDots(r1);
        updateVisibleDotsSpacing();
        if (IF_DEBUG == false) goto L43;
        L.d(TAG, "Rebound slots, reason=" + r12.getLogValue() + " range=" + r0 + " bindings=" + r13 + " visible=" + this.renderedSlot.size() + " recycled=" + this.recycledDefaultDots.size());
        return;
    }

    private final IndicatorImageDotView resolveReplacementView(SlotBinding r3) {
        if ((r3 instanceof SlotBinding.Page) == false) goto L8;
        if (((SlotBinding.Page) r3).getPageIndex() == 0) goto L15;
        return null;
    L15:
        return this.startDrawableDotView;
    L8:
        if (Intrinsics.areEqual(r3, SlotBinding.LeadingDummy.INSTANCE) == false) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == false) goto L14;
        return null;
    L14:
        throw new NoWhenBranchMatchedException();
    L10:
        r2 = Intrinsics.areEqual(r3, SlotBinding.TrailingDummy.INSTANCE);
        goto L11
    }

    private final void cancelDotAnimation(View r1) {
        r1.animate().setListener(null).cancel();
    }

    private final IndicatorDotView acquireDefaultDotView(ArrayDeque<IndicatorDotView> r8) {
        IndicatorDotView r9 = r8.pollFirst();
        if (r9 != null) goto L14;
        r9 = this.recycledDefaultDots.pollFirst();
        if (r9 != null) goto L12;
        if (IF_DEBUG == false) goto L9;
        L.d(TAG, "Create new default dot");
    L9:
        Context r2 = getContext();
        Intrinsics.checkNotNullExpressionValue(r2, "context");
        return new IndicatorDotView(r2, null, 0, 6, null);
    L12:
        if (IF_DEBUG == false) goto L14;
        L.d(TAG, Intrinsics.stringPlus("Reuse pooled default dot, remaining=", Integer.valueOf(this.recycledDefaultDots.size())));
    L14:
        return r9;
    }

    private final void recycleDefaultDots(ArrayDeque<IndicatorDotView> r3) {
    L3:
        if ((!r3.isEmpty()) == false) goto L5;
        this.recycledDefaultDots.addLast(r3.removeFirst());
        goto L3
    }

    private final void bindSlot(final RenderSlot r3) {
        int r1 = 0;
        updateDotLayout(r3.getView(), false);
        OBaseIndicator.Pager r0 = getPager();
        if (r0 == null) goto L6;
        r1 = r0.getCurrentItem();
    L6:
        refreshRenderedSlot(r3, r1);
        r3.getView().setOnClickListener(new OCarouselIndicator$$ExternalSyntheticLambda0(r3, this));
    }

    /* JADX INFO: renamed from: bindSlot$lambda-12, reason: not valid java name */
    private static final void m376bindSlot$lambda12(RenderSlot r1, OCarouselIndicator r2, View r3) {
        Intrinsics.checkNotNullParameter(r1, "$slot");
        Intrinsics.checkNotNullParameter(r2, "this$0");
        SlotBinding r4 = r1.getBinding();
        if ((r4 instanceof SlotBinding.Page) == true) goto L5;
        return;
    L5:
        if (r2.getDotsClickable() == false) goto L14;
        SlotBinding.Page r5 = (SlotBinding.Page) r4;
        if (r5.getPageIndex() >= r2.pagerCount()) goto L15;
        OBaseIndicator.Pager r6 = r2.getPager();
        if (r6 == null) goto L16;
        r6.setCurrentItem(r5.getPageIndex(), false);
        return;
    L16:
        return;
    L15:
        return;
    }

    private final void updateDotLayout(View r4, boolean r5) {
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        LinearLayout.LayoutParams r2 = null;
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
    L6:
        if (r1 == null) goto L9;
        r2 = new LinearLayout.LayoutParams(r1);
    L9:
        if (r2 != null) goto L11;
        r2 = new LinearLayout.LayoutParams((int) getDotsWidth(), (int) getDotsHeight());
    L11:
        r2.width = (int) getDotsWidth();
        r2.height = (int) getDotsHeight();
        if (r5 == true) goto L14;
        r2.setMargins(0, 0, 0, 0);
    L14:
        r4.setLayoutParams(r2);
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final void refreshVisibleDotsDraws() {
        OBaseIndicator.Pager r0 = getPager();
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        Iterator<T> r2 = this.renderedSlot.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        refreshRenderedSlot((RenderSlot) r2.next(), r1);
        goto L8
    L10:
        return;
    L5:
        r1 = r0.getCurrentItem();
        goto L6
    }

    private final void refreshVisibleDotsSize() {
        OBaseIndicator.Pager r0 = getPager();
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        Iterator<T> r2 = this.renderedSlot.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        RenderSlot r3 = (RenderSlot) r2.next();
        updateDotLayout(r3.getView(), true);
        refreshRenderedSlot(r3, r1);
        goto L8
    L10:
        Iterator<T> r4 = this.recycledDefaultDots.iterator();
    L12:
        if (r4.hasNext() == false) goto L14;
        IndicatorDotView r5 = (IndicatorDotView) r4.next();
        Intrinsics.checkNotNullExpressionValue(r5, "it");
        updateDotLayout(r5, true);
        goto L12
    L14:
        IndicatorImageDotView r6 = this.startDrawableDotView;
        if (r6 == null) goto L21;
        updateDotLayout(r6, true);
        return;
    L21:
        return;
    L5:
        r1 = r0.getCurrentItem();
        goto L6
    }

    private final void updateVisibleDotsSpacing() {
        if (this.renderedSlot.isEmpty() == false) goto L5;
        return;
    L5:
        IntRange r0 = CollectionsKt.getIndices(this.renderedSlot);
        int r1 = (int) getDotsSpacing();
        Iterator<T> r7 = this.renderedSlot.iterator();
        int r2 = 0;
    L7:
        if (r7.hasNext() == false) goto L16;
        Object r3 = r7.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        RenderSlot r5 = (RenderSlot) r3;
        DotSpacingSpec r6 = OBaseIndicatorKt.resolveDotSpacingSpec(r2, r1, r0);
        if (r6.getStartMargin() != r6.getEndMargin()) goto L14;
        r5.getIndicator().setHorizontalMargin(r6.getStartMargin());
    L15:
        r2 = r4;
        goto L7
    L14:
        r5.getIndicator().setStartMargin(r6.getStartMargin());
        r5.getIndicator().setEndMargin(r6.getEndMargin());
        goto L15
    }

    private final void applyViewportState(IndicatorViewportState r6) {
        OBaseIndicator.Pager r0 = getPager();
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        Iterator<T> r2 = this.renderedSlot.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        RenderSlot r3 = (RenderSlot) r2.next();
        applyDotVisualState(r3.getView(), resolveSlotVisualState(r3, r6));
        refreshRenderedSlot(r3, r1);
        goto L8
    L10:
        return;
    L5:
        r1 = r0.getCurrentItem();
        goto L6
    }

    private final void applyViewportTransitionProgress(IndicatorViewportState r7, IndicatorViewportState r8, float r9) {
        OBaseIndicator.Pager r0 = getPager();
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        Iterator<T> r2 = this.renderedSlot.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        RenderSlot r3 = (RenderSlot) r2.next();
        applyDotTransitionVisualState(r3.getView(), resolveSlotVisualState(r3, r7), resolveSlotVisualState(r3, r8), r9);
        refreshRenderedSlot(r3, r1);
        goto L8
    L10:
        return;
    L5:
        r1 = r0.getCurrentItem();
        goto L6
    }

    private final IndicatorDotVisualState resolveSlotVisualState(RenderSlot r1, IndicatorViewportState r2) {
        SlotBinding r0 = r1.getBinding();
        if ((r0 instanceof SlotBinding.Page) == false) goto L6;
        return r2.dotVisualStateAt(((SlotBinding.Page) r0).getPageIndex());
    L6:
        if (Intrinsics.areEqual(r0, SlotBinding.LeadingDummy.INSTANCE) == false) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L13;
        return IndicatorDotVisualState.HIDDEN;
    L13:
        throw new NoWhenBranchMatchedException();
    L8:
        r3 = Intrinsics.areEqual(r0, SlotBinding.TrailingDummy.INSTANCE);
        goto L9
    }

    private final float resolveDotTargetScale(IndicatorDotVisualState r1) {
        int r0 = WhenMappings.$EnumSwitchMapping$0[r1.ordinal()];
        if (r0 != 1) goto L5;
        return 0.5f;
    L5:
        if (r0 == 2) goto L7;
        return 1.0f;
    L7:
        return 0.0f;
    }

    private final float resolveDotTargetAlpha(IndicatorDotVisualState r1) {
        int r0 = WhenMappings.$EnumSwitchMapping$0[r1.ordinal()];
        if (r0 != 2) goto L5;
        return 0.0f;
    L5:
        if (r0 == 3) goto L7;
        return INACTIVE_DOT_ALPHA;
    L7:
        return 1.0f;
    }

    private final void applyDotVisualState(View r6, IndicatorDotVisualState r7) {
        boolean r1 = false;
        if (r7 != IndicatorDotVisualState.HIDDEN) goto L5;
        int r0 = 4;
    L6:
        float r2 = resolveDotTargetScale(r7);
        float r8 = resolveDotTargetAlpha(r7);
        if (r6.getVisibility() == r0) goto L9;
    L23:
        cancelDotAnimation(r6);
        r6.setVisibility(r0);
        r6.setScaleX(r2);
        r6.setScaleY(r2);
        r6.setAlpha(r8);
        return;
    L9:
        if (r6.getScaleX() != r2) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == false) goto L23;
        if (r6.getScaleY() != r2) goto L16;
        boolean r4 = true;
    L17:
        if (r4 == false) goto L23;
        if (r6.getAlpha() != r8) goto L21;
        r1 = true;
    L21:
        if (r1 == false) goto L23;
        return;
    L16:
        r4 = false;
        goto L17
    L11:
        r3 = false;
        goto L12
    L5:
        r0 = 0;
        goto L6
    }

    private final void applyDotTransitionVisualState(View r4, IndicatorDotVisualState r5, IndicatorDotVisualState r6, float r7) {
        if (r5 != r6) goto L5;
        applyDotVisualState(r4, r5);
        return;
    L5:
        float r0 = resolveDotTargetScale(r5);
        float r1 = resolveDotTargetScale(r6);
        float r8 = resolveDotTargetAlpha(r5);
        float r2 = resolveDotTargetAlpha(r6);
        float r3 = interpolate(r0, r1, r7);
        float r9 = interpolate(r8, r2, r7);
        boolean r10 = false;
        if (r7 >= 1.0f) goto L8;
    L10:
        int r11 = 0;
    L12:
        if (r4.getVisibility() == r11) goto L14;
    L28:
        cancelDotAnimation(r4);
        r4.setVisibility(r11);
        r4.setScaleX(r3);
        r4.setScaleY(r3);
        r4.setAlpha(r9);
        return;
    L14:
        if (r4.getScaleX() != r3) goto L16;
        boolean r12 = true;
    L17:
        if (r12 == false) goto L28;
        if (r4.getScaleY() != r3) goto L21;
        boolean r13 = true;
    L22:
        if (r13 == false) goto L28;
        if (r4.getAlpha() != r9) goto L26;
        r10 = true;
    L26:
        if (r10 == false) goto L28;
        return;
    L21:
        r13 = false;
        goto L22
    L16:
        r12 = false;
        goto L17
    L8:
        if (r6 != IndicatorDotVisualState.HIDDEN) goto L10;
        r11 = 4;
        goto L12
    }

    private final void applyScrollColors(int r7, int r8, float r9) {
        IndicatorAnimator r0 = this.indicatorAnimator;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("indicatorAnimator");
        r0 = null;
    L5:
        IndicatorViewportState r1 = r0.currentViewportState();
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.isVisible(r7) == true) goto L11;
        return;
    L11:
        if (r1.isVisible(r8) == false) goto L32;
        Object r2 = this.argbEvaluator.evaluate(r9, Integer.valueOf(this.selectedDotColor), Integer.valueOf(getDotsColor()));
        if (r2 == null) goto L30;
        int r3 = ((Integer) r2).intValue();
        Object r10 = this.argbEvaluator.evaluate(r9, Integer.valueOf(getDotsColor()), Integer.valueOf(this.selectedDotColor));
        if (r10 == null) goto L28;
        applyDotColorIfVisible(r8, ((Integer) r10).intValue(), r1);
        OBaseIndicator.Pager r11 = getPager();
        boolean r12 = false;
        if (r11 != null) goto L21;
    L23:
        if (r12 == false) goto L25;
        r3 = this.selectedDotColor;
    L25:
        applyDotColorIfVisible(r7, r3, r1);
        return;
    L21:
        if (r7 != r11.getCurrentItem()) goto L23;
        r12 = true;
        goto L23
    L28:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L30:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    private final void applyDotColorIfVisible(int r1, int r2, IndicatorViewportState r3) {
        if (r3.isVisible(r1) == true) goto L5;
        return;
    L5:
        RenderSlot r0 = findVisibleSlot(r1);
        if (r0 != null) goto L8;
        return;
    L8:
        r0.getIndicator().setDotColor(r2);
        r0.getIndicator().invalidate();
    }

    private final void refreshRenderedSlot(RenderSlot r4, int r5) {
        IndicatorIcon r0 = r4.getIndicator();
        SlotBinding r1 = r4.getBinding();
        if ((r1 instanceof SlotBinding.Page) == false) goto L9;
        if (((SlotBinding.Page) r1).getPageIndex() != r5) goto L7;
        int r6 = this.selectedDotColor;
    L14:
        r0.setDotColor(r6);
        r4.getIndicator().setCornerRadius(getDotsCornerRadius());
        r4.getIndicator().setStrokeWidth(getDotsStrokeWidth());
        r4.getIndicator().setStrokeColor(getDotsStrokeColor());
        r4.getIndicator().invalidate();
        return;
    L7:
        r6 = getDotsColor();
        goto L14
    L9:
        if (Intrinsics.areEqual(r1, SlotBinding.LeadingDummy.INSTANCE) == false) goto L11;
        boolean r7 = true;
    L12:
        if (r7 == false) goto L17;
        r6 = getDotsColor();
        goto L14
    L17:
        throw new NoWhenBranchMatchedException();
    L11:
        r7 = Intrinsics.areEqual(r1, SlotBinding.TrailingDummy.INSTANCE);
        goto L12
    }

    private final RenderSlot findVisibleSlot(int r6) {
        Iterator<T> r5 = this.renderedSlot.iterator();
    L4:
        if (r5.hasNext() == false) goto L19;
        Object r0 = r5.next();
        SlotBinding r1 = ((RenderSlot) r0).getBinding();
        boolean r3 = false;
        boolean r4 = true;
        if ((r1 instanceof SlotBinding.Page) == false) goto L11;
        if (((SlotBinding.Page) r1).getPageIndex() != r6) goto L15;
        r3 = true;
    L15:
        if (r3 == false) goto L4;
    L21:
        return (RenderSlot) r0;
    L11:
        if (Intrinsics.areEqual(r1, SlotBinding.LeadingDummy.INSTANCE) == true) goto L14;
        r4 = Intrinsics.areEqual(r1, SlotBinding.TrailingDummy.INSTANCE);
    L14:
        if (r4 == true) goto L15;
        throw new NoWhenBranchMatchedException();
    L19:
        r0 = null;
        goto L21
    }

    private final List<SlotBinding> resolveRenderSlotBindings(int r5, IntRange r6) {
        if (r5 <= 0) goto L24;
        if (r6.isEmpty() == true) goto L24;
        IntRange r0 = r6;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<Integer> r2 = r0.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        r1.add(new SlotBinding.Page(((IntIterator) r2).nextInt()));
        goto L8
    L10:
        ArrayList r3 = r1;
        if (r5 > size(r6)) goto L13;
        return r3;
    L13:
        List r4 = CollectionsKt.createListBuilder(r3.size() + 2);
        if (r6.getFirst() <= 0) goto L16;
        SlotBinding r7 = new SlotBinding.Page(r6.getFirst() - 1);
    L17:
        r4.add(r7);
        r4.addAll(r3);
        if (r6.getLast() >= (r5 - 1)) goto L20;
        SlotBinding r8 = new SlotBinding.Page(r6.getLast() + 1);
    L21:
        r4.add(r8);
        return CollectionsKt.build(r4);
    L20:
        r8 = SlotBinding.TrailingDummy.INSTANCE;
        goto L21
    L16:
        r7 = SlotBinding.LeadingDummy.INSTANCE;
    L24:
        return CollectionsKt.emptyList();
    }

    private final int size(IntRange r1) {
        if (r1.isEmpty() == false) goto L6;
        return 0;
    L6:
        return (r1.getLast() - r1.getFirst()) + 1;
    }
}
