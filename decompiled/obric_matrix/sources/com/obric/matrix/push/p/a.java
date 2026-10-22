package com.obric.matrix.push.p;

import androidx.core.app.NotificationCompat;
import com.bytedance.common.wschannel.WsConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b#\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\bo\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0014\u0010\u0017\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0014\u0010\u0019\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0014\u0010\u001b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0014\u0010\u001d\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006R\u0014\u0010\u001f\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0006R\u0014\u0010!\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0006R\u0014\u0010#\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0006R\u0014\u0010%\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0006R\u0014\u0010'\u001a\u00020(X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020,X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0014\u0010/\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0006R\u0014\u00101\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0006R\u0014\u00103\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0006R\u0014\u00105\u001a\u00020,X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b6\u0010.R\u0014\u00107\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0006R\u0014\u00109\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0006R\u0014\u0010;\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0006R\u0014\u0010=\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u0006R\u0014\u0010?\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u0006R\u0014\u0010A\u001a\u00020,X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bB\u0010.R\u0014\u0010C\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\u0006R\u0014\u0010E\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\u0006R\u0014\u0010G\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\u0006R\u0014\u0010I\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010\u0006R\u0014\u0010K\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bL\u0010\u0006R\u0014\u0010M\u001a\u00020,X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bN\u0010.R\u0014\u0010O\u001a\u00020,X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bP\u0010.R\u0014\u0010Q\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bR\u0010\u0006R\u0014\u0010S\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bT\u0010\u0006R\u0014\u0010U\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bV\u0010\u0006R\u0014\u0010W\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bX\u0010\u0006R\u0014\u0010Y\u001a\u00020,X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010.R\u0014\u0010[\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010\u0006R\u0014\u0010]\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b^\u0010\u0006R\u0014\u0010_\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b`\u0010\u0006R\u0014\u0010a\u001a\u00020,X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bb\u0010.R\u0014\u0010c\u001a\u00020,X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bd\u0010.R\u0014\u0010e\u001a\u00020,X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bf\u0010.R\u0014\u0010g\u001a\u00020,X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bh\u0010.R\u0014\u0010i\u001a\u00020,X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bj\u0010.R\u0014\u0010k\u001a\u00020,X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bl\u0010.R\u0014\u0010m\u001a\u00020,X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bn\u0010.R\u0014\u0010o\u001a\u00020,X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bp\u0010.R\u0014\u0010q\u001a\u00020,X\u0086D¢\u0006\b\n\u0000\u001a\u0004\br\u0010.R\u0014\u0010s\u001a\u00020,X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bt\u0010.R\u0014\u0010u\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bv\u0010\u0006R\u0014\u0010w\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bx\u0010\u0006R\u0014\u0010y\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bz\u0010\u0006R\u0014\u0010{\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b|\u0010\u0006R\u0014\u0010}\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b~\u0010\u0006R\u0015\u0010\u007f\u001a\u00020\u0004X\u0086D¢\u0006\t\n\u0000\u001a\u0005\b\u0080\u0001\u0010\u0006R\u0016\u0010\u0081\u0001\u001a\u00020\u0004X\u0086D¢\u0006\t\n\u0000\u001a\u0005\b\u0082\u0001\u0010\u0006R\u0016\u0010\u0083\u0001\u001a\u00020\u0004X\u0086D¢\u0006\t\n\u0000\u001a\u0005\b\u0084\u0001\u0010\u0006R\u0016\u0010\u0085\u0001\u001a\u00020,X\u0086D¢\u0006\t\n\u0000\u001a\u0005\b\u0086\u0001\u0010.R\u0016\u0010\u0087\u0001\u001a\u00020,X\u0086D¢\u0006\t\n\u0000\u001a\u0005\b\u0088\u0001\u0010.R\u0016\u0010\u0089\u0001\u001a\u00020,X\u0086D¢\u0006\t\n\u0000\u001a\u0005\b\u008a\u0001\u0010.R\u0016\u0010\u008b\u0001\u001a\u00020,X\u0086D¢\u0006\t\n\u0000\u001a\u0005\b\u008c\u0001\u0010.R\u0016\u0010\u008d\u0001\u001a\u00020,X\u0086D¢\u0006\t\n\u0000\u001a\u0005\b\u008e\u0001\u0010.R\u0016\u0010\u008f\u0001\u001a\u00020\u0004X\u0086D¢\u0006\t\n\u0000\u001a\u0005\b\u0090\u0001\u0010\u0006R\u0016\u0010\u0091\u0001\u001a\u00020\u0004X\u0086D¢\u0006\t\n\u0000\u001a\u0005\b\u0092\u0001\u0010\u0006R\u0016\u0010\u0093\u0001\u001a\u00020\u0004X\u0086D¢\u0006\t\n\u0000\u001a\u0005\b\u0094\u0001\u0010\u0006R\u0016\u0010\u0095\u0001\u001a\u00020\u0004X\u0086D¢\u0006\t\n\u0000\u001a\u0005\b\u0096\u0001\u0010\u0006R\u0016\u0010\u0097\u0001\u001a\u00020\u0004X\u0086D¢\u0006\t\n\u0000\u001a\u0005\b\u0098\u0001\u0010\u0006R\u0016\u0010\u0099\u0001\u001a\u00020\u0004X\u0086D¢\u0006\t\n\u0000\u001a\u0005\b\u009a\u0001\u0010\u0006¨\u0006\u009b\u0001"}, d2 = {"Lcom/obric/matrix/push/model/AbsPushServiceConstants;", "", "()V", "ACTION_ALARM_SERVICE", "", "getACTION_ALARM_SERVICE", "()Ljava/lang/String;", "ACTION_CLICK_PUSH", "getACTION_CLICK_PUSH", "ACTION_DELETE_PUSH", "getACTION_DELETE_PUSH", "ACTION_NOTIFICATION_EVENT", "getACTION_NOTIFICATION_EVENT", "BRAND", "getBRAND", "CLIENT_TIME", "getCLIENT_TIME", "COUNTRY", "getCOUNTRY", "DATA", "getDATA", "DEVICE_DID", "getDEVICE_DID", "EVENT", "getEVENT", "EVENT_NAME_MSG_RECEIVE", "getEVENT_NAME_MSG_RECEIVE", "EVENT_NAME_PUSH_CLICK", "getEVENT_NAME_PUSH_CLICK", "EVENT_NAME_PUSH_ENABLE", "getEVENT_NAME_PUSH_ENABLE", "EVENT_NAME_PUSH_RECEIVE", "getEVENT_NAME_PUSH_RECEIVE", "EVENT_NAME_PUSH_REPEAT", "getEVENT_NAME_PUSH_REPEAT", "EVENT_NAME_PUSH_SENT", "getEVENT_NAME_PUSH_SENT", "EVENT_NAME_PUSH_SHOW", "getEVENT_NAME_PUSH_SHOW", "EVENT_REPORT_DELAY_WITH_SECOND", "", "getEVENT_REPORT_DELAY_WITH_SECOND", "()J", "EVENT_REPORT_MAX_NUM_ONE_BATCH", "", "getEVENT_REPORT_MAX_NUM_ONE_BATCH", "()I", "FILTER_KEY_APP_VERSION", "getFILTER_KEY_APP_VERSION", "FILTER_KEY_ROM", "getFILTER_KEY_ROM", "FORCE_UPDATE_TOKEN", "getFORCE_UPDATE_TOKEN", "HANDLE_HISTORY_MSG_BATCH_SIZE", "getHANDLE_HISTORY_MSG_BATCH_SIZE", "HOST_AID", "getHOST_AID", "KEY_EVENT", "getKEY_EVENT", "KEY_METHOD", "getKEY_METHOD", "KEY_OPEN_URL", "getKEY_OPEN_URL", "LANGUAGE", "getLANGUAGE", "MESSAGE_DEDUPLICATION_TIME_WINDOW_IN_MS", "getMESSAGE_DEDUPLICATION_TIME_WINDOW_IN_MS", "MODEL", "getMODEL", "OS_API", "getOS_API", "OS_VERSION", "getOS_VERSION", "OTA_VERSION_CODE", "getOTA_VERSION_CODE", "PRODUCT", "getPRODUCT", "PUSH_MSG_TYPE_MESSAGE", "getPUSH_MSG_TYPE_MESSAGE", "PUSH_MSG_TYPE_NOTIFICATION", "getPUSH_MSG_TYPE_NOTIFICATION", "PUSH_SDK_VERSION_CODE", "getPUSH_SDK_VERSION_CODE", "PUSH_SDK_VERSION_NAME", "getPUSH_SDK_VERSION_NAME", "REGION", "getREGION", "REQUEST_CODE", "getREQUEST_CODE", "REQUEST_CODE_UPDATE_DEVICE", "getREQUEST_CODE_UPDATE_DEVICE", "ROM", "getROM", "SDK_VERSION_CODE", "getSDK_VERSION_CODE", "SDK_VERSION_NAME", "getSDK_VERSION_NAME", "SEND_RESULT_CODE_ERROR_LANGUAGE", "getSEND_RESULT_CODE_ERROR_LANGUAGE", "SENT_RESULT_CODE_APP_NOT_INSTALL", "getSENT_RESULT_CODE_APP_NOT_INSTALL", "SENT_RESULT_CODE_APP_NO_TOKEN", "getSENT_RESULT_CODE_APP_NO_TOKEN", "SENT_RESULT_CODE_ERROR_INTERCEPTOR", "getSENT_RESULT_CODE_ERROR_INTERCEPTOR", "SENT_RESULT_CODE_ERROR_PARSE_FILTER_RULE", "getSENT_RESULT_CODE_ERROR_PARSE_FILTER_RULE", "SENT_RESULT_CODE_ERROR_SUB_SWITCH_OFF", "getSENT_RESULT_CODE_ERROR_SUB_SWITCH_OFF", "SENT_RESULT_CODE_ERROR_SWITCH_OFF", "getSENT_RESULT_CODE_ERROR_SWITCH_OFF", "SENT_RESULT_CODE_FILTER_RULE", "getSENT_RESULT_CODE_FILTER_RULE", "SENT_RESULT_CODE_PARAM_EXCEPTION", "getSENT_RESULT_CODE_PARAM_EXCEPTION", "SENT_RESULT_CODE_SUCCESS", "getSENT_RESULT_CODE_SUCCESS", "SERIAL_NUMBER", "getSERIAL_NUMBER", "SS_VERSION_CODE", "getSS_VERSION_CODE", "SS_VERSION_NAME", "getSS_VERSION_NAME", "TOKEN", "getTOKEN", "TZ_NAME", "getTZ_NAME", "TZ_OFFSET", "getTZ_OFFSET", "UPDATE_TIME", "getUPDATE_TIME", "UPDATE_TYPE", "getUPDATE_TYPE", "UPDATE_TYPE_DEFAULT", "getUPDATE_TYPE_DEFAULT", "UPDATE_TYPE_INSTALL", "getUPDATE_TYPE_INSTALL", "UPDATE_TYPE_PUSH_SERVICE", "getUPDATE_TYPE_PUSH_SERVICE", "UPDATE_TYPE_UNINSTALL", "getUPDATE_TYPE_UNINSTALL", "UPDATE_TYPE_UPGRADE", "getUPDATE_TYPE_UPGRADE", "UPDATE_VERSION_CODE", "getUPDATE_VERSION_CODE", "VALUE_EVENT_CLICK", "getVALUE_EVENT_CLICK", "VALUE_EVENT_REVOKE", "getVALUE_EVENT_REVOKE", "VALUE_EVENT_SHOW", "getVALUE_EVENT_SHOW", "VALUE_METHOD_INIT", "getVALUE_METHOD_INIT", "VALUE_METHOD_NOTIFICATION_CLICK", "getVALUE_METHOD_NOTIFICATION_CLICK", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class a {
    private final String A;
    private final String B;
    private final String C;
    private final String D;
    private final String E;
    private final String F;
    private final String G;
    private final String H;
    private final String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private final String f9767J;
    private final long K;
    private final int L;
    private final String M;
    private final String N;
    private final int O;
    private final int P;
    private final int Q;
    private final int R;
    private final int S;
    private final String T;
    private final int U;
    private final int V;
    private final int W;
    private final int X;
    private final int Y;
    private final int Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9768a;
    private final int a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9769b;
    private final int b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f9770c;
    private final int c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f9771d;
    private final int d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f9772e;
    private final int e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f9773f;
    private final int f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f9774g;
    private final int g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f9775h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f9776i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f9777j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f9778k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f9779l;
    private final String m;
    private final String n;
    private final String o;
    private final String p;
    private final String q;
    private final String r;
    private final String s;
    private final String t;
    private final String u;
    private final String v;
    private final String w;
    private final String x;
    private final String y;
    private final String z;

    public a() {
        this.f9768a = "method";
        this.f9769b = NotificationCompat.CATEGORY_EVENT;
        this.f9770c = "device_init";
        this.f9771d = "notification_click";
        this.f9772e = "show";
        this.f9773f = "click";
        this.f9774g = "revoke";
        this.f9775h = "com.obric.matrix.push.action.NOTIFICATION_EVENT";
        this.f9776i = "com.obric.matrix.push.action.ALARM_SERVICE";
        this.f9777j = "com.obric.matrix.push.action.CLICK_PUSH";
        this.f9778k = "com.obric.matrix.push.action.DELETE_PUSH";
        this.f9779l = 10001;
        this.m = "request_code";
        this.n = "brand";
        this.o = "model";
        this.p = "product";
        this.q = "update_time";
        this.r = "ota_version";
        this.s = WsConstants.KEY_DEVICE_ID;
        this.t = "serial_number";
        this.u = "rom";
        this.v = "os_version";
        this.w = "os_api";
        this.x = "country";
        this.y = "region";
        this.z = "language";
        this.A = "tz_name";
        this.B = "tz_offset";
        this.C = "sdk_version_name";
        this.D = "sdk_version_code";
        this.E = "update_type";
        this.F = "data";
        this.G = "token";
        this.H = "force_update_token";
        this.I = "push_click";
        this.f9767J = "revoke_receive";
        this.K = 5;
        this.L = 10;
        this.M = "com.bytedance.push.android.bdpush.sdk.version.name";
        this.N = "com.bytedance.push.android.bdpush.sdk.version.code";
        this.P = 1;
        this.Q = 2;
        this.R = 3;
        this.S = 4;
        this.T = WsConstants.KEY_APP_VERSION;
        this.U = 604800000;
        this.W = 1;
        this.Y = 1;
        this.Z = 2;
        this.a0 = 3;
        this.b0 = 4;
        this.c0 = 5;
        this.d0 = 6;
        this.e0 = 7;
        this.f0 = 8;
        this.g0 = 9;
    }

    public final String A() {
        return this.C;
    }

    public final String B() {
        return this.y;
    }

    public final String C() {
        return this.m;
    }

    public final int D() {
        return this.f9779l;
    }

    public final String E() {
        return this.u;
    }

    public final String F() {
        return this.N;
    }

    public final String G() {
        return this.M;
    }

    public final int H() {
        return this.g0;
    }

    public final int I() {
        return this.Y;
    }

    public final int J() {
        return this.Z;
    }

    public final int K() {
        return this.e0;
    }

    public final int L() {
        return this.b0;
    }

    public final int M() {
        return this.d0;
    }

    public final int N() {
        return this.c0;
    }

    public final int O() {
        return this.a0;
    }

    public final int P() {
        return this.f0;
    }

    public final int Q() {
        return this.X;
    }

    public final String R() {
        return this.t;
    }

    public final String S() {
        return this.G;
    }

    public final String T() {
        return this.A;
    }

    public final String U() {
        return this.B;
    }

    public final String V() {
        return this.q;
    }

    public final String W() {
        return this.E;
    }

    public final int X() {
        return this.O;
    }

    public final int Y() {
        return this.P;
    }

    public final int Z() {
        return this.S;
    }

    public final String a() {
        return this.f9776i;
    }

    public final int a0() {
        return this.Q;
    }

    public final String b() {
        return this.f9777j;
    }

    public final int b0() {
        return this.R;
    }

    public final String c() {
        return this.f9778k;
    }

    public final String c0() {
        return this.f9773f;
    }

    public final String d() {
        return this.f9775h;
    }

    public final String d0() {
        return this.f9774g;
    }

    public final String e() {
        return this.n;
    }

    public final String e0() {
        return this.f9772e;
    }

    public final String f() {
        return this.x;
    }

    public final String f0() {
        return this.f9770c;
    }

    public final String g() {
        return this.F;
    }

    public final String g0() {
        return this.f9771d;
    }

    public final String h() {
        return this.s;
    }

    public final String i() {
        return this.f9767J;
    }

    public final String j() {
        return this.I;
    }

    public final long k() {
        return this.K;
    }

    public final int l() {
        return this.L;
    }

    public final String m() {
        return this.T;
    }

    public final String n() {
        return this.H;
    }

    public final String o() {
        return this.f9769b;
    }

    public final String p() {
        return this.f9768a;
    }

    public final String q() {
        return this.z;
    }

    public final int r() {
        return this.U;
    }

    public final String s() {
        return this.o;
    }

    public final String t() {
        return this.w;
    }

    public final String u() {
        return this.v;
    }

    public final String v() {
        return this.r;
    }

    public final String w() {
        return this.p;
    }

    public final int x() {
        return this.W;
    }

    public final int y() {
        return this.V;
    }

    public final String z() {
        return this.D;
    }
}
