package com.android.settingslib.volume.data.repository;

import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: AudioSharingRepository.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/settingslib/volume/data/repository/AudioSharingRepository;", "", "inAudioSharing", "Lkotlinx/coroutines/flow/Flow;", "", "getInAudioSharing", "()Lkotlinx/coroutines/flow/Flow;", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface AudioSharingRepository {
    Flow<Boolean> getInAudioSharing();
}
