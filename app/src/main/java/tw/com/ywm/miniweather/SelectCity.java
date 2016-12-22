package tw.com.ywm.miniweather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.edu.pku.yangwenming.app.MyApplication;
import cn.edu.pku.yangwenming.bean.City;

/**
 * Created by ywm108 on 2016/10/18.
 */
public class SelectCity extends Activity implements View.OnClickListener {
    private ImageView mBackBtn;
    MyApplication app;
    ArrayList<String>  city =new ArrayList<String>();
    ArrayList<String>  cityId=new ArrayList<String>();
    List<City> data=new ArrayList<City>();
    String SelectedId;
    HashMap<String,String > hashMap = new HashMap<>();

    private ListView mlistView;
    private EditText mEditText;
    private String  stringEditText=null;
    @Override

   protected void onCreate(Bundle saveInstanceState)
    {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.select_city);
        mBackBtn = (ImageView)findViewById(R.id.title_back);
        mBackBtn.setOnClickListener(this);

        mEditText=(EditText)findViewById(R.id.search_Editxt);
        /**
         * 对EDITTEXT进行监控
         */
        mEditText.addTextChangedListener(mTextWatcher);
       //对edit赋予初值
        //mEditText.setText("北");

        mlistView=(ListView)findViewById(R.id.list_view);
        app=(MyApplication)getApplication();
        data=app.getCityList();
        int i=0;
       // stringEditText=mEditText.getText().toString();
      //  String stringGetCity=null;
        /*
        while(i<data.size()){
            //添加判定条件与searchEditText里的内容进行匹配操作
            stringGetCity=data.get(i).getCity().toString();
            if((stringGetCity).charAt(0)==(stringEditText).charAt(0)){
            city.add(stringGetCity);
            cityId.add(data.get(i).getNumber().toString());
            hashMap.put(data.get(i).getCity().toString(),data.get(i).getNumber().toString());
        }
            i++;

        }
*/
     //   ArrayAdapter<String> adapter=new ArrayAdapter<String>(SelectCity.this,android.R.layout.simple_list_item_1,city);
     //   mlistView.setAdapter(adapter);

        //listview的单击事件
        mlistView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
          @Override
            public void onItemClick(AdapterView<?>adapterView,View view,int i,long l){
              Toast.makeText(SelectCity.this,"你单击了:"+adapterView.getItemAtPosition(i).toString(),Toast.LENGTH_SHORT).show();
              TextView textview=(TextView) findViewById(R.id.cuerrent_city);
              textview.setText("当前城市:"+adapterView.getItemAtPosition(i).toString());
              mEditText.setText(adapterView.getItemAtPosition(i).toString());
          }
        });

    }
    TextWatcher mTextWatcher = new TextWatcher() {
        private CharSequence temp;
        private int editStart ;
        private int editEnd ;
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            temp = charSequence;
            Log.d("myapp","beforeTextChanged:"+temp) ;
        }
        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            String stringGetCity=null;
          //  mEditText.setText(charSequence.toString());
            stringEditText=mEditText.getText().toString();
            Log.d("myapp","onTextChanged:"+charSequence) ;
            while(i<data.size()){
                //添加判定条件与searchEditText里的内容进行匹配操作
                stringGetCity=data.get(i).getCity().toString();

                if((stringGetCity).substring(0,1).equals(stringEditText)){
                    city.add(stringGetCity);
                    cityId.add(data.get(i).getNumber().toString());
                    hashMap.put(data.get(i).getCity().toString(),data.get(i).getNumber().toString());
                }
                i++;
            }
            //与mListView关联
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(SelectCity.this,android.R.layout.simple_list_item_1,city);
            mlistView.setAdapter(adapter);
        }
        @Override
        public void afterTextChanged(Editable editable) {
            editStart = mEditText.getSelectionStart();
            editEnd = mEditText.getSelectionEnd();
            if (temp.length() > 10) {
                Toast.makeText(SelectCity.this,"你输入的字数已经超过了限制！",Toast.LENGTH_SHORT).show();
                editable.delete(editStart-1, editEnd);
                int tempSelection = editStart;
                mEditText.setText(editable);
                mEditText.setSelection(tempSelection);
            }
            Log.d("myapp","afterTextChanged:") ;
        }
    };
    @Override
    public void  onClick(View v){
        switch(v.getId()){
            case R.id.title_back:
                Intent i = new Intent();
                TextView textview=(TextView)findViewById(R.id.cuerrent_city);
                String splitTextView= textview.getText().toString();
                String[]  splitArray=splitTextView.split(":");
                String CityNumber=hashMap.get(splitArray[1].toString());
                //利用广播发送数据
                Intent intent = new Intent();
                if (CityNumber!=null) {
                    intent.putExtra("UpdateCitycode", CityNumber);
                }
                else
                {
                    intent.putExtra("UpdateCitycode", "101010100");
                }
                intent.setAction("com.ljq.activity.MyService");
                sendBroadcast(intent);
                i.putExtra("cityCode",CityNumber);

                setResult(RESULT_OK,i);
                finish();

            break;
            default:
                break;
        }
    }
}
