package zj;

import com.bytedance.forest.model.Scene;
import com.bytedance.forest.model.t;
import com.bytedance.forest.model.w;
import com.bytedance.lynx.webview.TTWebSdk;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements com.bytedance.forest.interceptor.a {
    @Override // com.bytedance.forest.interceptor.a
    public final void c(w r13) {
        Intrinsics.checkNotNullParameter(r13, "response");
        if (r13.f4441q.isWebRequest() == true) goto L36;
        return;
    L36:
    L10:
        e = move-exception;
        int r14 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        AtomicBoolean r15 = b.f23451a;
        com.bytedance.ies.bullet.base.utils.logger.a.d("TTWebPredictor", "onLoadFinished and try ttweb preload but error with " + e.getMessage(), null, 12);
        return;
    L7:
        if (TTWebSdk.isTTWebView() == true) goto L12;
        com.bytedance.forest.interceptor.b.e(this);     // Catch: Exception -> L10
        int r12 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;     // Catch: Exception -> L10
        AtomicBoolean r16 = b.f23451a;     // Catch: Exception -> L10
        com.bytedance.ies.bullet.base.utils.logger.a.d("TTWebPredictor", "[PREDICTOR_DEBUG] ttwebview  not init or use sys webview, unregister ttWebInterceptor from forest", null, 12);     // Catch: Exception -> L10
        return;
    L12:
        boolean r10 = false;
        if (TTWebSdk.isFeatureSupport("predictor", 0) == true) goto L17;
        com.bytedance.forest.interceptor.b.e(this);     // Catch: Exception -> L10
        int r17 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;     // Catch: Exception -> L10
        AtomicBoolean r18 = b.f23451a;     // Catch: Exception -> L10
        com.bytedance.ies.bullet.base.utils.logger.a.d("TTWebPredictor", "[PREDICTOR_DEBUG] ttwebview not support predictor for version 0, unregister ttWebInterceptor from forest", null, 12);     // Catch: Exception -> L10
        return;
    L17:
        if (r13.f4441q.isPreload() == true) goto L19;
        return;
    L19:
        if (r13.f4442r == true) goto L21;
        return;
    L21:
        if (r13.f4449z == 0) goto L39;
        String r19 = r13.f4441q.getUrl();     // Catch: Exception -> L10
        byte[] r11 = r13.k();     // Catch: Exception -> L10
        if (r11 != null) goto L28;
        int r110 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;     // Catch: Exception -> L10
        AtomicBoolean r111 = b.f23451a;     // Catch: Exception -> L10
        com.bytedance.ies.bullet.base.utils.logger.a.d("TTWebPredictor", "[PREDICTOR_DEBUG] ttwebview preload failed for no bytes from preload response " + r19, null, 12);     // Catch: Exception -> L10
        return;
    L28:
        if (r13.f4441q.getScene() != Scene.f4351k) goto L31;
        r10 = true;
    L31:
        if (TTWebSdk.preloadResource(r19, r11, "{\"x-ttwebview-response-update-time\":\"" + r13.f4449z + "\",\"isMainResource\":" + r10 + '}') == true) goto L40;
        int r112 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;     // Catch: Exception -> L10
        AtomicBoolean r113 = b.f23451a;     // Catch: Exception -> L10
        com.bytedance.ies.bullet.base.utils.logger.a.d("TTWebPredictor", "[PREDICTOR_DEBUG] ttwebview preload failed for size: " + r11.length + ',' + r19, null, 12);     // Catch: Exception -> L10
        return;
    L40:
        return;
    }

    @Override // com.bytedance.forest.interceptor.a
    public final void d(String r5, t r10) {
        Intrinsics.checkNotNullParameter(r5, "url");
        Intrinsics.checkNotNullParameter(r10, "requestParams");
    }
}
