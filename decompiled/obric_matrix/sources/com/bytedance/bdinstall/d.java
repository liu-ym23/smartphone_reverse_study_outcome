package com.bytedance.bdinstall;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.matrix.common_api.INetworkApi;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f2724a = null;

    class a extends com.ss.android.ugc.quota.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f2725a;

        a(boolean r1) {
            this.f2725a = r1;
        }

        @Override // com.ss.android.ugc.quota.a, com.ss.android.ugc.quota.b
        public boolean markAsNewUser() {
            return !this.f2725a;
        }

        @Override // com.ss.android.ugc.quota.a, com.ss.android.ugc.quota.b
        public int triggerType() {
            return 0;
        }
    }

    class b extends com.ss.android.ugc.quota.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f2726a;

        b(boolean r1) {
            this.f2726a = r1;
        }

        @Override // com.ss.android.ugc.quota.a, com.ss.android.ugc.quota.b
        public boolean markAsNewUser() {
            return !this.f2726a;
        }

        @Override // com.ss.android.ugc.quota.a, com.ss.android.ugc.quota.b
        public int triggerType() {
            return 0;
        }
    }

    static {
        f2724a = new String[]{WsConstants.KEY_APP_ID, WsConstants.KEY_APP_VERSION, "tt_data", WsConstants.KEY_DEVICE_ID, "bd_did"};
    }

    static boolean a(d0 r1, String r2, boolean r3, y r4, boolean r5) {
        StringBuilder r0 = new StringBuilder(r2);
        HashMap<String, String> r6 = c(r5);
        JSONObject r7 = null;
        String r8 = r1.get(d(r0.toString(), r3, r4), r6);     // Catch: Exception -> L5
    L7:
        if (r8 != null) goto L18;
    L12:
        if (r7 != null) goto L14;
    L16:
        return false;
    L14:
        if ("success".equals(r7.optString("message", "")) == false) goto L16;
        return true;
    L18:
        r7 = new JSONObject(r8);     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        q.c("Register#active parse json error " + r8 + ", " + e);
        e.printStackTrace();
    L5:
        e = move-exception;
        q.c("Register#active http error = " + e);
        r8 = null;
        goto L7
    }

    static void b(StringBuilder r2, String r3, String r4) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r3) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r4) == false) goto L9;
        return;
    L9:
        if (r2.toString().indexOf(63) >= 0) goto L11;
        String r0 = "?";
    L12:
        r2.append(r0);
        r2.append(r3);
        r2.append("=");
        r2.append(Uri.encode(r4));
        return;
    L11:
        r0 = "&";
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static HashMap<String, String> c(boolean r3) {
        HashMap<String, String> r0 = new HashMap();
        Pair<String, String> r4 = BDNetworkTagManager.d().a(new a(r3));     // Catch: Throwable -> L7
        if (r4 == null) goto L6;
        r0.put(r4.first, r4.second);     // Catch: Throwable -> L7
    L6:
        return r0;
    }

    private static String d(String r8, boolean r9, y r10) {
        if (TextUtils.isEmpty(r8) == true) goto L20;
        Uri r11 = Uri.parse(r8);
        String r0 = r11.getQuery();
        ArrayList r1 = new ArrayList();
        String[] r2 = f2724a;
        int r3 = r2.length;
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L10;
        String r5 = r2[r4];
        String r6 = r11.getQueryParameter(r5);
        if (TextUtils.isEmpty(r6) == true) goto L9;
        r1.add(new Pair(r5, r6));
    L9:
        r4 = r4 + 1;
        goto L5
    L10:
        Uri.Builder r12 = r11.buildUpon();
        r12.clearQuery();
        Iterator r7 = r1.iterator();
    L12:
        if (r7.hasNext() == false) goto L14;
        Pair r13 = (Pair) r7.next();
        r12.appendQueryParameter((String) r13.first, (String) r13.second);
        goto L12
    L14:
        r12.appendQueryParameter("tt_info", new String(Base64.encode(g(r0, r9, r10), 8)));
        return r12.build().toString();
    L20:
        return r8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static HashMap<String, String> e(boolean r2, boolean r3) {
        HashMap<String, String> r0 = new HashMap(2);
        if (r2 == false) goto L5;
        String r4 = "application/octet-stream;tt-data=a";
    L6:
        r0.put(INetworkApi.CONTENT_TYPE, r4);
        Pair<String, String> r5 = BDNetworkTagManager.d().a(new b(r3));     // Catch: Throwable -> L11
        if (r5 == null) goto L10;
        r0.put(r5.first, r5.second);     // Catch: Throwable -> L11
    L10:
        return r0;
    L5:
        r4 = INetworkApi.DEFAULT_CONTENT_TYPE;
        goto L6
    }

    static JSONObject f(d0 r1, String r2, JSONObject r3, boolean r4, y r5, boolean r6) {
        HashMap<String, String> r7 = e(r4, r6);
        byte[] r8 = g(r3.toString(), r4, r5);     // Catch: Exception -> L9
        if (r8 == null) goto L7;
        if (r4 == false) goto L7;
        r2 = r2 + "&tt_data=a";     // Catch: Exception -> L9
    L7:
        String r9 = r1.a(r2, r8, r7);     // Catch: Exception -> L9
    L11:
        if (r9 == null) goto L21;
        return new JSONObject(r9);
    L14:
        e = move-exception;
        q.c("Register#doRegister parse json error " + r9 + ", " + e);
        e.printStackTrace();
        return null;
    L21:
        return null;
    L9:
        e = move-exception;
        q.c("Register#doRegister http error = " + e);
        r9 = null;
        goto L11
    }

    private static byte[] g(String r4, boolean r5, y r6) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r2 = null;
        if (r5 == false) goto L11;
        GZIPOutputStream r3 = new GZIPOutputStream(r0);     // Catch: Throwable -> L9
        r3.write(r4.getBytes("UTF-8"));     // Catch: Throwable -> L7
        r2 = r3;
    L12:
        if (r2 == null) goto L21;
        r2.close();     // Catch: IOException -> L19
    L33:
    L21:
        byte[] r7 = r0.toByteArray();
        if (r5 == false) goto L43;
        if (r6 != null) goto L25;
        return r7;
    L25:
        return r6.a(r7, r7.length);
    L43:
        return r7;
    L7:
        th = th;
        r2 = r3;
    L36:
        q.i(th);     // Catch: Throwable -> L26
        if (r2 == null) goto L21;
        r2.close();     // Catch: IOException -> L19
    L26:
        th = move-exception;
        if (r2 != null) goto L40;
    L32:
        throw th;
    L40:
        r2.close();     // Catch: IOException -> L30
    L30:
        e = move-exception;
        q.i(e);
        goto L32
    L11:
        r0.write(r4.getBytes("UTF-8"));     // Catch: Throwable -> L9
    L19:
        e = move-exception;
        q.i(e);
    L9:
        th = th;
        goto L36
    }
}
