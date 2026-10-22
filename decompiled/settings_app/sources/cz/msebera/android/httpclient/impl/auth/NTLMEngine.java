package cz.msebera.android.httpclient.impl.auth;

/* JADX INFO: loaded from: classes5.dex */
public interface NTLMEngine {
    String generateType1Msg(String r1, String r2) throws NTLMEngineException;

    String generateType3Msg(String r1, String r2, String r3, String r4, String r5) throws NTLMEngineException;
}
