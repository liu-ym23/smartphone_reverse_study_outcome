package com.obric.matrix.sdk.push.cross_process;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.obric.matrix.push.common.CommonConstants;
import com.obric.matrix.push.common.CommonSupport;
import com.obric.matrix.push.common.log.Logger;
import com.obric.matrix.sdk.push.IPushClient;
import com.obric.matrix.sdk.push.model.Message;
import com.obric.matrix.sdk.push.model.PushSdkConstants;
import com.obric.matrix.sdk.push.model.RevokeMsg;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class MessageReceiver extends BroadcastReceiver implements IPushClient {
    public MessageReceiver() {
    }

    private final void onEvent(Context r3, Integer r4, String r5) {
        String r2 = null;
        if (r3 != null) goto L15;
        Context r6 = null;
    L8:
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L5
        r0.put(CommonConstants.MSG_TYPE, r4);     // Catch: Throwable -> L5
        r0.put(CommonConstants.MSG_ID, r5);     // Catch: Throwable -> L5
        if (r6 == null) goto L11;
        r2 = r6.getPackageName();     // Catch: Throwable -> L5
    L11:
        r0.put("package_name", r2);     // Catch: Throwable -> L5
        ArrayList<Object> r7 = new ArrayList();     // Catch: Throwable -> L5
        r7.add(PushSdkConstants.EVENT_NAME_PUSH_SDK_RECEIVE);     // Catch: Throwable -> L5
        r7.add(r0.toString());     // Catch: Throwable -> L5
        CommonSupport r8 = CommonSupport.INSTANCE;     // Catch: Throwable -> L5
        Intrinsics.c(r6);     // Catch: Throwable -> L5
        r8.getCrossProcessService(r6).invoke("com.obric.matrix", CommonConstants.CROSS_PROCESS_METHOD_SDK_EVENT, r7, new AnonymousClass1());     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Logger.e("onEvent error: " + th);
        return;
    L15:
        r6 = r3.getApplicationContext();     // Catch: Throwable -> L5
        goto L8
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context r5, @Nullable Intent r6) {
        if (r6 == null) goto L19;
        int r0 = r6.getIntExtra(CommonConstants.MSG_TYPE, 1);
        String r2 = r6.getStringExtra(CommonConstants.MSG_ID);
        onEvent(r5, Integer.valueOf(r0), r2);
        if (r0 != 1) goto L6;
        String r7 = r6.getStringExtra(CommonConstants.KEY_PASS_THOUGH_DATA);
        if (TextUtils.isEmpty(r7) == true) goto L20;
        Intrinsics.c(r2);     // Catch: Throwable -> L15
        Intrinsics.c(r7);     // Catch: Throwable -> L15
        onReceiveMsg(new Message(r2, r7));     // Catch: Throwable -> L15
    L16:
        return;
    L20:
        return;
    L6:
        if (r0 != 2) goto L21;
        String r8 = r6.getStringExtra(CommonConstants.MSG_REVOKE_ID);
        String r9 = r6.getStringExtra(CommonConstants.MSG_REVOKE_DATA);
        Intrinsics.c(r2);     // Catch: Throwable -> L15
        Intrinsics.c(r8);     // Catch: Throwable -> L15
        onRevokeMsg(new RevokeMsg(r2, r8, r9));     // Catch: Throwable -> L15
        goto L16
    L21:
        return;
    L22:
        return;
    }
}
