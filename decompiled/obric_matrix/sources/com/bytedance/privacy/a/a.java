package com.bytedance.privacy.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean[] f5345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final String f5346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f5347c;

    /* JADX INFO: renamed from: com.bytedance.privacy.a.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0171a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean[] f5348a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f5349b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f5350c;

        public b() {
            this.f5348a = new boolean[c.values().length];
            this.f5350c = false;
        }

        static /* synthetic */ boolean[] a(b r0) {
            return r0.f5348a;
        }

        static /* synthetic */ String b(b r0) {
            return r0.f5349b;
        }

        static /* synthetic */ boolean c(b r0) {
            return r0.f5350c;
        }

        public a d() {
            return new a(this, null);
        }

        public b e(String r3) {
            if (r3 == null) goto L12;
            if (r3.isEmpty() == true) goto L12;
            if (r3.getBytes(StandardCharsets.UTF_8).length > 1024) goto L10;
            this.f5349b = r3;
            return this;
        L10:
            throw new com.bytedance.privacy.c.a("customInfo too long (max 1024 bytes)");
        L12:
            throw new com.bytedance.privacy.c.a("customInfo must not be null or empty");
        }

        public b f() {
            this.f5350c = true;
            return this;
        }
    }

    public static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f5351f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final c f5352g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final c f5353h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ c[] f5354i = null;

        static {
            f5351f = new c("UDID", 0);
            f5352g = new c("RPDID", 1);
            f5353h = new c("RPUID", 2);
            f5354i = a();
        }

        private c(String r1, int r2) {
            super(r1, r2);
        }

        private static /* synthetic */ c[] a() {
            return new c[]{f5351f, f5352g, f5353h};
        }

        public static c valueOf(String r1) {
            return (c) Enum.valueOf(c.class, r1);
        }

        public static c[] values() {
            return (c[]) f5354i.clone();
        }
    }

    private a(b r2) {
        this.f5345a = (boolean[]) b.a(r2).clone();
        this.f5346b = b.b(r2);
        this.f5347c = b.c(r2);
    }

    /* synthetic */ a(b r1, C0171a r2) {
        this(r1);
    }

    @Nullable
    public String a() {
        return this.f5346b;
    }

    public boolean b() {
        return this.f5347c;
    }

    public boolean c(c r1) {
        return this.f5345a[r1.ordinal()];
    }

    @NonNull
    public String toString() {
        StringBuilder r0 = new StringBuilder("AttestationConfig{");
        r0.append("requestedIds=[");
        c[] r1 = c.values();
        int r2 = r1.length;
        boolean r4 = true;
        int r5 = 0;
    L3:
        if (r5 >= r2) goto L10;
        c r6 = r1[r5];
        if (this.f5345a[r6.ordinal()] == false) goto L9;
        if (r4 == true) goto L8;
        r0.append(", ");
    L8:
        r0.append(r6.name());
        r4 = false;
    L9:
        r5 = r5 + 1;
        goto L3
    L10:
        r0.append("]");
        if (this.f5346b == null) goto L13;
        r0.append(", customInfo='");
        r0.append(this.f5346b);
        r0.append('\'');
    L13:
        r0.append(", devHealthStatusRequired=");
        r0.append(this.f5347c);
        r0.append('}');
        return r0.toString();
    }
}
