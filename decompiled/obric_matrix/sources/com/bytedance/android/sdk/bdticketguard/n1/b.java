package com.bytedance.android.sdk.bdticketguard.n1;

import com.bytedance.common.wschannel.WsConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.i0.m0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f868g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f869h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final b f870i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ b[] f871j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Map<String, b> f872k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f873l = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f874f;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public final b a(String r1) {
            o.g(r1, WsConstants.KEY_CONNECTION_TYPE);
            return (b) b.a().get(r1);
        }
    }

    static {
        int r3 = 0;
        b r1 = new b("InitTee", 0, "tee");
        f868g = r1;
        b r2 = new b("InitRee", 1, "ree");
        f869h = r2;
        b r4 = new b("InitEncryption", 2, "encryption");
        f870i = r4;
        f871j = new b[]{r1, r2, r4};
        f873l = new a(null);
        b[] r0 = values();
        LinkedHashMap r5 = new LinkedHashMap(kotlin.r0.e.c(m0.d(r0.length), 16));
        int r6 = r0.length;
    L3:
        if (r3 >= r6) goto L5;
        b r7 = r0[r3];
        r5.put(r7.f874f, r7);
        r3 = r3 + 1;
        goto L3
    L5:
        f872k = r5;
    }

    private b(String r1, int r2, String r3) {
        super(r1, r2);
        this.f874f = r3;
    }

    public static final /* synthetic */ Map a() {
        return f872k;
    }

    public static b valueOf(String r1) {
        return (b) Enum.valueOf(b.class, r1);
    }

    public static b[] values() {
        return (b[]) f871j.clone();
    }

    public final String b() {
        return this.f874f;
    }
}
