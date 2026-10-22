package com.bytedance.common.wschannel.converter;

import com.bytedance.common.wschannel.model.WsChannelMsg;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public interface MsgConverter {
    WsChannelMsg decode(byte[] r1) throws IOException;

    byte[] encode(WsChannelMsg r1);
}
