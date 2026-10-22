package com.obric.security.cleaner.cacheFragment;

import android.view.View;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.security.R;
import com.obric.security.cleaner.CleanerDetailViewModel;
import com.obric.security.cleaner.RubbishEntityWrapper;
import com.obric.security.cleaner.cacheFragment.adapter.RubbishBaseAdapter;
import com.obric.security.cleaner.cacheFragment.adapter.SoftCacheListAdapter;
import com.obric.security.cleaner.trashclear.TcTrashClearHelper;
import com.obric.security.monitor.PerformanceScenes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import tmsdk.fg.module.cleanV2.RubbishEntity;

/* JADX INFO: compiled from: SoftCacheFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016¨\u0006\u0010"}, d2 = {"Lcom/obric/security/cleaner/cacheFragment/SoftCacheFragment;", "Lcom/obric/security/cleaner/cacheFragment/RubbishBaseFragment;", "()V", "fpsScene", "", "getListAdapter", "Lcom/obric/security/cleaner/cacheFragment/adapter/RubbishBaseAdapter;", "getRubbishList", "", "Ltmsdk/fg/module/cleanV2/RubbishEntity;", "getRubbishType", "", "getSelectCount", "initTitleBar", "", "scene", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class SoftCacheFragment extends RubbishBaseFragment {
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
        return PerformanceScenes.FPS_CLEANER_SOFT_CACHE_LIST;
    }

    @Override // com.obric.security.cleaner.cacheFragment.RubbishBaseFragment
    public int getRubbishType() {
        return 0;
    }

    @Override // com.obric.security.cleaner.cacheFragment.RubbishBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.obric.security.cleaner.cacheFragment.RubbishBaseFragment
    public String scene() {
        return "soft_rubbish";
    }

    public SoftCacheFragment() {
    }

    @Override // com.obric.security.cleaner.cacheFragment.RubbishBaseFragment
    public void initTitleBar() {
        super.initTitleBar();
        OFloatingTitleBar r0 = getTitleBar();
        if (r0 == null) goto L6;
        r0.setCenterTitle(getString(R.string.scan_cache_trash_txt));
        return;
    }

    @Override // com.obric.security.cleaner.cacheFragment.RubbishBaseFragment
    public Collection<RubbishEntity> getRubbishList() {
        TcTrashClearHelper r0 = getTrashClearHelper();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getSoftCacheRubbish();
    }

    @Override // com.obric.security.cleaner.cacheFragment.RubbishBaseFragment
    public RubbishBaseAdapter getListAdapter() {
        return new SoftCacheListAdapter();
    }

    @Override // com.obric.security.cleaner.cacheFragment.RubbishBaseFragment
    public int getSelectCount() {
        RubbishBaseAdapter r0 = getAdapter();
        if ((r0 instanceof SoftCacheListAdapter) == true) goto L5;
        r0 = null;
    L5:
        SoftCacheListAdapter r1 = (SoftCacheListAdapter) r0;
        int r2 = 0;
        if (r1 == null) goto L17;
        ArrayList<RubbishEntityWrapper> r3 = r1.getWrappers();
        if (r3 == null) goto L17;
        Iterator<T> r4 = r3.iterator();
    L11:
        if (r4.hasNext() == false) goto L17;
        RubbishEntityWrapper r5 = (RubbishEntityWrapper) r4.next();
        CleanerDetailViewModel r6 = getViewModel();
        if (r6 == null) goto L11;
        if (r6.isSelected(r5.getEntity()) != true) goto L11;
        r2 = r2 + 1;
    L17:
        return r2;
    }
}
