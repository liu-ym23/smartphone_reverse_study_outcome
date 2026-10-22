package com.obric.dejavu.library.cipher;

import android.icu.text.PluralRules;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CryptoOptions.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J'\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/obric/dejavu/library/cipher/CryptoOptions;", "", "approxFactor", "", "seed", "", "algVersion", "", "(DLjava/lang/String;I)V", "getAlgVersion", "()I", "setAlgVersion", "(I)V", "getApproxFactor", "()D", "setApproxFactor", "(D)V", "getSeed", "()Ljava/lang/String;", "setSeed", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "toString", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CryptoOptions {
    private int algVersion;
    private double approxFactor;
    private String seed;

    public static /* synthetic */ CryptoOptions copy$default(CryptoOptions r0, double r1, String r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.approxFactor;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r0.seed;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = r0.algVersion;
    L12:
        return r0.copy(r1, r3, r4);
    }

    public final double component1() {
        return this.approxFactor;
    }

    public final String component2() {
        return this.seed;
    }

    public final int component3() {
        return this.algVersion;
    }

    public final CryptoOptions copy(double r1, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "seed");
        return new CryptoOptions(r1, r3, r4);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof CryptoOptions) == true) goto L8;
        return false;
    L8:
        CryptoOptions r9 = (CryptoOptions) r8;
        if (Double.compare(this.approxFactor, r9.approxFactor) == 0) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.seed, r9.seed) == true) goto L15;
        return false;
    L15:
        if (this.algVersion == r9.algVersion) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Double.hashCode(this.approxFactor) * 31) + this.seed.hashCode()) * 31) + Integer.hashCode(this.algVersion);
    }

    public String toString() {
        return "CryptoOptions(approxFactor=" + this.approxFactor + ", seed=" + this.seed + ", algVersion=" + this.algVersion + ')';
    }

    public CryptoOptions(double r2, String r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "seed");
        this.approxFactor = r2;
        this.seed = r4;
        this.algVersion = r5;
    }

    public /* synthetic */ CryptoOptions(double r1, String r3, int r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = 0.1d;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 3;
    L8:
        this(r1, r3, r4);
    }

    public final double getApproxFactor() {
        return this.approxFactor;
    }

    public final void setApproxFactor(double r1) {
        this.approxFactor = r1;
    }

    public final String getSeed() {
        return this.seed;
    }

    public final void setSeed(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.seed = r2;
    }

    public final int getAlgVersion() {
        return this.algVersion;
    }

    public final void setAlgVersion(int r1) {
        this.algVersion = r1;
    }
}
