package kotlin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX WARN: Method from annotation default annotation not found: level */
/* JADX WARN: Method from annotation default annotation not found: message */
/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.ANNOTATION_TYPE})
@SinceKotlin
@Metadata
@kotlin.annotation.Target
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention
public @interface RequiresOptIn {

    @Metadata
    public static final enum Level extends Enum<Level> {
        public static final Level b = null;
        public static final /* synthetic */ Level[] c = null;

        static {
            Level r0 = new Level("WARNING", 0);
            Level r1 = new Level("ERROR", 1);
            b = r1;
            c = new Level[]{r0, r1};
        }

        public static Level valueOf(String r1) {
            return (Level) Enum.valueOf(Level.class, r1);
        }

        public static Level[] values() {
            return (Level[]) c.clone();
        }
    }
}
