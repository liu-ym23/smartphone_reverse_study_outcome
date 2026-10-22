package com.android.settings.biometrics.ocean.face;

import android.content.Context;
import android.os.CancellationSignal;
import android.os.UserHandle;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.android.internal.widget.LockscreenCredential;
import com.android.settings.fuelgauge.PowerUsageDetail;
import com.obric.matrix.platform.sdk.ones.account.AccountInfoBundleKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FaceEnrollMgr.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000{\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010%\u001a\u00020&H\u0002J\u001c\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020&0\u001dJ\u0010\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\bH\u0002J0\u0010-\u001a\u00020&2\u0006\u0010.\u001a\u00020/2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u00100\u001a\u0002012\u000e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001dJ\u0010\u00102\u001a\u00020&2\u0006\u00103\u001a\u000204H\u0002J\u0006\u00105\u001a\u00020&J\u0010\u00106\u001a\u00020&2\u0006\u00107\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u001f\u001a\u0010\u0012\f\u0012\n  *\u0004\u0018\u00010\n0\n0\u0011¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0013R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/android/settings/biometrics/ocean/face/FaceEnrollMgr;", "", "()V", "TAG", "", "cancellationSignal", "Landroid/os/CancellationSignal;", "enrollStep", "", "enrolling", "", "enrollmentCallback", "com/android/settings/biometrics/ocean/face/FaceEnrollMgr$enrollmentCallback$1", "Lcom/android/settings/biometrics/ocean/face/FaceEnrollMgr$enrollmentCallback$1;", "faceUpdater", "Lcom/android/settings/biometrics/ocean/face/FaceUpdater;", "hasEnrollingImageDataLv", "Landroidx/lifecycle/MutableLiveData;", "getHasEnrollingImageDataLv", "()Landroidx/lifecycle/MutableLiveData;", "helpTextLv", "getHelpTextLv", "progressLv", "getProgressLv", "progressTextLv", "Landroidx/lifecycle/LiveData;", "getProgressTextLv", "()Landroidx/lifecycle/LiveData;", "surfaceHolderGetter", "Lkotlin/Function0;", "Landroid/view/SurfaceHolder;", "timeoutLv", "kotlin.jvm.PlatformType", "getTimeoutLv", "token", "", AccountInfoBundleKey.USER_ID, "cancelEnroll", "", "generateToken", "password", "Lcom/android/internal/widget/LockscreenCredential;", "listener", "getProgressText", PowerUsageDetail.EXTRA_PERCENT, "init", "context", "Landroid/content/Context;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "startEnroll", "surface", "Landroid/view/Surface;", "tryStartEnroll", "updateHelpText", "text", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FaceEnrollMgr {
    private final String TAG;
    private CancellationSignal cancellationSignal;
    private int enrollStep;
    private boolean enrolling;
    private final FaceEnrollMgr$enrollmentCallback$1 enrollmentCallback;
    private FaceUpdater faceUpdater;
    private final MutableLiveData<Boolean> hasEnrollingImageDataLv;
    private final MutableLiveData<String> helpTextLv;
    private final MutableLiveData<Integer> progressLv;
    private final LiveData<String> progressTextLv;
    private Function0<? extends SurfaceHolder> surfaceHolderGetter;
    private final MutableLiveData<Boolean> timeoutLv;
    private byte[] token;
    private final int userId;

    /* JADX WARN: Type inference failed for: r0v1, types: [com.android.settings.biometrics.ocean.face.FaceEnrollMgr$enrollmentCallback$1] */
    public FaceEnrollMgr() {
        this.TAG = "FaceEnrollMgr";
        this.enrollmentCallback = new FaceEnrollMgr$enrollmentCallback$1(this);
        this.helpTextLv = new MutableLiveData("");
        MutableLiveData<Integer> r0 = new MutableLiveData(0);
        this.progressLv = r0;
        this.progressTextLv = Transformations.map(r0, new FaceEnrollMgr$progressTextLv$1(this));
        this.userId = UserHandle.myUserId();
        this.enrollStep = -1;
        this.timeoutLv = new MutableLiveData(false);
        this.hasEnrollingImageDataLv = new MutableLiveData(false);
    }

    public static final /* synthetic */ void access$cancelEnroll(FaceEnrollMgr r0) {
        r0.cancelEnroll();
    }

    public static final /* synthetic */ boolean access$getEnrolling$p(FaceEnrollMgr r0) {
        return r0.enrolling;
    }

    public static final /* synthetic */ String access$getProgressText(FaceEnrollMgr r0, int r1) {
        return r0.getProgressText(r1);
    }

    public static final /* synthetic */ Function0 access$getSurfaceHolderGetter$p(FaceEnrollMgr r0) {
        return r0.surfaceHolderGetter;
    }

    public static final /* synthetic */ String access$getTAG$p(FaceEnrollMgr r0) {
        return r0.TAG;
    }

    public static final /* synthetic */ void access$setEnrollStep$p(FaceEnrollMgr r0, int r1) {
        r0.enrollStep = r1;
    }

    public static final /* synthetic */ void access$setEnrolling$p(FaceEnrollMgr r0, boolean r1) {
        r0.enrolling = r1;
    }

    public static final /* synthetic */ void access$setToken$p(FaceEnrollMgr r0, byte[] r1) {
        r0.token = r1;
    }

    public static final /* synthetic */ void access$startEnroll(FaceEnrollMgr r0, Surface r1) {
        r0.startEnroll(r1);
    }

    public static final /* synthetic */ void access$updateHelpText(FaceEnrollMgr r0, String r1) {
        r0.updateHelpText(r1);
    }

    public final MutableLiveData<String> getHelpTextLv() {
        return this.helpTextLv;
    }

    public final MutableLiveData<Integer> getProgressLv() {
        return this.progressLv;
    }

    public final LiveData<String> getProgressTextLv() {
        return this.progressTextLv;
    }

    public final MutableLiveData<Boolean> getTimeoutLv() {
        return this.timeoutLv;
    }

    public final MutableLiveData<Boolean> getHasEnrollingImageDataLv() {
        return this.hasEnrollingImageDataLv;
    }

    public final void init(Context r2, byte[] r3, LifecycleOwner r4, Function0<? extends SurfaceHolder> r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r5, "surfaceHolderGetter");
        this.surfaceHolderGetter = r5;
        this.faceUpdater = new FaceUpdater(r2);
        this.token = r3;
        r4.getLifecycle().addObserver(new C01441(this));
        this.progressLv.observe(r4, new FaceEnrollMgr$sam$androidx_lifecycle_Observer$0(new AnonymousClass2(this)));
    }

    private final void startEnroll(Surface r12) {
        this.enrolling = true;
        this.cancellationSignal = new CancellationSignal();
        this.timeoutLv.postValue(false);
        this.progressLv.postValue(0);
        FaceUpdater r3 = this.faceUpdater;
        if (r3 == null) goto L6;
        r3.enroll(this.userId, this.token, this.cancellationSignal, this.enrollmentCallback, new int[0], r12, false);
        return;
    }

    private final void cancelEnroll() {
        if (this.enrolling == false) goto L9;
        CancellationSignal r0 = this.cancellationSignal;
        if (r0 == null) goto L7;
        r0.cancel();
    L7:
        this.enrolling = false;
        this.enrollStep = -1;
        return;
    }

    private final String getProgressText(int r1) {
        return new StringBuilder().append(r1).append('%').toString();
    }

    public final void tryStartEnroll() {
        Function0<? extends SurfaceHolder> r0 = this.surfaceHolderGetter;
        if (r0 == null) goto L5;
        SurfaceHolder r1 = r0.invoke();
    L7:
        if (this.enrolling == true) goto L11;
        if (r1 == null) goto L12;
        Surface r2 = r1.getSurface();
        Intrinsics.checkNotNullExpressionValue(r2, "getSurface(...)");
        startEnroll(r2);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r1 = null;
        goto L7
    }

    private final void updateHelpText(String r2) {
        if (Intrinsics.areEqual(r2, this.helpTextLv.getValue()) == true) goto L6;
        this.helpTextLv.postValue(r2);
        return;
    }

    public final void generateToken(LockscreenCredential r3, final Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "password");
        Intrinsics.checkNotNullParameter(r4, "listener");
        FaceUpdater r0 = this.faceUpdater;
        if (r0 == null) goto L6;
        r0.generateToken2(r3, new AnonymousClass1(this, r4));
        return;
    }
}
