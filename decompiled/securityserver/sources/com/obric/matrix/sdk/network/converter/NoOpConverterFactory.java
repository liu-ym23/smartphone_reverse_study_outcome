package com.obric.matrix.sdk.network.converter;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public class NoOpConverterFactory extends Converter.Factory {
    private NoOpConverterFactory() {
    }

    public static NoOpConverterFactory create() {
        return new NoOpConverterFactory();
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    public Converter<?, TypedOutput> requestBodyConverter(Type r1, Annotation[] r2, Annotation[] r3, Retrofit r4) {
        return null;
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    public Converter<TypedInput, ?> responseBodyConverter(Type r1, Annotation[] r2, Retrofit r3) {
        if (r1 == TypedInput.class) goto L5;
        return null;
    L5:
        return new AnonymousClass1(this);
    }
}
