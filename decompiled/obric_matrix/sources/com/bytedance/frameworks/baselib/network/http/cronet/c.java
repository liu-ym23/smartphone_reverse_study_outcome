package com.bytedance.frameworks.baselib.network.http.cronet;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public EnumC0148c f4692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4694c;

    public interface a {
        void bindBigCore(int r1);

        void bindLittleCore(int r1);

        void resetCoreBind(int r1);
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f4695f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final b f4696g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final b f4697h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final b f4698i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final b f4699j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final b f4700k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final b f4701l = null;
        private static final /* synthetic */ b[] m = null;

        static {
            b r0 = new b("CALLED_MULIT_TIMES", 0);
            f4695f = r0;
            b r1 = new b("PROCESS_NAME_NULL", 1);
            f4696g = r1;
            b r3 = new b("TNC_DISABLED", 2);
            f4697h = r3;
            b r5 = new b("CRASH_HAPPENED", 3);
            f4698i = r5;
            b r7 = new b("OPT_EFFECTIVE", 4);
            f4699j = r7;
            b r9 = new b("FALLBACK_FIX", 5);
            f4700k = r9;
            b r11 = new b("HAS_EXCEPTION", 6);
            f4701l = r11;
            m = new b[]{r0, r1, r3, r5, r7, r9, r11};
        }

        private b(String r1, int r2) {
            super(r1, r2);
        }

        public static b valueOf(String r1) {
            return (b) Enum.valueOf(b.class, r1);
        }

        public static b[] values() {
            return (b[]) m.clone();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.cronet.c$c, reason: collision with other inner class name */
    public static final enum EnumC0148c extends Enum<EnumC0148c> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final EnumC0148c f4702f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final EnumC0148c f4703g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final EnumC0148c f4704h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final EnumC0148c f4705i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final EnumC0148c f4706j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final /* synthetic */ EnumC0148c[] f4707k = null;

        static {
            EnumC0148c r0 = new EnumC0148c("INIT_THREAD", 0);
            f4702f = r0;
            EnumC0148c r1 = new EnumC0148c("NETWORK_THREAD", 1);
            f4703g = r1;
            EnumC0148c r3 = new EnumC0148c("FILE_THREAD", 2);
            f4704h = r3;
            EnumC0148c r5 = new EnumC0148c("THREAD_POOL_SERVICE_THREAD", 3);
            f4705i = r5;
            EnumC0148c r7 = new EnumC0148c("WORKER_THREAD", 4);
            f4706j = r7;
            f4707k = new EnumC0148c[]{r0, r1, r3, r5, r7};
        }

        private EnumC0148c(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumC0148c valueOf(String r1) {
            return (EnumC0148c) Enum.valueOf(EnumC0148c.class, r1);
        }

        public static EnumC0148c[] values() {
            return (EnumC0148c[]) f4707k.clone();
        }
    }

    public c() {
        this.f4693b = 20;
        this.f4694c = 0;
    }
}
