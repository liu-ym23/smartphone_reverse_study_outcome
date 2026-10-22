package com.android.settingslib.suggestions;

import android.content.Context;
import android.service.settings.suggestions.Suggestion;
import com.GlobalProxyLancet;
import com.android.settingslib.utils.AsyncLoaderCompat;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SuggestionLoaderCompat extends AsyncLoaderCompat<List<Suggestion>> {
    public static final int LOADER_ID_SUGGESTIONS = 42;
    private static final String TAG = "SuggestionLoader";
    private final SuggestionController mSuggestionController;

    /* JADX INFO: renamed from: onDiscardResult, reason: avoid collision after fix types in other method */
    protected void onDiscardResult2(List<Suggestion> r1) {
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    public /* bridge */ /* synthetic */ Object loadInBackground() {
        return loadInBackground();
    }

    @Override // com.android.settingslib.utils.AsyncLoaderCompat
    protected /* bridge */ /* synthetic */ void onDiscardResult(List<Suggestion> r1) {
        onDiscardResult2(r1);
    }

    public SuggestionLoaderCompat(Context r1, SuggestionController r2) {
        super(r1);
        this.mSuggestionController = r2;
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    public List<Suggestion> loadInBackground() {
        List<Suggestion> r3 = this.mSuggestionController.getSuggestions();
        if (r3 != null) goto L5;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "data is null");
    L6:
        return r3;
    L5:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "data size " + r3.size());
        goto L6
    }
}
