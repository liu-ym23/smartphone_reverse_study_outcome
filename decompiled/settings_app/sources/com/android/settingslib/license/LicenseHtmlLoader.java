package com.android.settingslib.license;

import android.content.Context;
import com.android.settingslib.utils.AsyncLoader;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class LicenseHtmlLoader extends AsyncLoader<File> {
    private static final String TAG = "LicenseHtmlLoader";
    private Context mContext;

    /* JADX INFO: renamed from: onDiscardResult, reason: avoid collision after fix types in other method */
    protected void onDiscardResult2(File r1) {
    }

    @Override // android.content.AsyncTaskLoader
    public /* bridge */ /* synthetic */ Object loadInBackground() {
        return loadInBackground();
    }

    @Override // com.android.settingslib.utils.AsyncLoader
    protected /* bridge */ /* synthetic */ void onDiscardResult(File r1) {
        onDiscardResult2(r1);
    }

    public LicenseHtmlLoader(Context r1) {
        super(r1);
        this.mContext = r1;
    }

    @Override // android.content.AsyncTaskLoader
    public File loadInBackground() {
        return new LicenseHtmlLoaderCompat(this.mContext).loadInBackground();
    }
}
