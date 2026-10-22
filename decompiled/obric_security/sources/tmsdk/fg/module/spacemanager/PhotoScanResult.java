package tmsdk.fg.module.spacemanager;

import android.util.Pair;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class PhotoScanResult {
    public long mInnerPicSize;
    public long mOutPicSize;
    public Pair<Integer, Long> mPhotoCountAndSize;
    public ArrayList<PhotoItem> mResultList;
    public Pair<Integer, Long> mScreenShotCountAndSize;

    public static class PhotoItem {
        public static int PHOTO_COMPRESS_STATUS_CAN_NOT = 0;
        public static int PHOTO_COMPRESS_STATUS_FINISH = 1;
        public static int PHOTO_COMPRESS_STATUS_NOT_START = 2;
        public int mCompressStatus;
        public long mDbId;
        public int mHeight;
        public boolean mIsOut;
        public boolean mIsScreenShot;
        public String mPath;
        public long mSize;
        public long mTime;
        public int mWidth;

        static {
        }

        public PhotoItem() {
            this.mPath = "";
            this.mIsOut = false;
            this.mIsScreenShot = false;
            this.mCompressStatus = PHOTO_COMPRESS_STATUS_CAN_NOT;
        }
    }

    public PhotoScanResult() {
        this.mResultList = new ArrayList();
    }
}
