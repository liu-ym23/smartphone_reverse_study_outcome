package com.bytedance.common.utility.io;

import android.content.Context;
import com.bytedance.networkstackapplib.NetworkStackConstant;
import com.qq.taf.jce.JceStruct;
import java.io.File;
import java.io.InputStream;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class FileUtils {
    private static final byte[] GIF87A = null;
    private static final byte[] GIF89A = null;
    private static final byte[] JPEG = null;
    private static final byte[] PNG = null;
    private static final String TAG = "FileUtils";

    /* JADX INFO: renamed from: com.bytedance.common.utility.io.FileUtils$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$android$standard$tools$file$FileUtils$ImageType = null;

        static {
            int[] r0 = new int[com.bytedance.android.standard.tools.file.FileUtils.ImageType.values().length];
            $SwitchMap$com$bytedance$android$standard$tools$file$FileUtils$ImageType = r0;
            r0[com.bytedance.android.standard.tools.file.FileUtils.ImageType.UNKNOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$bytedance$android$standard$tools$file$FileUtils$ImageType[com.bytedance.android.standard.tools.file.FileUtils.ImageType.JPG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$bytedance$android$standard$tools$file$FileUtils$ImageType[com.bytedance.android.standard.tools.file.FileUtils.ImageType.PNG.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$bytedance$android$standard$tools$file$FileUtils$ImageType[com.bytedance.android.standard.tools.file.FileUtils.ImageType.GIF.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static final enum ImageType extends Enum<ImageType> {
        private static final /* synthetic */ ImageType[] $VALUES = null;
        public static final ImageType GIF = null;
        public static final ImageType JPG = null;
        public static final ImageType PNG = null;
        public static final ImageType UNKNOWN = null;

        private ImageType(String r1, int r2) {
            super(r1, r2);
        }

        public static ImageType valueOf(String r1) {
            return (ImageType) Enum.valueOf(ImageType.class, r1);
        }

        public static ImageType[] values() {
            return (ImageType[]) $VALUES.clone();
        }

        static {
            ImageType r0 = new ImageType(NetworkStackConstant.UNKNOWN_TYPE, 0);
            UNKNOWN = r0;
            ImageType r1 = new ImageType("JPG", 1);
            JPG = r1;
            ImageType r3 = new ImageType("PNG", 2);
            PNG = r3;
            ImageType r5 = new ImageType("GIF", 3);
            GIF = r5;
            $VALUES = new ImageType[]{r0, r1, r3, r5};
        }
    }

    private static ImageType getOldImageType(com.bytedance.android.standard.tools.file.FileUtils.ImageType r2) {
        ImageType r0 = ImageType.UNKNOWN;
        int r3 = AnonymousClass1.$SwitchMap$com$bytedance$android$standard$tools$file$FileUtils$ImageType[r2.ordinal()];
        if (r3 == 1) goto L15;
        if (r3 == 2) goto L18;
        if (r3 == 3) goto L17;
        if (r3 == 4) goto L16;
        return r0;
    L16:
        return ImageType.GIF;
    L17:
        return ImageType.PNG;
    L18:
        return ImageType.JPG;
    L15:
        return ImageType.UNKNOWN;
    }

    static {
        GIF87A = new byte[]{71, 73, 70, 56, 55, 97};
        GIF89A = new byte[]{71, 73, 70, 56, 57, 97};
        JPEG = new byte[]{-1, -40, -1};
        PNG = new byte[]{-119, 80, 78, 71, JceStruct.SIMPLE_LIST, 10, 26, 10};
    }

    private FileUtils() {
    }

    public static InputStream getInputStream(String r0) {
        return com.bytedance.android.standard.tools.file.FileUtils.getInputStream(r0);
    }

    public static byte[] getByteArray(String r0) {
        return com.bytedance.android.standard.tools.file.FileUtils.getByteArray(r0);
    }

    public static boolean copyFile(String r0, String r1, String r2) {
        return com.bytedance.android.standard.tools.file.FileUtils.copyFile(r0, r1, r2);
    }

    public static boolean saveInputStream(InputStream r0, String r1, String r2) {
        return com.bytedance.android.standard.tools.file.FileUtils.saveInputStream(r0, r1, r2);
    }

    public static ImageType getImageType(String r0) {
        return getOldImageType(com.bytedance.android.standard.tools.file.FileUtils.getImageType(r0));
    }

    public static ImageType getImageType(File r0) {
        return getOldImageType(com.bytedance.android.standard.tools.file.FileUtils.getImageType(r0));
    }

    public static boolean isGif(File r0) {
        return com.bytedance.android.standard.tools.file.FileUtils.isGif(r0);
    }

    public static boolean exists(String r0) {
        return com.bytedance.android.standard.tools.file.FileUtils.exists(r0);
    }

    private static boolean checkSignature(byte[] r4, byte[] r5) {
        if (r4 == null) goto L17;
        if (r5 == null) goto L18;
        int r1 = 0;
    L8:
        if (r1 >= r5.length) goto L13;
        if (r4[r1] != r5[r1]) goto L19;
        r1 = r1 + 1;
        goto L8
    L19:
        return false;
    L13:
        return true;
    L18:
        return false;
    L17:
        return false;
    }

    public static void chmod(String r0, int r1) {
        com.bytedance.android.standard.tools.file.FileUtils.chmod(r0, r1);
    }

    public static String getFileNameWithoutExtension(String r0) {
        return com.bytedance.android.standard.tools.file.FileUtils.getFileNameWithoutExtension(r0);
    }

    public static String getExtension(String r0) {
        return com.bytedance.android.standard.tools.file.FileUtils.getExtension(r0);
    }

    public static void clearDir(String r0) throws Exception {
        com.bytedance.android.standard.tools.file.FileUtils.clearDir(r0);
    }

    public static void removeDir(String r0) throws Exception {
        com.bytedance.android.standard.tools.file.FileUtils.removeDir(r0);
    }

    public static void clearDir(String r0, Set<String> r1) throws Exception {
        com.bytedance.android.standard.tools.file.FileUtils.clearDir(r0, r1);
    }

    public static void removeDir(String r0, Set<String> r1) throws Exception {
        com.bytedance.android.standard.tools.file.FileUtils.removeDir(r0, r1);
    }

    public static long getDirectorySize(File r0, boolean r1) {
        return com.bytedance.android.standard.tools.file.FileUtils.getDirectorySize(r0, r1);
    }

    public static String getCacheDirPath(Context r0) throws NullPointerException {
        return com.bytedance.android.standard.tools.file.FileUtils.getCacheDirPath(r0);
    }

    public static String getFilesDirPath(Context r0) throws NullPointerException {
        return com.bytedance.android.standard.tools.file.FileUtils.getFilesDirPath(r0);
    }

    public static boolean isExternalStorageWritable() {
        return com.bytedance.android.standard.tools.file.FileUtils.isExternalStorageWritable();
    }

    public static boolean isExternalStorageReadable() {
        return com.bytedance.android.standard.tools.file.FileUtils.isExternalStorageReadable();
    }
}
