package com.bytedance.frameworks.baselib.network.dispatcher;

/* JADX INFO: loaded from: classes.dex */
public interface IRequest {

    public static final enum Priority extends Enum<Priority> {
        private static final /* synthetic */ Priority[] $VALUES = null;
        public static final Priority HIGH = null;
        public static final Priority IMMEDIATE = null;
        public static final Priority LOW = null;
        public static final Priority LOWEST = null;
        public static final Priority NORMAL = null;

        static {
            Priority r0 = new Priority("LOWEST", 0);
            LOWEST = r0;
            Priority r1 = new Priority("LOW", 1);
            LOW = r1;
            Priority r2 = new Priority("NORMAL", 2);
            NORMAL = r2;
            Priority r3 = new Priority("HIGH", 3);
            HIGH = r3;
            Priority r4 = new Priority("IMMEDIATE", 4);
            IMMEDIATE = r4;
            $VALUES = new Priority[]{r0, r1, r2, r3, r4};
        }

        private Priority(String r1, int r2) {
            super(r1, r2);
        }

        public static Priority valueOf(String r1) {
            return (Priority) Enum.valueOf(Priority.class, r1);
        }

        public static Priority[] values() {
            return (Priority[]) $VALUES.clone();
        }
    }

    Priority getPriority();

    int getSequence();
}
