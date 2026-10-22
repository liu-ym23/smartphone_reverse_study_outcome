package cz.msebera.android.httpclient.extras;

import android.os.Build;
import android.os.Process;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.Provider;
import java.security.SecureRandomSpi;

/* JADX INFO: loaded from: classes5.dex */
public final class PRNGFixes {
    private static final byte[] BUILD_FINGERPRINT_AND_DEVICE_SERIAL = null;
    private static final int VERSION_CODE_JELLY_BEAN = 16;
    private static final int VERSION_CODE_JELLY_BEAN_MR2 = 18;

    public static class LinuxPRNGSecureRandom extends SecureRandomSpi {
        private static final File URANDOM_FILE = null;
        private static final Object sLock = null;
        private static DataInputStream sUrandomIn;
        private static OutputStream sUrandomOut;
        private boolean mSeeded;

        public LinuxPRNGSecureRandom() {
        }

        static {
            URANDOM_FILE = new File("/dev/urandom");
            sLock = new Object();
        }

        @Override // java.security.SecureRandomSpi
        protected void engineSetSeed(byte[] r4) {
            Object r1 = sLock;     // Catch: Throwable -> L12 IOException -> L14
            monitor-enter(r1);     // Catch: Throwable -> L12 IOException -> L14
            OutputStream r2 = getUrandomOutputStream();     // Catch: Throwable -> L9
            monitor-exit(r1);     // Catch: Throwable -> L9
            r2.write(r4);     // Catch: Throwable -> L12 IOException -> L14
            r2.flush();     // Catch: Throwable -> L12 IOException -> L14
        L8:
            this.mSeeded = true;
            return;
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12 IOException -> L14
        L14:
            Log.w("PRNGFixes", "Failed to mix seed into " + URANDOM_FILE);     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            this.mSeeded = true;
            throw th;
        }

        @Override // java.security.SecureRandomSpi
        protected void engineNextBytes(byte[] r3) {
            if (this.mSeeded == true) goto L24;
            engineSetSeed(PRNGFixes.access$000());
        L24:
            Object r0 = sLock;     // Catch: IOException -> L19
            monitor-enter(r0);     // Catch: IOException -> L19
            DataInputStream r2 = getUrandomInputStream();     // Catch: Throwable -> L16
            monitor-exit(r0);     // Catch: Throwable -> L16
            monitor-enter(r2);     // Catch: IOException -> L19
            r2.readFully(r3);     // Catch: Throwable -> L13
            monitor-exit(r2);     // Catch: Throwable -> L13
            return;
        L13:
            th = move-exception;
            throw th;     // Catch: IOException -> L19
        L16:
            th = move-exception;
            throw th;     // Catch: IOException -> L19
        L19:
            e = move-exception;
            throw new SecurityException("Failed to read from " + URANDOM_FILE, e);
        }

        @Override // java.security.SecureRandomSpi
        protected byte[] engineGenerateSeed(int r1) {
            byte[] r2 = new byte[r1];
            engineNextBytes(r2);
            return r2;
        }

        private DataInputStream getUrandomInputStream() {
            Object r0 = sLock;
            monitor-enter(r0);
        L14:
            th = move-exception;
            throw th;
        L5:
            if (sUrandomIn == null) goto L17;
        L11:
            DataInputStream r4 = sUrandomIn;     // Catch: Throwable -> L14
            monitor-exit(r0);     // Catch: Throwable -> L14
            return r4;
        L17:
            sUrandomIn = new DataInputStream(new FileInputStream(URANDOM_FILE));     // Catch: IOException -> L8 Throwable -> L14
        L8:
            e = move-exception;
            throw new SecurityException("Failed to open " + URANDOM_FILE + " for reading", e);     // Catch: Throwable -> L14
        }

        private OutputStream getUrandomOutputStream() throws IOException {
            Object r2 = sLock;
            monitor-enter(r2);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (sUrandomOut != null) goto L7;
            sUrandomOut = new FileOutputStream(URANDOM_FILE);     // Catch: Throwable -> L10
        L7:
            OutputStream r0 = sUrandomOut;     // Catch: Throwable -> L10
            monitor-exit(r2);     // Catch: Throwable -> L10
            return r0;
        }
    }

    private static class LinuxPRNGSecureRandomProvider extends Provider {
        public LinuxPRNGSecureRandomProvider() {
            super("LinuxPRNG", 1.0d, "A Linux-specific random number provider that uses /dev/urandom");
            put("SecureRandom.SHA1PRNG", LinuxPRNGSecureRandom.class.getName());
            put("SecureRandom.SHA1PRNG ImplementedIn", ExifInterface.TAG_SOFTWARE);
        }
    }

    private static void applyOpenSSLFix() throws SecurityException {
    }

    private static void installLinuxPRNGSecureRandom() throws SecurityException {
    }

    static /* synthetic */ byte[] access$000() {
        return generateSeed();
    }

    static {
        BUILD_FINGERPRINT_AND_DEVICE_SERIAL = getBuildFingerprintAndDeviceSerial();
    }

    private PRNGFixes() {
    }

    public static void apply() {
        applyOpenSSLFix();
        installLinuxPRNGSecureRandom();
    }

    private static byte[] generateSeed() {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();     // Catch: IOException -> L4
        DataOutputStream r1 = new DataOutputStream(r0);     // Catch: IOException -> L4
        r1.writeLong(System.currentTimeMillis());     // Catch: IOException -> L4
        r1.writeLong(System.nanoTime());     // Catch: IOException -> L4
        r1.writeInt(Process.myPid());     // Catch: IOException -> L4
        r1.writeInt(Process.myUid());     // Catch: IOException -> L4
        r1.write(BUILD_FINGERPRINT_AND_DEVICE_SERIAL);     // Catch: IOException -> L4
        r1.close();     // Catch: IOException -> L4
        return r0.toByteArray();
    L4:
        e = move-exception;
        throw new SecurityException("Failed to generate seed", e);
    }

    private static String getDeviceSerialNumber() {
        return (String) Build.class.getField("SERIAL").get(null);
    L5:
        return null;
    }

    private static byte[] getBuildFingerprintAndDeviceSerial() {
        StringBuilder r0 = new StringBuilder();
        String r1 = Build.FINGERPRINT;
        if (r1 == null) goto L5;
        r0.append(r1);
    L5:
        String r2 = getDeviceSerialNumber();
        if (r2 == null) goto L12;
        r0.append(r2);
    L12:
        return r0.toString().getBytes("UTF-8");
    L11:
        throw new RuntimeException("UTF-8 encoding not supported");
    }
}
