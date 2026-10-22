package com.obric.oui.blur;

import android.icu.text.PluralRules;
import com.obric.oui.material.MaterialConfigFormatNames;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BlurConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u0006\u0010\u001d\u001a\u00020\u0000J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\u001e\u001a\u00020\u0000J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\r\u0010#\u001a\u00020$H\u0000¢\u0006\u0002\b%J\t\u0010&\u001a\u00020'HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006("}, d2 = {"Lcom/obric/oui/blur/BlurConfig;", "", "blurRadius", "", MaterialConfigFormatNames.DIRECTION, "", "alpha", "curveType", "endPoint", "(FIFIF)V", "getAlpha", "()F", "setAlpha", "(F)V", "getBlurRadius", "setBlurRadius", "getCurveType", "()I", "setCurveType", "(I)V", "getDirection", "setDirection", "getEndPoint", "setEndPoint", "component1", "component2", "component3", "component4", "component5", "copy", "deepCopy", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "toCore", "Lcom/obric/oui/blur/BlurConfigCore;", "toCore$OUI_standardRelease", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BlurConfig {
    private float alpha;
    private float blurRadius;
    private int curveType;
    private int direction;
    private float endPoint;

    public BlurConfig() {
        this(0.0f, 0, 0.0f, 0, 0.0f, 31, null);
    }

    public static /* synthetic */ BlurConfig copy$default(BlurConfig r3, float r4, int r5, float r6, int r7, float r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.blurRadius;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.direction;
    L8:
        int r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.alpha;
    L11:
        float r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.curveType;
    L14:
        int r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.endPoint;
    L17:
        float r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final float component1() {
        return this.blurRadius;
    }

    public final int component2() {
        return this.direction;
    }

    public final float component3() {
        return this.alpha;
    }

    public final int component4() {
        return this.curveType;
    }

    public final float component5() {
        return this.endPoint;
    }

    public final BlurConfig copy(float r7, int r8, float r9, int r10, float r11) {
        return new BlurConfig(r7, r8, r9, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BlurConfig) == true) goto L8;
        return false;
    L8:
        BlurConfig r6 = (BlurConfig) r5;
        if (Intrinsics.areEqual(Float.valueOf(this.blurRadius), Float.valueOf(r6.blurRadius)) == true) goto L12;
        return false;
    L12:
        if (this.direction == r6.direction) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(Float.valueOf(this.alpha), Float.valueOf(r6.alpha)) == true) goto L18;
        return false;
    L18:
        if (this.curveType == r6.curveType) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(Float.valueOf(this.endPoint), Float.valueOf(r6.endPoint)) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((Float.hashCode(this.blurRadius) * 31) + Integer.hashCode(this.direction)) * 31) + Float.hashCode(this.alpha)) * 31) + Integer.hashCode(this.curveType)) * 31) + Float.hashCode(this.endPoint);
    }

    public String toString() {
        return "BlurConfig(blurRadius=" + this.blurRadius + ", direction=" + this.direction + ", alpha=" + this.alpha + ", curveType=" + this.curveType + ", endPoint=" + this.endPoint + ')';
    }

    public BlurConfig(float r1, int r2, float r3, int r4, float r5) {
        this.blurRadius = r1;
        this.direction = r2;
        this.alpha = r3;
        this.curveType = r4;
        this.endPoint = r5;
    }

    public /* synthetic */ BlurConfig(float r4, int r5, float r6, int r7, float r8, int r9, DefaultConstructorMarker r10) {
        if ((r9 & 1) == 0) goto L5;
        r4 = 0.0f;
    L5:
        int r0 = 0;
        if ((r9 & 2) == 0) goto L8;
        int r11 = 0;
    L9:
        float r1 = 1.0f;
        if ((r9 & 4) == 0) goto L12;
        float r2 = 1.0f;
    L14:
        if ((r9 & 8) != 0) goto L18;
        r0 = r7;
    L18:
        if ((r9 & 16) != 0) goto L21;
        r1 = r8;
    L21:
        this(r4, r11, r2, r0, r1);
        return;
    L12:
        r2 = r6;
        goto L14
    L8:
        r11 = r5;
        goto L9
    }

    public final float getBlurRadius() {
        return this.blurRadius;
    }

    public final void setBlurRadius(float r1) {
        this.blurRadius = r1;
    }

    public final int getDirection() {
        return this.direction;
    }

    public final void setDirection(int r1) {
        this.direction = r1;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final void setAlpha(float r1) {
        this.alpha = r1;
    }

    public final int getCurveType() {
        return this.curveType;
    }

    public final void setCurveType(int r1) {
        this.curveType = r1;
    }

    public final float getEndPoint() {
        return this.endPoint;
    }

    public final void setEndPoint(float r1) {
        this.endPoint = r1;
    }

    public final BlurConfigCore toCore$OUI_standardRelease() {
        return new BlurConfigCore(this.blurRadius, this.direction, this.alpha, this.curveType, this.endPoint);
    }

    public final BlurConfig deepCopy() {
        BlurConfigCore r7 = BlurConfigCore.deepCopy(toCore$OUI_standardRelease());
        return new BlurConfig(r7.getBlurRadius(), r7.getDirection(), r7.getAlpha(), r7.getCurveType(), r7.getEndPoint());
    }

    public final BlurConfig copy() {
        return deepCopy();
    }
}
