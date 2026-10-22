package tmsdk.fg.module.spacemanager;

import android.text.TextUtils;
import tmsdk.common.OfflineVideo;
import tmsdk.common.tcc.QFile;

/* JADX INFO: loaded from: classes5.dex */
public class FileMedia extends FileInfo {
    public String album;
    public String artist;
    public OfflineVideo mOfflineVideo;
    public String[] mPlayers;
    public String pkg;
    public String title;

    public FileMedia() {
    }

    @Override // tmsdk.fg.module.spacemanager.FileInfo
    public boolean delFile() {
        boolean r0 = super.delFile();
        OfflineVideo r1 = this.mOfflineVideo;
        if (r1 != null) goto L5;
        return r0;
    L5:
        if (TextUtils.isEmpty(r1.mPath) == false) goto L7;
        return false;
    L7:
        QFile r2 = new QFile(this.mOfflineVideo.mPath);
        if (r0 == false) goto L10;
    L13:
        return true;
    L10:
        if (r2.deleteSelf() == true) goto L13;
        return false;
    }
}
