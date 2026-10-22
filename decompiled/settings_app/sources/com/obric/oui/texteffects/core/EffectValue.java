package com.obric.oui.texteffects.core;

import android.icu.text.PluralRules;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextEffectProtocol.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0006\t\n\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/obric/oui/texteffects/core/EffectValue;", "", "()V", "DimensionDp", "FloatValue", "InterpolatedDimension", "LayerWidth", "ParentWidth", "TextWidthRatio", "Lcom/obric/oui/texteffects/core/EffectValue$FloatValue;", "Lcom/obric/oui/texteffects/core/EffectValue$DimensionDp;", "Lcom/obric/oui/texteffects/core/EffectValue$ParentWidth;", "Lcom/obric/oui/texteffects/core/EffectValue$LayerWidth;", "Lcom/obric/oui/texteffects/core/EffectValue$TextWidthRatio;", "Lcom/obric/oui/texteffects/core/EffectValue$InterpolatedDimension;", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class EffectValue {

    /* JADX INFO: compiled from: TextEffectProtocol.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/texteffects/core/EffectValue$DimensionDp;", "Lcom/obric/oui/texteffects/core/EffectValue;", "value", "", "(F)V", "getValue", "()F", "component1", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "", "hashCode", "", "toString", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DimensionDp extends EffectValue {
        private final float value;

        public static /* synthetic */ DimensionDp copy$default(DimensionDp r0, float r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.value;
        L6:
            return r0.copy(r1);
        }

        public final float component1() {
            return this.value;
        }

        public final DimensionDp copy(float r1) {
            return new DimensionDp(r1);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof DimensionDp) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(Float.valueOf(this.value), Float.valueOf(((DimensionDp) r4).value)) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Float.hashCode(this.value);
        }

        public String toString() {
            return "DimensionDp(value=" + this.value + ')';
        }

        public DimensionDp(float r2) {
            super(null);
            this.value = r2;
        }

        public final float getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: TextEffectProtocol.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/texteffects/core/EffectValue$FloatValue;", "Lcom/obric/oui/texteffects/core/EffectValue;", "value", "", "(F)V", "getValue", "()F", "component1", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "", "hashCode", "", "toString", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FloatValue extends EffectValue {
        private final float value;

        public static /* synthetic */ FloatValue copy$default(FloatValue r0, float r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.value;
        L6:
            return r0.copy(r1);
        }

        public final float component1() {
            return this.value;
        }

        public final FloatValue copy(float r1) {
            return new FloatValue(r1);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof FloatValue) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(Float.valueOf(this.value), Float.valueOf(((FloatValue) r4).value)) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Float.hashCode(this.value);
        }

        public String toString() {
            return "FloatValue(value=" + this.value + ')';
        }

        public FloatValue(float r2) {
            super(null);
            this.value = r2;
        }

        public final float getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: TextEffectProtocol.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0001HÆ\u0003J\t\u0010\r\u001a\u00020\u0001HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/obric/oui/texteffects/core/EffectValue$InterpolatedDimension;", "Lcom/obric/oui/texteffects/core/EffectValue;", "from", "to", "progress", "", "(Lcom/obric/oui/texteffects/core/EffectValue;Lcom/obric/oui/texteffects/core/EffectValue;F)V", "getFrom", "()Lcom/obric/oui/texteffects/core/EffectValue;", "getProgress", "()F", "getTo", "component1", "component2", "component3", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "", "hashCode", "", "toString", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class InterpolatedDimension extends EffectValue {
        private final EffectValue from;
        private final float progress;
        private final EffectValue to;

        public static /* synthetic */ InterpolatedDimension copy$default(InterpolatedDimension r0, EffectValue r1, EffectValue r2, float r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.from;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.to;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.progress;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final EffectValue component1() {
            return this.from;
        }

        public final EffectValue component2() {
            return this.to;
        }

        public final float component3() {
            return this.progress;
        }

        public final InterpolatedDimension copy(EffectValue r1, EffectValue r2, float r3) {
            Intrinsics.checkNotNullParameter(r1, "from");
            Intrinsics.checkNotNullParameter(r2, "to");
            return new InterpolatedDimension(r1, r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof InterpolatedDimension) == true) goto L8;
            return false;
        L8:
            InterpolatedDimension r6 = (InterpolatedDimension) r5;
            if (Intrinsics.areEqual(this.from, r6.from) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.to, r6.to) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(Float.valueOf(this.progress), Float.valueOf(r6.progress)) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.from.hashCode() * 31) + this.to.hashCode()) * 31) + Float.hashCode(this.progress);
        }

        public String toString() {
            return "InterpolatedDimension(from=" + this.from + ", to=" + this.to + ", progress=" + this.progress + ')';
        }

        public final EffectValue getFrom() {
            return this.from;
        }

        public final EffectValue getTo() {
            return this.to;
        }

        public final float getProgress() {
            return this.progress;
        }

        public InterpolatedDimension(EffectValue r2, EffectValue r3, float r4) {
            Intrinsics.checkNotNullParameter(r2, "from");
            Intrinsics.checkNotNullParameter(r3, "to");
            super(null);
            this.from = r2;
            this.to = r3;
            this.progress = r4;
        }
    }

    /* JADX INFO: compiled from: TextEffectProtocol.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/texteffects/core/EffectValue$LayerWidth;", "Lcom/obric/oui/texteffects/core/EffectValue;", "extraDp", "", "(F)V", "getExtraDp", "()F", "component1", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "", "hashCode", "", "toString", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class LayerWidth extends EffectValue {
        private final float extraDp;

        public LayerWidth() {
            float r2 = 0.0f;
            this(r2, 1, null);
        }

        public static /* synthetic */ LayerWidth copy$default(LayerWidth r0, float r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.extraDp;
        L6:
            return r0.copy(r1);
        }

        public final float component1() {
            return this.extraDp;
        }

        public final LayerWidth copy(float r1) {
            return new LayerWidth(r1);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof LayerWidth) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(Float.valueOf(this.extraDp), Float.valueOf(((LayerWidth) r4).extraDp)) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Float.hashCode(this.extraDp);
        }

        public String toString() {
            return "LayerWidth(extraDp=" + this.extraDp + ')';
        }

        public LayerWidth(float r2) {
            super(null);
            this.extraDp = r2;
        }

        public /* synthetic */ LayerWidth(float r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = 0.0f;
        L5:
            this(r1);
        }

        public final float getExtraDp() {
            return this.extraDp;
        }
    }

    /* JADX INFO: compiled from: TextEffectProtocol.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/texteffects/core/EffectValue$ParentWidth;", "Lcom/obric/oui/texteffects/core/EffectValue;", "extraDp", "", "(F)V", "getExtraDp", "()F", "component1", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "", "hashCode", "", "toString", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ParentWidth extends EffectValue {
        private final float extraDp;

        public ParentWidth() {
            float r2 = 0.0f;
            this(r2, 1, null);
        }

        public static /* synthetic */ ParentWidth copy$default(ParentWidth r0, float r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.extraDp;
        L6:
            return r0.copy(r1);
        }

        public final float component1() {
            return this.extraDp;
        }

        public final ParentWidth copy(float r1) {
            return new ParentWidth(r1);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof ParentWidth) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(Float.valueOf(this.extraDp), Float.valueOf(((ParentWidth) r4).extraDp)) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Float.hashCode(this.extraDp);
        }

        public String toString() {
            return "ParentWidth(extraDp=" + this.extraDp + ')';
        }

        public ParentWidth(float r2) {
            super(null);
            this.extraDp = r2;
        }

        public /* synthetic */ ParentWidth(float r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = 0.0f;
        L5:
            this(r1);
        }

        public final float getExtraDp() {
            return this.extraDp;
        }
    }

    /* JADX INFO: compiled from: TextEffectProtocol.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/texteffects/core/EffectValue$TextWidthRatio;", "Lcom/obric/oui/texteffects/core/EffectValue;", "ratio", "", "(F)V", "getRatio", "()F", "component1", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "", "hashCode", "", "toString", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class TextWidthRatio extends EffectValue {
        private final float ratio;

        public static /* synthetic */ TextWidthRatio copy$default(TextWidthRatio r0, float r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.ratio;
        L6:
            return r0.copy(r1);
        }

        public final float component1() {
            return this.ratio;
        }

        public final TextWidthRatio copy(float r1) {
            return new TextWidthRatio(r1);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof TextWidthRatio) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(Float.valueOf(this.ratio), Float.valueOf(((TextWidthRatio) r4).ratio)) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Float.hashCode(this.ratio);
        }

        public String toString() {
            return "TextWidthRatio(ratio=" + this.ratio + ')';
        }

        public TextWidthRatio(float r2) {
            super(null);
            this.ratio = r2;
        }

        public final float getRatio() {
            return this.ratio;
        }
    }

    public /* synthetic */ EffectValue(DefaultConstructorMarker r1) {
        this();
    }

    private EffectValue() {
    }
}
