package com.bytedance.bdinstall;

import com.bytedance.frameworks.core.encrypt.TTEncryptUtils;

/* JADX INFO: loaded from: classes3.dex */
public interface IEncryptor {

    public static class DefaultEncryptor implements IEncryptor {
        public DefaultEncryptor() {
        }

        @Override // com.bytedance.bdinstall.IEncryptor
        public byte[] encrypt(byte[] r1, int r2) {
            return TTEncryptUtils.encrypt(r1, r2);
        L4:
            th = move-exception;
            th.printStackTrace();
            return null;
        }
    }

    byte[] encrypt(byte[] r1, int r2);
}
