package com.android.settings;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SimpleImageLoader extends AsyncTask<HashMap<AppIconsSettingsFragment.Asset, Drawable>, Object, Integer> {
    public static final String EXTRA_INVALID_ASSET = "extra_invalid_asset";
    public static final int LOAD_APP_ICON = 0;
    private static final int LOAD_FAILED = 0;
    private static final int LOAD_SUCCESS = 1;
    public static final int LOAD_WALLPAPER = 1;
    private static final String TAG = "WallpaperSettings";
    private ArrayList<AppIconsSettingsFragment.Asset> mAssetList;
    private Callback mCallback;
    private Context mContext;
    private Handler mHandler;
    private List<String> mNameList;
    private int mToken;

    interface Callback {
        void onLoadFailed();

        void onLoadFinished();
    }

    @Override // android.os.AsyncTask
    protected /* bridge */ /* synthetic */ Integer doInBackground(HashMap<AppIconsSettingsFragment.Asset, Drawable>[] r1) {
        return doInBackground2(r1);
    }

    @Override // android.os.AsyncTask
    protected /* bridge */ /* synthetic */ void onPostExecute(Integer r1) {
        onPostExecute2(r1);
    }

    public SimpleImageLoader(Context r1, int r2, Callback r3) {
        this.mContext = r1;
        this.mToken = r2;
        this.mCallback = r3;
    }

    /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
    protected Integer doInBackground2(HashMap<AppIconsSettingsFragment.Asset, Drawable>... r3) {
        if (this.mToken != 0) goto L10;
        loadAppIconList(r3);
        if (r3[0].size() <= 0) goto L10;
        return 1;
    L10:
        return 0;
    }

    /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
    protected void onPostExecute2(Integer r3) {
        if (this.mCallback != null) goto L5;
    L8:
        super.onPostExecute(r3);
        return;
    L5:
        if (r3.intValue() != 1) goto L7;
        this.mCallback.onLoadFinished();
        goto L8
    L7:
        this.mCallback.onLoadFailed();
        goto L8
    }

    private void loadAppIconList(HashMap<AppIconsSettingsFragment.Asset, Drawable>[] r6) {
        Iterator<AppIconsSettingsFragment.Asset> r0 = this.mAssetList.iterator();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.hasNext() == false) goto L17;
        AppIconsSettingsFragment.Asset r1 = r0.next();
        r1.getPackageName();
        Drawable r2 = AppIconsSettingsFragment.loadOfficialIcon(r1);
        if (r2 != null) goto L8;
        Message r3 = Message.obtain();
        Bundle r4 = new Bundle();
        r4.putParcelable(EXTRA_INVALID_ASSET, r1);
        r3.setData(r4);
        this.mHandler.sendMessage(r3);
        goto L5
    L8:
        r6[0].put(r1, r2);
        r6[1].put(r1, AppIconsSettingsFragment.loadUnOfficialIcon(r1));
        goto L5
    }

    private void loadWallpaperPreview(HashMap<String, Drawable> r5) {
        int r0 = 0;
    L4:
        if (r0 >= this.mNameList.size()) goto L6;
        int r1 = getResIdFromName(this.mNameList.get(r0));
        Bitmap r2 = Utils.getRoundedCornerBitmap(BitmapFactory.decodeResource(this.mContext.getResources(), r1));
        BitmapDrawable r3 = new BitmapDrawable(this.mContext.getResources(), r2);
        r5.put(String.valueOf(r0), r3);
        r0 = r0 + 1;
        goto L4
    }

    private int getResIdFromName(String r3) {
        return this.mContext.getResources().getIdentifier(r3, "drawable", this.mContext.getPackageName());
    }

    public void setNameList(List<String> r1) {
        this.mNameList = r1;
        if (r1 != null) goto L5;
    L6:
        OLog.e(TAG, "Wallpaper name list is null or empty !");
        return;
    L5:
        if (r1.size() == 0) goto L6;
    }

    public void setAssetList(ArrayList<AppIconsSettingsFragment.Asset> r3) {
        ArrayList<AppIconsSettingsFragment.Asset> r0 = new ArrayList(r3.size());
        this.mAssetList = r0;
        r0.addAll(r3);
    }

    public void setHandler(Handler r1) {
        this.mHandler = r1;
    }
}
