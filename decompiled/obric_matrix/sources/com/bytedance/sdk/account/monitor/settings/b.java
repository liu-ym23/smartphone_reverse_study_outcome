package com.bytedance.sdk.account.monitor.settings;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f5698e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, com.bytedance.sdk.account.monitor.settings.a> f5699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f5700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f5701c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f5702d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g r1) {
            this();
        }

        public final b a(boolean r3, JSONObject r4, int r5, String r6) {
            o.g(r4, "element");
            o.g(r6, "configVersion");
            b r2 = new b(r3, r5, r6, null);
            if (r3 == false) goto L8;
            Iterator<String> r7 = r4.keys();
            o.b(r7, "element.keys()");
        L6:
            if (r7.hasNext() == false) goto L8;
            String r8 = r7.next();
            Map r9 = b.a(r2);
            o.b(r8, "key");
            r9.put(r8, com.bytedance.sdk.account.monitor.settings.a.f5689i.a(r4.getJSONObject(r8), r2));
        L8:
            return r2;
        }
    }

    static {
        f5698e = new a(null);
    }

    private b(boolean r1, int r2, String r3) {
        this.f5700b = r1;
        this.f5701c = r2;
        this.f5702d = r3;
        this.f5699a = new LinkedHashMap();
    }

    public /* synthetic */ b(boolean r1, int r2, String r3, g r4) {
        this(r1, r2, r3);
    }

    public static final /* synthetic */ Map a(b r0) {
        return r0.f5699a;
    }

    public final void b(String r2, com.bytedance.sdk.account.monitor.settings.a r3) {
        o.g(r2, "eventName");
        o.g(r3, "eventConfig");
        this.f5699a.put(r2, r3);
    }

    public final com.bytedance.sdk.account.monitor.settings.a c(String r2) {
        o.g(r2, "eventName");
        return this.f5699a.get(r2);
    }

    public final String d() {
        return this.f5702d;
    }

    public final boolean e() {
        return this.f5700b;
    }

    public final int f() {
        return this.f5701c;
    }
}
