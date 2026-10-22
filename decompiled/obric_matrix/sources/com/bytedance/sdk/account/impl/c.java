package com.bytedance.sdk.account.impl;

import com.bytedance.common.wschannel.WsConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static com.ss.android.i.e.a f5532a;

        static {
            f5532a = new com.ss.android.i.e.a();
        }

        public static d.b.s.a.k0.a a(JSONObject r0, JSONObject r1) {
            return c(r0, r1);
        }

        public static d.b.s.a.k0.a b(JSONObject r1) {
            return f5532a.a(r1);
        }

        public static d.b.s.a.k0.a c(JSONObject r1, JSONObject r2) {
            return f5532a.b(r1, r2);
        }
    }

    public static void a(d.b.s.a.h0.a r2, JSONObject r3, JSONObject r4) {
        String r5 = WsConstants.ERROR_CODE;
        if (r3.has(WsConstants.ERROR_CODE) == false) goto L5;
    L4:
        r2.f14778a = r3.optInt(r5, r2.f14778a);
    L8:
        r2.f14779b = r3.optString("description");
        if (r2.f14778a != 1075) goto L12;
        r2.f14782e = r3.optLong("apply_time");
        r2.f14785h = r3.optString("avatar_url");
        r2.f14784g = r3.optString("nick_name");
        r2.f14781d = r3.optString("token");
        r2.f14783f = r3.optLong("cancel_time");
        return;
    L12:
        return;
    L5:
        r5 = "code";
        if (r3.has("code") == false) goto L8;
        goto L8
    }

    public static void b(d.b.s.a.b0.a.b r5, JSONObject r6) {
        String r0 = WsConstants.ERROR_CODE;
        if (r6.has(WsConstants.ERROR_CODE) == false) goto L5;
    L4:
        r5.f14652a = r6.optInt(r0, r5.f14652a);
    L8:
        r5.f14654c = r6.optString("description");
        if ((r5 instanceof d.b.s.a.b0.a.b) == false) goto L12;
        r5.f14655d = r6.optString("captcha");
        r5.f14656e = r6.optString("alert_text");
    L12:
        if (r5.f14652a != 1001) goto L17;
        if ((r5 instanceof d.b.s.a.b0.a.f) == false) goto L17;
        String r1 = r6.optString("dialog_tips");
        ((d.b.s.a.b0.a.f) r5).n = r1;
    L17:
        if (r5.f14652a != 1057) goto L22;
        if ((r5 instanceof d.b.s.a.b0.a.f) == false) goto L22;
        d.b.s.a.b0.a.f r2 = (d.b.s.a.b0.a.f) r5;
        r2.n = r6.optString("dialog_tips");
        r2.o = r6.optString("next_url");
    L22:
        if (r5.f14652a != 1057) goto L27;
        if ((r5 instanceof d.b.s.a.b0.a.c) == false) goto L27;
        d.b.s.a.b0.a.c r3 = (d.b.s.a.b0.a.c) r5;
        r3.m = r6.optString("dialog_tips");
        r3.n = r6.optString("next_url");
    L27:
        if (r5.f14652a != 1075) goto L30;
        r5.f14659h = r6.optLong("apply_time");
        r5.f14662k = r6.optString("avatar_url");
        r5.f14661j = r6.optString("nick_name");
        r5.f14658g = r6.optString("token");
        r5.f14660i = r6.optLong("cancel_time");
        return;
    L30:
        return;
    L5:
        r0 = "code";
        if (r6.has("code") == false) goto L8;
        goto L8
    }
}
