package javax.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifier;
import javax.annotation.meta.TypeQualifierValidator;
import javax.annotation.meta.When;

/* JADX INFO: loaded from: classes5.dex */
@TypeQualifier(applicableTo = Number.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Nonnegative {

    public static class Checker implements TypeQualifierValidator<Nonnegative> {
        public Checker() {
        }

        @Override // javax.annotation.meta.TypeQualifierValidator
        public /* bridge */ /* synthetic */ When forConstantValue(Annotation r1, Object r2) {
            return forConstantValue((Nonnegative) r1, r2);
        }

        public When forConstantValue(Nonnegative r6, Object r7) {
            if ((r7 instanceof Number) == false) goto L5;
            Number r8 = (Number) r7;
            boolean r9 = true;
            if ((r8 instanceof Long) == false) goto L13;
            if (r8.longValue() < 0) goto L24;
        L11:
            r9 = false;
        L24:
            if (r9 == false) goto L28;
            return When.NEVER;
        L28:
            return When.ALWAYS;
        L13:
            if ((r8 instanceof Double) == false) goto L18;
            if (r8.doubleValue() >= 0.0d) goto L11;
        L18:
            if ((r8 instanceof Float) == false) goto L23;
            if (r8.floatValue() >= 0.0f) goto L11;
        L23:
            if (r8.intValue() >= 0) goto L11;
        L5:
            return When.NEVER;
        }
    }

    When when() default When.ALWAYS;
}
