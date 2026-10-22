package com.obric.security.cleaner.bigfile;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public class BigFileScanResultItem implements ItemCache {
    protected String absolutePath;
    protected String fileExtension;
    protected int fileType;
    protected Uri imageContentUri;
    private Drawable mDrawable;
    protected long mID;
    protected String mName;
    public String mPath;
    protected List<String> mPathes;
    protected long mSize;
    protected String mimeType;

    @Override // com.obric.security.cleaner.bigfile.ItemCache
    public String getNote() {
        return null;
    }

    @Override // com.obric.security.cleaner.bigfile.ItemCache
    public String getPackage() {
        return null;
    }

    @Override // com.obric.security.cleaner.bigfile.ItemCache
    public long getProcessedSize() {
        return 0;
    }

    @Override // com.obric.security.cleaner.bigfile.ItemCache
    public long getRemainSize() {
        return 0;
    }

    @Override // com.obric.security.cleaner.bigfile.ItemCache
    public void setProcessedSize(long processedSize) {
    }

    @Override // com.obric.security.cleaner.bigfile.ItemCache
    public void setRemainSize(long processedSize) {
    }

    public BigFileScanResultItem(int id, String path, long size) {
        ArrayList r0 = new ArrayList();
        this.mPathes = r0;
        this.fileType = 0;
        this.mID = id;
        this.mSize = size;
        r0.add(path);
        this.mName = getFileNameFromPath(path);
        this.mDrawable = null;
        this.mPath = path;
        this.absolutePath = FileUtils.removeStoragePrefix(path);
        this.mimeType = FileUtils.getMimeTypeFromSystem(this.mName);
        String r4 = FileUtils.getFileExtension(this.mName);
        this.fileExtension = r4;
        int r5 = FileUtils.getFileType(this.mimeType, r4);
        this.fileType = r5;
        if (r5 != 1) goto L6;
        this.imageContentUri = FileUtils.getImageContentUri(this.mName, FileUtils.getParentDirectory(this.absolutePath));
        return;
    }

    @Override // com.obric.security.cleaner.bigfile.ItemCache
    public String getName(Locale loccale) {
        return this.mName;
    }

    @Override // com.obric.security.cleaner.bigfile.ItemCache
    public long getID() {
        return this.mID;
    }

    @Override // com.obric.security.cleaner.bigfile.ItemCache
    public long getSize() {
        return this.mSize;
    }

    private String getFileNameFromPath(String path) {
        return new File(path).getName();
    }

    @Override // com.obric.security.cleaner.bigfile.ItemCache
    public List<String> getFilePath() {
        return this.mPathes;
    }

    @Override // com.obric.security.cleaner.bigfile.ItemCache
    public Drawable getIcon() {
        return this.mDrawable;
    }

    public boolean equals(Object o) {
        if (this != o) goto L5;
        return true;
    L5:
        if (o != null) goto L7;
        return false;
    L7:
        if (getClass() == o.getClass()) goto L10;
        return false;
    L10:
        return Objects.equals(this.mPath, ((BigFileScanResultItem) o).mPath);
    }

    public int hashCode() {
        return Objects.hashCode(this.mPath);
    }
}
