package androidx.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.annotation.MustBeDocumented;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.PACKAGE})
@kotlin.annotation.Target
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention
@MustBeDocumented
@Metadata
@Documented
public @interface RestrictTo {

    @Metadata
    public static final enum Scope extends Enum<Scope> {
        private static final /* synthetic */ Scope[] $VALUES = null;

        @Deprecated
        public static final Scope GROUP_ID = null;
        public static final Scope LIBRARY = null;
        public static final Scope LIBRARY_GROUP = null;
        public static final Scope LIBRARY_GROUP_PREFIX = null;
        public static final Scope SUBCLASSES = null;
        public static final Scope TESTS = null;

        private static final /* synthetic */ Scope[] $values() {
            return new Scope[]{LIBRARY, LIBRARY_GROUP, LIBRARY_GROUP_PREFIX, GROUP_ID, TESTS, SUBCLASSES};
        }

        static {
            LIBRARY = new Scope("LIBRARY", 0);
            LIBRARY_GROUP = new Scope("LIBRARY_GROUP", 1);
            LIBRARY_GROUP_PREFIX = new Scope("LIBRARY_GROUP_PREFIX", 2);
            GROUP_ID = new Scope("GROUP_ID", 3);
            TESTS = new Scope("TESTS", 4);
            SUBCLASSES = new Scope("SUBCLASSES", 5);
            $VALUES = $values();
        }

        private Scope(String r1, int r2) {
            super(r1, r2);
        }

        public static Scope valueOf(String r1) {
            return (Scope) Enum.valueOf(Scope.class, r1);
        }

        public static Scope[] values() {
            return (Scope[]) $VALUES.clone();
        }
    }

    Scope[] value();
}
