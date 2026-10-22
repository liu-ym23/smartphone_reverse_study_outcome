package com.obric.oui.texteffects.runtime;

import android.util.Log;
import android.view.View;
import com.obric.oui.texteffects.TextEffectDebugLog;
import com.obric.oui.texteffects.core.EffectValue;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ExternalViewLayerBinding.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fJ\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\bJ\b\u0010\u0017\u001a\u00020\bH\u0002J\u0006\u0010\u0018\u001a\u00020\u0013J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\bH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/obric/oui/texteffects/runtime/ExternalViewLayerBinding;", "", "bindingKey", "", "view", "Landroid/view/View;", "textWidthProvider", "Lkotlin/Function0;", "", "inactiveVisibility", "", "fallbackLayerWidthDp", "(Ljava/lang/String;Landroid/view/View;Lkotlin/jvm/functions/Function0;IF)V", "getBindingKey", "()Ljava/lang/String;", "density", "getView", "()Landroid/view/View;", "apply", "", "frame", "Lcom/obric/oui/texteffects/runtime/LayerFrame;", "parentWidthPx", "getLayerWidthPx", "reset", "resolveDimension", "value", "Lcom/obric/oui/texteffects/core/EffectValue;", "Companion", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ExternalViewLayerBinding {
    private static final Companion Companion = null;

    @Deprecated
    private static final String Tag = "ExternalBinding";
    private final String bindingKey;
    private final float density;
    private final float fallbackLayerWidthDp;
    private final int inactiveVisibility;
    private final Function0<Float> textWidthProvider;
    private final View view;

    /* JADX INFO: compiled from: ExternalViewLayerBinding.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/texteffects/runtime/ExternalViewLayerBinding$Companion;", "", "()V", "Tag", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ExternalViewLayerBinding(String r2, View r3, Function0<Float> r4, int r5, float r6) {
        Intrinsics.checkNotNullParameter(r2, "bindingKey");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "textWidthProvider");
        this.bindingKey = r2;
        this.view = r3;
        this.textWidthProvider = r4;
        this.inactiveVisibility = r5;
        this.fallbackLayerWidthDp = r6;
        this.density = r3.getResources().getDisplayMetrics().density;
    }

    public final String getBindingKey() {
        return this.bindingKey;
    }

    public final View getView() {
        return this.view;
    }

    public /* synthetic */ ExternalViewLayerBinding(String r7, final View r8, Function0 r9, int r10, float r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 4) == 0) goto L5;
        r9 = new AnonymousClass1(r8);
    L5:
        Function0 r3 = r9;
        if ((r12 & 8) == 0) goto L8;
        r10 = 4;
    L8:
        int r4 = r10;
        if ((r12 & 16) == 0) goto L11;
        r11 = 248.0f;
    L11:
        this(r7, r8, r3, r4, r11);
    }

    public final void reset() {
        this.view.setVisibility(this.inactiveVisibility);
        View r2 = this.view;
        r2.setTranslationX(-r2.getMeasuredWidth());
    }

    public final void apply(LayerFrame r4, float r5) {
        Intrinsics.checkNotNullParameter(r4, "frame");
        EffectValue r0 = r4.getTranslationX();
        if (r0 == null) goto L6;
        getView().setTranslationX(resolveDimension(r0, r5));
    L6:
        EffectValue r1 = r4.getTranslationY();
        if (r1 == null) goto L11;
        getView().setTranslationY(resolveDimension(r1, r5));
    L11:
        if (Float.isNaN(r4.getAlpha()) == true) goto L13;
        this.view.setAlpha(RangesKt.coerceIn(r4.getAlpha(), 0.0f, 1.0f));
    L13:
        View r6 = this.view;
        Float r7 = r4.visibilityOrNull();
        int r2 = 0;
        if (r7 != null) goto L17;
    L20:
        r6.setVisibility(r2);
        TextEffectDebugLog r8 = TextEffectDebugLog.INSTANCE;
        if (TextEffectDebugLog.getEnabled() == true) goto L23;
        return;
    L23:
        if (TextEffectDebugLog.getFrameEnabled() == false) goto L27;
        Log.d(Intrinsics.stringPlus("OUITextEffects/", Tag), "apply binding=" + getBindingKey() + ", alpha=" + getView().getAlpha() + ", visibility=" + getView().getVisibility() + ", translationX=" + getView().getTranslationX() + ", translationY=" + getView().getTranslationY());
        return;
    L27:
        return;
    L17:
        if (r7.floatValue() > 0.001f) goto L20;
        r2 = this.inactiveVisibility;
        goto L20
    }

    private final float resolveDimension(EffectValue r4, float r5) {
        if ((r4 instanceof EffectValue.FloatValue) == false) goto L6;
        return ((EffectValue.FloatValue) r4).getValue();
    L6:
        if ((r4 instanceof EffectValue.DimensionDp) == false) goto L9;
        float r6 = ((EffectValue.DimensionDp) r4).getValue();
        return this.density * r6;
    L9:
        if ((r4 instanceof EffectValue.ParentWidth) == false) goto L13;
        float r7 = ((EffectValue.ParentWidth) r4).getExtraDp();
        float r3 = this.density;
    L26:
        return r5 + (r7 * r3);
    L13:
        if ((r4 instanceof EffectValue.LayerWidth) == false) goto L16;
        r5 = -getLayerWidthPx();
        r7 = ((EffectValue.LayerWidth) r4).getExtraDp();
        r3 = this.density;
        goto L26
    L16:
        if ((r4 instanceof EffectValue.TextWidthRatio) == false) goto L19;
        return RangesKt.coerceAtLeast(this.textWidthProvider.invoke().floatValue(), 0.0f) * ((EffectValue.TextWidthRatio) r4).getRatio();
    L19:
        if ((r4 instanceof EffectValue.InterpolatedDimension) == false) goto L23;
        EffectValue.InterpolatedDimension r8 = (EffectValue.InterpolatedDimension) r4;
        float r0 = resolveDimension(r8.getFrom(), r5);
        return ((resolveDimension(r8.getTo(), r5) - r0) * RangesKt.coerceIn(r8.getProgress(), 0.0f, 1.0f)) + r0;
    L23:
        throw new NoWhenBranchMatchedException();
    }

    private final float getLayerWidthPx() {
        Integer r0 = Integer.valueOf(this.view.getMeasuredWidth());
        int r1 = r0.intValue();
        Integer r2 = Integer.valueOf(getView().getWidth());
        boolean r4 = true;
        if (r2.intValue() <= 0) goto L5;
        boolean r3 = true;
    L7:
        if (r3 == true) goto L10;
        r2 = null;
    L10:
        if (r2 != null) goto L12;
        int r5 = 0;
    L13:
        if (r1 > r5) goto L16;
        r4 = false;
    L16:
        if (r4 == true) goto L19;
        r0 = null;
    L19:
        if (r0 != null) goto L21;
        int r6 = this.view.getWidth();
    L22:
        if (r6 <= 0) goto L25;
        return r6;
    L25:
        return this.view.getResources().getDisplayMetrics().density * this.fallbackLayerWidthDp;
    L21:
        r6 = r0.intValue();
        goto L22
    L12:
        r5 = r2.intValue();
        goto L13
    L5:
        r3 = false;
        goto L7
    }
}
