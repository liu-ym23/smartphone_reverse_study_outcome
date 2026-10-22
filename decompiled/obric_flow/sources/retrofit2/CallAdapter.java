package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes3.dex */
public interface CallAdapter<R, T> {

    public static abstract class Factory {
        public Factory() {
        }

        public static Type getParameterUpperBound(int r5, ParameterizedType r10) {
            return Utils.getParameterUpperBound(r5, r10);
        }

        public static Class<?> getRawType(Type r5) {
            return Utils.getRawType(r5);
        }

        public abstract CallAdapter<?, ?> get(Type r5, Annotation[] r10, Retrofit r11);
    }

    T adapt(Call<R> r5);

    Type responseType();
}
