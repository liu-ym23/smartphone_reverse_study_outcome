package coil.intercept;

import coil.EventListener;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.request.NullRequestData;
import coil.size.Size;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.capabilitykit.common.Ext;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: RealInterceptorChain.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0006H\u0002J&\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0002J\u0019\u0010!\u001a\u00020\"2\u0006\u0010\t\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010#J\u0010\u0010$\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0019R\u0014\u0010\t\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"Lcoil/intercept/RealInterceptorChain;", "Lcoil/intercept/Interceptor$Chain;", "initialRequest", "Lcoil/request/ImageRequest;", "interceptors", "", "Lcoil/intercept/Interceptor;", "index", "", Ext.KEY_REQUEST, PerfConsts.PERF_DISK_FILE_SIZE, "Lcoil/size/Size;", "eventListener", "Lcoil/EventListener;", "isPlaceholderCached", "", "(Lcoil/request/ImageRequest;Ljava/util/List;ILcoil/request/ImageRequest;Lcoil/size/Size;Lcoil/EventListener;Z)V", "getEventListener", "()Lcoil/EventListener;", "getIndex", "()I", "getInitialRequest", "()Lcoil/request/ImageRequest;", "getInterceptors", "()Ljava/util/List;", "()Z", "getRequest", "getSize", "()Lcoil/size/Size;", "checkRequest", "", "interceptor", "copy", "proceed", "Lcoil/request/ImageResult;", "(Lcoil/request/ImageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withSize", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RealInterceptorChain implements Interceptor.Chain {
    private final EventListener eventListener;
    private final int index;
    private final ImageRequest initialRequest;
    private final List<Interceptor> interceptors;
    private final boolean isPlaceholderCached;
    private final ImageRequest request;
    private final Size size;

    /* JADX INFO: renamed from: coil.intercept.RealInterceptorChain$proceed$1, reason: invalid class name */
    /* JADX INFO: compiled from: RealInterceptorChain.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "coil.intercept.RealInterceptorChain", f = "RealInterceptorChain.kt", i = {0, 0}, l = {25}, m = "proceed", n = {"this", "interceptor"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ RealInterceptorChain this$0;

        AnonymousClass1(RealInterceptorChain r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.proceed(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RealInterceptorChain(ImageRequest r1, List<? extends Interceptor> r2, int r3, ImageRequest r4, Size r5, EventListener r6, boolean r7) {
        this.initialRequest = r1;
        this.interceptors = r2;
        this.index = r3;
        this.request = r4;
        this.size = r5;
        this.eventListener = r6;
        this.isPlaceholderCached = r7;
    }

    @Override // coil.intercept.Interceptor.Chain
    public /* bridge */ /* synthetic */ Interceptor.Chain withSize(Size r1) {
        return withSize(r1);
    }

    public final ImageRequest getInitialRequest() {
        return this.initialRequest;
    }

    public final List<Interceptor> getInterceptors() {
        return this.interceptors;
    }

    public final int getIndex() {
        return this.index;
    }

    @Override // coil.intercept.Interceptor.Chain
    public ImageRequest getRequest() {
        return this.request;
    }

    @Override // coil.intercept.Interceptor.Chain
    public Size getSize() {
        return this.size;
    }

    public final EventListener getEventListener() {
        return this.eventListener;
    }

    public final boolean isPlaceholderCached() {
        return this.isPlaceholderCached;
    }

    @Override // coil.intercept.Interceptor.Chain
    public RealInterceptorChain withSize(Size r7) {
        return copy$default(this, 0, null, r7, 3, null);
    }

    @Override // coil.intercept.Interceptor.Chain
    public Object proceed(ImageRequest r12, Continuation<? super ImageResult> r13) {
        if ((r13 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r13;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        Interceptor r11 = (Interceptor) r0.L$1;
        RealInterceptorChain r15 = (RealInterceptorChain) r0.L$0;
        ResultKt.throwOnFailure(r14);
        Interceptor r16 = r11;
        RealInterceptorChain this = r15;
        Object r17 = r14;
    L20:
        ImageResult r18 = (ImageResult) r17;
        this.checkRequest(r18.getRequest(), r16);
        return r18;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        int r19 = this.index;
        if (r19 <= 0) goto L17;
        checkRequest(r12, this.interceptors.get(r19 - 1));
    L17:
        r16 = this.interceptors.get(this.index);
        RealInterceptorChain r110 = copy$default(this, this.index + 1, r12, null, 4, null);
        r0.L$0 = this;
        r0.L$1 = r16;
        r0.label = 1;
        r17 = r16.intercept(r110, r0);
        if (r17 != r1) goto L20;
        return r1;
    L7:
        r0 = new AnonymousClass1(this, r13);
        goto L8
    }

    private final void checkRequest(ImageRequest r6, Interceptor r7) {
        boolean r2 = true;
        if (r6.getContext() != this.initialRequest.getContext()) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L38;
        if (r6.getData() == NullRequestData.INSTANCE) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == false) goto L36;
        if (r6.getTarget() != this.initialRequest.getTarget()) goto L16;
        boolean r3 = true;
    L17:
        if (r3 == false) goto L34;
        if (r6.getLifecycle() != this.initialRequest.getLifecycle()) goto L21;
        boolean r4 = true;
    L22:
        if (r4 == false) goto L32;
        if (r6.getSizeResolver() == this.initialRequest.getSizeResolver()) goto L27;
        r2 = false;
    L27:
        if (r2 == false) goto L30;
        return;
    L30:
        throw new IllegalStateException(("Interceptor '" + r7 + "' cannot modify the request's size resolver. Use `Interceptor.Chain.withSize` instead.").toString());
    L32:
        throw new IllegalStateException(("Interceptor '" + r7 + "' cannot modify the request's lifecycle.").toString());
    L21:
        r4 = false;
        goto L22
    L34:
        throw new IllegalStateException(("Interceptor '" + r7 + "' cannot modify the request's target.").toString());
    L16:
        r3 = false;
        goto L17
    L36:
        throw new IllegalStateException(("Interceptor '" + r7 + "' cannot set the request's data to null.").toString());
    L11:
        r1 = false;
        goto L12
    L38:
        throw new IllegalStateException(("Interceptor '" + r7 + "' cannot modify the request's context.").toString());
    L5:
        r0 = false;
        goto L7
    }

    static /* synthetic */ RealInterceptorChain copy$default(RealInterceptorChain r0, int r1, ImageRequest r2, Size r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.index;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.getRequest();
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.getSize();
    L12:
        return r0.copy(r1, r2, r3);
    }

    private final RealInterceptorChain copy(int r10, ImageRequest r11, Size r12) {
        return new RealInterceptorChain(this.initialRequest, this.interceptors, r10, r11, r12, this.eventListener, this.isPlaceholderCached);
    }
}
