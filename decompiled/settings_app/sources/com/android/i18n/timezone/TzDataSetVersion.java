package com.android.i18n.timezone;

import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class TzDataSetVersion {
    public static final String DEFAULT_FILE_NAME = "tz_version";

    public static class TzDataSetException extends Exception {
        public TzDataSetException(String r1) {
            throw new RuntimeException("Stub!");
        }

        public TzDataSetException(String r1, Throwable r2) {
            throw new RuntimeException("Stub!");
        }
    }

    public TzDataSetVersion(int r1, int r2, String r3, int r4) throws TzDataSetException {
        throw new RuntimeException("Stub!");
    }

    public static int currentFormatMajorVersion() {
        throw new RuntimeException("Stub!");
    }

    public static int currentFormatMinorVersion() {
        throw new RuntimeException("Stub!");
    }

    public static TzDataSetVersion readFromFile(File r1) throws IOException, TzDataSetException {
        throw new RuntimeException("Stub!");
    }

    public int getFormatMajorVersion() {
        throw new RuntimeException("Stub!");
    }

    public int getFormatMinorVersion() {
        throw new RuntimeException("Stub!");
    }

    public String getRulesVersion() {
        throw new RuntimeException("Stub!");
    }

    public int getRevision() {
        throw new RuntimeException("Stub!");
    }

    public byte[] toBytes() {
        throw new RuntimeException("Stub!");
    }

    public static boolean isCompatibleWithThisDevice(TzDataSetVersion r1) {
        throw new RuntimeException("Stub!");
    }

    public boolean equals(Object r1) {
        throw new RuntimeException("Stub!");
    }

    public int hashCode() {
        throw new RuntimeException("Stub!");
    }

    public String toString() {
        throw new RuntimeException("Stub!");
    }
}
