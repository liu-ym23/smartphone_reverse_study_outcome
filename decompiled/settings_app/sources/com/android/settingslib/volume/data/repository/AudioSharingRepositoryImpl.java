package com.android.settingslib.volume.data.repository;

import com.android.settingslib.bluetooth.LocalBluetoothLeBroadcast;
import com.android.settingslib.bluetooth.LocalBluetoothManager;
import com.android.settingslib.bluetooth.LocalBluetoothProfileManager;
import com.android.settingslib.flags.Flags;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: AudioSharingRepository.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\tH\u0002R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/android/settingslib/volume/data/repository/AudioSharingRepositoryImpl;", "Lcom/android/settingslib/volume/data/repository/AudioSharingRepository;", "localBluetoothManager", "Lcom/android/settingslib/bluetooth/LocalBluetoothManager;", "backgroundCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "(Lcom/android/settingslib/bluetooth/LocalBluetoothManager;Lkotlin/coroutines/CoroutineContext;)V", "inAudioSharing", "Lkotlinx/coroutines/flow/Flow;", "", "getInAudioSharing", "()Lkotlinx/coroutines/flow/Flow;", "isBroadcasting", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AudioSharingRepositoryImpl implements AudioSharingRepository {
    private final Flow<Boolean> inAudioSharing;
    private final LocalBluetoothManager localBluetoothManager;

    public AudioSharingRepositoryImpl(LocalBluetoothManager r4, CoroutineContext r5) {
        Intrinsics.checkNotNullParameter(r5, "backgroundCoroutineContext");
        this.localBluetoothManager = r4;
        if (Flags.enableLeAudioSharing() == false) goto L12;
        if (r4 == null) goto L11;
        LocalBluetoothProfileManager r6 = r4.getProfileManager();
        if (r6 == null) goto L11;
        LocalBluetoothLeBroadcast r7 = r6.getLeAudioBroadcastProfile();
        if (r7 == null) goto L11;
        Flow<Boolean> r8 = FlowKt.flowOn(FlowKt.onStart(FlowKt.callbackFlow(new AudioSharingRepositoryImpl$inAudioSharing$1$1(r7, this, null)), new AudioSharingRepositoryImpl$inAudioSharing$1$2(this, null)), r5);
        if (r8 == null) goto L11;
    L13:
        this.inAudioSharing = r8;
        return;
    L11:
        r8 = FlowKt.flowOf(false);
        goto L13
    L12:
        r8 = FlowKt.flowOf(false);
        goto L13
    }

    public static final /* synthetic */ boolean access$isBroadcasting(AudioSharingRepositoryImpl r0) {
        return r0.isBroadcasting();
    }

    @Override // com.android.settingslib.volume.data.repository.AudioSharingRepository
    public Flow<Boolean> getInAudioSharing() {
        return this.inAudioSharing;
    }

    private final boolean isBroadcasting() {
        if (Flags.enableLeAudioSharing() == false) goto L15;
        LocalBluetoothManager r2 = this.localBluetoothManager;
        if (r2 == null) goto L11;
        LocalBluetoothProfileManager r3 = r2.getProfileManager();
        if (r3 == null) goto L11;
        LocalBluetoothLeBroadcast r4 = r3.getLeAudioBroadcastProfile();
        if (r4 == null) goto L11;
        boolean r5 = r4.isEnabled(null);
    L12:
        if (r5 == false) goto L16;
        return true;
    L16:
        return false;
    L11:
        r5 = false;
        goto L12
    L15:
        return false;
    }
}
