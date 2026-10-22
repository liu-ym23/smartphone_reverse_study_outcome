package com.android.settingslib.volume.data.repository;

import com.android.settingslib.media.LocalMediaManager;
import com.android.settingslib.media.flags.Flags;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;

/* JADX INFO: compiled from: LocalMediaRepository.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/android/settingslib/volume/data/repository/LocalMediaRepositoryImpl$DevicesUpdate;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.android.settingslib.volume.data.repository.LocalMediaRepositoryImpl$mediaDevicesUpdates$1", f = "LocalMediaRepository.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
final class LocalMediaRepositoryImpl$mediaDevicesUpdates$1 extends SuspendLambda implements Function2<ProducerScope<? super LocalMediaRepositoryImpl.DevicesUpdate>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ LocalMediaRepositoryImpl this$0;

    LocalMediaRepositoryImpl$mediaDevicesUpdates$1(LocalMediaRepositoryImpl r1, Continuation<? super LocalMediaRepositoryImpl$mediaDevicesUpdates$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        LocalMediaRepositoryImpl$mediaDevicesUpdates$1 r0 = new LocalMediaRepositoryImpl$mediaDevicesUpdates$1(this.this$0, r3);
        r0.L$0 = r2;
        return r0;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(ProducerScope<? super LocalMediaRepositoryImpl.DevicesUpdate> r1, Continuation<? super Unit> r2) {
        return invoke2(r1, r2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(ProducerScope<? super LocalMediaRepositoryImpl.DevicesUpdate> r1, Continuation<? super Unit> r2) {
        return ((LocalMediaRepositoryImpl$mediaDevicesUpdates$1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.android.settingslib.volume.data.repository.LocalMediaRepositoryImpl$mediaDevicesUpdates$1$callback$1] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        final ProducerScope r7 = (ProducerScope) this.L$0;
        final ?? r2 = new LocalMediaRepositoryImpl$mediaDevicesUpdates$1$callback$1(r7);
        LocalMediaRepositoryImpl.access$getLocalMediaManager$p(this.this$0).registerCallback((LocalMediaManager.DeviceCallback) r2);
        if (Flags.removeUnnecessaryRouteScanning() == true) goto L11;
        LocalMediaRepositoryImpl.access$getLocalMediaManager$p(this.this$0).startScan();
    L11:
        final LocalMediaRepositoryImpl r4 = this.this$0;
        this.label = 1;
        if (ProduceKt.awaitClose(r7, new AnonymousClass1(r4, r2), this) != r0) goto L15;
        return r0;
    }
}
