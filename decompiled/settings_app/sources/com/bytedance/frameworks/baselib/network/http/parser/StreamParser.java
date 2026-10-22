package com.bytedance.frameworks.baselib.network.http.parser;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.android.settings.utils.HanziToPinyin;
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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
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

    private static boolean isBuffSizeValid(int r1) {
        if (r1 >= 4096) goto L5;
    L7:
        return false;
    L5:
        if (r1 > MAX_API_RESPONSE_LENGTH) goto L7;
        return true;
    }

    public StreamParser() {
    }

    static {
        sSpecificReadBodyBuffInitSize = new ConcurrentHashMap();
    }

    public static void onConfigUpdate(SharedPreferences r2) {
        sReadBodyBuffInitSize = r2.getInt(KEY_READ_RESPONSE_BUFF_INIT_SIZE, 0);
        sReadBodyBuffFirstIncreaseSize = r2.getInt(KEY_READ_RESPONSE_BUFF_INCREASE_SIZE, 0);
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

    public static void onSaveConfigToSP(SharedPreferences.Editor r2) {
        r2.putInt(KEY_READ_RESPONSE_BUFF_INIT_SIZE, sReadBodyBuffInitSize);
        r2.putInt(KEY_READ_RESPONSE_BUFF_INCREASE_SIZE, sReadBodyBuffFirstIncreaseSize);
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

    public static void decodeSSBinary(byte[] r4, int r5) throws IOException {
        if (r4 == null) goto L8;
        if (r5 <= 0) goto L10;
        byte[] r0 = {-99, -114, 127, 90};
        int r1 = 0;
    L6:
        if (r1 >= r5) goto L11;
        r4[r1] = (byte) (r4[r1] ^ r0[r1 % 4]);
        r1 = r1 + 1;
        goto L6
    L11:
        return;
    L10:
        return;
    }

    public static void safeClose(Closeable r1) {
        safeClose(r1, null);
    }

    private static void safeClose(Closeable r2, String r3) {
        if (r2 == null) goto L13;
        r2.close();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        if (Logger.debug() == false) goto L14;
        if (r3 == null) goto L15;
        Logger.d(TAG, r3 + HanziToPinyin.Token.SEPARATOR + e);
        return;
    L15:
        return;
    L14:
        return;
    }

    public static byte[] stream2ByteArray(int r5, InputStream r6, long r7, RequestHandler r9) throws IOException {
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
        Logger.w(TAG, "entity length exceed given maxLength: " + r5 + HanziToPinyin.Token.SEPARATOR + r7);     // Catch: Throwable -> L10 Exception -> L12
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
    /* JADX WARN: Type inference failed for: r11v27, types: [long] */
    /* JADX WARN: Type inference failed for: r11v29 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r2v0, types: [long] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11, types: [long] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v4 */
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
    public static boolean stream2File(InputStream r24, long r25, RequestHandler r27, int r28, String r29, String r30, String r31, IDownloadPublisher<String> r32, String r33, TaskInfo r34) throws Exception {
        InputStream r1 = r24;
        ?? r2 = r25;
        String r5 = r29;
        String r9 = ".tmp";
        if (r1 != null) goto L5;
        return false;
    L5:
        String r14 = "delete temp file exception ";
        String r15 = "close random file exception ";
        if (r2 <= 2147483647L) goto L220;
        Logger.w(TAG, "HTTP entity too large");     // Catch: Throwable -> L163 Exception -> L167
        throw new DownloadFileTooLargeException(r28, 2147483647L);     // Catch: Throwable -> L163 Exception -> L167
    L220:
        if (r2 >= 0) goto L10;
        r2 = 4096(0x1000, double:2.0237E-320);
    L213:
        File r0 = new File(r5);     // Catch: Throwable -> L157 Exception -> L159
        if (r0.exists() == true) goto L187;
        r0.mkdirs();     // Catch: Throwable -> L16 Exception -> L20
    L187:
        File r3 = File.createTempFile("tempimage", ".tmp", new File(r5));     // Catch: Throwable -> L16 Exception -> L20 IOException -> L29
    L28:
        ?? r6 = r3;
        if (r6 != 0) goto L50;
        safeClose(r1, "close instream exception ");
        safeClose(null, "close outstream exception ");
        safeClose(null, "close random file exception ");
        if (r6 == 0) goto L230;
        r6.delete();     // Catch: Exception -> L44
        return false;
    L44:
        e = move-exception;
        if (Logger.debug() == false) goto L231;
        Logger.d(TAG, "delete temp file exception " + e);
        return false;
    L231:
        return false;
    L230:
        return false;
    L50:
        r9 = "close outstream exception ";
        ?? r10 = new RandomAccessFile(r6, "rw");     // Catch: Throwable -> L151 Exception -> L153
    L211:
        r10.setLength(0);     // Catch: Throwable -> L145 Exception -> L148
        byte[] r4 = new byte[4096];     // Catch: Throwable -> L145 Exception -> L148
        String r16 = r5;
        long r11 = 0;
        long r17 = 0;
    L54:
        int r7 = r1.read(r4);     // Catch: Throwable -> L145 Exception -> L148
    L56:
        if (r7 == (-1)) goto L111;
        if (r34 != null) goto L216;
    L78:
        String r19 = r14;
        String r8 = r15;
        long r12 = r11 + ((long) r7);
        if (r28 <= 0) goto L207;
        if (r12 <= r28) goto L207;
        Logger.w(TAG, "entity length did exceed given maxLength");     // Catch: Throwable -> L107 Exception -> L109
        r10.close();     // Catch: Throwable -> L107 Exception -> L109
    L88:
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
    L170:
        if (r27 == null) goto L195;
        r27.abort();     // Catch: Throwable -> L184
    L195:
        throw e;     // Catch: Throwable -> L173
    L173:
        th = th;
    L166:
        Throwable r21 = th;
        ?? r22 = r6;
        ?? r112 = r10;
        ?? r113 = r111;
    L175:
        safeClose(r1, "close instream exception ");
        safeClose(r113, r9);
        safeClose(r112, r13);
        if (r22 == 0) goto L227;
        r22.delete();     // Catch: Exception -> L179
        throw r21;
    L179:
        e = move-exception;
        if (Logger.debug() == false) goto L228;
        Logger.d(TAG, r19 + e);
        throw r21;
    L228:
        throw r21;
    L227:
        throw r21;
    L86:
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
        goto L175
    L85:
        throw new DownloadFileTooLargeException(r28, r2);     // Catch: Throwable -> L86 Exception -> L88
    L109:
        e = e;
        r13 = r8;
        r20 = r6;
        r110 = r10;
    L107:
        th = move-exception;
        r21 = th;
        r13 = r8;
        r26 = r6;
        r114 = r10;
    L207:
        r10.write(r4, 0, r7);     // Catch: Throwable -> L107 Exception -> L109
        if (r32 == null) goto L105;
        if (r33 == null) goto L105;
        long r115 = System.currentTimeMillis();     // Catch: Throwable -> L107 Exception -> L109
        if ((r115 - r17) < 500) goto L105;
        if (r2 < r12) goto L99;
        int r116 = (int) ((100 * r12) / r2);     // Catch: Throwable -> L107 Exception -> L109
    L101:
        if (r116 < 99) goto L103;
        r116 = 99;
    L103:
        r32.publishProgress(r116, r33);     // Catch: Throwable -> L107 Exception -> L109
        r17 = r115;
    L106:
        r11 = r12;
        r15 = r8;
        r14 = r19;
        goto L54
    L99:
        r116 = 80;
    L105:
        r12 = r12;
        goto L106
    L216:
    L76:
        e = e;
        r19 = r14;
        r13 = r15;
        r20 = r6;
        r110 = r10;
    L74:
        th = move-exception;
        r21 = th;
        r19 = r14;
        r13 = r15;
        r26 = r6;
        r114 = r10;
        goto L19
    L59:
        if (r34.isCanceled() == false) goto L78;
        if (r27 == null) goto L62;
        URI r35 = r27.getURI();     // Catch: Throwable -> L74 Exception -> L76
        r27.abort();     // Catch: Throwable -> L74 Exception -> L76
    L63:
        Logger.v(TAG, "download file canceled " + r35);     // Catch: Throwable -> L74 Exception -> L76
        r10.close();     // Catch: Throwable -> L74 Exception -> L76
        safeClose(r1, "close instream exception ");
        safeClose(null, r9);
        safeClose(null, r15);
        if (r6 == 0) goto L233;
        r6.delete();     // Catch: Exception -> L68
        return false;
    L68:
        e = move-exception;
        if (Logger.debug() == false) goto L234;
        Logger.d(TAG, r14 + e);
        return false;
    L234:
        return false;
    L233:
        return false;
    L62:
        r35 = null;
        goto L63
    L111:
        r19 = r14;
        String r36 = r15;
        r24.close();     // Catch: Throwable -> L141 Exception -> L143
    L114:
        if (r11 > 0) goto L209;
    L197:
        r10.close();     // Catch: Throwable -> L137 Exception -> L139
    L205:
        r6.delete();     // Catch: Throwable -> L133 Exception -> L135
        safeClose(null, "close instream exception ");
        safeClose(null, r9);
        safeClose(null, r36);
        return true;
    L135:
        e = e;
        r13 = r36;
        r1 = null;
        ?? r117 = 0;
        ?? r37 = r6;
    L169:
        r111 = r117;
        r6 = r37;
        r10 = r117;
    L133:
        th = th;
        r13 = r36;
        r1 = null;
        r10 = 0;
        r6 = r6;
    L165:
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
        goto L166
    L209:
        r10.seek(0);     // Catch: Throwable -> L125 Exception -> L127
        FileOutputStream r38 = new FileOutputStream(new File(r16, r31));     // Catch: Throwable -> L125 Exception -> L127
    L199:
        int r39 = r10.read(r4);     // Catch: Throwable -> L121 Exception -> L123
        if (r39 == (-1)) goto L119;
        r38.write(r4, 0, r39);     // Catch: Throwable -> L121 Exception -> L123
        goto L199
    L119:
        r38.close();     // Catch: Throwable -> L121 Exception -> L123
    L123:
        e = e;
        r111 = r38;
        r13 = r36;
        r1 = null;
        r6 = r6;
        r10 = r10;
    L121:
        th = move-exception;
        r21 = th;
        r113 = r38;
        r13 = r36;
        r1 = null;
        r22 = r6;
        r112 = r10;
        goto L175
    L127:
        e = e;
        r13 = r36;
        r1 = null;
        r20 = r6;
        r110 = r10;
    L125:
        th = move-exception;
        r21 = th;
        r13 = r36;
        r1 = null;
        r26 = r6;
        r114 = r10;
    L143:
        e = e;
        r13 = r36;
    L150:
        r111 = 0;
        r6 = r6;
        r10 = r10;
    L141:
        th = th;
        r13 = r36;
    L147:
        r111 = 0;
    L148:
        e = e;
        r19 = r14;
        r13 = r15;
    L145:
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
        goto L165
    L29:
        e = move-exception;
        if (StringUtils.isEmpty(r30) == true) goto L156;
        if (r30.equals(r5) == true) goto L156;
        File r40 = new File(r30);     // Catch: Throwable -> L157 Exception -> L159
        if (r40.exists() == true) goto L37;
        r40.mkdirs();     // Catch: Throwable -> L16 Exception -> L20
    L37:
        r3 = File.createTempFile("tempimage", ".tmp", new File(r30));     // Catch: Throwable -> L157 Exception -> L159
        r5 = r30;
        goto L28
    L156:
        throw e;     // Catch: Throwable -> L163 Exception -> L167
    L159:
        e = e;
        r19 = "delete temp file exception ";
        r13 = "close random file exception ";
        r9 = "close outstream exception ";
        r2 = 0;
    L168:
        ?? r41 = r2;
        r117 = r41;
        r37 = r41;
    L157:
        th = th;
        r19 = "delete temp file exception ";
        r13 = "close random file exception ";
        r9 = "close outstream exception ";
        r2 = 0;
    L164:
        ?? r42 = r2;
        r10 = r42;
        r6 = r42;
        goto L165
    L10:
        if (r28 <= 0) goto L213;
        if (r2 <= r28) goto L213;
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
    L167:
        e = e;
    L163:
        th = th;
        goto L164
    }

    public static byte[] response2buf(boolean r7, Map<String, List<String>> r8, int r9, InputStream r10, int[] r11, RequestHandler r12) throws IOException {
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

    public static byte[] readResponse(boolean r16, Map<String, List<String>> r17, int r18, InputStream r19, int[] r20, RetrofitMetrics r21) throws IOException {
        InputStream r2 = r19;
        if (r18 > 0) goto L5;
        int r0 = MAX_API_RESPONSE_LENGTH;
    L7:
        if (r0 >= 1048576) goto L10;
        r0 = 1048576;
    L10:
        if (r2 != null) goto L87;
        return null;
    L87:
        long r6 = System.currentTimeMillis();     // Catch: Throwable -> L84
        r2 = processInputStream(r2, r17, r16, r21);     // Catch: Throwable -> L84
        if (isBuffSizeValid(sReadBodyBuffInitSize) == false) goto L15;
        int r8 = sReadBodyBuffInitSize;     // Catch: Throwable -> L84
    L17:
        if (isBuffSizeValid(sReadBodyBuffFirstIncreaseSize) == false) goto L19;
        int r9 = sReadBodyBuffFirstIncreaseSize;     // Catch: Throwable -> L84
    L20:
        if (r21 == null) goto L30;
        if (r21.url == null) goto L30;
        if (TextUtils.isEmpty(r21.url.getPath()) == true) goto L30;
        Integer r10 = sSpecificReadBodyBuffInitSize.get(r21.url.getPath());     // Catch: Throwable -> L84
        if (r10 == null) goto L30;
        r8 = r10.intValue();     // Catch: Throwable -> L84
    L30:
        if (Logger.debug() == false) goto L35;
        if (r21 == null) goto L35;
        if (r21.url == null) goto L35;
        Logger.d(TAG, "bufrefine " + r21.url.getPath() + " read init buf size is " + r8);     // Catch: Throwable -> L84
    L35:
        byte[] r11 = new byte[r8];     // Catch: Throwable -> L84
        int r12 = 0;
        int r13 = 0;
    L88:
    L66:
        e = move-exception;
        if (r16 == false) goto L83;
        if (r12 <= 0) goto L83;
        Logger.w(TAG, "ungzip got exception " + e);     // Catch: Throwable -> L84
    L70:
        if (r12 <= 0) goto L81;
        if (r21 == null) goto L73;
        r21.extra.put(RetrofitMetrics.ExtraKeys.STREAM_READ_TIME, Long.valueOf(System.currentTimeMillis() - r6));     // Catch: Throwable -> L84
        r21.extra.put(RetrofitMetrics.ExtraKeys.STREAM_READ_BYTE_COUNT, Long.valueOf(r12));     // Catch: Throwable -> L84
    L73:
        r20[0] = r12;     // Catch: Throwable -> L84
        if (Logger.debug() == false) goto L79;
        if (r21 == null) goto L79;
        if (r21.url == null) goto L79;
        Logger.d(TAG, "bufrefine " + r21.url.getPath() + " copyTimes is " + r13 + " final length is " + r12);     // Catch: Throwable -> L84
    L79:
        safeClose(r2);
        return r11;
    L81:
        safeClose(r2);
        return null;
    L83:
        throw e;     // Catch: Throwable -> L84
    L56:
        e = move-exception;
        String r14 = e.getMessage();     // Catch: Throwable -> L84
        if (r16 == false) goto L65;
        if (r12 <= 0) goto L65;
        if ("CRC mismatch".equals(r14) == false) goto L63;
    L64:
        Logger.w(TAG, "ungzip got exception " + e);     // Catch: Throwable -> L84
        goto L70
    L63:
        if ("Size mismatch".equals(r14) == true) goto L64;
    L65:
        throw e;     // Catch: Throwable -> L84
    L52:
        e = move-exception;
        Logger.e(TAG, "new buff error" + e);     // Catch: Throwable -> L84
        safeClose(r2);
        return null;
    L39:
        if ((r12 + 4096) > r11.length) goto L41;
    L45:
        int r15 = r2.read(r11, r12, r11.length - r12);     // Catch: OutOfMemoryError -> L52 IOException -> L56 EOFException -> L66 Throwable -> L84
        if (r15 <= 0) goto L70;
        r12 = r12 + r15;     // Catch: OutOfMemoryError -> L52 IOException -> L56 EOFException -> L66 Throwable -> L84
        if (r12 <= r0) goto L88;
        Logger.w(TAG, "entity length did exceed given maxLength");     // Catch: OutOfMemoryError -> L52 IOException -> L56 EOFException -> L66 Throwable -> L84
        throw new DownloadFileTooLargeException(r0, r12);     // Catch: OutOfMemoryError -> L52 IOException -> L56 EOFException -> L66 Throwable -> L84
    L41:
        if (r11.length >= r9) goto L43;
        int r110 = r11.length + r9;     // Catch: OutOfMemoryError -> L52 IOException -> L56 EOFException -> L66 Throwable -> L84
    L44:
        byte[] r111 = new byte[r110];     // Catch: OutOfMemoryError -> L52 IOException -> L56 EOFException -> L66 Throwable -> L84
        System.arraycopy(r11, 0, r111, 0, r12);     // Catch: OutOfMemoryError -> L52 IOException -> L56 EOFException -> L66 Throwable -> L84
        r13 = r13 + 1;     // Catch: OutOfMemoryError -> L52 IOException -> L56 EOFException -> L66 Throwable -> L84
        r11 = r111;
        goto L45
    L43:
        r110 = r11.length * 2;     // Catch: OutOfMemoryError -> L52 IOException -> L56 EOFException -> L66 Throwable -> L84
        goto L44
    L19:
        r9 = READ_RESPONSE_FIRST_INCREASE_SIZE;
        goto L20
    L15:
        r8 = 32768;
    L84:
        th = move-exception;
        safeClose(r2);
        throw th;
    L5:
        r0 = r18;
        goto L7
    }

    public static String bytesToString(byte[] r3, Map<String, String> r4) throws Exception {
        if (r3 != null) goto L5;
        return null;
    L5:
        String r1 = r4.get("Content-Type");
        if (TextUtils.isEmpty(r1) == false) goto L9;
        r1 = r4.get("Content-Type".toLowerCase());
    L9:
        return bytesToString(r3, r1);
    }

    public static String bytesToString(byte[] r1, String r2) throws Exception {
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

    public static InputStream processInputStream(InputStream r0, Map<String, List<String>> r1, boolean r2, RetrofitMetrics r3) throws IOException {
        if (r2 == true) goto L4;
        NetworkParams.StreamProcessor r4 = NetworkParams.getStreamProcessor();
        if (r4 != null) goto L9;
        return r0;
    L9:
        return r4.processInputStream(r0, r1, r3);
    L4:
        return new GZIPInputStream(r0);
    }
}
