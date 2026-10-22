package com.obric.oui.texteffects;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.android.settings.revone.TabletDpiSettingsFragment;
import com.obric.common.oui.R;
import com.obric.oui.blur.BlurConfig;
import com.obric.oui.blur.BlurToken;
import com.obric.oui.color.BlendConfig;
import com.obric.oui.material.MaterialConfig;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.texteffects.core.Direction;
import com.obric.oui.texteffects.core.EffectLayer;
import com.obric.oui.texteffects.core.EffectProperty;
import com.obric.oui.texteffects.core.EffectStage;
import com.obric.oui.texteffects.core.EffectValue;
import com.obric.oui.texteffects.core.Keyframe;
import com.obric.oui.texteffects.core.MaterialLayerSpec;
import com.obric.oui.texteffects.core.PropertyTrack;
import com.obric.oui.texteffects.core.TextEffectSpec;
import com.obric.oui.texteffects.preset.DimPointEffectSpecFactory;
import com.obric.oui.texteffects.runtime.ExternalViewLayerApplier;
import com.obric.oui.texteffects.runtime.ExternalViewLayerBinding;
import com.obric.oui.texteffects.runtime.TextEffectFrame;
import com.obric.oui.texteffects.runtime.TextEffectTimelineSampler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: ODimPointGenerateEffectView.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 t2\u00020\u0001:\u0001tB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020)H\u0002J\u001a\u0010*\u001a\u00020\"2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0018\u0010+\u001a\u00020\"2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0007H\u0002J\u0010\u0010.\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010/\u001a\u000200H\u0002J\u0018\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0007H\u0002J\b\u00106\u001a\u00020\"H\u0002J\b\u00107\u001a\u00020\"H\u0002J\u0010\u00108\u001a\u00020\n2\u0006\u00109\u001a\u00020:H\u0002J\b\u0010;\u001a\u00020\u0007H\u0002J\u0018\u0010<\u001a\u00020\u00072\u0006\u00109\u001a\u00020:2\u0006\u0010=\u001a\u00020\nH\u0002J\u0010\u0010>\u001a\u00020\u00122\u0006\u0010?\u001a\u000204H\u0002J\u0006\u0010@\u001a\u00020\nJ\b\u0010A\u001a\u00020\"H\u0014J\u0012\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010D\u001a\u00020\u0007H\u0002J\b\u0010E\u001a\u00020&H\u0002J\b\u0010F\u001a\u00020\"H\u0002J\b\u0010G\u001a\u00020\nH\u0002J\u0010\u0010H\u001a\u00020&2\u0006\u0010I\u001a\u00020&H\u0002J\u001f\u0010J\u001a\u0004\u0018\u00010\n2\u0006\u0010#\u001a\u00020$2\u0006\u0010K\u001a\u00020LH\u0002¢\u0006\u0002\u0010MJ\u000e\u0010N\u001a\u00020\"2\u0006\u0010O\u001a\u00020\nJ\u000e\u0010P\u001a\u00020\"2\u0006\u0010Q\u001a\u000202J\u000e\u0010R\u001a\u00020\"2\u0006\u0010Q\u001a\u000202J\u000e\u0010S\u001a\u00020\"2\u0006\u0010Q\u001a\u000202J\u0010\u0010T\u001a\u00020\"2\b\u00109\u001a\u0004\u0018\u00010:J\u0010\u0010U\u001a\u00020\"2\b\u00109\u001a\u0004\u0018\u00010:J\u0012\u0010V\u001a\u00020\"2\n\b\u0002\u0010W\u001a\u0004\u0018\u00010:J\u000e\u0010X\u001a\u00020\"2\u0006\u0010Y\u001a\u00020:J\u000e\u0010Z\u001a\u00020\"2\u0006\u0010[\u001a\u00020:J\u0012\u0010\\\u001a\u00020\"2\n\b\u0002\u0010W\u001a\u0004\u0018\u00010:J\u0010\u0010]\u001a\u00020\"2\b\u00109\u001a\u0004\u0018\u00010:J\u0010\u0010^\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0012\u0010_\u001a\u00020\"2\n\b\u0002\u00109\u001a\u0004\u0018\u00010:J\u000e\u0010`\u001a\u00020\"2\u0006\u0010a\u001a\u00020:J\u000e\u0010b\u001a\u00020\"2\u0006\u0010[\u001a\u00020:J\u000e\u0010c\u001a\u00020\"2\u0006\u0010d\u001a\u00020:J\u000e\u0010e\u001a\u00020\"2\u0006\u0010f\u001a\u00020:J\u0006\u0010g\u001a\u00020\"J\b\u0010h\u001a\u00020\"H\u0002J\u0006\u0010i\u001a\u00020\"J\u0010\u0010j\u001a\u00020\"2\b\u00109\u001a\u0004\u0018\u00010:J\u0010\u0010k\u001a\u00020\n2\u0006\u0010K\u001a\u00020LH\u0002J(\u0010l\u001a\u00020\"2\u0006\u0010m\u001a\u00020\u00122\u0006\u00109\u001a\u00020:2\u0006\u0010#\u001a\u00020$2\u0006\u0010K\u001a\u00020LH\u0002J\u0012\u0010n\u001a\u0004\u0018\u00010\u00122\u0006\u0010K\u001a\u00020LH\u0002J\u0013\u0010o\u001a\u0004\u0018\u00010\n*\u00020pH\u0002¢\u0006\u0002\u0010qJ\f\u0010r\u001a\u00020\u0007*\u00020sH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001f\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b \u0010\u0014¨\u0006u"}, d2 = {"Lcom/obric/oui/texteffects/ODimPointGenerateEffectView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "debugAnimationDurationScale", "", TabletDpiSettingsFragment.UNIT, "Lkotlin/Function1;", "effectTextView", "Lcom/obric/oui/texteffects/ODimPointEffectTextView;", "getEffectTextView", "()Lcom/obric/oui/texteffects/ODimPointEffectTextView;", ODimPointGenerateEffectView.EnterScanIndicatorBindingKey, "Landroid/view/View;", "getEnterScanIndicator", "()Landroid/view/View;", ODimPointGenerateEffectView.ExitScanIndicatorBindingKey, "getExitScanIndicator", "externalAnimator", "Landroid/animation/ValueAnimator;", "externalLayerBindings", "", "Lcom/obric/oui/texteffects/runtime/ExternalViewLayerBinding;", "pendingContentRewriteRunnable", "Ljava/lang/Runnable;", "promptGenerateIndicatorRunnable", "scanIndicator", "getScanIndicator", "applyExternalFrame", "", "spec", "Lcom/obric/oui/texteffects/core/TextEffectSpec;", "playTimeMs", "", "applyTextViewPaddingFromXml", "typedArray", "Landroid/content/res/TypedArray;", "applyTextViewXmlAttributes", "applyTypefaceFromXml", "typefaceValue", "textStyle", "bindExternalLayers", "buildScanIndicatorLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "buildScanIndicatorMaterial", "Lcom/obric/oui/material/MaterialConfig;", "isLight", "", MaterialConfigFormatNames.DIRECTION, "cancelPendingContentRewriteRunnable", "cancelPromptGenerateIndicatorRunnable", "computeDisplayTextWidthPx", "text", "", "computeScanIndicatorHeightPx", "computeScanIndicatorWidthPx", "fromRatio", "createScanIndicator", "enter", "getDebugAnimationDurationScale", "onDetachedFromWindow", "parseEllipsize", "Landroid/text/TextUtils$TruncateAt;", "value", "remainingRewriteDurationMs", "resetExternalLayers", "resolvedExternalParentWidthPx", "scaledDurationMs", "durationMs", "scanIndicatorFromRatio", "bindingKey", "", "(Lcom/obric/oui/texteffects/core/TextEffectSpec;Ljava/lang/String;)Ljava/lang/Float;", "setDebugAnimationDurationScale", "scale", "setEnterScanIndicatorMaterial", "config", "setExitScanIndicatorMaterial", "setScanIndicatorMaterial", "setText", "setTextWithEffect", "showContentPending", "contentText", "showPromptFailure", "failurePromptText", "showPromptPending", "promptText", "startContentPending", "startDimPointTextEffect", "startExternalLayerAnimator", "startGenerate", "startGenerateFromPromptPending", "actualText", "startPromptPending", "startPromptTextSwitch", "newPromptText", "startRewrite", "newText", "stopEffect", "stopExternalAnimator", "stopGenerate", "submitContentText", "textWidthForBindingKey", "updateScanIndicatorSize", "view", "viewForBindingKey", "textWidthRatioOrNull", "Lcom/obric/oui/texteffects/core/EffectValue;", "(Lcom/obric/oui/texteffects/core/EffectValue;)Ljava/lang/Float;", "toMaterialBlurDirection", "Lcom/obric/oui/texteffects/core/Direction;", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ODimPointGenerateEffectView extends FrameLayout {
    private static final Companion Companion = null;

    @Deprecated
    private static final String EnterScanIndicatorBindingKey = "enterScanIndicator";

    @Deprecated
    private static final String ExitScanIndicatorBindingKey = "exitScanIndicator";

    @Deprecated
    private static final String Tag = "DimPointGenerateView";
    private float debugAnimationDurationScale;
    private final Function1<Float, Integer> dp;
    private final ODimPointEffectTextView effectTextView;
    private final View enterScanIndicator;
    private final View exitScanIndicator;
    private ValueAnimator externalAnimator;
    private final List<ExternalViewLayerBinding> externalLayerBindings;
    private Runnable pendingContentRewriteRunnable;
    private Runnable promptGenerateIndicatorRunnable;

    /* JADX INFO: compiled from: ODimPointGenerateEffectView.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/texteffects/ODimPointGenerateEffectView$Companion;", "", "()V", "EnterScanIndicatorBindingKey", "", "ExitScanIndicatorBindingKey", "Tag", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: ODimPointGenerateEffectView.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[Direction.values().length];
            r0[Direction.RightToLeft.ordinal()] = 1;
            r0[Direction.LeftToRight.ordinal()] = 2;
            r0[Direction.TopToBottom.ordinal()] = 3;
            r0[Direction.BottomToTop.ordinal()] = 4;
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static /* synthetic */ void $r8$lambda$kGKbKatVBNzJtGx4TAqtCDhP6Qg(TextEffectSpec r0, ODimPointGenerateEffectView r1, ValueAnimator r2) {
        m1411startExternalLayerAnimator$lambda11$lambda10(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$rltG3fxPEtcOM1Ij2vlTt2El3bU(ODimPointGenerateEffectView r0, TextEffectSpec r1) {
        m1412startGenerateFromPromptPending$lambda5(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$u5FFDfbdXFHgHyKBngFycc20gVs(ODimPointGenerateEffectView r0, CharSequence r1) {
        m1413startRewrite$lambda6(r0, r1);
    }

    static {
        Companion = new Companion(null);
    }

    public ODimPointGenerateEffectView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public ODimPointGenerateEffectView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ ODimPointGenerateEffectView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ void access$resetExternalLayers(ODimPointGenerateEffectView r0) {
        r0.resetExternalLayers();
    }

    public static final /* synthetic */ float access$textWidthForBindingKey(ODimPointGenerateEffectView r0, String r1) {
        return r0.textWidthForBindingKey(r1);
    }

    public ODimPointGenerateEffectView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.externalLayerBindings = new ArrayList();
        this.debugAnimationDurationScale = 1.0f;
        Function1<Float, Integer> r0 = new ODimPointGenerateEffectView$dp$1(this);
        this.dp = r0;
        TextEffectDebugLog r1 = TextEffectDebugLog.INSTANCE;
        if (TextEffectDebugLog.getEnabled() == false) goto L5;
        Log.d(Intrinsics.stringPlus("OUITextEffects/", Tag), "init DimPointGenerateEffectView");
    L5:
        setClipChildren(false);
        setClipToPadding(false);
        ODimPointEffectTextView r8 = new ODimPointEffectTextView(r10, null, 0, 6, null);
        r8.setGravity(16);
        r8.setIncludeFontPadding(false);
        r8.setSingleLine(true);
        r8.setPadding(r0.invoke(Float.valueOf(16.0f)).intValue(), 0, r0.invoke(Float.valueOf(16.0f)).intValue(), 0);
        this.effectTextView = r8;
        applyTextViewXmlAttributes(r11, r12);
        addView(r8, new FrameLayout.LayoutParams(-1, r0.invoke(Float.valueOf(56.0f)).intValue(), 16));
        View r13 = createScanIndicator(false);
        this.exitScanIndicator = r13;
        View r14 = createScanIndicator(true);
        this.enterScanIndicator = r14;
        addView(r13, buildScanIndicatorLayoutParams());
        addView(r14, buildScanIndicatorLayoutParams());
        bindExternalLayers(DimPointEffectSpecFactory.rewrite$default(DimPointEffectSpecFactory.INSTANCE, true, 0.0f, 2, null));
        resetExternalLayers();
    }

    public final ODimPointEffectTextView getEffectTextView() {
        return this.effectTextView;
    }

    public final View getExitScanIndicator() {
        return this.exitScanIndicator;
    }

    public final View getEnterScanIndicator() {
        return this.enterScanIndicator;
    }

    public final View getScanIndicator() {
        return this.enterScanIndicator;
    }

    private final void applyTextViewXmlAttributes(AttributeSet r4, int r5) {
        if (r4 != null) goto L5;
        if (r5 != 0) goto L5;
        return;
    L5:
        TypedArray r6 = getContext().obtainStyledAttributes(r4, R.styleable.ODimPointGenerateEffectView, r5, 0);
        Intrinsics.checkNotNullExpressionValue(r6, "context.obtainStyledAttr…ectView, defStyleAttr, 0)");
    L64:
        th = move-exception;
        r6.recycle();
        throw th;
    L7:
        if (r6.hasValue(R.styleable.ODimPointGenerateEffectView_android_textAppearance) == false) goto L12;
        int r7 = r6.getResourceId(R.styleable.ODimPointGenerateEffectView_android_textAppearance, 0);     // Catch: Throwable -> L64
        if (r7 == 0) goto L12;
        this.effectTextView.setTextAppearance(r7);     // Catch: Throwable -> L64
    L12:
        if (r6.hasValue(R.styleable.ODimPointGenerateEffectView_android_text) == false) goto L15;
        this.effectTextView.setText(r6.getText(R.styleable.ODimPointGenerateEffectView_android_text));     // Catch: Throwable -> L64
    L15:
        if (r6.hasValue(R.styleable.ODimPointGenerateEffectView_android_hint) == false) goto L18;
        this.effectTextView.setHint(r6.getText(R.styleable.ODimPointGenerateEffectView_android_hint));     // Catch: Throwable -> L64
    L18:
        if (r6.hasValue(R.styleable.ODimPointGenerateEffectView_android_textColor) == false) goto L24;
        ColorStateList r8 = r6.getColorStateList(R.styleable.ODimPointGenerateEffectView_android_textColor);     // Catch: Throwable -> L64
        if (r8 == null) goto L24;
        getEffectTextView().setTextColor(r8);     // Catch: Throwable -> L64
    L24:
        if (r6.hasValue(R.styleable.ODimPointGenerateEffectView_android_textColorHint) == false) goto L30;
        ColorStateList r9 = r6.getColorStateList(R.styleable.ODimPointGenerateEffectView_android_textColorHint);     // Catch: Throwable -> L64
        if (r9 == null) goto L30;
        getEffectTextView().setHintTextColor(r9);     // Catch: Throwable -> L64
    L30:
        if (r6.hasValue(R.styleable.ODimPointGenerateEffectView_android_textSize) == false) goto L32;
        this.effectTextView.setTextSize(0, r6.getDimension(R.styleable.ODimPointGenerateEffectView_android_textSize, this.effectTextView.getTextSize()));     // Catch: Throwable -> L64
    L32:
        applyTypefaceFromXml(r6.getInt(R.styleable.ODimPointGenerateEffectView_android_typeface, -1), r6.getInt(R.styleable.ODimPointGenerateEffectView_android_textStyle, -1));     // Catch: Throwable -> L64
        if (r6.hasValue(R.styleable.ODimPointGenerateEffectView_android_gravity) == false) goto L36;
        this.effectTextView.setGravity(r6.getInt(R.styleable.ODimPointGenerateEffectView_android_gravity, this.effectTextView.getGravity()));     // Catch: Throwable -> L64
    L36:
        if (r6.hasValue(R.styleable.ODimPointGenerateEffectView_android_includeFontPadding) == false) goto L39;
        this.effectTextView.setIncludeFontPadding(r6.getBoolean(R.styleable.ODimPointGenerateEffectView_android_includeFontPadding, this.effectTextView.getIncludeFontPadding()));     // Catch: Throwable -> L64
    L39:
        if (r6.hasValue(R.styleable.ODimPointGenerateEffectView_android_singleLine) == false) goto L42;
        this.effectTextView.setSingleLine(r6.getBoolean(R.styleable.ODimPointGenerateEffectView_android_singleLine, true));     // Catch: Throwable -> L64
    L42:
        if (r6.hasValue(R.styleable.ODimPointGenerateEffectView_android_lines) == false) goto L45;
        this.effectTextView.setLines(r6.getInt(R.styleable.ODimPointGenerateEffectView_android_lines, 1));     // Catch: Throwable -> L64
    L45:
        if (r6.hasValue(R.styleable.ODimPointGenerateEffectView_android_minLines) == false) goto L48;
        this.effectTextView.setMinLines(r6.getInt(R.styleable.ODimPointGenerateEffectView_android_minLines, 1));     // Catch: Throwable -> L64
    L48:
        if (r6.hasValue(R.styleable.ODimPointGenerateEffectView_android_maxLines) == false) goto L51;
        this.effectTextView.setMaxLines(r6.getInt(R.styleable.ODimPointGenerateEffectView_android_maxLines, Integer.MAX_VALUE));     // Catch: Throwable -> L64
    L51:
        if (r6.hasValue(R.styleable.ODimPointGenerateEffectView_android_ellipsize) == false) goto L54;
        this.effectTextView.setEllipsize(parseEllipsize(r6.getInt(R.styleable.ODimPointGenerateEffectView_android_ellipsize, 0)));     // Catch: Throwable -> L64
    L54:
        if (r6.hasValue(R.styleable.ODimPointGenerateEffectView_android_lineSpacingExtra) == false) goto L56;
    L57:
        float r10 = r6.getDimension(R.styleable.ODimPointGenerateEffectView_android_lineSpacingExtra, 0.0f);     // Catch: Throwable -> L64
        float r0 = r6.getFloat(R.styleable.ODimPointGenerateEffectView_android_lineSpacingMultiplier, 1.0f);     // Catch: Throwable -> L64
        this.effectTextView.setLineSpacing(r10, r0);     // Catch: Throwable -> L64
    L59:
        if (r6.hasValue(R.styleable.ODimPointGenerateEffectView_android_letterSpacing) == false) goto L61;
        this.effectTextView.setLetterSpacing(r6.getFloat(R.styleable.ODimPointGenerateEffectView_android_letterSpacing, this.effectTextView.getLetterSpacing()));     // Catch: Throwable -> L64
    L61:
        applyTextViewPaddingFromXml(r6);     // Catch: Throwable -> L64
        r6.recycle();
        return;
    L56:
        if (r6.hasValue(R.styleable.ODimPointGenerateEffectView_android_lineSpacingMultiplier) == false) goto L59;
        goto L57
    }

    private final void applyTypefaceFromXml(int r3, int r4) {
        if (r4 < 0) goto L4;
        int r0 = r4;
    L6:
        if (r3 != 1) goto L8;
        Typeface r1 = Typeface.SANS_SERIF;
    L15:
        if (r3 >= 0) goto L17;
        if (r4 >= 0) goto L17;
        return;
    L17:
        this.effectTextView.setTypeface(r1, r0);
        return;
    L8:
        if (r3 != 2) goto L10;
        r1 = Typeface.SERIF;
        goto L15
    L10:
        if (r3 == 3) goto L12;
        r1 = this.effectTextView.getTypeface();
        goto L15
    L12:
        r1 = Typeface.MONOSPACE;
        goto L15
    L4:
        r0 = 0;
        goto L6
    }

    private final void applyTextViewPaddingFromXml(TypedArray r7) {
        int r0 = this.effectTextView.getPaddingLeft();
        int r1 = this.effectTextView.getPaddingTop();
        int r2 = this.effectTextView.getPaddingRight();
        int r3 = this.effectTextView.getPaddingBottom();
        if (r7.hasValue(R.styleable.ODimPointGenerateEffectView_android_padding) == false) goto L5;
        Integer r4 = Integer.valueOf(r7.getDimensionPixelSize(R.styleable.ODimPointGenerateEffectView_android_padding, 0));
    L6:
        if (r4 == null) goto L9;
        r0 = r4.intValue();
    L9:
        if (r4 == null) goto L12;
        r1 = r4.intValue();
    L12:
        if (r4 == null) goto L15;
        r2 = r4.intValue();
    L15:
        if (r4 == null) goto L19;
        r3 = r4.intValue();
    L19:
        if (r7.hasValue(R.styleable.ODimPointGenerateEffectView_android_paddingLeft) == false) goto L22;
        r0 = r7.getDimensionPixelSize(R.styleable.ODimPointGenerateEffectView_android_paddingLeft, r0);
    L22:
        if (r7.hasValue(R.styleable.ODimPointGenerateEffectView_android_paddingTop) == false) goto L25;
        r1 = r7.getDimensionPixelSize(R.styleable.ODimPointGenerateEffectView_android_paddingTop, r1);
    L25:
        if (r7.hasValue(R.styleable.ODimPointGenerateEffectView_android_paddingRight) == false) goto L28;
        r2 = r7.getDimensionPixelSize(R.styleable.ODimPointGenerateEffectView_android_paddingRight, r2);
    L28:
        if (r7.hasValue(R.styleable.ODimPointGenerateEffectView_android_paddingBottom) == false) goto L31;
        r3 = r7.getDimensionPixelSize(R.styleable.ODimPointGenerateEffectView_android_paddingBottom, r3);
    L31:
        if (r7.hasValue(R.styleable.ODimPointGenerateEffectView_android_paddingStart) == false) goto L34;
        r0 = r7.getDimensionPixelSize(R.styleable.ODimPointGenerateEffectView_android_paddingStart, r0);
    L34:
        if (r7.hasValue(R.styleable.ODimPointGenerateEffectView_android_paddingEnd) == false) goto L36;
        r2 = r7.getDimensionPixelSize(R.styleable.ODimPointGenerateEffectView_android_paddingEnd, r2);
    L36:
        this.effectTextView.setPadding(r0, r1, r2, r3);
        return;
    L5:
        r4 = null;
        Integer r5 = (Integer) null;
        goto L6
    }

    private final TextUtils.TruncateAt parseEllipsize(int r1) {
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L19;
        if (r1 == 3) goto L18;
        if (r1 == 4) goto L17;
        return null;
    L17:
        return TextUtils.TruncateAt.MARQUEE;
    L18:
        return TextUtils.TruncateAt.END;
    L19:
        return TextUtils.TruncateAt.MIDDLE;
    L15:
        return TextUtils.TruncateAt.START;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        TextEffectDebugLog r0 = TextEffectDebugLog.INSTANCE;
        if (TextEffectDebugLog.getEnabled() == false) goto L5;
        Log.d(Intrinsics.stringPlus("OUITextEffects/", Tag), "onDetachedFromWindow");
    L5:
        stopEffect();
        super.onDetachedFromWindow();
    }

    public final void setText(CharSequence r1) {
        stopEffect();
        this.effectTextView.setText(r1);
    }

    public static /* synthetic */ void startGenerate$default(ODimPointGenerateEffectView r0, CharSequence r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.startGenerate(r1);
    }

    public final void startGenerate(CharSequence r4) {
        cancelPromptGenerateIndicatorRunnable();
        cancelPendingContentRewriteRunnable();
        TextEffectSpec r0 = DimPointEffectSpecFactory.INSTANCE.generate(true);
        this.effectTextView.setDebugAnimationDurationScale(this.debugAnimationDurationScale);
        this.effectTextView.startGenerate(r4);
        View r5 = this.enterScanIndicator;
        CharSequence r1 = this.effectTextView.getText();
        if (r1 != null) goto L5;
    L5:
        updateScanIndicatorSize(r5, r1, r0, EnterScanIndicatorBindingKey);
        startExternalLayerAnimator(r0);
    }

    public final void startDimPointTextEffect(CharSequence r1) {
        submitContentText(r1);
    }

    public final void submitContentText(CharSequence r5) {
        String r0 = this.effectTextView.getText();
        if (r0 != null) goto L5;
    L5:
        if (r5 != null) goto L7;
    L7:
        boolean r2 = true;
        if (this.effectTextView.isPromptPending() == false) goto L17;
        if (r5.length() <= 0) goto L12;
        boolean r1 = true;
    L13:
        if (r1 == false) goto L17;
        startGenerateFromPromptPending(r5);
        return;
    L12:
        r1 = false;
    L17:
        if (TextUtils.equals(r0, r5) == false) goto L25;
        if (r0.length() == 0) goto L22;
        r2 = false;
    L22:
        if (r2 == false) goto L32;
        stopEffect();
        this.effectTextView.setText(r5);
        return;
    L32:
        return;
    L25:
        if (r0.length() == 0) goto L28;
        r2 = false;
    L28:
        if (r2 == false) goto L30;
        startGenerate(r5);
        return;
    L30:
        startRewrite(r5);
    }

    public final void setTextWithEffect(CharSequence r1) {
        submitContentText(r1);
    }

    public final void showPromptPending(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "promptText");
        startPromptPending(r2);
    }

    public final void showPromptFailure(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "failurePromptText");
        startPromptTextSwitch(r2);
    }

    public static /* synthetic */ void showContentPending$default(ODimPointGenerateEffectView r0, CharSequence r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = r0.effectTextView.getText();
    L5:
        r0.showContentPending(r1);
    }

    public final void showContentPending(CharSequence r1) {
        startContentPending(r1);
    }

    public final void startPromptPending(CharSequence r3) {
        Intrinsics.checkNotNullParameter(r3, "promptText");
        cancelPromptGenerateIndicatorRunnable();
        cancelPendingContentRewriteRunnable();
        stopExternalAnimator();
        this.effectTextView.setDebugAnimationDurationScale(this.debugAnimationDurationScale);
        this.effectTextView.startPromptPending(r3);
    }

    public static /* synthetic */ void startContentPending$default(ODimPointGenerateEffectView r0, CharSequence r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = r0.effectTextView.getText();
    L5:
        r0.startContentPending(r1);
    }

    public final void startContentPending(CharSequence r3) {
        cancelPromptGenerateIndicatorRunnable();
        cancelPendingContentRewriteRunnable();
        stopExternalAnimator();
        this.effectTextView.setDebugAnimationDurationScale(this.debugAnimationDurationScale);
        this.effectTextView.startContentPending(r3);
    }

    public final void startGenerateFromPromptPending(CharSequence r4) {
        Intrinsics.checkNotNullParameter(r4, "actualText");
        cancelPromptGenerateIndicatorRunnable();
        cancelPendingContentRewriteRunnable();
        if (this.effectTextView.isPromptPending() == true) goto L6;
        startGenerate(r4);
        return;
    L6:
        stopExternalAnimator();
        this.effectTextView.setDebugAnimationDurationScale(this.debugAnimationDurationScale);
        this.effectTextView.startGenerateFromPromptPending(r4);
        final TextEffectSpec r0 = DimPointEffectSpecFactory.INSTANCE.generate(true);
        updateScanIndicatorSize(this.enterScanIndicator, r4, r0, EnterScanIndicatorBindingKey);
        Runnable r5 = new ODimPointGenerateEffectView$$ExternalSyntheticLambda2(this, r0);
        this.promptGenerateIndicatorRunnable = r5;
        postDelayed(r5, scaledDurationMs(150));
    }

    /* JADX INFO: renamed from: startGenerateFromPromptPending$lambda-5, reason: not valid java name */
    private static final void m1412startGenerateFromPromptPending$lambda5(ODimPointGenerateEffectView r1, TextEffectSpec r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$spec");
        r1.promptGenerateIndicatorRunnable = null;
        r1.startExternalLayerAnimator(r2);
    }

    public final void startPromptTextSwitch(CharSequence r3) {
        Intrinsics.checkNotNullParameter(r3, "newPromptText");
        cancelPromptGenerateIndicatorRunnable();
        cancelPendingContentRewriteRunnable();
        stopExternalAnimator();
        this.effectTextView.setDebugAnimationDurationScale(this.debugAnimationDurationScale);
        this.effectTextView.startPromptTextSwitch(r3);
    }

    public final void startRewrite(final CharSequence r6) {
        Intrinsics.checkNotNullParameter(r6, "newText");
        cancelPromptGenerateIndicatorRunnable();
        cancelPendingContentRewriteRunnable();
        TextEffectSpec r0 = DimPointEffectSpecFactory.rewrite$default(DimPointEffectSpecFactory.INSTANCE, true, 0.0f, 2, null);
        if (this.effectTextView.isRewriteExitingOldText() == false) goto L7;
        this.effectTextView.startRewrite(r6);
        updateScanIndicatorSize(this.enterScanIndicator, r6, r0, EnterScanIndicatorBindingKey);
        return;
    L7:
        if (this.effectTextView.isRewriteEnteringNewText() == false) goto L10;
        Runnable r1 = new ODimPointGenerateEffectView$$ExternalSyntheticLambda0(this, r6);
        this.pendingContentRewriteRunnable = r1;
        postDelayed(r1, remainingRewriteDurationMs());
        return;
    L10:
        CharSequence r2 = this.effectTextView.getText();
        if (r2 != null) goto L13;
    L13:
        this.effectTextView.setDebugAnimationDurationScale(this.debugAnimationDurationScale);
        this.effectTextView.startRewrite(r6);
        updateScanIndicatorSize(this.exitScanIndicator, r2, r0, ExitScanIndicatorBindingKey);
        updateScanIndicatorSize(this.enterScanIndicator, r6, r0, EnterScanIndicatorBindingKey);
        startExternalLayerAnimator(r0);
    }

    /* JADX INFO: renamed from: startRewrite$lambda-6, reason: not valid java name */
    private static final void m1413startRewrite$lambda6(ODimPointGenerateEffectView r1, CharSequence r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$newText");
        r1.pendingContentRewriteRunnable = null;
        r1.startRewrite(r2);
    }

    public final void stopGenerate() {
        stopEffect();
    }

    public final void stopEffect() {
        TextEffectDebugLog r0 = TextEffectDebugLog.INSTANCE;
        if (TextEffectDebugLog.getEnabled() == false) goto L5;
        Log.d(Intrinsics.stringPlus("OUITextEffects/", Tag), "stopEffect");
    L5:
        cancelPromptGenerateIndicatorRunnable();
        cancelPendingContentRewriteRunnable();
        stopExternalAnimator();
        this.effectTextView.stopEffect();
    }

    public final void setDebugAnimationDurationScale(float r4) {
        if (Float.isNaN(r4) == false) goto L5;
    L8:
        float r5 = 1.0f;
    L10:
        if (this.debugAnimationDurationScale != r5) goto L12;
        boolean r0 = true;
    L13:
        if (r0 == false) goto L15;
        return;
    L15:
        this.debugAnimationDurationScale = r5;
        TextEffectDebugLog r1 = TextEffectDebugLog.INSTANCE;
        if (TextEffectDebugLog.getEnabled() == false) goto L18;
        Log.d(Intrinsics.stringPlus("OUITextEffects/", Tag), Intrinsics.stringPlus("setDebugAnimationDurationScale scale=", Float.valueOf(r5)));
    L18:
        this.effectTextView.setDebugAnimationDurationScale(r5);
        return;
    L12:
        r0 = false;
        goto L13
    L5:
        if (Float.isInfinite(r4) == true) goto L8;
        r5 = RangesKt.coerceIn(r4, 0.1f, 10.0f);
        goto L10
    }

    public final float getDebugAnimationDurationScale() {
        return this.debugAnimationDurationScale;
    }

    public final void setScanIndicatorMaterial(MaterialConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        setEnterScanIndicatorMaterial(r2);
    }

    public final void setEnterScanIndicatorMaterial(MaterialConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        OMaterialHelper.setCommonGradientBlur(this.enterScanIndicator, r2);
    }

    public final void setExitScanIndicatorMaterial(MaterialConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        OMaterialHelper.setCommonGradientBlur(this.exitScanIndicator, r2);
    }

    private final void startExternalLayerAnimator(final TextEffectSpec r5) {
        stopExternalAnimator();
        bindExternalLayers(r5);
        final Ref.BooleanRef r0 = new Ref.BooleanRef();
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r1.setDuration(scaledDurationMs(r5.getDurationMs()));
        r1.setInterpolator(new LinearInterpolator());
        r1.addUpdateListener(new ODimPointGenerateEffectView$$ExternalSyntheticLambda1(r5, this));
        r1.addListener(new ODimPointGenerateEffectView$startExternalLayerAnimator$1$2(r0, r5, this));
        r1.start();
        this.externalAnimator = r1;
    }

    /* JADX INFO: renamed from: startExternalLayerAnimator$lambda-11$lambda-10, reason: not valid java name */
    private static final void m1411startExternalLayerAnimator$lambda11$lambda10(TextEffectSpec r4, ODimPointGenerateEffectView r5, ValueAnimator r6) {
        Intrinsics.checkNotNullParameter(r4, "$spec");
        Intrinsics.checkNotNullParameter(r5, "this$0");
        Intrinsics.checkNotNullParameter(r6, "animator");
        long r0 = (long) (r6.getAnimatedFraction() * r4.getDurationMs());
        TextEffectDebugLog r7 = TextEffectDebugLog.INSTANCE;
        if (TextEffectDebugLog.getEnabled() == true) goto L5;
    L7:
        r5.applyExternalFrame(r4, r0);
        return;
    L5:
        if (TextEffectDebugLog.getFrameEnabled() == false) goto L7;
        Log.d(Intrinsics.stringPlus("OUITextEffects/", Tag), "external animator update spec=" + r4.getId() + ", playTime=" + r0);
        goto L7
    }

    private final void applyExternalFrame(TextEffectSpec r2, long r3) {
        TextEffectFrame r4 = TextEffectTimelineSampler.INSTANCE.sample(r2, r3);
        ExternalViewLayerApplier.INSTANCE.apply(r4, this.externalLayerBindings, resolvedExternalParentWidthPx());
    }

    private final float resolvedExternalParentWidthPx() {
        Integer r0 = Integer.valueOf(getWidth());
        boolean r2 = true;
        int r3 = 0;
        if (r0.intValue() <= 0) goto L5;
        boolean r1 = true;
    L6:
        Integer r4 = null;
        if (r1 == true) goto L10;
        r0 = null;
    L10:
        if (r0 != null) goto L36;
        r0 = Integer.valueOf(getMeasuredWidth());
        if (r0.intValue() <= 0) goto L14;
        boolean r5 = true;
    L15:
        if (r5 == true) goto L18;
        r0 = null;
    L18:
        if (r0 != null) goto L36;
        r0 = Integer.valueOf(this.effectTextView.getWidth());
        if (r0.intValue() <= 0) goto L22;
        boolean r6 = true;
    L23:
        if (r6 == true) goto L26;
        r0 = null;
    L26:
        if (r0 != null) goto L36;
        Integer r7 = Integer.valueOf(this.effectTextView.getMeasuredWidth());
        if (r7.intValue() > 0) goto L31;
        r2 = false;
    L31:
        if (r2 == false) goto L33;
        r4 = r7;
    L33:
        if (r4 == null) goto L38;
        r3 = r4.intValue();
    L38:
        return r3;
    L22:
        r6 = false;
        goto L23
    L14:
        r5 = false;
    L36:
        r3 = r0.intValue();
        goto L38
    L5:
        r1 = false;
        goto L6
    }

    private final void stopExternalAnimator() {
        if (this.externalAnimator == null) goto L7;
        TextEffectDebugLog r0 = TextEffectDebugLog.INSTANCE;
        if (TextEffectDebugLog.getEnabled() == false) goto L7;
        Log.d(Intrinsics.stringPlus("OUITextEffects/", Tag), "stopExternalAnimator");
    L7:
        ValueAnimator r1 = this.externalAnimator;
        if (r1 == null) goto L11;
        r1.cancel();
    L11:
        this.externalAnimator = null;
        resetExternalLayers();
    }

    private final void cancelPromptGenerateIndicatorRunnable() {
        Runnable r0 = this.promptGenerateIndicatorRunnable;
        if (r0 == null) goto L6;
        removeCallbacks(r0);
    L6:
        this.promptGenerateIndicatorRunnable = null;
    }

    private final void cancelPendingContentRewriteRunnable() {
        Runnable r0 = this.pendingContentRewriteRunnable;
        if (r0 == null) goto L6;
        removeCallbacks(r0);
    L6:
        this.pendingContentRewriteRunnable = null;
    }

    private final long remainingRewriteDurationMs() {
        return scaledDurationMs(RangesKt.coerceAtLeast(DimPointEffectSpecFactory.rewrite$default(DimPointEffectSpecFactory.INSTANCE, true, 0.0f, 2, null).getDurationMs() - this.effectTextView.currentRewritePlayTimeMs(), 1));
    }

    private final void resetExternalLayers() {
        Iterator<T> r1 = this.externalLayerBindings.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((ExternalViewLayerBinding) r1.next()).reset();
        goto L4
    }

    private final void bindExternalLayers(TextEffectSpec r12) {
        this.externalLayerBindings.clear();
        List<EffectStage> r13 = r12.getStages();
        ArrayList r0 = new ArrayList();
        Iterator<T> r14 = r13.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        CollectionsKt.addAll(r0, ((EffectStage) r14.next()).getLayers());
        goto L4
    L6:
        ArrayList r15 = new ArrayList();
        Iterator r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L12;
        Object r2 = r1.next();
        if ((r2 instanceof EffectLayer.ExternalView) == false) goto L8;
        r15.add(r2);
        goto L8
    L12:
        HashSet r3 = new HashSet();
        ArrayList r4 = new ArrayList();
        Iterator r16 = r15.iterator();
    L14:
        if (r16.hasNext() == false) goto L18;
        Object r5 = r16.next();
        if (r3.add(((EffectLayer.ExternalView) r5).getBindingKey()) == false) goto L14;
        r4.add(r5);
        goto L14
    L18:
        Iterator r17 = r4.iterator();
    L20:
        if (r17.hasNext() == false) goto L31;
        final EffectLayer.ExternalView r6 = (EffectLayer.ExternalView) r17.next();
        View r7 = viewForBindingKey(r6.getBindingKey());
        if (r7 == null) goto L20;
        MaterialLayerSpec r8 = r6.getMaterial();
        if (r8 == null) goto L28;
        OMaterialHelper.setCommonGradientBlur(r7, buildScanIndicatorMaterial(true, toMaterialBlurDirection(r8.getBlurDirection())));
    L28:
        this.externalLayerBindings.add(new ExternalViewLayerBinding(r6.getBindingKey(), r7, new ODimPointGenerateEffectView$bindExternalLayers$3$2(this, r6), 0, 0.0f, 24, null));
        TextEffectDebugLog r9 = TextEffectDebugLog.INSTANCE;
        if (TextEffectDebugLog.getEnabled() == false) goto L20;
        Log.d(Intrinsics.stringPlus("OUITextEffects/", Tag), "bind external layer id=" + r6.getId() + ", bindingKey=" + r6.getBindingKey());
        goto L20
    }

    private final View viewForBindingKey(String r2) {
        if (Intrinsics.areEqual(r2, ExitScanIndicatorBindingKey) == false) goto L6;
        return this.exitScanIndicator;
    L6:
        if (Intrinsics.areEqual(r2, EnterScanIndicatorBindingKey) == true) goto L11;
        return null;
    L11:
        return this.enterScanIndicator;
    }

    private final float textWidthForBindingKey(String r3) {
        CharSequence r1 = null;
        if (Intrinsics.areEqual(r3, ExitScanIndicatorBindingKey) == false) goto L8;
        Object r4 = this.exitScanIndicator.getTag();
        if ((r4 instanceof CharSequence) == false) goto L12;
        r1 = (CharSequence) r4;
    L12:
        if (r1 != null) goto L14;
        r1 = this.effectTextView.getText();
    L14:
        if (r1 != null) goto L17;
    L17:
        return RangesKt.coerceAtLeast(computeDisplayTextWidthPx(r1), 1.0f);
    L8:
        if (Intrinsics.areEqual(r3, EnterScanIndicatorBindingKey) == false) goto L12;
        Object r5 = this.enterScanIndicator.getTag();
        if ((r5 instanceof CharSequence) == false) goto L12;
        r1 = (CharSequence) r5;
        goto L12
    }

    private final int toMaterialBlurDirection(Direction r3) {
        int r2 = WhenMappings.$EnumSwitchMapping$0[r3.ordinal()];
        if (r2 != 1) goto L5;
        return 4;
    L5:
        if (r2 == 2) goto L12;
        if (r2 == 3) goto L12;
        if (r2 == 4) goto L12;
        throw new NoWhenBranchMatchedException();
    L12:
        return 3;
    }

    private final View createScanIndicator(boolean r1) {
        View r2 = new View(getContext());
        r2.setAlpha(1.0f);
        r2.setVisibility(4);
        return r2;
    }

    private final FrameLayout.LayoutParams buildScanIndicatorLayoutParams() {
        return new FrameLayout.LayoutParams(this.dp.invoke(Float.valueOf(16.0f)).intValue(), computeScanIndicatorHeightPx(), 19);
    }

    private final void updateScanIndicatorSize(View r7, CharSequence r8, TextEffectSpec r9, String r10) {
        r7.setTag(r8);
        Float r0 = scanIndicatorFromRatio(r9, r10);
        if (r0 != null) goto L8;
        TextEffectDebugLog r6 = TextEffectDebugLog.INSTANCE;
        if (TextEffectDebugLog.getEnabled() == false) goto L24;
        Log.d(Intrinsics.stringPlus("OUITextEffects/", Tag), "skip indicator size update, missing fromRatio bindingKey=" + r10 + ", spec=" + r9.getId());
        return;
    L24:
        return;
    L8:
        float r11 = r0.floatValue();
        int r1 = computeScanIndicatorWidthPx(r8, r11);
        int r12 = computeScanIndicatorHeightPx();
        ViewGroup.LayoutParams r3 = r7.getLayoutParams();
        if ((r3 instanceof FrameLayout.LayoutParams) == false) goto L11;
        FrameLayout.LayoutParams r4 = (FrameLayout.LayoutParams) r3;
    L13:
        if (r4 != null) goto L16;
        r7.setLayoutParams(new FrameLayout.LayoutParams(r1, r12, 19));
    L20:
        r7.measure(View.MeasureSpec.makeMeasureSpec(r1, 1073741824), View.MeasureSpec.makeMeasureSpec(r12, 1073741824));
        TextEffectDebugLog r13 = TextEffectDebugLog.INSTANCE;
        if (TextEffectDebugLog.getEnabled() == false) goto L25;
        Log.d(Intrinsics.stringPlus("OUITextEffects/", Tag), "update indicator size bindingKey=" + r10 + ", fromRatio=" + r11 + ", text=" + r8 + ", width=" + r1 + ", height=" + r12);
        return;
    L25:
        return;
    L16:
        if (r4.width == r1) goto L18;
    L19:
        r4.width = r1;
        r4.height = r12;
        r4.gravity = 19;
        r7.setLayoutParams(r4);
        goto L20
    L18:
        if (r4.height == r12) goto L20;
    L11:
        r4 = null;
        goto L13
    }

    private final Float scanIndicatorFromRatio(TextEffectSpec r8, final String r9) {
        Iterator r10 = SequencesKt.flatMap(SequencesKt.filter(SequencesKt.filter(SequencesKt.flatMap(CollectionsKt.asSequence(r8.getStages()), AnonymousClass1.INSTANCE), ODimPointGenerateEffectView$scanIndicatorFromRatio$$inlined$filterIsInstance$1.INSTANCE), new AnonymousClass2(r9)), AnonymousClass3.INSTANCE).iterator();
    L4:
        if (r10.hasNext() == false) goto L11;
        Object r11 = r10.next();
        if (((PropertyTrack) r11).getProperty() != EffectProperty.TranslationX) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L4;
    L12:
        PropertyTrack r12 = (PropertyTrack) r11;
        if (r12 == null) goto L45;
        List<Keyframe> r13 = r12.getKeyframes();
        if (r13 == null) goto L46;
        Iterator<T> r14 = r13.iterator();
        if (r14.hasNext() == true) goto L21;
        Object r15 = null;
    L30:
        Keyframe r16 = (Keyframe) r15;
        if (r16 == null) goto L47;
        EffectValue r17 = r16.getValue();
        if (r17 != null) goto L37;
        return null;
    L37:
        return textWidthRatioOrNull(r17);
    L47:
        return null;
    L21:
        r15 = r14.next();
        if (r14.hasNext() == false) goto L30;
        long r2 = ((Keyframe) r15).getTimeMs();
    L25:
        Object r3 = r14.next();
        long r4 = ((Keyframe) r3).getTimeMs();
        if (r2 <= r4) goto L29;
        r15 = r3;
        r2 = r4;
    L29:
        if (r14.hasNext() == true) goto L25;
    L46:
        return null;
    L45:
        return null;
    L8:
        r1 = false;
        goto L9
    L11:
        r11 = null;
        goto L12
    }

    private final Float textWidthRatioOrNull(EffectValue r2) {
        if ((r2 instanceof EffectValue.TextWidthRatio) == false) goto L6;
        return Float.valueOf(((EffectValue.TextWidthRatio) r2).getRatio());
    L6:
        if ((r2 instanceof EffectValue.InterpolatedDimension) == true) goto L11;
        return null;
    L11:
        return textWidthRatioOrNull(((EffectValue.InterpolatedDimension) r2).getFrom());
    }

    private final int computeScanIndicatorWidthPx(CharSequence r1, float r2) {
        return RangesKt.coerceAtLeast(MathKt.roundToInt((float) Math.ceil(computeDisplayTextWidthPx(r1) * Math.abs(r2))), 1);
    }

    private final float computeDisplayTextWidthPx(CharSequence r4) {
        float r0 = RangesKt.coerceAtLeast((this.effectTextView.getWidth() - this.effectTextView.getCompoundPaddingLeft()) - this.effectTextView.getCompoundPaddingRight(), 0.0f);
        if (this.effectTextView.getEllipsize() == null) goto L8;
        if (r0 <= 0.0f) goto L8;
        r4 = TextUtils.ellipsize(r4, this.effectTextView.getPaint(), r0, this.effectTextView.getEllipsize());
    L8:
        return this.effectTextView.getPaint().measureText(r4, 0, r4.length());
    }

    private final int computeScanIndicatorHeightPx() {
        Paint.FontMetrics r0 = this.effectTextView.getPaint().getFontMetrics();
        return RangesKt.coerceAtLeast(MathKt.roundToInt((float) Math.ceil((r0.descent - r0.ascent) + (this.dp.invoke(Float.valueOf(16.0f)).floatValue() * 2.0f))), 1);
    }

    private final long scaledDurationMs(long r1) {
        return RangesKt.coerceAtLeast(MathKt.roundToInt(r1 * this.debugAnimationDurationScale), 1);
    }

    private final MaterialConfig buildScanIndicatorMaterial(boolean r23, int r24) {
        BlendConfig[] r3 = OMaterialHelper.getBlendConfigArray(getResources(), R.array.oui_no_gradient_blur_colors, R.array.oui_no_gradient_blur_blend_modes);
        if (r23 == true) goto L5;
        float r0 = BlurToken.Blur_Progress_Thin;
    L7:
        return new MaterialConfig(null, null, r3, null, null, null, new BlurConfig(r0, r24, 0.0f, 3, 0.0f, 20, null), null, null, null, 955, null);
    L5:
        r0 = 16.0f;
        goto L7
    }
}
