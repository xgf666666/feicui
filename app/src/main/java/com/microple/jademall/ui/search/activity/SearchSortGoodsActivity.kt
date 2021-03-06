package com.microple.jademall.ui.search.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.view.View
import android.widget.TextView
import com.microple.jademall.R
import com.microple.jademall.bean.Category
import com.microple.jademall.bean.TwoSearch
import com.microple.jademall.ui.home.HomeGoodsFragment
import com.microple.jademall.ui.home.adapter.HomeTabAdapter
import com.microple.jademall.ui.search.SortGoodsFragment
import com.microple.jademall.ui.search.adapter.SearchSortTabAdapter
import com.microple.jademall.ui.search.mvp.contract.SearchSortGoodsContract
import com.microple.jademall.ui.search.mvp.presenter.SearchSortGoodsPresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_sort_goods.*
import java.util.ArrayList

/**
 * author: linfeng
 * date: 2018/8/7.
 * describe:分类搜索二级分类商品列表
 */
class SearchSortGoodsActivity : BaseMvpActivity<SearchSortGoodsPresenter>(),SearchSortGoodsContract.View, View.OnClickListener {

    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): SearchSortGoodsPresenter = SearchSortGoodsPresenter()

    companion object {
        fun startSearchSortGoodsActivity(context: Context,cat_id:Int,name:String){
            val intent = Intent(context, SearchSortGoodsActivity::class.java)
            intent.putExtra("cat_id",cat_id)
            intent.putExtra("name",name)
            context.startActivity(intent)
        }
    }
    override fun getCategory(data: TwoSearch) {
        initGoodsData(data)
    }
    /**
     * 初始化数据状态
     */
    var cat_id=0
    var name=""
    val fragments = ArrayList<Fragment>()
    override fun initData() {
        getPresenter().getCategory(""+intent.getIntExtra("cat_id",0))
         cat_id=intent.getIntExtra("cat_id",0)
         name=intent.getStringExtra("name")
        tv_head.text=name
        iv_back.setOnClickListener(this)
        tv_filtrate.setOnClickListener(this)
        tv_price.setOnClickListener(this)
        tv_hot.setOnClickListener(this)
        tv_newest.setOnClickListener(this)
    }
    private fun initGoodsData(data: TwoSearch) {
        for (i in 0..data.sec_cates.size-1) {
            var fragment= HomeGoodsFragment()
            var bundle= Bundle()
            bundle.putInt("cat_id",data.sec_cates[i].cat_id)
            fragment.arguments=bundle
            fragments.add(fragment)
        }
        viewPager.adapter = HomeTabAdapter(supportFragmentManager, fragments, data.sec_cates)
        slidingTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE)
        slidingTabLayout.setupWithViewPager(viewPager)

    }


    /**
     * 初始化事件
     */
    override fun initEvent() {
    }

    private var isFiltrate = true

    override fun getActivityLayoutId(): Int = R.layout.activity_sort_goods


    var price=0
    var sort=""
    override fun onClick(v: View?) {
        when (v) {
            iv_back -> finish()
            tv_filtrate -> {
                if (isFiltrate) {
                    ll_filtrate.visibility = View.VISIBLE
                    isFiltrate = !isFiltrate
                } else {
                    ll_filtrate.visibility = View.GONE
                    isFiltrate = !isFiltrate
                }
            }
            tv_price -> {
                setText(tv_price)
                sort="goods_price"
                if (price==0){
                    price=1
                    sort="goods_price desc"
                }else{
                    price=0
                    sort="goods_price asc"
                }
                for (i:Int in 0..fragments.size-1){
                    (fragments[i] as HomeGoodsFragment).setCat_id(sort)
                }
            }
            tv_hot -> {
                setText(tv_hot)
                for (i:Int in 0..fragments.size-1){
                    (fragments[i] as HomeGoodsFragment).setCat_id("hot")
                }

            }
            tv_newest -> {
                setText(tv_newest)
                for (i:Int in 0..fragments.size-1){
                    (fragments[i] as HomeGoodsFragment).setCat_id("new")
                }

            }
        }
    }
    fun setText(textView: TextView){
        tv_newest.setTextColor(resources.getColor(R.color.text_black))
        tv_price.setTextColor(resources.getColor(R.color.text_black))
        tv_hot.setTextColor(resources.getColor(R.color.text_black))
        textView.setTextColor(resources.getColor(R.color.colorMain))

    }
}