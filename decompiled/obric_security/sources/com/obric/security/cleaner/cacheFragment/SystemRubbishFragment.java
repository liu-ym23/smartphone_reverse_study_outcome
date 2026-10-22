package com.obric.security.cleaner.cacheFragment;

import android.view.View;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.security.R;
import com.obric.security.cleaner.cacheFragment.adapter.RubbishBaseAdapter;
import com.obric.security.cleaner.cacheFragment.adapter.SystemCacheListAdapter;
import com.obric.security.monitor.PerformanceScenes;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: compiled from: SystemRubbishFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016¨\u0006\f"}, d2 = {"Lcom/obric/security/cleaner/cacheFragment/SystemRubbishFragment;", "Lcom/obric/security/cleaner/cacheFragment/RubbishBaseFragment;", "()V", "fpsScene", "", "getListAdapter", "Lcom/obric/security/cleaner/cacheFragment/adapter/RubbishBaseAdapter;", "getRubbishType", "", "initTitleBar", "", "scene", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class SystemRubbishFragment extends RubbishBaseFragment {
    private HashMap _$_findViewCache;

    @Override // com.obric.security.cleaner.cacheFragment.RubbishBaseFragment
    public void _$_clearFindViewByIdCache() {
        HashMap r0 = this._$_findViewCache;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    @Override // com.obric.security.cleaner.cacheFragment.RubbishBaseFragment
    public View _$_findCachedViewById(int r3) {
        if (this._$_findViewCache != null) goto L5;
        this._$_findViewCache = new HashMap();
    L5:
        View r0 = (View) this._$_findViewCache.get(Integer.valueOf(r3));
        if (r0 != null) goto L13;
        View r1 = getView();
        if (r1 != null) goto L11;
        return null;
    L11:
        View r2 = r1.findViewById(r3);
        this._$_findViewCache.put(Integer.valueOf(r3), r2);
        return r2;
    L13:
        return r0;
    }

    @Override // com.obric.security.cleaner.cacheFragment.RubbishBaseFragment
    public String fpsScene() {
        return PerformanceScenes.FPS_CLEANER_SYSTEM_RUBBISH_LIST;
    }

    @Override // com.obric.security.cleaner.cacheFragment.RubbishBaseFragment
    public int getRubbishType() {
        return 1;
    }

    @Override // com.obric.security.cleaner.cacheFragment.RubbishBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.obric.security.cleaner.cacheFragment.RubbishBaseFragment
    public String scene() {
        return "system_rubbish";
    }

    public SystemRubbishFragment() {
    }

    @Override // com.obric.security.cleaner.cacheFragment.RubbishBaseFragment
    public void initTitleBar() {
        super.initTitleBar();
        OFloatingTitleBar r0 = getTitleBar();
        if (r0 == null) goto L6;
        r0.setCenterTitle(getString(R.string.clear_sdk_trash_system));
        return;
    }

    @Override // com.obric.security.cleaner.cacheFragment.RubbishBaseFragment
    public RubbishBaseAdapter getListAdapter() {
        return new SystemCacheListAdapter();
    }
}
