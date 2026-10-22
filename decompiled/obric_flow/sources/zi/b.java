package zi;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.core.app.NotificationCompat;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.sdk.xbridge.cn.platform.web.c;
import com.bytedance.sdk.xbridge.cn.platform.web.e;
import com.lynx.jsbridge.LynxResourceModule;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends e {
    @Override // com.bytedance.sdk.xbridge.cn.platform.web.e
    public final c b(String r10) {
        Intrinsics.checkNotNullParameter(r10, "msg");
        JSONObject r5 = new JSONObject(r10);
        String r11 = r5.optString("func");
        String r12 = l();
        String r13 = "";
        if (r12 != null) goto L5;
        r12 = "";
    L5:
        JSONObject r14 = r5.optJSONObject(LynxResourceModule.PARAMS_KEY);
        if (r14 != null) goto L8;
        r14 = new JSONObject();
    L8:
        c r15 = new c(r11, r12, r14);
        String r16 = r5.optString("__callback_id");
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        r15.M = r16;
        Intrinsics.checkNotNullParameter(r5.optString("__msg_type"), "<set-?>");
        r15.f933b = r5.optLong("__timestamp", System.currentTimeMillis());
        Intrinsics.checkNotNullParameter(r5.optString("JSSDK"), "<set-?>");
        String r17 = r5.optString("namespace", this.f);
        Intrinsics.checkNotNullParameter(r17, "namespace");
        if (Intrinsics.areEqual("host", r17) == true) goto L12;
        r13 = r17;
    L12:
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r15.d = r13;
        String r18 = r5.optString("__iframe_url");
        Intrinsics.checkNotNullParameter(r18, "<set-?>");
        r15.L = r18;
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r15.f944q = Integer.valueOf(r5.optInt("appID", 0));
        r15.D = this.f7421h.f7449a;
        Intrinsics.checkNotNullParameter("2", "<set-?>");
        r15.N = "2";
        return r15;
    }

    @Override // com.bytedance.sdk.xbridge.cn.platform.web.e
    public final String c(c r5, JSONObject r10) {
        Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r10, "data");
        JSONObject r11 = new JSONObject();
        r11.put("__callback_id", r5.M);
        r11.put("__params", r10);
        r11.put("__msg_type", "callback");
        if (TextUtils.isEmpty(r5.L) == true) goto L11;
        String r12 = r5.L;
        Charset r13 = Charsets.UTF_8;
        if (r12 == null) goto L9;
        String r14 = Base64.encodeToString(r12.getBytes(r13), 2);
        StringCompanionObject r15 = StringCompanionObject.INSTANCE;
        return String.format("javascript:(function(){   const iframe = document.querySelector(atob('%s'));   if (iframe && iframe.contentWindow) {        iframe.contentWindow.postMessage(%s, atob('%s'));   }})()", Arrays.copyOf(new Object[]{Base64.encodeToString(String.format("iframe[src=\"%s\"", Arrays.copyOf(new Object[]{r12}, 1)).getBytes(r13), 2), r11, r14}, 3));
    L9:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L11:
        return "javascript:ToutiaoJSBridge._handleMessageFromToutiao(" + r11 + ')';
    }

    @Override // com.bytedance.sdk.xbridge.cn.platform.web.e
    public final void d(SSWebView r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        r5.addJavascriptInterface(this, "ToutiaoJSBridge");
    }

    @Override // com.bytedance.sdk.xbridge.cn.platform.web.e
    public final void f(String r5, JSONObject r10) {
        Intrinsics.checkNotNullParameter(r5, "event");
        JSONObject r11 = new JSONObject();
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L5
        r11.put("__msg_type", "event");     // Catch: Throwable -> L5
        r11.put("__event_id", r5);     // Catch: Throwable -> L5
        r11.put("__params", r10);     // Catch: Throwable -> L5
        e("javascript:window.ToutiaoJSBridge && ToutiaoJSBridge._handleMessageFromToutiao && ToutiaoJSBridge._handleMessageFromToutiao(" + r11 + ')', null);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Throwable r14 = Result.m127exceptionOrNullimpl(Result.m124constructorimpl(ResultKt.createFailure(th)));
        if (r14 == null) goto L12;
        Log.e("JSB2Impl", "parse event failed,reason=" + r14.getMessage());
        return;
    }

    @JavascriptInterface
    public final void invokeMethod(String r5) {
        h(r5);
    }
}
