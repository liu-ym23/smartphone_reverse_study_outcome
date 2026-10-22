package com.obric.oui.texteffects.preset;

import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.texteffects.core.BlendSpec;
import com.obric.oui.texteffects.core.Direction;
import com.obric.oui.texteffects.core.EasingSpec;
import com.obric.oui.texteffects.core.EffectLayer;
import com.obric.oui.texteffects.core.EffectProperty;
import com.obric.oui.texteffects.core.EffectStage;
import com.obric.oui.texteffects.core.EffectValue;
import com.obric.oui.texteffects.core.FillSpec;
import com.obric.oui.texteffects.core.Keyframe;
import com.obric.oui.texteffects.core.LoopSpec;
import com.obric.oui.texteffects.core.MaterialLayerSpec;
import com.obric.oui.texteffects.core.PropertyTrack;
import com.obric.oui.texteffects.core.SelectorSpec;
import com.obric.oui.texteffects.core.TextEffectSpec;
import com.obric.oui.texteffects.core.TextSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: DimPointEffectSpecFactory.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002JC\u0010\u0015\u001a\u00020\u00142*\u0010\u0016\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00180\u0017\"\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0002¢\u0006\u0002\u0010\u001dJI\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u001c2*\u0010\u0016\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00180\u0017\"\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u0018H\u0002¢\u0006\u0002\u0010!J,\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u00192\b\b\u0002\u0010&\u001a\u00020\u001a2\b\b\u0002\u0010'\u001a\u00020\u001aH\u0002J\u0018\u0010(\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u0019H\u0002JI\u0010)\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u001c2*\u0010\u0016\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00180\u0017\"\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u0018H\u0002¢\u0006\u0002\u0010!J\u0010\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020-JK\u0010.\u001a\u00020\u00142*\u0010\u0016\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00180\u0017\"\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00182\u0006\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u000200H\u0002¢\u0006\u0002\u00102JC\u00103\u001a\u00020\u00142*\u0010\u0016\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00180\u0017\"\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0002¢\u0006\u0002\u0010\u001dJ&\u00104\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002J@\u00105\u001a\u00020#2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u00042\u0006\u0010/\u001a\u0002002\u0006\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u001aH\u0002J\u0006\u00107\u001a\u00020+J\b\u00108\u001a\u00020\u0014H\u0002J\b\u00109\u001a\u00020\u0014H\u0002J\u0006\u0010:\u001a\u00020+J\u0006\u0010;\u001a\u00020+J\u001a\u0010<\u001a\u00020+2\b\b\u0002\u0010=\u001a\u00020-2\b\b\u0002\u0010>\u001a\u00020\u001aJC\u0010?\u001a\u00020\u00142*\u0010\u0016\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00180\u0017\"\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0002¢\u0006\u0002\u0010\u001dJC\u0010@\u001a\u00020\u00142*\u0010\u0016\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00180\u0017\"\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0002¢\u0006\u0002\u0010\u001dR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/obric/oui/texteffects/preset/DimPointEffectSpecFactory;", "", "()V", "IdPrefix", "", "blurEasing", "Lcom/obric/oui/texteffects/core/EasingSpec$AeAnimator;", "easeInOutEasing", "Lcom/obric/oui/texteffects/core/EasingSpec$CubicBezier;", "easeInQuadEasing", "standRampUpEasing", "standardEasing", "trackingEasing", "baseTextLayer", "Lcom/obric/oui/texteffects/core/EffectLayer$Text;", "id", "source", "Lcom/obric/oui/texteffects/core/TextSource;", "properties", "", "Lcom/obric/oui/texteffects/core/PropertyTrack;", "blurTrack", "frames", "", "Lkotlin/Pair;", "", "", "easing", "Lcom/obric/oui/texteffects/core/EasingSpec;", "([Lkotlin/Pair;Lcom/obric/oui/texteffects/core/EasingSpec;)Lcom/obric/oui/texteffects/core/PropertyTrack;", "dpTrack", "property", "Lcom/obric/oui/texteffects/core/EffectProperty;", "(Lcom/obric/oui/texteffects/core/EffectProperty;Lcom/obric/oui/texteffects/core/EasingSpec;[Lkotlin/Pair;)Lcom/obric/oui/texteffects/core/PropertyTrack;", "enterIndicatorLayer", "Lcom/obric/oui/texteffects/core/EffectLayer$ExternalView;", "startMs", "durationMs", "fromRatio", "toRatio", "exitIndicatorLayer", "floatTrack", "generate", "Lcom/obric/oui/texteffects/core/TextEffectSpec;", "includeEnterIndicator", "", "gradientAlphaScanTrack", MaterialConfigFormatNames.DIRECTION, "Lcom/obric/oui/texteffects/core/Direction;", "gradientAlphaDirection", "([Lkotlin/Pair;Lcom/obric/oui/texteffects/core/Direction;Lcom/obric/oui/texteffects/core/Direction;)Lcom/obric/oui/texteffects/core/PropertyTrack;", "gradientColorFadeTrack", "gradientTextLayer", "indicatorLayer", "bindingKey", "pending", "promptFadeInAlphaTrack", "promptFadeOutAlphaTrack", "promptPendingExit", "promptTextSwitch", "rewrite", "includeIndicators", "oldGradientAlpha", "trackingTrack", "translateXTrack", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DimPointEffectSpecFactory {
    public static final DimPointEffectSpecFactory INSTANCE = null;
    private static final String IdPrefix = "oui.dim_point";
    private static final EasingSpec.AeAnimator blurEasing = null;
    private static final EasingSpec.CubicBezier easeInOutEasing = null;
    private static final EasingSpec.CubicBezier easeInQuadEasing = null;
    private static final EasingSpec.AeAnimator standRampUpEasing = null;
    private static final EasingSpec.CubicBezier standardEasing = null;
    private static final EasingSpec.AeAnimator trackingEasing = null;

    private DimPointEffectSpecFactory() {
    }

    static {
        INSTANCE = new DimPointEffectSpecFactory();
        standardEasing = new EasingSpec.CubicBezier(0.33f, 0.0f, 0.67f, 1.0f);
        easeInOutEasing = new EasingSpec.CubicBezier(0.42f, 0.0f, 0.58f, 1.0f);
        easeInQuadEasing = new EasingSpec.CubicBezier(0.26f, 0.0f, 0.6f, 0.2f);
        standRampUpEasing = new EasingSpec.AeAnimator(0, 0.0f, 0.0f, 1, null);
        blurEasing = new EasingSpec.AeAnimator(0, 0.4f, 0.0f, 1, null);
        trackingEasing = new EasingSpec.AeAnimator(0, 0.3f, 0.0f, 1, null);
    }

    public final TextEffectSpec pending() {
        LoopSpec.Infinite r12 = LoopSpec.Infinite.INSTANCE;
        TextSource r0 = TextSource.Current;
        Float r4 = Float.valueOf(0.0f);
        return new TextEffectSpec("oui.dim_point.pending", 0, DimPointEffectTokens.PendingCycleMs, r12, CollectionsKt.listOf(new EffectStage("pending_breath", 0, DimPointEffectTokens.PendingCycleMs, CollectionsKt.listOf(new EffectLayer.Text[]{baseTextLayer$default(this, "base_text", TextSource.Current, null, 4, null), gradientTextLayer("gradient_overlay", r0, CollectionsKt.listOf(gradientColorFadeTrack$default(this, new Pair[]{TuplesKt.to(0L, r4), TuplesKt.to(750L, Float.valueOf(0.8f)), TuplesKt.to(Long.valueOf(DimPointEffectTokens.PendingCycleMs), r4)}, null, 2, null)))}))), 2, null);
    }

    public final TextEffectSpec promptPendingExit() {
        return new TextEffectSpec("oui.dim_point.prompt_pending_exit", 0, 150, null, CollectionsKt.listOf(new EffectStage("prompt_pending_exit", 0, 150, CollectionsKt.listOf(baseTextLayer("prompt_text_exit", TextSource.Current, CollectionsKt.listOf(promptFadeOutAlphaTrack()))))), 10, null);
    }

    public final TextEffectSpec promptTextSwitch() {
        return new TextEffectSpec("oui.dim_point.prompt_text_switch", 0, 150, null, CollectionsKt.listOf(new EffectStage("prompt_text_switch", 0, 150, CollectionsKt.listOf(new EffectLayer.Text[]{baseTextLayer("old_prompt_exit", TextSource.Old, CollectionsKt.listOf(promptFadeOutAlphaTrack())), baseTextLayer("new_prompt_enter", TextSource.New, CollectionsKt.listOf(promptFadeInAlphaTrack()))}))), 10, null);
    }

    public static /* synthetic */ TextEffectSpec generate$default(DimPointEffectSpecFactory r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return r0.generate(r1);
    }

    public final TextEffectSpec generate(boolean r27) {
        long r17 = Math.max(1250, 1450);
        TextSource r12 = TextSource.Current;
        Float r15 = Float.valueOf(0.03f);
        Float r5 = Float.valueOf(0.0f);
        Pair[] r0 = {TuplesKt.to(150L, r15), TuplesKt.to(1250L, r5)};
        Float r1 = Float.valueOf(-0.5f);
        Float r10 = Float.valueOf(1.0f);
        PropertyTrack[] r13 = {trackingTrack$default(this, r0, null, 2, null), gradientAlphaScanTrack$default(this, new Pair[]{TuplesKt.to(0L, r1), TuplesKt.to(1250L, r10)}, Direction.LeftToRight, null, 4, null)};
        TextSource r14 = TextSource.Current;
        Float r2 = Float.valueOf(0.8f);
        List r16 = CollectionsKt.mutableListOf(new EffectLayer[]{baseTextLayer("generate_scan_base_text", r12, CollectionsKt.listOf(r13)), gradientTextLayer("generate_scan_text", r14, CollectionsKt.listOf(new PropertyTrack[]{gradientColorFadeTrack$default(this, new Pair[]{TuplesKt.to(0L, r2), TuplesKt.to(750L, r2), TuplesKt.to(1450L, r5)}, null, 2, null), trackingTrack$default(this, new Pair[]{TuplesKt.to(150L, r15), TuplesKt.to(1400L, r5)}, null, 2, null), gradientAlphaScanTrack$default(this, new Pair[]{TuplesKt.to(0L, r1), TuplesKt.to(1250L, r10)}, Direction.LeftToRight, null, 4, null)}))});
        if (r27 == false) goto L6;
        r16.add(enterIndicatorLayer(0, 1250, -0.4f, 1.0f));
    L6:
        return new TextEffectSpec("oui.dim_point.generate", 0, r17, null, CollectionsKt.mutableListOf(new EffectStage[]{new EffectStage("generate_enter", 0, r17, r16)}), 10, null);
    }

    public static /* synthetic */ TextEffectSpec rewrite$default(DimPointEffectSpecFactory r0, boolean r1, float r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = 0.0f;
    L9:
        return r0.rewrite(r1, r2);
    }

    public final TextEffectSpec rewrite(boolean r34, float r35) {
        long r21 = Math.max(Math.max(1250, 1450), Math.max(600, Math.max(600, 600)));
        TextSource r5 = TextSource.Old;
        Float r12 = Float.valueOf(0.0f);
        Float r9 = Float.valueOf(16.0f);
        Pair[] r0 = {TuplesKt.to(0L, r12), TuplesKt.to(600L, r9)};
        Float r11 = Float.valueOf(3.0f);
        Pair[] r1 = {TuplesKt.to(0L, r12), TuplesKt.to(600L, r11)};
        Float r10 = Float.valueOf(-0.4f);
        Float r4 = Float.valueOf(1.0f);
        List r15 = CollectionsKt.mutableListOf(new EffectLayer[]{baseTextLayer("old_text_exit", r5, CollectionsKt.listOf(new PropertyTrack[]{blurTrack$default(this, r0, null, 2, null), translateXTrack$default(this, r1, null, 2, null), gradientAlphaScanTrack$default(this, new Pair[]{TuplesKt.to(0L, r10), TuplesKt.to(50L, r10), TuplesKt.to(600L, r4)}, Direction.RightToLeft, null, 4, null)}))});
        Float r8 = Float.valueOf(0.8f);
        if (r35 <= 0.001f) goto L5;
        Float r13 = r4;
        int r14 = 2;
        int r16 = 3;
        r15.add(gradientTextLayer("old_gradient_exit", TextSource.Old, CollectionsKt.listOf(new PropertyTrack[]{gradientColorFadeTrack$default(this, new Pair[]{TuplesKt.to(0L, Float.valueOf(RangesKt.coerceIn(r35, 0.0f, 0.8f))), TuplesKt.to(600L, Float.valueOf(RangesKt.coerceIn(r35, 0.0f, 0.8f)))}, null, 2, null), blurTrack$default(this, new Pair[]{TuplesKt.to(0L, r12), TuplesKt.to(600L, r9)}, null, 2, null), translateXTrack$default(this, new Pair[]{TuplesKt.to(0L, r12), TuplesKt.to(600L, r11)}, null, 2, null), gradientAlphaScanTrack$default(this, new Pair[]{TuplesKt.to(0L, r10), TuplesKt.to(600L, r13)}, Direction.RightToLeft, null, 4, null)})));
    L6:
        EffectLayer[] r7 = new EffectLayer[r14];
        TextSource r17 = TextSource.New;
        PropertyTrack[] r6 = new PropertyTrack[r14];
        Pair[] r2 = new Pair[r14];
        r2[0] = TuplesKt.to(150L, Float.valueOf(0.03f));
        r2[1] = TuplesKt.to(1400L, r12);
        r6[0] = trackingTrack$default(this, r2, null, r14, null);
        Pair[] r3 = new Pair[r14];
        r3[0] = TuplesKt.to(0L, Float.valueOf(-0.5f));
        r3[1] = TuplesKt.to(1250L, r13);
        r6[1] = gradientAlphaScanTrack$default(this, r3, Direction.LeftToRight, null, 4, null);
        r7[0] = baseTextLayer("new_text_enter_base", r17, CollectionsKt.listOf(r6));
        TextSource r18 = TextSource.New;
        PropertyTrack[] r19 = new PropertyTrack[r16];
        Pair[] r20 = new Pair[r16];
        r20[0] = TuplesKt.to(0L, r8);
        r20[1] = TuplesKt.to(750L, r8);
        r20[r14] = TuplesKt.to(1450L, r12);
        r19[0] = gradientColorFadeTrack$default(this, r20, null, r14, null);
        Pair[] r22 = new Pair[r14];
        r22[0] = TuplesKt.to(150L, Float.valueOf(0.03f));
        r22[1] = TuplesKt.to(1400L, r12);
        r19[1] = trackingTrack$default(this, r22, null, r14, null);
        Pair[] r23 = new Pair[r14];
        r23[0] = TuplesKt.to(0L, Float.valueOf(-0.5f));
        r23[1] = TuplesKt.to(1250L, r13);
        r19[r14] = gradientAlphaScanTrack$default(this, r23, Direction.LeftToRight, null, 4, null);
        r7[1] = gradientTextLayer("new_text_enter", r18, CollectionsKt.listOf(r19));
        List r24 = CollectionsKt.mutableListOf(r7);
        if (r34 == false) goto L10;
        r15.add(exitIndicatorLayer(0, 600));
        r24.add(enterIndicatorLayer$default(this, 0, 1250, 0.0f, 0.0f, 12, null));
    L10:
        return new TextEffectSpec("oui.dim_point.rewrite", 0, r21, null, CollectionsKt.mutableListOf(new EffectStage[]{new EffectStage("rewrite", 0, r21, CollectionsKt.plus(r15, r24))}), 10, null);
    L5:
        r14 = 2;
        r13 = r4;
        r16 = 3;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ EffectLayer.Text baseTextLayer$default(DimPointEffectSpecFactory r0, String r1, TextSource r2, List r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = CollectionsKt.emptyList();
    L6:
        return r0.baseTextLayer(r1, r2, r3);
    }

    private final EffectLayer.Text baseTextLayer(String r9, TextSource r10, List<PropertyTrack> r11) {
        return new EffectLayer.Text(r9, r10, FillSpec.TextColor.INSTANCE, null, r11, 8, null);
    }

    private final EffectLayer.Text gradientTextLayer(String r7, TextSource r8, List<PropertyTrack> r9) {
        return new EffectLayer.Text(r7, r8, new FillSpec.LinearGradient(DimPointEffectTokens.INSTANCE.getGradientColors(), DimPointEffectTokens.INSTANCE.getGradientPositions()), BlendSpec.SCREEN, r9);
    }

    static /* synthetic */ EffectLayer.ExternalView enterIndicatorLayer$default(DimPointEffectSpecFactory r7, long r8, long r10, float r12, float r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L5;
        r12 = -0.7f;
    L5:
        float r5 = r12;
        if ((r14 & 8) == 0) goto L9;
        r13 = 1.0f;
    L9:
        return r7.enterIndicatorLayer(r8, r10, r5, r13);
    }

    private final EffectLayer.ExternalView enterIndicatorLayer(long r11, long r13, float r15, float r16) {
        return indicatorLayer("enter_indicator", "enterScanIndicator", Direction.LeftToRight, r11, r13, r15, r16);
    }

    private final EffectLayer.ExternalView exitIndicatorLayer(long r11, long r13) {
        return indicatorLayer("exit_indicator", "exitScanIndicator", Direction.RightToLeft, r11, r13, -0.7f, 1.0f);
    }

    private final EffectLayer.ExternalView indicatorLayer(String r16, String r17, Direction r18, long r19, long r21, float r23, float r24) {
        EffectValue.TextWidthRatio r2 = new EffectValue.TextWidthRatio(r23);
        EffectValue.TextWidthRatio r3 = new EffectValue.TextWidthRatio(r24);
        List r4 = CollectionsKt.createListBuilder();
        if (r19 <= 0) goto L5;
        r4.add(new Keyframe(0, new EffectValue.FloatValue(0.0f)));
        r4.add(new Keyframe(r19, new EffectValue.FloatValue(0.0f)));
    L5:
        r4.add(new Keyframe(r19, new EffectValue.FloatValue(1.0f)));
        long r10 = r19 + r21;
        r4.add(new Keyframe(r10 - 1, new EffectValue.FloatValue(0.0f)));
        List r5 = CollectionsKt.build(r4);
        List r8 = CollectionsKt.createListBuilder();
        if (r19 <= 0) goto L8;
        r8.add(new Keyframe(0, r2));
    L8:
        r8.add(new Keyframe(r19, r2));
        r8.add(new Keyframe(r10, r3));
        List r0 = CollectionsKt.build(r8);
        return new EffectLayer.ExternalView(r16, r17, new MaterialLayerSpec(r18), CollectionsKt.listOf(new PropertyTrack[]{new PropertyTrack(EffectProperty.Visibility, r5, EasingSpec.Linear.INSTANCE, null, 8, null), new PropertyTrack(EffectProperty.TranslationX, r0, easeInOutEasing, null, 8, null)}));
    }

    static /* synthetic */ PropertyTrack gradientColorFadeTrack$default(DimPointEffectSpecFactory r0, Pair[] r1, EasingSpec.CubicBezier r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = easeInOutEasing;
    L6:
        return r0.gradientColorFadeTrack(r1, r2);
    }

    private final PropertyTrack gradientColorFadeTrack(Pair<Long, Float>[] r3, EasingSpec r4) {
        return floatTrack(EffectProperty.Alpha, r4, (Pair[]) Arrays.copyOf(r3, r3.length));
    }

    private final PropertyTrack promptFadeOutAlphaTrack() {
        return floatTrack(EffectProperty.Alpha, easeInQuadEasing, new Pair[]{TuplesKt.to(0L, Float.valueOf(1.0f)), TuplesKt.to(150L, Float.valueOf(0.0f))});
    }

    private final PropertyTrack promptFadeInAlphaTrack() {
        return floatTrack(EffectProperty.Alpha, easeInQuadEasing, new Pair[]{TuplesKt.to(0L, Float.valueOf(0.0f)), TuplesKt.to(150L, Float.valueOf(1.0f))});
    }

    static /* synthetic */ PropertyTrack blurTrack$default(DimPointEffectSpecFactory r0, Pair[] r1, EasingSpec.CubicBezier r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = easeInOutEasing;
    L6:
        return r0.blurTrack(r1, r2);
    }

    private final PropertyTrack blurTrack(Pair<Long, Float>[] r3, EasingSpec r4) {
        return dpTrack(EffectProperty.BlurRadius, r4, (Pair[]) Arrays.copyOf(r3, r3.length));
    }

    static /* synthetic */ PropertyTrack translateXTrack$default(DimPointEffectSpecFactory r0, Pair[] r1, EasingSpec.CubicBezier r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = easeInOutEasing;
    L6:
        return r0.translateXTrack(r1, r2);
    }

    private final PropertyTrack translateXTrack(Pair<Long, Float>[] r3, EasingSpec r4) {
        return dpTrack(EffectProperty.TranslationX, r4, (Pair[]) Arrays.copyOf(r3, r3.length));
    }

    static /* synthetic */ PropertyTrack trackingTrack$default(DimPointEffectSpecFactory r0, Pair[] r1, EasingSpec.CubicBezier r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = easeInOutEasing;
    L6:
        return r0.trackingTrack(r1, r2);
    }

    private final PropertyTrack trackingTrack(Pair<Long, Float>[] r3, EasingSpec r4) {
        return floatTrack(EffectProperty.Tracking, r4, (Pair[]) Arrays.copyOf(r3, r3.length));
    }

    static /* synthetic */ PropertyTrack gradientAlphaScanTrack$default(DimPointEffectSpecFactory r0, Pair[] r1, Direction r2, Direction r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = r2;
    L6:
        return r0.gradientAlphaScanTrack(r1, r2, r3);
    }

    private final PropertyTrack gradientAlphaScanTrack(Pair<Long, Float>[] r9, Direction r10, Direction r11) {
        EffectProperty r8 = EffectProperty.GradientAlphaScan;
        ArrayList r0 = new ArrayList(r9.length);
        int r1 = r9.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        Pair<Long, Float> r3 = r9[r2];
        r0.add(new Keyframe(r3.getFirst().longValue(), new EffectValue.FloatValue(r3.getSecond().floatValue())));
        r2 = r2 + 1;
        goto L3
    L6:
        return new PropertyTrack(r8, r0, easeInOutEasing, new SelectorSpec.ScanWindow(r10, r11, 0.3f, 16.0f));
    }

    private final PropertyTrack floatTrack(EffectProperty r10, EasingSpec r11, Pair<Long, Float>... r12) {
        ArrayList r9 = new ArrayList(r12.length);
        int r0 = r12.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L6;
        Pair<Long, Float> r2 = r12[r1];
        r9.add(new Keyframe(r2.getFirst().longValue(), new EffectValue.FloatValue(r2.getSecond().floatValue())));
        r1 = r1 + 1;
        goto L3
    L6:
        return new PropertyTrack(r10, r9, r11, null, 8, null);
    }

    private final PropertyTrack dpTrack(EffectProperty r10, EasingSpec r11, Pair<Long, Float>... r12) {
        ArrayList r9 = new ArrayList(r12.length);
        int r0 = r12.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L6;
        Pair<Long, Float> r2 = r12[r1];
        r9.add(new Keyframe(r2.getFirst().longValue(), new EffectValue.DimensionDp(r2.getSecond().floatValue())));
        r1 = r1 + 1;
        goto L3
    L6:
        return new PropertyTrack(r10, r9, r11, null, 8, null);
    }
}
