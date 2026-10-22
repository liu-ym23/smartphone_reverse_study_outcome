package com.android.settings;

import android.content.Context;
import com.android.settingslib.utils.AsyncLoaderCompat;
import com.obric.olog.OLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class LicenseHtmlLoaderCompat extends AsyncLoaderCompat<File> {
    static final String[] DEFAULT_LICENSE_XML_PATHS = null;
    static final String NOTICE_HTML_FILE_NAME = "NOTICE.html";
    private static final String TAG = "LicenseHtmlLoaderCompat";
    private final Context mContext;

    /* JADX INFO: renamed from: onDiscardResult, reason: avoid collision after fix types in other method */
    protected void onDiscardResult2(File r1) {
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    public /* bridge */ /* synthetic */ Object loadInBackground() {
        return loadInBackground();
    }

    @Override // com.android.settingslib.utils.AsyncLoaderCompat
    protected /* bridge */ /* synthetic */ void onDiscardResult(File r1) {
        onDiscardResult2(r1);
    }

    static {
        DEFAULT_LICENSE_XML_PATHS = new String[]{"/system/etc/NOTICE.xml.gz", "/vendor/etc/NOTICE.xml.gz", "/odm/etc/NOTICE.xml.gz", "/oem/etc/NOTICE.xml.gz", "/product/etc/NOTICE.xml.gz", "/system_ext/etc/NOTICE.xml.gz", "/vendor_dlkm/etc/NOTICE.xml.gz", "/odm_dlkm/etc/NOTICE.xml.gz", "/system_dlkm/etc/NOTICE.xml.gz"};
    }

    public LicenseHtmlLoaderCompat(Context r1) {
        super(r1);
        this.mContext = r1;
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    public File loadInBackground() {
        return generateHtmlFromDefaultXmlFiles();
    }

    private File generateHtmlFromDefaultXmlFiles() {
        List<File> r0 = getVaildXmlFiles();
        if (r0.isEmpty() == false) goto L6;
        OLog.e(TAG, "No notice file exists.");
        return null;
    L6:
        File r1 = getCachedHtmlFile(this.mContext);
        if (isCachedHtmlFileOutdated(r0, r1) == true) goto L9;
    L12:
        return r1;
    L9:
        if (generateHtmlFile(this.mContext, r0, r1) == true) goto L12;
        return null;
    }

    private List<File> getVaildXmlFiles() {
        ArrayList r9 = new ArrayList();
        String[] r0 = DEFAULT_LICENSE_XML_PATHS;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L10;
        File r4 = new File(r0[r2]);
        if (r4.exists() == false) goto L9;
        if (r4.length() == 0) goto L9;
        r9.add(r4);
    L9:
        r2 = r2 + 1;
        goto L3
    L10:
        return r9;
    }

    private File getCachedHtmlFile(Context r2) {
        return new File(r2.getCacheDir(), NOTICE_HTML_FILE_NAME);
    }

    private boolean isCachedHtmlFileOutdated(List<File> r6, File r7) {
        if (r7.exists() == true) goto L5;
        return true;
    L5:
        if (r7.length() == 0) goto L18;
        Iterator<File> r5 = r6.iterator();
    L8:
        if (r5.hasNext() == false) goto L12;
        File r8 = r5.next();
        if (r7.lastModified() >= r8.lastModified()) goto L8;
        return true;
    L12:
        return false;
    L18:
        return true;
    }

    private boolean generateHtmlFile(Context r1, List<File> r2, File r3) {
        return LicenseHtmlGeneratorFromXml.generateHtml(r2, r3, r1.getString(R.string.notice_header));
    }
}
