package com.obric.safecheck.riskcontrol.observer;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bytedanceos.security.invokeHistory.InvokeHistoryActivity;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.safecheck.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import obric.view.WindowManagerHelper;

/* JADX INFO: compiled from: GxbAntiFraudAlertOverlay.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\fH\u0002J\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0010H\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/safecheck/riskcontrol/observer/GxbAntiFraudAlertOverlay;", "", "()V", "TAG", "", "dialog", "Lcom/obric/oui/dialog/v2/alert/OAlertDialog;", "mainHandler", "Landroid/os/Handler;", "overlayView", "Landroid/view/View;", "dismiss", "", "dismissInternal", InvokeHistoryActivity.PREF_SHOW, "context", "Landroid/content/Context;", "showInternal", "appContext", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class GxbAntiFraudAlertOverlay {
    public static final GxbAntiFraudAlertOverlay INSTANCE = null;
    private static final String TAG = "GxbAntiFraudOverlay";
    private static OAlertDialog dialog;
    private static final Handler mainHandler = null;
    private static View overlayView;

    static {
        INSTANCE = new GxbAntiFraudAlertOverlay();
        mainHandler = new Handler(Looper.getMainLooper());
    }

    private GxbAntiFraudAlertOverlay() {
    }

    public static final /* synthetic */ void access$dismissInternal(GxbAntiFraudAlertOverlay r0) {
        r0.dismissInternal();
    }

    public static final /* synthetic */ void access$showInternal(GxbAntiFraudAlertOverlay r0, Context r1) {
        r0.showInternal(r1);
    }

    public final void show(final Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        mainHandler.post(new RunnableC03171(r2));
    }

    public final void dismiss() {
        mainHandler.post(AnonymousClass1.INSTANCE);
    }

    private final void showInternal(Context r14) {
        OAlertDialog r0 = dialog;
        if (r0 != null) goto L5;
    L8:
        Object r1 = r14.getSystemService("window");
        if ((r1 instanceof WindowManager) == true) goto L11;
        r1 = null;
    L11:
        WindowManager r2 = (WindowManager) r1;
        if (r2 != null) goto L15;
        Log.e(TAG, "WindowManager is null");
        return;
    L15:
        WindowManager.LayoutParams r10 = new WindowManager.LayoutParams(-1, -1, WindowManagerHelper.LayoutParamsSmt.TYPE_APPLICATION_OVERLAY, 2, -3);
        r10.gravity = 17;
        r10.dimAmount = 0.4f;
        View r4 = new View(r14);
        r4.setOnClickListener(GxbAntiFraudAlertOverlay$showInternal$host$1$1.INSTANCE);
        r2.addView(r4, r10);     // Catch: Throwable -> L29
        overlayView = r4;     // Catch: Throwable -> L29
        ContextThemeWrapper r3 = new ContextThemeWrapper(r14, R.style.GxbAntiFraudDialogTheme);
        OAlertDialogBuilder r7 = OAlertDialogBuilder.title$default(new OAlertDialogBuilder(r3), r3.getString(R.string.gxb_anti_fraud_alert_title), false, 2, null).message(r3.getString(R.string.gxb_anti_fraud_alert_message)).overrideButtonStyleController(GxbAntiFraudAlertOverlay$showInternal$d$1.INSTANCE).horizontalButton(false);
        String r15 = r3.getString(R.string.gxb_anti_fraud_alert_known);
        Intrinsics.checkNotNullExpressionValue(r15, "themed.getString(R.strin…b_anti_fraud_alert_known)");
        OAlertDialog r16 = OAlertDialogBuilder.negativeButton$default(r7, r15, GxbAntiFraudAlertOverlay$showInternal$d$2.INSTANCE, null, 4, null).build();
        r16.setCancelable(false);
        r16.setCanceledOnTouchOutside(false);
        Window r5 = r16.getWindow();     // Catch: Throwable -> L22
        if (r5 == null) goto L32;
        r5.setType(WindowManagerHelper.LayoutParamsSmt.TYPE_APPLICATION_OVERLAY);     // Catch: Throwable -> L22
    L32:
        r16.show();     // Catch: Throwable -> L26
        dialog = r16;     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        Log.e(TAG, "dialog show failed", th);
        dismissInternal();
        return;
    L22:
        th = move-exception;
        Log.e(TAG, "set dialog window type failed", th);
    L29:
        th = move-exception;
        Log.e(TAG, "addView overlay host failed", th);
        return;
    L5:
        if (r0.isShowing() != true) goto L8;
        Log.d(TAG, "overlay already showing, skip");
    }

    private final void dismissInternal() {
        OAlertDialog r0 = dialog;     // Catch: Throwable -> L7
        if (r0 == null) goto L9;
        r0.dismiss();     // Catch: Throwable -> L7
    L9:
        Object r1 = null;
        OAlertDialog r2 = (OAlertDialog) null;
        dialog = null;
        View r3 = overlayView;
        View r4 = (View) null;
        overlayView = null;
        if (r3 == null) goto L26;
        Object r5 = r3.getContext().getSystemService("window");     // Catch: Throwable -> L19
        if ((r5 instanceof WindowManager) == false) goto L15;
        r1 = r5;
    L15:
        WindowManager r6 = (WindowManager) r1;     // Catch: Throwable -> L19
        if (r6 == null) goto L27;
        r6.removeViewImmediate(r3);     // Catch: Throwable -> L19
        return;
    L27:
        return;
    L19:
        th = move-exception;
        Log.e(TAG, "remove overlay host failed", th);
        return;
    L26:
        return;
    L7:
        th = move-exception;
        Log.e(TAG, "dialog dismiss failed", th);
        goto L9
    }
}
