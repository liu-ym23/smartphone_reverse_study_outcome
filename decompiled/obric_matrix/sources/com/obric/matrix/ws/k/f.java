package com.obric.matrix.ws.k;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0011\u001a\u00020\u0006H&¨\u0006\u0012"}, d2 = {"Lcom/obric/matrix/ws/internal/IWsChannelRegister;", "", "isConnected", "", "isConnectedWithUid", "notifyHeartbeat", "", "onParamChanged", "scene", "", "registerChannel", "context", "Landroid/content/Context;", "registerListener", "listener", "Lcom/obric/matrix/ws_api/IWsChannelListener;", "removeListener", "unRegisterChannel", "ws_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface f {
    boolean isConnected();

    void registerListener(com.obric.matrix.ws_api.a r1);
}
