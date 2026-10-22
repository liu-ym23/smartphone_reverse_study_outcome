package androidx.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.MustBeDocumented;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE})
@kotlin.annotation.Target
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention
@MustBeDocumented
@Metadata
@Documented
public @interface Dimension {

    @NotNull
    public static final Companion Companion = null;
    public static final int DP = 0;
    public static final int PX = 1;
    public static final int SP = 2;

    @Metadata
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final int DP = 0;
        public static final int PX = 1;
        public static final int SP = 2;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    int unit() default 1;
}
