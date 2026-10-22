package com.obric.search.api.search.impl;

import com.android.settings.DataUsageFragment;
import com.android.settings.search.IndexDatabaseHelper;
import com.obric.search.api.query.impl.FullTextSearchQuery;
import com.obric.search.api.search.intf.ISearchSpec;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FullTextSearchSpec.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0001\u0019BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0002\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/obric/search/api/search/impl/FullTextSearchSpec;", "Lcom/obric/search/api/search/intf/ISearchSpec;", "schemaName", "", IndexDatabaseHelper.SavedQueriesColums.QUERY, "Lcom/obric/search/api/query/impl/FullTextSearchQuery;", "rankMethod", "Lcom/obric/search/api/search/impl/FullTextSearchSpec$RankMethod;", DataUsageFragment.INTENT_EXTRA_LIMIT, "", "offset", "targetIdList", "", "(Ljava/lang/String;Lcom/obric/search/api/query/impl/FullTextSearchQuery;Lcom/obric/search/api/search/impl/FullTextSearchSpec$RankMethod;JJLjava/util/List;)V", "getLimit", "()J", "getOffset", "getQuery", "()Lcom/obric/search/api/query/impl/FullTextSearchQuery;", "getRankMethod", "()Lcom/obric/search/api/search/impl/FullTextSearchSpec$RankMethod;", "getSchemaName", "()Ljava/lang/String;", "getTargetIdList", "()Ljava/util/List;", "RankMethod", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FullTextSearchSpec implements ISearchSpec {
    private final long limit;
    private final long offset;
    private final FullTextSearchQuery query;
    private final RankMethod rankMethod;
    private final String schemaName;
    private final List<Long> targetIdList;

    /* JADX INFO: compiled from: FullTextSearchSpec.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/search/api/search/impl/FullTextSearchSpec$RankMethod;", "", "(Ljava/lang/String;I)V", "None", "BM25", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final enum RankMethod extends Enum<RankMethod> {
        private static final /* synthetic */ RankMethod[] $VALUES = null;
        public static final RankMethod BM25 = null;
        public static final RankMethod None = null;

        private static final /* synthetic */ RankMethod[] $values() {
            return new RankMethod[]{None, BM25};
        }

        public static RankMethod valueOf(String r1) {
            return (RankMethod) Enum.valueOf(RankMethod.class, r1);
        }

        public static RankMethod[] values() {
            return (RankMethod[]) $VALUES.clone();
        }

        private RankMethod(String r1, int r2) {
            super(r1, r2);
        }

        static {
            None = new RankMethod("None", 0);
            BM25 = new RankMethod("BM25", 1);
            $VALUES = $values();
        }
    }

    public FullTextSearchSpec(String r2, FullTextSearchQuery r3, RankMethod r4, long r5, long r7, List<Long> r9) {
        Intrinsics.checkNotNullParameter(r2, "schemaName");
        Intrinsics.checkNotNullParameter(r3, IndexDatabaseHelper.SavedQueriesColums.QUERY);
        Intrinsics.checkNotNullParameter(r4, "rankMethod");
        Intrinsics.checkNotNullParameter(r9, "targetIdList");
        this.schemaName = r2;
        this.query = r3;
        this.rankMethod = r4;
        this.limit = r5;
        this.offset = r7;
        this.targetIdList = r9;
    }

    @Override // com.obric.search.api.search.intf.ISearchSpec
    public String getSchemaName() {
        return this.schemaName;
    }

    public final FullTextSearchQuery getQuery() {
        return this.query;
    }

    public /* synthetic */ FullTextSearchSpec(String r11, FullTextSearchQuery r12, RankMethod r13, long r14, long r16, List r18, int r19, DefaultConstructorMarker r20) {
        if ((r19 & 4) == 0) goto L5;
        RankMethod r4 = RankMethod.None;
    L7:
        if ((r19 & 8) == 0) goto L9;
        long r5 = 0;
    L11:
        if ((r19 & 16) == 0) goto L13;
        long r7 = 0;
    L15:
        if ((r19 & 32) == 0) goto L17;
        List r9 = CollectionsKt.emptyList();
    L18:
        this(r11, r12, r4, r5, r7, r9);
        return;
    L17:
        r9 = r18;
        goto L18
    L13:
        r7 = r16;
        goto L15
    L9:
        r5 = r14;
        goto L11
    L5:
        r4 = r13;
        goto L7
    }

    public final RankMethod getRankMethod() {
        return this.rankMethod;
    }

    public final long getLimit() {
        return this.limit;
    }

    public final long getOffset() {
        return this.offset;
    }

    public final List<Long> getTargetIdList() {
        return this.targetIdList;
    }
}
