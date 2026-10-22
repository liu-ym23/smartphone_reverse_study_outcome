package com.android.settingslib.volume.data.repository;

import android.icu.text.PluralRules;
import com.android.settingslib.media.LocalMediaManager;
import com.android.settingslib.media.MediaDevice;
import com.android.settingslib.volume.shared.AudioManagerEventsReceiver;
import com.android.settingslib.volume.shared.model.AudioManagerEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: LocalMediaRepository.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u001c\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/android/settingslib/volume/data/repository/LocalMediaRepositoryImpl;", "Lcom/android/settingslib/volume/data/repository/LocalMediaRepository;", "audioManagerEventsReceiver", "Lcom/android/settingslib/volume/shared/AudioManagerEventsReceiver;", "localMediaManager", "Lcom/android/settingslib/media/LocalMediaManager;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lcom/android/settingslib/volume/shared/AudioManagerEventsReceiver;Lcom/android/settingslib/media/LocalMediaManager;Lkotlinx/coroutines/CoroutineScope;)V", "currentConnectedDevice", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/android/settingslib/media/MediaDevice;", "getCurrentConnectedDevice", "()Lkotlinx/coroutines/flow/StateFlow;", "devicesChanges", "Lkotlinx/coroutines/flow/Flow;", "Lcom/android/settingslib/volume/shared/model/AudioManagerEvent$StreamDevicesChanged;", "mediaDevicesUpdates", "Lcom/android/settingslib/volume/data/repository/LocalMediaRepositoryImpl$DevicesUpdate;", "DevicesUpdate", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LocalMediaRepositoryImpl implements LocalMediaRepository {
    private final StateFlow<MediaDevice> currentConnectedDevice;
    private final Flow<AudioManagerEvent.StreamDevicesChanged> devicesChanges;
    private final LocalMediaManager localMediaManager;
    private final Flow<DevicesUpdate> mediaDevicesUpdates;

    /* JADX INFO: compiled from: LocalMediaRepository.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/android/settingslib/volume/data/repository/LocalMediaRepositoryImpl$DevicesUpdate;", "", "DeviceAttributesChanged", "DeviceListUpdate", "SelectedDeviceStateChanged", "Lcom/android/settingslib/volume/data/repository/LocalMediaRepositoryImpl$DevicesUpdate$DeviceAttributesChanged;", "Lcom/android/settingslib/volume/data/repository/LocalMediaRepositoryImpl$DevicesUpdate$DeviceListUpdate;", "Lcom/android/settingslib/volume/data/repository/LocalMediaRepositoryImpl$DevicesUpdate$SelectedDeviceStateChanged;", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private interface DevicesUpdate {

        /* JADX INFO: compiled from: LocalMediaRepository.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/android/settingslib/volume/data/repository/LocalMediaRepositoryImpl$DevicesUpdate$DeviceAttributesChanged;", "Lcom/android/settingslib/volume/data/repository/LocalMediaRepositoryImpl$DevicesUpdate;", "()V", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class DeviceAttributesChanged implements DevicesUpdate {
            public static final DeviceAttributesChanged INSTANCE = null;

            static {
                INSTANCE = new DeviceAttributesChanged();
            }

            private DeviceAttributesChanged() {
            }
        }

        /* JADX INFO: compiled from: LocalMediaRepository.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/android/settingslib/volume/data/repository/LocalMediaRepositoryImpl$DevicesUpdate$DeviceListUpdate;", "Lcom/android/settingslib/volume/data/repository/LocalMediaRepositoryImpl$DevicesUpdate;", "newDevices", "", "Lcom/android/settingslib/media/MediaDevice;", "(Ljava/util/List;)V", "getNewDevices", "()Ljava/util/List;", "component1", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class DeviceListUpdate implements DevicesUpdate {
            private final List<MediaDevice> newDevices;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ DeviceListUpdate copy$default(DeviceListUpdate r0, List r1, int r2, Object r3) {
                if ((r2 & 1) == 0) goto L6;
                r1 = r0.newDevices;
            L6:
                return r0.copy(r1);
            }

            public final List<MediaDevice> component1() {
                return this.newDevices;
            }

            public final DeviceListUpdate copy(List<? extends MediaDevice> r1) {
                return new DeviceListUpdate(r1);
            }

            public boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof DeviceListUpdate) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.newDevices, ((DeviceListUpdate) r4).newDevices) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                List<MediaDevice> r0 = this.newDevices;
                if (r0 != null) goto L6;
                return 0;
            L6:
                return r0.hashCode();
            }

            public String toString() {
                return "DeviceListUpdate(newDevices=" + this.newDevices + ')';
            }

            /* JADX WARN: Multi-variable type inference failed */
            public DeviceListUpdate(List<? extends MediaDevice> r1) {
                this.newDevices = r1;
            }

            public final List<MediaDevice> getNewDevices() {
                return this.newDevices;
            }
        }

        /* JADX INFO: compiled from: LocalMediaRepository.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/android/settingslib/volume/data/repository/LocalMediaRepositoryImpl$DevicesUpdate$SelectedDeviceStateChanged;", "Lcom/android/settingslib/volume/data/repository/LocalMediaRepositoryImpl$DevicesUpdate;", "()V", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class SelectedDeviceStateChanged implements DevicesUpdate {
            public static final SelectedDeviceStateChanged INSTANCE = null;

            static {
                INSTANCE = new SelectedDeviceStateChanged();
            }

            private SelectedDeviceStateChanged() {
            }
        }
    }

    public LocalMediaRepositoryImpl(AudioManagerEventsReceiver r5, LocalMediaManager r6, CoroutineScope r7) {
        Intrinsics.checkNotNullParameter(r5, "audioManagerEventsReceiver");
        Intrinsics.checkNotNullParameter(r6, "localMediaManager");
        Intrinsics.checkNotNullParameter(r7, "coroutineScope");
        this.localMediaManager = r6;
        Flow<AudioManagerEvent.StreamDevicesChanged> r8 = FlowKt.filterIsInstance(r5.getEvents(), Reflection.getOrCreateKotlinClass(AudioManagerEvent.StreamDevicesChanged.class));
        this.devicesChanges = r8;
        SharedFlow r0 = FlowKt.shareIn(FlowKt.callbackFlow(new LocalMediaRepositoryImpl$mediaDevicesUpdates$1(this, null)), r7, SharingStarted.Companion.getEagerly(), 0);
        this.mediaDevicesUpdates = r0;
        final Flow r9 = FlowKt.merge(new Flow[]{r8, r0});
        this.currentConnectedDevice = FlowKt.stateIn(FlowKt.onStart(new LocalMediaRepositoryImpl$special$$inlined$map$1(r9, this), new LocalMediaRepositoryImpl$currentConnectedDevice$2(this, null)), r7, SharingStarted.Companion.getEagerly(), r6.getCurrentConnectedDevice());
    }

    public static final /* synthetic */ LocalMediaManager access$getLocalMediaManager$p(LocalMediaRepositoryImpl r0) {
        return r0.localMediaManager;
    }

    @Override // com.android.settingslib.volume.data.repository.LocalMediaRepository
    public StateFlow<MediaDevice> getCurrentConnectedDevice() {
        return this.currentConnectedDevice;
    }
}
