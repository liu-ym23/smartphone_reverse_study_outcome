package androidx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR})
@Metadata
@kotlin.annotation.Target
@Retention(RetentionPolicy.RUNTIME)
public @interface ReplaceWith {
    String expression();

    String[] imports() default {};
}
