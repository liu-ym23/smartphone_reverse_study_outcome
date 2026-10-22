package com.bytedance.common.wschannel.converter;

import com.bytedance.common.wschannel.model.WsChannelMsg;

/* JADX INFO: loaded from: classes.dex */
public interface MsgConverter {
    WsChannelMsg decode(byte[] r1);

    byte[] encode(WsChannelMsg r1);
}
