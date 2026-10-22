package android.icu.util;

/* JADX INFO: loaded from: classes.dex */
public interface RangeValueIterator {

    public static class Element {
        public int limit;
        public int start;
        public int value;

        public Element() {
            throw new RuntimeException("Stub!");
        }
    }

    boolean next(Element r1);

    void reset();
}
