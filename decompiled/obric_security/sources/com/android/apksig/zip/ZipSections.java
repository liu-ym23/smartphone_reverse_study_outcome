package com.android.apksig.zip;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class ZipSections {
    private final long mCentralDirectoryOffset;
    private final int mCentralDirectoryRecordCount;
    private final long mCentralDirectorySizeBytes;
    private final ByteBuffer mEocd;
    private final long mEocdOffset;

    public ZipSections(long r1, long r3, int r5, long r6, ByteBuffer r8) {
        this.mCentralDirectoryOffset = r1;
        this.mCentralDirectorySizeBytes = r3;
        this.mCentralDirectoryRecordCount = r5;
        this.mEocdOffset = r6;
        this.mEocd = r8;
    }

    public long getZipCentralDirectoryOffset() {
        return this.mCentralDirectoryOffset;
    }

    public int getZipCentralDirectoryRecordCount() {
        return this.mCentralDirectoryRecordCount;
    }

    public long getZipCentralDirectorySizeBytes() {
        return this.mCentralDirectorySizeBytes;
    }

    public ByteBuffer getZipEndOfCentralDirectory() {
        return this.mEocd;
    }

    public long getZipEndOfCentralDirectoryOffset() {
        return this.mEocdOffset;
    }
}
