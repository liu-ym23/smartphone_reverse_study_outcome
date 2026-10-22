package com.obric.search.api.schema.impl.bean;

import android.icu.text.PluralRules;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FullTextSearchDocumentInfo.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012 \b\u0002\u0010\t\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n0\u00070\u0007¢\u0006\u0002\u0010\fJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J!\u0010\u0016\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n0\u00070\u0007HÆ\u0003JO\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072 \b\u0002\u0010\t\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n0\u00070\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R)\u0010\t\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n0\u00070\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/obric/search/api/schema/impl/bean/FullTextSearchDocumentInfo;", "", "id", "", "score", "", "isFullMatch", "", "", "tokenPositions", "Lkotlin/Pair;", "", "(JDLjava/util/List;Ljava/util/List;)V", "getId", "()J", "()Ljava/util/List;", "getScore", "()D", "getTokenPositions", "component1", "component2", "component3", "component4", "copy", "equals", PluralRules.KEYWORD_OTHER, "hashCode", "toString", "", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FullTextSearchDocumentInfo {
    private final long id;
    private final List<Boolean> isFullMatch;
    private final double score;
    private final List<List<Pair<Integer, Integer>>> tokenPositions;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FullTextSearchDocumentInfo copy$default(FullTextSearchDocumentInfo r7, long r8, double r10, List r12, List r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L5;
        r8 = r7.id;
    L5:
        long r1 = r8;
        if ((r14 & 2) == 0) goto L8;
        r10 = r7.score;
    L8:
        double r3 = r10;
        if ((r14 & 4) == 0) goto L11;
        r12 = r7.isFullMatch;
    L11:
        List r5 = r12;
        if ((r14 & 8) == 0) goto L15;
        r13 = r7.tokenPositions;
    L15:
        return r7.copy(r1, r3, r5, r13);
    }

    public final long component1() {
        return this.id;
    }

    public final double component2() {
        return this.score;
    }

    public final List<Boolean> component3() {
        return this.isFullMatch;
    }

    public final List<List<Pair<Integer, Integer>>> component4() {
        return this.tokenPositions;
    }

    public final FullTextSearchDocumentInfo copy(long r8, double r10, List<Boolean> r12, List<? extends List<Pair<Integer, Integer>>> r13) {
        Intrinsics.checkNotNullParameter(r12, "isFullMatch");
        Intrinsics.checkNotNullParameter(r13, "tokenPositions");
        return new FullTextSearchDocumentInfo(r8, r10, r12, r13);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof FullTextSearchDocumentInfo) == true) goto L8;
        return false;
    L8:
        FullTextSearchDocumentInfo r9 = (FullTextSearchDocumentInfo) r8;
        if (this.id == r9.id) goto L12;
        return false;
    L12:
        if (Double.compare(this.score, r9.score) == 0) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.isFullMatch, r9.isFullMatch) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.tokenPositions, r9.tokenPositions) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.id) * 31) + Double.hashCode(this.score)) * 31) + this.isFullMatch.hashCode()) * 31) + this.tokenPositions.hashCode();
    }

    public String toString() {
        return "FullTextSearchDocumentInfo(id=" + this.id + ", score=" + this.score + ", isFullMatch=" + this.isFullMatch + ", tokenPositions=" + this.tokenPositions + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FullTextSearchDocumentInfo(long r2, double r4, List<Boolean> r6, List<? extends List<Pair<Integer, Integer>>> r7) {
        Intrinsics.checkNotNullParameter(r6, "isFullMatch");
        Intrinsics.checkNotNullParameter(r7, "tokenPositions");
        this.id = r2;
        this.score = r4;
        this.isFullMatch = r6;
        this.tokenPositions = r7;
    }

    public final long getId() {
        return this.id;
    }

    public final double getScore() {
        return this.score;
    }

    public /* synthetic */ FullTextSearchDocumentInfo(long r8, double r10, List r12, List r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L5;
        r10 = 0.0d;
    L5:
        double r3 = r10;
        if ((r14 & 4) == 0) goto L8;
        r12 = CollectionsKt.emptyList();
    L8:
        List r5 = r12;
        if ((r14 & 8) == 0) goto L11;
        r13 = CollectionsKt.emptyList();
    L11:
        this(r8, r3, r5, r13);
    }

    public final List<Boolean> isFullMatch() {
        return this.isFullMatch;
    }

    public final List<List<Pair<Integer, Integer>>> getTokenPositions() {
        return this.tokenPositions;
    }
}
