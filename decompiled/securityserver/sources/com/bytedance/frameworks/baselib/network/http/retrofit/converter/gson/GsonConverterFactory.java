package com.bytedance.frameworks.baselib.network.http.retrofit.converter.gson;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public final class GsonConverterFactory extends Converter.Factory {
    private final Gson gson;

    private GsonConverterFactory(Gson r1) {
        if (r1 == null) goto L7;
        this.gson = r1;
        return;
    L7:
        throw new NullPointerException("gson == null");
    }

    public static GsonConverterFactory create() {
        return create(new Gson());
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    public Converter<?, TypedOutput> requestBodyConverter(Type r1, Annotation[] r2, Annotation[] r3, Retrofit r4) {
        TypeAdapter r5 = this.gson.getAdapter(TypeToken.get(r1));
        return new GsonRequestBodyConverter(this.gson, r5);
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    public Converter<TypedInput, ?> responseBodyConverter(Type r1, Annotation[] r2, Retrofit r3) {
        TypeAdapter r4 = this.gson.getAdapter(TypeToken.get(r1));
        return new GsonResponseBodyConverter(this.gson, r4);
    }

    public static GsonConverterFactory create(Gson r1) {
        return new GsonConverterFactory(r1);
    }
}
