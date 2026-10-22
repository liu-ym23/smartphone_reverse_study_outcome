package androidx.annotation.experimental;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface Experimental {

    public static final enum Level extends Enum<Level> {
        private static final /* synthetic */ Level[] $VALUES = null;
        public static final Level ERROR = null;
        public static final Level WARNING = null;

        static {
            Level r0 = new Level("WARNING", 0);
            WARNING = r0;
            Level r1 = new Level("ERROR", 1);
            ERROR = r1;
            $VALUES = new Level[]{r0, r1};
        }

        private Level(String r1, int r2) {
            super(r1, r2);
        }

        public static Level valueOf(String r1) {
            return (Level) Enum.valueOf(Level.class, r1);
        }

        public static Level[] values() {
            return (Level[]) $VALUES.clone();
        }
    }

    Level level() default Level.ERROR;
}
