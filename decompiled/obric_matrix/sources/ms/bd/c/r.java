package ms.bd.c;

import android.content.Context;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class r extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.framwork.core.sdkmonitor.k f22471b;

    class a implements com.bytedance.framwork.core.sdkmonitor.k.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f22472a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f22473b;

        a(r r1, JSONObject r2, String r3) {
            this.f22472a = r2;
            this.f22473b = r3;
        }

        @Override // com.bytedance.framwork.core.sdkmonitor.k.m
        public Map<String, String> getCommonParams() {
            HashMap r1 = new HashMap();
            String r2 = (String) m.a(16777217, 0, 0, "961077", new byte[]{39, 34, 71, 86, 27, 37, 59});     // Catch: JSONException -> L14
            if (this.f22472a.getBoolean((String) m.a(16777217, 0, 0, "c1af7f", new byte[]{125, 37, 23, 0, 27, 116, 97})) == false) goto L11;
            Object r3 = m.a(16777217, 0, 0, "6c000f", new byte[]{118});     // Catch: JSONException -> L14
        L12:
            r1.put(r2, (String) r3);     // Catch: JSONException -> L14
        L15:
            r1.put((String) m.a(16777217, 0, 0, "beb5b5", new byte[]{123, 104, 2, 85, 98, 35, 104, 64}), this.f22473b);
            return r1;
        L11:
            r3 = m.a(16777217, 0, 0, "bf7ea2", new byte[]{35});     // Catch: JSONException -> L14
        L14:
            String r4 = (String) m.a(16777217, 0, 0, "c602e6", new byte[]{97, 49, 78, 121, 93, 50});
            goto L15
        }

        @Override // com.bytedance.framwork.core.sdkmonitor.k.m
        public String getSessionId() {
            return null;
        }
    }

    public r() {
    }

    @Override // ms.bd.c.q
    public void d(long r11, long r13, String r15, String r16, String r17, int r18, JSONObject r19) {
        com.bytedance.framwork.core.sdkmonitor.k r0 = this.f22471b;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.V(r11, r13, r15, null, r17, r18, null);
    }

    @Override // ms.bd.c.q
    public void e(String r2, JSONObject r3, JSONObject r4, JSONObject r5) {
        if (this.f22471b != null) goto L6;
        return;
    L6:
        if (r3.length() <= 0) goto L8;
    L9:
        this.f22471b.X(r2, r3, r4, r5);
        return;
    L8:
        if (r4.length() > 0) goto L9;
    }

    @Override // ms.bd.c.q
    public boolean g(String r30) {
        Context r1 = ms.bd.c.a.a().c();
        String r2 = null;
        JSONObject r4 = new JSONObject(r30);     // Catch: JSONException -> L5
    L7:
        if (r4 != null) goto L36;
        return false;
    L36:
        String r6 = r4.getString((String) m.a(16777217, 0, 0, "d1e896", new byte[]{102, 55, 29, 115, 7, 40, 99}));     // Catch: JSONException -> L32
        r2 = r4.getString((String) m.a(16777217, 0, 0, "2993c1", new byte[]{43, 52, 89, 83, 99, 39, 56, 28}));     // Catch: JSONException -> L31
        ArrayList r8 = new ArrayList();     // Catch: JSONException -> L31
        ArrayList r10 = new ArrayList();     // Catch: JSONException -> L31
        JSONArray r9 = r4.getJSONArray((String) m.a(16777217, 0, 0, "18c3bd", new byte[]{35, 53, 30, 65, 84, 116, 7, 43, 30, 112}));     // Catch: JSONException -> L31
        JSONArray r3 = r4.getJSONArray((String) m.a(16777217, 0, 0, "b51f81", new byte[]{97, 50, 82, 29, 21, 50, 84, 38, 76, 37}));     // Catch: JSONException -> L31
        int r7 = 0;
    L18:
        if (r7 >= r9.length()) goto L20;
        r8.add(r9.getString(r7));     // Catch: JSONException -> L31
        r7 = r7 + 1;     // Catch: JSONException -> L31
        goto L18
    L20:
        int r11 = 0;
    L22:
        if (r11 >= r3.length()) goto L25;
        r10.add(r3.getString(r11));     // Catch: JSONException -> L31
        r11 = r11 + 1;     // Catch: JSONException -> L31
        goto L22
    L25:
        if (r8.size() > 0) goto L27;
    L30:
        return false;
    L27:
        if (r10.size() <= 0) goto L30;
        SDKMonitorUtils.d(r6, r8);     // Catch: JSONException -> L31
        SDKMonitorUtils.e(r6, r10);     // Catch: JSONException -> L31
    L34:
        r4.remove((String) m.a(16777217, 0, 0, "580980", new byte[]{39, 53, 77, 75, 14, 32, 3, 43, 77, 122}));
        r4.remove((String) m.a(16777217, 0, 0, "6284ea", new byte[]{53, 53, 91, 79, 72, 98, 0, 33, 69, 119}));
        SDKMonitorUtils.c(r1, r6, r4, new a(this, r4, r2));
        this.f22471b = SDKMonitorUtils.b(r6);
        return true;
    L31:
        String r5 = r2;
        r2 = r6;
    L33:
        String r12 = (String) m.a(16777217, 0, 0, "2cc6dc", new byte[]{48, 100, 29, 125, 82});
        r6 = r2;
        r2 = r5;
    L32:
        r5 = null;
    L5:
        String r13 = (String) m.a(16777217, 0, 0, "016a82", new byte[]{50, 54, 72});
        r4 = null;
        goto L7
    }

    @Override // ms.bd.c.q
    public void h(long r11, long r13, String r15, String r16, String r17, int r18, JSONObject r19) {
        com.bytedance.framwork.core.sdkmonitor.k r0 = this.f22471b;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.Y(r11, r13, r15, null, r17, r18, null);
    }
}
