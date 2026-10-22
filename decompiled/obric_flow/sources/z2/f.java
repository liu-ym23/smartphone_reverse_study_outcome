package z2;

import android.app.Application;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.ai.monitor.AppletMonitorableEvent$EventOrigin;
import com.bytedance.ttnet.TTNetInit;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ExceptionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f23384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AppletMonitorableEvent$EventOrigin f23385c;
    public boolean d;
    public long e;
    public String f;
    public String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public JSONObject f23386h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public JSONObject f23387i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public JSONObject f23388j;

    public f(String r5, AppletMonitorableEvent$EventOrigin r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "origin");
        this.f23384b = "common_event";
        this.e = -1;
        this.f23383a = r5;
        this.f23385c = r10;
    }

    public static void d(String r5, String r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r11, "json");
        if (r5.length() == 0) goto L12;
        if (r10 != null) goto L7;
        return;
    L7:
        if (r10.length() == 0) goto L13;
        r11.put(r5, r10);
        return;
    L13:
        return;
    }

    public static void f(JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "json");
        u0.a r5 = s0.a.f21800c;
        Object r11 = "";
        if (r5 == null) goto L6;
        String r12 = r5.f22195b;
        if (r12 == null) goto L6;
    L8:
        if (r12.length() != 0) goto L12;
        Intrinsics.checkNotNullParameter("AppletMonitorableEvent", "tag");
        t0.d r13 = com.bytedance.ai.utils.c.f2846a;
        if (r13 == null) goto L12;
        r13.e("AppletMonitorableEvent", "did is Empty, AISDK isInitialized is false");
    L12:
        r10.put("did", r12);
        AtomicBoolean r14 = s0.a.f21798a;
        Object r15 = "Product";
        if (r14.get() == false) goto L26;
        u0.a r16 = s0.a.f21800c;
        if (r16 == null) goto L26;
        if (r16.f22203n == false) goto L20;
        Object r17 = r16.f22204o;
    L23:
        if (r17 == null) goto L26;
        r15 = r17;
        goto L26
    L20:
        if (r16.f22205p == false) goto L22;
        r17 = r16.f22206q;
        goto L23
    L22:
        r17 = "Product";
    L26:
        r10.put("http_env", r15);
        if (r14.get() == true) goto L29;
    L38:
        r10.put("gecko_env", r11);
        r10.put("ai_sdk_version", "0.90.0-rc.37-miniapp");
        return;
    L29:
        if (s0.a.f21800c == null) goto L38;
        Object[] r18 = {TTNetInit.DOMAIN_BOE_KEY, "test", "prd"};
        Application r19 = k5.d.s;
        if (r19 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("application");
        r19 = null;
    L34:
        int r20 = r19.getSharedPreferences("gecko_settings", 0).getInt("gecko_env", 2);
        if (r20 >= 3) goto L38;
        if (r20 < 0) goto L38;
        r11 = r18[r20];
    L6:
        r12 = "";
        goto L8
    }

    public JSONObject a() {
        return this.f23387i;
    }

    public final void b(String r5, Object r10) {
        if (r5.length() != 0) goto L6;
        return;
    L6:
        if (StringsKt.isBlank(r5) == true) goto L26;
    L11:
        e = move-exception;
        String r11 = "error occurred when put extra info to event: " + e.getMessage();
        Intrinsics.checkNotNullParameter("AppletMonitorableEvent", "tag");
        t0.d r12 = com.bytedance.ai.utils.c.f2846a;
        if (r12 == null) goto L24;
        r12.d("AppletMonitorableEvent", r11);
        return;
    L24:
        return;
    L9:
        if (this.f23386h != null) goto L13;
        this.f23386h = new JSONObject();     // Catch: JSONException -> L11
    L13:
        JSONObject r13 = this.f23386h;     // Catch: JSONException -> L11
        if (r13 == null) goto L23;
        r13.putOpt(r5, r10);     // Catch: JSONException -> L11
        return;
    L23:
        return;
    }

    public final void c(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        Intrinsics.checkNotNullParameter(r10, "value");
        if (r10.length() > 0) goto L5;
        return;
    L5:
        if (StringsKt.isBlank(r10) == true) goto L9;
        b(r5, r10);
        return;
    }

    public final void e(Map r5) {
        Intrinsics.checkNotNullParameter(r5, "map");
        if (this.f23386h != null) goto L19;
        this.f23386h = new JSONObject();
    L19:
        JSONObject r10 = this.f23386h;     // Catch: JSONException -> L14
        if (r5 == null) goto L23;
        if (r10 == null) goto L24;
        Iterator r11 = r5.entrySet().iterator();     // Catch: JSONException -> L14
    L11:
        if (r11.hasNext() == false) goto L26;
        Map.Entry r12 = (Map.Entry) r11.next();     // Catch: JSONException -> L14
        r10.put((String) r12.getKey(), r12.getValue());     // Catch: JSONException -> L14
        goto L11
    L26:
        return;
    L24:
        return;
    L23:
        return;
    L14:
        e = move-exception;
        String r13 = ExceptionsKt.stackTraceToString(e);
        Intrinsics.checkNotNullParameter("AppletMonitorableEvent", "tag");
        t0.d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L25;
        r14.e("AppletMonitorableEvent", r13);
        return;
    }

    public boolean g() {
        String r5 = this.f23383a;
        if (r5.length() > 0) goto L5;
        return false;
    L5:
        if (StringsKt.isBlank(r5) == true) goto L10;
        return true;
    L10:
        return false;
    }

    public JSONObject h() {
        if (g() == false) goto L5;
        JSONObject r5 = new JSONObject();     // Catch: JSONException -> L15
        r5.put("event", this.f23383a);     // Catch: JSONException -> L15
        r5.put("type", this.f23384b);     // Catch: JSONException -> L15
        r5.put("origin", this.f23385c.name());     // Catch: JSONException -> L15
        r5.put("timeStamp", this.e);     // Catch: JSONException -> L15
        d(Constant.DESCRIPTION, null, r5);     // Catch: JSONException -> L15
        d("packageId", this.f, r5);     // Catch: JSONException -> L15
        d(Constant.APPID, this.g, r5);     // Catch: JSONException -> L15
        JSONObject r10 = this.f23386h;     // Catch: JSONException -> L15
        Intrinsics.checkNotNullParameter(r5, "dst");     // Catch: JSONException -> L15
        if (r10 == null) goto L17;
        Iterator<String> r11 = r10.keys();     // Catch: JSONException -> L15
        if (r11 == null) goto L17;
    L11:
        if (r11.hasNext() == false) goto L17;
        String r12 = r11.next();     // Catch: JSONException -> L15
        Object r13 = r10.opt(r12);     // Catch: JSONException -> L15
        if (r13 == null) goto L11;
        r5.put(r12, r13);     // Catch: JSONException -> L15
    L17:
        f(r5);     // Catch: JSONException -> L15
        return r5;
    L15:
        e = move-exception;
        String r14 = "failed to convert event to json: " + e.getMessage();
        Intrinsics.checkNotNullParameter("AppletMonitorableEvent", "tag");
        t0.d r15 = com.bytedance.ai.utils.c.f2846a;
        if (r15 == null) goto L23;
        r15.d("AppletMonitorableEvent", r14);
    L23:
        return new JSONObject();
    L5:
        return new JSONObject();
    }
}
