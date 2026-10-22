package androidx.navigation;

import android.content.Intent;
import android.net.Uri;
import androidx.annotation.RestrictTo;
import kotlin.Metadata;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import kotlin.u0.i;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0011B%\b\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007B\u000f\b\u0017\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0010\u001a\u00020\u0005H\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Landroidx/navigation/NavDeepLinkRequest;", "", "uri", "Landroid/net/Uri;", "action", "", "mimeType", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;)V", "intent", "Landroid/content/Intent;", "(Landroid/content/Intent;)V", "getAction", "()Ljava/lang/String;", "getMimeType", "getUri", "()Landroid/net/Uri;", "toString", "Builder", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class NavDeepLinkRequest {
    private final String action;
    private final String mimeType;
    private final Uri uri;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/navigation/NavDeepLinkRequest$Builder;", "", "()V", "action", "", "mimeType", "uri", "Landroid/net/Uri;", "build", "Landroidx/navigation/NavDeepLinkRequest;", "setAction", "setMimeType", "setUri", "Companion", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {
        public static final Companion Companion = null;
        private String action;
        private String mimeType;
        private Uri uri;

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\f"}, d2 = {"Landroidx/navigation/NavDeepLinkRequest$Builder$Companion;", "", "()V", "fromAction", "Landroidx/navigation/NavDeepLinkRequest$Builder;", "action", "", "fromMimeType", "mimeType", "fromUri", "uri", "Landroid/net/Uri;", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(g r1) {
                this();
            }

            public final Builder fromAction(String r2) {
                o.f(r2, "action");
                if (r2.length() <= 0) goto L5;
                boolean r1 = true;
            L6:
                if (r1 == false) goto L10;
                Builder r3 = new Builder(null);
                r3.setAction(r2);
                return r3;
            L10:
                throw new IllegalArgumentException("The NavDeepLinkRequest cannot have an empty action.".toString());
            L5:
                r1 = false;
                goto L6
            }

            public final Builder fromMimeType(String r2) {
                o.f(r2, "mimeType");
                Builder r1 = new Builder(null);
                r1.setMimeType(r2);
                return r1;
            }

            public final Builder fromUri(Uri r2) {
                o.f(r2, "uri");
                Builder r1 = new Builder(null);
                r1.setUri(r2);
                return r1;
            }
        }

        static {
            Companion = new Companion(null);
        }

        private Builder() {
        }

        public /* synthetic */ Builder(g r1) {
            this();
        }

        public static final Builder fromAction(String r1) {
            return Companion.fromAction(r1);
        }

        public static final Builder fromMimeType(String r1) {
            return Companion.fromMimeType(r1);
        }

        public static final Builder fromUri(Uri r1) {
            return Companion.fromUri(r1);
        }

        public final NavDeepLinkRequest build() {
            return new NavDeepLinkRequest(this.uri, this.action, this.mimeType);
        }

        public final Builder setAction(String r2) {
            o.f(r2, "action");
            if (r2.length() <= 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L10;
            this.action = r2;
            return this;
        L10:
            throw new IllegalArgumentException("The NavDeepLinkRequest cannot have an empty action.".toString());
        L5:
            r0 = false;
            goto L6
        }

        public final Builder setMimeType(String r3) {
            o.f(r3, "mimeType");
            if (new i("^[-\\w*.]+/[-\\w+*.]+$").d(r3) == false) goto L7;
            this.mimeType = r3;
            return this;
        L7:
            throw new IllegalArgumentException(("The given mimeType " + r3 + " does not match to required \"type/subtype\" format").toString());
        }

        public final Builder setUri(Uri r2) {
            o.f(r2, "uri");
            this.uri = r2;
            return this;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public NavDeepLinkRequest(Intent r3) {
        o.f(r3, "intent");
        this(r3.getData(), r3.getAction(), r3.getType());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public NavDeepLinkRequest(Uri r1, String r2, String r3) {
        this.uri = r1;
        this.action = r2;
        this.mimeType = r3;
    }

    public String getAction() {
        return this.action;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public Uri getUri() {
        return this.uri;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("NavDeepLinkRequest");
        r0.append("{");
        if (getUri() == null) goto L6;
        r0.append(" uri=");
        r0.append(String.valueOf(getUri()));
    L6:
        if (getAction() == null) goto L9;
        r0.append(" action=");
        r0.append(getAction());
    L9:
        if (getMimeType() == null) goto L11;
        r0.append(" mimetype=");
        r0.append(getMimeType());
    L11:
        r0.append(" }");
        String r2 = r0.toString();
        o.e(r2, "sb.toString()");
        return r2;
    }
}
