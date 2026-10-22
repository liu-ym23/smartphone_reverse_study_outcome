package com.bytedance.common.wschannel.app;

import com.bytedance.common.wschannel.event.MessageAckEvent;

/* JADX INFO: loaded from: classes.dex */
public interface OnMessageAckListener {
    void onReceiveMsgAck(MessageAckEvent r1);
}
