package com.microple.jademall.ui.live.mvp.contract

import com.microple.jademall.bean.LiveGoods
import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface LiveGoodsContract {
    interface View :BaseMvpView{
        fun getGoods(liveGoods: LiveGoods)

    }
    interface Model{
        fun getGoods(live_id:String): Observable<BaseResponseEntity<LiveGoods>>

    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun getGoods(live_id:String)
    }
}