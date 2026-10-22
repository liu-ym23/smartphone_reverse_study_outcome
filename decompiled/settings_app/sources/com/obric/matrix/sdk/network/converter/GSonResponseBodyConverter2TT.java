package com.obric.matrix.sdk.network.converter;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.mime.MimeUtil;
import com.bytedance.retrofit2.mime.TypedInput;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes4.dex */
public class GSonResponseBodyConverter2TT<T> implements Converter<TypedInput, T> {
    private final TypeAdapter<T> adapter;
    private final Gson gson;

    @Override // com.bytedance.retrofit2.Converter
    public /* bridge */ /* synthetic */ Object convert(TypedInput r1) throws IOException {
        return convert2(r1);
    }

    GSonResponseBodyConverter2TT(Gson r1, TypeAdapter<T> r2) {
        this.gson = r1;
        this.adapter = r2;
    }

    /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
    public T convert2(TypedInput r3) throws IOException {
        String r1 = "UTF-8";
        if (r3.mimeType() == null) goto L5;
        r1 = MimeUtil.parseCharset(r3.mimeType(), "UTF-8");
    L5:
        InputStreamReader r0 = new InputStreamReader(r3.in(), r1);
        JsonReader r4 = this.gson.newJsonReader(r0);
        return this.adapter.read(r4);
    }
}
