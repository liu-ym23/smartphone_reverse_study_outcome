package retrofit2;

import ai.j0;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import okhttp3.c0;
import okhttp3.q0;
import okhttp3.z;

/* JADX INFO: loaded from: classes3.dex */
abstract class ParameterHandler<T> {

    public static final class Body<T> extends ParameterHandler<T> {
        private final Converter<T, q0> converter;
        private final Method method;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private final int f21725p;

        public Body(Method r5, int r10, Converter<T, q0> r11) {
            this.method = r5;
            this.f21725p = r10;
            this.converter = r11;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder r5, T r10) {
            if (r10 == null) goto L11;
            r5.setBody(this.converter.convert(r10));
            return;
        L7:
            e = move-exception;
            throw Utils.parameterError(this.method, e, this.f21725p, "Unable to convert " + r10 + " to RequestBody", new Object[0]);
        L11:
            throw Utils.parameterError(this.method, this.f21725p, "Body parameter value must not be null.", new Object[0]);
        }
    }

    public static final class Field<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final String name;
        private final Converter<T, String> valueConverter;

        public Field(String r5, Converter<T, String> r10, boolean r11) {
            Objects.requireNonNull(r5, "name == null");
            this.name = r5;
            this.valueConverter = r10;
            this.encoded = r11;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder r5, T r10) throws IOException {
            if (r10 != null) goto L4;
            return;
        L4:
            String r11 = this.valueConverter.convert(r10);
            if (r11 != null) goto L7;
            return;
        L7:
            r5.addFormField(this.name, r11, this.encoded);
        }
    }

    public static final class FieldMap<T> extends ParameterHandler<Map<String, T>> {
        private final boolean encoded;
        private final Method method;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private final int f21726p;
        private final Converter<T, String> valueConverter;

        public FieldMap(Method r5, int r10, Converter<T, String> r11, boolean r12) {
            this.method = r5;
            this.f21726p = r10;
            this.valueConverter = r11;
            this.encoded = r12;
        }

        @Override // retrofit2.ParameterHandler
        public /* bridge */ /* synthetic */ void apply(RequestBuilder r5, Object r10) throws IOException {
            apply(r5, (Map) r10);
        }

        public void apply(RequestBuilder r10, Map<String, T> r11) throws IOException {
            if (r11 == null) goto L22;
            Iterator<Map.Entry<String, T>> r12 = r11.entrySet().iterator();
        L6:
            if (r12.hasNext() == false) goto L20;
            Map.Entry<String, T> r5 = r12.next();
            String r13 = r5.getKey();
            if (r13 == null) goto L19;
            T r14 = r5.getValue();
            if (r14 == null) goto L17;
            String r15 = this.valueConverter.convert(r14);
            if (r15 == null) goto L15;
            r10.addFormField(r13, r15, this.encoded);
            goto L6
        L15:
            throw Utils.parameterError(this.method, this.f21726p, "Field map value '" + r14 + "' converted to null by " + this.valueConverter.getClass().getName() + " for key '" + r13 + "'.", new Object[0]);
        L17:
            throw Utils.parameterError(this.method, this.f21726p, j0.k("Field map contained null value for key '", r13, "'."), new Object[0]);
        L19:
            throw Utils.parameterError(this.method, this.f21726p, "Field map contained null key.", new Object[0]);
        L20:
            return;
        L22:
            throw Utils.parameterError(this.method, this.f21726p, "Field map was null.", new Object[0]);
        }
    }

    public static final class Header<T> extends ParameterHandler<T> {
        private final String name;
        private final Converter<T, String> valueConverter;

        public Header(String r5, Converter<T, String> r10) {
            Objects.requireNonNull(r5, "name == null");
            this.name = r5;
            this.valueConverter = r10;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder r5, T r10) throws IOException {
            if (r10 != null) goto L4;
            return;
        L4:
            String r11 = this.valueConverter.convert(r10);
            if (r11 != null) goto L7;
            return;
        L7:
            r5.addHeader(this.name, r11);
        }
    }

    public static final class HeaderMap<T> extends ParameterHandler<Map<String, T>> {
        private final Method method;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private final int f21727p;
        private final Converter<T, String> valueConverter;

        public HeaderMap(Method r5, int r10, Converter<T, String> r11) {
            this.method = r5;
            this.f21727p = r10;
            this.valueConverter = r11;
        }

        @Override // retrofit2.ParameterHandler
        public /* bridge */ /* synthetic */ void apply(RequestBuilder r5, Object r10) throws IOException {
            apply(r5, (Map) r10);
        }

        public void apply(RequestBuilder r5, Map<String, T> r10) throws IOException {
            if (r10 == null) goto L18;
            Iterator<Map.Entry<String, T>> r11 = r10.entrySet().iterator();
        L6:
            if (r11.hasNext() == false) goto L16;
            Map.Entry<String, T> r12 = r11.next();
            String r13 = r12.getKey();
            if (r13 == null) goto L15;
            T r14 = r12.getValue();
            if (r14 == null) goto L13;
            r5.addHeader(r13, this.valueConverter.convert(r14));
            goto L6
        L13:
            throw Utils.parameterError(this.method, this.f21727p, j0.k("Header map contained null value for key '", r13, "'."), new Object[0]);
        L15:
            throw Utils.parameterError(this.method, this.f21727p, "Header map contained null key.", new Object[0]);
        L16:
            return;
        L18:
            throw Utils.parameterError(this.method, this.f21727p, "Header map was null.", new Object[0]);
        }
    }

    public static final class Headers extends ParameterHandler<c0> {
        private final Method method;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private final int f21728p;

        public Headers(Method r5, int r10) {
            this.method = r5;
            this.f21728p = r10;
        }

        @Override // retrofit2.ParameterHandler
        public /* bridge */ /* synthetic */ void apply(RequestBuilder r5, c0 r10) throws IOException {
            apply2(r5, r10);
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        public void apply2(RequestBuilder r5, c0 r10) {
            if (r10 == null) goto L6;
            r5.addHeaders(r10);
            return;
        L6:
            throw Utils.parameterError(this.method, this.f21728p, "Headers parameter must not be null.", new Object[0]);
        }
    }

    public static final class Part<T> extends ParameterHandler<T> {
        private final Converter<T, q0> converter;
        private final c0 headers;
        private final Method method;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private final int f21729p;

        public Part(Method r5, int r10, c0 r11, Converter<T, q0> r12) {
            this.method = r5;
            this.f21729p = r10;
            this.headers = r11;
            this.converter = r12;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder r5, T r10) {
            if (r10 != null) goto L10;
            return;
        L10:
            r5.addPart(this.headers, this.converter.convert(r10));
            return;
        L7:
            e = move-exception;
            throw Utils.parameterError(this.method, this.f21729p, "Unable to convert " + r10 + " to RequestBody", new Object[]{e});
        }
    }

    public static final class PartMap<T> extends ParameterHandler<Map<String, T>> {
        private final Method method;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private final int f21730p;
        private final String transferEncoding;
        private final Converter<T, q0> valueConverter;

        public PartMap(Method r5, int r10, Converter<T, q0> r11, String r12) {
            this.method = r5;
            this.f21730p = r10;
            this.valueConverter = r11;
            this.transferEncoding = r12;
        }

        @Override // retrofit2.ParameterHandler
        public /* bridge */ /* synthetic */ void apply(RequestBuilder r5, Object r10) throws IOException {
            apply(r5, (Map) r10);
        }

        public void apply(RequestBuilder r10, Map<String, T> r11) throws IOException {
            if (r11 == null) goto L18;
            Iterator<Map.Entry<String, T>> r12 = r11.entrySet().iterator();
        L6:
            if (r12.hasNext() == false) goto L16;
            Map.Entry<String, T> r5 = r12.next();
            String r13 = r5.getKey();
            if (r13 == null) goto L15;
            T r14 = r5.getValue();
            if (r14 == null) goto L13;
            r10.addPart(z.h(new String[]{"Content-Disposition", j0.k("form-data; name=\"", r13, "\""), "Content-Transfer-Encoding", this.transferEncoding}), this.valueConverter.convert(r14));
            goto L6
        L13:
            throw Utils.parameterError(this.method, this.f21730p, j0.k("Part map contained null value for key '", r13, "'."), new Object[0]);
        L15:
            throw Utils.parameterError(this.method, this.f21730p, "Part map contained null key.", new Object[0]);
        L16:
            return;
        L18:
            throw Utils.parameterError(this.method, this.f21730p, "Part map was null.", new Object[0]);
        }
    }

    public static final class Path<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final Method method;
        private final String name;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private final int f21731p;
        private final Converter<T, String> valueConverter;

        public Path(Method r5, int r10, String r11, Converter<T, String> r12, boolean r13) {
            this.method = r5;
            this.f21731p = r10;
            Objects.requireNonNull(r11, "name == null");
            this.name = r11;
            this.valueConverter = r12;
            this.encoded = r13;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder r5, T r10) throws IOException {
            if (r10 == null) goto L6;
            r5.addPathParam(this.name, this.valueConverter.convert(r10), this.encoded);
            return;
        L6:
            throw Utils.parameterError(this.method, this.f21731p, j0.q(new StringBuilder("Path parameter \""), this.name, "\" value must not be null."), new Object[0]);
        }
    }

    public static final class Query<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final String name;
        private final Converter<T, String> valueConverter;

        public Query(String r5, Converter<T, String> r10, boolean r11) {
            Objects.requireNonNull(r5, "name == null");
            this.name = r5;
            this.valueConverter = r10;
            this.encoded = r11;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder r5, T r10) throws IOException {
            if (r10 != null) goto L4;
            return;
        L4:
            String r11 = this.valueConverter.convert(r10);
            if (r11 != null) goto L7;
            return;
        L7:
            r5.addQueryParam(this.name, r11, this.encoded);
        }
    }

    public static final class QueryMap<T> extends ParameterHandler<Map<String, T>> {
        private final boolean encoded;
        private final Method method;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private final int f21732p;
        private final Converter<T, String> valueConverter;

        public QueryMap(Method r5, int r10, Converter<T, String> r11, boolean r12) {
            this.method = r5;
            this.f21732p = r10;
            this.valueConverter = r11;
            this.encoded = r12;
        }

        @Override // retrofit2.ParameterHandler
        public /* bridge */ /* synthetic */ void apply(RequestBuilder r5, Object r10) throws IOException {
            apply(r5, (Map) r10);
        }

        public void apply(RequestBuilder r10, Map<String, T> r11) throws IOException {
            if (r11 == null) goto L22;
            Iterator<Map.Entry<String, T>> r12 = r11.entrySet().iterator();
        L6:
            if (r12.hasNext() == false) goto L20;
            Map.Entry<String, T> r5 = r12.next();
            String r13 = r5.getKey();
            if (r13 == null) goto L19;
            T r14 = r5.getValue();
            if (r14 == null) goto L17;
            String r15 = this.valueConverter.convert(r14);
            if (r15 == null) goto L15;
            r10.addQueryParam(r13, r15, this.encoded);
            goto L6
        L15:
            throw Utils.parameterError(this.method, this.f21732p, "Query map value '" + r14 + "' converted to null by " + this.valueConverter.getClass().getName() + " for key '" + r13 + "'.", new Object[0]);
        L17:
            throw Utils.parameterError(this.method, this.f21732p, j0.k("Query map contained null value for key '", r13, "'."), new Object[0]);
        L19:
            throw Utils.parameterError(this.method, this.f21732p, "Query map contained null key.", new Object[0]);
        L20:
            return;
        L22:
            throw Utils.parameterError(this.method, this.f21732p, "Query map was null", new Object[0]);
        }
    }

    public static final class QueryName<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final Converter<T, String> nameConverter;

        public QueryName(Converter<T, String> r5, boolean r10) {
            this.nameConverter = r5;
            this.encoded = r10;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder r5, T r10) throws IOException {
            if (r10 != null) goto L4;
            return;
        L4:
            r5.addQueryParam(this.nameConverter.convert(r10), null, this.encoded);
        }
    }

    public static final class RawPart extends ParameterHandler<okhttp3.j0> {
        static final RawPart INSTANCE = null;

        static {
            INSTANCE = new RawPart();
        }

        private RawPart() {
        }

        @Override // retrofit2.ParameterHandler
        public /* bridge */ /* synthetic */ void apply(RequestBuilder r5, okhttp3.j0 r10) throws IOException {
            apply2(r5, r10);
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        public void apply2(RequestBuilder r5, okhttp3.j0 r10) {
            if (r10 == null) goto L5;
            r5.addPart(r10);
            return;
        }
    }

    public static final class RelativeUrl extends ParameterHandler<Object> {
        private final Method method;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private final int f21733p;

        public RelativeUrl(Method r5, int r10) {
            this.method = r5;
            this.f21733p = r10;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder r5, Object r10) {
            if (r10 == null) goto L6;
            r5.setRelativeUrl(r10);
            return;
        L6:
            throw Utils.parameterError(this.method, this.f21733p, "@Url parameter is null.", new Object[0]);
        }
    }

    public static final class Tag<T> extends ParameterHandler<T> {
        final Class<T> cls;

        public Tag(Class<T> r5) {
            this.cls = r5;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder r5, T r10) {
            r5.addTag(this.cls, r10);
        }
    }

    public ParameterHandler() {
    }

    public abstract void apply(RequestBuilder r5, T r10) throws IOException;

    public final ParameterHandler<Object> array() {
        return new AnonymousClass2(this);
    }

    public final ParameterHandler<Iterable<T>> iterable() {
        return new AnonymousClass1(this);
    }
}
