package com.bumptech.glide.request;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.GlideTrace;
import com.bumptech.glide.util.pool.StateVerifier;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;

/* JADX INFO: loaded from: classes.dex */
public final class SingleRequest<R> implements Request, SizeReadyCallback, ResourceCallback {
    private static final String GLIDE_TAG = "Glide";
    private static final boolean IS_VERBOSE_LOGGABLE = false;
    private static final String TAG = "GlideRequest";
    private final TransitionFactory<? super R> animationFactory;
    private final Executor callbackExecutor;
    private final Context context;
    private int cookie;
    private volatile Engine engine;
    private Drawable errorDrawable;
    private Drawable fallbackDrawable;
    private final GlideContext glideContext;
    private int height;
    private boolean isCallingCallbacks;
    private Engine.LoadStatus loadStatus;
    private final Object model;
    private final int overrideHeight;
    private final int overrideWidth;
    private Drawable placeholderDrawable;
    private final Priority priority;
    private final RequestCoordinator requestCoordinator;
    private final List<RequestListener<R>> requestListeners;
    private final Object requestLock;
    private final BaseRequestOptions<?> requestOptions;
    private RuntimeException requestOrigin;
    private Resource<R> resource;
    private long startTime;
    private final StateVerifier stateVerifier;
    private Status status;
    private final String tag;
    private final Target<R> target;
    private final RequestListener<R> targetListener;
    private final Class<R> transcodeClass;
    private int width;

    private static final enum Status extends Enum<Status> {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final Status CLEARED = null;
        public static final Status COMPLETE = null;
        public static final Status FAILED = null;
        public static final Status PENDING = null;
        public static final Status RUNNING = null;
        public static final Status WAITING_FOR_SIZE = null;

        private static /* synthetic */ Status[] $values() {
            return new Status[]{PENDING, RUNNING, WAITING_FOR_SIZE, COMPLETE, FAILED, CLEARED};
        }

        private Status(String r1, int r2) {
            super(r1, r2);
        }

        public static Status valueOf(String r1) {
            return (Status) Enum.valueOf(Status.class, r1);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }

        static {
            PENDING = new Status("PENDING", 0);
            RUNNING = new Status(DebugCoroutineInfoImplKt.RUNNING, 1);
            WAITING_FOR_SIZE = new Status("WAITING_FOR_SIZE", 2);
            COMPLETE = new Status("COMPLETE", 3);
            FAILED = new Status("FAILED", 4);
            CLEARED = new Status("CLEARED", 5);
            $VALUES = $values();
        }
    }

    static {
        IS_VERBOSE_LOGGABLE = Log.isLoggable(TAG, 2);
    }

    public static <R> SingleRequest<R> obtain(Context r18, GlideContext r19, Object r20, Object r21, Class<R> r22, BaseRequestOptions<?> r23, int r24, int r25, Priority r26, Target<R> r27, RequestListener<R> r28, List<RequestListener<R>> r29, RequestCoordinator r30, Engine r31, TransitionFactory<? super R> r32, Executor r33) {
        return new SingleRequest(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33);
    }

    private SingleRequest(Context r4, GlideContext r5, Object r6, Object r7, Class<R> r8, BaseRequestOptions<?> r9, int r10, int r11, Priority r12, Target<R> r13, RequestListener<R> r14, List<RequestListener<R>> r15, RequestCoordinator r16, Engine r17, TransitionFactory<? super R> r18, Executor r19) {
        if (IS_VERBOSE_LOGGABLE == false) goto L5;
        String r1 = String.valueOf(super.hashCode());
    L6:
        this.tag = r1;
        this.stateVerifier = StateVerifier.newInstance();
        this.requestLock = r6;
        this.context = r4;
        this.glideContext = r5;
        this.model = r7;
        this.transcodeClass = r8;
        this.requestOptions = r9;
        this.overrideWidth = r10;
        this.overrideHeight = r11;
        this.priority = r12;
        this.target = r13;
        this.targetListener = r14;
        this.requestListeners = r15;
        this.requestCoordinator = r16;
        this.engine = r17;
        this.animationFactory = r18;
        this.callbackExecutor = r19;
        this.status = Status.PENDING;
        if (this.requestOrigin == null) goto L9;
        return;
    L9:
        if (r5.getExperiments().isEnabled(GlideBuilder.LogRequestOrigins.class) == false) goto L13;
        this.requestOrigin = new RuntimeException("Glide request origin trace");
        return;
    L13:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bumptech.glide.request.Request
    public void begin() {
        Object r1 = this.requestLock;
        monitor-enter(r1);
        assertNotCallingCallbacks();     // Catch: Throwable -> L41
        this.stateVerifier.throwIfRecycled();     // Catch: Throwable -> L41
        this.startTime = LogTime.getLogTime();     // Catch: Throwable -> L41
        if (this.model != null) goto L17;
        if (Util.isValidDimensions(this.overrideWidth, this.overrideHeight) == false) goto L10;
        this.width = this.overrideWidth;     // Catch: Throwable -> L41
        this.height = this.overrideHeight;     // Catch: Throwable -> L41
    L10:
        if (getFallbackDrawable() != null) goto L12;
        int r0 = 5;
    L13:
        onLoadFailed(new GlideException("Received null model"), r0);     // Catch: Throwable -> L41
        monitor-exit(r1);     // Catch: Throwable -> L41
        return;
    L12:
        r0 = 3;
        goto L13
    L17:
        if (this.status == Status.RUNNING) goto L40;
        if (this.status != Status.COMPLETE) goto L23;
        onResourceReady(this.resource, DataSource.MEMORY_CACHE, false);     // Catch: Throwable -> L41
        monitor-exit(r1);     // Catch: Throwable -> L41
        return;
    L23:
        experimentalNotifyRequestStarted(this.model);     // Catch: Throwable -> L41
        this.cookie = GlideTrace.beginSectionAsync(TAG);     // Catch: Throwable -> L41
        this.status = Status.WAITING_FOR_SIZE;     // Catch: Throwable -> L41
        if (Util.isValidDimensions(this.overrideWidth, this.overrideHeight) == false) goto L26;
        onSizeReady(this.overrideWidth, this.overrideHeight);     // Catch: Throwable -> L41
    L28:
        if (this.status == Status.RUNNING) goto L32;
        if (this.status == Status.WAITING_FOR_SIZE) goto L32;
    L35:
        if (IS_VERBOSE_LOGGABLE == false) goto L37;
        logV("finished run method in " + LogTime.getElapsedMillis(this.startTime));     // Catch: Throwable -> L41
    L37:
        monitor-exit(r1);     // Catch: Throwable -> L41
        return;
    L32:
        if (canNotifyStatusChanged() == false) goto L35;
        this.target.onLoadStarted(getPlaceholderDrawable());     // Catch: Throwable -> L41
        goto L35
    L26:
        this.target.getSize(this);     // Catch: Throwable -> L41
        goto L28
    L40:
        throw new IllegalArgumentException("Cannot restart a running request");     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        throw th;
    }

    private void experimentalNotifyRequestStarted(Object r3) {
        List<RequestListener<R>> r2 = this.requestListeners;
        if (r2 != null) goto L5;
        return;
    L5:
        Iterator<RequestListener<R>> r4 = r2.iterator();
    L7:
        if (r4.hasNext() == false) goto L11;
        RequestListener<R> r0 = r4.next();
        if ((r0 instanceof ExperimentalRequestListener) == false) goto L7;
        ((ExperimentalRequestListener) r0).onRequestStarted(r3);
        goto L7
    }

    private void cancel() {
        assertNotCallingCallbacks();
        this.stateVerifier.throwIfRecycled();
        this.target.removeCallback(this);
        Engine.LoadStatus r0 = this.loadStatus;
        if (r0 == null) goto L6;
        r0.cancel();
        this.loadStatus = null;
        return;
    }

    private void assertNotCallingCallbacks() {
        if (this.isCallingCallbacks == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
    }

    @Override // com.bumptech.glide.request.Request
    public void clear() {
        Object r0 = this.requestLock;
        monitor-enter(r0);
        assertNotCallingCallbacks();     // Catch: Throwable -> L20
        this.stateVerifier.throwIfRecycled();     // Catch: Throwable -> L20
        if (this.status != Status.CLEARED) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L20
        return;
    L8:
        cancel();     // Catch: Throwable -> L20
        Resource<R> r1 = this.resource;     // Catch: Throwable -> L20
        if (r1 == null) goto L11;
        this.resource = null;     // Catch: Throwable -> L20
    L13:
        if (canNotifyCleared() == false) goto L15;
        this.target.onLoadCleared(getPlaceholderDrawable());     // Catch: Throwable -> L20
    L15:
        GlideTrace.endSectionAsync(TAG, this.cookie);     // Catch: Throwable -> L20
        this.status = Status.CLEARED;     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        if (r1 == null) goto L24;
        this.engine.release(r1);
        return;
    L24:
        return;
    L11:
        r1 = null;
    L20:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.request.Request
    public void pause() {
        Object r0 = this.requestLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (isRunning() == false) goto L7;
        clear();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isRunning() {
        Object r0 = this.requestLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.status != Status.RUNNING) goto L7;
    L10:
        boolean r3 = true;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r3;
    L7:
        if (this.status == Status.WAITING_FOR_SIZE) goto L10;
        r3 = false;
        goto L11
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isComplete() {
        Object r0 = this.requestLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.status != Status.COMPLETE) goto L7;
        boolean r2 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L7:
        r2 = false;
        goto L8
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isCleared() {
        Object r0 = this.requestLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.status != Status.CLEARED) goto L7;
        boolean r2 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L7:
        r2 = false;
        goto L8
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isAnyResourceSet() {
        Object r0 = this.requestLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.status != Status.COMPLETE) goto L7;
        boolean r2 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L7:
        r2 = false;
        goto L8
    }

    private Drawable getErrorDrawable() {
        if (this.errorDrawable != null) goto L10;
        Drawable r0 = this.requestOptions.getErrorPlaceholder();
        this.errorDrawable = r0;
        if (r0 != null) goto L10;
        if (this.requestOptions.getErrorId() <= 0) goto L10;
        this.errorDrawable = loadDrawable(this.requestOptions.getErrorId());
    L10:
        return this.errorDrawable;
    }

    private Drawable getPlaceholderDrawable() {
        if (this.placeholderDrawable != null) goto L10;
        Drawable r0 = this.requestOptions.getPlaceholderDrawable();
        this.placeholderDrawable = r0;
        if (r0 != null) goto L10;
        if (this.requestOptions.getPlaceholderId() <= 0) goto L10;
        this.placeholderDrawable = loadDrawable(this.requestOptions.getPlaceholderId());
    L10:
        return this.placeholderDrawable;
    }

    private Drawable getFallbackDrawable() {
        if (this.fallbackDrawable != null) goto L10;
        Drawable r0 = this.requestOptions.getFallbackDrawable();
        this.fallbackDrawable = r0;
        if (r0 != null) goto L10;
        if (this.requestOptions.getFallbackId() <= 0) goto L10;
        this.fallbackDrawable = loadDrawable(this.requestOptions.getFallbackId());
    L10:
        return this.fallbackDrawable;
    }

    private Drawable loadDrawable(int r2) {
        if (this.requestOptions.getTheme() == null) goto L5;
        Resources.Theme r0 = this.requestOptions.getTheme();
    L7:
        return DrawableDecoderCompat.getDrawable(this.context, r2, r0);
    L5:
        r0 = this.context.getTheme();
        goto L7
    }

    private void setErrorPlaceholder() {
        if (canNotifyStatusChanged() == true) goto L6;
        return;
    L6:
        if (this.model != null) goto L8;
        Drawable r0 = getFallbackDrawable();
    L9:
        if (r0 != null) goto L11;
        r0 = getErrorDrawable();
    L11:
        if (r0 != null) goto L13;
        r0 = getPlaceholderDrawable();
    L13:
        this.target.onLoadFailed(r0);
        return;
    L8:
        r0 = null;
        goto L9
    }

    @Override // com.bumptech.glide.request.target.SizeReadyCallback
    public void onSizeReady(int r25, int r26) {
        this.stateVerifier.throwIfRecycled();
        Object r14 = this.requestLock;
        monitor-enter(r14);
        boolean r21 = IS_VERBOSE_LOGGABLE;     // Catch: Throwable -> L23
        if (r21 == false) goto L8;
        logV("Got onSizeReady in " + LogTime.getElapsedMillis(this.startTime));     // Catch: Throwable -> L23
    L8:
        if (this.status == Status.WAITING_FOR_SIZE) goto L11;
        monitor-exit(r14);     // Catch: Throwable -> L23
        return;
    L11:
        this.status = Status.RUNNING;     // Catch: Throwable -> L23
        float r2 = this.requestOptions.getSizeMultiplier();     // Catch: Throwable -> L23
        this.width = maybeApplySizeMultiplier(r25, r2);     // Catch: Throwable -> L23
        this.height = maybeApplySizeMultiplier(r26, r2);     // Catch: Throwable -> L23
        if (r21 == false) goto L16;
        logV("finished setup for calling load in " + LogTime.getElapsedMillis(this.startTime));     // Catch: Throwable -> L23
    L16:
        this.loadStatus = this.engine.load(this.glideContext, this.model, this.requestOptions.getSignature(), this.width, this.height, this.requestOptions.getResourceClass(), this.transcodeClass, this.priority, this.requestOptions.getDiskCacheStrategy(), this.requestOptions.getTransformations(), this.requestOptions.isTransformationRequired(), this.requestOptions.isScaleOnlyOrNoTransform(), this.requestOptions.getOptions(), this.requestOptions.isMemoryCacheable(), this.requestOptions.getUseUnlimitedSourceGeneratorsPool(), this.requestOptions.getUseAnimationPool(), this.requestOptions.getOnlyRetrieveFromCache(), this, this.callbackExecutor);     // Catch: Throwable -> L27
        if (this.status == Status.RUNNING) goto L19;
        this.loadStatus = null;     // Catch: Throwable -> L27
    L19:
        if (r21 == false) goto L21;
        logV("finished onSizeReady in " + LogTime.getElapsedMillis(this.startTime));     // Catch: Throwable -> L27
    L21:
        monitor-exit(r14);     // Catch: Throwable -> L27
        return;
    L23:
        th = th;
    L25:
        monitor-exit(r14);     // Catch: Throwable -> L27
        throw th;
    L27:
        th = th;
        goto L25
    }

    private static int maybeApplySizeMultiplier(int r1, float r2) {
        if (r1 != Integer.MIN_VALUE) goto L6;
        return r1;
    L6:
        return Math.round(r2 * r1);
    }

    private boolean canSetResource() {
        RequestCoordinator r0 = this.requestCoordinator;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.canSetImage(this) == true) goto L8;
        return false;
    }

    private boolean canNotifyCleared() {
        RequestCoordinator r0 = this.requestCoordinator;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.canNotifyCleared(this) == true) goto L8;
        return false;
    }

    private boolean canNotifyStatusChanged() {
        RequestCoordinator r0 = this.requestCoordinator;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.canNotifyStatusChanged(this) == true) goto L8;
        return false;
    }

    private boolean isFirstReadyResource() {
        RequestCoordinator r0 = this.requestCoordinator;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.getRoot().isAnyResourceSet() == false) goto L8;
        return false;
    }

    private void notifyRequestCoordinatorLoadSucceeded() {
        RequestCoordinator r0 = this.requestCoordinator;
        if (r0 == null) goto L6;
        r0.onRequestSuccess(this);
        return;
    }

    private void notifyRequestCoordinatorLoadFailed() {
        RequestCoordinator r0 = this.requestCoordinator;
        if (r0 == null) goto L6;
        r0.onRequestFailed(this);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.request.ResourceCallback
    public void onResourceReady(Resource<?> r7, DataSource r8, boolean r9) {
        this.stateVerifier.throwIfRecycled();
        Resource<?> r2 = null;
        Object r3 = this.requestLock;     // Catch: Throwable -> L43
        monitor-enter(r3);     // Catch: Throwable -> L43
        this.loadStatus = null;     // Catch: Throwable -> L40
        if (r7 != null) goto L10;
        onLoadFailed(new GlideException("Expected to receive a Resource<R> with an object of " + this.transcodeClass + " inside, but instead got null."));     // Catch: Throwable -> L40
        monitor-exit(r3);     // Catch: Throwable -> L40
        return;
    L10:
        Object r1 = r7.get();     // Catch: Throwable -> L40
        if (r1 != null) goto L13;
    L25:
        this.resource = null;     // Catch: Throwable -> L38
        StringBuilder r10 = new StringBuilder("Expected to receive an object of ").append(this.transcodeClass).append(" but instead got ");     // Catch: Throwable -> L38
        if (r1 == null) goto L28;
        Object r0 = r1.getClass();     // Catch: Throwable -> L38
    L29:
        StringBuilder r11 = r10.append(r0).append("{").append(r1).append("} inside Resource{").append(r7).append("}.");     // Catch: Throwable -> L38
        if (r1 == null) goto L32;
        String r4 = "";
    L33:
        onLoadFailed(new GlideException(r11.append(r4).toString()));     // Catch: Throwable -> L38
        monitor-exit(r3);     // Catch: Throwable -> L38
        if (r7 == null) goto L52;
        this.engine.release(r7);
        return;
    L52:
        return;
    L32:
        r4 = " To indicate failure return a null Resource object, rather than a Resource object containing null data.";
        goto L33
    L28:
        r0 = "";
        goto L29
    L13:
        if (this.transcodeClass.isAssignableFrom(r1.getClass()) == false) goto L25;
        if (canSetResource() == true) goto L22;
        this.resource = null;     // Catch: Throwable -> L38
        this.status = Status.COMPLETE;     // Catch: Throwable -> L38
        GlideTrace.endSectionAsync(TAG, this.cookie);     // Catch: Throwable -> L38
        monitor-exit(r3);     // Catch: Throwable -> L38
        if (r7 == null) goto L51;
        this.engine.release(r7);
        return;
    L51:
        return;
    L22:
        onResourceReady(r7, r1, r8, r9);     // Catch: Throwable -> L40
        monitor-exit(r3);     // Catch: Throwable -> L40
        return;
    L38:
        th = move-exception;
        r2 = r7;
        th = th;
    L41:
        monitor-exit(r3);     // Catch: Throwable -> L40
        throw th;     // Catch: Throwable -> L43
    L40:
        th = th;
    L43:
        th = move-exception;
        if (r2 == null) goto L46;
        this.engine.release(r2);
    L46:
        throw th;
    }

    private void onResourceReady(Resource<R> r16, R r17, DataSource r18, boolean r19) {
        boolean r9 = isFirstReadyResource();
        this.status = Status.COMPLETE;
        this.resource = r16;
        if (this.glideContext.getLogLevel() > 3) goto L5;
        Log.d(GLIDE_TAG, "Finished loading " + r17.getClass().getSimpleName() + " from " + r18 + " for " + this.model + " with size [" + this.width + MaterialConfigFormatNames.X + this.height + "] in " + LogTime.getElapsedMillis(this.startTime) + " ms");
    L5:
        notifyRequestCoordinatorLoadSucceeded();
        boolean r10 = true;
        this.isCallingCallbacks = true;
        List<RequestListener<R>> r2 = this.requestListeners;     // Catch: Throwable -> L27
        if (r2 == null) goto L15;
        Iterator<RequestListener<R>> r12 = r2.iterator();     // Catch: Throwable -> L27
        boolean r8 = false;
    L10:
        if (r12.hasNext() == false) goto L16;
        RequestListener<R> r13 = r12.next();     // Catch: Throwable -> L27
        boolean r14 = r8 | r13.onResourceReady(r17, this.model, this.target, r18, r9);     // Catch: Throwable -> L27
        if ((r13 instanceof ExperimentalRequestListener) == true) goto L13;
        r8 = r14;
        goto L10
    L13:
        r8 = ((ExperimentalRequestListener) r13).onResourceReady(r17, this.model, this.target, r18, r9, r19) | r14;     // Catch: Throwable -> L27
    L16:
        RequestListener<R> r3 = this.targetListener;     // Catch: Throwable -> L27
        if (r3 != null) goto L19;
    L21:
        r10 = false;
    L23:
        if ((r8 | r10) == true) goto L25;
        this.target.onResourceReady(r17, this.animationFactory.build(r18, r9));     // Catch: Throwable -> L27
    L25:
        this.isCallingCallbacks = false;
        GlideTrace.endSectionAsync(TAG, this.cookie);
        return;
    L19:
        if (r3.onResourceReady(r17, this.model, this.target, r18, r9) == false) goto L21;
    L15:
        r8 = false;
    L27:
        th = move-exception;
        this.isCallingCallbacks = false;
        throw th;
    }

    @Override // com.bumptech.glide.request.ResourceCallback
    public void onLoadFailed(GlideException r2) {
        onLoadFailed(r2, 5);
    }

    @Override // com.bumptech.glide.request.ResourceCallback
    public Object getLock() {
        this.stateVerifier.throwIfRecycled();
        return this.requestLock;
    }

    private void onLoadFailed(GlideException r9, int r10) {
        this.stateVerifier.throwIfRecycled();
        Object r1 = this.requestLock;
        monitor-enter(r1);
        r9.setOrigin(this.requestOrigin);     // Catch: Throwable -> L33
        int r2 = this.glideContext.getLogLevel();     // Catch: Throwable -> L33
        if (r2 > r10) goto L9;
        Log.w(GLIDE_TAG, "Load failed for [" + this.model + "] with dimensions [" + this.width + MaterialConfigFormatNames.X + this.height + "]", r9);     // Catch: Throwable -> L33
        if (r2 > 4) goto L9;
        r9.logRootCauses(GLIDE_TAG);     // Catch: Throwable -> L33
    L9:
        this.loadStatus = null;     // Catch: Throwable -> L33
        this.status = Status.FAILED;     // Catch: Throwable -> L33
        notifyRequestCoordinatorLoadFailed();     // Catch: Throwable -> L33
        boolean r11 = true;
        this.isCallingCallbacks = true;     // Catch: Throwable -> L33
        List<RequestListener<R>> r3 = this.requestListeners;     // Catch: Throwable -> L30
        if (r3 == null) goto L17;
        Iterator<RequestListener<R>> r4 = r3.iterator();     // Catch: Throwable -> L30
        boolean r5 = false;
    L15:
        if (r4.hasNext() == false) goto L18;
        r5 = r5 | r4.next().onLoadFailed(r9, this.model, this.target, isFirstReadyResource());     // Catch: Throwable -> L30
    L18:
        RequestListener<R> r6 = this.targetListener;     // Catch: Throwable -> L30
        if (r6 != null) goto L21;
    L23:
        r11 = false;
    L25:
        if ((r5 | r11) == true) goto L27;
        setErrorPlaceholder();     // Catch: Throwable -> L30
    L27:
        this.isCallingCallbacks = false;     // Catch: Throwable -> L33
        GlideTrace.endSectionAsync(TAG, this.cookie);     // Catch: Throwable -> L33
        monitor-exit(r1);     // Catch: Throwable -> L33
        return;
    L21:
        if (r6.onLoadFailed(r9, this.model, this.target, isFirstReadyResource()) == false) goto L23;
    L17:
        r5 = false;
    L30:
        th = move-exception;
        this.isCallingCallbacks = false;     // Catch: Throwable -> L33
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isEquivalentTo(Request r15) {
        if ((r15 instanceof SingleRequest) == true) goto L5;
        return false;
    L5:
        Object r0 = this.requestLock;
        monitor-enter(r0);
        int r2 = this.overrideWidth;     // Catch: Throwable -> L34
        int r3 = this.overrideHeight;     // Catch: Throwable -> L34
        Object r4 = this.model;     // Catch: Throwable -> L34
        Class<R> r5 = this.transcodeClass;     // Catch: Throwable -> L34
        BaseRequestOptions<?> r6 = this.requestOptions;     // Catch: Throwable -> L34
        Priority r7 = this.priority;     // Catch: Throwable -> L34
        List<RequestListener<R>> r14 = this.requestListeners;     // Catch: Throwable -> L34
        if (r14 == null) goto L10;
        int r16 = r14.size();     // Catch: Throwable -> L34
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L34
        SingleRequest r17 = (SingleRequest) r15;
        Object r8 = r17.requestLock;
        monitor-enter(r8);
        int r1 = r17.overrideWidth;     // Catch: Throwable -> L31
        int r9 = r17.overrideHeight;     // Catch: Throwable -> L31
        Object r10 = r17.model;     // Catch: Throwable -> L31
        Class<R> r11 = r17.transcodeClass;     // Catch: Throwable -> L31
        BaseRequestOptions<?> r12 = r17.requestOptions;     // Catch: Throwable -> L31
        Priority r13 = r17.priority;     // Catch: Throwable -> L31
        List<RequestListener<R>> r18 = r17.requestListeners;     // Catch: Throwable -> L31
        if (r18 == null) goto L17;
        int r19 = r18.size();     // Catch: Throwable -> L31
    L18:
        monitor-exit(r8);     // Catch: Throwable -> L31
        if (r2 != r1) goto L41;
        if (r3 == r9) goto L22;
        return false;
    L22:
        if (Util.bothModelsNullEquivalentOrEquals(r4, r10) == true) goto L24;
        return false;
    L24:
        if (r5.equals(r11) == true) goto L26;
        return false;
    L26:
        if (Util.bothBaseRequestOptionsNullEquivalentOrEquals(r6, r12) == false) goto L45;
        if (r7 != r13) goto L46;
        if (r16 != r19) goto L47;
        return true;
    L47:
        return false;
    L46:
        return false;
    L45:
        return false;
    L41:
        return false;
    L17:
        r19 = 0;
    L31:
        th = move-exception;
        throw th;
    L10:
        r16 = 0;
    L34:
        th = move-exception;
        throw th;
    }

    private void logV(String r2) {
        Log.v(TAG, r2 + " this: " + this.tag);
    }

    public String toString() {
        Object r0 = this.requestLock;
        monitor-enter(r0);
        Object r1 = this.model;     // Catch: Throwable -> L8
        Class<R> r2 = this.transcodeClass;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return super.toString() + "[model=" + r1 + ", transcodeClass=" + r2 + "]";
    L8:
        th = move-exception;
        throw th;
    }
}
