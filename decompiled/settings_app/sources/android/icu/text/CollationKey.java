package android.icu.text;

/* JADX INFO: loaded from: classes.dex */
public final class CollationKey implements Comparable<CollationKey> {

    public static final class BoundMode {
        public static final int LOWER = 0;
        public static final int UPPER = 1;
        public static final int UPPER_LONG = 2;

        private BoundMode() {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(CollationKey r1) {
        return compareTo2(r1);
    }

    public CollationKey(String r1, byte[] r2) {
        throw new RuntimeException("Stub!");
    }

    public String getSourceString() {
        throw new RuntimeException("Stub!");
    }

    public byte[] toByteArray() {
        throw new RuntimeException("Stub!");
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(CollationKey r1) {
        throw new RuntimeException("Stub!");
    }

    public boolean equals(Object r1) {
        throw new RuntimeException("Stub!");
    }

    public boolean equals(CollationKey r1) {
        throw new RuntimeException("Stub!");
    }

    public int hashCode() {
        throw new RuntimeException("Stub!");
    }

    public CollationKey getBound(int r1, int r2) {
        throw new RuntimeException("Stub!");
    }

    public CollationKey merge(CollationKey r1) {
        throw new RuntimeException("Stub!");
    }
}
