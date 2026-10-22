package com.android.settingslib.volume.domain.interactor;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: AudioVolumeInteractor.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.android.settingslib.volume.domain.interactor.AudioVolumeInteractor", f = "AudioVolumeInteractor.kt", i = {0, 0, 0, 1, 1, 1, 1, 1}, l = {51, 54, 56, 58}, m = "setVolume-ZdW0WiI", n = {"this", "audioStream", "volume", "this", "streamModel", "audioStream", "volume", "oldVolume"}, s = {"L$0", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1", "I$2"})
final class AudioVolumeInteractor$setVolume$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AudioVolumeInteractor this$0;

    AudioVolumeInteractor$setVolume$1(AudioVolumeInteractor r1, Continuation<? super AudioVolumeInteractor$setVolume$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m809setVolumeZdW0WiI(0, 0, this);
    }
}
