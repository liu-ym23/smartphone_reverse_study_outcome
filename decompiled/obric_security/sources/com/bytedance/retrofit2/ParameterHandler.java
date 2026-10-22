package com.bytedance.retrofit2;

import com.bytedance.retrofit2.http.ext.QueryParamObject;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes.dex */
abstract class ParameterHandler<T> {

    static final class AddCommonParam<T> extends ParameterHandler<T> {
        private final Converter<T, String> converter;

        AddCommonParam(Converter<T, String> r2) {
            this.converter = (Converter) Utils.checkNotNull(r2, "converter == null");
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        void apply(RequestBuilder r3, T r4) throws IOException {
            if (r4 != null) goto L9;
            return;
        L9:
            r3.setAddCommonParam(Boolean.parseBoolean(this.converter.convert(r4)));     // Catch: IOException -> L6
            return;
        L6:
            e = move-exception;
            throw new RuntimeException("Unable to convert " + r4 + " to AddCommonParam", e);
        }
    }

    static final class Body<T> extends ParameterHandler<T> {
        private final Converter<T, TypedOutput> converter;
        private final boolean isCustomMethod;
        private final java.lang.reflect.Method method;
        private final int p;

        Body(java.lang.reflect.Method r1, int r2, boolean r3, Converter<T, TypedOutput> r4) {
            this.method = r1;
            this.p = r2;
            this.isCustomMethod = r3;
            this.converter = r4;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        void apply(RequestBuilder r5, @Nullable T r6) {
            if (r6 == null) goto L5;
            r5.setBody(this.converter.convert(r6));
            return;
        L12:
            e = move-exception;
            throw Utils.parameterError(this.method, e, this.p, "Unable to convert " + r6 + " to RequestBody", new Object[0]);
        L5:
            if (this.isCustomMethod == false) goto L8;
            return;
        L8:
            throw Utils.parameterError(this.method, this.p, "Body parameter value must not be null.", new Object[0]);
        }
    }

    static final class ConverterBody extends ParameterHandler<RequestBody> {
        static final ConverterBody INSTANCE = null;

        ConverterBody() {
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        /* bridge */ /* synthetic */ void apply(RequestBuilder r1, RequestBody r2) throws IOException {
            apply2(r1, r2);
        }

        static {
            INSTANCE = new ConverterBody();
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        void apply2(RequestBuilder r1, RequestBody r2) {
            if (r2 == null) goto L6;
            r1.setBody(r2);
            r1.useRequestBody();
            return;
        L6:
            throw new IllegalArgumentException("Body parameter value must not be null.");
        }
    }

    static final class ConverterPart extends ParameterHandler<RequestBody> {
        private final Headers headers;

        @Override // com.bytedance.retrofit2.ParameterHandler
        /* bridge */ /* synthetic */ void apply(RequestBuilder r1, RequestBody r2) throws IOException {
            apply2(r1, r2);
        }

        ConverterPart(Headers r1) {
            this.headers = r1;
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        void apply2(RequestBuilder r1, RequestBody r2) {
            if (r2 != null) goto L4;
            return;
        L4:
            r1.addPart(this.headers, r2);
            r1.useRequestBody();
        }
    }

    static final class ConverterPartMap extends ParameterHandler<Map<String, RequestBody>> {
        private final String transferEncoding;

        @Override // com.bytedance.retrofit2.ParameterHandler
        /* bridge */ /* synthetic */ void apply(RequestBuilder r1, Map<String, RequestBody> r2) throws IOException {
            apply2(r1, r2);
        }

        ConverterPartMap(String r1) {
            this.transferEncoding = r1;
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        void apply2(RequestBuilder r6, Map<String, RequestBody> r7) throws IOException {
            if (r7 == null) goto L18;
            Iterator<Map.Entry<String, RequestBody>> r8 = r7.entrySet().iterator();
        L5:
            if (r8.hasNext() == false) goto L15;
            Map.Entry<String, RequestBody> r0 = r8.next();
            String r1 = r0.getKey();
            if (r1 == null) goto L14;
            RequestBody r2 = r0.getValue();
            if (r2 == null) goto L12;
            r6.addPart(Headers.of(new String[]{"Content-Disposition", "form-data; name=\"" + r1 + "\"", "Content-Transfer-Encoding", this.transferEncoding}), r2);
            goto L5
        L12:
            throw new IllegalArgumentException("Part map contained null value for key '" + r1 + "'.");
        L14:
            throw new IllegalArgumentException("Part map contained null key.");
        L15:
            r6.useRequestBody();
            return;
        L18:
            throw new IllegalArgumentException("Part map was null.");
        }
    }

    static final class ConverterRawPart extends ParameterHandler<MultipartBody.Part> {
        static final ConverterRawPart INSTANCE = null;

        ConverterRawPart() {
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        /* bridge */ /* synthetic */ void apply(RequestBuilder r1, MultipartBody.Part r2) throws IOException {
            apply2(r1, r2);
        }

        static {
            INSTANCE = new ConverterRawPart();
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        void apply2(RequestBuilder r1, MultipartBody.Part r2) throws IOException {
            if (r2 == null) goto L4;
            r1.addPart(r2);
        L4:
            r1.useRequestBody();
        }
    }

    static final class ExtraInfo<T> extends ParameterHandler<T> {
        private final Converter<T, Object> converter;

        ExtraInfo(Converter<T, Object> r2) {
            this.converter = (Converter) Utils.checkNotNull(r2, "converter == null");
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        void apply(RequestBuilder r3, T r4) throws IOException {
            if (r4 != null) goto L9;
            return;
        L9:
            r3.setExtraInfo(this.converter.convert(r4));     // Catch: IOException -> L6
            return;
        L6:
            e = move-exception;
            throw new RuntimeException("Unable to convert " + r4 + " to ExtraInfo", e);
        }
    }

    static final class Field<T> extends ParameterHandler<T> {
        private final boolean encode;
        private final String name;
        private final Converter<T, String> valueConverter;

        Field(String r2, Converter<T, String> r3, boolean r4) {
            this.name = (String) Utils.checkNotNull(r2, "name == null");
            this.valueConverter = r3;
            this.encode = r4;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        void apply(RequestBuilder r2, @Nullable T r3) throws IOException {
            if (r3 != null) goto L4;
            return;
        L4:
            String r4 = this.valueConverter.convert(r3);
            if (r4 != null) goto L7;
            return;
        L7:
            r2.addFormField(this.name, r4, this.encode);
        }
    }

    static final class FieldMap<T> extends ParameterHandler<Map<String, T>> {
        private final boolean encode;
        private final java.lang.reflect.Method method;
        private final int p;
        private final Converter<T, String> valueConverter;

        @Override // com.bytedance.retrofit2.ParameterHandler
        /* bridge */ /* synthetic */ void apply(RequestBuilder r1, @Nullable Object r2) throws IOException {
            apply(r1, (Map) r2);
        }

        FieldMap(java.lang.reflect.Method r1, int r2, Converter<T, String> r3, boolean r4) {
            this.method = r1;
            this.p = r2;
            this.valueConverter = r3;
            this.encode = r4;
        }

        void apply(RequestBuilder r7, @Nullable Map<String, T> r8) throws IOException {
            if (r8 == null) goto L22;
            Iterator<Map.Entry<String, T>> r9 = r8.entrySet().iterator();
        L6:
            if (r9.hasNext() == false) goto L20;
            Map.Entry<String, T> r1 = r9.next();
            String r2 = r1.getKey();
            if (r2 == null) goto L19;
            T r3 = r1.getValue();
            if (r3 == null) goto L17;
            String r4 = this.valueConverter.convert(r3);
            if (r4 == null) goto L15;
            r7.addFormField(r2, r4, this.encode);
            goto L6
        L15:
            throw Utils.parameterError(this.method, this.p, "Field map value '" + r3 + "' converted to null by " + this.valueConverter.getClass().getName() + " for key '" + r2 + "'.", new Object[0]);
        L17:
            throw Utils.parameterError(this.method, this.p, "Field map contained null value for key '" + r2 + "'.", new Object[0]);
        L19:
            throw Utils.parameterError(this.method, this.p, "Field map contained null key.", new Object[0]);
        L20:
            return;
        L22:
            throw Utils.parameterError(this.method, this.p, "Field map was null.", new Object[0]);
        }
    }

    static final class Header<T> extends ParameterHandler<T> {
        private final String name;
        private final Converter<T, String> valueConverter;

        Header(String r2, Converter<T, String> r3) {
            this.name = (String) Utils.checkNotNull(r2, "name == null");
            this.valueConverter = r3;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        void apply(RequestBuilder r2, @Nullable T r3) throws IOException {
            if (r3 != null) goto L4;
            return;
        L4:
            String r4 = this.valueConverter.convert(r3);
            if (r4 != null) goto L7;
            return;
        L7:
            r2.addHeader(this.name, r4);
        }
    }

    static final class HeaderList<T> extends ParameterHandler<List<T>> {
        private final Converter<T, com.bytedance.retrofit2.client.Header> valueConverter;

        @Override // com.bytedance.retrofit2.ParameterHandler
        /* bridge */ /* synthetic */ void apply(RequestBuilder r1, Object r2) throws IOException {
            apply(r1, (List) r2);
        }

        HeaderList(Converter<T, com.bytedance.retrofit2.client.Header> r1) {
            this.valueConverter = r1;
        }

        void apply(RequestBuilder r3, List<T> r4) throws IOException {
            if (r4 != null) goto L4;
            return;
        L4:
            Iterator<T> r5 = r4.iterator();
        L6:
            if (r5.hasNext() == false) goto L8;
            T r0 = r5.next();
            com.bytedance.retrofit2.client.Header r1 = this.valueConverter.convert(r0);
            r3.addHeader(r1.getName(), r1.getValue());
            goto L6
        }
    }

    static final class HeaderMap<T> extends ParameterHandler<Map<String, T>> {
        private final java.lang.reflect.Method method;
        private final int p;
        private final Converter<T, String> valueConverter;

        @Override // com.bytedance.retrofit2.ParameterHandler
        /* bridge */ /* synthetic */ void apply(RequestBuilder r1, @Nullable Object r2) throws IOException {
            apply(r1, (Map) r2);
        }

        HeaderMap(java.lang.reflect.Method r1, int r2, Converter<T, String> r3) {
            this.method = r1;
            this.p = r2;
            this.valueConverter = r3;
        }

        void apply(RequestBuilder r5, @Nullable Map<String, T> r6) throws IOException {
            if (r6 == null) goto L18;
            Iterator<Map.Entry<String, T>> r7 = r6.entrySet().iterator();
        L6:
            if (r7.hasNext() == false) goto L16;
            Map.Entry<String, T> r1 = r7.next();
            String r2 = r1.getKey();
            if (r2 == null) goto L15;
            T r3 = r1.getValue();
            if (r3 == null) goto L13;
            r5.addHeader(r2, this.valueConverter.convert(r3));
            goto L6
        L13:
            throw Utils.parameterError(this.method, this.p, "Header map contained null value for key '" + r2 + "'.", new Object[0]);
        L15:
            throw Utils.parameterError(this.method, this.p, "Header map contained null key.", new Object[0]);
        L16:
            return;
        L18:
            throw Utils.parameterError(this.method, this.p, "Header map was null.", new Object[0]);
        }
    }

    static final class MaxLength<T> extends ParameterHandler<T> {
        private final Converter<T, String> converter;

        MaxLength(Converter<T, String> r2) {
            this.converter = (Converter) Utils.checkNotNull(r2, "converter == null");
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        void apply(RequestBuilder r3, T r4) throws IOException {
            if (r4 != null) goto L9;
            return;
        L9:
            r3.setMaxLength(Integer.parseInt(this.converter.convert(r4)));     // Catch: IOException -> L6
            return;
        L6:
            e = move-exception;
            throw new RuntimeException("Unable to convert " + r4 + " to MaxLength", e);
        }
    }

    static final class Method<T> extends ParameterHandler<T> {
        private final String name;
        private final Converter<T, String> valueConverter;

        Method(String r2, Converter<T, String> r3) {
            this.name = (String) Utils.checkNotNull(r2, "name == null");
            this.valueConverter = r3;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        void apply(RequestBuilder r2, T r3) throws IOException {
            if (r3 == null) goto L6;
            r2.setMethod(this.name, this.valueConverter.convert(r3));
            return;
        L6:
            throw new IllegalArgumentException("Method parameter \"" + this.name + "\" value must not be null.");
        }
    }

    static final class Part<T> extends ParameterHandler<T> {
        private final Converter<T, TypedOutput> converter;
        private final java.lang.reflect.Method method;
        private final String name;
        private final int p;

        Part(java.lang.reflect.Method r1, int r2, String r3, Converter<T, TypedOutput> r4) {
            this.method = r1;
            this.p = r2;
            this.name = r3;
            this.converter = r4;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        void apply(RequestBuilder r4, T r5) {
            if (r5 != null) goto L10;
            return;
        L10:
            r4.addPart(this.name, this.converter.convert(r5));
            return;
        L7:
            e = move-exception;
            throw Utils.parameterError(this.method, this.p, "Unable to convert " + r5 + " to RequestBody", new Object[]{e});
        }
    }

    static final class PartMap<T> extends ParameterHandler<Map<String, T>> {
        private final java.lang.reflect.Method method;
        private final int p;
        private final String transferEncoding;
        private final Converter<T, TypedOutput> valueConverter;

        @Override // com.bytedance.retrofit2.ParameterHandler
        /* bridge */ /* synthetic */ void apply(RequestBuilder r1, @Nullable Object r2) throws IOException {
            apply(r1, (Map) r2);
        }

        PartMap(java.lang.reflect.Method r1, int r2, Converter<T, TypedOutput> r3, String r4) {
            this.method = r1;
            this.p = r2;
            this.valueConverter = r3;
            this.transferEncoding = r4;
        }

        void apply(RequestBuilder r6, @Nullable Map<String, T> r7) throws IOException {
            if (r7 == null) goto L18;
            Iterator<Map.Entry<String, T>> r8 = r7.entrySet().iterator();
        L6:
            if (r8.hasNext() == false) goto L16;
            Map.Entry<String, T> r1 = r8.next();
            String r2 = r1.getKey();
            if (r2 == null) goto L15;
            T r3 = r1.getValue();
            if (r3 == null) goto L13;
            r6.addPart(r2, this.transferEncoding, this.valueConverter.convert(r3));
            goto L6
        L13:
            throw Utils.parameterError(this.method, this.p, "Part map contained null value for key '" + r2 + "'.", new Object[0]);
        L15:
            throw Utils.parameterError(this.method, this.p, "Part map contained null key.", new Object[0]);
        L16:
            return;
        L18:
            throw Utils.parameterError(this.method, this.p, "Part map was null.", new Object[0]);
        }
    }

    static final class Path<T> extends ParameterHandler<T> {
        private final boolean encode;
        private final java.lang.reflect.Method method;
        private final String name;
        private final int p;
        private final Converter<T, String> valueConverter;

        Path(java.lang.reflect.Method r1, int r2, String r3, Converter<T, String> r4, boolean r5) {
            this.method = r1;
            this.p = r2;
            this.name = (String) Utils.checkNotNull(r3, "name == null");
            this.valueConverter = r4;
            this.encode = r5;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        void apply(RequestBuilder r3, @Nullable T r4) throws IOException {
            if (r4 == null) goto L6;
            r3.addPathParam(this.name, this.valueConverter.convert(r4), this.encode);
            return;
        L6:
            throw Utils.parameterError(this.method, this.p, "Path parameter \"" + this.name + "\" value must not be null.", new Object[0]);
        }
    }

    static final class Query<T> extends ParameterHandler<T> {
        private final boolean encode;
        private final String name;
        private final Converter<T, String> valueConverter;

        Query(String r2, Converter<T, String> r3, boolean r4) {
            this.name = (String) Utils.checkNotNull(r2, "name == null");
            this.valueConverter = r3;
            this.encode = r4;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        void apply(RequestBuilder r2, T r3) throws IOException {
            if (r3 != null) goto L4;
            return;
        L4:
            String r4 = this.valueConverter.convert(r3);
            if (r4 != null) goto L7;
            return;
        L7:
            r2.addQueryParam(this.name, r4, this.encode);
        }
    }

    static final class QueryMap<T> extends ParameterHandler<Map<String, T>> {
        private final boolean encode;
        private final java.lang.reflect.Method method;
        private final int p;
        private final Converter<T, String> valueConverter;

        @Override // com.bytedance.retrofit2.ParameterHandler
        /* bridge */ /* synthetic */ void apply(RequestBuilder r1, @Nullable Object r2) throws IOException {
            apply(r1, (Map) r2);
        }

        QueryMap(java.lang.reflect.Method r1, int r2, Converter<T, String> r3, boolean r4) {
            this.method = r1;
            this.p = r2;
            this.valueConverter = r3;
            this.encode = r4;
        }

        void apply(RequestBuilder r6, @Nullable Map<String, T> r7) throws IOException {
            if (r7 != null) goto L4;
            return;
        L4:
            Iterator<Map.Entry<String, T>> r8 = r7.entrySet().iterator();
        L6:
            if (r8.hasNext() == false) goto L19;
            Map.Entry<String, T> r0 = r8.next();
            String r1 = r0.getKey();
            if (r1 == null) goto L18;
            T r2 = r0.getValue();
            if (r2 == null) goto L6;
            String r3 = this.valueConverter.convert(r2);
            if (r3 == null) goto L16;
            r6.addQueryParam(r1, r3, this.encode);
            goto L6
        L16:
            throw Utils.parameterError(this.method, this.p, "Query map value '" + r2 + "' converted to null by " + this.valueConverter.getClass().getName() + " for key '" + r1 + "'.", new Object[0]);
        L18:
            throw Utils.parameterError(this.method, this.p, "Query map contained null key.", new Object[0]);
        }
    }

    static final class QueryName<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final Converter<T, String> nameConverter;

        QueryName(Converter<T, String> r1, boolean r2) {
            this.nameConverter = r1;
            this.encoded = r2;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        void apply(RequestBuilder r2, @Nullable T r3) throws IOException {
            if (r3 != null) goto L4;
            return;
        L4:
            r2.addQueryParam(this.nameConverter.convert(r3), null, this.encoded);
        }
    }

    static final class QueryObject<T> extends ParameterHandler<T> {
        QueryObject() {
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        void apply(RequestBuilder r2, T r3) throws IOException {
            if (r3 != null) goto L5;
            return;
        L5:
            if ((r3 instanceof QueryParamObject) == false) goto L9;
            r2.setQueryObjectParams(((QueryParamObject) r3).toQuery());
            return;
        L9:
            throw new RuntimeException("wrong type:" + r3.getClass() + ",not implement QueryParamObject");
        }
    }

    static final class RelativeUrl extends ParameterHandler<Object> {
        private final java.lang.reflect.Method method;
        private final int p;

        RelativeUrl(java.lang.reflect.Method r1, int r2) {
            this.method = r1;
            this.p = r2;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        void apply(RequestBuilder r1, @Nullable Object r2) {
            r1.setRelativeUrl(r2);
        }
    }

    static final class Tag<T> extends ParameterHandler<T> {
        final Class<T> cls;

        Tag(Class<T> r1) {
            this.cls = r1;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        void apply(RequestBuilder r1, @Nullable T r2) {
            r1.addTag(this.cls, r2);
        }
    }

    abstract void apply(RequestBuilder r1, @Nullable T r2) throws IOException;

    ParameterHandler() {
    }

    final ParameterHandler<Iterable<T>> iterable() {
        return new AnonymousClass1(this);
    }

    final ParameterHandler<Object> array() {
        return new AnonymousClass2(this);
    }
}
