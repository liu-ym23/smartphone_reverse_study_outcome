package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.ErrorRequestCoordinator;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.RequestFutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.SingleRequest;
import com.bumptech.glide.request.ThumbnailRequestCoordinator;
import com.bumptech.glide.request.target.PreloadTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.signature.AndroidResourceSignature;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class RequestBuilder<TranscodeType> extends BaseRequestOptions<RequestBuilder<TranscodeType>> implements Cloneable, ModelTypes<RequestBuilder<TranscodeType>> {
    protected static final RequestOptions DOWNLOAD_ONLY_OPTIONS = null;
    private final Context context;
    private RequestBuilder<TranscodeType> errorBuilder;
    private final Glide glide;
    private final GlideContext glideContext;
    private boolean isDefaultTransitionOptionsSet;
    private boolean isModelSet;
    private boolean isThumbnailBuilt;
    private Object model;
    private List<RequestListener<TranscodeType>> requestListeners;
    private final RequestManager requestManager;
    private Float thumbSizeMultiplier;
    private RequestBuilder<TranscodeType> thumbnailBuilder;
    private final Class<TranscodeType> transcodeClass;
    private TransitionOptions<?, ? super TranscodeType> transitionOptions;

    /* JADX INFO: renamed from: com.bumptech.glide.RequestBuilder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType = null;
        static final /* synthetic */ int[] $SwitchMap$com$bumptech$glide$Priority = null;

        static {
            int[] r0 = new int[Priority.values().length];
            $SwitchMap$com$bumptech$glide$Priority = r0;
            r0[Priority.LOW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L34:
            $SwitchMap$com$bumptech$glide$Priority[Priority.NORMAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L44:
            $SwitchMap$com$bumptech$glide$Priority[Priority.HIGH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L54:
            $SwitchMap$com$bumptech$glide$Priority[Priority.IMMEDIATE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L10:
            int[] r4 = new int[ImageView.ScaleType.values().length];
            $SwitchMap$android$widget$ImageView$ScaleType = r4;
            r4[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L36:
            $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L42:
            $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
        L48:
            $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_START.ordinal()] = 4;     // Catch: NoSuchFieldError -> L27
        L32:
            $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_END.ordinal()] = 5;     // Catch: NoSuchFieldError -> L28
        L40:
            $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_XY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L29
        L52:
            $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER.ordinal()] = 7;     // Catch: NoSuchFieldError -> L30
        L38:
            $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.MATRIX.ordinal()] = 8;     // Catch: NoSuchFieldError -> L31
            return;
        }
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions apply(BaseRequestOptions r1) {
        return apply(r1);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ BaseRequestOptions clone() {
        return clone();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object mo884clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ Object load(Bitmap r1) {
        return load(r1);
    }

    @Override // com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ Object load(Drawable r1) {
        return load(r1);
    }

    @Override // com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ Object load(Uri r1) {
        return load(r1);
    }

    @Override // com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ Object load(File r1) {
        return load(r1);
    }

    @Override // com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ Object load(Integer r1) {
        return load(r1);
    }

    @Override // com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ Object load(Object r1) {
        return load(r1);
    }

    @Override // com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ Object load(String r1) {
        return load(r1);
    }

    @Override // com.bumptech.glide.ModelTypes
    @Deprecated
    public /* bridge */ /* synthetic */ Object load(URL r1) {
        return load(r1);
    }

    @Override // com.bumptech.glide.ModelTypes
    public /* bridge */ /* synthetic */ Object load(byte[] r1) {
        return load(r1);
    }

    static {
        DOWNLOAD_ONLY_OPTIONS = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.DATA).priority(Priority.LOW).skipMemoryCache(true);
    }

    protected RequestBuilder(Glide r2, RequestManager r3, Class<TranscodeType> r4, Context r5) {
        this.isDefaultTransitionOptionsSet = true;
        this.glide = r2;
        this.requestManager = r3;
        this.transcodeClass = r4;
        this.context = r5;
        this.transitionOptions = r3.getDefaultTransitionOptions(r4);
        this.glideContext = r2.getGlideContext();
        initRequestListeners(r3.getDefaultRequestListeners());
        apply(r3.getDefaultRequestOptions());
    }

    RequestManager getRequestManager() {
        return this.requestManager;
    }

    protected RequestBuilder(Class<TranscodeType> r4, RequestBuilder<?> r5) {
        this(r5.glide, r5.requestManager, r4, r5.context);
        this.model = r5.model;
        this.isModelSet = r5.isModelSet;
        apply(r5);
    }

    private void initRequestListeners(List<RequestListener<Object>> r2) {
        Iterator<RequestListener<Object>> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        addListener((RequestListener) r3.next());
        goto L4
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public RequestBuilder<TranscodeType> apply(BaseRequestOptions<?> r1) {
        Preconditions.checkNotNull(r1);
        return (RequestBuilder) super.apply(r1);
    }

    public RequestBuilder<TranscodeType> transition(TransitionOptions<?, ? super TranscodeType> r2) {
        if (isAutoCloneEnabled() == true) goto L5;
        this.transitionOptions = (TransitionOptions) Preconditions.checkNotNull(r2);
        this.isDefaultTransitionOptionsSet = false;
        return selfOrThrowIfLocked();
    L5:
        return clone().transition(r2);
    }

    public RequestBuilder<TranscodeType> listener(RequestListener<TranscodeType> r2) {
        if (isAutoCloneEnabled() == true) goto L5;
        this.requestListeners = null;
        return addListener(r2);
    L5:
        return clone().listener(r2);
    }

    public RequestBuilder<TranscodeType> addListener(RequestListener<TranscodeType> r2) {
        if (isAutoCloneEnabled() == true) goto L5;
        if (r2 == null) goto L12;
        if (this.requestListeners != null) goto L10;
        this.requestListeners = new ArrayList();
    L10:
        this.requestListeners.add(r2);
    L12:
        return selfOrThrowIfLocked();
    L5:
        return clone().addListener(r2);
    }

    public RequestBuilder<TranscodeType> error(RequestBuilder<TranscodeType> r2) {
        if (isAutoCloneEnabled() == true) goto L5;
        this.errorBuilder = r2;
        return selfOrThrowIfLocked();
    L5:
        return clone().error(r2);
    }

    public RequestBuilder<TranscodeType> error(Object r2) {
        if (r2 != null) goto L6;
        RequestBuilder r0 = (RequestBuilder) null;
        return error(null);
    L6:
        return error(cloneWithNullErrorAndThumbnail().load(r2));
    }

    private RequestBuilder<TranscodeType> cloneWithNullErrorAndThumbnail() {
        RequestBuilder r1 = (RequestBuilder) null;
        return clone().error(null).thumbnail(null);
    }

    public RequestBuilder<TranscodeType> thumbnail(RequestBuilder<TranscodeType> r2) {
        if (isAutoCloneEnabled() == true) goto L5;
        this.thumbnailBuilder = r2;
        return selfOrThrowIfLocked();
    L5:
        return clone().thumbnail(r2);
    }

    public RequestBuilder<TranscodeType> thumbnail(RequestBuilder<TranscodeType>... r2) {
        if (r2 != null) goto L4;
    L8:
        RequestBuilder r0 = (RequestBuilder) null;
        return thumbnail(null);
    L4:
        if (r2.length == 0) goto L8;
        return thumbnail(Arrays.asList(r2));
    }

    public RequestBuilder<TranscodeType> thumbnail(List<RequestBuilder<TranscodeType>> r4) {
        RequestBuilder<TranscodeType> r0 = null;
        if (r4 != null) goto L5;
    L18:
        RequestBuilder r5 = (RequestBuilder) null;
        return thumbnail(null);
    L5:
        if (r4.isEmpty() == true) goto L18;
        int r1 = r4.size() - 1;
    L8:
        if (r1 < 0) goto L17;
        RequestBuilder<TranscodeType> r2 = r4.get(r1);
        if (r2 == null) goto L15;
        if (r0 != null) goto L14;
        r0 = r2;
        goto L15
    L14:
        r0 = r2.thumbnail(r0);
    L15:
        r1 = r1 - 1;
        goto L8
    L17:
        return thumbnail(r0);
    }

    @Deprecated
    public RequestBuilder<TranscodeType> thumbnail(float r2) {
        if (isAutoCloneEnabled() == false) goto L7;
        return clone().thumbnail(r2);
    L7:
        if (r2 < 0.0f) goto L13;
        if (r2 > 1.0f) goto L13;
        this.thumbSizeMultiplier = Float.valueOf(r2);
        return selfOrThrowIfLocked();
    L13:
        throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
    }

    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<TranscodeType> load(Object r1) {
        return loadGeneric(r1);
    }

    private RequestBuilder<TranscodeType> loadGeneric(Object r2) {
        if (isAutoCloneEnabled() == true) goto L5;
        this.model = r2;
        this.isModelSet = true;
        return selfOrThrowIfLocked();
    L5:
        return clone().loadGeneric(r2);
    }

    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<TranscodeType> load(Bitmap r1) {
        return loadGeneric(r1).apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE));
    }

    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<TranscodeType> load(Drawable r1) {
        return loadGeneric(r1).apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE));
    }

    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<TranscodeType> load(String r1) {
        return loadGeneric(r1);
    }

    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<TranscodeType> load(Uri r2) {
        return maybeApplyOptionsResourceUri(r2, loadGeneric(r2));
    }

    private RequestBuilder<TranscodeType> maybeApplyOptionsResourceUri(Uri r2, RequestBuilder<TranscodeType> r3) {
        if (r2 != null) goto L4;
    L8:
        return r3;
    L4:
        if ("android.resource".equals(r2.getScheme()) == false) goto L8;
        return applyResourceThemeAndSignature(r3);
    }

    private RequestBuilder<TranscodeType> applyResourceThemeAndSignature(RequestBuilder<TranscodeType> r2) {
        return r2.theme(this.context.getTheme()).signature(AndroidResourceSignature.obtain(this.context));
    }

    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<TranscodeType> load(File r1) {
        return loadGeneric(r1);
    }

    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<TranscodeType> load(Integer r1) {
        return applyResourceThemeAndSignature(loadGeneric(r1));
    }

    @Override // com.bumptech.glide.ModelTypes
    @Deprecated
    public RequestBuilder<TranscodeType> load(URL r1) {
        return loadGeneric(r1);
    }

    @Override // com.bumptech.glide.ModelTypes
    public RequestBuilder<TranscodeType> load(byte[] r1) {
        RequestBuilder<TranscodeType> r0 = loadGeneric(r1);
        if (r0.isDiskCacheStrategySet() == true) goto L6;
        r0 = r0.apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE));
    L6:
        if (r0.isSkipMemoryCacheSet() == false) goto L8;
        return r0;
    L8:
        return r0.apply(RequestOptions.skipMemoryCacheOf(true));
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public RequestBuilder<TranscodeType> clone() {
        RequestBuilder<TranscodeType> r2 = (RequestBuilder) super.clone();
        r2.transitionOptions = r2.transitionOptions.clone();
        if (r2.requestListeners == null) goto L5;
        r2.requestListeners = new ArrayList(r2.requestListeners);
    L5:
        RequestBuilder<TranscodeType> r0 = r2.thumbnailBuilder;
        if (r0 == null) goto L8;
        r2.thumbnailBuilder = r0.clone();
    L8:
        RequestBuilder<TranscodeType> r1 = r2.errorBuilder;
        if (r1 == null) goto L11;
        r2.errorBuilder = r1.clone();
    L11:
        return r2;
    }

    public <Y extends Target<TranscodeType>> Y into(Y r3) {
        return (Y) into(r3, null, Executors.mainThreadExecutor());
    }

    <Y extends Target<TranscodeType>> Y into(Y r1, RequestListener<TranscodeType> r2, Executor r3) {
        return (Y) into(r1, r2, this, r3);
    }

    private <Y extends Target<TranscodeType>> Y into(Y r2, RequestListener<TranscodeType> r3, BaseRequestOptions<?> r4, Executor r5) {
        Preconditions.checkNotNull(r2);
        if (this.isModelSet == false) goto L15;
        Request r6 = buildRequest(r2, r3, r4, r5);
        Request r7 = r2.getRequest();
        if (r6.isEquivalentTo(r7) == true) goto L7;
    L12:
        this.requestManager.clear(r2);
        r2.setRequest(r6);
        this.requestManager.track(r2, r6);
        return r2;
    L7:
        if (isSkipMemoryCacheWithCompletePreviousRequest(r4, r7) == true) goto L12;
        if (((Request) Preconditions.checkNotNull(r7)).isRunning() == true) goto L11;
        r7.begin();
    L11:
        return r2;
    L15:
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    private boolean isSkipMemoryCacheWithCompletePreviousRequest(BaseRequestOptions<?> r1, Request r2) {
        if (r1.isMemoryCacheable() == false) goto L5;
    L7:
        return false;
    L5:
        if (r2.isComplete() == false) goto L7;
        return true;
    }

    public ViewTarget<ImageView, TranscodeType> into(ImageView r4) {
        Util.assertMainThread();
        Preconditions.checkNotNull(r4);
        if (isTransformationSet() == false) goto L5;
        BaseRequestOptions r0 = this;
    L17:
        return (ViewTarget) into(this.glideContext.buildImageViewTarget(r4, this.transcodeClass), null, r0, Executors.mainThreadExecutor());
    L5:
        if (isTransformationAllowed() == true) goto L7;
        r0 = this;
        goto L17
    L7:
        if (r4.getScaleType() != null) goto L9;
        r0 = this;
        goto L17
    L9:
        switch(AnonymousClass1.$SwitchMap$android$widget$ImageView$ScaleType[r4.getScaleType().ordinal()]) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L12;
            case 5: goto L12;
            case 6: goto L11;
            default: goto L20;
        };
    L11:
        r0 = clone().optionalCenterInside();
        goto L17
    L12:
        r0 = clone().optionalFitCenter();
        goto L17
    L13:
        r0 = clone().optionalCenterInside();
        goto L17
    L14:
        r0 = clone().optionalCenterCrop();
        goto L17
    L20:
        r0 = this;
        goto L17
    }

    @Deprecated
    public FutureTarget<TranscodeType> into(int r1, int r2) {
        return submit(r1, r2);
    }

    public FutureTarget<TranscodeType> submit() {
        return submit(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public FutureTarget<TranscodeType> submit(int r2, int r3) {
        RequestFutureTarget r0 = new RequestFutureTarget(r2, r3);
        return (FutureTarget) into(r0, r0, Executors.directExecutor());
    }

    public Target<TranscodeType> preload(int r2, int r3) {
        return into(PreloadTarget.obtain(this.requestManager, r2, r3));
    }

    public Target<TranscodeType> preload() {
        return preload(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Deprecated
    public <Y extends Target<File>> Y downloadOnly(Y r1) {
        return (Y) getDownloadOnlyRequest().into(r1);
    }

    @Deprecated
    public FutureTarget<File> downloadOnly(int r1, int r2) {
        return getDownloadOnlyRequest().submit(r1, r2);
    }

    protected RequestBuilder<File> getDownloadOnlyRequest() {
        return new RequestBuilder(File.class, this).apply(DOWNLOAD_ONLY_OPTIONS);
    }

    private Priority getThumbnailPriority(Priority r3) {
        int r4 = AnonymousClass1.$SwitchMap$com$bumptech$glide$Priority[r3.ordinal()];
        if (r4 == 1) goto L18;
        if (r4 == 2) goto L16;
        if (r4 == 3) goto L14;
        if (r4 == 4) goto L14;
        throw new IllegalArgumentException("unknown priority: " + getPriority());
    L14:
        return Priority.IMMEDIATE;
    L16:
        return Priority.HIGH;
    L18:
        return Priority.NORMAL;
    }

    private Request buildRequest(Target<TranscodeType> r12, RequestListener<TranscodeType> r13, BaseRequestOptions<?> r14, Executor r15) {
        return buildRequestRecursive(new Object(), r12, r13, null, this.transitionOptions, r14.getPriority(), r14.getOverrideWidth(), r14.getOverrideHeight(), r14, r15);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Request buildRequestRecursive(Object r15, Target<TranscodeType> r16, RequestListener<TranscodeType> r17, RequestCoordinator r18, TransitionOptions<?, ? super TranscodeType> r19, Priority r20, int r21, int r22, BaseRequestOptions<?> r23, Executor r24) {
        if (this.errorBuilder == null) goto L5;
        RequestCoordinator r4 = new ErrorRequestCoordinator(r15, r18);
        ErrorRequestCoordinator r13 = r4;
    L6:
        Request r0 = buildThumbnailRequestRecursive(r15, r16, r17, r4, r19, r20, r21, r22, r23, r24);
        if (r13 != 0) goto L9;
        return r0;
    L9:
        int r1 = this.errorBuilder.getOverrideWidth();
        int r2 = this.errorBuilder.getOverrideHeight();
        if (Util.isValidDimensions(r21, r22) == true) goto L12;
    L14:
        RequestBuilder<TranscodeType> r3 = this.errorBuilder;
        ErrorRequestCoordinator r5 = r13;
        r13.setRequests(r0, r3.buildRequestRecursive(r15, r16, r17, r5, r3.transitionOptions, r3.getPriority(), r1, r2, this.errorBuilder, r24));
        return r13;
    L12:
        if (this.errorBuilder.isValidOverride() == true) goto L14;
        r1 = r23.getOverrideWidth();
        r2 = r23.getOverrideHeight();
        goto L14
    L5:
        r13 = 0;
        r4 = r18;
        goto L6
    }

    private Request buildThumbnailRequestRecursive(Object r19, Target<TranscodeType> r20, RequestListener<TranscodeType> r21, RequestCoordinator r22, TransitionOptions<?, ? super TranscodeType> r23, Priority r24, int r25, int r26, BaseRequestOptions<?> r27, Executor r28) {
        RequestBuilder<TranscodeType> r0 = this.thumbnailBuilder;
        if (r0 == null) goto L24;
        if (this.isThumbnailBuilt == true) goto L22;
        TransitionOptions<?, ? super TranscodeType> r1 = r0.transitionOptions;
        if (r0.isDefaultTransitionOptionsSet == false) goto L9;
        TransitionOptions<?, ? super TranscodeType> r14 = r23;
    L11:
        if (r0.isPrioritySet() == false) goto L13;
        Priority r2 = this.thumbnailBuilder.getPriority();
    L14:
        Priority r15 = r2;
        int r3 = this.thumbnailBuilder.getOverrideWidth();
        int r4 = this.thumbnailBuilder.getOverrideHeight();
        if (Util.isValidDimensions(r25, r26) == true) goto L17;
    L19:
        ThumbnailRequestCoordinator r10 = new ThumbnailRequestCoordinator(r19, r22);
        Request r11 = obtainRequest(r19, r20, r21, r27, r10, r23, r24, r25, r26, r28);
        this.isThumbnailBuilt = true;
        RequestBuilder<TranscodeType> r9 = this.thumbnailBuilder;
        TransitionOptions<?, ? super TranscodeType> r5 = r14;
        Request r6 = r9.buildRequestRecursive(r19, r20, r21, r10, r5, r15, r3, r4, r9, r28);
        this.isThumbnailBuilt = false;
        r10.setRequests(r11, r6);
        return r10;
    L17:
        if (this.thumbnailBuilder.isValidOverride() == true) goto L19;
        r3 = r27.getOverrideWidth();
        r4 = r27.getOverrideHeight();
        goto L19
    L13:
        r2 = getThumbnailPriority(r24);
        goto L14
    L9:
        r14 = r1;
        goto L11
    L22:
        throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
    L24:
        if (this.thumbSizeMultiplier == null) goto L28;
        ThumbnailRequestCoordinator r16 = new ThumbnailRequestCoordinator(r19, r22);
        r16.setRequests(obtainRequest(r19, r20, r21, r27, r16, r23, r24, r25, r26, r28), obtainRequest(r19, r20, r21, r27.clone().sizeMultiplier(this.thumbSizeMultiplier.floatValue()), r16, r23, getThumbnailPriority(r24), r25, r26, r28));
        return r16;
    L28:
        return obtainRequest(r19, r20, r21, r27, r22, r23, r24, r25, r26, r28);
    }

    private Request obtainRequest(Object r17, Target<TranscodeType> r18, RequestListener<TranscodeType> r19, BaseRequestOptions<?> r20, RequestCoordinator r21, TransitionOptions<?, ? super TranscodeType> r22, Priority r23, int r24, int r25, Executor r26) {
        Context r1 = this.context;
        GlideContext r2 = this.glideContext;
        return SingleRequest.obtain(r1, r2, r17, this.model, this.transcodeClass, r20, r24, r25, r23, r18, r19, this.requestListeners, r21, r2.getEngine(), r22.getTransitionFactory(), r26);
    }

    Object getModel() {
        return this.model;
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public boolean equals(Object r4) {
        if ((r4 instanceof RequestBuilder) == false) goto L26;
        RequestBuilder r5 = (RequestBuilder) r4;
        if (super.equals(r5) == true) goto L7;
        return false;
    L7:
        if (Objects.equals(this.transcodeClass, r5.transcodeClass) == true) goto L9;
        return false;
    L9:
        if (this.transitionOptions.equals(r5.transitionOptions) == true) goto L11;
        return false;
    L11:
        if (Objects.equals(this.model, r5.model) == true) goto L13;
        return false;
    L13:
        if (Objects.equals(this.requestListeners, r5.requestListeners) == true) goto L15;
        return false;
    L15:
        if (Objects.equals(this.thumbnailBuilder, r5.thumbnailBuilder) == true) goto L17;
        return false;
    L17:
        if (Objects.equals(this.errorBuilder, r5.errorBuilder) == true) goto L19;
        return false;
    L19:
        if (Objects.equals(this.thumbSizeMultiplier, r5.thumbSizeMultiplier) == true) goto L21;
        return false;
    L21:
        if (this.isDefaultTransitionOptionsSet == r5.isDefaultTransitionOptionsSet) goto L23;
        return false;
    L23:
        if (this.isModelSet != r5.isModelSet) goto L36;
        return true;
    L36:
        return false;
    L26:
        return false;
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public int hashCode() {
        int r0 = super.hashCode();
        int r1 = Util.hashCode(this.transcodeClass, r0);
        int r2 = Util.hashCode(this.transitionOptions, r1);
        int r3 = Util.hashCode(this.model, r2);
        int r4 = Util.hashCode(this.requestListeners, r3);
        int r5 = Util.hashCode(this.thumbnailBuilder, r4);
        int r6 = Util.hashCode(this.errorBuilder, r5);
        int r7 = Util.hashCode(this.thumbSizeMultiplier, r6);
        int r8 = Util.hashCode(this.isDefaultTransitionOptionsSet, r7);
        return Util.hashCode(this.isModelSet, r8);
    }
}
