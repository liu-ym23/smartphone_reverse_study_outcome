package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.annotation.DoNotInline;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.XmlRes;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class FileProvider extends ContentProvider {
    private static final String ATTR_NAME = "name";
    private static final String ATTR_PATH = "path";
    private static final String[] COLUMNS = null;
    private static final File DEVICE_ROOT = null;
    private static final String DISPLAYNAME_FIELD = "displayName";
    private static final String META_DATA_FILE_PROVIDER_PATHS = "android.support.FILE_PROVIDER_PATHS";
    private static final String TAG_CACHE_PATH = "cache-path";
    private static final String TAG_EXTERNAL = "external-path";
    private static final String TAG_EXTERNAL_CACHE = "external-cache-path";
    private static final String TAG_EXTERNAL_FILES = "external-files-path";
    private static final String TAG_EXTERNAL_MEDIA = "external-media-path";
    private static final String TAG_FILES_PATH = "files-path";
    private static final String TAG_ROOT_PATH = "root-path";

    @GuardedBy("sCache")
    private static final HashMap<String, PathStrategy> sCache = null;
    private int mResourceId;
    private PathStrategy mStrategy;

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static File[] getExternalMediaDirs(Context r0) {
            return r0.getExternalMediaDirs();
        }
    }

    interface PathStrategy {
        File getFileForUri(Uri r1);

        Uri getUriForFile(File r1);
    }

    static class SimplePathStrategy implements PathStrategy {
        private final String mAuthority;
        private final HashMap<String, File> mRoots;

        SimplePathStrategy(String r2) {
            this.mRoots = new HashMap();
            this.mAuthority = r2;
        }

        void addRoot(String r3, File r4) {
            if (TextUtils.isEmpty(r3) == true) goto L11;
            this.mRoots.put(r3, r4.getCanonicalFile());
            return;
        L7:
            e = move-exception;
            throw new IllegalArgumentException("Failed to resolve canonical path for " + r4, e);
        L11:
            throw new IllegalArgumentException("Name must not be empty");
        }

        @Override // androidx.core.content.FileProvider.PathStrategy
        public File getFileForUri(Uri r5) {
            String r0 = r5.getEncodedPath();
            int r1 = r0.indexOf(47, 1);
            String r3 = Uri.decode(r0.substring(1, r1));
            String r2 = Uri.decode(r0.substring(r1 + 1));
            File r4 = this.mRoots.get(r3);
            if (r4 == null) goto L14;
            File r6 = new File(r4, r2);
            File r7 = r6.getCanonicalFile();     // Catch: IOException -> L11
            if (r7.getPath().startsWith(r4.getPath()) == false) goto L10;
            return r7;
        L10:
            throw new SecurityException("Resolved path jumped beyond configured root");
        L12:
            throw new IllegalArgumentException("Failed to resolve canonical path for " + r6);
        L14:
            throw new IllegalArgumentException("Unable to find configured root for " + r5);
        }

        @Override // androidx.core.content.FileProvider.PathStrategy
        public Uri getUriForFile(File r6) {
            String r7 = r6.getCanonicalPath();     // Catch: IOException -> L21
            Map.Entry<String, File> r0 = null;
            Iterator<Map.Entry<String, File>> r1 = this.mRoots.entrySet().iterator();
        L5:
            if (r1.hasNext() == false) goto L12;
            Map.Entry<String, File> r2 = r1.next();
            String r3 = r2.getValue().getPath();
            if (r7.startsWith(r3) == false) goto L5;
            if (r0 == null) goto L11;
            if (r3.length() <= r0.getValue().getPath().length()) goto L5;
        L11:
            r0 = r2;
            goto L5
        L12:
            if (r0 == null) goto L20;
            String r4 = r0.getValue().getPath();
            boolean r5 = r4.endsWith("/");
            int r8 = r4.length();
            if (r5 == true) goto L18;
            r8 = r8 + 1;
        L18:
            return new Uri.Builder().scheme("content").authority(this.mAuthority).encodedPath(Uri.encode(r0.getKey()) + '/' + Uri.encode(r7.substring(r8), "/")).build();
        L20:
            throw new IllegalArgumentException("Failed to find configured root that contains " + r7);
        L22:
            throw new IllegalArgumentException("Failed to resolve canonical path for " + r6);
        }
    }

    static {
        COLUMNS = new String[]{"_display_name", "_size"};
        DEVICE_ROOT = new File("/");
        sCache = new HashMap();
    }

    public FileProvider() {
        this.mResourceId = 0;
    }

    protected FileProvider(@XmlRes int r1) {
        this.mResourceId = r1;
    }

    private static File buildPath(File r4, String... r5) {
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        String r2 = r5[r1];
        if (r2 == null) goto L7;
        r4 = new File(r4, r2);
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        return r4;
    }

    private static Object[] copyOf(Object[] r2, int r3) {
        Object[] r0 = new Object[r3];
        System.arraycopy(r2, 0, r0, 0, r3);
        return r0;
    }

    private static String[] copyOf(String[] r2, int r3) {
        String[] r0 = new String[r3];
        System.arraycopy(r2, 0, r0, 0, r3);
        return r0;
    }

    @VisibleForTesting
    static XmlResourceParser getFileProviderPathsMetaData(Context r2, String r3, @Nullable ProviderInfo r4, int r5) {
        if (r4 == null) goto L13;
        if (r4.metaData != null) goto L7;
        if (r5 == 0) goto L7;
        Bundle r6 = new Bundle(1);
        r4.metaData = r6;
        r6.putInt(META_DATA_FILE_PROVIDER_PATHS, r5);
    L7:
        XmlResourceParser r7 = r4.loadXmlMetaData(r2.getPackageManager(), META_DATA_FILE_PROVIDER_PATHS);
        if (r7 == null) goto L11;
        return r7;
    L11:
        throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
    L13:
        throw new IllegalArgumentException("Couldn't find meta-data for provider with authority " + r3);
    }

    private static PathStrategy getPathStrategy(Context r2, String r3, int r4) {
        HashMap<String, PathStrategy> r0 = sCache;
        monitor-enter(r0);
        PathStrategy r1 = r0.get(r3);     // Catch: Throwable -> L16
        if (r1 == null) goto L20;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L16
        return r1;
    L20:
        r1 = parsePathStrategy(r2, r3, r4);     // Catch: XmlPullParserException -> L8 IOException -> L11 Throwable -> L16
        r0.put(r3, r1);     // Catch: Throwable -> L16
        goto L14
    L8:
        e = move-exception;
        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e);     // Catch: Throwable -> L16
    L11:
        e = move-exception;
        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public static Uri getUriForFile(@NonNull Context r1, @NonNull String r2, @NonNull File r3) {
        return getPathStrategy(r1, r2, 0).getUriForFile(r3);
    }

    @NonNull
    @SuppressLint({"StreamFiles"})
    public static Uri getUriForFile(@NonNull Context r0, @NonNull String r1, @NonNull File r2, @NonNull String r3) {
        return getUriForFile(r0, r1, r2).buildUpon().appendQueryParameter(DISPLAYNAME_FIELD, r3).build();
    }

    private static int modeToMode(String r3) {
        if ("r".equals(r3) == false) goto L6;
        return 268435456;
    L6:
        if ("w".equals(r3) == false) goto L8;
    L21:
        return 738197504;
    L8:
        if ("wt".equals(r3) == true) goto L21;
        if ("wa".equals(r3) == false) goto L14;
        return 704643072;
    L14:
        if ("rw".equals(r3) == false) goto L17;
        return 939524096;
    L17:
        if ("rwt".equals(r3) == false) goto L20;
        return 1006632960;
    L20:
        throw new IllegalArgumentException("Invalid mode: " + r3);
    }

    private static PathStrategy parsePathStrategy(Context r8, String r9, int r10) {
        SimplePathStrategy r0 = new SimplePathStrategy(r9);
        XmlResourceParser r11 = getFileProviderPathsMetaData(r8, r9, r8.getPackageManager().resolveContentProvider(r9, 128), r10);
    L3:
        int r12 = r11.next();
        if (r12 == 1) goto L38;
        if (r12 != 2) goto L3;
        String r13 = r11.getName();
        File r2 = null;
        String r3 = r11.getAttributeValue(null, ATTR_NAME);
        String r4 = r11.getAttributeValue(null, ATTR_PATH);
        if (TAG_ROOT_PATH.equals(r13) == false) goto L11;
        r2 = DEVICE_ROOT;
    L36:
        if (r2 == null) goto L3;
        r0.addRoot(r3, buildPath(r2, new String[]{r4}));
        goto L3
    L11:
        if (TAG_FILES_PATH.equals(r13) == false) goto L14;
        r2 = r8.getFilesDir();
        goto L36
    L14:
        if (TAG_CACHE_PATH.equals(r13) == false) goto L17;
        r2 = r8.getCacheDir();
        goto L36
    L17:
        if (TAG_EXTERNAL.equals(r13) == false) goto L20;
        r2 = Environment.getExternalStorageDirectory();
        goto L36
    L20:
        if (TAG_EXTERNAL_FILES.equals(r13) == false) goto L25;
        File[] r14 = ContextCompat.getExternalFilesDirs(r8, null);
        if (r14.length <= 0) goto L36;
        r2 = r14[0];
        goto L36
    L25:
        if (TAG_EXTERNAL_CACHE.equals(r13) == false) goto L30;
        File[] r15 = ContextCompat.getExternalCacheDirs(r8);
        if (r15.length <= 0) goto L36;
        r2 = r15[0];
        goto L36
    L30:
        if (Build.VERSION.SDK_INT < 21) goto L36;
        if (TAG_EXTERNAL_MEDIA.equals(r13) == false) goto L36;
        File[] r16 = Api21Impl.getExternalMediaDirs(r8);
        if (r16.length <= 0) goto L36;
        r2 = r16[0];
        goto L36
    L38:
        return r0;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(@NonNull Context r2, @NonNull ProviderInfo r3) {
        super.attachInfo(r2, r3);
        if (r3.exported == true) goto L18;
        if (r3.grantUriPermissions == false) goto L16;
        String r4 = r3.authority.split(";")[0];
        HashMap<String, PathStrategy> r0 = sCache;
        monitor-enter(r0);
        r0.remove(r4);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        this.mStrategy = getPathStrategy(r2, r4, this.mResourceId);
        return;
    L12:
        th = move-exception;
        throw th;
    L16:
        throw new SecurityException("Provider must grant uri permissions");
    L18:
        throw new SecurityException("Provider must not be exported");
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri r1, @Nullable String r2, @Nullable String[] r3) {
        return this.mStrategy.getFileForUri(r1).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri r2) {
        File r1 = this.mStrategy.getFileForUri(r2);
        int r3 = r1.getName().lastIndexOf(46);
        if (r3 < 0) goto L7;
        String r4 = r1.getName().substring(r3 + 1);
        String r5 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(r4);
        if (r5 == null) goto L9;
        return r5;
    L9:
        return "application/octet-stream";
    L7:
        return "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public Uri insert(@NonNull Uri r1, @NonNull ContentValues r2) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    @SuppressLint({"UnknownNullness"})
    public ParcelFileDescriptor openFile(@NonNull Uri r1, @NonNull String r2) {
        return ParcelFileDescriptor.open(this.mStrategy.getFileForUri(r1), modeToMode(r2));
    }

    @Override // android.content.ContentProvider
    @NonNull
    public Cursor query(@NonNull Uri r6, @Nullable String[] r7, @Nullable String r8, @Nullable String[] r9, @Nullable String r10) {
        File r5 = this.mStrategy.getFileForUri(r6);
        String r11 = r6.getQueryParameter(DISPLAYNAME_FIELD);
        if (r7 != null) goto L5;
        r7 = COLUMNS;
    L5:
        String[] r12 = new String[r7.length];
        Object[] r13 = new Object[r7.length];
        int r14 = r7.length;
        int r0 = 0;
        int r1 = 0;
    L6:
        if (r0 >= r14) goto L19;
        String r2 = r7[r0];
        if ("_display_name".equals(r2) == false) goto L15;
        r12[r1] = "_display_name";
        int r3 = r1 + 1;
        if (r11 != null) goto L12;
        String r4 = r5.getName();
    L13:
        r13[r1] = r4;
    L17:
        r1 = r3;
    L18:
        r0 = r0 + 1;
        goto L6
    L12:
        r4 = r11;
        goto L13
    L15:
        if ("_size".equals(r2) == false) goto L18;
        r12[r1] = "_size";
        r3 = r1 + 1;
        r13[r1] = Long.valueOf(r5.length());
        goto L17
    L19:
        String[] r15 = copyOf(r12, r1);
        Object[] r16 = copyOf(r13, r1);
        MatrixCursor r17 = new MatrixCursor(r15, 1);
        r17.addRow(r16);
        return r17;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri r1, @NonNull ContentValues r2, @Nullable String r3, @Nullable String[] r4) {
        throw new UnsupportedOperationException("No external updates");
    }
}
