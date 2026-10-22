package com.android.settingslib.media.data.repository;

import android.media.AudioDeviceAttributes;
import android.media.Spatializer;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SpatializerRepository.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\rH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0019\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0019\u0010\u0012\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0019\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ!\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0010H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/android/settingslib/media/data/repository/SpatializerRepositoryImpl;", "Lcom/android/settingslib/media/data/repository/SpatializerRepository;", "spatializer", "Landroid/media/Spatializer;", "backgroundContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroid/media/Spatializer;Lkotlin/coroutines/CoroutineContext;)V", "addSpatialAudioCompatibleDevice", "", "audioDeviceAttributes", "Landroid/media/AudioDeviceAttributes;", "(Landroid/media/AudioDeviceAttributes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSpatialAudioCompatibleDevices", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isHeadTrackingAvailableForDevice", "", "isHeadTrackingEnabled", "isSpatialAudioAvailableForDevice", "removeSpatialAudioCompatibleDevice", "setHeadTrackingEnabled", "isEnabled", "(Landroid/media/AudioDeviceAttributes;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SpatializerRepositoryImpl implements SpatializerRepository {
    private final CoroutineContext backgroundContext;
    private final Spatializer spatializer;

    /* JADX INFO: renamed from: com.android.settingslib.media.data.repository.SpatializerRepositoryImpl$addSpatialAudioCompatibleDevice$2, reason: invalid class name */
    /* JADX INFO: compiled from: SpatializerRepository.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.android.settingslib.media.data.repository.SpatializerRepositoryImpl$addSpatialAudioCompatibleDevice$2", f = "SpatializerRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AudioDeviceAttributes $audioDeviceAttributes;
        int label;
        final /* synthetic */ SpatializerRepositoryImpl this$0;

        AnonymousClass2(SpatializerRepositoryImpl r1, AudioDeviceAttributes r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$audioDeviceAttributes = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, this.$audioDeviceAttributes, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass2) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            SpatializerRepositoryImpl.access$getSpatializer$p(this.this$0).addCompatibleAudioDevice(this.$audioDeviceAttributes);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.android.settingslib.media.data.repository.SpatializerRepositoryImpl$getSpatialAudioCompatibleDevices$1, reason: invalid class name */
    /* JADX INFO: compiled from: SpatializerRepository.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.android.settingslib.media.data.repository.SpatializerRepositoryImpl", f = "SpatializerRepository.kt", i = {}, l = {81}, m = "getSpatialAudioCompatibleDevices", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SpatializerRepositoryImpl this$0;

        AnonymousClass1(SpatializerRepositoryImpl r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.getSpatialAudioCompatibleDevices(this);
        }
    }

    /* JADX INFO: renamed from: com.android.settingslib.media.data.repository.SpatializerRepositoryImpl$getSpatialAudioCompatibleDevices$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SpatializerRepository.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a$\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u00040\u0001*\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Landroid/media/AudioDeviceAttributes;", "kotlin.jvm.PlatformType", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.android.settingslib.media.data.repository.SpatializerRepositoryImpl$getSpatialAudioCompatibleDevices$2", f = "SpatializerRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C01592 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<AudioDeviceAttributes>>, Object> {
        int label;
        final /* synthetic */ SpatializerRepositoryImpl this$0;

        C01592(SpatializerRepositoryImpl r1, Continuation<? super C01592> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new C01592(this.this$0, r2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super List<AudioDeviceAttributes>> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super List<AudioDeviceAttributes>> r2) {
            return ((C01592) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            return SpatializerRepositoryImpl.access$getSpatializer$p(this.this$0).getCompatibleAudioDevices();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.android.settingslib.media.data.repository.SpatializerRepositoryImpl$isHeadTrackingAvailableForDevice$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SpatializerRepository.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.android.settingslib.media.data.repository.SpatializerRepositoryImpl$isHeadTrackingAvailableForDevice$2", f = "SpatializerRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C01602 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ AudioDeviceAttributes $audioDeviceAttributes;
        int label;
        final /* synthetic */ SpatializerRepositoryImpl this$0;

        C01602(SpatializerRepositoryImpl r1, AudioDeviceAttributes r2, Continuation<? super C01602> r3) {
            this.this$0 = r1;
            this.$audioDeviceAttributes = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01602(this.this$0, this.$audioDeviceAttributes, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return ((C01602) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            return Boxing.boxBoolean(SpatializerRepositoryImpl.access$getSpatializer$p(this.this$0).hasHeadTracker(this.$audioDeviceAttributes));
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.android.settingslib.media.data.repository.SpatializerRepositoryImpl$isHeadTrackingEnabled$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SpatializerRepository.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.android.settingslib.media.data.repository.SpatializerRepositoryImpl$isHeadTrackingEnabled$2", f = "SpatializerRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C01612 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ AudioDeviceAttributes $audioDeviceAttributes;
        int label;
        final /* synthetic */ SpatializerRepositoryImpl this$0;

        C01612(SpatializerRepositoryImpl r1, AudioDeviceAttributes r2, Continuation<? super C01612> r3) {
            this.this$0 = r1;
            this.$audioDeviceAttributes = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01612(this.this$0, this.$audioDeviceAttributes, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return ((C01612) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            return Boxing.boxBoolean(SpatializerRepositoryImpl.access$getSpatializer$p(this.this$0).isHeadTrackerEnabled(this.$audioDeviceAttributes));
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.android.settingslib.media.data.repository.SpatializerRepositoryImpl$isSpatialAudioAvailableForDevice$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SpatializerRepository.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.android.settingslib.media.data.repository.SpatializerRepositoryImpl$isSpatialAudioAvailableForDevice$2", f = "SpatializerRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C01622 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ AudioDeviceAttributes $audioDeviceAttributes;
        int label;
        final /* synthetic */ SpatializerRepositoryImpl this$0;

        C01622(SpatializerRepositoryImpl r1, AudioDeviceAttributes r2, Continuation<? super C01622> r3) {
            this.this$0 = r1;
            this.$audioDeviceAttributes = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01622(this.this$0, this.$audioDeviceAttributes, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return ((C01622) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            return Boxing.boxBoolean(SpatializerRepositoryImpl.access$getSpatializer$p(this.this$0).isAvailableForDevice(this.$audioDeviceAttributes));
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.android.settingslib.media.data.repository.SpatializerRepositoryImpl$removeSpatialAudioCompatibleDevice$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SpatializerRepository.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.android.settingslib.media.data.repository.SpatializerRepositoryImpl$removeSpatialAudioCompatibleDevice$2", f = "SpatializerRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C01632 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AudioDeviceAttributes $audioDeviceAttributes;
        int label;
        final /* synthetic */ SpatializerRepositoryImpl this$0;

        C01632(SpatializerRepositoryImpl r1, AudioDeviceAttributes r2, Continuation<? super C01632> r3) {
            this.this$0 = r1;
            this.$audioDeviceAttributes = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01632(this.this$0, this.$audioDeviceAttributes, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((C01632) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            SpatializerRepositoryImpl.access$getSpatializer$p(this.this$0).removeCompatibleAudioDevice(this.$audioDeviceAttributes);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.android.settingslib.media.data.repository.SpatializerRepositoryImpl$setHeadTrackingEnabled$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SpatializerRepository.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.android.settingslib.media.data.repository.SpatializerRepositoryImpl$setHeadTrackingEnabled$2", f = "SpatializerRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C01642 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AudioDeviceAttributes $audioDeviceAttributes;
        final /* synthetic */ boolean $isEnabled;
        int label;
        final /* synthetic */ SpatializerRepositoryImpl this$0;

        C01642(SpatializerRepositoryImpl r1, boolean r2, AudioDeviceAttributes r3, Continuation<? super C01642> r4) {
            this.this$0 = r1;
            this.$isEnabled = r2;
            this.$audioDeviceAttributes = r3;
            super(2, r4);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01642(this.this$0, this.$isEnabled, this.$audioDeviceAttributes, r4);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((C01642) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            SpatializerRepositoryImpl.access$getSpatializer$p(this.this$0).setHeadTrackerEnabled(this.$isEnabled, this.$audioDeviceAttributes);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public SpatializerRepositoryImpl(Spatializer r2, CoroutineContext r3) {
        Intrinsics.checkNotNullParameter(r2, "spatializer");
        Intrinsics.checkNotNullParameter(r3, "backgroundContext");
        this.spatializer = r2;
        this.backgroundContext = r3;
    }

    public static final /* synthetic */ Spatializer access$getSpatializer$p(SpatializerRepositoryImpl r0) {
        return r0.spatializer;
    }

    @Override // com.android.settingslib.media.data.repository.SpatializerRepository
    public Object isHeadTrackingAvailableForDevice(AudioDeviceAttributes r4, Continuation<? super Boolean> r5) {
        return BuildersKt.withContext(this.backgroundContext, new C01602(this, r4, null), r5);
    }

    @Override // com.android.settingslib.media.data.repository.SpatializerRepository
    public Object isSpatialAudioAvailableForDevice(AudioDeviceAttributes r4, Continuation<? super Boolean> r5) {
        return BuildersKt.withContext(this.backgroundContext, new C01622(this, r4, null), r5);
    }

    @Override // com.android.settingslib.media.data.repository.SpatializerRepository
    public Object getSpatialAudioCompatibleDevices(Continuation<? super Collection<AudioDeviceAttributes>> r6) {
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
        ResultKt.throwOnFailure(r7);
    L17:
        Intrinsics.checkNotNullExpressionValue(r7, "override suspend fun get….compatibleAudioDevices }");
        return r7;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        CoroutineContext r8 = this.backgroundContext;
        C01592 r3 = new C01592(this, null);
        r0.label = 1;
        r7 = BuildersKt.withContext(r8, r3, r0);
        if (r7 != r1) goto L17;
        return r1;
    L7:
        r0 = new AnonymousClass1(this, r6);
        goto L8
    }

    @Override // com.android.settingslib.media.data.repository.SpatializerRepository
    public Object addSpatialAudioCompatibleDevice(AudioDeviceAttributes r4, Continuation<? super Unit> r5) {
        Object r3 = BuildersKt.withContext(this.backgroundContext, new AnonymousClass2(this, r4, null), r5);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Unit.INSTANCE;
    }

    @Override // com.android.settingslib.media.data.repository.SpatializerRepository
    public Object removeSpatialAudioCompatibleDevice(AudioDeviceAttributes r4, Continuation<? super Unit> r5) {
        Object r3 = BuildersKt.withContext(this.backgroundContext, new C01632(this, r4, null), r5);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Unit.INSTANCE;
    }

    @Override // com.android.settingslib.media.data.repository.SpatializerRepository
    public Object isHeadTrackingEnabled(AudioDeviceAttributes r4, Continuation<? super Boolean> r5) {
        return BuildersKt.withContext(this.backgroundContext, new C01612(this, r4, null), r5);
    }

    @Override // com.android.settingslib.media.data.repository.SpatializerRepository
    public Object setHeadTrackingEnabled(AudioDeviceAttributes r4, boolean r5, Continuation<? super Unit> r6) {
        Object r3 = BuildersKt.withContext(this.backgroundContext, new C01642(this, r5, r4, null), r6);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Unit.INSTANCE;
    }
}
