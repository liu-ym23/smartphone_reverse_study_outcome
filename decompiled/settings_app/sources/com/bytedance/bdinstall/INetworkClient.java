package com.bytedance.bdinstall;

import android.util.Pair;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface INetworkClient {
    String get(String r1, Map<String, String> r2) throws Exception;

    String post(String r1, List<Pair<String, String>> r2) throws Exception;

    String post(String r1, byte[] r2, String r3) throws Exception;

    String post(String r1, byte[] r2, Map<String, String> r3) throws Exception;

    byte[] postStream(String r1, byte[] r2, Map<String, String> r3) throws RangersHttpException;
}
