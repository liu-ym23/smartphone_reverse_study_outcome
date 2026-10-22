package com.bytedance.common.wschannel.client;

import androidx.annotation.NonNull;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.event.ConnectionState;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseIntentParse implements IntentParse {

    @NonNull
    protected final ClientMsgParser.ParserListener mListener;

    public BaseIntentParse(@NonNull ClientMsgParser.ParserListener r1) {
        this.mListener = r1;
    }

    @NonNull
    public ConnectionState syncConnectState(int r4, int r5, boolean r6) {
        ConnectionState r0 = ConnectionState.CONNECTION_UNKNOWN;
        if (r5 == 0) goto L18;
        if (r5 != 1) goto L9;
        r0 = ConnectionState.CONNECTING;
        goto L18
    L9:
        if (r5 != 2) goto L12;
        r0 = ConnectionState.CONNECT_FAILED;
        goto L18
    L12:
        if (r5 != 3) goto L15;
        r0 = ConnectionState.CONNECT_CLOSED;
        goto L18
    L15:
        if (r5 != 4) goto L18;
        r0 = ConnectionState.CONNECTED;
    L18:
        if (Logger.debug() == false) goto L20;
        Logger.d(AbsWsClientService.TAG, "state = " + r5 + " connectionState = " + r0);
    L20:
        this.mListener.syncState(r4, r0, r6);
        return r0;
    }
}
