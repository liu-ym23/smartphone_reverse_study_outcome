package v3;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.bytedance.android.anniex.container.AnnieXContainer;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.behavior.j;
import com.lynx.tasm.m0;
import com.lynx.tasm.n0;
import com.lynx.tasm.o0;
import com.lynx.tasm.y;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.xml.transform.Transformer;
import kotlin.jvm.internal.Intrinsics;
import on.d;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnnieXContainer f22509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o0 f22510b;

    public b(AnnieXContainer r5, o0 r10) {
        Intrinsics.checkNotNullParameter(r5, "container");
        this.f22509a = r5;
        this.f22510b = r10;
    }

    @Override // com.lynx.tasm.o0, com.lynx.tasm.behavior.k
    public final void loadImage(Context r10, String r11, String r12, float r13, float r14, Transformer r15, j r16) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r16, "handler");
        o0 r5 = this.f22510b;
        if (r5 == null) goto L6;
        r5.loadImage(r10, r11, r12, r13, r14, r15, r16);
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onCallJSBFinished(Map r5) {
        super.onCallJSBFinished(r5);
        o0 r10 = this.f22510b;
        if (r10 == null) goto L6;
        r10.onCallJSBFinished(r5);
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onDataUpdated() {
        o0 r5 = this.f22510b;
        if (r5 == null) goto L6;
        r5.onDataUpdated();
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onDestroy() {
        o0 r5 = this.f22510b;
        if (r5 == null) goto L6;
        r5.onDestroy();
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onDynamicComponentPerfReady(HashMap r5) {
        super.onDynamicComponentPerfReady(r5);
        o0 r10 = this.f22510b;
        if (r10 == null) goto L6;
        r10.onDynamicComponentPerfReady(r5);
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onFirstLoadPerfReady(y r5) {
        o0 r10 = this.f22510b;
        if (r10 == null) goto L6;
        r10.onFirstLoadPerfReady(null);
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onFirstScreen() {
        o0 r5 = this.f22510b;
        if (r5 == null) goto L5;
        r5.onFirstScreen();
    L5:
        AnnieXContainer r10 = this.f22509a;
        View r11 = r10.getKitView();
        if ((r11 instanceof LynxView) == false) goto L8;
        LynxView r12 = (LynxView) r11;
    L9:
        if (r12 != null) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(r10.getViewType(), OpenPageMethod.APP_POPUP) == false) goto L14;
        r10.getAnnieXContainerModel$anniex_release();
    L14:
        if (Intrinsics.areEqual(r10.getViewType(), OpenPageMethod.APP_POPUP) == false) goto L18;
        r10.getAnnieXContainerModel$anniex_release();
        return;
    L18:
        return;
    L8:
        r12 = null;
        goto L9
    }

    @Override // com.lynx.tasm.o0
    public final void onFling(n0 r5) {
        super.onFling(r5);
        o0 r10 = this.f22510b;
        if (r10 == null) goto L6;
        r10.onFling(r5);
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onFlushFinish(m0 r5) {
        super.onFlushFinish(null);
        o0 r10 = this.f22510b;
        if (r10 == null) goto L6;
        r10.onFlushFinish(null);
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onJSBInvoked(Map r5) {
        super.onJSBInvoked(r5);
        o0 r10 = this.f22510b;
        if (r10 == null) goto L6;
        r10.onJSBInvoked(r5);
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onKeyEvent(KeyEvent r5, boolean r10) {
        super.onKeyEvent(r5, r10);
        o0 r11 = this.f22510b;
        if (r11 == null) goto L6;
        r11.onKeyEvent(r5, r10);
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onLoadFailed(String r5) {
        o0 r10 = this.f22510b;
        if (r10 == null) goto L6;
        r10.onLoadFailed(r5);
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onLoadSuccess() {
        o0 r5 = this.f22510b;
        if (r5 == null) goto L6;
        r5.onLoadSuccess();
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onLynxEvent(d r5) {
        super.onLynxEvent(r5);
        o0 r10 = this.f22510b;
        if (r10 == null) goto L6;
        r10.onLynxEvent(r5);
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onLynxViewAndJSRuntimeDestroy() {
        o0 r5 = this.f22510b;
        if (r5 == null) goto L6;
        r5.onLynxViewAndJSRuntimeDestroy();
        return;
    }

    @Override // com.lynx.tasm.o0, com.lynx.tasm.j
    public final void onModuleMethodInvoked(String r5, String r10, int r11) {
        o0 r12 = this.f22510b;
        if (r12 == null) goto L6;
        r12.onModuleMethodInvoked(r5, r10, r11);
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onPageStart(String r5) {
        o0 r10 = this.f22510b;
        if (r10 == null) goto L6;
        r10.onPageStart(r5);
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onPageUpdate() {
        o0 r5 = this.f22510b;
        if (r5 == null) goto L6;
        r5.onPageUpdate();
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onPiperInvoked(Map r5) {
        super.onPiperInvoked(r5);
        o0 r10 = this.f22510b;
        if (r10 == null) goto L6;
        r10.onPiperInvoked(r5);
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onReceivedError(String r5) {
        super.onReceivedError(r5);
        o0 r10 = this.f22510b;
        if (r10 == null) goto L6;
        r10.onReceivedError(r5);
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onReceivedJSError(LynxError r5) {
        super.onReceivedJSError(r5);
        o0 r10 = this.f22510b;
        if (r10 == null) goto L6;
        r10.onReceivedJSError(r5);
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onReceivedJavaError(LynxError r5) {
        super.onReceivedJavaError(r5);
        o0 r10 = this.f22510b;
        if (r10 == null) goto L6;
        r10.onReceivedJavaError(r5);
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onReceivedNativeError(LynxError r5) {
        super.onReceivedNativeError(r5);
        o0 r10 = this.f22510b;
        if (r10 == null) goto L6;
        r10.onReceivedNativeError(r5);
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onReportComponentInfo(Set r5) {
        o0 r10 = this.f22510b;
        if (r10 == null) goto L6;
        r10.onReportComponentInfo(r5);
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onRuntimeReady() {
        o0 r5 = this.f22510b;
        if (r5 == null) goto L6;
        r5.onRuntimeReady();
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onScrollStart(n0 r5) {
        o0 r10 = this.f22510b;
        if (r10 == null) goto L6;
        r10.onScrollStart(r5);
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onScrollStop(n0 r5) {
        o0 r10 = this.f22510b;
        if (r10 == null) goto L6;
        r10.onScrollStop(r5);
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onTimingSetup(Map r5) {
        o0 r10 = this.f22510b;
        if (r10 == null) goto L6;
        r10.onTimingSetup(r5);
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onTimingUpdate(Map r5, Map r10, String r11) {
        o0 r12 = this.f22510b;
        if (r12 == null) goto L6;
        r12.onTimingUpdate(r5, r10, r11);
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onUpdateDataWithoutChange() {
        o0 r5 = this.f22510b;
        if (r5 == null) goto L6;
        r5.onUpdateDataWithoutChange();
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onUpdatePerfReady(y r5) {
        o0 r10 = this.f22510b;
        if (r10 == null) goto L6;
        r10.onUpdatePerfReady(null);
        return;
    }

    @Override // com.lynx.tasm.o0, com.lynx.tasm.behavior.k
    public final String shouldRedirectImageUrl(String r5) {
        o0 r10 = this.f22510b;
        if (r10 == null) goto L7;
        r10.shouldRedirectImageUrl(r5);
        return null;
    L7:
        return null;
    }

    @Override // com.lynx.tasm.o0, com.lynx.tasm.j
    public final void onReceivedError(LynxError r5) {
        o0 r10 = this.f22510b;
        if (r10 == null) goto L6;
        r10.onReceivedError(r5);
        return;
    }
}
