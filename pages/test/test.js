// pages/test/test.js
const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    ishavedata:false,
    cooklist:[],
    cooks:[
      {
        name:"乔佳伟",
        age:18
      },
      {
        name: "王家乐",
        age: 17
      }, {
        name: "王家乐",
        age: 17
      }
      , {
        name: "王家乐",
        age: 17
      }
      , {
        name: "王家乐",
        age: 17
      }
      , {
        name: "王家乐",
        age: 17
      }
      , {
        name: "王家乐",
        age: 17
      }
      , {
        name: "王家乐",
        age: 17
      }
    ]

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    var thatdat = this;
    wx.request({
      url: 'http://localhost:8080/cookRegister/cooklist?account=' + "123",
      header:{
        'content-type': 'application/x-www-form-urlencoded;charset=utf-8' // 默认值
      },
      success:function(res){
        console.log(res.data);
        thatdat.setData({
          cooklist:res.data,
          ishavedata:true
        })
      },
      fail:function(res){

      }
    })
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },

  setCooks:function(e){
    this.setData({
      cooklist:e
    })
  }
})