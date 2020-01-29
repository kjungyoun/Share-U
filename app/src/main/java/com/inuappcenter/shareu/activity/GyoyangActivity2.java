package com.inuappcenter.shareu.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.inuappcenter.shareu.R;
import com.inuappcenter.shareu.model.Code;
import com.inuappcenter.shareu.model.Major;
import com.inuappcenter.shareu.recycler.MajorAdapter2;
import com.inuappcenter.shareu.service.RetrofitHelper;
import com.inuappcenter.shareu.service.RetrofitService;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.view.View.VISIBLE;

public class GyoyangActivity2 extends AppCompatActivity {

    private ArrayList<Major> dataList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_major);

        //this.initializeData();

        TextView tv_gyoyang = (TextView) findViewById(R.id.tv_gyoyang) ;
        TextView tv_my_gyoyang = (TextView) findViewById(R.id.tv_my_major) ;
        tv_gyoyang.setTextColor(Color.parseColor("#574FBA"));
        tv_gyoyang.setTypeface(Typeface.DEFAULT_BOLD);
        tv_my_gyoyang.setVisibility(VISIBLE);

        Intent intent =getIntent();
        String name = intent.getExtras().getString("select_gyoyang"); /*String형*/
        tv_my_gyoyang.setText(name);
        //initializeData();

        RetrofitService networkService = RetrofitHelper.create();
        networkService.getDetailedGyoyangList(name).enqueue(new Callback<List<Major>>(){
            @Override
            public void onResponse(Call<List<Major> > call, Response<List<Major>> response) {
                if(response.isSuccessful())
                {
                    dataList = new ArrayList<>();
                    String flag ="?";
                    Log.e("ㄷㄷ",response.body().size()+"");
                    for(int i=0;i<response.body().size();i++)
                    {
                        Log.e("냥",response.body().get(i).third+"");
                        if(flag.equals(response.body().get(i).third))
                        {
                            Log.e("흠",flag+" "+response.body().get(i).third);
                            dataList.add(new Major(response.body().get(i).first,response.body().get(i).second,null,Code.ViewType.MAJOR));
                        }
                        else
                        {
                            Log.e("힝",flag+" "+response.body().get(i).third);
                            flag=response.body().get(i).third;
                            dataList.add(new Major("  "+response.body().get(i).third,null,null,Code.ViewType.INDEX));
                            dataList.add(new Major(response.body().get(i).first,response.body().get(i).second,null,Code.ViewType.MAJOR));
                        }
                    }



                }
                RecyclerView recyclerView = findViewById(R.id.recyclerview_select_major);
                LinearLayoutManager manager
                        = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL,false);
                recyclerView.setLayoutManager(manager); // LayoutManager 등록
                recyclerView.setAdapter(new MajorAdapter2(GyoyangActivity2.this,dataList));  // Adapter 등록
            }
            @Override
            public void onFailure(Call<List<Major>> call, Throwable t) {

            }
        });



        Button btn_left_bar_major = (Button)findViewById(R.id.btn_left_bar_major);
        Button.OnClickListener onClickListener2 = new Button.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                switch(view.getId())
                {
                    case R.id.btn_left_bar_major:
                        finish();
                }
            }
        };
        btn_left_bar_major.setOnClickListener(onClickListener2);

    }
    public void initializeData()
    {
        dataList = new ArrayList<>();

        dataList.add(new Major("사용자1님이 입장하셨습니다.33", null, null, Code.ViewType.INDEX));
        dataList.add(new Major("안녕하세요33", "사용자1", null, Code.ViewType.MAJOR));
        dataList.add(new Major("사용자2님이 입장하셨습니다.", null, null, Code.ViewType.INDEX));
        dataList.add(new Major("안녕하세요", "사용자2",null,  Code.ViewType.MAJOR));
        dataList.add(new Major("사용자1님이 입장하셨습니다.", null, null, Code.ViewType.INDEX));
        dataList.add(new Major("안녕하세요", "사용자1", null, Code.ViewType.MAJOR));
        dataList.add(new Major("사용자2님이 입장하셨습니다.", null, null, Code.ViewType.INDEX));
        dataList.add(new Major("안녕하세요", "사용자2",null,  Code.ViewType.MAJOR));
        dataList.add(new Major("사용자1님이 입장하셨습니다.", null, null, Code.ViewType.INDEX));
        dataList.add(new Major("안녕하세요", "사용자1", null, Code.ViewType.MAJOR));
        dataList.add(new Major("사용자2님이 입장하셨습니다.", null, null, Code.ViewType.INDEX));
        dataList.add(new Major("안녕하세요", "사용자2",null,  Code.ViewType.MAJOR));
        dataList.add(new Major("사용자1님이 입장하셨습니다.", null, null, Code.ViewType.INDEX));
        dataList.add(new Major("안녕하세요", "사용자1", null, Code.ViewType.MAJOR));
        dataList.add(new Major("사용자2님이 입장하셨습니다.", null, null, Code.ViewType.INDEX));
        dataList.add(new Major("안녕하세요", "사용자2",null,  Code.ViewType.MAJOR));
        dataList.add(new Major("사용자1님이 입장하셨습니다.", null, null, Code.ViewType.INDEX));
        dataList.add(new Major("안녕하세요", "사용자1", null, Code.ViewType.MAJOR));
        dataList.add(new Major("사용자2님이 입장하셨습니다.", null, null, Code.ViewType.INDEX));
        dataList.add(new Major("안녕하세요", "사용자2",null,  Code.ViewType.MAJOR));
        dataList.add(new Major("사용자1님이 입장하셨습니다.", null, null, Code.ViewType.INDEX));
        dataList.add(new Major("안녕하세요", "사용자1", null, Code.ViewType.MAJOR));
        dataList.add(new Major("사용자2님이 입장하셨습니다.", null, null, Code.ViewType.INDEX));
        dataList.add(new Major("안녕하세요", "사용자2",null,  Code.ViewType.MAJOR));
        dataList.add(new Major("사용자1님이 입장하셨습니다.", null, null, Code.ViewType.INDEX));
        dataList.add(new Major("안녕하세요", "사용자1", null, Code.ViewType.MAJOR));
        dataList.add(new Major("사용자2님이 입장하셨습니다.", null, null, Code.ViewType.INDEX));
        dataList.add(new Major("안녕하세요", "사용자2",null,  Code.ViewType.MAJOR));
        dataList.add(new Major("사용자1님이 입장하셨습니다.", null, null, Code.ViewType.INDEX));
        dataList.add(new Major("안녕하세요", "사용자1", null, Code.ViewType.MAJOR));
        dataList.add(new Major("사용자2님이 입장하셨습니다.", null, null, Code.ViewType.INDEX));
        dataList.add(new Major("안녕하세요", "사용자2",null,  Code.ViewType.MAJOR));
        dataList.add(new Major("사용자1님이 입장하셨습니다.", null, null, Code.ViewType.INDEX));
        dataList.add(new Major("안녕하세요", "사용자1", null, Code.ViewType.MAJOR));
        dataList.add(new Major("사용자2님이 입장하셨습니다.", null, null, Code.ViewType.INDEX));
        dataList.add(new Major("안녕하세요", "사용자2",null,  Code.ViewType.MAJOR));
        dataList.add(new Major("사용자1님이 입장하셨습니다.", null, null, Code.ViewType.INDEX));
        dataList.add(new Major("안녕하세요", "사용자1", null, Code.ViewType.MAJOR));
        dataList.add(new Major("사용자2님이 입장하셨습니다.", null, null, Code.ViewType.INDEX));
        dataList.add(new Major("안녕하세요", "사용자2",null,  Code.ViewType.MAJOR));
    }
    public void initializeData2()
    {
        dataList = new ArrayList<>();

        dataList.add(new Major("사용자1님이 입장하셨습니다2.", null, null, Code.ViewType.INDEX));
        dataList.add(new Major("안녕하세요2", "사용자1", null, Code.ViewType.MAJOR));
        dataList.add(new Major("사용자2님이 입장하셨습니다.", null, null, Code.ViewType.INDEX));
        dataList.add(new Major("안녕하세요", "사용자2",null,  Code.ViewType.MAJOR));
        dataList.add(new Major("사용자1님이 입장하셨습니다.", null, null, Code.ViewType.INDEX));
        dataList.add(new Major("안녕하세요", "사용자1", null, Code.ViewType.MAJOR));
        dataList.add(new Major("사용자2님이 입장하셨습니다.", null, null, Code.ViewType.INDEX));
        dataList.add(new Major("안녕하세요", "사용자2",null,  Code.ViewType.MAJOR));
        dataList.add(new Major("사용자1님이 입장하셨습니다.", null, null, Code.ViewType.INDEX));
        dataList.add(new Major("안녕하세요", "사용자1", null, Code.ViewType.MAJOR));
        dataList.add(new Major("사용자2님이 입장하셨습니다.", null, null, Code.ViewType.INDEX));
        dataList.add(new Major("안녕하세요", "사용자2",null,  Code.ViewType.MAJOR));
        dataList.add(new Major("사용자1님이 입장하셨습니다.", null, null, Code.ViewType.INDEX));
        dataList.add(new Major("안녕하세요", "사용자1", null, Code.ViewType.MAJOR));
        dataList.add(new Major("사용자2님이 입장하셨습니다.", null, null, Code.ViewType.INDEX));
        dataList.add(new Major("안녕하세요", "사용자2",null,  Code.ViewType.MAJOR));
        dataList.add(new Major("사용자1님이 입장하셨습니다.", null, null, Code.ViewType.INDEX));
        dataList.add(new Major("안녕하세요", "사용자1", null, Code.ViewType.MAJOR));
        dataList.add(new Major("사용자2님이 입장하셨습니다.", null, null, Code.ViewType.INDEX));
        dataList.add(new Major("안녕하세요", "사용자2",null,  Code.ViewType.MAJOR));
        dataList.add(new Major("사용자1님이 입장하셨습니다.", null, null, Code.ViewType.INDEX));
        dataList.add(new Major("안녕하세요", "사용자1", null, Code.ViewType.MAJOR));
        dataList.add(new Major("사용자2님이 입장하셨습니다.", null, null, Code.ViewType.INDEX));
        dataList.add(new Major("안녕하세요", "사용자2",null,  Code.ViewType.MAJOR));
        dataList.add(new Major("사용자1님이 입장하셨습니다.", null, null, Code.ViewType.INDEX));
        dataList.add(new Major("안녕하세요", "사용자1", null, Code.ViewType.MAJOR));
        dataList.add(new Major("사용자2님이 입장하셨습니다.", null, null, Code.ViewType.INDEX));
        dataList.add(new Major("안녕하세요", "사용자2",null,  Code.ViewType.MAJOR));
        dataList.add(new Major("사용자1님이 입장하셨습니다.", null, null, Code.ViewType.INDEX));
        dataList.add(new Major("안녕하세요", "사용자1", null, Code.ViewType.MAJOR));
        dataList.add(new Major("사용자2님이 입장하셨습니다.", null, null, Code.ViewType.INDEX));
        dataList.add(new Major("안녕하세요", "사용자2",null,  Code.ViewType.MAJOR));
        dataList.add(new Major("사용자1님이 입장하셨습니다.", null, null, Code.ViewType.INDEX));
        dataList.add(new Major("안녕하세요", "사용자1", null, Code.ViewType.MAJOR));
        dataList.add(new Major("사용자2님이 입장하셨습니다.", null, null, Code.ViewType.INDEX));
        dataList.add(new Major("안녕하세요", "사용자2",null,  Code.ViewType.MAJOR));
        dataList.add(new Major("사용자1님이 입장하셨습니다.", null, null, Code.ViewType.INDEX));
        dataList.add(new Major("안녕하세요", "사용자1", null, Code.ViewType.MAJOR));
        dataList.add(new Major("사용자2님이 입장하셨습니다.", null, null, Code.ViewType.INDEX));
        dataList.add(new Major("안녕하세요", "사용자2",null,  Code.ViewType.MAJOR));
    }
}