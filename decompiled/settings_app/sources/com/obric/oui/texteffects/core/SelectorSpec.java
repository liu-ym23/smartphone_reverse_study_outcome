package com.obric.oui.texteffects.core;

import android.icu.text.PluralRules;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.obric.oui.material.MaterialConfigFormatNames;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextEffectProtocol.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/obric/oui/texteffects/core/SelectorSpec;", "", "()V", "All", "ScanWindow", "XPositionRamp", "Lcom/obric/oui/texteffects/core/SelectorSpec$All;", "Lcom/obric/oui/texteffects/core/SelectorSpec$XPositionRamp;", "Lcom/obric/oui/texteffects/core/SelectorSpec$ScanWindow;", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class SelectorSpec {

    /* JADX INFO: compiled from: TextEffectProtocol.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/oui/texteffects/core/SelectorSpec$All;", "Lcom/obric/oui/texteffects/core/SelectorSpec;", "()V", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class All extends SelectorSpec {
        public static final All INSTANCE = null;

        static {
            INSTANCE = new All();
        }

        private All() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: TextEffectProtocol.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/obric/oui/texteffects/core/SelectorSpec$ScanWindow;", "Lcom/obric/oui/texteffects/core/SelectorSpec;", MaterialConfigFormatNames.DIRECTION, "Lcom/obric/oui/texteffects/core/Direction;", "gradientAlphaDirection", "featherRatio", "", "minFeatherDp", "(Lcom/obric/oui/texteffects/core/Direction;Lcom/obric/oui/texteffects/core/Direction;FF)V", "getDirection", "()Lcom/obric/oui/texteffects/core/Direction;", "getFeatherRatio", "()F", "getGradientAlphaDirection", "getMinFeatherDp", "component1", "component2", "component3", "component4", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "", "hashCode", "", "toString", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ScanWindow extends SelectorSpec {
        private final Direction direction;
        private final float featherRatio;
        private final Direction gradientAlphaDirection;
        private final float minFeatherDp;

        public static /* synthetic */ ScanWindow copy$default(ScanWindow r0, Direction r1, Direction r2, float r3, float r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.direction;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.gradientAlphaDirection;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.featherRatio;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.minFeatherDp;
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final Direction component1() {
            return this.direction;
        }

        public final Direction component2() {
            return this.gradientAlphaDirection;
        }

        public final float component3() {
            return this.featherRatio;
        }

        public final float component4() {
            return this.minFeatherDp;
        }

        public final ScanWindow copy(Direction r1, Direction r2, float r3, float r4) {
            Intrinsics.checkNotNullParameter(r1, MaterialConfigFormatNames.DIRECTION);
            Intrinsics.checkNotNullParameter(r2, "gradientAlphaDirection");
            return new ScanWindow(r1, r2, r3, r4);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof ScanWindow) == true) goto L8;
            return false;
        L8:
            ScanWindow r6 = (ScanWindow) r5;
            if (this.direction == r6.direction) goto L12;
            return false;
        L12:
            if (this.gradientAlphaDirection == r6.gradientAlphaDirection) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(Float.valueOf(this.featherRatio), Float.valueOf(r6.featherRatio)) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(Float.valueOf(this.minFeatherDp), Float.valueOf(r6.minFeatherDp)) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.direction.hashCode() * 31) + this.gradientAlphaDirection.hashCode()) * 31) + Float.hashCode(this.featherRatio)) * 31) + Float.hashCode(this.minFeatherDp);
        }

        public String toString() {
            return "ScanWindow(direction=" + this.direction + ", gradientAlphaDirection=" + this.gradientAlphaDirection + ", featherRatio=" + this.featherRatio + ", minFeatherDp=" + this.minFeatherDp + ')';
        }

        public /* synthetic */ ScanWindow(Direction r1, Direction r2, float r3, float r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 2) == 0) goto L5;
            r2 = r1;
        L5:
            this(r1, r2, r3, r4);
        }

        public final Direction getDirection() {
            return this.direction;
        }

        public final Direction getGradientAlphaDirection() {
            return this.gradientAlphaDirection;
        }

        public final float getFeatherRatio() {
            return this.featherRatio;
        }

        public final float getMinFeatherDp() {
            return this.minFeatherDp;
        }

        public ScanWindow(Direction r2, Direction r3, float r4, float r5) {
            Intrinsics.checkNotNullParameter(r2, MaterialConfigFormatNames.DIRECTION);
            Intrinsics.checkNotNullParameter(r3, "gradientAlphaDirection");
            super(null);
            this.direction = r2;
            this.gradientAlphaDirection = r3;
            this.featherRatio = r4;
            this.minFeatherDp = r5;
        }
    }

    /* JADX INFO: compiled from: TextEffectProtocol.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/obric/oui/texteffects/core/SelectorSpec$XPositionRamp;", "Lcom/obric/oui/texteffects/core/SelectorSpec;", "start", "", TraceStatsConsts.STATS_KEY_END, MaterialConfigFormatNames.DIRECTION, "Lcom/obric/oui/texteffects/core/Direction;", "(FFLcom/obric/oui/texteffects/core/Direction;)V", "getDirection", "()Lcom/obric/oui/texteffects/core/Direction;", "getEnd", "()F", "getStart", "component1", "component2", "component3", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "", "hashCode", "", "toString", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class XPositionRamp extends SelectorSpec {
        private final Direction direction;
        private final float end;
        private final float start;

        public static /* synthetic */ XPositionRamp copy$default(XPositionRamp r0, float r1, float r2, Direction r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.start;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.end;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.direction;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final float component1() {
            return this.start;
        }

        public final float component2() {
            return this.end;
        }

        public final Direction component3() {
            return this.direction;
        }

        public final XPositionRamp copy(float r1, float r2, Direction r3) {
            Intrinsics.checkNotNullParameter(r3, MaterialConfigFormatNames.DIRECTION);
            return new XPositionRamp(r1, r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof XPositionRamp) == true) goto L8;
            return false;
        L8:
            XPositionRamp r6 = (XPositionRamp) r5;
            if (Intrinsics.areEqual(Float.valueOf(this.start), Float.valueOf(r6.start)) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(Float.valueOf(this.end), Float.valueOf(r6.end)) == true) goto L15;
            return false;
        L15:
            if (this.direction == r6.direction) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Float.hashCode(this.start) * 31) + Float.hashCode(this.end)) * 31) + this.direction.hashCode();
        }

        public String toString() {
            return "XPositionRamp(start=" + this.start + ", end=" + this.end + ", direction=" + this.direction + ')';
        }

        public final float getStart() {
            return this.start;
        }

        public final float getEnd() {
            return this.end;
        }

        public final Direction getDirection() {
            return this.direction;
        }

        public XPositionRamp(float r2, float r3, Direction r4) {
            Intrinsics.checkNotNullParameter(r4, MaterialConfigFormatNames.DIRECTION);
            super(null);
            this.start = r2;
            this.end = r3;
            this.direction = r4;
        }
    }

    public /* synthetic */ SelectorSpec(DefaultConstructorMarker r1) {
        this();
    }

    private SelectorSpec() {
    }
}
