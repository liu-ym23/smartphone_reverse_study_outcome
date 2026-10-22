package com.obric.matrix.push.m.d;

import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J.\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fH&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H&J\"\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u0011H&J\"\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u0011H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0005H&J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0017"}, d2 = {"Lcom/obric/matrix/push/base/event/IEventService;", "", "onClickPushEvent", "", "msgId", "", "pkgName", "onEvent", "eventName", "params", "Lorg/json/JSONObject;", "needNetReport", "", "needAppLog", "onNotifyEnableEvent", "id", "reason", "", "onReceiveMessageEvent", "sentResultCode", "onReceivePushEvent", "onRepeatPushEvent", "onShowPushEvent", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface c {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public static /* synthetic */ void a(c r0, String r1, JSONObject r2, boolean r3, boolean r4, int r5, Object r6) {
            if (r6 != null) goto L12;
            if ((r5 & 4) == 0) goto L7;
            r3 = false;
        L7:
            if ((r5 & 8) == 0) goto L9;
            r4 = true;
        L9:
            r0.e(r1, r2, r3, r4);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onEvent");
        }
    }

    void a(String r1, String r2);

    void b(String r1);

    void c(String r1, String r2);

    void d(String r1, String r2, int r3);

    void e(String r1, JSONObject r2, boolean r3, boolean r4);

    void f(String r1, String r2, int r3);
}
