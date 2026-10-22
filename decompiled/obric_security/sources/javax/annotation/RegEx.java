package javax.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.annotation.meta.TypeQualifierValidator;
import javax.annotation.meta.When;

/* JADX INFO: loaded from: classes5.dex */
@Syntax("RegEx")
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface RegEx {

    public static class Checker implements TypeQualifierValidator<RegEx> {
        public Checker() {
        }

        @Override // javax.annotation.meta.TypeQualifierValidator
        public /* bridge */ /* synthetic */ When forConstantValue(Annotation r1, Object r2) {
            return forConstantValue((RegEx) r1, r2);
        }

        public When forConstantValue(RegEx r1, Object r2) {
            if ((r2 instanceof String) == false) goto L5;
            Pattern.compile((String) r2);     // Catch: PatternSyntaxException -> L9
            return When.ALWAYS;
        L10:
            return When.NEVER;
        L5:
            return When.NEVER;
        }
    }

    When when() default When.ALWAYS;
}
