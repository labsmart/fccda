package br.com.luiz.AgendaFCCDA_01;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabWidget;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import Adapters.ViewPagerAdapter;


public class MainActivity extends FragmentActivity implements
        TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener {

    private TabHost mTabHost;
    private ViewPager mViewPager;
    private HashMap<String, TabInfo> mapTabInfo = new HashMap<String, MainActivity.TabInfo>();
    private PagerAdapter mPagerAdapter;


    // Informacao da Tab
    private class TabInfo {
        private String tag;
        private Class<?> clss;
        private Bundle args;
        private Fragment fragment;

        TabInfo(String tag, Class<?> clazz, Bundle args) {
            this.tag = tag;
            this.clss = clazz;
            this.args = args;
        }
    }


    // Um simples factory que retorna View para o TabHost
    class TabFactory implements TabContentFactory {

        private final Context mContext;

        public TabFactory(Context context) {
            mContext = context;
        }

        public View createTabContent(String tag) {
            View v = new View(mContext);
            v.setMinimumWidth(0);
            v.setMinimumHeight(0);
            return v;
        }

    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // Infla o layout
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Inicializa o TabHost
        this.initialiseTabHost(savedInstanceState);
        if (savedInstanceState != null) {
            // Define a Tab de acordo com o estado salvo
            mTabHost.setCurrentTabByTag(savedInstanceState.getString("tab"));
        }
        // Inicializa o ViewPager
        this.intialiseViewPager();



    }


    @Nullable

    protected void onSaveInstanceState(Bundle outState) {
        // salva a Tab selecionada
        outState.putString("tab", mTabHost.getCurrentTabTag());
        super.onSaveInstanceState(outState);
    }

    private void intialiseViewPager() {

        List<Fragment> fragments = new Vector<Fragment>();
        fragments.add(Fragment.instantiate(this, AbaEventos.class.getName()));
        fragments.add(Fragment.instantiate(this, AbaMenu.class.getName()));
        this.mPagerAdapter = new ViewPagerAdapter(
                super.getSupportFragmentManager(), fragments);
        this.mViewPager = (ViewPager) super.findViewById(R.id.viewpager);
        this.mViewPager.setAdapter(this.mPagerAdapter);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private void initialiseTabHost(Bundle args) {
        mTabHost = (TabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup();

        TabInfo tabInfo = null;
        MainActivity.AddTab(this, this.mTabHost,
                this.mTabHost.newTabSpec("Tab1").setIndicator("EVENTOS"),
                (tabInfo = new TabInfo("Tab1", AbaEventos.class, args)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);
        MainActivity.AddTab(this, this.mTabHost,
                this.mTabHost.newTabSpec("Tab2").setIndicator("MENU"),
                (tabInfo = new TabInfo("Tab2", AbaMenu.class, args)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);

        mTabHost.setOnTabChangedListener(this);


        // Trecho utilizado para setar background do tabhost
        TabWidget widget = mTabHost.getTabWidget();
        for (int i = 0; i < widget.getChildCount(); i++) {
            View v = widget.getChildAt(i);
            v.setBackgroundResource(R.drawable.tab_indicator);


        }

        for (int i = 0; i < mTabHost.getTabWidget().getTabCount(); i++) {
            LinearLayout rl = (LinearLayout) mTabHost.getTabWidget().getChildAt(i);
            TextView textView = (TextView) rl.getChildAt(1);
            textView.setTextColor(Color.WHITE);
        }
    }
/*

	public void MenuPC (View v) {
		Intent intent = new Intent(this, PontosCulturaisActivity.class);
		startActivity(intent);
	}
	*/

    // Opção para acessar pontos culturais
    public void MenuPC(View v) {
        Intent intent = new Intent(this, PontosCulturaisActivity.class);
        startActivity(intent);
    }



    // Opção para acessar promocoes
    public void MenuPromocoes(View v) {
        Intent intent = new Intent(this, PromocoesActivity.class);
        startActivity(intent);
    }

    // Opção para acessar sobre
    public void MenuSobre(View v) {
        Intent intent = new Intent(this, SobreActivity.class);
        startActivity(intent);
    }



    public void filtro(View v) {


        View a = findViewById(R.id.linear_edit);
        View b = findViewById(R.id.linear_txt);

        a.setVisibility(View.VISIBLE);
        b.setVisibility(View.GONE);


    }


    public void voltar_filtro(View v) {


        View a = findViewById(R.id.linear_edit);
        View b = findViewById(R.id.linear_txt);

        a.setVisibility(View.GONE);
        b.setVisibility(View.VISIBLE);

        EditText campo_txt = (EditText) findViewById(R.id.edit_text_texto);
        campo_txt.setText(null);



    }


    private static void AddTab(MainActivity activity, TabHost tabHost,
                               TabHost.TabSpec tabSpec, TabInfo tabInfo) {
        // Attach uma Tab view factory para o spec
        tabSpec.setContent(activity.new TabFactory(activity));
        tabHost.addTab(tabSpec);
    }

    public void onTabChanged(String tag) {
        // Avisa para o mViewPager qual a Tab que est&aacute; ativa
        int pos = this.mTabHost.getCurrentTab();


        //mTabHost.getTabWidget().getChildAt(0).setBackgroundColor(Color.parseColor("#2F4F4F"));

        this.mViewPager.setCurrentItem(pos);


    }

    @Override
    public void onPageScrolled(int position, float positionOffset,
                               int positionOffsetPixels) {
    }


    @Override
    public void onPageSelected(int position) {
        this.mTabHost.setCurrentTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


}
