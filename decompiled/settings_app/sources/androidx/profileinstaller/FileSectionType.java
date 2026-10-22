package androidx.profileinstaller;

/* JADX INFO: loaded from: classes.dex */
final enum FileSectionType extends Enum<FileSectionType> {
    private static final /* synthetic */ FileSectionType[] $VALUES = null;
    public static final FileSectionType AGGREGATION_COUNT = null;
    public static final FileSectionType CLASSES = null;
    public static final FileSectionType DEX_FILES = null;
    public static final FileSectionType EXTRA_DESCRIPTORS = null;
    public static final FileSectionType METHODS = null;
    private final long mValue;

    private static /* synthetic */ FileSectionType[] $values() {
        return new FileSectionType[]{DEX_FILES, EXTRA_DESCRIPTORS, CLASSES, METHODS, AGGREGATION_COUNT};
    }

    public static FileSectionType valueOf(String r1) {
        return (FileSectionType) Enum.valueOf(FileSectionType.class, r1);
    }

    public static FileSectionType[] values() {
        return (FileSectionType[]) $VALUES.clone();
    }

    static {
        DEX_FILES = new FileSectionType("DEX_FILES", 0, 0);
        EXTRA_DESCRIPTORS = new FileSectionType("EXTRA_DESCRIPTORS", 1, 1);
        CLASSES = new FileSectionType("CLASSES", 2, 2);
        METHODS = new FileSectionType("METHODS", 3, 3);
        AGGREGATION_COUNT = new FileSectionType("AGGREGATION_COUNT", 4, 4);
        $VALUES = $values();
    }

    private FileSectionType(String r1, int r2, long r3) {
        super(r1, r2);
        this.mValue = r3;
    }

    public long getValue() {
        return this.mValue;
    }

    static FileSectionType fromValue(long r4) {
        FileSectionType[] r0 = values();
        int r1 = 0;
    L4:
        if (r1 >= r0.length) goto L11;
        if (r0[r1].getValue() == r4) goto L8;
        r1 = r1 + 1;
        goto L4
    L8:
        return r0[r1];
    L11:
        throw new IllegalArgumentException("Unsupported FileSection Type " + r4);
    }
}
