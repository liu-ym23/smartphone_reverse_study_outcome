package com.obric.matrix.opush.d.d;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J.\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fH&J\"\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0010H&J,\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0005H&J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0016"}, d2 = {"Lcom/obric/matrix/opush/base/event/IEventService;", "", "onClickPushEvent", "", "msgId", "", "pkgName", "onEvent", "eventName", "params", "Lorg/json/JSONObject;", "needNetReport", "", "needAppLog", "onReceiveMessageEvent", "sentResultCode", "", "onReceivePushEvent", WsConstants.KEY_EXTRA, "onRepeatPushEvent", "id", "onShowPushEvent", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface b {
    void a(String r1, String r2);

    void b(String r1);

    void c(String r1, String r2);

    void d(String r1, String r2, int r3, String r4);
}
