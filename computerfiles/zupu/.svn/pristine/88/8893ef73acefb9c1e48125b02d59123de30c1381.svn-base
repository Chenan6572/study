<?xml version="1.0" encoding="utf-8"?>

<div xmlns="http://www.w3.org/1999/xhtml" class="main13" component="$UI/system/components/justep/window/window"
  design="device:m;" xid="window">  
  <div component="$UI/system/components/justep/model/model" xid="model" style="height:auto;top:81px;left:341px;"
    onLoad="modelLoad"> 
    <div component="$UI/system/components/justep/data/data" autoLoad="true"
      xid="newsData" idColumn="fID" onCustomRefresh="productDataCustomRefresh"> 
      <column label="id" name="fID" type="String" xid="xid1"/>  
      <column label="标题" name="fTitle" type="String" xid="xid2"/>  
      <column label="图片" name="fImg" type="String" xid="xid3"/>  
      <column label="摘要" name="fOmit" type="String" xid="xid4"/>  
      <column label="跟帖" name="fPostNumber" type="Integer" xid="xid5"/>  
      <rule xid="rule1"> 
        <col name="fPostNumber" xid="ruleCol1"> 
          <calculate xid="calculate1"> 
            <expr xid="default1" style="display:none">$row.val("fPostNumber")&gt;=10000?$row.val("fPostNumber")+"跟贴":"1小时前";</expr> 
          </calculate> 
        </col> 
      </rule> 
    </div>  
    <div component="$UI/system/components/justep/data/data" autoLoad="true"
      xid="navData" onCustomRefresh="navDataCustomRefresh"/> 
  </div>  
  <div component="$UI/system/components/justep/popOver/popOver" class="x-popOver x-wangyiOver"
    xid="popOver" style="height:100%;" anchor="navMenuTop" direction="right-bottom"
    opacity="0.5"> 
    <div class="x-popOver-overlay" xid="div2"/>  
    <div xid="div4" class="x-full x-popOver-content panel"> 
      <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-icon pull-right"
        icon="icon-ios7-arrow-up" onClick="{operation:'popOver.hide'}" xid="button1"> 
        <i xid="i9" class="text-muted icon-ios7-arrow-up"/> 
      </a>  
      <h5 class="text-muted">切换栏目</h5>  
      <div component="$UI/system/components/bootstrap/row/row" class="row o-nomargin x-navGroup panel-body"
        xid="row2"> 
        <div class="col col-xs-3 " xid="col4"> 
          <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-label active"
            label="头条" xid="button3" target="navContent1" onClick="{operation:'popOver.hide'}"> 
            <i xid="i10"/>  
            <span xid="span18">头条</span> 
          </a> 
        </div>  
        <div class="col col-xs-3" xid="col5"> 
          <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-label"
            label="娱乐" xid="button4" target="navContent2" onClick="{operation:'popOver.hide'}"> 
            <i xid="i11"/>  
            <span xid="span19">娱乐</span> 
          </a> 
        </div>  
        <div class="col col-xs-3" xid="col6"> 
          <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-label"
            label="热点" xid="button6" target="navContent3" onClick="{operation:'popOver.hide'}"> 
            <i xid="i22"/>  
            <span xid="span26">热点</span> 
          </a> 
        </div>  
        <div class="col col-xs-3" xid="col7"> 
          <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-label"
            label="体育" xid="button7" target="navContent4" onClick="{operation:'popOver.hide'}"> 
            <i xid="i23"/>  
            <span xid="span27">体育</span> 
          </a> 
        </div>  
        <div class="col col-xs-3" xid="col5"> 
          <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-label"
            label="昆明" xid="button4" target="navContent5" onClick="{operation:'popOver.hide'}"> 
            <i xid="i11"/>  
            <span xid="span19">昆明</span> 
          </a> 
        </div>  
        <div class="col col-xs-3" xid="col5"> 
          <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-label"
            label="财经" xid="button4" target="navContent6" onClick="{operation:'popOver.hide'}"> 
            <i xid="i11"/>  
            <span xid="span19">财经</span> 
          </a> 
        </div>  
        <div class="col col-xs-3" xid="col5"> 
          <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-label"
            label="科技" xid="button4" target="navContent7" onClick="{operation:'popOver.hide'}"> 
            <i xid="i11"/>  
            <span xid="span19">科技</span> 
          </a> 
        </div>  
        <div class="col col-xs-3" xid="col5"> 
          <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-label"
            label="图片" xid="button4" target="navContent8" onClick="{operation:'popOver.hide'}"> 
            <i xid="i11"/>  
            <span xid="span19">图片</span> 
          </a> 
        </div>  
        <div class="col col-xs-3" xid="col5"> 
          <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-label"
            label="跟帖" xid="button4" target="navContent9" onClick="{operation:'popOver.hide'}"> 
            <i xid="i11"/>  
            <span xid="span19">跟帖</span> 
          </a> 
        </div>  
        <div class="col col-xs-3" xid="col5"> 
          <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-label"
            label="直播" xid="button4" target="" onClick="{operation:'popOver.hide'}"> 
            <i xid="i11"/>  
            <span xid="span19">直播</span> 
          </a> 
        </div>  
        <div class="col col-xs-3" xid="col5"> 
          <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-label"
            label="时尚" xid="button4" target="" onClick="{operation:'popOver.hide'}"> 
            <i xid="i11"/>  
            <span xid="span19">时尚</span> 
          </a> 
        </div>  
        <div class="col col-xs-3" xid="col5"> 
          <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-label o-nopadding"
            label="轻松一刻" xid="button4" target="" onClick="{operation:'popOver.hide'}"> 
            <i xid="i11"/>  
            <span xid="span19">轻松一刻</span> 
          </a> 
        </div>  
        <div class="col col-xs-3" xid="col5"> 
          <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-label"
            label="汽车" xid="button4" target="" onClick="{operation:'popOver.hide'}"> 
            <i xid="i11"/>  
            <span xid="span19">汽车</span> 
          </a> 
        </div>  
        <div class="col col-xs-3" xid="col5"> 
          <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-label"
            label="段子" xid="button4" target="" onClick="{operation:'popOver.hide'}"> 
            <i xid="i11"/>  
            <span xid="span19">段子</span> 
          </a> 
        </div>  
        <div class="col col-xs-3" xid="col5"> 
          <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-label"
            label="军事" xid="button4" target="" onClick="{operation:'popOver.hide'}"> 
            <i xid="i11"/>  
            <span xid="span19">军事</span> 
          </a> 
        </div>  
        <div class="col col-xs-3" xid="col5"> 
          <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-label"
            label="房产" xid="button4" target="" onClick="{operation:'popOver.hide'}"> 
            <i xid="i11"/>  
            <span xid="span19">房产</span> 
          </a> 
        </div> 
      </div>  
      <div xid="div9" class="panel-heading" bind-text="'点击添加更多栏目'"/>  
      <div component="$UI/system/components/bootstrap/row/row" class="row o-nomargin x-navGroup panel-body bg-muted"
        xid="row3"> 
        <div class="col col-xs-3" xid="col9"> 
          <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-label"
            label="NBA" xid="button11" target=""> 
            <i xid="i25"/>  
            <span xid="span31">NBA</span> 
          </a> 
        </div>  
        <div class="col col-xs-3" xid="col8"> 
          <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-label"
            label="社会" xid="button10" target=""> 
            <i xid="i26"/>  
            <span xid="span29">社会</span> 
          </a> 
        </div>  
        <div class="col col-xs-3" xid="col11"> 
          <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-label"
            label="哒哒" xid="button8" target=""> 
            <i xid="i27"/>  
            <span xid="span28">哒哒</span> 
          </a> 
        </div>  
        <div class="col col-xs-3" xid="col10"> 
          <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-label"
            label="影视" xid="button9" target=""> 
            <i xid="i24"/>  
            <span xid="span30">影视</span> 
          </a> 
        </div>  
        <div class="col col-xs-3" xid="col8"> 
          <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-label"
            label="彩票" xid="button10" target=""> 
            <i xid="i26"/>  
            <span xid="span29">彩票</span> 
          </a> 
        </div>  
        <div class="col col-xs-3" xid="col8"> 
          <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-label o-nopadding"
            label="中国足球" xid="button10" target=""> 
            <i xid="i26"/>  
            <span xid="span29">中国足球</span> 
          </a> 
        </div>  
        <div class="col col-xs-3" xid="col8"> 
          <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-label"
            label="CBA" xid="button10" target=""> 
            <i xid="i26"/>  
            <span xid="span29">CBA</span> 
          </a> 
        </div>  
        <div class="col col-xs-3" xid="col8"> 
          <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-label"
            label="跑步" xid="button10" target=""> 
            <i xid="i26"/>  
            <span xid="span29">跑步</span> 
          </a> 
        </div>  
        <div class="col col-xs-3" xid="col8"> 
          <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-label"
            label="手机" xid="button10" target=""> 
            <i xid="i26"/>  
            <span xid="span29">手机</span> 
          </a> 
        </div>  
        <div class="col col-xs-3" xid="col8"> 
          <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-label"
            label="数码" xid="button10" target=""> 
            <i xid="i26"/>  
            <span xid="span29">数码</span> 
          </a> 
        </div>  
        <div class="col col-xs-3" xid="col8"> 
          <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-label o-nopadding"
            label="移动互联" xid="button10" target=""> 
            <i xid="i26"/>  
            <span xid="span29">移动互联</span> 
          </a> 
        </div>  
        <div class="col col-xs-3" xid="col8"> 
          <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-label o-nopadding"
            label="云课堂" xid="button10" target=""> 
            <i xid="i26"/>  
            <span xid="span29">云课堂</span> 
          </a> 
        </div> 
      </div> 
    </div> 
  </div>  
  <div component="$UI/system/components/justep/popOver/popOver" class="x-popOver"
    xid="popOverMore" anchor="titleBar" position="center" style="height:100%;"> 
    <div class="x-popOver-overlay" xid="div13"/>  
    <div class="x-full x-popOver-content panel" xid="div14"> 
      <div xid="div15" class="panel-body"> 
        <div xid="div19" class="col-xs-6 pull-left media"> 
          <h1 xid="h11" class="media-left text-danger"><![CDATA[21]]></h1>  
          <div xid="div27" class="media-body"> 
            <span xid="span14" class="text-danger"><![CDATA[℃]]></span>  
            <p xid="p1" bind-text="'10/22℃'"/> 
          </div> 
        </div>  
        <div xid="div26" class="col-xs-6 pull-left text-right"> 
          <img src="" alt="" xid="image15" bind-attr-src="$model.getImageUrl('./main/img/cloud.png')"
            class="img_cloud"/>  
          <div xid="div28" bind-text="'多云 微风'"/>  
          <div xid="div29" bind-text="'昆明'"/> 
        </div>  
        <div xid="div30" class="col-xs-12 pull-left"> 
          <span xid="span21"><![CDATA[2015/10/14 星期五]]></span>  
          <p xid="p2" bind-text="'PM2.5 24 优'"/> 
        </div> 
      </div>  
      <div component="$UI/system/components/bootstrap/row/row" class="row text-center panel-body o-nomargin o-nopadding"
        xid="row4"> 
       
         
        <div class="col col-xs-4 o-nopadding" xid="col12"> 
          <img src="" alt="" bind-attr-src="$model.getImageUrl('./main/img/more4.png')"
            class="img3" xid="image5"/>  
          <div bind-text="'添加亲人'" xid="div25" class="text-muted h6"/> 
        </div>  
        <div class="col col-xs-4 o-nopadding" xid="col12"> 
          <img src="" alt="" bind-attr-src="$model.getImageUrl('./main/img/more5.png')"
            class="img3" xid="image5"/>  
          <div bind-text="'扫一扫'" xid="div25" class="text-muted h6"/> 
        </div>  
        <div class="col col-xs-4 o-nopadding" xid="col12"> 
          <img src="" alt="" bind-attr-src="$model.getImageUrl('./main/img/more6.png')"
            class="img3" xid="image5"/>  
          <div bind-text="'邀请好友'" xid="div25" class="text-muted h6"/> 
        </div> 
      </div> 
    </div> 
  </div>  
  <div component="$UI/system/components/justep/panel/panel" class="x-panel x-full x-card top-trans"
    xid="panel1"> 
    
    
       <div class="x-panel-top" xid="top1" height="48"> 
              <div component="$UI/system/components/justep/titleBar/titleBar"
                class="x-titlebar" xid="titleBar"> 
                		   <div class="x-titlebar-left" xid="div1"> 
					          <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-icon" style="display:none"
					            label="" xid="backBtn" icon="icon-chevron-left" onClick="{&quot;operation&quot;:&quot;window.close&quot;}"
					            bind-visible="justep.Portal.getPortal()"> 
					            <i xid="i11" class="icon-chevron-left"/>  
					            <span xid="span18"/> 
					          </a> 
					        </div>  
					        <div class="x-titlebar-title" xid="div2">云耕族谱</div>  
					        <div class="x-titlebar-right reverse" xid="div3"/> 
				 </div>				    
            </div>  
            
    
    
    <div class="x-panel-content x-cards" xid="content"> 
      <div component="$UI/system/components/justep/contents/contents" class="x-contents x-full"
        active="0" xid="contents1" wrap="false" swipe="false"> 
        <div class="x-contents-content" xid="newsContent"> 
          <div component="$UI/system/components/justep/panel/panel" class="x-panel x-full x-has-iosstatusbar"
            xid="panel7"> 
            
         
            
            <div class="x-panel-content" xid="content1"> 
              <div component="$UI/system/components/justep/panel/panel" class="x-panel x-full"
                xid="panel2"> 
                <div class="x-panel-content" xid="content2"> 
                  <div component="$UI/system/components/justep/contents/contents"
                    class="x-contents x-full" active="0" xid="navContents" wrap="false"> 
                    <div class="x-contents-content" xid="navContent1" bind-touchmove="navContent1Touchmove"
                      bind-touchstart="navContent1Touchstart"> 
                      <div class="list-group-item x-seach" xid="div16"> 
                        <input component="$UI/system/components/justep/input/input"
                          class="form-control x-inputText" xid="keyInput"/>  
                        <span class="glyphicon glyphicon-search form-control-feedback"
                          aria-hidden="true" xid="span34"/> 
                      </div>  
                      <div component="$UI/system/components/bootstrap/carousel/carousel"
                        class="x-carousel carousel x-banner" xid="carousel1"> 
                        <ol class="carousel-indicators" xid="ol1"/>  
                        <div class="x-contents carousel-inner" role="listbox"
                          component="$UI/system/components/justep/contents/contents"
                          active="0" slidable="true" wrap="true" swipe="true" xid="bannerContents"> 
                          
                          <div class="x-contents-content" xid="banner2"> 
                            <img alt="" xid="image2" id="image2" class="image-wall img1"
                              bind-attr-src="$model.getImageUrl('./main/img/2.jpg')"/>  
                            <div class="x-title" xid="div10"> 
                              <img alt="" class="img_small" xid="image8" bind-attr-src="$model.getImageUrl('./main/img/icon5.png')"/>  
                              <span xid="span22">马上点击屏幕右上角添加亲人吧</span> 
                            </div> 
                          </div>  
                          <div class="x-contents-content" xid="banner3"> 
                            <img alt="" xid="image13" id="image13" class="image-wall img1"
                              bind-attr-src="$model.getImageUrl('./main/img/3.jpg')"/>  
                            <div class="x-title" xid="div11"> 
                              <img alt="" class="img_small" xid="image9" bind-attr-src="$model.getImageUrl('./main/img/icon1.png')"/>  
                              <span xid="span23">添加亲人有积分奖励啊</span> 
                            </div> 
                          </div>  
                          <div class="x-contents-content" xid="banner4"> 
                            <img alt="" xid="image14" id="image14" class="image-wall img1"
                              bind-attr-src="$model.getImageUrl('./main/img/4.jpg')"/>  
                            <div class="x-title" xid="div12"> 
                              <img alt="" class="img_small" xid="image10" bind-attr-src="$model.getImageUrl('./main/img/icon1.png')"/>  
                              <span xid="span24">张东创建了家族树</span> 
                            </div> 
                          </div> 
                        </div> 
                      </div>  
                      <div class="panel panel-default x-card x-wangyi" component="$UI/system/components/bootstrap/panel/panel"
                        xid="panel5"> 
                        
                          
                          		  
			                          <ul class="x-list-template" xid="listTemplateUl1"
			                            bind-click="detailClick"> 
			                            <li xid="li1" class="list-group-item x-flex"> 
			                              <div xid="div8" class="media-left"> 
			                                <a xid="a1"> 
			                                  <img alt="" xid="image4" class="img-responsive img_new"
			                                    src="$UI/zupu/img/head.png" style="width:72px;"/> 
			                                </a> 
			                              </div>  
			                              <div class="x-flex1" xid="col26"> 
			                                <h5 class="o-nomargintop">刘小奇</h5>  
			                                <span style="text-align: justify;"
			                                  class="text-muted" xid="span38">  音容宛在 丰碑永存！深切缅怀敬爱的周总理..</span>
			                                <span class="pull-right"
			                                  xid="span39">5分钟前</span> 
			                              </div> 
			                            </li> 
			                            <li xid="li1" class="list-group-item x-flex"> 
			                              <div xid="div8" class="media-left"> 
			                                <a xid="a1"> 
			                                  <img alt="" xid="image4" class="img-responsive img_new"
			                                    src="$UI/zupu/img/head.png" style="width:72px;"/> 
			                                </a> 
			                              </div>  
			                              <div class="x-flex1" xid="col26"> 
			                                <h5 class="o-nomargintop">刘小奇</h5>  
			                                <span style="text-align: justify;"
			                                  class="text-muted" xid="span38">  音容宛在 丰碑永存！深切缅怀敬爱的周总理..</span>
			                                <span class="pull-right"
			                                  xid="span39">5分钟前</span> 
			                              </div> 
			                            </li>
			                            <li xid="li1" class="list-group-item x-flex"> 
			                              <div xid="div8" class="media-left"> 
			                                <a xid="a1"> 
			                                  <img alt="" xid="image4" class="img-responsive img_new"
			                                    src="$UI/zupu/img/head.png" style="width:72px;"/> 
			                                </a> 
			                              </div>  
			                              <div class="x-flex1" xid="col26"> 
			                                <h5 class="o-nomargintop">刘小奇</h5>  
			                                <span style="text-align: justify;"
			                                  class="text-muted" xid="span38">  音容宛在 丰碑永存！深切缅怀敬爱的周总理..</span>
			                                <span class="pull-right"
			                                  xid="span39">5分钟前</span> 
			                              </div> 
			                            </li>			                            
			                          </ul> 
                       	  
                        
                        
                         <div component="$UI/system/components/justep/list/list"
                          class="x-list" data="newsData" limit="3" xid="list2"> 
			                          <ul class="x-list-template" xid="listTemplateUl1"
			                            bind-click="detailClick"> 
			                            <li xid="li1" class="list-group-item x-flex"> 
			                              <div xid="div8" class="media-left"> 
			                                <a xid="a1"> 
			                                  <img alt="" xid="image4" class="img-responsive img_new"
			                                    src="$UI/zupu/img/head.png" style="width:72px;"/> 
			                                </a> 
			                              </div>  
			                              <div class="x-flex1" xid="col26"> 
			                                <h5 bind-text="ref('fTitle')" class="o-nomargintop"/>  
			                                <span style="text-align: justify;" bind-text="ref('fOmit')"
			                                  class="text-muted" xid="span38"/>  
			                                <span bind-text="ref('fPostNumber')" class="pull-right"
			                                  xid="span39"/> 
			                              </div> 
			                            </li> 
			                          </ul> 
                       	 </div>  
                        
                        
                        <div xid="div18" style="display:none"> 
                          <h5 class="panel-heading">广州女子为追回爱犬贼轧双腿
                            <span xid="span12" class="pull-right text-muted">16071跟帖</span> 
                          </h5>  
                          <div component="$UI/system/components/bootstrap/row/row"
                            class="row o-nomargin panel" xid="row1"> 
                            <div class="col col-xs-4" xid="col1"> 
                              <img src="" alt="" xid="image6" class="img-responsive"
                                bind-attr-src="$model.getImageUrl('./main/img/a3.jpg')"/> 
                            </div>  
                            <div class="col col-xs-4" xid="col2"> 
                              <img src="" alt="" xid="image7" class="img-responsive"
                                bind-attr-src="$model.getImageUrl('./main/img/a4.jpg')"/> 
                            </div>  
                            <div class="col col-xs-4" xid="col3"> 
                              <img src="" alt="" xid="image11" class="img-responsive"
                                bind-attr-src="$model.getImageUrl('./main/img/a5.jpg')"/> 
                            </div> 
                          </div> 
                        </div>  
                        
                        
                        <div component="$UI/system/components/justep/list/list"
                          class="x-list" data="newsData" limit="3" xid="list2"> 
			                          <ul class="x-list-template" xid="listTemplateUl1"
			                            bind-click="detailClick"> 
			                            <li xid="li1" class="list-group-item x-flex"> 
			                              <div xid="div8" class="media-left"> 
			                                <a xid="a1"> 
			                                  <img alt="" xid="image4" class="img-responsive img_new"
			                                    src="$UI/zupu/img/head.png" style="width:72px;"/> 
			                                </a> 
			                              </div>  
			                              <div class="x-flex1" xid="col26"> 
			                                <h5 bind-text="ref('fTitle')" class="o-nomargintop"/>  
			                                <span style="text-align: justify;" bind-text="ref('fOmit')"
			                                  class="text-muted" xid="span38"/>  
			                                <span bind-text="ref('fPostNumber')" class="pull-right"
			                                  xid="span39"/> 
			                              </div> 
			                            </li> 
			                          </ul> 
                       	 </div> 
                      </div> 
                    </div>  
                    
                    
                    <div class="x-contents-content" xid="navContent2"> 
                      <div component="$UI/system/components/justep/windowContainer/windowContainer"
                        class="x-window-container" xid="navContainer2" style="height:100%;width:100%;"
                        autoLoad="true"/> 
                    </div>  
                    <div class="x-contents-content" xid="navContent3"> 
                      <div component="$UI/system/components/justep/windowContainer/windowContainer"
                        class="x-window-container" xid="navContainer3" style="height:100%;width:100%;"
                        autoLoad="true"/> 
                    </div>  
                    <div class="x-contents-content" xid="navContent4"> 
                      <div component="$UI/system/components/justep/windowContainer/windowContainer"
                        class="x-window-container" xid="navContainer4" style="height:100%;width:100%;"
                        autoLoad="true"/> 
                    </div>  
                    <div class="x-contents-content" xid="navContent5"> 
                      <div component="$UI/system/components/justep/windowContainer/windowContainer"
                        class="x-window-container" xid="navContainer5" style="height:100%;width:100%;"
                        autoLoad="true"/> 
                    </div>  
                    <div class="x-contents-content" xid="navContent6"> 
                      <div component="$UI/system/components/justep/windowContainer/windowContainer"
                        class="x-window-container" xid="navContainer6" style="height:100%;width:100%;"
                        autoLoad="true"/> 
                    </div>  
                    <div class="x-contents-content" xid="navContent7"> 
                      <div component="$UI/system/components/justep/windowContainer/windowContainer"
                        class="x-window-container" xid="navContainer7" style="height:100%;width:100%;"
                        autoLoad="true"/> 
                    </div>  
                    <div class="x-contents-content" xid="navContent8"> 
                      <div component="$UI/system/components/justep/windowContainer/windowContainer"
                        class="x-window-container" xid="navContainer8" style="height:100%;width:100%;"
                        autoLoad="true"/> 
                    </div>  
                    <div class="x-contents-content" xid="navContent9"> 
                      <div component="$UI/system/components/justep/windowContainer/windowContainer"
                        class="x-window-container" xid="navContainer9" style="height:100%;width:100%;"
                        autoLoad="true"/> 
                    </div> 
                  </div> 
                </div> 
              </div> 
            </div> 
          </div> 
        </div>  
        <div class="x-contents-content" xid="readContent"> 
        	
				<style type="text/css">
					    body{margin:20px auto; padding:0; width:1000px }
					    canvas{border:dashed 2px #ccc}
					    span{font-size:16px; cursor:pointer}
					</style>
					<script type="text/javascript">
					    function $$(id){
					        return document.getElementById(id);					        
					    }
					    					    
					    $("#test").html("初始化");
					     
					 
					    function drawRect(co){
					        var can = $$('can');
					        cans = can.getContext('2d');
					        cans.strokeStyle = co;
					        cans.lineWidth = 3;
					        cans.strokeRect(100,50,80,40);
					    }
					    function drawCircle(co){
					        cans.beginPath();
					        cans.arc(30,30,30,0,Math.PI*2,1);
					        cans.closePath();
					        cans.strokeStyle = co;
					        cans.lineWidth = 3;
					        cans.stroke();
					    }
					    function mv_click(){
					        var can = $$('can');
					        var cans = can.getContext('2d');
					        cans.clearRect(-200, -200, 800, 800);
					        cans.translate(10,10);
					        //drawRect('black');
					    }
					    function zoom_click(){
					        var can = $$('can');
					        var cans = can.getContext('2d');
					        drawCircle('red');
					        cans.scale(1.1,1.1);
					        drawCircle('green');
					    }
					    function rotate_click(){
					        var can = $$('can');
					        var cans = can.getContext('2d');
					        cans.rotate(Math.PI*2/360*45);
					        drawRect('green');
					        cans.rotate(-Math.PI/4);
					        drawRect('black');
					    }
					    
					    drawCircle('red');
					    
					    function abc()
					    {	
					    	$("#test").html($model.transURL('../img'));
					    	var can = $$('can');
					    	cans = can.getContext('2d');					    	 
					    	//cans.scale(1.1,1.1);
					    	cans.translate(10,10);					    	
					    	
					    	//cans.fillStyle = 'red';
					    	cans.clearRect(-100, -100, 800, 800);
						    //cans.rect(50, 100, 200, 100);
						    //cxt.stroke();
						    cans.fill();
						    
						    
						    cans.fillRect(0,0,22,22);
						    var img = new Image();
							img.src = "http://localhost:8080/x5/UI2/v_eb3e398a146e4c548e9bcc610a89699dl_zh_CNs_d_m/zupu/main/img/menu1.png";
							cans.drawImage(img,10,10); 
					    }
					</script>

			   <canvas id="can" width="500" height="800"></canvas>
            <br/>             
			<span id="test"></span>
		
        <a component="$UI/system/components/justep/button/button" class="btn btn-default" label="显示族谱" xid="button2" onClick="showFamily">
   <i xid="i1"></i>
   <span xid="span1">显示族谱</span></a></div>  
        <div class="x-contents-content" xid="foundContent"> 
        
        		 <div component="$UI/system/components/justep/windowContainer/windowContainer"
            class="x-window-container" xid="foundContainer" autoLoad="true">
          	
          	 <ul xid="ul1" class="list-group">
				          <li class="list-group-item" xid="li1"> 
				            <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-icon pull-right"
				              label="button" xid="button12" icon="icon-ios7-arrow-right"> 
				              <i xid="i18" class="icon-ios7-arrow-right text-muted"/>  
				              <span xid="span17"/>
				            </a>  
				            <span xid="span16"><![CDATA[添加亲人]]></span>
				          </li>  
				          <li class="list-group-item" xid="li1"> 
				            <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-icon pull-right"
				              label="button" xid="button14" icon="icon-ios7-arrow-right"> 
				              <i xid="i27" class="icon-ios7-arrow-right text-muted"/>  
				              <span xid="span20"/>
				            </a>  
				            <span xid="span19"><![CDATA[扫一扫]]></span>
				          </li>  
				          <li class="list-group-item" xid="li1"> 
				            <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-icon pull-right"
				              label="button" xid="button16" icon="icon-ios7-arrow-right"> 
				              <i xid="i29" class="icon-ios7-arrow-right text-muted"/>  
				              <span xid="span23"/>
				            </a>  
				            <span xid="span22"><![CDATA[邀请好友]]></span>
				          </li>
				    </ul> 
          
          </div> 
        </div>  
        <div class="x-contents-content" xid="userContent"> 
        
       		 <div component="$UI/system/components/justep/windowContainer/windowContainer"
            class="x-window-container" xid="userContainer" autoLoad="true"/> 
            
           <div component="$UI/system/components/justep/panel/panel" class="panel panel-default x-card" xid="panel3"> 
				  <ul xid="ul1" class="list-group">
				          <li class="list-group-item" xid="li1"> 
				            <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-icon pull-right"
				              label="button" xid="button12" icon="icon-ios7-arrow-right"> 
				              <i xid="i18" class="icon-ios7-arrow-right text-muted"/>  
				              <span xid="span17"/>
				            </a>  
				            <span xid="span16"><![CDATA[照片 ]]></span>
				          </li>  
				          <li class="list-group-item" xid="li1"> 
				            <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-icon pull-right"
				              label="button" xid="button14" icon="icon-ios7-arrow-right"> 
				              <i xid="i27" class="icon-ios7-arrow-right text-muted"/>  
				              <span xid="span20"/>
				            </a>  
				            <span xid="span19"><![CDATA[姓名]]></span>
				          </li>  
				          <li class="list-group-item" xid="li1"> 
				            <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-icon pull-right"
				              label="button" xid="button16" icon="icon-ios7-arrow-right"> 
				              <i xid="i29" class="icon-ios7-arrow-right text-muted"/>  
				              <span xid="span23"/>
				            </a>  
				            <span xid="span22"><![CDATA[昵称]]></span>
				          </li> 
				        <li class="list-group-item" xid="li4"> 
				  <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-icon pull-right" xid="button2" icon="icon-ios7-arrow-right">
				   <i xid="i1" class="icon-ios7-arrow-right"></i>
				   <span xid="span1"></span></a>
				  <span xid="span2"><![CDATA[个人详细]]></span></li></ul> 
	       </div>
  
		  	 <div component="$UI/system/components/justep/panel/panel" class="panel panel-default x-card"
		        xid="panel4"> 
		        <div class="list-group-item" xid="div10"> 
		          
		          <span xid="span25"><![CDATA[个人资料设置]]></span>
		        </div> 
		      </div>
		      <div component="$UI/system/components/justep/panel/panel" class="panel panel-default x-card"
		        xid="panel2"> 
		        <div class="list-group-item" xid="div1" align="center"> 
		          <span xid="quit"><![CDATA[退出]]></span>
		        </div> 
		      </div>
  
  
  
        </div> 
      </div> 
    </div>  
    <div class="x-panel-bottom" xid="bottom1"> 
      <div component="$UI/system/components/justep/button/buttonGroup" class="btn-group btn-group-justified x-card x-wangyi"
        tabbed="true" xid="buttonGroup1"> 
        <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-icon-top active"
          label="首页" xid="newsBtn" icon="icon-android-note" target="newsContent"> 
          <i xid="i4" class="icon icon-android-note"/>  
          <span xid="span6">首页</span> 
        </a>  
        <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-icon-top"
          label="族谱" xid="readBtn" icon="icon-ios7-bookmarks-outline" target="readContent"> 
          <i xid="i3" class="icon icon-ios7-bookmarks-outline"/>  
          <span xid="span5">族谱</span> 
        </a>  
        <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-icon-top"
          label="发现" xid="foundBtn" icon="icon-android-locate" target="foundContent"> 
          <i xid="i3" class="icon icon-android-locate"/>  
          <span xid="span4">发现</span> 
        </a>  
        <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-icon-top"
          label="我的" xid="userBtn" icon="icon-ios7-contact-outline" target="userContent"> 
          <i xid="i6" class="icon icon-ios7-contact-outline"/>  
          <span xid="span71">我的</span> 
        </a> 
      </div> 
    </div> 
  </div> 
<div component="$UI/system/components/justep/model/model" xid="model1" style="position:absolute;top:69px;left:606px;width:77px;height:79px;"></div></div>