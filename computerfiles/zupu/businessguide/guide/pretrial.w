<?xml version="1.0" encoding="utf-8"?>

<div xmlns="http://www.w3.org/1999/xhtml" component="$UI/system/components/justep/window/window" design="device:m;"
  xid="window" class="window">  
  <div component="$UI/system/components/justep/model/model" xid="model1" style="position:absolute;height:auto;left:317px;top:76px;"> 
    <div component="$UI/system/components/justep/data/data" autoLoad="true"
      xid="data1" idColumn="fId"> 
      <column label="主键" name="fId" type="String" xid="xid1"/>  
      <column label="附件" name="fAttachment" type="String" xid="xid2"/>  
      <data xid="default1">[{"fId":"0"}]</data>
    </div> 
  </div>
  <div component="$UI/system/components/justep/model/model" xid="model" style="left:18px;top:83px;height:244px;"></div>  
  <div component="$UI/system/components/justep/panel/panel" class="x-panel x-full"
    xid="panel1"> 
    <div class="x-panel-top" xid="top1"> 
      <div component="$UI/system/components/justep/titleBar/titleBar" title="预审填写"
        style="background-color:rgba(231, 64, 58, 1)" class="x-titlebar"> 
        <div class="x-titlebar-left"> 
          <a component="$UI/system/components/justep/button/button" label=""
            class="btn btn-link btn-only-icon" icon="icon-chevron-left" onClick="{operation:'window.close'}"
            xid="backBtn"> 
            <i class="icon-chevron-left"/>  
            <span/> 
          </a> 
        </div>  
        <div class="x-titlebar-title">预审填写</div>  
        <div class="x-titlebar-right reverse"/> 
      </div> 
    </div>  
    <div class="x-panel-content" xid="content1"> 
      <div class="up_content"> 
        <div class="txt_tips"> 
          <img src="../../img/u41.png"/>  
          <span>申请人信息</span> 
        </div>  
        <div class="inputs clear"> 
          <div class="name_inputs">姓名</div>  
          <input type="text" placeholder="请输入您的姓名" id="names"/> 
        </div>  
        <div class="inputs"> 
          <div class="name_inputs">电话</div>  
          <input type="text" placeholder="请输入您的电话" id="phones"/> 
        </div>  
        <div class="inputs"> 
          <div class="name_inputs">身份证</div>  
          <input type="text" placeholder="请输入您的身份证号" id="idcards"/> 
        </div> 
      </div>  
      <div class="middle_content"> 
        <div class="txt_tips"> 
          <img src="../../img/u44.png"/>  
          <span>申请人资料信息</span> 
        </div>  
        <div class="up_de clear"> 
          <div class="upload_imgs"> 
            <a href=""> 
              <img src="../../img/u16.png" bind-click="message"/> 
            </a> 
          </div>  
          <div class="delete_tips"> 
            <a href=""> 
              <img src="../../img/u48.png"/> 
            </a>  
            <a href=""> 
              <img src="../../img/u47.png" bind-click="btndelete"/> 
            </a> 
          </div> 
        </div> 
      </div>  
      <!-- <div component="$UI/system/components/justep/attachment/attachmentSimple"
        xid="attachmentSimple1" bind-ref="data1.ref('fAttachment')"> 
        <div class="x-attachment" xid="div4"> 
          <div class="x-attachment-content x-card-border" xid="div5"> 
            <div class="x-doc-process" xid="div6"> 
              <div class="progress-bar x-doc-process-bar" role="progressbar"
                style="width:0%;" xid="div7"/>
            </div>  
            <div data-bind="foreach:$attachmentItems" xid="div8"> 
              <div class="x-attachment-cell" xid="div9"> 
                <div class="x-attachment-item x-item-other" id="files" data-bind="click:$model.previewOrRemoveItem.bind($model),style:{backgroundImage:($model.previewPicture.bind($model,$object))()}"
                  xid="div10"> 
                  <a data-bind="visible:$model.$state.get() == 'remove'"
                    class="x-remove-barget" xid="a1"/> 
                </div> 
              </div> 
            </div>  
            <div class="x-attachment-cell" data-bind="visible:$state.get() == 'upload'"
              xid="div11"> 
              <div class="x-attachment-item x-item-upload" data-bind="visible:$state.get() == 'upload'"
                xid="div12"/>
            </div>  
            <div class="x-attachment-cell" data-bind="visible:$state.get() == 'upload' &amp;&amp; $attachmentItems.get().length &gt; 0"
              xid="div13"> 
              <div class="x-attachment-item x-item-remove" data-bind="click:changeState.bind($object,'remove')"
                xid="div14"/>
            </div>  
            <div style="clear:both;" xid="div15"/>
          </div> 
        </div> 
      </div>   -->
      <div class="down_content" bind-click="savebtn"> 
        <span>提交</span> 
      </div> 
    </div> 
  </div> 
</div>
