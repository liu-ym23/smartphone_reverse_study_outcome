package vf;

import android.text.TextUtils;
import com.google.common.base.u;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f22574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f22575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f22576c;
    public String d;
    public boolean e;
    public final HashSet f;

    public b() {
        this.f22574a = true;
        this.f22575b = false;
        this.f22576c = 450;
        this.d = null;
        this.e = false;
        this.f = new HashSet();
    }

    public static void b(JsonObject r5, b r10) {
        int r11 = 0;
        if (a.d.f22574a == false) goto L17;
        if (r5 == null) goto L17;
        if (r5.has("scc_cs_enable") == false) goto L14;
        JsonElement r12 = r5.get("scc_cs_enable");
        if (r12.isJsonPrimitive() == false) goto L14;
        if (r12.getAsJsonPrimitive().isBoolean() == false) goto L14;
        boolean r13 = r12.getAsBoolean();
    L15:
        if (r13 == false) goto L17;
        boolean r14 = true;
    L18:
        r10.f22574a = r14;
        if (r14 == false) goto L100;
        boolean r15 = r10.e;
        if (r5 != null) goto L24;
    L32:
        r10.e = r15;
        boolean r16 = r10.f22575b;
        if (r5 != null) goto L35;
    L43:
        r10.f22575b = r16;
        int r17 = r10.f22576c;
        if (r5 != null) goto L46;
    L54:
        if (r17 > 0) goto L56;
        r17 = 450;
    L56:
        r10.f22576c = r17;
        String r18 = r10.d;
        if (r5 != null) goto L59;
    L67:
        r10.d = r18;
        if (r5 != null) goto L70;
    L78:
        JsonArray r19 = null;
    L79:
        if (r19 != null) goto L81;
        return;
    L81:
        if (r19.size() <= 0) goto L99;
        HashSet r20 = new HashSet();
    L84:
        if (r11 >= r19.size()) goto L92;
        JsonElement r21 = r19.get(r11);
        if (r21.isJsonPrimitive() == false) goto L91;
        if (r21.getAsJsonPrimitive().isString() == false) goto L91;
        r20.add(r21.getAsString());
    L91:
        r11 = r11 + 1;
        goto L84
    L92:
        r10.f.addAll(r20);
        return;
    L99:
        return;
    L70:
        if (r5.has("scc_cs_allow_list") == false) goto L78;
        JsonElement r22 = r5.get("scc_cs_allow_list");
        if (r22.isJsonArray() == false) goto L78;
        if (r22.getAsJsonArray().isJsonArray() == false) goto L78;
        r19 = r22.getAsJsonArray();
        goto L79
    L59:
        if (r5.has("scc_seclink_scene") == false) goto L67;
        JsonElement r23 = r5.get("scc_seclink_scene");
        if (r23.isJsonPrimitive() == false) goto L67;
        if (r23.getAsJsonPrimitive().isString() == false) goto L67;
        r18 = r23.getAsString();
        goto L67
    L46:
        if (r5.has("scc_cs_max_wait_time") == false) goto L54;
        JsonElement r24 = r5.get("scc_cs_max_wait_time");
        if (r24.isJsonPrimitive() == false) goto L54;
        if (r24.getAsJsonPrimitive().isNumber() == false) goto L54;
        r17 = r24.getAsInt();
        goto L54
    L35:
        if (r5.has("scc_cs_enable_prefetch") == false) goto L43;
        JsonElement r25 = r5.get("scc_cs_enable_prefetch");
        if (r25.isJsonPrimitive() == false) goto L43;
        if (r25.getAsJsonPrimitive().isBoolean() == false) goto L43;
        r16 = r25.getAsBoolean();
        goto L43
    L24:
        if (r5.has("scc_cs_is_debug") == false) goto L32;
        JsonElement r26 = r5.get("scc_cs_is_debug");
        if (r26.isJsonPrimitive() == false) goto L32;
        if (r26.getAsJsonPrimitive().isBoolean() == false) goto L32;
        r15 = r26.getAsBoolean();
        goto L32
    L100:
        return;
    L14:
        r13 = false;
    L17:
        r14 = false;
        goto L18
    }

    public final u a(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return null;
    L5:
        Iterator r10 = this.f.iterator();
    L7:
        if (r10.hasNext() == false) goto L14;
        String r11 = (String) r10.next();
        if (r5.equals(r11) == true) goto L13;
        if (r5.endsWith("." + r11) == false) goto L7;
    L13:
        return new u(r11, 2);
    L14:
        return null;
    }

    public final String toString() {
        return "SccSettings{mEnableScc=" + this.f22574a + ", mEnablePrefetch=" + this.f22575b + ", mCsMaxWaitMs=" + this.f22576c + ", mSeclinkScene='" + this.d + "', mIsDebug=" + this.e + ", mDomainAllowSet=" + this.f + '}';
    }

    public b(b r5) {
        this.f22574a = r5.f22574a;
        this.f22575b = r5.f22575b;
        this.f22576c = r5.f22576c;
        this.d = r5.d;
        this.e = r5.e;
        this.f = new HashSet(r5.f);
    }
}
