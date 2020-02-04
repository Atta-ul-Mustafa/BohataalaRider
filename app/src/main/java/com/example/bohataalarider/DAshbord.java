package com.example.bohataalarider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import static com.example.bohataalarider.MainActivity.rloginB;

public class DAshbord extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    List<NewRetro> _new=new ArrayList<>();
    List<InProgressRetro> inProgress=new ArrayList<>();

    public  static int xid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashbord);
      ClientApi clientApi = Base.getClient().create(ClientApi.class);
        FRider fSubCat = new FRider(rloginB.getRiderId());
        Call<RriderA> call = clientApi. getnewInprogress(fSubCat);
call.enqueue(new Callback<RriderA>() {
    @Override
    public void onResponse(Call<RriderA> call, Response<RriderA> response) {
        RriderA rriderA=response.body();

        RriderB data=rriderA.getData();
        _new=data.getNew();
         inProgress=data.getInProgress();

        Toast.makeText(DAshbord.this, ""+rriderA.getMessage(), Toast.LENGTH_SHORT).show();
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        addTabs(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Toast.makeText(DAshbord.this, ""+position, Toast.LENGTH_SHORT).show();

            xid=position;
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onFailure(Call<RriderA> call, Throwable t) {
        Toast.makeText(DAshbord.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
    }
});

    }

    private void addTabs(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new AppleFragment(_new), "NEW");
        adapter.addFrag(new InProgress(inProgress), "INPROGRESS");
        adapter.addFrag(new OrangeFragment(), "hISTORY");
        viewPager.setAdapter(adapter);
    }
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


}
