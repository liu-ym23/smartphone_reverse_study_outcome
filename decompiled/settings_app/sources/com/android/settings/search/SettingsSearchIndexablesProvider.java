package com.android.settings.search;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.provider.SearchIndexableResource;
import android.provider.SearchIndexablesContract;
import android.provider.SearchIndexablesProvider;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class SettingsSearchIndexablesProvider extends SearchIndexablesProvider {
    private static final String TAG = "SettingsSearchIndexablesProvider";

    public boolean onCreate() {
        return true;
    }

    public SettingsSearchIndexablesProvider() {
    }

    public Cursor queryXmlResources(String[] r5) {
        MatrixCursor r4 = new MatrixCursor(SearchIndexablesContract.INDEXABLES_XML_RES_COLUMNS);
        Iterator<SearchIndexableResource> r6 = SearchIndexableResources.values().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        SearchIndexableResource r0 = r6.next();
        r4.addRow(new Object[]{Integer.valueOf(r0.rank), Integer.valueOf(r0.xmlResId), r0.className, Integer.valueOf(r0.iconResId), null, null, null});
        goto L4
    L6:
        return r4;
    }

    public Cursor queryRawData(String[] r1) {
        return new MatrixCursor(SearchIndexablesContract.INDEXABLES_RAW_COLUMNS);
    }

    public Cursor queryNonIndexableKeys(String[] r1) {
        return new MatrixCursor(SearchIndexablesContract.NON_INDEXABLES_KEYS_COLUMNS);
    }
}
