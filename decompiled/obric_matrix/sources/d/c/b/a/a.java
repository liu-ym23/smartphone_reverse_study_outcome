package d.c.b.a;

/* JADX INFO: loaded from: classes.dex */
public interface a {

    /* JADX INFO: renamed from: d.c.b.a.a$a, reason: collision with other inner class name */
    public static final enum EnumC0411a extends Enum<EnumC0411a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final EnumC0411a f15256f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final EnumC0411a f15257g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final EnumC0411a f15258h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final EnumC0411a f15259i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final EnumC0411a f15260j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final EnumC0411a f15261k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final EnumC0411a f15262l = null;
        public static final EnumC0411a m = null;
        public static final EnumC0411a n = null;
        public static final EnumC0411a o = null;
        public static final EnumC0411a p = null;
        public static final EnumC0411a q = null;
        public static final EnumC0411a r = null;
        public static final EnumC0411a s = null;
        public static final EnumC0411a t = null;
        public static final EnumC0411a u = null;
        public static final EnumC0411a v = null;
        private static final /* synthetic */ EnumC0411a[] w = null;

        static {
            EnumC0411a r0 = new EnumC0411a("READ_DECODE", 0);
            f15256f = r0;
            EnumC0411a r1 = new EnumC0411a("READ_FILE", 1);
            f15257g = r1;
            EnumC0411a r3 = new EnumC0411a("READ_FILE_NOT_FOUND", 2);
            f15258h = r3;
            EnumC0411a r5 = new EnumC0411a("READ_INVALID_ENTRY", 3);
            f15259i = r5;
            EnumC0411a r7 = new EnumC0411a("WRITE_ENCODE", 4);
            f15260j = r7;
            EnumC0411a r9 = new EnumC0411a("WRITE_CREATE_TEMPFILE", 5);
            f15261k = r9;
            EnumC0411a r11 = new EnumC0411a("WRITE_UPDATE_FILE_NOT_FOUND", 6);
            f15262l = r11;
            EnumC0411a r13 = new EnumC0411a("WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND", 7);
            m = r13;
            EnumC0411a r15 = new EnumC0411a("WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND", 8);
            n = r15;
            EnumC0411a r14 = new EnumC0411a("WRITE_RENAME_FILE_OTHER", 9);
            o = r14;
            EnumC0411a r12 = new EnumC0411a("WRITE_CREATE_DIR", 10);
            p = r12;
            EnumC0411a r10 = new EnumC0411a("WRITE_CALLBACK_ERROR", 11);
            q = r10;
            EnumC0411a r8 = new EnumC0411a("WRITE_INVALID_ENTRY", 12);
            r = r8;
            EnumC0411a r6 = new EnumC0411a("DELETE_FILE", 13);
            s = r6;
            EnumC0411a r4 = new EnumC0411a("EVICTION", 14);
            t = r4;
            EnumC0411a r2 = new EnumC0411a("GENERIC_IO", 15);
            u = r2;
            EnumC0411a r16 = new EnumC0411a("OTHER", 16);
            v = r16;
            w = new EnumC0411a[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16};
        }

        private EnumC0411a(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumC0411a valueOf(String r1) {
            return (EnumC0411a) Enum.valueOf(EnumC0411a.class, r1);
        }

        public static EnumC0411a[] values() {
            return (EnumC0411a[]) w.clone();
        }
    }

    void a(EnumC0411a r1, Class<?> r2, String r3, Throwable r4);
}
