package com.android.settings.search;

import android.content.Context;
import android.provider.SearchIndexableResource;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class BaseSearchIndexProvider implements Indexable.SearchIndexProvider {
    private static final List<String> EMPTY_LIST = null;

    @Override // com.android.settings.search.Indexable.SearchIndexProvider
    public List<SearchIndexableRaw> getRawDataToIndex(Context r1, boolean r2) {
        return null;
    }

    @Override // com.android.settings.search.Indexable.SearchIndexProvider
    public List<SearchIndexableResource> getXmlResourcesToIndex(Context r1, boolean r2) {
        return null;
    }

    static {
        EMPTY_LIST = Collections.emptyList();
    }

    public BaseSearchIndexProvider() {
    }

    @Override // com.android.settings.search.Indexable.SearchIndexProvider
    public List<String> getNonIndexableKeys(Context r1) {
        return EMPTY_LIST;
    }
}
