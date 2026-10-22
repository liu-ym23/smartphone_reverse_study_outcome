package com.bytedance.common.wschannel.model;

import android.content.ComponentName;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class WsComponent implements Parcelable {
    public static final Parcelable.Creator<WsComponent> CREATOR = null;
    List<WsApi> acceptApis;
    ComponentName componentName;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public WsComponent() {
    }

    public ComponentName getComponentName() {
        return this.componentName;
    }

    public void setComponentName(ComponentName r1) {
        this.componentName = r1;
    }

    public List<WsApi> getAcceptApis() {
        return this.acceptApis;
    }

    public void setAcceptApis(List<WsApi> r1) {
        this.acceptApis = r1;
    }

    public JSONObject toJson() throws JSONException {
        JSONObject r0 = new JSONObject();
        ComponentName r1 = this.componentName;
        if (r1 == null) goto L5;
        r0.put("package_name", r1.getPackageName());
        r0.put("class_name", this.componentName.getClassName());
    L5:
        List<WsApi> r2 = this.acceptApis;
        if (r2 != null) goto L8;
    L14:
        return r0;
    L8:
        if (r2.size() <= 0) goto L14;
        JSONArray r3 = new JSONArray();
        Iterator<WsApi> r4 = this.acceptApis.iterator();
    L11:
        if (r4.hasNext() == false) goto L13;
        r3.put(r4.next().toJson());
        goto L11
    L13:
        r0.put("accept_services", r3);
        goto L14
    }

    public void parseFromJson(JSONObject r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        String r0 = r5.optString("package_name");
        String r1 = r5.optString("class_name");
        if (TextUtils.isEmpty(r0) == false) goto L7;
    L9:
        JSONArray r6 = r5.optJSONArray("accept_services");
        if (r6 == null) goto L14;
        this.acceptApis = new ArrayList();
        int r2 = r6.length();
        int r3 = 0;
    L12:
        if (r3 >= r2) goto L16;
        WsApi r4 = new WsApi();
        r4.parseFromJson(r6.optJSONObject(r3));
        this.acceptApis.add(r4);
        r3 = r3 + 1;
        goto L12
    L16:
        return;
    L14:
        return;
    L7:
        if (TextUtils.isEmpty(r1) == true) goto L9;
        this.componentName = new ComponentName(r0, r1);
        goto L9
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeParcelable(this.componentName, r3);
        r2.writeTypedList(this.acceptApis);
    }
}
