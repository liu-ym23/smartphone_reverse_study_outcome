package com.android.settingslib.view.accessibility.domain.interactor;

import com.android.settings.search.IndexDatabaseHelper;
import com.android.settingslib.view.accessibility.data.repository.CaptioningRepository;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: CaptioningInteractor.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068F¢\u0006\u0006\u001a\u0004\b\t\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/android/settingslib/view/accessibility/domain/interactor/CaptioningInteractor;", "", "repository", "Lcom/android/settingslib/view/accessibility/data/repository/CaptioningRepository;", "(Lcom/android/settingslib/view/accessibility/data/repository/CaptioningRepository;)V", "isSystemAudioCaptioningEnabled", "Lkotlinx/coroutines/flow/StateFlow;", "", "()Lkotlinx/coroutines/flow/StateFlow;", "isSystemAudioCaptioningUiEnabled", "setIsSystemAudioCaptioningEnabled", "", IndexDatabaseHelper.IndexColumns.ENABLED, "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CaptioningInteractor {
    private final CaptioningRepository repository;

    public CaptioningInteractor(CaptioningRepository r2) {
        Intrinsics.checkNotNullParameter(r2, "repository");
        this.repository = r2;
    }

    public final StateFlow<Boolean> isSystemAudioCaptioningEnabled() {
        return this.repository.isSystemAudioCaptioningEnabled();
    }

    public final StateFlow<Boolean> isSystemAudioCaptioningUiEnabled() {
        return this.repository.isSystemAudioCaptioningUiEnabled();
    }

    public final Object setIsSystemAudioCaptioningEnabled(boolean r1, Continuation<? super Unit> r2) {
        Object r0 = this.repository.setIsSystemAudioCaptioningEnabled(r1, r2);
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r0;
    L6:
        return Unit.INSTANCE;
    }
}
