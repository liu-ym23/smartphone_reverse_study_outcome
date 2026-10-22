package retrofit2;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class Invocation {
    private final List<?> arguments;
    private final Method method;

    public Invocation(Method r5, List<?> r10) {
        this.method = r5;
        this.arguments = Collections.unmodifiableList(r10);
    }

    public static Invocation of(Method r5, List<?> r10) {
        Objects.requireNonNull(r5, "method == null");
        Objects.requireNonNull(r10, "arguments == null");
        return new Invocation(r5, new ArrayList(r10));
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
