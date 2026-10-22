package org.checkerframework.dataflow.qual;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes6.dex */
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Pure {

    public static final enum Kind extends Enum<Kind> {
        private static final /* synthetic */ Kind[] $VALUES = null;
        public static final Kind DETERMINISTIC = null;
        public static final Kind SIDE_EFFECT_FREE = null;

        private Kind(String r1, int r2) {
            super(r1, r2);
        }

        public static Kind valueOf(String r1) {
            return (Kind) Enum.valueOf(Kind.class, r1);
        }

        public static Kind[] values() {
            return (Kind[]) $VALUES.clone();
        }

        static {
            Kind r0 = new Kind("SIDE_EFFECT_FREE", 0);
            SIDE_EFFECT_FREE = r0;
            Kind r1 = new Kind("DETERMINISTIC", 1);
            DETERMINISTIC = r1;
            $VALUES = new Kind[]{r0, r1};
        }
    }
}
