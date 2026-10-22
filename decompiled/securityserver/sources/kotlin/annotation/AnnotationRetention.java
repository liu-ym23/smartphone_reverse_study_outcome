package kotlin.annotation;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final enum AnnotationRetention extends Enum<AnnotationRetention> {
    public static final AnnotationRetention b = null;
    public static final /* synthetic */ AnnotationRetention[] c = null;

    static {
        AnnotationRetention r0 = new AnnotationRetention("SOURCE", 0);
        AnnotationRetention r1 = new AnnotationRetention("BINARY", 1);
        AnnotationRetention r2 = new AnnotationRetention("RUNTIME", 2);
        b = r2;
        c = new AnnotationRetention[]{r0, r1, r2};
    }

    public static AnnotationRetention valueOf(String r1) {
        return (AnnotationRetention) Enum.valueOf(AnnotationRetention.class, r1);
    }

    public static AnnotationRetention[] values() {
        return (AnnotationRetention[]) c.clone();
    }
}
