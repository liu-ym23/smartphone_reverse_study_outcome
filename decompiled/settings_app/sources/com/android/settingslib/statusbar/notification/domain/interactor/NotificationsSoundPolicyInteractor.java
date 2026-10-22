package com.android.settingslib.statusbar.notification.domain.interactor;

import android.app.NotificationManager;
import com.android.settingslib.statusbar.notification.data.model.ZenMode;
import com.android.settingslib.statusbar.notification.data.repository.NotificationsSoundPolicyRepository;
import com.obric.aikernel.sdk.ext.CozeCloudExt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: NotificationsSoundPolicyInteractor.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0016\u001a\u00020\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0019\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0019\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u0019\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u000e8Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0011\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, d2 = {"Lcom/android/settingslib/statusbar/notification/domain/interactor/NotificationsSoundPolicyInteractor;", "", "repository", "Lcom/android/settingslib/statusbar/notification/data/repository/NotificationsSoundPolicyRepository;", "(Lcom/android/settingslib/statusbar/notification/data/repository/NotificationsSoundPolicyRepository;)V", "areAlarmsAllowed", "Lkotlinx/coroutines/flow/Flow;", "", "getAreAlarmsAllowed", "()Lkotlinx/coroutines/flow/Flow;", "isMediaAllowed", "isRingerAllowed", "isSystemAllowed", "notificationPolicy", "Lkotlinx/coroutines/flow/StateFlow;", "Landroid/app/NotificationManager$Policy;", "getNotificationPolicy", "()Lkotlinx/coroutines/flow/StateFlow;", "zenMode", "Lcom/android/settingslib/statusbar/notification/data/model/ZenMode;", "getZenMode", "isZenMuted", CozeCloudExt.API_KEY_HTTP_STREAM_METHOD, "Lcom/android/settingslib/volume/shared/model/AudioStream;", "isZenMuted-tLTdkI8", "(I)Lkotlinx/coroutines/flow/Flow;", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NotificationsSoundPolicyInteractor {
    private final Flow<Boolean> areAlarmsAllowed;
    private final Flow<Boolean> isMediaAllowed;
    private final Flow<Boolean> isRingerAllowed;
    private final Flow<Boolean> isSystemAllowed;
    private final NotificationsSoundPolicyRepository repository;

    public NotificationsSoundPolicyInteractor(NotificationsSoundPolicyRepository r2) {
        Intrinsics.checkNotNullParameter(r2, "repository");
        this.repository = r2;
        final StateFlow<NotificationManager.Policy> r3 = getNotificationPolicy();
        this.areAlarmsAllowed = new NotificationsSoundPolicyInteractor$special$$inlined$map$1(r3);
        final StateFlow<NotificationManager.Policy> r4 = getNotificationPolicy();
        this.isMediaAllowed = new NotificationsSoundPolicyInteractor$special$$inlined$map$2(r4);
        final StateFlow<NotificationManager.Policy> r5 = getNotificationPolicy();
        this.isSystemAllowed = new NotificationsSoundPolicyInteractor$special$$inlined$map$3(r5);
        final StateFlow<NotificationManager.Policy> r6 = getNotificationPolicy();
        this.isRingerAllowed = new NotificationsSoundPolicyInteractor$special$$inlined$map$4(r6);
    }

    public final StateFlow<NotificationManager.Policy> getNotificationPolicy() {
        return this.repository.getNotificationPolicy();
    }

    public final StateFlow<ZenMode> getZenMode() {
        return this.repository.getZenMode();
    }

    public final Flow<Boolean> getAreAlarmsAllowed() {
        return this.areAlarmsAllowed;
    }

    public final Flow<Boolean> isMediaAllowed() {
        return this.isMediaAllowed;
    }

    public final Flow<Boolean> isSystemAllowed() {
        return this.isSystemAllowed;
    }

    public final Flow<Boolean> isRingerAllowed() {
        return this.isRingerAllowed;
    }

    /* JADX INFO: renamed from: isZenMuted-tLTdkI8, reason: not valid java name */
    public final Flow<Boolean> m780isZenMutedtLTdkI8(int r8) {
        return FlowKt.combine(FlowKt.filterNotNull(getZenMode()), FlowKt.filterNotNull(this.areAlarmsAllowed), FlowKt.filterNotNull(this.isMediaAllowed), FlowKt.filterNotNull(this.isRingerAllowed), FlowKt.filterNotNull(this.isSystemAllowed), new NotificationsSoundPolicyInteractor$isZenMuted$1(r8, null));
    }
}
