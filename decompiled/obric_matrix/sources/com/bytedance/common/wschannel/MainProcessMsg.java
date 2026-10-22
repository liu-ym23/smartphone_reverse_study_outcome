package com.bytedance.common.wschannel;

import com.bytedance.common.wschannel.model.WsChannelMsg;

/* JADX INFO: loaded from: classes.dex */
final class MainProcessMsg extends WsChannelMsg {
    private final WsChannelMsg y;
    private final g z;

    MainProcessMsg(WsChannelMsg r1, g r2) {
        super(r1);
        this.y = r1;
        this.z = r2;
    }

    public g S() {
        return this.z;
    }

    WsChannelMsg T() {
        return this.y;
    }
}
