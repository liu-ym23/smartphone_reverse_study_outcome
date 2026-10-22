package com.loopj.android.http;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.client.entity.UrlEncodedFormEntity;
import cz.msebera.android.httpclient.client.utils.URLEncodedUtils;
import cz.msebera.android.httpclient.message.BasicNameValuePair;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListMap;

/* JADX INFO: loaded from: classes4.dex */
public class RequestParams implements Serializable {
    public static final String APPLICATION_JSON = "application/json";
    public static final String APPLICATION_OCTET_STREAM = "application/octet-stream";
    protected static final String LOG_TAG = "RequestParams";
    protected boolean autoCloseInputStreams;
    protected String contentEncoding;
    protected String elapsedFieldInJsonStreamer;
    protected final ConcurrentSkipListMap<String, List<FileWrapper>> fileArrayParams;
    protected final ConcurrentSkipListMap<String, FileWrapper> fileParams;
    protected boolean forceMultipartEntity;
    protected boolean isRepeatable;
    protected final ConcurrentSkipListMap<String, StreamWrapper> streamParams;
    protected final ConcurrentSkipListMap<String, String> urlParams;
    protected final ConcurrentSkipListMap<String, Object> urlParamsWithObjects;
    protected boolean useJsonStreamer;

    public static class FileWrapper implements Serializable {
        public final String contentType;
        public final String customFileName;
        public final File file;

        public FileWrapper(File r1, String r2, String r3) {
            this.file = r1;
            this.contentType = r2;
            this.customFileName = r3;
        }
    }

    public static class StreamWrapper {
        public final boolean autoClose;
        public final String contentType;
        public final InputStream inputStream;
        public final String name;

        public StreamWrapper(InputStream r1, String r2, String r3, boolean r4) {
            this.inputStream = r1;
            this.name = r2;
            this.contentType = r3;
            this.autoClose = r4;
        }

        static StreamWrapper newInstance(InputStream r1, String r2, String r3, boolean r4) {
            if (r3 != null) goto L6;
            r3 = "application/octet-stream";
        L6:
            return new StreamWrapper(r1, r2, r3, r4);
        }
    }

    public RequestParams() {
        Map r1 = (Map) null;
        this(null);
    }

    public RequestParams(Map<String, String> r3) {
        this.urlParams = new ConcurrentSkipListMap();
        this.streamParams = new ConcurrentSkipListMap();
        this.fileParams = new ConcurrentSkipListMap();
        this.fileArrayParams = new ConcurrentSkipListMap();
        this.urlParamsWithObjects = new ConcurrentSkipListMap();
        this.forceMultipartEntity = false;
        this.elapsedFieldInJsonStreamer = "_elapsed";
        this.contentEncoding = "UTF-8";
        if (r3 == null) goto L8;
        Iterator<Map.Entry<String, String>> r4 = r3.entrySet().iterator();
    L6:
        if (r4.hasNext() == false) goto L10;
        Map.Entry<String, String> r0 = r4.next();
        put(r0.getKey(), r0.getValue());
        goto L6
    L10:
        return;
    }

    public RequestParams(final String r2, final String r3) {
        this(new AnonymousClass1(r2, r3));
    }

    public RequestParams(Object... r5) {
        this.urlParams = new ConcurrentSkipListMap();
        this.streamParams = new ConcurrentSkipListMap();
        this.fileParams = new ConcurrentSkipListMap();
        this.fileArrayParams = new ConcurrentSkipListMap();
        this.urlParamsWithObjects = new ConcurrentSkipListMap();
        int r0 = 0;
        this.forceMultipartEntity = false;
        this.elapsedFieldInJsonStreamer = "_elapsed";
        this.contentEncoding = "UTF-8";
        int r1 = r5.length;
        if ((r1 % 2) != 0) goto L8;
    L4:
        if (r0 >= r1) goto L6;
        put(String.valueOf(r5[r0]), String.valueOf(r5[r0 + 1]));
        r0 = r0 + 2;
        goto L4
    L6:
        return;
    L8:
        throw new IllegalArgumentException("Supplied arguments must be even");
    }

    public void setContentEncoding(String r2) {
        if (r2 == null) goto L4;
        this.contentEncoding = r2;
        return;
    L4:
        AsyncHttpClient.log.d(LOG_TAG, "setContentEncoding called with null attribute");
    }

    public void setForceMultipartEntityContentType(boolean r1) {
        this.forceMultipartEntity = r1;
    }

    public void put(String r1, String r2) {
        if (r1 == null) goto L6;
        if (r2 == null) goto L7;
        this.urlParams.put(r1, r2);
        return;
    L7:
        return;
    }

    public void put(String r2, File[] r3) throws FileNotFoundException {
        put(r2, r3, null, null);
    }

    public void put(String r6, File[] r7, String r8, String r9) throws FileNotFoundException {
        if (r6 == null) goto L17;
        ArrayList r0 = new ArrayList();
        int r1 = r7.length;
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L12;
        File r3 = r7[r2];
        if (r3 == null) goto L11;
        if (r3.exists() == false) goto L11;
        r0.add(new FileWrapper(r3, r8, r9));
        r2 = r2 + 1;
    L11:
        throw new FileNotFoundException();
    L12:
        this.fileArrayParams.put(r6, r0);
        return;
    }

    public void put(String r2, File r3) throws FileNotFoundException {
        put(r2, r3, null, null);
    }

    public void put(String r2, String r3, File r4) throws FileNotFoundException {
        put(r2, r4, null, r3);
    }

    public void put(String r2, File r3, String r4) throws FileNotFoundException {
        put(r2, r3, r4, null);
    }

    public void put(String r2, File r3, String r4, String r5) throws FileNotFoundException {
        if (r3 == null) goto L9;
        if (r3.exists() == false) goto L9;
        if (r2 == null) goto L10;
        this.fileParams.put(r2, new FileWrapper(r3, r4, r5));
        return;
    L10:
        return;
    L9:
        throw new FileNotFoundException();
    }

    public void put(String r2, InputStream r3) {
        put(r2, r3, null);
    }

    public void put(String r2, InputStream r3, String r4) {
        put(r2, r3, r4, null);
    }

    public void put(String r7, InputStream r8, String r9, String r10) {
        put(r7, r8, r9, r10, this.autoCloseInputStreams);
    }

    public void put(String r1, InputStream r2, String r3, String r4, boolean r5) {
        if (r1 == null) goto L6;
        if (r2 == null) goto L7;
        this.streamParams.put(r1, StreamWrapper.newInstance(r2, r3, r4, r5));
        return;
    L7:
        return;
    }

    public void put(String r1, Object r2) {
        if (r1 == null) goto L6;
        if (r2 == null) goto L7;
        this.urlParamsWithObjects.put(r1, r2);
        return;
    L7:
        return;
    }

    public void put(String r1, int r2) {
        if (r1 == null) goto L5;
        this.urlParams.put(r1, String.valueOf(r2));
        return;
    }

    public void put(String r1, long r2) {
        if (r1 == null) goto L5;
        this.urlParams.put(r1, String.valueOf(r2));
        return;
    }

    public void add(String r2, String r3) {
        if (r2 == null) goto L14;
        if (r3 == null) goto L15;
        Object r0 = this.urlParamsWithObjects.get(r2);
        if (r0 != null) goto L8;
        r0 = new HashSet();
        put(r2, r0);
    L8:
        if ((r0 instanceof List) == false) goto L11;
        ((List) r0).add(r3);
        return;
    L11:
        if ((r0 instanceof Set) == false) goto L17;
        ((Set) r0).add(r3);
        return;
    L17:
        return;
    L15:
        return;
    }

    public void remove(String r2) {
        this.urlParams.remove(r2);
        this.streamParams.remove(r2);
        this.fileParams.remove(r2);
        this.urlParamsWithObjects.remove(r2);
        this.fileArrayParams.remove(r2);
    }

    public boolean has(String r2) {
        if (this.urlParams.get(r2) == null) goto L5;
    L14:
        return true;
    L5:
        if (this.streamParams.get(r2) != null) goto L14;
        if (this.fileParams.get(r2) != null) goto L14;
        if (this.urlParamsWithObjects.get(r2) != null) goto L14;
        if (this.fileArrayParams.get(r2) != null) goto L14;
        return false;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        Iterator<Map.Entry<String, String>> r1 = this.urlParams.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        Map.Entry<String, String> r2 = r1.next();
        if (r0.length() <= 0) goto L8;
        r0.append("&");
    L8:
        r0.append(r2.getKey());
        r0.append("=");
        r0.append(r2.getValue());
        goto L4
    L9:
        Iterator<Map.Entry<String, StreamWrapper>> r3 = this.streamParams.entrySet().iterator();
    L11:
        if (r3.hasNext() == false) goto L16;
        Map.Entry<String, StreamWrapper> r4 = r3.next();
        if (r0.length() <= 0) goto L15;
        r0.append("&");
    L15:
        r0.append(r4.getKey());
        r0.append("=");
        r0.append("STREAM");
        goto L11
    L16:
        Iterator<Map.Entry<String, FileWrapper>> r5 = this.fileParams.entrySet().iterator();
    L18:
        if (r5.hasNext() == false) goto L23;
        Map.Entry<String, FileWrapper> r6 = r5.next();
        if (r0.length() <= 0) goto L22;
        r0.append("&");
    L22:
        r0.append(r6.getKey());
        r0.append("=");
        r0.append("FILE");
        goto L18
    L23:
        Iterator<Map.Entry<String, List<FileWrapper>>> r7 = this.fileArrayParams.entrySet().iterator();
    L25:
        if (r7.hasNext() == false) goto L30;
        Map.Entry<String, List<FileWrapper>> r8 = r7.next();
        if (r0.length() <= 0) goto L29;
        r0.append("&");
    L29:
        r0.append(r8.getKey());
        r0.append("=");
        r0.append("FILES(SIZE=").append(r8.getValue().size()).append(")");
        goto L25
    L30:
        Iterator<BasicNameValuePair> r9 = getParamsList(null, this.urlParamsWithObjects).iterator();
    L32:
        if (r9.hasNext() == false) goto L38;
        BasicNameValuePair r10 = r9.next();
        if (r0.length() <= 0) goto L36;
        r0.append("&");
    L36:
        r0.append(r10.getName());
        r0.append("=");
        r0.append(r10.getValue());
        goto L32
    L38:
        return r0.toString();
    }

    public void setHttpEntityIsRepeatable(boolean r1) {
        this.isRepeatable = r1;
    }

    public void setUseJsonStreamer(boolean r1) {
        this.useJsonStreamer = r1;
    }

    public void setElapsedFieldInJsonStreamer(String r1) {
        this.elapsedFieldInJsonStreamer = r1;
    }

    public void setAutoCloseInputStreams(boolean r1) {
        this.autoCloseInputStreams = r1;
    }

    public HttpEntity getEntity(ResponseHandlerInterface r2) throws IOException {
        if (this.useJsonStreamer == false) goto L7;
        return createJsonStreamerEntity(r2);
    L7:
        if (this.forceMultipartEntity == true) goto L17;
        if (this.streamParams.isEmpty() == false) goto L17;
        if (this.fileParams.isEmpty() == false) goto L17;
        if (this.fileArrayParams.isEmpty() == false) goto L17;
        return createFormEntity();
    L17:
        return createMultipartEntity(r2);
    }

    private HttpEntity createJsonStreamerEntity(ResponseHandlerInterface r6) throws IOException {
        if (this.fileParams.isEmpty() == true) goto L5;
    L8:
        boolean r1 = true;
    L9:
        JsonStreamerEntity r0 = new JsonStreamerEntity(r6, r1, this.elapsedFieldInJsonStreamer);
        Iterator<Map.Entry<String, String>> r7 = this.urlParams.entrySet().iterator();
    L11:
        if (r7.hasNext() == false) goto L13;
        Map.Entry<String, String> r2 = r7.next();
        r0.addPart(r2.getKey(), r2.getValue());
        goto L11
    L13:
        Iterator<Map.Entry<String, Object>> r8 = this.urlParamsWithObjects.entrySet().iterator();
    L15:
        if (r8.hasNext() == false) goto L17;
        Map.Entry<String, Object> r3 = r8.next();
        r0.addPart(r3.getKey(), r3.getValue());
        goto L15
    L17:
        Iterator<Map.Entry<String, FileWrapper>> r9 = this.fileParams.entrySet().iterator();
    L19:
        if (r9.hasNext() == false) goto L21;
        Map.Entry<String, FileWrapper> r4 = r9.next();
        r0.addPart(r4.getKey(), r4.getValue());
        goto L19
    L21:
        Iterator<Map.Entry<String, StreamWrapper>> r5 = this.streamParams.entrySet().iterator();
    L23:
        if (r5.hasNext() == false) goto L27;
        Map.Entry<String, StreamWrapper> r10 = r5.next();
        StreamWrapper r11 = r10.getValue();
        if (r11.inputStream == null) goto L23;
        r0.addPart(r10.getKey(), StreamWrapper.newInstance(r11.inputStream, r11.name, r11.contentType, r11.autoClose));
        goto L23
    L27:
        return r0;
    L5:
        if (this.streamParams.isEmpty() == false) goto L8;
        r1 = false;
        goto L9
    }

    private HttpEntity createFormEntity() {
        return new UrlEncodedFormEntity(getParamsList(), this.contentEncoding);
    L4:
        e = move-exception;
        AsyncHttpClient.log.e(LOG_TAG, "createFormEntity failed", e);
        return null;
    }

    private HttpEntity createMultipartEntity(ResponseHandlerInterface r7) throws IOException {
        SimpleMultipartEntity r0 = new SimpleMultipartEntity(r7);
        r0.setIsRepeatable(this.isRepeatable);
        Iterator<Map.Entry<String, String>> r8 = this.urlParams.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        Map.Entry<String, String> r1 = r8.next();
        r0.addPartWithCharset(r1.getKey(), r1.getValue(), this.contentEncoding);
        goto L4
    L6:
        Iterator<BasicNameValuePair> r9 = getParamsList(null, this.urlParamsWithObjects).iterator();
    L8:
        if (r9.hasNext() == false) goto L10;
        BasicNameValuePair r2 = r9.next();
        r0.addPartWithCharset(r2.getName(), r2.getValue(), this.contentEncoding);
        goto L8
    L10:
        Iterator<Map.Entry<String, StreamWrapper>> r10 = this.streamParams.entrySet().iterator();
    L12:
        if (r10.hasNext() == false) goto L16;
        Map.Entry<String, StreamWrapper> r3 = r10.next();
        StreamWrapper r4 = r3.getValue();
        if (r4.inputStream == null) goto L12;
        r0.addPart(r3.getKey(), r4.name, r4.inputStream, r4.contentType);
        goto L12
    L16:
        Iterator<Map.Entry<String, FileWrapper>> r11 = this.fileParams.entrySet().iterator();
    L18:
        if (r11.hasNext() == false) goto L20;
        Map.Entry<String, FileWrapper> r5 = r11.next();
        FileWrapper r6 = r5.getValue();
        r0.addPart(r5.getKey(), r6.file, r6.contentType, r6.customFileName);
        goto L18
    L20:
        Iterator<Map.Entry<String, List<FileWrapper>>> r12 = this.fileArrayParams.entrySet().iterator();
    L22:
        if (r12.hasNext() == false) goto L27;
        Map.Entry<String, List<FileWrapper>> r13 = r12.next();
        Iterator<FileWrapper> r14 = r13.getValue().iterator();
    L25:
        if (r14.hasNext() == false) goto L22;
        FileWrapper r15 = r14.next();
        r0.addPart(r13.getKey(), r15.file, r15.contentType, r15.customFileName);
        goto L25
    L27:
        return r0;
    }

    protected List<BasicNameValuePair> getParamsList() {
        LinkedList r0 = new LinkedList();
        Iterator<Map.Entry<String, String>> r1 = this.urlParams.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry<String, String> r2 = r1.next();
        r0.add(new BasicNameValuePair(r2.getKey(), r2.getValue()));
        goto L4
    L6:
        r0.addAll(getParamsList(null, this.urlParamsWithObjects));
        return r0;
    }

    private List<BasicNameValuePair> getParamsList(String r11, Object r12) {
        LinkedList r0 = new LinkedList();
        if ((r12 instanceof Map) == false) goto L21;
        Map r13 = (Map) r12;
        ArrayList r1 = new ArrayList(r13.keySet());
        if (r1.size() > 0) goto L7;
    L9:
        Iterator r2 = r1.iterator();
    L11:
        if (r2.hasNext() == false) goto L37;
        Object r5 = r2.next();
        if ((r5 instanceof String) == false) goto L11;
        Object r6 = r13.get(r5);
        if (r6 == null) goto L11;
        if (r11 != null) goto L18;
        String r7 = (String) r5;
    L19:
        r0.addAll(getParamsList(r7, r6));
        goto L11
    L18:
        r7 = String.format(Locale.US, "%s[%s]", new Object[]{r11, r5});
    L37:
        return r0;
    L7:
        if ((r1.get(0) instanceof Comparable) == false) goto L9;
        Collections.sort(r1);
        goto L9
    L21:
        if ((r12 instanceof List) == false) goto L26;
        List r14 = (List) r12;
        int r3 = r14.size();
        int r8 = 0;
    L23:
        if (r8 >= r3) goto L37;
        r0.addAll(getParamsList(String.format(Locale.US, "%s[%d]", new Object[]{r11, Integer.valueOf(r8)}), r14.get(r8)));
        r8 = r8 + 1;
        goto L23
    L26:
        if ((r12 instanceof Object[]) == false) goto L31;
        Object[] r15 = (Object[]) r12;
        int r4 = r15.length;
        int r9 = 0;
    L28:
        if (r9 >= r4) goto L37;
        r0.addAll(getParamsList(String.format(Locale.US, "%s[%d]", new Object[]{r11, Integer.valueOf(r9)}), r15[r9]));
        r9 = r9 + 1;
        goto L28
    L31:
        if ((r12 instanceof Set) == false) goto L36;
        Iterator r16 = ((Set) r12).iterator();
    L34:
        if (r16.hasNext() == false) goto L37;
        r0.addAll(getParamsList(r11, r16.next()));
        goto L34
    L36:
        r0.add(new BasicNameValuePair(r11, r12.toString()));
        goto L37
    }

    protected String getParamString() {
        return URLEncodedUtils.format(getParamsList(), this.contentEncoding);
    }
}
