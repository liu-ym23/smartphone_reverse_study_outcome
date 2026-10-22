package d.b.r;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public interface c<R, T> {

    public static abstract class a {
        public a() {
        }

        protected static Class<?> b(Type r0) {
            return f0.j(r0);
        }

        public abstract c<?, ?> a(Type r1, Annotation[] r2, v r3);
    }

    Type a();

    T b(b<R> r1);
}
