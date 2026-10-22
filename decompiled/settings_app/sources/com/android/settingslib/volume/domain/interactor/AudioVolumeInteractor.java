package com.android.settingslib.volume.domain.interactor;

import com.android.settingslib.statusbar.notification.domain.interactor.NotificationsSoundPolicyInteractor;
import com.android.settingslib.volume.data.repository.AudioRepository;
import com.android.settingslib.volume.shared.model.AudioStream;
import com.android.settingslib.volume.shared.model.AudioStreamModel;
import com.android.settingslib.volume.shared.model.RingerMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: AudioVolumeInteractor.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\r2\u0006\u0010\u000f\u001a\u00020\u0010ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0012J1\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u000eH\u0082@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ)\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u000eH\u0086@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J)\u0010!\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u0017H\u0086@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b#\u0010$R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006%"}, d2 = {"Lcom/android/settingslib/volume/domain/interactor/AudioVolumeInteractor;", "", "audioRepository", "Lcom/android/settingslib/volume/data/repository/AudioRepository;", "notificationsSoundPolicyInteractor", "Lcom/android/settingslib/statusbar/notification/domain/interactor/NotificationsSoundPolicyInteractor;", "(Lcom/android/settingslib/volume/data/repository/AudioRepository;Lcom/android/settingslib/statusbar/notification/domain/interactor/NotificationsSoundPolicyInteractor;)V", "ringerMode", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/android/settingslib/volume/shared/model/RingerMode;", "getRingerMode", "()Lkotlinx/coroutines/flow/StateFlow;", "canChangeVolume", "Lkotlinx/coroutines/flow/Flow;", "", "audioStream", "Lcom/android/settingslib/volume/shared/model/AudioStream;", "canChangeVolume-tLTdkI8", "(I)Lkotlinx/coroutines/flow/Flow;", "getAudioStream", "Lcom/android/settingslib/volume/shared/model/AudioStreamModel;", "getAudioStream-tLTdkI8", "processVolume", "", "audioStreamModel", "isZenMuted", "processVolume-L0tBgz0", "(Lcom/android/settingslib/volume/shared/model/AudioStreamModel;IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setMuted", "", "isMuted", "setMuted-ZdW0WiI", "(IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setVolume", "volume", "setVolume-ZdW0WiI", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AudioVolumeInteractor {
    private final AudioRepository audioRepository;
    private final NotificationsSoundPolicyInteractor notificationsSoundPolicyInteractor;

    public AudioVolumeInteractor(AudioRepository r2, NotificationsSoundPolicyInteractor r3) {
        Intrinsics.checkNotNullParameter(r2, "audioRepository");
        Intrinsics.checkNotNullParameter(r3, "notificationsSoundPolicyInteractor");
        this.audioRepository = r2;
        this.notificationsSoundPolicyInteractor = r3;
    }

    /* JADX INFO: renamed from: access$processVolume-L0tBgz0, reason: not valid java name */
    public static final /* synthetic */ Object m804access$processVolumeL0tBgz0(AudioVolumeInteractor r0, AudioStreamModel r1, int r2, boolean r3, Continuation r4) {
        return r0.m805processVolumeL0tBgz0(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: getAudioStream-tLTdkI8, reason: not valid java name */
    public final Flow<AudioStreamModel> m807getAudioStreamtLTdkI8(int r5) {
        return FlowKt.combine(this.audioRepository.mo795getAudioStreamtLTdkI8(r5), this.audioRepository.getRingerMode(), this.notificationsSoundPolicyInteractor.m780isZenMutedtLTdkI8(r5), new AudioVolumeInteractor$getAudioStream$1(this, null));
    }

    public final StateFlow<RingerMode> getRingerMode() {
        return this.audioRepository.getRingerMode();
    }

    /* JADX INFO: renamed from: setVolume-ZdW0WiI, reason: not valid java name */
    public final Object m809setVolumeZdW0WiI(int r10, int r11, Continuation<? super Unit> r12) {
        if ((r12 instanceof AudioVolumeInteractor$setVolume$1) == false) goto L7;
        AudioVolumeInteractor$setVolume$1 r0 = (AudioVolumeInteractor$setVolume$1) r12;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L20;
        if (r2 == 1) goto L19;
        if (r2 == 2) goto L18;
        if (r2 == 3) goto L17;
        if (r2 != 4) goto L16;
        ResultKt.throwOnFailure(r13);
    L44:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r13);
    L35:
        return Unit.INSTANCE;
    L18:
        int r9 = r0.I$2;
        int r14 = r0.I$1;
        int r15 = r0.I$0;
        AudioStreamModel r3 = (AudioStreamModel) r0.L$1;
        AudioVolumeInteractor r5 = (AudioVolumeInteractor) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L30:
        if (r14 != r3.getMinVolume()) goto L37;
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 3;
        if (r5.m808setMutedZdW0WiI(r15, true, r0) != r1) goto L35;
        return r1;
    L37:
        if (r9 != r3.getMinVolume()) goto L46;
        if (r14 <= r3.getMinVolume()) goto L46;
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 4;
        if (r5.m808setMutedZdW0WiI(r15, false, r0) != r1) goto L44;
        return r1;
    L46:
        return Unit.INSTANCE;
    L19:
        r11 = r0.I$1;
        r10 = r0.I$0;
        AudioVolumeInteractor this = (AudioVolumeInteractor) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L23:
        r3 = (AudioStreamModel) r13;
        int r16 = r3.getVolume();
        if (r11 == r16) goto L46;
        AudioRepository r7 = this.audioRepository;
        r0.L$0 = this;
        r0.L$1 = r3;
        r0.I$0 = r10;
        r0.I$1 = r11;
        r0.I$2 = r16;
        r0.label = 2;
        if (r7.mo799setVolumeZdW0WiI(r10, r11, r0) != r1) goto L28;
        return r1;
    L28:
        r5 = this;
        r9 = r16;
        int r8 = r11;
        r15 = r10;
        r14 = r8;
        goto L30
    L20:
        ResultKt.throwOnFailure(r13);
        Flow<AudioStreamModel> r17 = m807getAudioStreamtLTdkI8(r10);
        r0.L$0 = this;
        r0.I$0 = r10;
        r0.I$1 = r11;
        r0.label = 1;
        r13 = FlowKt.first(r17, r0);
        if (r13 != r1) goto L23;
        return r1;
    L7:
        r0 = new AudioVolumeInteractor$setVolume$1(this, r12);
        goto L8
    }

    /* JADX INFO: renamed from: setMuted-ZdW0WiI, reason: not valid java name */
    public final Object m808setMutedZdW0WiI(int r10, boolean r11, Continuation<? super Unit> r12) {
        if ((r12 instanceof AudioVolumeInteractor$setMuted$1) == false) goto L7;
        AudioVolumeInteractor$setMuted$1 r0 = (AudioVolumeInteractor$setMuted$1) r12;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L22;
        if (r2 == 1) goto L21;
        if (r2 == 2) goto L20;
        if (r2 == 3) goto L19;
        if (r2 == 4) goto L18;
        if (r2 != 5) goto L17;
        ResultKt.throwOnFailure(r13);
    L55:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        int r9 = r0.I$0;
        AudioVolumeInteractor r14 = (AudioVolumeInteractor) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L49:
        AudioStreamModel r15 = (AudioStreamModel) r13;
        if (r15.getVolume() != r15.getMinVolume()) goto L55;
        int r16 = r15.getVolume() + 1;
        r0.L$0 = null;
        r0.label = 5;
        if (r14.m809setVolumeZdW0WiI(r9, r16, r0) != r1) goto L55;
        return r1;
    L19:
        boolean r17 = r0.Z$0;
        r10 = r0.I$0;
        AudioVolumeInteractor r18 = (AudioVolumeInteractor) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L43:
        if (((Boolean) r13).booleanValue() == false) goto L55;
        if (r17 == true) goto L55;
        Flow<AudioStreamModel> r19 = r18.m807getAudioStreamtLTdkI8(r10);
        r0.L$0 = r18;
        r0.I$0 = r10;
        r0.label = 4;
        r13 = FlowKt.first(r19, r0);
        if (r13 != r1) goto L48;
        return r1;
    L48:
        r9 = r10;
        r14 = r18;
        goto L49
    L20:
        boolean r20 = r0.Z$0;
        r10 = r0.I$0;
        AudioVolumeInteractor r110 = (AudioVolumeInteractor) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L37:
        AudioVolumeInteractor r8 = r110;
        r11 = r20;
        AudioVolumeInteractor this = r8;
    L38:
        AudioRepository r111 = this.audioRepository;
        r0.L$0 = this;
        r0.I$0 = r10;
        r0.Z$0 = r11;
        r0.label = 3;
        r13 = r111.mo797setMutedZdW0WiI(r10, r11, r0);
        if (r13 != r1) goto L41;
        return r1;
    L41:
        boolean r21 = r11;
        r18 = this;
        r17 = r21;
        goto L43
    L21:
        r11 = r0.Z$0;
        r10 = r0.I$0;
        this = (AudioVolumeInteractor) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L26:
        if (((AudioStreamModel) r13).isAffectedByMute() == false) goto L28;
        if (r10 != 2) goto L38;
        if (r11 == false) goto L32;
        int r112 = 1;
    L33:
        AudioRepository r3 = this.audioRepository;
        int r113 = RingerMode.m830constructorimpl(r112);
        r0.L$0 = this;
        r0.I$0 = r10;
        r0.Z$0 = r11;
        r0.label = 2;
        if (r3.mo798setRingerMode2JRsiQU(r10, r113, r0) != r1) goto L36;
        return r1;
    L36:
        boolean r22 = r11;
        r110 = this;
        r20 = r22;
        goto L37
    L32:
        r112 = 2;
        goto L33
    L28:
        return Unit.INSTANCE;
    L22:
        ResultKt.throwOnFailure(r13);
        Flow<AudioStreamModel> r114 = m807getAudioStreamtLTdkI8(r10);
        r0.L$0 = this;
        r0.I$0 = r10;
        r0.Z$0 = r11;
        r0.label = 1;
        r13 = FlowKt.first(r114, r0);
        if (r13 != r1) goto L26;
        return r1;
    L7:
        r0 = new AudioVolumeInteractor$setMuted$1(this, r12);
        goto L8
    }

    /* JADX INFO: renamed from: canChangeVolume-tLTdkI8, reason: not valid java name */
    public final Flow<Boolean> m806canChangeVolumetLTdkI8(int r3) {
        if (r3 != 5) goto L5;
        Flow<Boolean> r4 = this.notificationsSoundPolicyInteractor.m780isZenMutedtLTdkI8(r3);
        final Flow<AudioStreamModel> r2 = m807getAudioStreamtLTdkI8(AudioStream.m819constructorimpl(2));
        return FlowKt.combine(r4, new AudioVolumeInteractor$canChangeVolumetLTdkI8$$inlined$map$1(r2), new AudioVolumeInteractor$canChangeVolume$2(null));
    L5:
        final Flow<Boolean> r5 = this.notificationsSoundPolicyInteractor.m780isZenMutedtLTdkI8(r3);
        return new AudioVolumeInteractor$canChangeVolumetLTdkI8$$inlined$map$2(r5);
    }

    /* JADX INFO: renamed from: processVolume-L0tBgz0, reason: not valid java name */
    private final Object m805processVolumeL0tBgz0(AudioStreamModel r2, int r3, boolean r4, Continuation<? super Integer> r5) {
        if (r4 == false) goto L6;
        return this.audioRepository.mo796getLastAudibleVolumeVrMivd8(r2.m828getAudioStream2ffMKO0(), r5);
    L6:
        if (r2.m828getAudioStream2ffMKO0() != 2) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == false) goto L23;
        if (r3 != 1) goto L23;
        if (r2.m828getAudioStream2ffMKO0() == 2) goto L21;
        if (r2.m828getAudioStream2ffMKO0() != 5) goto L27;
        if (r2.isMuted() == true) goto L21;
    L27:
        return Boxing.boxInt(r2.getVolume());
    L21:
        return Boxing.boxInt(r2.getMinVolume());
    L23:
        if (r2.isMuted() == false) goto L27;
        return Boxing.boxInt(r2.getMinVolume());
    L8:
        if (r2.m828getAudioStream2ffMKO0() == 5) goto L11;
        r1 = false;
        goto L12
    }
}
