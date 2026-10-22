package com.bytedance.retrofit2;

import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.mime.MimeUtil;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import kotlin.Unit;

/* JADX INFO: loaded from: classes.dex */
final class BuiltInConverters extends Converter.Factory {
    private boolean checkForKotlinUnit;

    static final class BufferingResponseBodyConverter implements Converter<TypedInput, TypedInput> {
        static final BufferingResponseBodyConverter INSTANCE = null;

        BufferingResponseBodyConverter() {
        }

        @Override // com.bytedance.retrofit2.Converter
        public /* bridge */ /* synthetic */ TypedInput convert(@Nullable TypedInput r1) throws IOException {
            return convert2(r1);
        }

        static {
            INSTANCE = new BufferingResponseBodyConverter();
        }

        /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
        public TypedInput convert2(@Nullable TypedInput r4) throws IOException {
            if (r4 != null) goto L4;
        L15:
            return r4;
        L4:
            if ((r4 instanceof TypedByteArray) == true) goto L15;
            String r3 = r4.mimeType();
            InputStream r5 = r4.in();
            TypedByteArray r1 = new TypedByteArray(r3, Utils.streamToBytes(r5), new String[0]);     // Catch: Throwable -> L11
            if (r5 != null) goto L22;
        L10:
            return r1;
        L22:
            r5.close();     // Catch: IOException -> L16
        L11:
            th = move-exception;
            if (r5 != null) goto L20;
        L14:
            throw th;
        L20:
            r5.close();     // Catch: IOException -> L17
            goto L14
        }
    }

    static final class HeaderConverter implements Converter<Header, Header> {
        static final HeaderConverter INSTANCE = null;

        /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
        public Header convert2(Header r1) throws IOException {
            return r1;
        }

        HeaderConverter() {
        }

        @Override // com.bytedance.retrofit2.Converter
        public /* bridge */ /* synthetic */ Header convert(Header r1) throws IOException {
            return convert2(r1);
        }

        static {
            INSTANCE = new HeaderConverter();
        }
    }

    static final class ObjectConverter implements Converter<Object, Object> {
        static final ObjectConverter INSTANCE = null;

        @Override // com.bytedance.retrofit2.Converter
        public Object convert(Object r1) throws IOException {
            return r1;
        }

        ObjectConverter() {
        }

        static {
            INSTANCE = new ObjectConverter();
        }
    }

    static final class RequestBodyConverter implements Converter<TypedOutput, TypedOutput> {
        static final RequestBodyConverter INSTANCE = null;

        /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
        public TypedOutput convert2(TypedOutput r1) {
            return r1;
        }

        RequestBodyConverter() {
        }

        @Override // com.bytedance.retrofit2.Converter
        public /* bridge */ /* synthetic */ TypedOutput convert(TypedOutput r1) throws IOException {
            return convert2(r1);
        }

        static {
            INSTANCE = new RequestBodyConverter();
        }
    }

    static final class StreamingResponseBodyConverter implements Converter<TypedInput, TypedInput> {
        static final StreamingResponseBodyConverter INSTANCE = null;

        /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
        public TypedInput convert2(TypedInput r1) {
            return r1;
        }

        StreamingResponseBodyConverter() {
        }

        @Override // com.bytedance.retrofit2.Converter
        public /* bridge */ /* synthetic */ TypedInput convert(TypedInput r1) throws IOException {
            return convert2(r1);
        }

        static {
            INSTANCE = new StreamingResponseBodyConverter();
        }
    }

    static final class StringConverter implements Converter<String, String> {
        static final StringConverter INSTANCE = null;

        /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
        public String convert2(String r1) throws IOException {
            return r1;
        }

        StringConverter() {
        }

        @Override // com.bytedance.retrofit2.Converter
        public /* bridge */ /* synthetic */ String convert(String r1) throws IOException {
            return convert2(r1);
        }

        static {
            INSTANCE = new StringConverter();
        }
    }

    static final class StringResponseBodyConverter implements Converter<TypedInput, String> {
        static final StringResponseBodyConverter INSTANCE = null;

        StringResponseBodyConverter() {
        }

        @Override // com.bytedance.retrofit2.Converter
        public /* bridge */ /* synthetic */ String convert(TypedInput r1) throws IOException {
            return convert2(r1);
        }

        static {
            INSTANCE = new StringResponseBodyConverter();
        }

        /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
        public String convert2(TypedInput r2) throws IOException {
            if ((r2 instanceof TypedByteArray) == false) goto L9;
            String r0 = "UTF-8";
            if (r2.mimeType() == null) goto L8;
            r0 = MimeUtil.parseCharset(r2.mimeType(), "UTF-8");
        L8:
            return new String(((TypedByteArray) r2).getBytes(), r0);
        L9:
            return null;
        }
    }

    static final class ToStringConverter implements Converter<Object, String> {
        static final ToStringConverter INSTANCE = null;

        ToStringConverter() {
        }

        @Override // com.bytedance.retrofit2.Converter
        public /* bridge */ /* synthetic */ String convert(Object r1) throws IOException {
            return convert2(r1);
        }

        static {
            INSTANCE = new ToStringConverter();
        }

        @Override // com.bytedance.retrofit2.Converter
        /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
        public String convert2(Object r1) {
            return r1.toString();
        }
    }

    static final class UnitResponseBodyConverter implements Converter<TypedInput, Unit> {
        static final UnitResponseBodyConverter INSTANCE = null;

        UnitResponseBodyConverter() {
        }

        @Override // com.bytedance.retrofit2.Converter
        public /* bridge */ /* synthetic */ Unit convert(TypedInput r1) throws IOException {
            return convert2(r1);
        }

        static {
            INSTANCE = new UnitResponseBodyConverter();
        }

        /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
        public Unit convert2(TypedInput r1) {
            r1.in().close();     // Catch: IOException -> L4
        L7:
            return Unit.INSTANCE;
        L4:
            e = move-exception;
            e.printStackTrace();
            goto L7
        }
    }

    static final class VoidResponseBodyConverter implements Converter<TypedInput, Void> {
        static final VoidResponseBodyConverter INSTANCE = null;

        VoidResponseBodyConverter() {
        }

        @Override // com.bytedance.retrofit2.Converter
        public /* bridge */ /* synthetic */ Void convert(TypedInput r1) throws IOException {
            return convert2(r1);
        }

        static {
            INSTANCE = new VoidResponseBodyConverter();
        }

        /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
        public Void convert2(TypedInput r1) throws IOException {
            InputStream r0 = r1.in();
            if (r0 == null) goto L7;
            r0.close();
            return null;
        L7:
            return null;
        }
    }

    BuiltInConverters() {
        this.checkForKotlinUnit = true;
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    @Nullable
    public Converter<TypedInput, ?> responseBodyConverter(Type r1, Annotation[] r2, Retrofit r3) {
        if (r1 != TypedInput.class) goto L11;
        if (Utils.isAnnotationPresent(r2, Streaming.class) == false) goto L9;
        return StreamingResponseBodyConverter.INSTANCE;
    L9:
        return BufferingResponseBodyConverter.INSTANCE;
    L11:
        if (r1 != String.class) goto L15;
        return StringResponseBodyConverter.INSTANCE;
    L15:
        if (r1 != Void.class) goto L19;
        return VoidResponseBodyConverter.INSTANCE;
    L19:
        if (this.checkForKotlinUnit == true) goto L21;
        return null;
    L21:
        if (r1 != Unit.class) goto L30;
        return UnitResponseBodyConverter.INSTANCE;
    L24:
        this.checkForKotlinUnit = false;
        return null;
    L30:
        return null;
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    @Nullable
    public Converter<?, TypedOutput> requestBodyConverter(Type r1, Annotation[] r2, Annotation[] r3, Retrofit r4) {
        if (TypedOutput.class.isAssignableFrom(Utils.getRawType(r1)) == true) goto L5;
        return null;
    L5:
        return RequestBodyConverter.INSTANCE;
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    public Converter<?, Object> objectConverter(Type r1, Annotation[] r2, Retrofit r3) {
        if (r1 == Object.class) goto L5;
        return null;
    L5:
        return ObjectConverter.INSTANCE;
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    public Converter<?, String> stringConverter(Type r1, Annotation[] r2, Retrofit r3) {
        if (r1 == String.class) goto L5;
        return null;
    L5:
        return StringConverter.INSTANCE;
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    public Converter<?, Header> headerConverter(Type r1, Annotation[] r2, Retrofit r3) {
        if (r1 == Header.class) goto L5;
        return null;
    L5:
        return HeaderConverter.INSTANCE;
    }
}
