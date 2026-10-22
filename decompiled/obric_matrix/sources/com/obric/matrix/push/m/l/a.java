package com.obric.matrix.push.m.l;

import com.obric.matrix.push.base.network.c;
import kotlin.Metadata;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0005H&J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\rH&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH&JA\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/obric/matrix/push/base/request/IPushRequestService;", "", "registerAppToken", "", "pkgName", "", "appId", "appKey", "requestCallback", "Lcom/obric/matrix/push/base/network/IRequestCallback;", "forceUpdateToken", "reportEvent", "events", "Lorg/json/JSONArray;", "updateDeviceInfo", "sdkVersionName", "sdkVersionCode", "", "updateType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ILcom/obric/matrix/push/base/network/IRequestCallback;)V", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface a {

    /* JADX INFO: renamed from: com.obric.matrix.push.m.l.a$a, reason: collision with other inner class name */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class C0273a {
        public static /* synthetic */ void a(a r6, String r7, String r8, Integer r9, int r10, c r11, int r12, Object r13) {
            if (r13 != null) goto L20;
            if ((r12 & 2) == 0) goto L6;
            r8 = "";
        L6:
            String r2 = r8;
            if ((r12 & 4) == 0) goto L9;
            Integer r3 = null;
        L11:
            if ((r12 & 8) == 0) goto L13;
            r10 = com.obric.matrix.push.p.b.h0.X();
        L13:
            int r4 = r10;
            if ((r12 & 16) == 0) goto L16;
            c r5 = null;
        L17:
            r6.c(r7, r2, r3, r4, r5);
            return;
        L16:
            r5 = r11;
            goto L17
        L9:
            r3 = r9;
            goto L11
        L20:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateDeviceInfo");
        }
    }

    void a(String r1, String r2, String r3, c r4, String r5);

    String b(JSONArray r1);

    void c(String r1, String r2, Integer r3, int r4, c r5);
}
