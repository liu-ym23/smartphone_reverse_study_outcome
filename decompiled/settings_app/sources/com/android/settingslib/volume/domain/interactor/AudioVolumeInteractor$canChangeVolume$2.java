package com.android.settingslib.volume.domain.interactor;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: AudioVolumeInteractor.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "", "isZenMuted", "isRingMuted"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.android.settingslib.volume.domain.interactor.AudioVolumeInteractor$canChangeVolume$2", f = "AudioVolumeInteractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AudioVolumeInteractor$canChangeVolume$2 extends SuspendLambda implements Function3<Boolean, Boolean, Continuation<? super Boolean>, Object> {
    /* synthetic */ boolean Z$0;
    /* synthetic */ boolean Z$1;
    int label;

    AudioVolumeInteractor$canChangeVolume$2(Continuation<? super AudioVolumeInteractor$canChangeVolume$2> r2) {
        super(3, r2);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Boolean r1, Boolean r2, Continuation<? super Boolean> r3) {
        return invoke(r1.booleanValue(), r2.booleanValue(), r3);
    }

    public final Object invoke(boolean r1, boolean r2, Continuation<? super Boolean> r3) {
        AudioVolumeInteractor$canChangeVolume$2 r0 = new AudioVolumeInteractor$canChangeVolume$2(r3);
        r0.Z$0 = r1;
        r0.Z$1 = r2;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r2);
        boolean r3 = this.Z$0;
        boolean r1 = this.Z$1;
        if (r3 == true) goto L8;
        if (r1 == true) goto L8;
        boolean r4 = true;
    L10:
        return Boxing.boxBoolean(r4);
    L8:
        r4 = false;
        goto L10
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
