package com.google.gson;

/* JADX INFO: loaded from: classes2.dex */
public interface u {

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f7099f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f7100g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f7101h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final a f7102i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ a[] f7103j = null;

        static {
            a r0 = new a("ALLOW", 0);
            f7099f = r0;
            a r1 = new a("INDECISIVE", 1);
            f7100g = r1;
            a r3 = new a("BLOCK_INACCESSIBLE", 2);
            f7101h = r3;
            a r5 = new a("BLOCK_ALL", 3);
            f7102i = r5;
            f7103j = new a[]{r0, r1, r3, r5};
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r1) {
            return (a) Enum.valueOf(a.class, r1);
        }

        public static a[] values() {
            return (a[]) f7103j.clone();
        }
    }

    a a(Class<?> r1);
}
