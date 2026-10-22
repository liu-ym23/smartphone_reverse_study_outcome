package com.slardaros.client.monitor.network.httpurlconnection;

import com.obric.olog.OLog;
import com.slardaros.client.monitor.io.CInputStream;
import com.slardaros.client.monitor.io.CountingOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class HttpURLConnectionExtension extends HttpURLConnection {
    private static final String TAG = "HttpURLConnectionExtension";
    private HttpURLConnection impl;
    private TransactionState transactionState;

    static /* synthetic */ void access$000(HttpURLConnectionExtension r0, Exception r1) {
        r0.error(r1);
    }

    static /* synthetic */ HttpURLConnection access$100(HttpURLConnectionExtension r0) {
        return r0.impl;
    }

    static /* synthetic */ void access$200(HttpURLConnectionExtension r0, TransactionState r1) {
        r0.addTransactionAndErrorData(r1);
    }

    public HttpURLConnectionExtension(HttpURLConnection r2) {
        super(r2.getURL());
        this.impl = r2;
    }

    @Override // java.net.URLConnection
    public void addRequestProperty(String r1, String r2) {
        this.impl.addRequestProperty(r1, r2);
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        TransactionState r0 = this.transactionState;
        if (r0 != null) goto L5;
    L7:
        this.impl.disconnect();
        return;
    L5:
        if (r0.isComplete() == true) goto L7;
        addTransactionAndErrorData(this.transactionState);
        goto L7
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return this.impl.usingProxy();
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        getTransactionState();
        this.impl.connect();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        error(e);
        throw e;
    }

    @Override // java.net.URLConnection
    public boolean getAllowUserInteraction() {
        return this.impl.getAllowUserInteraction();
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        return this.impl.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public Object getContent() throws IOException {
        getTransactionState();
        Object r0 = this.impl.getContent();     // Catch: IOException -> L10
        int r1 = this.impl.getContentLength();
        if (r1 < 0) goto L9;
        TransactionState r2 = getTransactionState();
        if (r2.isComplete() == true) goto L9;
        r2.setBytesReceived(r1);
        addTransactionAndErrorData(r2);
    L9:
        return r0;
    L10:
        e = move-exception;
        error(e);
        throw e;
    }

    @Override // java.net.URLConnection
    public Object getContent(Class[] r2) throws IOException {
        getTransactionState();
        Object r3 = this.impl.getContent(r2);     // Catch: IOException -> L6
        checkResponse();
        return r3;
    L6:
        e = move-exception;
        error(e);
        throw e;
    }

    @Override // java.net.URLConnection
    public String getContentEncoding() {
        getTransactionState();
        String r0 = this.impl.getContentEncoding();
        checkResponse();
        return r0;
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        getTransactionState();
        int r0 = this.impl.getContentLength();
        checkResponse();
        return r0;
    }

    @Override // java.net.URLConnection
    public String getContentType() {
        getTransactionState();
        String r0 = this.impl.getContentType();
        checkResponse();
        return r0;
    }

    @Override // java.net.URLConnection
    public long getDate() {
        getTransactionState();
        long r0 = this.impl.getDate();
        checkResponse();
        return r0;
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        getTransactionState();
        return new CInputStream(this.impl.getErrorStream(), true);
    L5:
        e = move-exception;
        OLog.e(TAG, e.toString());
        return this.impl.getErrorStream();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(String r2, long r3) {
        getTransactionState();
        long r4 = this.impl.getHeaderFieldDate(r2, r3);
        checkResponse();
        return r4;
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        return this.impl.getInstanceFollowRedirects();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        return this.impl.getPermission();
    }

    @Override // java.net.HttpURLConnection
    public String getRequestMethod() {
        return this.impl.getRequestMethod();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        getTransactionState();
        int r0 = this.impl.getResponseCode();     // Catch: IOException -> L6
        checkResponse();
        return r0;
    L6:
        e = move-exception;
        error(e);
        throw e;
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        getTransactionState();
        String r0 = this.impl.getResponseMessage();     // Catch: IOException -> L6
        checkResponse();
        return r0;
    L6:
        e = move-exception;
        error(e);
        throw e;
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int r1) {
        this.impl.setChunkedStreamingMode(r1);
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int r1) {
        this.impl.setFixedLengthStreamingMode(r1);
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean r1) {
        this.impl.setInstanceFollowRedirects(r1);
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String r2) throws ProtocolException {
        getTransactionState();
        this.impl.setRequestMethod(r2);     // Catch: ProtocolException -> L5
        return;
    L5:
        e = move-exception;
        error(e);
        throw e;
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        return this.impl.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        return this.impl.getDoInput();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        return this.impl.getDoOutput();
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        getTransactionState();
        long r0 = this.impl.getExpiration();
        checkResponse();
        return r0;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public String getHeaderField(int r2) {
        getTransactionState();
        String r3 = this.impl.getHeaderField(r2);
        checkResponse();
        return r3;
    }

    @Override // java.net.URLConnection
    public String getHeaderField(String r2) {
        getTransactionState();
        String r3 = this.impl.getHeaderField(r2);
        checkResponse();
        return r3;
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(String r2, int r3) {
        getTransactionState();
        int r4 = this.impl.getHeaderFieldInt(r2, r3);
        checkResponse();
        return r4;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public String getHeaderFieldKey(int r2) {
        getTransactionState();
        String r3 = this.impl.getHeaderFieldKey(r2);
        checkResponse();
        return r3;
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        getTransactionState();
        Map<String, List<String>> r0 = this.impl.getHeaderFields();
        checkResponse();
        return r0;
    }

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        getTransactionState();
        long r0 = this.impl.getIfModifiedSince();
        checkResponse();
        return r0;
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        final TransactionState r0 = getTransactionState();
        CInputStream r1 = new CInputStream(this.impl.getInputStream());     // Catch: IOException -> L6
        TransactionStateUtil.inspectAndInstrumentResponse(r0, this.impl);     // Catch: IOException -> L6
        r1.addStreamCompleteListener(new AnonymousClass1(this, r0));
        return r1;
    L6:
        e = move-exception;
        error(e);
        throw e;
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        getTransactionState();
        long r0 = this.impl.getLastModified();
        checkResponse();
        return r0;
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        final TransactionState r0 = getTransactionState();
        CountingOutputStream r1 = new CountingOutputStream(this.impl.getOutputStream());     // Catch: IOException -> L6
        r1.addStreamCompleteListener(new AnonymousClass2(this, r0));
        return r1;
    L6:
        e = move-exception;
        error(e);
        throw e;
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        return this.impl.getReadTimeout();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        return this.impl.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String r1) {
        return this.impl.getRequestProperty(r1);
    }

    @Override // java.net.URLConnection
    public URL getURL() {
        return this.impl.getURL();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        return this.impl.getUseCaches();
    }

    @Override // java.net.URLConnection
    public void setAllowUserInteraction(boolean r1) {
        this.impl.setAllowUserInteraction(r1);
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int r1) {
        this.impl.setConnectTimeout(r1);
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean r1) {
        this.impl.setDefaultUseCaches(r1);
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean r1) {
        this.impl.setDoInput(r1);
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean r1) {
        this.impl.setDoOutput(r1);
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long r1) {
        this.impl.setIfModifiedSince(r1);
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int r1) {
        this.impl.setReadTimeout(r1);
    }

    @Override // java.net.URLConnection
    public void setRequestProperty(String r1, String r2) {
        this.impl.setRequestProperty(r1, r2);
    }

    @Override // java.net.URLConnection
    public void setUseCaches(boolean r1) {
        this.impl.setUseCaches(r1);
    }

    @Override // java.net.URLConnection
    public String toString() {
        return this.impl.toString();
    }

    private void checkResponse() {
        if (getTransactionState().isComplete() == true) goto L6;
        TransactionStateUtil.inspectAndInstrumentResponse(getTransactionState(), this.impl);
        return;
    }

    private TransactionState getTransactionState() {
        if (this.transactionState != null) goto L6;
        TransactionState r0 = new TransactionState();
        this.transactionState = r0;
        TransactionStateUtil.inspectAndInstrument(r0, this.impl);
    L6:
        return this.transactionState;
    }

    private void error(Exception r2) {
        TransactionState r0 = getTransactionState();
        TransactionStateUtil.setErrorCodeFromException(r0, r2);
        if (r0.isComplete() == true) goto L6;
        TransactionStateUtil.inspectAndInstrumentResponse(r0, this.impl);
        MonitorRecorder.reportMonitorData(r0, "httpurlconnection");
        return;
    }

    private void addTransactionAndErrorData(TransactionState r1) {
        MonitorRecorder.reportMonitorData(r1, "httpurlconnection");
    }
}
