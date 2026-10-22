package com.bytedance.sync.v2.f;

import android.content.Context;
import com.bytedance.common.wschannel.model.WsChannelMsg;

/* JADX INFO: loaded from: classes.dex */
public interface e extends com.ss.android.ug.bus.a {
    com.bytedance.sync.v2.j.e I(byte[] r1);

    byte[] s(com.bytedance.sync.v2.j.e r1);

    WsChannelMsg t(Context r1, com.bytedance.sync.v2.j.e r2);
}
