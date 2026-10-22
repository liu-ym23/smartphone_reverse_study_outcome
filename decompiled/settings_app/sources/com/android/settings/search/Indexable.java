package com.android.settings.search;

import android.content.Context;
import android.provider.SearchIndexableResource;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface Indexable {

    public interface SearchIndexProvider {
        List<String> getNonIndexableKeys(Context r1);

        List<SearchIndexableRaw> getRawDataToIndex(Context r1, boolean r2);

        List<SearchIndexableResource> getXmlResourcesToIndex(Context r1, boolean r2);
    }
}
