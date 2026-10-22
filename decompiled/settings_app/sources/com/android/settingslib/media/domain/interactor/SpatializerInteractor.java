package com.android.settingslib.media.domain.interactor;

import android.media.AudioDeviceAttributes;
import com.android.settingslib.media.data.repository.SpatializerRepository;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpatializerInteractor.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0019\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0019\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\tJ!\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J!\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/android/settingslib/media/domain/interactor/SpatializerInteractor;", "", "repository", "Lcom/android/settingslib/media/data/repository/SpatializerRepository;", "(Lcom/android/settingslib/media/data/repository/SpatializerRepository;)V", "isHeadTrackingAvailable", "", "audioDeviceAttributes", "Landroid/media/AudioDeviceAttributes;", "(Landroid/media/AudioDeviceAttributes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isHeadTrackingEnabled", "isSpatialAudioAvailable", "isSpatialAudioEnabled", "setHeadTrackingEnabled", "", "isEnabled", "(Landroid/media/AudioDeviceAttributes;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setSpatialAudioEnabled", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SpatializerInteractor {
    private final SpatializerRepository repository;

    /* JADX INFO: renamed from: com.android.settingslib.media.domain.interactor.SpatializerInteractor$isSpatialAudioEnabled$1, reason: invalid class name */
    /* JADX INFO: compiled from: SpatializerInteractor.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.android.settingslib.media.domain.interactor.SpatializerInteractor", f = "SpatializerInteractor.kt", i = {0}, l = {34}, m = "isSpatialAudioEnabled", n = {"audioDeviceAttributes"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SpatializerInteractor this$0;

        AnonymousClass1(SpatializerInteractor r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.isSpatialAudioEnabled(null, this);
        }
    }

    public SpatializerInteractor(SpatializerRepository r2) {
        Intrinsics.checkNotNullParameter(r2, "repository");
        this.repository = r2;
    }

    public final Object isSpatialAudioAvailable(AudioDeviceAttributes r1, Continuation<? super Boolean> r2) {
        return this.repository.isSpatialAudioAvailableForDevice(r1, r2);
    }

    public final Object isHeadTrackingAvailable(AudioDeviceAttributes r1, Continuation<? super Boolean> r2) {
        return this.repository.isHeadTrackingAvailableForDevice(r1, r2);
    }

    public final Object isSpatialAudioEnabled(AudioDeviceAttributes r5, Continuation<? super Boolean> r6) {
        if ((r6 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r6;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r5 = (AudioDeviceAttributes) r0.L$0;
        ResultKt.throwOnFailure(r7);
    L18:
        return Boxing.boxBoolean(((Collection) r7).contains(r5));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        SpatializerRepository r4 = this.repository;
        r0.L$0 = r5;
        r0.label = 1;
        r7 = r4.getSpatialAudioCompatibleDevices(r0);
        if (r7 != r1) goto L18;
        return r1;
    L7:
        r0 = new AnonymousClass1(this, r6);
        goto L8
    }

    public final Object setSpatialAudioEnabled(AudioDeviceAttributes r1, boolean r2, Continuation<? super Unit> r3) {
        if (r2 == false) goto L8;
        Object r0 = this.repository.addSpatialAudioCompatibleDevice(r1, r3);
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L7;
        return r0;
    L7:
        return Unit.INSTANCE;
    L8:
        Object r4 = this.repository.removeSpatialAudioCompatibleDevice(r1, r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        return r4;
    L12:
        return Unit.INSTANCE;
    }

    public final Object isHeadTrackingEnabled(AudioDeviceAttributes r1, Continuation<? super Boolean> r2) {
        return this.repository.isHeadTrackingEnabled(r1, r2);
    }

    public final Object setHeadTrackingEnabled(AudioDeviceAttributes r1, boolean r2, Continuation<? super Unit> r3) {
        Object r0 = this.repository.setHeadTrackingEnabled(r1, r2, r3);
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r0;
    L6:
        return Unit.INSTANCE;
    }
}
