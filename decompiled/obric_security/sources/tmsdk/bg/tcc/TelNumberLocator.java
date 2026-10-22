package tmsdk.bg.tcc;

import android.content.Context;
import java.util.ArrayList;
import tmsdk.common.TMSDKContext;
import tmsdk.common.module.update.UpdateConfig;
import tmsdkobf.q8;
import tmsdkobf.z4;

/* JADX INFO: loaded from: classes5.dex */
public class TelNumberLocator {
    private static final String YELLOW_PAGE_NAME = "yd.sdb";
    private static TelNumberLocator mInstance;
    private Context mContext;
    private long object;

    static {
        TMSDKContext.registerNatives(3, TelNumberLocator.class);
    }

    protected TelNumberLocator(Context r5) {
        this.mContext = r5;
        long r0 = newObject();
        this.object = r0;
        if (0 == r0) goto L7;
        reload();
        return;
    L7:
        throw new OutOfMemoryError();
    }

    private static native void deleteObject(long r0);

    private static native int[] getAreaCode(long r0);

    private static native int getAreaCodeLocation(long r0, int r2, StringBuffer r3);

    private static native int getCityNameList(long r0, String r2, ArrayList<String> r3);

    private static native int[] getCountryCode(long r0);

    private static native int getCountryCodeLocation(long r0, int r2, StringBuffer r3);

    public static synchronized TelNumberLocator getDefault(Context r2) {
        monitor-enter(TelNumberLocator.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (mInstance != null) goto L7;
        mInstance = new TelNumberLocator(r2);     // Catch: Throwable -> L10
    L7:
        TelNumberLocator r3 = mInstance;     // Catch: Throwable -> L10
        monitor-exit(TelNumberLocator.class);
        return r3;
    }

    private static native int getDetailYellowPages(long r0, ArrayList<Integer> r2, ArrayList<String> r3, ArrayList<String> r4, ArrayList<String> r5);

    private static native int getLocation(long r0, StringBuffer r2, StringBuffer r3, StringBuffer r4, String r5, boolean r6);

    private static native int getMobileNumLocation(long r0, int r2, StringBuffer r3);

    private static native int getProvinceNameList(long r0, ArrayList<String> r2);

    private static native int getYellowPages(long r0, ArrayList<String> r2, ArrayList<String> r3);

    private static native int init(long r0, String r2, String r3);

    private static native long newObject();

    private static native int patch(long r0, String r2, String r3, String r4);

    private void throwIfError(int r1) {
        if (r1 == (-4)) goto L9;
        if (r1 != 0) goto L7;
        return;
    L7:
        throw new TelNumberLocatorException(r1);
    L9:
        throw new OutOfMemoryError();
    }

    protected void finalize() {
        long r0 = this.object;
        if (r0 == 0) goto L5;
        deleteObject(r0);
    L5:
        this.object = 0;
    }

    public int[] getAreaCode() {
        return getAreaCode(this.object);
    }

    public String getAreaCodeLocation(int r4) {
        StringBuffer r0 = new StringBuffer();
        int r5 = getAreaCodeLocation(this.object, r4, r0);
        if (r5 >= 0) goto L10;
        if (r5 != (-1)) goto L8;
        return "";
    L8:
        throwIfError(r5);
    L10:
        return r0.toString();
    }

    public ArrayList<String> getCityNameList(String r4) {
        ArrayList<String> r0 = new ArrayList();
        throwIfError(getCityNameList(this.object, r4, r0));
        return r0;
    }

    public int[] getCountryCode() {
        return getCountryCode(this.object);
    }

    public String getCountryCodeLocation(int r4) {
        StringBuffer r0 = new StringBuffer();
        int r5 = getCountryCodeLocation(this.object, r4, r0);
        if (r5 >= 0) goto L10;
        if (r5 != (-1)) goto L8;
        return "";
    L8:
        throwIfError(r5);
    L10:
        return r0.toString();
    }

    public boolean getDetailYellowPages(ArrayList<Integer> r7, ArrayList<String> r8, ArrayList<String> r9, ArrayList<String> r10) {
        if (r8 == null) goto L7;
        if (r9 == null) goto L9;
        throwIfError(getDetailYellowPages(this.object, r7, r8, r9, r10));
        return true;
    L9:
        return false;
    L7:
        return false;
    }

    public void getLocation(StringBuffer r10, StringBuffer r11, StringBuffer r12, String r13, boolean r14) {
        q8.c("TelNumberLocator", "getLocation native");
        int r15 = getLocation(this.object, r10, r11, r12, r13, r14);
        if (r15 < 0) goto L5;
        return;
    L5:
        if (r15 != (-1)) goto L7;
        r10.replace(0, r10.length(), "");
        r11.replace(0, r11.length(), "");
        r12.replace(0, r12.length(), "");
        return;
    L7:
        throwIfError(r15);
    }

    public String getMobileNumLocation(int r4) {
        StringBuffer r0 = new StringBuffer();
        int r5 = getMobileNumLocation(this.object, r4, r0);
        if (r5 >= 0) goto L10;
        if (r5 != (-1)) goto L8;
        return "";
    L8:
        throwIfError(r5);
    L10:
        return r0.toString();
    }

    public ArrayList<String> getProvinceNameList() {
        ArrayList<String> r0 = new ArrayList();
        throwIfError(getProvinceNameList(this.object, r0));
        return r0;
    }

    public boolean getYellowPages(ArrayList<String> r3, ArrayList<String> r4) {
        if (r3 == null) goto L7;
        if (r4 == null) goto L9;
        throwIfError(getYellowPages(this.object, r3, r4));
        return true;
    L9:
        return false;
    L7:
        return false;
    }

    public int patchLocation(String r4, String r5) {
        String r0 = z4.a(this.mContext, UpdateConfig.LOCATION_NAME, null);
        return patch(this.object, r0, r4, r5);
    }

    public void reload() {
        String r1 = z4.a(this.mContext, UpdateConfig.LOCATION_NAME, null);     // Catch: Exception -> L10
        String r2 = z4.a(this.mContext, YELLOW_PAGE_NAME, null);     // Catch: Exception -> L10
        if (q8.a() == false) goto L6;
        System.out.println("path:::::" + r1);     // Catch: Exception -> L10
    L6:
        if (r1 != null) goto L8;
        if (r2 != null) goto L8;
        return;
    L8:
        throwIfError(init(this.object, r1, r2));     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
    }
}
