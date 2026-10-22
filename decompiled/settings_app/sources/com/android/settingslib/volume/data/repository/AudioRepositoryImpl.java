package com.android.settingslib.volume.data.repository;

import android.content.ContentResolver;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.net.Uri;
import android.provider.Settings;
import com.android.settingslib.volume.shared.AudioManagerEventsReceiver;
import com.android.settingslib.volume.shared.model.AudioManagerEvent;
import com.android.settingslib.volume.shared.model.AudioStream;
import com.android.settingslib.volume.shared.model.AudioStreamModel;
import com.android.settingslib.volume.shared.model.RingerMode;
import com.obric.aikernel.sdk.ext.CozeCloudExt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: AudioRepository.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ#\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u001f\u001a\u00020\u001aH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!J\u0019\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u001bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010$J\u001d\u0010%\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001aH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010'J!\u0010(\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u001aH\u0096@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b)\u0010*J\u001d\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u001aH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b-\u0010.J)\u0010/\u001a\u0002002\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u00101\u001a\u000200H\u0096@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b2\u00103J)\u00104\u001a\u0002052\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u0016H\u0096@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b6\u00107J)\u00108\u001a\u0002052\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u00109\u001a\u00020\u0013H\u0096@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b:\u00107J#\u0010;\u001a\b\u0012\u0004\u0012\u0002050\u001d2\u0006\u0010\u001f\u001a\u00020\u001aH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b<\u0010!R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000eX\u0096\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u001d\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0019X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006="}, d2 = {"Lcom/android/settingslib/volume/data/repository/AudioRepositoryImpl;", "Lcom/android/settingslib/volume/data/repository/AudioRepository;", "audioManagerEventsReceiver", "Lcom/android/settingslib/volume/shared/AudioManagerEventsReceiver;", "audioManager", "Landroid/media/AudioManager;", "contentResolver", "Landroid/content/ContentResolver;", "backgroundCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lcom/android/settingslib/volume/shared/AudioManagerEventsReceiver;Landroid/media/AudioManager;Landroid/content/ContentResolver;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineScope;)V", "communicationDevice", "Lkotlinx/coroutines/flow/StateFlow;", "Landroid/media/AudioDeviceInfo;", "getCommunicationDevice", "()Lkotlinx/coroutines/flow/StateFlow;", "mode", "", "getMode", "ringerMode", "Lcom/android/settingslib/volume/shared/model/RingerMode;", "getRingerMode", "streamSettingNames", "", "Lcom/android/settingslib/volume/shared/model/AudioStream;", "", "getAudioStream", "Lkotlinx/coroutines/flow/Flow;", "Lcom/android/settingslib/volume/shared/model/AudioStreamModel;", "audioStream", "getAudioStream-tLTdkI8", "(I)Lkotlinx/coroutines/flow/Flow;", "getBluetoothAudioDeviceCategory", "bluetoothAddress", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentAudioStream", "getCurrentAudioStream-tLTdkI8", "(I)Lcom/android/settingslib/volume/shared/model/AudioStreamModel;", "getLastAudibleVolume", "getLastAudibleVolume-VrMivd8", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMinVolume", CozeCloudExt.API_KEY_HTTP_STREAM_METHOD, "getMinVolume-tLTdkI8", "(I)I", "setMuted", "", "isMuted", "setMuted-ZdW0WiI", "(IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setRingerMode", "", "setRingerMode-2JRsiQU", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setVolume", "volume", "setVolume-ZdW0WiI", "volumeSettingChanges", "volumeSettingChanges-tLTdkI8", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AudioRepositoryImpl implements AudioRepository {
    private final AudioManager audioManager;
    private final AudioManagerEventsReceiver audioManagerEventsReceiver;
    private final CoroutineContext backgroundCoroutineContext;
    private final ContentResolver contentResolver;
    private final CoroutineScope coroutineScope;
    private final StateFlow<Integer> mode;
    private final StateFlow<RingerMode> ringerMode;
    private final Map<AudioStream, String> streamSettingNames;

    /* JADX INFO: renamed from: com.android.settingslib.volume.data.repository.AudioRepositoryImpl$getBluetoothAudioDeviceCategory$2, reason: invalid class name */
    /* JADX INFO: compiled from: AudioRepository.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.android.settingslib.volume.data.repository.AudioRepositoryImpl$getBluetoothAudioDeviceCategory$2", f = "AudioRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        final /* synthetic */ String $bluetoothAddress;
        int label;
        final /* synthetic */ AudioRepositoryImpl this$0;

        AnonymousClass2(AudioRepositoryImpl r1, String r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$bluetoothAddress = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, this.$bluetoothAddress, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Integer> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Integer> r2) {
            return ((AnonymousClass2) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            return Boxing.boxInt(AudioRepositoryImpl.access$getAudioManager$p(this.this$0).getBluetoothAudioDeviceCategory(this.$bluetoothAddress));
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public AudioRepositoryImpl(AudioManagerEventsReceiver r9, AudioManager r10, ContentResolver r11, CoroutineContext r12, CoroutineScope r13) {
        Intrinsics.checkNotNullParameter(r9, "audioManagerEventsReceiver");
        Intrinsics.checkNotNullParameter(r10, "audioManager");
        Intrinsics.checkNotNullParameter(r11, "contentResolver");
        Intrinsics.checkNotNullParameter(r12, "backgroundCoroutineContext");
        Intrinsics.checkNotNullParameter(r13, "coroutineScope");
        this.audioManagerEventsReceiver = r9;
        this.audioManager = r10;
        this.contentResolver = r11;
        this.backgroundCoroutineContext = r12;
        this.coroutineScope = r13;
        this.streamSettingNames = MapsKt.mapOf(new Pair[]{TuplesKt.to(AudioStream.m818boximpl(AudioStream.m819constructorimpl(0)), "volume_voice"), TuplesKt.to(AudioStream.m818boximpl(AudioStream.m819constructorimpl(1)), "volume_system"), TuplesKt.to(AudioStream.m818boximpl(AudioStream.m819constructorimpl(2)), "volume_ring"), TuplesKt.to(AudioStream.m818boximpl(AudioStream.m819constructorimpl(3)), "volume_music"), TuplesKt.to(AudioStream.m818boximpl(AudioStream.m819constructorimpl(4)), "volume_alarm"), TuplesKt.to(AudioStream.m818boximpl(AudioStream.m819constructorimpl(5)), "volume_notification"), TuplesKt.to(AudioStream.m818boximpl(AudioStream.m819constructorimpl(6)), "volume_bluetooth_sco"), TuplesKt.to(AudioStream.m818boximpl(AudioStream.m819constructorimpl(10)), "volume_a11y"), TuplesKt.to(AudioStream.m818boximpl(AudioStream.m819constructorimpl(11)), "volume_assistant")});
        this.mode = FlowKt.stateIn(FlowKt.flowOn(FlowKt.onStart(FlowKt.callbackFlow(new AudioRepositoryImpl$mode$1(this, null)), new AudioRepositoryImpl$mode$2(this, null)), r12), r13, SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 0, 0, 3, null), Integer.valueOf(r10.getMode()));
        final Flow r14 = FlowKt.filterIsInstance(r9.getEvents(), Reflection.getOrCreateKotlinClass(AudioManagerEvent.InternalRingerModeChanged.class));
        this.ringerMode = FlowKt.stateIn(FlowKt.flowOn(FlowKt.onStart(new AudioRepositoryImpl$special$$inlined$map$1(r14, this), new AudioRepositoryImpl$ringerMode$2(this, null)), r12), r13, SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 0, 0, 3, null), RingerMode.m829boximpl(RingerMode.m830constructorimpl(r10.getRingerModeInternal())));
    }

    public static final /* synthetic */ AudioManager access$getAudioManager$p(AudioRepositoryImpl r0) {
        return r0.audioManager;
    }

    public static final /* synthetic */ ContentResolver access$getContentResolver$p(AudioRepositoryImpl r0) {
        return r0.contentResolver;
    }

    /* JADX INFO: renamed from: access$getCurrentAudioStream-tLTdkI8, reason: not valid java name */
    public static final /* synthetic */ AudioStreamModel m800access$getCurrentAudioStreamtLTdkI8(AudioRepositoryImpl r0, int r1) {
        return r0.m801getCurrentAudioStreamtLTdkI8(r1);
    }

    @Override // com.android.settingslib.volume.data.repository.AudioRepository
    public StateFlow<Integer> getMode() {
        return this.mode;
    }

    @Override // com.android.settingslib.volume.data.repository.AudioRepository
    public StateFlow<RingerMode> getRingerMode() {
        return this.ringerMode;
    }

    @Override // com.android.settingslib.volume.data.repository.AudioRepository
    public StateFlow<AudioDeviceInfo> getCommunicationDevice() {
        final Flow r0 = FlowKt.filterNotNull(FlowKt.callbackFlow(new AudioRepositoryImpl$communicationDevice$1(this, null)));
        return FlowKt.stateIn(FlowKt.flowOn(FlowKt.onStart(new AudioRepositoryImpl$special$$inlined$map$2(r0, this), new AudioRepositoryImpl$communicationDevice$3(this, null)), this.backgroundCoroutineContext), this.coroutineScope, SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 0, 0, 3, null), this.audioManager.getCommunicationDevice());
    }

    @Override // com.android.settingslib.volume.data.repository.AudioRepository
    /* JADX INFO: renamed from: getAudioStream-tLTdkI8 */
    public Flow<AudioStreamModel> mo795getAudioStreamtLTdkI8(final int r4) {
        final SharedFlow<AudioManagerEvent> r1 = this.audioManagerEventsReceiver.getEvents();
        final Flow r0 = FlowKt.conflate(FlowKt.merge(new Flow[]{new AudioRepositoryImpl$getAudioStreamtLTdkI8$$inlined$filter$1(r1, r4), m803volumeSettingChangestLTdkI8(r4)}));
        return FlowKt.flowOn(FlowKt.onStart(new AudioRepositoryImpl$getAudioStreamtLTdkI8$$inlined$map$1(r0, this, r4), new AudioRepositoryImpl$getAudioStream$3(this, r4, null)), this.backgroundCoroutineContext);
    }

    /* JADX INFO: renamed from: getCurrentAudioStream-tLTdkI8, reason: not valid java name */
    private final AudioStreamModel m801getCurrentAudioStreamtLTdkI8(int r10) {
        int r3 = m802getMinVolumetLTdkI8(r10);
        int r4 = this.audioManager.getStreamMaxVolume(r10);
        return new AudioStreamModel(r10, this.audioManager.getStreamVolume(r10), r3, r4, this.audioManager.isStreamMutableByUi(r10), this.audioManager.isStreamAffectedByRingerMode(r10), this.audioManager.isStreamMute(r10), null);
    }

    @Override // com.android.settingslib.volume.data.repository.AudioRepository
    /* JADX INFO: renamed from: getLastAudibleVolume-VrMivd8 */
    public Object mo796getLastAudibleVolumeVrMivd8(int r4, Continuation<? super Integer> r5) {
        return BuildersKt.withContext(this.backgroundCoroutineContext, new AudioRepositoryImpl$getLastAudibleVolume$2(this, r4, null), r5);
    }

    @Override // com.android.settingslib.volume.data.repository.AudioRepository
    /* JADX INFO: renamed from: setVolume-ZdW0WiI */
    public Object mo799setVolumeZdW0WiI(int r4, int r5, Continuation<? super Unit> r6) {
        Object r3 = BuildersKt.withContext(this.backgroundCoroutineContext, new AudioRepositoryImpl$setVolume$2(this, r4, r5, null), r6);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Unit.INSTANCE;
    }

    @Override // com.android.settingslib.volume.data.repository.AudioRepository
    /* JADX INFO: renamed from: setMuted-ZdW0WiI */
    public Object mo797setMutedZdW0WiI(int r4, boolean r5, Continuation<? super Boolean> r6) {
        return BuildersKt.withContext(this.backgroundCoroutineContext, new AudioRepositoryImpl$setMuted$2(r5, this, r4, null), r6);
    }

    @Override // com.android.settingslib.volume.data.repository.AudioRepository
    /* JADX INFO: renamed from: setRingerMode-2JRsiQU */
    public Object mo798setRingerMode2JRsiQU(int r3, int r4, Continuation<? super Unit> r5) {
        Object r2 = BuildersKt.withContext(this.backgroundCoroutineContext, new AudioRepositoryImpl$setRingerMode$2(this, r4, null), r5);
        if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r2;
    L6:
        return Unit.INSTANCE;
    }

    @Override // com.android.settingslib.volume.data.repository.AudioRepository
    public Object getBluetoothAudioDeviceCategory(String r4, Continuation<? super Integer> r5) {
        return BuildersKt.withContext(this.backgroundCoroutineContext, new AnonymousClass2(this, r4, null), r5);
    }

    /* JADX INFO: renamed from: getMinVolume-tLTdkI8, reason: not valid java name */
    private final int m802getMinVolumetLTdkI8(int r2) {
        return this.audioManager.getStreamMinVolume(r2);
    L5:
        return this.audioManager.getStreamMinVolume(0);
    }

    /* JADX INFO: renamed from: volumeSettingChanges-tLTdkI8, reason: not valid java name */
    private final Flow<Unit> m803volumeSettingChangestLTdkI8(int r3) {
        String r4 = this.streamSettingNames.get(AudioStream.m818boximpl(r3));
        if (r4 == null) goto L5;
        Uri r5 = Settings.System.getUriFor(r4);
    L6:
        if (r5 != null) goto L10;
        return FlowKt.emptyFlow();
    L10:
        return FlowKt.callbackFlow(new AudioRepositoryImpl$volumeSettingChanges$1(this, r5, null));
    L5:
        r5 = null;
        goto L6
    }
}
