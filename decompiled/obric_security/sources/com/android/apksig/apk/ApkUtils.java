package com.android.apksig.apk;

import com.android.apksig.util.DataSource;
import com.android.apksig.zip.ZipFormatException;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public abstract class ApkUtils {

    public static class ZipSections extends com.android.apksig.zip.ZipSections {
        public ZipSections(long r1, long r3, int r5, long r6, ByteBuffer r8) {
            super(r1, r3, r5, r6, r8);
        }
    }

    private ApkUtils() {
    }

    public static ZipSections findZipSections(DataSource r10) throws IOException, ZipFormatException {
        com.android.apksig.zip.ZipSections r11 = ApkUtilsLite.findZipSections(r10);
        return new ZipSections(r11.getZipCentralDirectoryOffset(), r11.getZipCentralDirectorySizeBytes(), r11.getZipCentralDirectoryRecordCount(), r11.getZipEndOfCentralDirectoryOffset(), r11.getZipEndOfCentralDirectory());
    }
}
