// pages/kitass/kitass/kitass.js
Page({
  logBtn:function(){
    wx.navigateTo({
      url: "../cook/cookinformation/cook",
    })
    // wx.request({
    //   url: 'http://localhost:8080/testtable/add',
    //   header:{
    //     'content-type': 'application/x-www-form-urlencoded;charset=utf-8' // 默认值
    //   },
    //   data:{
    //     id:1,
    //     name:"zhangsna",
    //     age:12,
    //     sex:"nan"
    //   },
    //   success: function (res) {
    //     // wx.navigateTo({
    //     //   url: '../register/register',
    //     // })
    //     console.log(res.data);
    //   },
    //   fail: function (res) {
    //     console.log(".....fail.....");
    //   }

    // })
  },
  /**
   * 页面的初始数据
   */
  data: {

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

  }
})