package com.bytedanceos.cleaner;

import com.bytedanceos.application.LabelEntry;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SMTRubbishEntity {
    private static final int ENTITY_TYPE_INDIVIDUAL = 0;
    private static final int ENTITY_TYPE_SUMMARY = 1;
    public static final int INDEX_APK = 2;
    public static final int INDEX_SOFTWARE_CACHE = 0;
    public static final int INDEX_SYSTEM_RUBBISH = 1;
    public static final int INDEX_UNINSTALL_RETAIL = 4;
    public static final int MODEL_TYPE_DELETED = 2;
    public static final int MODEL_TYPE_SELECTED = 1;
    public static final int MODEL_TYPE_UNSELECTED = 0;
    private String mAppName;
    public int mCount;
    private String mDescription;
    public LabelEntry mLabelEntry;
    private String mPackageName;
    private List<String> mPaths;
    private HashSet<String> mRubbishKeys;
    private int mRubbishType;
    public long mSelectedSize;
    private long mSize;
    private int mStatus;
    private boolean mSuggest;
    public SMTRubbishEntity mSummaryEntity;
    private long mTotalSize;
    public int mType;

    public boolean isSummary() {
        if (this.mType == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public void setSummary() {
        this.mType = 1;
    }

    public long getSize() {
        if (isSummary() == false) goto L7;
        return this.mTotalSize;
    L7:
        return this.mSize;
    }

    public void setSize(long size) {
        this.mSize = size;
    }

    public void addPath(String path) {
        if (this.mPaths.contains(path) == true) goto L6;
        this.mPaths.add(path);
        return;
    }

    public List<String> getPaths() {
        return this.mPaths;
    }

    public void addTotalSize(long size) {
        this.mTotalSize += size;
    }

    public void subTotalSize(long size) {
        this.mTotalSize -= size;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String toString() {
        return "SMTRubbishEntity{mType=" + this.mType + "mRubbishType=" + this.mRubbishType + "mPackageName=" + this.mPackageName + "mAppName=" + this.mAppName + "mDescription=" + this.mDescription + "mSize=" + this.mSize + "mStatus=" + this.mStatus + ", mSelectedSize=" + this.mSelectedSize + ", mCount=" + this.mCount + ", mLabelEntry=" + this.mLabelEntry + ", mTotalSize=" + this.mTotalSize + ", mPaths=" + this.mPaths + '}';
    }

    public String getAppName() {
        return this.mAppName;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public void setPackageName(String packageName) {
        this.mPackageName = packageName;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public boolean isSuggest() {
        return this.mSuggest;
    }

    public boolean setStatus(int status) {
        this.mStatus = status;
        return true;
    }

    public SMTRubbishEntity(int rubbishType, String rubbinKey, boolean suggest, long size, String appName, String packageName, String description) {
        this.mType = 0;
        this.mCount = 0;
        this.mPaths = new ArrayList();
        this.mRubbishType = rubbishType;
        HashSet<String> r2 = new HashSet();
        this.mRubbishKeys = r2;
        r2.add(rubbinKey);
        this.mSuggest = suggest;
        if (suggest == false) goto L5;
        this.mStatus = 1;
    L5:
        this.mSize = size;
        this.mAppName = appName;
        this.mPackageName = packageName;
        this.mDescription = description;
    }

    public SMTRubbishEntity() {
        this.mType = 0;
        this.mCount = 0;
        this.mPaths = new ArrayList();
    }

    public int getRubbishType() {
        return this.mRubbishType;
    }
}
