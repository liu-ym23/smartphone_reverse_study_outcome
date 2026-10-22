package com.obric.oui.lisitem;

import android.graphics.drawable.GradientDrawable;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.obric.common.oea.foundation.animation.builder.ValueAnimatable;
import com.obric.common.oea.foundation.animation.manager.AnimationManager;
import com.obric.common.oea.foundation.animation.spec.AnimationSpecKt;
import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.layout.OUIFrameLayout;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: OCardListItemPositionHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u000b\b\u0016\u0018\u0000 +2\u00020\u0001:\u0001+B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ8\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J \u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!H\u0002J \u0010\"\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!H\u0002J\"\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00072\b\b\u0002\u0010&\u001a\u00020\u0005H\u0002J\u000e\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u0007J\u001a\u0010)\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u00072\b\b\u0002\u0010&\u001a\u00020\u0005H\u0007J\u000e\u0010*\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u0005R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/obric/oui/lisitem/OCardListItemPositionHelper;", "", "cardContainer", "Landroid/widget/FrameLayout;", "showBg", "", "bgColor", "", "cardPosition", "(Landroid/widget/FrameLayout;ZII)V", "bgDrawable", "Landroid/graphics/drawable/GradientDrawable;", "cardBg", "getCardContainer", "()Landroid/widget/FrameLayout;", "currentCornerRadii", "", "currentPosition", "positionAnimator", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "showCardBg", "animatePositionChange", "", "startRadii", "targetRadii", "startTopPadding", "startBottomPadding", "targetTopPadding", "targetBottomPadding", "lerpInt", "start", TraceStatsConsts.STATS_KEY_END, "progress", "", "lerpRadii", "resetCardContainerIfNeed", "show", "position", "animate", "setBgColor", "color", "setCardPosition", "setShowCardBg", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OCardListItemPositionHelper {
    private static final int CARD_CORNER_RADIUS_DP = 20;
    public static final Companion Companion = null;
    private final GradientDrawable bgDrawable;
    private int cardBg;
    private final FrameLayout cardContainer;
    private float[] currentCornerRadii;
    private int currentPosition;
    private AnimationManager positionAnimator;
    private boolean showCardBg;

    /* JADX INFO: compiled from: OCardListItemPositionHelper.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/lisitem/OCardListItemPositionHelper$Companion;", "", "()V", "CARD_CORNER_RADIUS_DP", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final void setCardPosition(int r4) {
        setCardPosition$default(this, r4, false, 2, null);
    }

    public OCardListItemPositionHelper(FrameLayout r7, boolean r8, int r9, int r10) {
        Intrinsics.checkNotNullParameter(r7, "cardContainer");
        this.cardContainer = r7;
        this.bgDrawable = new GradientDrawable();
        this.showCardBg = true;
        this.currentPosition = -1;
        this.currentCornerRadii = new float[8];
        this.cardBg = r9;
        resetCardContainerIfNeed$default(this, r8, r10, false, 4, null);
    }

    public static final /* synthetic */ GradientDrawable access$getBgDrawable$p(OCardListItemPositionHelper r0) {
        return r0.bgDrawable;
    }

    public static final /* synthetic */ float[] access$getCurrentCornerRadii$p(OCardListItemPositionHelper r0) {
        return r0.currentCornerRadii;
    }

    public static final /* synthetic */ boolean access$getShowCardBg$p(OCardListItemPositionHelper r0) {
        return r0.showCardBg;
    }

    public static final /* synthetic */ int access$lerpInt(OCardListItemPositionHelper r0, int r1, int r2, float r3) {
        return r0.lerpInt(r1, r2, r3);
    }

    public static final /* synthetic */ float[] access$lerpRadii(OCardListItemPositionHelper r0, float[] r1, float[] r2, float r3) {
        return r0.lerpRadii(r1, r2, r3);
    }

    public static final /* synthetic */ void access$setCurrentCornerRadii$p(OCardListItemPositionHelper r0, float[] r1) {
        r0.currentCornerRadii = r1;
    }

    public static final /* synthetic */ void access$setPositionAnimator$p(OCardListItemPositionHelper r0, AnimationManager r1) {
        r0.positionAnimator = r1;
    }

    public final FrameLayout getCardContainer() {
        return this.cardContainer;
    }

    public final void setBgColor(int r7) {
        this.cardBg = r7;
        resetCardContainerIfNeed$default(this, this.showCardBg, this.currentPosition, false, 4, null);
    }

    public final void setShowCardBg(boolean r7) {
        resetCardContainerIfNeed$default(this, r7, this.currentPosition, false, 4, null);
    }

    public static /* synthetic */ void setCardPosition$default(OCardListItemPositionHelper r0, int r1, boolean r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        r0.setCardPosition(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setCardPosition");
    }

    public final void setCardPosition(int r2, boolean r3) {
        resetCardContainerIfNeed(this.showCardBg, r2, r3);
    }

    static /* synthetic */ void resetCardContainerIfNeed$default(OCardListItemPositionHelper r0, boolean r1, int r2, boolean r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L6;
        r3 = false;
    L6:
        r0.resetCardContainerIfNeed(r1, r2, r3);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resetCardContainerIfNeed");
    }

    private final void resetCardContainerIfNeed(boolean r24, int r25, boolean r26) {
        if (this.showCardBg == r24) goto L5;
    L7:
        AnimationManager r2 = this.positionAnimator;
        if (r2 == null) goto L11;
        AnimationManager.cancelAnimation$default(r2, false, 1, null);
    L11:
        if (r26 == true) goto L13;
    L17:
        boolean r3 = false;
    L18:
        float[] r6 = this.currentCornerRadii;
        float[] r7 = Arrays.copyOf(r6, r6.length);
        Intrinsics.checkNotNullExpressionValue(r7, "copyOf(this, size)");
        int r9 = this.cardContainer.getPaddingTop();
        int r10 = this.cardContainer.getPaddingBottom();
        this.showCardBg = r24;
        this.currentPosition = r25;
        float[] r11 = new float[8];
        if (r24 == false) goto L34;
        float r0 = OUnitExtensionKt.vdpFloat(this.cardContainer, 20);
        this.bgDrawable.setColor(this.cardBg);
        int r12 = this.currentPosition;
        if (r12 == 1) goto L27;
        if (r12 == 2) goto L26;
        if (r12 == 3) goto L25;
        r11 = new float[]{r0, r0, r0, r0, r0, r0, r0, r0};
    L28:
        if (r3 == false) goto L30;
        float[] r14 = Arrays.copyOf(r7, r7.length);
        Intrinsics.checkNotNullExpressionValue(r14, "copyOf(this, size)");
    L31:
        this.currentCornerRadii = r14;
        this.bgDrawable.setCornerRadii(r14);
        this.cardContainer.setBackground(this.bgDrawable);
        FrameLayout r8 = this.cardContainer;
        if ((r8 instanceof OUIFrameLayout) == false) goto L35;
        ((OUIFrameLayout) r8).setShadowCornerRadius((int) r0);
    L35:
        int r1 = OUnitExtensionKt.vdp(this.cardContainer, 12);
        int r13 = OUnitExtensionKt.vdp(this.cardContainer, 8);
        int r15 = OUnitExtensionKt.vdp(this.cardContainer, 8);
        int r16 = OUnitExtensionKt.vdp(this.cardContainer, 8);
        int r4 = OUnitExtensionKt.vdp(this.cardContainer, 2);
        int r17 = OUnitExtensionKt.vdp(this.cardContainer, 2);
        int r5 = OUnitExtensionKt.vdp(this.cardContainer, 2);
        int r18 = OUnitExtensionKt.vdp(this.cardContainer, 2);
        int r19 = OUnitExtensionKt.vdp(this.cardContainer, 8);
        int r20 = OUnitExtensionKt.vdp(this.cardContainer, 2);
        int r21 = OUnitExtensionKt.vdp(this.cardContainer, 8);
        int r22 = OUnitExtensionKt.vdp(this.cardContainer, 8);
        int r23 = OUnitExtensionKt.vdp(this.cardContainer, 2);
        ViewGroup.LayoutParams r27 = this.cardContainer.getLayoutParams();
        if ((r27 instanceof ViewGroup.MarginLayoutParams) == false) goto L38;
        ViewGroup.MarginLayoutParams r28 = (ViewGroup.MarginLayoutParams) r27;
    L39:
        if (r28 == null) goto L50;
        if (this.showCardBg == false) goto L44;
        int r29 = r1;
    L45:
        r28.setMarginStart(r29);
        if (this.showCardBg == false) goto L48;
        r13 = r1;
    L48:
        r28.setMarginEnd(r13);
        goto L50
    L44:
        r29 = r13;
    L50:
        if (this.showCardBg == false) goto L52;
        this.cardContainer.setClipChildren(true);
        this.cardContainer.setClipToPadding(true);
        int r30 = 0;
    L54:
        if (this.showCardBg == true) goto L57;
        r15 = r30;
    L57:
        this.cardContainer.getPaddingTop();
        this.cardContainer.getPaddingBottom();
        int r31 = this.currentPosition;
        if (r31 == 1) goto L78;
        if (r31 != 2) goto L62;
        r19 = r5;
        int r32 = r17;
    L82:
        if (r3 == false) goto L84;
        animatePositionChange(r7, r11, r9, r10, r32, r19);
    L85:
        this.cardContainer.requestLayout();
        return;
    L84:
        this.cardContainer.setPadding(r15, r32, r15, r19);
        goto L85
    L62:
        if (r31 == 3) goto L72;
        boolean r33 = this.showCardBg;
        if (r33 == false) goto L66;
        r32 = r21;
    L67:
        if (r33 == false) goto L69;
        int r34 = r22;
    L70:
        r19 = r34;
        goto L82
    L69:
        r34 = r23;
        goto L70
    L66:
        r32 = r30;
        goto L67
    L72:
        if (this.showCardBg == true) goto L75;
        r19 = r20;
    L75:
        r32 = r18;
        goto L82
    L78:
        if (this.showCardBg == false) goto L80;
        r32 = r16;
    L81:
        r19 = r4;
        goto L82
    L80:
        r32 = r30;
        goto L81
    L52:
        r30 = 0;
        this.cardContainer.setClipChildren(false);
        this.cardContainer.setClipToPadding(false);
        goto L54
    L38:
        r28 = null;
        goto L39
    L30:
        r14 = Arrays.copyOf(r11, r11.length);
        Intrinsics.checkNotNullExpressionValue(r14, "copyOf(this, size)");
        goto L31
    L25:
        r11 = new float[]{0.0f, 0.0f, 0.0f, 0.0f, r0, r0, r0, r0};
        goto L28
    L26:
        r11 = new float[8];
        goto L28
    L27:
        r11 = new float[]{r0, r0, r0, r0, 0.0f, 0.0f, 0.0f, 0.0f};
        goto L28
    L34:
        float[] r35 = Arrays.copyOf(r11, 8);
        Intrinsics.checkNotNullExpressionValue(r35, "copyOf(this, size)");
        this.currentCornerRadii = r35;
        this.cardContainer.setBackground(null);
        goto L35
    L13:
        if (this.showCardBg != r24) goto L17;
        if (this.currentPosition == (-1)) goto L17;
        r3 = true;
        goto L18
    L5:
        if (this.currentPosition != r25) goto L7;
    }

    private final void animatePositionChange(final float[] r12, final float[] r13, final int r14, final int r15, final int r16, final int r17) {
        this.positionAnimator = ValueAnimatable.Builder.of$default(new ValueAnimatable.Builder(), 0.0f, 1.0f, AnimationSpecKt.spring$default(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_2, 0, 4, null), null, 8, null).onUpdate(new AnonymousClass1(this, r12, r13, r14, r16, r15, r17)).onEnd(new AnonymousClass2(this, r13, r16, r17)).build().start();
    }

    private final float[] lerpRadii(float[] r5, float[] r6, float r7) {
        float r4 = RangesKt.coerceIn(r7, 0.0f, 1.0f);
        int r8 = r5.length;
        float[] r0 = new float[r8];
        int r1 = 0;
    L3:
        if (r1 >= r8) goto L5;
        float r2 = r5[r1];
        r0[r1] = r2 + ((r6[r1] - r2) * r4);
        r1 = r1 + 1;
        goto L3
    L5:
        return r0;
    }

    private final int lerpInt(int r2, int r3, float r4) {
        return MathKt.roundToInt(r2 + ((r3 - r2) * RangesKt.coerceIn(r4, 0.0f, 1.0f)));
    }
}
