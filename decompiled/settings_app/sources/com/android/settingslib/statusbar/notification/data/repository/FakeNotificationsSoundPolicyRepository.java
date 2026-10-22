package com.android.settingslib.statusbar.notification.data.repository;

import android.app.NotificationManager;
import com.android.settingslib.statusbar.notification.data.model.ZenMode;
import kotlin.Metadata;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: FakeNotificationsSoundPolicyRepository.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005J\u001b\u0010\u0011\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b\u0012R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001f\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\t8VX\u0096\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"Lcom/android/settingslib/statusbar/notification/data/repository/FakeNotificationsSoundPolicyRepository;", "Lcom/android/settingslib/statusbar/notification/data/repository/NotificationsSoundPolicyRepository;", "()V", "mutableNotificationPolicy", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroid/app/NotificationManager$Policy;", "mutableZenMode", "Lcom/android/settingslib/statusbar/notification/data/model/ZenMode;", "notificationPolicy", "Lkotlinx/coroutines/flow/StateFlow;", "getNotificationPolicy", "()Lkotlinx/coroutines/flow/StateFlow;", "zenMode", "getZenMode", "updateNotificationPolicy", "", "policy", "updateZenMode", "updateZenMode-XqomqAY", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FakeNotificationsSoundPolicyRepository implements NotificationsSoundPolicyRepository {
    private final MutableStateFlow<NotificationManager.Policy> mutableNotificationPolicy;
    private final MutableStateFlow<ZenMode> mutableZenMode;

    public FakeNotificationsSoundPolicyRepository() {
        this.mutableNotificationPolicy = StateFlowKt.MutableStateFlow(null);
        this.mutableZenMode = StateFlowKt.MutableStateFlow(ZenMode.m772boximpl(ZenMode.m773constructorimpl(0)));
        FakeNotificationsSoundPolicyRepositoryKt.updateNotificationPolicy$default(this, 0, 0, 0, 0, 0, 0, 63, null);
    }

    @Override // com.android.settingslib.statusbar.notification.data.repository.NotificationsSoundPolicyRepository
    public StateFlow<NotificationManager.Policy> getNotificationPolicy() {
        return FlowKt.asStateFlow(this.mutableNotificationPolicy);
    }

    @Override // com.android.settingslib.statusbar.notification.data.repository.NotificationsSoundPolicyRepository
    public StateFlow<ZenMode> getZenMode() {
        return FlowKt.asStateFlow(this.mutableZenMode);
    }

    public final void updateNotificationPolicy(NotificationManager.Policy r1) {
        this.mutableNotificationPolicy.setValue(r1);
    }

    /* JADX INFO: renamed from: updateZenMode-XqomqAY, reason: not valid java name */
    public final void m779updateZenModeXqomqAY(ZenMode r1) {
        this.mutableZenMode.setValue(r1);
    }
}
