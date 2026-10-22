package com.obric.matrix;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.obric.matrix.account_api.OAccount;
import kotlin.Metadata;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\rH\u0017R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/obric/matrix/MyRequestServiceImpl;", "Lcom/bytedance/news/common/settings/api/RequestService;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "GET_SETTINGS_URL", "", "TAG", "getContext", "()Landroid/content/Context;", "executeSettingPost", "baseUrl", "request", "Lcom/bytedance/news/common/settings/api/Response;", "app_matrix_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class n implements com.bytedance.news.common.settings.g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f9231c;

    public n(Context r2) {
        kotlin.n0.d.o.f(r2, "context");
        this.f9229a = r2;
        this.f9230b = "https://is.snssdk.com/service/settings/v3/";
        this.f9231c = "MyRequestServiceImpl";
    }

    private final String a(String r7) {
        byte[] r2 = new byte[1];
        return com.bytedance.common.utility.g.f().i(r7, r2, false, "application/json", true);
    L5:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    @Override // com.bytedance.news.common.settings.g.a
    @NonNull
    public com.bytedance.news.common.settings.g.b b() {
        com.obric.matrix.r.c.c.b(this.f9231c, "request settings开始");
        com.bytedance.news.common.settings.g.b r1 = new com.bytedance.news.common.settings.g.b();
    L39:
        e = e;
        String r10 = this.f9231c;
        StringBuilder r3 = new StringBuilder();
    L41:
        r3.append("Cannot approach here");
        r3.append(e);
        com.obric.matrix.r.c.c.f(r10, r3.toString());
        return r1;
    L37:
        e = th;
        r10 = this.f9231c;
        r3 = new StringBuilder();
        goto L41
    L4:
        if (com.ss.android.k.c.b.b(this.f9229a) == true) goto L6;
        return r1;
    L6:
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L37 JSONException -> L39
        r2.append(this.f9230b);     // Catch: Throwable -> L37 JSONException -> L39
        com.obric.matrix.account_api.a r4 = OAccount.INSTANCE.getAccountInfo();     // Catch: Throwable -> L37 JSONException -> L39
        if (r4 == null) goto L10;
        String r5 = "?user_id=" + r4.n();     // Catch: Throwable -> L37 JSONException -> L39
    L9:
        r2.append(r5);     // Catch: Throwable -> L37 JSONException -> L39
        r2.append("&ctx_infos=" + com.bytedance.news.common.settings.g.h.a.c(this.f9229a).b());     // Catch: Throwable -> L37 JSONException -> L39
        String r6 = r2.toString();     // Catch: Throwable -> L37 JSONException -> L39
        kotlin.n0.d.o.e(r6, "sb.toString()");     // Catch: Throwable -> L37 JSONException -> L39
        String r7 = null;
        if (com.bytedance.common.utility.k.c(r6) == false) goto L14;
    L18:
        String r8 = a(r6);     // Catch: Throwable -> L37 JSONException -> L39
        if (com.bytedance.common.utility.k.c(r8) == false) goto L21;
        return r1;
    L21:
        JSONObject r9 = new JSONObject(r8);     // Catch: Throwable -> L37 JSONException -> L39
        if (com.ss.android.k.a.n(r9) == true) goto L24;
        return r1;
    L24:
        JSONObject r11 = r9.optJSONObject("data");     // Catch: Throwable -> L37 JSONException -> L39
        if (r11 == null) goto L27;
        JSONObject r12 = r11.optJSONObject("settings");     // Catch: Throwable -> L37 JSONException -> L39
    L28:
        com.bytedance.news.common.settings.g.c r13 = new com.bytedance.news.common.settings.g.c(r12, null);     // Catch: Throwable -> L37 JSONException -> L39
        com.bytedance.news.common.settings.g.b r14 = new com.bytedance.news.common.settings.g.b();     // Catch: Throwable -> L37 JSONException -> L39
        r14.f5308b = r13;     // Catch: Throwable -> L37 JSONException -> L39
        if (r11 == null) goto L31;
        JSONObject r15 = r11.optJSONObject("vid_info");     // Catch: Throwable -> L37 JSONException -> L39
    L32:
        r14.f5309c = r15;     // Catch: Throwable -> L37 JSONException -> L39
        if (r11 == null) goto L35;
        r7 = r11.optString("ctx_infos");     // Catch: Throwable -> L37 JSONException -> L39
    L35:
        r14.f5310d = r7;     // Catch: Throwable -> L37 JSONException -> L39
        r14.f5307a = true;     // Catch: Throwable -> L37 JSONException -> L39
        return r14;
    L31:
        r15 = null;
        goto L32
    L27:
        r12 = null;
        goto L28
    L14:
        if (kotlin.u0.k.A(r6, LocationInfoConst.HTTPS, false, 2, null) == true) goto L18;
        if (kotlin.u0.k.A(r6, "http", false, 2, null) == false) goto L18;
        r6 = kotlin.u0.k.y(r6, "http", LocationInfoConst.HTTPS, false, 4, null);     // Catch: Throwable -> L37 JSONException -> L39
        goto L18
    L10:
        r5 = "?user_id=0";
        goto L9
    }
}
