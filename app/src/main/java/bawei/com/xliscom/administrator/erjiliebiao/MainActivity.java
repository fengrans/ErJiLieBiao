
package bawei.com.xliscom.administrator.erjiliebiao;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bawei.com.xliscom.administrator.erjiliebiao.adapters.MyAdapters;
public class MainActivity extends AppCompatActivity {
    List<Map<String, Object>> cdata = new ArrayList();
    @ViewInject(R.id.elv)
    ExpandableListView elv;
    private List<Newsinfo.DataBean> list = new ArrayList<>();
    private String str = "https://mock.eolinker.com/success/rq7m6GNqurs93zYkEANkY8Z4358Aihf1";
    private GoogleApiClient client;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        x.view().inject(this);
        RequestParams rp = new RequestParams(str);
        x.http().get(rp, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gon = new Gson();
                Newsinfo newsinfo = gon.fromJson(result, Newsinfo.class);
                MyAdapters mm = new MyAdapters(newsinfo.getData(), MainActivity.this);
                list = newsinfo.getData();
                elv.setAdapter(mm);
            }
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("123", ex + "");
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

}
