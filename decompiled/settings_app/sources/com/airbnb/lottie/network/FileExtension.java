package com.airbnb.lottie.network;

import com.airbnb.lottie.utils.Logger;

/* JADX INFO: loaded from: classes.dex */
public final enum FileExtension extends Enum<FileExtension> {
    private static final /* synthetic */ FileExtension[] $VALUES = null;
    public static final FileExtension JSON = null;
    public static final FileExtension ZIP = null;
    public final String extension;

    public static FileExtension valueOf(String r1) {
        return (FileExtension) Enum.valueOf(FileExtension.class, r1);
    }

    public static FileExtension[] values() {
        return (FileExtension[]) $VALUES.clone();
    }

    static {
        FileExtension r0 = new FileExtension("JSON", 0, ".json");
        JSON = r0;
        FileExtension r1 = new FileExtension("ZIP", 1, ".zip");
        ZIP = r1;
        $VALUES = new FileExtension[]{r0, r1};
    }

    private FileExtension(String r1, int r2, String r3) {
        super(r1, r2);
        this.extension = r3;
    }

    public String tempExtension() {
        return ".temp" + this.extension;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.extension;
    }

    public static FileExtension forFile(String r5) {
        FileExtension[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        FileExtension r3 = r0[r2];
        if (r5.endsWith(r3.extension) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L8:
        Logger.warning("Unable to find correct extension for " + r5);
        return JSON;
    }
}
