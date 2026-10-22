package kotlin.annotation;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final enum AnnotationTarget extends Enum<AnnotationTarget> {
    public static final /* synthetic */ AnnotationTarget[] b = null;

    static {
        b = new AnnotationTarget[]{new AnnotationTarget("CLASS", 0), new AnnotationTarget("ANNOTATION_CLASS", 1), new AnnotationTarget("TYPE_PARAMETER", 2), new AnnotationTarget("PROPERTY", 3), new AnnotationTarget("FIELD", 4), new AnnotationTarget("LOCAL_VARIABLE", 5), new AnnotationTarget("VALUE_PARAMETER", 6), new AnnotationTarget("CONSTRUCTOR", 7), new AnnotationTarget("FUNCTION", 8), new AnnotationTarget("PROPERTY_GETTER", 9), new AnnotationTarget("PROPERTY_SETTER", 10), new AnnotationTarget("TYPE", 11), new AnnotationTarget("EXPRESSION", 12), new AnnotationTarget("FILE", 13), new AnnotationTarget("TYPEALIAS", 14)};
    }

    public static AnnotationTarget valueOf(String r1) {
        return (AnnotationTarget) Enum.valueOf(AnnotationTarget.class, r1);
    }

    public static AnnotationTarget[] values() {
        return (AnnotationTarget[]) b.clone();
    }
}
