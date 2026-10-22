package com.bytedance.sdk.account.monitor.settings;

import com.bytedance.sdk.account.monitor.f.e;
import com.bytedance.sdk.account.monitor.f.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.i0.j0;
import kotlin.i0.r;
import kotlin.n0.d.o;
import kotlin.r0.d;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final C0180a f5689i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f5690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f5691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f5692c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f5693d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final g f5694e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f5695f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Set<String> f5696g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f5697h;

    /* JADX INFO: renamed from: com.bytedance.sdk.account.monitor.settings.a$a, reason: collision with other inner class name */
    public static final class C0180a {
        private C0180a() {
        }

        public /* synthetic */ C0180a(kotlin.n0.d.g r1) {
            this();
        }

        public final a a(Object r13, b r14) {
            o.g(r14, "parent");
            if ((r13 instanceof JSONObject) == false) goto L34;
            JSONObject r15 = (JSONObject) r13;
            int r3 = r15.optInt("sample_rate", 1);
            String r4 = null;
            int r5 = r15.optInt("sample_mode", 0);
            if (r15.has("sample_if") == false) goto L7;
            g r12 = e.f5678a.a(r15.get("sample_if"));
        L8:
            String r2 = r15.optString("sample_group", "");
            o.b(r2, "it");
            if (r2.length() <= 0) goto L11;
            boolean r7 = true;
        L12:
            if (r7 == false) goto L14;
            String r8 = r2;
        L15:
            JSONArray r6 = r15.optJSONArray("log_params");
            if (r6 == null) goto L30;
            d r9 = kotlin.r0.e.m(0, r6.length());
            ArrayList r10 = new ArrayList();
            Iterator<Integer> r11 = r9.iterator();
        L19:
            if (r11.hasNext() == false) goto L29;
            String r16 = r6.optString(((j0) r11).nextInt());
            o.b(r16, "it1");
            if (r16.length() <= 0) goto L23;
            boolean r17 = true;
        L24:
            if (r17 == true) goto L27;
            r16 = null;
        L27:
            if (r16 == null) goto L19;
            r10.add(r16);
            goto L19
        L23:
            r17 = false;
            goto L24
        L29:
            Set r18 = r.D0(r10);
        L32:
            return new a(r14, r3, r4, r5, r12, r8, r18, r15.optBoolean("log_all_params", false), 4, null);
        L30:
            r18 = null;
            goto L32
        L14:
            r8 = null;
            goto L15
        L11:
            r7 = false;
            goto L12
        L7:
            r12 = null;
            goto L8
        L34:
            throw new IllegalArgumentException("Invalid JSON object");
        }
    }

    static {
        f5689i = new C0180a(null);
    }

    public a(b r2, int r3, String r4, int r5, g r6, String r7, Set<String> r8, boolean r9) {
        o.g(r2, "parent");
        o.g(r4, "configVersion");
        this.f5690a = r2;
        this.f5691b = r3;
        this.f5692c = r4;
        this.f5693d = r5;
        this.f5694e = r6;
        this.f5695f = r7;
        this.f5696g = r8;
        this.f5697h = r9;
    }

    public /* synthetic */ a(b r10, int r11, String r12, int r13, g r14, String r15, Set r16, boolean r17, int r18, kotlin.n0.d.g r19) {
        if ((r18 & 2) == 0) goto L5;
        int r1 = 1;
    L7:
        if ((r18 & 4) == 0) goto L9;
        String r2 = "";
    L10:
        boolean r4 = false;
        if ((r18 & 8) == 0) goto L13;
        int r3 = 0;
    L14:
        Set r6 = null;
        if ((r18 & 16) == 0) goto L17;
        g r5 = null;
    L19:
        if ((r18 & 32) == 0) goto L21;
        String r7 = null;
    L23:
        if ((r18 & 64) != 0) goto L27;
        r6 = r16;
    L27:
        if ((r18 & 128) != 0) goto L30;
        r4 = r17;
    L30:
        this(r10, r1, r2, r3, r5, r7, r6, r4);
        return;
    L21:
        r7 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r3 = r13;
        goto L14
    L9:
        r2 = r12;
        goto L10
    L5:
        r1 = r11;
        goto L7
    }

    public final boolean a() {
        return this.f5697h;
    }

    public final Set<String> b() {
        return this.f5696g;
    }

    public final b c() {
        return this.f5690a;
    }

    public final String d() {
        return this.f5695f;
    }

    public final g e() {
        return this.f5694e;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L5;
    L33:
        return true;
    L5:
        if ((r5 instanceof a) == false) goto L32;
        a r6 = (a) r5;
        if (o.a(this.f5690a, r6.f5690a) == false) goto L32;
        if (this.f5691b != r6.f5691b) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == false) goto L32;
        if (o.a(this.f5692c, r6.f5692c) == false) goto L32;
        if (this.f5693d != r6.f5693d) goto L18;
        boolean r2 = true;
    L19:
        if (r2 == false) goto L32;
        if (o.a(this.f5694e, r6.f5694e) == false) goto L32;
        if (o.a(this.f5695f, r6.f5695f) == false) goto L32;
        if (o.a(this.f5696g, r6.f5696g) == false) goto L32;
        if (this.f5697h != r6.f5697h) goto L29;
        boolean r4 = true;
    L30:
        if (r4 == false) goto L32;
    L29:
        r4 = false;
        goto L30
    L18:
        r2 = false;
        goto L19
    L11:
        r1 = false;
    L32:
        return false;
    }

    public final int f() {
        return this.f5693d;
    }

    public final int g() {
        return this.f5691b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    public int hashCode() {
        b r0 = this.f5690a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((r2 * 31) + this.f5691b) * 31;
        String r4 = this.f5692c;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (((r3 + r5) * 31) + this.f5693d) * 31;
        g r7 = this.f5694e;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.f5695f;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Set<String> r13 = this.f5696g;
        if (r13 == null) goto L21;
        r1 = r13.hashCode();
    L21:
        int r14 = (r12 + r1) * 31;
        boolean r15 = this.f5697h;
        ?? r16 = r15;
        if (r15 == false) goto L25;
        r16 = 1;
    L25:
        return r14 + r16;
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "EventConfig(parent=" + this.f5690a + ", sampleRate=" + this.f5691b + ", configVersion=" + this.f5692c + ", sampleMode=" + this.f5693d + ", sampleIf=" + this.f5694e + ", sampleGroup=" + this.f5695f + ", logParams=" + this.f5696g + ", logAllParams=" + this.f5697h + ")";
    }
}
