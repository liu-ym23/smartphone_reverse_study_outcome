package com.android.settingslib.statusbar.notification.data.repository;

import android.app.NotificationManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FakeNotificationsSoundPolicyRepository.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u001aF\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0004¨\u0006\n"}, d2 = {"updateNotificationPolicy", "", "Lcom/android/settingslib/statusbar/notification/data/repository/FakeNotificationsSoundPolicyRepository;", "priorityCategories", "", "priorityCallSenders", "priorityMessageSenders", "suppressedVisualEffects", "state", "priorityConversationSenders", "app_debug"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class FakeNotificationsSoundPolicyRepositoryKt {
    public static /* synthetic */ void updateNotificationPolicy$default(FakeNotificationsSoundPolicyRepository r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r9 & 2) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r9 & 4) == 0) goto L12;
        r5 = 3;
    L12:
        if ((r9 & 8) == 0) goto L15;
        r6 = -1;
    L15:
        if ((r9 & 16) == 0) goto L18;
        r7 = -1;
    L18:
        if ((r9 & 32) == 0) goto L20;
        r8 = 3;
    L20:
        updateNotificationPolicy(r2, r3, r4, r5, r6, r7, r8);
    }

    public static final void updateNotificationPolicy(FakeNotificationsSoundPolicyRepository r8, int r9, int r10, int r11, int r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        r8.updateNotificationPolicy(new NotificationManager.Policy(r9, r10, r11, r12, r13, r14));
    }
}
