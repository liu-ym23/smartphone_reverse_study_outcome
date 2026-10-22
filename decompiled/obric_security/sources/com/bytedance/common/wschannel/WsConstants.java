package com.bytedance.common.wschannel;

import com.bytedance.common.wschannel.app.OnBindWsChannelServiceListener;
import com.bytedance.common.wschannel.app.OnMessageAckListener;
import com.bytedance.common.wschannel.app.OnMessageReceiveListener;
import com.bytedance.common.wschannel.app.OnServiceConnectListener;
import com.bytedance.common.wschannel.event.ConnectionState;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class WsConstants {
    public static final String APP_STATE_ACTION = "com.bytedance.article.wschannel.appstate";
    public static final String APP_STATE_BACKGROUND_KEY = "IsBackground";
    public static final int APP_STATE_CHANGE_METHOD = 4;
    public static final int APP_STATE_CHANGE_SERVICE = 9000;
    public static final int APP_STATE_DID_ENTER_BACKGROUND_INACTIVE = 3;
    public static final int APP_STATE_DID_ENTER_FOREGROUND = 1;
    public static final int APP_STATE_WILL_ENTER_BACKGROUND = 2;
    public static final int CHANNEL_TYPE_OK = 2;
    public static final String DATA_INTENT = "DATA_INTENT";
    public static final long DEFAULT_IO_LIMIT = 102400;
    public static final String ERROR_CODE = "error_code";
    public static final int ERROR_CODE_HEART_BEAT_TIMEOUT = 3;
    public static final int ERROR_CODE_NETWORK = 1;
    public static final int ERROR_CODE_RETRY_FAILED = 2;
    public static final int ERROR_CODE_URL_PARSE_FAILED = 4;
    public static final long EXIT_DELAY_TIME = 3000;
    public static final String KEY_ACK_CODE = "ack_code";
    public static final String KEY_ACK_ID = "ack_id";
    public static final String KEY_APP_ID = "aid";
    public static final String KEY_APP_KEY = "app_key";
    public static final String KEY_APP_STATE = "app_state";
    public static final String KEY_APP_VERSION = "app_version";
    public static final String KEY_AUTO_CONNECT_DISABLED = "auto_connect_disabled";
    public static final String KEY_CHANNEL_ID = "channel_id";
    public static final String KEY_CHANNEL_TYPE = "channel_type";
    public static final String KEY_CONNECTION = "connection";
    public static final String KEY_CONNECTION_ERROR = "error";
    public static final String KEY_CONNECTION_STATE = "state";
    public static final String KEY_CONNECTION_TYPE = "type";
    public static final String KEY_CONNECTION_URL = "url";
    public static final String KEY_DEVICE_ID = "device_id";
    public static final String KEY_DISABLE_FALLBACK_WEBSOCKET = "disable_fallback_websocket";
    public static final String KEY_ENABLE_OFFLINE_DETECT = "key_enable_offline_detect";
    public static final String KEY_ENABLE_REPORT_APP_STATE = "enableAppStateChangeReport";
    public static final String KEY_EXTRA = "extra";
    public static final String KEY_FPID = "fpid";
    public static final String KEY_FRONTIER_ENABLED = "frontier_enabled";
    public static final String KEY_FRONTIER_MSGID = "x_frontier_msgid";
    public static final String KEY_FRONTIER_URLS = "frontier_urls";
    public static final String KEY_HEADERS = "custom_headers";
    public static final String KEY_INSTALL_ID = "iid";
    public static final String KEY_IO_LIMIT = "key_io_limit_size";
    public static final String KEY_IS_ACK = "is_ack";
    public static final String KEY_MEM_TRIM = "mem_trim";
    public static final String KEY_MONITOR_SERVICE_ID_LIST = "monitor_service_id_list";
    public static final String KEY_NEED_ACK = "need_ack";
    public static final String KEY_NETWORK_STATE = "network_state";
    public static final String KEY_OK_IMPL_ENABLE = "key_ok_impl_enable";
    public static final String KEY_PAYLOAD = "payload";
    public static final String KEY_PAYLOAD_MD5 = "payload_md5";
    public static final String KEY_PLATFORM = "platform";
    public static final String KEY_PRIVATE_PROTOCOL_ENABLE = "private_protocol_enable";
    public static final String KEY_PRIVATE_PROTOCOL_URL = "private_protocol_url";
    public static final String KEY_PROGRESS = "link_progress";
    public static final String KEY_RECEIVE_DATA_FROM_IPC = "key_receive_data_from_ipc";
    public static final String KEY_RETRY_SEND_MSG_DELAY = "key_retry_send_msg_delay";
    public static final String KEY_SDK_VERSION = "sdk_version";
    public static final String KEY_SEND_RESULT = "send_result";
    public static final String KEY_SERVICE = "service";
    public static final String KEY_SERVICE_ID_LIST = "service_id_list";
    public static final String KEY_SESSION_ID = "sid";
    public static final String KEY_TRANSPORT_MODE = "transport_mode";
    public static final String KEY_WS_APP = "ws_app";
    public static final String KEY_WS_APPS = "ws_apps";
    public static final String MEM_TRIM_ACTION = "com.bytedance.article.wschannel.mem_trim";
    public static final int MSG_APP_STATE_CHANGE = 2;
    public static final String MSG_COUNT = "msg_count";
    public static final int MSG_INIT = 7;
    public static final int MSG_INTENT = 10123;
    public static final int MSG_NETWORK_STATE_CHANGE = 3;
    public static final int MSG_PARAMETER_CHANGE = 4;
    public static final int MSG_PLUGIN_DOWNLOAD = 6;
    public static final int MSG_RECEIVE_PAYLOAD = 40;
    public static final int MSG_REGISTER = 0;
    public static final int MSG_REGISTER_SERVICE = 12;
    public static final int MSG_RELEASE_CLIENT = 8;
    public static final int MSG_RETRY_SEND_PAYLOAD = 10;
    public static final int MSG_SEND_PAYLOAD = 5;
    public static final int MSG_SEND_PAYLOAD_RESULT = 41;
    public static final int MSG_UNREGISTER = 1;
    public static final int MSG_UNREGISTER_SERVICE = 13;
    public static final String NETWORK_STATE_ACTION = "com.bytedance.article.wschannel.networkstate";
    public static final int NETWORK_STATE_NOT_REACHABLE = 2;
    public static final int NETWORK_STATE_REACHABLE_UNKNOWN = 1;
    public static final int NETWORK_STATE_REACHABLE_VIA_WIFI = 3;
    public static final int NETWORK_STATE_REACHABLE_VIA_WWAN = 4;
    public static final int NE_2G = 2;
    public static final int NE_3G = 3;
    public static final int NE_4G = 4;
    public static final int NE_UNKNOWN = 0;
    public static final int NE_WIFI = 1;
    public static final String PING_NOT_RECEIVE_PONG_MSG = "sent ping but didn't receive pong";
    public static final int PLATFORM_ANDROID = 0;
    public static final String PUSH_CHANNEL_LOG_TYPE = "ss_lcs_v2";
    public static final String RECEIVE_CONNECTION_ACTION = "com.bytedance.article.wschannel.receive.connection";
    public static final String RECEIVE_PAYLOAD_ACTION = "com.bytedance.article.wschannel.receive.payload";
    public static final String RECEIVE_PROGRESS_ACTION = "com.bytedance.article.wschannel.receive.progress";
    public static final String RECEIVE_SERVICE_ACTION = "com.bytedance.article.wschannel.receive.service";
    public static final long RELEASE_DELAY = 1000;
    public static final String SALT = "f8a69f1719916z";
    public static final int SDK_VERSION = 2;
    public static final int SELF_CHANNEL = 1;
    public static final String SEND_PAYLOAD_ACTION = "com.bytedance.article.wschannel.send.payload";
    public static final String SYNC_CONNECT_STATE = "com.bytedance.article.wschannel.syncconnectstate";
    public static final int SYNC_SOCKET_STATE = 9;
    public static final String TTNET_TRAFFIC_CONTROL_DROP = "ERR_TTNET_TRAFFIC_CONTROL_DROP, -555 ";
    public static final int WAKE_UP_PROCESS = 11;
    private static volatile ConfigProvider<Boolean> optLogic;
    private static OnMessageAckListener sAckListener;
    private static OnBindWsChannelServiceListener sBindWsChannelServiceListener;
    private static OnMessageReceiveListener sListener;
    private static Map<Integer, Boolean> sPrivateProtocolState;
    private static OnServiceConnectListener sServiceListener;
    private static final Object sServiceLock = null;
    private static Map<Integer, Map<Integer, Boolean>> sServiceState;
    private static Map<Integer, ConnectionState> sStates;

    public WsConstants() {
    }

    static {
        sStates = new ConcurrentHashMap();
        sPrivateProtocolState = new ConcurrentHashMap();
        sServiceState = new HashMap();
        sServiceLock = new Object();
        optLogic = DefaultConfigProviders.DEFAULT_BOOLEAN;
    }

    public static void setOnMessageReceiveListener(OnMessageReceiveListener r0) {
        sListener = r0;
    }

    public static OnBindWsChannelServiceListener getBindWsChannelServiceListener() {
        return sBindWsChannelServiceListener;
    }

    public static void setBindWsChannelServiceListener(OnBindWsChannelServiceListener r0) {
        sBindWsChannelServiceListener = r0;
    }

    public static ConfigProvider<Boolean> getOptLogic() {
        return optLogic;
    }

    static void setOptLogic(ConfigProvider<Boolean> r0) {
        if (r0 != null) goto L4;
        return;
    L4:
        optLogic = r0;
    }

    public static OnMessageReceiveListener getListener(int r0) {
        return sListener;
    }

    public static OnMessageAckListener getMessageAckListener() {
        return sAckListener;
    }

    public static void setMessageAckListener(OnMessageAckListener r0) {
        sAckListener = r0;
    }

    public static OnServiceConnectListener getServiceConnectListener() {
        return sServiceListener;
    }

    public static void setServiceConnectListener(OnServiceConnectListener r0) {
        sServiceListener = r0;
    }

    static boolean isWsChannelConnected(int r1) {
        if (sStates.get(Integer.valueOf(r1)) != ConnectionState.CONNECTED) goto L5;
        return true;
    L5:
        return false;
    }

    static boolean isPrivateProtocolEnabled(int r2) {
        if (sPrivateProtocolState.containsKey(Integer.valueOf(r2)) == true) goto L5;
        return false;
    L5:
        if (sPrivateProtocolState.get(Integer.valueOf(r2)).booleanValue() == true) goto L7;
        return false;
    L7:
        return true;
    }

    public static void setConnectionState(int r2, ConnectionState r3, boolean r4) {
        sStates.put(Integer.valueOf(r2), r3);
        sPrivateProtocolState.put(Integer.valueOf(r2), Boolean.valueOf(r4));
    }

    static void remove(int r2) {
        sStates.remove(Integer.valueOf(r2));
        Object r0 = sServiceLock;
        monitor-enter(r0);
        sServiceState.remove(Integer.valueOf(r2));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void initServiceState(int r4, List<Integer> r5) {
        Object r0 = sServiceLock;
        monitor-enter(r0);
        HashMap r1 = new HashMap();     // Catch: Throwable -> L16
        if (r5 != null) goto L9;
        sServiceState.put(Integer.valueOf(r4), r1);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L9:
        Iterator<Integer> r6 = r5.iterator();     // Catch: Throwable -> L16
    L11:
        if (r6.hasNext() == false) goto L13;
        r1.put(r6.next(), false);     // Catch: Throwable -> L16
        goto L11
    L13:
        sServiceState.put(Integer.valueOf(r4), r1);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public static void setServiceState(ServiceConnectEvent r3) {
        Object r0 = sServiceLock;
        monitor-enter(r0);
        Map<Integer, Boolean> r1 = sServiceState.get(Integer.valueOf(r3.getChannelId()));     // Catch: Throwable -> L11
        if (r1 != null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        r1.put(Integer.valueOf(r3.getServiceId()), Boolean.valueOf(r3.isServiceConnected()));     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    static boolean isServiceConnected(int r2, int r3) {
        Object r0 = sServiceLock;
        monitor-enter(r0);
        Map<Integer, Boolean> r4 = sServiceState.get(Integer.valueOf(r2));     // Catch: Throwable -> L15
        if (r4 != null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return false;
    L8:
        Boolean r5 = r4.get(Integer.valueOf(r3));     // Catch: Throwable -> L15
        if (r5 != null) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return false;
    L12:
        boolean r6 = r5.booleanValue();     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return r6;
    L15:
        th = move-exception;
        throw th;
    }

    static void removeService(int r2, int r3) {
        Object r0 = sServiceLock;
        monitor-enter(r0);
        Map<Integer, Boolean> r4 = sServiceState.get(Integer.valueOf(r2));     // Catch: Throwable -> L11
        if (r4 != null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        r4.remove(Integer.valueOf(r3));     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
