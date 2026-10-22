package com.obric.matrix.opush.f;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b#\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0003\b\u0083\u0001\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0014\u0010\u0017\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0014\u0010\u0019\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0014\u0010\u001b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0014\u0010\u001d\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006R\u0014\u0010\u001f\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0006R\u0014\u0010!\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0006R\u0014\u0010#\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0006R\u0014\u0010%\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0006R\u0014\u0010'\u001a\u00020(X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020,X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0014\u0010/\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0006R\u0014\u00101\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0006R\u0014\u00103\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0006R\u0014\u00105\u001a\u00020,X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b6\u0010.R\u0014\u00107\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0006R\u0014\u00109\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0006R\u0014\u0010;\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0006R\u0014\u0010=\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u0006R\u0014\u0010?\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u0006R\u0014\u0010A\u001a\u00020,X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bB\u0010.R\u0014\u0010C\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\u0006R\u0014\u0010E\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\u0006R\u0014\u0010G\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\u0006R\u0014\u0010I\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010\u0006R\u0014\u0010K\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bL\u0010\u0006R\u0014\u0010M\u001a\u00020,X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bN\u0010.R\u0014\u0010O\u001a\u00020,X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bP\u0010.R\u0014\u0010Q\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bR\u0010\u0006R\u0014\u0010S\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bT\u0010\u0006R\u0014\u0010U\u001a\u00020,X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bV\u0010.R\u0014\u0010W\u001a\u00020,X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bX\u0010.R\u0014\u0010Y\u001a\u00020,X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010.R\u0014\u0010[\u001a\u00020,X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010.R\u0014\u0010]\u001a\u00020,X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b^\u0010.R\u0014\u0010_\u001a\u00020,X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b`\u0010.R\u0014\u0010a\u001a\u00020,X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bb\u0010.R\u0014\u0010c\u001a\u00020,X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bd\u0010.R\u0014\u0010e\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bf\u0010\u0006R\u0014\u0010g\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bh\u0010\u0006R\u0014\u0010i\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bj\u0010\u0006R\u0014\u0010k\u001a\u00020,X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bl\u0010.R\u0014\u0010m\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bn\u0010\u0006R\u0014\u0010o\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bp\u0010\u0006R\u0014\u0010q\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\br\u0010\u0006R\u0014\u0010s\u001a\u00020,X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bt\u0010.R\u0014\u0010u\u001a\u00020,X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bv\u0010.R\u0014\u0010w\u001a\u00020,X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bx\u0010.R\u0014\u0010y\u001a\u00020,X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bz\u0010.R\u0014\u0010{\u001a\u00020,X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b|\u0010.R\u0014\u0010}\u001a\u00020,X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b~\u0010.R\u0015\u0010\u007f\u001a\u00020,X\u0086D¢\u0006\t\n\u0000\u001a\u0005\b\u0080\u0001\u0010.R\u0016\u0010\u0081\u0001\u001a\u00020,X\u0086D¢\u0006\t\n\u0000\u001a\u0005\b\u0082\u0001\u0010.R\u0016\u0010\u0083\u0001\u001a\u00020,X\u0086D¢\u0006\t\n\u0000\u001a\u0005\b\u0084\u0001\u0010.R\u0016\u0010\u0085\u0001\u001a\u00020,X\u0086D¢\u0006\t\n\u0000\u001a\u0005\b\u0086\u0001\u0010.R\u0016\u0010\u0087\u0001\u001a\u00020,X\u0086D¢\u0006\t\n\u0000\u001a\u0005\b\u0088\u0001\u0010.R\u0016\u0010\u0089\u0001\u001a\u00020\u0004X\u0086D¢\u0006\t\n\u0000\u001a\u0005\b\u008a\u0001\u0010\u0006R\u0016\u0010\u008b\u0001\u001a\u00020\u0004X\u0086D¢\u0006\t\n\u0000\u001a\u0005\b\u008c\u0001\u0010\u0006R\u0016\u0010\u008d\u0001\u001a\u00020\u0004X\u0086D¢\u0006\t\n\u0000\u001a\u0005\b\u008e\u0001\u0010\u0006R\u0016\u0010\u008f\u0001\u001a\u00020\u0004X\u0086D¢\u0006\t\n\u0000\u001a\u0005\b\u0090\u0001\u0010\u0006R\u0016\u0010\u0091\u0001\u001a\u00020\u0004X\u0086D¢\u0006\t\n\u0000\u001a\u0005\b\u0092\u0001\u0010\u0006R\u0016\u0010\u0093\u0001\u001a\u00020\u0004X\u0086D¢\u0006\t\n\u0000\u001a\u0005\b\u0094\u0001\u0010\u0006R\u0016\u0010\u0095\u0001\u001a\u00020\u0004X\u0086D¢\u0006\t\n\u0000\u001a\u0005\b\u0096\u0001\u0010\u0006R\u0016\u0010\u0097\u0001\u001a\u00020\u0004X\u0086D¢\u0006\t\n\u0000\u001a\u0005\b\u0098\u0001\u0010\u0006R\u0016\u0010\u0099\u0001\u001a\u00020,X\u0086D¢\u0006\t\n\u0000\u001a\u0005\b\u009a\u0001\u0010.R\u0016\u0010\u009b\u0001\u001a\u00020,X\u0086D¢\u0006\t\n\u0000\u001a\u0005\b\u009c\u0001\u0010.R\u0016\u0010\u009d\u0001\u001a\u00020,X\u0086D¢\u0006\t\n\u0000\u001a\u0005\b\u009e\u0001\u0010.R\u0016\u0010\u009f\u0001\u001a\u00020,X\u0086D¢\u0006\t\n\u0000\u001a\u0005\b \u0001\u0010.R\u0016\u0010¡\u0001\u001a\u00020,X\u0086D¢\u0006\t\n\u0000\u001a\u0005\b¢\u0001\u0010.R\u0016\u0010£\u0001\u001a\u00020\u0004X\u0086D¢\u0006\t\n\u0000\u001a\u0005\b¤\u0001\u0010\u0006R\u0016\u0010¥\u0001\u001a\u00020\u0004X\u0086D¢\u0006\t\n\u0000\u001a\u0005\b¦\u0001\u0010\u0006R\u0016\u0010§\u0001\u001a\u00020\u0004X\u0086D¢\u0006\t\n\u0000\u001a\u0005\b¨\u0001\u0010\u0006R\u0016\u0010©\u0001\u001a\u00020\u0004X\u0086D¢\u0006\t\n\u0000\u001a\u0005\bª\u0001\u0010\u0006R\u0016\u0010«\u0001\u001a\u00020\u0004X\u0086D¢\u0006\t\n\u0000\u001a\u0005\b¬\u0001\u0010\u0006R\u0016\u0010\u00ad\u0001\u001a\u00020\u0004X\u0086D¢\u0006\t\n\u0000\u001a\u0005\b®\u0001\u0010\u0006¨\u0006¯\u0001"}, d2 = {"Lcom/obric/matrix/opush/model/AbsPushServiceConstants;", "", "()V", "ACTION_ALARM_SERVICE", "", "getACTION_ALARM_SERVICE", "()Ljava/lang/String;", "ACTION_CLICK_PUSH", "getACTION_CLICK_PUSH", "ACTION_DELETE_PUSH", "getACTION_DELETE_PUSH", "ACTION_NOTIFICATION_EVENT", "getACTION_NOTIFICATION_EVENT", "BRAND", "getBRAND", "CLIENT_TIME", "getCLIENT_TIME", "COUNTRY", "getCOUNTRY", "DATA", "getDATA", "DEVICE_DID", "getDEVICE_DID", "EVENT", "getEVENT", "EVENT_NAME_MSG_RECEIVE", "getEVENT_NAME_MSG_RECEIVE", "EVENT_NAME_PUSH_CLICK", "getEVENT_NAME_PUSH_CLICK", "EVENT_NAME_PUSH_ENABLE", "getEVENT_NAME_PUSH_ENABLE", "EVENT_NAME_PUSH_RECEIVE", "getEVENT_NAME_PUSH_RECEIVE", "EVENT_NAME_PUSH_REPEAT", "getEVENT_NAME_PUSH_REPEAT", "EVENT_NAME_PUSH_SENT", "getEVENT_NAME_PUSH_SENT", "EVENT_NAME_PUSH_SHOW", "getEVENT_NAME_PUSH_SHOW", "EVENT_REPORT_DELAY_WITH_SECOND", "", "getEVENT_REPORT_DELAY_WITH_SECOND", "()J", "EVENT_REPORT_MAX_NUM_ONE_BATCH", "", "getEVENT_REPORT_MAX_NUM_ONE_BATCH", "()I", "FILTER_KEY_APP_VERSION", "getFILTER_KEY_APP_VERSION", "FILTER_KEY_ROM", "getFILTER_KEY_ROM", "FORCE_UPDATE_TOKEN", "getFORCE_UPDATE_TOKEN", "HANDLE_HISTORY_MSG_BATCH_SIZE", "getHANDLE_HISTORY_MSG_BATCH_SIZE", "HOST_AID", "getHOST_AID", "KEY_EVENT", "getKEY_EVENT", "KEY_METHOD", "getKEY_METHOD", "KEY_OPEN_URL", "getKEY_OPEN_URL", "LANGUAGE", "getLANGUAGE", "MESSAGE_DEDUPLICATION_TIME_WINDOW_IN_MS", "getMESSAGE_DEDUPLICATION_TIME_WINDOW_IN_MS", "MODEL", "getMODEL", "OS_API", "getOS_API", "OS_VERSION", "getOS_VERSION", "OTA_VERSION_CODE", "getOTA_VERSION_CODE", "PRODUCT", "getPRODUCT", "PUSH_MSG_TYPE_MESSAGE", "getPUSH_MSG_TYPE_MESSAGE", "PUSH_MSG_TYPE_NOTIFICATION", "getPUSH_MSG_TYPE_NOTIFICATION", "PUSH_SDK_VERSION_CODE", "getPUSH_SDK_VERSION_CODE", "PUSH_SDK_VERSION_NAME", "getPUSH_SDK_VERSION_NAME", "RECEIPT_BATCH_LIMIT", "getRECEIPT_BATCH_LIMIT", "RECEIPT_CODE_ARRIVE", "getRECEIPT_CODE_ARRIVE", "RECEIPT_CODE_ARRIVE_LEGACY", "getRECEIPT_CODE_ARRIVE_LEGACY", "RECEIPT_CODE_CLICK", "getRECEIPT_CODE_CLICK", "RECEIPT_CODE_DELETE", "getRECEIPT_CODE_DELETE", "RECEIPT_CODE_NOTIFICATION_DISABLED", "getRECEIPT_CODE_NOTIFICATION_DISABLED", "RECEIPT_CODE_REPEAT", "getRECEIPT_CODE_REPEAT", "RECEIPT_CODE_SHOW", "getRECEIPT_CODE_SHOW", "RECEIPT_STATUS_NOTIFICATION_DISABLED", "getRECEIPT_STATUS_NOTIFICATION_DISABLED", "REGION", "getREGION", "REQUEST_CODE", "getREQUEST_CODE", "REQUEST_CODE_UPDATE_DEVICE", "getREQUEST_CODE_UPDATE_DEVICE", "ROM", "getROM", "SDK_VERSION_CODE", "getSDK_VERSION_CODE", "SDK_VERSION_NAME", "getSDK_VERSION_NAME", "SEND_RESULT_CERT_NOT_MATCH", "getSEND_RESULT_CERT_NOT_MATCH", "SEND_RESULT_CODE_ERROR_LANGUAGE", "getSEND_RESULT_CODE_ERROR_LANGUAGE", "SENT_RESULT_CODE_APP_NOT_INSTALL", "getSENT_RESULT_CODE_APP_NOT_INSTALL", "SENT_RESULT_CODE_APP_NO_TOKEN", "getSENT_RESULT_CODE_APP_NO_TOKEN", "SENT_RESULT_CODE_ERROR_INTERCEPTOR", "getSENT_RESULT_CODE_ERROR_INTERCEPTOR", "SENT_RESULT_CODE_ERROR_PARSE_FILTER_RULE", "getSENT_RESULT_CODE_ERROR_PARSE_FILTER_RULE", "SENT_RESULT_CODE_ERROR_SUB_SWITCH_OFF", "getSENT_RESULT_CODE_ERROR_SUB_SWITCH_OFF", "SENT_RESULT_CODE_ERROR_SWITCH_OFF", "getSENT_RESULT_CODE_ERROR_SWITCH_OFF", "SENT_RESULT_CODE_FILTER_RULE", "getSENT_RESULT_CODE_FILTER_RULE", "SENT_RESULT_CODE_PARAM_EXCEPTION", "getSENT_RESULT_CODE_PARAM_EXCEPTION", "SENT_RESULT_CODE_SUCCESS", "getSENT_RESULT_CODE_SUCCESS", "SERIAL_NUMBER", "getSERIAL_NUMBER", "SS_VERSION_CODE", "getSS_VERSION_CODE", "SS_VERSION_NAME", "getSS_VERSION_NAME", "TOKEN", "getTOKEN", "TZ_NAME", "getTZ_NAME", "TZ_OFFSET", "getTZ_OFFSET", "UPDATE_TIME", "getUPDATE_TIME", "UPDATE_TYPE", "getUPDATE_TYPE", "UPDATE_TYPE_DEFAULT", "getUPDATE_TYPE_DEFAULT", "UPDATE_TYPE_INSTALL", "getUPDATE_TYPE_INSTALL", "UPDATE_TYPE_PUSH_SERVICE", "getUPDATE_TYPE_PUSH_SERVICE", "UPDATE_TYPE_UNINSTALL", "getUPDATE_TYPE_UNINSTALL", "UPDATE_TYPE_UPGRADE", "getUPDATE_TYPE_UPGRADE", "UPDATE_VERSION_CODE", "getUPDATE_VERSION_CODE", "VALUE_EVENT_CLICK", "getVALUE_EVENT_CLICK", "VALUE_EVENT_REMOVE", "getVALUE_EVENT_REMOVE", "VALUE_EVENT_SHOW", "getVALUE_EVENT_SHOW", "VALUE_METHOD_INIT", "getVALUE_METHOD_INIT", "VALUE_METHOD_NOTIFICATION_CLICK", "getVALUE_METHOD_NOTIFICATION_CLICK", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class a {
    private final int A;
    private final int B;
    private final int C;
    private final int D;
    private final int E;
    private final String F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f9413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f9414d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f9415e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f9416f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f9417g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f9418h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f9419i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f9420j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f9421k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f9422l;
    private final String m;
    private final String n;
    private final String o;
    private final String p;
    private final String q;
    private final int r;
    private final int s;
    private final int t;
    private final int u;
    private final int v;
    private final int w;
    private final int x;
    private final int y;
    private final int z;

    public a() {
        this.f9411a = "method";
        this.f9412b = NotificationCompat.CATEGORY_EVENT;
        this.f9413c = "device_init";
        this.f9414d = "show";
        this.f9415e = "click";
        this.f9416f = "remove";
        this.f9417g = "com.obric.matrix.opush.action.NOTIFICATION_EVENT";
        this.f9418h = "com.obric.matrix.opush.action.ALARM_SERVICE";
        this.f9419i = "com.obric.matrix.opush.action.CLICK_PUSH";
        this.f9420j = "com.obric.matrix.opush.action.DELETE_PUSH";
        this.f9421k = 10001;
        this.f9422l = "request_code";
        this.m = "PushToken";
        this.n = "push_receive";
        this.o = "push_click";
        this.p = "com.bytedance.push.android.bdpush.sdk.version.name";
        this.q = "com.bytedance.push.android.bdpush.sdk.version.code";
        this.s = 4;
        this.t = 604800000;
        this.v = 1;
        this.w = 2;
        this.x = 10;
        this.y = 100003;
        this.z = 100004;
        this.A = 100005;
        this.B = 500001;
        this.C = 400001;
        this.D = 400002;
        this.E = 32;
        this.F = "notification_disabled";
    }

    public final int A() {
        return this.r;
    }

    public final int B() {
        return this.s;
    }

    public final String C() {
        return this.f9415e;
    }

    public final String D() {
        return this.f9416f;
    }

    public final String E() {
        return this.f9414d;
    }

    public final String F() {
        return this.f9413c;
    }

    public final String a() {
        return this.f9418h;
    }

    public final String b() {
        return this.f9419i;
    }

    public final String c() {
        return this.f9420j;
    }

    public final String d() {
        return this.f9417g;
    }

    public final String e() {
        return this.o;
    }

    public final String f() {
        return this.n;
    }

    public final String g() {
        return this.f9412b;
    }

    public final String h() {
        return this.f9411a;
    }

    public final int i() {
        return this.t;
    }

    public final int j() {
        return this.E;
    }

    public final int k() {
        return this.y;
    }

    public final int l() {
        return this.A;
    }

    public final int m() {
        return this.B;
    }

    public final int n() {
        return this.C;
    }

    public final int o() {
        return this.D;
    }

    public final int p() {
        return this.z;
    }

    public final String q() {
        return this.F;
    }

    public final String r() {
        return this.f9422l;
    }

    public final int s() {
        return this.f9421k;
    }

    public final String t() {
        return this.q;
    }

    public final String u() {
        return this.p;
    }

    public final int v() {
        return this.x;
    }

    public final int w() {
        return this.v;
    }

    public final int x() {
        return this.w;
    }

    public final int y() {
        return this.u;
    }

    public final String z() {
        return this.m;
    }
}
