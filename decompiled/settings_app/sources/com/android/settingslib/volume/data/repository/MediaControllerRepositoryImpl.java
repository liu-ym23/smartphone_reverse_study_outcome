package com.android.settingslib.volume.data.repository;

import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.MediaSessionManager;
import com.android.settingslib.bluetooth.LocalBluetoothManager;
import com.android.settingslib.bluetooth.LocalBluetoothManagerExtKt;
import com.android.settingslib.media.session.MediaSessionManagerExtKt;
import com.android.settingslib.volume.shared.AudioManagerEventsReceiver;
import com.android.settingslib.volume.shared.model.AudioManagerEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: MediaControllerRepository.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fR \u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/android/settingslib/volume/data/repository/MediaControllerRepositoryImpl;", "Lcom/android/settingslib/volume/data/repository/MediaControllerRepository;", "audioManagerEventsReceiver", "Lcom/android/settingslib/volume/shared/AudioManagerEventsReceiver;", "mediaSessionManager", "Landroid/media/session/MediaSessionManager;", "localBluetoothManager", "Lcom/android/settingslib/bluetooth/LocalBluetoothManager;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "backgroundContext", "Lkotlin/coroutines/CoroutineContext;", "(Lcom/android/settingslib/volume/shared/AudioManagerEventsReceiver;Landroid/media/session/MediaSessionManager;Lcom/android/settingslib/bluetooth/LocalBluetoothManager;Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;)V", "activeSessions", "Lkotlinx/coroutines/flow/StateFlow;", "", "Landroid/media/session/MediaController;", "getActiveSessions", "()Lkotlinx/coroutines/flow/StateFlow;", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MediaControllerRepositoryImpl implements MediaControllerRepository {
    private final StateFlow<List<MediaController>> activeSessions;
    private final MediaSessionManager mediaSessionManager;

    public MediaControllerRepositoryImpl(AudioManagerEventsReceiver r8, MediaSessionManager r9, LocalBluetoothManager r10, CoroutineScope r11, CoroutineContext r12) {
        Intrinsics.checkNotNullParameter(r8, "audioManagerEventsReceiver");
        Intrinsics.checkNotNullParameter(r9, "mediaSessionManager");
        Intrinsics.checkNotNullParameter(r11, "coroutineScope");
        Intrinsics.checkNotNullParameter(r12, "backgroundContext");
        this.mediaSessionManager = r9;
        Flow[] r0 = new Flow[4];
        final Flow<MediaSession.Token> r1 = MediaSessionManagerExtKt.getDefaultRemoteSessionChanged(r9);
        r0[0] = new MediaControllerRepositoryImpl$special$$inlined$map$1(r1, this);
        r0[1] = FlowKt.filterNotNull(MediaSessionManagerExtKt.getActiveMediaChanges(r9));
        if (r10 == null) goto L7;
        final Flow<Unit> r13 = LocalBluetoothManagerExtKt.getHeadsetAudioModeChanges(r10);
        if (r13 == null) goto L7;
        Flow<List<MediaController>> r14 = new MediaControllerRepositoryImpl$special$$inlined$map$2(r13, this);
    L8:
        r0[2] = r14;
        final Flow r15 = FlowKt.filterIsInstance(r8.getEvents(), Reflection.getOrCreateKotlinClass(AudioManagerEvent.StreamDevicesChanged.class));
        r0[3] = new MediaControllerRepositoryImpl$special$$inlined$map$3(r15, this);
        this.activeSessions = FlowKt.stateIn(FlowKt.flowOn(FlowKt.onStart(FlowKt.merge(r0), new MediaControllerRepositoryImpl$activeSessions$4(this, null)), r12), r11, SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 0, 0, 3, null), CollectionsKt.emptyList());
        return;
    L7:
        r14 = FlowKt.emptyFlow();
        goto L8
    }

    public static final /* synthetic */ MediaSessionManager access$getMediaSessionManager$p(MediaControllerRepositoryImpl r0) {
        return r0.mediaSessionManager;
    }

    @Override // com.android.settingslib.volume.data.repository.MediaControllerRepository
    public StateFlow<List<MediaController>> getActiveSessions() {
        return this.activeSessions;
    }
}
