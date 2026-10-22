package cz.msebera.android.httpclient.entity.mime;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.entity.ContentType;
import cz.msebera.android.httpclient.entity.mime.content.ByteArrayBody;
import cz.msebera.android.httpclient.entity.mime.content.ContentBody;
import cz.msebera.android.httpclient.entity.mime.content.FileBody;
import cz.msebera.android.httpclient.entity.mime.content.InputStreamBody;
import cz.msebera.android.httpclient.entity.mime.content.StringBody;
import cz.msebera.android.httpclient.message.BasicNameValuePair;
import cz.msebera.android.httpclient.util.Args;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: classes5.dex */
public class MultipartEntityBuilder {
    private static final String DEFAULT_SUBTYPE = "form-data";
    private static final char[] MULTIPART_CHARS = null;
    private List<FormBodyPart> bodyParts;
    private String boundary;
    private Charset charset;
    private ContentType contentType;
    private HttpMultipartMode mode;

    /* JADX INFO: renamed from: cz.msebera.android.httpclient.entity.mime.MultipartEntityBuilder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cz$msebera$android$httpclient$entity$mime$HttpMultipartMode = null;

        static {
            int[] r0 = new int[HttpMultipartMode.values().length];
            $SwitchMap$cz$msebera$android$httpclient$entity$mime$HttpMultipartMode = r0;
            r0[HttpMultipartMode.BROWSER_COMPATIBLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$cz$msebera$android$httpclient$entity$mime$HttpMultipartMode[HttpMultipartMode.RFC6532.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static {
        MULTIPART_CHARS = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    }

    public static MultipartEntityBuilder create() {
        return new MultipartEntityBuilder();
    }

    MultipartEntityBuilder() {
        this.mode = HttpMultipartMode.STRICT;
        this.boundary = null;
        this.charset = null;
        this.bodyParts = null;
    }

    public MultipartEntityBuilder setMode(HttpMultipartMode r1) {
        this.mode = r1;
        return this;
    }

    public MultipartEntityBuilder setLaxMode() {
        this.mode = HttpMultipartMode.BROWSER_COMPATIBLE;
        return this;
    }

    public MultipartEntityBuilder setStrictMode() {
        this.mode = HttpMultipartMode.STRICT;
        return this;
    }

    public MultipartEntityBuilder setBoundary(String r1) {
        this.boundary = r1;
        return this;
    }

    public MultipartEntityBuilder setMimeSubtype(String r3) {
        Args.notBlank(r3, "MIME subtype");
        this.contentType = ContentType.create("multipart/" + r3);
        return this;
    }

    @Deprecated
    public MultipartEntityBuilder seContentType(ContentType r1) {
        return setContentType(r1);
    }

    public MultipartEntityBuilder setContentType(ContentType r2) {
        Args.notNull(r2, "Content type");
        this.contentType = r2;
        return this;
    }

    public MultipartEntityBuilder setCharset(Charset r1) {
        this.charset = r1;
        return this;
    }

    public MultipartEntityBuilder addPart(FormBodyPart r2) {
        if (r2 != null) goto L5;
        return this;
    L5:
        if (this.bodyParts != null) goto L7;
        this.bodyParts = new ArrayList();
    L7:
        this.bodyParts.add(r2);
        return this;
    }

    public MultipartEntityBuilder addPart(String r2, ContentBody r3) {
        Args.notNull(r2, "Name");
        Args.notNull(r3, "Content body");
        return addPart(FormBodyPartBuilder.create(r2, r3).build());
    }

    public MultipartEntityBuilder addTextBody(String r2, String r3, ContentType r4) {
        return addPart(r2, new StringBody(r3, r4));
    }

    public MultipartEntityBuilder addTextBody(String r2, String r3) {
        return addTextBody(r2, r3, ContentType.DEFAULT_TEXT);
    }

    public MultipartEntityBuilder addBinaryBody(String r2, byte[] r3, ContentType r4, String r5) {
        return addPart(r2, new ByteArrayBody(r3, r4, r5));
    }

    public MultipartEntityBuilder addBinaryBody(String r3, byte[] r4) {
        return addBinaryBody(r3, r4, ContentType.DEFAULT_BINARY, null);
    }

    public MultipartEntityBuilder addBinaryBody(String r2, File r3, ContentType r4, String r5) {
        return addPart(r2, new FileBody(r3, r4, r5));
    }

    public MultipartEntityBuilder addBinaryBody(String r3, File r4) {
        ContentType r0 = ContentType.DEFAULT_BINARY;
        if (r4 == null) goto L5;
        String r1 = r4.getName();
    L7:
        return addBinaryBody(r3, r4, r0, r1);
    L5:
        r1 = null;
        goto L7
    }

    public MultipartEntityBuilder addBinaryBody(String r2, InputStream r3, ContentType r4, String r5) {
        return addPart(r2, new InputStreamBody(r3, r4, r5));
    }

    public MultipartEntityBuilder addBinaryBody(String r3, InputStream r4) {
        return addBinaryBody(r3, r4, ContentType.DEFAULT_BINARY, null);
    }

    private String generateBoundary() {
        StringBuilder r5 = new StringBuilder();
        Random r0 = new Random();
        int r1 = r0.nextInt(11) + 30;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        char[] r3 = MULTIPART_CHARS;
        r5.append(r3[r0.nextInt(r3.length)]);
        r2 = r2 + 1;
        goto L3
    L6:
        return r5.toString();
    }

    MultipartFormEntity buildEntity() {
        String r0 = this.boundary;
        if (r0 != null) goto L7;
        ContentType r2 = this.contentType;
        if (r2 == null) goto L7;
        r0 = r2.getParameter("boundary");
    L7:
        if (r0 != null) goto L9;
        r0 = generateBoundary();
    L9:
        Charset r3 = this.charset;
        if (r3 != null) goto L14;
        ContentType r4 = this.contentType;
        if (r4 == null) goto L14;
        r3 = r4.getCharset();
    L14:
        ArrayList r5 = new ArrayList(2);
        r5.add(new BasicNameValuePair("boundary", r0));
        if (r3 == null) goto L17;
        r5.add(new BasicNameValuePair("charset", r3.name()));
    L17:
        NameValuePair[] r1 = (NameValuePair[]) r5.toArray(new NameValuePair[r5.size()]);
        ContentType r6 = this.contentType;
        if (r6 == null) goto L20;
        ContentType r7 = r6.withParameters(r1);
    L22:
        if (this.bodyParts == null) goto L24;
        List r8 = new ArrayList(this.bodyParts);
    L25:
        HttpMultipartMode r9 = this.mode;
        if (r9 != null) goto L29;
        r9 = HttpMultipartMode.STRICT;
    L29:
        int r10 = AnonymousClass1.$SwitchMap$cz$msebera$android$httpclient$entity$mime$HttpMultipartMode[r9.ordinal()];
        if (r10 == 1) goto L34;
        if (r10 == 2) goto L33;
        AbstractMultipartForm r11 = new HttpStrictMultipart(r3, r0, r8);
    L36:
        return new MultipartFormEntity(r11, r7, r11.getTotalLength());
    L33:
        r11 = new HttpRFC6532Multipart(r3, r0, r8);
        goto L36
    L34:
        r11 = new HttpBrowserCompatibleMultipart(r3, r0, r8);
        goto L36
    L24:
        r8 = Collections.emptyList();
        goto L25
    L20:
        r7 = ContentType.create("multipart/form-data", r1);
        goto L22
    }

    public HttpEntity build() {
        return buildEntity();
    }
}
