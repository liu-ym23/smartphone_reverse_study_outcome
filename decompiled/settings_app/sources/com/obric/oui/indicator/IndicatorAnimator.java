package com.obric.oui.indicator;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.icu.text.PluralRules;
import android.view.View;
import com.android.settings.wifi.WifiAuthorizeUtils;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.utils.log.L;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: IndicatorAnimator.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 .2\u00020\u0001:\u0005-./01B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\nH\u0002J\b\u0010\u0019\u001a\u0004\u0018\u00010\u000eJ\u0016\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000eJ\b\u0010\u001e\u001a\u00020\u0016H\u0002J\u001e\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\fJ*\u0010#\u001a\u00020$2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020$H\u0002J&\u0010&\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010'\u001a\u00020\f2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00160)H\u0002J \u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u0010X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/obric/oui/indicator/IndicatorAnimator;", "", "trackView", "Landroid/view/View;", "interpolator", "Landroid/animation/TimeInterpolator;", WifiAuthorizeUtils.AUTO_LOGIN_HOST, "Lcom/obric/oui/indicator/IndicatorAnimator$Host;", "(Landroid/view/View;Landroid/animation/TimeInterpolator;Lcom/obric/oui/indicator/IndicatorAnimator$Host;)V", "activeViewportTransition", "Lcom/obric/oui/indicator/IndicatorAnimator$ActiveViewportTransition;", "lastScrollAnchorOffset", "", "lastViewportState", "Lcom/obric/oui/indicator/IndicatorViewportState;", "tag", "", "getTag", "()Ljava/lang/String;", "viewportTransitionToken", "", "cancelTrackAnimation", "", "commitViewportTransition", "transition", "currentViewportState", "render", "reason", "Lcom/obric/oui/indicator/IndicatorAnimator$RenderReason;", "nextViewportState", "resetViewportTransitionVisuals", "resolveScrollViewportAnchorPosition", "selectedPosition", "nextPosition", "positionOffset", "shouldAnimateViewportTransition", "", "viewportRangeChanged", "startTrackTranslationAnimation", "targetTranslationX", "onComplete", "Lkotlin/Function0;", "startViewportTransition", "sourceState", "targetState", "ActiveViewportTransition", "Companion", "Host", "RenderReason", "ScrollDirection", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IndicatorAnimator {
    public static final Companion Companion = null;
    private static final long DURATION_MS = 300;
    private static final boolean IF_DEBUG = false;
    private ActiveViewportTransition activeViewportTransition;
    private final Host host;
    private final TimeInterpolator interpolator;
    private float lastScrollAnchorOffset;
    private IndicatorViewportState lastViewportState;
    private final String tag;
    private final View trackView;
    private int viewportTransitionToken;

    /* JADX INFO: compiled from: IndicatorAnimator.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003J;\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0011\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/obric/oui/indicator/IndicatorAnimator$ActiveViewportTransition;", "", "transitionToken", "", "sourceState", "Lcom/obric/oui/indicator/IndicatorViewportState;", "targetState", MaterialConfigFormatNames.DIRECTION, "Lcom/obric/oui/indicator/IndicatorViewportShiftDirection;", "reason", "Lcom/obric/oui/indicator/IndicatorAnimator$RenderReason;", "(ILcom/obric/oui/indicator/IndicatorViewportState;Lcom/obric/oui/indicator/IndicatorViewportState;Lcom/obric/oui/indicator/IndicatorViewportShiftDirection;Lcom/obric/oui/indicator/IndicatorAnimator$RenderReason;)V", "getDirection", "()Lcom/obric/oui/indicator/IndicatorViewportShiftDirection;", "getReason", "()Lcom/obric/oui/indicator/IndicatorAnimator$RenderReason;", "getSourceState", "()Lcom/obric/oui/indicator/IndicatorViewportState;", "getTargetState", "setTargetState", "(Lcom/obric/oui/indicator/IndicatorViewportState;)V", "getTransitionToken", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class ActiveViewportTransition {
        private final IndicatorViewportShiftDirection direction;
        private final RenderReason reason;
        private final IndicatorViewportState sourceState;
        private IndicatorViewportState targetState;
        private final int transitionToken;

        public static /* synthetic */ ActiveViewportTransition copy$default(ActiveViewportTransition r3, int r4, IndicatorViewportState r5, IndicatorViewportState r6, IndicatorViewportShiftDirection r7, RenderReason r8, int r9, Object r10) {
            if ((r9 & 1) == 0) goto L6;
            r4 = r3.transitionToken;
        L6:
            if ((r9 & 2) == 0) goto L8;
            r5 = r3.sourceState;
        L8:
            IndicatorViewportState r11 = r5;
            if ((r9 & 4) == 0) goto L11;
            r6 = r3.targetState;
        L11:
            IndicatorViewportState r0 = r6;
            if ((r9 & 8) == 0) goto L14;
            r7 = r3.direction;
        L14:
            IndicatorViewportShiftDirection r1 = r7;
            if ((r9 & 16) == 0) goto L17;
            r8 = r3.reason;
        L17:
            int r12 = r4;
            return r3.copy(r12, r11, r0, r1, r8);
        }

        public final int component1() {
            return this.transitionToken;
        }

        public final IndicatorViewportState component2() {
            return this.sourceState;
        }

        public final IndicatorViewportState component3() {
            return this.targetState;
        }

        public final IndicatorViewportShiftDirection component4() {
            return this.direction;
        }

        public final RenderReason component5() {
            return this.reason;
        }

        public final ActiveViewportTransition copy(int r7, IndicatorViewportState r8, IndicatorViewportState r9, IndicatorViewportShiftDirection r10, RenderReason r11) {
            Intrinsics.checkNotNullParameter(r8, "sourceState");
            Intrinsics.checkNotNullParameter(r9, "targetState");
            Intrinsics.checkNotNullParameter(r10, MaterialConfigFormatNames.DIRECTION);
            Intrinsics.checkNotNullParameter(r11, "reason");
            return new ActiveViewportTransition(r7, r8, r9, r10, r11);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof ActiveViewportTransition) == true) goto L8;
            return false;
        L8:
            ActiveViewportTransition r6 = (ActiveViewportTransition) r5;
            if (this.transitionToken == r6.transitionToken) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.sourceState, r6.sourceState) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.targetState, r6.targetState) == true) goto L18;
            return false;
        L18:
            if (this.direction == r6.direction) goto L21;
            return false;
        L21:
            if (this.reason == r6.reason) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return (((((((Integer.hashCode(this.transitionToken) * 31) + this.sourceState.hashCode()) * 31) + this.targetState.hashCode()) * 31) + this.direction.hashCode()) * 31) + this.reason.hashCode();
        }

        public String toString() {
            return "ActiveViewportTransition(transitionToken=" + this.transitionToken + ", sourceState=" + this.sourceState + ", targetState=" + this.targetState + ", direction=" + this.direction + ", reason=" + this.reason + ')';
        }

        public ActiveViewportTransition(int r2, IndicatorViewportState r3, IndicatorViewportState r4, IndicatorViewportShiftDirection r5, RenderReason r6) {
            Intrinsics.checkNotNullParameter(r3, "sourceState");
            Intrinsics.checkNotNullParameter(r4, "targetState");
            Intrinsics.checkNotNullParameter(r5, MaterialConfigFormatNames.DIRECTION);
            Intrinsics.checkNotNullParameter(r6, "reason");
            this.transitionToken = r2;
            this.sourceState = r3;
            this.targetState = r4;
            this.direction = r5;
            this.reason = r6;
        }

        public final int getTransitionToken() {
            return this.transitionToken;
        }

        public final IndicatorViewportState getSourceState() {
            return this.sourceState;
        }

        public final IndicatorViewportState getTargetState() {
            return this.targetState;
        }

        public final void setTargetState(IndicatorViewportState r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.targetState = r2;
        }

        public final IndicatorViewportShiftDirection getDirection() {
            return this.direction;
        }

        public final RenderReason getReason() {
            return this.reason;
        }
    }

    /* JADX INFO: compiled from: IndicatorAnimator.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/indicator/IndicatorAnimator$Companion;", "", "()V", "DURATION_MS", "", "IF_DEBUG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: IndicatorAnimator.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J \u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\tH&J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0015\u001a\u00020\u0010H&J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u001a"}, d2 = {"Lcom/obric/oui/indicator/IndicatorAnimator$Host;", "", "maxVisibleDots", "", "getMaxVisibleDots", "()I", "pagerCount", "getPagerCount", "applyViewportState", "", "state", "Lcom/obric/oui/indicator/IndicatorViewportState;", "applyViewportTransitionProgress", "sourceState", "targetState", "progress", "", "cancelVisibleDotAnimations", "rebindVisibleSlots", "reason", "Lcom/obric/oui/indicator/IndicatorAnimator$RenderReason;", "resolveViewportStepDistance", "shouldRebindVisibleSlots", "", "targetRange", "Lkotlin/ranges/IntRange;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Host {
        void applyViewportState(IndicatorViewportState r1);

        void applyViewportTransitionProgress(IndicatorViewportState r1, IndicatorViewportState r2, float r3);

        void cancelVisibleDotAnimations();

        int getMaxVisibleDots();

        int getPagerCount();

        void rebindVisibleSlots(IndicatorViewportState r1, RenderReason r2);

        float resolveViewportStepDistance();

        boolean shouldRebindVisibleSlots(IntRange r1);
    }

    /* JADX INFO: compiled from: IndicatorAnimator.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/oui/indicator/IndicatorAnimator$RenderReason;", "", "logValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getLogValue", "()Ljava/lang/String;", "SCROLL", "REFRESH_DOTS", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum RenderReason extends Enum<RenderReason> {
        private static final /* synthetic */ RenderReason[] $VALUES = null;
        public static final RenderReason REFRESH_DOTS = null;
        public static final RenderReason SCROLL = null;
        private final String logValue;

        private static final /* synthetic */ RenderReason[] $values() {
            return new RenderReason[]{SCROLL, REFRESH_DOTS};
        }

        public static RenderReason valueOf(String r1) {
            return (RenderReason) Enum.valueOf(RenderReason.class, r1);
        }

        public static RenderReason[] values() {
            return (RenderReason[]) $VALUES.clone();
        }

        private RenderReason(String r1, int r2, String r3) {
            super(r1, r2);
            this.logValue = r3;
        }

        public final String getLogValue() {
            return this.logValue;
        }

        static {
            SCROLL = new RenderReason("SCROLL", 0, "scroll");
            REFRESH_DOTS = new RenderReason("REFRESH_DOTS", 1, "refreshDots");
            $VALUES = $values();
        }
    }

    /* JADX INFO: compiled from: IndicatorAnimator.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/indicator/IndicatorAnimator$ScrollDirection;", "", "(Ljava/lang/String;I)V", "FORWARD", "BACKWARD", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final enum ScrollDirection extends Enum<ScrollDirection> {
        private static final /* synthetic */ ScrollDirection[] $VALUES = null;
        public static final ScrollDirection BACKWARD = null;
        public static final ScrollDirection FORWARD = null;

        private static final /* synthetic */ ScrollDirection[] $values() {
            return new ScrollDirection[]{FORWARD, BACKWARD};
        }

        public static ScrollDirection valueOf(String r1) {
            return (ScrollDirection) Enum.valueOf(ScrollDirection.class, r1);
        }

        public static ScrollDirection[] values() {
            return (ScrollDirection[]) $VALUES.clone();
        }

        private ScrollDirection(String r1, int r2) {
            super(r1, r2);
        }

        static {
            FORWARD = new ScrollDirection("FORWARD", 0);
            BACKWARD = new ScrollDirection("BACKWARD", 1);
            $VALUES = $values();
        }
    }

    /* JADX INFO: compiled from: IndicatorAnimator.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[ScrollDirection.values().length];
            r0[ScrollDirection.BACKWARD.ordinal()] = 1;
            r0[ScrollDirection.FORWARD.ordinal()] = 2;
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$kWN3-3GIzB4C-kzxqffVTDt38QM, reason: not valid java name */
    public static /* synthetic */ void m1230$r8$lambda$kWN33GIzB4CkzxqffVTDt38QM(IndicatorAnimator r0, ActiveViewportTransition r1, float r2, ValueAnimator r3) {
        m1231startTrackTranslationAnimation$lambda1(r0, r1, r2, r3);
    }

    static {
        Companion = new Companion(null);
    }

    public IndicatorAnimator(View r2, TimeInterpolator r3, Host r4) {
        Intrinsics.checkNotNullParameter(r2, "trackView");
        Intrinsics.checkNotNullParameter(r3, "interpolator");
        Intrinsics.checkNotNullParameter(r4, WifiAuthorizeUtils.AUTO_LOGIN_HOST);
        this.trackView = r2;
        this.interpolator = r3;
        this.host = r4;
        this.tag = OCarouselIndicator.TAG;
    }

    public static final /* synthetic */ void access$commitViewportTransition(IndicatorAnimator r0, ActiveViewportTransition r1) {
        r0.commitViewportTransition(r1);
    }

    public static final /* synthetic */ ActiveViewportTransition access$getActiveViewportTransition$p(IndicatorAnimator r0) {
        return r0.activeViewportTransition;
    }

    public static final /* synthetic */ View access$getTrackView$p(IndicatorAnimator r0) {
        return r0.trackView;
    }

    public final String getTag() {
        return this.tag;
    }

    public final IndicatorViewportState currentViewportState() {
        return this.lastViewportState;
    }

    public final void render(RenderReason r6, IndicatorViewportState r7) {
        Intrinsics.checkNotNullParameter(r6, "reason");
        Intrinsics.checkNotNullParameter(r7, "nextViewportState");
        if (this.activeViewportTransition == null) goto L5;
        return;
    L5:
        IndicatorViewportState r0 = this.lastViewportState;
        if (r0 != null) goto L8;
        IntRange r1 = null;
    L9:
        boolean r2 = true;
        boolean r3 = !Intrinsics.areEqual(r1, r7.getVisibleRange());
        if (r3 == true) goto L16;
        if (this.host.shouldRebindVisibleSlots(r7.getVisibleRange()) == true) goto L16;
        r2 = false;
    L16:
        if (shouldAnimateViewportTransition(r6, r0, r7, r3) == false) goto L21;
        if (r0 != null) goto L19;
        r0 = r7;
    L19:
        startViewportTransition(r0, r7, r6);
        return;
    L21:
        if (r2 == false) goto L23;
        this.host.rebindVisibleSlots(r7, r6);
    L23:
        this.lastViewportState = r7;
        this.host.applyViewportState(r7);
        return;
    L8:
        r1 = r0.getVisibleRange();
        goto L9
    }

    public final int resolveScrollViewportAnchorPosition(int r6, int r7, float r8) {
        float r0 = this.lastScrollAnchorOffset;
        if (r8 <= r0) goto L6;
        ScrollDirection r1 = ScrollDirection.FORWARD;
    L10:
        if (r1 != null) goto L12;
        int r2 = -1;
    L13:
        boolean r3 = false;
        if (r2 == (-1)) goto L25;
        if (r2 == 1) goto L22;
        if (r2 == 2) goto L25;
        throw new NoWhenBranchMatchedException();
    L22:
        if (r8 > 0.5f) goto L26;
    L27:
        boolean r4 = false;
    L28:
        if (r4 == false) goto L31;
        r6 = r7;
    L31:
        if (r8 != 0.0f) goto L33;
        r3 = true;
    L33:
        if (r3 == true) goto L35;
        this.lastScrollAnchorOffset = r8;
    L35:
        return r6;
    L26:
        r4 = true;
    L25:
        if (r8 < 0.5f) goto L27;
    L12:
        r2 = WhenMappings.$EnumSwitchMapping$0[r1.ordinal()];
        goto L13
    L6:
        if (r8 >= r0) goto L8;
        r1 = ScrollDirection.BACKWARD;
        goto L10
    L8:
        r1 = null;
        goto L10
    }

    private final boolean shouldAnimateViewportTransition(RenderReason r3, IndicatorViewportState r4, IndicatorViewportState r5, boolean r6) {
        if (r3 != RenderReason.SCROLL) goto L16;
        if (r6 == false) goto L16;
        if (r4 != null) goto L12;
        if (IF_DEBUG == false) goto L10;
        L.d(this.tag, "Skip viewport transition, reason=" + r3.getLogValue() + " current=null next=" + r5.getVisibleRange());
    L10:
        return false;
    L12:
        if (this.host.getPagerCount() > this.host.getMaxVisibleDots()) goto L14;
        return false;
    L14:
        return true;
    L16:
        return false;
    }

    private final void startViewportTransition(IndicatorViewportState r11, IndicatorViewportState r12, RenderReason r13) {
        IndicatorViewportShiftDirection r0 = IndicatorViewportStateKt.resolveViewportShiftDirection(r11.getVisibleRange(), r12.getVisibleRange());
        if (r0 != null) goto L6;
        L.w(getTag(), "Abort viewport transition because range shift is not adjacent, source=" + r11.getVisibleRange() + " target=" + r12.getVisibleRange());
        this.host.rebindVisibleSlots(r12, r13);
        this.lastViewportState = r12;
        this.host.applyViewportState(r12);
        return;
    L6:
        float r1 = this.host.resolveViewportStepDistance();
        if (r1 > 0.0f) goto L10;
        L.w(this.tag, Intrinsics.stringPlus("Abort viewport transition because step distance is invalid, distance=", Float.valueOf(r1)));
        this.host.rebindVisibleSlots(r12, r13);
        this.lastViewportState = r12;
        this.host.applyViewportState(r12);
        return;
    L10:
        resetViewportTransitionVisuals();
        int r3 = this.viewportTransitionToken + 1;
        this.viewportTransitionToken = r3;
        final ActiveViewportTransition r9 = new ActiveViewportTransition(r3, r11, r12, r0, r13);
        this.activeViewportTransition = r9;
        if (IF_DEBUG == false) goto L13;
        L.d(this.tag, "Start viewport transition, reason=" + r13.getLogValue() + " from=" + r11.getVisibleRange() + " to=" + r12.getVisibleRange() + " direction=" + r0 + " distance=" + r1);
    L13:
        this.host.applyViewportTransitionProgress(r11, r12, 0.0f);
        startTrackTranslationAnimation(r9, r0.resolveExitTranslation(r1), new AnonymousClass1(this, r9));
    }

    private final void commitViewportTransition(ActiveViewportTransition r7) {
        ActiveViewportTransition r0 = this.activeViewportTransition;
        boolean r1 = false;
        if (r0 != null) goto L6;
    L8:
        if (r1 == true) goto L10;
        return;
    L10:
        IndicatorViewportState r2 = r0.getTargetState();
        this.host.rebindVisibleSlots(r2, r0.getReason());
        this.lastViewportState = r2;
        this.host.applyViewportState(r2);
        boolean r3 = IF_DEBUG;
        if (r3 == false) goto L13;
        L.d(this.tag, "Commit viewport transition, token=" + r7.getTransitionToken() + " range=" + r2.getVisibleRange());
    L13:
        resetViewportTransitionVisuals();
        this.activeViewportTransition = null;
        if (r3 == false) goto L17;
        L.d(this.tag, "Finish viewport transition after commit, token=" + r7.getTransitionToken() + " range=" + r2.getVisibleRange());
        return;
    L17:
        return;
    L6:
        if (r0.getTransitionToken() != r7.getTransitionToken()) goto L8;
        r1 = true;
        goto L8
    }

    private final void startTrackTranslationAnimation(final ActiveViewportTransition r4, float r5, final Function0<Unit> r6) {
        cancelTrackAnimation();
        final float r0 = Math.abs(r5);
        this.trackView.animate().translationX(r5).setDuration(300).setInterpolator(this.interpolator).setUpdateListener(new IndicatorAnimator$$ExternalSyntheticLambda0(this, r4, r0)).setListener(new AnonymousClass2(this, r4, r6)).start();
    }

    /* JADX INFO: renamed from: startTrackTranslationAnimation$lambda-1, reason: not valid java name */
    private static final void m1231startTrackTranslationAnimation$lambda1(IndicatorAnimator r2, ActiveViewportTransition r3, float r4, ValueAnimator r5) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "$transition");
        Intrinsics.checkNotNullParameter(r5, "it");
        ActiveViewportTransition r6 = r2.activeViewportTransition;
        boolean r0 = false;
        if (r6 != null) goto L6;
    L8:
        if (r0 == true) goto L10;
        return;
    L10:
        float r7 = Math.abs(r2.trackView.getTranslationX()) / r4;
        r2.host.applyViewportTransitionProgress(r3.getSourceState(), r3.getTargetState(), r7);
        return;
    L6:
        if (r6.getTransitionToken() != r3.getTransitionToken()) goto L8;
        r0 = true;
        goto L8
    }

    private final void resetViewportTransitionVisuals() {
        this.trackView.setTranslationX(0.0f);
        IndicatorViewportState r0 = this.lastViewportState;
        if (r0 == null) goto L7;
        this.host.applyViewportState(r0);
        return;
    }

    private final void cancelTrackAnimation() {
        this.trackView.animate().setUpdateListener(null).setListener(null).cancel();
    }
}
