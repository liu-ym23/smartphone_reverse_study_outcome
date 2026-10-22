package com.bytedance.frameworks.core.encrypt;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import com.bytedance.librarian.LibrarianImpl;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes.dex */
public class RequestEncryptUtils {
    private static final String DEFAULT_CONTENT_CHARSET = "ISO-8859-1";
    private static final String KEY_DEVICE_BRAND = "device_brand";
    private static final String KEY_DEVICE_ID = "device_id";
    private static final String KEY_DEVICE_TYPE = "device_type";
    private static final String KEY_OPENUDID = "openudid";
    private static final String KEY_SS_ENCRYPT = "ss_encrypt";
    private static final String KEY_SS_QUERIES = "ss_queries";
    private static final String KEY_SS_QUERIES_HEADER = "X-SS-QUERIES";
    private static final String KEY_UUID = "uuid";
    private static final String NAME_VALUE_SEPARATOR = "=";
    private static final String PARAMETER_SEPARATOR = "&";
    private static final String TAG = "RequestEncryptUtils";
    private static boolean sDebug = false;
    private static IEncryptConfig sEncryptConfig;

    public interface IEncryptConfig {
        boolean isSsQueriesHeaderOpen();

        boolean isSsQueriesOpen();

        boolean isSsQueriesPlaintextOpen();
    }

    static {
    }

    public RequestEncryptUtils() {
    }

    public static void setEncryptConfig(IEncryptConfig r0) {
        sEncryptConfig = r0;
    }

    public static void setDebug(boolean r0) {
        sDebug = r0;
    }

    public static String tryEncryptRequest(String r11, List<Pair<String, String>> r12) {
        if (TextUtils.isEmpty(r11) == false) goto L6;
        return r11;
    L6:
        if (sEncryptConfig != null) goto L9;
        return r11;
    L9:
        if (sDebug == false) goto L11;
        return r11;
    L11:
        LinkedHashMap r1 = new LinkedHashMap();
        Uri r2 = Uri.parse(r11);     // Catch: Throwable -> L36
        parseQueries(r2, r1);     // Catch: Throwable -> L36
        LinkedList r3 = new LinkedList();     // Catch: Throwable -> L36
        tryAddQuery(r1, r3, "device_id");     // Catch: Throwable -> L36
        tryAddQuery(r1, r3, KEY_DEVICE_TYPE);     // Catch: Throwable -> L36
        tryAddQuery(r1, r3, "device_brand");     // Catch: Throwable -> L36
        tryAddQuery(r1, r3, KEY_UUID);     // Catch: Throwable -> L36
        tryAddQuery(r1, r3, KEY_OPENUDID);     // Catch: Throwable -> L36
        String r4 = format(r3, false, "UTF-8");     // Catch: Throwable -> L36
        if (TextUtils.isEmpty(r4) == false) goto L15;
        return r11;
    L15:
        byte[] r5 = r4.getBytes();     // Catch: Throwable -> L36
        byte[] r6 = EncryptorUtil.encrypt(r5, r5.length);     // Catch: Throwable -> L36
        if (r6 != null) goto L18;
        return r11;
    L18:
        String r7 = Base64.encodeToString(r6, 2);     // Catch: Throwable -> L36
        LinkedList r8 = new LinkedList();     // Catch: Throwable -> L36
        if (sEncryptConfig.isSsQueriesOpen() == false) goto L22;
        LinkedList r9 = new LinkedList();     // Catch: Throwable -> L36
        r9.add(r7);     // Catch: Throwable -> L36
        r8.add(new Pair(KEY_SS_QUERIES, r9));     // Catch: Throwable -> L36
    L22:
        if (sEncryptConfig.isSsQueriesHeaderOpen() == false) goto L26;
        if (r12 == null) goto L26;
        r12.add(new Pair(KEY_SS_QUERIES_HEADER, encode(r7, "UTF-8")));     // Catch: Throwable -> L36
    L26:
        if (r1.isEmpty() == true) goto L34;
        Iterator r13 = r1.entrySet().iterator();     // Catch: Throwable -> L36
    L29:
        if (r13.hasNext() == false) goto L34;
        Map.Entry r10 = (Map.Entry) r13.next();     // Catch: Throwable -> L36
        if (r10 == null) goto L29;
        r8.add(new Pair(r10.getKey(), r10.getValue()));     // Catch: Throwable -> L36
    L34:
        String r14 = format(r8, true, "UTF-8");     // Catch: Throwable -> L36
        return createUri(r2.getScheme(), r2.getHost(), r2.getPort(), r2.getPath(), r14, r2.getFragment()).toString();
    L36:
        th = move-exception;
        th.printStackTrace();
        return r11;
    }

    public static byte[] tryEncryptRequestBody(byte[] r1) {
        if (r1 != null) goto L4;
    L13:
        return r1;
    L4:
        if (r1.length == 0) goto L13;
        if (sDebug == false) goto L14;
        return r1;
    L14:
        return EncryptorUtil.encrypt(r1, r1.length);
    L11:
        th = move-exception;
        th.printStackTrace();
        goto L13
    }

    private static boolean tryAddQuery(Map<String, List<String>> r2, List<Pair<String, List<String>>> r3, String r4) throws UnsupportedEncodingException {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return false;
    L5:
        if (r3 != null) goto L8;
        return false;
    L8:
        if (r2.containsKey(r4) == false) goto L14;
        r3.add(new Pair(r4, r2.get(r4)));
        if (sEncryptConfig.isSsQueriesPlaintextOpen() == true) goto L15;
        r2.remove(r4);
        return true;
    L15:
        return true;
    L14:
        return false;
    }

    public static void parseQueries(Uri r9, Map<String, List<String>> r10) throws IOException {
        if (r9 == null) goto L26;
        if (r10 != null) goto L27;
        return;
    L27:
        String r11 = r9.getEncodedQuery();     // Catch: Throwable -> L21
        if (r11 == null) goto L32;
        String[] r12 = r11.split(PARAMETER_SEPARATOR);     // Catch: Throwable -> L21
        int r1 = r12.length;     // Catch: Throwable -> L21
        int r3 = 0;
    L8:
        if (r3 >= r1) goto L33;
        String r4 = r12[r3];     // Catch: Throwable -> L21
        int r5 = r4.indexOf(NAME_VALUE_SEPARATOR);     // Catch: Throwable -> L21
        if (r5 < 0) goto L16;
        String r7 = URLDecoder.decode(r4.substring(0, r5), "UTF-8");     // Catch: Throwable -> L21
        List<String> r8 = r10.get(r7);     // Catch: Throwable -> L21
        if (r8 != null) goto L15;
        r8 = new LinkedList();     // Catch: Throwable -> L21
    L15:
        r8.add(URLDecoder.decode(r4.substring(r5 + 1), "UTF-8"));     // Catch: Throwable -> L21
        r10.put(r7, r8);     // Catch: Throwable -> L21
    L20:
        r3 = r3 + 1;
        goto L8
    L16:
        String r6 = URLDecoder.decode(r4, "UTF-8");     // Catch: Throwable -> L21
        List<String> r13 = r10.get(r6);     // Catch: Throwable -> L21
        if (r13 != null) goto L19;
        r13 = new LinkedList();     // Catch: Throwable -> L21
    L19:
        r13.add("");     // Catch: Throwable -> L21
        r10.put(r6, r13);     // Catch: Throwable -> L21
        goto L20
    L33:
        return;
    L32:
        return;
    L21:
        th = move-exception;
        th.printStackTrace();
        throw new IOException("parseUrl url is null !!!");
    L26:
        throw new IOException("parseUrl url is null !!!");
    }

    private static Uri createUri(String r1, String r2, int r3, String r4, String r5, String r6) {
        StringBuilder r0 = new StringBuilder();
        if (r2 == null) goto L9;
        if (r1 == null) goto L6;
        r0.append(r1);
        r0.append("://");
    L6:
        r0.append(r2);
        if (r3 <= 0) goto L9;
        r0.append(':');
        r0.append(r3);
    L9:
        if (r4 != null) goto L11;
    L12:
        r0.append(IOUtils.DIR_SEPARATOR_UNIX);
    L13:
        if (r4 == null) goto L15;
        r0.append(r4);
    L15:
        if (r5 == null) goto L17;
        r0.append('?');
        r0.append(r5);
    L17:
        if (r6 == null) goto L20;
        r0.append('#');
        r0.append(r6);
    L20:
        return Uri.parse(r0.toString());
    L11:
        if (r4.startsWith(LibrarianImpl.Constants.SEPARATOR) == true) goto L13;
        goto L12
    }

    private static String format(List<Pair<String, List<String>>> r5, boolean r6, String r7) {
        StringBuilder r0 = new StringBuilder();
        Iterator<Pair<String, List<String>>> r8 = r5.iterator();
    L4:
        if (r8.hasNext() == false) goto L25;
        Pair<String, List<String>> r1 = r8.next();
        String r2 = (String) r1.first;
        if (r6 == false) goto L8;
        r2 = encode((String) r1.first, r7);
    L8:
        List r3 = (List) r1.second;
        if (r3 == null) goto L4;
        if (r3.size() <= 0) goto L4;
        Iterator r4 = r3.iterator();
    L14:
        if (r4.hasNext() == false) goto L4;
        String r9 = (String) r4.next();
        if (r6 == false) goto L21;
        if (r9 == null) goto L19;
        r9 = encode(r9, r7);
        goto L21
    L19:
        r9 = "";
    L21:
        if (r0.length() <= 0) goto L23;
        r0.append(PARAMETER_SEPARATOR);
    L23:
        r0.append(r2);
        r0.append(NAME_VALUE_SEPARATOR);
        r0.append(r9);
        goto L14
    L25:
        return r0.toString();
    }

    private static String encode(String r0, String r1) {
        if (r1 != null) goto L10;
        r1 = "ISO-8859-1";
    L10:
        return URLEncoder.encode(r0, r1);
    L7:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }
}
