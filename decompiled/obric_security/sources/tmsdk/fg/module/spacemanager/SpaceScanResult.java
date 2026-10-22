package tmsdk.fg.module.spacemanager;

/* JADX INFO: loaded from: classes5.dex */
public class SpaceScanResult {
    public long mDbId;
    public int mHeight;
    public String mPath;
    public long mSize;
    public long mTime;
    public int mWidth;

    public SpaceScanResult(long r1, long r3, String r5, long r6, int r8, int r9) {
        this.mTime = r1;
        this.mSize = r3;
        this.mPath = r5;
        this.mDbId = r6;
        this.mHeight = r8;
        this.mWidth = r9;
    }
}
