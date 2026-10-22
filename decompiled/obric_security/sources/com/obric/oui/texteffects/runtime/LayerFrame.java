package com.obric.oui.texteffects.runtime;

import com.obric.oui.texteffects.core.EffectProperty;
import com.obric.oui.texteffects.core.EffectValue;
import com.obric.oui.texteffects.core.SelectorSpec;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextEffectFrame.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u009f\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0011\u0012\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00110\u0015¢\u0006\u0002\u0010\u0017J\u000e\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\tJ\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\tHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0015\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00110\u0015HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0007HÆ\u0003J\t\u00107\u001a\u00020\tHÆ\u0003J\t\u00108\u001a\u00020\tHÆ\u0003J\t\u00109\u001a\u00020\tHÆ\u0003J\t\u0010:\u001a\u00020\tHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u000eHÆ\u0003J«\u0001\u0010<\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00110\u0015HÆ\u0001J\u0013\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000e\u0010@\u001a\u00020\t2\u0006\u0010-\u001a\u00020\tJ\t\u0010A\u001a\u00020BHÖ\u0001J\r\u0010C\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010DJ\t\u0010E\u001a\u00020\u0003HÖ\u0001J\u000e\u0010F\u001a\u00020\t2\u0006\u0010-\u001a\u00020\tJ\r\u0010G\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010DR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u001d\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00110\u0015¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0019R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001dR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001dR\u0011\u0010\u000f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0019¨\u0006H"}, d2 = {"Lcom/obric/oui/texteffects/runtime/LayerFrame;", "", "stageId", "", "layerId", "bindingKey", "stagePlayTimeMs", "", "alpha", "", "gradientAlpha", "scanProgress", "tracking", "scanSelector", "Lcom/obric/oui/texteffects/core/SelectorSpec$ScanWindow;", "visibility", "blurRadius", "Lcom/obric/oui/texteffects/core/EffectValue;", "translationX", "translationY", "properties", "", "Lcom/obric/oui/texteffects/core/EffectProperty;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JFFFFLcom/obric/oui/texteffects/core/SelectorSpec$ScanWindow;FLcom/obric/oui/texteffects/core/EffectValue;Lcom/obric/oui/texteffects/core/EffectValue;Lcom/obric/oui/texteffects/core/EffectValue;Ljava/util/Map;)V", "getAlpha", "()F", "getBindingKey", "()Ljava/lang/String;", "getBlurRadius", "()Lcom/obric/oui/texteffects/core/EffectValue;", "getGradientAlpha", "getLayerId", "getProperties", "()Ljava/util/Map;", "getScanProgress", "getScanSelector", "()Lcom/obric/oui/texteffects/core/SelectorSpec$ScanWindow;", "getStageId", "getStagePlayTimeMs", "()J", "getTracking", "getTranslationX", "getTranslationY", "getVisibility", "alphaOr", "defaultValue", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "gradientAlphaOr", "hashCode", "", "scanProgressOrNull", "()Ljava/lang/Float;", "toString", "trackingOr", "visibilityOrNull", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LayerFrame {
    private final float alpha;
    private final String bindingKey;
    private final EffectValue blurRadius;
    private final float gradientAlpha;
    private final String layerId;
    private final Map<EffectProperty, EffectValue> properties;
    private final float scanProgress;
    private final SelectorSpec.ScanWindow scanSelector;
    private final String stageId;
    private final long stagePlayTimeMs;
    private final float tracking;
    private final EffectValue translationX;
    private final EffectValue translationY;
    private final float visibility;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LayerFrame copy$default(LayerFrame r16, String r17, String r18, String r19, long r20, float r22, float r23, float r24, float r25, SelectorSpec.ScanWindow r26, float r27, EffectValue r28, EffectValue r29, EffectValue r30, Map r31, int r32, Object r33) {
        if ((r32 & 1) == 0) goto L5;
        String r2 = r16.stageId;
    L7:
        if ((r32 & 2) == 0) goto L9;
        String r3 = r16.layerId;
    L11:
        if ((r32 & 4) == 0) goto L13;
        String r4 = r16.bindingKey;
    L15:
        if ((r32 & 8) == 0) goto L17;
        long r5 = r16.stagePlayTimeMs;
    L19:
        if ((r32 & 16) == 0) goto L21;
        float r7 = r16.alpha;
    L23:
        if ((r32 & 32) == 0) goto L25;
        float r8 = r16.gradientAlpha;
    L27:
        if ((r32 & 64) == 0) goto L29;
        float r9 = r16.scanProgress;
    L31:
        if ((r32 & 128) == 0) goto L33;
        float r10 = r16.tracking;
    L35:
        if ((r32 & 256) == 0) goto L37;
        SelectorSpec.ScanWindow r11 = r16.scanSelector;
    L39:
        if ((r32 & 512) == 0) goto L41;
        float r12 = r16.visibility;
    L43:
        if ((r32 & 1024) == 0) goto L45;
        EffectValue r13 = r16.blurRadius;
    L47:
        if ((r32 & 2048) == 0) goto L49;
        EffectValue r14 = r16.translationX;
    L51:
        if ((r32 & 4096) == 0) goto L53;
        EffectValue r15 = r16.translationY;
    L55:
        if ((r32 & 8192) == 0) goto L57;
        Map r1 = r16.properties;
    L59:
        return r16.copy(r2, r3, r4, r5, r7, r8, r9, r10, r11, r12, r13, r14, r15, r1);
    L57:
        r1 = r31;
        goto L59
    L53:
        r15 = r30;
        goto L55
    L49:
        r14 = r29;
        goto L51
    L45:
        r13 = r28;
        goto L47
    L41:
        r12 = r27;
        goto L43
    L37:
        r11 = r26;
        goto L39
    L33:
        r10 = r25;
        goto L35
    L29:
        r9 = r24;
        goto L31
    L25:
        r8 = r23;
        goto L27
    L21:
        r7 = r22;
        goto L23
    L17:
        r5 = r20;
        goto L19
    L13:
        r4 = r19;
        goto L15
    L9:
        r3 = r18;
        goto L11
    L5:
        r2 = r17;
        goto L7
    }

    public final String component1() {
        return this.stageId;
    }

    public final float component10() {
        return this.visibility;
    }

    public final EffectValue component11() {
        return this.blurRadius;
    }

    public final EffectValue component12() {
        return this.translationX;
    }

    public final EffectValue component13() {
        return this.translationY;
    }

    public final Map<EffectProperty, EffectValue> component14() {
        return this.properties;
    }

    public final String component2() {
        return this.layerId;
    }

    public final String component3() {
        return this.bindingKey;
    }

    public final long component4() {
        return this.stagePlayTimeMs;
    }

    public final float component5() {
        return this.alpha;
    }

    public final float component6() {
        return this.gradientAlpha;
    }

    public final float component7() {
        return this.scanProgress;
    }

    public final float component8() {
        return this.tracking;
    }

    public final SelectorSpec.ScanWindow component9() {
        return this.scanSelector;
    }

    public final LayerFrame copy(String r18, String r19, String r20, long r21, float r23, float r24, float r25, float r26, SelectorSpec.ScanWindow r27, float r28, EffectValue r29, EffectValue r30, EffectValue r31, Map<EffectProperty, ? extends EffectValue> r32) {
        Intrinsics.checkNotNullParameter(r18, "stageId");
        Intrinsics.checkNotNullParameter(r19, "layerId");
        Intrinsics.checkNotNullParameter(r32, "properties");
        return new LayerFrame(r18, r19, r20, r21, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof LayerFrame) == true) goto L8;
        return false;
    L8:
        LayerFrame r9 = (LayerFrame) r8;
        if (Intrinsics.areEqual(this.stageId, r9.stageId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.layerId, r9.layerId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.bindingKey, r9.bindingKey) == true) goto L18;
        return false;
    L18:
        if (this.stagePlayTimeMs == r9.stagePlayTimeMs) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(Float.valueOf(this.alpha), Float.valueOf(r9.alpha)) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(Float.valueOf(this.gradientAlpha), Float.valueOf(r9.gradientAlpha)) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(Float.valueOf(this.scanProgress), Float.valueOf(r9.scanProgress)) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(Float.valueOf(this.tracking), Float.valueOf(r9.tracking)) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.scanSelector, r9.scanSelector) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(Float.valueOf(this.visibility), Float.valueOf(r9.visibility)) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.blurRadius, r9.blurRadius) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.translationX, r9.translationX) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.translationY, r9.translationY) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.properties, r9.properties) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.stageId.hashCode() * 31) + this.layerId.hashCode()) * 31;
        String r1 = this.bindingKey;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((((((((r0 + r3) * 31) + Long.hashCode(this.stagePlayTimeMs)) * 31) + Float.hashCode(this.alpha)) * 31) + Float.hashCode(this.gradientAlpha)) * 31) + Float.hashCode(this.scanProgress)) * 31) + Float.hashCode(this.tracking)) * 31;
        SelectorSpec.ScanWindow r5 = this.scanSelector;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((r4 + r6) * 31) + Float.hashCode(this.visibility)) * 31;
        EffectValue r8 = this.blurRadius;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        EffectValue r11 = this.translationX;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        EffectValue r14 = this.translationY;
        if (r14 == null) goto L23;
        r2 = r14.hashCode();
    L23:
        return ((r13 + r2) * 31) + this.properties.hashCode();
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("LayerFrame(stageId=");
        r0.append(this.stageId).append(", layerId=").append(this.layerId).append(", bindingKey=").append(this.bindingKey).append(", stagePlayTimeMs=").append(this.stagePlayTimeMs).append(", alpha=").append(this.alpha).append(", gradientAlpha=").append(this.gradientAlpha).append(", scanProgress=").append(this.scanProgress).append(", tracking=").append(this.tracking).append(", scanSelector=").append(this.scanSelector).append(", visibility=").append(this.visibility).append(", blurRadius=").append(this.blurRadius).append(", translationX=");
        r0.append(this.translationX).append(", translationY=").append(this.translationY).append(", properties=").append(this.properties).append(')');
        return r0.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LayerFrame(String r6, String r7, String r8, long r9, float r11, float r12, float r13, float r14, SelectorSpec.ScanWindow r15, float r16, EffectValue r17, EffectValue r18, EffectValue r19, Map<EffectProperty, ? extends EffectValue> r20) {
        Intrinsics.checkNotNullParameter(r6, "stageId");
        Intrinsics.checkNotNullParameter(r7, "layerId");
        Intrinsics.checkNotNullParameter(r20, "properties");
        this.stageId = r6;
        this.layerId = r7;
        this.bindingKey = r8;
        this.stagePlayTimeMs = r9;
        this.alpha = r11;
        this.gradientAlpha = r12;
        this.scanProgress = r13;
        this.tracking = r14;
        this.scanSelector = r15;
        this.visibility = r16;
        this.blurRadius = r17;
        this.translationX = r18;
        this.translationY = r19;
        this.properties = r20;
    }

    public final String getStageId() {
        return this.stageId;
    }

    public final String getLayerId() {
        return this.layerId;
    }

    public final String getBindingKey() {
        return this.bindingKey;
    }

    public final long getStagePlayTimeMs() {
        return this.stagePlayTimeMs;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final float getGradientAlpha() {
        return this.gradientAlpha;
    }

    public final float getScanProgress() {
        return this.scanProgress;
    }

    public final float getTracking() {
        return this.tracking;
    }

    public final SelectorSpec.ScanWindow getScanSelector() {
        return this.scanSelector;
    }

    public final float getVisibility() {
        return this.visibility;
    }

    public final EffectValue getBlurRadius() {
        return this.blurRadius;
    }

    public final EffectValue getTranslationX() {
        return this.translationX;
    }

    public final EffectValue getTranslationY() {
        return this.translationY;
    }

    public /* synthetic */ LayerFrame(String r20, String r21, String r22, long r23, float r25, float r26, float r27, float r28, SelectorSpec.ScanWindow r29, float r30, EffectValue r31, EffectValue r32, EffectValue r33, Map r34, int r35, DefaultConstructorMarker r36) {
        if ((r35 & 16) == 0) goto L5;
        float r9 = Float.NaN;
    L7:
        if ((r35 & 32) == 0) goto L9;
        float r10 = Float.NaN;
    L11:
        if ((r35 & 64) == 0) goto L13;
        float r11 = Float.NaN;
    L15:
        if ((r35 & 128) == 0) goto L17;
        float r12 = Float.NaN;
    L19:
        if ((r35 & 256) == 0) goto L21;
        SelectorSpec.ScanWindow r13 = null;
    L23:
        if ((r35 & 512) == 0) goto L25;
        float r14 = Float.NaN;
    L27:
        if ((r35 & 1024) == 0) goto L29;
        EffectValue r15 = null;
    L31:
        if ((r35 & 2048) == 0) goto L33;
        EffectValue r16 = null;
    L35:
        if ((r35 & 4096) == 0) goto L37;
        EffectValue r17 = null;
    L39:
        if ((r35 & 8192) == 0) goto L41;
        Map r18 = MapsKt.emptyMap();
    L42:
        this(r20, r21, r22, r23, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);
        return;
    L41:
        r18 = r34;
        goto L42
    L37:
        r17 = r33;
        goto L39
    L33:
        r16 = r32;
        goto L35
    L29:
        r15 = r31;
        goto L31
    L25:
        r14 = r30;
        goto L27
    L21:
        r13 = r29;
        goto L23
    L17:
        r12 = r28;
        goto L19
    L13:
        r11 = r27;
        goto L15
    L9:
        r10 = r26;
        goto L11
    L5:
        r9 = r25;
        goto L7
    }

    public final Map<EffectProperty, EffectValue> getProperties() {
        return this.properties;
    }

    public final float alphaOr(float r2) {
        if (Float.isNaN(this.alpha) == false) goto L6;
        return r2;
    L6:
        return this.alpha;
    }

    public final float gradientAlphaOr(float r2) {
        if (Float.isNaN(this.gradientAlpha) == false) goto L6;
        return r2;
    L6:
        return this.gradientAlpha;
    }

    public final Float scanProgressOrNull() {
        if (Float.isNaN(this.scanProgress) == false) goto L6;
        return null;
    L6:
        return Float.valueOf(this.scanProgress);
    }

    public final float trackingOr(float r2) {
        if (Float.isNaN(this.tracking) == false) goto L6;
        return r2;
    L6:
        return this.tracking;
    }

    public final Float visibilityOrNull() {
        if (Float.isNaN(this.visibility) == false) goto L6;
        return null;
    L6:
        return Float.valueOf(this.visibility);
    }
}
