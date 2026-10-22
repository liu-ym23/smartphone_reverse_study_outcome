package com.android.settingslib.statusbar.notification.data.repository;

import android.app.NotificationManager;
import android.content.Context;
import com.android.settingslib.statusbar.notification.data.model.ZenMode;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: NotificationsSoundPolicyRepository.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u000fX\u0096\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/android/settingslib/statusbar/notification/data/repository/NotificationsSoundPolicyRepositoryImpl;", "Lcom/android/settingslib/statusbar/notification/data/repository/NotificationsSoundPolicyRepository;", "context", "Landroid/content/Context;", "notificationManager", "Landroid/app/NotificationManager;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "backgroundCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroid/content/Context;Landroid/app/NotificationManager;Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;)V", "notificationBroadcasts", "Lkotlinx/coroutines/flow/SharedFlow;", "", "notificationPolicy", "Lkotlinx/coroutines/flow/StateFlow;", "Landroid/app/NotificationManager$Policy;", "getNotificationPolicy", "()Lkotlinx/coroutines/flow/StateFlow;", "zenMode", "Lcom/android/settingslib/statusbar/notification/data/model/ZenMode;", "getZenMode", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NotificationsSoundPolicyRepositoryImpl implements NotificationsSoundPolicyRepository {
    private final Context context;
    private final SharedFlow<String> notificationBroadcasts;
    private final NotificationManager notificationManager;
    private final StateFlow<NotificationManager.Policy> notificationPolicy;
    private final StateFlow<ZenMode> zenMode;

    public NotificationsSoundPolicyRepositoryImpl(Context r9, NotificationManager r10, CoroutineScope r11, CoroutineContext r12) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "notificationManager");
        Intrinsics.checkNotNullParameter(r11, "scope");
        Intrinsics.checkNotNullParameter(r12, "backgroundCoroutineContext");
        this.context = r9;
        this.notificationManager = r10;
        SharedFlow<String> r13 = FlowKt.shareIn$default(FlowKt.callbackFlow(new NotificationsSoundPolicyRepositoryImpl$notificationBroadcasts$1(this, null)), r11, SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 0, 0, 3, null), 0, 4, null);
        this.notificationBroadcasts = r13;
        final SharedFlow<String> r0 = r13;
        final Flow<String> r1 = new NotificationsSoundPolicyRepositoryImpl$special$$inlined$filter$1(r0);
        this.notificationPolicy = FlowKt.stateIn(FlowKt.flowOn(FlowKt.onStart(new NotificationsSoundPolicyRepositoryImpl$special$$inlined$map$1(r1, this), new NotificationsSoundPolicyRepositoryImpl$notificationPolicy$3(this, null)), r12), r11, SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 0, 0, 3, null), null);
        final SharedFlow<String> r14 = r13;
        final Flow<String> r2 = new NotificationsSoundPolicyRepositoryImpl$special$$inlined$filter$2(r14);
        this.zenMode = FlowKt.stateIn(FlowKt.flowOn(FlowKt.onStart(new NotificationsSoundPolicyRepositoryImpl$special$$inlined$map$2(r2, this), new NotificationsSoundPolicyRepositoryImpl$zenMode$3(this, null)), r12), r11, SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 0, 0, 3, null), null);
    }

    public static final /* synthetic */ Context access$getContext$p(NotificationsSoundPolicyRepositoryImpl r0) {
        return r0.context;
    }

    public static final /* synthetic */ NotificationManager access$getNotificationManager$p(NotificationsSoundPolicyRepositoryImpl r0) {
        return r0.notificationManager;
    }

    @Override // com.android.settingslib.statusbar.notification.data.repository.NotificationsSoundPolicyRepository
    public StateFlow<NotificationManager.Policy> getNotificationPolicy() {
        return this.notificationPolicy;
    }

    @Override // com.android.settingslib.statusbar.notification.data.repository.NotificationsSoundPolicyRepository
    public StateFlow<ZenMode> getZenMode() {
        return this.zenMode;
    }
}
