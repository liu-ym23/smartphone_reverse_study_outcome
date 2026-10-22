package com.bytedance.common.utility;

import java.io.File;
import tmsdk.common.tcc.DeepCleanSAFEngine;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class DigestUtils {
    private static final int BYTE_RANGE = 8192;
    static final char[] HEX_CHARS = null;
    private static final int MAX_STRING = 4;
    private static final int RADIX = 16;
    private static final int RADIX_OFFSET = 4;
    private static final int STRING_MASK_F = 15;
    private static final int STRING_MASK_FF = 255;

    static {
        HEX_CHARS = new char[]{DeepCleanSAFEngine.DetailPath.KEY, DeepCleanSAFEngine.DetailPath.DETAIL_PATH, DeepCleanSAFEngine.DetailPath.FILENAME, DeepCleanSAFEngine.DetailPath.FILESIZE, DeepCleanSAFEngine.DetailPath.CTIME, DeepCleanSAFEngine.DetailPath.MTIME, DeepCleanSAFEngine.DetailPath.ATIME, DeepCleanSAFEngine.DetailPath.IMPORTANT, '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    private DigestUtils() {
    }

    public static String toHexString(byte[] r0) {
        return com.bytedance.android.standard.tools.security.DigestUtils.toHexString(r0);
    }

    public static String toHexString(byte[] r0, int r1, int r2) {
        return com.bytedance.android.standard.tools.security.DigestUtils.toHexString(r0, r1, r2);
    }

    public static byte[] hexStringToBytes(String r0) throws IllegalArgumentException {
        return com.bytedance.android.standard.tools.security.DigestUtils.hexStringToBytes(r0);
    }

    public static String md5Hex(File r0) {
        return com.bytedance.android.standard.tools.security.DigestUtils.md5Hex(r0);
    }

    public static String md5Hex(String r0) {
        return com.bytedance.android.standard.tools.security.DigestUtils.md5Hex(r0);
    }

    public static String md5Hex(byte[] r0) {
        return com.bytedance.android.standard.tools.security.DigestUtils.md5Hex(r0);
    }

    public static String md5Hex(byte[] r0, int r1, int r2) {
        return com.bytedance.android.standard.tools.security.DigestUtils.md5Hex(r0, r1, r2);
    }
}
