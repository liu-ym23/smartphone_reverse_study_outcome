package tmsdkobf;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f273a;
    private static String b;
    private static String c;
    private static String d;

    public static String a() {
        return b;
    }

    public static String b() {
        return d;
    }

    public static String c() {
        return c;
    }

    public static String d() {
        return f273a;
    }

    protected static void a(JSONObject r2) {
        JSONObject r3 = r2.getJSONObject("wifiDetect");
        f273a = r3.optString("urlApprove", "");
        b = r3.optString("detectSSLStripTestUrl", "");
        c = r3.optString("safeRedirectDomain", "");
        d = r3.optString("miwifiDiagnosisUrl", "");
    }
}
