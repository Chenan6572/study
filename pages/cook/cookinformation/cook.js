// pages/cook/cookinformation/cook.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    cookname:"",
    cooktel:"",
    cookpei:"",
    cookhealth:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {
    

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  },
  subMission:function(){
    wx.request({
      url: 'http://localhost:8080/cookRegister/add',
      header:{
        'content-type': 'application/x-www-form-urlencoded;charset=utf-8' // 默认值
      },
      data:{
        id:"",
        cookName:this.data.cookname,
        cookTel: this.data.cooktel,
        cookPei: this.data.cookpei,
        cooKHealth: this.data.coolhealth
      },
      success:function(res){
        console.log(res.data)
        wx.navigateTo({
          url:"../../kitass/kitass"
        })
      },
      fail:function(res){
        wx.showToast({
          title: '服务器错误，提交失败',
          icon:"none",
          duration:2000
        })
        console.log(res.data)
      }
    })
  },
  setCookname:function(e){
    this.setData({
      cookname: e.detail.value
    })
  },
  setCooktel: function (e) {
    this.setData({
      cooktel: e.detail.value
    })
  },
  setCookpei:function(e){
    this.setData({
      cookpei:e.detail.value
    })
  }, 
  setCookhealth:function(e){
    this.setData({
      cookhealth:e.detail.value
    })
  }
})