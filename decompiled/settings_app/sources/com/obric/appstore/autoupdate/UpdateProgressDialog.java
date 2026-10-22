package com.obric.appstore.autoupdate;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.obric.oui.progress.OProgressView;
import com.obric.oui.selection.OSelectionPanelBtnView;
import com.obric.oui.sheet.OInsetSheet;
import com.obric.oui.sheet.OInsetSheetTitleBar;
import obric.view.WindowManagerHelper;

/* JADX INFO: loaded from: classes4.dex */
public class UpdateProgressDialog {
    private static final int MESSAGE_DELAY_TIME = 300;
    private static final int MESSAGE_UPDATE_PROGRESS = 297;
    private static String TAG = "UpdateProgressDialog";
    private Context mActivity;
    private String mAppPkgName;
    private OInsetSheet mDialog;
    private int mModel;
    private TextView mPercent;
    private OProgressView mProgressBar;
    private UpdateHandler mUpdateHandler;

    private class UpdateHandler extends Handler {
        final /* synthetic */ UpdateProgressDialog this$0;

        private UpdateHandler(UpdateProgressDialog r1) {
            this.this$0 = r1;
        }

        /* synthetic */ UpdateHandler(UpdateProgressDialog r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r4) {
            if (r4.what != 297) goto L12;
            int r5 = ObricAutoUpdateUtils.getInstance().getDownloadProgress(UpdateProgressDialog.access$100(this.this$0), UpdateProgressDialog.access$200(this.this$0));
            if (r5 >= 0) goto L8;
            Log.d(UpdateProgressDialog.access$500(), "appstore progress: -1" + UpdateProgressDialog.access$200(this.this$0));
            return;
        L8:
            if (r5 != 100) goto L10;
            Log.d(UpdateProgressDialog.access$500(), "appstore progress:" + r5);
            UpdateProgressDialog.access$600(this.this$0, r5);
            this.this$0.dismiss();
            return;
        L10:
            UpdateProgressDialog.access$600(this.this$0, r5);
            sendEmptyMessageDelayed(297, 300);
            return;
        }
    }

    static {
    }

    static /* synthetic */ Context access$100(UpdateProgressDialog r0) {
        return r0.mActivity;
    }

    static /* synthetic */ String access$200(UpdateProgressDialog r0) {
        return r0.mAppPkgName;
    }

    static /* synthetic */ UpdateHandler access$300(UpdateProgressDialog r0) {
        return r0.mUpdateHandler;
    }

    static /* synthetic */ int access$400(UpdateProgressDialog r0) {
        return r0.mModel;
    }

    static /* synthetic */ String access$500() {
        return TAG;
    }

    static /* synthetic */ void access$600(UpdateProgressDialog r0, int r1) {
        r0.setProgress(r1);
    }

    public UpdateProgressDialog(Context r1, String r2, int r3) {
        this.mActivity = r1;
        this.mAppPkgName = r2;
        this.mModel = r3;
        this.mUpdateHandler = new UpdateHandler(this, null);
        this.mDialog = new OInsetSheet(r1);
        onCreate();
    }

    protected void onCreate() {
        this.mDialog.setRootWidth(OInsetSheet.PanelWidth.BOARD_WIDTH);
        this.mDialog.setHeaderView(genHeaderView());
        this.mDialog.setContainerView(genContentView());
        this.mDialog.setFooterView(genFootView());
        this.mDialog.setClearDimFlag(false);
        this.mDialog.setCanceledOnTouchOutside(true);
        this.mDialog.setCancelable(false);
    }

    private View genHeaderView() {
        OInsetSheetTitleBar r0 = new OInsetSheetTitleBar(this.mActivity);
        r0.setShowLeftBack(false);
        r0.setTitleText(this.mActivity.getString(R.string.auto_progress_title));
        r0.sheetTitleBarStyle();
        return r0;
    }

    private View genContentView() {
        View r0 = LayoutInflater.from(this.mActivity).inflate(R.layout.obric_auto_downloading, null);
        this.mPercent = (TextView) r0.findViewById(R.id.auto_downloading_percent);
        this.mProgressBar = (OProgressView) r0.findViewById(R.id.auto_progressbar);
        setProgress(0);
        return r0;
    }

    private View genFootView() {
        OSelectionPanelBtnView r0 = new OSelectionPanelBtnView(this.mActivity);
        r0.getBtnPositive().setVisibility(8);
        r0.getHorizontal_space().setVisibility(8);
        r0.getBtnNegative().setText(android.R.string.cancel);
        r0.getBtnNegative().setOnClickListener(new AnonymousClass1(this));
        return r0;
    }

    private void closePanel() {
        OInsetSheet r0 = this.mDialog;     // Catch: Exception -> L6
        if (r0 == null) goto L9;
        r0.dismiss();     // Catch: Exception -> L6
        return;
    L9:
        return;
    }

    private void setProgress(int r5) {
        TextView r0 = this.mPercent;
        if (r0 == null) goto L5;
        r0.setText(String.format("%d%%", new Object[]{Integer.valueOf(r5)}));
    L5:
        OProgressView r4 = this.mProgressBar;
        if (r4 == null) goto L9;
        r4.setProgress(r5);
        return;
    }

    public void show() {
    L7:
        e = move-exception;
        Log.e(TAG, "show: ", e);
    L9:
        this.mUpdateHandler.sendEmptyMessageDelayed(297, 300);
        return;
    L3:
        if ((this.mActivity instanceof Activity) == true) goto L5;
        this.mDialog.getWindow().setType(WindowManagerHelper.LayoutParamsSmt.TYPE_APPLICATION_OVERLAY);     // Catch: Exception -> L7
    L5:
        this.mDialog.show();     // Catch: Exception -> L7
        goto L9
    }

    public void showDelay(long r3) {
        if (r3 > 0) goto L6;
        show();
        return;
    L6:
        this.mUpdateHandler.postDelayed(new AnonymousClass2(this), r3);
    }

    public void dismiss() {
        closePanel();
        this.mUpdateHandler.removeMessages(297);
    }
}
