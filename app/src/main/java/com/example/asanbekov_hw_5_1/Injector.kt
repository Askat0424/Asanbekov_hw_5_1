package com.example.asanbekov_hw_5_1

class Injector {
    companion object {
        fun fillModel() = CounterModel()
        fun fillPresenter() = Presenter()
    }
}