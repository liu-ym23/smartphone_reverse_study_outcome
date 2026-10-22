package com.obric.matrix.platform.sdk.ones.internal.monitor;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class EventConstants {

    @NotNull
    public static final String EVENT_BIND_RESULT = "event_bind_result";

    @NotNull
    public static final String EVENT_KEY_CALLBACK_USE_TIME = "callback_use_time";

    @NotNull
    public static final String EVENT_KEY_CMD = "cmd";

    @NotNull
    public static final String EVENT_KEY_COST_TIME = "cost_time";

    @NotNull
    public static final String EVENT_KEY_ERROR_CODE = "error_code";

    @NotNull
    public static final String EVENT_KEY_ERROR_MESSAGE = "error_message";

    @NotNull
    public static final String EVENT_KEY_PACKAGE_NAME = "package_name";

    @NotNull
    public static final String EVENT_KEY_PROCESS_TIME = "process_time";

    @NotNull
    public static final String EVENT_KEY_RESULT = "result";

    @NotNull
    public static final String EVENT_KEY_START_CALLBACK_TIME = "start_callback_time";

    @NotNull
    public static final String EVENT_KEY_START_INTENT_USE_TIME = "start_intent_use_time";

    @NotNull
    public static final String EVENT_KEY_START_TIME = "start_time";

    @NotNull
    public static final String EVENT_KEY_STATUS = "status";

    @NotNull
    public static final String EVENT_KEY_WAY = "way";

    @NotNull
    public static final String EVENT_SEND_CMD_RESULT = "event_send_cmd_result";

    @NotNull
    public static final String EVENT_SEND_CMD_START = "event_send_cmd_start";

    @NotNull
    public static final String EVENT_VALUE_FALSE = "0";

    @NotNull
    public static final String EVENT_VALUE_TRUE = "1";

    @NotNull
    public static final EventConstants INSTANCE = null;
    public static final int SEND_CMD_WAY_BINDER = 1;
    public static final int SEND_CMD_WAY_INTENT_SERVICE = 2;
    public static final int SEND_CMD_WAY_PROVIDER = 3;

    @NotNull
    public static final String STATUS_RECEIVER_RESULT = "status_receiver_result";

    @NotNull
    public static final String STATUS_START = "status_start";

    static {
        INSTANCE = new EventConstants();
    }

    private EventConstants() {
    }
}
