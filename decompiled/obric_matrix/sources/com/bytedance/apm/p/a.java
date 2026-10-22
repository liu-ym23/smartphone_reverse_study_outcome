package com.bytedance.apm.p;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.apm.k;
import com.bytedance.apm.util.i;
import com.bytedance.apm.util.q;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.boost_multidex.Constants;
import com.bytedance.common.wschannel.WsConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile f f1675a;

    /* JADX INFO: renamed from: com.bytedance.apm.p.a$a, reason: collision with other inner class name */
    static class C0050a implements com.bytedance.apm.p.g.a.InterfaceC0051a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int[] f1676a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f1677b;

        C0050a(int[] r1, d r2) {
            this.f1676a = r1;
            this.f1677b = r2;
        }

        @Override // com.bytedance.apm.p.g.a.InterfaceC0051a
        public void a(boolean r4, int r5, Exception r6, JSONObject r7) {
            JSONObject r8 = b.a(r4, r5, r6, r7);
            b.b(r8.toString());
            int[] r0 = this.f1676a;
            r0[0] = r0[0] + 1;
            if (r4 == false) goto L5;
        L7:
            d r3 = this.f1677b;
            if (r3 == null) goto L11;
            r3.a(r4, r8);
        L11:
            if (r4 == true) goto L13;
            com.bytedance.apm.c.p("apm_event_stats_alog_fail", r5, r8);
        L13:
            if (r6 == null) goto L16;
            k.e().d(r6, "apm_event_stats_alog_fail");
            return;
        L16:
            return;
        L5:
            if (r0[0] >= 2) goto L7;
        }
    }

    private static void a(String r14, long r15, long r17, String r19, d r20) {
        if (f1675a == null) goto L57;
        b.b("begin get alog file");
        List<String> r1 = f1675a.a(com.bytedance.apm.d.h(), r14, r15, r17);
        b.b("end get alog file:" + r14);
        Object r3 = "null";
        if (i.b(r1) == true) goto L41;
        com.bytedance.apm.u.c r0 = b(r1);
        if (c(r0) == true) goto L21;
        com.bytedance.apm.c.p("apm_event_stats_alog_fail", 5, null);
        if (r20 == null) goto L19;
        JSONObject r2 = new JSONObject();
        JSONObject r5 = new JSONObject();     // Catch: Exception -> L16
        r5.put(WsConstants.KEY_APP_ID, r0.a());     // Catch: Exception -> L16
        r5.put("did", r0.d());     // Catch: Exception -> L16
        r5.put("processName", r0.e());     // Catch: Exception -> L16
        if (r0.b() == null) goto L14;
        r3 = Integer.valueOf(r0.b().size());     // Catch: Exception -> L16
    L14:
        r5.put("alogSize", r3);     // Catch: Exception -> L16
        r2.put(LocationMonitorConst.INFO, r5.toString());     // Catch: Exception -> L16
    L18:
        r20.a(false, b.a(false, 5, null, r2));
    L16:
        e = move-exception;
        e.printStackTrace();
    L19:
        b.b("upload param missed");
        return;
    L21:
        b.b("alog file begin zip");
        String r4 = g(r0.b());
        b.b("alog file end zip");
        C0050a r12 = new C0050a(new int[]{0}, r20);
        if (TextUtils.isEmpty(r4) == false) goto L65;
        b.b("alog file upload origin file begin");
        boolean r6 = com.bytedance.apm.p.g.a.b(r0.a(), r0.d(), r0.e(), r0.b(), r19, r0.c(), r12);
        if (r6 == true) goto L26;
        r6 = com.bytedance.apm.p.g.a.b(r0.a(), r0.d(), r0.e(), r0.b(), r19, r0.c(), r12);
    L26:
        b.b("alog file upload origin file end. success :" + r6);
    L39:
        if (r6 == false) goto L71;
        com.bytedance.apm.c.p("apm_event_stats_alog_success", 0, null);
        return;
    L71:
        return;
    L65:
        ArrayList r7 = new ArrayList();     // Catch: Throwable -> L33
        r7.add(r4);     // Catch: Throwable -> L33
        b.b("alog file upload zip file begin");     // Catch: Throwable -> L33
        boolean r13 = com.bytedance.apm.p.g.a.b(r0.a(), r0.d(), r0.e(), r7, r19, r0.c(), r12);     // Catch: Throwable -> L33
        if (r13 == false) goto L63;
    L38:
        b.b("alog file upload zip file end. success:" + r13 + " zip file:" + r4);
        new File(r4).delete();
        r6 = r13;
        goto L39
    L63:
        r13 = com.bytedance.apm.p.g.a.b(r0.a(), r0.d(), r0.e(), r7, r19, r0.c(), r12);     // Catch: Throwable -> L31
    L31:
        th = th;
    L36:
        if (com.bytedance.apm.d.C() == false) goto L38;
        th.printStackTrace();
    L33:
        th = th;
        r13 = false;
        goto L36
    L41:
        JSONObject r8 = new JSONObject();
        r8.put(LocationMonitorConst.INFO, "alog upload file failed,local file is null");     // Catch: Exception -> L60
        r8.put("e_dir", r14);     // Catch: Exception -> L60
        r8.put("e_start_time", r15);     // Catch: Exception -> L60
        r8.put("e_end_time", r17);     // Catch: Exception -> L60
        File r9 = new File(r14);     // Catch: Exception -> L60
        if (r9.exists() == true) goto L46;
    L51:
        r8.put("e_file", "null");     // Catch: Exception -> L60
        goto L52
    L46:
        if (r9.listFiles() == null) goto L51;
        StringBuilder r10 = new StringBuilder();     // Catch: Exception -> L60
        r10.append("[");     // Catch: Exception -> L60
        File[] r11 = r9.listFiles();     // Catch: Exception -> L60
        int r16 = r11.length;     // Catch: Exception -> L60
        int r18 = 0;
    L48:
        if (r18 >= r16) goto L50;
        r10.append(r11[r18].getName());     // Catch: Exception -> L60
        r10.append(",");     // Catch: Exception -> L60
        r18 = r18 + 1;     // Catch: Exception -> L60
        goto L48
    L50:
        r10.append("]");     // Catch: Exception -> L60
        r8.put("e_file", r10.toString());     // Catch: Exception -> L60
    L52:
        JSONObject r21 = b.a(false, 4, null, r8);
        com.bytedance.apm.c.p("apm_event_stats_alog_fail", 4, r21);
        if (r20 != null) goto L67;
    L55:
        b.b("alog upload file failed,local file is null");     // Catch: Exception -> L59
        return;
    L73:
        return;
    L67:
        r20.a(false, r21);     // Catch: Exception -> L59
        goto L55
    L57:
        com.bytedance.apm.c.p("apm_event_stats_alog_fail", 12, b.a(false, 12, null, null));
    }

    private static com.bytedance.apm.u.c b(List<String> r4) {
        com.bytedance.apm.u.c r0 = new com.bytedance.apm.u.c();
        JSONObject r1 = com.bytedance.apm.d.l();
        if (r1 == null) goto L6;
        r0.f(r1.optString(WsConstants.KEY_APP_ID));
        r0.i(r1.optString(WsConstants.KEY_DEVICE_ID));
    L6:
        if (q.a(com.bytedance.apm.d.h()).contains(":") == false) goto L8;
        String r2 = q.a(com.bytedance.apm.d.h());
    L9:
        r0.j(r2);
        r0.g(r4);
        r0.h(r1);
        return r0;
    L8:
        r2 = "main";
        goto L9
    }

    private static boolean c(com.bytedance.apm.u.c r1) {
        if (TextUtils.isEmpty(r1.a()) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r1.d()) == false) goto L7;
        return false;
    L7:
        if (TextUtils.isEmpty(r1.e()) == false) goto L9;
        return false;
    L9:
        if (r1.b() != null) goto L11;
        return false;
    L11:
        if (r1.b().size() == 0) goto L20;
        return true;
    L20:
        return false;
    }

    private static String d(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return "";
    L6:
        int r0 = r4.lastIndexOf(".");
        if (r0 != (-1)) goto L11;
        return r4 + Constants.ZIP_SUFFIX;
    L11:
        return r4.substring(0, r0) + Constants.ZIP_SUFFIX;
    }

    public static void e(Context r0, f r1) {
        if (f1675a != null) goto L6;
        f1675a = r1;
        return;
    }

    public static void f(String r14, long r15, long r17, String r19, e r20, d r21) {
        long r9 = System.currentTimeMillis();
        com.bytedance.apm.c.p("apm_event_stats_alog", 0, null);
        StringBuilder r0 = new StringBuilder();
        r0.append("begin upload alog:");
        String r1 = r14;
        r0.append(r14);
        r0.append(" startTime:");
        r0.append(r15);
        r0.append(" endTime:");
        r0.append(r17);
        r0.append(" scene:");
        r0.append(r19);
        b.b(r0.toString());
        boolean r7 = true;
        if (com.bytedance.apm.d.h() != null) goto L6;
        String r2 = "apm context is null";
        int r3 = 0;
    L18:
        JSONObject r4 = new JSONObject();
        r4.put(LocationMonitorConst.INFO, r2);     // Catch: JSONException -> L21
    L23:
        JSONObject r5 = b.a(!r7, r3, null, r4);
        if (r7 == false) goto L27;
        if (r21 == null) goto L27;
        r21.a(false, r5);
    L27:
        if (r7 == false) goto L29;
        com.bytedance.apm.c.p("apm_event_stats_alog_fail", r3, r5);
    L29:
        b.b("upload end. " + r2);
        JSONObject r6 = new JSONObject();
        r6.put("time", System.currentTimeMillis() - r9);     // Catch: JSONException -> L32
    L34:
        com.bytedance.apm.c.l("apm_event_stats_alog_time", null, r6, null);
        return;
    L32:
        e = move-exception;
        e.printStackTrace();
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    L6:
        if (TextUtils.isEmpty(r14) == false) goto L12;
        if (TextUtils.isEmpty(com.bytedance.apm.d.f()) == false) goto L10;
        r2 = "alog file dir is null";
        r3 = 1;
        goto L18
    L10:
        r1 = com.bytedance.apm.d.f();
    L12:
        if (new File(r1).exists() == true) goto L14;
        r2 = "alog file dir do not exist";
        r3 = 2;
        goto L18
    L14:
        if (r20 == null) goto L16;
        r20.flushAlogDataToFile();
        b.b("flush alog data to file");
    L17:
        a(r1, r15, r17, r19, r21);
        r2 = "";
        r3 = -1;
        r7 = false;
        goto L18
    L16:
        com.bytedance.apm.c.p("apm_event_stats_alog_fail", 3, null);
        goto L17
    }

    private static String g(List<String> r4) {
        File r0 = new File(r4.get(0));
        File r2 = new File(r0.getParent(), d(r0.getName()));
        if (r2.exists() == false) goto L14;
        r2.delete();
    L14:
        com.bytedance.apm.util.e.b(r2.getAbsolutePath(), (String[]) r4.toArray(new String[0]));     // Catch: Exception -> L8
        return r2.getAbsolutePath();
    L9:
        if (r2.exists() == false) goto L17;
        r2.delete();     // Catch: Exception -> L13
        return null;
    L17:
        return null;
    L18:
        return null;
    }
}
