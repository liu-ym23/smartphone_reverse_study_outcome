package com.monitor.cloudmessage.upload.net;

import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.monitor.cloudmessage.CloudMessageManager;
import com.monitor.cloudmessage.upload.entity.FileUploadInfo;
import com.monitor.cloudmessage.upload.entity.UploadInfo;
import com.monitor.cloudmessage.utils.StringUtils;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class CloudMessageUploadService {
    public static final String API_PATH = "monitor/collect/c/cloudcontrol/file";
    static final String BOUNDARY = null;
    static final String COMMON_PARAMS_FILETYPE = "command_commonparams";
    static final String CONTENT_TYPE = "multipart/form-data";
    public static String ENCODE = "UTF-8";
    static final String LINE_END = "\r\n";
    static final String PREFIX = "--";
    static final String SPECIFIC_PARAMS_FILETYPE = "command_specificparams";
    public static String UPLOAD_URL = "https://mon.zijieapi.com/monitor/collect/c/cloudcontrol/file";
    public static Map<String, String> map;

    static {
        map = new HashMap();
        BOUNDARY = "cloudMessage" + UUID.randomUUID().toString();
    }

    public CloudMessageUploadService() {
    }

    private static boolean postFile(String r14, File r15, Map<String, String> r16, int r17, String r18, String r19, String r20, long r21, HashMap<String, String> r23) {
        if (TextUtils.isEmpty(r14) == true) goto L80;
        if (r15 == null) goto L80;
        if (r15.exists() == false) goto L80;
        HttpURLConnection r6 = null;
        HttpURLConnection r8 = (HttpURLConnection) new URL(r14).openConnection();     // Catch: Throwable -> L58
        r8.setReadTimeout(30000);     // Catch: Throwable -> L23
        r8.setConnectTimeout(30000);     // Catch: Throwable -> L23
        r8.setDoInput(true);     // Catch: Throwable -> L23
        r8.setDoOutput(true);     // Catch: Throwable -> L23
        r8.setUseCaches(false);     // Catch: Throwable -> L23
        r8.setRequestMethod(HttpMethodContrants.POST);     // Catch: Throwable -> L23
        r8.setRequestProperty("Charset", ENCODE);     // Catch: Throwable -> L23
        r8.setRequestProperty(WsConstants.KEY_CONNECTION, "keep-alive");     // Catch: Throwable -> L23
        r8.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + BOUNDARY);     // Catch: Throwable -> L23
        Map<String, String> r5 = map;     // Catch: Throwable -> L23
        if (r5 != null) goto L13;
    L26:
        r8.connect();     // Catch: Throwable -> L23
        DataOutputStream r7 = new DataOutputStream(r8.getOutputStream());     // Catch: Throwable -> L23
        StringBuffer r9 = new StringBuffer();     // Catch: Throwable -> L36
        r9.append(PREFIX);     // Catch: Throwable -> L36
        String r10 = BOUNDARY;     // Catch: Throwable -> L36
        r9.append(r10);     // Catch: Throwable -> L36
        r9.append(LINE_END);     // Catch: Throwable -> L36
        r9.append("Content-Disposition: form-data; name=\"status\"\r\n\r\n" + r17 + LINE_END + PREFIX + r10 + LINE_END);     // Catch: Throwable -> L36
        r9.append("Content-Disposition: form-data; name=\"cid\"\r\n\r\n" + r19 + LINE_END + PREFIX + r10 + LINE_END);     // Catch: Throwable -> L36
        r9.append("Content-Disposition: form-data; name=\"err_msg\"\r\n\r\n" + r20 + LINE_END + PREFIX + r10 + LINE_END);     // Catch: Throwable -> L36
        r9.append("Content-Disposition: form-data; name=\"operate_time\"\r\n\r\n" + r21 + LINE_END + PREFIX + r10 + LINE_END);     // Catch: Throwable -> L36
        StringBuilder r11 = new StringBuilder();     // Catch: Throwable -> L36
        r11.append("Content-Disposition: form-data; name=\"aid\"\r\n\r\n");     // Catch: Throwable -> L36
        CloudMessageManager.getInstance();     // Catch: Throwable -> L36
        r11.append(CloudMessageManager.getAid());     // Catch: Throwable -> L36
        r11.append(LINE_END);     // Catch: Throwable -> L36
        r11.append(PREFIX);     // Catch: Throwable -> L36
        r11.append(r10);     // Catch: Throwable -> L36
        r11.append(LINE_END);     // Catch: Throwable -> L36
        r9.append(r11.toString());     // Catch: Throwable -> L36
        StringBuilder r12 = new StringBuilder();     // Catch: Throwable -> L36
        r12.append("Content-Disposition: form-data; name=\"update_version_code\"\r\n\r\n");     // Catch: Throwable -> L36
        CloudMessageManager.getInstance();     // Catch: Throwable -> L36
        r12.append(CloudMessageManager.getUpdateVersionCode());     // Catch: Throwable -> L36
        r12.append(LINE_END);     // Catch: Throwable -> L36
        r12.append(PREFIX);     // Catch: Throwable -> L36
        r12.append(r10);     // Catch: Throwable -> L36
        r12.append(LINE_END);     // Catch: Throwable -> L36
        r9.append(r12.toString());     // Catch: Throwable -> L36
        StringBuilder r13 = new StringBuilder();     // Catch: Throwable -> L36
        r13.append("Content-Disposition: form-data; name=\"uid\"\r\n\r\n");     // Catch: Throwable -> L36
        CloudMessageManager.getInstance();     // Catch: Throwable -> L36
        r13.append(CloudMessageManager.getUid());     // Catch: Throwable -> L36
        r13.append(LINE_END);     // Catch: Throwable -> L36
        r13.append(PREFIX);     // Catch: Throwable -> L36
        r13.append(r10);     // Catch: Throwable -> L36
        r13.append(LINE_END);     // Catch: Throwable -> L36
        r9.append(r13.toString());     // Catch: Throwable -> L36
        if (r17 != 2) goto L30;
    L38:
        r7.write(r9.toString().getBytes());     // Catch: Throwable -> L36
        writeAddtionalInfo(r7, r23);     // Catch: Throwable -> L36
        r9.setLength(0);     // Catch: Throwable -> L36
    L39:
        r9.append("Content-Disposition: form-data; name=\"file\"; filetype=\"" + r18 + "\"; filename=\"" + r15.getName() + "\"" + LINE_END);     // Catch: Throwable -> L36
        r9.append("Content-Type: text/plain\r\n");     // Catch: Throwable -> L36
        r9.append(LINE_END);     // Catch: Throwable -> L36
        r7.write(r9.toString().getBytes());     // Catch: Throwable -> L36
        FileInputStream r1 = new FileInputStream(r15);     // Catch: Throwable -> L36
        byte[] r0 = new byte[1024];     // Catch: Throwable -> L36
    L40:
        int r2 = r1.read(r0);     // Catch: Throwable -> L36
        if (r2 == (-1)) goto L43;
        r7.write(r0, 0, r2);     // Catch: Throwable -> L36
        goto L40
    L43:
        r1.close();     // Catch: Throwable -> L36
        r7.write(LINE_END.getBytes());     // Catch: Throwable -> L36
        r7.write((PREFIX + BOUNDARY + PREFIX + LINE_END).getBytes());     // Catch: Throwable -> L36
        r7.flush();     // Catch: Throwable -> L36
        r7.close();     // Catch: Throwable -> L36
        if (r8.getResponseCode() != 200) goto L52;
        r8.disconnect();
        r7.close();     // Catch: Throwable -> L49
    L51:
        return true;
    L49:
        th = move-exception;
        th.printStackTrace();
        goto L51
    L52:
        r8.disconnect();
        r7.close();     // Catch: Throwable -> L55
    L57:
        return false;
    L55:
        th = move-exception;
        th.printStackTrace();
        goto L57
    L30:
        if (r17 == 3) goto L38;
        if (r17 != 0) goto L39;
        if (r23 == null) goto L39;
        if (r23.isEmpty() == true) goto L39;
    L36:
        th = th;
    L25:
        r6 = r8;
    L83:
        th.printStackTrace();     // Catch: Throwable -> L69
        if (r6 == null) goto L63;
        r6.disconnect();
    L63:
        if (r7 != null) goto L93;
    L68:
        return false;
    L93:
        r7.close();     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        th.printStackTrace();
    L69:
        th = move-exception;
        if (r6 == null) goto L73;
        r6.disconnect();
    L73:
        if (r7 == null) goto L106;
        r7.close();     // Catch: Throwable -> L76
        throw th;
    L76:
        th = move-exception;
        th.printStackTrace();
        throw th;
    L106:
        throw th;
    L13:
        if (r5.isEmpty() == true) goto L26;
        Iterator<Map.Entry<String, String>> r22 = map.entrySet().iterator();     // Catch: Throwable -> L23
    L16:
        if (r22.hasNext() == false) goto L26;
        Map.Entry<String, String> r110 = r22.next();     // Catch: Throwable -> L23
        String r111 = r110.getKey();     // Catch: Throwable -> L23
        String r112 = r110.getValue();     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r111) == true) goto L16;
        if (TextUtils.isEmpty(r112) == true) goto L16;
        r8.setRequestProperty(r111, r112);     // Catch: Throwable -> L23
    L23:
        th = th;
        r7 = null;
    L58:
        th = th;
        r7 = null;
    L80:
        throw new IllegalArgumentException("url and file not be null ");
    }

    private static boolean postWithoutFile(String r8, Map<String, String> r9, int r10, String r11, String r12, long r13, HashMap<String, String> r15) {
        HttpURLConnection r3 = null;
        HttpURLConnection r14 = (HttpURLConnection) new URL(r8).openConnection();     // Catch: Throwable -> L49
        r14.setReadTimeout(30000);     // Catch: Throwable -> L18
        r14.setConnectTimeout(30000);     // Catch: Throwable -> L18
        r14.setDoInput(true);     // Catch: Throwable -> L18
        r14.setDoOutput(true);     // Catch: Throwable -> L18
        r14.setUseCaches(false);     // Catch: Throwable -> L18
        r14.setRequestMethod(HttpMethodContrants.POST);     // Catch: Throwable -> L18
        r14.setRequestProperty("Charset", ENCODE);     // Catch: Throwable -> L18
        r14.setRequestProperty(WsConstants.KEY_CONNECTION, "keep-alive");     // Catch: Throwable -> L18
        r14.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + BOUNDARY);     // Catch: Throwable -> L18
        Map<String, String> r1 = map;     // Catch: Throwable -> L18
        if (r1 != null) goto L8;
    L21:
        r14.connect();     // Catch: Throwable -> L18
        DataOutputStream r2 = new DataOutputStream(r14.getOutputStream());     // Catch: Throwable -> L18
        StringBuffer r4 = new StringBuffer();     // Catch: Throwable -> L31
        r4.append(PREFIX);     // Catch: Throwable -> L31
        String r5 = BOUNDARY;     // Catch: Throwable -> L31
        r4.append(r5);     // Catch: Throwable -> L31
        r4.append(LINE_END);     // Catch: Throwable -> L31
        r4.append("Content-Disposition: form-data; name=\"status\"\r\n\r\n" + r10 + LINE_END + PREFIX + r5 + LINE_END);     // Catch: Throwable -> L31
        r4.append("Content-Disposition: form-data; name=\"cid\"\r\n\r\n" + r11 + LINE_END + PREFIX + r5 + LINE_END);     // Catch: Throwable -> L31
        r4.append("Content-Disposition: form-data; name=\"err_msg\"\r\n\r\n" + r12 + LINE_END + PREFIX + r5 + LINE_END);     // Catch: Throwable -> L31
        StringBuilder r16 = new StringBuilder();     // Catch: Throwable -> L31
        r16.append("Content-Disposition: form-data; name=\"aid\"\r\n\r\n");     // Catch: Throwable -> L31
        CloudMessageManager.getInstance();     // Catch: Throwable -> L31
        r16.append(CloudMessageManager.getAid());     // Catch: Throwable -> L31
        r16.append(LINE_END);     // Catch: Throwable -> L31
        r16.append(PREFIX);     // Catch: Throwable -> L31
        r16.append(r5);     // Catch: Throwable -> L31
        r16.append(LINE_END);     // Catch: Throwable -> L31
        r4.append(r16.toString());     // Catch: Throwable -> L31
        StringBuilder r17 = new StringBuilder();     // Catch: Throwable -> L31
        r17.append("Content-Disposition: form-data; name=\"update_version_code\"\r\n\r\n");     // Catch: Throwable -> L31
        CloudMessageManager.getInstance();     // Catch: Throwable -> L31
        r17.append(CloudMessageManager.getUpdateVersionCode());     // Catch: Throwable -> L31
        r17.append(LINE_END);     // Catch: Throwable -> L31
        r17.append(PREFIX);     // Catch: Throwable -> L31
        r17.append(r5);     // Catch: Throwable -> L31
        r17.append(LINE_END);     // Catch: Throwable -> L31
        r4.append(r17.toString());     // Catch: Throwable -> L31
        r4.append("Content-Disposition: form-data; name=\"operate_time\"\r\n\r\n" + r13 + LINE_END + PREFIX + r5 + LINE_END);     // Catch: Throwable -> L31
        if (r10 != 2) goto L25;
    L33:
        r2.write(r4.toString().getBytes());     // Catch: Throwable -> L31
        writeAddtionalInfo(r2, r15);     // Catch: Throwable -> L31
        r4.setLength(0);     // Catch: Throwable -> L31
    L34:
        StringBuilder r18 = new StringBuilder();     // Catch: Throwable -> L31
        r18.append("Content-Disposition: form-data; name=\"uid\"\r\n\r\n");     // Catch: Throwable -> L31
        CloudMessageManager.getInstance();     // Catch: Throwable -> L31
        r18.append(CloudMessageManager.getUid());     // Catch: Throwable -> L31
        r18.append(LINE_END);     // Catch: Throwable -> L31
        r18.append(PREFIX);     // Catch: Throwable -> L31
        r18.append(r5);     // Catch: Throwable -> L31
        r18.append(LINE_END);     // Catch: Throwable -> L31
        r4.append(r18.toString());     // Catch: Throwable -> L31
        r2.write(r4.toString().getBytes());     // Catch: Throwable -> L31
        r2.flush();     // Catch: Throwable -> L31
        r2.close();     // Catch: Throwable -> L31
        if (r14.getResponseCode() != 200) goto L43;
        r14.disconnect();
        r2.close();     // Catch: Throwable -> L40
    L42:
        return true;
    L40:
        th = move-exception;
        th.printStackTrace();
        goto L42
    L43:
        r14.disconnect();
        r2.close();     // Catch: Throwable -> L46
    L48:
        return false;
    L46:
        th = move-exception;
        th.printStackTrace();
        goto L48
    L25:
        if (r10 == 3) goto L33;
        if (r10 != 0) goto L34;
        if (r15 == null) goto L34;
        if (r15.isEmpty() == true) goto L34;
    L31:
        th = th;
    L20:
        r3 = r14;
    L81:
        th.printStackTrace();     // Catch: Throwable -> L60
        if (r3 == null) goto L54;
        r3.disconnect();
    L54:
        if (r2 != null) goto L71;
    L59:
        return false;
    L71:
        r2.close();     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        th.printStackTrace();
    L60:
        th = move-exception;
        if (r3 == null) goto L63;
        r3.disconnect();
    L63:
        if (r2 != null) goto L75;
    L68:
        throw th;
    L75:
        r2.close();     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        th.printStackTrace();
        goto L68
    L8:
        if (r1.isEmpty() == true) goto L21;
        Iterator<Map.Entry<String, String>> r6 = map.entrySet().iterator();     // Catch: Throwable -> L18
    L11:
        if (r6.hasNext() == false) goto L21;
        Map.Entry<String, String> r7 = r6.next();     // Catch: Throwable -> L18
        String r19 = r7.getKey();     // Catch: Throwable -> L18
        String r20 = r7.getValue();     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(r19) == true) goto L11;
        if (TextUtils.isEmpty(r20) == true) goto L11;
        r14.setRequestProperty(r19, r20);     // Catch: Throwable -> L18
    L18:
        th = th;
        r2 = null;
    L49:
        th = th;
        r2 = null;
        goto L81
    }

    public static boolean uploadData(UploadInfo r8) {
        return postWithoutFile(UPLOAD_URL, null, r8.getCloudMsgResponseCode(), r8.getCommandId(), r8.getErrorMsg(), r8.getOperateTime(), r8.getSpecificParams());
    }

    public static boolean uploadFile(FileUploadInfo r15) {
        int r1 = 0;
        boolean r2 = false;
    L4:
        if (r1 >= r15.getUploadFileAbsluteNames().size()) goto L27;
        File r3 = new File(r15.getUploadFileAbsluteNames().get(r1));
        if (r3.exists() == false) goto L26;
        if (r1 >= (r15.getUploadFileAbsluteNames().size() - 1)) goto L11;
        int r4 = 1;
    L13:
        if (r15.isForceUseState() == false) goto L15;
        r4 = r15.getCloudMsgResponseCode();
    L15:
        boolean r5 = postFile(UPLOAD_URL, r3, null, r4, r15.getFileType(), r15.getCommandId(), r15.getErrorMsg(), r15.getOperateTime(), r15.getSpecificParams());
        if (r5 == true) goto L18;
    L20:
        if (r1 != 0) goto L22;
        r2 = r5;
        goto L26
    L22:
        if (r2 == false) goto L25;
        if (r5 == false) goto L25;
        r2 = true;
    L25:
        r2 = false;
        goto L26
    L18:
        if (r15.isCompress() == false) goto L20;
        r3.delete();
        goto L20
    L11:
        r4 = 2;
    L26:
        r1 = r1 + 1;
        goto L4
    L27:
        return r2;
    }

    private static void writeAddtionalInfo(DataOutputStream r4, HashMap<String, String> r5) {
        if (CloudMessageManager.getInstance().getCommonParams() != null) goto L5;
    L7:
        if (r5 != null) goto L9;
        return;
    L9:
        if (r5.size() == 0) goto L13;
        r4.write("Content-Disposition: form-data; name=\"fileSpecific\"; filetype=\"command_specificparams\"; filename=\"specific_params.txt\"\r\nContent-Type: text/plain\r\n\r\n".getBytes());
        r4.write(StringUtils.getJsonString(r5).getBytes());
        r4.write(LINE_END.getBytes());
        r4.write((PREFIX + BOUNDARY + LINE_END).getBytes());
        r4.flush();
        return;
    L13:
        return;
    L5:
        if (CloudMessageManager.getInstance().getCommonParams().size() == 0) goto L7;
        r4.write("Content-Disposition: form-data; name=\"fileCommon\"; filetype=\"command_commonparams\"; filename=\"common_params.txt\"\r\nContent-Type: text/plain\r\n\r\n".getBytes());
        r4.write(StringUtils.getJsonString(CloudMessageManager.getInstance().getCommonParams()).getBytes());
        r4.write(LINE_END.getBytes());
        r4.write((PREFIX + BOUNDARY + LINE_END).getBytes());
        r4.flush();
        goto L7
    }

    public static boolean uploadFile(File r10, int r11, String r12, String r13, String r14, long r15, HashMap<String, String> r17) {
        return postFile(UPLOAD_URL, r10, null, r11, r12, r13, r14, r15, r17);
    }
}
