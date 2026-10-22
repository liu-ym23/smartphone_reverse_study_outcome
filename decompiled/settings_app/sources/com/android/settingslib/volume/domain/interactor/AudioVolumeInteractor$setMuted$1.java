package com.android.settingslib.volume.domain.interactor;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: AudioVolumeInteractor.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.android.settingslib.volume.domain.interactor.AudioVolumeInteractor", f = "AudioVolumeInteractor.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3}, l = {64, 71, 73, 75, 79}, m = "setMuted-ZdW0WiI", n = {"this", "audioStream", "isMuted", "this", "audioStream", "isMuted", "this", "audioStream", "isMuted", "this", "audioStream"}, s = {"L$0", "I$0", "Z$0", "L$0", "I$0", "Z$0", "L$0", "I$0", "Z$0", "L$0", "I$0"})
final class AudioVolumeInteractor$setMuted$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AudioVolumeInteractor this$0;

    AudioVolumeInteractor$setMuted$1(AudioVolumeInteractor r1, Continuation<? super AudioVolumeInteractor$setMuted$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m808setMutedZdW0WiI(0, false, this);
    }
}
