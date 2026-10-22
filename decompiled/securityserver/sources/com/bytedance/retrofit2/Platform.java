package com.bytedance.retrofit2;

import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
class Platform {
    private static final Platform PLATFORM = null;
    private static final boolean SQUARE_RETROFIT_EXISTS = false;

    public static class Android extends Platform {

        public static class MainThreadExecutor implements Executor {
            private final Handler handler;

            public MainThreadExecutor() {
                this.handler = new Handler(Looper.getMainLooper());
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable r1) {
                this.handler.post(r1);
            }
        }

        public Android() {
        }

        @Override // com.bytedance.retrofit2.Platform
        public List<? extends CallAdapter.Factory> defaultCallAdapterFactories(@Nullable Executor r1) {
            if (r1 == null) goto L6;
            return Collections.singletonList(new ExecutorCallAdapterFactory(r1));
        L6:
            throw new AssertionError();
        }

        @Override // com.bytedance.retrofit2.Platform
        public int defaultCallAdapterFactoriesSize() {
            return 1;
        }

        @Override // com.bytedance.retrofit2.Platform
        public Executor defaultCallbackExecutor() {
            return new MainThreadExecutor();
        }

        @Override // com.bytedance.retrofit2.Platform
        public List<? extends Converter.Factory> defaultConverterFactories() {
            return Collections.emptyList();
        }

        @Override // com.bytedance.retrofit2.Platform
        public int defaultConverterFactoriesSize() {
            return 0;
        }

        @Override // com.bytedance.retrofit2.Platform
        public boolean isDefaultMethod(Method r1) {
            return r1.isDefault();
        }
    }

    static {
        PLATFORM = findPlatform();
        SQUARE_RETROFIT_EXISTS = findSquareRetrofit();
    }

    public Platform() {
    }

    private static Platform findPlatform() {
        Class.forName("android.os.Build");     // Catch: ClassNotFoundException -> L4
        return new Android();
    L5:
        return new Platform();
    }

    private static boolean findSquareRetrofit() {
        new retrofit2.Retrofit.Builder();     // Catch: NoClassDefFoundError -> L5
        return true;
    L5:
        return false;
    }

    public static Platform get() {
        return PLATFORM;
    }

    public static boolean squareRetrofitExists() {
        return SQUARE_RETROFIT_EXISTS;
    }

    public List<? extends CallAdapter.Factory> defaultCallAdapterFactories(@Nullable Executor r1) {
        if (r1 == null) goto L6;
        return Collections.singletonList(new ExecutorCallAdapterFactory(r1));
    L6:
        return Collections.singletonList(DefaultCallAdapterFactory.INSTANCE);
    }

    public int defaultCallAdapterFactoriesSize() {
        return 1;
    }

    @Nullable
    public Executor defaultCallbackExecutor() {
        return null;
    }

    public List<? extends Converter.Factory> defaultConverterFactories() {
        return Collections.emptyList();
    }

    public int defaultConverterFactoriesSize() {
        return 0;
    }

    @Nullable
    public Object invokeDefaultMethod(Method r1, Class<?> r2, Object r3, @Nullable Object... r4) {
        throw new UnsupportedOperationException();
    }

    public boolean isDefaultMethod(Method r1) {
        return false;
    }
}
