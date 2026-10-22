package com.obric.search.sdk.embedding.shema;

import android.net.Uri;
import com.android.settingslib.SliceBroadcastRelay;
import com.obric.aikernel.phx.sdk.api.IBaseModel;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.response.Response;
import com.obric.dejavu.library.DbInstance;
import com.obric.dejavu.library.DbObjResult;
import com.obric.dejavu.library.DbStatus;
import com.obric.search.api.document.intf.IDocument;
import com.obric.search.api.schema.impl.EmbeddingSearchTextSchemaExecutor;
import com.obric.search.common.log.RuntimeLogger;
import com.obric.search.sdk.embedding.document.IEmbeddingSearchImageDocument;
import com.obric.search.sdk.embedding.document.IEmbeddingSearchTextDocument;
import com.obric.search.sdk.embedding.exception.EmbeddingSearchException;
import com.obric.search.sdk.embedding.query.EmbeddingSearchQuery;
import com.obric.search.sdk.embedding.search.EmbeddingSearchSpec;
import com.obric.search.sdk.embedding.utils.ScriptModelLoadHelper;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: EmbeddingSearchTextImageSchemaExecutor.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\rJ>\u0010\u0013\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00170\u00160\u00150\u00150\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J2\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00142\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001dH\u0082@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b#\u0010$J\u0016\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(H\u0016J\b\u0010*\u001a\u00020+H\u0016R\u0014\u0010\u000e\u001a\u00020\u0003X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006,"}, d2 = {"Lcom/obric/search/sdk/embedding/shema/EmbeddingSearchTextImageSchemaExecutor;", "Lcom/obric/search/api/schema/impl/EmbeddingSearchTextSchemaExecutor;", "schemaName", "", "context", "Lcom/obric/search/sdk/embedding/shema/EmbeddingSearchSchemaContext;", "embeddingModel", "Lcom/obric/search/sdk/embedding/shema/EmbeddingSearchSchema$EMBEDDING_MODEL;", "indexMetricType", "Lcom/obric/search/sdk/embedding/shema/EmbeddingSearchSchema$INDEX_METRIC_TYPE;", "priority", "", "forceExecute", "(Ljava/lang/String;Lcom/obric/search/sdk/embedding/shema/EmbeddingSearchSchemaContext;Lcom/obric/search/sdk/embedding/shema/EmbeddingSearchSchema$EMBEDDING_MODEL;Lcom/obric/search/sdk/embedding/shema/EmbeddingSearchSchema$INDEX_METRIC_TYPE;II)V", "TAG", "getTAG", "()Ljava/lang/String;", "imageModelLoadHelper", "Lcom/obric/search/sdk/embedding/utils/ScriptModelLoadHelper;", "getDBResult", "Lkotlin/Result;", "", "Lkotlin/Pair;", "", "searchSpec", "Lcom/obric/search/sdk/embedding/search/EmbeddingSearchSpec;", "getDBResult-IoAF18A", "(Lcom/obric/search/sdk/embedding/search/EmbeddingSearchSpec;)Ljava/lang/Object;", "getImageEmbeddingModel", "Lcom/obric/aikernel/phx/sdk/api/IBaseModel;", "image2Vec", "", SliceBroadcastRelay.EXTRA_URI, "Landroid/net/Uri;", "model", "image2Vec-0E7RQCE", "(Landroid/net/Uri;Lcom/obric/aikernel/phx/sdk/api/IBaseModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putDocuments", "", "list", "", "Lcom/obric/search/api/document/intf/IDocument;", "triggerLoadModel", "", "embeddingPlugin_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EmbeddingSearchTextImageSchemaExecutor extends EmbeddingSearchTextSchemaExecutor {
    private final String TAG;
    private ScriptModelLoadHelper imageModelLoadHelper;

    /* JADX INFO: compiled from: EmbeddingSearchTextImageSchemaExecutor.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[EmbeddingSearchQuery.TYPE.values().length];
            r0[EmbeddingSearchQuery.TYPE.TEXT_QUERY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[EmbeddingSearchQuery.TYPE.IMAGE_QUERY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX INFO: renamed from: access$image2Vec-0E7RQCE, reason: not valid java name */
    public static final /* synthetic */ Object m1470access$image2Vec0E7RQCE(EmbeddingSearchTextImageSchemaExecutor r0, Uri r1, IBaseModel r2, Continuation r3) {
        return r0.m1472image2Vec0E7RQCE(r1, r2, r3);
    }

    /* JADX INFO: renamed from: access$word2Vec-0E7RQCE, reason: not valid java name */
    public static final /* synthetic */ Object m1471access$word2Vec0E7RQCE(EmbeddingSearchTextImageSchemaExecutor r0, String r1, IBaseModel r2, Continuation r3) {
        return r0.m1469word2Vec0E7RQCE(r1, r2, r3);
    }

    public EmbeddingSearchTextImageSchemaExecutor(String r2, EmbeddingSearchSchemaContext r3, EmbeddingSearchSchema.EMBEDDING_MODEL r4, EmbeddingSearchSchema.INDEX_METRIC_TYPE r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r2, "schemaName");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "embeddingModel");
        Intrinsics.checkNotNullParameter(r5, "indexMetricType");
        super(r2, r3, r4, r5, r6, r7);
        this.TAG = "EmbeddingSearchTextImageSchemaExecutor";
        this.imageModelLoadHelper = new ScriptModelLoadHelper(r4.getImageModelName());
    }

    @Override // com.obric.search.api.schema.impl.EmbeddingSearchTextSchemaExecutor
    protected String getTAG() {
        return this.TAG;
    }

    private final IBaseModel getImageEmbeddingModel() {
        return this.imageModelLoadHelper.getScriptModel(false);
    }

    @Override // com.obric.search.api.schema.impl.EmbeddingSearchTextSchemaExecutor
    public void triggerLoadModel() {
        super.triggerLoadModel();
        getImageEmbeddingModel();
    }

    /* JADX INFO: renamed from: image2Vec-0E7RQCE, reason: not valid java name */
    private final Object m1472image2Vec0E7RQCE(final Uri r5, IBaseModel r6, Continuation<? super Result<float[]>> r7) {
        if ((r7 instanceof EmbeddingSearchTextImageSchemaExecutor$image2Vec$1) == false) goto L7;
        EmbeddingSearchTextImageSchemaExecutor$image2Vec$1 r0 = (EmbeddingSearchTextImageSchemaExecutor$image2Vec$1) r7;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        final EmbeddingSearchTextImageSchemaExecutor this = (EmbeddingSearchTextImageSchemaExecutor) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L17:
        Response r9 = (Response) r8;
        if (r9 != null) goto L22;
        RuntimeLogger.INSTANCE.error(this.getTAG(), "image2Vec error! Res is null.");
        Result.Companion r4 = Result.Companion;
        return Result.m1508constructorimpl(ResultKt.createFailure(new EmbeddingSearchException(EmbeddingSearchException.AIK_MODEL_ERROR, "image2Vec error! Res is null.")));
    L22:
        if (r9.getErrorCode() == 0) goto L24;
    L30:
        RuntimeLogger.INSTANCE.error(this.getTAG(), "image2Vec error! Res: " + r9);
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
        RequestParams r13 = new RequestParams(null, new EmbeddingSearchTextImageSchemaExecutor$image2Vec$res$1(r5, this), 1, null);
        r0.L$0 = this;
        r0.label = 1;
        r8 = r6.infer(r13, r0);
        if (r8 != r1) goto L17;
        return r1;
    L7:
        r0 = new EmbeddingSearchTextImageSchemaExecutor$image2Vec$1(this, r7);
        goto L8
    }

    @Override // com.obric.search.api.schema.impl.EmbeddingSearchTextSchemaExecutor, com.obric.search.api.schema.intf.ISearchEngineSchemaExecutor
    public boolean putDocuments(List<? extends IDocument> r15) {
        Intrinsics.checkNotNullParameter(r15, "list");
        if (r15.isEmpty() == false) goto L5;
        return true;
    L5:
        DbInstance r0 = getDbInstance();
        if (r0 != null) goto L10;
        RuntimeLogger.INSTANCE.error(getTAG(), "putDocuments failed. db is null.");
        return false;
    L10:
        if ((r15.get(0) instanceof IEmbeddingSearchTextDocument) == false) goto L31;
        IBaseModel r13 = getTextEmbeddingModel();
        if (r13 != null) goto L15;
        RuntimeLogger.INSTANCE.error(getTAG(), "putDocuments failed. model is null.");
        return false;
    L15:
        Iterator<? extends IDocument> r16 = r15.iterator();
    L17:
        if (r16.hasNext() == false) goto L51;
        IDocument r2 = r16.next();
        if ((r2 instanceof IEmbeddingSearchTextDocument) == false) goto L20;
        float[] r4 = (float[]) BuildersKt.runBlocking(Dispatchers.getIO(), new EmbeddingSearchTextImageSchemaExecutor$putDocuments$vec$1(this, r2, r13, null));
        if (r4 == null) goto L24;
        DbStatus r3 = DbInstance.insert$default(r0, String.valueOf(r2.getId()), r4, null, false, 12, null);
        if (r3.getCode() == 0) goto L17;
        RuntimeLogger.INSTANCE.error(getTAG(), "putDocuments failed. db.insert error, message: " + r3.getMsg());
        return false;
    L24:
        RuntimeLogger.INSTANCE.error(getTAG(), "putDocuments failed. word2Vec error!");
        return false;
    L20:
        RuntimeLogger.INSTANCE.error(getTAG(), "putDocuments failed. Document type error!");
        return false;
    L51:
        return true;
    L31:
        if ((r15.get(0) instanceof IEmbeddingSearchImageDocument) == false) goto L52;
        IBaseModel r14 = getImageEmbeddingModel();
        if (r14 != null) goto L36;
        RuntimeLogger.INSTANCE.error(getTAG(), "putDocuments failed. model is null.");
        return false;
    L36:
        Iterator<? extends IDocument> r17 = r15.iterator();
    L38:
        if (r17.hasNext() == false) goto L51;
        IDocument r5 = r17.next();
        if ((r5 instanceof IEmbeddingSearchImageDocument) == false) goto L41;
        float[] r6 = (float[]) BuildersKt.runBlocking(Dispatchers.getIO(), new EmbeddingSearchTextImageSchemaExecutor$putDocuments$vec$2(r5, this, r14, null));
        if (r6 == null) goto L45;
        DbStatus r7 = DbInstance.insert$default(r0, String.valueOf(r5.getId()), r6, null, false, 12, null);
        if (r7.getCode() == 0) goto L38;
        RuntimeLogger.INSTANCE.error(getTAG(), "putDocuments failed. db.insert error, message: " + r7.getMsg());
        return false;
    L45:
        RuntimeLogger.INSTANCE.error(getTAG(), "putDocuments failed. image2Vec error!");
        return false;
    L41:
        RuntimeLogger.INSTANCE.error(getTAG(), "putDocuments failed. Document type error!");
        return false;
    L52:
        RuntimeLogger.INSTANCE.error(getTAG(), "putDocuments failed. Document type error!");
        return false;
    }

    @Override // com.obric.search.api.schema.impl.EmbeddingSearchTextSchemaExecutor
    /* JADX INFO: renamed from: getDBResult-IoAF18A */
    public Object mo1467getDBResultIoAF18A(EmbeddingSearchSpec r9) {
        Intrinsics.checkNotNullParameter(r9, "searchSpec");
        DbInstance r1 = getDbInstance();
        if (r1 != null) goto L6;
        RuntimeLogger.INSTANCE.error(getTAG(), "getDBResult failed. db is null.");
        Result.Companion r8 = Result.Companion;
        return Result.m1508constructorimpl(ResultKt.createFailure(new EmbeddingSearchException(EmbeddingSearchException.GET_DB_RESULT_ERROR, "Db is null!")));
    L6:
        int r2 = WhenMappings.$EnumSwitchMapping$0[r9.getQuery().getType().ordinal()];
        Object r6 = null;
        if (r2 != 1) goto L9;
        IBaseModel r3 = getTextEmbeddingModel();
        if (r3 != null) goto L31;
        RuntimeLogger.INSTANCE.error(getTAG(), "getDBResult failed. model is null.");
        Result.Companion r10 = Result.Companion;
        return Result.m1508constructorimpl(ResultKt.createFailure(new EmbeddingSearchException(EmbeddingSearchException.GET_DB_RESULT_ERROR, "Model is null!")));
    L31:
        Object r4 = ((Result) BuildersKt.runBlocking(Dispatchers.getIO(), new EmbeddingSearchTextImageSchemaExecutor$getDBResult$word2VecTemp$1(this, r9, r3, null))).m1517unboximpl();
        if (Result.m1514isFailureimpl(r4) == true) goto L35;
        r6 = r4;
    L35:
        float[] r7 = (float[]) r6;
        if (r7 != null) goto L42;
        Result.Companion r11 = Result.Companion;
        EmbeddingSearchException r12 = Result.m1511exceptionOrNullimpl(r4);
        if (r12 != null) goto L41;
        r12 = new EmbeddingSearchException(EmbeddingSearchException.GET_DB_RESULT_ERROR, "word2Vec error!");
    L41:
        return Result.m1508constructorimpl(ResultKt.createFailure(r12));
    L42:
        DbObjResult r13 = DbInstance.search$default(r1, new float[][]{r7}, r9.getLimit(), null, 4, null);
        Pair[][] r5 = (Pair[][]) r13.getData();
        if (r13.getStatus().getCode() != 0) goto L48;
        if (r5 == null) goto L48;
        Result.Companion r14 = Result.Companion;
        return Result.m1508constructorimpl(r5);
    L48:
        RuntimeLogger.INSTANCE.error(getTAG(), "getDBResult failed. db.search error, message: " + r13.getStatus().getMsg());
        Result.Companion r15 = Result.Companion;
        return Result.m1508constructorimpl(ResultKt.createFailure(new EmbeddingSearchException(EmbeddingSearchException.GET_DB_RESULT_ERROR, "db.search error, message: " + r13.getStatus().getMsg())));
    L9:
        if (r2 != 2) goto L26;
        IBaseModel r16 = getImageEmbeddingModel();
        if (r16 != null) goto L14;
        RuntimeLogger.INSTANCE.error(getTAG(), "getDBResult failed. model is null.");
        Result.Companion r17 = Result.Companion;
        return Result.m1508constructorimpl(ResultKt.createFailure(new EmbeddingSearchException(EmbeddingSearchException.GET_DB_RESULT_ERROR, "Model is null!")));
    L14:
        Object r18 = ((Result) BuildersKt.runBlocking(Dispatchers.getIO(), new EmbeddingSearchTextImageSchemaExecutor$getDBResult$image2VecTemp$1(this, r9, r16, null))).m1517unboximpl();
        if (Result.m1514isFailureimpl(r18) == true) goto L18;
        r6 = r18;
    L18:
        r7 = (float[]) r6;
        if (r7 != null) goto L42;
        Result.Companion r19 = Result.Companion;
        EmbeddingSearchException r20 = Result.m1511exceptionOrNullimpl(r18);
        if (r20 != null) goto L24;
        r20 = new EmbeddingSearchException(EmbeddingSearchException.GET_DB_RESULT_ERROR, "image2Vec error!");
    L24:
        return Result.m1508constructorimpl(ResultKt.createFailure(r20));
    L26:
        throw new NoWhenBranchMatchedException();
    }
}
