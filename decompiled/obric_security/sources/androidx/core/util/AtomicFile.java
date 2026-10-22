package androidx.core.util;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class AtomicFile {
    private static final String LOG_TAG = "AtomicFile";
    private final File mBaseName;
    private final File mLegacyBackupName;
    private final File mNewName;

    public AtomicFile(File r4) {
        this.mBaseName = r4;
        this.mNewName = new File(r4.getPath() + ".new");
        this.mLegacyBackupName = new File(r4.getPath() + ".bak");
    }

    public File getBaseFile() {
        return this.mBaseName;
    }

    public void delete() {
        this.mBaseName.delete();
        this.mNewName.delete();
        this.mLegacyBackupName.delete();
    }

    public FileOutputStream startWrite() throws IOException {
        if (this.mLegacyBackupName.exists() == false) goto L16;
        rename(this.mLegacyBackupName, this.mBaseName);
    L16:
        return new FileOutputStream(this.mNewName);
    L8:
        if (this.mNewName.getParentFile().mkdirs() == false) goto L15;
        return new FileOutputStream(this.mNewName);
    L11:
        e = move-exception;
        throw new IOException("Failed to create new file " + this.mNewName, e);
    L15:
        throw new IOException("Failed to create directory for " + this.mNewName);
    }

    public void finishWrite(FileOutputStream r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (sync(r3) == true) goto L13;
        Log.e(LOG_TAG, "Failed to sync file output stream");
    L13:
        r3.close();     // Catch: IOException -> L9
    L11:
        rename(this.mNewName, this.mBaseName);
        return;
    L9:
        e = move-exception;
        Log.e(LOG_TAG, "Failed to close file output stream", e);
        goto L11
    }

    public void failWrite(FileOutputStream r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (sync(r3) == true) goto L15;
        Log.e(LOG_TAG, "Failed to sync file output stream");
    L15:
        r3.close();     // Catch: IOException -> L9
    L12:
        if (this.mNewName.delete() == true) goto L17;
        Log.e(LOG_TAG, "Failed to delete new file " + this.mNewName);
        return;
    L17:
        return;
    L9:
        e = move-exception;
        Log.e(LOG_TAG, "Failed to close file output stream", e);
        goto L12
    }

    public FileInputStream openRead() throws FileNotFoundException {
        if (this.mLegacyBackupName.exists() == false) goto L6;
        rename(this.mLegacyBackupName, this.mBaseName);
    L6:
        if (this.mNewName.exists() == false) goto L13;
        if (this.mBaseName.exists() == false) goto L13;
        if (this.mNewName.delete() == true) goto L13;
        Log.e(LOG_TAG, "Failed to delete outdated new file " + this.mNewName);
    L13:
        return new FileInputStream(this.mBaseName);
    }

    public byte[] readFully() throws IOException {
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

    private static boolean sync(FileOutputStream r0) {
        r0.getFD().sync();     // Catch: IOException -> L5
        return true;
    L5:
        return false;
    }

    private static void rename(File r3, File r4) {
        if (r4.isDirectory() == false) goto L8;
        if (r4.delete() == true) goto L8;
        Log.e(LOG_TAG, "Failed to delete file which is a directory " + r4);
    L8:
        if (r3.renameTo(r4) == true) goto L11;
        Log.e(LOG_TAG, "Failed to rename " + r3 + " to " + r4);
        return;
    }
}
