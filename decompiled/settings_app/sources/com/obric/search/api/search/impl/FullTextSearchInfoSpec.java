package com.obric.search.api.search.impl;

import android.icu.text.PluralRules;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FullTextSearchInfoSpec.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/obric/search/api/search/impl/FullTextSearchInfoSpec;", "", "needScore", "", "needIsFullMatch", "needTokenPositions", "(ZZZ)V", "getNeedIsFullMatch", "()Z", "getNeedScore", "getNeedTokenPositions", "component1", "component2", "component3", "copy", "equals", PluralRules.KEYWORD_OTHER, "hashCode", "", "toString", "", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FullTextSearchInfoSpec {
    private final boolean needIsFullMatch;
    private final boolean needScore;
    private final boolean needTokenPositions;

    public FullTextSearchInfoSpec() {
        this(false, false, false, 7, null);
    }

    public static /* synthetic */ FullTextSearchInfoSpec copy$default(FullTextSearchInfoSpec r0, boolean r1, boolean r2, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.needScore;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.needIsFullMatch;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.needTokenPositions;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final boolean component1() {
        return this.needScore;
    }

    public final boolean component2() {
        return this.needIsFullMatch;
    }

    public final boolean component3() {
        return this.needTokenPositions;
    }

    public final FullTextSearchInfoSpec copy(boolean r1, boolean r2, boolean r3) {
        return new FullTextSearchInfoSpec(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FullTextSearchInfoSpec) == true) goto L8;
        return false;
    L8:
        FullTextSearchInfoSpec r6 = (FullTextSearchInfoSpec) r5;
        if (this.needScore == r6.needScore) goto L12;
        return false;
    L12:
        if (this.needIsFullMatch == r6.needIsFullMatch) goto L15;
        return false;
    L15:
        if (this.needTokenPositions == r6.needTokenPositions) goto L17;
        return false;
    L17:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    public int hashCode() {
        boolean r0 = this.needScore;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        boolean r4 = this.needIsFullMatch;
        ?? r5 = r4;
        if (r4 == false) goto L8;
        r5 = 1;
    L8:
        int r6 = (r3 + r5) * 31;
        boolean r7 = this.needTokenPositions;
        if (r7 == true) goto L13;
        r1 = r7;
    L13:
        return r6 + r1;
    }

    public String toString() {
        return "FullTextSearchInfoSpec(needScore=" + this.needScore + ", needIsFullMatch=" + this.needIsFullMatch + ", needTokenPositions=" + this.needTokenPositions + ')';
    }

    public FullTextSearchInfoSpec(boolean r1, boolean r2, boolean r3) {
        this.needScore = r1;
        this.needIsFullMatch = r2;
        this.needTokenPositions = r3;
    }

    public /* synthetic */ FullTextSearchInfoSpec(boolean r2, boolean r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = false;
    L11:
        this(r2, r3, r4);
    }

    public final boolean getNeedScore() {
        return this.needScore;
    }

    public final boolean getNeedIsFullMatch() {
        return this.needIsFullMatch;
    }

    public final boolean getNeedTokenPositions() {
        return this.needTokenPositions;
    }
}
