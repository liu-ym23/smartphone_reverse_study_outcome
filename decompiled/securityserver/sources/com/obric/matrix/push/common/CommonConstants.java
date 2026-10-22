package com.obric.matrix.push.common;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class CommonConstants {

    @NotNull
    public static final String APP_ID = "app_id";

    @NotNull
    public static final String APP_KEY = "app_key";

    @NotNull
    public static final String APP_VERSION = "app_version";

    @NotNull
    public static final String CROSS_PROCESS_ACTION = ".action.CROSS_PROCESS";

    @NotNull
    public static final String CROSS_PROCESS_IS_FROM_ON_BIND = "is_from_on_bind";

    @NotNull
    public static final String CROSS_PROCESS_METHOD_RECEIVE_MESSAGE = "receive_message";

    @NotNull
    public static final String CROSS_PROCESS_METHOD_REGISTER_CHANNEL = "register_channel";

    @NotNull
    public static final String CROSS_PROCESS_METHOD_SDK_EVENT = "sdk_event";

    @NotNull
    public static final String CROSS_PROCESS_METHOD_UN_REGISTER_CHANNEL = "un_register_channel";

    @NotNull
    public static final String CROSS_PROCESS_ORIGIN_PACKAGE_NAME = "origin_package_name";

    @NotNull
    public static final String DATA = "data";
    public static final int ERROR_CODE_NETWORK_ERROR = 101;

    @NotNull
    public static final String ERROR_MSG_UNKNOWN_ERROR = "unknown_error";

    @NotNull
    public static final CommonConstants INSTANCE = null;

    @NotNull
    public static final String KEY_PASS_THOUGH_DATA = "pass_though_data";

    @NotNull
    public static final String MSG_FAILED = "failed";

    @NotNull
    public static final String MSG_ID = "msg_id";

    @NotNull
    public static final String MSG_REVOKE_DATA = "revoke_data";

    @NotNull
    public static final String MSG_REVOKE_ID = "revoke_id";

    @NotNull
    public static final String MSG_SUCCESS = "success";

    @NotNull
    public static final String MSG_TYPE = "msg_type";

    @NotNull
    public static final String PACKAGE_NAME = "package_name";

    @NotNull
    public static final String PASS_THROUGH_MSG_ACTION = ".action.MESSAGE_EVENT";

    @NotNull
    public static final String PUSH_SERVICE_PKG_NAME = "com.obric.matrix";

    @NotNull
    public static final String RESPONSE_CODE = "code";
    public static final int RESPONSE_CODE_ERROR = -1;
    public static final int RESPONSE_CODE_SUCCESS = 0;

    @NotNull
    public static final String RESPONSE_MESSAGE = "message";

    @NotNull
    public static final String RESULT = "result";

    @NotNull
    public static final String SENT_RESULT_CODE = "sent_result_code";

    @NotNull
    public static final String VALUE_FALSE = "0";

    @NotNull
    public static final String VALUE_TRUE = "1";

    static {
        INSTANCE = new CommonConstants();
    }

    private CommonConstants() {
    }
}
