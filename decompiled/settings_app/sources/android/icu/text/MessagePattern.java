package android.icu.text;

import android.icu.util.Freezable;

/* JADX INFO: loaded from: classes.dex */
public final class MessagePattern implements Cloneable, Freezable<MessagePattern> {
    public static final int ARG_NAME_NOT_NUMBER = -1;
    public static final int ARG_NAME_NOT_VALID = -2;
    public static final double NO_NUMERIC_VALUE = -1.23456789E8d;

    public static final enum ApostropheMode extends Enum<ApostropheMode> {
        private static final /* synthetic */ ApostropheMode[] $VALUES = null;
        public static final ApostropheMode DOUBLE_OPTIONAL = null;
        public static final ApostropheMode DOUBLE_REQUIRED = null;

        public static ApostropheMode valueOf(String r1) {
            return (ApostropheMode) Enum.valueOf(ApostropheMode.class, r1);
        }

        public static ApostropheMode[] values() {
            return (ApostropheMode[]) $VALUES.clone();
        }

        private ApostropheMode(String r1, int r2) {
            super(r1, r2);
        }

        static {
            ApostropheMode r0 = new ApostropheMode("DOUBLE_OPTIONAL", 0);
            DOUBLE_OPTIONAL = r0;
            ApostropheMode r1 = new ApostropheMode("DOUBLE_REQUIRED", 1);
            DOUBLE_REQUIRED = r1;
            $VALUES = new ApostropheMode[]{r0, r1};
        }
    }

    public static final enum ArgType extends Enum<ArgType> {
        private static final /* synthetic */ ArgType[] $VALUES = null;
        public static final ArgType CHOICE = null;
        public static final ArgType NONE = null;
        public static final ArgType PLURAL = null;
        public static final ArgType SELECT = null;
        public static final ArgType SELECTORDINAL = null;
        public static final ArgType SIMPLE = null;

        public static ArgType valueOf(String r1) {
            return (ArgType) Enum.valueOf(ArgType.class, r1);
        }

        public static ArgType[] values() {
            return (ArgType[]) $VALUES.clone();
        }

        private ArgType(String r1, int r2) {
            super(r1, r2);
        }

        static {
            ArgType r0 = new ArgType("NONE", 0);
            NONE = r0;
            ArgType r1 = new ArgType("SIMPLE", 1);
            SIMPLE = r1;
            ArgType r3 = new ArgType("CHOICE", 2);
            CHOICE = r3;
            ArgType r5 = new ArgType("PLURAL", 3);
            PLURAL = r5;
            ArgType r7 = new ArgType("SELECT", 4);
            SELECT = r7;
            ArgType r9 = new ArgType("SELECTORDINAL", 5);
            SELECTORDINAL = r9;
            $VALUES = new ArgType[]{r0, r1, r3, r5, r7, r9};
        }

        public boolean hasPluralStyle() {
            throw new RuntimeException("Stub!");
        }
    }

    public static final class Part {

        public static final enum Type extends Enum<Type> {
            private static final /* synthetic */ Type[] $VALUES = null;
            public static final Type ARG_DOUBLE = null;
            public static final Type ARG_INT = null;
            public static final Type ARG_LIMIT = null;
            public static final Type ARG_NAME = null;
            public static final Type ARG_NUMBER = null;
            public static final Type ARG_SELECTOR = null;
            public static final Type ARG_START = null;
            public static final Type ARG_STYLE = null;
            public static final Type ARG_TYPE = null;
            public static final Type INSERT_CHAR = null;
            public static final Type MSG_LIMIT = null;
            public static final Type MSG_START = null;
            public static final Type REPLACE_NUMBER = null;
            public static final Type SKIP_SYNTAX = null;

            public static Type valueOf(String r1) {
                return (Type) Enum.valueOf(Type.class, r1);
            }

            public static Type[] values() {
                return (Type[]) $VALUES.clone();
            }

            private Type(String r1, int r2) {
                super(r1, r2);
            }

            static {
                Type r0 = new Type("MSG_START", 0);
                MSG_START = r0;
                Type r1 = new Type("MSG_LIMIT", 1);
                MSG_LIMIT = r1;
                Type r3 = new Type("SKIP_SYNTAX", 2);
                SKIP_SYNTAX = r3;
                Type r5 = new Type("INSERT_CHAR", 3);
                INSERT_CHAR = r5;
                Type r7 = new Type("REPLACE_NUMBER", 4);
                REPLACE_NUMBER = r7;
                Type r9 = new Type("ARG_START", 5);
                ARG_START = r9;
                Type r11 = new Type("ARG_LIMIT", 6);
                ARG_LIMIT = r11;
                Type r13 = new Type("ARG_NUMBER", 7);
                ARG_NUMBER = r13;
                Type r15 = new Type("ARG_NAME", 8);
                ARG_NAME = r15;
                Type r14 = new Type("ARG_TYPE", 9);
                ARG_TYPE = r14;
                Type r12 = new Type("ARG_STYLE", 10);
                ARG_STYLE = r12;
                Type r10 = new Type("ARG_SELECTOR", 11);
                ARG_SELECTOR = r10;
                Type r8 = new Type("ARG_INT", 12);
                ARG_INT = r8;
                Type r6 = new Type("ARG_DOUBLE", 13);
                ARG_DOUBLE = r6;
                $VALUES = new Type[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6};
            }

            public boolean hasNumericValue() {
                throw new RuntimeException("Stub!");
            }
        }

        private Part() {
            throw new RuntimeException("Stub!");
        }

        public Type getType() {
            throw new RuntimeException("Stub!");
        }

        public int getIndex() {
            throw new RuntimeException("Stub!");
        }

        public int getLength() {
            throw new RuntimeException("Stub!");
        }

        public int getLimit() {
            throw new RuntimeException("Stub!");
        }

        public int getValue() {
            throw new RuntimeException("Stub!");
        }

        public ArgType getArgType() {
            throw new RuntimeException("Stub!");
        }

        public String toString() {
            throw new RuntimeException("Stub!");
        }

        public boolean equals(Object r1) {
            throw new RuntimeException("Stub!");
        }

        public int hashCode() {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // android.icu.util.Freezable
    public /* bridge */ /* synthetic */ MessagePattern cloneAsThawed() {
        return cloneAsThawed();
    }

    @Override // android.icu.util.Freezable
    public /* bridge */ /* synthetic */ MessagePattern freeze() {
        return freeze();
    }

    public MessagePattern() {
        throw new RuntimeException("Stub!");
    }

    public MessagePattern(ApostropheMode r1) {
        throw new RuntimeException("Stub!");
    }

    public MessagePattern(String r1) {
        throw new RuntimeException("Stub!");
    }

    public MessagePattern parse(String r1) {
        throw new RuntimeException("Stub!");
    }

    public MessagePattern parseChoiceStyle(String r1) {
        throw new RuntimeException("Stub!");
    }

    public MessagePattern parsePluralStyle(String r1) {
        throw new RuntimeException("Stub!");
    }

    public MessagePattern parseSelectStyle(String r1) {
        throw new RuntimeException("Stub!");
    }

    public void clear() {
        throw new RuntimeException("Stub!");
    }

    public void clearPatternAndSetApostropheMode(ApostropheMode r1) {
        throw new RuntimeException("Stub!");
    }

    public boolean equals(Object r1) {
        throw new RuntimeException("Stub!");
    }

    public int hashCode() {
        throw new RuntimeException("Stub!");
    }

    public ApostropheMode getApostropheMode() {
        throw new RuntimeException("Stub!");
    }

    public String getPatternString() {
        throw new RuntimeException("Stub!");
    }

    public boolean hasNamedArguments() {
        throw new RuntimeException("Stub!");
    }

    public boolean hasNumberedArguments() {
        throw new RuntimeException("Stub!");
    }

    public String toString() {
        throw new RuntimeException("Stub!");
    }

    public static int validateArgumentName(String r1) {
        throw new RuntimeException("Stub!");
    }

    public String autoQuoteApostropheDeep() {
        throw new RuntimeException("Stub!");
    }

    public int countParts() {
        throw new RuntimeException("Stub!");
    }

    public Part getPart(int r1) {
        throw new RuntimeException("Stub!");
    }

    public Part.Type getPartType(int r1) {
        throw new RuntimeException("Stub!");
    }

    public int getPatternIndex(int r1) {
        throw new RuntimeException("Stub!");
    }

    public String getSubstring(Part r1) {
        throw new RuntimeException("Stub!");
    }

    public boolean partSubstringMatches(Part r1, String r2) {
        throw new RuntimeException("Stub!");
    }

    public double getNumericValue(Part r1) {
        throw new RuntimeException("Stub!");
    }

    public double getPluralOffset(int r1) {
        throw new RuntimeException("Stub!");
    }

    public int getLimitPartIndex(int r1) {
        throw new RuntimeException("Stub!");
    }

    public Object clone() {
        throw new RuntimeException("Stub!");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.icu.util.Freezable
    public MessagePattern cloneAsThawed() {
        throw new RuntimeException("Stub!");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.icu.util.Freezable
    public MessagePattern freeze() {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.util.Freezable
    public boolean isFrozen() {
        throw new RuntimeException("Stub!");
    }
}
