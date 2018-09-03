package com.microple.jademall.ui.search.mvp.presenter

import android.view.SearchEvent
import com.microple.jademall.ui.home.mvp.contract.GoodsDetailContract
import com.microple.jademall.ui.home.mvp.contract.HomeGoodsContract
import com.microple.jademall.ui.home.mvp.model.GoodsDetailModel
import com.microple.jademall.ui.home.mvp.model.HomeGoodsModel
import com.microple.jademall.ui.search.mvp.contract.SearchContract
import com.microple.jademall.ui.search.mvp.contract.SearchResultGoodsContract
import com.microple.jademall.ui.search.mvp.model.SeachModel
import com.microple.jademall.ui.search.mvp.model.SeachResultGoodsModel
import com.weibiaogan.litong.extensions.ui

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class SearchResultGoodsPresenter:SearchResultGoodsContract.Presenter() {


    override fun createModel(): SearchResultGoodsContract.Model =SeachResultGoodsModel()
}