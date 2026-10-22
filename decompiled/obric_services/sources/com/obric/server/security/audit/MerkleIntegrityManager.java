package com.obric.server.security.audit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import com.obric.security.keymanager.KeyManager;
import com.obric.security.keymanager.KeyManagerResult;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class MerkleIntegrityManager {
    private static final String AUDIT_KEY_ALIAS = "audit_integrity_key";
    private static final String TAG = "AuditMerkle";
    private final Context mContext;
    private volatile boolean mKeyReady;
    private String mLastBlockHash;
    private long mLastBlockSeq;
    private volatile byte[] mPendingCertChain;
    private boolean mStateLoaded;

    public static final class SignedBlock {
        public final String blockHash;
        public final long blockSeq;
        public final String merkleRoot;
        public final String prevHash;
        public final List<List<String>> proofPaths;
        public final byte[] signature;

        SignedBlock(long blockSeq, String blockHash, String prevHash, String merkleRoot, byte[] signature, List<List<String>> proofPaths) {
            this.blockSeq = blockSeq;
            this.blockHash = blockHash;
            this.prevHash = prevHash;
            this.merkleRoot = merkleRoot;
            this.signature = signature;
            this.proofPaths = proofPaths;
        }
    }

    public MerkleIntegrityManager(Context context) {
        this.mLastBlockHash = "";
        this.mLastBlockSeq = 0;
        this.mStateLoaded = false;
        this.mKeyReady = false;
        this.mContext = context;
    }

    public static String computeLeafHash(long ts, String session, byte[] payloadRaw) {
        MessageDigest md = MessageDigest.getInstance("SHA-256");     // Catch: NoSuchAlgorithmException -> L11
        md.update(String.valueOf(ts).getBytes(StandardCharsets.UTF_8));     // Catch: NoSuchAlgorithmException -> L11
        md.update((byte) 124);     // Catch: NoSuchAlgorithmException -> L11
        if (session != null) goto L5;
        String r2 = "";
    L6:
        md.update(r2.getBytes(StandardCharsets.UTF_8));     // Catch: NoSuchAlgorithmException -> L11
        md.update((byte) 124);     // Catch: NoSuchAlgorithmException -> L11
        if (payloadRaw == null) goto L9;
        md.update(payloadRaw);     // Catch: NoSuchAlgorithmException -> L11
    L9:
        return toHex(md.digest());
    L5:
        r2 = session;
    L11:
        e = move-exception;
        throw new RuntimeException("SHA-256 unavailable", e);
    }

    private static String sha256(String input) {
        MessageDigest md = MessageDigest.getInstance("SHA-256");     // Catch: NoSuchAlgorithmException -> L4
        return toHex(md.digest(input.getBytes(StandardCharsets.UTF_8)));
    L4:
        e = move-exception;
        throw new RuntimeException("SHA-256 unavailable", e);
    }

    private static String toHex(byte[] digest) {
        StringBuilder sb = new StringBuilder(digest.length * 2);
        int r1 = digest.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        byte b = digest[r2];
        sb.append(Character.forDigit((b >> 4) & 15, 16));
        sb.append(Character.forDigit(b & 15, 16));
        r2 = r2 + 1;
        goto L3
    L6:
        return sb.toString();
    }

    static String buildMerkleRoot(List<String> leafHashes) {
        if (leafHashes == null) goto L20;
        if (leafHashes.isEmpty() == true) goto L20;
        List<String> level = new ArrayList(leafHashes);
    L8:
        if (level.size() <= 1) goto L18;
        if ((level.size() % 2) == 0) goto L12;
        level.add(level.get(level.size() - 1));
    L12:
        List<String> next = new ArrayList();
        int i = 0;
    L14:
        if (i >= level.size()) goto L16;
        next.add(sha256(level.get(i) + level.get(i + 1)));
        i = i + 2;
        goto L14
    L16:
        level = next;
        goto L8
    L18:
        return level.get(0);
    L20:
        return sha256("");
    }

    static List<String> buildProofPath(List<String> leafHashes, int index) {
        List<String> path = new ArrayList();
        if (leafHashes != null) goto L5;
    L23:
        return path;
    L5:
        if (leafHashes.size() <= 1) goto L23;
        List<String> level = new ArrayList(leafHashes);
        int idx = index;
    L9:
        if (level.size() <= 1) goto L22;
        if ((level.size() % 2) == 0) goto L14;
        level.add(level.get(level.size() - 1));
    L14:
        if ((idx % 2) != 0) goto L16;
        int sibling = idx + 1;
    L17:
        path.add(level.get(sibling));
        idx = idx / 2;
        List<String> next = new ArrayList();
        int i = 0;
    L19:
        if (i >= level.size()) goto L21;
        next.add(sha256(level.get(i) + level.get(i + 1)));
        i = i + 2;
        goto L19
    L21:
        level = next;
        goto L9
    L16:
        sibling = idx - 1;
        goto L17
    L22:
        return path;
    }

    public SignedBlock buildAndSign(SQLiteDatabase db, List<String> leafHashes) {
        if (leafHashes != null) goto L5;
    L18:
        return null;
    L5:
        if (leafHashes.isEmpty() == true) goto L18;
        loadChainStateIfNeeded(db);
        String merkleRoot = buildMerkleRoot(leafHashes);
        List<List<String>> proofPaths = new ArrayList(leafHashes.size());
        int i = 0;
    L9:
        if (i >= leafHashes.size()) goto L11;
        proofPaths.add(buildProofPath(leafHashes, i));
        i = i + 1;
        goto L9
    L11:
        long blockSeq = 1 + this.mLastBlockSeq;
        String blockHash = sha256(merkleRoot + "|" + this.mLastBlockHash + "|" + blockSeq);
        byte[] signature = signBlockHash(blockHash);
        ContentValues cv = new ContentValues();     // Catch: Exception -> L14
        cv.put("block_seq", Long.valueOf(blockSeq));     // Catch: Exception -> L14
        cv.put("block_hash", blockHash);     // Catch: Exception -> L14
        cv.put("prev_hash", this.mLastBlockHash);     // Catch: Exception -> L14
        cv.put("merkle_root", merkleRoot);     // Catch: Exception -> L14
        cv.put("signature", signature);     // Catch: Exception -> L14
        cv.put("record_count", Integer.valueOf(leafHashes.size()));     // Catch: Exception -> L14
        cv.put("created_ts", Long.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L14
        db.insertOrThrow("audit_blocks", null, cv);     // Catch: Exception -> L14
    L16:
        String prevHash = this.mLastBlockHash;
        this.mLastBlockHash = blockHash;
        this.mLastBlockSeq = blockSeq;
        return new SignedBlock(blockSeq, blockHash, prevHash, merkleRoot, signature, proofPaths);
    L14:
        e = move-exception;
        Log.w(TAG, "buildAndSign: persist audit_blocks failed", e);
        goto L16
    }

    public String getCertChainBase64() {
        byte[] chain = this.mPendingCertChain;
        if (chain != null) goto L5;
        ensureKeyReady();
        chain = this.mPendingCertChain;
    L5:
        if (chain != null) goto L8;
        return null;
    L8:
        return Base64.encodeToString(chain, 2);
    }

    public void ensureKeyReady() {
        Bundle keyParams = new Bundle();     // Catch: Throwable -> L15
        keyParams.putInt("key_algorithm", 2);     // Catch: Throwable -> L15
        keyParams.putInt("key_length", 256);     // Catch: Throwable -> L15
        keyParams.putInt("key_purpose", 196);     // Catch: Throwable -> L15
        int gen = KeyManager.getInstance().generateKeyPair(this.mContext, AUDIT_KEY_ALIAS, keyParams);     // Catch: Throwable -> L15
        if (gen == 0) goto L6;
        Log.i(TAG, "ensureKeyReady: generateKeyPair ret=" + gen + " (may already exist)");     // Catch: Throwable -> L15
    L6:
        Bundle attestParams = new Bundle();     // Catch: Throwable -> L15
        attestParams.putString("challenge", sha256(AUDIT_KEY_ALIAS + System.currentTimeMillis()));     // Catch: Throwable -> L15
        KeyManagerResult res = KeyManager.getInstance().keyAttestation(this.mContext, AUDIT_KEY_ALIAS, attestParams);     // Catch: Throwable -> L15
        if (res != null) goto L9;
    L13:
        Log.w(TAG, "ensureKeyReady: attestation unavailable, sign will degrade");     // Catch: Throwable -> L15
        return;
    L9:
        if (res.getResultCode() != 0) goto L13;
        if (res.getOutData() == null) goto L13;
        this.mPendingCertChain = res.getOutData();     // Catch: Throwable -> L15
        this.mKeyReady = true;     // Catch: Throwable -> L15
        Log.i(TAG, "ensureKeyReady: key + attestation ready, certChain bytes=" + this.mPendingCertChain.length);     // Catch: Throwable -> L15
        return;
    L15:
        t = move-exception;
        Log.w(TAG, "ensureKeyReady failed (degrade to unsigned)", t);
    }

    private byte[] signBlockHash(String blockHash) {
        byte[] data = blockHash.getBytes(StandardCharsets.UTF_8);     // Catch: Throwable -> L15
        KeyManagerResult res = KeyManager.getInstance().sign(this.mContext, AUDIT_KEY_ALIAS, data, new Bundle());     // Catch: Throwable -> L15
        if (res != null) goto L6;
    L9:
        StringBuilder r4 = new StringBuilder().append("signBlockHash: sign failed, ret=");     // Catch: Throwable -> L15
        if (res != null) goto L12;
        Object r5 = "null";
    L13:
        Log.w(TAG, r4.append(r5).append(", alias=").append(AUDIT_KEY_ALIAS).append(", dataLen=").append(data.length).toString());     // Catch: Throwable -> L15
        return null;
    L12:
        r5 = Integer.valueOf(res.getResultCode());     // Catch: Throwable -> L15
        goto L13
    L6:
        if (res.getResultCode() != 0) goto L9;
        return res.getOutData();
    L15:
        t = move-exception;
        Log.w(TAG, "signBlockHash failed (degrade to unsigned)", t);
        return null;
    }

    private void loadChainStateIfNeeded(SQLiteDatabase db) {
        if (this.mStateLoaded == false) goto L5;
        return;
    L5:
        Cursor c = null;
        c = db.rawQuery("SELECT block_seq, block_hash FROM audit_blocks ORDER BY block_seq DESC LIMIT 1", null);     // Catch: Throwable -> L16 Exception -> L18
        if (c.moveToNext() == false) goto L13;
        this.mLastBlockSeq = c.getLong(0);     // Catch: Throwable -> L16 Exception -> L18
        if (c.getString(1) == null) goto L11;
        String r2 = c.getString(1);     // Catch: Throwable -> L16 Exception -> L18
    L12:
        this.mLastBlockHash = r2;     // Catch: Throwable -> L16 Exception -> L18
    L11:
        r2 = "";
    L13:
        if (c == null) goto L15;
    L14:
        c.close();
    L15:
        this.mStateLoaded = true;
        return;
    L16:
        th = move-exception;
        if (c == null) goto L25;
        c.close();
    L25:
        this.mStateLoaded = true;
        throw th;
    L18:
        e = move-exception;
        Log.w(TAG, "loadChainStateIfNeeded failed", e);     // Catch: Throwable -> L16
        if (c == null) goto L15;
        goto L15
    }
}
