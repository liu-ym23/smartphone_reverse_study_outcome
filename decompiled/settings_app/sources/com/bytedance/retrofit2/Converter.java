package com.bytedance.retrofit2;

import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public interface Converter<F, T> {

    public static abstract class Factory {
        @Nullable
        public Converter<?, Header> headerConverter(Type r1, Annotation[] r2, Retrofit r3) {
            return null;
        }

        @Nullable
        public Converter<?, Object> objectConverter(Type r1, Annotation[] r2, Retrofit r3) {
            return null;
        }

        @Nullable
        public Converter<?, TypedOutput> requestBodyConverter(Type r1, Annotation[] r2, Annotation[] r3, Retrofit r4) {
            return null;
        }

        @Nullable
        public Converter<TypedInput, ?> responseBodyConverter(Type r1, Annotation[] r2, Retrofit r3) {
            return null;
        }

        @Nullable
        public Converter<?, String> stringConverter(Type r1, Annotation[] r2, Retrofit r3) {
            return null;
        }

        public Factory() {
        }
    }

    @Nullable
    T convert(F r1) throws IOException;
}
