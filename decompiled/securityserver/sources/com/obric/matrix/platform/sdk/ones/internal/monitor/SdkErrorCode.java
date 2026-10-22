package com.obric.matrix.platform.sdk.ones.internal.monitor;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SdkErrorCode {
    public static final int ERROR_BINDER_CONNECT_EXCEPTION = -20002;
    public static final int ERROR_BINDER_DEAD_EXCEPTION = -20005;
    public static final int ERROR_BINDER_INVOKE_EXCEPTION = -20006;

    @NotNull
    public static final String ERROR_REASON_BINDER_CONNECT_ERROR = "binder connect error";

    @NotNull
    public static final String ERROR_REASON_RECEIVE_RESULT_EXCEPTION = "receive result exception";

    @NotNull
    public static final String ERROR_REASON_SEND_CMD_ASYNC_ERROR = "send cmd internal error";

    @NotNull
    public static final String ERROR_REASON_SEND_CMD_ERROR = "send cmd internal error";

    @NotNull
    public static final String ERROR_REASON_SEND_CMD_TIMEOUT = "send cmd timeout";
    public static final int ERROR_RECEIVER_RESULT_EXCEPTION = -20004;
    public static final int ERROR_SEND_CMD_ASYNC_ERROR = -20003;
    public static final int ERROR_SEND_CMD_ERROR = -20000;
    public static final int ERROR_SEND_CMD_TIMEOUT = -20001;

    @NotNull
    public static final SdkErrorCode INSTANCE = null;

    static {
        INSTANCE = new SdkErrorCode();
    }

    private SdkErrorCode() {
    }
}
