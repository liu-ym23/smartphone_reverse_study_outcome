package com.android.settingslib.media.session;

import android.media.session.MediaController;
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
import kotlinx.coroutines.channels.ProducerScope;

/* JADX INFO: compiled from: MediaSessionManagerExt.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.android.settingslib.media.session.MediaSessionManagerExtKt$activeMediaChanges$1$listener$1$1", f = "MediaSessionManagerExt.kt", i = {}, l = {36}, m = "invokeSuspend", n = {}, s = {})
final class MediaSessionManagerExtKt$activeMediaChanges$1$listener$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ProducerScope<List<MediaController>> $$this$callbackFlow;
    final /* synthetic */ List<MediaController> $it;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    MediaSessionManagerExtKt$activeMediaChanges$1$listener$1$1(ProducerScope<? super List<MediaController>> r1, List<MediaController> r2, Continuation<? super MediaSessionManagerExtKt$activeMediaChanges$1$listener$1$1> r3) {
        this.$$this$callbackFlow = r1;
        this.$it = r2;
        super(2, r3);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MediaSessionManagerExtKt$activeMediaChanges$1$listener$1$1(this.$$this$callbackFlow, this.$it, r3);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return invoke2(r1, r2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
        return ((MediaSessionManagerExtKt$activeMediaChanges$1$listener$1$1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        this.label = 1;
        if (this.$$this$callbackFlow.send(this.$it, this) != r0) goto L12;
        return r0;
    }
}
