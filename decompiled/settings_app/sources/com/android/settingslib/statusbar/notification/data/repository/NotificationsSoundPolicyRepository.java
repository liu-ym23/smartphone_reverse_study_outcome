package com.android.settingslib.statusbar.notification.data.repository;

import android.app.NotificationManager;
import com.android.settingslib.statusbar.notification.data.model.ZenMode;
import kotlin.Metadata;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: NotificationsSoundPolicyRepository.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003X¦\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/android/settingslib/statusbar/notification/data/repository/NotificationsSoundPolicyRepository;", "", "notificationPolicy", "Lkotlinx/coroutines/flow/StateFlow;", "Landroid/app/NotificationManager$Policy;", "getNotificationPolicy", "()Lkotlinx/coroutines/flow/StateFlow;", "zenMode", "Lcom/android/settingslib/statusbar/notification/data/model/ZenMode;", "getZenMode", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface NotificationsSoundPolicyRepository {
    StateFlow<NotificationManager.Policy> getNotificationPolicy();

    StateFlow<ZenMode> getZenMode();
}
