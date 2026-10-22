package com.obric.matrix.opush.d.i;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b`\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0005H&J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH&J\"\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000bH&JA\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0015\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/obric/matrix/opush/base/request/IPushRequestService;", "", "registerAppToken", "", "pkgName", "", "appId", "appKey", "userId", "", "requestCallback", "Lcom/obric/matrix/opush/base/network/IRequestCallback;", "forceUpdateToken", "reportEvent", "events", "Lorg/json/JSONArray;", "unregisterAppToken", "token", "updateDeviceInfo", "sdkVersionName", "sdkVersionCode", "updateType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ILcom/obric/matrix/opush/base/network/IRequestCallback;)V", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface a {

    /* JADX INFO: renamed from: com.obric.matrix.opush.d.i.a$a, reason: collision with other inner class name */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class C0252a {
        public static /* synthetic */ void a(a r6, String r7, String r8, Integer r9, int r10, com.obric.matrix.opush.base.network.b r11, int r12, Object r13) {
            if (r13 != null) goto L20;
            if ((r12 & 2) == 0) goto L6;
            r8 = "";
        L6:
            String r2 = r8;
            if ((r12 & 4) == 0) goto L9;
            Integer r3 = null;
        L11:
            if ((r12 & 8) == 0) goto L13;
            r10 = com.obric.matrix.opush.f.b.G.A();
        L13:
            int r4 = r10;
            if ((r12 & 16) == 0) goto L16;
            com.obric.matrix.opush.base.network.b r5 = null;
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

    void a(String r1, String r2, com.obric.matrix.opush.base.network.b r3);

    void b(String r1, String r2, String r3, int r4, com.obric.matrix.opush.base.network.b r5, String r6);

    void c(String r1, String r2, Integer r3, int r4, com.obric.matrix.opush.base.network.b r5);
}
