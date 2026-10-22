package com.bytedance.retrofit2.mime;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.common.utility.Logger;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import kotlin.UByte;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TTRequestCompressManager {
    private static final String BLOCK_PATH_EQUAL_KEY = "block_path_equal_list";
    private static final String BLOCK_PATH_REGEX_KEY = "block_path_regex_list";
    private static final String BROTLI_COMPRESS_HEADER = "br";
    private static final String COMPRESS_BROTLI_QUALITY_KEY = "br_level";
    private static final String COMPRESS_ENABLED_KEY = "enabled";
    private static final int COMPRESS_MAX_BODY_SIZE = 1048576;
    private static final String COMPRESS_MAX_BODY_SIZE_KEY = "max_body_size";
    private static final int COMPRESS_MIN_BODY_SIZE = 100;
    private static final String COMPRESS_MIN_BODY_SIZE_KEY = "min_body_size";
    private static final String COMPRESS_REQUEST_KEY = "tt_compress";
    private static final String COMPRESS_REQUEST_TYPE_KEY = "type";
    private static final String COMPRESS_ZSTD_LEVEL_KEY = "zstd_level";
    private static final int DEFAULT_BROTLI_QUALITY = 4;
    private static final int DEFAULT_ZSTD_LEVEL = 6;
    private static final String EQUAL_PATH_KEY = "equal_path";
    private static final String GZIP_COMPRESS_HEADER = "gzip";
    private static final char[] HEX_ARRAY = null;
    private static final String HOST_GROUP_KEY = "host_group";
    private static final int MAX_BROTLI_QUALITY = 11;
    private static final int MAX_ZSTD_LEVEL = 22;
    private static final int MIN_BROTLI_QUALITY = 0;
    private static final int MIN_ZSTD_LEVEL = 1;
    private static final String OPT_ENABLED_KEY = "opt_enabled";
    private static final String PREFIX_PATH_KEY = "prefix_path";
    private static final String REGEX_PATH_KEY = "regex_path";
    private static final String TAG = "TTRequestCompress";
    private static final String ZSTD_COMPRESS_HEADER = "zstd";
    private static final String ZSTD_EQUAL_PATH_KEY = "zstd_equal_path";
    private static final String ZSTD_PREFIX_PATH_KEY = "zstd_prefix_path";
    private static final String ZSTD_REGEX_PATH_KEY = "zstd_regex_path";
    private static AddZstdCompressCallback sAddZstdCompressCallback = null;
    private static CopyOnWriteArraySet<String> sBlockEqualPathArraySet = null;
    private static CopyOnWriteArraySet<Pattern> sBlockPatternPathArraySet = null;
    private static int sBrotliCompressQuality = 4;
    public static volatile CompressDataCallback sCallback = null;
    private static volatile boolean sCompressOptEnabled = false;
    private static CompressType sCompressType = null;
    private static CopyOnWriteArraySet<String> sEqualPathArraySet = null;
    public static volatile Boolean sGlobalCompressDisabled = null;
    private static CopyOnWriteArraySet<String> sHostGroupArraySet = null;
    private static int sMaxBodyCompressSize = 1048576;
    private static int sMinBodyCompressSize = 100;
    private static CopyOnWriteArraySet<String> sPrefixPathArraySet = null;
    private static CopyOnWriteArraySet<Pattern> sRegexPathArraySet = null;
    private static volatile boolean sRequestCompressEnabled = false;
    private static int sZstdCompressLevel = 6;
    private static CopyOnWriteArraySet<String> sZstdEqualPathArraySet;
    private static CopyOnWriteArraySet<String> sZstdPrefixPathArraySet;
    private static CopyOnWriteArraySet<Pattern> sZstdRegexPathArraySet;

    public interface AddZstdCompressCallback {
        byte[] compress(byte[] r1, int r2);

        byte[] decompress(byte[] r1, int r2);
    }

    public static class CompressData {
        public String contentEncoding;
        public byte[] data;
        public int failedCode;
        public String failedPrefixData;
        public CompressType type;

        CompressData(int r1) {
            this.failedCode = r1;
        }
    }

    public interface CompressDataCallback {
        byte[] compressData(byte[] r1, int r2, int r3, int r4);

        byte[] decompressData(byte[] r1, int r2, int r3);
    }

    public static final enum CompressType extends Enum<CompressType> {
        private static final /* synthetic */ CompressType[] $VALUES = null;
        public static final CompressType BROTLI = null;
        public static final CompressType GZIP = null;
        public static final CompressType NONE = null;
        public static final CompressType ZSTD = null;
        private final int mType;

        public static CompressType valueOf(String r1) {
            return (CompressType) Enum.valueOf(CompressType.class, r1);
        }

        public static CompressType[] values() {
            return (CompressType[]) $VALUES.clone();
        }

        static {
            CompressType r0 = new CompressType("NONE", 0, 0);
            NONE = r0;
            CompressType r1 = new CompressType("GZIP", 1, 1);
            GZIP = r1;
            CompressType r3 = new CompressType("BROTLI", 2, 2);
            BROTLI = r3;
            CompressType r5 = new CompressType("ZSTD", 3, 3);
            ZSTD = r5;
            $VALUES = new CompressType[]{r0, r1, r3, r5};
        }

        private CompressType(String r1, int r2, int r3) {
            super(r1, r2);
            this.mType = r3;
        }

        public int getType() {
            return this.mType;
        }
    }

    public static final enum DisableCompress extends Enum<DisableCompress> {
        private static final /* synthetic */ DisableCompress[] $VALUES = null;
        public static final DisableCompress BODY_ENCRYPTED = null;
        public static final DisableCompress BODY_SIZE_MISMATCH = null;
        public static final DisableCompress BODY_SIZE_OVERFLOW = null;
        public static final DisableCompress DATA_NULL = null;
        public static final DisableCompress GLOBAL_DISABLE = null;
        public static final DisableCompress GZIP_PREFIX_MISMATCH = null;
        public static final DisableCompress NONE = null;
        public static final DisableCompress REMOVE_ENCODING = null;
        public static final DisableCompress TNC_DISABLE = null;
        public static final DisableCompress URL_MISMATCH = null;
        public static final DisableCompress ZSTD_PREFIX_MISMATCH = null;
        private final int reason;

        public static DisableCompress valueOf(String r1) {
            return (DisableCompress) Enum.valueOf(DisableCompress.class, r1);
        }

        public static DisableCompress[] values() {
            return (DisableCompress[]) $VALUES.clone();
        }

        static {
            DisableCompress r0 = new DisableCompress("NONE", 0, 0);
            NONE = r0;
            DisableCompress r1 = new DisableCompress("GLOBAL_DISABLE", 1, 1);
            GLOBAL_DISABLE = r1;
            DisableCompress r3 = new DisableCompress("TNC_DISABLE", 2, 2);
            TNC_DISABLE = r3;
            DisableCompress r5 = new DisableCompress("URL_MISMATCH", 3, 3);
            URL_MISMATCH = r5;
            DisableCompress r7 = new DisableCompress("BODY_SIZE_MISMATCH", 4, 4);
            BODY_SIZE_MISMATCH = r7;
            DisableCompress r9 = new DisableCompress("BODY_SIZE_OVERFLOW", 5, 5);
            BODY_SIZE_OVERFLOW = r9;
            DisableCompress r11 = new DisableCompress("ZSTD_PREFIX_MISMATCH", 6, 6);
            ZSTD_PREFIX_MISMATCH = r11;
            DisableCompress r13 = new DisableCompress("GZIP_PREFIX_MISMATCH", 7, 7);
            GZIP_PREFIX_MISMATCH = r13;
            DisableCompress r15 = new DisableCompress("BODY_ENCRYPTED", 8, 8);
            BODY_ENCRYPTED = r15;
            DisableCompress r14 = new DisableCompress("REMOVE_ENCODING", 9, 9);
            REMOVE_ENCODING = r14;
            DisableCompress r12 = new DisableCompress("DATA_NULL", 10, 10);
            DATA_NULL = r12;
            $VALUES = new DisableCompress[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12};
        }

        private DisableCompress(String r1, int r2, int r3) {
            super(r1, r2);
            this.reason = r3;
        }

        public int getReason() {
            return this.reason;
        }
    }

    public TTRequestCompressManager() {
    }

    static {
        sCompressType = CompressType.NONE;
        sEqualPathArraySet = new CopyOnWriteArraySet();
        sPrefixPathArraySet = new CopyOnWriteArraySet();
        sRegexPathArraySet = new CopyOnWriteArraySet();
        sZstdEqualPathArraySet = new CopyOnWriteArraySet();
        sZstdPrefixPathArraySet = new CopyOnWriteArraySet();
        sZstdRegexPathArraySet = new CopyOnWriteArraySet();
        sHostGroupArraySet = new CopyOnWriteArraySet();
        sBlockEqualPathArraySet = new CopyOnWriteArraySet();
        sBlockPatternPathArraySet = new CopyOnWriteArraySet();
        sGlobalCompressDisabled = false;
        HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    }

    private static void resetCompressConfig() {
        sRequestCompressEnabled = false;
        sMaxBodyCompressSize = 1048576;
        sMinBodyCompressSize = 100;
        sCompressType = CompressType.NONE;
        sEqualPathArraySet.clear();
        sPrefixPathArraySet.clear();
        sRegexPathArraySet.clear();
        sZstdEqualPathArraySet.clear();
        sZstdPrefixPathArraySet.clear();
        sZstdRegexPathArraySet.clear();
        sHostGroupArraySet.clear();
        sBlockEqualPathArraySet.clear();
        sBlockPatternPathArraySet.clear();
    }

    public static boolean isBodyOptEnabled() {
        return sCompressOptEnabled;
    }

    public static void onServerConfigChanged(JSONObject r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        resetCompressConfig();
        JSONObject r4 = r3.optJSONObject(COMPRESS_REQUEST_KEY);
        if (r4 != null) goto L7;
        return;
    L7:
        boolean r1 = false;
        if (r4.optInt(COMPRESS_ENABLED_KEY, 0) <= 0) goto L10;
        boolean r0 = true;
    L11:
        sRequestCompressEnabled = r0;
        if (r4.optInt(OPT_ENABLED_KEY, 0) <= 0) goto L14;
        r1 = true;
    L14:
        sCompressOptEnabled = r1;
        sMaxBodyCompressSize = r4.optInt(COMPRESS_MAX_BODY_SIZE_KEY, 1048576);
        sMinBodyCompressSize = r4.optInt(COMPRESS_MIN_BODY_SIZE_KEY, 100);
        int r2 = r4.optInt(COMPRESS_BROTLI_QUALITY_KEY, 4);
        if (r2 >= 0) goto L17;
    L19:
        int r5 = r4.optInt(COMPRESS_ZSTD_LEVEL_KEY, 6);
        if (r5 >= 1) goto L22;
    L24:
        int r6 = r4.optInt("type", CompressType.GZIP.getType());
        covertIntToCompressType(r6);
        parseArraySetStringConfig(r4.optJSONArray(EQUAL_PATH_KEY), sEqualPathArraySet);
        parseArraySetStringConfig(r4.optJSONArray(PREFIX_PATH_KEY), sPrefixPathArraySet);
        parseArraySetPatternConfig(r4.optJSONArray(REGEX_PATH_KEY), sRegexPathArraySet);
        parseArraySetStringConfig(r4.optJSONArray(ZSTD_EQUAL_PATH_KEY), sZstdEqualPathArraySet);
        parseArraySetStringConfig(r4.optJSONArray(ZSTD_PREFIX_PATH_KEY), sZstdPrefixPathArraySet);
        parseArraySetPatternConfig(r4.optJSONArray(ZSTD_REGEX_PATH_KEY), sZstdRegexPathArraySet);
        parseArraySetStringConfig(r4.optJSONArray(HOST_GROUP_KEY), sHostGroupArraySet);
        parseArraySetStringConfig(r4.optJSONArray(BLOCK_PATH_EQUAL_KEY), sBlockEqualPathArraySet);
        parseArraySetPatternConfig(r4.optJSONArray(BLOCK_PATH_REGEX_KEY), sBlockPatternPathArraySet);
        if (Logger.debug() == false) goto L28;
        Log.d(TAG, "sRequestCompressEnabled:" + sRequestCompressEnabled + " type:" + r6);
        return;
    L28:
        return;
    L22:
        if (r5 > 22) goto L24;
        sZstdCompressLevel = r5;
        goto L24
    L17:
        if (r2 > 11) goto L19;
        sBrotliCompressQuality = r2;
        goto L19
    L10:
        r0 = false;
        goto L11
    }

    private static void parseArraySetStringConfig(JSONArray r3, CopyOnWriteArraySet<String> r4) {
        if (r3 == null) goto L12;
        if (r4 == null) goto L19;
        int r0 = 0;
    L14:
        if (r0 >= r3.length()) goto L21;
        String r1 = r3.getString(r0);     // Catch: JSONException -> L13
        if (TextUtils.isEmpty(r1) == true) goto L11;
        r4.add(r1);     // Catch: JSONException -> L13
    L11:
        r0 = r0 + 1;
        goto L14
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }

    private static void parseArraySetPatternConfig(JSONArray r3, CopyOnWriteArraySet<Pattern> r4) {
        if (r3 == null) goto L13;
        if (r4 == null) goto L23;
        int r0 = 0;
    L16:
        if (r0 >= r3.length()) goto L25;
        String r1 = r3.getString(r0);     // Catch: JSONException -> L15
        if (TextUtils.isEmpty(r1) == true) goto L12;
        r4.add(Pattern.compile(r1, 2));     // Catch: Throwable -> L14
    L12:
        r0 = r0 + 1;
        goto L16
    L25:
        return;
    L24:
        return;
    L23:
        return;
    }

    private static void covertIntToCompressType(int r1) {
        if (r1 != 1) goto L5;
        sCompressType = CompressType.GZIP;
        return;
    L5:
        if (r1 != 2) goto L7;
        sCompressType = CompressType.BROTLI;
        return;
    L7:
        if (r1 == 3) goto L9;
        sCompressType = CompressType.NONE;
        return;
    L9:
        sCompressType = CompressType.ZSTD;
    }

    public static void setCompressDataCallback(CompressDataCallback r0) {
        sCallback = r0;
    }

    public static void setGlobalForbidenCompress() {
        sGlobalCompressDisabled = true;
    }

    private static CompressType getCompressType(String r2, String r3) {
        if (TextUtils.isEmpty(r2) == true) goto L86;
        if (TextUtils.isEmpty(r3) == true) goto L86;
        if (isEmptySet(sZstdEqualPathArraySet) == true) goto L14;
        if (sZstdEqualPathArraySet.contains(r3) == false) goto L14;
        return CompressType.ZSTD;
    L14:
        if (isEmptySet(sZstdPrefixPathArraySet) == true) goto L23;
        Iterator<String> r0 = sZstdPrefixPathArraySet.iterator();
    L17:
        if (r0.hasNext() == false) goto L23;
        if (r3.startsWith(r0.next()) == false) goto L17;
        return CompressType.ZSTD;
    L23:
        if (isEmptySet(sZstdRegexPathArraySet) == true) goto L34;
        Iterator<Pattern> r1 = sZstdRegexPathArraySet.iterator();
    L26:
        if (r1.hasNext() == false) goto L34;
        Pattern r4 = r1.next();
        if (r4 == null) goto L26;
        if (r4.matcher(r3).matches() == false) goto L26;
        return CompressType.ZSTD;
    L34:
        if (isEmptySet(sEqualPathArraySet) == true) goto L40;
        if (sEqualPathArraySet.contains(r3) == false) goto L40;
        return sCompressType;
    L40:
        if (isEmptySet(sPrefixPathArraySet) == true) goto L49;
        Iterator<String> r5 = sPrefixPathArraySet.iterator();
    L43:
        if (r5.hasNext() == false) goto L49;
        if (r3.startsWith(r5.next()) == false) goto L43;
        return sCompressType;
    L49:
        if (isEmptySet(sRegexPathArraySet) == true) goto L60;
        Iterator<Pattern> r6 = sRegexPathArraySet.iterator();
    L52:
        if (r6.hasNext() == false) goto L60;
        Pattern r7 = r6.next();
        if (r7 == null) goto L52;
        if (r7.matcher(r3).matches() == false) goto L52;
        return sCompressType;
    L60:
        if (isEmptySet(sHostGroupArraySet) == true) goto L84;
        if (isHostMatch(r2) == false) goto L84;
        if (isEmptySet(sBlockEqualPathArraySet) == true) goto L71;
        if (sBlockEqualPathArraySet.contains(r3) == false) goto L71;
        return CompressType.NONE;
    L71:
        if (isEmptySet(sBlockPatternPathArraySet) == true) goto L82;
        Iterator<Pattern> r8 = sBlockPatternPathArraySet.iterator();
    L74:
        if (r8.hasNext() == false) goto L82;
        Pattern r9 = r8.next();
        if (r9 == null) goto L74;
        if (r9.matcher(r3).matches() == false) goto L74;
        return CompressType.NONE;
    L82:
        return sCompressType;
    L84:
        return CompressType.NONE;
    L86:
        return CompressType.NONE;
    }

    private static boolean isHostMatch(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return false;
    L5:
        Iterator<String> r0 = sHostGroupArraySet.iterator();
    L7:
        if (r0.hasNext() == false) goto L15;
        if (matchPattern(r3, r0.next()) == false) goto L7;
        return true;
    L15:
        return false;
    }

    private static boolean isEmptySet(Set<?> r0) {
        if (r0 != null) goto L4;
        return true;
    L4:
        if (r0.isEmpty() == true) goto L10;
        return false;
    L10:
        return true;
    }

    public static CompressData compressBody(byte[] r4, int r5, String r6, String r7, boolean r8) {
        CompressData r0 = new CompressData(0);
        if (sGlobalCompressDisabled.booleanValue() == false) goto L10;
        if (Logger.debug() == false) goto L7;
        Log.d(TAG, "global compress is disabled.");
    L7:
        r0.failedCode = DisableCompress.GLOBAL_DISABLE.getReason();
        return r0;
    L10:
        if (sRequestCompressEnabled == false) goto L57;
        if (sCompressType == CompressType.NONE) goto L57;
        CompressType r1 = getCompressType(r6, r7);
        if (r8 == true) goto L24;
        if (r1 != CompressType.NONE) goto L24;
        if (Logger.debug() == false) goto L21;
        Log.d(TAG, "Url is not matched:" + r6 + r7);
    L21:
        r0.failedCode = DisableCompress.URL_MISMATCH.getReason();
        return r0;
    L24:
        if (r5 > sMaxBodyCompressSize) goto L52;
        if (r5 < sMinBodyCompressSize) goto L52;
        if (r1 != CompressType.GZIP) goto L36;
        byte[] r9 = gzipCompress(r4, r5);
        if (canUseCompressedBody(r5, r9, r1, r0) == true) goto L33;
        return r0;
    L33:
        r0.data = r9;
        r0.type = r1;
        r0.contentEncoding = "gzip";
        return r0;
    L36:
        if (r1 != CompressType.BROTLI) goto L43;
        byte[] r10 = brotliCompress(r4, r5, sBrotliCompressQuality);
        if (canUseCompressedBody(r5, r10, r1, r0) == true) goto L40;
        return r0;
    L40:
        r0.data = r10;
        r0.type = r1;
        r0.contentEncoding = BROTLI_COMPRESS_HEADER;
        return r0;
    L43:
        if (r1 != CompressType.ZSTD) goto L49;
        byte[] r11 = zstdCompress(r4, sZstdCompressLevel);
        if (canUseCompressedBody(r5, r11, r1, r0) == true) goto L47;
        return r0;
    L47:
        r0.data = r11;
        r0.type = r1;
        r0.contentEncoding = "zstd";
        return r0;
    L49:
        return null;
    L52:
        if (Logger.debug() == false) goto L54;
        Log.d(TAG, "Request body size is not matched:" + r5);
    L54:
        r0.failedCode = DisableCompress.BODY_SIZE_MISMATCH.getReason();
        return r0;
    L57:
        if (Logger.debug() == false) goto L59;
        Log.d(TAG, "Request compress is disabled.");
    L59:
        r0.failedCode = DisableCompress.TNC_DISABLE.getReason();
        return r0;
    }

    private static String byteArrayToHexString(byte[] r6) {
        char[] r0 = new char[r6.length * 2];
        int r1 = 0;
    L4:
        if (r1 >= r6.length) goto L7;
        int r2 = r6[r1] & UByte.MAX_VALUE;
        int r3 = r1 * 2;
        char[] r4 = HEX_ARRAY;
        r0[r3] = r4[r2 >>> 4];
        r0[r3 + 1] = r4[r2 & 15];
        r1 = r1 + 1;
        goto L4
    L7:
        return new String(r0);
    }

    public static boolean canUseCompressedBody(int r5, byte[] r6, CompressType r7, CompressData r8) {
        if (r6 != null) goto L5;
    L37:
        return false;
    L5:
        if (r6.length <= 3) goto L37;
        if (sCompressOptEnabled == true) goto L11;
        return true;
    L11:
        if (r6.length < r5) goto L15;
        r8.failedCode = DisableCompress.BODY_SIZE_OVERFLOW.getReason();
        return false;
    L15:
        if (r7 != CompressType.GZIP) goto L26;
        byte r9 = r6[0];
        byte r10 = r6[1];
        byte r11 = r6[2];
        if (r9 == 31) goto L19;
    L23:
        r8.failedCode = DisableCompress.GZIP_PREFIX_MISMATCH.getReason();
        r8.failedPrefixData = byteArrayToHexString(new byte[]{r9, r10, r11});
        return false;
    L19:
        if (r10 != (-117)) goto L23;
        if (r11 != 8) goto L23;
        return true;
    L26:
        if (r7 != CompressType.ZSTD) goto L36;
        byte r12 = r6[0];
        byte r13 = r6[1];
        byte r14 = r6[2];
        if (r12 == 40) goto L30;
    L34:
        r8.failedCode = DisableCompress.ZSTD_PREFIX_MISMATCH.getReason();
        r8.failedPrefixData = byteArrayToHexString(new byte[]{r12, r13, r14});
        return false;
    L30:
        if (r13 != (-75)) goto L34;
        if (r14 != 47) goto L34;
        return true;
    L36:
        return true;
    }

    public static byte[] brotliCompress(byte[] r2, int r3, int r4) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if (sCallback != null) goto L8;
        return null;
    L8:
        return sCallback.compressData(r2, r3, r4, CompressType.BROTLI.getType());
    }

    public static byte[] brotliDecompress(byte[] r2, int r3) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if (sCallback != null) goto L8;
        return null;
    L8:
        return sCallback.decompressData(r2, r3, CompressType.BROTLI.getType());
    }

    public static byte[] gzipCompress(byte[] r5, int r6) {
        GZIPOutputStream r0 = null;
        if (r5 != null) goto L5;
        return null;
    L5:
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();
        GZIPOutputStream r2 = new GZIPOutputStream(r1);     // Catch: Throwable -> L16 IOException -> L18
        r2.write(r5);     // Catch: IOException -> L14 Throwable -> L29
        r2.close();     // Catch: IOException -> L10
        r1.close();     // Catch: IOException -> L10
    L13:
        return r1.toByteArray();
    L10:
        e = move-exception;
        e.printStackTrace();
    L14:
        e = e;
    L20:
        Log.w(TAG, "Compress with gzip exception: " + e);     // Catch: Throwable -> L29
        if (r2 != null) goto L45;
    L25:
        r1.close();     // Catch: IOException -> L23
    L28:
        return null;
    L23:
        e = move-exception;
        e.printStackTrace();
        goto L28
    L45:
        r2.close();     // Catch: IOException -> L23
    L29:
        th = th;
        r0 = r2;
    L31:
        if (r0 != null) goto L41;
    L35:
        r1.close();     // Catch: IOException -> L33
    L38:
        throw th;
    L33:
        e = move-exception;
        e.printStackTrace();
        goto L38
    L41:
        r0.close();     // Catch: IOException -> L33
        goto L35
    L18:
        e = e;
        r2 = null;
    L16:
        th = th;
        goto L31
    }

    public static byte[] gzipDecompress(byte[] r6) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        GZIPInputStream r1 = null;
        GZIPInputStream r2 = new GZIPInputStream(new ByteArrayInputStream(r6));     // Catch: Throwable -> L18 IOException -> L20
    L47:
        byte[] r7 = new byte[4096];     // Catch: IOException -> L16 Throwable -> L31
    L6:
        int r3 = r2.read(r7);     // Catch: IOException -> L16 Throwable -> L31
        if (r3 < 0) goto L43;
        r0.write(r7, 0, r3);     // Catch: IOException -> L16 Throwable -> L31
        goto L6
    L43:
        r2.close();     // Catch: IOException -> L12
        r0.close();     // Catch: IOException -> L12
    L15:
        return r0.toByteArray();
    L12:
        e = move-exception;
        e.printStackTrace();
    L16:
        e = e;
    L22:
        Log.w(TAG, "Decompress with gzip exception: " + e);     // Catch: Throwable -> L31
        if (r2 != null) goto L45;
    L27:
        r0.close();     // Catch: IOException -> L25
    L30:
        return null;
    L25:
        e = move-exception;
        e.printStackTrace();
        goto L30
    L45:
        r2.close();     // Catch: IOException -> L25
    L31:
        th = th;
        r1 = r2;
    L33:
        if (r1 != null) goto L41;
    L37:
        r0.close();     // Catch: IOException -> L35
    L40:
        throw th;
    L35:
        e = move-exception;
        e.printStackTrace();
        goto L40
    L41:
        r1.close();     // Catch: IOException -> L35
    L20:
        e = e;
        r2 = null;
    L18:
        th = th;
        goto L33
    }

    public static void setAddZstdCompressCallback(AddZstdCompressCallback r0) {
        sAddZstdCompressCallback = r0;
    }

    public static byte[] zstdCompress(byte[] r1, int r2) {
        AddZstdCompressCallback r0 = sAddZstdCompressCallback;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.compress(r1, r2);
    }

    public static byte[] zstdDecompress(byte[] r1, int r2) {
        AddZstdCompressCallback r0 = sAddZstdCompressCallback;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.decompress(r1, r2);
    }

    public static byte[] decompressDataByType(byte[] r2, String r3, int r4) {
        if (r2 != null) goto L4;
        return r2;
    L4:
        if (TextUtils.isEmpty(r3) == true) goto L30;
        r3.hashCode();
        byte r1 = -1;
        switch(r3.hashCode()) {
            case 3152: goto L18;
            case 3189082: goto L14;
            case 3748713: goto L10;
            default: goto L21;
        };
    L21:
        switch(r1) {
            case 0: goto L28;
            case 1: goto L26;
            case 2: goto L24;
            default: goto L22;
        };
    L22:
        return r2;
    L24:
        return zstdDecompress(r2, r4);
    L26:
        return gzipDecompress(r2);
    L28:
        return brotliDecompress(r2, r2.length);
    L10:
        if (r3.equals("zstd") == false) goto L21;
        r1 = 2;
        goto L21
    L14:
        if (r3.equals("gzip") == false) goto L21;
        r1 = 1;
        goto L21
    L18:
        if (r3.equals(BROTLI_COMPRESS_HEADER) == false) goto L21;
        r1 = 0;
        goto L21
    L30:
        return r2;
    }

    private static boolean matchPattern(String r12, String r13) {
        if (r12 == null) goto L29;
        if (r13 == null) goto L29;
        int r1 = r12.length();
        int r2 = r13.length();
        int r4 = 0;
        int r5 = 0;
        int r6 = -1;
        int r7 = -1;
    L8:
        if (r4 >= r1) goto L22;
        if (r5 >= r2) goto L15;
        if (r13.charAt(r5) == '?') goto L14;
        if (r13.charAt(r5) != r12.charAt(r4)) goto L15;
    L14:
        r4 = r4 + 1;
        r5 = r5 + 1;
    L15:
        if (r5 >= r2) goto L19;
        if (r13.charAt(r5) != '*') goto L19;
        r7 = r4;
        r6 = r5;
        r5 = r5 + 1;
    L19:
        if (r6 == (-1)) goto L20;
        r5 = r6 + 1;
        r7 = r7 + 1;
        r4 = r7;
        goto L8
    L20:
        return false;
    L22:
        if (r5 >= r2) goto L27;
        if (r13.charAt(r5) != '*') goto L25;
        r5 = r5 + 1;
        goto L22
    L25:
        return false;
    L27:
        return true;
    L29:
        return false;
    }
}
