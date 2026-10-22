package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import okhttp3.q0;
import okhttp3.w0;

/* JADX INFO: loaded from: classes3.dex */
public interface Converter<F, T> {

    public static abstract class Factory {
        public Factory() {
        }

        public static Type getParameterUpperBound(int r5, ParameterizedType r10) {
            return Utils.getParameterUpperBound(r5, r10);
        }

        public static Class<?> getRawType(Type r5) {
            return Utils.getRawType(r5);
        }

        public Converter<?, q0> requestBodyConverter(Type r5, Annotation[] r10, Annotation[] r11, Retrofit r12) {
            return null;
        }

        public Converter<w0, ?> responseBodyConverter(Type r5, Annotation[] r10, Retrofit r11) {
            return null;
        }

        public Converter<?, String> stringConverter(Type r5, Annotation[] r10, Retrofit r11) {
            return null;
        }
    }

    T convert(F r5) throws IOException;
}
