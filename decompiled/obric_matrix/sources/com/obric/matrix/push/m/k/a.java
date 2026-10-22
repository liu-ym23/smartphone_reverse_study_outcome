package com.obric.matrix.push.m.k;

import android.content.Intent;
import com.obric.matrix.push.g;
import com.obric.matrix.push.k;
import com.obric.matrix.push_api.e;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Lcom/obric/matrix/push/base/notification/INotificationService;", "", "cancelNotification", "", "revoke", "Lcom/obric/matrix/push/Revoke;", "showNotification", "push", "Lcom/obric/matrix/push/Push;", "notification", "Lcom/obric/matrix/push_api/Notification;", "intent", "Landroid/content/Intent;", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface a {
    void a(g r1);

    void b(k r1);

    void showNotification(e r1, Intent r2);
}
