package coil.intercept;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.icu.lang.UCharacter;
import coil.EventListener;
import coil.request.ImageRequest;
import coil.request.Options;
import coil.size.Size;
import coil.transform.Transformation;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: EngineInterceptor.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcoil/intercept/EngineInterceptor$ExecuteResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "coil.intercept.EngineInterceptor$transform$3", f = "EngineInterceptor.kt", i = {0, 0, 0}, l = {UCharacter.UnicodeBlock.ORNAMENTAL_DINGBATS_ID}, m = "invokeSuspend", n = {"$this$withContext", "$this$foldIndices$iv", "i$iv"}, s = {"L$0", "L$1", "I$0"})
final class EngineInterceptor$transform$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super EngineInterceptor.ExecuteResult>, Object> {
    final /* synthetic */ EventListener $eventListener;
    final /* synthetic */ Options $options;
    final /* synthetic */ ImageRequest $request;
    final /* synthetic */ EngineInterceptor.ExecuteResult $result;
    final /* synthetic */ List<Transformation> $transformations;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ EngineInterceptor this$0;

    /* JADX WARN: Multi-variable type inference failed */
    EngineInterceptor$transform$3(EngineInterceptor r1, EngineInterceptor.ExecuteResult r2, Options r3, List<? extends Transformation> r4, EventListener r5, ImageRequest r6, Continuation<? super EngineInterceptor$transform$3> r7) {
        this.this$0 = r1;
        this.$result = r2;
        this.$options = r3;
        this.$transformations = r4;
        this.$eventListener = r5;
        this.$request = r6;
        super(2, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        EngineInterceptor$transform$3 r8 = new EngineInterceptor$transform$3(this.this$0, this.$result, this.$options, this.$transformations, this.$eventListener, this.$request, r11);
        r8.L$0 = r10;
        return r8;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super EngineInterceptor.ExecuteResult> r2) {
        return invoke2(r1, r2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r1, Continuation<? super EngineInterceptor.ExecuteResult> r2) {
        return ((EngineInterceptor$transform$3) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0070 -> B:13:0x0073). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        int r2 = this.I$1;
        int r3 = this.I$0;
        Options r4 = (Options) this.L$2;
        List<Transformation> r5 = (List) this.L$1;
        CoroutineScope r6 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r11);
    L13:
        Bitmap r12 = (Bitmap) r11;
        CoroutineScopeKt.ensureActive(r6);
        r3 = r3 + 1;
    L9:
        if (r3 >= r2) goto L14;
        Transformation r7 = r5.get(r3);
        Size r8 = r4.getSize();
        this.L$0 = r6;
        this.L$1 = r5;
        this.L$2 = r4;
        this.I$0 = r3;
        this.I$1 = r2;
        this.label = 1;
        r11 = r7.transform(r12, r8, this);
        if (r11 != r0) goto L13;
        return r0;
    L14:
        this.$eventListener.transformEnd(this.$request, r12);
        return EngineInterceptor.ExecuteResult.copy$default(this.$result, new BitmapDrawable(this.$request.getContext().getResources(), r12), false, null, null, 14, null);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        CoroutineScope r13 = (CoroutineScope) this.L$0;
        Bitmap r9 = EngineInterceptor.access$convertDrawableToBitmap(this.this$0, this.$result.getDrawable(), this.$options, this.$transformations);
        this.$eventListener.transformStart(this.$request, r9);
        List<Transformation> r10 = this.$transformations;
        r4 = this.$options;
        r6 = r13;
        r12 = r9;
        r2 = r10.size();
        r5 = r10;
        r3 = 0;
        goto L9
    }
}
