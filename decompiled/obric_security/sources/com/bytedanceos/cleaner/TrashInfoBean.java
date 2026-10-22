package com.bytedanceos.cleaner;

/* JADX INFO: loaded from: classes2.dex */
public class TrashInfoBean {
    public static final int BOTTOM = 2;
    public static final int MIDDLE = 1;
    public static final int TOP = 0;
    public static final int WHOLE = 3;
    private int mCount;
    private String mDesc;
    private String mDescDetial;
    private String mPath;
    private long mSelectedSize;
    private int mShowTypeInAdapter;

    public TrashInfoBean() {
    }

    public int getShowTypeInAdapter() {
        return this.mShowTypeInAdapter;
    }

    public void setShowTypeInAdapter(int showTypeInAdapter) {
        this.mShowTypeInAdapter = showTypeInAdapter;
    }

    public String toString() {
        return super.toString();
    }

    public String getDescDetial() {
        return this.mDescDetial;
    }

    public void setDescDetial(String descDetial) {
        this.mDescDetial = descDetial;
    }

    public long getSelectedSize() {
        return this.mSelectedSize;
    }

    public void setSelectedSize(long selectedSize) {
        this.mSelectedSize = selectedSize;
    }

    public String getPath() {
        return this.mPath;
    }

    public void setPath(String path) {
        this.mPath = path;
    }

    public String getDesc() {
        return this.mDesc;
    }

    public void setDesc(String desc) {
        this.mDesc = desc;
    }

    public int getCount() {
        return this.mCount;
    }

    public void setCount(int count) {
        this.mCount = count;
    }
}
