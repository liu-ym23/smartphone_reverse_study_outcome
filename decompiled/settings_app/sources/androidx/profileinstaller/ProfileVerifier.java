package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.concurrent.futures.ResolvableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class ProfileVerifier {
    private static final String CUR_PROFILES_BASE_DIR = "/data/misc/profiles/cur/0/";
    private static final String PROFILE_FILE_NAME = "primary.prof";
    private static final String PROFILE_INSTALLED_CACHE_FILE_NAME = "profileInstalled";
    private static final String REF_PROFILES_BASE_DIR = "/data/misc/profiles/ref/";
    private static final Object SYNC_OBJ = null;
    private static final String TAG = "ProfileVerifier";
    private static CompilationStatus sCompilationStatus;
    private static final ResolvableFuture<CompilationStatus> sFuture = null;

    private static class Api33Impl {
        private Api33Impl() {
        }

        static PackageInfo getPackageInfo(PackageManager r2, Context r3) throws PackageManager.NameNotFoundException {
            return r2.getPackageInfo(r3.getPackageName(), PackageManager.PackageInfoFlags.of(0));
        }
    }

    static class Cache {
        private static final int SCHEMA = 1;
        final long mInstalledCurrentProfileSize;
        final long mPackageLastUpdateTime;
        final int mResultCode;
        final int mSchema;

        Cache(int r1, int r2, long r3, long r5) {
            this.mSchema = r1;
            this.mResultCode = r2;
            this.mPackageLastUpdateTime = r3;
            this.mInstalledCurrentProfileSize = r5;
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (r7 != null) goto L8;
        L21:
            return false;
        L8:
            if ((r7 instanceof Cache) == false) goto L21;
            Cache r8 = (Cache) r7;
            if (this.mResultCode != r8.mResultCode) goto L20;
            if (this.mPackageLastUpdateTime != r8.mPackageLastUpdateTime) goto L20;
            if (this.mSchema != r8.mSchema) goto L20;
            if (this.mInstalledCurrentProfileSize != r8.mInstalledCurrentProfileSize) goto L20;
            return true;
        L20:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.mResultCode), Long.valueOf(this.mPackageLastUpdateTime), Integer.valueOf(this.mSchema), Long.valueOf(this.mInstalledCurrentProfileSize)});
        }

        void writeOnFile(File r4) throws IOException {
            r4.delete();
            DataOutputStream r0 = new DataOutputStream(new FileOutputStream(r4));
            r0.writeInt(this.mSchema);     // Catch: Throwable -> L6
            r0.writeInt(this.mResultCode);     // Catch: Throwable -> L6
            r0.writeLong(this.mPackageLastUpdateTime);     // Catch: Throwable -> L6
            r0.writeLong(this.mInstalledCurrentProfileSize);     // Catch: Throwable -> L6
            r0.close();
            return;
        L6:
            th = move-exception;
            r0.close();     // Catch: Throwable -> L9
        L11:
            throw th;
        L9:
            th = move-exception;
            th.addSuppressed(th);
            goto L11
        }

        static Cache readFromFile(File r9) throws IOException {
            DataInputStream r0 = new DataInputStream(new FileInputStream(r9));
            Cache r10 = new Cache(r0.readInt(), r0.readInt(), r0.readLong(), r0.readLong());     // Catch: Throwable -> L6
            r0.close();
            return r10;
        L6:
            th = move-exception;
            r0.close();     // Catch: Throwable -> L9
        L11:
            throw th;
        L9:
            th = move-exception;
            th.addSuppressed(th);
            goto L11
        }
    }

    public static class CompilationStatus {
        public static final int RESULT_CODE_COMPILED_WITH_PROFILE = 1;
        public static final int RESULT_CODE_COMPILED_WITH_PROFILE_NON_MATCHING = 3;
        public static final int RESULT_CODE_ERROR_CACHE_FILE_EXISTS_BUT_CANNOT_BE_READ = 131072;
        public static final int RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE = 196608;
        private static final int RESULT_CODE_ERROR_CODE_BIT_SHIFT = 16;
        public static final int RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST = 65536;
        public static final int RESULT_CODE_ERROR_UNSUPPORTED_API_VERSION = 262144;
        public static final int RESULT_CODE_NO_PROFILE = 0;
        public static final int RESULT_CODE_PROFILE_ENQUEUED_FOR_COMPILATION = 2;
        private final boolean mHasCurrentProfile;
        private final boolean mHasReferenceProfile;
        final int mResultCode;

        @Retention(RetentionPolicy.SOURCE)
        public @interface ResultCode {
        }

        CompilationStatus(int r1, boolean r2, boolean r3) {
            this.mResultCode = r1;
            this.mHasCurrentProfile = r3;
            this.mHasReferenceProfile = r2;
        }

        public int getProfileInstallResultCode() {
            return this.mResultCode;
        }

        public boolean isCompiledWithProfile() {
            return this.mHasReferenceProfile;
        }

        public boolean hasProfileEnqueuedForCompilation() {
            return this.mHasCurrentProfile;
        }
    }

    static {
        sFuture = ResolvableFuture.create();
        SYNC_OBJ = new Object();
        sCompilationStatus = null;
    }

    private ProfileVerifier() {
    }

    public static CompilationStatus writeProfileVerification(Context r1) {
        return writeProfileVerification(r1, false);
    }

    static CompilationStatus writeProfileVerification(Context r18, boolean r19) {
        if (r19 == true) goto L6;
        CompilationStatus r0 = sCompilationStatus;
        if (r0 == null) goto L6;
        return r0;
    L6:
        Object r1 = SYNC_OBJ;
        monitor-enter(r1);
        if (r19 == false) goto L77;
    L15:
        File r2 = new File(new File(REF_PROFILES_BASE_DIR, r18.getPackageName()), PROFILE_FILE_NAME);     // Catch: Throwable -> L13
        long r3 = r2.length();     // Catch: Throwable -> L13
        int r6 = 0;
        if (r2.exists() == true) goto L18;
    L20:
        boolean r4 = false;
    L21:
        File r8 = new File(new File(CUR_PROFILES_BASE_DIR, r18.getPackageName()), PROFILE_FILE_NAME);     // Catch: Throwable -> L13
        long r16 = r8.length();     // Catch: Throwable -> L13
        if (r8.exists() == true) goto L24;
    L26:
        boolean r5 = false;
    L80:
        long r14 = getPackageLastUpdateTime(r18);     // Catch: Throwable -> L13 PackageManager.NameNotFoundException -> L70
        File r7 = new File(r18.getFilesDir(), PROFILE_INSTALLED_CACHE_FILE_NAME);     // Catch: Throwable -> L13
        if (r7.exists() == true) goto L75;
        Cache r9 = null;
    L38:
        if (r9 != null) goto L40;
    L45:
        if (r4 == false) goto L47;
        r6 = 1;
    L49:
        if (r19 == false) goto L53;
        if (r5 == false) goto L53;
        if (r6 == 1) goto L53;
        r6 = 2;
    L53:
        if (r9 != null) goto L55;
    L60:
        Cache r10 = new Cache(1, r6, r14, r16);     // Catch: Throwable -> L13
        if (r9 != null) goto L63;
    L78:
        r10.writeOnFile(r7);     // Catch: Throwable -> L13 IOException -> L66
    L67:
        CompilationStatus r11 = setCompilationStatus(r6, r4, r5);     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        return r11;
    L66:
        r6 = CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        goto L67
    L63:
        if (r9.equals(r10) == true) goto L67;
    L55:
        if (r9.mResultCode != 2) goto L60;
        if (r6 != 1) goto L60;
        if (r3 >= r9.mInstalledCurrentProfileSize) goto L60;
        r6 = 3;
        goto L60
    L47:
        if (r5 == false) goto L49;
        r6 = 2;
        goto L49
    L40:
        if (r9.mPackageLastUpdateTime != r14) goto L45;
        if (r9.mResultCode == 2) goto L45;
        r6 = r9.mResultCode;     // Catch: Throwable -> L13
        goto L49
    L75:
        r9 = Cache.readFromFile(r7);     // Catch: Throwable -> L13 IOException -> L32
    L35:
        return setCompilationStatus(131072, r4, r5);
    L13:
        th = move-exception;
        throw th;
    L72:
        return setCompilationStatus(65536, r4, r5);
    L24:
        if (r16 <= 0) goto L26;
        r5 = true;
        goto L80
    L18:
        if (r3 <= 0) goto L20;
        r4 = true;
        goto L21
    L77:
        CompilationStatus r12 = sCompilationStatus;     // Catch: Throwable -> L13
        if (r12 == null) goto L15;
        monitor-exit(r1);     // Catch: Throwable -> L13
        return r12;
    }

    private static CompilationStatus setCompilationStatus(int r1, boolean r2, boolean r3) {
        CompilationStatus r0 = new CompilationStatus(r1, r2, r3);
        sCompilationStatus = r0;
        sFuture.set(r0);
        return sCompilationStatus;
    }

    private static long getPackageLastUpdateTime(Context r2) throws PackageManager.NameNotFoundException {
        return Api33Impl.getPackageInfo(r2.getApplicationContext().getPackageManager(), r2).lastUpdateTime;
    }

    public static ListenableFuture<CompilationStatus> getCompilationStatusAsync() {
        return sFuture;
    }
}
