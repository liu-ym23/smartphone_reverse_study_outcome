package com.obric.oui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.obric.common.oea.style.scene.transition.TransitionAnimHelper;
import com.obric.common.oea.style.scene.transition.TransitionAnimStyle;
import com.obric.matrix.platform.sdk.ones.safecushion.SafeCushionConstant;
import com.obric.oui.window.permission.WebViewActivity;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SecurityWebViewActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014¨\u0006\t"}, d2 = {"Lcom/obric/oui/SecurityWebViewActivity;", "Lcom/obric/oui/window/permission/WebViewActivity;", "()V", SafeCushionConstant.FINISH_STATE, "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class SecurityWebViewActivity extends WebViewActivity {
    public static final Companion Companion = null;
    public static final String EXTRA_TITLE = "extra_title";
    public static final String EXTRA_URL = "extra_url";
    private HashMap _$_findViewCache;

    /* JADX INFO: compiled from: SecurityWebViewActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/oui/SecurityWebViewActivity$Companion;", "", "()V", "EXTRA_TITLE", "", "EXTRA_URL", "open", "", "context", "Landroid/content/Context;", "url", "title", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final void open(Context r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intent r1 = new Intent(r2, SecurityWebViewActivity.class);
            r1.putExtra(SecurityWebViewActivity.EXTRA_URL, r3);
            r1.putExtra(SecurityWebViewActivity.EXTRA_TITLE, r4);
            r2.startActivity(r1);
        }
    }

    static {
        Companion = new Companion(null);
    }

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

    public SecurityWebViewActivity() {
    }

    @Override // com.obric.oui.window.permission.WebViewActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        TransitionAnimHelper.overrideExitAnim(this, TransitionAnimStyle.Standard);
    }
}
