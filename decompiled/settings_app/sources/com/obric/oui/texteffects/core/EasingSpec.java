package com.obric.oui.texteffects.core;

import android.icu.text.PluralRules;
import com.android.settings.activate.ActivateService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextEffectProtocol.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/obric/oui/texteffects/core/EasingSpec;", "", "()V", "AeAnimator", "AeAnimatorMode", "CubicBezier", "Linear", "Lcom/obric/oui/texteffects/core/EasingSpec$Linear;", "Lcom/obric/oui/texteffects/core/EasingSpec$CubicBezier;", "Lcom/obric/oui/texteffects/core/EasingSpec$AeAnimator;", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class EasingSpec {

    /* JADX INFO: compiled from: TextEffectProtocol.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/obric/oui/texteffects/core/EasingSpec$AeAnimator;", "Lcom/obric/oui/texteffects/core/EasingSpec;", "mode", "", "easeLow", "", "easeHigh", "(IFF)V", "getEaseHigh", "()F", "getEaseLow", "getMode", "()I", "component1", "component2", "component3", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "", "hashCode", "toString", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AeAnimator extends EasingSpec {
        private final float easeHigh;
        private final float easeLow;
        private final int mode;

        public AeAnimator() {
            this(0, 0.0f, 0.0f, 7, null);
        }

        public static /* synthetic */ AeAnimator copy$default(AeAnimator r0, int r1, float r2, float r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.mode;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.easeLow;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.easeHigh;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final int component1() {
            return this.mode;
        }

        public final float component2() {
            return this.easeLow;
        }

        public final float component3() {
            return this.easeHigh;
        }

        public final AeAnimator copy(int r1, float r2, float r3) {
            return new AeAnimator(r1, r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof AeAnimator) == true) goto L8;
            return false;
        L8:
            AeAnimator r6 = (AeAnimator) r5;
            if (this.mode == r6.mode) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(Float.valueOf(this.easeLow), Float.valueOf(r6.easeLow)) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(Float.valueOf(this.easeHigh), Float.valueOf(r6.easeHigh)) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.mode) * 31) + Float.hashCode(this.easeLow)) * 31) + Float.hashCode(this.easeHigh);
        }

        public String toString() {
            return "AeAnimator(mode=" + this.mode + ", easeLow=" + this.easeLow + ", easeHigh=" + this.easeHigh + ')';
        }

        public /* synthetic */ AeAnimator(int r2, float r3, float r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 1) == 0) goto L6;
            r2 = 0;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = 0.0f;
        L9:
            if ((r5 & 4) == 0) goto L11;
            r4 = 0.0f;
        L11:
            this(r2, r3, r4);
        }

        public final int getMode() {
            return this.mode;
        }

        public final float getEaseLow() {
            return this.easeLow;
        }

        public final float getEaseHigh() {
            return this.easeHigh;
        }

        public AeAnimator(int r2, float r3, float r4) {
            super(null);
            this.mode = r2;
            this.easeLow = r3;
            this.easeHigh = r4;
        }
    }

    /* JADX INFO: compiled from: TextEffectProtocol.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/texteffects/core/EasingSpec$AeAnimatorMode;", "", "()V", "RampDown", "", "RampUp", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AeAnimatorMode {
        public static final AeAnimatorMode INSTANCE = null;
        public static final int RampDown = 1;
        public static final int RampUp = 0;

        static {
            INSTANCE = new AeAnimatorMode();
        }

        private AeAnimatorMode() {
        }
    }

    /* JADX INFO: compiled from: TextEffectProtocol.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/obric/oui/texteffects/core/EasingSpec$CubicBezier;", "Lcom/obric/oui/texteffects/core/EasingSpec;", ActivateService.ACTIVATE_SMS_TYPE, "", "y1", "x2", "y2", "(FFFF)V", "getX1", "()F", "getX2", "getY1", "getY2", "component1", "component2", "component3", "component4", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "", "hashCode", "", "toString", "", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CubicBezier extends EasingSpec {
        private final float x1;
        private final float x2;
        private final float y1;
        private final float y2;

        public static /* synthetic */ CubicBezier copy$default(CubicBezier r0, float r1, float r2, float r3, float r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.x1;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.y1;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.x2;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.y2;
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final float component1() {
            return this.x1;
        }

        public final float component2() {
            return this.y1;
        }

        public final float component3() {
            return this.x2;
        }

        public final float component4() {
            return this.y2;
        }

        public final CubicBezier copy(float r1, float r2, float r3, float r4) {
            return new CubicBezier(r1, r2, r3, r4);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof CubicBezier) == true) goto L8;
            return false;
        L8:
            CubicBezier r6 = (CubicBezier) r5;
            if (Intrinsics.areEqual(Float.valueOf(this.x1), Float.valueOf(r6.x1)) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(Float.valueOf(this.y1), Float.valueOf(r6.y1)) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(Float.valueOf(this.x2), Float.valueOf(r6.x2)) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(Float.valueOf(this.y2), Float.valueOf(r6.y2)) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((Float.hashCode(this.x1) * 31) + Float.hashCode(this.y1)) * 31) + Float.hashCode(this.x2)) * 31) + Float.hashCode(this.y2);
        }

        public String toString() {
            return "CubicBezier(x1=" + this.x1 + ", y1=" + this.y1 + ", x2=" + this.x2 + ", y2=" + this.y2 + ')';
        }

        public final float getX1() {
            return this.x1;
        }

        public final float getY1() {
            return this.y1;
        }

        public final float getX2() {
            return this.x2;
        }

        public final float getY2() {
            return this.y2;
        }

        public CubicBezier(float r2, float r3, float r4, float r5) {
            super(null);
            this.x1 = r2;
            this.y1 = r3;
            this.x2 = r4;
            this.y2 = r5;
        }
    }

    /* JADX INFO: compiled from: TextEffectProtocol.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/oui/texteffects/core/EasingSpec$Linear;", "Lcom/obric/oui/texteffects/core/EasingSpec;", "()V", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Linear extends EasingSpec {
        public static final Linear INSTANCE = null;

        static {
            INSTANCE = new Linear();
        }

        private Linear() {
            super(null);
        }
    }

    public /* synthetic */ EasingSpec(DefaultConstructorMarker r1) {
        this();
    }

    private EasingSpec() {
    }
}
