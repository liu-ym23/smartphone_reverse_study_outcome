package obric.widget.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import obric.widget.R;

/* JADX INFO: loaded from: classes5.dex */
public class NetworkView extends RelativeLayout {
    public static final int STATUS_LOADING = 1;
    public static final int STATUS_REFRESH = 0;
    private View mProgressView;
    private View mRefreshBtn;
    private View mRefreshLayout;
    private int mStatus;

    public NetworkView(Context context) {
        super(context);
        this.mStatus = 0;
    }

    public NetworkView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mStatus = 0;
    }

    public NetworkView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mStatus = 0;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mRefreshBtn = findViewById(R.id.refresh_btn);
        this.mRefreshLayout = findViewById(R.id.refresh_layout);
        this.mProgressView = findViewById(R.id.progress_view);
    }

    public void setStatus(int status) {
        this.mStatus = status;
        if (status == 1) goto L5;
        this.mRefreshLayout.setVisibility(0);
        this.mProgressView.setVisibility(8);
        return;
    L5:
        this.mRefreshLayout.setVisibility(8);
        this.mProgressView.setVisibility(0);
    }

    public int getStatus() {
        return this.mStatus;
    }

    public View getRefreshBtn() {
        return this.mRefreshBtn;
    }

    public View getProgressView() {
        return this.mProgressView;
    }

    public View getRefreshLayout() {
        return this.mRefreshLayout;
    }
}
