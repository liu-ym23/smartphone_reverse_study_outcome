package androidx.core.util;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class AtomicFile {
    private final File mBackupName;
    private final File mBaseName;

    public AtomicFile(@NonNull File r3) {
        this.mBaseName = r3;
        this.mBackupName = new File(r3.getPath() + ".bak");
    }

    private static boolean sync(@NonNull FileOutputStream r0) {
        r0.getFD().sync();     // Catch: IOException -> L5
        return true;
    L5:
        return false;
    }

    public void delete() {
        this.mBaseName.delete();
        this.mBackupName.delete();
    }

    public void failWrite(@Nullable FileOutputStream r2) {
        if (r2 == null) goto L11;
        sync(r2);
        r2.close();     // Catch: IOException -> L6
        this.mBaseName.delete();     // Catch: IOException -> L6
        this.mBackupName.renameTo(this.mBaseName);     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        Log.w("AtomicFile", "failWrite: Got exception:", e);
        return;
    }

    public void finishWrite(@Nullable FileOutputStream r2) {
        if (r2 == null) goto L11;
        sync(r2);
        r2.close();     // Catch: IOException -> L6
        this.mBackupName.delete();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        Log.w("AtomicFile", "finishWrite: Got exception:", e);
        return;
    }

    @NonNull
    public File getBaseFile() {
        return this.mBaseName;
    }

    @NonNull
    public FileInputStream openRead() {
        if (this.mBackupName.exists() == false) goto L6;
        this.mBaseName.delete();
        this.mBackupName.renameTo(this.mBaseName);
    L6:
        return new FileInputStream(this.mBaseName);
    }

    @NonNull
    public byte[] readFully() {
        FileInputStream r5 = openRead();
        byte[] r0 = new byte[r5.available()];     // Catch: Throwable -> L13
        int r2 = 0;
    L4:
        int r3 = r5.read(r0, r2, r0.length - r2);     // Catch: Throwable -> L13
        if (r3 <= 0) goto L6;
        r2 = r2 + r3;
        int r4 = r5.available();     // Catch: Throwable -> L13
        if (r4 <= (r0.length - r2)) goto L4;
        byte[] r6 = new byte[r4 + r2];     // Catch: Throwable -> L13
        System.arraycopy(r0, 0, r6, 0, r2);     // Catch: Throwable -> L13
        r0 = r6;
        goto L4
    L6:
        r5.close();
        return r0;
    L13:
        th = move-exception;
        r5.close();
        throw th;
    }

    @NonNull
    public FileOutputStream startWrite() {
        if (this.mBaseName.exists() == true) goto L5;
    L20:
        return new FileOutputStream(this.mBaseName);
    L13:
        if (this.mBaseName.getParentFile().mkdirs() == false) goto L19;
        return new FileOutputStream(this.mBaseName);
    L17:
        throw new IOException("Couldn't create " + this.mBaseName);
    L19:
        throw new IOException("Couldn't create directory " + this.mBaseName);
    L5:
        if (this.mBackupName.exists() == false) goto L7;
        this.mBaseName.delete();
        goto L20
    L7:
        if (this.mBaseName.renameTo(this.mBackupName) == true) goto L20;
        Log.w("AtomicFile", "Couldn't rename file " + this.mBaseName + " to backup file " + this.mBackupName);
        goto L20
    }
}
