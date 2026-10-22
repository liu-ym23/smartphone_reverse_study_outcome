package com.bytedance.frameworks.baselib.network.http.retrofit.converter.gson;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
final class GsonRequestBodyConverter<T> implements Converter<T, TypedOutput> {
    private static final String MEDIA_TYPE = "application/json; charset=UTF-8";
    private static final Charset UTF_8 = null;
    private final TypeAdapter<T> adapter;
    private final Gson gson;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.retrofit2.Converter
    public /* bridge */ /* synthetic */ TypedOutput convert(Object r1) throws IOException {
        return convert(r1);
    }

    static {
        UTF_8 = Charset.forName("UTF-8");
    }

    GsonRequestBodyConverter(Gson r1, TypeAdapter<T> r2) {
        this.gson = r1;
        this.adapter = r2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.retrofit2.Converter
    public TypedOutput convert(T r4) throws IOException {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(1024);
        OutputStreamWriter r1 = new OutputStreamWriter(r0, UTF_8);
        JsonWriter r2 = this.gson.newJsonWriter(r1);
        this.adapter.write(r2, r4);
        r2.close();
        return new TypedByteArray(MEDIA_TYPE, r0.toByteArray(), new String[0]);
    }
}
