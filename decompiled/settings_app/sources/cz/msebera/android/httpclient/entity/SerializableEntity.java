package cz.msebera.android.httpclient.entity;

import cz.msebera.android.httpclient.util.Args;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public class SerializableEntity extends AbstractHttpEntity {
    private Serializable objRef;
    private byte[] objSer;

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isRepeatable() {
        return true;
    }

    public SerializableEntity(Serializable r2, boolean r3) throws IOException {
        Args.notNull(r2, "Source object");
        if (r3 == false) goto L5;
        createBytes(r2);
        return;
    L5:
        this.objRef = r2;
    }

    public SerializableEntity(Serializable r2) {
        Args.notNull(r2, "Source object");
        this.objRef = r2;
    }

    private void createBytes(Serializable r3) throws IOException {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        ObjectOutputStream r1 = new ObjectOutputStream(r0);
        r1.writeObject(r3);
        r1.flush();
        this.objSer = r0.toByteArray();
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public InputStream getContent() throws IOException, IllegalStateException {
        if (this.objSer != null) goto L6;
        createBytes(this.objRef);
    L6:
        return new ByteArrayInputStream(this.objSer);
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public long getContentLength() {
        byte[] r2 = this.objSer;
        if (r2 != null) goto L6;
        return -1;
    L6:
        return r2.length;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isStreaming() {
        if (this.objSer != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public void writeTo(OutputStream r2) throws IOException {
        Args.notNull(r2, "Output stream");
        byte[] r0 = this.objSer;
        if (r0 != null) goto L5;
        ObjectOutputStream r1 = new ObjectOutputStream(r2);
        r1.writeObject(this.objRef);
        r1.flush();
        return;
    L5:
        r2.write(r0);
        r2.flush();
    }
}
