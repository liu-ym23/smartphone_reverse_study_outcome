package com.squareup.wire;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.FIELD})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B5\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0013\u0010\u0006\u001a\u00020\u00058\u0006@\u0006¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\b8\u0006@\u0006¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0013\u0010\f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u00020\u00058\u0006@\u0006¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/squareup/wire/WireField;", "", "", "redacted", "()Z", "", "adapter", "()Ljava/lang/String;", "", LocationMonitorConst.TAG, "()I", "Lcom/squareup/wire/WireField$Label;", "label", "()Lcom/squareup/wire/WireField$Label;", "keyAdapter", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lcom/squareup/wire/WireField$Label;Z)V", "Label", "wire-runtime"}, k = 1, mv = {1, 1, 15})
@Retention(RetentionPolicy.RUNTIME)
public @interface WireField {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0013\u0010\u0003\u001a\u00020\u00028G@\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0013\u0010\u0005\u001a\u00020\u00028G@\u0006¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0004R\u0013\u0010\u0006\u001a\u00020\u00028G@\u0006¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/squareup/wire/WireField$Label;", "", "", "isRepeated", "()Z", "isOneOf", "isPacked", "<init>", "(Ljava/lang/String;I)V", "REQUIRED", "OPTIONAL", "REPEATED", "ONE_OF", "PACKED", "wire-runtime"}, k = 1, mv = {1, 1, 15})
    public static final enum Label extends Enum<Label> {
        private static final /* synthetic */ Label[] $VALUES = null;
        public static final Label ONE_OF = null;
        public static final Label OPTIONAL = null;
        public static final Label PACKED = null;
        public static final Label REPEATED = null;
        public static final Label REQUIRED = null;

        static {
            Label r1 = new Label("REQUIRED", 0);
            REQUIRED = r1;
            Label r2 = new Label("OPTIONAL", 1);
            OPTIONAL = r2;
            Label r3 = new Label("REPEATED", 2);
            REPEATED = r3;
            Label r4 = new Label("ONE_OF", 3);
            ONE_OF = r4;
            Label r5 = new Label("PACKED", 4);
            PACKED = r5;
            $VALUES = new Label[]{r1, r2, r3, r4, r5};
        }

        private Label(String r1, int r2) {
            super(r1, r2);
        }

        public static Label valueOf(String r1) {
            return (Label) Enum.valueOf(Label.class, r1);
        }

        public static Label[] values() {
            return (Label[]) $VALUES.clone();
        }

        public final boolean isOneOf() {
            if (this != ONE_OF) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean isPacked() {
            if (this != PACKED) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean isRepeated() {
            if (this != REPEATED) goto L5;
        L8:
            return true;
        L5:
            if (this == PACKED) goto L8;
            return false;
        }
    }

    String adapter();

    String keyAdapter() default "";

    Label label() default Label.OPTIONAL;

    boolean redacted() default false;

    int tag();
}
