package com.bytedance.frameworks.baselib.network.http.parser;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.RequestHandler;
import com.bytedance.frameworks.baselib.network.http.util.ByteArrayBuffer;
import com.bytedance.frameworks.baselib.network.http.util.DownloadFileTooLargeException;
import com.bytedance.frameworks.baselib.network.http.util.IDownloadPublisher;
import com.bytedance.frameworks.baselib.network.http.util.TaskInfo;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.mime.MimeUtil;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.URI;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPInputStream;
import okio.Buffer;
import okio.BufferedSource;
import okio.Okio;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class StreamParser {
    private static final String CONTENT_ENCODING = "Content-Encoding";
    public static final String CONTENT_TYPE_OCTET = "application/octet-stream";
    private static final String KEY_READ_RESPONSE_BUFF_INCREASE_SIZE = "read_response_buff_increase_size";
    private static final String KEY_READ_RESPONSE_BUFF_INIT_SIZE = "read_response_buff_init_size";
    private static final String KEY_SPECIFIC_READ_RESPONSE_BUFF_INIT_SIZE = "specific_init_size";
    private static final int MAX_API_RESPONSE_LENGTH = 5242880;
    private static final int READ_RESPONSE_FIRST_INCREASE_SIZE = 102400;
    private static final int READ_RESPONSE_FREE_MIN_BUFF_SIZE = 4096;
    private static final int READ_RESPONSE_INIT_BUFF_SIZE = 32768;
    private static final String TAG = "StreamParser";
    private static volatile int sReadBodyBuffFirstIncreaseSize;
    private static volatile int sReadBodyBuffInitSize;
    private static final Map<String, Integer> sSpecificReadBodyBuffInitSize = null;

    static {
        sSpecificReadBodyBuffInitSize = new ConcurrentHashMap();
    }

    public StreamParser() {
    }

    public static String bytesToString(byte[] r3, Map<String, String> r4) {
        if (r3 != null) goto L5;
        return null;
    L5:
        String r1 = r4.get("Content-Type");
        if (TextUtils.isEmpty(r1) == false) goto L9;
        r1 = r4.get("Content-Type".toLowerCase());
    L9:
        return bytesToString(r3, r1);
    }

    public static void decodeSSBinary(byte[] r5, int r6) {
        if (r5 == null) goto L9;
        if (r6 <= 0) goto L11;
        byte[] r1 = {-99, -114, 127, 90};
        int r2 = 0;
    L7:
        if (r2 >= r6) goto L12;
        r5[r2] = (byte) (r5[r2] ^ r1[r2 % 4]);
        r2 = r2 + 1;
        goto L7
    L12:
        return;
    L11:
        return;
    }

    private static int getMaxLength(int r1) {
        if (r1 > 0) goto L6;
        return MAX_API_RESPONSE_LENGTH;
    L6:
        if (r1 >= 1048576) goto L8;
        return 1048576;
    L8:
        return r1;
    }

    private static boolean isBuffSizeValid(int r1) {
        if (r1 >= 4096) goto L5;
    L7:
        return false;
    L5:
        if (r1 > MAX_API_RESPONSE_LENGTH) goto L7;
        return true;
    }

    public static void onConfigUpdate(SharedPreferences r2) {
        sReadBodyBuffInitSize = r2.getInt(KEY_READ_RESPONSE_BUFF_INIT_SIZE, 0);
        sReadBodyBuffFirstIncreaseSize = r2.getInt(KEY_READ_RESPONSE_BUFF_INCREASE_SIZE, 0);
    }

    public static void onSaveConfigToSP(SharedPreferences.Editor r2) {
        r2.putInt(KEY_READ_RESPONSE_BUFF_INIT_SIZE, sReadBodyBuffInitSize);
        r2.putInt(KEY_READ_RESPONSE_BUFF_INCREASE_SIZE, sReadBodyBuffFirstIncreaseSize);
    }

    public static void onServerConfigUpdate(JSONObject r4) {
        sReadBodyBuffInitSize = r4.optInt(KEY_READ_RESPONSE_BUFF_INIT_SIZE, 0);
        sReadBodyBuffFirstIncreaseSize = r4.optInt(KEY_READ_RESPONSE_BUFF_INCREASE_SIZE, 0);
        JSONObject r5 = r4.optJSONObject(KEY_SPECIFIC_READ_RESPONSE_BUFF_INIT_SIZE);
        if (r5 == null) goto L19;
        sSpecificReadBodyBuffInitSize.clear();
        Iterator<String> r0 = r5.keys();
    L6:
        if (r0.hasNext() == false) goto L11;
        String r1 = r0.next();
        int r2 = r5.optInt(r1);
        if (r2 < 4096) goto L6;
        sSpecificReadBodyBuffInitSize.put(r1, Integer.valueOf(r2));
        goto L6
    L11:
        if (Logger.debug() == false) goto L20;
        Logger.d(TAG, "bufrefine, get specific init size " + sSpecificReadBodyBuffInitSize);
        return;
    L20:
        return;
    }

    public static InputStream processInputStream(InputStream r0, Map<String, List<String>> r1, boolean r2, RetrofitMetrics r3) {
        if (r2 == true) goto L4;
        NetworkParams.StreamProcessor r4 = NetworkParams.getStreamProcessor();
        if (r4 != null) goto L9;
        return r0;
    L9:
        return r4.processInputStream(r0, r1, r3);
    L4:
        return new GZIPInputStream(r0);
    }

    public static byte[] readResponse(boolean r16, Map<String, List<String>> r17, int r18, InputStream r19, int[] r20, RetrofitMetrics r21) {
        InputStream r2 = r19;
        int r0 = getMaxLength(r18);
        if (r2 != null) goto L89;
        return null;
    L89:
        long r6 = System.currentTimeMillis();     // Catch: Throwable -> L8
        r2 = processInputStream(r2, r17, r16, r21);     // Catch: Throwable -> L8
        if (isBuffSizeValid(sReadBodyBuffInitSize) == false) goto L10;
        int r8 = sReadBodyBuffInitSize;     // Catch: Throwable -> L8
    L12:
        if (isBuffSizeValid(sReadBodyBuffFirstIncreaseSize) == false) goto L14;
        int r9 = sReadBodyBuffFirstIncreaseSize;     // Catch: Throwable -> L8
    L15:
        if (r21 == null) goto L25;
        URL r10 = r21.url;     // Catch: Throwable -> L8
        if (r10 == null) goto L25;
        if (TextUtils.isEmpty(r10.getPath()) == true) goto L25;
        Integer r11 = sSpecificReadBodyBuffInitSize.get(r21.url.getPath());     // Catch: Throwable -> L8
        if (r11 == null) goto L25;
        r8 = r11.intValue();     // Catch: Throwable -> L8
    L25:
        if (Logger.debug() == false) goto L30;
        if (r21 == null) goto L30;
        if (r21.url == null) goto L30;
        Logger.d(TAG, "bufrefine " + r21.url.getPath() + " read init buf size is " + r8);     // Catch: Throwable -> L8
    L30:
        byte[] r12 = new byte[r8];     // Catch: Throwable -> L8
        int r13 = 0;
        int r14 = 0;
        int r15 = 0;
    L90:
    L38:
        e = move-exception;
        Logger.e(TAG, "new buff error" + e);     // Catch: Throwable -> L8
    L61:
        safeClose(r2);
        return null;
    L42:
        e = e;
        String r110 = "bufrefine ";
    L72:
        if (r16 == false) goto L86;
        if (r13 <= 0) goto L86;
        Logger.w(TAG, "ungzip got exception " + e);     // Catch: Throwable -> L8
    L75:
        if (r13 <= 0) goto L61;
        if (r21 == null) goto L78;
        r21.extra.put(RetrofitMetrics.ExtraKeys.STREAM_READ_TIME, Long.valueOf(System.currentTimeMillis() - r6));     // Catch: Throwable -> L8
        r21.extra.put(RetrofitMetrics.ExtraKeys.STREAM_READ_BYTE_COUNT, Long.valueOf(r13));     // Catch: Throwable -> L8
        r21.apiStreamReadCount = r15;     // Catch: Throwable -> L8
        r21.streamParserCopyCount = r14;     // Catch: Throwable -> L8
        r21.responseReadType = 0;     // Catch: Throwable -> L8
    L78:
        r20[0] = r13;     // Catch: Throwable -> L8
        if (Logger.debug() == false) goto L84;
        if (r21 == null) goto L84;
        if (r21.url == null) goto L84;
        Logger.d(TAG, r110 + r21.url.getPath() + " copyTimes is " + r14 + " final length is " + r13);     // Catch: Throwable -> L8
    L84:
        safeClose(r2);
        return r12;
    L86:
        throw e;     // Catch: Throwable -> L8
    L40:
        e = e;
        r110 = "bufrefine ";
    L63:
        String r5 = e.getMessage();     // Catch: Throwable -> L8
        if (r16 == false) goto L71;
        if (r13 <= 0) goto L71;
        if ("CRC mismatch".equals(r5) == false) goto L69;
    L70:
        Logger.w(TAG, "ungzip got exception " + e);     // Catch: Throwable -> L8
        goto L75
    L69:
        if ("Size mismatch".equals(r5) == true) goto L70;
    L71:
        throw e;     // Catch: Throwable -> L8
    L34:
        if ((r13 + 4096) > r12.length) goto L36;
    L46:
        int r7 = r2.read(r12, r13, r12.length - r13);     // Catch: Throwable -> L8 OutOfMemoryError -> L38 IOException -> L40 EOFException -> L42
        r15 = r15 + 1;     // Catch: Throwable -> L8 OutOfMemoryError -> L38 IOException -> L40 EOFException -> L42
        if (r7 <= 0) goto L59;
        r13 = r13 + r7;     // Catch: Throwable -> L8 OutOfMemoryError -> L38 IOException -> L40 EOFException -> L42
        if (r13 <= r0) goto L90;
        Logger.w(TAG, "entity length did exceed given maxLength");     // Catch: Throwable -> L8 OutOfMemoryError -> L38 IOException -> L40 EOFException -> L42
        r110 = "bufrefine ";
    L57:
        e = e;
    L55:
        e = e;
        goto L63
    L54:
        throw new DownloadFileTooLargeException(r0, r13);     // Catch: Throwable -> L8 OutOfMemoryError -> L38 IOException -> L55 EOFException -> L57
    L59:
        r110 = "bufrefine ";
        goto L75
    L36:
        if (r12.length >= r9) goto L44;
        int r22 = r12.length + r9;     // Catch: Throwable -> L8 OutOfMemoryError -> L38 IOException -> L40 EOFException -> L42
    L45:
        byte[] r23 = new byte[r22];     // Catch: Throwable -> L8 OutOfMemoryError -> L38 IOException -> L40 EOFException -> L42
        System.arraycopy(r12, 0, r23, 0, r13);     // Catch: Throwable -> L8 OutOfMemoryError -> L38 IOException -> L40 EOFException -> L42
        r14 = r14 + 1;     // Catch: Throwable -> L8 OutOfMemoryError -> L38 IOException -> L40 EOFException -> L42
        r12 = r23;
        goto L46
    L44:
        r22 = r12.length * 2;     // Catch: Throwable -> L8 OutOfMemoryError -> L38 IOException -> L40 EOFException -> L42
        goto L45
    L14:
        r9 = READ_RESPONSE_FIRST_INCREASE_SIZE;
        goto L15
    L10:
        r8 = 32768;
    L8:
        th = move-exception;
        safeClose(r2);
        throw th;
    }

    public static byte[] readResponseWithOkio(boolean r9, Map<String, List<String>> r10, int r11, InputStream r12, RetrofitMetrics r13) {
        if (r12 != null) goto L5;
        return null;
    L5:
        long r0 = System.currentTimeMillis();
        Buffer r2 = new Buffer();
        InputStream r14 = processInputStream(r12, r10, r9, r13);
        int r15 = getMaxLength(r11);
        BufferedSource r16 = Okio.buffer(Okio.source(r14));     // Catch: Throwable -> L23 Exception -> L25
    L41:
    L14:
        th = move-exception;
        if (r16 != null) goto L37;
    L32:
        throw th;     // Catch: Throwable -> L23 Exception -> L25
    L37:
        r16.close();     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L23 Exception -> L25
        goto L32
    L8:
        if (r16.exhausted() == true) goto L18;
        long r3 = r15;
        if (r16.read(r2, r3 - r2.size()) == (-1)) goto L17;
        if (r2.size() <= r3) goto L41;
    L17:
        throw new DownloadFileTooLargeException(r15, r2.size());     // Catch: Throwable -> L14
    L18:
        if (r13 == null) goto L20;
        r13.extra.put(RetrofitMetrics.ExtraKeys.STREAM_READ_TIME, Long.valueOf(System.currentTimeMillis() - r0));     // Catch: Throwable -> L14
        r13.extra.put(RetrofitMetrics.ExtraKeys.STREAM_READ_BYTE_COUNT, Long.valueOf(r2.size()));     // Catch: Throwable -> L14
        r13.responseReadType = 1;     // Catch: Throwable -> L14
    L20:
        r16.close();     // Catch: Throwable -> L23 Exception -> L25
        safeClose(r14);
        return r2.readByteArray();
    L25:
        e = move-exception;
        Logger.e("ttnet_okio", e.getMessage());     // Catch: Throwable -> L23
        throw e;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        safeClose(r14);
        throw th;
    }

    public static byte[] readResponseWithZeroCopy(boolean r6, Map<String, List<String>> r7, int r8, InputStream r9, RetrofitMetrics r10) {
        if (Logger.debug() == false) goto L8;
        if (r10 == null) goto L8;
        URL r0 = r10.url;
        if (r0 == null) goto L8;
        Logger.d("ttnet_0cp", r0.getPath());
    L8:
        if (r9 != null) goto L11;
        return null;
    L11:
        long r2 = System.currentTimeMillis();
        InputStream r11 = processInputStream(r9, r7, r6, r10);
        r11.read(new byte[0]);     // Catch: Throwable -> L15 Exception -> L17
        int r12 = r11.available();     // Catch: Throwable -> L15 Exception -> L17
        if (Logger.debug() == false) goto L19;
        Logger.d("ttnet_0cp", "available size is " + r12);     // Catch: Throwable -> L15 Exception -> L17
    L19:
        byte[] r13 = new byte[r12];     // Catch: Throwable -> L15 Exception -> L17
        r11.read(r13);     // Catch: Throwable -> L15 Exception -> L17
        if (r10 == null) goto L22;
        r10.extra.put(RetrofitMetrics.ExtraKeys.STREAM_READ_TIME, Long.valueOf(System.currentTimeMillis() - r2));     // Catch: Throwable -> L15 Exception -> L17
        r10.responseReadType = 2;     // Catch: Throwable -> L15 Exception -> L17
        r10.extra.put(RetrofitMetrics.ExtraKeys.STREAM_READ_BYTE_COUNT, Long.valueOf(r12));     // Catch: Throwable -> L15 Exception -> L17
    L22:
        safeClose(r11);
        return r13;
    L15:
        th = move-exception;
        safeClose(r11);
        throw th;
    L17:
        e = move-exception;
        Logger.e("ttnet_0cp", e.getMessage());     // Catch: Throwable -> L15
        throw e;     // Catch: Throwable -> L15
    }

    public static byte[] response2buf(boolean r7, Map<String, List<String>> r8, int r9, InputStream r10, int[] r11, RequestHandler r12) {
        if (r10 != null) goto L18;
        return null;
    L18:
        byte[] r13 = readResponse(r7, r8, r9, r10, r11, null);     // Catch: Exception -> L13
        if (r13 != null) goto L9;
    L12:
        return null;
    L9:
        if (r11[0] <= 0) goto L12;
        return r13;
    L13:
        e = move-exception;
        if (r12 != null) goto L20;
    L16:
        throw e;
    L20:
        r12.abort();     // Catch: Throwable -> L17
        goto L16
    }

    public static void safeClose(Closeable r1) {
        safeClose(r1, null);
    }

    public static byte[] stream2ByteArray(int r5, InputStream r6, long r7, RequestHandler r9) {
        if (r6 != null) goto L41;
        return null;
    L41:
        if (r7 <= 2147483647L) goto L15;
        Logger.w(TAG, "HTTP entity too large to be buffered in memory");     // Catch: Throwable -> L10 Exception -> L12
        safeClose(r6);
        return null;
    L15:
        if (r7 >= 0) goto L17;
        r7 = 4096;
    L23:
        ByteArrayBuffer r0 = new ByteArrayBuffer((int) r7);     // Catch: Throwable -> L10 Exception -> L12
        byte[] r8 = new byte[4096];     // Catch: Throwable -> L10 Exception -> L12
        int r2 = 0;
    L24:
        int r3 = r6.read(r8);     // Catch: Throwable -> L10 Exception -> L12
        if (r3 == (-1)) goto L32;
        r0.append(r8, 0, r3);     // Catch: Throwable -> L10 Exception -> L12
        r2 = r2 + r3;     // Catch: Throwable -> L10 Exception -> L12
        if (r5 <= 0) goto L24;
        if (r2 <= r5) goto L24;
        Logger.w(TAG, "entity length did exceed given maxLength");     // Catch: Throwable -> L10 Exception -> L12
        safeClose(r6);
        return null;
    L32:
        byte[] r10 = r0.toByteArray();     // Catch: Throwable -> L10 Exception -> L12
        safeClose(r6);
        return r10;
    L17:
        if (r5 <= 0) goto L23;
        if (r7 <= r5) goto L23;
        Logger.w(TAG, "entity length exceed given maxLength: " + r5 + " " + r7);     // Catch: Throwable -> L10 Exception -> L12
        safeClose(r6);
        return null;
    L12:
        e = move-exception;
        if (r9 != null) goto L42;
    L37:
        throw e;     // Catch: Throwable -> L10
    L42:
        r9.abort();     // Catch: Throwable -> L40
    L10:
        th = move-exception;
        safeClose(r6);
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r10v27 */
    /* JADX WARN: Type inference failed for: r10v28 */
    /* JADX WARN: Type inference failed for: r10v29 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v30 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v29 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v30 */
    /* JADX WARN: Type inference failed for: r6v31 */
    /* JADX WARN: Type inference failed for: r6v32 */
    /* JADX WARN: Type inference failed for: r6v33 */
    /* JADX WARN: Type inference failed for: r6v34 */
    /* JADX WARN: Type inference failed for: r6v35 */
    /* JADX WARN: Type inference failed for: r6v36 */
    /* JADX WARN: Type inference failed for: r6v37 */
    /* JADX WARN: Type inference failed for: r6v38 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    public static boolean stream2File(InputStream r24, long r25, RequestHandler r27, int r28, String r29, String r30, String r31, IDownloadPublisher<String> r32, String r33, TaskInfo r34) {
        InputStream r1 = r24;
        long r2 = r25;
        String r5 = r29;
        String r9 = ".tmp";
        if (r1 != null) goto L5;
        return false;
    L5:
        String r14 = "delete temp file exception ";
        String r15 = "close random file exception ";
        if (r2 <= 2147483647L) goto L219;
        Logger.w(TAG, "HTTP entity too large");     // Catch: Throwable -> L163 Exception -> L165
        throw new DownloadFileTooLargeException(r28, 2147483647L);     // Catch: Throwable -> L163 Exception -> L165
    L219:
        if (r2 >= 0) goto L10;
        r2 = 4096;
    L209:
        File r0 = new File(r5);     // Catch: Throwable -> L155 Exception -> L158
        if (r0.exists() == true) goto L186;
        r0.mkdirs();     // Catch: Throwable -> L16 Exception -> L20
    L186:
        File r3 = File.createTempFile("tempimage", ".tmp", new File(r5));     // Catch: Throwable -> L16 Exception -> L20 IOException -> L29
    L28:
        ?? r6 = r3;
        if (r6 != 0) goto L50;
        safeClose(r1, "close instream exception ");
        safeClose(null, "close outstream exception ");
        safeClose(null, "close random file exception ");
        if (r6 == 0) goto L229;
        r6.delete();     // Catch: Exception -> L44
        return false;
    L44:
        e = move-exception;
        if (Logger.debug() == false) goto L230;
        Logger.d(TAG, "delete temp file exception " + e);
        return false;
    L230:
        return false;
    L229:
        return false;
    L50:
        r9 = "close outstream exception ";
        ?? r10 = new RandomAccessFile(r6, "rw");     // Catch: Throwable -> L151 Exception -> L153
    L213:
        r10.setLength(0);     // Catch: Throwable -> L147 Exception -> L149
        byte[] r4 = new byte[4096];     // Catch: Throwable -> L147 Exception -> L149
        String r16 = r5;
        long r11 = 0;
        long r17 = 0;
    L54:
        int r7 = r1.read(r4);     // Catch: Throwable -> L147 Exception -> L149
    L56:
        if (r7 == (-1)) goto L108;
        if (r34 != null) goto L215;
    L76:
        String r19 = r14;
        String r8 = r15;
        long r12 = r11 + ((long) r7);
        if (r28 <= 0) goto L205;
        if (r12 <= r28) goto L205;
        Logger.w(TAG, "entity length did exceed given maxLength");     // Catch: Throwable -> L88 Exception -> L90
        r10.close();     // Catch: Throwable -> L88 Exception -> L90
    L86:
        e = e;
        String r13 = r8;
        ?? r18 = r6;
    L22:
        ?? r110 = 0;
        ?? r20 = r18;
    L23:
        ?? r111 = 0;
        r6 = r20;
        r10 = r110;
    L169:
        if (r27 == null) goto L194;
        r27.abort();     // Catch: Throwable -> L183
    L194:
        throw e;     // Catch: Throwable -> L172
    L172:
        th = th;
    L133:
        Throwable r21 = th;
        ?? r22 = r6;
        ?? r112 = r10;
        ?? r113 = r111;
    L174:
        safeClose(r1, "close instream exception ");
        safeClose(r113, r9);
        safeClose(r112, r13);
        if (r22 == 0) goto L226;
        r22.delete();     // Catch: Exception -> L178
        throw r21;
    L178:
        e = move-exception;
        if (Logger.debug() == false) goto L227;
        Logger.d(TAG, r19 + e);
        throw r21;
    L227:
        throw r21;
    L226:
        throw r21;
    L84:
        th = move-exception;
        r21 = th;
        r13 = r8;
        ?? r23 = r6;
    L18:
        ?? r114 = 0;
        ?? r26 = r23;
    L19:
        r113 = 0;
        r22 = r26;
        r112 = r114;
        goto L174
    L83:
        throw new DownloadFileTooLargeException(r28, r2);     // Catch: Throwable -> L84 Exception -> L86
    L90:
        e = e;
        r13 = r8;
        r20 = r6;
        r110 = r10;
    L88:
        th = move-exception;
        r21 = th;
        r13 = r8;
        r26 = r6;
        r114 = r10;
    L205:
        r10.write(r4, 0, r7);     // Catch: Throwable -> L88 Exception -> L90
        if (r32 == null) goto L106;
        if (r33 == null) goto L106;
        long r115 = System.currentTimeMillis();     // Catch: Throwable -> L88 Exception -> L90
        if ((r115 - r17) < 500) goto L106;
        if (r2 < r12) goto L100;
        int r116 = (int) ((100 * r12) / r2);     // Catch: Throwable -> L88 Exception -> L90
    L102:
        if (r116 < 99) goto L104;
        r116 = 99;
    L104:
        r32.publishProgress(r116, r33);     // Catch: Throwable -> L88 Exception -> L90
        r17 = r115;
    L107:
        r11 = r12;
        r15 = r8;
        r14 = r19;
        goto L54
    L100:
        r116 = 80;
    L106:
        r12 = r12;
        goto L107
    L215:
    L64:
        e = e;
        r19 = r14;
        r13 = r15;
        r20 = r6;
        r110 = r10;
    L62:
        th = move-exception;
        r21 = th;
        r19 = r14;
        r13 = r15;
        r26 = r6;
        r114 = r10;
        goto L19
    L59:
        if (r34.isCanceled() == false) goto L76;
        if (r27 == null) goto L66;
        URI r35 = r27.getURI();     // Catch: Throwable -> L62 Exception -> L64
        r27.abort();     // Catch: Throwable -> L62 Exception -> L64
    L67:
        Logger.v(TAG, "download file canceled " + r35);     // Catch: Throwable -> L62 Exception -> L64
        r10.close();     // Catch: Throwable -> L62 Exception -> L64
        safeClose(r1, "close instream exception ");
        safeClose(null, r9);
        safeClose(null, r15);
        r6.delete();     // Catch: Exception -> L71
        return false;
    L71:
        e = move-exception;
        if (Logger.debug() == false) goto L232;
        Logger.d(TAG, r14 + e);
        return false;
    L232:
        return false;
    L66:
        r35 = null;
        goto L67
    L108:
        r19 = r14;
        String r36 = r15;
        r24.close();     // Catch: Throwable -> L141 Exception -> L144
    L111:
        if (r11 > 0) goto L203;
    L196:
        r10.close();     // Catch: Throwable -> L137 Exception -> L139
    L211:
        r6.delete();     // Catch: Throwable -> L130 Exception -> L134
        safeClose(null, "close instream exception ");
        safeClose(null, r9);
        safeClose(null, r36);
        return true;
    L134:
        e = e;
        r13 = r36;
        r1 = null;
        ?? r117 = 0;
        ?? r37 = r6;
    L136:
        r111 = r117;
        r6 = r37;
        r10 = r117;
    L130:
        th = th;
        r13 = r36;
        r1 = null;
        r10 = 0;
        r6 = r6;
    L132:
        r111 = r10;
    L139:
        e = e;
        r13 = r36;
        r1 = null;
        r111 = 0;
        r6 = r6;
        r10 = r10;
    L137:
        th = th;
        r13 = r36;
        r1 = null;
        r111 = 0;
        goto L133
    L203:
        r10.seek(0);     // Catch: Throwable -> L122 Exception -> L124
        FileOutputStream r38 = new FileOutputStream(new File(r16, r31));     // Catch: Throwable -> L122 Exception -> L124
    L198:
        int r39 = r10.read(r4);     // Catch: Throwable -> L116 Exception -> L118
        if (r39 == (-1)) goto L120;
        r38.write(r4, 0, r39);     // Catch: Throwable -> L116 Exception -> L118
        goto L198
    L120:
        r38.close();     // Catch: Throwable -> L116 Exception -> L118
    L118:
        e = e;
        r111 = r38;
        r13 = r36;
        r1 = null;
        r6 = r6;
        r10 = r10;
    L116:
        th = move-exception;
        r21 = th;
        r113 = r38;
        r13 = r36;
        r1 = null;
        r22 = r6;
        r112 = r10;
        goto L174
    L124:
        e = e;
        r13 = r36;
        r1 = null;
        r20 = r6;
        r110 = r10;
    L122:
        th = move-exception;
        r21 = th;
        r13 = r36;
        r1 = null;
        r26 = r6;
        r114 = r10;
    L144:
        e = e;
        r13 = r36;
    L146:
        r111 = 0;
        r6 = r6;
        r10 = r10;
    L141:
        th = th;
        r13 = r36;
    L143:
        r111 = 0;
    L149:
        e = e;
        r19 = r14;
        r13 = r15;
    L147:
        th = th;
        r19 = r14;
        r13 = r15;
    L153:
        e = e;
        r19 = "delete temp file exception ";
        r13 = "close random file exception ";
        r117 = 0;
        r37 = r6;
    L151:
        th = th;
        r19 = "delete temp file exception ";
        r13 = "close random file exception ";
        r10 = 0;
        r6 = r6;
        goto L132
    L29:
        e = move-exception;
        if (StringUtils.isEmpty(r30) == true) goto L162;
        if (r30.equals(r5) == true) goto L162;
        File r40 = new File(r30);     // Catch: Throwable -> L155 Exception -> L158
        if (r40.exists() == true) goto L37;
        r40.mkdirs();     // Catch: Throwable -> L16 Exception -> L20
    L37:
        r3 = File.createTempFile("tempimage", ".tmp", new File(r30));     // Catch: Throwable -> L155 Exception -> L158
        r5 = r30;
        goto L28
    L162:
        throw e;     // Catch: Throwable -> L163 Exception -> L165
    L158:
        e = e;
        r19 = "delete temp file exception ";
        r13 = "close random file exception ";
        r9 = "close outstream exception ";
        ?? r41 = 0;
    L160:
        ?? r42 = r41;
        r117 = r42;
        r37 = r42;
    L155:
        th = th;
        r19 = "delete temp file exception ";
        r13 = "close random file exception ";
        r9 = "close outstream exception ";
        ?? r43 = 0;
    L157:
        ?? r44 = r43;
        r10 = r44;
        r6 = r44;
        goto L132
    L10:
        if (r28 <= 0) goto L209;
        if (r2 <= r28) goto L209;
        Logger.w(TAG, "entity length exceed given maxLength");     // Catch: Throwable -> L16 Exception -> L20
        throw new DownloadFileTooLargeException(r28, r2);     // Catch: Throwable -> L16 Exception -> L20
    L20:
        e = e;
        r19 = "delete temp file exception ";
        r13 = "close random file exception ";
        r9 = "close outstream exception ";
        r18 = 0;
    L16:
        th = move-exception;
        r21 = th;
        r19 = "delete temp file exception ";
        r13 = "close random file exception ";
        r9 = "close outstream exception ";
        r23 = 0;
    L165:
        e = e;
        r41 = r2;
    L163:
        th = th;
        r43 = r2;
        goto L157
    }

    public static boolean testIsSSBinary(String r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        int r1 = r3.indexOf("application/octet-stream");
        if (r1 < 0) goto L8;
        r1 = r3.indexOf("ssmix=", r1 + 24);
    L8:
        if (r1 <= 0) goto L11;
        return true;
    L11:
        return false;
    }

    private static void safeClose(Closeable r2, String r3) {
        if (r2 == null) goto L13;
        r2.close();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        if (Logger.debug() == false) goto L14;
        if (r3 == null) goto L15;
        Logger.d(TAG, r3 + " " + e);
        return;
    L15:
        return;
    L14:
        return;
    }

    public static String bytesToString(byte[] r1, String r2) {
        if (r1 != null) goto L5;
        return null;
    L5:
        String r0 = "UTF-8";
        String r3 = MimeUtil.parseCharset(r2, "UTF-8");
        if (r3 == null) goto L10;
        r0 = r3;
    L10:
        return new String(r1, r0);
    }
}
