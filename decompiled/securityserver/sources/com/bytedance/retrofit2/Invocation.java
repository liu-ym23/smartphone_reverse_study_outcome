package com.bytedance.retrofit2;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class Invocation {
    private final List<?> arguments;
    private final Method method;

    public Invocation(Method r1, List<?> r2) {
        this.method = r1;
        this.arguments = Collections.unmodifiableList(r2);
    }

    public static Invocation of(Method r2, List<?> r3) {
        Utils.checkNotNull(r2, "method == null");
        Utils.checkNotNull(r3, "arguments == null");
        return new Invocation(r2, new ArrayList(r3));
    }

    public List<?> arguments() {
        return this.arguments;
    }

    public Method method() {
        return this.method;
    }

    public String toString() {
        return String.format("%s.%s() %s", new Object[]{this.method.getDeclaringClass().getName(), this.method.getName(), this.arguments});
    }
}
