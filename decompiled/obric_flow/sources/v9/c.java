package v9;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import java.net.CookieManager;
import java.net.URI;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import s9.h;
import sj.d;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends CookieManager {
    @Override // java.net.CookieManager, java.net.CookieHandler
    public final Map get(URI r5, Map r10) {
        String r11 = r5.toString();     // Catch: Throwable -> L27
        if (r10 != null) goto L6;
    L31:
        d r12 = h.f21879a;     // Catch: Throwable -> L27
    L35:
        return Collections.emptyMap();
    L6:
        if (r10 != null) goto L8;
    L15:
        List r13 = null;
    L16:
        if (r13 == null) goto L31;
        Iterator r14 = r13.iterator();     // Catch: Throwable -> L27
    L19:
        if (r14.hasNext() == false) goto L31;
        String r15 = (String) r14.next();     // Catch: Throwable -> L27
        if (r15 == null) goto L19;
        if (Boolean.parseBoolean(r15) == false) goto L19;
        if (Logger.debug() == false) goto L30;
        Logger.v("SSCookieHandler", "X-SS-No-Cookie " + r11);     // Catch: Throwable -> L27
    L30:
        return Collections.emptyMap();
    L8:
        if (TextUtils.isEmpty("X-SS-No-Cookie") == true) goto L15;
        r13 = (List) r10.get("X-SS-No-Cookie");     // Catch: Throwable -> L27
        if (r13 != null) goto L13;
    L14:
        r13 = (List) r10.get("X-SS-No-Cookie".toLowerCase());     // Catch: Throwable -> L27
        goto L16
    L13:
        if (r13.isEmpty() == false) goto L16;
    L27:
        th = move-exception;
        th.printStackTrace();
        goto L35
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object, s9.f] */
    @Override // java.net.CookieManager, java.net.CookieHandler
    public final void put(URI r5, Map r10) {
        ?? r11 = h.g;
        if (r11 == 0) goto L5;
        List r12 = r11.a(r5.getHost());
    L6:
        JSONObject r13 = new JSONObject();
        if (r10 != null) goto L9;
    L11:
        boolean r14 = false;
    L13:
        String r15 = "";
        if (r12 != null) goto L31;
        String r16 = "";
    L17:
        r13.put("shareHostList", r16);     // Catch: JSONException -> L30
        if (r14 == false) goto L21;
        r13.put("responseHeaders", r10.toString());     // Catch: JSONException -> L30
    L21:
        if (r5 == null) goto L24;
        r15 = r5.toString();     // Catch: JSONException -> L30
    L24:
        r13.put("url", r15);     // Catch: JSONException -> L30
    L33:
        d r17 = h.f21879a;     // Catch: Throwable -> L27
        return;
    L27:
        th = move-exception;
        th.printStackTrace();
        return;
    L31:
        r16 = r12.toString();     // Catch: JSONException -> L30
        goto L17
    L9:
        if (r10.containsKey("Set-Cookie") == false) goto L11;
        r14 = true;
        goto L13
    L5:
        r12 = null;
        goto L6
    }
}
