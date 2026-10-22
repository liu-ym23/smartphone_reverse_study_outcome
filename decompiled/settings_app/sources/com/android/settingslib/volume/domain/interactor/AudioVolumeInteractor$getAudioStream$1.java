package com.android.settingslib.volume.domain.interactor;

import com.android.settingslib.volume.shared.model.AudioStreamModel;
import com.android.settingslib.volume.shared.model.RingerMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: AudioVolumeInteractor.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u008a@"}, d2 = {"<anonymous>", "Lcom/android/settingslib/volume/shared/model/AudioStreamModel;", "streamModel", "ringerMode", "Lcom/android/settingslib/volume/shared/model/RingerMode;", "isZenMuted", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.android.settingslib.volume.domain.interactor.AudioVolumeInteractor$getAudioStream$1", f = "AudioVolumeInteractor.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
final class AudioVolumeInteractor$getAudioStream$1 extends SuspendLambda implements Function4<AudioStreamModel, RingerMode, Boolean, Continuation<? super AudioStreamModel>, Object> {
    /* synthetic */ int I$0;
    /* synthetic */ Object L$0;
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ AudioVolumeInteractor this$0;

    AudioVolumeInteractor$getAudioStream$1(AudioVolumeInteractor r1, Continuation<? super AudioVolumeInteractor$getAudioStream$1> r2) {
        this.this$0 = r1;
        super(4, r2);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(AudioStreamModel r1, RingerMode r2, Boolean r3, Continuation<? super AudioStreamModel> r4) {
        return m810invokeL0tBgz0(r1, r2.m835unboximpl(), r3.booleanValue(), r4);
    }

    /* JADX INFO: renamed from: invoke-L0tBgz0, reason: not valid java name */
    public final Object m810invokeL0tBgz0(AudioStreamModel r2, int r3, boolean r4, Continuation<? super AudioStreamModel> r5) {
        AudioVolumeInteractor$getAudioStream$1 r0 = new AudioVolumeInteractor$getAudioStream$1(this.this$0, r5);
        r0.L$0 = r2;
        r0.I$0 = r3;
        r0.Z$0 = r4;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        int r3 = this.I$0;
        AudioStreamModel r0 = (AudioStreamModel) this.L$0;
        ResultKt.throwOnFailure(r12);
        int r4 = r3;
        AudioStreamModel r5 = r0;
        Object r6 = r12;
    L13:
        return AudioStreamModel.m825copygJrEJJU$default(r5, r4, ((Number) r6).intValue(), 0, 0, false, false, false, 125, null);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        AudioStreamModel r7 = (AudioStreamModel) this.L$0;
        int r8 = this.I$0;
        boolean r9 = this.Z$0;
        this.L$0 = r7;
        this.I$0 = 0;
        this.label = 1;
        r6 = AudioVolumeInteractor.m804access$processVolumeL0tBgz0(this.this$0, r7, r8, r9, this);
        if (r6 != r1) goto L11;
        return r1;
    L11:
        r5 = r7;
        r4 = 0;
        goto L13
    }
}
