package com.obric.search.api.schema.impl;

import android.content.Context;
import com.obric.search.api.schema.intf.ISearchEngineSchema;
import com.obric.search.api.schema.intf.ISearchEngineSchemaContext;
import com.obric.search.api.schema.intf.ISearchEngineSchemaExecutor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FullTextSearchSchema.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/obric/search/api/schema/impl/FullTextSearchSchema;", "Lcom/obric/search/api/schema/intf/ISearchEngineSchema;", "schemaName", "", "columnList", "", "tokenizer", "Lcom/obric/search/api/schema/impl/FullTextSearchSchema$TOKENIZER;", "isContentLess", "", "(Ljava/lang/String;Ljava/util/List;Lcom/obric/search/api/schema/impl/FullTextSearchSchema$TOKENIZER;Z)V", "getColumnList", "()Ljava/util/List;", "()Z", "getSchemaName", "()Ljava/lang/String;", "getTokenizer", "()Lcom/obric/search/api/schema/impl/FullTextSearchSchema$TOKENIZER;", "createExecutor", "Lcom/obric/search/api/schema/intf/ISearchEngineSchemaExecutor;", "context", "Landroid/content/Context;", "schemaContext", "Lcom/obric/search/api/schema/intf/ISearchEngineSchemaContext;", "TOKENIZER", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FullTextSearchSchema implements ISearchEngineSchema {
    private final List<String> columnList;
    private final boolean isContentLess;
    private final String schemaName;
    private final TOKENIZER tokenizer;

    /* JADX INFO: compiled from: FullTextSearchSchema.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/obric/search/api/schema/impl/FullTextSearchSchema$TOKENIZER;", "", "sqlName", "", "typeCode", "", "(Ljava/lang/String;ILjava/lang/String;I)V", "getSqlName", "()Ljava/lang/String;", "getTypeCode", "()I", "O_TOKENIZER_1", "O_TOKENIZER_2", "O_TOKENIZER_3_FOR_TEST", "O_TOKENIZER_4_FOR_TEST", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final enum TOKENIZER extends Enum<TOKENIZER> {
        private static final /* synthetic */ TOKENIZER[] $VALUES = null;
        public static final TOKENIZER O_TOKENIZER_1 = null;
        public static final TOKENIZER O_TOKENIZER_2 = null;
        public static final TOKENIZER O_TOKENIZER_3_FOR_TEST = null;
        public static final TOKENIZER O_TOKENIZER_4_FOR_TEST = null;
        private final String sqlName;
        private final int typeCode;

        private static final /* synthetic */ TOKENIZER[] $values() {
            return new TOKENIZER[]{O_TOKENIZER_1, O_TOKENIZER_2, O_TOKENIZER_3_FOR_TEST, O_TOKENIZER_4_FOR_TEST};
        }

        public static TOKENIZER valueOf(String r1) {
            return (TOKENIZER) Enum.valueOf(TOKENIZER.class, r1);
        }

        public static TOKENIZER[] values() {
            return (TOKENIZER[]) $VALUES.clone();
        }

        private TOKENIZER(String r1, int r2, String r3, int r4) {
            super(r1, r2);
            this.sqlName = r3;
            this.typeCode = r4;
        }

        public final String getSqlName() {
            return this.sqlName;
        }

        public final int getTypeCode() {
            return this.typeCode;
        }

        static {
            O_TOKENIZER_1 = new TOKENIZER("O_TOKENIZER_1", 0, "OTokenizer1", 1);
            O_TOKENIZER_2 = new TOKENIZER("O_TOKENIZER_2", 1, "OTokenizer2", 2);
            O_TOKENIZER_3_FOR_TEST = new TOKENIZER("O_TOKENIZER_3_FOR_TEST", 2, "OTokenizer3", 1);
            O_TOKENIZER_4_FOR_TEST = new TOKENIZER("O_TOKENIZER_4_FOR_TEST", 3, "OTokenizer4", 2);
            $VALUES = $values();
        }
    }

    public FullTextSearchSchema(String r2, List<String> r3, TOKENIZER r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "schemaName");
        Intrinsics.checkNotNullParameter(r3, "columnList");
        Intrinsics.checkNotNullParameter(r4, "tokenizer");
        this.schemaName = r2;
        this.columnList = r3;
        this.tokenizer = r4;
        this.isContentLess = r5;
    }

    @Override // com.obric.search.api.schema.intf.ISearchEngineSchema
    public String getSchemaName() {
        return this.schemaName;
    }

    public final List<String> getColumnList() {
        return this.columnList;
    }

    public /* synthetic */ FullTextSearchSchema(String r1, List r2, TOKENIZER r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = TOKENIZER.O_TOKENIZER_1;
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = true;
    L8:
        this(r1, r2, r3, r4);
    }

    public final TOKENIZER getTokenizer() {
        return this.tokenizer;
    }

    public final boolean isContentLess() {
        return this.isContentLess;
    }

    @Override // com.obric.search.api.schema.intf.ISearchEngineSchema
    public ISearchEngineSchemaExecutor createExecutor(Context r2, ISearchEngineSchemaContext r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "schemaContext");
        if (this.isContentLess == false) goto L6;
        return new FullTextSearchSchemaExecutor(getSchemaName(), (FullTextSearchSchemaContext) r3, this.columnList);
    L6:
        return new NonContentLessFTSExecutor(getSchemaName(), (FullTextSearchSchemaContext) r3, this.columnList);
    }
}
