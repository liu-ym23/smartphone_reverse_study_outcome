package com.obric.matrix.t;

import com.bytedance.bdinstall.k0;
import com.bytedance.bdinstall.r;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/obric/matrix/launch/Config;", "", "()V", "bdInstallEnv", "Lcom/bytedance/bdinstall/Env;", "getBdInstallEnv", "()Lcom/bytedance/bdinstall/Env;", "ttnetDomainDefaultJson", "", "getTtnetDomainDefaultJson", "()Ljava/lang/String;", "app_launch_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f10034a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f10035b = null;

    static {
        f10034a = new b();
        new r(k0.a("https://matrix-cn.picovr.com"), false, false);
        f10035b = "{\n    \"data\":{\n        \"chromium_open\":1,\n        \"ttnet_enable_cronet_request_report\":1,\n        \"ttnet_h2_config\":{\n            \"h2_session_check_enabled\":1,\n            \"h2_session_check_interval\":65,\n            \"ping_keepalive_hosts\":[\n            ],\n            \"ping_keepalive_interval\":30,\n            \"ping_probe_timeout\":5,\n            \"session_check_hosts\":[\n            ]\n        },\n        \"ttnet_h2_enabled\":1,\n        \"ttnet_http_dns_enabled\":1,\n        \"ttnet_http_dns_google\":0,\n        \"ttnet_http_dns_prefer\":1,\n        \"ttnet_http_dns_timeout\":2,\n        \"ttnet_local_dns_time_out\":2,\n        \"ttnet_quic_enabled\":1,\n        \"ttnet_quic_hint\":{\n            \"matrix-cn.picovr.com\":443\n        },\n        \"ttnet_quic_internal_param\":{\n            \"congestion_control_type\":2,\n            \"max_server_configs_stored\":10,\n            \"max_time_before_0rtt_crypto_handshake_seconds\":2,\n            \"ping_keepalive_hosts\":[\n                \"matrix-cn.picovr.com:443\"\n            ],\n            \"ping_keepalive_interval\":25,\n            \"quic_version\":\"Q043\"\n        },\n        \"ttnet_websocket_config\":{\n            \"qos2_enable\":1\n        },\n        \"ttnet_request_retry_delay_interval_ms\":200,\n        \"ttnet_request_retry_error_list\":[\n            -21,\n            -109,\n            -126,\n            -324,\n            -101\n        ],\n        \"ttnet_request_retry_max_attempts\":3,\n        \"ttnet_url_dispatcher_enabled\":1\n    }\n}";
    }

    private b() {
    }

    public final String a() {
        return f10035b;
    }
}
