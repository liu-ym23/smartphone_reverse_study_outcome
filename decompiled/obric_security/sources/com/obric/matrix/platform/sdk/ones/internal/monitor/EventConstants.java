package com.obric.matrix.platform.sdk.ones.internal.monitor;

import kotlin.Metadata;

/* JADX INFO: compiled from: EventConstants.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/internal/monitor/EventConstants;", "", "()V", "EVENT_BIND_RESULT", "", "EVENT_KEY_CALLBACK_USE_TIME", "EVENT_KEY_CMD", "EVENT_KEY_COST_TIME", "EVENT_KEY_ERROR_CODE", "EVENT_KEY_ERROR_MESSAGE", "EVENT_KEY_PACKAGE_NAME", "EVENT_KEY_PROCESS_TIME", "EVENT_KEY_RESULT", "EVENT_KEY_START_CALLBACK_TIME", "EVENT_KEY_START_INTENT_USE_TIME", "EVENT_KEY_START_TIME", "EVENT_KEY_STATUS", "EVENT_KEY_WAY", "EVENT_SEND_CMD_RESULT", "EVENT_SEND_CMD_START", "EVENT_VALUE_FALSE", "EVENT_VALUE_TRUE", "SEND_CMD_WAY_BINDER", "", "SEND_CMD_WAY_INTENT_SERVICE", "SEND_CMD_WAY_PROVIDER", "STATUS_RECEIVER_RESULT", "STATUS_START", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EventConstants {
    public static final String EVENT_BIND_RESULT = "event_bind_result";
    public static final String EVENT_KEY_CALLBACK_USE_TIME = "callback_use_time";
    public static final String EVENT_KEY_CMD = "cmd";
    public static final String EVENT_KEY_COST_TIME = "cost_time";
    public static final String EVENT_KEY_ERROR_CODE = "error_code";
    public static final String EVENT_KEY_ERROR_MESSAGE = "error_message";
    public static final String EVENT_KEY_PACKAGE_NAME = "package_name";
    public static final String EVENT_KEY_PROCESS_TIME = "process_time";
    public static final String EVENT_KEY_RESULT = "result";
    public static final String EVENT_KEY_START_CALLBACK_TIME = "start_callback_time";
    public static final String EVENT_KEY_START_INTENT_USE_TIME = "start_intent_use_time";
    public static final String EVENT_KEY_START_TIME = "start_time";
    public static final String EVENT_KEY_STATUS = "status";
    public static final String EVENT_KEY_WAY = "way";
    public static final String EVENT_SEND_CMD_RESULT = "event_send_cmd_result";
    public static final String EVENT_SEND_CMD_START = "event_send_cmd_start";
    public static final String EVENT_VALUE_FALSE = "0";
    public static final String EVENT_VALUE_TRUE = "1";
    public static final EventConstants INSTANCE = null;
    public static final int SEND_CMD_WAY_BINDER = 1;
    public static final int SEND_CMD_WAY_INTENT_SERVICE = 2;
    public static final int SEND_CMD_WAY_PROVIDER = 3;
    public static final String STATUS_RECEIVER_RESULT = "status_receiver_result";
    public static final String STATUS_START = "status_start";

    static {
        INSTANCE = new EventConstants();
    }

    private EventConstants() {
    }
}
