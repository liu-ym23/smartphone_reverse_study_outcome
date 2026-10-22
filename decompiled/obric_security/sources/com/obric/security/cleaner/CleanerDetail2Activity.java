package com.obric.security.cleaner;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedanceos.cleaner.CleanerActivity;
import com.bytedanceos.cloud.PreferenceMgr;
import com.bytedanceos.security.BaseActivity;
import com.obric.security.R;
import com.obric.security.cleaner.cacheFragment.ApkFragment;
import com.obric.security.cleaner.cacheFragment.SoftCacheFragment;
import com.obric.security.cleaner.cacheFragment.SystemRubbishFragment;
import com.obric.security.cleaner.cacheFragment.UninstallRetailFragment;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CleanerDetail2Activity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0012\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0011\u001a\u00020\fH\u0014R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/security/cleaner/CleanerDetail2Activity;", "Lcom/bytedanceos/security/BaseActivity;", "()V", "mPreferenceMgr", "Lcom/bytedanceos/cloud/PreferenceMgr;", "getMPreferenceMgr", "()Lcom/bytedanceos/cloud/PreferenceMgr;", "setMPreferenceMgr", "(Lcom/bytedanceos/cloud/PreferenceMgr;)V", "viewModel", "Lcom/obric/security/cleaner/CleanerDetailViewModel;", "initFragment", "", "initObserve", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public class CleanerDetail2Activity extends BaseActivity {
    private HashMap _$_findViewCache;
    private PreferenceMgr mPreferenceMgr;
    private CleanerDetailViewModel viewModel;

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

    public CleanerDetail2Activity() {
    }

    public static final /* synthetic */ void access$initFragment(CleanerDetail2Activity r0) {
        r0.initFragment();
    }

    public final PreferenceMgr getMPreferenceMgr() {
        return this.mPreferenceMgr;
    }

    public final void setMPreferenceMgr(PreferenceMgr r1) {
        this.mPreferenceMgr = r1;
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r3) {
        super.onCreate(r3);
        setContentView(R.layout.activity_cleaner_detail2);
        if ((this instanceof ViewModelStoreOwner) == true) goto L5;
        CleanerDetail2Activity r4 = null;
    L6:
        CleanerDetail2Activity r5 = r4;
        if (r5 == null) goto L9;
        this.viewModel = (CleanerDetailViewModel) new ViewModelProvider(r5).get(CleanerDetailViewModel.class);
    L9:
        this.mPreferenceMgr = PreferenceMgr.getInstance(this);
        String r6 = getIntent().getStringExtra("from");
        if (r6 != null) goto L12;
        r6 = "";
    L12:
        Intrinsics.checkNotNullExpressionValue(r6, "intent.getStringExtra(\"from\") ?: \"\"");
        initObserve();
        CleanerDetailViewModel r0 = this.viewModel;
        if (r0 == null) goto L20;
        CleanerDetail2Activity r1 = this;
        PreferenceMgr r2 = this.mPreferenceMgr;
        if (r2 == null) goto L17;
        boolean r7 = r2.isAllowed();
    L18:
        r0.popPermissionDialogIfNeeded(r1, r7, r6);
        return;
    L17:
        r7 = false;
        goto L18
    L20:
        return;
    L5:
        r4 = this;
        goto L6
    }

    private final void initObserve() {
        CleanerDetailViewModel r0 = this.viewModel;
        if (r0 == null) goto L8;
        MutableLiveData<Boolean> r1 = r0.getAgreeGrant();
        if (r1 == null) goto L9;
        r1.observe(this, new AnonymousClass1(this));
        return;
    L9:
        return;
    }

    private final void initFragment() {
        int r0 = getIntent().getIntExtra(CleanerActivity.TYPE, 0);
        FragmentManager r3 = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(r3, "supportFragmentManager");
        FragmentTransaction r4 = r3.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(r4, "fragmentManager.beginTransaction()");
        SystemRubbishFragment r1 = null;
        Fragment r2 = (Fragment) null;
        if (r0 != 0) goto L6;
        r1 = new SoftCacheFragment();
    L14:
        if (r1 == null) goto L17;
        r4.replace(R.id.fragment_container, r1);
        r4.commit();
        return;
    L17:
        return;
    L6:
        if (r0 != 4) goto L9;
        r1 = new UninstallRetailFragment();
        goto L14
    L9:
        if (r0 != 2) goto L12;
        r1 = new ApkFragment();
        goto L14
    L12:
        if (r0 != 1) goto L14;
        r1 = new SystemRubbishFragment();
        goto L14
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        CleanerDetailViewModel r0 = this.viewModel;
        if (r0 == null) goto L6;
        r0.removeCallBack();
        return;
    }
}
