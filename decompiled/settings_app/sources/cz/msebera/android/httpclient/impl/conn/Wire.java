package cz.msebera.android.httpclient.impl.conn;

import com.android.settings.utils.HanziToPinyin;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.util.Args;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public class Wire {
    private final String id;
    private final HttpClientAndroidLog log;

    public Wire(HttpClientAndroidLog r1, String r2) {
        this.log = r1;
        this.id = r2;
    }

    public Wire(HttpClientAndroidLog r2) {
        this(r2, "");
    }

    private void wire(String r7, InputStream r8) throws IOException {
        StringBuilder r0 = new StringBuilder();
    L3:
        int r1 = r8.read();
        if (r1 == (-1)) goto L19;
        if (r1 == 13) goto L7;
        if (r1 == 10) goto L10;
        if (r1 < 32) goto L17;
        if (r1 > 127) goto L17;
        r0.append((char) r1);
    L17:
        r0.append("[0x");
        r0.append(Integer.toHexString(r1));
        r0.append("]");
        goto L3
    L10:
        r0.append("[\\n]\"");
        r0.insert(0, "\"");
        r0.insert(0, r7);
        this.log.debug(this.id + HanziToPinyin.Token.SEPARATOR + r0.toString());
        r0.setLength(0);
        goto L3
    L7:
        r0.append("[\\r]");
        goto L3
    L19:
        if (r0.length() <= 0) goto L35;
        r0.append('\"');
        r0.insert(0, '\"');
        r0.insert(0, r7);
        this.log.debug(this.id + HanziToPinyin.Token.SEPARATOR + r0.toString());
        return;
    }

    public boolean enabled() {
        return this.log.isDebugEnabled();
    }

    public void output(InputStream r2) throws IOException {
        Args.notNull(r2, "Output");
        wire(">> ", r2);
    }

    public void input(InputStream r2) throws IOException {
        Args.notNull(r2, "Input");
        wire("<< ", r2);
    }

    public void output(byte[] r2, int r3, int r4) throws IOException {
        Args.notNull(r2, "Output");
        wire(">> ", new ByteArrayInputStream(r2, r3, r4));
    }

    public void input(byte[] r2, int r3, int r4) throws IOException {
        Args.notNull(r2, "Input");
        wire("<< ", new ByteArrayInputStream(r2, r3, r4));
    }

    public void output(byte[] r2) throws IOException {
        Args.notNull(r2, "Output");
        wire(">> ", new ByteArrayInputStream(r2));
    }

    public void input(byte[] r2) throws IOException {
        Args.notNull(r2, "Input");
        wire("<< ", new ByteArrayInputStream(r2));
    }

    public void output(int r3) throws IOException {
        output(new byte[]{(byte) r3});
    }

    public void input(int r3) throws IOException {
        input(new byte[]{(byte) r3});
    }

    public void output(String r2) throws IOException {
        Args.notNull(r2, "Output");
        output(r2.getBytes());
    }

    public void input(String r2) throws IOException {
        Args.notNull(r2, "Input");
        input(r2.getBytes());
    }
}
