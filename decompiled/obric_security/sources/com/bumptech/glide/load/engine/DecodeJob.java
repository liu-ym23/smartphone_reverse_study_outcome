package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.core.util.Pools;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.GlideTrace;
import com.bumptech.glide.util.pool.StateVerifier;
import com.bytedance.apm.doctor.DoctorConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class DecodeJob<R> implements DataFetcherGenerator.FetcherReadyCallback, Runnable, Comparable<DecodeJob<?>>, FactoryPools.Poolable {
    private static final String TAG = "DecodeJob";
    private Callback<R> callback;
    private Key currentAttemptingKey;
    private Object currentData;
    private DataSource currentDataSource;
    private DataFetcher<?> currentFetcher;
    private volatile DataFetcherGenerator currentGenerator;
    private Key currentSourceKey;
    private Thread currentThread;
    private final DecodeHelper<R> decodeHelper;
    private final DeferredEncodeManager<?> deferredEncodeManager;
    private final DiskCacheProvider diskCacheProvider;
    private DiskCacheStrategy diskCacheStrategy;
    private GlideContext glideContext;
    private int height;
    private volatile boolean isCallbackNotified;
    private volatile boolean isCancelled;
    private boolean isLoadingFromAlternateCacheKey;
    private EngineKey loadKey;
    private Object model;
    private boolean onlyRetrieveFromCache;
    private Options options;
    private int order;
    private final Pools.Pool<DecodeJob<?>> pool;
    private Priority priority;
    private final ReleaseManager releaseManager;
    private RunReason runReason;
    private Key signature;
    private Stage stage;
    private long startFetchTime;
    private final StateVerifier stateVerifier;
    private final List<Throwable> throwables;
    private int width;

    /* JADX INFO: renamed from: com.bumptech.glide.load.engine.DecodeJob$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bumptech$glide$load$EncodeStrategy = null;
        static final /* synthetic */ int[] $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason = null;
        static final /* synthetic */ int[] $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage = null;

        static {
            int[] r0 = new int[EncodeStrategy.values().length];
            $SwitchMap$com$bumptech$glide$load$EncodeStrategy = r0;
            r0[EncodeStrategy.SOURCE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L28:
            $SwitchMap$com$bumptech$glide$load$EncodeStrategy[EncodeStrategy.TRANSFORMED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L6:
            int[] r2 = new int[Stage.values().length];
            $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage = r2;
            r2[Stage.RESOURCE_CACHE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L36:
            $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[Stage.DATA_CACHE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L46:
            $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[Stage.SOURCE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L32:
            $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[Stage.FINISHED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L38:
            $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[Stage.INITIALIZE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L24
        L13:
            int[] r3 = new int[RunReason.values().length];
            $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason = r3;
            r3[RunReason.INITIALIZE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L42:
            $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason[RunReason.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L30:
            $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason[RunReason.DECODE_DATA.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
            return;
        }
    }

    interface Callback<R> {
        void onLoadFailed(GlideException r1);

        void onResourceReady(Resource<R> r1, DataSource r2, boolean r3);

        void reschedule(DecodeJob<?> r1);
    }

    private final class DecodeCallback<Z> implements DecodePath.DecodeCallback<Z> {
        private final DataSource dataSource;
        final /* synthetic */ DecodeJob this$0;

        DecodeCallback(DecodeJob r1, DataSource r2) {
            this.this$0 = r1;
            this.dataSource = r2;
        }

        @Override // com.bumptech.glide.load.engine.DecodePath.DecodeCallback
        public Resource<Z> onResourceDecoded(Resource<Z> r2) {
            return this.this$0.onResourceDecoded(this.dataSource, r2);
        }
    }

    private static class DeferredEncodeManager<Z> {
        private ResourceEncoder<Z> encoder;
        private Key key;
        private LockedResource<Z> toEncode;

        DeferredEncodeManager() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        <X> void init(Key r1, ResourceEncoder<X> r2, LockedResource<X> r3) {
            this.key = r1;
            this.encoder = r2;
            this.toEncode = r3;
        }

        void encode(DiskCacheProvider r5, Options r6) {
            GlideTrace.beginSection("DecodeJob.encode");
            r5.getDiskCache().put(this.key, new DataCacheWriter(this.encoder, this.toEncode, r6));     // Catch: Throwable -> L6
            this.toEncode.unlock();
            GlideTrace.endSection();
            return;
        L6:
            th = move-exception;
            this.toEncode.unlock();
            GlideTrace.endSection();
            throw th;
        }

        boolean hasResourceToEncode() {
            if (this.toEncode == null) goto L5;
            return true;
        L5:
            return false;
        }

        void clear() {
            this.key = null;
            this.encoder = null;
            this.toEncode = null;
        }
    }

    interface DiskCacheProvider {
        DiskCache getDiskCache();
    }

    private static class ReleaseManager {
        private boolean isEncodeComplete;
        private boolean isFailed;
        private boolean isReleased;

        ReleaseManager() {
        }

        synchronized boolean release(boolean r2) {
            monitor-enter(this);
            this.isReleased = true;     // Catch: Throwable -> L7
            boolean r3 = isComplete(r2);     // Catch: Throwable -> L7
            monitor-exit(this);
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        synchronized boolean onEncodeComplete() {
            monitor-enter(this);
            this.isEncodeComplete = true;     // Catch: Throwable -> L7
            boolean r0 = isComplete(false);     // Catch: Throwable -> L7
            monitor-exit(this);
            return r0;
        L7:
            th = move-exception;
            throw th;
        }

        synchronized boolean onFailed() {
            monitor-enter(this);
            this.isFailed = true;     // Catch: Throwable -> L7
            boolean r0 = isComplete(false);     // Catch: Throwable -> L7
            monitor-exit(this);
            return r0;
        L7:
            th = move-exception;
            throw th;
        }

        synchronized void reset() {
            monitor-enter(this);
            this.isEncodeComplete = false;     // Catch: Throwable -> L7
            this.isReleased = false;     // Catch: Throwable -> L7
            this.isFailed = false;     // Catch: Throwable -> L7
            monitor-exit(this);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private boolean isComplete(boolean r2) {
            if (this.isFailed == true) goto L8;
            if (r2 == true) goto L8;
            if (this.isEncodeComplete == true) goto L8;
        L10:
            return false;
        L8:
            if (this.isReleased == false) goto L10;
            return true;
        }
    }

    private static final enum RunReason extends Enum<RunReason> {
        private static final /* synthetic */ RunReason[] $VALUES = null;
        public static final RunReason DECODE_DATA = null;
        public static final RunReason INITIALIZE = null;
        public static final RunReason SWITCH_TO_SOURCE_SERVICE = null;

        private static /* synthetic */ RunReason[] $values() {
            return new RunReason[]{INITIALIZE, SWITCH_TO_SOURCE_SERVICE, DECODE_DATA};
        }

        private RunReason(String r1, int r2) {
            super(r1, r2);
        }

        public static RunReason valueOf(String r1) {
            return (RunReason) Enum.valueOf(RunReason.class, r1);
        }

        public static RunReason[] values() {
            return (RunReason[]) $VALUES.clone();
        }

        static {
            INITIALIZE = new RunReason("INITIALIZE", 0);
            SWITCH_TO_SOURCE_SERVICE = new RunReason("SWITCH_TO_SOURCE_SERVICE", 1);
            DECODE_DATA = new RunReason("DECODE_DATA", 2);
            $VALUES = $values();
        }
    }

    private static final enum Stage extends Enum<Stage> {
        private static final /* synthetic */ Stage[] $VALUES = null;
        public static final Stage DATA_CACHE = null;
        public static final Stage ENCODE = null;
        public static final Stage FINISHED = null;
        public static final Stage INITIALIZE = null;
        public static final Stage RESOURCE_CACHE = null;
        public static final Stage SOURCE = null;

        private static /* synthetic */ Stage[] $values() {
            return new Stage[]{INITIALIZE, RESOURCE_CACHE, DATA_CACHE, SOURCE, ENCODE, FINISHED};
        }

        private Stage(String r1, int r2) {
            super(r1, r2);
        }

        public static Stage valueOf(String r1) {
            return (Stage) Enum.valueOf(Stage.class, r1);
        }

        public static Stage[] values() {
            return (Stage[]) $VALUES.clone();
        }

        static {
            INITIALIZE = new Stage("INITIALIZE", 0);
            RESOURCE_CACHE = new Stage("RESOURCE_CACHE", 1);
            DATA_CACHE = new Stage(DoctorConstants.DATA_CACHE, 2);
            SOURCE = new Stage("SOURCE", 3);
            ENCODE = new Stage("ENCODE", 4);
            FINISHED = new Stage("FINISHED", 5);
            $VALUES = $values();
        }
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(DecodeJob<?> r1) {
        return compareTo2(r1);
    }

    DecodeJob(DiskCacheProvider r2, Pools.Pool<DecodeJob<?>> r3) {
        this.decodeHelper = new DecodeHelper();
        this.throwables = new ArrayList();
        this.stateVerifier = StateVerifier.newInstance();
        this.deferredEncodeManager = new DeferredEncodeManager();
        this.releaseManager = new ReleaseManager();
        this.diskCacheProvider = r2;
        this.pool = r3;
    }

    DecodeJob<R> init(GlideContext r17, Object r18, EngineKey r19, Key r20, int r21, int r22, Class<?> r23, Class<R> r24, Priority r25, DiskCacheStrategy r26, Map<Class<?>, Transformation<?>> r27, boolean r28, boolean r29, boolean r30, Options r31, Callback<R> r32, int r33) {
        this.decodeHelper.init(r17, r18, r20, r21, r22, r26, r23, r24, r25, r31, r27, r28, r29, this.diskCacheProvider);
        this.glideContext = r17;
        this.signature = r20;
        this.priority = r25;
        this.loadKey = r19;
        this.width = r21;
        this.height = r22;
        this.diskCacheStrategy = r26;
        this.onlyRetrieveFromCache = r30;
        this.options = r31;
        this.callback = r32;
        this.order = r33;
        this.runReason = RunReason.INITIALIZE;
        this.model = r18;
        return this;
    }

    boolean willDecodeFromCache() {
        Stage r1 = getNextStage(Stage.INITIALIZE);
        if (r1 != Stage.RESOURCE_CACHE) goto L5;
    L8:
        return true;
    L5:
        if (r1 == Stage.DATA_CACHE) goto L8;
        return false;
    }

    void release(boolean r2) {
        if (this.releaseManager.release(r2) == false) goto L6;
        releaseInternal();
        return;
    }

    private void onEncodeComplete() {
        if (this.releaseManager.onEncodeComplete() == false) goto L6;
        releaseInternal();
        return;
    }

    private void onLoadFailed() {
        if (this.releaseManager.onFailed() == false) goto L6;
        releaseInternal();
        return;
    }

    private void releaseInternal() {
        this.releaseManager.reset();
        this.deferredEncodeManager.clear();
        this.decodeHelper.clear();
        this.isCallbackNotified = false;
        this.glideContext = null;
        this.signature = null;
        this.options = null;
        this.priority = null;
        this.loadKey = null;
        this.callback = null;
        this.stage = null;
        this.currentGenerator = null;
        this.currentThread = null;
        this.currentSourceKey = null;
        this.currentData = null;
        this.currentDataSource = null;
        this.currentFetcher = null;
        this.startFetchTime = 0;
        this.isCancelled = false;
        this.model = null;
        this.throwables.clear();
        this.pool.release(this);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(DecodeJob<?> r3) {
        int r0 = getPriority() - r3.getPriority();
        if (r0 == 0) goto L5;
        return r0;
    L5:
        return this.order - r3.order;
    }

    private int getPriority() {
        return this.priority.ordinal();
    }

    public void cancel() {
        this.isCancelled = true;
        DataFetcherGenerator r1 = this.currentGenerator;
        if (r1 == null) goto L6;
        r1.cancel();
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        GlideTrace.beginSectionFormat("DecodeJob#run(reason=%s, model=%s)", this.runReason, this.model);
        DataFetcher<?> r2 = this.currentFetcher;
    L29:
        th = move-exception;
        if (r2 == null) goto L32;
        r2.cleanup();
    L32:
        GlideTrace.endSection();
        throw th;
    L27:
        e = move-exception;
        throw e;     // Catch: Throwable -> L29
    L15:
        th = move-exception;
        if (Log.isLoggable(TAG, 3) == false) goto L21;
        Log.d(TAG, "DecodeJob threw unexpectedly, isCancelled: " + this.isCancelled + ", stage: " + this.stage, th);     // Catch: Throwable -> L29
    L21:
        if (this.stage == Stage.ENCODE) goto L24;
        this.throwables.add(th);     // Catch: Throwable -> L29
        notifyFailed();     // Catch: Throwable -> L29
    L24:
        if (this.isCancelled == true) goto L26;
        throw th;     // Catch: Throwable -> L29
    L26:
        throw th;     // Catch: Throwable -> L29
    L4:
        if (this.isCancelled == false) goto L10;
        notifyFailed();     // Catch: Throwable -> L15 CallbackException -> L27
        if (r2 == null) goto L8;
        r2.cleanup();
    L8:
        GlideTrace.endSection();
        return;
    L10:
        runWrapped();     // Catch: Throwable -> L15 CallbackException -> L27
        if (r2 == null) goto L13;
        r2.cleanup();
    L13:
        GlideTrace.endSection();
    }

    private void runWrapped() {
        int r0 = AnonymousClass1.$SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason[this.runReason.ordinal()];
        if (r0 != 1) goto L5;
        this.stage = getNextStage(Stage.INITIALIZE);
        this.currentGenerator = getNextGenerator();
        runGenerators();
        return;
    L5:
        if (r0 != 2) goto L7;
        runGenerators();
        return;
    L7:
        if (r0 != 3) goto L10;
        decodeFromRetrievedData();
        return;
    L10:
        throw new IllegalStateException("Unrecognized run reason: " + this.runReason);
    }

    private DataFetcherGenerator getNextGenerator() {
        int r0 = AnonymousClass1.$SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[this.stage.ordinal()];
        if (r0 == 1) goto L19;
        if (r0 == 2) goto L17;
        if (r0 == 3) goto L15;
        if (r0 != 4) goto L13;
        return null;
    L13:
        throw new IllegalStateException("Unrecognized stage: " + this.stage);
    L15:
        return new SourceGenerator(this.decodeHelper, this);
    L17:
        return new DataCacheGenerator(this.decodeHelper, this);
    L19:
        return new ResourceCacheGenerator(this.decodeHelper, this);
    }

    private void runGenerators() {
        this.currentThread = Thread.currentThread();
        this.startFetchTime = LogTime.getLogTime();
        boolean r0 = false;
    L4:
        if (this.isCancelled == true) goto L14;
        if (this.currentGenerator == null) goto L14;
        r0 = this.currentGenerator.startNext();
        if (r0 == true) goto L14;
        this.stage = getNextStage(this.stage);
        this.currentGenerator = getNextGenerator();
        if (this.stage != Stage.SOURCE) goto L4;
        reschedule(RunReason.SWITCH_TO_SOURCE_SERVICE);
        return;
    L14:
        if (this.stage != Stage.FINISHED) goto L16;
    L17:
        if (r0 == true) goto L26;
        notifyFailed();
        return;
    L26:
        return;
    L16:
        if (this.isCancelled == true) goto L17;
    }

    private void notifyFailed() {
        setNotifiedOrThrow();
        GlideException r0 = new GlideException("Failed to load resource", new ArrayList(this.throwables));
        this.callback.onLoadFailed(r0);
        onLoadFailed();
    }

    private void notifyComplete(Resource<R> r1, DataSource r2, boolean r3) {
        setNotifiedOrThrow();
        this.callback.onResourceReady(r1, r2, r3);
    }

    private void setNotifiedOrThrow() {
        this.stateVerifier.throwIfRecycled();
        if (this.isCallbackNotified == true) goto L5;
        this.isCallbackNotified = true;
        return;
    L5:
        if (this.throwables.isEmpty() == false) goto L7;
        Throwable r2 = null;
    L9:
        throw new IllegalStateException("Already notified", r2);
    L7:
        List<Throwable> r3 = this.throwables;
        r2 = r3.get(r3.size() - 1);
        goto L9
    }

    private Stage getNextStage(Stage r3) {
        int r0 = AnonymousClass1.$SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[r3.ordinal()];
        if (r0 == 1) goto L27;
        if (r0 == 2) goto L22;
        if (r0 == 3) goto L20;
        if (r0 == 4) goto L20;
        if (r0 != 5) goto L18;
        if (this.diskCacheStrategy.decodeCachedResource() == false) goto L16;
        return Stage.RESOURCE_CACHE;
    L16:
        return getNextStage(Stage.RESOURCE_CACHE);
    L18:
        throw new IllegalArgumentException("Unrecognized stage: " + r3);
    L20:
        return Stage.FINISHED;
    L22:
        if (this.onlyRetrieveFromCache == false) goto L25;
        return Stage.FINISHED;
    L25:
        return Stage.SOURCE;
    L27:
        if (this.diskCacheStrategy.decodeCachedData() == false) goto L30;
        return Stage.DATA_CACHE;
    L30:
        return getNextStage(Stage.DATA_CACHE);
    }

    private void reschedule(RunReason r1) {
        this.runReason = r1;
        this.callback.reschedule(this);
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void reschedule() {
        reschedule(RunReason.SWITCH_TO_SOURCE_SERVICE);
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void onDataFetcherReady(Key r1, Object r2, DataFetcher<?> r3, DataSource r4, Key r5) {
        this.currentSourceKey = r1;
        this.currentData = r2;
        this.currentFetcher = r3;
        this.currentDataSource = r4;
        this.currentAttemptingKey = r5;
        boolean r6 = false;
        if (r1 == this.decodeHelper.getCacheKeys().get(0)) goto L5;
        r6 = true;
    L5:
        this.isLoadingFromAlternateCacheKey = r6;
        if (Thread.currentThread() == this.currentThread) goto L8;
        reschedule(RunReason.DECODE_DATA);
        return;
    L8:
        GlideTrace.beginSection("DecodeJob.decodeFromRetrievedData");
        decodeFromRetrievedData();     // Catch: Throwable -> L12
        GlideTrace.endSection();
        return;
    L12:
        th = move-exception;
        GlideTrace.endSection();
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void onDataFetcherFailed(Key r3, Exception r4, DataFetcher<?> r5, DataSource r6) {
        r5.cleanup();
        GlideException r0 = new GlideException("Fetching data failed", r4);
        r0.setLoggingDetails(r3, r6, r5.getDataClass());
        this.throwables.add(r0);
        if (Thread.currentThread() == this.currentThread) goto L5;
        reschedule(RunReason.SWITCH_TO_SOURCE_SERVICE);
        return;
    L5:
        runGenerators();
    }

    private void decodeFromRetrievedData() {
        if (Log.isLoggable(TAG, 2) == false) goto L13;
        logWithTimeAndKey("Retrieved data", this.startFetchTime, "data: " + this.currentData + ", cache key: " + this.currentSourceKey + ", fetcher: " + this.currentFetcher);
    L13:
        Resource<R> r0 = decodeFromData(this.currentFetcher, this.currentData, this.currentDataSource);     // Catch: GlideException -> L7
    L9:
        if (r0 == null) goto L11;
        notifyEncodeAndRelease(r0, this.currentDataSource, this.isLoadingFromAlternateCacheKey);
        return;
    L11:
        runGenerators();
        return;
    L7:
        e = move-exception;
        e.setLoggingDetails(this.currentAttemptingKey, this.currentDataSource);
        this.throwables.add(e);
        r0 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void notifyEncodeAndRelease(Resource<R> r2, DataSource r3, boolean r4) {
        GlideTrace.beginSection("DecodeJob.notifyEncodeAndRelease");
    L23:
        th = move-exception;
        GlideTrace.endSection();
        throw th;
    L4:
        if ((r2 instanceof Initializable) == false) goto L7;
        ((Initializable) r2).initialize();     // Catch: Throwable -> L23
    L7:
        if (this.deferredEncodeManager.hasResourceToEncode() == false) goto L9;
        r2 = LockedResource.obtain(r2);     // Catch: Throwable -> L23
        LockedResource r0 = r2;
    L10:
        notifyComplete(r2, r3, r4);     // Catch: Throwable -> L23
        this.stage = Stage.ENCODE;     // Catch: Throwable -> L23
    L19:
        th = move-exception;
        if (r0 == 0) goto L22;
        r0.unlock();     // Catch: Throwable -> L23
    L22:
        throw th;     // Catch: Throwable -> L23
    L12:
        if (this.deferredEncodeManager.hasResourceToEncode() == false) goto L14;
        this.deferredEncodeManager.encode(this.diskCacheProvider, this.options);     // Catch: Throwable -> L19
    L14:
        if (r0 == 0) goto L16;
        r0.unlock();     // Catch: Throwable -> L23
    L16:
        onEncodeComplete();     // Catch: Throwable -> L23
        GlideTrace.endSection();
        return;
    L9:
        r0 = 0;
        goto L10
    }

    private <Data> Resource<R> decodeFromData(DataFetcher<?> r5, Data r6, DataSource r7) throws GlideException {
        if (r6 != null) goto L14;
        r5.cleanup();
        return null;
    L14:
        long r1 = LogTime.getLogTime();     // Catch: Throwable -> L11
        Resource<R> r8 = decodeFromFetcher(r6, r7);     // Catch: Throwable -> L11
        if (Log.isLoggable(TAG, 2) == false) goto L9;
        logWithTimeAndKey("Decoded result " + r8, r1);     // Catch: Throwable -> L11
    L9:
        r5.cleanup();
        return r8;
    L11:
        th = move-exception;
        r5.cleanup();
        throw th;
    }

    private <Data> Resource<R> decodeFromFetcher(Data r3, DataSource r4) throws GlideException {
        return runLoadPath(r3, r4, this.decodeHelper.getLoadPath(r3.getClass()));
    }

    private Options getOptionsWithHardwareConfig(DataSource r3) {
        Options r0 = this.options;
        if (r3 != DataSource.RESOURCE_DISK_CACHE) goto L5;
    L8:
        boolean r4 = true;
    L9:
        Boolean r1 = (Boolean) r0.get(Downsampler.ALLOW_HARDWARE_CONFIG);
        if (r1 != null) goto L12;
    L15:
        Options r2 = new Options();
        r2.putAll(this.options);
        r2.set(Downsampler.ALLOW_HARDWARE_CONFIG, Boolean.valueOf(r4));
        return r2;
    L12:
        if (r1.booleanValue() == false) goto L14;
        if (r4 == false) goto L15;
    L14:
        return r0;
    L5:
        if (this.decodeHelper.isScaleOnlyOrNoTransform() == true) goto L8;
        r4 = false;
        goto L9
    }

    private <Data, ResourceType> Resource<R> runLoadPath(Data r7, DataSource r8, LoadPath<Data, ResourceType, R> r9) throws GlideException {
        Options r2 = getOptionsWithHardwareConfig(r8);
        DataRewinder<Data> r10 = this.glideContext.getRegistry().getRewinder(r7);
        Resource<R> r6 = r9.load(r10, r2, this.width, this.height, new DecodeCallback(this, r8));     // Catch: Throwable -> L6
        r10.cleanup();
        return r6;
    L6:
        th = move-exception;
        r10.cleanup();
        throw th;
    }

    private void logWithTimeAndKey(String r2, long r3) {
        logWithTimeAndKey(r2, r3, null);
    }

    private void logWithTimeAndKey(String r2, long r3, String r5) {
        StringBuilder r1 = new StringBuilder().append(r2).append(" in ").append(LogTime.getElapsedMillis(r3)).append(", load key: ").append(this.loadKey);
        if (r5 == null) goto L5;
        String r4 = ", " + r5;
    L6:
        Log.v(TAG, r1.append(r4).append(", thread: ").append(Thread.currentThread().getName()).toString());
        return;
    L5:
        r4 = "";
        goto L6
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    public StateVerifier getVerifier() {
        return this.stateVerifier;
    }

    <Z> Resource<Z> onResourceDecoded(DataSource r12, Resource<Z> r13) {
        Class<?> r8 = r13.get().getClass();
        ResourceEncoder<Z> r1 = null;
        if (r12 == DataSource.RESOURCE_DISK_CACHE) goto L5;
        Transformation<Z> r0 = this.decodeHelper.getTransformation(r8);
        Transformation<Z> r7 = r0;
        Resource<Z> r2 = r0.transform(this.glideContext, r13, this.width, this.height);
    L7:
        if (r13.equals(r2) == true) goto L10;
        r13.recycle();
    L10:
        if (this.decodeHelper.isResourceEncoderAvailable(r2) == false) goto L12;
        r1 = this.decodeHelper.getResultEncoder(r2);
        EncodeStrategy r14 = r1.getEncodeStrategy(this.options);
    L13:
        ResourceEncoder r10 = r1;
        if (this.diskCacheStrategy.isResourceCacheable(!this.decodeHelper.isSourceKey(this.currentSourceKey), r12, r14) == false) goto L27;
        if (r10 == null) goto L26;
        int r15 = AnonymousClass1.$SwitchMap$com$bumptech$glide$load$EncodeStrategy[r14.ordinal()];
        if (r15 != 1) goto L19;
        Key r16 = new DataCacheKey(this.currentSourceKey, this.signature);
    L24:
        LockedResource r3 = LockedResource.obtain(r2);
        this.deferredEncodeManager.init(r16, r10, r3);
        return r3;
    L19:
        if (r15 != 2) goto L22;
        r16 = new ResourceCacheKey(this.decodeHelper.getArrayPool(), this.currentSourceKey, this.signature, this.width, this.height, r7, r8, this.options);
        goto L24
    L22:
        throw new IllegalArgumentException("Unknown strategy: " + r14);
    L26:
        throw new Registry.NoResultEncoderAvailableException(r2.get().getClass());
    L27:
        return r2;
    L12:
        r14 = EncodeStrategy.NONE;
        goto L13
    L5:
        r2 = r13;
        r7 = null;
        goto L7
    }
}
