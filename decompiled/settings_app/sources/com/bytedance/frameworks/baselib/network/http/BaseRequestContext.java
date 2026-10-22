package com.bytedance.frameworks.baselib.network.http;

import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes3.dex */
public class BaseRequestContext {
    public static final int BYPASS_PROXY = 128;
    public static final int DISABLE_CACHE = 16;
    public static final int DO_NOT_SEND_COOKIE = 2;
    public static final int ENABLE_EARLY_DATA = 4;
    public static final int NORMAL = 0;
    public static final int WEBVIEW_REQUEST = 1;
    public AuthCredentials authCredentials;
    public boolean byPassProxy;
    public boolean bypassCookie;
    public boolean bypass_network_status_check;
    public boolean enable_http_cache;
    public boolean followRedirectInternal;
    public boolean force_handle_response;
    public boolean force_use_okhttp;
    public int input_stream_buffer_size;
    public boolean isCustomizedCookie;
    public boolean is_need_monitor_in_cancel;
    public IOkHttpRequestClientBuilderHook okHttpRequestClientBuilderHook;
    public int output_stream_buffer_size;
    public long protect_timeout;
    public boolean read_error_response;
    public String remoteIp;
    public int request_flag;
    public int request_type_flags;
    public long socket_connect_timeout;
    public long socket_read_timeout;
    public long socket_write_timeout;
    public int status;
    public boolean streaming_force_return_response;
    public long throttle_net_speed;
    public long timeout_connect;
    public long timeout_read;
    public long timeout_write;

    public static class AuthCredentials {
        public String password;
        public String username;

        public AuthCredentials() {
        }

        public String toString() {
            return "AuthCredentials{username=" + this.username + ", password=" + this.password + '}';
        }
    }

    public interface IOkHttpRequestClientBuilderHook {
        void addBuilderConfig(OkHttpClient.Builder r1);
    }

    public BaseRequestContext() {
        this.force_use_okhttp = false;
        this.request_type_flags = 0;
        this.bypass_network_status_check = true;
        this.followRedirectInternal = true;
        this.enable_http_cache = false;
        this.is_need_monitor_in_cancel = true;
        this.bypassCookie = false;
        this.isCustomizedCookie = false;
        this.byPassProxy = false;
    }
}
