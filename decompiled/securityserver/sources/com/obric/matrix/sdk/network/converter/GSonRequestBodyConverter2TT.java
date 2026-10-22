package com.obric.matrix.sdk.network.converter;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes2.dex */
public class GSonRequestBodyConverter2TT<T> implements Converter<T, TypedOutput> {
    private static final String MEDIA_TYPE = "application/json; charset=UTF-8";
    private static final Charset UTF_8 = null;
    private final TypeAdapter<T> adapter;
    private final Gson gson;

    static {
        UTF_8 = StandardCharsets.UTF_8;
    }

    public GSonRequestBodyConverter2TT(Gson r1, TypeAdapter<T> r2) {
        this.gson = r1;
        this.adapter = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.retrofit2.Converter
    public /* bridge */ /* synthetic */ TypedOutput convert(Object r1) {
        return convert(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.retrofit2.Converter
    public TypedOutput convert(T r4) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(1024);
        OutputStreamWriter r1 = new OutputStreamWriter(r0, UTF_8);     // Catch: Exception -> L5
        JsonWriter r2 = this.gson.newJsonWriter(r1);     // Catch: Exception -> L5
        this.adapter.write(r2, r4);     // Catch: Exception -> L5
        r2.close();     // Catch: Exception -> L5
    L8:
        return new TypedByteArray(MEDIA_TYPE, r0.toByteArray(), new String[0]);
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }
}
