package com.obric.matrix.sdk.push;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.obric.matrix.push.common.CommonConstants;
import com.obric.matrix.push.common.CommonSupport;
import com.obric.matrix.push.common.log.Logger;
import com.obric.matrix.sdk.push.model.PushSdkConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class PushImpl {

    @NotNull
    private final String TAG;

    public PushImpl() {
        this.TAG = "PushImpl";
    }

    public static final /* synthetic */ String access$getTAG$p(PushImpl r0) {
        return r0.TAG;
    }

    private final void onEvent(Context r4) {
        Context r3 = r4.getApplicationContext();     // Catch: Throwable -> L4
        String r5 = r4.getPackageName();     // Catch: Throwable -> L4
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L4
        r0.put("package_name", r5);     // Catch: Throwable -> L4
        ArrayList<Object> r6 = new ArrayList();     // Catch: Throwable -> L4
        r6.add("push_sdk_register");     // Catch: Throwable -> L4
        r6.add(r0.toString());     // Catch: Throwable -> L4
        CommonSupport r1 = CommonSupport.INSTANCE;     // Catch: Throwable -> L4
        Intrinsics.c(r3);     // Catch: Throwable -> L4
        r1.getCrossProcessService(r3).invoke("com.obric.matrix", CommonConstants.CROSS_PROCESS_METHOD_SDK_EVENT, r6, new AnonymousClass1());     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        String r7 = Log.getStackTraceString(th);
        Intrinsics.e(r7, "getStackTraceString(e)");
        Logger.e(r7);
    }

    public final void registerPush(@NotNull Context r4, @NotNull PushConfiguration r5, @NotNull final IRegisterCallback r6) {
        Intrinsics.f(r4, "context");
        Intrinsics.f(r5, "pushConfiguration");
        Intrinsics.f(r6, "registerCallback");
        Logger.d(this.TAG, "registerPush");
        if (TextUtils.isEmpty(r5.getAppId()) == false) goto L7;
        r6.onFailed(PushSdkConstants.ERROR_CODE_PARAMS_ERROR, PushSdkConstants.ERROR_MSG_APP_ID_IS_EMPTY);
        return;
    L7:
        if (TextUtils.isEmpty(r5.getAppKey()) == false) goto L10;
        r6.onFailed(PushSdkConstants.ERROR_CODE_PARAMS_ERROR, PushSdkConstants.ERROR_MSG_APP_SECRET_IS_EMPTY);
        return;
    L10:
        ArrayList<Object> r0 = new ArrayList();
        r0.add(r5.getAppId());
        r0.add(r5.getAppKey());
        Logger.d(this.TAG, "invoke register_channel");
        onEvent(r4);     // Catch: Throwable -> L13
        CommonSupport.INSTANCE.getCrossProcessService(r4).invoke("com.obric.matrix", CommonConstants.CROSS_PROCESS_METHOD_REGISTER_CHANNEL, r0, new C00381(this, r6));     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        r6.onFailed(PushSdkConstants.ERROR_CODE_CALL_PUSH_SERVICE_ERROR, "error when call push_service! " + th.getMessage());
    }

    public final void unRegisterPush(@NotNull Context r4) {
        Intrinsics.f(r4, "context");
        CommonSupport.INSTANCE.getCrossProcessService(r4).invoke("com.obric.matrix", CommonConstants.CROSS_PROCESS_METHOD_UN_REGISTER_CHANNEL, null, null);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Logger.d(this.TAG, "error when unRegister: " + th.getMessage());
    }
}
