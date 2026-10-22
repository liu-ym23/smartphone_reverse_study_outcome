package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;

/* JADX INFO: loaded from: classes4.dex */
public final class Version {
    private static final Version[] VERSIONS = null;
    private final int dataRegionSizeColumns;
    private final int dataRegionSizeRows;
    private final ECBlocks ecBlocks;
    private final int symbolSizeColumns;
    private final int symbolSizeRows;
    private final int totalCodewords;
    private final int versionNumber;

    /* JADX INFO: renamed from: com.google.zxing.datamatrix.decoder.Version$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static final class ECB {
        private final int count;
        private final int dataCodewords;

        /* synthetic */ ECB(int r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private ECB(int r1, int r2) {
            this.count = r1;
            this.dataCodewords = r2;
        }

        int getCount() {
            return this.count;
        }

        int getDataCodewords() {
            return this.dataCodewords;
        }
    }

    static final class ECBlocks {
        private final ECB[] ecBlocks;
        private final int ecCodewords;

        /* synthetic */ ECBlocks(int r1, ECB r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        /* synthetic */ ECBlocks(int r1, ECB r2, ECB r3, AnonymousClass1 r4) {
            this(r1, r2, r3);
        }

        private ECBlocks(int r2, ECB r3) {
            this.ecCodewords = r2;
            this.ecBlocks = new ECB[]{r3};
        }

        private ECBlocks(int r2, ECB r3, ECB r4) {
            this.ecCodewords = r2;
            this.ecBlocks = new ECB[]{r3, r4};
        }

        int getECCodewords() {
            return this.ecCodewords;
        }

        ECB[] getECBlocks() {
            return this.ecBlocks;
        }
    }

    static {
        VERSIONS = buildVersions();
    }

    private Version(int r2, int r3, int r4, int r5, int r6, ECBlocks r7) {
        this.versionNumber = r2;
        this.symbolSizeRows = r3;
        this.symbolSizeColumns = r4;
        this.dataRegionSizeRows = r5;
        this.dataRegionSizeColumns = r6;
        this.ecBlocks = r7;
        int r8 = r7.getECCodewords();
        ECB[] r9 = r7.getECBlocks();
        int r10 = r9.length;
        int r11 = 0;
        int r12 = 0;
    L3:
        if (r11 >= r10) goto L5;
        ECB r13 = r9[r11];
        r12 = r12 + (r13.getCount() * (r13.getDataCodewords() + r8));
        r11 = r11 + 1;
        goto L3
    L5:
        this.totalCodewords = r12;
    }

    public int getVersionNumber() {
        return this.versionNumber;
    }

    public int getSymbolSizeRows() {
        return this.symbolSizeRows;
    }

    public int getSymbolSizeColumns() {
        return this.symbolSizeColumns;
    }

    public int getDataRegionSizeRows() {
        return this.dataRegionSizeRows;
    }

    public int getDataRegionSizeColumns() {
        return this.dataRegionSizeColumns;
    }

    public int getTotalCodewords() {
        return this.totalCodewords;
    }

    ECBlocks getECBlocks() {
        return this.ecBlocks;
    }

    public static Version getVersionForDimensions(int r5, int r6) throws FormatException {
        if ((r5 & 1) != 0) goto L17;
        if ((r6 & 1) != 0) goto L17;
        Version[] r0 = VERSIONS;
        int r1 = r0.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L15;
        Version r3 = r0[r2];
        if (r3.symbolSizeRows != r5) goto L13;
        if (r3.symbolSizeColumns != r6) goto L13;
        return r3;
    L13:
        r2 = r2 + 1;
        goto L7
    L15:
        throw FormatException.getFormatInstance();
    L17:
        throw FormatException.getFormatInstance();
    }

    public String toString() {
        return String.valueOf(this.versionNumber);
    }

    private static Version[] buildVersions() {
        int r6 = 8;
        int r10 = 1;
        AnonymousClass1 r12 = null;
        int r13 = 5;
        Version r2 = new Version(3, 14, 14, 12, 12, new ECBlocks(10, new ECB(r10, r6, r12), r12));
        int r3 = 2;
        int r9 = 12;
        int r11 = 18;
        Version r4 = new Version(7, 22, 22, 20, 20, new ECBlocks(20, new ECB(r10, 30, r12), r12));
        int r8 = 6;
        int r5 = 36;
        int r0 = 62;
        int r15 = 56;
        int r14 = 68;
        ECB r7 = new ECB(r10, 5, r12);
        ECB r16 = new ECB(r10, 10, r12);
        ECB r17 = new ECB(r10, 16, r12);
        Version r1 = new Version(29, 16, 36, 14, 16, new ECBlocks(24, new ECB(r10, 32, r12), r12));
        return new Version[]{new Version(1, 10, 10, 8, 8, new ECBlocks(r13, new ECB(r10, 3, r12), r12)), new Version(2, 12, 12, 10, 10, new ECBlocks(7, new ECB(r10, r13, r12), r12)), r2, new Version(4, 16, 16, 14, 14, new ECBlocks(r9, new ECB(r10, r9, r12), r12)), new Version(5, 18, 18, 16, 16, new ECBlocks(14, new ECB(r10, r11, r12), r12)), new Version(6, 20, 20, 18, 18, new ECBlocks(r11, new ECB(r10, 22, r12), r12)), r4, new Version(8, 24, 24, 22, 22, new ECBlocks(24, new ECB(r10, r5, r12), r12)), new Version(9, 26, 26, 24, 24, new ECBlocks(28, new ECB(r10, 44, r12), r12)), new Version(10, 32, 32, 14, 14, new ECBlocks(r5, new ECB(r10, r0, r12), r12)), new Version(11, 36, 36, 16, 16, new ECBlocks(42, new ECB(r10, 86, r12), r12)), new Version(12, 40, 40, 18, 18, new ECBlocks(48, new ECB(r10, 114, r12), r12)), new Version(13, 44, 44, 20, 20, new ECBlocks(r15, new ECB(r10, 144, r12), r12)), new Version(14, 48, 48, 22, 22, new ECBlocks(r14, new ECB(r10, 174, r12), r12)), new Version(15, 52, 52, 24, 24, new ECBlocks(42, new ECB(r3, 102, r12), r12)), new Version(16, 64, 64, 14, 14, new ECBlocks(r15, new ECB(r3, 140, r12), r12)), new Version(17, 72, 72, 16, 16, new ECBlocks(r5, new ECB(4, 92, r12), r12)), new Version(18, 80, 80, 18, 18, new ECBlocks(48, new ECB(4, 114, r12), r12)), new Version(19, 88, 88, 20, 20, new ECBlocks(r15, new ECB(4, 144, r12), r12)), new Version(20, 96, 96, 22, 22, new ECBlocks(r14, new ECB(4, 174, r12), r12)), new Version(21, 104, 104, 24, 24, new ECBlocks(r15, new ECB(r8, 136, r12), r12)), new Version(22, 120, 120, 18, 18, new ECBlocks(r14, new ECB(r8, 175, r12), r12)), new Version(23, 132, 132, 20, 20, new ECBlocks(r0, new ECB(r6, 163, r12), r12)), new Version(24, 144, 144, 22, 22, new ECBlocks(r0, new ECB(r6, 156, r12), new ECB(r3, 155, r12), r12)), new Version(25, 8, 18, 6, 16, new ECBlocks(7, r7, r12)), new Version(26, 8, 32, 6, 14, new ECBlocks(11, r16, r12)), new Version(27, 12, 26, 10, 24, new ECBlocks(14, r17, r12)), new Version(28, 12, 36, 10, 16, new ECBlocks(r11, new ECB(r10, 22, r12), r12)), r1, new Version(30, 16, 48, 14, 22, new ECBlocks(28, new ECB(r10, 49, r12), r12))};
    }
}
