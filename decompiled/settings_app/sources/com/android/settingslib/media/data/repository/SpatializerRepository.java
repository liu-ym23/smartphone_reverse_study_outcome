package com.android.settingslib.media.data.repository;

import android.media.AudioDeviceAttributes;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: SpatializerRepository.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0019\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0019\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0019\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J!\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/android/settingslib/media/data/repository/SpatializerRepository;", "", "addSpatialAudioCompatibleDevice", "", "audioDeviceAttributes", "Landroid/media/AudioDeviceAttributes;", "(Landroid/media/AudioDeviceAttributes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSpatialAudioCompatibleDevices", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isHeadTrackingAvailableForDevice", "", "isHeadTrackingEnabled", "isSpatialAudioAvailableForDevice", "removeSpatialAudioCompatibleDevice", "setHeadTrackingEnabled", "isEnabled", "(Landroid/media/AudioDeviceAttributes;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface SpatializerRepository {
    Object addSpatialAudioCompatibleDevice(AudioDeviceAttributes r1, Continuation<? super Unit> r2);

    Object getSpatialAudioCompatibleDevices(Continuation<? super Collection<AudioDeviceAttributes>> r1);

    Object isHeadTrackingAvailableForDevice(AudioDeviceAttributes r1, Continuation<? super Boolean> r2);

    Object isHeadTrackingEnabled(AudioDeviceAttributes r1, Continuation<? super Boolean> r2);

    Object isSpatialAudioAvailableForDevice(AudioDeviceAttributes r1, Continuation<? super Boolean> r2);

    Object removeSpatialAudioCompatibleDevice(AudioDeviceAttributes r1, Continuation<? super Unit> r2);

    Object setHeadTrackingEnabled(AudioDeviceAttributes r1, boolean r2, Continuation<? super Unit> r3);
}
