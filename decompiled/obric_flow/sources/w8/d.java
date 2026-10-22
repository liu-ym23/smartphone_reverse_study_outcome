package w8;

import androidx.core.app.NotificationCompat;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization.JvmProtoBufUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f22794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f22795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f22796c;
    public final HashMap d;
    public final HashMap e;
    public final HashMap f;
    public String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f f22797h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int[] f22798i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f22799j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f22800k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f22801l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LinkedList f22802m;

    public d() {
        c r5 = new c();
        r5.f22787r = -1;
        r5.f22790v = null;
        this.f22794a = r5;
        this.f22795b = new HashMap();
        this.f22796c = new HashMap();
        this.d = new HashMap();
        this.e = new HashMap();
        this.f = new HashMap();
        this.f22797h = new f(this);
        this.f22798i = new int[]{0, 0, 0};
        this.f22799j = "unknown";
        this.f22800k = "unknown";
        this.f22801l = "unknown";
    }

    public final JSONObject a() {
        c r5 = this.f22794a;
        r5.getClass();
        JSONObject r10 = new JSONObject();
        JSONObject r11 = new JSONObject();
        r11.put("kswapd", r5.f22774a);     // Catch: Throwable -> L6
        r11.put("mmcqd", r5.f22775b);     // Catch: Throwable -> L6
        r11.put("kwork", r5.f22776c);     // Catch: Throwable -> L6
        r11.put("system_server", r5.d);     // Catch: Throwable -> L6
        r11.put("lmkd", r5.e);     // Catch: Throwable -> L6
        r11.put("user", r5.f);     // Catch: Throwable -> L6
        r11.put(NotificationCompat.CATEGORY_SYSTEM, r5.g);     // Catch: Throwable -> L6
        r11.put("iowait", r5.f22777h);     // Catch: Throwable -> L6
        r11.put("minor", r5.f22778i);     // Catch: Throwable -> L6
        r11.put("major", r5.f22779j);     // Catch: Throwable -> L6
        r11.put("user2", r5.f22780k);     // Catch: Throwable -> L6
        r11.put("sys2", r5.f22781l);     // Catch: Throwable -> L6
        r11.put("iowait2", r5.f22782m);     // Catch: Throwable -> L6
        r11.put("minor2", r5.f22783n);     // Catch: Throwable -> L6
        r11.put("major2", r5.f22784o);     // Catch: Throwable -> L6
        r11.put("process_name", r5.f22785p);     // Catch: Throwable -> L6
        r11.put("top_cpu_process_name", r5.f22786q);     // Catch: Throwable -> L6
        r11.put("top_cpu_process_is_anrapp", r5.f22787r);     // Catch: Throwable -> L6
        r11.put("load", r5.s);     // Catch: Throwable -> L6
        r11.put("before_cpu_list", r5.f22788t);     // Catch: Throwable -> L6
        r11.put("after_cpu_list", r5.f22789u);     // Catch: Throwable -> L6
        r11.put("cpu_thread_list", r5.f22791w);     // Catch: Throwable -> L6
        r11.put("dex2oat", r5.f22792x);     // Catch: Throwable -> L6
        r11.put("main_thread_cpu", r5.f22793y);     // Catch: Throwable -> L6
        r10.put("cpu", r11);     // Catch: Throwable -> L6
    L4:
        r5.f22774a = 0.0f;
        r5.f22775b = 0.0f;
        r5.f22776c = 0.0f;
        r5.d = 0.0f;
        r5.e = 0.0f;
        r5.f = 0.0f;
        r5.g = 0.0f;
        r5.f22777h = 0.0f;
        r5.f22787r = -1;
        r5.f22786q = null;
        r5.s = null;
        r5.f22788t = null;
        r5.f22789u = null;
        r5.f22791w = null;
        r5.f22792x = null;
        r5.f22793y = 0.0f;
        return r10;
    }

    public final void b(String r12, String r13, int r14, int r15, int r16, long r17, long r19, long r21) {
        if (this.f22802m != null) goto L16;
        JSONArray r5 = mh.e.f(l9.c.e(), new String[]{"custom_event_settings", "npth_simple_setting", "max_utm_thread_ignore"});
        if (r5 == null) goto L11;
        this.f22802m = new LinkedList();
        String r10 = r5.optString(0);
        int r11 = 1;
    L8:
        if (r11 >= r5.length()) goto L13;
        this.f22802m.add(Pattern.compile(r5.optString(r11)));     // Catch: Throwable -> L43
    L10:
        r11 = r11 + 1;
    L13:
        if (this.f22802m != null) goto L15;
        LinkedList r18 = new LinkedList();
        this.f22802m = r18;
        r18.add(Pattern.compile("^main$"));
        this.f22802m.add(Pattern.compile("^default_npth_thread$"));
        this.f22802m.add(Pattern.compile("^RenderThread$"));
        this.f22802m.add(Pattern.compile("^Jit thread pool worker thread.*$"));
    L15:
        this.f22797h.e("max_utm_thread_version", r10);
        goto L16
    L11:
        r10 = "npth_inner_default";
    L16:
        Iterator r20 = this.f22802m.iterator();
    L18:
        if (r20.hasNext() == false) goto L22;
        if (((Pattern) r20.next()).matcher(r13).matches() == false) goto L18;
    L31:
        int r22 = Integer.valueOf(r12).intValue();
        int r23 = r14 + r15;
        c r24 = this.f22794a;
        if (r24.f22791w != null) goto L35;
        r24.f22791w = new JSONObject();
    L35:
        if (JvmProtoBufUtil.DEFAULT_MODULE_NAME.equals(r13) == false) goto L37;
        r24.f22793y = r23;
    L37:
        JSONObject r25 = new JSONObject();
        r25.put("thread_name", r13);     // Catch: JSONException -> L40
        r25.put("cpu", r23);     // Catch: JSONException -> L40
        r25.put("nice", r16);     // Catch: JSONException -> L40
        r25.put("runTime", r17);     // Catch: JSONException -> L40
        r25.put("waitTime", r19);     // Catch: JSONException -> L40
        r25.put("switchCount", r21);     // Catch: JSONException -> L40
        r24.f22791w.put(String.valueOf(r22), r25);     // Catch: JSONException -> L40
        return;
    L40:
        e = move-exception;
        e.printStackTrace();
        return;
    L22:
        int[] r26 = this.f22798i;
        if (r14 <= r26[0]) goto L26;
        r26[0] = r14;
        this.f22799j = r13;
    L26:
        if (r15 <= r26[1]) goto L28;
        r26[1] = r15;
        this.f22800k = r13;
    L28:
        int r27 = r14 + r15;
        if (r27 <= r26[2]) goto L31;
        r26[2] = r27;
        this.f22801l = r13;
        goto L31
    }

    public final void c(JSONObject r5) {
        Iterator r10 = this.d.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        Map.Entry r11 = (Map.Entry) r10.next();
        String r12 = (String) r11.getKey();
        mh.e.g(r11.getValue(), r12, r5);
        goto L4
    L6:
        Iterator r13 = this.e.entrySet().iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        Map.Entry r14 = (Map.Entry) r13.next();
        String r15 = (String) r14.getKey();
        mh.e.g(r14.getValue(), r15, r5);
        goto L8
    }
}
