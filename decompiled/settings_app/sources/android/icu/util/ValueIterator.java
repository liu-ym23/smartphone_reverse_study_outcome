package android.icu.util;

/* JADX INFO: loaded from: classes.dex */
public interface ValueIterator {

    public static final class Element {
        public int integer;
        public Object value;

        public Element() {
            throw new RuntimeException("Stub!");
        }
    }

    boolean next(Element r1);

    void reset();

    void setRange(int r1, int r2);
}
