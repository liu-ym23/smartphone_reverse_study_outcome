package com.obric.search.api.schema.impl;

import android.content.ContentValues;
import com.obric.search.api.document.intf.IDocument;
import com.obric.search.api.document.intf.IFullTextSearchDocument;
import com.obric.search.api.remove.impl.FullTextSearchRemoveSpec;
import com.obric.search.api.remove.intf.IRemoveSpec;
import com.obric.search.api.search.impl.FullTextSearchSpec;
import com.obric.search.api.search.intf.ISearchSpec;
import com.obric.search.common.log.RuntimeLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NonContentLessFTSExecutor.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 !2\u00020\u0001:\u0001!B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\bJ \u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00150\u00072\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0007H\u0016J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0016R\u001b\u0010\t\u001a\u00020\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u000f\u0010\u000bR\u001b\u0010\u0011\u001a\u00020\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0012\u0010\u000b¨\u0006\""}, d2 = {"Lcom/obric/search/api/schema/impl/NonContentLessFTSExecutor;", "Lcom/obric/search/api/schema/impl/FullTextSearchSchemaExecutor;", "schemaName", "", "context", "Lcom/obric/search/api/schema/impl/FullTextSearchSchemaContext;", "columnList", "", "(Ljava/lang/String;Lcom/obric/search/api/schema/impl/FullTextSearchSchemaContext;Ljava/util/List;)V", "insertOrReplaceSQLString", "getInsertOrReplaceSQLString", "()Ljava/lang/String;", "insertOrReplaceSQLString$delegate", "Lkotlin/Lazy;", "removeAllSQLString", "getRemoveAllSQLString", "removeAllSQLString$delegate", "removeSQLString", "getRemoveSQLString", "removeSQLString$delegate", "getDocumentsIdAndContentValues", "Lkotlin/Pair;", "", "Landroid/content/ContentValues;", "searchSpec", "Lcom/obric/search/api/search/intf/ISearchSpec;", "putDocuments", "", "list", "Lcom/obric/search/api/document/intf/IDocument;", "removeDocuments", "removeSpec", "Lcom/obric/search/api/remove/intf/IRemoveSpec;", "Companion", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NonContentLessFTSExecutor extends FullTextSearchSchemaExecutor {
    public static final Companion Companion = null;
    private static final String TAG = "NonContentLessFTSExecutor";
    private final Lazy insertOrReplaceSQLString$delegate;
    private final Lazy removeAllSQLString$delegate;
    private final Lazy removeSQLString$delegate;

    /* JADX INFO: compiled from: NonContentLessFTSExecutor.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/search/api/schema/impl/NonContentLessFTSExecutor$Companion;", "", "()V", "TAG", "", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

    public NonContentLessFTSExecutor(final String r2, FullTextSearchSchemaContext r3, List<String> r4) {
        Intrinsics.checkNotNullParameter(r2, "schemaName");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "columnList");
        super(r2, r3, r4);
        this.removeSQLString$delegate = LazyKt.lazy(new NonContentLessFTSExecutor$removeSQLString$2(r2));
        this.removeAllSQLString$delegate = LazyKt.lazy(new NonContentLessFTSExecutor$removeAllSQLString$2(r2));
        this.insertOrReplaceSQLString$delegate = LazyKt.lazy(new NonContentLessFTSExecutor$insertOrReplaceSQLString$2(r2, this));
    }

    private final String getRemoveSQLString() {
        return (String) this.removeSQLString$delegate.getValue();
    }

    private final String getRemoveAllSQLString() {
        return (String) this.removeAllSQLString$delegate.getValue();
    }

    private final String getInsertOrReplaceSQLString() {
        return (String) this.insertOrReplaceSQLString$delegate.getValue();
    }

    @Override // com.obric.search.api.schema.impl.FullTextSearchSchemaExecutor, com.obric.search.api.schema.intf.ISearchEngineSchemaExecutor
    public boolean removeDocuments(IRemoveSpec r6) {
        Intrinsics.checkNotNullParameter(r6, "removeSpec");
        RuntimeLogger.INSTANCE.debug(TAG, "removeDocuments called! SchemaName is " + r6.getSchemaName());
        if ((r6 instanceof FullTextSearchRemoveSpec) == true) goto L6;
        RuntimeLogger.INSTANCE.error(TAG, "removeDocuments removeSpec type error.");
        return false;
    L6:
        FullTextSearchRemoveSpec r7 = (FullTextSearchRemoveSpec) r6;
        if (r7.getRemoveAll() == false) goto L11;
        Pair<Boolean, Integer> r5 = getContext().getSqLiteSearchEngine().executeDelete(getSchemaName(), getRemoveAllSQLString());
        RuntimeLogger.INSTANCE.info(TAG, "removeDocuments remove all done. res is " + r5);
        return r5.getFirst().booleanValue();
    L11:
        if (r7.getList().isEmpty() == false) goto L14;
        RuntimeLogger.INSTANCE.warn(TAG, "removeDocuments removeSpec list is empty.");
        return true;
    L14:
        List<IDocument> r8 = r7.getList();
        ArrayList r0 = new ArrayList();
        Iterator<T> r9 = r8.iterator();
    L16:
        if (r9.hasNext() == false) goto L23;
        IDocument r1 = (IDocument) r9.next();
        if ((r1 instanceof IFullTextSearchDocument) == false) goto L20;
        Long r2 = Long.valueOf(r1.getId());
    L21:
        if (r2 == null) goto L16;
        r0.add(r2);
        goto L16
    L20:
        r2 = null;
        Long r3 = (Long) null;
        goto L21
    L23:
        Pair<Boolean, Integer> r10 = getContext().getSqLiteSearchEngine().batchDeleteByLongValue(getSchemaName(), getRemoveSQLString(), r0);
        RuntimeLogger.INSTANCE.debug(TAG, "removeDocuments done. res is " + r10);
        return r10.getFirst().booleanValue();
    }

    public final List<Pair<Long, ContentValues>> getDocumentsIdAndContentValues(ISearchSpec r12) {
        Intrinsics.checkNotNullParameter(r12, "searchSpec");
        RuntimeLogger.INSTANCE.debug(TAG, "getDocumentsIdAndContentValues called! SchemaName is " + r12.getSchemaName());
        if ((r12 instanceof FullTextSearchSpec) == true) goto L6;
        RuntimeLogger.INSTANCE.error(TAG, "getDocumentsIdAndContentValues searchSpec type error.");
        return CollectionsKt.emptyList();
    L6:
        FullTextSearchSpec r13 = (FullTextSearchSpec) r12;
        return getContext().getSqLiteSearchEngine().queryRowIdAndStringColumn(getQuerySQLString("ROWID, " + CollectionsKt.joinToString$default(getColumnList(), ", ", null, null, 0, null, null, 62, null), getSchemaName(), r13.getRankMethod(), r13.getLimit(), r13.getOffset(), r13.getTargetIdList()), r13.getQuery().getMatchClause(), getColumnList());
    }

    @Override // com.obric.search.api.schema.impl.FullTextSearchSchemaExecutor, com.obric.search.api.schema.intf.ISearchEngineSchemaExecutor
    public boolean putDocuments(List<? extends IDocument> r9) {
        Intrinsics.checkNotNullParameter(r9, "list");
        if (r9.isEmpty() == false) goto L6;
        RuntimeLogger.INSTANCE.warn(TAG, "putOrReplaceDocuments called! List is empty! Return true");
        return true;
    L6:
        RuntimeLogger.INSTANCE.debug(TAG, "putOrReplaceDocuments called! SchemaName is " + r9.get(0).getSchemaName());
        ArrayList r0 = new ArrayList();
        Iterator<? extends IDocument> r10 = r9.iterator();
    L8:
        if (r10.hasNext() == false) goto L17;
        IDocument r1 = r10.next();
        if ((r1 instanceof IFullTextSearchDocument) == false) goto L11;
        ContentValues r2 = ((IFullTextSearchDocument) r1).toContentValues();
        ArrayList r4 = new ArrayList();
        Iterator<String> r5 = getColumnList().iterator();
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
        boolean r11 = getContext().getSqLiteSearchEngine().batchInsertStringValue(getSchemaName(), getInsertOrReplaceSQLString(), r0);     // Catch: Throwable -> L21
        monitor-exit(this);
        return r11;
    L21:
        th = move-exception;
        throw th;
    }
}
