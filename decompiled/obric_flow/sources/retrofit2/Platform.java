package retrofit2;

import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
class Platform {
    private static final Platform PLATFORM = null;
    private final boolean hasJava8Types;
    private final Constructor<MethodHandles.Lookup> lookupConstructor;

    public static final class Android extends Platform {

        public static final class MainThreadExecutor implements Executor {
            private final Handler handler;

            public MainThreadExecutor() {
                this.handler = new Handler(Looper.getMainLooper());
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable r5) {
                this.handler.post(r5);
            }
        }

        public Android() {
            super(true);
        }

        @Override // retrofit2.Platform
        public Executor defaultCallbackExecutor() {
            return new MainThreadExecutor();
        }

        @Override // retrofit2.Platform
        public Object invokeDefaultMethod(Method r5, Class<?> r10, Object r11, Object... r12) throws Throwable {
            return super.invokeDefaultMethod(r5, r10, r11, r12);
        }
    }

    static {
        PLATFORM = findPlatform();
    }

    public Platform(boolean r5) {
        this.hasJava8Types = r5;
        Constructor<MethodHandles.Lookup> r10 = null;
        if (r5 == true) goto L8;
    L5:
        this.lookupConstructor = r10;
        return;
    L8:
        r10 = MethodHandles.Lookup.class.getDeclaredConstructor(new Class[]{Class.class, Integer.TYPE});     // Catch: Throwable -> L7
        r10.setAccessible(true);     // Catch: Throwable -> L7
        goto L5
    }

    private static Platform findPlatform() {
        Class.forName("android.os.Build");     // Catch: ClassNotFoundException -> L4
        return new Android();
    L5:
        return new Platform(true);
    }

    public static Platform get() {
        return PLATFORM;
    }

    public List<? extends CallAdapter.Factory> defaultCallAdapterFactories(Executor r5) {
        DefaultCallAdapterFactory r10 = new DefaultCallAdapterFactory(r5);
        if (this.hasJava8Types == false) goto L6;
        return Arrays.asList(new CallAdapter.Factory[]{CompletableFutureCallAdapterFactory.INSTANCE, r10});
    L6:
        return Collections.singletonList(r10);
    }

    public int defaultCallAdapterFactoriesSize() {
        if (this.hasJava8Types == false) goto L5;
        return 2;
    L5:
        return 1;
    }

    public Executor defaultCallbackExecutor() {
        return null;
    }

    public List<? extends Converter.Factory> defaultConverterFactories() {
        if (this.hasJava8Types == false) goto L6;
        return Collections.singletonList(OptionalConverterFactory.INSTANCE);
    L6:
        return Collections.emptyList();
    }

    public int defaultConverterFactoriesSize() {
        return this.hasJava8Types ? 1 : 0;
    }

    public Object invokeDefaultMethod(Method r5, Class<?> r10, Object r11, Object... r12) throws Throwable {
        Constructor<MethodHandles.Lookup> r13 = this.lookupConstructor;
        if (r13 == null) goto L5;
        MethodHandles.Lookup r14 = r13.newInstance(new Object[]{r10, -1});
    L7:
        return r14.unreflectSpecial(r5, r10).bindTo(r11).invokeWithArguments(r12);
    L5:
        r14 = MethodHandles.lookup();
        goto L7
    }

    public boolean isDefaultMethod(Method r5) {
        if (this.hasJava8Types == true) goto L5;
    L7:
        return false;
    L5:
        if (r5.isDefault() == false) goto L7;
        return true;
    }
}
