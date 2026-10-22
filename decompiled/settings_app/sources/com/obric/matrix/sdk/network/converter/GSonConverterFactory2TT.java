package com.obric.matrix.sdk.network.converter;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes4.dex */
public class GSonConverterFactory2TT extends Converter.Factory {
    private final Gson gson;

    public static GSonConverterFactory2TT create() {
        return create(new GsonBuilder().setLenient().create());
    }

    public static GSonConverterFactory2TT create(Gson r1) {
        if (r1 == null) goto L6;
        return new GSonConverterFactory2TT(r1);
    L6:
        throw new NullPointerException("gson == null");
    }

    private GSonConverterFactory2TT(Gson r1) {
        this.gson = r1;
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    public Converter<TypedInput, ?> responseBodyConverter(Type r1, Annotation[] r2, Retrofit r3) {
        TypeAdapter r4 = this.gson.getAdapter(TypeToken.get(r1));
        return new GSonResponseBodyConverter2TT(this.gson, r4);
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    public Converter<?, TypedOutput> requestBodyConverter(Type r1, Annotation[] r2, Annotation[] r3, Retrofit r4) {
        TypeAdapter r5 = this.gson.getAdapter(TypeToken.get(r1));
        return new GSonRequestBodyConverter2TT(this.gson, r5);
    }
}
