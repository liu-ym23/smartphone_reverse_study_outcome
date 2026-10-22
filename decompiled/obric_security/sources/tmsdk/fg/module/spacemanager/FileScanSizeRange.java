package tmsdk.fg.module.spacemanager;

/* JADX INFO: loaded from: classes5.dex */
public class FileScanSizeRange {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f75a;
    private final long b;
    private final FileScanSizeRangeUnit c;

    public static final enum FileScanSizeRangeUnit extends Enum<FileScanSizeRangeUnit> {
        public static final FileScanSizeRangeUnit GB = null;
        public static final FileScanSizeRangeUnit KB = null;
        public static final FileScanSizeRangeUnit MB = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ FileScanSizeRangeUnit[] f76a = null;

        static {
            KB = new FileScanSizeRangeUnit("KB", 0);
            MB = new FileScanSizeRangeUnit("MB", 1);
            GB = new FileScanSizeRangeUnit("GB", 2);
            f76a = a();
        }

        private FileScanSizeRangeUnit(String r1, int r2) {
            super(r1, r2);
        }

        private static /* synthetic */ FileScanSizeRangeUnit[] a() {
            return new FileScanSizeRangeUnit[]{KB, MB, GB};
        }

        public static FileScanSizeRangeUnit valueOf(String r1) {
            return (FileScanSizeRangeUnit) Enum.valueOf(FileScanSizeRangeUnit.class, r1);
        }

        public static FileScanSizeRangeUnit[] values() {
            return (FileScanSizeRangeUnit[]) f76a.clone();
        }
    }

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f77a = null;

        static {
            int[] r0 = new int[FileScanSizeRangeUnit.values().length];
            f77a = r0;
            r0[FileScanSizeRangeUnit.MB.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f77a[FileScanSizeRangeUnit.GB.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public FileScanSizeRange() {
        this(-1, Long.MAX_VALUE, FileScanSizeRangeUnit.KB);
    }

    private long a(long r3, FileScanSizeRangeUnit r5) {
        if (r3 >= 0) goto L16;
        return 0;
    L16:
        int r2 = a.f77a[r5.ordinal()];     // Catch: ArithmeticException -> L14
        if (r2 != 1) goto L8;
        long r4 = Math.multiplyExact(r3, 1024);     // Catch: ArithmeticException -> L14
    L13:
        return r4;
    L8:
        if (r2 != 2) goto L17;
        r4 = Math.multiplyExact(Math.multiplyExact(r3, 1024), 1024);     // Catch: ArithmeticException -> L14
        goto L13
    L17:
        return r3;
    L14:
        return Long.MAX_VALUE;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        long r1 = this.b;
        if (r1 != (-1)) goto L5;
        long r2 = 10240;
    L6:
        long r3 = this.f75a;
        if (r3 != Long.MAX_VALUE) goto L9;
        long r4 = Long.MAX_VALUE;
    L11:
        if (r2 <= r4) goto L13;
        r4 = Long.MAX_VALUE;
    L13:
        r0.append(r2).append(",");
        if (r4 != Long.MAX_VALUE) goto L16;
        Object r8 = "-";
    L17:
        r0.append(r8);
        return r0.toString();
    L16:
        r8 = Long.valueOf(r4);
        goto L17
    L9:
        r4 = a(r3, this.c);
        goto L11
    L5:
        r2 = a(r1, this.c);
        goto L6
    }

    public FileScanSizeRange(long r1, long r3, FileScanSizeRangeUnit r5) {
        if (r5 != null) goto L5;
        r5 = FileScanSizeRangeUnit.KB;
    L5:
        this.b = r1;
        this.f75a = r3;
        this.c = r5;
    }

    public FileScanSizeRange(long r7, FileScanSizeRangeUnit r9) {
        this(r7, Long.MAX_VALUE, r9);
    }
}
