package so;

import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.bytedance.apm.agent.tracing.AutoPageTraceHelper;
import com.bytedance.apm.agent.v2.instrumentation.FragmentTimeAgent;
import com.bytedance.crash.n;
import com.bytedance.crash.util.NativeTools;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.concurrent.ConcurrentLinkedQueue;
import l9.o;
import l9.u;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import zm.p;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21968a;

    public /* synthetic */ e(int r5) {
        this.f21968a = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long r5 = 0;
        int r10 = 0;
        switch(this.f21968a) {
            case 0: goto L149;
            case 1: goto L173;
            case 2: goto L94;
            case 3: goto L92;
            case 4: goto L157;
            case 5: goto L178;
            case 6: goto L27;
            case 7: goto L18;
            case 8: goto L15;
            case 9: goto L161;
            case 10: goto L6;
            default: goto L4;
        };
    L4:
        zn.a.f23550b.a();
        return;
    L6:
        long r11 = SystemClock.uptimeMillis();
        new zf.j().a();     // Catch: Throwable -> L9
        Log.i("warmClassForImage", "image warm-up cost:" + (SystemClock.uptimeMillis() - r11));     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        th.printStackTrace();
        return;
    L18:
        File r12 = w8.e.f22803a;
        monitor-enter(w8.e.class);
        w8.e.g = false;     // Catch: Throwable -> L24
        w8.e.f22803a = null;     // Catch: Throwable -> L24
        w8.e.f22810l = null;     // Catch: Throwable -> L24
        w8.e.f22804b = null;     // Catch: Throwable -> L24
        monitor-exit(w8.e.class);     // Catch: Throwable -> L24
        cl.a.C(r12);
        return;
    L24:
        th = move-exception;
        throw th;
    L27:
        File r13 = w8.e.f22803a;
        monitor-enter(w8.e.class);
        w8.e.f22803a = null;     // Catch: Throwable -> L33
        w8.e.f22810l = null;     // Catch: Throwable -> L33
        w8.e.f22804b = null;     // Catch: Throwable -> L33
        monitor-exit(w8.e.class);     // Catch: Throwable -> L33
        cl.a.C(r13);
        return;
    L33:
        th = move-exception;
        throw th;
    L92:
        boolean r14 = FragmentTimeAgent.access$100().contains(FragmentTimeAgent.access$000());
        FragmentTimeAgent.access$100().add(FragmentTimeAgent.access$000());
        FragmentTimeAgent.access$200(r14, null, 0, 0);
        return;
    L94:
        ConcurrentLinkedQueue r15 = AutoPageTraceHelper.f3843c;
        int r16 = r15.size();     // Catch: Exception -> L122
    L96:
        if (r10 >= r16) goto L207;
        t5.a r17 = (t5.a) r15.peek();     // Catch: Exception -> L122
        if (r17 == null) goto L208;
        if (r17.f == r5) goto L205;
        t5.a r18 = (t5.a) r15.poll();     // Catch: Exception -> L122
        long r19 = r18.f22100b;     // Catch: Exception -> L122
        String r110 = r18.f22099a;
        if (r19 <= r5) goto L209;
        if (r18.f22101c <= r5) goto L210;
        if (r18.d <= r5) goto L211;
        if (r18.e <= r5) goto L212;
        JSONObject r111 = new JSONObject();     // Catch: Exception -> L122
        r111.put("name", "onCreate");     // Catch: Exception -> L122
        r111.put("start", r19);     // Catch: Exception -> L122
        r111.put("end", r18.f22101c);     // Catch: Exception -> L122
        JSONObject r20 = new JSONObject();     // Catch: Exception -> L122
        r20.put("name", "onResume");     // Catch: Exception -> L122
        r20.put("start", r18.d);     // Catch: Exception -> L122
        r20.put("end", r18.e);     // Catch: Exception -> L122
        JSONObject r21 = new JSONObject();     // Catch: Exception -> L122
        r21.put("name", "onWindowFocusChanged");     // Catch: Exception -> L122
        ConcurrentLinkedQueue r112 = r15;
        int r22 = r16;
        r21.put("start", r18.f);     // Catch: Exception -> L122
        JSONArray r23 = new JSONArray();     // Catch: Exception -> L122
        r23.put(r111);     // Catch: Exception -> L122
        r23.put(r20);     // Catch: Exception -> L122
        r23.put(r21);     // Catch: Exception -> L122
        JSONObject r24 = new JSONObject();     // Catch: Exception -> L122
        r24.put("name", "page_load_stats");     // Catch: Exception -> L122
        r24.put("page_type", "activity");     // Catch: Exception -> L122
        r24.put("start", r19);     // Catch: Exception -> L122
        r24.put("end", r18.f);     // Catch: Exception -> L122
        long r25 = r18.f - r19;     // Catch: Exception -> L122
        if (r25 >= 0) goto L114;
        Object r26 = null;
    L121:
        int r27 = 1;
    L125:
        r10 = r10 + r27;
        r15 = r112;
        r16 = r22;
        r5 = 0;
        goto L96
    L114:
        if (r25 <= AutoPageTraceHelper.d) goto L116;
        r27 = 1;
        r26 = null;
        goto L125
    L116:
        r24.put("spans", r23);     // Catch: Exception -> L122
        HashSet r28 = AutoPageTraceHelper.f3842b;     // Catch: Exception -> L122
        if (r28.contains(r110) == false) goto L119;
        int r29 = 2;
    L120:
        r28.add(r110);     // Catch: Exception -> L122
        r24.put("launch_mode", r29);     // Catch: Exception -> L122
        r24.put("collect_from", 1);     // Catch: Exception -> L122
        r24.put("page_name", r110);     // Catch: Exception -> L122
        JSONObject r30 = new JSONObject();     // Catch: Exception -> L122
        r30.put("trace", r24);     // Catch: Exception -> L122
        r26 = null;
        z6.b.f23409a.d(new com.bytedance.apm.e("page_load_trace", null, null, r30));     // Catch: Exception -> L122
        goto L121
    L119:
        r29 = 1;
        goto L120
    L212:
        return;
    L211:
        return;
    L210:
        return;
    L209:
        return;
    L205:
        return;
    L208:
        return;
    L207:
        return;
    L122:
        e = move-exception;
        if (com.bytedance.apm.j.f3887a == false) goto L206;
        e.printStackTrace();
        return;
    L206:
        return;
    L149:
        mn.h.h();
        return;
    L157:
        if (FragmentTimeAgent.access$500() != null) goto L87;
        return;
    L87:
        if (FragmentTimeAgent.access$300() != null) goto L89;
        return;
    L89:
        if (FragmentTimeAgent.access$300().get() == null) goto L203;
        ((View) FragmentTimeAgent.access$300().get()).getViewTreeObserver().removeOnGlobalLayoutListener(FragmentTimeAgent.access$500());     // Catch: Exception -> L156
        return;
    L203:
        return;
    L204:
        return;
    L161:
        new am.a("npth-tick", 6).start();     // Catch: Throwable -> L155
        return;
    L199:
        return;
    L178:
        w8.e.e.take();     // Catch: Throwable -> L151
        int r31 = 0;
    L38:
        if (r31 > 240) goto L83;
        if (p.j() == true) goto L41;
        r31 = r31 + 1;     // Catch: Throwable -> L151
        SystemClock.sleep(500);     // Catch: Throwable -> L151
        goto L38
    L41:
        w8.e.f22807i = System.currentTimeMillis();     // Catch: Throwable -> L151
        u r32 = o.e();     // Catch: Throwable -> L151
        e r33 = w8.e.f22813o;     // Catch: Throwable -> L151
        if (r32.f19595b.isEmpty() == true) goto L44;
    L45:
        u.d(r32.f19595b, r33, u.f);     // Catch: Throwable -> L151
        u.d(r32.f19596c, r33, u.g);     // Catch: Throwable -> L151
    L47:
        if (r32.d == null) goto L50;
        r32.d.removeCallbacks(r33);     // Catch: Throwable -> L151
    L50:
        if (w8.e.g == true) goto L60;
        monitor-enter(w8.e.class);     // Catch: Throwable -> L151
        w8.e.g = true;     // Catch: Throwable -> L57
        monitor-exit(w8.e.class);     // Catch: Throwable -> L57
        goto L178
    L55:
        w8.e.d(0, System.currentTimeMillis(), false);     // Catch: Throwable -> L151
    L57:
        th = move-exception;
        throw th;     // Catch: Throwable -> L151
    L60:
        File r34 = new File(com.bytedance.crash.util.g.h(n.f4057a), x8.a.f22986i + "/proc/" + Process.myPid());     // Catch: Throwable -> L151
        File r35 = new File(r34, "anr_info_" + System.currentTimeMillis() + "_current");     // Catch: Throwable -> L151
        cl.a.I(new File(r34, "thread"));     // Catch: Throwable -> L151
        if (TextUtils.isEmpty("silent anr no anr info") == true) goto L68;
        r35.getParentFile().mkdirs();     // Catch: Throwable -> L151
        FileOutputStream r36 = new FileOutputStream(r35, false);     // Catch: Throwable -> L67
        r36.write("silent anr no anr info".getBytes());     // Catch: Throwable -> L153
        r36.flush();     // Catch: Throwable -> L153
    L66:
        com.bytedance.android.anniex.base.service.f.h(r36);     // Catch: Throwable -> L151
    L67:
        r36 = null;
    L68:
        String r37 = "";
        int r38 = 0;
    L70:
        if (r38 >= 800) goto L76;
        r37 = p.c(n.f4057a);     // Catch: Throwable -> L151
        if (TextUtils.isEmpty(r37) == false) goto L76;
        SystemClock.sleep(60);     // Catch: Throwable -> L151
        r38 = r38 + 1;     // Catch: Throwable -> L151
    L76:
        if (TextUtils.isEmpty(r37) == false) goto L78;
        w8.e.e(r34.getParentFile(), r35, "silent anr no anr info");     // Catch: Throwable -> L151
        goto L83
    L78:
        cl.a.C(r35);     // Catch: Throwable -> L151
        File r39 = new File(r34, "anr_info_" + System.currentTimeMillis() + "_current");     // Catch: Throwable -> L151
        cl.a.u(r37, r39, false);     // Catch: Throwable -> L151 IOException -> L152
    L80:
        w8.e.e(r34.getParentFile(), r39, r37);     // Catch: Throwable -> L151
        goto L83
    L44:
        if (r32.f19596c.isEmpty() == true) goto L47;
    L83:
        File r40 = w8.e.f22803a;
        goto L178
    L15:
        if (n.f4075x == false) goto L200;
        NativeTools.k().s(Build.VERSION.SDK_INT);
        return;
    L200:
        return;
    L173:
        if (com.bytedance.apm.j.f == (-1)) goto L135;
        long r41 = sk.a.f21947n - sk.a.f21939b;     // Catch: JSONException -> L154
        if (r41 > 0) goto L140;
        return;
    L140:
        if (r41 > 15000) goto L216;
        JSONArray r42 = sk.a.e();     // Catch: JSONException -> L154
        JSONObject r43 = new JSONObject();     // Catch: JSONException -> L154
        r43.put("name", "launch_stats");     // Catch: JSONException -> L154
        r43.put("start", sk.a.f21939b);     // Catch: JSONException -> L154
        r43.put("end", sk.a.f21947n);     // Catch: JSONException -> L154
        r43.put("spans", r42);     // Catch: JSONException -> L154
        r43.put("collect_from", 1);     // Catch: JSONException -> L154
        r43.put("page_name", sk.a.f21949p);     // Catch: JSONException -> L154
        r43.put("launch_mode", com.bytedance.apm.j.f);     // Catch: JSONException -> L154
        JSONObject r113 = new JSONObject();     // Catch: JSONException -> L154
        r113.put("trace", r43);     // Catch: JSONException -> L154
        if (com.bytedance.apm.j.f3887a == false) goto L147;
        String r44 = "auto span: " + r43;     // Catch: JSONException -> L154
        if (com.bytedance.apm.j.f3887a == false) goto L147;
        Log.d("LaunchAnalysis", r44);     // Catch: JSONException -> L154
    L147:
        i6.a.i().b(new j6.e("start_trace", "", null, null, r113));     // Catch: JSONException -> L154
        return;
    L216:
        return;
    L135:
        if (com.bytedance.apm.j.f3887a == false) goto L213;
        Log.d("LaunchAnalysis", "auto launch mode not init");     // Catch: JSONException -> L154
        return;
    L213:
        return;
    }
}
