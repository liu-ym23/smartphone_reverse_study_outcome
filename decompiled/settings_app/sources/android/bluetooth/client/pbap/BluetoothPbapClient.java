package android.bluetooth.client.pbap;

import android.accounts.Account;
import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.bytedance.networkstackapplib.NetworkStackConstant;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class BluetoothPbapClient {
    public static final String CCH_PATH = "telecom/cch.vcf";
    private static final boolean DBG = true;
    public static final int EVENT_PULL_PHONE_BOOK_DONE = 2;
    public static final int EVENT_PULL_PHONE_BOOK_ERROR = 102;
    public static final int EVENT_PULL_PHONE_BOOK_SIZE_DONE = 5;
    public static final int EVENT_PULL_PHONE_BOOK_SIZE_ERROR = 105;
    public static final int EVENT_PULL_VCARD_ENTRY_DONE = 4;
    public static final int EVENT_PULL_VCARD_ENTRY_ERROR = 104;
    public static final int EVENT_PULL_VCARD_LISTING_DONE = 3;
    public static final int EVENT_PULL_VCARD_LISTING_ERROR = 103;
    public static final int EVENT_PULL_VCARD_LISTING_SIZE_DONE = 6;
    public static final int EVENT_PULL_VCARD_LISTING_SIZE_ERROR = 106;
    public static final int EVENT_SESSION_AUTH_REQUESTED = 203;
    public static final int EVENT_SESSION_AUTH_TIMEOUT = 204;
    public static final int EVENT_SESSION_CONNECTED = 201;
    public static final int EVENT_SESSION_DISCONNECTED = 202;
    public static final int EVENT_SET_PHONE_BOOK_DONE = 1;
    public static final int EVENT_SET_PHONE_BOOK_ERROR = 101;
    public static final String ICH_PATH = "telecom/ich.vcf";
    public static final short MAX_LIST_COUNT = -1;
    public static final String MCH_PATH = "telecom/mch.vcf";
    public static final String OCH_PATH = "telecom/och.vcf";
    public static final byte ORDER_BY_ALPHABETICAL = 1;
    public static final byte ORDER_BY_DEFAULT = -1;
    public static final byte ORDER_BY_INDEXED = 0;
    public static final byte ORDER_BY_PHONETIC = 2;
    public static final String PB_PATH = "telecom/pb.vcf";
    public static final byte SEARCH_ATTR_NAME = 0;
    public static final byte SEARCH_ATTR_NUMBER = 1;
    public static final byte SEARCH_ATTR_SOUND = 2;
    public static final String SIM_CCH_PATH = "SIM1/telecom/cch.vcf";
    public static final String SIM_ICH_PATH = "SIM1/telecom/ich.vcf";
    public static final String SIM_MCH_PATH = "SIM1/telecom/mch.vcf";
    public static final String SIM_OCH_PATH = "SIM1/telecom/och.vcf";
    public static final String SIM_PB_PATH = "SIM1/telecom/pb.vcf";
    private static final String TAG = "BluetoothPbapClient";
    public static final long VCARD_ATTR_ADDR = 32;
    public static final long VCARD_ATTR_AGENT = 32768;
    public static final long VCARD_ATTR_BDAY = 16;
    public static final long VCARD_ATTR_CATEGORIES = 16777216;
    public static final long VCARD_ATTR_CLASS = 67108864;
    public static final long VCARD_ATTR_EMAIL = 256;
    public static final long VCARD_ATTR_FN = 2;
    public static final long VCARD_ATTR_GEO = 2048;
    public static final long VCARD_ATTR_KEY = 4194304;
    public static final long VCARD_ATTR_LABEL = 64;
    public static final long VCARD_ATTR_LOGO = 16384;
    public static final long VCARD_ATTR_MAILER = 512;
    public static final long VCARD_ATTR_N = 4;
    public static final long VCARD_ATTR_NICKNAME = 8388608;
    public static final long VCARD_ATTR_NOTE = 131072;
    public static final long VCARD_ATTR_ORG = 65536;
    public static final long VCARD_ATTR_PHOTO = 8;
    public static final long VCARD_ATTR_PROID = 33554432;
    public static final long VCARD_ATTR_REV = 262144;
    public static final long VCARD_ATTR_ROLE = 8192;
    public static final long VCARD_ATTR_SORT_STRING = 134217728;
    public static final long VCARD_ATTR_SOUND = 524288;
    public static final long VCARD_ATTR_TEL = 128;
    public static final long VCARD_ATTR_TITLE = 4096;
    public static final long VCARD_ATTR_TZ = 1024;
    public static final long VCARD_ATTR_UID = 2097152;
    public static final long VCARD_ATTR_URL = 1048576;
    public static final long VCARD_ATTR_VERSION = 1;
    public static final long VCARD_ATTR_X_IRMC_CALL_DATETIME = 268435456;
    public static final byte VCARD_TYPE_21 = 0;
    public static final byte VCARD_TYPE_30 = 1;
    private final Account mAccount;
    private final Handler mClientHandler;
    private ConnectionState mConnectionState;
    private final BluetoothPbapSession mSession;
    private SessionHandler mSessionHandler;

    public static final enum ConnectionState extends Enum<ConnectionState> {
        private static final /* synthetic */ ConnectionState[] $VALUES = null;
        public static final ConnectionState CONNECTED = null;
        public static final ConnectionState CONNECTING = null;
        public static final ConnectionState DISCONNECTED = null;
        public static final ConnectionState DISCONNECTING = null;

        private static /* synthetic */ ConnectionState[] $values() {
            return new ConnectionState[]{DISCONNECTED, CONNECTING, CONNECTED, DISCONNECTING};
        }

        private ConnectionState(String r1, int r2) {
            super(r1, r2);
        }

        public static ConnectionState valueOf(String r1) {
            return (ConnectionState) Enum.valueOf(ConnectionState.class, r1);
        }

        public static ConnectionState[] values() {
            return (ConnectionState[]) $VALUES.clone();
        }

        static {
            DISCONNECTED = new ConnectionState(NetworkStackConstant.ERR_DISCONNECTED, 0);
            CONNECTING = new ConnectionState("CONNECTING", 1);
            CONNECTED = new ConnectionState("CONNECTED", 2);
            DISCONNECTING = new ConnectionState("DISCONNECTING", 3);
            $VALUES = $values();
        }
    }

    private static class SessionHandler extends Handler {
        private final WeakReference<BluetoothPbapClient> mClient;

        SessionHandler(BluetoothPbapClient r2) {
            this.mClient = new WeakReference(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r3) {
            Log.d(BluetoothPbapClient.TAG, "handleMessage: what=" + r3.what);
            BluetoothPbapClient r2 = this.mClient.get();
            if (r2 != null) goto L6;
            return;
        L6:
            switch(r3.what) {
                case 3: goto L31;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                default: goto L68;
            };
        L8:
            BluetoothPbapClient.access$000(r2, 204);
            return;
        L9:
            BluetoothPbapClient.access$000(r2, 203);
            return;
        L10:
            BluetoothPbapClient.access$402(r2, ConnectionState.DISCONNECTED);
            BluetoothPbapClient.access$000(r2, 202);
            return;
        L11:
            BluetoothPbapClient.access$402(r2, ConnectionState.CONNECTED);
            BluetoothPbapClient.access$000(r2, 201);
            return;
        L12:
            BluetoothPbapClient.access$402(r2, ConnectionState.CONNECTING);
            return;
        L13:
            BluetoothPbapRequest r4 = (BluetoothPbapRequest) r3.obj;
            if ((r4 instanceof BluetoothPbapRequestPullPhoneBookSize) == false) goto L17;
            BluetoothPbapClient.access$000(r2, 105);
            return;
        L17:
            if ((r4 instanceof BluetoothPbapRequestPullVcardListingSize) == false) goto L20;
            BluetoothPbapClient.access$000(r2, 106);
            return;
        L20:
            if ((r4 instanceof BluetoothPbapRequestPullPhoneBook) == false) goto L23;
            BluetoothPbapClient.access$000(r2, 102);
            return;
        L23:
            if ((r4 instanceof BluetoothPbapRequestPullVcardListing) == false) goto L26;
            BluetoothPbapClient.access$000(r2, 103);
            return;
        L26:
            if ((r4 instanceof BluetoothPbapRequestPullVcardEntry) == false) goto L29;
            BluetoothPbapClient.access$000(r2, 104);
            return;
        L29:
            if ((r4 instanceof BluetoothPbapRequestSetPath) == false) goto L60;
            BluetoothPbapClient.access$000(r2, 101);
            return;
        L60:
            return;
        L31:
            BluetoothPbapRequest r5 = (BluetoothPbapRequest) r3.obj;
            if ((r5 instanceof BluetoothPbapRequestPullPhoneBookSize) == false) goto L35;
            BluetoothPbapClient.access$100(r2, 5, ((BluetoothPbapRequestPullPhoneBookSize) r5).getSize());
            return;
        L35:
            if ((r5 instanceof BluetoothPbapRequestPullVcardListingSize) == false) goto L38;
            BluetoothPbapClient.access$100(r2, 6, ((BluetoothPbapRequestPullVcardListingSize) r5).getSize());
            return;
        L38:
            if ((r5 instanceof BluetoothPbapRequestPullPhoneBook) == false) goto L41;
            BluetoothPbapRequestPullPhoneBook r6 = (BluetoothPbapRequestPullPhoneBook) r5;
            BluetoothPbapClient.access$200(r2, 2, r6.getNewMissedCalls(), r6.getList());
            return;
        L41:
            if ((r5 instanceof BluetoothPbapRequestPullVcardListing) == false) goto L44;
            BluetoothPbapRequestPullVcardListing r7 = (BluetoothPbapRequestPullVcardListing) r5;
            BluetoothPbapClient.access$200(r2, 3, r7.getNewMissedCalls(), r7.getList());
            return;
        L44:
            if ((r5 instanceof BluetoothPbapRequestPullVcardEntry) == false) goto L47;
            BluetoothPbapClient.access$300(r2, 4, ((BluetoothPbapRequestPullVcardEntry) r5).getVcard());
            return;
        L47:
            if ((r5 instanceof BluetoothPbapRequestSetPath) == false) goto L67;
            BluetoothPbapClient.access$000(r2, 1);
            return;
        L67:
            return;
        }
    }

    static /* synthetic */ void access$000(BluetoothPbapClient r0, int r1) {
        r0.sendToClient(r1);
    }

    static /* synthetic */ void access$100(BluetoothPbapClient r0, int r1, int r2) {
        r0.sendToClient(r1, r2);
    }

    static /* synthetic */ void access$200(BluetoothPbapClient r0, int r1, int r2, Object r3) {
        r0.sendToClient(r1, r2, r3);
    }

    static /* synthetic */ void access$300(BluetoothPbapClient r0, int r1, Object r2) {
        r0.sendToClient(r1, r2);
    }

    static /* synthetic */ ConnectionState access$402(BluetoothPbapClient r0, ConnectionState r1) {
        r0.mConnectionState = r1;
        return r1;
    }

    private void sendToClient(int r3) {
        sendToClient(r3, 0, null);
    }

    private void sendToClient(int r2, int r3) {
        sendToClient(r2, r3, null);
    }

    private void sendToClient(int r2, Object r3) {
        sendToClient(r2, 0, r3);
    }

    private void sendToClient(int r2, int r3, Object r4) {
        this.mClientHandler.obtainMessage(r2, r3, 0, r4).sendToTarget();
    }

    public BluetoothPbapClient(BluetoothDevice r3, Account r4, Handler r5) {
        this.mConnectionState = ConnectionState.DISCONNECTED;
        Log.d(TAG, " device " + r3 + " account " + r4);
        if (r3 == null) goto L7;
        this.mAccount = r4;
        this.mClientHandler = r5;
        this.mSessionHandler = new SessionHandler(this);
        this.mSession = new BluetoothPbapSession(r3, this.mSessionHandler);
        return;
    L7:
        throw new NullPointerException("BluetoothDevice is null");
    }

    public void connect() {
        this.mSession.start();
    }

    public void finalize() {
        BluetoothPbapSession r0 = this.mSession;
        if (r0 == null) goto L6;
        r0.stop();
        return;
    }

    public void disconnect() {
        this.mSession.stop();
    }

    public void abort() {
        this.mSession.abort();
    }

    public ConnectionState getState() {
        return this.mConnectionState;
    }

    public boolean setPhoneBookFolderRoot() {
        BluetoothPbapRequestSetPath r0 = new BluetoothPbapRequestSetPath(false);
        return this.mSession.makeRequest(r0);
    }

    public boolean setPhoneBookFolderUp() {
        BluetoothPbapRequestSetPath r0 = new BluetoothPbapRequestSetPath(true);
        return this.mSession.makeRequest(r0);
    }

    public boolean setPhoneBookFolderDown(String r2) {
        BluetoothPbapRequestSetPath r0 = new BluetoothPbapRequestSetPath(r2);
        return this.mSession.makeRequest(r0);
    }

    public boolean pullPhoneBookSize(String r2) {
        BluetoothPbapRequestPullPhoneBookSize r0 = new BluetoothPbapRequestPullPhoneBookSize(r2);
        return this.mSession.makeRequest(r0);
    }

    public boolean pullVcardListingSize(String r2) {
        BluetoothPbapRequestPullVcardListingSize r0 = new BluetoothPbapRequestPullVcardListingSize(r2);
        return this.mSession.makeRequest(r0);
    }

    public boolean pullPhoneBook(String r8) {
        return pullPhoneBook(r8, 0, (byte) 0, 0, 0);
    }

    public boolean pullPhoneBook(String r8, long r9, byte r11) {
        return pullPhoneBook(r8, r9, r11, 0, 0);
    }

    public boolean pullPhoneBook(String r8, int r9, int r10) {
        return pullPhoneBook(r8, 0, (byte) 0, r9, r10);
    }

    public boolean pullPhoneBook(String r10, int r11, int r12, Account r13) {
        if (r13 == null) goto L6;
        BluetoothPbapRequestPullPhoneBook r8 = new BluetoothPbapRequestPullPhoneBook(r10, r13, 0, (byte) 0, r11, r12);
        return this.mSession.makeRequest(r8);
    L6:
        return pullPhoneBook(r10, 0, (byte) 0, r11, r12);
    }

    public boolean pullPhoneBook(String r10, long r11, byte r13, int r14, int r15) {
        BluetoothPbapRequestPullPhoneBook r8 = new BluetoothPbapRequestPullPhoneBook(r10, this.mAccount, r11, r13, r14, r15);
        return this.mSession.makeRequest(r8);
    }

    public boolean pullVcardListing(String r8) {
        return pullVcardListing(r8, (byte) -1, (byte) 0, null, 0, 0);
    }

    public boolean pullVcardListing(String r8, byte r9) {
        return pullVcardListing(r8, r9, (byte) 0, null, 0, 0);
    }

    public boolean pullVcardListing(String r8, byte r9, String r10) {
        return pullVcardListing(r8, (byte) -1, r9, r10, 0, 0);
    }

    public boolean pullVcardListing(String r8, byte r9, int r10, int r11) {
        return pullVcardListing(r8, r9, (byte) 0, null, r10, r11);
    }

    public boolean pullVcardListing(String r8, int r9, int r10) {
        return pullVcardListing(r8, (byte) -1, (byte) 0, null, r9, r10);
    }

    public boolean pullVcardListing(String r9, byte r10, byte r11, String r12, int r13, int r14) {
        BluetoothPbapRequestPullVcardListing r7 = new BluetoothPbapRequestPullVcardListing(r9, r10, r11, r12, r13, r14);
        return this.mSession.makeRequest(r7);
    }

    public boolean pullVcardEntry(String r4) {
        return pullVcardEntry(r4, 0, (byte) 0);
    }

    public boolean pullVcardEntry(String r8, long r9, byte r11) {
        BluetoothPbapRequestPullVcardEntry r6 = new BluetoothPbapRequestPullVcardEntry(r8, this.mAccount, r9, r11);
        return this.mSession.makeRequest(r6);
    }

    public boolean setAuthResponse(String r3) {
        Log.d(TAG, " setAuthResponse key=" + r3);
        return this.mSession.setAuthResponse(r3);
    }
}
