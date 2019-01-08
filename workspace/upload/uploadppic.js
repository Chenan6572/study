// upload/uploadppic.js
const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    img_arr: [],
    formdata: '',
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

  },
  // 图片上传
 gotoshow:function(e){
    var that = this
    wx.chooseImage({
      count:3,  //选择上传的最大数
      sizeType:['original','compressed'],
      sourceType:['album','camera'],
      success: function(res) {
        const tempFilePaths = res.tempFilePaths;
        //上传操作
        wx.uploadFile({
          url:'http://localhost:8080/upload/uploadpic',
          filePath: tempFilePaths[0],
          name: 'file',
          header:{
            "Content-Type": "multipart/form-data",
            'accept': 'application/json',
          },
          method:"POST",
          success:function(res){
            const data = res.data
          },
          fail:function(e){
            wx.showToast({
              title: '服务器错误，提交失败',
              icon: "none",
              duration: 2000
            })
            console.log(res.data)
          }
        })
      },
      fail: function (e) {
        wx.showToast({
          title: '服务器错误，提交失败',
          icon: "none",
          duration: 2000
        })
      },
    })
 }
})