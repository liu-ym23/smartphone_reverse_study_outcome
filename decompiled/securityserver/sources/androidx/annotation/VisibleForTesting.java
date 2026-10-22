package androidx.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.MustBeDocumented;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@MustBeDocumented
@Metadata
@Documented
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention
public @interface VisibleForTesting {

    @NotNull
    public static final Companion Companion = null;
    public static final int NONE = 5;
    public static final int PACKAGE_PRIVATE = 3;
    public static final int PRIVATE = 2;
    public static final int PROTECTED = 4;

    @Metadata
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final int NONE = 5;
        public static final int PACKAGE_PRIVATE = 3;
        public static final int PRIVATE = 2;
        public static final int PROTECTED = 4;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    int otherwise() default 2;
}
