package com.obric.matrix.platform.sdk.ones.internal.monitor;

import kotlin.Metadata;

/* JADX INFO: compiled from: SdkErrorCode.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/internal/monitor/SdkErrorCode;", "", "()V", "ERROR_BINDER_CONNECT_EXCEPTION", "", "ERROR_BINDER_DEAD_EXCEPTION", "ERROR_BINDER_INVOKE_EXCEPTION", "ERROR_REASON_BINDER_CONNECT_ERROR", "", "ERROR_REASON_RECEIVE_RESULT_EXCEPTION", "ERROR_REASON_SEND_CMD_ASYNC_ERROR", "ERROR_REASON_SEND_CMD_ERROR", "ERROR_REASON_SEND_CMD_TIMEOUT", "ERROR_RECEIVER_RESULT_EXCEPTION", "ERROR_SEND_CMD_ASYNC_ERROR", "ERROR_SEND_CMD_ERROR", "ERROR_SEND_CMD_TIMEOUT", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SdkErrorCode {
    public static final int ERROR_BINDER_CONNECT_EXCEPTION = -20002;
    public static final int ERROR_BINDER_DEAD_EXCEPTION = -20005;
    public static final int ERROR_BINDER_INVOKE_EXCEPTION = -20006;
    public static final String ERROR_REASON_BINDER_CONNECT_ERROR = "binder connect error";
    public static final String ERROR_REASON_RECEIVE_RESULT_EXCEPTION = "receive result exception";
    public static final String ERROR_REASON_SEND_CMD_ASYNC_ERROR = "send cmd internal error";
    public static final String ERROR_REASON_SEND_CMD_ERROR = "send cmd internal error";
    public static final String ERROR_REASON_SEND_CMD_TIMEOUT = "send cmd timeout";
    public static final int ERROR_RECEIVER_RESULT_EXCEPTION = -20004;
    public static final int ERROR_SEND_CMD_ASYNC_ERROR = -20003;
    public static final int ERROR_SEND_CMD_ERROR = -20000;
    public static final int ERROR_SEND_CMD_TIMEOUT = -20001;
    public static final SdkErrorCode INSTANCE = null;

    static {
        INSTANCE = new SdkErrorCode();
    }

    private SdkErrorCode() {
    }
}
