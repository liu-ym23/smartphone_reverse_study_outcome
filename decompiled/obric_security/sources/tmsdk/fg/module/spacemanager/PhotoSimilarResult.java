package tmsdk.fg.module.spacemanager;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class PhotoSimilarResult {
    public ArrayList<PhotoSimilarBucketItem> mItemList;
    public long mTime;
    public String mTimeString;

    public static class PhotoSimilarBucketItem {
        public double mBlurValue;
        public long mFileSize;
        public int mHeight;
        public long mId;
        public String mPath;
        public boolean mSelected;
        public int mWidth;

        public PhotoSimilarBucketItem() {
        }
    }

    public PhotoSimilarResult() {
    }
}
