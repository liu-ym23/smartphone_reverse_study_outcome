package android.icu.text;

/* JADX INFO: loaded from: classes.dex */
public final class Edits {

    public static final class Iterator {
        private Iterator() {
            throw new RuntimeException("Stub!");
        }

        public boolean next() {
            throw new RuntimeException("Stub!");
        }

        public boolean findSourceIndex(int r1) {
            throw new RuntimeException("Stub!");
        }

        public boolean findDestinationIndex(int r1) {
            throw new RuntimeException("Stub!");
        }

        public int destinationIndexFromSourceIndex(int r1) {
            throw new RuntimeException("Stub!");
        }

        public int sourceIndexFromDestinationIndex(int r1) {
            throw new RuntimeException("Stub!");
        }

        public boolean hasChange() {
            throw new RuntimeException("Stub!");
        }

        public int oldLength() {
            throw new RuntimeException("Stub!");
        }

        public int newLength() {
            throw new RuntimeException("Stub!");
        }

        public int sourceIndex() {
            throw new RuntimeException("Stub!");
        }

        public int replacementIndex() {
            throw new RuntimeException("Stub!");
        }

        public int destinationIndex() {
            throw new RuntimeException("Stub!");
        }

        public String toString() {
            throw new RuntimeException("Stub!");
        }
    }

    public Edits() {
        throw new RuntimeException("Stub!");
    }

    public void reset() {
        throw new RuntimeException("Stub!");
    }

    public void addUnchanged(int r1) {
        throw new RuntimeException("Stub!");
    }

    public void addReplace(int r1, int r2) {
        throw new RuntimeException("Stub!");
    }

    public int lengthDelta() {
        throw new RuntimeException("Stub!");
    }

    public boolean hasChanges() {
        throw new RuntimeException("Stub!");
    }

    public int numberOfChanges() {
        throw new RuntimeException("Stub!");
    }

    public Iterator getCoarseChangesIterator() {
        throw new RuntimeException("Stub!");
    }

    public Iterator getCoarseIterator() {
        throw new RuntimeException("Stub!");
    }

    public Iterator getFineChangesIterator() {
        throw new RuntimeException("Stub!");
    }

    public Iterator getFineIterator() {
        throw new RuntimeException("Stub!");
    }

    public Edits mergeAndAppend(Edits r1, Edits r2) {
        throw new RuntimeException("Stub!");
    }
}
