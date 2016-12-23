package tw.com.ywm.miniweather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.umeng.analytics.MobclickAgent;
import com.umeng.update.UmengUpdateAgent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ywm108 on 2016/11/29.
 */
public class Guide extends Activity implements ViewPager.OnPageChangeListener {
    private viewPagerAdapter vpApdater;
    private ViewPager vp;
    private List<View> views;
    private ImageView[] dots;
    private int[] ids={R.id.iv1,R.id.iv2,R.id.iv3};
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide);
        initviews();
        initDots();
        btn=(Button)views.get(2).findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Guide.this,MainActivity.class);
                    startActivity(i);
                finish();
            }
        });
        UmengUpdateAgent.update(this);

    }
    private void initDots(){
        dots = new ImageView[views.size()];
        for(int i=0;i<views.size();i++){
            dots[i]=(ImageView) findViewById(ids[i]);
        }
    }
    private void initviews(){
        LayoutInflater  inflater=LayoutInflater.from(this);
        views=new ArrayList<View>();
        views.add(inflater.inflate(R.layout.pager1,null));
        views.add(inflater.inflate(R.layout.pager2,null));
        views.add(inflater.inflate(R.layout.pager3,null));
        vpApdater=new viewPagerAdapter(views,this);
        vp=(ViewPager) findViewById(R.id.viewpager);
        vp.setAdapter(vpApdater);
        vp.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
       for(int a=0;a<ids.length;a++){
           if(a==position){
               dots[a].setImageResource(R.drawable.page_indicator_focused);
           }
           else{
               dots[a].setImageResource(R.drawable.page_indicator_unfocused);
           }
       }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

}
