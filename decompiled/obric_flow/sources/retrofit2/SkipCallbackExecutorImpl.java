package retrofit2;

import java.lang.annotation.Annotation;

/* JADX INFO: loaded from: classes3.dex */
final class SkipCallbackExecutorImpl implements SkipCallbackExecutor {
    private static final SkipCallbackExecutor INSTANCE = null;

    static {
        INSTANCE = new SkipCallbackExecutorImpl();
    }

    public SkipCallbackExecutorImpl() {
    }

    public static Annotation[] ensurePresent(Annotation[] r5) {
        if (Utils.isAnnotationPresent(r5, SkipCallbackExecutor.class) == false) goto L5;
        return r5;
    L5:
        Annotation[] r10 = new Annotation[r5.length + 1];
        r10[0] = INSTANCE;
        System.arraycopy(r5, 0, r10, 1, r5.length);
        return r10;
    }

    @Override // java.lang.annotation.Annotation
    public Class<? extends Annotation> annotationType() {
        return SkipCallbackExecutor.class;
    }

    @Override // java.lang.annotation.Annotation
    public boolean equals(Object r5) {
        return r5 instanceof SkipCallbackExecutor;
    }

    @Override // java.lang.annotation.Annotation
    public int hashCode() {
        return 0;
    }

    @Override // java.lang.annotation.Annotation
    public String toString() {
        return "@" + SkipCallbackExecutor.class.getName() + "()";
    }
}
