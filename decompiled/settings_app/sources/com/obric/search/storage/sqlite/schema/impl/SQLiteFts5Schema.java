package com.obric.search.storage.sqlite.schema.impl;

import com.obric.search.api.schema.impl.FullTextSearchSchema;
import com.obric.search.common.log.RuntimeLogger;
import com.obric.search.storage.sqlite.schema.intf.ISQLiteTableSchema;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SQLiteFts5Schema.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/search/storage/sqlite/schema/impl/SQLiteFts5Schema;", "Lcom/obric/search/storage/sqlite/schema/intf/ISQLiteTableSchema;", "tableName", "", "columnList", "", "tokenizer", "Lcom/obric/search/api/schema/impl/FullTextSearchSchema$TOKENIZER;", "isContentLess", "", "(Ljava/lang/String;Ljava/util/List;Lcom/obric/search/api/schema/impl/FullTextSearchSchema$TOKENIZER;Z)V", "getTableName", "()Ljava/lang/String;", "toCreateTableSQLString", "toDeleteTableSQLString", "Companion", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SQLiteFts5Schema implements ISQLiteTableSchema {
    public static final Companion Companion = null;
    private static final String TAG = "SQLiteFts5Schema";
    private final List<String> columnList;
    private final boolean isContentLess;
    private final String tableName;
    private final FullTextSearchSchema.TOKENIZER tokenizer;

    /* JADX INFO: compiled from: SQLiteFts5Schema.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/search/storage/sqlite/schema/impl/SQLiteFts5Schema$Companion;", "", "()V", "TAG", "", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: SQLiteFts5Schema.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[FullTextSearchSchema.TOKENIZER.values().length];
            r0[FullTextSearchSchema.TOKENIZER.O_TOKENIZER_2.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[FullTextSearchSchema.TOKENIZER.O_TOKENIZER_4_FOR_TEST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[FullTextSearchSchema.TOKENIZER.O_TOKENIZER_1.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[FullTextSearchSchema.TOKENIZER.O_TOKENIZER_3_FOR_TEST.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public SQLiteFts5Schema(String r2, List<String> r3, FullTextSearchSchema.TOKENIZER r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "tableName");
        Intrinsics.checkNotNullParameter(r3, "columnList");
        Intrinsics.checkNotNullParameter(r4, "tokenizer");
        this.tableName = r2;
        this.columnList = r3;
        this.tokenizer = r4;
        this.isContentLess = r5;
    }

    @Override // com.obric.search.storage.sqlite.schema.intf.ISQLiteTableSchema
    public String getTableName() {
        return this.tableName;
    }

    @Override // com.obric.search.storage.sqlite.schema.intf.ISQLiteTableSchema
    public String toCreateTableSQLString() {
        if (this.columnList.isEmpty() == false) goto L6;
        RuntimeLogger.INSTANCE.error(TAG, "Translate to SQL string error. Column list is empty!");
        return "";
    L6:
        StringBuilder r0 = new StringBuilder().append(this.columnList.get(0));
        int r1 = this.columnList.size();
        int r3 = 1;
    L7:
        if (r3 >= r1) goto L10;
        r0.append(", " + this.columnList.get(r3));
        r3 = r3 + 1;
        goto L7
    L10:
        if (this.isContentLess == false) goto L12;
        r0.append(", content=''");
    L12:
        int r2 = WhenMappings.$EnumSwitchMapping$0[this.tokenizer.ordinal()];
        if (r2 == 1) goto L25;
        if (r2 == 2) goto L25;
        if (r2 == 3) goto L27;
        if (r2 == 4) goto L27;
        throw new NoWhenBranchMatchedException();
    L27:
        return "CREATE VIRTUAL TABLE " + getTableName() + " USING fts5(" + r0 + ", tokenize='" + this.tokenizer.getSqlName() + "')";
    L25:
        return "CREATE VIRTUAL TABLE " + getTableName() + " USING fts5(" + r0 + ", prefix='1 2 3 4 5', tokenize='" + this.tokenizer.getSqlName() + "')";
    }

    @Override // com.obric.search.storage.sqlite.schema.intf.ISQLiteTableSchema
    public String toDeleteTableSQLString() {
        return "DROP TABLE " + getTableName();
    }
}
