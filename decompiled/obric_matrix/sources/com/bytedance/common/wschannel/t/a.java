package com.bytedance.common.wschannel.t;

import android.content.Context;
import android.os.Bundle;
import com.ss.android.message.log.PushLog;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static void a(Context r0, String r1, Bundle r2) {
        PushLog.onEventV3Bundle(r0, r1, r2);     // Catch: Throwable -> L4
        return;
    }
}
