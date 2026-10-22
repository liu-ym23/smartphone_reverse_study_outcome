package retrofit2.adapter.rxjava2;

import io.reactivex.BackpressureStrategy;
import java.lang.reflect.Type;
import mt.n;
import mt.z;
import retrofit2.Call;
import retrofit2.CallAdapter;

/* JADX INFO: loaded from: classes3.dex */
final class RxJava2CallAdapter<R> implements CallAdapter<R, Object> {
    private final boolean isAsync;
    private final boolean isBody;
    private final boolean isCompletable;
    private final boolean isFlowable;
    private final boolean isMaybe;
    private final boolean isResult;
    private final boolean isSingle;
    private final Type responseType;
    private final z scheduler;

    public RxJava2CallAdapter(Type r5, z r10, boolean r11, boolean r12, boolean r13, boolean r14, boolean r15, boolean r16, boolean r17) {
        this.responseType = r5;
        this.scheduler = r10;
        this.isAsync = r11;
        this.isResult = r12;
        this.isBody = r13;
        this.isFlowable = r14;
        this.isSingle = r15;
        this.isMaybe = r16;
        this.isCompletable = r17;
    }

    @Override // retrofit2.CallAdapter
    public Object adapt(Call<R> r5) {
        if (this.isAsync == false) goto L5;
        n r10 = new CallEnqueueObservable(r5);
    L7:
        if (this.isResult == false) goto L11;
        n r11 = new ResultObservable(r10);
    L9:
        r10 = r11;
    L13:
        z r12 = this.scheduler;
        if (r12 == null) goto L17;
        r10 = r10.subscribeOn(r12);
    L17:
        if (this.isFlowable == false) goto L21;
        return r10.toFlowable(BackpressureStrategy.LATEST);
    L21:
        if (this.isSingle == false) goto L25;
        return r10.singleOrError();
    L25:
        if (this.isMaybe == false) goto L29;
        return r10.singleElement();
    L29:
        if (this.isCompletable == true) goto L31;
        return r10;
    L31:
        return r10.ignoreElements();
    L11:
        if (this.isBody == false) goto L13;
        r11 = new BodyObservable(r10);
        goto L9
    L5:
        r10 = new CallExecuteObservable(r5);
        goto L7
    }

    @Override // retrofit2.CallAdapter
    public Type responseType() {
        return this.responseType;
    }
}
