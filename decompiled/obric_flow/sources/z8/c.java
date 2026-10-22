package z8;

import android.content.Context;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICommonParams;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.n;
import com.bytedance.crash.util.h;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import okhttp3.internal.ws.RealWebSocket;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ym.m;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f23416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Header f23417b;

    public c() {
        this.f23416a = new JSONObject();
    }

    public static String a(long r5) {
        if (r5 > RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) goto L7;
        return "0 - 1K";
    L7:
        if (r5 > 65536) goto L11;
        return "1K - 64K";
    L11:
        if (r5 > 524288) goto L15;
        return "64K - 512K";
    L15:
        if (r5 > 1048576) goto L19;
        return "512K - 1M";
    L19:
        if (r5 > 67108864) goto L22;
        return "1M - 64M";
    L22:
        return "64M - ";
    }

    public static c c(Context r5, long r10, String r11) {
        c r12 = new c();
        JSONObject r13 = r12.f23416a;
        mh.e.g(1, "is_dart", r13);
        mh.e.g(Long.valueOf(r10), "crash_time", r13);
        mh.e.g(m.o(r5), "process_name", r13);
        mh.e.g(r11, "data", r13);
        m.g(r5, r13);
        return r12;
    }

    public static c d(Context r5, String r10, String r11, String r12) {
        c r13 = new c();
        Long r14 = Long.valueOf(System.currentTimeMillis());
        JSONObject r15 = r13.f23416a;
        mh.e.g(r14, "crash_time", r15);
        mh.e.g(m.o(r5), "process_name", r15);
        mh.e.g(r10, "crash_name", r15);
        mh.e.g(r11, "crash_reason", r15);
        mh.e.g(r12, "data", r15);
        mh.e.g(CrashType.GAME.getName(), "crash_type", r15);
        m.g(r5, r15);
        return r13;
    }

    public static void l(JSONObject r5, String r10, String r11, Object r12) {
        if (r5 != null) goto L4;
        return;
    L4:
        JSONObject r13 = r5.optJSONObject(r10);
        if (r13 != null) goto L7;
        r13 = new JSONObject();
        mh.e.g(r13, r10, r5);
    L7:
        mh.e.g(r12, r11, r13);
    }

    public static void m(JSONObject r5, Map r10) {
        if (r10 != null) goto L10;
        return;
    L10:
        Iterator r11 = r10.entrySet().iterator();     // Catch: Throwable -> L9
    L5:
        if (r11.hasNext() == false) goto L15;
        Map.Entry r12 = (Map.Entry) r11.next();     // Catch: Throwable -> L9
        r5.put((String) r12.getKey(), r12.getValue());     // Catch: Throwable -> L9
    L15:
        return;
    }

    public static void n(JSONObject r10, JSONObject r11) {
        if (r10 == null) goto L32;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.length() <= 0) goto L57;
        Iterator<String> r5 = r11.keys();     // Catch: JSONException -> L33
    L8:
        if (r5.hasNext() == false) goto L59;
        String r12 = r5.next();     // Catch: JSONException -> L33
        Object r13 = r10.opt(r12);     // Catch: JSONException -> L33
        if (r13 == null) goto L12;
        if ((r13 instanceof JSONObject) == true) goto L15;
        if ((r13 instanceof JSONArray) == true) goto L18;
        r10.put(r12, r11.opt(r12));     // Catch: JSONException -> L33
        goto L8
    L18:
        JSONArray r14 = r11.optJSONArray(r12);     // Catch: JSONException -> L33
        if (r14 == null) goto L8;
        JSONArray r15 = (JSONArray) r13;     // Catch: JSONException -> L33
        int r16 = 0;
        if (r15.length() != 1) goto L28;
        if ((r15.opt(0) instanceof JSONObject) == false) goto L28;
        if ((r14.opt(0) instanceof JSONObject) == false) goto L28;
        n(r15.getJSONObject(0), r14.getJSONObject(0));     // Catch: JSONException -> L33
    L28:
        if (r16 >= r14.length()) goto L8;
        r15.put(r14.get(r16));     // Catch: JSONException -> L33
        r16 = r16 + 1;     // Catch: JSONException -> L33
        goto L28
    L15:
        n(r10.getJSONObject(r12), r11.getJSONObject(r12));     // Catch: JSONException -> L33
        goto L8
    L12:
        r10.put(r12, r11.opt(r12));     // Catch: JSONException -> L33
        goto L8
    L59:
        return;
    L58:
        return;
    L57:
        return;
    }

    public final JSONObject b() {
        JSONObject r5 = this.f23416a;
        Object r10 = r5.opt("data");
        if ((r10 instanceof JSONArray) == true) goto L5;
        return r5;
    L5:
        return ((JSONArray) r10).optJSONObject(0);
    }

    public final void e(float r5, String r10) {
        JSONObject r11 = this.f23416a;
        if (r11 == null) goto L13;
        JSONObject r12 = r11.optJSONObject("features_num");
        if (r12 == null) goto L11;
    L8:
        r12.put(r10, r5);     // Catch: Throwable -> L10
        return;
    L14:
        return;
    L11:
        r12 = new JSONObject();     // Catch: Throwable -> L10
        r11.put("features_num", r12);     // Catch: Throwable -> L10
        goto L8
    }

    public final void f(long r5, long r10) {
        JSONObject r11 = this.f23416a;
        mh.e.g(Long.valueOf(r5), "app_start_time", r11);     // Catch: Exception -> L6
        if (r10 == 0) goto L8;
        mh.e.g(Long.valueOf(r10), "app_start_up_time", r11);     // Catch: Exception -> L6
    L8:
        mh.e.g(new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault()).format(new Date(r5)), "app_start_time_readable", r11);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public final void g(ICommonParams r10) {
        boolean r5 = u8.a.f22265b;
        Boolean r11 = Boolean.valueOf(r5);
        JSONObject r12 = this.f23416a;
        mh.e.g(r11, "mira_init", r12);
        JSONArray r13 = null;
        if (r5 == true) goto L21;
    L18:
        mh.e.g(r13, "plugin_info", r12);
        return;
    L21:
        Map<String, Integer> r14 = r10.getPluginInfo();     // Catch: Throwable -> L16
        if (r14 == null) goto L18;
        JSONArray r15 = new JSONArray();     // Catch: Throwable -> L16
        Iterator<Map.Entry<String, Integer>> r16 = r14.entrySet().iterator();     // Catch: Throwable -> L12
    L9:
        if (r16.hasNext() == false) goto L14;
        Map.Entry<String, Integer> r17 = r16.next();     // Catch: Throwable -> L12
        JSONObject r18 = new JSONObject();     // Catch: Throwable -> L12
        r18.put(Constant.PACKAGE_NAME, r17.getKey());     // Catch: Throwable -> L12
        r18.put("version_code", r17.getValue());     // Catch: Throwable -> L12
        r15.put(r18);     // Catch: Throwable -> L12
        goto L9
    L14:
        r13 = r15;
    L12:
        th = th;
        r13 = r15;
    L23:
        r12.put("Code err:\n" + h.a(th), 0);     // Catch: Throwable -> L20
    L16:
        th = th;
        goto L23
    }

    public final void h(String r5, long r10) {
        JSONObject r11 = this.f23416a;
        if (r11 == null) goto L13;
        JSONObject r12 = r11.optJSONObject("features_num");
        if (r12 == null) goto L11;
    L8:
        r12.put(r5, r10);     // Catch: Throwable -> L10
        return;
    L14:
        return;
    L11:
        r12 = new JSONObject();     // Catch: Throwable -> L10
        r11.put("features_num", r12);     // Catch: Throwable -> L10
        goto L8
    }

    public final void i(String r5, Object r10) {
        mh.e.g(r10, r5, this.f23416a);
    }

    public final void j(String r5, String r10) {
        l(this.f23416a, "anr_timestamp", r5, r10);
    }

    public final void k(HashMap r10) {
        if (r10 == null) goto L33;
        JSONObject r5 = this.f23416a;
        Object r11 = r5.opt("data");
        if ((r11 instanceof JSONArray) == false) goto L6;
        JSONObject r12 = ((JSONArray) r11).optJSONObject(0);
    L8:
        if (r12 != null) goto L10;
        JSONObject r13 = new JSONObject();
    L26:
        Iterator r14 = r10.entrySet().iterator();     // Catch: Throwable -> L18
    L15:
        if (r14.hasNext() == false) goto L23;
        Map.Entry r15 = (Map.Entry) r14.next();     // Catch: Throwable -> L18
        String r16 = (String) r15.getKey();     // Catch: Throwable -> L18
        mh.e.g(r15.getValue(), r16, r13);     // Catch: Throwable -> L18
    L18:
        Iterator r17 = r10.entrySet().iterator();     // Catch: Throwable -> L25
    L20:
        if (r17.hasNext() == false) goto L23;
        Map.Entry r18 = (Map.Entry) r17.next();     // Catch: Throwable -> L25
        String r19 = (String) r18.getKey();     // Catch: Throwable -> L25
        mh.e.g(r18.getValue(), r19, r13);     // Catch: Throwable -> L25
    L23:
        mh.e.g(r13, "filters", r5);
        return;
    L10:
        r13 = r12.optJSONObject("filters");
        if (r13 != null) goto L26;
        r13 = new JSONObject();
        mh.e.g(r13, "filters", r5);
        goto L26
    L6:
        r12 = r5;
        goto L8
    }

    public final Header o() {
        if (this.f23417b != null) goto L6;
        Context r5 = n.f4057a;
        Header r10 = new Header();
        this.f23417b = r10;
        mh.e.g(r10.f4029a, "header", this.f23416a);
        this.f23417b = r10;
    L6:
        return this.f23417b;
    }

    public final void p(String r5, String r10) {
        l(b(), "filters", r5, r10);
    }

    public c(JSONObject r5) {
        this.f23416a = r5;
    }
}
