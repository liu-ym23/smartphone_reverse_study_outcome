package com.obric.matrix.push.m.i;

import android.content.Intent;
import com.obric.matrix.push.g;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH&J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH&J\"\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H&¨\u0006\u0015"}, d2 = {"Lcom/obric/matrix/push/base/message/IPushMsgHandleService;", "", "checkPackagePushEnable", "", "pkg", "", "notificationType", "handleExpiredHistoryMsg", "", "handleInterceptor", "", "push", "Lcom/obric/matrix/push/Push;", "passthough", "handlePush", "onHandlePushClick", "msgId", "pkgName", "intent", "Landroid/content/Intent;", "onHandlePushShow", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface c {
    void a(String r1, String r2);

    void b();

    void c(String r1, String r2, Intent r3);

    void d(g r1);
}
