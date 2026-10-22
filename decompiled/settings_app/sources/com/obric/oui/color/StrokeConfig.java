package com.obric.oui.color;

import android.icu.text.PluralRules;
import com.obric.oui.graphic.BlendMode;
import com.obric.oui.material.MaterialConfigFormatNames;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StrokeConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J\u0006\u0010\u0012\u001a\u00020\u0000J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0006\u0010\u0013\u001a\u00020\u0000J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\r\u0010\u0018\u001a\u00020\u0019H\u0000¢\u0006\u0002\b\u001aJ\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/obric/oui/color/StrokeConfig;", "", MaterialConfigFormatNames.WIDTH, "", "color", "", "blendMode", "Lcom/obric/oui/graphic/BlendMode;", "(FILcom/obric/oui/graphic/BlendMode;)V", "getBlendMode", "()Lcom/obric/oui/graphic/BlendMode;", "getColor", "()I", "getWidth", "()F", "component1", "component2", "component3", "copy", "deepCopy", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "toCore", "Lcom/obric/oui/color/StrokeConfigCore;", "toCore$OUI_standardRelease", "toString", "", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StrokeConfig {
    public static final Companion Companion = null;
    private final BlendMode blendMode;
    private final int color;
    private final float width;

    /* JADX INFO: compiled from: StrokeConfig.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/obric/oui/color/StrokeConfig$Companion;", "", "()V", "lerp", "Lcom/obric/oui/color/StrokeConfig;", "from", "to", "progress", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final StrokeConfig lerp(StrokeConfig r2, StrokeConfig r3, float r4) {
            if (r2 != null) goto L5;
            StrokeConfigCore r5 = null;
        L6:
            if (r3 != null) goto L8;
            StrokeConfigCore r6 = null;
        L9:
            StrokeConfigCore r7 = StrokeConfigCore.lerp(r5, r6, r4);
            if (r7 != null) goto L12;
            return null;
        L12:
            float r8 = r7.getWidth();
            int r9 = r7.getColor();
            BlendMode r10 = r7.getBlendMode();
            Intrinsics.checkNotNullExpressionValue(r10, "result.blendMode");
            return new StrokeConfig(r8, r9, r10);
        L8:
            r6 = r3.toCore$OUI_standardRelease();
            goto L9
        L5:
            r5 = r2.toCore$OUI_standardRelease();
            goto L6
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ StrokeConfig copy$default(StrokeConfig r0, float r1, int r2, BlendMode r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.width;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.color;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.blendMode;
    L12:
        return r0.copy(r1, r2, r3);
    }

    @JvmStatic
    public static final StrokeConfig lerp(StrokeConfig r1, StrokeConfig r2, float r3) {
        return Companion.lerp(r1, r2, r3);
    }

    public final float component1() {
        return this.width;
    }

    public final int component2() {
        return this.color;
    }

    public final BlendMode component3() {
        return this.blendMode;
    }

    public final StrokeConfig copy(float r1, int r2, BlendMode r3) {
        Intrinsics.checkNotNullParameter(r3, "blendMode");
        return new StrokeConfig(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof StrokeConfig) == true) goto L8;
        return false;
    L8:
        StrokeConfig r6 = (StrokeConfig) r5;
        if (Intrinsics.areEqual(Float.valueOf(this.width), Float.valueOf(r6.width)) == true) goto L12;
        return false;
    L12:
        if (this.color == r6.color) goto L15;
        return false;
    L15:
        if (this.blendMode == r6.blendMode) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Float.hashCode(this.width) * 31) + Integer.hashCode(this.color)) * 31) + this.blendMode.hashCode();
    }

    public String toString() {
        return "StrokeConfig(width=" + this.width + ", color=" + this.color + ", blendMode=" + this.blendMode + ')';
    }

    public StrokeConfig(float r2, int r3, BlendMode r4) {
        Intrinsics.checkNotNullParameter(r4, "blendMode");
        this.width = r2;
        this.color = r3;
        this.blendMode = r4;
    }

    public final float getWidth() {
        return this.width;
    }

    public final int getColor() {
        return this.color;
    }

    public /* synthetic */ StrokeConfig(float r1, int r2, BlendMode r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = BlendMode.SRC_OVER;
    L5:
        this(r1, r2, r3);
    }

    public final BlendMode getBlendMode() {
        return this.blendMode;
    }

    public final StrokeConfigCore toCore$OUI_standardRelease() {
        return new StrokeConfigCore(this.width, this.color, this.blendMode);
    }

    public final StrokeConfig deepCopy() {
        StrokeConfigCore r4 = StrokeConfigCore.deepCopy(toCore$OUI_standardRelease());
        float r1 = r4.getWidth();
        int r2 = r4.getColor();
        BlendMode r5 = r4.getBlendMode();
        Intrinsics.checkNotNullExpressionValue(r5, "result.blendMode");
        return new StrokeConfig(r1, r2, r5);
    }

    public final StrokeConfig copy() {
        return deepCopy();
    }
}
