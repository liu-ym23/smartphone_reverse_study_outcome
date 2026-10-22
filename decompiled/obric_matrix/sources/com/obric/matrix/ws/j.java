package com.obric.matrix.ws;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/matrix/ws/WsParams;", "", "()V", "APPKEY", "", "APPKEY_BOE", "PRODUCT_ID", "", "SLARDAR_MSG_METHOD", "SLARDAR_MSG_SERVICE", "WSURL", "WSURL_BOE", "getAppKey", "getUrl", "ws_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f10634a = null;

    static {
        f10634a = new j();
    }

    private j() {
    }

    public final String a() {
        com.obric.matrix.base.env.d.f8838a.e();
        return "f5c842f5cb5d88403005a8ec45694d2d";
    }

    public final String b() {
        if (com.obric.matrix.base.env.d.f8838a.e() == false) goto L5;
        return "ws://frontier-boe.bytedance.net/ws/v2";
    L5:
        return "wss://frontier.snssdk.com/ws/v2";
    }
}
