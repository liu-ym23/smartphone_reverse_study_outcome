package rg;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface a {
    boolean isSupportMultiProcess() default false;

    String settingsId() default "";

    String storageKey();
}
