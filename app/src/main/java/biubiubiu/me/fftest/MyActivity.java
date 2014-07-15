package biubiubiu.me.fftest;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.PersistentCookieStore;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import me.biubiubiu.libraryff.AppConstants;
import me.biubiubiu.libraryff.ConfigResult;
import me.biubiubiu.libraryff.RecordConfigHandler;


public class MyActivity extends ActionBarActivity {

    private AsyncHttpClient mClient;
    private UrlFactory mUrlFactory;
    private PersistentCookieStore mCookieStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUrlFactory = new UrlFactory(this);
        setContentView(R.layout.activity_my);
        mClient = new AsyncHttpClient();
        mClient.addHeader("User-Agent", "zhangwei1.0");
        mCookieStore = new PersistentCookieStore(MyActivity.this);
        mClient.setCookieStore(mCookieStore);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void getChapter(View view) {
        mClient.get(AppConstants.DEMO_CHAPTER_URL,
                new RecordConfigHandler(MyActivity.this) {
                    @Override
                    protected void postGetChapter() {
                        ToastUtils.show(MyActivity.this, "获取配置信息成功");
                    }
                }
        );
    }

    public void printConfig(View view) {
        ConfigResult cr = ConfigResult.readConfig(this);
        Toast.makeText(MyActivity.this, ReflectionToStringBuilder.reflectionToString(cr), Toast.LENGTH_SHORT).show();
    }

    public void sendMessage(View view) {
        MessageSender ms = new MessageSender(MyActivity.this);
        ms.send();
    }

    public void checkLogin(View view) {
        String url = mUrlFactory.buildCheckLoginUrl();
        mClient.get(url, new CheckLoginHandler() {

            @Override
            protected void onSuccess() {
                ToastUtils.show(MyActivity.this, "已登录");
            }

            @Override
            protected void onFailure() {
                ToastUtils.show(MyActivity.this, "登录失败");
            }
        });
    }

    public void logout(View view) {
//        NetUtil.clearCookie(this);
        mCookieStore.clear();
        ToastUtils.show(this, "cookie cleared");
    }
}
