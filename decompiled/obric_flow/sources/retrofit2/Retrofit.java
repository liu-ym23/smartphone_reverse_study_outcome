package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.d0;
import okhttp3.e0;
import okhttp3.i;
import okhttp3.q0;
import okhttp3.w0;

/* JADX INFO: loaded from: classes3.dex */
public final class Retrofit {
    final e0 baseUrl;
    final List<CallAdapter.Factory> callAdapterFactories;
    final i callFactory;
    final Executor callbackExecutor;
    final List<Converter.Factory> converterFactories;
    private final Map<Method, ServiceMethod<?>> serviceMethodCache;
    final boolean validateEagerly;

    public static final class Builder {
        private e0 baseUrl;
        private final List<CallAdapter.Factory> callAdapterFactories;
        private i callFactory;
        private Executor callbackExecutor;
        private final List<Converter.Factory> converterFactories;
        private final Platform platform;
        private boolean validateEagerly;

        public Builder(Platform r5) {
            this.converterFactories = new ArrayList();
            this.callAdapterFactories = new ArrayList();
            this.platform = r5;
        }

        public Builder addCallAdapterFactory(CallAdapter.Factory r5) {
            List<CallAdapter.Factory> r10 = this.callAdapterFactories;
            Objects.requireNonNull(r5, "factory == null");
            r10.add(r5);
            return this;
        }

        public Builder addConverterFactory(Converter.Factory r5) {
            List<Converter.Factory> r10 = this.converterFactories;
            Objects.requireNonNull(r5, "factory == null");
            r10.add(r5);
            return this;
        }

        public Builder baseUrl(URL r5) {
            Objects.requireNonNull(r5, "baseUrl == null");
            String r10 = r5.toString();
            Intrinsics.checkNotNullParameter(r10, "$this$toHttpUrl");
            d0 r11 = new d0();
            r11.d(null, r10);
            return baseUrl(r11.a());
        }

        public Retrofit build() {
            if (this.baseUrl == null) goto L13;
            i r5 = this.callFactory;
            if (r5 != null) goto L7;
            r5 = new OkHttpClient();
        L7:
            i r10 = r5;
            Executor r11 = this.callbackExecutor;
            if (r11 != null) goto L10;
            r11 = this.platform.defaultCallbackExecutor();
        L10:
            Executor r12 = r11;
            ArrayList r13 = new ArrayList(this.callAdapterFactories);
            r13.addAll(this.platform.defaultCallAdapterFactories(r12));
            ArrayList r14 = new ArrayList((this.converterFactories.size() + 1) + this.platform.defaultConverterFactoriesSize());
            r14.add(new BuiltInConverters());
            r14.addAll(this.converterFactories);
            r14.addAll(this.platform.defaultConverterFactories());
            return new Retrofit(r10, this.baseUrl, Collections.unmodifiableList(r14), Collections.unmodifiableList(r13), r12, this.validateEagerly);
        L13:
            throw new IllegalStateException("Base URL required.");
        }

        public List<CallAdapter.Factory> callAdapterFactories() {
            return this.callAdapterFactories;
        }

        public Builder callFactory(i r5) {
            Objects.requireNonNull(r5, "factory == null");
            this.callFactory = r5;
            return this;
        }

        public Builder callbackExecutor(Executor r5) {
            Objects.requireNonNull(r5, "executor == null");
            this.callbackExecutor = r5;
            return this;
        }

        public Builder client(OkHttpClient r5) {
            Objects.requireNonNull(r5, "client == null");
            return callFactory(r5);
        }

        public List<Converter.Factory> converterFactories() {
            return this.converterFactories;
        }

        public Builder validateEagerly(boolean r5) {
            this.validateEagerly = r5;
            return this;
        }

        public Builder() {
            this(Platform.get());
        }

        public Builder(Retrofit r5) {
            this.converterFactories = new ArrayList();
            this.callAdapterFactories = new ArrayList();
            Platform r10 = Platform.get();
            this.platform = r10;
            this.callFactory = r5.callFactory;
            this.baseUrl = r5.baseUrl;
            int r11 = r5.converterFactories.size() - r10.defaultConverterFactoriesSize();
            int r12 = 1;
        L3:
            if (r12 >= r11) goto L5;
            this.converterFactories.add(r5.converterFactories.get(r12));
            r12 = r12 + 1;
            goto L3
        L5:
            int r13 = r5.callAdapterFactories.size() - this.platform.defaultCallAdapterFactoriesSize();
            int r14 = 0;
        L6:
            if (r14 >= r13) goto L8;
            this.callAdapterFactories.add(r5.callAdapterFactories.get(r14));
            r14 = r14 + 1;
            goto L6
        L8:
            this.callbackExecutor = r5.callbackExecutor;
            this.validateEagerly = r5.validateEagerly;
        }

        public Builder baseUrl(String r5) {
            Objects.requireNonNull(r5, "baseUrl == null");
            Intrinsics.checkNotNullParameter(r5, "$this$toHttpUrl");
            d0 r10 = new d0();
            r10.d(null, r5);
            return baseUrl(r10.a());
        }

        public Builder baseUrl(e0 r5) {
            Objects.requireNonNull(r5, "baseUrl == null");
            ArrayList r10 = r5.g;
            if ("".equals(r10.get(r10.size() - 1)) == false) goto L7;
            this.baseUrl = r5;
            return this;
        L7:
            throw new IllegalArgumentException("baseUrl must end in /: " + r5);
        }
    }

    public Retrofit(i r5, e0 r10, List<Converter.Factory> r11, List<CallAdapter.Factory> r12, Executor r13, boolean r14) {
        this.serviceMethodCache = new ConcurrentHashMap();
        this.callFactory = r5;
        this.baseUrl = r10;
        this.converterFactories = r11;
        this.callAdapterFactories = r12;
        this.callbackExecutor = r13;
        this.validateEagerly = r14;
    }

    private void validateServiceInterface(Class<?> r10) {
        if (r10.isInterface() == false) goto L27;
        ArrayDeque r5 = new ArrayDeque(1);
        r5.add(r10);
    L6:
        if (r5.isEmpty() == true) goto L16;
        Class<?> r11 = (Class) r5.removeFirst();
        if (r11.getTypeParameters().length != 0) goto L9;
        Collections.addAll(r5, r11.getInterfaces());
        goto L6
    L9:
        StringBuilder r12 = new StringBuilder("Type parameters are unsupported on ");
        r12.append(r11.getName());
        if (r11 == r10) goto L13;
        r12.append(" which is an interface of ");
        r12.append(r10.getName());
    L13:
        throw new IllegalArgumentException(r12.toString());
    L16:
        if (this.validateEagerly == false) goto L25;
        Platform r13 = Platform.get();
        Method[] r14 = r10.getDeclaredMethods();
        int r15 = r14.length;
        int r16 = 0;
    L18:
        if (r16 >= r15) goto L34;
        Method r17 = r14[r16];
        if (r13.isDefaultMethod(r17) == true) goto L24;
        if (Modifier.isStatic(r17.getModifiers()) == true) goto L24;
        loadServiceMethod(r17);
    L24:
        r16 = r16 + 1;
        goto L18
    L34:
        return;
    L25:
        return;
    L27:
        throw new IllegalArgumentException("API declarations must be interfaces.");
    }

    public e0 baseUrl() {
        return this.baseUrl;
    }

    public CallAdapter<?, ?> callAdapter(Type r5, Annotation[] r10) {
        return nextCallAdapter(null, r5, r10);
    }

    public List<CallAdapter.Factory> callAdapterFactories() {
        return this.callAdapterFactories;
    }

    public i callFactory() {
        return this.callFactory;
    }

    public Executor callbackExecutor() {
        return this.callbackExecutor;
    }

    public List<Converter.Factory> converterFactories() {
        return this.converterFactories;
    }

    public <T> T create(final Class<T> r5) {
        validateServiceInterface(r5);
        return (T) Proxy.newProxyInstance(r5.getClassLoader(), new Class[]{r5}, new AnonymousClass1(this, r5));
    }

    public ServiceMethod<?> loadServiceMethod(Method r5) {
        ServiceMethod<?> r10 = this.serviceMethodCache.get(r5);
        if (r10 == null) goto L5;
        return r10;
    L5:
        Map<Method, ServiceMethod<?>> r11 = this.serviceMethodCache;
        monitor-enter(r11);
        ServiceMethod<?> r12 = this.serviceMethodCache.get(r5);     // Catch: Throwable -> L10
        if (r12 != null) goto L12;
        r12 = ServiceMethod.parseAnnotations(this, r5);     // Catch: Throwable -> L10
        this.serviceMethodCache.put(r5, r12);     // Catch: Throwable -> L10
    L12:
        monitor-exit(r11);     // Catch: Throwable -> L10
        return r12;
    L10:
        th = move-exception;
        throw th;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public CallAdapter<?, ?> nextCallAdapter(CallAdapter.Factory r5, Type r10, Annotation[] r11) {
        Objects.requireNonNull(r10, "returnType == null");
        Objects.requireNonNull(r11, "annotations == null");
        int r12 = this.callAdapterFactories.indexOf(r5) + 1;
        int r13 = this.callAdapterFactories.size();
        int r14 = r12;
    L3:
        if (r14 >= r13) goto L8;
        CallAdapter<?, ?> r15 = this.callAdapterFactories.get(r14).get(r10, r11, this);
        if (r15 != null) goto L6;
        r14 = r14 + 1;
        goto L3
    L6:
        return r15;
    L8:
        StringBuilder r16 = new StringBuilder("Could not locate call adapter for ");
        r16.append(r10);
        r16.append(".\n");
        if (r5 == null) goto L14;
        r16.append("  Skipped:");
        int r17 = 0;
    L11:
        if (r17 >= r12) goto L13;
        r16.append("\n   * ");
        r16.append(this.callAdapterFactories.get(r17).getClass().getName());
        r17 = r17 + 1;
        goto L11
    L13:
        r16.append('\n');
    L14:
        r16.append("  Tried:");
        int r18 = this.callAdapterFactories.size();
    L15:
        if (r12 >= r18) goto L18;
        r16.append("\n   * ");
        r16.append(this.callAdapterFactories.get(r12).getClass().getName());
        r12 = r12 + 1;
        goto L15
    L18:
        throw new IllegalArgumentException(r16.toString());
    }

    public <T> Converter<T, q0> nextRequestBodyConverter(Converter.Factory r5, Type r10, Annotation[] r11, Annotation[] r12) {
        Objects.requireNonNull(r10, "type == null");
        Objects.requireNonNull(r11, "parameterAnnotations == null");
        Objects.requireNonNull(r12, "methodAnnotations == null");
        int r13 = this.converterFactories.indexOf(r5) + 1;
        int r14 = this.converterFactories.size();
        int r15 = r13;
    L3:
        if (r15 >= r14) goto L8;
        Converter<T, q0> r16 = (Converter<T, q0>) this.converterFactories.get(r15).requestBodyConverter(r10, r11, r12, this);
        if (r16 != null) goto L6;
        r15 = r15 + 1;
        goto L3
    L6:
        return r16;
    L8:
        StringBuilder r17 = new StringBuilder("Could not locate RequestBody converter for ");
        r17.append(r10);
        r17.append(".\n");
        if (r5 == null) goto L14;
        r17.append("  Skipped:");
        int r18 = 0;
    L11:
        if (r18 >= r13) goto L13;
        r17.append("\n   * ");
        r17.append(this.converterFactories.get(r18).getClass().getName());
        r18 = r18 + 1;
        goto L11
    L13:
        r17.append('\n');
    L14:
        r17.append("  Tried:");
        int r19 = this.converterFactories.size();
    L15:
        if (r13 >= r19) goto L18;
        r17.append("\n   * ");
        r17.append(this.converterFactories.get(r13).getClass().getName());
        r13 = r13 + 1;
        goto L15
    L18:
        throw new IllegalArgumentException(r17.toString());
    }

    public <T> Converter<w0, T> nextResponseBodyConverter(Converter.Factory r5, Type r10, Annotation[] r11) {
        Objects.requireNonNull(r10, "type == null");
        Objects.requireNonNull(r11, "annotations == null");
        int r12 = this.converterFactories.indexOf(r5) + 1;
        int r13 = this.converterFactories.size();
        int r14 = r12;
    L3:
        if (r14 >= r13) goto L8;
        Converter<w0, T> r15 = (Converter<w0, T>) this.converterFactories.get(r14).responseBodyConverter(r10, r11, this);
        if (r15 != null) goto L6;
        r14 = r14 + 1;
        goto L3
    L6:
        return r15;
    L8:
        StringBuilder r16 = new StringBuilder("Could not locate ResponseBody converter for ");
        r16.append(r10);
        r16.append(".\n");
        if (r5 == null) goto L14;
        r16.append("  Skipped:");
        int r17 = 0;
    L11:
        if (r17 >= r12) goto L13;
        r16.append("\n   * ");
        r16.append(this.converterFactories.get(r17).getClass().getName());
        r17 = r17 + 1;
        goto L11
    L13:
        r16.append('\n');
    L14:
        r16.append("  Tried:");
        int r18 = this.converterFactories.size();
    L15:
        if (r12 >= r18) goto L18;
        r16.append("\n   * ");
        r16.append(this.converterFactories.get(r12).getClass().getName());
        r12 = r12 + 1;
        goto L15
    L18:
        throw new IllegalArgumentException(r16.toString());
    }

    public <T> Converter<T, q0> requestBodyConverter(Type r5, Annotation[] r10, Annotation[] r11) {
        return nextRequestBodyConverter(null, r5, r10, r11);
    }

    public <T> Converter<w0, T> responseBodyConverter(Type r5, Annotation[] r10) {
        return nextResponseBodyConverter(null, r5, r10);
    }

    public <T> Converter<T, String> stringConverter(Type r5, Annotation[] r10) {
        Objects.requireNonNull(r5, "type == null");
        Objects.requireNonNull(r10, "annotations == null");
        int r11 = this.converterFactories.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        Converter<T, String> r13 = (Converter<T, String>) this.converterFactories.get(r12).stringConverter(r5, r10, this);
        if (r13 != null) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return r13;
    L9:
        return BuiltInConverters.ToStringConverter.INSTANCE;
    }
}
