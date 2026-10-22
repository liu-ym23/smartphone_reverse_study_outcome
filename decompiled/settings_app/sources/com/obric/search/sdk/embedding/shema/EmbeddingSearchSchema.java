package com.obric.search.sdk.embedding.shema;

import android.content.Context;
import com.obric.search.api.schema.impl.EmbeddingSearchTextSchemaExecutor;
import com.obric.search.api.schema.intf.ISearchEngineSchema;
import com.obric.search.api.schema.intf.ISearchEngineSchemaContext;
import com.obric.search.api.schema.intf.ISearchEngineSchemaExecutor;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EmbeddingSearchSchema.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u001b\u001cB3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001d"}, d2 = {"Lcom/obric/search/sdk/embedding/shema/EmbeddingSearchSchema;", "Lcom/obric/search/api/schema/intf/ISearchEngineSchema;", "schemaName", "", "embeddingModel", "Lcom/obric/search/sdk/embedding/shema/EmbeddingSearchSchema$EMBEDDING_MODEL;", "indexMetricType", "Lcom/obric/search/sdk/embedding/shema/EmbeddingSearchSchema$INDEX_METRIC_TYPE;", "priority", "", "forceExecute", "(Ljava/lang/String;Lcom/obric/search/sdk/embedding/shema/EmbeddingSearchSchema$EMBEDDING_MODEL;Lcom/obric/search/sdk/embedding/shema/EmbeddingSearchSchema$INDEX_METRIC_TYPE;II)V", "getEmbeddingModel", "()Lcom/obric/search/sdk/embedding/shema/EmbeddingSearchSchema$EMBEDDING_MODEL;", "getForceExecute", "()I", "getIndexMetricType", "()Lcom/obric/search/sdk/embedding/shema/EmbeddingSearchSchema$INDEX_METRIC_TYPE;", "getPriority", "getSchemaName", "()Ljava/lang/String;", "createExecutor", "Lcom/obric/search/api/schema/intf/ISearchEngineSchemaExecutor;", "context", "Landroid/content/Context;", "schemaContext", "Lcom/obric/search/api/schema/intf/ISearchEngineSchemaContext;", "EMBEDDING_MODEL", "INDEX_METRIC_TYPE", "embeddingPlugin_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EmbeddingSearchSchema implements ISearchEngineSchema {
    private final EMBEDDING_MODEL embeddingModel;
    private final int forceExecute;
    private final INDEX_METRIC_TYPE indexMetricType;
    private final int priority;
    private final String schemaName;

    /* JADX INFO: compiled from: EmbeddingSearchSchema.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/obric/search/sdk/embedding/shema/EmbeddingSearchSchema$EMBEDDING_MODEL;", "", "textModelName", "", "imageModelName", "dims", "", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;I)V", "getDims", "()I", "getImageModelName", "()Ljava/lang/String;", "getTextModelName", "CLIP_FP32", "MEMORY_TEXT_EMBEDDING_V2", "embeddingPlugin_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final enum EMBEDDING_MODEL extends Enum<EMBEDDING_MODEL> {
        private static final /* synthetic */ EMBEDDING_MODEL[] $VALUES = null;
        public static final EMBEDDING_MODEL CLIP_FP32 = null;
        public static final EMBEDDING_MODEL MEMORY_TEXT_EMBEDDING_V2 = null;
        private final int dims;
        private final String imageModelName;
        private final String textModelName;

        private static final /* synthetic */ EMBEDDING_MODEL[] $values() {
            return new EMBEDDING_MODEL[]{CLIP_FP32, MEMORY_TEXT_EMBEDDING_V2};
        }

        public static EMBEDDING_MODEL valueOf(String r1) {
            return (EMBEDDING_MODEL) Enum.valueOf(EMBEDDING_MODEL.class, r1);
        }

        public static EMBEDDING_MODEL[] values() {
            return (EMBEDDING_MODEL[]) $VALUES.clone();
        }

        private EMBEDDING_MODEL(String r1, int r2, String r3, String r4, int r5) {
            super(r1, r2);
            this.textModelName = r3;
            this.imageModelName = r4;
            this.dims = r5;
        }

        public final String getTextModelName() {
            return this.textModelName;
        }

        public final String getImageModelName() {
            return this.imageModelName;
        }

        public final int getDims() {
            return this.dims;
        }

        static {
            CLIP_FP32 = new EMBEDDING_MODEL("CLIP_FP32", 0, "clip_text_embedding_v2_edge", "clip_image_embedding_v2_edge", 512);
            MEMORY_TEXT_EMBEDDING_V2 = new EMBEDDING_MODEL("MEMORY_TEXT_EMBEDDING_V2", 1, "memory_text_embedding_v2", "", 768);
            $VALUES = $values();
        }
    }

    /* JADX INFO: compiled from: EmbeddingSearchSchema.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/search/sdk/embedding/shema/EmbeddingSearchSchema$INDEX_METRIC_TYPE;", "", "(Ljava/lang/String;I)V", "INNER_PRODUCT", "L2", "embeddingPlugin_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final enum INDEX_METRIC_TYPE extends Enum<INDEX_METRIC_TYPE> {
        private static final /* synthetic */ INDEX_METRIC_TYPE[] $VALUES = null;
        public static final INDEX_METRIC_TYPE INNER_PRODUCT = null;
        public static final INDEX_METRIC_TYPE L2 = null;

        private static final /* synthetic */ INDEX_METRIC_TYPE[] $values() {
            return new INDEX_METRIC_TYPE[]{INNER_PRODUCT, L2};
        }

        public static INDEX_METRIC_TYPE valueOf(String r1) {
            return (INDEX_METRIC_TYPE) Enum.valueOf(INDEX_METRIC_TYPE.class, r1);
        }

        public static INDEX_METRIC_TYPE[] values() {
            return (INDEX_METRIC_TYPE[]) $VALUES.clone();
        }

        private INDEX_METRIC_TYPE(String r1, int r2) {
            super(r1, r2);
        }

        static {
            INNER_PRODUCT = new INDEX_METRIC_TYPE("INNER_PRODUCT", 0);
            L2 = new INDEX_METRIC_TYPE("L2", 1);
            $VALUES = $values();
        }
    }

    /* JADX INFO: compiled from: EmbeddingSearchSchema.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[EMBEDDING_MODEL.values().length];
            r0[EMBEDDING_MODEL.CLIP_FP32.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[EMBEDDING_MODEL.MEMORY_TEXT_EMBEDDING_V2.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public EmbeddingSearchSchema(String r2, EMBEDDING_MODEL r3, INDEX_METRIC_TYPE r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, "schemaName");
        Intrinsics.checkNotNullParameter(r3, "embeddingModel");
        Intrinsics.checkNotNullParameter(r4, "indexMetricType");
        this.schemaName = r2;
        this.embeddingModel = r3;
        this.indexMetricType = r4;
        this.priority = r5;
        this.forceExecute = r6;
    }

    @Override // com.obric.search.api.schema.intf.ISearchEngineSchema
    public String getSchemaName() {
        return this.schemaName;
    }

    public final EMBEDDING_MODEL getEmbeddingModel() {
        return this.embeddingModel;
    }

    public /* synthetic */ EmbeddingSearchSchema(String r7, EMBEDDING_MODEL r8, INDEX_METRIC_TYPE r9, int r10, int r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 4) == 0) goto L5;
        r9 = INDEX_METRIC_TYPE.INNER_PRODUCT;
    L5:
        INDEX_METRIC_TYPE r3 = r9;
        if ((r12 & 8) == 0) goto L8;
        int r4 = 0;
    L10:
        if ((r12 & 16) == 0) goto L12;
        int r5 = 0;
    L13:
        this(r7, r8, r3, r4, r5);
        return;
    L12:
        r5 = r11;
        goto L13
    L8:
        r4 = r10;
        goto L10
    }

    public final INDEX_METRIC_TYPE getIndexMetricType() {
        return this.indexMetricType;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final int getForceExecute() {
        return this.forceExecute;
    }

    @Override // com.obric.search.api.schema.intf.ISearchEngineSchema
    public ISearchEngineSchemaExecutor createExecutor(Context r10, ISearchEngineSchemaContext r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "schemaContext");
        EMBEDDING_MODEL r0 = this.embeddingModel;
        int r1 = WhenMappings.$EnumSwitchMapping$0[r0.ordinal()];
        if (r1 != 1) goto L5;
        EmbeddingSearchTextImageSchemaExecutor r2 = new EmbeddingSearchTextImageSchemaExecutor(getSchemaName(), (EmbeddingSearchSchemaContext) r11, this.embeddingModel, this.indexMetricType, this.priority, this.forceExecute);
    L10:
        r2.init(r10);
        return r2;
    L5:
        if (r1 != 2) goto L8;
        r2 = new EmbeddingSearchTextSchemaExecutor(getSchemaName(), (EmbeddingSearchSchemaContext) r11, this.embeddingModel, this.indexMetricType, this.priority, this.forceExecute);
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }
}
