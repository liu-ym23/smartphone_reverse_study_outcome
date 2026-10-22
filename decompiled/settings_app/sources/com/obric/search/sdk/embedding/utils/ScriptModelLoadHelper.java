package com.obric.search.sdk.embedding.utils;

import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.api.IBaseModel;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.search.common.log.RuntimeLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ScriptModelLoadHelper.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/obric/search/sdk/embedding/utils/ScriptModelLoadHelper;", "", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getScriptModel", "Lcom/obric/aikernel/phx/sdk/api/IBaseModel;", "useCloud", "", "Companion", "embeddingPlugin_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ScriptModelLoadHelper {
    public static final Companion Companion = null;
    private static final long LOAD_MODEL_TIME_OUT_MILLISECONDS = 30000;
    private static final String TAG = "ScriptModelLoadHelper";
    private final String name;

    /* JADX INFO: compiled from: ScriptModelLoadHelper.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/search/sdk/embedding/utils/ScriptModelLoadHelper$Companion;", "", "()V", "LOAD_MODEL_TIME_OUT_MILLISECONDS", "", "TAG", "", "embeddingPlugin_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.obric.search.sdk.embedding.utils.ScriptModelLoadHelper$getScriptModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: ScriptModelLoadHelper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/obric/aikernel/phx/sdk/api/IBaseModel;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.search.sdk.embedding.utils.ScriptModelLoadHelper$getScriptModel$1", f = "ScriptModelLoadHelper.kt", i = {}, l = {19}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super IBaseModel>, Object> {
        final /* synthetic */ boolean $useCloud;
        int label;
        final /* synthetic */ ScriptModelLoadHelper this$0;

        AnonymousClass1(ScriptModelLoadHelper r1, boolean r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$useCloud = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, this.$useCloud, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super IBaseModel> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super IBaseModel> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L11:
            return r8;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            RuntimeLogger.INSTANCE.info(ScriptModelLoadHelper.TAG, "getScriptModel start load script model.");
            this.label = 1;
            r8 = AIKernelManager.INSTANCE.loadPackage(this.this$0.getName(), this.$useCloud, new RequestParams(null, C00931.INSTANCE, 1, null), this);
            if (r8 != r0) goto L11;
            return r0;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ScriptModelLoadHelper(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        this.name = r2;
    }

    public final String getName() {
        return this.name;
    }

    public final IBaseModel getScriptModel(boolean r3) {
        return (IBaseModel) BuildersKt.runBlocking$default(null, new AnonymousClass1(this, r3, null), 1, null);
    }
}
