package com.loopj.android.http;

import android.text.TextUtils;
import com.android.settings.wifi.WifiSettings;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.message.BasicHeader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class JsonStreamerEntity implements HttpEntity {
    private static final int BUFFER_SIZE = 4096;
    private static final UnsupportedOperationException ERR_UNSUPPORTED = null;
    private static final Header HEADER_GZIP_ENCODING = null;
    private static final Header HEADER_JSON_CONTENT = null;
    private static final byte[] JSON_FALSE = null;
    private static final byte[] JSON_NULL = null;
    private static final byte[] JSON_TRUE = null;
    private static final String LOG_TAG = "JsonStreamerEntity";
    private static final byte[] STREAM_CONTENTS = null;
    private static final byte[] STREAM_NAME = null;
    private static final byte[] STREAM_TYPE = null;
    private final byte[] buffer;
    private final Header contentEncoding;
    private final byte[] elapsedField;
    private final Map<String, Object> jsonParams;
    private final ResponseHandlerInterface progressHandler;

    @Override // cz.msebera.android.httpclient.HttpEntity
    public void consumeContent() throws IOException, UnsupportedOperationException {
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public long getContentLength() {
        return -1;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isChunked() {
        return false;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isRepeatable() {
        return false;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isStreaming() {
        return false;
    }

    static {
        ERR_UNSUPPORTED = new UnsupportedOperationException("Unsupported operation in this implementation.");
        JSON_TRUE = "true".getBytes();
        JSON_FALSE = "false".getBytes();
        JSON_NULL = "null".getBytes();
        STREAM_NAME = escape("name");
        STREAM_TYPE = escape("type");
        STREAM_CONTENTS = escape(WifiSettings.ScannerIntentResult_CONTENTS);
        HEADER_JSON_CONTENT = new BasicHeader("Content-Type", RequestParams.APPLICATION_JSON);
        HEADER_GZIP_ENCODING = new BasicHeader("Content-Encoding", "gzip");
    }

    public JsonStreamerEntity(ResponseHandlerInterface r2, boolean r3, String r4) {
        this.buffer = new byte[4096];
        this.jsonParams = new HashMap();
        this.progressHandler = r2;
        byte[] r5 = null;
        if (r3 == false) goto L5;
        Header r6 = HEADER_GZIP_ENCODING;
    L6:
        this.contentEncoding = r6;
        if (TextUtils.isEmpty(r4) == true) goto L10;
        r5 = escape(r4);
    L10:
        this.elapsedField = r5;
        return;
    L5:
        r6 = null;
        goto L6
    }

    static byte[] escape(String r8) {
        if (r8 == null) goto L4;
        StringBuilder r0 = new StringBuilder(128);
        r0.append('\"');
        int r2 = r8.length();
        int r3 = -1;
    L6:
        r3 = r3 + 1;
        if (r3 >= r2) goto L39;
        char r4 = r8.charAt(r3);
        if (r4 != '\f') goto L11;
        r0.append("\\f");
        goto L6
    L11:
        if (r4 != '\r') goto L12;
        r0.append("\\r");
        goto L6
    L12:
        if (r4 != '\"') goto L14;
        r0.append("\\\"");
        goto L6
    L14:
        if (r4 != '\\') goto L15;
        r0.append("\\\\");
        goto L6
    L15:
        switch(r4) {
            case 8: goto L34;
            case 9: goto L33;
            case 10: goto L32;
            default: goto L17;
        };
    L32:
        r0.append("\\n");
        goto L6
    L33:
        r0.append("\\t");
        goto L6
    L34:
        r0.append("\\b");
        goto L6
    L17:
        if (r4 <= 31) goto L28;
        if (r4 < 127) goto L23;
        if (r4 <= 159) goto L28;
    L23:
        if (r4 < 8192) goto L27;
        if (r4 <= 8447) goto L28;
    L27:
        r0.append(r4);
    L28:
        String r5 = Integer.toHexString(r4);
        r0.append("\\u");
        int r6 = 4 - r5.length();
        int r7 = 0;
    L29:
        if (r7 >= r6) goto L31;
        r0.append('0');
        r7 = r7 + 1;
        goto L29
    L31:
        r0.append(r5.toUpperCase(Locale.US));
        goto L6
    L39:
        r0.append('\"');
        return r0.toString().getBytes();
    L4:
        return JSON_NULL;
    }

    public void addPart(String r1, Object r2) {
        this.jsonParams.put(r1, r2);
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public Header getContentEncoding() {
        return this.contentEncoding;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public Header getContentType() {
        return HEADER_JSON_CONTENT;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public InputStream getContent() throws IOException, UnsupportedOperationException {
        throw ERR_UNSUPPORTED;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public void writeTo(OutputStream r14) throws IOException {
        if (r14 == null) goto L71;
        long r0 = System.currentTimeMillis();
        if (this.contentEncoding == null) goto L6;
        r14 = new GZIPOutputStream(r14, 4096);
    L6:
        r14.write(123);
        Set<String> r3 = this.jsonParams.keySet();
        int r4 = r3.size();
        if (r4 <= 0) goto L68;
        Iterator<String> r5 = r3.iterator();
        int r6 = 0;
    L10:
        if (r5.hasNext() == false) goto L64;
        String r7 = r5.next();
        r6 = r6 + 1;
        Object r11 = this.jsonParams.get(r7);     // Catch: Throwable -> L58
        r14.write(escape(r7));     // Catch: Throwable -> L58
        r14.write(58);     // Catch: Throwable -> L58
        if (r11 != null) goto L15;
        r14.write(JSON_NULL);     // Catch: Throwable -> L58
    L55:
        if (this.elapsedField != null) goto L57;
        if (r6 >= r4) goto L10;
    L57:
        r14.write(44);
        goto L10
    L15:
        boolean r8 = r11 instanceof RequestParams.FileWrapper;     // Catch: Throwable -> L58
        if (r8 == false) goto L18;
    L49:
        r14.write(123);     // Catch: Throwable -> L58
        if (r8 == false) goto L52;
        writeToFromFile(r14, (RequestParams.FileWrapper) r11);     // Catch: Throwable -> L58
    L53:
        r14.write(125);     // Catch: Throwable -> L58
        goto L55
    L52:
        writeToFromStream(r14, (RequestParams.StreamWrapper) r11);     // Catch: Throwable -> L58
        goto L53
    L18:
        if ((r11 instanceof RequestParams.StreamWrapper) == true) goto L49;
        if ((r11 instanceof JsonValueInterface) == false) goto L24;
        r14.write(((JsonValueInterface) r11).getEscapedJsonValue());     // Catch: Throwable -> L58
        goto L55
    L24:
        if ((r11 instanceof JSONObject) == false) goto L27;
        r14.write(r11.toString().getBytes());     // Catch: Throwable -> L58
        goto L55
    L27:
        if ((r11 instanceof JSONArray) == false) goto L30;
        r14.write(r11.toString().getBytes());     // Catch: Throwable -> L58
        goto L55
    L30:
        if ((r11 instanceof Boolean) == false) goto L37;
        if (((Boolean) r11).booleanValue() == false) goto L34;
        byte[] r9 = JSON_TRUE;     // Catch: Throwable -> L58
    L35:
        r14.write(r9);     // Catch: Throwable -> L58
        goto L55
    L34:
        r9 = JSON_FALSE;     // Catch: Throwable -> L58
        goto L35
    L37:
        if ((r11 instanceof Long) == false) goto L40;
        r14.write((((Number) r11).longValue() + "").getBytes());     // Catch: Throwable -> L58
        goto L55
    L40:
        if ((r11 instanceof Double) == false) goto L43;
        r14.write((((Number) r11).doubleValue() + "").getBytes());     // Catch: Throwable -> L58
        goto L55
    L43:
        if ((r11 instanceof Float) == false) goto L46;
        r14.write((((Number) r11).floatValue() + "").getBytes());     // Catch: Throwable -> L58
        goto L55
    L46:
        if ((r11 instanceof Integer) == false) goto L48;
        r14.write((((Number) r11).intValue() + "").getBytes());     // Catch: Throwable -> L58
        goto L55
    L48:
        r14.write(escape(r11.toString()));     // Catch: Throwable -> L58
    L58:
        th = move-exception;
        if (this.elapsedField != null) goto L62;
        if (r6 < r4) goto L62;
    L63:
        throw th;
    L62:
        r14.write(44);
        goto L63
    L64:
        long r2 = System.currentTimeMillis() - r0;
        byte[] r13 = this.elapsedField;
        if (r13 == null) goto L67;
        r14.write(r13);
        r14.write(58);
        r14.write((r2 + "").getBytes());
    L67:
        AsyncHttpClient.log.i(LOG_TAG, "Uploaded JSON in " + Math.floor(r2 / 1000) + " seconds");
    L68:
        r14.write(125);
        r14.flush();
        AsyncHttpClient.silentCloseOutputStream(r14);
        return;
    L71:
        throw new IllegalStateException("Output stream cannot be null.");
    }

    private void writeToFromStream(OutputStream r5, RequestParams.StreamWrapper r6) throws IOException {
        writeMetaData(r5, r6.name, r6.contentType);
        Base64OutputStream r0 = new Base64OutputStream(r5, 18);
    L3:
        int r1 = r6.inputStream.read(this.buffer);
        if (r1 == (-1)) goto L6;
        r0.write(this.buffer, 0, r1);
        goto L3
    L6:
        AsyncHttpClient.silentCloseOutputStream(r0);
        endMetaData(r5);
        if (r6.autoClose == false) goto L11;
        AsyncHttpClient.silentCloseInputStream(r6.inputStream);
        return;
    }

    private void writeToFromFile(OutputStream r9, RequestParams.FileWrapper r10) throws IOException {
        writeMetaData(r9, r10.file.getName(), r10.contentType);
        long r0 = r10.file.length();
        FileInputStream r2 = new FileInputStream(r10.file);
        Base64OutputStream r11 = new Base64OutputStream(r9, 18);
        long r3 = 0;
    L3:
        int r5 = r2.read(this.buffer);
        if (r5 == (-1)) goto L6;
        r11.write(this.buffer, 0, r5);
        r3 = r3 + ((long) r5);
        this.progressHandler.sendProgressMessage(r3, r0);
        goto L3
    L6:
        AsyncHttpClient.silentCloseOutputStream(r11);
        endMetaData(r9);
        AsyncHttpClient.silentCloseInputStream(r2);
    }

    private void writeMetaData(OutputStream r2, String r3, String r4) throws IOException {
        r2.write(STREAM_NAME);
        r2.write(58);
        r2.write(escape(r3));
        r2.write(44);
        r2.write(STREAM_TYPE);
        r2.write(58);
        r2.write(escape(r4));
        r2.write(44);
        r2.write(STREAM_CONTENTS);
        r2.write(58);
        r2.write(34);
    }

    private void endMetaData(OutputStream r1) throws IOException {
        r1.write(34);
    }
}
