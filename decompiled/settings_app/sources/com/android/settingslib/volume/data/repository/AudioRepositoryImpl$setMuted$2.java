package com.android.settingslib.volume.data.repository;

import android.media.AudioManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AudioRepository.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.android.settingslib.volume.data.repository.AudioRepositoryImpl$setMuted$2", f = "AudioRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AudioRepositoryImpl$setMuted$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ int $audioStream;
    final /* synthetic */ boolean $isMuted;
    int label;
    final /* synthetic */ AudioRepositoryImpl this$0;

    AudioRepositoryImpl$setMuted$2(boolean r1, AudioRepositoryImpl r2, int r3, Continuation<? super AudioRepositoryImpl$setMuted$2> r4) {
        this.$isMuted = r1;
        this.this$0 = r2;
        this.$audioStream = r3;
        super(2, r4);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new AudioRepositoryImpl$setMuted$2(this.$isMuted, this.this$0, this.$audioStream, r4);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return invoke2(r1, r2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return ((AudioRepositoryImpl$setMuted$2) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r3);
        boolean r1 = false;
        if (this.$isMuted == AudioRepositoryImpl.access$getAudioManager$p(this.this$0).isStreamMute(this.$audioStream)) goto L13;
        AudioManager r4 = AudioRepositoryImpl.access$getAudioManager$p(this.this$0);
        int r0 = this.$audioStream;
        if (this.$isMuted == false) goto L10;
        int r2 = -100;
    L11:
        r4.adjustStreamVolume(r0, r2, 0);
        r1 = true;
        goto L13
    L10:
        r2 = 100;
    L13:
        return Boxing.boxBoolean(r1);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
