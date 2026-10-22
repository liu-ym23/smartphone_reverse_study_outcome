package tmsdkobf;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import tmsdk.fg.creator.BaseManagerF;
import tmsdk.fg.module.spacemanager.FileScanSizeRange;
import tmsdk.fg.module.spacemanager.ISpaceScanListener;
import tmsdk.fg.module.spacemanager.PhotoScanResult;
import tmsdk.fg.module.spacemanager.PhotoSimilarResult;
import tmsdk.fg.module.spacemanager.SpaceScanResult;

/* JADX INFO: loaded from: classes5.dex */
public class le extends BaseManagerF {
    private final String b;
    l0 c;
    private na d;

    public le() {
        this.b = "SpaceManager";
        this.d = na.e();
    }

    public static ArrayList a(List r13) {
        ArrayList r0 = new ArrayList();
        int r1 = r13.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        PhotoScanResult.PhotoItem r3 = (PhotoScanResult.PhotoItem) r13.get(r2);
        r0.add(new d9(r3.mTime, r3.mSize, r3.mPath, r3.mDbId));
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    public static List b(List r11) {
        ArrayList r0 = new ArrayList();
        int r1 = r11.size();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L8;
        w7 r4 = (w7) r11.get(r3);
        PhotoSimilarResult r5 = new PhotoSimilarResult();
        r5.mItemList = new ArrayList();
        r5.mTime = r4.f597a;
        r5.mTimeString = r4.b;
        int r6 = r4.c.size();
        int r7 = 0;
    L5:
        if (r7 >= r6) goto L7;
        PhotoSimilarResult.PhotoSimilarBucketItem r8 = new PhotoSimilarResult.PhotoSimilarBucketItem();
        r8.mId = ((w7.a) r4.c.get(r7)).g;
        r8.mPath = ((w7.a) r4.c.get(r7)).c;
        r8.mFileSize = ((w7.a) r4.c.get(r7)).b;
        r8.mSelected = ((w7.a) r4.c.get(r7)).h;
        r8.mHeight = ((w7.a) r4.c.get(r7)).j;
        r8.mWidth = ((w7.a) r4.c.get(r7)).k;
        r5.mItemList.add(r8);
        r7 = r7 + 1;
        goto L5
    L7:
        r0.add(r5);
        r3 = r3 + 1;
        goto L3
    L8:
        return r0;
    }

    public static ArrayList c(List r15) {
        ArrayList r0 = new ArrayList();
        int r1 = r15.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        PhotoScanResult.PhotoItem r3 = (PhotoScanResult.PhotoItem) r15.get(r2);
        r0.add(new SpaceScanResult(r3.mTime, r3.mSize, r3.mPath, r3.mDbId, r3.mHeight, r3.mWidth));
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    public long compressPhoto(String r3) {
        f.e(1310028);
        long r2 = this.d.a(r3);
        if (r2 >= 0) goto L5;
        f.a(1310029, "" + r2);
    L5:
        return r2;
    }

    public void d() {
        l0 r0 = this.c;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    public double detectBlur(String r2) {
        f.e(1310032);
        if (TextUtils.isEmpty(r2) == false) goto L7;
        f.a(1310033, "-51");
        return -51.0d;
    L7:
        if (new File(r2).exists() == true) goto L11;
        f.a(1310033, "-59");
        return -59.0d;
    L11:
        return new q0().a(r2);
    }

    @Override // tmsdkobf.b0
    public void onCreate(Context r1) {
    }

    public void onDestory() {
        l0 r0 = this.c;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    public int photoBlurCategorise(List r2, double r3, int r5, ISpaceScanListener r6) {
        f.f(1310030);
        this.d.a(r6);
        return this.d.a(c(r2), r3, r5);
    }

    public int photoCompressCategorise(ISpaceScanListener r2, List r3) {
        f.f(1310026);
        this.d.b(r2);
        return this.d.a(c(r3));
    }

    public int photoSimilarCategorise(List r2, int r3, ISpaceScanListener r4) {
        f.f(1310036);
        this.d.d(r4);
        return this.d.a(a(r2), r3);
    }

    public int stopPhotoBlurCategorise() {
        return this.d.a();
    }

    public int stopPhotoCompressCategorise() {
        return this.d.b();
    }

    public int stopPhotoScan() {
        return this.d.c();
    }

    public int stopPhotoSimilarCategorise() {
        return this.d.d();
    }

    public static PhotoScanResult a(na.b r7) {
        PhotoScanResult r0 = new PhotoScanResult();
        r0.mInnerPicSize = r7.f368a;
        r0.mOutPicSize = r7.b;
        r0.mPhotoCountAndSize = new Pair(Integer.valueOf(((Integer) r7.f.first).intValue()), Long.valueOf(((Long) r7.f.second).longValue()));
        r0.mScreenShotCountAndSize = new Pair(Integer.valueOf(((Integer) r7.g.first).intValue()), Long.valueOf(((Long) r7.g.second).longValue()));
        r0.mResultList = new ArrayList();
        int r1 = r7.e.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        d9 r3 = (d9) r7.e.get(r2);
        PhotoScanResult.PhotoItem r4 = new PhotoScanResult.PhotoItem();
        r4.mDbId = r3.g;
        r4.mIsOut = r3.d;
        r4.mIsScreenShot = r3.e;
        r4.mPath = r3.c;
        r4.mSize = r3.b;
        r4.mTime = r3.f149a;
        r0.mResultList.add(r4);
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    public void b() {
        na r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.c(null);
        this.d.d(null);
        this.d.b(null);
        this.d.a(null);
    }

    public void c() {
        na r0 = this.d;
        if (r0 == null) goto L6;
        r0.f();
        return;
    }

    public long compressPhoto(String r3, int r4) {
        f.e(1310028);
        long r2 = this.d.a(r3, r4);
        if (r2 >= 0) goto L5;
        f.a(1310029, "" + r2);
    L5:
        return r2;
    }

    public int photoBlurCategorise(List r7, double r8, ISpaceScanListener r10) {
        return photoBlurCategorise(r7, r8, q0.e, r10);
    }

    public void a(int r1) {
        if (r1 != 0) goto L6;
        this.c = null;
        return;
    }

    public long compressPhoto(String r2, int r3, String r4) {
        f.e(1310028);
        long r1 = this.d.a(r2, r3, r4);
        if (r1 >= 0) goto L5;
        f.a(1310029, "" + r1);
    L5:
        return r1;
    }

    public int photoBlurCategorise(List r7, int r8, ISpaceScanListener r9) {
        return photoBlurCategorise(r7, q0.d, r8, r9);
    }

    public int a(ISpaceScanListener r7, List r8) {
        return photoBlurCategorise(r8, q0.d, q0.e, r7);
    }

    public int a(ISpaceScanListener r2, String[] r3) {
        this.d.c(r2);
        int r1 = this.d.b(r3);
        f.f(1310024);
        return r1;
    }

    public int a(ArrayList r2, Set r3, FileScanSizeRange r4, ISpaceScanListener r5) {
        if (this.c == null) goto L6;
        return -2;
    L6:
        l0 r0 = new l0(this);
        this.c = r0;
        if (r0.a(r2, r3, r4, r5) == false) goto L10;
        f.f(1310034);
        return 0;
    L10:
        return -4;
    }
}
