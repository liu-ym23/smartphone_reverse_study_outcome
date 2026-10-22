package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class DeviceProfileWriter {
    private final String mApkName;
    private final AssetManager mAssetManager;
    private final File mCurProfile;
    private final byte[] mDesiredVersion;
    private boolean mDeviceSupportsAotProfile;
    private final ProfileInstaller.DiagnosticsCallback mDiagnostics;
    private final Executor mExecutor;
    private DexProfileData[] mProfile;
    private final String mProfileMetaSourceLocation;
    private final String mProfileSourceLocation;
    private byte[] mTranscodedProfile;

    private void result(final int r3, final Object r4) {
        this.mExecutor.execute(new DeviceProfileWriter$$ExternalSyntheticLambda0(this, r3, r4));
    }

    /* JADX INFO: renamed from: lambda$result$0$androidx-profileinstaller-DeviceProfileWriter, reason: not valid java name */
    /* synthetic */ void m64lambda$result$0$androidxprofileinstallerDeviceProfileWriter(int r1, Object r2) {
        this.mDiagnostics.onResultReceived(r1, r2);
    }

    public DeviceProfileWriter(AssetManager r2, Executor r3, ProfileInstaller.DiagnosticsCallback r4, String r5, String r6, String r7, File r8) {
        this.mDeviceSupportsAotProfile = false;
        this.mAssetManager = r2;
        this.mExecutor = r3;
        this.mDiagnostics = r4;
        this.mApkName = r5;
        this.mProfileSourceLocation = r6;
        this.mProfileMetaSourceLocation = r7;
        this.mCurProfile = r8;
        this.mDesiredVersion = desiredVersion();
    }

    public boolean deviceAllowsProfileInstallerAotWrites() {
        if (this.mDesiredVersion != null) goto L7;
        result(3, Integer.valueOf(Build.VERSION.SDK_INT));
        return false;
    L7:
        if (this.mCurProfile.exists() == true) goto L9;
        this.mCurProfile.createNewFile();     // Catch: IOException -> L15
    L13:
        this.mDeviceSupportsAotProfile = true;
        return true;
    L15:
        result(4, null);
        return false;
    L9:
        if (this.mCurProfile.canWrite() == true) goto L13;
        result(4, null);
        return false;
    }

    private void assertDeviceAllowsProfileInstallerAotWritesCalled() {
        if (this.mDeviceSupportsAotProfile == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
    }

    public DeviceProfileWriter read() {
        assertDeviceAllowsProfileInstallerAotWritesCalled();
        if (this.mDesiredVersion != null) goto L5;
        return this;
    L5:
        InputStream r0 = getProfileInputStream(this.mAssetManager);
        if (r0 == null) goto L8;
        this.mProfile = readProfileInternal(r0);
    L8:
        DexProfileData[] r1 = this.mProfile;
        if (r1 != null) goto L11;
    L15:
        return this;
    L11:
        if (requiresMetadata() == false) goto L15;
        DeviceProfileWriter r2 = addMetadata(r1, this.mDesiredVersion);
        if (r2 == null) goto L15;
        return r2;
    }

    private InputStream openStreamFromAssets(AssetManager r2, String r3) throws IOException {
        return r2.openFd(r3).createInputStream();
    L4:
        e = move-exception;
        String r4 = e.getMessage();
        if (r4 == null) goto L11;
        if (r4.contains("compressed") == false) goto L11;
        this.mDiagnostics.onDiagnosticReceived(5, null);
    L11:
        return null;
    }

    private InputStream getProfileInputStream(AssetManager r2) {
    L12:
        return openStreamFromAssets(r2, this.mProfileSourceLocation);
    L6:
        e = move-exception;
        this.mDiagnostics.onResultReceived(6, e);
    L8:
        return null;
    L4:
        e = move-exception;
        this.mDiagnostics.onResultReceived(7, e);
        goto L8
    }

    private DexProfileData[] readProfileInternal(InputStream r5) {
        DexProfileData[] r1 = ProfileTranscoder.readProfile(r5, ProfileTranscoder.readHeader(r5, ProfileTranscoder.MAGIC_PROF), this.mApkName);     // Catch: Throwable -> L8 IllegalStateException -> L10 IOException -> L14
        r5.close();     // Catch: IOException -> L6
        return r1;
    L6:
        e = move-exception;
        this.mDiagnostics.onResultReceived(7, e);
        return r1;
    L8:
        th = move-exception;
        r5.close();     // Catch: IOException -> L24
    L26:
        throw th;
    L24:
        e = move-exception;
        this.mDiagnostics.onResultReceived(7, e);
    L14:
        e = move-exception;
        this.mDiagnostics.onResultReceived(7, e);     // Catch: Throwable -> L8
        r5.close();     // Catch: IOException -> L18
    L30:
    L20:
        return null;
    L10:
        e = move-exception;
        this.mDiagnostics.onResultReceived(8, e);     // Catch: Throwable -> L8
        r5.close();     // Catch: IOException -> L18
    L18:
        e = move-exception;
        this.mDiagnostics.onResultReceived(7, e);
        goto L20
    }

    private DeviceProfileWriter addMetadata(DexProfileData[] r4, byte[] r5) {
        InputStream r1 = openStreamFromAssets(this.mAssetManager, this.mProfileMetaSourceLocation);     // Catch: IllegalStateException -> L19 IOException -> L21 FileNotFoundException -> L23
        if (r1 != null) goto L28;
        if (r1 == null) goto L25;
        r1.close();     // Catch: IllegalStateException -> L19 IOException -> L21 FileNotFoundException -> L23
    L25:
        return null;
    L28:
        this.mProfile = ProfileTranscoder.readMeta(r1, ProfileTranscoder.readHeader(r1, ProfileTranscoder.MAGIC_PROFM), r5, r4);     // Catch: Throwable -> L9
        if (r1 == null) goto L8;
        r1.close();     // Catch: IllegalStateException -> L19 IOException -> L21 FileNotFoundException -> L23
    L8:
        return this;
    L9:
        th = move-exception;
        if (r1 != null) goto L26;
    L15:
        throw th;     // Catch: IllegalStateException -> L19 IOException -> L21 FileNotFoundException -> L23
    L26:
        r1.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IllegalStateException -> L19 IOException -> L21 FileNotFoundException -> L23
    L23:
        e = move-exception;
        this.mDiagnostics.onResultReceived(9, e);
    L21:
        e = move-exception;
        this.mDiagnostics.onResultReceived(7, e);
    L19:
        e = move-exception;
        this.mProfile = null;
        this.mDiagnostics.onResultReceived(8, e);
        goto L25
    }

    public DeviceProfileWriter transcodeIfNeeded() {
        DexProfileData[] r0 = this.mProfile;
        byte[] r1 = this.mDesiredVersion;
        if (r0 == null) goto L27;
        if (r1 == null) goto L27;
        assertDeviceAllowsProfileInstallerAotWritesCalled();
        ByteArrayOutputStream r3 = new ByteArrayOutputStream();     // Catch: IllegalStateException -> L22 IOException -> L24
        ProfileTranscoder.writeHeader(r3, r1);     // Catch: Throwable -> L16
        if (ProfileTranscoder.transcodeAndWriteBody(r3, r1, r0) == true) goto L13;
        this.mDiagnostics.onResultReceived(5, null);     // Catch: Throwable -> L16
        this.mProfile = null;     // Catch: Throwable -> L16
        r3.close();     // Catch: IllegalStateException -> L22 IOException -> L24
        return this;
    L13:
        this.mTranscodedProfile = r3.toByteArray();     // Catch: Throwable -> L16
        r3.close();     // Catch: IllegalStateException -> L22 IOException -> L24
    L26:
        this.mProfile = null;
    L16:
        th = move-exception;
        r3.close();     // Catch: Throwable -> L19
    L21:
        throw th;     // Catch: IllegalStateException -> L22 IOException -> L24
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IllegalStateException -> L22 IOException -> L24
    L24:
        e = move-exception;
        this.mDiagnostics.onResultReceived(7, e);
    L22:
        e = move-exception;
        this.mDiagnostics.onResultReceived(8, e);
    L27:
        return this;
    }

    public boolean write() {
        byte[] r0 = this.mTranscodedProfile;
        if (r0 != null) goto L5;
        return false;
    L5:
        assertDeviceAllowsProfileInstallerAotWritesCalled();
        ByteArrayInputStream r3 = new ByteArrayInputStream(r0);     // Catch: Throwable -> L25 IOException -> L27 FileNotFoundException -> L30
        FileOutputStream r1 = new FileOutputStream(this.mCurProfile);     // Catch: Throwable -> L19
        Encoding.writeAll(r3, r1);     // Catch: Throwable -> L13
        result(1, null);     // Catch: Throwable -> L13
        r1.close();     // Catch: Throwable -> L19
        r3.close();     // Catch: Throwable -> L25 IOException -> L27 FileNotFoundException -> L30
        this.mTranscodedProfile = null;
        this.mProfile = null;
        return true;
    L13:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L16
    L18:
        throw th;     // Catch: Throwable -> L19
    L16:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        r3.close();     // Catch: Throwable -> L22
    L24:
        throw th;     // Catch: Throwable -> L25 IOException -> L27 FileNotFoundException -> L30
    L22:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L25 IOException -> L27 FileNotFoundException -> L30
    L25:
        th = move-exception;
        this.mTranscodedProfile = null;
        this.mProfile = null;
        throw th;
    L30:
        e = move-exception;
        result(6, e);     // Catch: Throwable -> L25
    L32:
        this.mTranscodedProfile = null;
        this.mProfile = null;
        return false;
    L27:
        e = move-exception;
        result(7, e);     // Catch: Throwable -> L25
        goto L32
    }

    private static byte[] desiredVersion() {
        if (Build.VERSION.SDK_INT <= 34) goto L5;
        return null;
    L5:
        int r0 = Build.VERSION.SDK_INT;
        if (r0 == 33) goto L10;
        if (r0 == 34) goto L10;
        return null;
    L10:
        return ProfileVersion.V015_S;
    }

    private static boolean requiresMetadata() {
        if (Build.VERSION.SDK_INT <= 34) goto L5;
        return false;
    L5:
        int r0 = Build.VERSION.SDK_INT;
        if (r0 == 33) goto L9;
        if (r0 == 34) goto L11;
        return false;
    L11:
        return true;
    L9:
        return true;
    }
}
