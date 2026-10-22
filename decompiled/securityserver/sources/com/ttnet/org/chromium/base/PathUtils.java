package com.ttnet.org.chromium.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.provider.MediaStore;
import android.system.Os;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.compat.ApiHelperForM;
import com.ttnet.org.chromium.base.compat.ApiHelperForQ;
import com.ttnet.org.chromium.base.compat.ApiHelperForR;
import com.ttnet.org.chromium.base.task.AsyncTask;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@MainDex
public abstract class PathUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int CACHE_DIRECTORY = 2;
    private static final int DATA_DIRECTORY = 0;
    private static final int NUM_DIRECTORIES = 3;
    private static final String TAG = "PathUtils";
    private static final int THUMBNAIL_DIRECTORY = 1;
    private static final String THUMBNAIL_DIRECTORY_NAME = "textures";
    private static String sCacheSubDirectory;
    private static String sDataDirectorySuffix;
    private static FutureTask<String[]> sDirPathFetchTask;
    private static final AtomicBoolean sInitializationStarted = null;

    static {
        sInitializationStarted = new AtomicBoolean();
    }

    private PathUtils() {
    }

    public static /* synthetic */ String[] a() {
        return setPrivateDataDirectorySuffixInternal();
    }

    @SuppressLint({"NewApi"})
    private static void chmod(String r1, int r2) {
        Os.chmod(r1, r2);     // Catch: Exception -> L4
        return;
    L4:
        Log.e(TAG, a.a.k("Failed to set permissions for path \"", r1, "\""), new Object[0]);
    }

    @NonNull
    @CalledByNative
    public static String[] getAllPrivateDownloadsDirectories() {
        List r0 = new ArrayList();
        StrictModeContext r1 = StrictModeContext.allowDiskWrites();
        File[] r2 = ContextUtils.getApplicationContext().getExternalFilesDirs(Environment.DIRECTORY_DOWNLOADS);     // Catch: Throwable -> L11
        if (r2 == null) goto L7;
        r0 = Arrays.asList(r2);     // Catch: Throwable -> L11
    L7:
        if (r1 == null) goto L10;
        r1.close();
    L10:
        return toAbsolutePathStrings(r0);
    L11:
        th = move-exception;
        if (r1 != null) goto L20;
    L17:
        throw th;
    L20:
        r1.close();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.addSuppressed(th);
        goto L17
    }

    @CalledByNative
    public static String getAppExternalCacheDirectory() {
        File r0 = ContextUtils.getApplicationContext().getExternalCacheDir();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0.getAbsolutePath();
    }

    @CalledByNative
    public static String getCacheDirectory() {
        return getDirectoryPath(2);
    }

    @CalledByNative
    public static String getDataDirectory() {
        return getDirectoryPath(0);
    }

    private static String getDirectoryPath(int r1) {
        return getOrComputeDirectoryPaths()[r1];
    }

    @NonNull
    @CalledByNative
    public static String getDownloadsDirectory() {
        StrictModeContext r0 = StrictModeContext.allowDiskReads();
        String[] r1 = getAllPrivateDownloadsDirectories();     // Catch: Throwable -> L6
        if (r1.length != 0) goto L8;
        String r2 = "";
    L9:
        if (r0 == null) goto L11;
        r0.close();
    L11:
        return r2;
    L8:
        r2 = r1[0];     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        if (r0 != null) goto L20;
    L17:
        throw th;
    L20:
        r0.close();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.addSuppressed(th);
        goto L17
    }

    @NonNull
    @RequiresApi(30)
    @CalledByNative
    public static String[] getExternalDownloadVolumesNames() {
        ArrayList r0 = new ArrayList();
        Iterator<String> r1 = ApiHelperForQ.getExternalVolumeNames(ContextUtils.getApplicationContext()).iterator();
    L4:
        if (r1.hasNext() == false) goto L14;
        String r2 = r1.next();
        if (TextUtils.isEmpty(r2) == true) goto L4;
        if (r2.contains("external_primary") == true) goto L4;
        File r3 = ApiHelperForR.getVolumeDir((StorageManager) ApiHelperForM.getSystemService(ContextUtils.getApplicationContext(), StorageManager.class), MediaStore.Files.getContentUri(r2));
        File r4 = new File(r3, Environment.DIRECTORY_DOWNLOADS);
        if (r4.isDirectory() == true) goto L12;
        Log.w(TAG, "Download dir missing: %s, parent dir:%s, isDirectory:%s", new Object[]{r4.getAbsolutePath(), r3.getAbsolutePath(), Boolean.valueOf(r3.isDirectory())});
    L12:
        r0.add(r4);
        goto L4
    L14:
        return toAbsolutePathStrings(r0);
    }

    @CalledByNative
    public static String getExternalStorageDirectory() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    @CalledByNative
    private static String getNativeLibraryDirectory() {
        ApplicationInfo r0 = ContextUtils.getApplicationContext().getApplicationInfo();
        int r1 = r0.flags;
        if ((r1 & 128) != 0) goto L10;
        if ((r1 & 1) == 0) goto L10;
        return "/system/lib/";
    L10:
        return r0.nativeLibraryDir;
    }

    private static String[] getOrComputeDirectoryPaths() {
        if (sDirPathFetchTask.isDone() == true) goto L20;
        StrictModeContext r0 = StrictModeContext.allowDiskWrites();
        sDirPathFetchTask.run();     // Catch: Throwable -> L8
        if (r0 == null) goto L20;
        r0.close();
    L8:
        th = move-exception;
        if (r0 != null) goto L24;
    L14:
        throw th;
    L24:
        r0.close();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th.addSuppressed(th);
    L20:
        return sDirPathFetchTask.get();
    L17:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @CalledByNative
    public static String getThumbnailCacheDirectory() {
        return getDirectoryPath(1);
    }

    public static void resetForTesting() {
        sInitializationStarted.set(false);
        sDirPathFetchTask = null;
        sDataDirectorySuffix = null;
        sCacheSubDirectory = null;
    }

    public static void setPrivateDataDirectorySuffix(String r2, String r3) {
        if (sInitializationStarted.getAndSet(true) == true) goto L6;
        sDataDirectorySuffix = r2;
        sCacheSubDirectory = r3;
        sDirPathFetchTask = new FutureTask(new c());
        AsyncTask.THREAD_POOL_EXECUTOR.execute(sDirPathFetchTask);
        return;
    }

    private static String[] setPrivateDataDirectorySuffixInternal() {
        String[] r0 = new String[3];
        Context r1 = ContextUtils.getApplicationContext();
        String r2 = r1.getDir(sDataDirectorySuffix, 0).getPath();
        r0[0] = r2;
        chmod(r2, 448);
        r0[1] = r1.getDir(THUMBNAIL_DIRECTORY_NAME, 0).getPath();
        if (r1.getCacheDir() != null) goto L5;
    L8:
        return r0;
    L5:
        if (sCacheSubDirectory != null) goto L7;
        r0[2] = r1.getCacheDir().getPath();
        goto L8
    L7:
        File r3 = new File(r1.getCacheDir(), sCacheSubDirectory);
        r3.mkdir();
        String r4 = r3.getPath();
        r0[2] = r4;
        chmod(r4, 1472);
        goto L8
    }

    @NonNull
    private static String[] toAbsolutePathStrings(@NonNull List<File> r3) {
        ArrayList r0 = new ArrayList();
        Iterator<File> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L12;
        File r1 = r4.next();
        if (r1 == null) goto L4;
        if (TextUtils.isEmpty(r1.getAbsolutePath()) == true) goto L4;
        r0.add(r1.getAbsolutePath());
        goto L4
    L12:
        return (String[]) r0.toArray(new String[r0.size()]);
    }

    public static void setPrivateDataDirectorySuffix(String r1) {
        setPrivateDataDirectorySuffix(r1, null);
    }
}
