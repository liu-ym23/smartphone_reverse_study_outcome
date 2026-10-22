package com.bytedance.common.wschannel.app;

import android.os.Parcelable;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface IWsApp extends Parcelable {
    String I();

    boolean J();

    int a();

    int b0();

    int c();

    List<String> f0();

    int getAppId();

    String getDeviceId();

    String getExtra();

    String getInstallId();

    int k();

    JSONObject m();

    boolean n();

    int o();

    String r();

    Map<String, String> t();

    List<Integer> u();
}
