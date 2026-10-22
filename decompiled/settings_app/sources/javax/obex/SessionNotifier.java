package javax.obex;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public interface SessionNotifier {
    ObexSession acceptAndOpen(ServerRequestHandler r1) throws IOException;

    ObexSession acceptAndOpen(ServerRequestHandler r1, Authenticator r2) throws IOException;
}
