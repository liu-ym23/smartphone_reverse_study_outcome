package com.bytedance.frameworks.baselib.network.dispatcher;

/* JADX INFO: loaded from: classes3.dex */
public interface IRequest {

    public static final enum Priority extends Enum<Priority> {
        private static final /* synthetic */ Priority[] $VALUES = null;
        public static final Priority HIGH = null;
        public static final Priority IMMEDIATE = null;
        public static final Priority LOW = null;
        public static final Priority NORMAL = null;

        static {
            Priority r0 = new Priority("LOW", 0);
            LOW = r0;
            Priority r1 = new Priority("NORMAL", 1);
            NORMAL = r1;
            Priority r3 = new Priority("HIGH", 2);
            HIGH = r3;
            Priority r5 = new Priority("IMMEDIATE", 3);
            IMMEDIATE = r5;
            $VALUES = new Priority[]{r0, r1, r3, r5};
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
