package com.bytedanceos.security.debug;

import android.os.Bundle;
import android.view.View;
import com.bytedanceos.security.BaseActivity;
import com.obric.oui.lisitem.OListItemGeneral;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: compiled from: DebugSettingActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedanceos/security/debug/DebugSettingActivity;", "Lcom/bytedanceos/security/BaseActivity;", "()V", "clearThisIsVirusRiskEntry", "Lcom/obric/oui/lisitem/OListItemGeneral;", "injectThisIsVirusRiskEntry", "manageSettingsEntry", "riskAppListEntry", "testSafeCheckEntry", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class DebugSettingActivity extends BaseActivity {
    private HashMap _$_findViewCache;
    private OListItemGeneral clearThisIsVirusRiskEntry;
    private OListItemGeneral injectThisIsVirusRiskEntry;
    private OListItemGeneral manageSettingsEntry;
    private OListItemGeneral riskAppListEntry;
    private OListItemGeneral testSafeCheckEntry;

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

    public DebugSettingActivity() {
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        super.onCreate(r1);
        finish();
    }
}
