package v6;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f22514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f22515c;

    public a(String r5) {
        this.f22515c = 0;
        this.f22513a = r5;
        this.f22514b = new HashMap();
    }

    public final void a(long r5, String r10) {
        HashMap r11 = this.f22514b;
        if (r11.containsKey(r10) == false) goto L5;
        r11.put(r10, Long.valueOf(((Long) r11.get(r10)).longValue() + r5));
    L6:
        this.f22515c += r5;
        return;
    L5:
        r11.put(r10, Long.valueOf(r5));
        goto L6
    }

    public final JSONObject b() {
        JSONObject r5 = new JSONObject();
        r5.put("biz", this.f22513a);     // Catch: JSONException -> L14
        r5.put("usage", this.f22515c);     // Catch: JSONException -> L14
        JSONArray r10 = new JSONArray();     // Catch: JSONException -> L14
        HashMap r11 = this.f22514b;
        if (r11 != null) goto L7;
    L12:
        r5.put("detail", r10);     // Catch: JSONException -> L14
        goto L13
    L7:
        if (r11.size() <= 0) goto L12;
        Iterator r12 = r11.entrySet().iterator();     // Catch: JSONException -> L14
    L10:
        if (r12.hasNext() == false) goto L12;
        Map.Entry r13 = (Map.Entry) r12.next();     // Catch: JSONException -> L14
        JSONObject r14 = new JSONObject();     // Catch: JSONException -> L14
        r14.put("source_id", r13.getKey());     // Catch: JSONException -> L14
        r14.put("usage", r13.getValue());     // Catch: JSONException -> L14
        r10.put(r14);     // Catch: JSONException -> L14
    L13:
        return r5;
    }

    public final JSONObject c(long r10) {
        JSONObject r5 = new JSONObject();
        r5.put("biz", this.f22513a);     // Catch: JSONException -> L16
        r5.put("usage", this.f22515c);     // Catch: JSONException -> L16
        JSONArray r11 = new JSONArray();     // Catch: JSONException -> L16
        HashMap r12 = this.f22514b;
        if (r12 != null) goto L7;
    L14:
        r5.put("detail", r11);     // Catch: JSONException -> L16
        goto L15
    L7:
        if (r12.size() <= 0) goto L14;
        Iterator r13 = r12.entrySet().iterator();     // Catch: JSONException -> L16
    L10:
        if (r13.hasNext() == false) goto L14;
        Map.Entry r14 = (Map.Entry) r13.next();     // Catch: JSONException -> L16
        if (((Long) r14.getValue()).longValue() < r10) goto L10;
        JSONObject r15 = new JSONObject();     // Catch: JSONException -> L16
        r15.put("source_id", r14.getKey());     // Catch: JSONException -> L16
        r15.put("usage", r14.getValue());     // Catch: JSONException -> L16
        r11.put(r15);     // Catch: JSONException -> L16
    L15:
        return r5;
    }
}
