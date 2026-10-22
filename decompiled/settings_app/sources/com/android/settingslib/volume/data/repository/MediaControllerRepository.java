package com.android.settingslib.volume.data.repository;

import android.media.session.MediaController;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: MediaControllerRepository.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/android/settingslib/volume/data/repository/MediaControllerRepository;", "", "activeSessions", "Lkotlinx/coroutines/flow/StateFlow;", "", "Landroid/media/session/MediaController;", "getActiveSessions", "()Lkotlinx/coroutines/flow/StateFlow;", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface MediaControllerRepository {
    StateFlow<List<MediaController>> getActiveSessions();
}
