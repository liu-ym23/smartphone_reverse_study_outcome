package tmsdkobf;

import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.jpegenc.JpegEnc;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import tmsdk.common.TMSDKContext;
import tmsdk.fg.module.spacemanager.SpaceManager;
import tmsdk.fg.module.spacemanager.SpaceScanResult;

/* JADX INFO: loaded from: classes5.dex */
public class q2 {
    public static String d;
    private static final AtomicLong e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    p2 f429a;
    public long b;
    private AtomicBoolean c;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f430a;
        final /* synthetic */ q2 b;

        a(q2 r1, List r2) {
            this.b = r1;
            this.f430a = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList r0 = new ArrayList(this.f430a);
            HashSet r1 = new HashSet();
            Iterator r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L24;
            SpaceScanResult r3 = (SpaceScanResult) r2.next();
            if (TextUtils.isEmpty(r3.mPath) == true) goto L4;
            if (r3.mPath.endsWith("jpg") == true) goto L17;
            if (r3.mPath.endsWith("JPG") == true) goto L17;
            if (r3.mPath.endsWith("jpeg") == true) goto L17;
            if (r3.mPath.endsWith("JPEG") == false) goto L4;
        L17:
            if (r3.mPath.contains("comps.jpg") == true) goto L4;
        L23:
            return;
        L20:
            if ("cp".equals(new ExifInterface(r3.mPath).getAttribute(androidx.exifinterface.media.ExifInterface.TAG_USER_COMMENT)) == false) goto L4;
            r1.add(r3.mPath);     // Catch: Throwable -> L23
            goto L4
        L24:
            this.b.f429a.b();
            this.b.f429a.a(r1);
            m9.e().b(System.currentTimeMillis());
        }
    }

    static {
        e = new AtomicLong(0);
    }

    public q2() {
        this.f429a = new p2();
        this.b = 0;
        this.c = new AtomicBoolean();
    }

    private void a(List r3) {
        ve.f().a(new a(this, r3), "cacheCompressPhoto");
    }

    private boolean b() {
        if (Math.abs(System.currentTimeMillis() - m9.e().f()) < 604800000) goto L6;
        return true;
    L6:
        q8.a("CompressPhotoProcessor", "checkCacheInterval, false");
        return false;
    }

    private boolean c(String r7) {
        File r6 = new File(r7);
        if (r6.exists() == true) goto L5;
    L13:
        return false;
    L5:
        if (r6.length() <= 0) goto L13;
        BitmapFactory.Options r8 = new BitmapFactory.Options();
        r8.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r7, r8);
        if (r8.outWidth <= 0) goto L13;
        if (r8.outHeight <= 0) goto L13;
        return true;
    }

    private long[] b(List r5) {
        int r4 = r5.size();
        Iterator r6 = r5.iterator();
        long r0 = 0;
    L4:
        if (r6.hasNext() == false) goto L7;
        r0 = r0 + ((SpaceScanResult) r6.next()).mSize;
        goto L4
    L7:
        return new long[]{r4, r0};
    }

    public void a() {
        this.c.set(true);
    }

    private String b(String r3) {
        if (d != null) goto L8;
        StringBuilder r2 = new StringBuilder();
        r2.append(md.a(TMSDKContext.getApplicaionContext(), null).getAbsolutePath());
        String r4 = File.separator;
        r2.append(r4);
        r2.append("tencent");
        r2.append(r4);
        r2.append(TMSDKContext.getApplicaionContext().getPackageName());
        r2.append(r4);
        r2.append("compressTemp");
        r2.append(r4);
        d = r2.toString();
        File r5 = new File(d);
        if (r5.exists() == true) goto L8;
        r5.mkdirs();
    L8:
        return d + System.currentTimeMillis() + "_" + e.incrementAndGet() + ".compress.jpg";
    }

    public long a(String r2) {
        return a(r2, 50);
    }

    public long a(String r2, int r3) {
        return a(r2, r3, null);
    }

    public long a(String r12, int r13, String r14) {
        if (TextUtils.isEmpty(r12) == false) goto L6;
        return -51;
    L6:
        if (r13 > 0) goto L8;
        return -53;
    L8:
        if (r13 < 100) goto L11;
        return -53;
    L11:
        if (TextUtils.isEmpty(r14) == false) goto L13;
        r14 = b(r12);
    L13:
        long r5 = 0;
    L27:
        th = move-exception;
        q8.a("CompressPhotoProcessor", th);
    L29:
        return r5;
    L16:
        if (q8.a() == false) goto L19;
        File r7 = new File(r12);     // Catch: Throwable -> L27
        q8.a("CompressPhotoProcessor", "---------------------------------------------");     // Catch: Throwable -> L27
        q8.a("CompressPhotoProcessor", "compressPhoto, inPath=" + r12);     // Catch: Throwable -> L27
        q8.a("CompressPhotoProcessor", "compressPhoto, outPath=" + r14);     // Catch: Throwable -> L27
        q8.a("CompressPhotoProcessor", "compressPhoto, inSize=" + r7.length() + ", modifyTime=" + r7.lastModified());     // Catch: Throwable -> L27
    L19:
        if (JpegEnc.a(r12, r13, r14) == 0) goto L21;
    L25:
        new File(r14).delete();     // Catch: Throwable -> L27
        goto L29
    L21:
        if (c(r14) == false) goto L25;
        a(r14, new ExifInterface(r12));     // Catch: Throwable -> L27
        r5 = a(r12, r14);     // Catch: Throwable -> L27
        if (q8.a() == false) goto L29;
        File r11 = new File(r12);     // Catch: Throwable -> L27
        q8.a("CompressPhotoProcessor", "compressPhoto, outSize=" + r11.length() + ", modifyTime=" + r11.lastModified() + ", tempFile size=" + new File(r14).length());     // Catch: Throwable -> L27
        goto L29
    }

    private boolean a(SpaceScanResult r7) {
        File r6 = new File(r7.mPath);
        if (r6.exists() == true) goto L5;
    L14:
        return false;
    L5:
        if (r6.length() <= 0) goto L14;
        BitmapFactory.Options r8 = new BitmapFactory.Options();
        r8.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r7.mPath, r8);
        int r2 = r8.outWidth;
        if (r2 <= 0) goto L14;
        int r9 = r8.outHeight;
        if (r9 <= 0) goto L14;
        r7.mHeight = r9;
        r7.mWidth = r2;
        return true;
    }

    private long a(String r9, String r10) {
        File r8 = new File(r9);
        File r0 = new File(r10);
        long r1 = System.currentTimeMillis();
        long r3 = r8.lastModified();
        boolean r7 = false;
        if (r0.exists() == true) goto L21;
    L12:
        if (r7 == false) goto L14;
        r8.setLastModified(r3);
        long r11 = r8.length();
    L15:
        StringBuilder r12 = new StringBuilder("rename result=");
        if (r7 == false) goto L18;
        String r2 = "YES";
    L19:
        q8.a("CompressPhotoProcessor", r12.append(r2).append(", cost=").append(System.currentTimeMillis() - r1).toString());
        return r11;
    L18:
        r2 = "NO";
        goto L19
    L14:
        r11 = 0;
        goto L15
    L21:
        r1 = System.currentTimeMillis();     // Catch: Exception -> L8
        r7 = z4.a(r10, r9);     // Catch: Exception -> L8
        if (r7 == false) goto L12;
        u4.a(TMSDKContext.getApplicaionContext(), r10);     // Catch: Exception -> L8
    L8:
        r7 = r0.renameTo(r8);     // Catch: Exception -> L10
    L10:
        if (0 != 0) goto L12;
        q8.a("CompressPhotoProcessor", "rename error");
        goto L12
    }

    private void a(String r8, ExifInterface r9) {
        ExifInterface r5 = new ExifInterface(r8);     // Catch: Exception -> L23
        r5.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_USER_COMMENT, "cp");     // Catch: Exception -> L23
        String r10 = r9.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_DATETIME);     // Catch: Exception -> L23
        if (TextUtils.isEmpty(r10) == true) goto L6;
        r5.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_DATETIME, r10);     // Catch: Exception -> L23
    L6:
        String r11 = r9.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_GPS_LATITUDE);     // Catch: Exception -> L23
        if (TextUtils.isEmpty(r11) == true) goto L9;
        r5.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_GPS_LATITUDE, r11);     // Catch: Exception -> L23
    L9:
        String r12 = r9.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_GPS_LATITUDE_REF);     // Catch: Exception -> L23
        if (TextUtils.isEmpty(r12) == true) goto L12;
        r5.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_GPS_LATITUDE_REF, r12);     // Catch: Exception -> L23
    L12:
        String r13 = r9.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_GPS_LONGITUDE);     // Catch: Exception -> L23
        if (TextUtils.isEmpty(r13) == true) goto L15;
        r5.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_GPS_LONGITUDE, r13);     // Catch: Exception -> L23
    L15:
        String r14 = r9.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_GPS_LONGITUDE_REF);     // Catch: Exception -> L23
        if (TextUtils.isEmpty(r14) == true) goto L18;
        r5.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_GPS_LONGITUDE_REF, r14);     // Catch: Exception -> L23
    L18:
        String r15 = r9.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION);     // Catch: Exception -> L23
        if (TextUtils.isEmpty(r15) == true) goto L21;
        r5.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, r15);     // Catch: Exception -> L23
    L21:
        r5.saveAttributes();     // Catch: Exception -> L23
        return;
    L23:
        e = move-exception;
        q8.a("CompressPhotoProcessor", e);
    }

    public int a(List r18, Handler r19) {
        this.c.set(false);
        if (r18 != null) goto L5;
    L65:
        q8.b("CompressPhotoProcessor", "image list is null or empty");
        Message r0 = r19.obtainMessage(4869);
        r0.arg1 = -51;
        r0.obj = null;
        r19.sendMessage(r0);
        return -1;
    L5:
        if (r18.size() == 0) goto L65;
        if (this.c.get() == false) goto L12;
    L9:
        Message r1 = r19.obtainMessage(4868);
    L10:
        r19.sendMessage(r1);
        return SpaceManager.ERROR_CODE_CANCEL_SCAN;
    L12:
        int r9 = (int) b(r18)[0];
        if (this.f429a != null) goto L15;
        this.f429a = new p2();
    L15:
        HashSet r10 = this.f429a.c();
        ArrayList r11 = new ArrayList();
        int r12 = 0;
    L17:
        if (r12 >= r18.size()) goto L61;
        if (this.c.get() == true) goto L20;
        SpaceScanResult r2 = (SpaceScanResult) r18.get(r12);
        if (TextUtils.isEmpty(r2.mPath) == false) goto L26;
        String r3 = "compress path is empty or null";
    L24:
        q8.a("CompressPhotoProcessor", r3);
    L60:
        r12 = r12 + 1;
        goto L17
    L26:
        if (r2.mPath.contains("comps.jpg") == false) goto L29;
        r3 = "has compassed image";
        goto L24
    L29:
        if (r2.mPath.endsWith("jpg") == false) goto L31;
    L67:
        if (r10.contains(r2.mPath) == true) goto L54;
        long r13 = r2.mSize;     // Catch: Exception -> L51
        if (r13 <= 512000) goto L54;
        if (r13 >= 104857600) goto L54;
        this.b += r13;     // Catch: Exception -> L51
    L48:
        th = move-exception;
        th.printStackTrace();     // Catch: Exception -> L51
        goto L54
    L45:
        if ("cp".equals(new ExifInterface(r2.mPath).getAttribute(androidx.exifinterface.media.ExifInterface.TAG_USER_COMMENT)) == true) goto L54;
        a(r2);     // Catch: Throwable -> L48
        r11.add(r2);     // Catch: Throwable -> L48
    L54:
        if (r11.isEmpty() == true) goto L57;
        Message r4 = r19.obtainMessage(4866);
        r4.obj = r11;
        r19.sendMessage(r4);
    L57:
        if (this.c.get() == true) goto L9;
        Message r5 = r19.obtainMessage(4867);
        r5.arg1 = (r12 * 100) / r9;
        r19.sendMessage(r5);
    L51:
        e = move-exception;
        q8.a("CompressPhotoProcessor", e);
        goto L54
    L31:
        if (r2.mPath.endsWith("JPG") == true) goto L67;
        if (r2.mPath.endsWith("jpeg") == true) goto L67;
        if (r2.mPath.endsWith("JPEG") == false) goto L54;
    L20:
        q8.a("CompressPhotoProcessor", "scan is canceled");
        r1 = r19.obtainMessage(4612);
        goto L10
    L61:
        Message r6 = r19.obtainMessage(4869);
        r6.arg1 = 0;
        r6.obj = r11;
        r19.sendMessage(r6);
        if (b() == false) goto L64;
        a(r18);
    L64:
        return 0;
    }
}
