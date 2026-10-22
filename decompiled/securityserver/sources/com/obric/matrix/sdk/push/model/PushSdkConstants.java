package com.obric.matrix.sdk.push.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class PushSdkConstants {

    @NotNull
    public static final String ERROR_CODE_CALL_PUSH_SERVICE_ERROR = "102";

    @NotNull
    public static final String ERROR_CODE_PARAMS_ERROR = "101";

    @NotNull
    public static final String ERROR_CODE_PUSH_SERVICE_ERROR = "103";

    @NotNull
    public static final String ERROR_MSG_APP_ID_IS_EMPTY = "appId is empty!";

    @NotNull
    public static final String ERROR_MSG_APP_SECRET_IS_EMPTY = "appSecret is empty!";

    @NotNull
    public static final String ERROR_MSG_CALL_PUSH_SERVICE_ERROR = "error when call push_service!";

    @NotNull
    public static final String EVENT_NAME_PUSH_SDK_RECEIVE = "push_sdk_receive";

    @NotNull
    public static final PushSdkConstants INSTANCE = null;

    static {
        INSTANCE = new PushSdkConstants();
    }

    private PushSdkConstants() {
    }
}
