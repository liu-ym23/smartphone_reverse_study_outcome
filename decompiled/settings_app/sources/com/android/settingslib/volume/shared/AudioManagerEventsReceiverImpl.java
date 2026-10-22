package com.android.settingslib.volume.shared;

import android.content.Context;
import android.content.Intent;
import com.GlobalProxyLancet;
import com.android.settingslib.volume.shared.model.AudioManagerEvent;
import com.android.settingslib.volume.shared.model.AudioStream;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharingStarted;

/* JADX INFO: compiled from: AudioManagerEventsReceiver.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0011\u001a\u0004\u0018\u00010\u000e*\u00020\u0012H\u0002R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/android/settingslib/volume/shared/AudioManagerEventsReceiverImpl;", "Lcom/android/settingslib/volume/shared/AudioManagerEventsReceiver;", "context", "Landroid/content/Context;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroid/content/Context;Lkotlinx/coroutines/CoroutineScope;)V", "allActions", "", "", "getAllActions", "()Ljava/util/Collection;", "events", "Lkotlinx/coroutines/flow/SharedFlow;", "Lcom/android/settingslib/volume/shared/model/AudioManagerEvent;", "getEvents", "()Lkotlinx/coroutines/flow/SharedFlow;", "toAudioManagerEvent", "Landroid/content/Intent;", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AudioManagerEventsReceiverImpl implements AudioManagerEventsReceiver {
    private final Context context;
    private final SharedFlow<AudioManagerEvent> events;

    public AudioManagerEventsReceiverImpl(Context r10, CoroutineScope r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "coroutineScope");
        this.context = r10;
        final Flow r12 = FlowKt.filterNotNull(FlowKt.callbackFlow(new AudioManagerEventsReceiverImpl$events$1(this, null)));
        final Flow<Intent> r0 = new AudioManagerEventsReceiverImpl$special$$inlined$filter$1(r12, this);
        this.events = FlowKt.shareIn$default(new AudioManagerEventsReceiverImpl$special$$inlined$mapNotNull$1(r0, this), r11, SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 0, 0, 3, null), 0, 4, null);
    }

    public static final /* synthetic */ Collection access$getAllActions(AudioManagerEventsReceiverImpl r0) {
        return r0.getAllActions();
    }

    public static final /* synthetic */ Context access$getContext$p(AudioManagerEventsReceiverImpl r0) {
        return r0.context;
    }

    public static final /* synthetic */ AudioManagerEvent access$toAudioManagerEvent(AudioManagerEventsReceiverImpl r0, Intent r1) {
        return r0.toAudioManagerEvent(r1);
    }

    private final Collection<String> getAllActions() {
        return SetsKt.setOf(new String[]{"android.media.STREAM_MUTE_CHANGED_ACTION", "android.media.MASTER_MUTE_CHANGED_ACTION", "android.media.VOLUME_CHANGED_ACTION", "android.media.INTERNAL_RINGER_MODE_CHANGED_ACTION", "android.media.STREAM_DEVICES_CHANGED_ACTION", "android.media.VOLUME_CHANGED_ACTION"});
    }

    @Override // com.android.settingslib.volume.shared.AudioManagerEventsReceiver
    public SharedFlow<AudioManagerEvent> getEvents() {
        return this.events;
    }

    private final AudioManagerEvent toAudioManagerEvent(Intent r4) {
        String r3 = r4.getAction();
        if (r3 == null) goto L26;
        int r0 = r3.hashCode();
        if (r0 == (-1315844839)) goto L22;
        if (r0 == 100931828) goto L17;
        if (r0 != 1170999219) goto L26;
        if (r3.equals("android.media.MASTER_MUTE_CHANGED_ACTION") == false) goto L26;
        return AudioManagerEvent.StreamMasterMuteChanged.INSTANCE;
    L17:
        if (r3.equals("android.media.INTERNAL_RINGER_MODE_CHANGED_ACTION") == false) goto L26;
        return AudioManagerEvent.InternalRingerModeChanged.INSTANCE;
    L22:
        if (r3.equals("android.media.STREAM_DEVICES_CHANGED_ACTION") == false) goto L26;
        return AudioManagerEvent.StreamDevicesChanged.INSTANCE;
    L26:
        int r5 = r4.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1);
        if (r5 != (-1)) goto L30;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e("AudioManagerIntentsReceiver", "Intent doesn't have AudioManager.EXTRA_VOLUME_STREAM_TYPE extra");
        return null;
    L30:
        int r6 = AudioStream.m819constructorimpl(r5);
        String r7 = r4.getAction();
        if (r7 == null) goto L45;
        int r1 = r7.hashCode();
        if (r1 == (-1940635523)) goto L41;
        if (r1 == 1920758225) goto L38;
        return null;
    L38:
        if (r7.equals("android.media.STREAM_MUTE_CHANGED_ACTION") == true) goto L47;
        return null;
    L47:
        return new AudioManagerEvent.StreamMuteChanged(r6, null);
    L41:
        if (r7.equals("android.media.VOLUME_CHANGED_ACTION") == true) goto L44;
        return null;
    L44:
        return new AudioManagerEvent.StreamVolumeChanged(r6, null);
    L45:
        return null;
    }
}
