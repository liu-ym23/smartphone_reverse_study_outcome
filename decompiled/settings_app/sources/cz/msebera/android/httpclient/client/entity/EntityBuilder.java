package cz.msebera.android.httpclient.client.entity;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.entity.AbstractHttpEntity;
import cz.msebera.android.httpclient.entity.BasicHttpEntity;
import cz.msebera.android.httpclient.entity.ByteArrayEntity;
import cz.msebera.android.httpclient.entity.ContentType;
import cz.msebera.android.httpclient.entity.FileEntity;
import cz.msebera.android.httpclient.entity.InputStreamEntity;
import cz.msebera.android.httpclient.entity.SerializableEntity;
import cz.msebera.android.httpclient.entity.StringEntity;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class EntityBuilder {
    private byte[] binary;
    private boolean chunked;
    private String contentEncoding;
    private ContentType contentType;
    private File file;
    private boolean gzipCompress;
    private List<NameValuePair> parameters;
    private Serializable serializable;
    private InputStream stream;
    private String text;

    EntityBuilder() {
    }

    public static EntityBuilder create() {
        return new EntityBuilder();
    }

    private void clearContent() {
        this.text = null;
        this.binary = null;
        this.stream = null;
        this.parameters = null;
        this.serializable = null;
        this.file = null;
    }

    public String getText() {
        return this.text;
    }

    public EntityBuilder setText(String r1) {
        clearContent();
        this.text = r1;
        return this;
    }

    public byte[] getBinary() {
        return this.binary;
    }

    public EntityBuilder setBinary(byte[] r1) {
        clearContent();
        this.binary = r1;
        return this;
    }

    public InputStream getStream() {
        return this.stream;
    }

    public EntityBuilder setStream(InputStream r1) {
        clearContent();
        this.stream = r1;
        return this;
    }

    public List<NameValuePair> getParameters() {
        return this.parameters;
    }

    public EntityBuilder setParameters(List<NameValuePair> r1) {
        clearContent();
        this.parameters = r1;
        return this;
    }

    public EntityBuilder setParameters(NameValuePair... r1) {
        return setParameters(Arrays.asList(r1));
    }

    public Serializable getSerializable() {
        return this.serializable;
    }

    public EntityBuilder setSerializable(Serializable r1) {
        clearContent();
        this.serializable = r1;
        return this;
    }

    public File getFile() {
        return this.file;
    }

    public EntityBuilder setFile(File r1) {
        clearContent();
        this.file = r1;
        return this;
    }

    public ContentType getContentType() {
        return this.contentType;
    }

    public EntityBuilder setContentType(ContentType r1) {
        this.contentType = r1;
        return this;
    }

    public String getContentEncoding() {
        return this.contentEncoding;
    }

    public EntityBuilder setContentEncoding(String r1) {
        this.contentEncoding = r1;
        return this;
    }

    public boolean isChunked() {
        return this.chunked;
    }

    public EntityBuilder chunked() {
        this.chunked = true;
        return this;
    }

    public boolean isGzipCompress() {
        return this.gzipCompress;
    }

    public EntityBuilder gzipCompress() {
        this.gzipCompress = true;
        return this;
    }

    private ContentType getContentOrDefault(ContentType r1) {
        ContentType r0 = this.contentType;
        if (r0 != null) goto L5;
        return r1;
    L5:
        return r0;
    }

    public HttpEntity build() {
        if (this.text == null) goto L6;
        AbstractHttpEntity r0 = new StringEntity(this.text, getContentOrDefault(ContentType.DEFAULT_TEXT));
    L26:
        if (r0.getContentType() == null) goto L30;
        ContentType r1 = this.contentType;
        if (r1 == null) goto L30;
        r0.setContentType(r1.toString());
    L30:
        r0.setContentEncoding(this.contentEncoding);
        r0.setChunked(this.chunked);
        if (this.gzipCompress == true) goto L33;
        return r0;
    L33:
        return new GzipCompressingEntity(r0);
    L6:
        if (this.binary == null) goto L9;
        r0 = new ByteArrayEntity(this.binary, getContentOrDefault(ContentType.DEFAULT_BINARY));
        goto L26
    L9:
        if (this.stream == null) goto L12;
        r0 = new InputStreamEntity(this.stream, -1, getContentOrDefault(ContentType.DEFAULT_BINARY));
        goto L26
    L12:
        if (this.parameters == null) goto L19;
        List<NameValuePair> r2 = this.parameters;
        ContentType r3 = this.contentType;
        if (r3 == null) goto L16;
        Charset r4 = r3.getCharset();
    L17:
        r0 = new UrlEncodedFormEntity(r2, r4);
        goto L26
    L16:
        r4 = null;
        goto L17
    L19:
        if (this.serializable == null) goto L22;
        r0 = new SerializableEntity(this.serializable);
        r0.setContentType(ContentType.DEFAULT_BINARY.toString());
        goto L26
    L22:
        if (this.file == null) goto L24;
        r0 = new FileEntity(this.file, getContentOrDefault(ContentType.DEFAULT_BINARY));
        goto L26
    L24:
        r0 = new BasicHttpEntity();
        goto L26
    }
}
