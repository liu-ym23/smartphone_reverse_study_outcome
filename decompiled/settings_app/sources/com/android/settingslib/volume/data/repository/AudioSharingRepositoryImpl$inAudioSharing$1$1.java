package com.android.settingslib.volume.data.repository;

import android.bluetooth.BluetoothLeBroadcast;
import com.android.internal.util.ConcurrentUtils;
import com.android.settingslib.bluetooth.LocalBluetoothLeBroadcast;
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

/* JADX INFO: compiled from: AudioSharingRepository.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.android.settingslib.volume.data.repository.AudioSharingRepositoryImpl$inAudioSharing$1$1", f = "AudioSharingRepository.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
final class AudioSharingRepositoryImpl$inAudioSharing$1$1 extends SuspendLambda implements Function2<ProducerScope<? super Boolean>, Continuation<? super Unit>, Object> {
    final /* synthetic */ LocalBluetoothLeBroadcast $leBroadcast;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AudioSharingRepositoryImpl this$0;

    AudioSharingRepositoryImpl$inAudioSharing$1$1(LocalBluetoothLeBroadcast r1, AudioSharingRepositoryImpl r2, Continuation<? super AudioSharingRepositoryImpl$inAudioSharing$1$1> r3) {
        this.$leBroadcast = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        AudioSharingRepositoryImpl$inAudioSharing$1$1 r0 = new AudioSharingRepositoryImpl$inAudioSharing$1$1(this.$leBroadcast, this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(ProducerScope<? super Boolean> r1, Continuation<? super Unit> r2) {
        return invoke2(r1, r2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(ProducerScope<? super Boolean> r1, Continuation<? super Unit> r2) {
        return ((AudioSharingRepositoryImpl$inAudioSharing$1$1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.android.settingslib.volume.data.repository.AudioSharingRepositoryImpl$inAudioSharing$1$1$listener$1] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        final ProducerScope r8 = (ProducerScope) this.L$0;
        final AudioSharingRepositoryImpl r3 = this.this$0;
        final ?? r2 = new AudioSharingRepositoryImpl$inAudioSharing$1$1$listener$1(r8, r3);
        this.$leBroadcast.registerServiceCallBack(ConcurrentUtils.DIRECT_EXECUTOR, (BluetoothLeBroadcast.Callback) r2);
        final LocalBluetoothLeBroadcast r4 = this.$leBroadcast;
        this.label = 1;
        if (ProduceKt.awaitClose(r8, new AnonymousClass1(r4, r2), this) != r0) goto L12;
        return r0;
    }
}
