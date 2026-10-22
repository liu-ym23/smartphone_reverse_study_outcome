package com.android.settingslib.volume.data.repository;

import android.media.AudioDeviceInfo;
import com.android.settingslib.volume.shared.model.AudioStreamModel;
import com.android.settingslib.volume.shared.model.RingerMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: AudioRepository.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J#\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J!\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H¦@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ)\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001cH¦@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ)\u0010 \u001a\u00020!2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u000bH¦@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J)\u0010$\u001a\u00020!2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\bH¦@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b&\u0010#R\u001a\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003X¦\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006'"}, d2 = {"Lcom/android/settingslib/volume/data/repository/AudioRepository;", "", "communicationDevice", "Lkotlinx/coroutines/flow/StateFlow;", "Landroid/media/AudioDeviceInfo;", "getCommunicationDevice", "()Lkotlinx/coroutines/flow/StateFlow;", "mode", "", "getMode", "ringerMode", "Lcom/android/settingslib/volume/shared/model/RingerMode;", "getRingerMode", "getAudioStream", "Lkotlinx/coroutines/flow/Flow;", "Lcom/android/settingslib/volume/shared/model/AudioStreamModel;", "audioStream", "Lcom/android/settingslib/volume/shared/model/AudioStream;", "getAudioStream-tLTdkI8", "(I)Lkotlinx/coroutines/flow/Flow;", "getBluetoothAudioDeviceCategory", "bluetoothAddress", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLastAudibleVolume", "getLastAudibleVolume-VrMivd8", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setMuted", "", "isMuted", "setMuted-ZdW0WiI", "(IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setRingerMode", "", "setRingerMode-2JRsiQU", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setVolume", "volume", "setVolume-ZdW0WiI", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface AudioRepository {
    /* JADX INFO: renamed from: getAudioStream-tLTdkI8, reason: not valid java name */
    Flow<AudioStreamModel> mo795getAudioStreamtLTdkI8(int r1);

    Object getBluetoothAudioDeviceCategory(String r1, Continuation<? super Integer> r2);

    StateFlow<AudioDeviceInfo> getCommunicationDevice();

    /* JADX INFO: renamed from: getLastAudibleVolume-VrMivd8, reason: not valid java name */
    Object mo796getLastAudibleVolumeVrMivd8(int r1, Continuation<? super Integer> r2);

    StateFlow<Integer> getMode();

    StateFlow<RingerMode> getRingerMode();

    /* JADX INFO: renamed from: setMuted-ZdW0WiI, reason: not valid java name */
    Object mo797setMutedZdW0WiI(int r1, boolean r2, Continuation<? super Boolean> r3);

    /* JADX INFO: renamed from: setRingerMode-2JRsiQU, reason: not valid java name */
    Object mo798setRingerMode2JRsiQU(int r1, int r2, Continuation<? super Unit> r3);

    /* JADX INFO: renamed from: setVolume-ZdW0WiI, reason: not valid java name */
    Object mo799setVolumeZdW0WiI(int r1, int r2, Continuation<? super Unit> r3);
}
