package com.android.settingslib.volume.domain.interactor;

import com.android.settingslib.volume.data.repository.AudioRepository;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: AudioModeInteractor.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/android/settingslib/volume/domain/interactor/AudioModeInteractor;", "", "repository", "Lcom/android/settingslib/volume/data/repository/AudioRepository;", "(Lcom/android/settingslib/volume/data/repository/AudioRepository;)V", "isOngoingCall", "Lkotlinx/coroutines/flow/Flow;", "", "()Lkotlinx/coroutines/flow/Flow;", "ongoingCallModes", "", "", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AudioModeInteractor {
    private final Flow<Boolean> isOngoingCall;
    private final Set<Integer> ongoingCallModes;

    public AudioModeInteractor(AudioRepository r6) {
        Intrinsics.checkNotNullParameter(r6, "repository");
        this.ongoingCallModes = SetsKt.setOf(new Integer[]{1, 2, 3});
        final StateFlow<Integer> r7 = r6.getMode();
        this.isOngoingCall = new AudioModeInteractor$special$$inlined$map$1(r7, this);
    }

    public static final /* synthetic */ Set access$getOngoingCallModes$p(AudioModeInteractor r0) {
        return r0.ongoingCallModes;
    }

    public final Flow<Boolean> isOngoingCall() {
        return this.isOngoingCall;
    }
}
