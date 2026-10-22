package xb;

import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f23009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f23010c;

    public c(JSONObject r13) {
        this.f23010c = Boolean.valueOf(r13.optBoolean("predefineEnable"));
        JSONObject r14 = r13.optJSONObject("meta");
        if (r14 == null) goto L5;
        String r5 = r14.optString("publicPath");
    L6:
        this.f23008a = r5;
        if (r14 == null) goto L9;
        JSONArray r15 = r14.optJSONArray("externals");
    L11:
        if (r15 == null) goto L55;
        HashMap r10 = new HashMap();
        int r11 = r15.length();     // Catch: Exception -> L18
        int r12 = 0;
    L14:
        if (r12 >= r11) goto L56;
        Object r16 = r15.get(r12);     // Catch: Exception -> L18
        if ((r16 instanceof JSONObject) == false) goto L20;
        JSONObject r17 = (JSONObject) r16;     // Catch: Exception -> L18
    L21:
        if (r17 == null) goto L23;
        r17.optString("name");     // Catch: Exception -> L18
    L23:
        if (r17 == null) goto L25;
        JSONObject r18 = r17.optJSONObject("requiredDependencies");     // Catch: Exception -> L18
    L27:
        if (r17 == null) goto L29;
        JSONObject r19 = r17.optJSONObject("filePath");     // Catch: Exception -> L18
    L30:
        bd.d r20 = new bd.d(r19);     // Catch: Exception -> L18
        if (r17 == null) goto L33;
        String r21 = r17.optString("matchRule");     // Catch: Exception -> L18
    L35:
        if (r17 == null) goto L37;
        JSONObject r22 = r17.optJSONObject("signature");     // Catch: Exception -> L18
    L38:
        a6.c r110 = new a6.c();     // Catch: Exception -> L18
        if (r22 == null) goto L41;
        String r111 = r22.optString("type");     // Catch: Exception -> L18
    L42:
        r110.f113a = r111;     // Catch: Exception -> L18
        if (r22 == null) goto L45;
        r22.optString("development");     // Catch: Exception -> L18
    L45:
        if (r22 == null) goto L47;
        r22.optString("production");     // Catch: Exception -> L18
    L47:
        if (r22 == null) goto L49;
        String r23 = r22.optString("module");     // Catch: Exception -> L18
    L50:
        r110.f114b = r23;     // Catch: Exception -> L18
        b r24 = new b(r18, r20, r110);     // Catch: Exception -> L18
        int r25 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;     // Catch: Exception -> L18
        com.bytedance.ies.bullet.base.utils.logger.a.c("predefine", "convert success:" + r24);     // Catch: Exception -> L18
        if (r21 == null) goto L53;
        r10.put(r21, r24);     // Catch: Exception -> L18
    L53:
        r12 = r12 + 1;
        goto L14
    L49:
        r23 = null;
        goto L50
    L41:
        r111 = null;
        goto L42
    L37:
        r22 = null;
        goto L38
    L33:
        r21 = null;
        goto L35
    L29:
        r19 = null;
        goto L30
    L25:
        r18 = null;
        goto L27
    L20:
        r17 = null;
    L56:
        this.f23009b = r10;
        com.bytedance.ies.bullet.base.utils.logger.a.g("XPredefine", "metaModel init", null, 12);
        return;
    L18:
        e = move-exception;
        int r26 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.d("XPredefine", "convert error:" + e.getMessage(), null, 12);
        goto L56
    L55:
        r10 = null;
        goto L56
    L9:
        r15 = null;
        goto L11
    L5:
        r5 = null;
        goto L6
    }
}
