package com.obric.search.api.schema.impl;

import android.content.ContentValues;
import com.android.launcher3.icons.cache.BaseIconCache;
import com.android.settings.DataUsageFragment;
import com.obric.search.api.document.intf.IDocument;
import com.obric.search.api.document.intf.IFullTextSearchDocument;
import com.obric.search.api.remove.impl.FullTextSearchRemoveSpec;
import com.obric.search.api.remove.intf.IRemoveSpec;
import com.obric.search.api.schema.impl.bean.DocumentIsFullMatch;
import com.obric.search.api.schema.impl.bean.DocumentTokenPosition;
import com.obric.search.api.schema.impl.bean.FullTextSearchDocumentInfo;
import com.obric.search.api.schema.intf.ISearchEngineSchemaExecutor;
import com.obric.search.api.search.impl.FullTextSearchInfoSpec;
import com.obric.search.api.search.impl.FullTextSearchSpec;
import com.obric.search.api.search.intf.ISearchSpec;
import com.obric.search.common.log.RuntimeLogger;
import com.tencent.wcdb.Cursor;
import cz.msebera.android.httpclient.message.TokenParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FullTextSearchSchemaExecutor.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0018\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 A2\u00020\u0001:\u0001AB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00072\u0006\u0010!\u001a\u00020\"H\u0016J\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u00072\u0006\u0010!\u001a\u00020\"J\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u00072\u0006\u0010!\u001a\u00020\"J\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u00072\u0006\u0010!\u001a\u00020)2\u0006\u0010*\u001a\u00020+J>\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u00032\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020 2\u0006\u00102\u001a\u00020 2\f\u00103\u001a\b\u0012\u0004\u0012\u00020 0\u0007H\u0004J\u0016\u00104\u001a\b\u0012\u0004\u0012\u0002050\u00072\u0006\u00106\u001a\u00020\u0003H\u0002J(\u00107\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u000209080\u00070\u00072\u0006\u0010:\u001a\u00020\u0003H\u0002J\u0016\u0010;\u001a\u0002052\f\u0010<\u001a\b\u0012\u0004\u0012\u00020=0\u0007H\u0016J\u0010\u0010>\u001a\u0002052\u0006\u0010?\u001a\u00020@H\u0016R\u001b\u0010\t\u001a\u00020\u00038DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00038DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0011\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0016\u0010\u000bR\u001b\u0010\u0018\u001a\u00020\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u0019\u0010\u000bR\u001b\u0010\u001b\u001a\u00020\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\r\u001a\u0004\b\u001c\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u000b¨\u0006B"}, d2 = {"Lcom/obric/search/api/schema/impl/FullTextSearchSchemaExecutor;", "Lcom/obric/search/api/schema/intf/ISearchEngineSchemaExecutor;", "schemaName", "", "context", "Lcom/obric/search/api/schema/impl/FullTextSearchSchemaContext;", "columnList", "", "(Ljava/lang/String;Lcom/obric/search/api/schema/impl/FullTextSearchSchemaContext;Ljava/util/List;)V", "argString", "getArgString", "()Ljava/lang/String;", "argString$delegate", "Lkotlin/Lazy;", "getColumnList", "()Ljava/util/List;", "columnString", "getColumnString", "columnString$delegate", "getContext", "()Lcom/obric/search/api/schema/impl/FullTextSearchSchemaContext;", "insertSQLString", "getInsertSQLString", "insertSQLString$delegate", "removeAllSQLString", "getRemoveAllSQLString", "removeAllSQLString$delegate", "removeSQLString", "getRemoveSQLString", "removeSQLString$delegate", "getSchemaName", "getDocumentsId", "", "searchSpec", "Lcom/obric/search/api/search/intf/ISearchSpec;", "getDocumentsIdAndIsFullMatch", "Lcom/obric/search/api/schema/impl/bean/DocumentIsFullMatch;", "getDocumentsTokenPosition", "Lcom/obric/search/api/schema/impl/bean/DocumentTokenPosition;", "getFTSDocumentInfo", "Lcom/obric/search/api/schema/impl/bean/FullTextSearchDocumentInfo;", "Lcom/obric/search/api/search/impl/FullTextSearchSpec;", "infoSpec", "Lcom/obric/search/api/search/impl/FullTextSearchInfoSpec;", "getQuerySQLString", "selectClause", "tableName", "rankMethod", "Lcom/obric/search/api/search/impl/FullTextSearchSpec$RankMethod;", DataUsageFragment.INTENT_EXTRA_LIMIT, "offset", "targetIdList", "parseIsFullMatch", "", "isFullMatchStr", "parseTokenPositions", "Lkotlin/Pair;", "", "tokenPositionsStr", "putDocuments", "list", "Lcom/obric/search/api/document/intf/IDocument;", "removeDocuments", "removeSpec", "Lcom/obric/search/api/remove/intf/IRemoveSpec;", "Companion", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class FullTextSearchSchemaExecutor implements ISearchEngineSchemaExecutor {
    public static final Companion Companion = null;
    private static final String TAG = "FullTextSearchSchemaExecutor";
    private final Lazy argString$delegate;
    private final List<String> columnList;
    private final Lazy columnString$delegate;
    private final FullTextSearchSchemaContext context;
    private final Lazy insertSQLString$delegate;
    private final Lazy removeAllSQLString$delegate;
    private final Lazy removeSQLString$delegate;
    private final String schemaName;

    /* JADX INFO: compiled from: FullTextSearchSchemaExecutor.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/search/api/schema/impl/FullTextSearchSchemaExecutor$Companion;", "", "()V", "TAG", "", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public FullTextSearchSchemaExecutor(String r2, FullTextSearchSchemaContext r3, List<String> r4) {
        Intrinsics.checkNotNullParameter(r2, "schemaName");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "columnList");
        this.schemaName = r2;
        this.context = r3;
        this.columnList = r4;
        this.argString$delegate = LazyKt.lazy(new FullTextSearchSchemaExecutor$argString$2(this));
        this.columnString$delegate = LazyKt.lazy(new FullTextSearchSchemaExecutor$columnString$2(this));
        this.insertSQLString$delegate = LazyKt.lazy(new FullTextSearchSchemaExecutor$insertSQLString$2(this));
        this.removeSQLString$delegate = LazyKt.lazy(new FullTextSearchSchemaExecutor$removeSQLString$2(this));
        this.removeAllSQLString$delegate = LazyKt.lazy(new FullTextSearchSchemaExecutor$removeAllSQLString$2(this));
    }

    public final String getSchemaName() {
        return this.schemaName;
    }

    public final FullTextSearchSchemaContext getContext() {
        return this.context;
    }

    public final List<String> getColumnList() {
        return this.columnList;
    }

    protected final String getArgString() {
        return (String) this.argString$delegate.getValue();
    }

    protected final String getColumnString() {
        return (String) this.columnString$delegate.getValue();
    }

    private final String getInsertSQLString() {
        return (String) this.insertSQLString$delegate.getValue();
    }

    private final String getRemoveSQLString() {
        return (String) this.removeSQLString$delegate.getValue();
    }

    private final String getRemoveAllSQLString() {
        return (String) this.removeAllSQLString$delegate.getValue();
    }

    @Override // com.obric.search.api.schema.intf.ISearchEngineSchemaExecutor
    public boolean putDocuments(List<? extends IDocument> r9) {
        Intrinsics.checkNotNullParameter(r9, "list");
        if (r9.isEmpty() == false) goto L6;
        RuntimeLogger.INSTANCE.warn(TAG, "putDocuments called! List is empty! Return true");
        return true;
    L6:
        RuntimeLogger.INSTANCE.debug(TAG, "putDocuments called! SchemaName is " + r9.get(0).getSchemaName());
        ArrayList r0 = new ArrayList();
        Iterator<? extends IDocument> r10 = r9.iterator();
    L8:
        if (r10.hasNext() == false) goto L17;
        IDocument r1 = r10.next();
        if ((r1 instanceof IFullTextSearchDocument) == false) goto L11;
        ContentValues r2 = ((IFullTextSearchDocument) r1).toContentValues();
        ArrayList r4 = new ArrayList();
        Iterator<String> r5 = this.columnList.iterator();
    L14:
        if (r5.hasNext() == false) goto L16;
        String r6 = r2.getAsString(r5.next());
        Intrinsics.checkNotNullExpressionValue(r6, "contentValues.getAsString(column)");
        r4.add(r6);
        goto L14
    L16:
        r0.add(new Pair(Long.valueOf(r1.getId()), r4));
        goto L8
    L11:
        return false;
    L17:
        monitor-enter(this);
        boolean r11 = this.context.getSqLiteSearchEngine().batchInsertStringValue(this.schemaName, getInsertSQLString(), r0);     // Catch: Throwable -> L21
        monitor-exit(this);
        return r11;
    L21:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.search.api.schema.intf.ISearchEngineSchemaExecutor
    public boolean removeDocuments(IRemoveSpec r15) {
        Intrinsics.checkNotNullParameter(r15, "removeSpec");
        RuntimeLogger.INSTANCE.debug(TAG, "removeDocuments called! SchemaName is " + r15.getSchemaName());
        boolean r2 = false;
        if ((r15 instanceof FullTextSearchRemoveSpec) == true) goto L6;
        RuntimeLogger.INSTANCE.error(TAG, "removeDocuments removeSpec type error.");
        return false;
    L6:
        FullTextSearchRemoveSpec r1 = (FullTextSearchRemoveSpec) r15;
        if (r1.getRemoveAll() == false) goto L16;
        monitor-enter(this);
        boolean r16 = this.context.getSqLiteSearchEngine().executeInsert(this.schemaName, getRemoveAllSQLString());     // Catch: Throwable -> L12
        RuntimeLogger.INSTANCE.info(TAG, "removeDocuments remove all done. res is " + r16);     // Catch: Throwable -> L12
        monitor-exit(this);
        return r16;
    L12:
        th = move-exception;
        throw th;
    L16:
        if (r1.getList().isEmpty() == false) goto L19;
        RuntimeLogger.INSTANCE.warn(TAG, "removeDocuments removeSpec list is empty.");
        return true;
    L19:
        ArrayList r0 = new ArrayList();
        ArrayList r3 = new ArrayList();
        monitor-enter(this);
        Iterator<IDocument> r17 = ((FullTextSearchRemoveSpec) r15).getList().iterator();     // Catch: Throwable -> L44
    L23:
        if (r17.hasNext() == false) goto L36;
        IDocument r4 = r17.next();     // Catch: Throwable -> L44
        if ((r4 instanceof IFullTextSearchDocument) == false) goto L42;
        if (this.context.getSqLiteSearchEngine().queryRowId("SELECT ROWID FROM " + this.schemaName + " WHERE ROWID = ? LIMIT 1", String.valueOf(r4.getId())).isEmpty() == true) goto L29;
        ContentValues r5 = ((IFullTextSearchDocument) r4).toContentValues();     // Catch: Throwable -> L44
        ArrayList r6 = new ArrayList();     // Catch: Throwable -> L44
        Iterator<String> r7 = this.columnList.iterator();     // Catch: Throwable -> L44
    L32:
        if (r7.hasNext() == false) goto L34;
        String r8 = r5.getAsString(r7.next());     // Catch: Throwable -> L44
        Intrinsics.checkNotNullExpressionValue(r8, "contentValues.getAsString(column)");     // Catch: Throwable -> L44
        r6.add(r8);     // Catch: Throwable -> L44
        goto L32
    L34:
        r3.add(new Pair(Long.valueOf(r4.getId()), r6));     // Catch: Throwable -> L44
        goto L23
    L29:
        r0.add(Long.valueOf(r4.getId()));     // Catch: Throwable -> L44
    L42:
        monitor-exit(this);
        return r2;
    L36:
        if ((!r0.isEmpty()) == false) goto L39;
        RuntimeLogger.INSTANCE.debug(TAG, "removeDocuments removeSpec not exist rowId(" + CollectionsKt.joinToString$default(r0, null, null, null, 0, null, null, 63, null) + ").");     // Catch: Throwable -> L44
    L39:
        if (r3.isEmpty() == false) goto L41;
        RuntimeLogger.INSTANCE.debug(TAG, "removeDocuments removeArguments is empty.");     // Catch: Throwable -> L44
        goto L42
    L41:
        r2 = this.context.getSqLiteSearchEngine().batchInsertStringValue(this.schemaName, getRemoveSQLString(), r3);     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        throw th;
    }

    protected final String getQuerySQLString(String r17, String r18, FullTextSearchSpec.RankMethod r19, long r20, long r22, List<Long> r24) {
        Intrinsics.checkNotNullParameter(r17, "selectClause");
        Intrinsics.checkNotNullParameter(r18, "tableName");
        Intrinsics.checkNotNullParameter(r19, "rankMethod");
        Intrinsics.checkNotNullParameter(r24, "targetIdList");
        StringBuilder r6 = new StringBuilder("SELECT " + r17 + " FROM " + r18 + " WHERE " + r18 + " MATCH ?");
        if ((!r24.isEmpty()) == false) goto L6;
        r6.append(" AND ROWID IN (" + CollectionsKt.joinToString$default(r24, ", ", null, null, 0, null, null, 62, null) + ')');
    L6:
        if (r19 != FullTextSearchSpec.RankMethod.BM25) goto L9;
        r6.append(" AND rank='bm25()' ORDER BY rank");
    L9:
        if (r20 == 0) goto L11;
        r6.append(" LIMIT " + r20 + " OFFSET " + r22);
    L11:
        String r0 = r6.toString();
        Intrinsics.checkNotNullExpressionValue(r0, "sb.toString()");
        return r0;
    }

    @Override // com.obric.search.api.schema.intf.ISearchEngineSchemaExecutor
    public List<Long> getDocumentsId(ISearchSpec r10) {
        Intrinsics.checkNotNullParameter(r10, "searchSpec");
        RuntimeLogger.INSTANCE.debug(TAG, "getDocumentsId called! SchemaName is " + r10.getSchemaName());
        if ((r10 instanceof FullTextSearchSpec) == true) goto L6;
        RuntimeLogger.INSTANCE.error(TAG, "getDocumentsId searchSpec type error.");
        return CollectionsKt.emptyList();
    L6:
        FullTextSearchSpec r11 = (FullTextSearchSpec) r10;
        return this.context.getSqLiteSearchEngine().queryRowId(getQuerySQLString("ROWID", this.schemaName, r11.getRankMethod(), r11.getLimit(), r11.getOffset(), r11.getTargetIdList()), r11.getQuery().getMatchClause());
    }

    private final List<List<Pair<Integer, Integer>>> parseTokenPositions(String r11) {
        int r10 = 1;
        List r12 = StringsKt.split$default(r11, new char[]{TokenParser.SP}, false, 0, 6, null);
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r0.add(Integer.valueOf(Integer.parseInt((String) r13.next())));
        goto L4
    L6:
        ArrayList r1 = r0;
        int r14 = ((Number) r1.get(0)).intValue() + 1;
        ArrayList r2 = new ArrayList();
        int r3 = ((Number) r1.get(0)).intValue();
        if (1 > r3) goto L19;
    L8:
        ArrayList r4 = new ArrayList();
        IntProgression r5 = RangesKt.step(RangesKt.until(r14, ((Number) r1.get(r10)).intValue() + r14), 2);
        int r6 = r5.getFirst();
        int r7 = r5.getLast();
        int r8 = r5.getStep();
        if (r8 <= 0) goto L11;
        if (r6 > r7) goto L11;
    L13:
        r4.add(new Pair(r1.get(r6), r1.get(r6 + 1)));
        if (r6 == r7) goto L16;
        r6 = r6 + r8;
    L16:
        r14 = r14 + ((Number) r1.get(r10)).intValue();
        r2.add(r4);
        if (r10 == r3) goto L19;
        r10 = r10 + 1;
    L11:
        if (r8 >= 0) goto L16;
        if (r7 > r6) goto L16;
    L19:
        return r2;
    }

    public final List<DocumentTokenPosition> getDocumentsTokenPosition(ISearchSpec r11) {
        Intrinsics.checkNotNullParameter(r11, "searchSpec");
        RuntimeLogger.INSTANCE.debug(TAG, "getDocumentsTokenPosition called! SchemaName is " + r11.getSchemaName());
        if ((r11 instanceof FullTextSearchSpec) == true) goto L6;
        RuntimeLogger.INSTANCE.error(TAG, "getDocumentsTokenPosition searchSpec type error.");
        return CollectionsKt.emptyList();
    L6:
        FullTextSearchSpec r12 = (FullTextSearchSpec) r11;
        List<Pair<Long, String>> r13 = this.context.getSqLiteSearchEngine().queryRowIdAndAuxiliaryFuncStringResult(getQuerySQLString("ROWID,token_position(" + this.schemaName + ')', this.schemaName, r12.getRankMethod(), r12.getLimit(), r12.getOffset(), r12.getTargetIdList()), r12.getQuery().getMatchClause());
        ArrayList r0 = new ArrayList();
        Iterator<Pair<Long, String>> r14 = r13.iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        Pair<Long, String> r1 = r14.next();
        r0.add(new DocumentTokenPosition(r1.getFirst().longValue(), parseTokenPositions(r1.getSecond())));
        goto L8
    L10:
        return r0;
    }

    private final List<Boolean> parseIsFullMatch(String r8) {
        List r9 = StringsKt.split$default(r8, new char[]{TokenParser.SP}, false, 0, 6, null);
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r0.add(Integer.valueOf(Integer.parseInt((String) r10.next())));
        goto L4
    L6:
        ArrayList r11 = new ArrayList();
        Iterator r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L14;
        if (((Number) r1.next()).intValue() == 0) goto L12;
        boolean r2 = true;
    L13:
        r11.add(Boolean.valueOf(r2));
        goto L8
    L12:
        r2 = false;
        goto L13
    L14:
        return r11;
    }

    public final List<DocumentIsFullMatch> getDocumentsIdAndIsFullMatch(ISearchSpec r11) {
        Intrinsics.checkNotNullParameter(r11, "searchSpec");
        RuntimeLogger.INSTANCE.debug(TAG, "getDocumentsIdAndIsFullMatch called! SchemaName is " + r11.getSchemaName());
        if ((r11 instanceof FullTextSearchSpec) == true) goto L6;
        RuntimeLogger.INSTANCE.error(TAG, "getDocumentsIdAndIsFullMatch searchSpec type error.");
        return CollectionsKt.emptyList();
    L6:
        FullTextSearchSpec r12 = (FullTextSearchSpec) r11;
        List<Pair<Long, String>> r13 = this.context.getSqLiteSearchEngine().queryRowIdAndAuxiliaryFuncStringResult(getQuerySQLString("ROWID,is_full_match(" + this.schemaName + ')', this.schemaName, r12.getRankMethod(), r12.getLimit(), r12.getOffset(), r12.getTargetIdList()), r12.getQuery().getMatchClause());
        ArrayList r0 = new ArrayList();
        Iterator<Pair<Long, String>> r14 = r13.iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        Pair<Long, String> r1 = r14.next();
        r0.add(new DocumentIsFullMatch(r1.getFirst().longValue(), parseIsFullMatch(r1.getSecond())));
        goto L8
    L10:
        return r0;
    }

    public final List<FullTextSearchDocumentInfo> getFTSDocumentInfo(FullTextSearchSpec r19, FullTextSearchInfoSpec r20) {
        Intrinsics.checkNotNullParameter(r19, "searchSpec");
        Intrinsics.checkNotNullParameter(r20, "infoSpec");
        RuntimeLogger.INSTANCE.debug(TAG, "getFTSDocumentInfo called! SchemaName is " + r19.getSchemaName());
        StringBuilder r1 = new StringBuilder("ROWID");
        if (r20.getNeedScore() == false) goto L6;
        r1.append(",bm25(" + this.schemaName + ") AS score");
    L6:
        if (r20.getNeedIsFullMatch() == false) goto L9;
        r1.append(",is_full_match(" + this.schemaName + ") AS is_full_match");
    L9:
        if (r20.getNeedTokenPositions() == false) goto L11;
        r1.append(",token_position(" + this.schemaName + ") AS token_positions");
    L11:
        String r2 = r1.toString();
        Intrinsics.checkNotNullExpressionValue(r2, "selectClauseBuilder.toString()");
        Cursor r3 = this.context.getSqLiteSearchEngine().getCursor(getQuerySQLString(r2, this.schemaName, r19.getRankMethod(), r19.getLimit(), r19.getOffset(), r19.getTargetIdList()), r19.getQuery().getMatchClause());
        ArrayList r4 = new ArrayList();
        Cursor r5 = r3;
        Cursor r6 = r5;     // Catch: Throwable -> L36
        RuntimeLogger.INSTANCE.debug(TAG, "queryRowIdAndStringColumn cursor size is " + r6.getCount());     // Catch: Throwable -> L36
        int r7 = r6.getColumnIndex(BaseIconCache.IconDB.COLUMN_ROWID);     // Catch: Throwable -> L36
        if (r7 != (-1)) goto L17;
        RuntimeLogger.INSTANCE.error(TAG, "queryRowIdAndStringColumn ROWID index is -1");     // Catch: Throwable -> L36
        CloseableKt.closeFinally(r5, null);
        return r4;
    L17:
        int r8 = r6.getColumnIndex("score");     // Catch: Throwable -> L36
        int r9 = r6.getColumnIndex("is_full_match");     // Catch: Throwable -> L36
        int r10 = r6.getColumnIndex("token_positions");     // Catch: Throwable -> L36
    L19:
        if (r6.moveToNext() == false) goto L33;
        long r12 = r6.getLong(r7);     // Catch: Throwable -> L36
        if (r8 == (-1)) goto L23;
        double r11 = ((double) (-1)) * r6.getDouble(r8);     // Catch: Throwable -> L36
    L24:
        double r14 = r11;
        if (r9 == (-1)) goto L27;
        String r13 = r6.getString(r9);     // Catch: Throwable -> L36
        Intrinsics.checkNotNullExpressionValue(r13, "it.getString(isFullMatchIndex)");     // Catch: Throwable -> L36
        List<Boolean> r15 = parseIsFullMatch(r13);     // Catch: Throwable -> L36
    L28:
        List<Boolean> r16 = r15;
        if (r10 == (-1)) goto L31;
        String r17 = r6.getString(r10);     // Catch: Throwable -> L36
        Intrinsics.checkNotNullExpressionValue(r17, "it.getString(tokenPositionsIndex)");     // Catch: Throwable -> L36
        List<List<Pair<Integer, Integer>>> r18 = parseTokenPositions(r17);     // Catch: Throwable -> L36
    L32:
        r4.add(new FullTextSearchDocumentInfo(r12, r14, r16, r18));     // Catch: Throwable -> L36
        goto L19
    L31:
        r18 = CollectionsKt.emptyList();     // Catch: Throwable -> L36
        goto L32
    L27:
        r15 = CollectionsKt.emptyList();     // Catch: Throwable -> L36
        goto L28
    L23:
        r11 = 0.0d;
        goto L24
    L33:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L36
        CloseableKt.closeFinally(r5, null);
        return r4;
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);
        throw th;
    }
}
