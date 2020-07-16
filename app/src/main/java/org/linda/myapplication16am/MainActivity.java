package org.linda.myapplication16am;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import android.view.Gravity;

import android.view.View;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Main_Avtivity";
    ImageView ivMenu;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ivMenu = findViewById(R.id.iv_menu);
        drawerLayout = findViewById(R.id.drawer);

        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.view_pager);

        toolbar = findViewById(R.id.toobar);
        setSupportActionBar(toolbar);

        adapter = new FragmentAdapter(getSupportFragmentManager(), 1);

        //Fragment Adepter에 컬렉션 담기
        adapter.addFragment(new Frag1());
        adapter.addFragment(new Frag2());

        //ViewPager와 Fragment 연결 -> 슬라이딩 가능하게 하기
        viewPager.setAdapter(adapter);

        //ViewPager과 TabLayout 연결하기
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText("첫번째");
        tabLayout.getTabAt(1).setText("두번째");



        ivMenu.setOnClickListener((View view)->{
            drawerLayout.openDrawer(Gravity.RIGHT);
        });
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return false;
    }*/

}