package com.google.gson;

/* JADX INFO: loaded from: classes4.dex */
public interface ReflectionAccessFilter {
    public static final ReflectionAccessFilter BLOCK_ALL_ANDROID = null;
    public static final ReflectionAccessFilter BLOCK_ALL_JAVA = null;
    public static final ReflectionAccessFilter BLOCK_ALL_PLATFORM = null;
    public static final ReflectionAccessFilter BLOCK_INACCESSIBLE_JAVA = null;

    public static final enum FilterResult extends Enum<FilterResult> {
        private static final /* synthetic */ FilterResult[] $VALUES = null;
        public static final FilterResult ALLOW = null;
        public static final FilterResult BLOCK_ALL = null;
        public static final FilterResult BLOCK_INACCESSIBLE = null;
        public static final FilterResult INDECISIVE = null;

        private FilterResult(String r1, int r2) {
            super(r1, r2);
        }

        public static FilterResult valueOf(String r1) {
            return (FilterResult) Enum.valueOf(FilterResult.class, r1);
        }

        public static FilterResult[] values() {
            return (FilterResult[]) $VALUES.clone();
        }

        static {
            FilterResult r0 = new FilterResult("ALLOW", 0);
            ALLOW = r0;
            FilterResult r1 = new FilterResult("INDECISIVE", 1);
            INDECISIVE = r1;
            FilterResult r3 = new FilterResult("BLOCK_INACCESSIBLE", 2);
            BLOCK_INACCESSIBLE = r3;
            FilterResult r5 = new FilterResult("BLOCK_ALL", 3);
            BLOCK_ALL = r5;
            $VALUES = new FilterResult[]{r0, r1, r3, r5};
        }
    }

    FilterResult check(Class<?> r1);

    static {
        BLOCK_INACCESSIBLE_JAVA = new AnonymousClass1();
        BLOCK_ALL_JAVA = new AnonymousClass2();
        BLOCK_ALL_ANDROID = new AnonymousClass3();
        BLOCK_ALL_PLATFORM = new AnonymousClass4();
    }
}
