package kotlin.s0.w.d.l0.i;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class k extends IOException {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private q f20359f;

    public k(String r1) {
        super(r1);
        this.f20359f = null;
    }

    static k b() {
        return new k("Protocol message end-group tag did not match expected tag.");
    }

    static k c() {
        return new k("Protocol message contained an invalid tag (zero).");
    }

    static k d() {
        return new k("Protocol message had invalid UTF-8.");
    }

    static k e() {
        return new k("Protocol message tag had invalid wire type.");
    }

    static k f() {
        return new k("CodedInputStream encountered a malformed varint.");
    }

    static k g() {
        return new k("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static k h() {
        return new k("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    static k j() {
        return new k("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    static k k() {
        return new k("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    public q a() {
        return this.f20359f;
    }

    public k i(q r1) {
        this.f20359f = r1;
        return this;
    }
}
