package tmsdk.common;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class OfflineVideo implements Comparable<OfflineVideo> {
    public static final int PROGRESS_UNKNOWN = -1;
    public static final int STATUS_DL_UNCOMPLETED = 1;
    public static final int STATUS_READ_COMPLETED = 3;
    public static final int STATUS_READ_UNCOMPLETED = 2;
    public static final int STATUS_UNKNOWN = 0;
    public String mAdapter;
    public String mAppName;
    public int mDownProgress;
    public String mPackage;
    public String mPath;
    public int mPlayProgress;
    public String[] mPlayers;
    public boolean mSelected;
    public long mSize;
    public boolean mThumbnailIsImage;
    public String mThumnbailPath;
    public String mTitle;

    public OfflineVideo() {
        this.mThumbnailIsImage = false;
        this.mSize = -1;
        this.mDownProgress = -1;
        this.mPlayProgress = -1;
        this.mSelected = false;
    }

    public static void dumpToFile(List<OfflineVideo> r1) {
        dumpToFile(r1, getOfflineDatabase());
    }

    public static String getOfflineDatabase() {
        return TMSDKContext.getApplicaionContext().getApplicationInfo().dataDir + "/databases/offlinevideo.db";
    }

    public static OfflineVideo readFrom(DataInputStream r3) throws IOException {
        OfflineVideo r0 = new OfflineVideo();
        r0.mPath = r3.readUTF();
        r0.mTitle = r3.readUTF();
        r0.mPackage = r3.readUTF();
        r0.mAppName = r3.readUTF();
        r0.mPlayers = r3.readUTF().split("&");
        r0.mThumnbailPath = r3.readUTF();
        r0.mSize = r3.readLong();
        r0.mDownProgress = r3.readInt();
        r0.mPlayProgress = r3.readInt();
        r0.mAdapter = r3.readUTF();
        return r0;
    }

    public static List<OfflineVideo> readOfflineVideos() {
        return readOfflineVideos(getOfflineDatabase());
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(OfflineVideo r1) {
        return compareTo2(r1);
    }

    public int getStatus() {
        int r0 = this.mDownProgress;
        if (r0 > 0) goto L5;
    L8:
        int r2 = this.mPlayProgress;
        if (r2 != (-1)) goto L13;
        return 0;
    L13:
        if (r2 <= 85) goto L15;
        return 3;
    L15:
        return 2;
    L5:
        if (r0 >= 95) goto L8;
        return 1;
    }

    public String getStatusDesc() {
        int r0 = this.mDownProgress;
        if (r0 != (-1)) goto L5;
    L8:
        int r3 = this.mPlayProgress;
        if (r3 != (-1)) goto L13;
        return null;
    L13:
        if (r3 <= 85) goto L15;
        return "已播完";
    L15:
        return "未看完";
    L5:
        if (r0 >= 95) goto L8;
        return "未下载完";
    }

    public void writeTo(DataOutputStream r7) throws IOException {
        String r0 = this.mPath;
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        r7.writeUTF(r0);
        String r2 = this.mTitle;
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        r7.writeUTF(r2);
        String r3 = this.mPackage;
        if (r3 != null) goto L11;
        r3 = "";
    L11:
        r7.writeUTF(r3);
        String r4 = this.mAppName;
        if (r4 != null) goto L14;
        r4 = "";
    L14:
        r7.writeUTF(r4);
        StringBuffer r5 = new StringBuffer();
        String[] r6 = this.mPlayers;
        if (r6 == null) goto L19;
        int r8 = r6.length;
        int r9 = 0;
    L17:
        if (r9 >= r8) goto L19;
        r5.append(r6[r9]);
        r5.append("&");
        r9 = r9 + 1;
    L19:
        r7.writeUTF(r5.toString());
        String r10 = this.mThumnbailPath;
        if (r10 != null) goto L22;
        r10 = "";
    L22:
        r7.writeUTF(r10);
        r7.writeLong(this.mSize);
        r7.writeInt(this.mDownProgress);
        r7.writeInt(this.mPlayProgress);
        String r11 = this.mAdapter;
        if (r11 == null) goto L26;
        r1 = r11;
    L26:
        r7.writeUTF(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.io.DataOutputStream] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r3v2, types: [tmsdk.common.OfflineVideo] */
    public static void dumpToFile(List<OfflineVideo> r4, String r5) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        ?? r1 = new DataOutputStream(r0);
        boolean r2 = true;
        if (r4 == null) goto L47;
        Iterator<OfflineVideo> r6 = r4.iterator();
    L6:
        if (r6.hasNext() == false) goto L47;
        r6.next().writeTo(r1);     // Catch: IOException -> L10
    L12:
        if (r2 == true) goto L6;
    L10:
        e = move-exception;
        e.printStackTrace();
        r2 = false;
    L47:
        r1.flush();     // Catch: Exception -> L15
    L17:
        if (r2 == true) goto L43;
        return;
    L43:
        FileOutputStream r3 = new FileOutputStream(r5);     // Catch: Throwable -> L26 Exception -> L28
        r3.write(r0.toByteArray());     // Catch: Throwable -> L22 Exception -> L24
        r1 = r3;
    L51:
        r1.close();     // Catch: Exception -> L34
    L60:
        return;
    L34:
        e = move-exception;
        e.printStackTrace();
        return;
    L24:
        Exception e = e;
    L30:
        e.printStackTrace();     // Catch: Throwable -> L22
        r1 = r3;
        if (r3 != null) goto L51;
        return;
    L22:
        Throwable th = th;
    L36:
        if (r1 != 0) goto L45;
    L41:
        throw th;
    L45:
        r1.close();     // Catch: Exception -> L39
    L39:
        e = move-exception;
        e.printStackTrace();
    L28:
        e = move-exception;
        r3 = null;
        e = e;
    L26:
        th = move-exception;
        r1 = 0;
        th = th;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    public static List<OfflineVideo> readOfflineVideos(String r4) {
        FileInputStream r1 = new FileInputStream(r4);     // Catch: FileNotFoundException -> L5
    L7:
        if (r1 != null) goto L9;
        return null;
    L9:
        ArrayList r5 = new ArrayList();
        DataInputStream r2 = new DataInputStream(r1);
    L30:
        if (r2.available() <= 0) goto L28;
        OfflineVideo r3 = readFrom(r2);     // Catch: Exception -> L26
        if (r3 == null) goto L30;
        r5.add(r3);     // Catch: Exception -> L26
    L28:
        r2.close();     // Catch: Exception -> L27
    L32:
        r1.close();     // Catch: IOException -> L19
    L22:
        if (r5.size() != 0) goto L25;
        return null;
    L25:
        return r5;
    L19:
        e = move-exception;
        e.printStackTrace();
    L5:
        e = move-exception;
        e.printStackTrace();
        r1 = null;
        goto L7
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(OfflineVideo r3) {
        long r0 = this.mSize - r3.mSize;
        if (r0 <= 0) goto L6;
        return -1;
    L6:
        if (r0 != 0) goto L9;
        return 0;
    L9:
        return 1;
    }
}
