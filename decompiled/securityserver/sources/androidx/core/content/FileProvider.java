package androidx.core.content;

import a.a;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.librarian.LibrarianImpl;
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
    private static final String META_DATA_FILE_PROVIDER_PATHS = "android.support.FILE_PROVIDER_PATHS";
    private static final String TAG_CACHE_PATH = "cache-path";
    private static final String TAG_EXTERNAL = "external-path";
    private static final String TAG_EXTERNAL_CACHE = "external-cache-path";
    private static final String TAG_EXTERNAL_FILES = "external-files-path";
    private static final String TAG_EXTERNAL_MEDIA = "external-media-path";
    private static final String TAG_FILES_PATH = "files-path";
    private static final String TAG_ROOT_PATH = "root-path";

    @GuardedBy("sCache")
    private static HashMap<String, PathStrategy> sCache;
    private PathStrategy mStrategy;

    public interface PathStrategy {
        File getFileForUri(Uri r1);

        Uri getUriForFile(File r1);
    }

    public static class SimplePathStrategy implements PathStrategy {
        private final String mAuthority;
        private final HashMap<String, File> mRoots;

        public SimplePathStrategy(String r2) {
            this.mRoots = new HashMap();
            this.mAuthority = r2;
        }

        public void addRoot(String r3, File r4) {
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
            Iterator<Map.Entry<String, File>> r0 = this.mRoots.entrySet().iterator();
            Map.Entry<String, File> r1 = null;
        L5:
            if (r0.hasNext() == false) goto L12;
            Map.Entry<String, File> r2 = r0.next();
            String r3 = r2.getValue().getPath();
            if (r7.startsWith(r3) == false) goto L5;
            if (r1 == null) goto L11;
            if (r3.length() <= r1.getValue().getPath().length()) goto L5;
        L11:
            r1 = r2;
            goto L5
        L12:
            if (r1 == null) goto L20;
            String r4 = r1.getValue().getPath();
            if (r4.endsWith(LibrarianImpl.Constants.SEPARATOR) == false) goto L16;
            String r8 = r7.substring(r4.length());
        L18:
            return new Uri.Builder().scheme("content").authority(this.mAuthority).encodedPath(Uri.encode(r1.getKey()) + '/' + Uri.encode(r8, LibrarianImpl.Constants.SEPARATOR)).build();
        L16:
            r8 = r7.substring(r4.length() + 1);
            goto L18
        L20:
            throw new IllegalArgumentException(a.A("Failed to find configured root that contains ", r7));
        L22:
            throw new IllegalArgumentException("Failed to resolve canonical path for " + r6);
        }
    }

    static {
        COLUMNS = new String[]{"_display_name", "_size"};
        DEVICE_ROOT = new File(LibrarianImpl.Constants.SEPARATOR);
        sCache = new HashMap();
    }

    public FileProvider() {
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

    private static String[] copyOf(String[] r2, int r3) {
        String[] r0 = new String[r3];
        System.arraycopy(r2, 0, r0, 0, r3);
        return r0;
    }

    private static PathStrategy getPathStrategy(Context r2, String r3) {
        HashMap<String, PathStrategy> r0 = sCache;
        monitor-enter(r0);
        PathStrategy r1 = sCache.get(r3);     // Catch: Throwable -> L8
        if (r1 == null) goto L21;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r1;
    L21:
        r1 = parsePathStrategy(r2, r3);     // Catch: Throwable -> L8 XmlPullParserException -> L10 IOException -> L13
        sCache.put(r3, r1);     // Catch: Throwable -> L8
        goto L16
    L13:
        e = move-exception;
        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e);     // Catch: Throwable -> L8
    L10:
        e = move-exception;
        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public static Uri getUriForFile(@NonNull Context r0, @NonNull String r1, @NonNull File r2) {
        return getPathStrategy(r0, r1).getUriForFile(r2);
    }

    private static int modeToMode(String r2) {
        if ("r".equals(r2) == false) goto L6;
        return 268435456;
    L6:
        if ("w".equals(r2) == false) goto L8;
    L21:
        return 738197504;
    L8:
        if ("wt".equals(r2) == true) goto L21;
        if ("wa".equals(r2) == false) goto L14;
        return 704643072;
    L14:
        if ("rw".equals(r2) == false) goto L17;
        return 939524096;
    L17:
        if ("rwt".equals(r2) == false) goto L20;
        return 1006632960;
    L20:
        throw new IllegalArgumentException(a.A("Invalid mode: ", r2));
    }

    private static PathStrategy parsePathStrategy(Context r7, String r8) {
        SimplePathStrategy r0 = new SimplePathStrategy(r8);
        ProviderInfo r1 = r7.getPackageManager().resolveContentProvider(r8, 128);
        if (r1 == null) goto L43;
        XmlResourceParser r9 = r1.loadXmlMetaData(r7.getPackageManager(), META_DATA_FILE_PROVIDER_PATHS);
        if (r9 == null) goto L41;
    L6:
        int r2 = r9.next();
        if (r2 == 1) goto L39;
        if (r2 != 2) goto L6;
        String r3 = r9.getName();
        File r4 = null;
        String r5 = r9.getAttributeValue(null, "name");
        String r6 = r9.getAttributeValue(null, "path");
        if (TAG_ROOT_PATH.equals(r3) == false) goto L14;
        r4 = DEVICE_ROOT;
    L37:
        if (r4 == null) goto L6;
        r0.addRoot(r5, buildPath(r4, new String[]{r6}));
        goto L6
    L14:
        if (TAG_FILES_PATH.equals(r3) == false) goto L17;
        r4 = r7.getFilesDir();
        goto L37
    L17:
        if (TAG_CACHE_PATH.equals(r3) == false) goto L20;
        r4 = r7.getCacheDir();
        goto L37
    L20:
        if (TAG_EXTERNAL.equals(r3) == false) goto L23;
        r4 = Environment.getExternalStorageDirectory();
        goto L37
    L23:
        if (TAG_EXTERNAL_FILES.equals(r3) == false) goto L28;
        File[] r10 = ContextCompat.getExternalFilesDirs(r7, null);
        if (r10.length <= 0) goto L37;
        r4 = r10[0];
        goto L37
    L28:
        if (TAG_EXTERNAL_CACHE.equals(r3) == false) goto L33;
        File[] r11 = ContextCompat.getExternalCacheDirs(r7);
        if (r11.length <= 0) goto L37;
        r4 = r11[0];
        goto L37
    L33:
        if (TAG_EXTERNAL_MEDIA.equals(r3) == false) goto L37;
        File[] r12 = r7.getExternalMediaDirs();
        if (r12.length <= 0) goto L37;
        r4 = r12[0];
        goto L37
    L39:
        return r0;
    L41:
        throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
    L43:
        throw new IllegalArgumentException(a.A("Couldn't find meta-data for provider with authority ", r8));
    }

    @Override // android.content.ContentProvider
    public void attachInfo(@NonNull Context r2, @NonNull ProviderInfo r3) {
        super.attachInfo(r2, r3);
        if (r3.exported == true) goto L11;
        if (r3.grantUriPermissions == false) goto L9;
        this.mStrategy = getPathStrategy(r2, r3.authority);
        return;
    L9:
        throw new SecurityException("Provider must grant uri permissions");
    L11:
        throw new SecurityException("Provider must not be exported");
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri r1, @Nullable String r2, @Nullable String[] r3) {
        return this.mStrategy.getFileForUri(r1).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
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
    public Uri insert(@NonNull Uri r1, ContentValues r2) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(@NonNull Uri r1, @NonNull String r2) {
        return ParcelFileDescriptor.open(this.mStrategy.getFileForUri(r1), modeToMode(r2));
    }

    @Override // android.content.ContentProvider
    public Cursor query(@NonNull Uri r5, @Nullable String[] r6, @Nullable String r7, @Nullable String[] r8, @Nullable String r9) {
        File r4 = this.mStrategy.getFileForUri(r5);
        if (r6 != null) goto L5;
        r6 = COLUMNS;
    L5:
        String[] r10 = new String[r6.length];
        Object[] r11 = new Object[r6.length];
        int r12 = r6.length;
        int r13 = 0;
        int r0 = 0;
    L6:
        if (r13 >= r12) goto L15;
        String r1 = r6[r13];
        if ("_display_name".equals(r1) == false) goto L12;
        r10[r0] = "_display_name";
        int r2 = r0 + 1;
        r11[r0] = r4.getName();
    L10:
        r0 = r2;
    L14:
        r13 = r13 + 1;
        goto L6
    L12:
        if ("_size".equals(r1) == false) goto L14;
        r10[r0] = "_size";
        r2 = r0 + 1;
        r11[r0] = Long.valueOf(r4.length());
        goto L10
    L15:
        String[] r14 = copyOf(r10, r0);
        Object[] r15 = copyOf(r11, r0);
        MatrixCursor r16 = new MatrixCursor(r14, 1);
        r16.addRow(r15);
        return r16;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri r1, ContentValues r2, @Nullable String r3, @Nullable String[] r4) {
        throw new UnsupportedOperationException("No external updates");
    }

    private static Object[] copyOf(Object[] r2, int r3) {
        Object[] r0 = new Object[r3];
        System.arraycopy(r2, 0, r0, 0, r3);
        return r0;
    }
}
