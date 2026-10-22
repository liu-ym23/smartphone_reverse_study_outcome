package javax.obex;

/* JADX INFO: loaded from: classes5.dex */
public final class ApplicationParameter {
    private byte[] mArray;
    private int mLength;
    private int mMaxLength;

    public static class TRIPLET_LENGTH {
        public static final byte DATABASEIDENTIFIER_LENGTH = 16;
        public static final byte FORMAT_LENGTH = 1;
        public static final byte LISTSTARTOFFSET_LENGTH = 2;
        public static final byte MAXLISTCOUNT_LENGTH = 2;
        public static final byte NEWMISSEDCALLS_LENGTH = 1;
        public static final byte ORDER_LENGTH = 1;
        public static final byte PHONEBOOKSIZE_LENGTH = 2;
        public static final byte PRIMARYVERSIONCOUNTER_LENGTH = 16;
        public static final byte PROPERTY_SELECTOR_LENGTH = 8;
        public static final byte RESETNEWMISSEDCALLS_LENGTH = 1;
        public static final byte SEARCH_ATTRIBUTE_LENGTH = 1;
        public static final byte SECONDARYVERSIONCOUNTER_LENGTH = 16;
        public static final byte SUPPORTEDFEATURE_LENGTH = 4;
        public static final byte VCARDSELECTOROPERATOR_LENGTH = 1;
        public static final byte VCARDSELECTOR_LENGTH = 8;

        public TRIPLET_LENGTH() {
        }
    }

    public static class TRIPLET_TAGID {
        public static final byte DATABASEIDENTIFIER_TAGID = 13;
        public static final byte FORMAT_TAGID = 7;
        public static final byte LISTSTARTOFFSET_TAGID = 5;
        public static final byte MAXLISTCOUNT_TAGID = 4;
        public static final byte NEWMISSEDCALLS_TAGID = 9;
        public static final byte ORDER_TAGID = 1;
        public static final byte PHONEBOOKSIZE_TAGID = 8;
        public static final byte PRIMARYVERSIONCOUNTER_TAGID = 10;
        public static final byte PROPERTY_SELECTOR_TAGID = 6;
        public static final byte RESET_NEW_MISSED_CALLS_TAGID = 15;
        public static final byte SEARCH_ATTRIBUTE_TAGID = 3;
        public static final byte SEARCH_VALUE_TAGID = 2;
        public static final byte SECONDARYVERSIONCOUNTER_TAGID = 11;
        public static final byte SUPPORTEDFEATURE_TAGID = 16;
        public static final byte VCARDSELECTOROPERATOR_TAGID = 14;
        public static final byte VCARDSELECTOR_TAGID = 12;

        public TRIPLET_TAGID() {
        }
    }

    public static class TRIPLET_VALUE {

        public static class FORMAT {
            public static final byte VCARD_VERSION_21 = 0;
            public static final byte VCARD_VERSION_30 = 1;

            public FORMAT() {
            }
        }

        public static class ORDER {
            public static final byte ORDER_BY_ALPHANUMERIC = 1;
            public static final byte ORDER_BY_INDEX = 0;
            public static final byte ORDER_BY_PHONETIC = 2;

            public ORDER() {
            }
        }

        public static class SEARCHATTRIBUTE {
            public static final byte SEARCH_BY_NAME = 0;
            public static final byte SEARCH_BY_NUMBER = 1;
            public static final byte SEARCH_BY_SOUND = 2;

            public SEARCHATTRIBUTE() {
            }
        }

        public TRIPLET_VALUE() {
        }
    }

    public ApplicationParameter() {
        this.mMaxLength = 1000;
        this.mArray = new byte[1000];
        this.mLength = 0;
    }

    public void addAPPHeader(byte r6, byte r7, byte[] r8) {
        int r0 = this.mLength;
        if (((r0 + r7) + 2) <= this.mMaxLength) goto L5;
        int r1 = r7 * 4;
        byte[] r2 = new byte[r0 + r1];
        System.arraycopy(this.mArray, 0, r2, 0, r0);
        this.mArray = r2;
        this.mMaxLength = this.mLength + r1;
    L5:
        byte[] r3 = this.mArray;
        int r4 = this.mLength;
        int r5 = r4 + 1;
        r3[r4] = r6;
        int r9 = r5 + 1;
        this.mLength = r9;
        r3[r5] = r7;
        System.arraycopy(r8, 0, r3, r9, r7);
        this.mLength += r7;
    }

    public byte[] getAPPparam() {
        int r0 = this.mLength;
        byte[] r1 = new byte[r0];
        System.arraycopy(this.mArray, 0, r1, 0, r0);
        return r1;
    }
}
