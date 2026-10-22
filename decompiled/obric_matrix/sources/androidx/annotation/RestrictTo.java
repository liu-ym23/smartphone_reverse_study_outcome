package androidx.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.PACKAGE})
@Documented
@Retention(RetentionPolicy.CLASS)
public @interface RestrictTo {

    public static final enum Scope extends Enum<Scope> {
        private static final /* synthetic */ Scope[] $VALUES = null;

        @Deprecated
        public static final Scope GROUP_ID = null;
        public static final Scope LIBRARY = null;
        public static final Scope LIBRARY_GROUP = null;
        public static final Scope LIBRARY_GROUP_PREFIX = null;
        public static final Scope SUBCLASSES = null;
        public static final Scope TESTS = null;

        static {
            Scope r0 = new Scope("LIBRARY", 0);
            LIBRARY = r0;
            Scope r1 = new Scope("LIBRARY_GROUP", 1);
            LIBRARY_GROUP = r1;
            Scope r3 = new Scope("LIBRARY_GROUP_PREFIX", 2);
            LIBRARY_GROUP_PREFIX = r3;
            Scope r5 = new Scope("GROUP_ID", 3);
            GROUP_ID = r5;
            Scope r7 = new Scope("TESTS", 4);
            TESTS = r7;
            Scope r9 = new Scope("SUBCLASSES", 5);
            SUBCLASSES = r9;
            $VALUES = new Scope[]{r0, r1, r3, r5, r7, r9};
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
