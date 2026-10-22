package com.qihoo360.mobilesafe.common.ui.base;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes4.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
public @interface WidgetRef {
    int[] animRef() default {};

    Class<?>[] classRef() default {};

    int[] drawableRef() default {};

    int[] layoutRef() default {};
}
