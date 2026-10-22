package com.obric.matrix.opush.d.g;

import android.content.Intent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\"\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H&J\b\u0010\u000f\u001a\u00020\u0003H&J$\u0010\u0010\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J$\u0010\u0013\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H&J$\u0010\u0019\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&¨\u0006\u001a"}, d2 = {"Lcom/obric/matrix/opush/base/message/IPushMsgHandleService;", "", "handleExpiredHistoryMsg", "", "handleMessage", "payloadType", "", "message", "", "onHandlePushClick", "msgId", "pkgName", "intent", "Landroid/content/Intent;", "onHandlePushShow", "resendPendingReceipts", "sendClickReceipt", "receiptContext", "Lcom/obric/matrix/opush/base/message/ReceiptContext;", "sendDeleteReceipt", "sendNotificationDisabledReceipt", "Lcom/obric/matrix/o/push/Message;", "sendPing", "heartbeatCount", "", "sendShowReceipt", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface d {
    void a(String r1, String r2);

    void b();

    void c(String r1, String r2, Intent r3);

    void d(String r1, byte[] r2);

    void e(String r1, String r2, f r3);

    void f(String r1, String r2, f r3);

    void g(String r1, String r2, f r3);

    void h();

    void sendPing(long r1);
}
