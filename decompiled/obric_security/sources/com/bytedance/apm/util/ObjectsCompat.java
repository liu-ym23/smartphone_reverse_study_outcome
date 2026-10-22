package com.bytedance.apm.util;

/* JADX INFO: loaded from: classes.dex */
public class ObjectsCompat {
    private static final ImplBase IMPL = null;

    /* JADX INFO: renamed from: com.bytedance.apm.util.ObjectsCompat$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class ImplBase {
        private ImplBase() {
        }

        /* synthetic */ ImplBase(AnonymousClass1 r1) {
            this();
        }

        public boolean equals(Object r1, Object r2) {
            if (r1 == r2) goto L8;
            if (r1 != null) goto L5;
        L7:
            return false;
        L5:
            if (r1.equals(r2) == false) goto L7;
        L8:
            return true;
        }
    }

    static {
        IMPL = new ImplBase(null);
    }

    private ObjectsCompat() {
    }

    public static boolean equals(Object r1, Object r2) {
        return IMPL.equals(r1, r2);
    }
}
