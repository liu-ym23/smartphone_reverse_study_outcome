package retrofit2;

import ai.j0;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.coroutines.Continuation;
import okhttp3.Request;
import okhttp3.b0;
import okhttp3.c0;
import okhttp3.e0;
import okhttp3.h0;
import okhttp3.n0;
import okhttp3.z;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.OPTIONS;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.QueryName;
import retrofit2.http.Tag;
import retrofit2.http.Url;

/* JADX INFO: loaded from: classes3.dex */
final class RequestFactory {
    private final e0 baseUrl;
    private final h0 contentType;
    private final boolean hasBody;
    private final c0 headers;
    final String httpMethod;
    private final boolean isFormEncoded;
    final boolean isKotlinSuspendFunction;
    private final boolean isMultipart;
    private final Method method;
    private final ParameterHandler<?>[] parameterHandlers;
    private final String relativeUrl;

    public static final class Builder {
        private static final String PARAM = "[a-zA-Z][a-zA-Z0-9_-]*";
        private static final Pattern PARAM_NAME_REGEX = null;
        private static final Pattern PARAM_URL_REGEX = null;
        h0 contentType;
        boolean gotBody;
        boolean gotField;
        boolean gotPart;
        boolean gotPath;
        boolean gotQuery;
        boolean gotQueryMap;
        boolean gotQueryName;
        boolean gotUrl;
        boolean hasBody;
        c0 headers;
        String httpMethod;
        boolean isFormEncoded;
        boolean isKotlinSuspendFunction;
        boolean isMultipart;
        final Method method;
        final Annotation[] methodAnnotations;
        final Annotation[][] parameterAnnotationsArray;
        ParameterHandler<?>[] parameterHandlers;
        final Type[] parameterTypes;
        String relativeUrl;
        Set<String> relativeUrlParamNames;
        final Retrofit retrofit;

        static {
            PARAM_URL_REGEX = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
            PARAM_NAME_REGEX = Pattern.compile(PARAM);
        }

        public Builder(Retrofit r5, Method r10) {
            this.retrofit = r5;
            this.method = r10;
            this.methodAnnotations = r10.getAnnotations();
            this.parameterTypes = r10.getGenericParameterTypes();
            this.parameterAnnotationsArray = r10.getParameterAnnotations();
        }

        private static Class<?> boxIfPrimitive(Class<?> r5) {
            if (Boolean.TYPE != r5) goto L7;
            return Boolean.class;
        L7:
            if (Byte.TYPE != r5) goto L11;
            return Byte.class;
        L11:
            if (Character.TYPE != r5) goto L15;
            return Character.class;
        L15:
            if (Double.TYPE != r5) goto L19;
            return Double.class;
        L19:
            if (Float.TYPE != r5) goto L23;
            return Float.class;
        L23:
            if (Integer.TYPE != r5) goto L27;
            return Integer.class;
        L27:
            if (Long.TYPE != r5) goto L31;
            return Long.class;
        L31:
            if (Short.TYPE != r5) goto L34;
            return Short.class;
        L34:
            return r5;
        }

        private c0 parseHeaders(String[] r10) {
            b0 r5 = new b0();
            int r11 = r10.length;
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L21;
            String r13 = r10[r12];
            int r14 = r13.indexOf(58);
            if (r14 == (-1)) goto L19;
            if (r14 == 0) goto L19;
            if (r14 == (r13.length() - 1)) goto L19;
            String r15 = r13.substring(0, r14);
            String r16 = r13.substring(r14 + 1).trim();
            if ("Content-Type".equalsIgnoreCase(r15) == true) goto L22;
            r5.a(r15, r16);
        L17:
            r12 = r12 + 1;
            goto L3
        L22:
            Pattern r17 = h0.e;     // Catch: IllegalArgumentException -> L13
            this.contentType = z.f(r16);     // Catch: IllegalArgumentException -> L13
        L13:
            e = move-exception;
            throw Utils.methodError(this.method, e, "Malformed content type: %s", new Object[]{r16});
        L19:
            throw Utils.methodError(this.method, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", new Object[]{r13});
        L21:
            return r5.d();
        }

        private void parseHttpMethodAndPath(String r5, String r10, boolean r11) {
            String r12 = this.httpMethod;
            if (r12 != null) goto L19;
            this.httpMethod = r5;
            this.hasBody = r11;
            if (r10.isEmpty() == false) goto L7;
            return;
        L7:
            int r13 = r10.indexOf(63);
            if (r13 != (-1)) goto L10;
        L16:
            this.relativeUrl = r10;
            this.relativeUrlParamNames = parsePathParameters(r10);
            return;
        L10:
            if (r13 >= (r10.length() - 1)) goto L16;
            String r14 = r10.substring(r13 + 1);
            if (PARAM_URL_REGEX.matcher(r14).find() == false) goto L16;
            throw Utils.methodError(this.method, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", new Object[]{r14});
        L19:
            throw Utils.methodError(this.method, "Only one HTTP method is allowed. Found: %s and %s.", new Object[]{r12, r5});
        }

        private void parseMethodAnnotation(Annotation r5) {
            if ((r5 instanceof DELETE) == false) goto L6;
            parseHttpMethodAndPath("DELETE", ((DELETE) r5).value(), false);
            return;
        L6:
            if ((r5 instanceof GET) == false) goto L9;
            parseHttpMethodAndPath("GET", ((GET) r5).value(), false);
            return;
        L9:
            if ((r5 instanceof HEAD) == false) goto L12;
            parseHttpMethodAndPath("HEAD", ((HEAD) r5).value(), false);
            return;
        L12:
            if ((r5 instanceof PATCH) == false) goto L15;
            parseHttpMethodAndPath("PATCH", ((PATCH) r5).value(), true);
            return;
        L15:
            if ((r5 instanceof POST) == false) goto L18;
            parseHttpMethodAndPath("POST", ((POST) r5).value(), true);
            return;
        L18:
            if ((r5 instanceof PUT) == false) goto L21;
            parseHttpMethodAndPath("PUT", ((PUT) r5).value(), true);
            return;
        L21:
            if ((r5 instanceof OPTIONS) == false) goto L24;
            parseHttpMethodAndPath("OPTIONS", ((OPTIONS) r5).value(), false);
            return;
        L24:
            if ((r5 instanceof HTTP) == false) goto L27;
            HTTP r10 = (HTTP) r5;
            parseHttpMethodAndPath(r10.method(), r10.path(), r10.hasBody());
            return;
        L27:
            if ((r5 instanceof Headers) == false) goto L34;
            String[] r11 = ((Headers) r5).value();
            if (r11.length == 0) goto L32;
            this.headers = parseHeaders(r11);
            return;
        L32:
            throw Utils.methodError(this.method, "@Headers annotation is empty.", new Object[0]);
        L34:
            if ((r5 instanceof Multipart) == false) goto L41;
            if (this.isFormEncoded == true) goto L39;
            this.isMultipart = true;
            return;
        L39:
            throw Utils.methodError(this.method, "Only one encoding annotation is allowed.", new Object[0]);
        L41:
            if ((r5 instanceof FormUrlEncoded) == true) goto L43;
            return;
        L43:
            if (this.isMultipart == true) goto L46;
            this.isFormEncoded = true;
            return;
        L46:
            throw Utils.methodError(this.method, "Only one encoding annotation is allowed.", new Object[0]);
        }

        private ParameterHandler<?> parseParameter(int r10, Type r11, Annotation[] r12, boolean r13) {
            if (r12 == null) goto L14;
            int r5 = r12.length;
            int r14 = 0;
            ParameterHandler<?> r15 = null;
        L5:
            if (r14 >= r5) goto L15;
            ParameterHandler<?> r16 = parseParameterAnnotation(r10, r11, r12, r12[r14]);
            if (r16 == null) goto L11;
            if (r15 != null) goto L13;
            r15 = r16;
            goto L11
        L13:
            throw Utils.parameterError(this.method, r10, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
        L11:
            r14 = r14 + 1;
        L15:
            if (r15 != null) goto L23;
            if (r13 == false) goto L22;
            if (Utils.getRawType(r11) != Continuation.class) goto L22;
            this.isKotlinSuspendFunction = true;     // Catch: NoClassDefFoundError -> L24
            return null;
        L22:
            throw Utils.parameterError(this.method, r10, "No Retrofit annotation found.", new Object[0]);
        L23:
            return r15;
        L14:
            r15 = null;
            goto L15
        }

        private ParameterHandler<?> parseParameterAnnotation(int r11, Type r12, Annotation[] r13, Annotation r14) {
            if ((r14 instanceof Url) == false) goto L43;
            validateResolvableType(r11, r12);
            if (this.gotUrl == true) goto L41;
            if (this.gotPath == true) goto L39;
            if (this.gotQuery == true) goto L37;
            if (this.gotQueryName == true) goto L35;
            if (this.gotQueryMap == true) goto L33;
            if (this.relativeUrl != null) goto L31;
            this.gotUrl = true;
            if (r12 == e0.class) goto L29;
            if (r12 == String.class) goto L29;
            if (r12 == URI.class) goto L29;
            if ((r12 instanceof Class) == false) goto L27;
            if ("android.net.Uri".equals(((Class) r12).getName()) == true) goto L29;
        L27:
            throw Utils.parameterError(this.method, r11, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
        L29:
            return new ParameterHandler.RelativeUrl(this.method, r11);
        L31:
            throw Utils.parameterError(this.method, r11, "@Url cannot be used with @%s URL", new Object[]{this.httpMethod});
        L33:
            throw Utils.parameterError(this.method, r11, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
        L35:
            throw Utils.parameterError(this.method, r11, "A @Url parameter must not come after a @QueryName.", new Object[0]);
        L37:
            throw Utils.parameterError(this.method, r11, "A @Url parameter must not come after a @Query.", new Object[0]);
        L39:
            throw Utils.parameterError(this.method, r11, "@Path parameters may not be used with @Url.", new Object[0]);
        L41:
            throw Utils.parameterError(this.method, r11, "Multiple @Url method annotations found.", new Object[0]);
        L43:
            if ((r14 instanceof Path) == false) goto L67;
            validateResolvableType(r11, r12);
            if (this.gotQuery == true) goto L65;
            if (this.gotQueryName == true) goto L63;
            if (this.gotQueryMap == true) goto L61;
            if (this.gotUrl == true) goto L59;
            if (this.relativeUrl == null) goto L57;
            this.gotPath = true;
            Path r15 = (Path) r14;
            String r5 = r15.value();
            validatePathName(r11, r5);
            return new ParameterHandler.Path(this.method, r11, r5, this.retrofit.stringConverter(r12, r13), r15.encoded());
        L57:
            throw Utils.parameterError(this.method, r11, "@Path can only be used with relative url on @%s", new Object[]{this.httpMethod});
        L59:
            throw Utils.parameterError(this.method, r11, "@Path parameters may not be used with @Url.", new Object[0]);
        L61:
            throw Utils.parameterError(this.method, r11, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
        L63:
            throw Utils.parameterError(this.method, r11, "A @Path parameter must not come after a @QueryName.", new Object[0]);
        L65:
            throw Utils.parameterError(this.method, r11, "A @Path parameter must not come after a @Query.", new Object[0]);
        L67:
            if ((r14 instanceof Query) == false) goto L83;
            validateResolvableType(r11, r12);
            Query r16 = (Query) r14;
            String r10 = r16.value();
            boolean r17 = r16.encoded();
            Class<?> r18 = Utils.getRawType(r12);
            this.gotQuery = true;
            if (Iterable.class.isAssignableFrom(r18) == false) goto L77;
            if ((r12 instanceof ParameterizedType) == false) goto L75;
            return new ParameterHandler.Query(r10, this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) r12), r13), r17).iterable();
        L75:
            throw Utils.parameterError(this.method, r11, r18.getSimpleName() + " must include generic type (e.g., " + r18.getSimpleName() + "<String>)", new Object[0]);
        L77:
            if (r18.isArray() == false) goto L81;
            return new ParameterHandler.Query(r10, this.retrofit.stringConverter(boxIfPrimitive(r18.getComponentType()), r13), r17).array();
        L81:
            return new ParameterHandler.Query(r10, this.retrofit.stringConverter(r12, r13), r17);
        L83:
            if ((r14 instanceof QueryName) == false) goto L99;
            validateResolvableType(r11, r12);
            boolean r19 = ((QueryName) r14).encoded();
            Class<?> r20 = Utils.getRawType(r12);
            this.gotQueryName = true;
            if (Iterable.class.isAssignableFrom(r20) == false) goto L93;
            if ((r12 instanceof ParameterizedType) == false) goto L91;
            return new ParameterHandler.QueryName(this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) r12), r13), r19).iterable();
        L91:
            throw Utils.parameterError(this.method, r11, r20.getSimpleName() + " must include generic type (e.g., " + r20.getSimpleName() + "<String>)", new Object[0]);
        L93:
            if (r20.isArray() == false) goto L97;
            return new ParameterHandler.QueryName(this.retrofit.stringConverter(boxIfPrimitive(r20.getComponentType()), r13), r19).array();
        L97:
            return new ParameterHandler.QueryName(this.retrofit.stringConverter(r12, r13), r19);
        L99:
            if ((r14 instanceof QueryMap) == false) goto L115;
            validateResolvableType(r11, r12);
            Class<?> r21 = Utils.getRawType(r12);
            this.gotQueryMap = true;
            if (Map.class.isAssignableFrom(r21) == false) goto L113;
            Type r110 = Utils.getSupertype(r12, r21, Map.class);
            if ((r110 instanceof ParameterizedType) == false) goto L111;
            ParameterizedType r111 = (ParameterizedType) r110;
            Type r22 = Utils.getParameterUpperBound(0, r111);
            if (String.class != r22) goto L109;
            return new ParameterHandler.QueryMap(this.method, r11, this.retrofit.stringConverter(Utils.getParameterUpperBound(1, r111), r13), ((QueryMap) r14).encoded());
        L109:
            throw Utils.parameterError(this.method, r11, j0.m("@QueryMap keys must be of type String: ", r22), new Object[0]);
        L111:
            throw Utils.parameterError(this.method, r11, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L113:
            throw Utils.parameterError(this.method, r11, "@QueryMap parameter type must be Map.", new Object[0]);
        L115:
            if ((r14 instanceof Header) == false) goto L131;
            validateResolvableType(r11, r12);
            String r112 = ((Header) r14).value();
            Class<?> r23 = Utils.getRawType(r12);
            if (Iterable.class.isAssignableFrom(r23) == false) goto L125;
            if ((r12 instanceof ParameterizedType) == false) goto L123;
            return new ParameterHandler.Header(r112, this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) r12), r13)).iterable();
        L123:
            throw Utils.parameterError(this.method, r11, r23.getSimpleName() + " must include generic type (e.g., " + r23.getSimpleName() + "<String>)", new Object[0]);
        L125:
            if (r23.isArray() == false) goto L129;
            return new ParameterHandler.Header(r112, this.retrofit.stringConverter(boxIfPrimitive(r23.getComponentType()), r13)).array();
        L129:
            return new ParameterHandler.Header(r112, this.retrofit.stringConverter(r12, r13));
        L131:
            if ((r14 instanceof HeaderMap) == false) goto L151;
            if (r12 == c0.class) goto L135;
            validateResolvableType(r11, r12);
            Class<?> r113 = Utils.getRawType(r12);
            if (Map.class.isAssignableFrom(r113) == false) goto L149;
            Type r114 = Utils.getSupertype(r12, r113, Map.class);
            if ((r114 instanceof ParameterizedType) == false) goto L147;
            ParameterizedType r115 = (ParameterizedType) r114;
            Type r116 = Utils.getParameterUpperBound(0, r115);
            if (String.class != r116) goto L145;
            return new ParameterHandler.HeaderMap(this.method, r11, this.retrofit.stringConverter(Utils.getParameterUpperBound(1, r115), r13));
        L145:
            throw Utils.parameterError(this.method, r11, j0.m("@HeaderMap keys must be of type String: ", r116), new Object[0]);
        L147:
            throw Utils.parameterError(this.method, r11, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L149:
            throw Utils.parameterError(this.method, r11, "@HeaderMap parameter type must be Map.", new Object[0]);
        L135:
            return new ParameterHandler.Headers(this.method, r11);
        L151:
            if ((r14 instanceof Field) == false) goto L171;
            validateResolvableType(r11, r12);
            if (this.isFormEncoded == false) goto L169;
            Field r117 = (Field) r14;
            String r24 = r117.value();
            boolean r118 = r117.encoded();
            this.gotField = true;
            Class<?> r25 = Utils.getRawType(r12);
            if (Iterable.class.isAssignableFrom(r25) == false) goto L163;
            if ((r12 instanceof ParameterizedType) == false) goto L161;
            return new ParameterHandler.Field(r24, this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) r12), r13), r118).iterable();
        L161:
            throw Utils.parameterError(this.method, r11, r25.getSimpleName() + " must include generic type (e.g., " + r25.getSimpleName() + "<String>)", new Object[0]);
        L163:
            if (r25.isArray() == false) goto L167;
            return new ParameterHandler.Field(r24, this.retrofit.stringConverter(boxIfPrimitive(r25.getComponentType()), r13), r118).array();
        L167:
            return new ParameterHandler.Field(r24, this.retrofit.stringConverter(r12, r13), r118);
        L169:
            throw Utils.parameterError(this.method, r11, "@Field parameters can only be used with form encoding.", new Object[0]);
        L171:
            if ((r14 instanceof FieldMap) == false) goto L191;
            validateResolvableType(r11, r12);
            if (this.isFormEncoded == false) goto L189;
            Class<?> r26 = Utils.getRawType(r12);
            if (Map.class.isAssignableFrom(r26) == false) goto L187;
            Type r119 = Utils.getSupertype(r12, r26, Map.class);
            if ((r119 instanceof ParameterizedType) == false) goto L185;
            ParameterizedType r120 = (ParameterizedType) r119;
            Type r27 = Utils.getParameterUpperBound(0, r120);
            if (String.class != r27) goto L183;
            Converter r121 = this.retrofit.stringConverter(Utils.getParameterUpperBound(1, r120), r13);
            this.gotField = true;
            return new ParameterHandler.FieldMap(this.method, r11, r121, ((FieldMap) r14).encoded());
        L183:
            throw Utils.parameterError(this.method, r11, j0.m("@FieldMap keys must be of type String: ", r27), new Object[0]);
        L185:
            throw Utils.parameterError(this.method, r11, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L187:
            throw Utils.parameterError(this.method, r11, "@FieldMap parameter type must be Map.", new Object[0]);
        L189:
            throw Utils.parameterError(this.method, r11, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
        L191:
            if ((r14 instanceof Part) == false) goto L251;
            validateResolvableType(r11, r12);
            if (this.isMultipart == false) goto L249;
            Part r122 = (Part) r14;
            this.gotPart = true;
            String r28 = r122.value();
            Class<?> r29 = Utils.getRawType(r12);
            if (r28.isEmpty() == true) goto L197;
            c0 r123 = z.h(new String[]{"Content-Disposition", j0.k("form-data; name=\"", r28, "\""), "Content-Transfer-Encoding", r122.encoding()});
            if (Iterable.class.isAssignableFrom(r29) == false) goto L235;
            if ((r12 instanceof ParameterizedType) == false) goto L233;
            Type r124 = Utils.getParameterUpperBound(0, (ParameterizedType) r12);
            if (okhttp3.j0.class.isAssignableFrom(Utils.getRawType(r124)) == true) goto L231;
            return new ParameterHandler.Part(this.method, r11, r123, this.retrofit.requestBodyConverter(r124, r13, this.methodAnnotations)).iterable();
        L231:
            throw Utils.parameterError(this.method, r11, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
        L233:
            throw Utils.parameterError(this.method, r11, r29.getSimpleName() + " must include generic type (e.g., " + r29.getSimpleName() + "<String>)", new Object[0]);
        L235:
            if (r29.isArray() == false) goto L243;
            Class<?> r125 = boxIfPrimitive(r29.getComponentType());
            if (okhttp3.j0.class.isAssignableFrom(r125) == true) goto L241;
            return new ParameterHandler.Part(this.method, r11, r123, this.retrofit.requestBodyConverter(r125, r13, this.methodAnnotations)).array();
        L241:
            throw Utils.parameterError(this.method, r11, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
        L243:
            if (okhttp3.j0.class.isAssignableFrom(r29) == true) goto L247;
            return new ParameterHandler.Part(this.method, r11, r123, this.retrofit.requestBodyConverter(r12, r13, this.methodAnnotations));
        L247:
            throw Utils.parameterError(this.method, r11, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
        L197:
            if (Iterable.class.isAssignableFrom(r29) == false) goto L209;
            if ((r12 instanceof ParameterizedType) == false) goto L207;
            if (okhttp3.j0.class.isAssignableFrom(Utils.getRawType(Utils.getParameterUpperBound(0, (ParameterizedType) r12))) == false) goto L205;
            return ParameterHandler.RawPart.INSTANCE.iterable();
        L205:
            throw Utils.parameterError(this.method, r11, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
        L207:
            throw Utils.parameterError(this.method, r11, r29.getSimpleName() + " must include generic type (e.g., " + r29.getSimpleName() + "<String>)", new Object[0]);
        L209:
            if (r29.isArray() == false) goto L217;
            if (okhttp3.j0.class.isAssignableFrom(r29.getComponentType()) == false) goto L215;
            return ParameterHandler.RawPart.INSTANCE.array();
        L215:
            throw Utils.parameterError(this.method, r11, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
        L217:
            if (okhttp3.j0.class.isAssignableFrom(r29) == false) goto L221;
            return ParameterHandler.RawPart.INSTANCE;
        L221:
            throw Utils.parameterError(this.method, r11, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
        L249:
            throw Utils.parameterError(this.method, r11, "@Part parameters can only be used with multipart encoding.", new Object[0]);
        L251:
            if ((r14 instanceof PartMap) == false) goto L275;
            validateResolvableType(r11, r12);
            if (this.isMultipart == false) goto L273;
            this.gotPart = true;
            Class<?> r30 = Utils.getRawType(r12);
            if (Map.class.isAssignableFrom(r30) == false) goto L271;
            Type r126 = Utils.getSupertype(r12, r30, Map.class);
            if ((r126 instanceof ParameterizedType) == false) goto L269;
            ParameterizedType r127 = (ParameterizedType) r126;
            Type r31 = Utils.getParameterUpperBound(0, r127);
            if (String.class != r31) goto L267;
            Type r128 = Utils.getParameterUpperBound(1, r127);
            if (okhttp3.j0.class.isAssignableFrom(Utils.getRawType(r128)) == true) goto L265;
            return new ParameterHandler.PartMap(this.method, r11, this.retrofit.requestBodyConverter(r128, r13, this.methodAnnotations), ((PartMap) r14).encoding());
        L265:
            throw Utils.parameterError(this.method, r11, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
        L267:
            throw Utils.parameterError(this.method, r11, j0.m("@PartMap keys must be of type String: ", r31), new Object[0]);
        L269:
            throw Utils.parameterError(this.method, r11, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L271:
            throw Utils.parameterError(this.method, r11, "@PartMap parameter type must be Map.", new Object[0]);
        L273:
            throw Utils.parameterError(this.method, r11, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
        L275:
            if ((r14 instanceof Body) == false) goto L293;
            validateResolvableType(r11, r12);
            if (this.isFormEncoded == true) goto L291;
            if (this.isMultipart == true) goto L291;
            if (this.gotBody == true) goto L289;
            Converter r129 = this.retrofit.requestBodyConverter(r12, r13, this.methodAnnotations);     // Catch: RuntimeException -> L285
            this.gotBody = true;
            return new ParameterHandler.Body(this.method, r11, r129);
        L285:
            e = move-exception;
            throw Utils.parameterError(this.method, e, r11, "Unable to create @Body converter for %s", new Object[]{r12});
        L289:
            throw Utils.parameterError(this.method, r11, "Multiple @Body method annotations found.", new Object[0]);
        L291:
            throw Utils.parameterError(this.method, r11, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
        L293:
            if ((r14 instanceof Tag) == false) goto L306;
            validateResolvableType(r11, r12);
            Class<?> r130 = Utils.getRawType(r12);
            int r131 = r11 - 1;
        L295:
            if (r131 < 0) goto L305;
            ParameterHandler<?> r132 = this.parameterHandlers[r131];
            if ((r132 instanceof ParameterHandler.Tag) == false) goto L303;
            if (((ParameterHandler.Tag) r132).cls.equals(r130) == false) goto L303;
            throw Utils.parameterError(this.method, r11, "@Tag type " + r130.getName() + " is duplicate of parameter #" + (r131 + 1) + " and would always overwrite its value.", new Object[0]);
        L303:
            r131 = r131 - 1;
            goto L295
        L305:
            return new ParameterHandler.Tag(r130);
        L306:
            return null;
        }

        public static Set<String> parsePathParameters(String r5) {
            Matcher r10 = PARAM_URL_REGEX.matcher(r5);
            LinkedHashSet r11 = new LinkedHashSet();
        L4:
            if (r10.find() == false) goto L6;
            r11.add(r10.group(1));
            goto L4
        L6:
            return r11;
        }

        private void validatePathName(int r5, String r10) {
            if (PARAM_NAME_REGEX.matcher(r10).matches() == false) goto L10;
            if (this.relativeUrlParamNames.contains(r10) == false) goto L8;
            return;
        L8:
            throw Utils.parameterError(this.method, r5, "URL \"%s\" does not contain \"{%s}\".", new Object[]{this.relativeUrl, r10});
        L10:
            throw Utils.parameterError(this.method, r5, "@Path parameter name must match %s. Found: %s", new Object[]{PARAM_URL_REGEX.pattern(), r10});
        }

        private void validateResolvableType(int r5, Type r10) {
            if (Utils.hasUnresolvableType(r10) == true) goto L6;
            return;
        L6:
            throw Utils.parameterError(this.method, r5, "Parameter type must not include a type variable or wildcard: %s", new Object[]{r10});
        }

        public RequestFactory build() {
            Annotation[] r5 = this.methodAnnotations;
            int r10 = r5.length;
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L6;
            parseMethodAnnotation(r5[r11]);
            r11 = r11 + 1;
            goto L3
        L6:
            if (this.httpMethod == null) goto L59;
            if (this.hasBody == false) goto L10;
        L18:
            int r12 = this.parameterAnnotationsArray.length;
            this.parameterHandlers = new ParameterHandler[r12];
            int r13 = r12 - 1;
            int r14 = 0;
        L19:
            if (r14 >= r12) goto L26;
            ParameterHandler<?>[] r15 = this.parameterHandlers;
            Type r16 = this.parameterTypes[r14];
            Annotation[] r17 = this.parameterAnnotationsArray[r14];
            if (r14 != r13) goto L23;
            boolean r18 = true;
        L24:
            r15[r14] = parseParameter(r14, r16, r17, r18);
            r14 = r14 + 1;
            goto L19
        L23:
            r18 = false;
            goto L24
        L26:
            if (this.relativeUrl == null) goto L28;
        L32:
            boolean r19 = this.isFormEncoded;
            if (r19 == false) goto L35;
        L43:
            if (r19 == false) goto L50;
            if (this.gotField == true) goto L50;
            throw Utils.methodError(this.method, "Form-encoded method must contain at least one @Field.", new Object[0]);
        L50:
            if (this.isMultipart == false) goto L57;
            if (this.gotPart == true) goto L57;
            throw Utils.methodError(this.method, "Multipart method must contain at least one @Part.", new Object[0]);
        L57:
            return new RequestFactory(this);
        L35:
            if (this.isMultipart == true) goto L43;
            if (this.hasBody == true) goto L43;
            if (this.gotBody == false) goto L43;
            throw Utils.methodError(this.method, "Non-body HTTP method cannot contain @Body.", new Object[0]);
        L28:
            if (this.gotUrl == true) goto L32;
            throw Utils.methodError(this.method, "Missing either @%s URL or @Url parameter.", new Object[]{this.httpMethod});
        L10:
            if (this.isMultipart == true) goto L17;
            if (this.isFormEncoded == false) goto L18;
            throw Utils.methodError(this.method, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
        L17:
            throw Utils.methodError(this.method, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
        L59:
            throw Utils.methodError(this.method, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
        }
    }

    public RequestFactory(Builder r5) {
        this.method = r5.method;
        this.baseUrl = r5.retrofit.baseUrl;
        this.httpMethod = r5.httpMethod;
        this.relativeUrl = r5.relativeUrl;
        this.headers = r5.headers;
        this.contentType = r5.contentType;
        this.hasBody = r5.hasBody;
        this.isFormEncoded = r5.isFormEncoded;
        this.isMultipart = r5.isMultipart;
        this.parameterHandlers = r5.parameterHandlers;
        this.isKotlinSuspendFunction = r5.isKotlinSuspendFunction;
    }

    public static RequestFactory parseAnnotations(Retrofit r5, Method r10) {
        return new Builder(r5, r10).build();
    }

    public Request create(Object[] r13) throws IOException {
        ParameterHandler<?>[] r5 = this.parameterHandlers;
        int r10 = r13.length;
        if (r10 != r5.length) goto L13;
        RequestBuilder r11 = new RequestBuilder(this.httpMethod, this.baseUrl, this.relativeUrl, this.headers, this.contentType, this.hasBody, this.isFormEncoded, this.isMultipart);
        if (this.isKotlinSuspendFunction == false) goto L7;
        r10 = r10 - 1;
    L7:
        ArrayList r12 = new ArrayList(r10);
        int r14 = 0;
    L8:
        if (r14 >= r10) goto L10;
        r12.add(r13[r14]);
        r5[r14].apply(r11, r13[r14]);
        r14 = r14 + 1;
        goto L8
    L10:
        n0 r15 = r11.get();
        r15.f(Invocation.class, new Invocation(this.method, r12));
        return r15.b();
    L13:
        throw new IllegalArgumentException(androidx.constraintlayout.motion.widget.a.s(j0.s(r10, "Argument count (", ") doesn't match expected count ("), r5.length, ")"));
    }
}
