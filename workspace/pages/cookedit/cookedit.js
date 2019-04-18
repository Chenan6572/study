// pages/cookedit/cookedit.js

let app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    isSubmit: false,
    warn: "",
    phone: "",
    pwd: "",
    isPub: false,
    sex:"女"

  },
  formSubmit: function (e) {
    console.log(e.detail.value);
    let { phone, pwd, isPub, sex } = e.detail.value;
    if (!phone || !pwd) {
      this.setData({
        warn: "手机号或密码为空！",
        isSubmit: true
      })
      return;
    }
    this.setData({
      warn: "",
      isSubmit: true,
      phone,
      pwd,
      isPub,
      sex
    })
  },
  formReset: function () {
    console.log('form发生了reset事件')
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