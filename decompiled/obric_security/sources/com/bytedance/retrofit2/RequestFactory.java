package com.bytedance.retrofit2;

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
import com.bytedance.retrofit2.http.Headers;
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
import java.io.IOException;
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

    static final class Builder<T> {
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

        Builder(Retrofit r4, Method r5, RetrofitMetrics r6) {
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

        RequestFactory build() {
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
            if (this.httpMethod == null) goto L67;
            if (this.hasBody == false) goto L13;
        L23:
            int r2 = this.parameterAnnotationsArray.length;
            this.parameterHandlers = new ParameterHandler[r2];
            int r5 = r2 - 1;
            int r6 = 0;
        L24:
            boolean r7 = true;
            if (r6 >= r2) goto L32;
            ParameterHandler<?>[] r8 = this.parameterHandlers;
            Type r9 = this.parameterTypes[r6];
            Annotation[] r10 = this.parameterAnnotationsArray[r6];
            if (r6 == r5) goto L30;
            r7 = false;
        L30:
            r8[r6] = parseParameter(r6, r9, r10, r7);
            r6 = r6 + 1;
            goto L24
        L32:
            if (this.relativeUrl == null) goto L34;
        L38:
            boolean r11 = this.isFormEncoded;
            if (r11 == false) goto L41;
        L51:
            if (r11 == false) goto L58;
            if (this.gotField == true) goto L58;
            throw Utils.methodError(this.method, "Form-encoded method must contain at least one @Field.", new Object[0]);
        L58:
            if (this.isMultipart == false) goto L65;
            if (this.gotPart == true) goto L65;
            throw Utils.methodError(this.method, "Multipart method must contain at least one @Part.", new Object[0]);
        L65:
            return new RequestFactory(this);
        L41:
            if (this.isMultipart == true) goto L51;
            if (this.hasBody == true) goto L51;
            if (this.isCustomMethod == true) goto L51;
            if (this.gotBody == false) goto L51;
            throw Utils.methodError(this.method, "Non-body HTTP method cannot contain @Body.", new Object[0]);
        L34:
            if (this.gotUrl == true) goto L38;
            throw Utils.methodError(this.method, "Missing either @%s URL or @Url parameter.", new Object[]{this.httpMethod});
        L13:
            if (this.isCustomMethod == true) goto L23;
            if (this.isMultipart == true) goto L22;
            if (this.isFormEncoded == false) goto L23;
            throw Utils.methodError(this.method, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
        L22:
            throw Utils.methodError(this.method, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
        L67:
            throw Utils.methodError(this.method, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
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
            parseHttpMethodAndPath("POST", ((POST) r5).value(), true);
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
            if ((r5 instanceof Headers) == false) goto L34;
            String[] r7 = ((Headers) r5).value();
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
            parseHttpMethodAndPath("POST", ((retrofit2.http.POST) r5).value(), true);
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

        private void parseHttpMethodAndPath(String r4, String r5, boolean r6) {
            String r0 = this.httpMethod;
            if (r0 != null) goto L31;
            this.httpMethod = r4;
            if (r4 == null) goto L8;
            this.methodParamName = parseMethodParameters(r4);
        L8:
            if (this.methodParamName == null) goto L10;
            this.isCustomMethod = true;
        L10:
            this.hasBody = r6;
            if (r5.isEmpty() == false) goto L13;
            return;
        L13:
            int r7 = r5.indexOf(63);
            if (r7 != (-1)) goto L16;
        L28:
            this.relativeUrl = r5;
            this.relativeUrlParamNames = parsePathParameters(r5);
            return;
        L16:
            if (r7 >= (r5.length() - 1)) goto L28;
            String r8 = r5.substring(r7 + 1);     // Catch: IllegalArgumentException -> L23
            if (PARAM_URL_REGEX.matcher(r8).find() == false) goto L28;
            throw Utils.methodError(this.method, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", new Object[]{r8});     // Catch: IllegalArgumentException -> L23
        L23:
            e = move-exception;
            if (e.getMessage().contains("URL query string") == false) goto L28;
            throw e;
        L31:
            throw Utils.methodError(this.method, "Only one HTTP method is allowed. Found: %s and %s.", new Object[]{r0, r4});
        }

        private List<Header> parseHeaders(String[] r9) {
            ArrayList r0 = new ArrayList();
            int r1 = r9.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L16;
            String r4 = r9[r3];
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
        private ParameterHandler<?> parseParameterAnnotation(int r7, Type r8, Annotation[] r9, Annotation r10) {
            if ((r10 instanceof Url) == false) goto L42;
            validateResolvableType(r7, r8);
            if (this.gotUrl == true) goto L40;
            if (this.gotPath == true) goto L38;
            if (this.gotQuery == true) goto L36;
            if (this.relativeUrl != null) goto L34;
            if (this.gotQueryName == true) goto L32;
            if (this.gotQueryMap == true) goto L30;
            this.gotUrl = true;
            if (r8 == String.class) goto L28;
            if (r8 == URI.class) goto L28;
            if ((r8 instanceof Class) == false) goto L26;
            if ("android.net.Uri".equals(((Class) r8).getName()) == true) goto L28;
        L26:
            throw Utils.parameterError(this.method, r7, "@Url must be String, java.net.URI, or android.net.Uri type.", new Object[0]);
        L28:
            return new ParameterHandler.RelativeUrl(this.method, r7);
        L30:
            throw Utils.parameterError(this.method, r7, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
        L32:
            throw Utils.parameterError(this.method, r7, "A @Url parameter must not come after a @QueryName.", new Object[0]);
        L34:
            throw Utils.parameterError(this.method, r7, "@Url cannot be used with @%s URL", new Object[]{this.httpMethod});
        L36:
            throw Utils.parameterError(this.method, r7, "A @Url parameter must not come after a @Query.", new Object[0]);
        L38:
            throw Utils.parameterError(this.method, r7, "@Path parameters may not be used with @Url.", new Object[0]);
        L40:
            throw Utils.parameterError(this.method, r7, "Multiple @Url method annotations found.", new Object[0]);
        L42:
            if ((r10 instanceof Path) == false) goto L66;
            validateResolvableType(r7, r8);
            if (this.gotQuery == true) goto L64;
            if (this.gotUrl == true) goto L62;
            if (this.relativeUrl == null) goto L60;
            if (this.gotQueryName == true) goto L58;
            if (this.gotQueryMap == true) goto L56;
            this.gotPath = true;
            Path r11 = (Path) r10;
            String r3 = r11.value();
            validatePathName(r7, r3);
            return new ParameterHandler.Path(this.method, r7, r3, this.retrofit.stringConverter(r8, r9), r11.encode());
        L56:
            throw Utils.parameterError(this.method, r7, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
        L58:
            throw Utils.parameterError(this.method, r7, "A @Path parameter must not come after a @QueryName.", new Object[0]);
        L60:
            throw Utils.parameterError(this.method, r7, "@Path can only be used with relative url on @%s", new Object[]{this.httpMethod});
        L62:
            throw Utils.parameterError(this.method, r7, "@Path parameters may not be used with @Url.", new Object[0]);
        L64:
            throw Utils.parameterError(this.method, r7, "A @Path parameter must not come after a @Query.", new Object[0]);
        L66:
            if ((r10 instanceof Query) == false) goto L82;
            validateResolvableType(r7, r8);
            Query r12 = (Query) r10;
            String r0 = r12.value();
            boolean r13 = r12.encode();
            Class<?> r5 = Utils.getRawType(r8);
            this.gotQuery = true;
            if (Iterable.class.isAssignableFrom(r5) == false) goto L76;
            if ((r8 instanceof ParameterizedType) == false) goto L74;
            return new ParameterHandler.Query(r0, this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) r8), r9), r13).iterable();
        L74:
            throw Utils.parameterError(this.method, r7, r5.getSimpleName() + " must include generic type (e.g., " + r5.getSimpleName() + "<String>)", new Object[0]);
        L76:
            if (r5.isArray() == false) goto L80;
            return new ParameterHandler.Query(r0, this.retrofit.stringConverter(boxIfPrimitive(r5.getComponentType()), r9), r13).array();
        L80:
            return new ParameterHandler.Query(r0, this.retrofit.stringConverter(r8, r9), r13);
        L82:
            if ((r10 instanceof QueryName) == false) goto L98;
            validateResolvableType(r7, r8);
            boolean r14 = ((QueryName) r10).encoded();
            Class<?> r1 = Utils.getRawType(r8);
            this.gotQueryName = true;
            if (Iterable.class.isAssignableFrom(r1) == false) goto L92;
            if ((r8 instanceof ParameterizedType) == false) goto L90;
            return new ParameterHandler.QueryName(this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) r8), r9), r14).iterable();
        L90:
            throw Utils.parameterError(this.method, r7, r1.getSimpleName() + " must include generic type (e.g., " + r1.getSimpleName() + "<String>)", new Object[0]);
        L92:
            if (r1.isArray() == false) goto L96;
            return new ParameterHandler.QueryName(this.retrofit.stringConverter(boxIfPrimitive(r1.getComponentType()), r9), r14).array();
        L96:
            return new ParameterHandler.QueryName(this.retrofit.stringConverter(r8, r9), r14);
        L98:
            if ((r10 instanceof QueryMap) == false) goto L114;
            validateResolvableType(r7, r8);
            Class<?> r2 = Utils.getRawType(r8);
            this.gotQueryMap = true;
            if (Map.class.isAssignableFrom(r2) == false) goto L112;
            Type r15 = Utils.getSupertype(r8, r2, Map.class);
            if ((r15 instanceof ParameterizedType) == false) goto L110;
            ParameterizedType r16 = (ParameterizedType) r15;
            Type r4 = Utils.getParameterUpperBound(0, r16);
            if (String.class != r4) goto L108;
            return new ParameterHandler.QueryMap(this.method, r7, this.retrofit.stringConverter(Utils.getParameterUpperBound(1, r16), r9), ((QueryMap) r10).encode());
        L108:
            throw Utils.parameterError(this.method, r7, "@QueryMap keys must be of type String: " + r4, new Object[0]);
        L110:
            throw Utils.parameterError(this.method, r7, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L112:
            throw Utils.parameterError(this.method, r7, "@QueryMap parameter type must be Map.", new Object[0]);
        L114:
            if ((r10 instanceof com.bytedance.retrofit2.http.Header) == false) goto L130;
            validateResolvableType(r7, r8);
            String r17 = ((com.bytedance.retrofit2.http.Header) r10).value();
            Class<?> r6 = Utils.getRawType(r8);
            if (Iterable.class.isAssignableFrom(r6) == false) goto L124;
            if ((r8 instanceof ParameterizedType) == false) goto L122;
            return new ParameterHandler.Header(r17, this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) r8), r9)).iterable();
        L122:
            throw Utils.parameterError(this.method, r7, r6.getSimpleName() + " must include generic type (e.g., " + r6.getSimpleName() + "<String>)", new Object[0]);
        L124:
            if (r6.isArray() == false) goto L128;
            return new ParameterHandler.Header(r17, this.retrofit.stringConverter(boxIfPrimitive(r6.getComponentType()), r9)).array();
        L128:
            return new ParameterHandler.Header(r17, this.retrofit.stringConverter(r8, r9));
        L130:
            if ((r10 instanceof HeaderList) == false) goto L146;
            Class<?> r18 = Utils.getRawType(r8);
            if (List.class.isAssignableFrom(r18) == false) goto L144;
            Type r19 = Utils.getSupertype(r8, r18, List.class);
            if ((r19 instanceof ParameterizedType) == false) goto L142;
            Type r20 = Utils.getParameterUpperBound(0, (ParameterizedType) r19);
            if (Header.class != r20) goto L140;
            return new ParameterHandler.HeaderList(this.retrofit.headerConverter(r20, r9));
        L140:
            throw Utils.parameterError(this.method, r7, "@HeaderList keys must be of type retrofit.client.Header: " + r20, new Object[0]);
        L142:
            throw Utils.parameterError(this.method, r7, "List must include generic types (e.g., List<Header>)", new Object[0]);
        L144:
            throw Utils.parameterError(this.method, r7, "@HeaderList parameter type must be List.", new Object[0]);
        L146:
            if ((r10 instanceof HeaderMap) == false) goto L162;
            validateResolvableType(r7, r8);
            Class<?> r110 = Utils.getRawType(r8);
            if (Map.class.isAssignableFrom(r110) == false) goto L160;
            Type r21 = Utils.getSupertype(r8, r110, Map.class);
            if ((r21 instanceof ParameterizedType) == false) goto L158;
            ParameterizedType r22 = (ParameterizedType) r21;
            Type r111 = Utils.getParameterUpperBound(0, r22);
            if (String.class != r111) goto L156;
            return new ParameterHandler.HeaderMap(this.method, r7, this.retrofit.stringConverter(Utils.getParameterUpperBound(1, r22), r9));
        L156:
            throw Utils.parameterError(this.method, r7, "@HeaderMap keys must be of type String: " + r111, new Object[0]);
        L158:
            throw Utils.parameterError(this.method, r7, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L160:
            throw Utils.parameterError(this.method, r7, "@HeaderMap parameter type must be Map.", new Object[0]);
        L162:
            if ((r10 instanceof Field) == false) goto L182;
            validateResolvableType(r7, r8);
            if (this.isFormEncoded == false) goto L180;
            Field r112 = (Field) r10;
            String r23 = r112.value();
            boolean r113 = r112.encode();
            this.gotField = true;
            Class<?> r24 = Utils.getRawType(r8);
            if (Iterable.class.isAssignableFrom(r24) == false) goto L174;
            if ((r8 instanceof ParameterizedType) == false) goto L172;
            return new ParameterHandler.Field(r23, this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) r8), r9), r113).iterable();
        L172:
            throw Utils.parameterError(this.method, r7, r24.getSimpleName() + " must include generic type (e.g., " + r24.getSimpleName() + "<String>)", new Object[0]);
        L174:
            if (r24.isArray() == false) goto L178;
            return new ParameterHandler.Field(r23, this.retrofit.stringConverter(boxIfPrimitive(r24.getComponentType()), r9), r113).array();
        L178:
            return new ParameterHandler.Field(r23, this.retrofit.stringConverter(r8, r9), r113);
        L180:
            throw Utils.parameterError(this.method, r7, "@Field parameters can only be used with form encoding.", new Object[0]);
        L182:
            if ((r10 instanceof FieldMap) == false) goto L202;
            validateResolvableType(r7, r8);
            if (this.isFormEncoded == false) goto L200;
            Class<?> r25 = Utils.getRawType(r8);
            if (Map.class.isAssignableFrom(r25) == false) goto L198;
            Type r26 = Utils.getSupertype(r8, r25, Map.class);
            if ((r26 instanceof ParameterizedType) == false) goto L196;
            ParameterizedType r27 = (ParameterizedType) r26;
            Type r28 = Utils.getParameterUpperBound(0, r27);
            if (String.class != r28) goto L194;
            Converter<T, String> r29 = this.retrofit.stringConverter(Utils.getParameterUpperBound(1, r27), r9);
            this.gotField = true;
            return new ParameterHandler.FieldMap(this.method, r7, r29, ((FieldMap) r10).encode());
        L194:
            throw Utils.parameterError(this.method, r7, "@FieldMap keys must be of type String: " + r28, new Object[0]);
        L196:
            throw Utils.parameterError(this.method, r7, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L198:
            throw Utils.parameterError(this.method, r7, "@FieldMap parameter type must be Map.", new Object[0]);
        L200:
            throw Utils.parameterError(this.method, r7, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
        L202:
            if ((r10 instanceof Part) == false) goto L213;
            if (this.isMultipart == false) goto L211;
            Part r114 = (Part) r10;
            this.gotPart = true;
            ParameterHandler<?> r30 = partAdapt(r8, r114.value(), r114.encoding());
            if (r30 == null) goto L209;
            return r30;
        L209:
            return new ParameterHandler.Part(this.method, r7, r114.value(), this.retrofit.requestBodyConverter(r8, r9, this.methodAnnotations));
        L211:
            throw Utils.parameterError(this.method, r7, "@Part parameters can only be used with multipart encoding.", new Object[0]);
        L213:
            if ((r10 instanceof PartMap) == false) goto L236;
            validateResolvableType(r7, r8);
            if (this.isMultipart == false) goto L234;
            this.gotPart = true;
            Class<?> r31 = Utils.getRawType(r8);
            if (Map.class.isAssignableFrom(r31) == false) goto L232;
            Type r32 = Utils.getSupertype(r8, r31, Map.class);
            if ((r32 instanceof ParameterizedType) == false) goto L230;
            ParameterizedType r33 = (ParameterizedType) r32;
            Type r34 = Utils.getParameterUpperBound(0, r33);
            if (String.class != r34) goto L228;
            ParameterHandler<?> r35 = partMapAdapt(r33, r10);
            if (r35 == null) goto L226;
            return r35;
        L226:
            return new ParameterHandler.PartMap(this.method, r7, this.retrofit.requestBodyConverter(Utils.getParameterUpperBound(1, r33), r9, this.methodAnnotations), ((PartMap) r10).encoding());
        L228:
            throw Utils.parameterError(this.method, r7, "@PartMap keys must be of type String: " + r34, new Object[0]);
        L230:
            throw Utils.parameterError(this.method, r7, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L232:
            throw Utils.parameterError(this.method, r7, "@PartMap parameter type must be Map.", new Object[0]);
        L234:
            throw Utils.parameterError(this.method, r7, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
        L236:
            if ((r10 instanceof Body) == false) goto L258;
            validateResolvableType(r7, r8);
            if (this.isFormEncoded == true) goto L256;
            if (this.isMultipart == true) goto L256;
            if (this.gotBody == true) goto L254;
            ParameterHandler<?> r115 = bodyAdapt(r8);
            if (r115 == null) goto L320;
            this.gotBody = true;
            return r115;
        L320:
            Converter<T, TypedOutput> r36 = this.retrofit.requestBodyConverter(r8, r9, this.methodAnnotations);     // Catch: RuntimeException -> L250
            this.gotBody = true;
            return new ParameterHandler.Body(this.method, r7, this.isCustomMethod, r36);
        L250:
            e = move-exception;
            throw Utils.parameterError(this.method, e, r7, "Unable to create @Body converter for %s", new Object[]{r8});
        L254:
            throw Utils.parameterError(this.method, r7, "Multiple @Body method annotations found.", new Object[0]);
        L256:
            throw Utils.parameterError(this.method, r7, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
        L258:
            if ((r10 instanceof com.bytedance.retrofit2.http.Method) == false) goto L266;
            if (this.gotMethod == true) goto L264;
            this.gotMethod = true;
            String r116 = ((com.bytedance.retrofit2.http.Method) r10).value();
            validateMethodName(r7, r116);
            return new ParameterHandler.Method(r116, this.retrofit.stringConverter(r8, r9));
        L264:
            throw Utils.parameterError(this.method, r7, "Multiple @Method method annotations found.", new Object[0]);
        L266:
            if ((r10 instanceof MaxLength) == false) goto L274;
            return new ParameterHandler.MaxLength(this.retrofit.stringConverter(r8, r9));
        L270:
            e = move-exception;
            throw Utils.parameterError(this.method, e, r7, "Unable to create @MaxLength converter for %s", new Object[]{r8});
        L274:
            if ((r10 instanceof AddCommonParam) == false) goto L283;
            this.commonParamLevel = ((AddCommonParam) r10).level();
            return new ParameterHandler.AddCommonParam(this.retrofit.stringConverter(r8, r9));
        L279:
            e = move-exception;
            throw Utils.parameterError(this.method, e, r7, "Unable to create @AddCommonParam converter for %s", new Object[]{r8});
        L283:
            if ((r10 instanceof ExtraInfo) == false) goto L291;
            return new ParameterHandler.ExtraInfo(this.retrofit.objectConverter(r8, r9));
        L287:
            e = move-exception;
            throw Utils.parameterError(this.method, e, r7, "Unable to create @ExtraInfo converter for %s", new Object[]{r8});
        L291:
            if ((r10 instanceof QueryObject) == false) goto L299;
            if (QueryParamObject.class.isAssignableFrom(Utils.getRawType(r8)) == false) goto L297;
            return new ParameterHandler.QueryObject();
        L297:
            throw Utils.parameterError(this.method, r7, "Unable to create @QueryObject for %s not QueryParamObject type", new Object[]{r8});
        L299:
            if ((r10 instanceof Tag) == false) goto L312;
            validateResolvableType(r7, r8);
            Class<?> r37 = Utils.getRawType(r8);
            int r38 = r7 - 1;
        L301:
            if (r38 < 0) goto L311;
            ParameterHandler<?> r117 = this.parameterHandlers[r38];
            if ((r117 instanceof ParameterHandler.Tag) == false) goto L309;
            if (((ParameterHandler.Tag) r117).cls.equals(r37) == false) goto L309;
            throw Utils.parameterError(this.method, r7, "@Tag type " + r37.getName() + " is duplicate of parameter #" + (r38 + 1) + " and would always overwrite its value.", new Object[0]);
        L309:
            r38 = r38 - 1;
            goto L301
        L311:
            return new ParameterHandler.Tag(r37);
        L312:
            return null;
        }

        private ParameterHandler<?> parseSquareParameterAnnotation(int r10, Type r11, Annotation[] r12, Annotation r13) {
            if ((r13 instanceof retrofit2.http.Url) == false) goto L42;
            validateResolvableType(r10, r11);
            if (this.gotUrl == true) goto L40;
            if (this.gotPath == true) goto L38;
            if (this.gotQuery == true) goto L36;
            if (this.gotQueryName == true) goto L34;
            if (this.gotQueryMap == true) goto L32;
            if (this.relativeUrl != null) goto L30;
            this.gotUrl = true;
            if (r11 == String.class) goto L28;
            if (r11 == URI.class) goto L28;
            if ((r11 instanceof Class) == false) goto L26;
            if ("android.net.Uri".equals(((Class) r11).getName()) == true) goto L28;
        L26:
            throw Utils.parameterError(this.method, r10, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
        L28:
            return new ParameterHandler.RelativeUrl(this.method, r10);
        L30:
            throw Utils.parameterError(this.method, r10, "@Url cannot be used with @%s URL", new Object[]{this.httpMethod});
        L32:
            throw Utils.parameterError(this.method, r10, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
        L34:
            throw Utils.parameterError(this.method, r10, "A @Url parameter must not come after a @QueryName.", new Object[0]);
        L36:
            throw Utils.parameterError(this.method, r10, "A @Url parameter must not come after a @Query.", new Object[0]);
        L38:
            throw Utils.parameterError(this.method, r10, "@Path parameters may not be used with @Url.", new Object[0]);
        L40:
            throw Utils.parameterError(this.method, r10, "Multiple @Url method annotations found.", new Object[0]);
        L42:
            if ((r13 instanceof retrofit2.http.Path) == false) goto L66;
            validateResolvableType(r10, r11);
            if (this.gotQuery == true) goto L64;
            if (this.gotQueryName == true) goto L62;
            if (this.gotQueryMap == true) goto L60;
            if (this.gotUrl == true) goto L58;
            if (this.relativeUrl == null) goto L56;
            this.gotPath = true;
            retrofit2.http.Path r14 = (retrofit2.http.Path) r13;
            String r6 = r14.value();
            validatePathName(r10, r6);
            return new ParameterHandler.Path(this.method, r10, r6, this.retrofit.stringConverter(r11, r12), !r14.encoded());
        L56:
            throw Utils.parameterError(this.method, r10, "@Path can only be used with relative url on @%s", new Object[]{this.httpMethod});
        L58:
            throw Utils.parameterError(this.method, r10, "@Path parameters may not be used with @Url.", new Object[0]);
        L60:
            throw Utils.parameterError(this.method, r10, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
        L62:
            throw Utils.parameterError(this.method, r10, "A @Path parameter must not come after a @QueryName.", new Object[0]);
        L64:
            throw Utils.parameterError(this.method, r10, "A @Path parameter must not come after a @Query.", new Object[0]);
        L66:
            if ((r13 instanceof retrofit2.http.Query) == false) goto L82;
            validateResolvableType(r10, r11);
            retrofit2.http.Query r15 = (retrofit2.http.Query) r13;
            String r0 = r15.value();
            boolean r16 = r15.encoded();
            Class<?> r5 = Utils.getRawType(r11);
            this.gotQuery = true;
            if (Iterable.class.isAssignableFrom(r5) == false) goto L76;
            if ((r11 instanceof ParameterizedType) == false) goto L74;
            return new ParameterHandler.Query(r0, this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) r11), r12), !r16).iterable();
        L74:
            throw Utils.parameterError(this.method, r10, r5.getSimpleName() + " must include generic type (e.g., " + r5.getSimpleName() + "<String>)", new Object[0]);
        L76:
            if (r5.isArray() == false) goto L80;
            return new ParameterHandler.Query(r0, this.retrofit.stringConverter(boxIfPrimitive(r5.getComponentType()), r12), !r16).array();
        L80:
            return new ParameterHandler.Query(r0, this.retrofit.stringConverter(r11, r12), !r16);
        L82:
            if ((r13 instanceof retrofit2.http.QueryName) == false) goto L98;
            validateResolvableType(r10, r11);
            boolean r17 = ((retrofit2.http.QueryName) r13).encoded();
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
            if ((r13 instanceof retrofit2.http.QueryMap) == false) goto L114;
            validateResolvableType(r10, r11);
            Class<?> r2 = Utils.getRawType(r11);
            this.gotQueryMap = true;
            if (Map.class.isAssignableFrom(r2) == false) goto L112;
            Type r18 = Utils.getSupertype(r11, r2, Map.class);
            if ((r18 instanceof ParameterizedType) == false) goto L110;
            ParameterizedType r19 = (ParameterizedType) r18;
            Type r3 = Utils.getParameterUpperBound(0, r19);
            if (String.class != r3) goto L108;
            return new ParameterHandler.QueryMap(this.method, r10, this.retrofit.stringConverter(Utils.getParameterUpperBound(1, r19), r12), !((retrofit2.http.QueryMap) r13).encoded());
        L108:
            throw Utils.parameterError(this.method, r10, "@QueryMap keys must be of type String: " + r3, new Object[0]);
        L110:
            throw Utils.parameterError(this.method, r10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L112:
            throw Utils.parameterError(this.method, r10, "@QueryMap parameter type must be Map.", new Object[0]);
        L114:
            if ((r13 instanceof retrofit2.http.Header) == false) goto L130;
            validateResolvableType(r10, r11);
            String r110 = ((retrofit2.http.Header) r13).value();
            Class<?> r4 = Utils.getRawType(r11);
            if (Iterable.class.isAssignableFrom(r4) == false) goto L124;
            if ((r11 instanceof ParameterizedType) == false) goto L122;
            return new ParameterHandler.Header(r110, this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) r11), r12)).iterable();
        L122:
            throw Utils.parameterError(this.method, r10, r4.getSimpleName() + " must include generic type (e.g., " + r4.getSimpleName() + "<String>)", new Object[0]);
        L124:
            if (r4.isArray() == false) goto L128;
            return new ParameterHandler.Header(r110, this.retrofit.stringConverter(boxIfPrimitive(r4.getComponentType()), r12)).array();
        L128:
            return new ParameterHandler.Header(r110, this.retrofit.stringConverter(r11, r12));
        L130:
            if ((r13 instanceof retrofit2.http.HeaderMap) == false) goto L146;
            validateResolvableType(r10, r11);
            Class<?> r111 = Utils.getRawType(r11);
            if (Map.class.isAssignableFrom(r111) == false) goto L144;
            Type r112 = Utils.getSupertype(r11, r111, Map.class);
            if ((r112 instanceof ParameterizedType) == false) goto L142;
            ParameterizedType r113 = (ParameterizedType) r112;
            Type r114 = Utils.getParameterUpperBound(0, r113);
            if (String.class != r114) goto L140;
            return new ParameterHandler.HeaderMap(this.method, r10, this.retrofit.stringConverter(Utils.getParameterUpperBound(1, r113), r12));
        L140:
            throw Utils.parameterError(this.method, r10, "@HeaderMap keys must be of type String: " + r114, new Object[0]);
        L142:
            throw Utils.parameterError(this.method, r10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L144:
            throw Utils.parameterError(this.method, r10, "@HeaderMap parameter type must be Map.", new Object[0]);
        L146:
            if ((r13 instanceof retrofit2.http.Field) == false) goto L166;
            validateResolvableType(r10, r11);
            if (this.isFormEncoded == false) goto L164;
            retrofit2.http.Field r115 = (retrofit2.http.Field) r13;
            String r7 = r115.value();
            boolean r116 = r115.encoded();
            this.gotField = true;
            Class<?> r8 = Utils.getRawType(r11);
            if (Iterable.class.isAssignableFrom(r8) == false) goto L158;
            if ((r11 instanceof ParameterizedType) == false) goto L156;
            return new ParameterHandler.Field(r7, this.retrofit.stringConverter(Utils.getParameterUpperBound(0, (ParameterizedType) r11), r12), !r116).iterable();
        L156:
            throw Utils.parameterError(this.method, r10, r8.getSimpleName() + " must include generic type (e.g., " + r8.getSimpleName() + "<String>)", new Object[0]);
        L158:
            if (r8.isArray() == false) goto L162;
            return new ParameterHandler.Field(r7, this.retrofit.stringConverter(boxIfPrimitive(r8.getComponentType()), r12), !r116).array();
        L162:
            return new ParameterHandler.Field(r7, this.retrofit.stringConverter(r11, r12), !r116);
        L164:
            throw Utils.parameterError(this.method, r10, "@Field parameters can only be used with form encoding.", new Object[0]);
        L166:
            if ((r13 instanceof retrofit2.http.FieldMap) == false) goto L186;
            validateResolvableType(r10, r11);
            if (this.isFormEncoded == false) goto L184;
            Class<?> r9 = Utils.getRawType(r11);
            if (Map.class.isAssignableFrom(r9) == false) goto L182;
            Type r117 = Utils.getSupertype(r11, r9, Map.class);
            if ((r117 instanceof ParameterizedType) == false) goto L180;
            ParameterizedType r118 = (ParameterizedType) r117;
            Type r20 = Utils.getParameterUpperBound(0, r118);
            if (String.class != r20) goto L178;
            Converter<T, String> r119 = this.retrofit.stringConverter(Utils.getParameterUpperBound(1, r118), r12);
            this.gotField = true;
            return new ParameterHandler.FieldMap(this.method, r10, r119, !((retrofit2.http.FieldMap) r13).encoded());
        L178:
            throw Utils.parameterError(this.method, r10, "@FieldMap keys must be of type String: " + r20, new Object[0]);
        L180:
            throw Utils.parameterError(this.method, r10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L182:
            throw Utils.parameterError(this.method, r10, "@FieldMap parameter type must be Map.", new Object[0]);
        L184:
            throw Utils.parameterError(this.method, r10, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
        L186:
            if ((r13 instanceof retrofit2.http.Part) == false) goto L197;
            if (this.isMultipart == false) goto L195;
            retrofit2.http.Part r120 = (retrofit2.http.Part) r13;
            this.gotPart = true;
            ParameterHandler<?> r21 = partAdapt(r11, r120.value(), r120.encoding());
            if (r21 == null) goto L193;
            return r21;
        L193:
            return new ParameterHandler.Part(this.method, r10, r120.value(), this.retrofit.requestBodyConverter(r11, r12, this.methodAnnotations));
        L195:
            throw Utils.parameterError(this.method, r10, "@Part parameters can only be used with multipart encoding.", new Object[0]);
        L197:
            if ((r13 instanceof retrofit2.http.PartMap) == false) goto L221;
            validateResolvableType(r10, r11);
            if (this.isMultipart == false) goto L219;
            this.gotPart = true;
            Class<?> r22 = Utils.getRawType(r11);
            if (Map.class.isAssignableFrom(r22) == false) goto L217;
            Type r121 = Utils.getSupertype(r11, r22, Map.class);
            if ((r121 instanceof ParameterizedType) == false) goto L215;
            ParameterizedType r122 = (ParameterizedType) r121;
            Type r23 = Utils.getParameterUpperBound(0, r122);
            if (String.class != r23) goto L213;
            Type r123 = Utils.getParameterUpperBound(1, r122);
            if (MultipartBody.Part.class.isAssignableFrom(Utils.getRawType(r123)) == true) goto L211;
            return new ParameterHandler.PartMap(this.method, r10, this.retrofit.requestBodyConverter(r123, r12, this.methodAnnotations), ((retrofit2.http.PartMap) r13).encoding());
        L211:
            throw Utils.parameterError(this.method, r10, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
        L213:
            throw Utils.parameterError(this.method, r10, "@PartMap keys must be of type String: " + r23, new Object[0]);
        L215:
            throw Utils.parameterError(this.method, r10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L217:
            throw Utils.parameterError(this.method, r10, "@PartMap parameter type must be Map.", new Object[0]);
        L219:
            throw Utils.parameterError(this.method, r10, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
        L221:
            if ((r13 instanceof retrofit2.http.Body) == false) goto L243;
            validateResolvableType(r10, r11);
            if (this.isFormEncoded == true) goto L241;
            if (this.isMultipart == true) goto L241;
            if (this.gotBody == true) goto L239;
            ParameterHandler<?> r124 = bodyAdapt(r11);
            if (r124 == null) goto L258;
            this.gotBody = true;
            return r124;
        L258:
            Converter<T, TypedOutput> r125 = this.retrofit.requestBodyConverter(r11, r12, this.methodAnnotations);     // Catch: RuntimeException -> L235
            this.gotBody = true;
            return new ParameterHandler.Body(this.method, r10, this.isCustomMethod, r125);
        L235:
            e = move-exception;
            throw Utils.parameterError(this.method, e, r10, "Unable to create @Body converter for %s", new Object[]{r11});
        L239:
            throw Utils.parameterError(this.method, r10, "Multiple @Body method annotations found.", new Object[0]);
        L241:
            throw Utils.parameterError(this.method, r10, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
        L243:
            if ((r13 instanceof retrofit2.http.Tag) == false) goto L256;
            validateResolvableType(r10, r11);
            Class<?> r126 = Utils.getRawType(r11);
            int r127 = r10 - 1;
        L245:
            if (r127 < 0) goto L255;
            ParameterHandler<?> r128 = this.parameterHandlers[r127];
            if ((r128 instanceof ParameterHandler.Tag) == false) goto L253;
            if (((ParameterHandler.Tag) r128).cls.equals(r126) == false) goto L253;
            throw Utils.parameterError(this.method, r10, "@Tag type " + r126.getName() + " is duplicate of parameter #" + (r127 + 1) + " and would always overwrite its value.", new Object[0]);
        L253:
            r127 = r127 - 1;
            goto L245
        L255:
            return new ParameterHandler.Tag(r126);
        L256:
            return null;
        }

        private ParameterHandler<?> partAdapt(Type r5, String r6, String r7) {
            Class<?> r0 = Utils.getRawType(r5);
            if (TextUtils.isEmpty(r6) == false) goto L24;
            if (Iterable.class.isAssignableFrom(r0) == false) goto L14;
            if ((r5 instanceof ParameterizedType) == true) goto L10;
            return null;
        L10:
            if (MultipartBody.Part.class.isAssignableFrom(Utils.getRawType(Utils.getParameterUpperBound(0, (ParameterizedType) r5))) == true) goto L12;
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
            if ((r5 instanceof ParameterizedType) == true) goto L29;
            return null;
        L29:
            if (RequestBody.class.isAssignableFrom(Utils.getRawType(Utils.getParameterUpperBound(0, (ParameterizedType) r5))) == false) goto L42;
            return new ParameterHandler.ConverterPart(getRequestBodyHeader(r6, r7)).iterable();
        L33:
            if (r0.isArray() == false) goto L39;
            if (RequestBody.class.isAssignableFrom(boxIfPrimitive(r0.getComponentType())) == false) goto L42;
            return new ParameterHandler.ConverterPart(getRequestBodyHeader(r6, r7)).array();
        L39:
            if (RequestBody.class.isAssignableFrom(r0) == false) goto L42;
            return new ParameterHandler.ConverterPart(getRequestBodyHeader(r6, r7));
        }

        @Nullable
        private ParameterHandler<?> partMapAdapt(ParameterizedType r1, Annotation r2) {
            if (RequestBody.class.isAssignableFrom(Utils.getRawType(Utils.getParameterUpperBound(1, r1))) == true) goto L5;
            return null;
        L5:
            return new ParameterHandler.ConverterPartMap(((PartMap) r2).encoding());
        }

        private ParameterHandler<?> bodyAdapt(Type r1) {
            if (RequestBody.class.isAssignableFrom(Utils.getRawType(r1)) == true) goto L5;
            return null;
        L5:
            return ParameterHandler.ConverterBody.INSTANCE;
        }

        private okhttp3.Headers getRequestBodyHeader(String r3, String r4) {
            return okhttp3.Headers.of(new String[]{"Content-Disposition", "form-data; name=\"" + r3 + "\"", "Content-Transfer-Encoding", r4});
        }

        private void validateMethodName(int r8, String r9) {
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
                r0 = 1
                r1 = 0
                r2 = 2
                java.util.regex.Pattern r3 = com.bytedance.retrofit2.RequestFactory.Builder.PARAM_NAME_REGEX     // Catch: java.lang.IllegalArgumentException -> L25
                java.util.regex.Matcher r3 = r3.matcher(r9)     // Catch: java.lang.IllegalArgumentException -> L25
                boolean r3 = r3.matches()     // Catch: java.lang.IllegalArgumentException -> L25
                if (r3 == 0) goto L10
                goto L32
            L10:
                java.lang.reflect.Method r3 = r7.method     // Catch: java.lang.IllegalArgumentException -> L25
                java.lang.String r4 = "@Method parameter name must match %s. Found: %s"
                java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch: java.lang.IllegalArgumentException -> L25
                java.util.regex.Pattern r6 = com.bytedance.retrofit2.RequestFactory.Builder.PARAM_URL_REGEX     // Catch: java.lang.IllegalArgumentException -> L25
                java.lang.String r6 = r6.pattern()     // Catch: java.lang.IllegalArgumentException -> L25
                r5[r1] = r6     // Catch: java.lang.IllegalArgumentException -> L25
                r5[r0] = r9     // Catch: java.lang.IllegalArgumentException -> L25
                java.lang.RuntimeException r3 = com.bytedance.retrofit2.Utils.parameterError(r3, r8, r4, r5)     // Catch: java.lang.IllegalArgumentException -> L25
                throw r3     // Catch: java.lang.IllegalArgumentException -> L25
            L25:
                r3 = move-exception
                java.lang.String r4 = r3.getMessage()
                java.lang.String r5 = "@Method parameter name must match"
                boolean r4 = r4.contains(r5)
                if (r4 != 0) goto L4f
            L32:
                java.lang.String r3 = r7.methodParamName
                if (r3 == 0) goto L4e
                boolean r3 = r3.equals(r9)
                if (r3 == 0) goto L3d
                goto L4e
            L3d:
                java.lang.reflect.Method r3 = r7.method
                java.lang.Object[] r2 = new java.lang.Object[r2]
                java.lang.String r7 = r7.httpMethod
                r2[r1] = r7
                r2[r0] = r9
                java.lang.String r7 = "Method \"%s\" does not contain \"{%s}\"."
                java.lang.RuntimeException r7 = com.bytedance.retrofit2.Utils.parameterError(r3, r8, r7, r2)
                throw r7
            L4e:
                return
            L4f:
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.retrofit2.RequestFactory.Builder.validateMethodName(int, java.lang.String):void");
        }

        private void validatePathName(int r8, String r9) {
        L8:
            e = move-exception;
            if (e.getMessage().contains("@Path parameter name must match") == false) goto L12;
            throw e;
        L12:
            if (this.relativeUrlParamNames.contains(r9) == false) goto L15;
            return;
        L15:
            throw Utils.parameterError(this.method, r8, "URL \"%s\" does not contain \"{%s}\".", new Object[]{this.relativeUrl, r9});
        L4:
            if (PARAM_NAME_REGEX.matcher(r9).matches() == true) goto L12;
            throw Utils.parameterError(this.method, r8, "@Path parameter name must match %s. Found: %s", new Object[]{PARAM_URL_REGEX.pattern(), r9});     // Catch: IllegalArgumentException -> L8
        }

        private void validateResolvableType(int r3, Type r4) {
            if (Utils.hasUnresolvableType(r4) == true) goto L6;
            return;
        L6:
            throw Utils.parameterError(this.method, r3, "Parameter type must not include a type variable or wildcard: %s", new Object[]{r4});
        }

        static Set<String> parsePathParameters(String r2) {
            LinkedHashSet r0 = new LinkedHashSet();
            Matcher r3 = PARAM_URL_REGEX.matcher(r2);     // Catch: IllegalArgumentException -> L9
        L5:
            if (r3.find() == false) goto L8;
            r0.add(r3.group(1));     // Catch: IllegalArgumentException -> L9
        L8:
            return r0;
        }

        static String parseMethodParameters(String r1) {
            Matcher r2 = PARAM_URL_REGEX.matcher(r1);     // Catch: IllegalArgumentException -> L8
            if (r2.find() == false) goto L6;
            return r2.group(1);
        L6:
            return null;
        L11:
            return null;
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
    }

    static RequestFactory parseAnnotations(Retrofit r1, Method r2, RetrofitMetrics r3) {
        return new Builder(r1, r2, r3).build();
    }

    RequestFactory(Builder r2) {
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

    public RetrofitMetrics getRetrofitMetrics() {
        return this.retrofitMetrics;
    }

    public void setRetrofitMetrics(RetrofitMetrics r1) {
        this.retrofitMetrics = r1;
    }

    Request toRequest(ExpandCallback r22, Object... r23) throws IOException {
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
        throw new IllegalArgumentException("Argument count (" + r4 + ") doesn't match expected count (" + r1.length + ")");
    L5:
        r4 = 0;
        goto L7
    }

    T toResponse(TypedInput r1) throws IOException {
        return this.responseConverter.convert(r1);
    }
}
