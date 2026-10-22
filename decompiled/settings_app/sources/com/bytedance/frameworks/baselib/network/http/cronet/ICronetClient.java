package com.bytedance.frameworks.baselib.network.http.cronet;

import android.content.Context;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public interface ICronetClient {
    public static final String KEY_CONNECT_TIME = "connect_time";
    public static final String KEY_DNS_TIME = "dns_time";
    public static final String KEY_POST_TASK_START = "post_task_start";
    public static final String KEY_PUSH_TIME = "push_time";
    public static final String KEY_RECEIVED_BYTE_COUNT = "received_byte_count";
    public static final String KEY_RECEIVE_TIME = "receive_time";
    public static final String KEY_REMOTE_IP = "remote_ip";
    public static final String KEY_REQUEST_HEADERS = "request_headers";
    public static final String KEY_REQUEST_START = "request_start";
    public static final String KEY_REQ_COOKIE_SOURCE_TYPE = "req_cookie_source_type";
    public static final String KEY_RESPONSE_HEADERS = "response_headers";
    public static final String KEY_RETRY_ATTEMPTS = "retry_attempts";
    public static final String KEY_SEND_BYTE_COUNT = "send_byte_count";
    public static final String KEY_SEND_TIME = "send_time";
    public static final String KEY_SOCKET_REUSED = "socket_reused";
    public static final String KEY_SSL_TIME = "ssl_time";
    public static final String KEY_TOTAL_TIME = "total_time";
    public static final String KEY_TTFB = "ttfb";
    public static final String KEY_UPPER_ADD_COOKIE_US = "upper_add_cookie_us";
    public static final String KEY_UPPER_SAVE_COOKIE_US = "upper_save_cookie_us";
    public static final String KEY_WAIT_CONTEXT = "wait_ctx";

    public interface ICronetBootFailureChecker {
        boolean isCronetBootFailureExpected();
    }

    int getCronetInternalErrorCode(HttpURLConnection r1);

    String getCronetVersion();

    void getRequestMetrics(HttpURLConnection r1, Map<String, Object> r2);

    boolean isCronetHttpURLConnection(HttpURLConnection r1);

    HttpURLConnection openConnection(Context r1, String r2, boolean r3, String r4, Executor r5, ICronetAppProvider r6) throws IOException;

    void setCronetBootFailureChecker(ICronetBootFailureChecker r1);

    void tryCreateCronetEngine(Context r1, boolean r2, boolean r3, boolean r4, boolean r5, String r6, Executor r7, boolean r8, ICronetAppProvider r9);
}
