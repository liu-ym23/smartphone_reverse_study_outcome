package com.bumptech.glide;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.prefill.BitmapPreFiller;
import com.bumptech.glide.load.engine.prefill.PreFillType;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.HardwareConfigState;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.module.ManifestParser;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class Glide implements ComponentCallbacks2 {
    private static final String DEFAULT_DISK_CACHE_DIR = "image_manager_disk_cache";
    private static final String DESTROYED_ACTIVITY_WARNING = "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).";
    private static final String TAG = "Glide";
    private static volatile Glide glide;
    private static volatile boolean isInitializing;
    private final ArrayPool arrayPool;
    private final BitmapPool bitmapPool;
    private BitmapPreFiller bitmapPreFiller;
    private final ConnectivityMonitorFactory connectivityMonitorFactory;
    private final RequestOptionsFactory defaultRequestOptionsFactory;
    private final Engine engine;
    private final GlideContext glideContext;
    private final List<RequestManager> managers;
    private final MemoryCache memoryCache;
    private MemoryCategory memoryCategory;
    private final RequestManagerRetriever requestManagerRetriever;

    public interface RequestOptionsFactory {
        RequestOptions build();
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r1) {
    }

    public static File getPhotoCacheDir(Context r1) {
        return getPhotoCacheDir(r1, "image_manager_disk_cache");
    }

    public static File getPhotoCacheDir(Context r2, String r3) {
        File r4 = r2.getCacheDir();
        if (r4 == null) goto L12;
        File r1 = new File(r4, r3);
        if (r1.isDirectory() == false) goto L7;
    L10:
        return r1;
    L7:
        if (r1.mkdirs() == true) goto L10;
        return null;
    L12:
        if (Log.isLoggable(TAG, 6) == false) goto L14;
        Log.e(TAG, "default disk cache dir is null");
    L14:
        return null;
    }

    public static Glide get(Context r3) {
        if (glide != null) goto L15;
        GeneratedAppGlideModule r0 = getAnnotationGeneratedGlideModules(r3.getApplicationContext());
        monitor-enter(Glide.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (glide != null) goto L9;
        checkAndInitializeGlide(r3, r0);     // Catch: Throwable -> L11
    L9:
        monitor-exit(Glide.class);     // Catch: Throwable -> L11
    L15:
        return glide;
    }

    static void checkAndInitializeGlide(Context r1, GeneratedAppGlideModule r2) {
        if (isInitializing == true) goto L12;
        isInitializing = true;
        initializeGlide(r1, r2);     // Catch: Throwable -> L8
        isInitializing = false;
        return;
    L8:
        th = move-exception;
        isInitializing = false;
        throw th;
    L12:
        throw new IllegalStateException("Glide has been called recursively, this is probably an internal library error!");
    }

    @Deprecated
    public static synchronized void init(Glide r2) {
        monitor-enter(Glide.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (glide == null) goto L7;
        tearDown();     // Catch: Throwable -> L10
    L7:
        glide = r2;     // Catch: Throwable -> L10
        monitor-exit(Glide.class);
    }

    public static void init(Context r3, GlideBuilder r4) {
        GeneratedAppGlideModule r0 = getAnnotationGeneratedGlideModules(r3);
        monitor-enter(Glide.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (glide == null) goto L7;
        tearDown();     // Catch: Throwable -> L10
    L7:
        initializeGlide(r3, r4, r0);     // Catch: Throwable -> L10
        monitor-exit(Glide.class);     // Catch: Throwable -> L10
    }

    public static synchronized boolean isInitialized() {
        monitor-enter(Glide.class);
        if (glide == null) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(Glide.class);
        return r1;
    L7:
        r1 = false;
    L10:
        th = move-exception;
        throw th;
    }

    public static void enableHardwareBitmaps() {
        HardwareConfigState.getInstance().unblockHardwareBitmaps();
    }

    public static void tearDown() {
        monitor-enter(Glide.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (glide == null) goto L7;
        glide.getContext().getApplicationContext().unregisterComponentCallbacks(glide);     // Catch: Throwable -> L10
        glide.engine.shutdown();     // Catch: Throwable -> L10
    L7:
        glide = null;     // Catch: Throwable -> L10
        monitor-exit(Glide.class);     // Catch: Throwable -> L10
    }

    private static void initializeGlide(Context r1, GeneratedAppGlideModule r2) {
        initializeGlide(r1, new GlideBuilder(), r2);
    }

    private static void initializeGlide(Context r8, GlideBuilder r9, GeneratedAppGlideModule r10) {
        Context r11 = r8.getApplicationContext();
        List<GlideModule> r0 = Collections.emptyList();
        if (r10 != null) goto L5;
    L6:
        r0 = new ManifestParser(r11).parse();
    L8:
        if (r10 == null) goto L22;
        if (r10.getExcludedModuleClasses().isEmpty() == true) goto L22;
        Set<Class<?>> r3 = r10.getExcludedModuleClasses();
        Iterator<GlideModule> r4 = r0.iterator();
    L13:
        if (r4.hasNext() == false) goto L22;
        GlideModule r5 = r4.next();
        if (r3.contains(r5.getClass()) == false) goto L13;
        if (Log.isLoggable(TAG, 3) == false) goto L20;
        Log.d(TAG, "AppGlideModule excludes manifest GlideModule: " + r5);
    L20:
        r4.remove();
    L22:
        if (Log.isLoggable(TAG, 3) == false) goto L27;
        Iterator<GlideModule> r1 = r0.iterator();
    L25:
        if (r1.hasNext() == false) goto L27;
        Log.d(TAG, "Discovered GlideModule from manifest: " + r1.next().getClass());
    L27:
        if (r10 == null) goto L29;
        RequestManagerRetriever.RequestManagerFactory r2 = r10.getRequestManagerFactory();
    L30:
        r9.setRequestManagerFactory(r2);
        Iterator<GlideModule> r6 = r0.iterator();
    L32:
        if (r6.hasNext() == false) goto L34;
        r6.next().applyOptions(r11, r9);
        goto L32
    L34:
        if (r10 == null) goto L36;
        r10.applyOptions(r11, r9);
    L36:
        Glide r12 = r9.build(r11, r0, r10);
        r11.registerComponentCallbacks(r12);
        glide = r12;
        return;
    L29:
        r2 = null;
        goto L30
    L5:
        if (r10.isManifestParsingEnabled() == false) goto L8;
        goto L6
    }

    private static GeneratedAppGlideModule getAnnotationGeneratedGlideModules(Context r5) {
        goto L13
    L19:
        return (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(new Class[]{Context.class}).newInstance(new Object[]{r5.getApplicationContext()});
    L8:
        e = move-exception;
        throwIncorrectGlideModule(e);
    L15:
        return null;
    L10:
        e = move-exception;
        throwIncorrectGlideModule(e);
    L6:
        e = move-exception;
        throwIncorrectGlideModule(e);
    L4:
        e = move-exception;
        throwIncorrectGlideModule(e);
    L13:
        if (Log.isLoggable(TAG, 5) == false) goto L15;
        Log.w(TAG, "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
        goto L15
    }

    private static void throwIncorrectGlideModule(Exception r2) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", r2);
    }

    Glide(Context r15, Engine r16, MemoryCache r17, BitmapPool r18, ArrayPool r19, RequestManagerRetriever r20, ConnectivityMonitorFactory r21, int r22, RequestOptionsFactory r23, Map<Class<?>, TransitionOptions<?, ?>> r24, List<RequestListener<Object>> r25, List<GlideModule> r26, AppGlideModule r27, GlideExperiments r28) {
        this.managers = new ArrayList();
        this.memoryCategory = MemoryCategory.NORMAL;
        this.engine = r16;
        this.bitmapPool = r18;
        this.arrayPool = r19;
        this.memoryCache = r17;
        this.requestManagerRetriever = r20;
        this.connectivityMonitorFactory = r21;
        this.defaultRequestOptionsFactory = r23;
        this.glideContext = new GlideContext(r15, r19, RegistryFactory.lazilyCreateAndInitializeRegistry(this, r26, r27), new ImageViewTargetFactory(), r23, r24, r25, r16, r28, r22);
    }

    public BitmapPool getBitmapPool() {
        return this.bitmapPool;
    }

    public ArrayPool getArrayPool() {
        return this.arrayPool;
    }

    public Context getContext() {
        return this.glideContext.getBaseContext();
    }

    ConnectivityMonitorFactory getConnectivityMonitorFactory() {
        return this.connectivityMonitorFactory;
    }

    GlideContext getGlideContext() {
        return this.glideContext;
    }

    public synchronized void preFillBitmapPool(PreFillType.Builder... r5) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.bitmapPreFiller != null) goto L6;
        DecodeFormat r0 = (DecodeFormat) this.defaultRequestOptionsFactory.build().getOptions().get(Downsampler.DECODE_FORMAT);     // Catch: Throwable -> L9
        this.bitmapPreFiller = new BitmapPreFiller(this.memoryCache, this.bitmapPool, r0);     // Catch: Throwable -> L9
    L6:
        this.bitmapPreFiller.preFill(r5);     // Catch: Throwable -> L9
        monitor-exit(this);
    }

    public void clearMemory() {
        Util.assertMainThread();
        this.memoryCache.clearMemory();
        this.bitmapPool.clearMemory();
        this.arrayPool.clearMemory();
    }

    public void trimMemory(int r4) {
        Util.assertMainThread();
        List<RequestManager> r0 = this.managers;
        monitor-enter(r0);
        Iterator<RequestManager> r1 = this.managers.iterator();     // Catch: Throwable -> L11
    L6:
        if (r1.hasNext() == false) goto L8;
        r1.next().onTrimMemory(r4);     // Catch: Throwable -> L11
        goto L6
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L11
        this.memoryCache.trimMemory(r4);
        this.bitmapPool.trimMemory(r4);
        this.arrayPool.trimMemory(r4);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void clearDiskCache() {
        Util.assertBackgroundThread();
        this.engine.clearDiskCache();
    }

    public RequestManagerRetriever getRequestManagerRetriever() {
        return this.requestManagerRetriever;
    }

    public MemoryCategory setMemoryCategory(MemoryCategory r3) {
        Util.assertMainThread();
        this.memoryCache.setSizeMultiplier(r3.getMultiplier());
        this.bitmapPool.setSizeMultiplier(r3.getMultiplier());
        MemoryCategory r0 = this.memoryCategory;
        this.memoryCategory = r3;
        return r0;
    }

    private static RequestManagerRetriever getRetriever(Context r1) {
        Preconditions.checkNotNull(r1, DESTROYED_ACTIVITY_WARNING);
        return get(r1).getRequestManagerRetriever();
    }

    public static RequestManager with(Context r1) {
        return getRetriever(r1).get(r1);
    }

    @Deprecated
    public static RequestManager with(Activity r0) {
        return with(r0.getApplicationContext());
    }

    public static RequestManager with(FragmentActivity r1) {
        return getRetriever(r1).get(r1);
    }

    public static RequestManager with(Fragment r1) {
        return getRetriever(r1.getContext()).get(r1);
    }

    @Deprecated
    public static RequestManager with(android.app.Fragment r1) {
        Activity r2 = r1.getActivity();
        Preconditions.checkNotNull(r2, DESTROYED_ACTIVITY_WARNING);
        return with(r2.getApplicationContext());
    }

    public static RequestManager with(View r1) {
        return getRetriever(r1.getContext()).get(r1);
    }

    public Registry getRegistry() {
        return this.glideContext.getRegistry();
    }

    boolean removeFromManagers(Target<?> r3) {
        List<RequestManager> r0 = this.managers;
        monitor-enter(r0);
        Iterator<RequestManager> r2 = this.managers.iterator();     // Catch: Throwable -> L15
    L6:
        if (r2.hasNext() == false) goto L12;
        if (r2.next().untrack(r3) == false) goto L6;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return true;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return false;
    L15:
        th = move-exception;
        throw th;
    }

    void registerRequestManager(RequestManager r3) {
        List<RequestManager> r0 = this.managers;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.managers.contains(r3) == true) goto L10;
        this.managers.add(r3);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IllegalStateException("Cannot register already registered manager");     // Catch: Throwable -> L11
    }

    void unregisterRequestManager(RequestManager r3) {
        List<RequestManager> r0 = this.managers;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.managers.contains(r3) == false) goto L10;
        this.managers.remove(r3);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IllegalStateException("Cannot unregister not yet registered manager");     // Catch: Throwable -> L11
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int r1) {
        trimMemory(r1);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        clearMemory();
    }
}
