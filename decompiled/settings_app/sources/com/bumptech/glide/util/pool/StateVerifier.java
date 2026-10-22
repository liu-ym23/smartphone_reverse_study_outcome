package com.bumptech.glide.util.pool;

/* JADX INFO: loaded from: classes3.dex */
public abstract class StateVerifier {
    private static final boolean DEBUG = false;

    /* JADX INFO: renamed from: com.bumptech.glide.util.pool.StateVerifier$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class DebugStateVerifier extends StateVerifier {
        private volatile RuntimeException recycledAtStackTraceException;

        DebugStateVerifier() {
            super(null);
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void throwIfRecycled() {
            if (this.recycledAtStackTraceException != null) goto L6;
            return;
        L6:
            throw new IllegalStateException("Already released", this.recycledAtStackTraceException);
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        void setRecycled(boolean r2) {
            if (r2 == false) goto L4;
            this.recycledAtStackTraceException = new RuntimeException("Released");
            return;
        L4:
            this.recycledAtStackTraceException = null;
        }
    }

    private static class DefaultStateVerifier extends StateVerifier {
        private volatile boolean isReleased;

        DefaultStateVerifier() {
            super(null);
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void throwIfRecycled() {
            if (this.isReleased == true) goto L6;
            return;
        L6:
            throw new IllegalStateException("Already released");
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void setRecycled(boolean r1) {
            this.isReleased = r1;
        }
    }

    abstract void setRecycled(boolean r1);

    public abstract void throwIfRecycled();

    /* synthetic */ StateVerifier(AnonymousClass1 r1) {
        this();
    }

    public static StateVerifier newInstance() {
        return new DefaultStateVerifier();
    }

    private StateVerifier() {
    }
}
