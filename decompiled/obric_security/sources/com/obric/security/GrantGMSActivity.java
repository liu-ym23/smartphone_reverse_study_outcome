package com.obric.security;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GrantGMSActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J,\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0014J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0006H\u0014J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/security/GrantGMSActivity;", "Landroid/app/Activity;", "()V", "dialog", "Lcom/obric/oui/dialog/v2/alert/OAlertDialog;", "makeSystemBarsTransparent", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "parent", "name", "", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "onResume", "showAlertDialog", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class GrantGMSActivity extends Activity {
    private HashMap _$_findViewCache;
    private OAlertDialog dialog;

    public void _$_clearFindViewByIdCache() {
        HashMap r0 = this._$_findViewCache;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    public View _$_findCachedViewById(int r3) {
        if (this._$_findViewCache != null) goto L5;
        this._$_findViewCache = new HashMap();
    L5:
        View r0 = (View) this._$_findViewCache.get(Integer.valueOf(r3));
        if (r0 != null) goto L9;
        View r1 = findViewById(r3);
        this._$_findViewCache.put(Integer.valueOf(r3), r1);
        return r1;
    L9:
        return r0;
    }

    public GrantGMSActivity() {
    }

    public static final /* synthetic */ OAlertDialog access$getDialog$p(GrantGMSActivity r0) {
        return r0.dialog;
    }

    public static final /* synthetic */ void access$setDialog$p(GrantGMSActivity r0, OAlertDialog r1) {
        r0.dialog = r1;
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View r2, String r3, Context r4, AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r3, "name");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "attrs");
        return super.onCreateView(r2, r3, r4, r5);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle r1) {
        super.onCreate(r1);
        makeSystemBarsTransparent();
        this.dialog = showAlertDialog(this);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent r2) {
        Intrinsics.checkNotNullParameter(r2, "intent");
        super.onNewIntent(r2);
        setIntent(r2);
        OAlertDialog r3 = this.dialog;
        if (r3 != null) goto L5;
    L6:
        OAlertDialog r4 = this.dialog;
        if (r4 == null) goto L9;
        r4.dismiss();
    L9:
        this.dialog = showAlertDialog(this);
        return;
    L5:
        if (r3.isShowing() != true) goto L6;
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        OAlertDialog r0 = this.dialog;
        if (r0 != null) goto L5;
    L6:
        OAlertDialog r1 = this.dialog;
        if (r1 == null) goto L9;
        r1.dismiss();
    L9:
        this.dialog = showAlertDialog(this);
        return;
    L5:
        if (r0.isShowing() != true) goto L6;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        OAlertDialog r0 = this.dialog;
        if (r0 == null) goto L5;
        r0.dismiss();
    L5:
        OAlertDialog r1 = (OAlertDialog) null;
        this.dialog = null;
        super.onDestroy();
    }

    private final OAlertDialog showAlertDialog(Context r5) {
        OAlertDialog r4 = OAlertDialogBuilder.title$default(new OAlertDialogBuilder(r5), getString(R.string.enable_gms_dialog_title), false, 2, null).message(getString(R.string.enable_gms_dialog_message)).overrideButtonStyleController(GrantGMSActivity$showAlertDialog$builder$1.INSTANCE).horizontalButton(true).positiveButton(R.string.go_to_enable, new GrantGMSActivity$showAlertDialog$builder$2(this)).negativeButton(R.string.cancel, new GrantGMSActivity$showAlertDialog$builder$3(this)).build();
        r4.show();
        return r4;
    }

    private final void makeSystemBarsTransparent() {
        getWindow().addFlags(Integer.MIN_VALUE);
        Window r0 = getWindow();
        Intrinsics.checkNotNullExpressionValue(r0, "window");
        r0.setStatusBarColor(0);
        Window r1 = getWindow();
        Intrinsics.checkNotNullExpressionValue(r1, "window");
        r1.setNavigationBarColor(0);
        Window r2 = getWindow();
        Intrinsics.checkNotNullExpressionValue(r2, "window");
        View r3 = r2.getDecorView();
        Intrinsics.checkNotNullExpressionValue(r3, "window.decorView");
        r3.setSystemUiVisibility(1792);
        Window r4 = getWindow();
        Intrinsics.checkNotNullExpressionValue(r4, "window");
        WindowInsetsController r5 = r4.getInsetsController();
        if (r5 == null) goto L6;
        r5.setSystemBarsBehavior(2);
        return;
    }
}
