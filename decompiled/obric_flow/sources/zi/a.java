package zi;

import ai.j0;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.pia.core.utils.n;
import com.bytedance.sdk.xbridge.cn.platform.web.c;
import com.bytedance.sdk.xbridge.cn.platform.web.e;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.utils.d;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends e {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f23449i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f23450j;

    public a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "namespace");
        super(r5);
        this.f23449i = "bytedance";
        this.f23450j = "IESJSBridgeSupport";
    }

    @Override // com.bytedance.sdk.xbridge.cn.platform.web.e
    public final c b(String r15) {
        Intrinsics.checkNotNullParameter(r15, "msg");
        JSONObject r5 = new JSONObject(r15);
        String r10 = r5.optString("__msg_type");
        String r11 = r5.optString("__callback_id");
        String r12 = "";
        String r13 = r5.optString("func", "");
        JSONObject r14 = r5.optJSONObject(LynxResourceModule.PARAMS_KEY);
        if (r14 != null) goto L5;
        r14 = new JSONObject();
    L5:
        String r16 = r5.optString("JSSDK");
        String r17 = r5.optString("namespace", this.f);
        long r18 = r5.optLong("__timestamp", System.currentTimeMillis());
        String r19 = r5.optString("__iframe_url");
        String r110 = l();
        if (r110 != null) goto L8;
        r110 = "";
    L8:
        c r111 = new c(r13, r110, r14);
        Intrinsics.checkNotNullParameter(r19, "<set-?>");
        r111.L = r19;
        r111.f933b = r18;
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        Intrinsics.checkNotNullParameter(r17, "namespace");
        if (Intrinsics.areEqual("host", r17) == true) goto L12;
        r12 = r17;
    L12:
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r111.d = r12;
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r111.M = r11;
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r111.f944q = Integer.valueOf(r5.optInt("appID", 0));
        r111.D = this.f7421h.f7449a;
        Intrinsics.checkNotNullParameter(IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST, "<set-?>");
        r111.N = IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST;
        return r111;
    }

    @Override // com.bytedance.sdk.xbridge.cn.platform.web.e
    public final String c(c r5, JSONObject r10) {
        Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r10, "data");
        if (TextUtils.isEmpty(r5.L) == true) goto L10;
        JSONObject r11 = d.k("__msg_type", "callback");
        r11.put("__callback_id", r5.M);
        r11.put("__params", r10);
        String r12 = r5.L;
        Charset r13 = Charsets.UTF_8;
        if (r12 == null) goto L9;
        String r14 = Base64.encodeToString(r12.getBytes(r13), 2);
        StringCompanionObject r15 = StringCompanionObject.INSTANCE;
        return String.format("javascript:(function(){   const iframe = document.querySelector(atob('%s'));   if (iframe && iframe.contentWindow) {        iframe.contentWindow.postMessage(%s, atob('%s'));   }})()", Arrays.copyOf(new Object[]{Base64.encodeToString(String.format("iframe[src=\"%s\"", Arrays.copyOf(new Object[]{r12}, 1)).getBytes(r13), 2), r11.toString(), r14}, 3));
    L9:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L10:
        JSONObject r16 = d.k("__msg_type", "callback");
        r16.put("__callback_id", r5.M);
        r16.put("__params", r10);
        return "javascript:ToutiaoJSBridge._handleMessageFromToutiao(" + r16 + ')';
    }

    @Override // com.bytedance.sdk.xbridge.cn.platform.web.e
    public final void d(SSWebView r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
    }

    @Override // com.bytedance.sdk.xbridge.cn.platform.web.e
    public final void f(String r5, JSONObject r10) {
        Intrinsics.checkNotNullParameter(r5, "event");
    }

    @Override // com.bytedance.sdk.xbridge.cn.platform.web.e
    public final void m(String r5) {
        Intrinsics.checkNotNullParameter(r5, "url");
        o(r5);
    }

    @Override // com.bytedance.sdk.xbridge.cn.platform.web.e
    public final void n(String r5) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r5) == true) goto L17;
        String r10 = this.f23449i;
        if (TextUtils.isEmpty(r10) == true) goto L19;
        String r11 = Uri.parse(r5).getScheme();
        if (r11 == null) goto L12;
        String r12 = r11.toLowerCase();
    L14:
        if (Intrinsics.areEqual(r10, r12) == false) goto L18;
        o(r5);
        return;
    L18:
        return;
    L12:
        r12 = null;
        goto L14
    L19:
        return;
    }

    public final boolean o(String r5) {
        String r10 = this.f23449i;
        if (StringsKt.P(r5, r10) == true) goto L5;
        return false;
    L5:
        String r11 = j0.j(r10, "://dispatch_message/");
        String r12 = j0.j(r10, "://private/setresult/");
    L14:
        e = move-exception;
        Log.e(this.f23450j, "parse url failed,ignore=" + e);
    L20:
        return false;
    L7:
        if (Intrinsics.areEqual(r5, r11) == false) goto L17;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L11;
        this.g = g();     // Catch: Exception -> L14
    L12:
        e("javascript:ToutiaoJSBridge._fetchQueue()", new n(this, 1));     // Catch: Exception -> L14
        return true;
    L11:
        this.d.post(new a6.a(this, 25));     // Catch: Exception -> L14
        goto L12
    L17:
        if (StringsKt.P(r5, r12) == false) goto L20;
        return true;
    }
}
