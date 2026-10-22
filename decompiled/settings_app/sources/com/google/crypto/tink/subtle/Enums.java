package com.google.crypto.tink.subtle;

/* JADX INFO: loaded from: classes4.dex */
public final class Enums {

    public static final enum HashType extends Enum<HashType> {
        private static final /* synthetic */ HashType[] $VALUES = null;
        public static final HashType SHA1 = null;
        public static final HashType SHA224 = null;
        public static final HashType SHA256 = null;
        public static final HashType SHA384 = null;
        public static final HashType SHA512 = null;

        private HashType(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        public static HashType valueOf(String name) {
            return (HashType) Enum.valueOf(HashType.class, name);
        }

        public static HashType[] values() {
            return (HashType[]) $VALUES.clone();
        }

        static {
            HashType r0 = new HashType("SHA1", 0);
            SHA1 = r0;
            HashType r1 = new HashType("SHA224", 1);
            SHA224 = r1;
            HashType r3 = new HashType("SHA256", 2);
            SHA256 = r3;
            HashType r5 = new HashType("SHA384", 3);
            SHA384 = r5;
            HashType r7 = new HashType("SHA512", 4);
            SHA512 = r7;
            $VALUES = new HashType[]{r0, r1, r3, r5, r7};
        }
    }

    private Enums() {
    }
}
