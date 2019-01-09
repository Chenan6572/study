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
      url: 'http://localhost:8080/cookRegister/cooklist?account=' + "15590135025",
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
  },
  choose: function () {
    var that = this
    wx.chooseImage({
      count: 1,
      sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
      sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
      success: function (res) {
        var tempFilePaths = res.tempFilePaths
        that.setData({
          tempFilePaths: res.tempFilePaths
        })
        // wx.uploadFile({
        //   url:'http://localhost:8080/upload/uploadpic',
        //   filePath: tempFilePaths[0],
        //   name: 'file',
        //   header:{
        //     "Content-Type": "multipart/form-data",
        //     'accept': 'application/json',
        //   },
        //   method:"POST",
        //   success:function(res){
        //     const data = res.data

        //     console.log(res)
        //     // that.setData({
        //     //   avatar: res.data
        //     // })
        //     // console.log(avatar)
        //   },
        //   fail:function(e){
        //     wx.showToast({
        //       title: '服务器错误，提交失败',
        //       icon: "none",
        //       duration: 2000
        //     })
        //     console.log(res.data)
        //   }
        // })
      }
    })
  }
})