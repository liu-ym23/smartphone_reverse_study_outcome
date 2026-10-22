package com.obric.security.mainpage;

import android.os.Bundle;
import android.view.View;
import com.bytedanceos.security.BaseActivity;
import com.obric.oui.image.OImageAppIcon;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.security.BuildConfig;
import com.obric.security.R;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: AboutPhoneManagerActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/obric/security/mainpage/AboutPhoneManagerActivity;", "Lcom/bytedanceos/security/BaseActivity;", "()V", "appicon", "Lcom/obric/oui/image/OImageAppIcon;", "mDebugSettingEntry", "Lcom/obric/oui/lisitem/OCardListItem;", "mPermissionNote", "mPermissionText", "mThirdPartySdkDir", "mTitleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "mVersion", "", "mtvVersion", "Lcom/obric/oui/text/OTextView;", "getMtvVersion", "()Lcom/obric/oui/text/OTextView;", "mtvVersion$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class AboutPhoneManagerActivity extends BaseActivity {
    private HashMap _$_findViewCache;
    private OImageAppIcon appicon;
    private OCardListItem mDebugSettingEntry;
    private OCardListItem mPermissionNote;
    private OCardListItem mPermissionText;
    private OCardListItem mThirdPartySdkDir;
    private OFloatingTitleBar mTitleBar;
    private String mVersion;
    private final Lazy mtvVersion$delegate;

    private final OTextView getMtvVersion() {
        return (OTextView) this.mtvVersion$delegate.getValue();
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

    public AboutPhoneManagerActivity() {
        this.mtvVersion$delegate = LazyKt.lazy(new AboutPhoneManagerActivity$mtvVersion$2(this));
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r7) {
        super.onCreate(r7);
        setContentView(R.layout.activity_about_phone_manager);
        this.mVersion = BuildConfig.VERSION_NAME;
        getMtvVersion().setText(getString(R.string.version_text, new Object[]{this.mVersion}));
        this.mTitleBar = (OFloatingTitleBar) findViewById(R.id.title_bar);
        initTitleBar(false, false);
        this.mPermissionText = (OCardListItem) findViewById(R.id.privacy_policy_text);
        this.mPermissionNote = (OCardListItem) findViewById(R.id.permission_note);
        this.mThirdPartySdkDir = (OCardListItem) findViewById(R.id.third_party_SDK_dir);
        this.mDebugSettingEntry = (OCardListItem) findViewById(R.id.debug_setting_entry);
        this.appicon = (OImageAppIcon) findViewById(R.id.iv_app_secure);
        OCardListItem r8 = this.mPermissionText;
        if (r8 == null) goto L5;
        OCardListItem.setCardPosition$default(r8, 1, false, 2, null);
        r8.setDefaultTailIcon(0);
        r8.showTailIcon(true);
        r8.setOnContentClickListener(new AboutPhoneManagerActivity$onCreate$$inlined$apply$lambda$1(this));
    L5:
        OCardListItem r9 = this.mPermissionNote;
        if (r9 == null) goto L8;
        OCardListItem.setCardPosition$default(r9, 2, false, 2, null);
        r9.setDefaultTailIcon(0);
        r9.showTailIcon(true);
        r9.setOnContentClickListener(new AboutPhoneManagerActivity$onCreate$$inlined$apply$lambda$2(this));
    L8:
        OCardListItem r10 = this.mThirdPartySdkDir;
        if (r10 == null) goto L11;
        OCardListItem.setCardPosition$default(r10, 3, false, 2, null);
        r10.setDefaultTailIcon(0);
        r10.showTailIcon(true);
        r10.setOnContentClickListener(new AboutPhoneManagerActivity$onCreate$$inlined$apply$lambda$3(this));
    L11:
        OCardListItem r11 = this.mDebugSettingEntry;
        if (r11 == null) goto L15;
        r11.setVisibility(8);
        OCardListItem.setCardPosition$default(r11, 3, false, 2, null);
        r11.setDefaultTailIcon(0);
        r11.showTailIcon(true);
        r11.setOnContentClickListener(new AboutPhoneManagerActivity$onCreate$$inlined$apply$lambda$4(this));
        return;
    }
}
