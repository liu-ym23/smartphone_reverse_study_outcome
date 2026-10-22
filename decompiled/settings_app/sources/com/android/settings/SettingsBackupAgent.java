package com.android.settings;

import android.app.backup.BackupAgent;
import android.app.backup.BackupDataInput;
import android.app.backup.BackupDataOutput;
import android.app.backup.FullBackupDataOutput;
import android.os.ParcelFileDescriptor;
import com.android.settings.quickphrases.QuickPhrasesHelper;
import com.android.settings.textboom.db.OcrAppInfoHelper;
import com.obric.olog.OLog;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class SettingsBackupAgent extends BackupAgent {
    private static final String SHARED_PREFS_FILE = "/shared_prefs/com.android.settings_preferences.xml";
    private static final String TAG = "SettingsBackupAgent2";

    public SettingsBackupAgent() {
    }

    @Override // android.app.backup.BackupAgent
    public void onFullBackup(FullBackupDataOutput r4) throws IOException {
        OLog.d(TAG, "onFullBackup");
        backupDBFile(OcrAppInfoHelper.DB_NAME, r4);
        backupDBFile(OcrAppInfoHelper.DB_SHM, r4);
        backupDBFile(OcrAppInfoHelper.DB_WAL, r4);
        backupDBFile(QuickPhrasesHelper.DB_NAME, r4);
        backupDBFile(QuickPhrasesHelper.DB_SHM, r4);
        backupDBFile(QuickPhrasesHelper.DB_WAL, r4);
        backupFile(new File(getApplicationContext().getDataDir().getAbsolutePath() + SHARED_PREFS_FILE), r4);
    }

    @Override // android.app.backup.BackupAgent
    public void onRestoreFile(ParcelFileDescriptor r3, long r4, File r6, int r7, long r8, long r10) throws IOException {
        OLog.d(TAG, "onRestoreFile, destination = " + r6 + "; size = " + r4 + "; time = " + r10);
        super.onRestoreFile(r3, r4, r6, r7, r8, r10);
    }

    private void backupDBFile(String r5, FullBackupDataOutput r6) {
        File r0 = getDatabasePath(r5);
        if (r0 != null) goto L5;
    L7:
        OLog.d(TAG, "db file not exist: " + r5);
        return;
    L5:
        if (r0.exists() == false) goto L7;
        OLog.d(TAG, "start backup db file " + r5 + " path is: " + r0.getAbsolutePath());
        fullBackupFile(r0, r6);
    }

    private void backupFile(File r4, FullBackupDataOutput r5) {
        if (r4 != null) goto L5;
    L7:
        OLog.d(TAG, "file not exist: " + r4);
        return;
    L5:
        if (r4.exists() == false) goto L7;
        OLog.d(TAG, "start backup file :" + r4);
        fullBackupFile(r4, r5);
    }

    @Override // android.app.backup.BackupAgent
    public void onBackup(ParcelFileDescriptor r1, BackupDataOutput r2, ParcelFileDescriptor r3) throws IOException {
        OLog.d(TAG, "onBackup");
    }

    @Override // android.app.backup.BackupAgent
    public void onRestore(BackupDataInput r1, int r2, ParcelFileDescriptor r3) throws IOException {
        OLog.d(TAG, "onRestore");
    }

    @Override // android.app.backup.BackupAgent
    public void onRestoreFinished() {
        super.onRestoreFinished();
        Utils.sendIntentToAndroid(getApplicationContext());
        OLog.d(TAG, "onRestoreFinished");
    }
}
