package com.obric.search.api.schema.impl;

import android.content.Context;
import androidx.core.view.PointerIconCompat;
import com.obric.aikernel.phx.sdk.api.IBaseModel;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.response.Response;
import com.obric.dejavu.library.DbIndexConfig;
import com.obric.dejavu.library.DbInstance;
import com.obric.dejavu.library.DbObjResult;
import com.obric.dejavu.library.DbOptions;
import com.obric.dejavu.library.DbStatus;
import com.obric.dejavu.library.IndexMetricType;
import com.obric.search.api.OSearchEngine;
import com.obric.search.api.document.intf.IDocument;
import com.obric.search.api.remove.intf.IRemoveSpec;
import com.obric.search.api.schema.intf.ISearchEngineSchemaExecutor;
import com.obric.search.api.search.intf.ISearchSpec;
import com.obric.search.common.log.RuntimeLogger;
import com.obric.search.sdk.embedding.document.IEmbeddingSearchTextDocument;
import com.obric.search.sdk.embedding.exception.EmbeddingSearchException;
import com.obric.search.sdk.embedding.query.EmbeddingSearchQuery;
import com.obric.search.sdk.embedding.remove.EmbeddingSearchRemoveSpec;
import com.obric.search.sdk.embedding.search.EmbeddingSearchSpec;
import com.obric.search.sdk.embedding.search.IEmbeddingSearchFilter;
import com.obric.search.sdk.embedding.shema.EmbeddingSearchSchema;
import com.obric.search.sdk.embedding.shema.EmbeddingSearchSchemaContext;
import com.obric.search.sdk.embedding.utils.ScriptModelLoadHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: EmbeddingSearchTextSchemaExecutor.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\rJ>\u0010*\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020.0-0,0,0+2\u0006\u0010/\u001a\u000200H\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b1\u00102J\u0016\u00103\u001a\b\u0012\u0004\u0012\u000205042\u0006\u0010/\u001a\u000206H\u0016J \u00107\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u0002080-042\u0006\u0010/\u001a\u000206J6\u00109\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u0002080-040+2\u0006\u0010/\u001a\u000206ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b:\u0010;J\n\u0010<\u001a\u0004\u0018\u00010=H\u0004J\u000e\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AJ\u0016\u0010B\u001a\u00020 2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020D04H\u0016J\u0010\u0010E\u001a\u00020 2\u0006\u0010F\u001a\u00020GH\u0016J\b\u0010H\u001a\u00020?H\u0016J2\u0010I\u001a\b\u0012\u0004\u0012\u00020J0+2\u0006\u0010K\u001a\u00020\u00032\u0006\u0010L\u001a\u00020=H\u0084@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\bM\u0010NR\u0014\u0010\u000e\u001a\u00020\u0003X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0010R\u001a\u0010$\u001a\u00020%X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006O"}, d2 = {"Lcom/obric/search/api/schema/impl/EmbeddingSearchTextSchemaExecutor;", "Lcom/obric/search/api/schema/intf/ISearchEngineSchemaExecutor;", "schemaName", "", "context", "Lcom/obric/search/sdk/embedding/shema/EmbeddingSearchSchemaContext;", "embeddingModel", "Lcom/obric/search/sdk/embedding/shema/EmbeddingSearchSchema$EMBEDDING_MODEL;", "indexMetricType", "Lcom/obric/search/sdk/embedding/shema/EmbeddingSearchSchema$INDEX_METRIC_TYPE;", "priority", "", "forceExecute", "(Ljava/lang/String;Lcom/obric/search/sdk/embedding/shema/EmbeddingSearchSchemaContext;Lcom/obric/search/sdk/embedding/shema/EmbeddingSearchSchema$EMBEDDING_MODEL;Lcom/obric/search/sdk/embedding/shema/EmbeddingSearchSchema$INDEX_METRIC_TYPE;II)V", "TAG", "getTAG", "()Ljava/lang/String;", "getContext", "()Lcom/obric/search/sdk/embedding/shema/EmbeddingSearchSchemaContext;", "dbInstance", "Lcom/obric/dejavu/library/DbInstance;", "getDbInstance", "()Lcom/obric/dejavu/library/DbInstance;", "setDbInstance", "(Lcom/obric/dejavu/library/DbInstance;)V", "getEmbeddingModel", "()Lcom/obric/search/sdk/embedding/shema/EmbeddingSearchSchema$EMBEDDING_MODEL;", "getForceExecute", "()I", "getIndexMetricType", "()Lcom/obric/search/sdk/embedding/shema/EmbeddingSearchSchema$INDEX_METRIC_TYPE;", "isInitDone", "", "isInitStart", "getPriority", "getSchemaName", "textModelLoadHelper", "Lcom/obric/search/sdk/embedding/utils/ScriptModelLoadHelper;", "getTextModelLoadHelper", "()Lcom/obric/search/sdk/embedding/utils/ScriptModelLoadHelper;", "setTextModelLoadHelper", "(Lcom/obric/search/sdk/embedding/utils/ScriptModelLoadHelper;)V", "getDBResult", "Lkotlin/Result;", "", "Lkotlin/Pair;", "", "searchSpec", "Lcom/obric/search/sdk/embedding/search/EmbeddingSearchSpec;", "getDBResult-IoAF18A", "(Lcom/obric/search/sdk/embedding/search/EmbeddingSearchSpec;)Ljava/lang/Object;", "getDocumentsId", "", "", "Lcom/obric/search/api/search/intf/ISearchSpec;", "getDocumentsIdAndDistance", "", "getDocumentsIdAndDistanceAndStatus", "getDocumentsIdAndDistanceAndStatus-IoAF18A", "(Lcom/obric/search/api/search/intf/ISearchSpec;)Ljava/lang/Object;", "getTextEmbeddingModel", "Lcom/obric/aikernel/phx/sdk/api/IBaseModel;", "init", "", "appContext", "Landroid/content/Context;", "putDocuments", "list", "Lcom/obric/search/api/document/intf/IDocument;", "removeDocuments", "removeSpec", "Lcom/obric/search/api/remove/intf/IRemoveSpec;", "triggerLoadModel", "word2Vec", "", "string", "model", "word2Vec-0E7RQCE", "(Ljava/lang/String;Lcom/obric/aikernel/phx/sdk/api/IBaseModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "embeddingPlugin_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class EmbeddingSearchTextSchemaExecutor implements ISearchEngineSchemaExecutor {
    private final String TAG;
    private final EmbeddingSearchSchemaContext context;
    private DbInstance dbInstance;
    private final EmbeddingSearchSchema.EMBEDDING_MODEL embeddingModel;
    private final int forceExecute;
    private final EmbeddingSearchSchema.INDEX_METRIC_TYPE indexMetricType;
    private volatile boolean isInitDone;
    private volatile boolean isInitStart;
    private final int priority;
    private final String schemaName;
    private ScriptModelLoadHelper textModelLoadHelper;

    /* JADX INFO: compiled from: EmbeddingSearchTextSchemaExecutor.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[EmbeddingSearchSchema.INDEX_METRIC_TYPE.values().length];
            r0[EmbeddingSearchSchema.INDEX_METRIC_TYPE.INNER_PRODUCT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[EmbeddingSearchSchema.INDEX_METRIC_TYPE.L2.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public EmbeddingSearchTextSchemaExecutor(String r2, EmbeddingSearchSchemaContext r3, EmbeddingSearchSchema.EMBEDDING_MODEL r4, EmbeddingSearchSchema.INDEX_METRIC_TYPE r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r2, "schemaName");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "embeddingModel");
        Intrinsics.checkNotNullParameter(r5, "indexMetricType");
        this.schemaName = r2;
        this.context = r3;
        this.embeddingModel = r4;
        this.indexMetricType = r5;
        this.priority = r6;
        this.forceExecute = r7;
        this.TAG = "EmbeddingSearchTextSchemaExecutor";
        this.textModelLoadHelper = new ScriptModelLoadHelper(r4.getTextModelName());
    }

    public final String getSchemaName() {
        return this.schemaName;
    }

    public final EmbeddingSearchSchemaContext getContext() {
        return this.context;
    }

    public final EmbeddingSearchSchema.EMBEDDING_MODEL getEmbeddingModel() {
        return this.embeddingModel;
    }

    public final EmbeddingSearchSchema.INDEX_METRIC_TYPE getIndexMetricType() {
        return this.indexMetricType;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final int getForceExecute() {
        return this.forceExecute;
    }

    protected String getTAG() {
        return this.TAG;
    }

    protected final DbInstance getDbInstance() {
        return this.dbInstance;
    }

    protected final void setDbInstance(DbInstance r1) {
        this.dbInstance = r1;
    }

    protected final ScriptModelLoadHelper getTextModelLoadHelper() {
        return this.textModelLoadHelper;
    }

    protected final void setTextModelLoadHelper(ScriptModelLoadHelper r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.textModelLoadHelper = r2;
    }

    public final synchronized void init(Context r28) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r28, "appContext");     // Catch: Throwable -> L25
        if (this.isInitStart == false) goto L9;
        monitor-exit(this);
        return;
    L9:
        this.isInitStart = true;     // Catch: Throwable -> L25
        RuntimeLogger.INSTANCE.info(getTAG(), "[" + this.schemaName + "]init start!");     // Catch: Throwable -> L25
        int r3 = WhenMappings.$EnumSwitchMapping$0[this.indexMetricType.ordinal()];     // Catch: Throwable -> L25
        if (r3 != 1) goto L12;
        IndexMetricType r4 = IndexMetricType.InnerProduct;     // Catch: Throwable -> L25
    L17:
        DbObjResult<DbInstance> r5 = DbInstance.Companion.openDb(r28.getFilesDir().getAbsolutePath() + File.separator + OSearchEngine.DATABASE_NAME_PREFIX, new DbOptions(this.schemaName, this.embeddingModel.getDims(), true, false, 0, null, new DbIndexConfig(null, r4, 0, 0, 0, 0, 0, 0, 0, false, PointerIconCompat.TYPE_GRABBING, null), 56, null));     // Catch: Throwable -> L25
        if (r5.getStatus().getCode() == 0) goto L22;
        RuntimeLogger.INSTANCE.error(getTAG(), "Open db failed. Message: " + r5.getStatus().getMsg());     // Catch: Throwable -> L25
        monitor-exit(this);
        return;
    L22:
        this.dbInstance = r5.getData();     // Catch: Throwable -> L25
        this.isInitDone = true;     // Catch: Throwable -> L25
        RuntimeLogger.INSTANCE.info(getTAG(), "[" + this.schemaName + "]init done!");     // Catch: Throwable -> L25
        monitor-exit(this);
        return;
    L12:
        if (r3 != 2) goto L15;
        r4 = IndexMetricType.L2;     // Catch: Throwable -> L25
        goto L17
    L15:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }

    protected final IBaseModel getTextEmbeddingModel() {
        return this.textModelLoadHelper.getScriptModel(false);
    }

    public void triggerLoadModel() {
        getTextEmbeddingModel();
    }

    /* JADX INFO: renamed from: word2Vec-0E7RQCE, reason: not valid java name */
    protected final Object m1469word2Vec0E7RQCE(final String r5, IBaseModel r6, Continuation<? super Result<float[]>> r7) {
        if ((r7 instanceof EmbeddingSearchTextSchemaExecutor$word2Vec$1) == false) goto L7;
        EmbeddingSearchTextSchemaExecutor$word2Vec$1 r0 = (EmbeddingSearchTextSchemaExecutor$word2Vec$1) r7;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        final EmbeddingSearchTextSchemaExecutor this = (EmbeddingSearchTextSchemaExecutor) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L17:
        Response r9 = (Response) r8;
        if (r9 != null) goto L22;
        RuntimeLogger.INSTANCE.error(this.getTAG(), "word2Vec error! Res is null.");
        Result.Companion r4 = Result.Companion;
        return Result.m1508constructorimpl(ResultKt.createFailure(new EmbeddingSearchException(EmbeddingSearchException.AIK_MODEL_ERROR, "word2Vec error! Res is null.")));
    L22:
        if (r9.getErrorCode() == 0) goto L24;
    L30:
        RuntimeLogger.INSTANCE.error(this.getTAG(), "word2Vec error! Res: " + r9);
        Result.Companion r10 = Result.Companion;
        return Result.m1508constructorimpl(ResultKt.createFailure(new EmbeddingSearchException(r9.getErrorCode(), r9.getErrorInfo())));
    L24:
        if (r9.getData() == null) goto L30;
        if ((r9.getData() instanceof float[]) == false) goto L30;
        Result.Companion r11 = Result.Companion;
        Object r12 = r9.getData();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.FloatArray");
        return Result.m1508constructorimpl((float[]) r12);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        RequestParams r13 = new RequestParams(null, new EmbeddingSearchTextSchemaExecutor$word2Vec$res$1(r5, this), 1, null);
        r0.L$0 = this;
        r0.label = 1;
        r8 = r6.infer(r13, r0);
        if (r8 != r1) goto L17;
        return r1;
    L7:
        r0 = new EmbeddingSearchTextSchemaExecutor$word2Vec$1(this, r7);
        goto L8
    }

    @Override // com.obric.search.api.schema.intf.ISearchEngineSchemaExecutor
    public boolean putDocuments(List<? extends IDocument> r11) {
        Intrinsics.checkNotNullParameter(r11, "list");
        DbInstance r0 = this.dbInstance;
        if (r0 != null) goto L6;
        RuntimeLogger.INSTANCE.error(getTAG(), "putDocuments failed. db is null.");
        return false;
    L6:
        IBaseModel r9 = getTextEmbeddingModel();
        if (r9 != null) goto L10;
        RuntimeLogger.INSTANCE.error(getTAG(), "putDocuments failed. model is null.");
        return false;
    L10:
        Iterator<? extends IDocument> r12 = r11.iterator();
    L12:
        if (r12.hasNext() == false) goto L25;
        IDocument r1 = r12.next();
        if ((r1 instanceof IEmbeddingSearchTextDocument) == false) goto L15;
        float[] r3 = (float[]) BuildersKt.runBlocking(Dispatchers.getIO(), new EmbeddingSearchTextSchemaExecutor$putDocuments$vec$1(this, r1, r9, null));
        if (r3 == null) goto L19;
        DbStatus r2 = DbInstance.insert$default(r0, String.valueOf(r1.getId()), r3, null, false, 12, null);
        if (r2.getCode() == 0) goto L12;
        RuntimeLogger.INSTANCE.error(getTAG(), "putDocuments failed. db.insert error, message: " + r2.getMsg());
        return false;
    L19:
        RuntimeLogger.INSTANCE.error(getTAG(), "putDocuments failed. word2Vec error!");
        return false;
    L15:
        RuntimeLogger.INSTANCE.error(getTAG(), "putDocuments failed. Document type error!");
        return false;
    L25:
        return true;
    }

    /* JADX INFO: renamed from: getDBResult-IoAF18A, reason: not valid java name */
    public Object mo1467getDBResultIoAF18A(EmbeddingSearchSpec r8) {
        Intrinsics.checkNotNullParameter(r8, "searchSpec");
        if (r8.getQuery().getType() == EmbeddingSearchQuery.TYPE.TEXT_QUERY) goto L6;
        RuntimeLogger.INSTANCE.error(getTAG(), "getDBResult failed. Query type error!");
        Result.Companion r7 = Result.Companion;
        return Result.m1508constructorimpl(ResultKt.createFailure(new EmbeddingSearchException(EmbeddingSearchException.QUERY_TYPE_ERROR, "Query type error!")));
    L6:
        DbInstance r0 = this.dbInstance;
        if (r0 != null) goto L10;
        RuntimeLogger.INSTANCE.error(getTAG(), "getDBResult failed. db is null.");
        Result.Companion r9 = Result.Companion;
        return Result.m1508constructorimpl(ResultKt.createFailure(new EmbeddingSearchException(EmbeddingSearchException.GET_DB_RESULT_ERROR, "Db is null!")));
    L10:
        IBaseModel r1 = getTextEmbeddingModel();
        if (r1 != null) goto L14;
        RuntimeLogger.INSTANCE.error(getTAG(), "getDBResult failed. model is null.");
        Result.Companion r10 = Result.Companion;
        return Result.m1508constructorimpl(ResultKt.createFailure(new EmbeddingSearchException(EmbeddingSearchException.GET_DB_RESULT_ERROR, "Model is null!")));
    L14:
        Object r4 = null;
        Object r2 = ((Result) BuildersKt.runBlocking(Dispatchers.getIO(), new EmbeddingSearchTextSchemaExecutor$getDBResult$word2VecRes$1(this, r8, r1, null))).m1517unboximpl();
        if (Result.m1514isFailureimpl(r2) == true) goto L18;
        r4 = r2;
    L18:
        float[] r5 = (float[]) r4;
        if (r5 != null) goto L25;
        RuntimeLogger.INSTANCE.error(getTAG(), "getDBResult failed. word2Vec error!");
        Result.Companion r11 = Result.Companion;
        EmbeddingSearchException r12 = Result.m1511exceptionOrNullimpl(r2);
        if (r12 != null) goto L24;
        r12 = new EmbeddingSearchException(EmbeddingSearchException.GET_DB_RESULT_ERROR, "word2Vec error!");
    L24:
        return Result.m1508constructorimpl(ResultKt.createFailure(r12));
    L25:
        DbObjResult r13 = DbInstance.search$default(r0, new float[][]{r5}, r8.getLimit(), null, 4, null);
        Pair[][] r3 = (Pair[][]) r13.getData();
        if (r13.getStatus().getCode() != 0) goto L31;
        if (r3 == null) goto L31;
        Result.Companion r14 = Result.Companion;
        return Result.m1508constructorimpl(r3);
    L31:
        RuntimeLogger.INSTANCE.error(getTAG(), "getDBResult failed. db.search error, message: " + r13.getStatus().getMsg());
        Result.Companion r15 = Result.Companion;
        return Result.m1508constructorimpl(ResultKt.createFailure(new EmbeddingSearchException(EmbeddingSearchException.GET_DB_RESULT_ERROR, "db.search error, message: " + r13.getStatus().getMsg())));
    }

    @Override // com.obric.search.api.schema.intf.ISearchEngineSchemaExecutor
    public List<Long> getDocumentsId(ISearchSpec r3) {
        Intrinsics.checkNotNullParameter(r3, "searchSpec");
        List<Pair<Long, Double>> r2 = getDocumentsIdAndDistance(r3);
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r5 = r2.iterator();
    L4:
        if (r5.hasNext() == false) goto L7;
        r4.add(Long.valueOf(((Number) ((Pair) r5.next()).getFirst()).longValue()));
        goto L4
    L7:
        return r4;
    }

    public final List<Pair<Long, Double>> getDocumentsIdAndDistance(ISearchSpec r2) {
        Intrinsics.checkNotNullParameter(r2, "searchSpec");
        Object r1 = m1468getDocumentsIdAndDistanceAndStatusIoAF18A(r2);
        if (Result.m1514isFailureimpl(r1) == false) goto L5;
        r1 = null;
    L5:
        List<Pair<Long, Double>> r3 = (List) r1;
        if (r3 == null) goto L8;
        return r3;
    L8:
        return CollectionsKt.emptyList();
    }

    /* JADX INFO: renamed from: getDocumentsIdAndDistanceAndStatus-IoAF18A, reason: not valid java name */
    public final Object m1468getDocumentsIdAndDistanceAndStatusIoAF18A(ISearchSpec r9) {
        Intrinsics.checkNotNullParameter(r9, "searchSpec");
        if ((r9 instanceof EmbeddingSearchSpec) == true) goto L6;
        RuntimeLogger.INSTANCE.error(getTAG(), "getDocumentsIdAndDistance failed. SearchSpec type error!");
        Result.Companion r8 = Result.Companion;
        return Result.m1508constructorimpl(ResultKt.createFailure(new EmbeddingSearchException(EmbeddingSearchException.SEARCH_SPEC_TYPE_ERROR, "SearchSpec type error!")));
    L6:
        EmbeddingSearchSpec r10 = (EmbeddingSearchSpec) r9;
        Object r11 = mo1467getDBResultIoAF18A(r10);
        if (Result.m1514isFailureimpl(r11) == false) goto L9;
        Object r0 = null;
    L10:
        Pair[][] r1 = (Pair[][]) r0;
        if (r1 != null) goto L17;
        Result.Companion r12 = Result.Companion;
        EmbeddingSearchException r13 = Result.m1511exceptionOrNullimpl(r11);
        if (r13 != null) goto L16;
        r13 = new EmbeddingSearchException(EmbeddingSearchException.GET_DB_RESULT_ERROR, "getDBResult error!");
    L16:
        return Result.m1508constructorimpl(ResultKt.createFailure(r13));
    L17:
        ArrayList r14 = new ArrayList();
        int r3 = 0;
        if (r1.length != 0) goto L20;
        boolean r2 = true;
    L22:
        if ((!r2) == false) goto L31;
        Pair[] r4 = r1[0];
        int r5 = r4.length;
    L24:
        if (r3 >= r5) goto L31;
        Pair r6 = r4[r3];
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L28
        Result.m1508constructorimpl(Boolean.valueOf(r14.add(new Pair(Long.valueOf(Long.parseLong((String) r6.getFirst())), Double.valueOf(((Number) r6.getSecond()).floatValue())))));     // Catch: Throwable -> L28
    L30:
        r3 = r3 + 1;
    L28:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        Result.m1508constructorimpl(ResultKt.createFailure(th));
    L31:
        IEmbeddingSearchFilter r16 = r10.getFilter();
        if (r16 == null) goto L35;
        Result.Companion r17 = Result.Companion;
        return Result.m1508constructorimpl(r16.filter(r14));
    L35:
        Result.Companion r18 = Result.Companion;
        return Result.m1508constructorimpl(r14);
    L20:
        r2 = false;
        goto L22
    L9:
        r0 = r11;
        goto L10
    }

    @Override // com.obric.search.api.schema.intf.ISearchEngineSchemaExecutor
    public boolean removeDocuments(IRemoveSpec r7) {
        Intrinsics.checkNotNullParameter(r7, "removeSpec");
        if ((r7 instanceof EmbeddingSearchRemoveSpec) == true) goto L6;
        RuntimeLogger.INSTANCE.error(getTAG(), "removeDocuments failed. RemoveSpec type error!");
        return false;
    L6:
        DbInstance r0 = this.dbInstance;
        if (r0 != null) goto L10;
        RuntimeLogger.INSTANCE.error(getTAG(), "removeDocuments failed. db is null.");
        return false;
    L10:
        EmbeddingSearchRemoveSpec r8 = (EmbeddingSearchRemoveSpec) r7;
        if (r8.getRemoveAll() == false) goto L17;
        RuntimeLogger.INSTANCE.info(getTAG(), "removeDocuments remove all.");
        DbStatus r9 = r0.clear();
        if (r9.getCode() == 0) goto L16;
        RuntimeLogger.INSTANCE.error(getTAG(), "removeDocuments failed. db.removeAll error, message: " + r9.getMsg());
        return false;
    L16:
        return true;
    L17:
        Iterator<T> r10 = r8.getIdList().iterator();
    L19:
        if (r10.hasNext() == false) goto L24;
        DbStatus r2 = r0.remove(String.valueOf(((Number) r10.next()).longValue()));
        if (r2.getCode() == 0) goto L19;
        RuntimeLogger.INSTANCE.error(getTAG(), "removeDocuments failed. db.remove error, message: " + r2.getMsg());
        return false;
    L24:
        return true;
    }
}
