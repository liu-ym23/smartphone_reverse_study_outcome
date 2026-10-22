package u9;

import android.text.TextUtils;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f22268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f22269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f22270c;
    public long d;
    public int e;
    public int f;
    public IOException g;

    public final JSONObject a() {
        JSONObject r5 = new JSONObject();
        r5.put("host", this.f22269b);     // Catch: JSONException -> L12
        r5.put("start", this.f22270c);     // Catch: JSONException -> L12
        r5.put("end", this.d);     // Catch: JSONException -> L12
        r5.put("net_error", this.e);     // Catch: JSONException -> L12
        r5.put("code", this.f);     // Catch: JSONException -> L12
        IOException r10 = this.g;     // Catch: JSONException -> L12
        if (r10 == null) goto L11;
        String r11 = r10.getMessage();     // Catch: JSONException -> L12
        if (TextUtils.isEmpty(r11) == false) goto L8;
    L10:
        r5.put("exception", r11);     // Catch: JSONException -> L12
        goto L11
    L8:
        if (r11.length() <= 64) goto L10;
        r11 = r11.substring(0, 64);     // Catch: JSONException -> L12
    L11:
        return r5;
    }
}
