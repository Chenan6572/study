window.onload = function(){
    var alllis = $("ullis").getElementsByTagName("li"); 
    var allimgs = $("ullis").getElementsByTagName("img");
    var allrounds = $("circle").getElementsByTagName("li");
    //索引
    var loop = 0;
    //定时器
    setInterval(function () {
        loop += 1;
        var index =loop % 4;
        //排他思想 循环 或者闭包
        for(var i=0; i<alllis.length; i++){
            allimgs[i].style.display = "none";       
        }
        //小圆圈
        for(var i=0; i<allrounds.length; i++){
            changestyle(allrounds,"",i);  
        }
        //自己选中
        changestyle(allimgs,"",index);
        changestyle(allrounds,'current',index); 
    },8000);   

    //左方向  
    $("arrow_l").onclick = function () {
        loop -= 1;     
        if(loop<=0){
            loop += 100; //防止出现负数
        }
        index =loop % 4;
        for(var i=0; i<alllis.length; i++){
            allimgs[i].style.display = "none";       
        }
        //小圆圈
        for(var i=0; i<allrounds.length; i++){
            changestyle(allrounds,"",i);   
        }
        changestyle(allimgs,"",index);
        changestyle(allrounds,'current',index);
    }
    //右方向  
    $("arrow_r").onclick = function () {
        loop += 1;     
        index =loop % 4;
        for(var i=0; i<alllis.length; i++){
            allimgs[i].style.display = "none";       
        }
        //小圆圈
        for(var i=0; i<allrounds.length; i++){
            changestyle(allrounds,"",i);   
        }
        changestyle(allimgs,"",index);
        changestyle(allrounds,'current',index);
    }
}
/**
 * 改变样式方法
 * @param {string} listname 数组名称
 * @param {string} className 类名称
 * @param {string} Id 索引
 */
function changestyle(listname,className,Id) {
    listname[Id].className = className;
    listname[Id].style.display = "block"; 
} 

function $(id){
    return typeof id == "string" ? document.getElementById(id) : null;
}