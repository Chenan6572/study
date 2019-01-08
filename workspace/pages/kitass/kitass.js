// pages/kitass/kitass/kitass.js
const app = getApp();
Page({
  logBtn: function() {
    wx.navigateTo({
      url: "../cook/cookinformation/cook",
    })
  },
  /**
   * 页面的初始数据
   */
  data: {
    ishavedata: false,
    cooklist: []
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
  onShow: function() {
    var thatdat = this;
    wx.request({
      url: 'http://localhost:8080/cookRegister/cooklist?account=' + "15590135025",
      header: {
        'content-type': 'application/x-www-form-urlencoded;charset=utf-8' // 默认值
      },
      success: function(res) {
        console.log(res.data);
        thatdat.setData({
          cooklist: res.data,
          ishavedata: true
        })
      },
      fail: function(res) {

      }
    })
  },
  //编辑
  editbtn: function() {
    wx.navigateTo({
      url: "../cookedit/cookedit",
    })
    wx.request({
      url: 'http://localhost:8080/cookRegister/update',
      header: {
        'content-type': 'application/x-www-form-urlencoded;charset=utf-8' // 默认值
      },
      success: function (res) {
        console.log(res.data);
        thatdat.setData({
          cooklist: res.data,
          ishavedata: true
        })
      },
      fail: function (res) {

      }
    })
  },
  //删除
  delbtn: function(e) {
    var thatdat = this;
    // 取得下标
    var index = parseInt(e.currentTarget.dataset.index);
    // 取出id值
    var id = this.data.addressObjects[index].get('id');
    wx.request({
      url: 'http://localhost:8080/cookRegister/delete？id=' +id,
      header: {
        'content-type': 'application/x-www-form-urlencoded;charset=utf-8' // 默认值
      },
      success: function(res) {
        thatdat.onShow();
        wx.showModal({
          title: '提示',
          content: '确定要删除吗？',
          success: function(e) {
            if (e.confirm) {
              // 用户点击了确定 可以调用删除方法了
            } else if (e.cancel) {
              console.log('用户点击取消')
            }
          }
        })
      },
      fail: function(res) {
        wx.showToast({
          title: '服务器错误，提交失败',
          icon: "none",
          duration: 2000
        })
        console.log(res.data)
      }
    })
  }
})