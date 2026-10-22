package com.bytedance.retrofit2;

import a.a;
import android.text.TextUtils;
import com.bytedance.retrofit2.cache.ICacheServer;
import com.bytedance.retrofit2.client.Client;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.DELETE;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HEAD;
import com.bytedance.retrofit2.http.HTTP;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.HeaderMap;
import com.bytedance.retrofit2.http.MaxLength;
import com.bytedance.retrofit2.http.Multipart;
import com.bytedance.retrofit2.http.OPTIONS;
import com.bytedance.retrofit2.http.PATCH;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.PUT;
import com.bytedance.retrofit2.http.Part;
import com.bytedance.retrofit2.http.PartMap;
import com.bytedance.retrofit2.http.Path;
import com.bytedance.retrofit2.http.Priority;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.QueryName;
import com.bytedance.retrofit2.http.RequestPriority;
import com.bytedance.retrofit2.http.ServiceType;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.http.Tag;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.http.ext.QueryObject;
import com.bytedance.retrofit2.http.ext.QueryParamObject;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import kotlin.coroutines.Continuation;
import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes.dex */
final class RequestFactory<T> {
    final boolean addCommonParam;
    final ICacheServer cacheServer;
    final Client.Provider clientProvider;
    final int commonParamLevel;
    private final String contentTypeHeader;
    private final boolean enableRecordFormFields;
    final Object extraInfo;
    private final boolean hasBody;

    @Nullable
    private final List<Header> headers;
    final Executor httpExecutor;
    final String httpMethod;
    final List<Interceptor> interceptors;
    private final boolean isFormEncoded;
    final boolean isKotlinSuspendFunction;
    private final boolean isMultipart;
    final boolean isResponseStreaming;
    final int maxLength;
    final Method method;
    private final ParameterHandler<?>[] parameterHandlers;
    final int priorityLevel;
    private final String relativeUrl;
    final int requestPriorityLevel;
    public Converter<TypedInput, T> responseConverter;
    private RetrofitMetrics retrofitMetrics;
    private final Endpoint server;
    final String serviceType;

    public static final class Builder<T> {
        private static final String PARAM = "[a-zA-Z][a-zA-Z0-9_-]*";
        private static final Pattern PARAM_NAME_REGEX = null;
        private static final Pattern PARAM_URL_REGEX = null;
        boolean addCommonParam;
        int commonParamLevel;

        @Nullable
        String contentTypeHeader;
        boolean enableRecordFormFields;
        Object extraInfo;
        boolean gotBody;
        boolean gotField;
        boolean gotMethod;
        boolean gotPart;
        boolean gotPath;
        boolean gotQuery;
        boolean gotQueryMap;
        boolean gotQueryName;
        boolean gotUrl;
        boolean hasBody;

        @Nullable
        List<Header> headers;

        @Nullable
        String httpMethod;
        boolean isCustomMethod;
        boolean isFormEncoded;
        boolean isKotlinSuspendFunction;
        boolean isMultipart;
        boolean isResponseStreaming;
        int maxLength;
        final Method method;
        final Annotation[] methodAnnotations;

        @Nullable
        String methodParamName;
        final Annotation[][] parameterAnnotationsArray;

        @Nullable
        ParameterHandler<?>[] parameterHandlers;
        final Type[] parameterTypes;
        int priorityLevel;

        @Nullable
        String relativeUrl;
        Set<String> relativeUrlParamNames;
        int requestPriorityLevel;

        @Nullable
        Converter<TypedInput, T> responseConverter;
        final Retrofit retrofit;
        final RetrofitMetrics retrofitMetrics;
        String serviceType;

        static {
            PARAM_URL_REGEX = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
            PARAM_NAME_REGEX = Pattern.compile(PARAM);
        }

        public Builder(Retrofit r4, Method r5, RetrofitMetrics r6) {
            this.priorityLevel = 1;
            this.serviceType = "";
            this.isResponseStreaming = false;
            this.maxLength = -1;
            this.addCommonParam = true;
            this.commonParamLevel = 0;
            this.isCustomMethod = false;
            this.extraInfo = null;
            this.requestPriorityLevel = 3;
            this.retrofit = r4;
            this.method = r5;
            this.methodAnnotations = r5.getAnnotations();
            this.parameterTypes = r5.getGenericParameterTypes();
            this.parameterAnnotationsArray = r5.getParameterAnnotations();
            this.retrofitMetrics = r6;
        }

        private ParameterHandler<?> bodyAdapt(Type r1) {
            if (RequestBody.class.isAssignableFrom(Utils.getRawType(r1)) == true) goto L5;
            return null;
        L5:
            return ParameterHandler.ConverterBody.INSTANCE;
        }

        private static Class<?> boxIfPrimitive(Class<?> r1) {
            if (Boolean.TYPE != r1) goto L7;
            return Boolean.class;
        L7:
            if (Byte.TYPE != r1) goto L11;
            return Byte.class;
        L11:
            if (Character.TYPE != r1) goto L15;
            return Character.class;
        L15:
            if (Double.TYPE != r1) goto L19;
            return Double.class;
        L19:
            if (Float.TYPE != r1) goto L23;
            return Float.class;
        L23:
            if (Integer.TYPE != r1) goto L27;
            return Integer.class;
        L27:
            if (Long.TYPE != r1) goto L31;
            return Long.class;
        L31:
            if (Short.TYPE != r1) goto L34;
            return Short.class;
        L34:
            return r1;
        }

        private Headers getRequestBodyHeader(String r2, String r3) {
            return Headers.of(new String[]{"Content-Disposition", a.k("form-data; name=\"", r2, "\""), "Content-Transfer-Encoding", r3});
        }

        private List<Header> parseHeaders(String[] r8) {
            ArrayList r0 = new ArrayList();
            int r1 = r8.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L16;
            String r4 = r8[r3];
            int r5 = r4.indexOf(58);
            if (r5 == (-1)) goto L15;
            if (r5 == 0) goto L15;
            if (r5 == (r4.length() - 1)) goto L15;
            String r6 = r4.substring(0, r5);
            String r7 = r4.substring(r5 + 1).trim();
            if ("Content-Type".equalsIgnoreCase(r6) == false) goto L12;
            this.contentTypeHeader = r7;
        L13:
            r3 = r3 + 1;
            goto L3
        L12:
            r0.add(new Header(r6, r7));
        L15:
            throw Utils.methodError(this.method, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", new Object[]{r4});
        L16:
            return r0;
        }

        private void parseHttpMethodAndPath(String r2, String r3, boolean r4) {
            String r0 = this.httpMethod;
            if (r0 != null) goto L31;
            this.httpMethod = r2;
            if (r2 == null) goto L8;
            this.methodParamName = parseMethodParameters(r2);
        L8:
            if (this.methodParamName == null) goto L10;
            this.isCustomMethod = true;
        L10:
            this.hasBody = r4;
            if (r3.isEmpty() == false) goto L13;
            return;
        L13:
            int r5 = r3.indexOf(63);
            if (r5 != (-1)) goto L16;
        L28:
            this.relativeUrl = r3;
            this.relativeUrlParamNames = parsePathParameters(r3);
            return;
        L16:
            if (r5 >= (r3.length() - 1)) goto L28;
            String r6 = r3.substring(r5 + 1);     // Catch: IllegalArgumentException -> L23
            if (PARAM_URL_REGEX.matcher(r6).find() == false) goto L28;
            throw Utils.methodError(this.method, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", new Object[]{r6});     // Catch: IllegalArgumentException -> L23
        L23:
            e = move-exception;
            if (e.getMessage().contains("URL query string") == false) goto L28;
            throw e;
        L31:
            throw Utils.methodError(this.method, "Only one HTTP method is allowed. Found: %s and %s.", new Object[]{r0, r2});
        }

        private void parseMethodAnnotation(Annotation r5) {
            if ((r5 instanceof DELETE) == false) goto L6;
            parseHttpMethodAndPath(HttpMethodContrants.DELETE, ((DELETE) r5).value(), false);
            return;
        L6:
            if ((r5 instanceof GET) == false) goto L9;
            parseHttpMethodAndPath(HttpMethodContrants.GET, ((GET) r5).value(), false);
            return;
        L9:
            if ((r5 instanceof HEAD) == false) goto L12;
            parseHttpMethodAndPath(HttpMethodContrants.HEAD, ((HEAD) r5).value(), false);
            return;
        L12:
            if ((r5 instanceof PATCH) == false) goto L15;
            parseHttpMethodAndPath(HttpMethodContrants.PATCH, ((PATCH) r5).value(), true);
            return;
        L15:
            if ((r5 instanceof POST) == false) goto L18;
            parseHttpMethodAndPath(HttpMethodContrants.POST, ((POST) r5).value(), true);
            return;
        L18:
            if ((r5 instanceof PUT) == false) goto L21;
            parseHttpMethodAndPath(HttpMethodContrants.PUT, ((PUT) r5).value(), true);
            return;
        L21:
            if ((r5 instanceof OPTIONS) == false) goto L24;
            parseHttpMethodAndPath(HttpMethodContrants.OPTIONS, ((OPTIONS) r5).value(), false);
            return;
        L24:
            if ((r5 instanceof HTTP) == false) goto L27;
            HTTP r6 = (HTTP) r5;
            parseHttpMethodAndPath(r6.method(), r6.path(), r6.hasBody());
            return;
        L27:
            if ((r5 instanceof com.bytedance.retrofit2.http.Headers) == false) goto L34;
            String[] r7 = ((com.bytedance.retrofit2.http.Headers) r5).value();
            if (r7.length == 0) goto L32;
            this.headers = parseHeaders(r7);
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
            if ((r5 instanceof FormUrlEncoded) == false) goto L48;
            if (this.isMultipart == true) goto L46;
            this.isFormEncoded = true;
            this.enableRecordFormFields = ((FormUrlEncoded) r5).enableRecord();
            return;
        L46:
            throw Utils.methodError(this.method, "Only one encoding annotation is allowed.", new Object[0]);
        L48:
            if ((r5 instanceof Streaming) == false) goto L51;
            this.isResponseStreaming = true;
            return;
        L51:
            if ((r5 instanceof Priority) == false) goto L54;
            this.priorityLevel = ((Priority) r5).value();
            return;
        L54:
            if ((r5 instanceof ServiceType) == false) goto L57;
            this.serviceType = ((ServiceType) r5).value();
            return;
        L57:
            if ((r5 instanceof RequestPriority) == false) goto L74;
            this.requestPriorityLevel = ((RequestPriority) r5).value();
            return;
        }

        public static String parseMethodParameters(String r1) {
            Matcher r2 = PARAM_URL_REGEX.matcher(r1);     // Catch: IllegalArgumentException -> L8
            if (r2.find() == false) goto L6;
            return r2.group(1);
        L6:
            return null;
        L11:
            return null;
        }

        @Nullable
        private ParameterHandler<?> parseParameter(int r9, Type r10, @Nullable Annotation[] r11, boolean r12) {
            if (r11 == null) goto L18;
            int r2 = r11.length;
            int r3 = 0;
            ParameterHandler<?> r4 = null;
        L5:
            if (r3 >= r2) goto L19;
            Annotation r5 = r11[r3];
            ParameterHandler<?> r6 = parseParameterAnnotation(r9, r10, r11, r5);
            if (r6 == null) goto L9;
        L11:
            if (r6 == null) goto L15;
            if (r4 != null) goto L17;
            r4 = r6;
            goto L15
        L17:
            throw Utils.parameterError(this.method, r9, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
        L15:
            r3 = r3 + 1;
            goto L5
        L9:
            if (Platform.squareRetrofitExists() == false) goto L11;
            r6 = parseSquareParameterAnnotation(r9, r10, r11, r5);
        L19:
            if (r4 != null) goto L27;
            if (r12 == false) goto L26;
            if (Utils.getRawType(r10) != Continuation.class) goto L26;
            this.isKotlinSuspendFunction = true;     // Catch: NoClassDefFoundError -> L28
            return null;
        L26:
            throw Utils.parameterError(this.method, r9, "No Retrofit annotation found.", new Object[0]);
        L27:
            return r4;
        L18:
            r4 = null;
            goto L19
        }

        @Nullable
        private ParameterHandler<?> parseParameterAnnotation(int r10, Type r11, Annotation[] r12, Annotation r13) {
            if ((r13 instanceof Url) == false) goto L42;
            validateResolvableType(r10, r11);
            if (this.gotUrl == true) goto L40;
            if (this.gotPath == true) goto L38;
            if (this.gotQuery == true) goto L36;
            if (this.relativeUrl != null) goto L34;
            if (this.gotQueryName == true) goto L32;
            if (this.gotQueryMap == true) goto L30;
            this.gotUrl = true;
            if (r11 == String.class) goto L28;
            if (r11 == URI.class) goto L28;
            if ((r11 instanceof Class) == false) goto L26;
            if ("android.net.Uri".equals(((Class) r11).getName()) == true) goto L28;
        L26:
            throw Utils.parameterError(this.method, r10, "@Url must be String, java.net.URI, or android.net.Uri type.", new Object[0]);
        L28:
            return new ParameterHandler.RelativeUrl(this.method, r10);
        L30:
            throw Utils.parameterError(this.method, r10, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
        L32:
            throw Utils.parameterError(this.method, r10, "A @Url parameter must not come after a @QueryName.", new Object[0]);
        L34:
            throw Utils.parameterError(this.method, r10, "@Url cannot be used with @%s URL", new Object[]{this.httpMethod});
        L36:
            throw Utils.parameterError(this.method, r10, "A @Url parameter must not come after a @Query.", new Object[0]);
        L38:
            throw Utils.parameterError(this.method, r10, "@Path parameters may not be used with @Url.", new Object[0]);
        L40:
            throw Utils.parameterError(this.method, r10, "Multiple @Url method annotations found.", new Object[0]);
        L42:
            if ((r13 instanceof Path) == false) goto L66;
            validateResolvableType(r10, r11);
            if (this.gotQuery == true) goto L64;
            if (this.gotUrl == true) goto L62;
            if (this.relativeUrl == null) goto L60;
            if (this.gotQueryName == true) goto L58;
            if (this.gotQueryMap == true) goto L56;
            this.gotPath = true;
            Path r14 = (Path) r13;
            String r3 = r14.value();
            validatePathName(r10, r3);
            return new ParameterHandler.Path(this.method, r10, r3, this.retrofit.stringConverter(r11, r12), r14.encode());
        L56:
            throw Utils.parameterError(this.method, r10, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
        L58:
            throw Utils.parameterError(this.method, r10, "A @Path parameter must not come after a @QueryName.", new Object[0]);
        L60:
            throw Utils.parameterError(this.method, r10, "@Path can only be used with relative url on @%s", new Object[]{this.httpMethod});
        L62:
            throw Utils.parameterError(this.method, r10, "@Path parameters may not be used with @Url.", new Object[0]);
        L64:
            throw Utils.parameterError(this.method, r10, "A @Path parameter must not come after a @Query.", new Object[0]);
        L66:
            if ((r13 instanceof Query) == false) goto L82;
            validateResolvableType(r10, r11);
            Query r15 = (Query) r13;
            String r0 = r15.value();
            boolean r16 = r15.encode();
            Class<?> r2 = Utils.getRawType(r11);
            this.gotQuery = true;
            if (Iterable.class.isAssignableFrom(r2) == false) goto L76;
            if ((r11 instanceof ParameterizedType) == false) goto L74;
            return new ParameterHandler.Query(r0, this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) r11), r12), r16).iterable();
        L74:
            throw Utils.parameterError(this.method, r10, r2.getSimpleName() + " must include generic type (e.g., " + r2.getSimpleName() + "<String>)", new Object[0]);
        L76:
            if (r2.isArray() == false) goto L80;
            return new ParameterHandler.Query(r0, this.retrofit.stringConverter(boxIfPrimitive(r2.getComponentType()), r12), r16).array();
        L80:
            return new ParameterHandler.Query(r0, this.retrofit.stringConverter(r11, r12), r16);
        L82:
            if ((r13 instanceof QueryName) == false) goto L98;
            validateResolvableType(r10, r11);
            boolean r17 = ((QueryName) r13).encoded();
            Class<?> r1 = Utils.getRawType(r11);
            this.gotQueryName = true;
            if (Iterable.class.isAssignableFrom(r1) == false) goto L92;
            if ((r11 instanceof ParameterizedType) == false) goto L90;
            return new ParameterHandler.QueryName(this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) r11), r12), r17).iterable();
        L90:
            throw Utils.parameterError(this.method, r10, r1.getSimpleName() + " must include generic type (e.g., " + r1.getSimpleName() + "<String>)", new Object[0]);
        L92:
            if (r1.isArray() == false) goto L96;
            return new ParameterHandler.QueryName(this.retrofit.stringConverter(boxIfPrimitive(r1.getComponentType()), r12), r17).array();
        L96:
            return new ParameterHandler.QueryName(this.retrofit.stringConverter(r11, r12), r17);
        L98:
            if ((r13 instanceof QueryMap) == false) goto L114;
            validateResolvableType(r10, r11);
            Class<?> r4 = Utils.getRawType(r11);
            this.gotQueryMap = true;
            if (Map.class.isAssignableFrom(r4) == false) goto L112;
            Type r18 = Utils.getSupertype(r11, r4, Map.class);
            if ((r18 instanceof ParameterizedType) == false) goto L110;
            ParameterizedType r19 = (ParameterizedType) r18;
            Type r5 = Utils.getParameterUpperBound(0, r19);
            if (String.class != r5) goto L108;
            return new ParameterHandler.QueryMap(this.method, r10, this.retrofit.stringConverter(Utils.getParameterUpperBound(1, r19), r12), ((QueryMap) r13).encode());
        L108:
            throw Utils.parameterError(this.method, r10, "@QueryMap keys must be of type String: " + r5, new Object[0]);
        L110:
            throw Utils.parameterError(this.method, r10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L112:
            throw Utils.parameterError(this.method, r10, "@QueryMap parameter type must be Map.", new Object[0]);
        L114:
            if ((r13 instanceof com.bytedance.retrofit2.http.Header) == false) goto L130;
            validateResolvableType(r10, r11);
            String r110 = ((com.bytedance.retrofit2.http.Header) r13).value();
            Class<?> r6 = Utils.getRawType(r11);
            if (Iterable.class.isAssignableFrom(r6) == false) goto L124;
            if ((r11 instanceof ParameterizedType) == false) goto L122;
            return new ParameterHandler.Header(r110, this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) r11), r12)).iterable();
        L122:
            throw Utils.parameterError(this.method, r10, r6.getSimpleName() + " must include generic type (e.g., " + r6.getSimpleName() + "<String>)", new Object[0]);
        L124:
            if (r6.isArray() == false) goto L128;
            return new ParameterHandler.Header(r110, this.retrofit.stringConverter(boxIfPrimitive(r6.getComponentType()), r12)).array();
        L128:
            return new ParameterHandler.Header(r110, this.retrofit.stringConverter(r11, r12));
        L130:
            if ((r13 instanceof HeaderList) == false) goto L146;
            Class<?> r111 = Utils.getRawType(r11);
            if (List.class.isAssignableFrom(r111) == false) goto L144;
            Type r112 = Utils.getSupertype(r11, r111, List.class);
            if ((r112 instanceof ParameterizedType) == false) goto L142;
            Type r113 = Utils.getParameterUpperBound(0, (ParameterizedType) r112);
            if (Header.class != r113) goto L140;
            return new ParameterHandler.HeaderList(this.retrofit.headerConverter(r113, r12));
        L140:
            throw Utils.parameterError(this.method, r10, "@HeaderList keys must be of type retrofit.client.Header: " + r113, new Object[0]);
        L142:
            throw Utils.parameterError(this.method, r10, "List must include generic types (e.g., List<Header>)", new Object[0]);
        L144:
            throw Utils.parameterError(this.method, r10, "@HeaderList parameter type must be List.", new Object[0]);
        L146:
            if ((r13 instanceof HeaderMap) == false) goto L162;
            validateResolvableType(r10, r11);
            Class<?> r114 = Utils.getRawType(r11);
            if (Map.class.isAssignableFrom(r114) == false) goto L160;
            Type r115 = Utils.getSupertype(r11, r114, Map.class);
            if ((r115 instanceof ParameterizedType) == false) goto L158;
            ParameterizedType r116 = (ParameterizedType) r115;
            Type r117 = Utils.getParameterUpperBound(0, r116);
            if (String.class != r117) goto L156;
            return new ParameterHandler.HeaderMap(this.method, r10, this.retrofit.stringConverter(Utils.getParameterUpperBound(1, r116), r12));
        L156:
            throw Utils.parameterError(this.method, r10, "@HeaderMap keys must be of type String: " + r117, new Object[0]);
        L158:
            throw Utils.parameterError(this.method, r10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L160:
            throw Utils.parameterError(this.method, r10, "@HeaderMap parameter type must be Map.", new Object[0]);
        L162:
            if ((r13 instanceof Field) == false) goto L182;
            validateResolvableType(r10, r11);
            if (this.isFormEncoded == false) goto L180;
            Field r118 = (Field) r13;
            String r7 = r118.value();
            boolean r119 = r118.encode();
            this.gotField = true;
            Class<?> r8 = Utils.getRawType(r11);
            if (Iterable.class.isAssignableFrom(r8) == false) goto L174;
            if ((r11 instanceof ParameterizedType) == false) goto L172;
            return new ParameterHandler.Field(r7, this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) r11), r12), r119).iterable();
        L172:
            throw Utils.parameterError(this.method, r10, r8.getSimpleName() + " must include generic type (e.g., " + r8.getSimpleName() + "<String>)", new Object[0]);
        L174:
            if (r8.isArray() == false) goto L178;
            return new ParameterHandler.Field(r7, this.retrofit.stringConverter(boxIfPrimitive(r8.getComponentType()), r12), r119).array();
        L178:
            return new ParameterHandler.Field(r7, this.retrofit.stringConverter(r11, r12), r119);
        L180:
            throw Utils.parameterError(this.method, r10, "@Field parameters can only be used with form encoding.", new Object[0]);
        L182:
            if ((r13 instanceof FieldMap) == false) goto L202;
            validateResolvableType(r10, r11);
            if (this.isFormEncoded == false) goto L200;
            Class<?> r9 = Utils.getRawType(r11);
            if (Map.class.isAssignableFrom(r9) == false) goto L198;
            Type r120 = Utils.getSupertype(r11, r9, Map.class);
            if ((r120 instanceof ParameterizedType) == false) goto L196;
            ParameterizedType r121 = (ParameterizedType) r120;
            Type r20 = Utils.getParameterUpperBound(0, r121);
            if (String.class != r20) goto L194;
            Converter<T, String> r122 = this.retrofit.stringConverter(Utils.getParameterUpperBound(1, r121), r12);
            this.gotField = true;
            return new ParameterHandler.FieldMap(this.method, r10, r122, ((FieldMap) r13).encode());
        L194:
            throw Utils.parameterError(this.method, r10, "@FieldMap keys must be of type String: " + r20, new Object[0]);
        L196:
            throw Utils.parameterError(this.method, r10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L198:
            throw Utils.parameterError(this.method, r10, "@FieldMap parameter type must be Map.", new Object[0]);
        L200:
            throw Utils.parameterError(this.method, r10, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
        L202:
            if ((r13 instanceof Part) == false) goto L213;
            if (this.isMultipart == false) goto L211;
            Part r123 = (Part) r13;
            this.gotPart = true;
            ParameterHandler<?> r21 = partAdapt(r11, r123.value(), r123.encoding());
            if (r21 == null) goto L209;
            return r21;
        L209:
            return new ParameterHandler.Part(this.method, r10, r123.value(), this.retrofit.requestBodyConverter(r11, r12, this.methodAnnotations));
        L211:
            throw Utils.parameterError(this.method, r10, "@Part parameters can only be used with multipart encoding.", new Object[0]);
        L213:
            if ((r13 instanceof PartMap) == false) goto L236;
            validateResolvableType(r10, r11);
            if (this.isMultipart == false) goto L234;
            this.gotPart = true;
            Class<?> r22 = Utils.getRawType(r11);
            if (Map.class.isAssignableFrom(r22) == false) goto L232;
            Type r124 = Utils.getSupertype(r11, r22, Map.class);
            if ((r124 instanceof ParameterizedType) == false) goto L230;
            ParameterizedType r125 = (ParameterizedType) r124;
            Type r23 = Utils.getParameterUpperBound(0, r125);
            if (String.class != r23) goto L228;
            ParameterHandler<?> r24 = partMapAdapt(r125, r13);
            if (r24 == null) goto L226;
            return r24;
        L226:
            return new ParameterHandler.PartMap(this.method, r10, this.retrofit.requestBodyConverter(Utils.getParameterUpperBound(1, r125), r12, this.methodAnnotations), ((PartMap) r13).encoding());
        L228:
            throw Utils.parameterError(this.method, r10, "@PartMap keys must be of type String: " + r23, new Object[0]);
        L230:
            throw Utils.parameterError(this.method, r10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L232:
            throw Utils.parameterError(this.method, r10, "@PartMap parameter type must be Map.", new Object[0]);
        L234:
            throw Utils.parameterError(this.method, r10, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
        L236:
            if ((r13 instanceof Body) == false) goto L258;
            validateResolvableType(r10, r11);
            if (this.isFormEncoded == true) goto L256;
            if (this.isMultipart == true) goto L256;
            if (this.gotBody == true) goto L254;
            ParameterHandler<?> r126 = bodyAdapt(r11);
            if (r126 == null) goto L316;
            this.gotBody = true;
            return r126;
        L316:
            Converter<T, TypedOutput> r127 = this.retrofit.requestBodyConverter(r11, r12, this.methodAnnotations);     // Catch: RuntimeException -> L250
            this.gotBody = true;
            return new ParameterHandler.Body(this.method, r10, this.isCustomMethod, r127);
        L250:
            e = move-exception;
            throw Utils.parameterError(this.method, e, r10, "Unable to create @Body converter for %s", new Object[]{r11});
        L254:
            throw Utils.parameterError(this.method, r10, "Multiple @Body method annotations found.", new Object[0]);
        L256:
            throw Utils.parameterError(this.method, r10, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
        L258:
            if ((r13 instanceof com.bytedance.retrofit2.http.Method) == false) goto L266;
            if (this.gotMethod == true) goto L264;
            this.gotMethod = true;
            String r128 = ((com.bytedance.retrofit2.http.Method) r13).value();
            validateMethodName(r10, r128);
            return new ParameterHandler.Method(r128, this.retrofit.stringConverter(r11, r12));
        L264:
            throw Utils.parameterError(this.method, r10, "Multiple @Method method annotations found.", new Object[0]);
        L266:
            if ((r13 instanceof MaxLength) == false) goto L274;
            return new ParameterHandler.MaxLength(this.retrofit.stringConverter(r11, r12));
        L270:
            e = move-exception;
            throw Utils.parameterError(this.method, e, r10, "Unable to create @MaxLength converter for %s", new Object[]{r11});
        L274:
            if ((r13 instanceof AddCommonParam) == false) goto L283;
            this.commonParamLevel = ((AddCommonParam) r13).level();
            return new ParameterHandler.AddCommonParam(this.retrofit.stringConverter(r11, r12));
        L279:
            e = move-exception;
            throw Utils.parameterError(this.method, e, r10, "Unable to create @AddCommonParam converter for %s", new Object[]{r11});
        L283:
            if ((r13 instanceof ExtraInfo) == false) goto L291;
            return new ParameterHandler.ExtraInfo(this.retrofit.objectConverter(r11, r12));
        L287:
            e = move-exception;
            throw Utils.parameterError(this.method, e, r10, "Unable to create @ExtraInfo converter for %s", new Object[]{r11});
        L291:
            if ((r13 instanceof QueryObject) == false) goto L299;
            if (QueryParamObject.class.isAssignableFrom(Utils.getRawType(r11)) == false) goto L297;
            return new ParameterHandler.QueryObject();
        L297:
            throw Utils.parameterError(this.method, r10, "Unable to create @QueryObject for %s not QueryParamObject type", new Object[]{r11});
        L299:
            if ((r13 instanceof Tag) == false) goto L312;
            validateResolvableType(r10, r11);
            Class<?> r129 = Utils.getRawType(r11);
            int r130 = r10 - 1;
        L301:
            if (r130 < 0) goto L311;
            ParameterHandler<?> r131 = this.parameterHandlers[r130];
            if ((r131 instanceof ParameterHandler.Tag) == false) goto L309;
            if (((ParameterHandler.Tag) r131).cls.equals(r129) == false) goto L309;
            throw Utils.parameterError(this.method, r10, "@Tag type " + r129.getName() + " is duplicate of parameter #" + (r130 + 1) + " and would always overwrite its value.", new Object[0]);
        L309:
            r130 = r130 - 1;
            goto L301
        L311:
            return new ParameterHandler.Tag(r129);
        L312:
            return null;
        }

        public static Set<String> parsePathParameters(String r2) {
            LinkedHashSet r0 = new LinkedHashSet();
            Matcher r3 = PARAM_URL_REGEX.matcher(r2);     // Catch: IllegalArgumentException -> L9
        L5:
            if (r3.find() == false) goto L8;
            r0.add(r3.group(1));     // Catch: IllegalArgumentException -> L9
        L8:
            return r0;
        }

        private void parseSquareMethodAnnotation(Annotation r5) {
            if ((r5 instanceof retrofit2.http.DELETE) == false) goto L6;
            parseHttpMethodAndPath(HttpMethodContrants.DELETE, ((retrofit2.http.DELETE) r5).value(), false);
            return;
        L6:
            if ((r5 instanceof retrofit2.http.GET) == false) goto L9;
            parseHttpMethodAndPath(HttpMethodContrants.GET, ((retrofit2.http.GET) r5).value(), false);
            return;
        L9:
            if ((r5 instanceof retrofit2.http.HEAD) == false) goto L12;
            parseHttpMethodAndPath(HttpMethodContrants.HEAD, ((retrofit2.http.HEAD) r5).value(), false);
            return;
        L12:
            if ((r5 instanceof retrofit2.http.PATCH) == false) goto L15;
            parseHttpMethodAndPath(HttpMethodContrants.PATCH, ((retrofit2.http.PATCH) r5).value(), true);
            return;
        L15:
            if ((r5 instanceof retrofit2.http.POST) == false) goto L18;
            parseHttpMethodAndPath(HttpMethodContrants.POST, ((retrofit2.http.POST) r5).value(), true);
            return;
        L18:
            if ((r5 instanceof retrofit2.http.PUT) == false) goto L21;
            parseHttpMethodAndPath(HttpMethodContrants.PUT, ((retrofit2.http.PUT) r5).value(), true);
            return;
        L21:
            if ((r5 instanceof retrofit2.http.OPTIONS) == false) goto L24;
            parseHttpMethodAndPath(HttpMethodContrants.OPTIONS, ((retrofit2.http.OPTIONS) r5).value(), false);
            return;
        L24:
            if ((r5 instanceof retrofit2.http.HTTP) == false) goto L27;
            retrofit2.http.HTTP r6 = (retrofit2.http.HTTP) r5;
            parseHttpMethodAndPath(r6.method(), r6.path(), r6.hasBody());
            return;
        L27:
            if ((r5 instanceof retrofit2.http.Headers) == false) goto L34;
            String[] r7 = ((retrofit2.http.Headers) r5).value();
            if (r7.length == 0) goto L32;
            this.headers = parseHeaders(r7);
            return;
        L32:
            throw Utils.methodError(this.method, "@Headers annotation is empty.", new Object[0]);
        L34:
            if ((r5 instanceof retrofit2.http.Multipart) == false) goto L41;
            if (this.isFormEncoded == true) goto L39;
            this.isMultipart = true;
            return;
        L39:
            throw Utils.methodError(this.method, "Only one encoding annotation is allowed.", new Object[0]);
        L41:
            if ((r5 instanceof retrofit2.http.FormUrlEncoded) == false) goto L48;
            if (this.isMultipart == true) goto L46;
            this.isFormEncoded = true;
            return;
        L46:
            throw Utils.methodError(this.method, "Only one encoding annotation is allowed.", new Object[0]);
        L48:
            if ((r5 instanceof retrofit2.http.Streaming) == false) goto L62;
            this.isResponseStreaming = true;
            return;
        }

        private ParameterHandler<?> parseSquareParameterAnnotation(int r11, Type r12, Annotation[] r13, Annotation r14) {
            if ((r14 instanceof retrofit2.http.Url) == false) goto L42;
            validateResolvableType(r11, r12);
            if (this.gotUrl == true) goto L40;
            if (this.gotPath == true) goto L38;
            if (this.gotQuery == true) goto L36;
            if (this.gotQueryName == true) goto L34;
            if (this.gotQueryMap == true) goto L32;
            if (this.relativeUrl != null) goto L30;
            this.gotUrl = true;
            if (r12 == String.class) goto L28;
            if (r12 == URI.class) goto L28;
            if ((r12 instanceof Class) == false) goto L26;
            if ("android.net.Uri".equals(((Class) r12).getName()) == true) goto L28;
        L26:
            throw Utils.parameterError(this.method, r11, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
        L28:
            return new ParameterHandler.RelativeUrl(this.method, r11);
        L30:
            throw Utils.parameterError(this.method, r11, "@Url cannot be used with @%s URL", new Object[]{this.httpMethod});
        L32:
            throw Utils.parameterError(this.method, r11, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
        L34:
            throw Utils.parameterError(this.method, r11, "A @Url parameter must not come after a @QueryName.", new Object[0]);
        L36:
            throw Utils.parameterError(this.method, r11, "A @Url parameter must not come after a @Query.", new Object[0]);
        L38:
            throw Utils.parameterError(this.method, r11, "@Path parameters may not be used with @Url.", new Object[0]);
        L40:
            throw Utils.parameterError(this.method, r11, "Multiple @Url method annotations found.", new Object[0]);
        L42:
            if ((r14 instanceof retrofit2.http.Path) == false) goto L66;
            validateResolvableType(r11, r12);
            if (this.gotQuery == true) goto L64;
            if (this.gotQueryName == true) goto L62;
            if (this.gotQueryMap == true) goto L60;
            if (this.gotUrl == true) goto L58;
            if (this.relativeUrl == null) goto L56;
            this.gotPath = true;
            retrofit2.http.Path r15 = (retrofit2.http.Path) r14;
            String r7 = r15.value();
            validatePathName(r11, r7);
            return new ParameterHandler.Path(this.method, r11, r7, this.retrofit.stringConverter(r12, r13), !r15.encoded());
        L56:
            throw Utils.parameterError(this.method, r11, "@Path can only be used with relative url on @%s", new Object[]{this.httpMethod});
        L58:
            throw Utils.parameterError(this.method, r11, "@Path parameters may not be used with @Url.", new Object[0]);
        L60:
            throw Utils.parameterError(this.method, r11, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
        L62:
            throw Utils.parameterError(this.method, r11, "A @Path parameter must not come after a @QueryName.", new Object[0]);
        L64:
            throw Utils.parameterError(this.method, r11, "A @Path parameter must not come after a @Query.", new Object[0]);
        L66:
            if ((r14 instanceof retrofit2.http.Query) == false) goto L82;
            validateResolvableType(r11, r12);
            retrofit2.http.Query r16 = (retrofit2.http.Query) r14;
            String r0 = r16.value();
            boolean r17 = r16.encoded();
            Class<?> r2 = Utils.getRawType(r12);
            this.gotQuery = true;
            if (Iterable.class.isAssignableFrom(r2) == false) goto L76;
            if ((r12 instanceof ParameterizedType) == false) goto L74;
            return new ParameterHandler.Query(r0, this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) r12), r13), !r17).iterable();
        L74:
            throw Utils.parameterError(this.method, r11, r2.getSimpleName() + " must include generic type (e.g., " + r2.getSimpleName() + "<String>)", new Object[0]);
        L76:
            if (r2.isArray() == false) goto L80;
            return new ParameterHandler.Query(r0, this.retrofit.stringConverter(boxIfPrimitive(r2.getComponentType()), r13), !r17).array();
        L80:
            return new ParameterHandler.Query(r0, this.retrofit.stringConverter(r12, r13), !r17);
        L82:
            if ((r14 instanceof retrofit2.http.QueryName) == false) goto L98;
            validateResolvableType(r11, r12);
            boolean r18 = ((retrofit2.http.QueryName) r14).encoded();
            Class<?> r1 = Utils.getRawType(r12);
            this.gotQueryName = true;
            if (Iterable.class.isAssignableFrom(r1) == false) goto L92;
            if ((r12 instanceof ParameterizedType) == false) goto L90;
            return new ParameterHandler.QueryName(this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) r12), r13), r18).iterable();
        L90:
            throw Utils.parameterError(this.method, r11, r1.getSimpleName() + " must include generic type (e.g., " + r1.getSimpleName() + "<String>)", new Object[0]);
        L92:
            if (r1.isArray() == false) goto L96;
            return new ParameterHandler.QueryName(this.retrofit.stringConverter(boxIfPrimitive(r1.getComponentType()), r13), r18).array();
        L96:
            return new ParameterHandler.QueryName(this.retrofit.stringConverter(r12, r13), r18);
        L98:
            if ((r14 instanceof retrofit2.http.QueryMap) == false) goto L114;
            validateResolvableType(r11, r12);
            Class<?> r3 = Utils.getRawType(r12);
            this.gotQueryMap = true;
            if (Map.class.isAssignableFrom(r3) == false) goto L112;
            Type r19 = Utils.getSupertype(r12, r3, Map.class);
            if ((r19 instanceof ParameterizedType) == false) goto L110;
            ParameterizedType r110 = (ParameterizedType) r19;
            Type r4 = Utils.getParameterUpperBound(0, r110);
            if (String.class != r4) goto L108;
            return new ParameterHandler.QueryMap(this.method, r11, this.retrofit.stringConverter(Utils.getParameterUpperBound(1, r110), r13), !((retrofit2.http.QueryMap) r14).encoded());
        L108:
            throw Utils.parameterError(this.method, r11, "@QueryMap keys must be of type String: " + r4, new Object[0]);
        L110:
            throw Utils.parameterError(this.method, r11, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L112:
            throw Utils.parameterError(this.method, r11, "@QueryMap parameter type must be Map.", new Object[0]);
        L114:
            if ((r14 instanceof retrofit2.http.Header) == false) goto L130;
            validateResolvableType(r11, r12);
            String r111 = ((retrofit2.http.Header) r14).value();
            Class<?> r5 = Utils.getRawType(r12);
            if (Iterable.class.isAssignableFrom(r5) == false) goto L124;
            if ((r12 instanceof ParameterizedType) == false) goto L122;
            return new ParameterHandler.Header(r111, this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) r12), r13)).iterable();
        L122:
            throw Utils.parameterError(this.method, r11, r5.getSimpleName() + " must include generic type (e.g., " + r5.getSimpleName() + "<String>)", new Object[0]);
        L124:
            if (r5.isArray() == false) goto L128;
            return new ParameterHandler.Header(r111, this.retrofit.stringConverter(boxIfPrimitive(r5.getComponentType()), r13)).array();
        L128:
            return new ParameterHandler.Header(r111, this.retrofit.stringConverter(r12, r13));
        L130:
            if ((r14 instanceof retrofit2.http.HeaderMap) == false) goto L146;
            validateResolvableType(r11, r12);
            Class<?> r112 = Utils.getRawType(r12);
            if (Map.class.isAssignableFrom(r112) == false) goto L144;
            Type r113 = Utils.getSupertype(r12, r112, Map.class);
            if ((r113 instanceof ParameterizedType) == false) goto L142;
            ParameterizedType r114 = (ParameterizedType) r113;
            Type r115 = Utils.getParameterUpperBound(0, r114);
            if (String.class != r115) goto L140;
            return new ParameterHandler.HeaderMap(this.method, r11, this.retrofit.stringConverter(Utils.getParameterUpperBound(1, r114), r13));
        L140:
            throw Utils.parameterError(this.method, r11, "@HeaderMap keys must be of type String: " + r115, new Object[0]);
        L142:
            throw Utils.parameterError(this.method, r11, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L144:
            throw Utils.parameterError(this.method, r11, "@HeaderMap parameter type must be Map.", new Object[0]);
        L146:
            if ((r14 instanceof retrofit2.http.Field) == false) goto L166;
            validateResolvableType(r11, r12);
            if (this.isFormEncoded == false) goto L164;
            retrofit2.http.Field r116 = (retrofit2.http.Field) r14;
            String r6 = r116.value();
            boolean r117 = r116.encoded();
            this.gotField = true;
            Class<?> r8 = Utils.getRawType(r12);
            if (Iterable.class.isAssignableFrom(r8) == false) goto L158;
            if ((r12 instanceof ParameterizedType) == false) goto L156;
            return new ParameterHandler.Field(r6, this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) r12), r13), !r117).iterable();
        L156:
            throw Utils.parameterError(this.method, r11, r8.getSimpleName() + " must include generic type (e.g., " + r8.getSimpleName() + "<String>)", new Object[0]);
        L158:
            if (r8.isArray() == false) goto L162;
            return new ParameterHandler.Field(r6, this.retrofit.stringConverter(boxIfPrimitive(r8.getComponentType()), r13), !r117).array();
        L162:
            return new ParameterHandler.Field(r6, this.retrofit.stringConverter(r12, r13), !r117);
        L164:
            throw Utils.parameterError(this.method, r11, "@Field parameters can only be used with form encoding.", new Object[0]);
        L166:
            if ((r14 instanceof retrofit2.http.FieldMap) == false) goto L186;
            validateResolvableType(r11, r12);
            if (this.isFormEncoded == false) goto L184;
            Class<?> r9 = Utils.getRawType(r12);
            if (Map.class.isAssignableFrom(r9) == false) goto L182;
            Type r118 = Utils.getSupertype(r12, r9, Map.class);
            if ((r118 instanceof ParameterizedType) == false) goto L180;
            ParameterizedType r119 = (ParameterizedType) r118;
            Type r10 = Utils.getParameterUpperBound(0, r119);
            if (String.class != r10) goto L178;
            Converter<T, String> r120 = this.retrofit.stringConverter(Utils.getParameterUpperBound(1, r119), r13);
            this.gotField = true;
            return new ParameterHandler.FieldMap(this.method, r11, r120, !((retrofit2.http.FieldMap) r14).encoded());
        L178:
            throw Utils.parameterError(this.method, r11, "@FieldMap keys must be of type String: " + r10, new Object[0]);
        L180:
            throw Utils.parameterError(this.method, r11, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L182:
            throw Utils.parameterError(this.method, r11, "@FieldMap parameter type must be Map.", new Object[0]);
        L184:
            throw Utils.parameterError(this.method, r11, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
        L186:
            if ((r14 instanceof retrofit2.http.Part) == false) goto L197;
            if (this.isMultipart == false) goto L195;
            retrofit2.http.Part r121 = (retrofit2.http.Part) r14;
            this.gotPart = true;
            ParameterHandler<?> r20 = partAdapt(r12, r121.value(), r121.encoding());
            if (r20 == null) goto L193;
            return r20;
        L193:
            return new ParameterHandler.Part(this.method, r11, r121.value(), this.retrofit.requestBodyConverter(r12, r13, this.methodAnnotations));
        L195:
            throw Utils.parameterError(this.method, r11, "@Part parameters can only be used with multipart encoding.", new Object[0]);
        L197:
            if ((r14 instanceof retrofit2.http.PartMap) == false) goto L221;
            validateResolvableType(r11, r12);
            if (this.isMultipart == false) goto L219;
            this.gotPart = true;
            Class<?> r21 = Utils.getRawType(r12);
            if (Map.class.isAssignableFrom(r21) == false) goto L217;
            Type r122 = Utils.getSupertype(r12, r21, Map.class);
            if ((r122 instanceof ParameterizedType) == false) goto L215;
            ParameterizedType r123 = (ParameterizedType) r122;
            Type r22 = Utils.getParameterUpperBound(0, r123);
            if (String.class != r22) goto L213;
            Type r124 = Utils.getParameterUpperBound(1, r123);
            if (MultipartBody.Part.class.isAssignableFrom(Utils.getRawType(r124)) == true) goto L211;
            return new ParameterHandler.PartMap(this.method, r11, this.retrofit.requestBodyConverter(r124, r13, this.methodAnnotations), ((retrofit2.http.PartMap) r14).encoding());
        L211:
            throw Utils.parameterError(this.method, r11, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
        L213:
            throw Utils.parameterError(this.method, r11, "@PartMap keys must be of type String: " + r22, new Object[0]);
        L215:
            throw Utils.parameterError(this.method, r11, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L217:
            throw Utils.parameterError(this.method, r11, "@PartMap parameter type must be Map.", new Object[0]);
        L219:
            throw Utils.parameterError(this.method, r11, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
        L221:
            if ((r14 instanceof retrofit2.http.Body) == false) goto L243;
            validateResolvableType(r11, r12);
            if (this.isFormEncoded == true) goto L241;
            if (this.isMultipart == true) goto L241;
            if (this.gotBody == true) goto L239;
            ParameterHandler<?> r125 = bodyAdapt(r12);
            if (r125 == null) goto L258;
            this.gotBody = true;
            return r125;
        L258:
            Converter<T, TypedOutput> r126 = this.retrofit.requestBodyConverter(r12, r13, this.methodAnnotations);     // Catch: RuntimeException -> L235
            this.gotBody = true;
            return new ParameterHandler.Body(this.method, r11, this.isCustomMethod, r126);
        L235:
            e = move-exception;
            throw Utils.parameterError(this.method, e, r11, "Unable to create @Body converter for %s", new Object[]{r12});
        L239:
            throw Utils.parameterError(this.method, r11, "Multiple @Body method annotations found.", new Object[0]);
        L241:
            throw Utils.parameterError(this.method, r11, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
        L243:
            if ((r14 instanceof retrofit2.http.Tag) == false) goto L256;
            validateResolvableType(r11, r12);
            Class<?> r127 = Utils.getRawType(r12);
            int r128 = r11 - 1;
        L245:
            if (r128 < 0) goto L255;
            ParameterHandler<?> r129 = this.parameterHandlers[r128];
            if ((r129 instanceof ParameterHandler.Tag) == false) goto L253;
            if (((ParameterHandler.Tag) r129).cls.equals(r127) == false) goto L253;
            throw Utils.parameterError(this.method, r11, "@Tag type " + r127.getName() + " is duplicate of parameter #" + (r128 + 1) + " and would always overwrite its value.", new Object[0]);
        L253:
            r128 = r128 - 1;
            goto L245
        L255:
            return new ParameterHandler.Tag(r127);
        L256:
            return null;
        }

        private ParameterHandler<?> partAdapt(Type r6, String r7, String r8) {
            Class<?> r0 = Utils.getRawType(r6);
            if (TextUtils.isEmpty(r7) == false) goto L24;
            if (Iterable.class.isAssignableFrom(r0) == false) goto L14;
            if ((r6 instanceof ParameterizedType) == true) goto L10;
            return null;
        L10:
            if (MultipartBody.Part.class.isAssignableFrom(Utils.getRawType(Utils.getParameterUpperBound(0, (ParameterizedType) r6))) == true) goto L12;
        L42:
            return null;
        L12:
            return ParameterHandler.ConverterRawPart.INSTANCE.iterable();
        L14:
            if (r0.isArray() == false) goto L20;
            if (MultipartBody.Part.class.isAssignableFrom(r0.getComponentType()) == false) goto L42;
            return ParameterHandler.ConverterRawPart.INSTANCE.array();
        L20:
            if (MultipartBody.Part.class.isAssignableFrom(r0) == false) goto L42;
            return ParameterHandler.ConverterRawPart.INSTANCE;
        L24:
            if (Iterable.class.isAssignableFrom(r0) == false) goto L33;
            if ((r6 instanceof ParameterizedType) == true) goto L29;
            return null;
        L29:
            if (RequestBody.class.isAssignableFrom(Utils.getRawType(Utils.getParameterUpperBound(0, (ParameterizedType) r6))) == false) goto L42;
            return new ParameterHandler.ConverterPart(getRequestBodyHeader(r7, r8)).iterable();
        L33:
            if (r0.isArray() == false) goto L39;
            if (RequestBody.class.isAssignableFrom(boxIfPrimitive(r0.getComponentType())) == false) goto L42;
            return new ParameterHandler.ConverterPart(getRequestBodyHeader(r7, r8)).array();
        L39:
            if (RequestBody.class.isAssignableFrom(r0) == false) goto L42;
            return new ParameterHandler.ConverterPart(getRequestBodyHeader(r7, r8));
        }

        @Nullable
        private ParameterHandler<?> partMapAdapt(ParameterizedType r1, Annotation r2) {
            if (RequestBody.class.isAssignableFrom(Utils.getRawType(Utils.getParameterUpperBound(1, r1))) == true) goto L5;
            return null;
        L5:
            return new ParameterHandler.ConverterPartMap(((PartMap) r2).encoding());
        }

        private void validateMethodName(int r4, String r5) {
            /*  JADX ERROR: Simple mode code generation failed
                java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
                	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
                	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
                	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
                	at java.base/java.util.Objects.checkIndex(Objects.java:365)
                	at java.base/java.util.ArrayList.get(ArrayList.java:428)
                	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
                	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                */
            /*
                this = this;
                java.util.regex.Pattern r0 = com.bytedance.retrofit2.RequestFactory.Builder.PARAM_NAME_REGEX     // Catch: java.lang.IllegalArgumentException -> L20
                java.util.regex.Matcher r0 = r0.matcher(r5)     // Catch: java.lang.IllegalArgumentException -> L20
                boolean r0 = r0.matches()     // Catch: java.lang.IllegalArgumentException -> L20
                if (r0 == 0) goto Ld
                goto L2d
            Ld:
                java.lang.reflect.Method r0 = r3.method     // Catch: java.lang.IllegalArgumentException -> L20
                java.lang.String r1 = "@Method parameter name must match %s. Found: %s"
                java.util.regex.Pattern r2 = com.bytedance.retrofit2.RequestFactory.Builder.PARAM_URL_REGEX     // Catch: java.lang.IllegalArgumentException -> L20
                java.lang.String r2 = r2.pattern()     // Catch: java.lang.IllegalArgumentException -> L20
                java.lang.Object[] r2 = new java.lang.Object[]{r2, r5}     // Catch: java.lang.IllegalArgumentException -> L20
                java.lang.RuntimeException r0 = com.bytedance.retrofit2.Utils.parameterError(r0, r4, r1, r2)     // Catch: java.lang.IllegalArgumentException -> L20
                throw r0     // Catch: java.lang.IllegalArgumentException -> L20
            L20:
                r0 = move-exception
                java.lang.String r1 = r0.getMessage()
                java.lang.String r2 = "@Method parameter name must match"
                boolean r1 = r1.contains(r2)
                if (r1 != 0) goto L48
            L2d:
                java.lang.String r0 = r3.methodParamName
                if (r0 == 0) goto L47
                boolean r0 = r0.equals(r5)
                if (r0 == 0) goto L38
                goto L47
            L38:
                java.lang.reflect.Method r0 = r3.method
                java.lang.String r3 = r3.httpMethod
                java.lang.Object[] r3 = new java.lang.Object[]{r3, r5}
                java.lang.String r5 = "Method \"%s\" does not contain \"{%s}\"."
                java.lang.RuntimeException r3 = com.bytedance.retrofit2.Utils.parameterError(r0, r4, r5, r3)
                throw r3
            L47:
                return
            L48:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.retrofit2.RequestFactory.Builder.validateMethodName(int, java.lang.String):void");
        }

        private void validatePathName(int r4, String r5) {
        L7:
            e = move-exception;
            if (e.getMessage().contains("@Path parameter name must match") == false) goto L11;
            throw e;
        L11:
            if (this.relativeUrlParamNames.contains(r5) == false) goto L14;
            return;
        L14:
            throw Utils.parameterError(this.method, r4, "URL \"%s\" does not contain \"{%s}\".", new Object[]{this.relativeUrl, r5});
        L3:
            if (PARAM_NAME_REGEX.matcher(r5).matches() == true) goto L11;
            throw Utils.parameterError(this.method, r4, "@Path parameter name must match %s. Found: %s", new Object[]{PARAM_URL_REGEX.pattern(), r5});     // Catch: IllegalArgumentException -> L7
        }

        private void validateResolvableType(int r2, Type r3) {
            if (Utils.hasUnresolvableType(r3) == true) goto L6;
            return;
        L6:
            throw Utils.parameterError(this.method, r2, "Parameter type must not include a type variable or wildcard: %s", new Object[]{r3});
        }

        public RequestFactory build() {
            Annotation[] r0 = this.methodAnnotations;
            int r1 = r0.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L9;
            Annotation r4 = r0[r3];
            parseMethodAnnotation(r4);
            if (Platform.squareRetrofitExists() == false) goto L7;
            parseSquareMethodAnnotation(r4);
        L7:
            r3 = r3 + 1;
            goto L3
        L9:
            if (this.httpMethod == null) goto L66;
            if (this.hasBody == false) goto L13;
        L23:
            int r2 = this.parameterAnnotationsArray.length;
            this.parameterHandlers = new ParameterHandler[r2];
            int r5 = r2 - 1;
            int r6 = 0;
        L24:
            if (r6 >= r2) goto L31;
            ParameterHandler<?>[] r7 = this.parameterHandlers;
            Type r8 = this.parameterTypes[r6];
            Annotation[] r9 = this.parameterAnnotationsArray[r6];
            if (r6 != r5) goto L28;
            boolean r10 = true;
        L29:
            r7[r6] = parseParameter(r6, r8, r9, r10);
            r6 = r6 + 1;
            goto L24
        L28:
            r10 = false;
            goto L29
        L31:
            if (this.relativeUrl == null) goto L33;
        L37:
            boolean r11 = this.isFormEncoded;
            if (r11 == false) goto L40;
        L50:
            if (r11 == false) goto L57;
            if (this.gotField == true) goto L57;
            throw Utils.methodError(this.method, "Form-encoded method must contain at least one @Field.", new Object[0]);
        L57:
            if (this.isMultipart == false) goto L64;
            if (this.gotPart == true) goto L64;
            throw Utils.methodError(this.method, "Multipart method must contain at least one @Part.", new Object[0]);
        L64:
            return new RequestFactory(this);
        L40:
            if (this.isMultipart == true) goto L50;
            if (this.hasBody == true) goto L50;
            if (this.isCustomMethod == true) goto L50;
            if (this.gotBody == false) goto L50;
            throw Utils.methodError(this.method, "Non-body HTTP method cannot contain @Body.", new Object[0]);
        L33:
            if (this.gotUrl == true) goto L37;
            throw Utils.methodError(this.method, "Missing either @%s URL or @Url parameter.", new Object[]{this.httpMethod});
        L13:
            if (this.isCustomMethod == true) goto L23;
            if (this.isMultipart == true) goto L22;
            if (this.isFormEncoded == false) goto L23;
            throw Utils.methodError(this.method, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
        L22:
            throw Utils.methodError(this.method, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
        L66:
            throw Utils.methodError(this.method, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
        }
    }

    public RequestFactory(Builder r2) {
        this.clientProvider = r2.retrofit.clientProvider();
        this.interceptors = r2.retrofit.interceptors();
        this.httpExecutor = r2.retrofit.httpExecutor();
        this.server = r2.retrofit.server();
        this.responseConverter = r2.responseConverter;
        this.httpMethod = r2.httpMethod;
        this.relativeUrl = r2.relativeUrl;
        this.hasBody = r2.hasBody;
        this.isFormEncoded = r2.isFormEncoded;
        this.isMultipart = r2.isMultipart;
        this.parameterHandlers = r2.parameterHandlers;
        this.headers = r2.headers;
        this.contentTypeHeader = r2.contentTypeHeader;
        this.priorityLevel = r2.priorityLevel;
        this.requestPriorityLevel = r2.requestPriorityLevel;
        this.serviceType = r2.serviceType;
        this.isResponseStreaming = r2.isResponseStreaming;
        this.maxLength = r2.maxLength;
        this.addCommonParam = r2.addCommonParam;
        this.commonParamLevel = r2.commonParamLevel;
        this.extraInfo = r2.extraInfo;
        this.method = r2.method;
        this.cacheServer = r2.retrofit.cacheServer();
        this.isKotlinSuspendFunction = r2.isKotlinSuspendFunction;
        this.retrofitMetrics = r2.retrofitMetrics;
        this.enableRecordFormFields = r2.enableRecordFormFields;
    }

    public static RequestFactory parseAnnotations(Retrofit r1, Method r2, RetrofitMetrics r3) {
        return new Builder(r1, r2, r3).build();
    }

    public RetrofitMetrics getRetrofitMetrics() {
        return this.retrofitMetrics;
    }

    public void setRetrofitMetrics(RetrofitMetrics r1) {
        this.retrofitMetrics = r1;
    }

    public Request toRequest(ExpandCallback r22, Object... r23) {
        RequestBuilder r15 = new RequestBuilder(this.httpMethod, this.server, this.relativeUrl, this.headers, this.contentTypeHeader, this.priorityLevel, this.requestPriorityLevel, this.isResponseStreaming, this.maxLength, this.addCommonParam, this.commonParamLevel, this.extraInfo, this.hasBody, this.isFormEncoded, this.isMultipart, this.serviceType, this.enableRecordFormFields);
        ParameterHandler<?>[] r1 = this.parameterHandlers;
        int r2 = 0;
        if (r23 == null) goto L5;
        int r4 = r23.length;
    L7:
        if (r4 != r1.length) goto L17;
        if (this.isKotlinSuspendFunction == false) goto L11;
        r4 = r4 - 1;
    L11:
        ArrayList r5 = new ArrayList(r4);
    L12:
        if (r2 >= r4) goto L14;
        r5.add(r23[r2]);
        r1[r2].apply(r15, r23[r2]);
        r2 = r2 + 1;
        goto L12
    L14:
        r15.addTag(Invocation.class, new Invocation(this.method, r5));
        return r15.build(r22);
    L17:
        throw new IllegalArgumentException(a.n(a.p(r4, "Argument count (", ") doesn't match expected count ("), ")", r1.length));
    L5:
        r4 = 0;
        goto L7
    }

    public T toResponse(TypedInput r1) {
        return this.responseConverter.convert(r1);
    }
}
