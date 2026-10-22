package com.android.settingslib.volume.data.repository;

import android.content.Context;
import android.media.AudioSystem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AudioSystemRepository.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/android/settingslib/volume/data/repository/AudioSystemRepositoryImpl;", "Lcom/android/settingslib/volume/data/repository/AudioSystemRepository;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isSingleVolume", "", "()Z", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AudioSystemRepositoryImpl implements AudioSystemRepository {
    private final Context context;

    public AudioSystemRepositoryImpl(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.context = r2;
    }

    @Override // com.android.settingslib.volume.data.repository.AudioSystemRepository
    public boolean isSingleVolume() {
        return AudioSystem.isSingleVolume(this.context);
    }
}
