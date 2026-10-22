package d.b.b.e.a.k;

import android.app.Application;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.apm.doctor.DoctorManager;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.services.apm.api.EnsureManager;
import com.bytedance.services.apm.api.HttpResponse;
import com.bytedance.services.apm.api.IEncrypt;
import com.bytedance.services.apm.api.IZstdCompress;
import com.bytedance.services.apm.api.IZstdDict;
import com.bytedance.services.slardar.config.IConfigManager;
import com.obric.matrix.common_api.INetworkApi;
import d.b.b.o.k;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static HashMap<f, e> f12684j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static volatile int f12685k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f12686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f12687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f12688c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f12689d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Boolean f12690e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<String> f12691f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private IZstdCompress f12692g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private IZstdDict f12693h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f12694i;

    static {
        f12684j = new HashMap();
    }

    private e(f r2) {
        this.f12689d = null;
        this.f12694i = 0;
        this.f12691f = r2.b();
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.ALL, value = "android.content.Context")
    public static SharedPreferences a(Application r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    private byte[] c(byte[] r3) {
        ByteArrayOutputStream r2 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r0 = null;
        GZIPOutputStream r1 = new GZIPOutputStream(r2);     // Catch: Throwable -> L9 IOException -> L12
        r1.write(r3);     // Catch: Throwable -> L7 IOException -> L15
        d.b.b.o.d.a(r1);
        return r2.toByteArray();
    L7:
        th = th;
        r0 = r1;
    L10:
        d.b.b.o.d.a(r0);
        throw th;
    L13:
        d.b.b.o.d.a(r1);
        return null;
    L12:
        r1 = null;
    L9:
        th = th;
        goto L10
    }

    private d.b.b.n.f.a d(String r9, byte[] r10, boolean r11) {
        HashMap r0 = new HashMap();
        HashMap r1 = new HashMap(d.b.b.i.c.a.w());
        r0.put("Accept-Encoding", "gzip");
        byte[] r4 = null;
        if (r10.length > 128) goto L5;
    L38:
        if (r4 == null) goto L41;
        r10 = r4;
    L41:
        r0.put(INetworkApi.CONTENT_TYPE, INetworkApi.DEFAULT_CONTENT_TYPE);
        if (c.e().i() == false) goto L55;
        byte[] r2 = f(r10);
        if (r2 == null) goto L55;
        r1.put("tt_data", "a");
        String r12 = k.a(r9, r1);
        r0.put(INetworkApi.CONTENT_TYPE, "application/octet-stream;tt-data=a");
        if (d.b.b.o.a.c() == false) goto L48;
        d.b.b.o.m.b.a(d.b.b.e.a.a.f12571a, "before encrypt url:" + r12);
    L48:
        LinkedList r13 = new LinkedList();
        String r8 = m(r12, r13);
        if (TextUtils.isEmpty(r8) == true) goto L52;
        r12 = r8;
    L52:
        if (d.b.b.o.a.c() == false) goto L54;
        d.b.b.o.m.b.a(d.b.b.e.a.a.f12571a, "after encrypt url:" + r12);
    L54:
        r0.putAll(d.b.b.o.f.c(r13));
        r10 = r2;
    L56:
        r0.put("Version-Code", LocationInfoConst.ALLOW_USE_LOCATION);
        return new d.b.b.n.f.a(r12, r0, r10);
    L55:
        r12 = k.a(r9, r1);
        goto L56
    L5:
        if (r11 == false) goto L7;
    L34:
        if (r4 != null) goto L38;
        r4 = c(r10);
        if (r4 == null) goto L38;
        r0.put("Content-Encoding", "gzip");
        goto L38
    L7:
        if (this.f12692g != null) goto L10;
        this.f12692g = (IZstdCompress) d.b.b.n.c.a(IZstdCompress.class);
    L10:
        if (f12685k != 1) goto L18;
        IZstdCompress r14 = this.f12692g;
        if (r14 == null) goto L18;
        byte[] r15 = r14.compress(r10, 15);
        if (r15 == null) goto L16;
        r0.put("Content-Encoding", "zstd");
        r0.put("Content-Encoding-Level", String.valueOf(15));
    L16:
        r4 = r15;
    L18:
        if (f12685k != 2) goto L34;
        if (this.f12692g == null) goto L34;
        if (this.f12693h != null) goto L24;
        this.f12693h = (IZstdDict) d.b.b.n.c.a(IZstdDict.class);
    L24:
        IZstdDict r16 = this.f12693h;
        if (r16 == null) goto L29;
        Pair<byte[], String> r17 = r16.getDictAndDictVersion();
        byte[] r5 = (byte[]) r17.first;
        String r18 = (String) r17.second;
        if (r5 == null) goto L30;
        r4 = this.f12692g.compress(r10, r5, 15);
    L30:
        if (r4 == null) goto L34;
        r0.put("Content-Encoding", "zstd/dict_monitor");
        r0.put("Content-Encoding-Level", String.valueOf(15));
        if (TextUtils.isEmpty(r18) == true) goto L34;
        r0.put("slardar-zstd-version", r18);
        r1.put("slardar-zstd-version", r18);
        goto L34
    L29:
        r18 = null;
        goto L30
    }

    private String e(byte[] r3, String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L12;
        return "";
    L12:
        SecretKeySpec r2 = new SecretKeySpec(r4.getBytes(), "AES");     // Catch: Throwable -> L7
        Cipher r5 = Cipher.getInstance("AES/ECB/NoPadding");     // Catch: Throwable -> L7
        r5.init(2, r2);     // Catch: Throwable -> L7
        return new String(r5.doFinal(Base64.decode(r3, 0))).replaceAll("\\$+$", "");
    L7:
        th = move-exception;
        if (d.b.b.o.a.c() == false) goto L11;
        d.b.b.o.m.b.c(d.b.b.e.a.a.f12571a, "decodeData", th);
    L11:
        return "";
    }

    private byte[] f(byte[] r1) {
        IEncrypt r0 = (IEncrypt) d.b.b.n.c.a(IEncrypt.class);
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.encrypt(r1);
    }

    private JSONObject g(HttpResponse r8) {
        JSONObject r3 = new JSONObject(new String(r8.getResponseBytes()));     // Catch: Exception -> L26
        Map<String, String> r9 = r8.getHeaders();     // Catch: Exception -> L26
        if (r9 != null) goto L6;
    L11:
        String r4 = null;
    L12:
        boolean r10 = true;
        String r5 = r3.optString("data");     // Catch: Throwable -> L24
        if (r5.isEmpty() == false) goto L16;
    L19:
        j(r3);     // Catch: Throwable -> L24
        if (r10 == true) goto L23;
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L24
        r7.put("message", "success");     // Catch: Throwable -> L24
        return r7;
    L23:
        return r3;
    L16:
        if (TextUtils.isEmpty(r4) == true) goto L18;
        String r6 = e(r5.getBytes(), r4);     // Catch: Throwable -> L24
        JSONObject r11 = new JSONObject(r6);     // Catch: Throwable -> L24
        r10 = true ^ TextUtils.isEmpty(r6);     // Catch: Throwable -> L24
        r3 = r11;
        goto L19
    L18:
        r3 = new JSONObject(new String(r5.getBytes()));     // Catch: Throwable -> L24
    L24:
        JSONObject r12 = new JSONObject();     // Catch: Exception -> L26
        r12.put("message", "success");     // Catch: Exception -> L26
        return r12;
    L6:
        if (r9.isEmpty() == true) goto L11;
        r4 = r9.get("ran");     // Catch: Exception -> L26
        if (TextUtils.isEmpty(r4) == false) goto L12;
        r4 = r9.get("Ran");     // Catch: Exception -> L26
    L26:
        return null;
    }

    public static e h(f r2) {
        if (f12684j.containsKey(r2) == true) goto L5;
        f12684j.put(r2, new e(r2));
    L5:
        return f12684j.get(r2);
    }

    private String i() {
        List<String> r0 = this.f12691f;
        if (TextUtils.isEmpty(this.f12686a) == true) goto L13;
        if (r0 != null) goto L7;
    L11:
        return null;
    L7:
        if (r0.size() <= 0) goto L11;
        return "https://" + this.f12686a + new URL(r0.get(0)).getPath();
    L13:
        if (TextUtils.isEmpty(this.f12689d) == true) goto L17;
        return this.f12689d;
    L17:
        if (this.f12687b == false) goto L19;
        this.f12688c++;
    L19:
        int r1 = r0.size();
        int r3 = this.f12688c;
        if (r1 <= r3) goto L23;
        if (r3 < 0) goto L23;
        String r4 = r0.get(r3);
    L25:
        return r4;
    L23:
        this.f12688c = 0;
        r4 = r0.get(0);
        goto L25
    }

    private void j(JSONObject r1) {
        if (d.b.b.o.e.d(r1) == false) goto L5;
        return;
    L5:
        JSONObject r0 = r1.optJSONObject("configs");
        if (d.b.b.o.e.d(r0) == false) goto L8;
        return;
    L8:
        d.b.b.e.a.g r2 = (d.b.b.e.a.g) d.b.b.n.c.a(d.b.b.e.a.g.class);
        if (r2 == null) goto L12;
        r2.onResponse(r0);
        return;
    }

    public static void l(int r4) {
        if (r4 != 2) goto L8;
        long r0 = a(d.b.b.o.a.b(), "dict_interval", 0).getLong("force_zstd_timestamp", 0);
        if ((System.currentTimeMillis() - r0) > 3600000) goto L8;
        f12685k = 1;
        return;
    L8:
        f12685k = r4;
    }

    private String m(String r1, List<Pair<String, String>> r2) {
        d.b.b.n.e.a r0 = (d.b.b.n.e.a) d.b.b.n.c.a(d.b.b.n.e.a.class);
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.a(r1, r2);
    }

    private void n(String r2) {
        if (this.f12693h != null) goto L6;
        this.f12693h = (IZstdDict) d.b.b.n.c.a(IZstdDict.class);
    L6:
        if (this.f12693h == null) goto L12;
        URL r0 = new URL(r2);     // Catch: MalformedURLException -> L9
        this.f12693h.setDomain(r0.getHost());     // Catch: MalformedURLException -> L9
        return;
    L13:
        return;
    }

    byte[] b(byte[] r4) {
        JSONObject r3 = new JSONObject(new String(r4));
        IConfigManager r5 = (IConfigManager) com.bytedance.news.common.service.manager.d.a(IConfigManager.class);
        if (r5 == null) goto L10;
        JSONObject r6 = r5.retrieveSettingsParams();
        JSONObject r0 = new JSONObject();
        String r1 = String.valueOf(d.b.b.i.c.a.h());
        if (TextUtils.isEmpty(r1) == true) goto L10;
        if (r1.equals(BDLocationException.ERROR_TIMEOUT) == true) goto L10;
        r0.put(r1, r6);
        r3.put("settings_params", r0);
    L10:
        return r3.toString().getBytes();
    }

    boolean k(byte[] r22) {
        Boolean r4 = Boolean.TRUE;
        if (r22 != null) goto L5;
    L113:
        return true;
    L5:
        if (r22.length == 0) goto L113;
        String r7 = i();     // Catch: Throwable -> L110
        n(r7);     // Catch: Throwable -> L110
        byte[] r0 = b(r22);     // Catch: JSONException -> L11 Throwable -> L110
    L14:
        d.b.b.n.f.a r2 = d(r7, r0, false);     // Catch: Throwable -> L110
        if (d.b.b.o.a.c() == false) goto L18;
        DoctorManager.getInstance().b("APM_SEND_DATA", "url:" + r2.f13039a + " header:" + r2.f13040b);     // Catch: Throwable -> L110
        d.b.b.o.m.b.a(d.b.b.e.a.a.f12571a, "sendLog createRequest: origin Bytes=" + r0.length + " compressed Bytes=" + r2.f13041c.length + " url=" + r2.f13039a + " headers=" + r2.f13040b);     // Catch: Throwable -> L110
    L18:
        HttpResponse r8 = d.b.b.i.c.a.g(r2.f13039a, r2.f13040b, r2.f13041c);     // Catch: Throwable -> L110
        if (d.b.b.o.a.c() == false) goto L25;
        String r10 = d.b.b.e.a.a.f12571a;     // Catch: Throwable -> L110
        StringBuilder r11 = new StringBuilder();     // Catch: Throwable -> L110
        r11.append("http result:");     // Catch: Throwable -> L110
        if (r8 != null) goto L23;
        Object r9 = -1;     // Catch: Throwable -> L110
    L24:
        r11.append(r9);     // Catch: Throwable -> L110
        d.b.b.o.m.b.a(r10, r11.toString());     // Catch: Throwable -> L110
        goto L25
    L23:
        r9 = r8.getStatusCode() + " header:" + r8.getHeaders();     // Catch: Throwable -> L110
    L25:
        this.f12686a = null;     // Catch: Throwable -> L110
        this.f12689d = null;     // Catch: Throwable -> L110
        if (r8 != null) goto L28;
    L102:
        this.f12687b = true;     // Catch: Throwable -> L110
        Boolean r1 = this.f12690e;     // Catch: Throwable -> L110
        if (r1 != null) goto L105;
    L107:
        this.f12690e = r4;     // Catch: Throwable -> L110
        return false;
    L105:
        if (r1.booleanValue() == false) goto L107;
        c.e().s();     // Catch: Throwable -> L110
        goto L107
    L28:
        if (r8.getStatusCode() <= 0) goto L102;
        this.f12687b = false;     // Catch: Throwable -> L110
        if (500 <= r8.getStatusCode()) goto L33;
    L41:
        JSONObject r12 = g(r8);     // Catch: Throwable -> L110
        if (r12 != null) goto L44;
    L100:
        this.f12690e = r4;     // Catch: Throwable -> L110
        return false;
    L44:
        if (r8.getStatusCode() != 200) goto L100;
        String r13 = r12.optString("message");     // Catch: Throwable -> L110
        String r14 = r12.optString("redirect");     // Catch: Throwable -> L110
        long r15 = r12.optLong("delay");     // Catch: Throwable -> L110
        if (r12.optLong("server_code", 0) == 10001) goto L49;
    L56:
        JSONObject r3 = r12.optJSONObject("settings_info");     // Catch: Throwable -> L110
        if (r3 == null) goto L64;
        IConfigManager r16 = (IConfigManager) com.bytedance.news.common.service.manager.d.a(IConfigManager.class);     // Catch: Throwable -> L110
        if (r16 == null) goto L64;
        JSONObject r5 = r3.optJSONObject(String.valueOf(d.b.b.i.c.a.h()));     // Catch: Throwable -> L110
        if (r5 == null) goto L64;
        r16.updateWithSpecificAidResult(r5);     // Catch: Throwable -> L110
    L64:
        if ("success".equals(r13) == false) goto L66;
        c.e().n();     // Catch: Throwable -> L110
        this.f12689d = r7;     // Catch: Throwable -> L110
        this.f12690e = Boolean.FALSE;     // Catch: Throwable -> L110
        boolean r6 = true;
        boolean r17 = false;
    L118:
    L85:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L110
    L87:
        JSONObject r18 = r12.optJSONObject("downgrade_rule");     // Catch: Throwable -> L110
        if (r18 == null) goto L90;
        d.b.b.e.a.k.h.a.a().c(d.b.b.e.a.k.h.c.a(r18), true);     // Catch: Throwable -> L110
    L90:
        this.f12686a = r14;     // Catch: Throwable -> L110
        if (r15 <= 0) goto L93;
        c.e().a(r15);     // Catch: Throwable -> L110
    L93:
        if (r17 == false) goto L98;
        c.e().b();     // Catch: Throwable -> L110
        if (r8.getHeaders() == null) goto L97;
        b.c().f(r8.getHeaders().get("x-tt-logid"));     // Catch: Throwable -> L110
    L97:
        b.c().g(System.currentTimeMillis());     // Catch: Throwable -> L110
    L99:
        return r6;
    L98:
        c.e().m();     // Catch: Throwable -> L110
        goto L99
    L71:
        if (d.b.b.o.a.c() == false) goto L87;
        JSONObject r19 = new JSONObject();     // Catch: Throwable -> L85
        r19.put("RESPONSE_DATA_URL", r2.f13039a);     // Catch: Throwable -> L85
        if (r8.getHeaders() == null) goto L83;
        JSONObject r20 = new JSONObject();     // Catch: Throwable -> L85
        Iterator<Map.Entry<String, String>> r110 = r8.getHeaders().entrySet().iterator();     // Catch: Throwable -> L85
    L76:
        if (r110.hasNext() == false) goto L82;
        Map.Entry<String, String> r111 = r110.next();     // Catch: Throwable -> L85
        if (r111.getKey() == null) goto L76;
        r20.put(r111.getKey(), r111.getValue());     // Catch: Throwable -> L114
        goto L76
    L82:
        r19.put("RESPONSE_DATA_HEADERS", r20);     // Catch: Throwable -> L85
    L83:
        r19.put("RESPONSE_DATA_BODY_TEXT", r12);     // Catch: Throwable -> L85
        com.bytedance.apm.doctor.a.g(r0, r19);     // Catch: Throwable -> L85
    L66:
        this.f12690e = r4;     // Catch: Throwable -> L110
        r17 = "drop data".equals(r13);     // Catch: Throwable -> L110
        if (d.b.b.o.a.c() == false) goto L69;
        d.b.b.o.m.b.a(d.b.b.e.a.a.f12571a, "responseMessage:" + r13);     // Catch: Throwable -> L110
    L69:
        r6 = false;
        goto L118
    L49:
        if (f12685k != 2) goto L56;
        if (this.f12692g == null) goto L56;
        if (this.f12694i != 0) goto L56;
        f12685k = 1;     // Catch: Throwable -> L110
        a(d.b.b.o.a.b(), "dict_interval", 0).edit().putLong("dict_interval", 0).putLong("force_zstd_timestamp", System.currentTimeMillis()).commit();     // Catch: Throwable -> L110
        this.f12694i++;     // Catch: Throwable -> L110
        boolean r21 = k(r0);     // Catch: Throwable -> L110
        this.f12694i--;     // Catch: Throwable -> L110
        return r21;
    L33:
        if (r8.getStatusCode() > 600) goto L41;
        Boolean r23 = this.f12690e;     // Catch: Throwable -> L110
        if (r23 != null) goto L37;
    L39:
        this.f12690e = r4;     // Catch: Throwable -> L110
        return false;
    L37:
        if (r23.booleanValue() == false) goto L39;
        c.e().l();     // Catch: Throwable -> L110
        goto L39
    L11:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "NetworkSender->sendLog(byte[] bytes)");     // Catch: Throwable -> L110
        d.b.b.o.m.b.b(d.b.b.e.a.a.f12571a, " appendSettingsParams wrong ");     // Catch: Throwable -> L110
        r0 = r22;
    L110:
        th = move-exception;
        d.b.b.o.m.b.c(d.b.b.e.a.a.f12571a, "sendLog failed.", th);
        return false;
    }
}
