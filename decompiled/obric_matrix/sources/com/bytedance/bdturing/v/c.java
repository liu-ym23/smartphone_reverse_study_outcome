package com.bytedance.bdturing.v;

import kotlin.i;
import kotlin.n0.d.q;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final kotlin.h f3190a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final JSONObject f3191b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f3192c = null;

    static final class a extends q implements kotlin.n0.c.a<String> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f3193f = null;

        static {
            f3193f = new a();
        }

        a() {
            super(0);
        }

        public final String a() {
            return "{\n\t\"common\": {\n\t\t\"period\": 300000,\n\t\t\"retry_count\": 3,\n\t\t\"retry_interval\": 2000,\n\t\t\"alpha\": \"0.5\",\n\t\t\"rgb\": \"000000\",\n\t\t\"skip_launch\": 0,\n\t\t\"use_jsb_request\": 0,\n        \"use_native_report\":0,\n        \"use_dialog_size_v2\":0,\n\t\t\"pre_create\": 0,\n\t\t\"request_encrypt\": 0,\n\t\t\"host\": {\n\t\t\t\"cn\": \"https://vcs.zijieapi.com/\",\n            \"boe\":\"https://vcs-boe.bytedance.net/\"\n\t\t},\n\t\t\"back_up_host\": {\n\t\t\t\"cn\": \"https://vcs.zijieapi.com/\",\n            \"boe\":\"https://vcs-boe.bytedance.net/\"\n\t\t}\n\t},\n\t\"self_unpunish\": {\n\t\t\"url\": {\n            \"cn\": \"https://unpkg.byted-static.com/byted/secsdk-unpunish/1.7.3/output/index.html\",\n            \"boe\": \"https://unblock.web.bytedance.net/\"\n\t\t},\n\t\t\"host\": {\n            \"cn\":\"https://rc.snssdk.com\",\n            \"boe\": \"https://rc-boe.snssdk.com/\"\n\t\t},\n        \"height\": 0,\n\t\t\"width\": 0\n\t},\n\t\"qa\": {\n\t\t\"host\": {\n            \"cn\": \"https://rc.snssdk.com\",\n            \"boe\": \"https://rc-boe.snssdk.com/\"\n\t\t},\n\t\t\"url\": {\n\t\t\t\"cn\":  \"https://unpkg.byted-static.com/byted/secsdk-qa/1.2.6/build/index.html\",\n            \"boe\": \"http://qa.web.bytedance.net\"\n\t\t},\n\t\t\"height\": 318,\n\t\t\"width\": 300\n\t},\n\t\"sms\": {\n\t\t\"host\": {\n            \"cn\": \"https://rc.snssdk.com\",\n            \"boe\": \"https://rc-boe.snssdk.com/\"\n\t\t},\n\t\t\"url\": {\n            \"cn\": \"https://unpkg.byted-static.com/byted/secsdk-mobile-original/1.9.9/build/index.html\",\n            \"boe\": \"https://mobile.web.bytedance.net/\"\n\t\t},\n        \"height\": 0,\n\t\t\"width\": 0\n\t},\n    \"twice_verify\": {\n\t\t\"host\": {\n            \"cn\": \"\"\n\t\t},\n\t\t\"url\": {\n            \"cn\": \"/verifycenter/authentication\"\n\t\t},\n        \"height\": 0,\n\t\t\"width\": 0\n\t},\n\t\"verify\": {\n\t\t\"host\": {\n            \"cn\":\"https://verify.zijieapi.com/\",\n            \"boe\": \"https://boe-verify.bytedance.net/\"\n\t\t},\n\t\t\"back_up_host\": {\n            \"cn\":\"https://verify.zijieapi.com/\",\n            \"boe\": \"https://boe-verify.bytedance.net/\"\n\t\t},\n\t\t\"url\": {\n            \"cn\":\"https://lf-cdn-tos.bytescm.com/obj/static/secsdk-captcha/cn2/2.26.18/index.html\",\n            \"boe\": \"https://captcha.web.bytedance.net/\"\n\t\t},\n\t\t\"height\": 303,\n\t\t\"width\": 300\n\t},\n\n    \"smarter_verify\":{\n        \"url\":{\n            \"cn\":\"https://unpkg.byted-static.com/byted/secsdk-smart-captcha/0.0.8/output/app/smarter/index.html\"\n        },\n        \"host\":{\n            \"cn\":\"https://verify.snssdk.com/\"\n        },\n        \"back_up_host\":{\n            \"cn\":\"https://verify.snssdk.com/\"\n        },\n        \"width\":0,\n        \"height\":0\n    },\n    \"smartest_verify\":{\n        \"url\":{\n            \"cn\":\"https://unpkg.byted-static.com/byted/secsdk-smart-captcha/0.0.8/output/app/smartest/index.html\"\n        },\n        \"host\":{\n            \"cn\":\"https://verify.snssdk.com/\"\n        },\n        \"back_up_host\":{\n            \"cn\":\"https://verify.snssdk.com/\"\n        },\n        \"width\":0,\n        \"height\":0\n    },\n     \"verify_identity\":{\n            \"report_url\":{\n                \"cn\":\"https://verify.zijieapi.com/captcha/reportIdentity\",\n                \"boe\":\"https://boe-verify.bytedance.net/captcha/reportIdentity\"\n            }\n        }\n}";
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ String invoke() {
            return a();
        }
    }

    static {
        c r0 = new c();
        f3192c = r0;
        f3190a = i.b(a.f3193f);
        f3191b = new JSONObject(r0.a());
    }

    private c() {
    }

    private final String a() {
        return (String) f3190a.getValue();
    }

    public final JSONObject b() {
        return f3191b;
    }
}
