package tmsdkobf;

import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.networkstackapplib.TTNetworkStackAPI;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class tk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f538a;

    static {
    }

    public static int b(boolean r1) {
        int r0 = f538a;
        if (r0 == 0) goto L6;
        return r0;
    L6:
        return a(r1);
    }

    public static boolean b() {
        return a(InetAddress.getByName("2000::0"), 65535);
    L4:
        return false;
    }

    public static boolean b(String r9) {
        if (TextUtils.isEmpty(r9) == false) goto L5;
        return false;
    L5:
        boolean r2 = r9.contains("::");
        if (r2 == false) goto L11;
        if (r9.indexOf("::") == r9.lastIndexOf("::")) goto L11;
        return false;
    L11:
        if (r9.startsWith(":") == false) goto L15;
        if (r9.startsWith("::") == true) goto L15;
    L18:
        return false;
    L15:
        if (r9.endsWith(":") == true) goto L17;
    L19:
        String[] r3 = r9.split(":");
        if (r2 == false) goto L31;
        ArrayList r4 = new ArrayList(Arrays.asList(r3));
        if (r9.endsWith("::") == false) goto L25;
        r4.add("");
    L29:
        r3 = (String[]) r4.toArray(new String[r4.size()]);
        goto L31
    L25:
        if (r9.startsWith("::") == false) goto L29;
        if (r4.isEmpty() == true) goto L29;
        r4.remove(0);
    L31:
        if (r3.length <= 8) goto L33;
        return false;
    L33:
        int r10 = 0;
        int r5 = 0;
        int r6 = 0;
    L35:
        if (r10 >= r3.length) goto L62;
        String r7 = r3[r10];
        if (r7.length() != 0) goto L42;
        r6 = r6 + 1;
        if (r6 > 1) goto L40;
    L59:
        r5 = r5 + 1;
    L60:
        r10 = r10 + 1;
        goto L35
    L40:
        return false;
    L42:
        if (r10 != (r3.length - 1)) goto L50;
        if (r7.contains(LibrarianImpl.Constants.DOT) == false) goto L50;
        if (a(r7) == false) goto L47;
        r5 = r5 + 2;
        r6 = 0;
        goto L60
    L47:
        return false;
    L50:
        if (r7.length() > 4) goto L51;
        int r8 = Integer.parseInt(r7, 16);     // Catch: NumberFormatException -> L68
        if (r8 < 0) goto L61;
        if (r8 > 65535) goto L61;
        r6 = 0;
    L61:
        return false;
    L51:
        return false;
    L62:
        if (r5 > 8) goto L67;
        if (r5 >= 8) goto L66;
        if (r2 == false) goto L67;
    L66:
        return true;
    L67:
        return false;
    L17:
        if (r9.endsWith("::") == true) goto L19;
        goto L18
    }

    public static int a(boolean r9) {
        int r0 = 3;
        if (r9 == true) goto L57;
        return 3;
    L57:
        Enumeration<NetworkInterface> r1 = NetworkInterface.getNetworkInterfaces();     // Catch: Throwable -> L56
        boolean r2 = false;
        boolean r3 = false;
    L8:
        if (r1.hasMoreElements() == false) goto L37;
        NetworkInterface r4 = r1.nextElement();     // Catch: Throwable -> L56
        if (r4.isUp() == false) goto L8;
        List<InterfaceAddress> r6 = r4.getInterfaceAddresses();     // Catch: Throwable -> L56
        if (r6 == null) goto L8;
        if (r6.size() == 0) goto L8;
        r4.getDisplayName();     // Catch: Throwable -> L56
        int r5 = 0;
    L19:
        if (r5 >= r6.size()) goto L8;
        InetAddress r7 = r6.get(r5).getAddress();     // Catch: Throwable -> L56
        if (r7.isLoopbackAddress() == false) goto L24;
    L36:
        r5 = r5 + 1;     // Catch: Throwable -> L56
        goto L19
    L24:
        if ((r7 instanceof Inet4Address) == false) goto L27;
        r2 = true;
        goto L36
    L27:
        if ((r7 instanceof Inet6Address) == false) goto L36;
        if (r7.isAnyLocalAddress() == true) goto L36;
        if (r7.isLoopbackAddress() == true) goto L36;
        if (r7.isLinkLocalAddress() == true) goto L36;
        r3 = true;
        goto L36
    L37:
        if (r2 == false) goto L39;
        if (r3 == false) goto L39;
    L41:
        boolean r8 = a();     // Catch: Throwable -> L56
        boolean r10 = b();     // Catch: Throwable -> L56
        if (r8 == false) goto L45;
        if (r10 == false) goto L45;
    L54:
        f538a = r0;
        return r0;
    L45:
        if (r8 == true) goto L50;
        if (r10 == false) goto L53;
    L52:
        r0 = 2;
    L50:
        r0 = 1;
    L39:
        if (r2 == true) goto L49;
        if (r3 == false) goto L41;
    L49:
        if (r2 == true) goto L50;
        if (r3 == true) goto L52;
    L53:
        r0 = 0;
        goto L54
    }

    public static boolean a(InetAddress r4, int r5) {
        DatagramSocket r0 = null;
        byte[] r2 = new byte[0];     // Catch: Throwable -> L13
        DatagramSocket r3 = new DatagramSocket(null);     // Catch: Throwable -> L13
        r3.send(new DatagramPacket(r2, 0, r4, r5));     // Catch: Throwable -> L11
        r3.close();     // Catch: Throwable -> L7
        return true;
    L7:
        th = move-exception;
        th.getMessage();
        return true;
    L11:
        th = th;
        r0 = r3;
    L36:
        th.getMessage();     // Catch: Throwable -> L21
        if (r0 != null) goto L32;
    L20:
        return false;
    L32:
        r0.close();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        th.getMessage();
    L21:
        th = move-exception;
        if (r0 != null) goto L28;
    L27:
        throw th;
    L28:
        r0.close();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        th.getMessage();
    L13:
        th = th;
        goto L36
    }

    public static boolean a() {
        return a(InetAddress.getByName(TTNetworkStackAPI.CHECK_SERVER_ADDR), 65535);
    L4:
        return false;
    }

    public static boolean a(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L21;
        return false;
    L21:
        if (r4.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}") == false) goto L19;
        String[] r5 = r4.split("\\.");     // Catch: Exception -> L20
        if (r5.length >= 4) goto L11;
        return false;
    L11:
        if (Integer.parseInt(r5[0]) > 255) goto L19;
        if (Integer.parseInt(r5[1]) > 255) goto L19;
        if (Integer.parseInt(r5[2]) > 255) goto L19;
        if (Integer.parseInt(r5[3]) > 255) goto L19;
        return true;
    L19:
        return false;
    }
}
