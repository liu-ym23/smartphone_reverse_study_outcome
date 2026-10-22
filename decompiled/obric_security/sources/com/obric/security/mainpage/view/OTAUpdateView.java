package com.obric.security.mainpage.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.PowerManager;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedanceos.security.widget.SecurityItemTextNeutral;
import com.bytedanceos.securitycenter.MainActivityTemp;
import com.obric.olog.OLog;
import com.obric.security.R;
import com.obric.security.ota.UpdateProgressManager;

/* JADX INFO: loaded from: classes4.dex */
public class OTAUpdateView extends RelativeLayout {
    private static final int ACTION_DOWNLOAD = 1;
    private static final int ACTION_INSTALL = 2;
    private static final int ACTION_NONE = 0;
    public static final int OTA_SCORE = 5;
    private static final int OTA_STATUS_DOWNLOADED = 3;
    private static final int OTA_STATUS_DOWNLOADING = 2;
    private static final int OTA_STATUS_INSTALLING = 5;
    private static final int OTA_STATUS_NO_UPDATE = 0;
    private static final int OTA_STATUS_TO_DOWNLOAD = 1;
    private static final int OTA_STATUS_WAIT_REBOOT = 6;
    private static final int OTA_UPDATE_PROGRESS_REQUEST = 100;
    private static final String TAG = "OceanDownloaderHelper";
    private Handler.Callback handlerCallback;
    private boolean isConn;
    DialogInterface.OnClickListener listener;
    private ServiceConnection mConn;
    private Context mContext;
    private volatile boolean mHasRequest;
    private Messenger mMessenger;
    private boolean mNeedUpdate;
    private SecurityItemTextNeutral mOtaUpdateView;
    private Messenger mService;
    private int mStatus;
    private AlertDialog mWarnDialog;
    private Handler mainHandler;
    private UpdateProgressManager updateProgressManager;

    public static class ACTION_STATUS {
        public static final int ONGOING = 1;
        public static final int REBOOT = 2;
        public static final int WAIT = 0;

        public ACTION_STATUS() {
        }
    }

    public static class DOWNLOAD_STATUS {
        public static final int DOWNLOADED = 2;
        public static final int DOWNLOADING = 1;
        public static final int NO_DOWNLOAD = 0;

        public DOWNLOAD_STATUS() {
        }
    }

    public static class UPDATE_STATUS {
        public static final int CHECKING_FAILURE = 1;
        public static final int NO_UPDATE = 0;
        public static final int UPDATE_AVIAILABLE = 2;

        public UPDATE_STATUS() {
        }
    }

    public int getOTAStatus(int updateStatus, int downloadStatus, int actionStatus) {
        if (actionStatus != 2) goto L6;
        return 6;
    L6:
        if (actionStatus != 1) goto L8;
        return 5;
    L8:
        if (downloadStatus != 2) goto L10;
        return 3;
    L10:
        if (downloadStatus == 1) goto L20;
        if (updateStatus == 2) goto L19;
        return 0;
    L19:
        return 1;
    L20:
        return 2;
    }

    static /* synthetic */ boolean access$000(OTAUpdateView r0) {
        return r0.mHasRequest;
    }

    static /* synthetic */ boolean access$002(OTAUpdateView r0, boolean r1) {
        r0.mHasRequest = r1;
        return r1;
    }

    static /* synthetic */ int access$100(OTAUpdateView r0) {
        return r0.mStatus;
    }

    static /* synthetic */ int access$102(OTAUpdateView r0, int r1) {
        r0.mStatus = r1;
        return r1;
    }

    static /* synthetic */ boolean access$202(OTAUpdateView r0, boolean r1) {
        r0.mNeedUpdate = r1;
        return r1;
    }

    static /* synthetic */ void access$300(OTAUpdateView r0, int r1, String r2, int r3) {
        r0.updateView(r1, r2, r3);
    }

    static /* synthetic */ Messenger access$402(OTAUpdateView r0, Messenger r1) {
        r0.mService = r1;
        return r1;
    }

    static /* synthetic */ boolean access$502(OTAUpdateView r0, boolean r1) {
        r0.isConn = r1;
        return r1;
    }

    static /* synthetic */ Context access$600(OTAUpdateView r0) {
        return r0.mContext;
    }

    static /* synthetic */ void access$700(OTAUpdateView r0) {
        r0.reboot();
    }

    /* JADX INFO: renamed from: lambda$new$0$com-obric-security-mainpage-view-OTAUpdateView, reason: not valid java name */
    /* synthetic */ boolean m605lambda$new$0$comobricsecuritymainpageviewOTAUpdateView(Message r2) {
        if (r2.what != 100) goto L6;
        sendToServer(100);
        return true;
    L6:
        return false;
    }

    public OTAUpdateView(Context context) {
        this(context, null);
    }

    public OTAUpdateView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OTAUpdateView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr, 0);
        this.mStatus = 0;
        this.mHasRequest = false;
        this.mNeedUpdate = false;
        this.mainHandler = null;
        this.listener = new AnonymousClass1(this);
        this.mMessenger = new Messenger(new AnonymousClass2(this));
        this.mConn = new AnonymousClass3(this);
        this.handlerCallback = new OTAUpdateView$$ExternalSyntheticLambda0(this);
        init(context);
    }

    private void init(final Context context) {
        this.mContext = context;
        SecurityItemTextNeutral r0 = (SecurityItemTextNeutral) LayoutInflater.from(context).inflate(R.layout.ota_update_layout, this, true).findViewById(R.id.ota_update_item);
        this.mOtaUpdateView = r0;
        r0.setBtnBackgroudResource(R.drawable.security_item_btn_red_bg);
        this.mOtaUpdateView.setContentImage(this.mContext.getDrawable(R.drawable.ota_icon_tip));
        this.mOtaUpdateView.setSummary(getResources().getString(R.string.ota_summary));
        this.mOtaUpdateView.setBtnText(getResources().getString(R.string.ota_update));
        this.mOtaUpdateView.setTitleString(getResources().getString(R.string.ota_title));
        this.mOtaUpdateView.setRightLayout(2);
        this.mOtaUpdateView.setOnClickListener(new AnonymousClass4(this, context));
        this.mOtaUpdateView.setBtnClickListener(new AnonymousClass5(this, context));
        this.mWarnDialog = new AlertDialog.Builder(this.mContext).setTitle(R.string.first_launch_dialog_title).setMessage(context.getString(R.string.first_launch_dialog_msg)).setPositiveButton(context.getString(R.string.ok), this.listener).setNegativeButton(context.getString(R.string.btn_cancel), this.listener).create();
        this.mainHandler = new Handler(Looper.getMainLooper(), this.handlerCallback);
    }

    public void doCreate() {
        bindServiceInvoked();
    }

    public void doResume() {
        OLog.d(TAG, "doResume:" + this.isConn);
        if (this.mHasRequest == false) goto L5;
        return;
    L5:
        if (this.isConn == false) goto L9;
        this.mHasRequest = true;
        sendToServer(100);
        return;
    }

    public void doPause() {
        Handler r1 = this.mainHandler;
        if (r1 == null) goto L6;
        r1.removeCallbacksAndMessages(null);
        return;
    }

    public void doDestory() {
        ServiceConnection r0 = this.mConn;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.isConn == false) goto L9;
        this.mContext.unbindService(r0);
        return;
    }

    void sendUpdateProgressMessage(long delay) {
        Handler r0 = this.mainHandler;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.hasMessages(100) == true) goto L9;
        Message r1 = Message.obtain();
        r1.what = 100;
        this.mainHandler.sendMessageDelayed(r1, delay);
        return;
    }

    void sendToServer(int method) {
        Message r0 = Message.obtain(null, method);
        r0.replyTo = this.mMessenger;
        Bundle r1 = new Bundle();
        r1.putString("calling_pkg", this.mContext.getPackageName());
        r0.setData(r1);
        if (MainActivityTemp.DBG == false) goto L6;
        OLog.d(TAG, "send to ota server isConn=" + this.isConn + ", method=" + method);
    L6:
        if (this.isConn == false) goto L16;
        this.mService.send(r0);     // Catch: RemoteException -> L9
        return;
    L9:
        e = move-exception;
        if (MainActivityTemp.DBG == false) goto L17;
        OLog.d(TAG, "send to ota server exception=" + e);
        return;
    L17:
        return;
    }

    private void bindServiceInvoked() {
        Intent r0 = new Intent();
        r0.setAction("com.obric.updatequery");
        r0.setPackage("com.obric.updater");
        this.mContext.bindService(r0, this.mConn, 1);
        if (MainActivityTemp.DBG == false) goto L6;
        OLog.d(TAG, "to bind ota service");
        return;
    }

    public boolean needUpdate() {
        return this.mNeedUpdate;
    }

    private void updateView(int status, String updateName, int installProgress) {
        if (status != 0) goto L6;
        setVisibility(8);
        return;
    L6:
        if (status != 1) goto L9;
        getDownloadInfoListToView(status);
    L20:
        setVisibility(0);
        return;
    L9:
        if (status != 2) goto L12;
        getDownloadInfoListToView(status);
        goto L20
    L12:
        if (status != 3) goto L15;
        this.mOtaUpdateView.setProgressMode(false);
        this.mOtaUpdateView.setBtnText(this.mContext.getString(R.string.ota_to_install));
        sendUpdateProgressMessage(2000);
        goto L20
    L15:
        if (status != 5) goto L18;
        this.mOtaUpdateView.setProgressMode(true);
        this.mOtaUpdateView.updateInstallProgress(installProgress, this.mContext.getString(R.string.ota_installing));
        sendUpdateProgressMessage(600);
        goto L20
    L18:
        if (status != 6) goto L20;
        this.mOtaUpdateView.setProgressMode(false);
        this.mOtaUpdateView.setBtnText(this.mContext.getString(R.string.ota_reboot));
        goto L20
    }

    private void getDownloadInfoListToView(int status) {
        if (status != 1) goto L5;
        this.mContext.getString(R.string.ota_to_dowaload);
        return;
    L5:
        this.mContext.getString(R.string.ota_dowaloading);
    }

    private void reboot() {
        OLog.d(TAG, "reboot now");
        PowerManager r2 = (PowerManager) this.mContext.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
        if (r2 == null) goto L6;
        r2.reboot("ota");
        return;
    }

    private void showWarnDialog() {
        AlertDialog r0 = this.mWarnDialog;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == true) goto L10;
        this.mWarnDialog.show();
        return;
    }
}
