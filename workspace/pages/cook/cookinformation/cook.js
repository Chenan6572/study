// pages/cook/cookinformation/cook.js
const app = getApp();
Page({
  /**
   * 页面的初始数据
   */
  data: {
    account:"",
    cookname: "",
    cooktel: "",
    cookpei: "",
    cookhealth:"../../../resource/jason.jpeg",
    tempcookimg:""
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    var that = this
    wx.request({
      url: 'http://localhost:8080/cookRegister/detail?cookRegisterId=1547023584803501780',
      data: {},
      header: {
        'content-type': 'application/x-www-form-urlencoded;charset=utf-8' // 默认值
      },
      method: 'POST',
      success: function (res) {
        console.log(res.data)
        console.log(res.data.cookHealth.substr(1, 40));
        that.setData({
          account: res.data.account,
          cookname: res.data.cookName,
          cooktel: res.data.cookTel,
          cookpei: res.data.cookPei,
          cookhealth: "http://localhost:8080/showimg/" + res.data.cookHealth.substr(1, 40)
          
        })
      },
      fail: function (res) { }
    })

    console.log("我要打嗝。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。")
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {
    console.log("我也要打嗝。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。")

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {
    console.log("我不想打嗝。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。")
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {
    console.log("我也不想打嗝。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。")
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {
    console.log("我不知道到底打不打嗝。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。")
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
  //form表单
  formSubmit: function (e) {
    console.log(e.detail.value);
    var {account,cookname,cooktel,cookpei} = e.detail.value;
    var thatData = this;
    wx.request({
      url: 'http://localhost:8080/cookRegister/add',
      header: {
        'content-type': 'application/x-www-form-urlencoded;charset=utf-8' // 默认值
      },
      data: {
        id: "",
        account: account,
        cookName: cookname,
        cookTel: cooktel,
        cookPei: cookpei,
        cookHealth: thatData.data.tempcookimg,
      },
      success: function (res) {
        console.log(res.data)
        // thatData.setData({
        //   cooklist: res.data,
        //   isdata: true
        // })
        // wx.navigateTo({
        //   url: "../../kitass/kitass"
        // })
      },
      fail: function (res) {
        wx.showToast({
          title: '服务器错误，提交失败',
          icon: "none",
          duration: 2000
        })
        console.log(res.data)
      }
    })
    this.setData({
      account,
      cookname,
      cooktel,
      cookpei,
      
    })
  },

  imgsrc: function(e){
    cookhealth:e.target.dataset.imgsrc
  },
  
  // account:function(e){
  //   this.setData({
  //     account:e.detail.value
  //   })
  // },
  // setCookname:function(e){
  //   this.setData({
  //     cookname: e.detail.value
  //   })
  // },
  // setCooktel: function (e) {
  //   this.setData({
  //     cooktel: e.detail.value
  //   })
  // },
  // formSubmit:function(e){
  //   this.setData({
  //     cookpei: e.detail.value
  //   })
  // },
  // 图片上传
  gotoshow: function (e) {
    var that = this
    wx.chooseImage({
      count: 1, //选择上传的最大数
      sizeType: ['original', 'compressed'],
      sourceType: ['album', 'camera'],
      success: function (res) {
        const tempFilePaths = res.tempFilePaths;
        console.log(res.tempFilePaths[0])
        wx.showToast({
          title: '正在上传...',
          icon: 'loading',
          mask: true,
          duration: 300
        })
        that.setData({
          cookhealth: res.tempFilePaths[0]
        })
        //上传操作
        wx.uploadFile({
          url: 'http://localhost:8080/upload/uploadpic',
          filePath: tempFilePaths[0],
          name: 'file',
          header: {
            "Content-Type": "multipart/form-data",
            'accept': 'application/json',
          },
          method: "POST",
          success: function (res) {
            const data = res.data;
            
            console.log(res.data)
            that.setData ({
              cookhealth: tempFilePaths[0],
              tempcookimg: res.data
            })
          },
          fail: function () {
            wx.showToast({
              title: '服务器错误，提交失败',
              icon: "none",
              duration: 2000
            })
          }
        })
      }
    })
  }
  
})