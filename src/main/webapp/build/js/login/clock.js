define("clock",["jquery"],function($){
    return {
        simpleClock : function(id){
            var today=new Date();
            var year=today.getFullYear();
            var month=today.getMonth()+1;
            var day=today.getDate();
            var hours=today.getHours();
            var minutes=today.getMinutes();
            var seconds=today.getSeconds();
            //如果是单位数字，前面补0
            month=month<10? "0"+month :month;
            day=day<10? "0"+day :day;
            hours=hours<10? "0"+hours :hours;
            minutes=minutes<10? "0"+minutes :minutes;
            seconds=seconds<10? "0"+seconds :seconds;
            //时间信息连成字符串
            var str=year+"年"+month+"月"+day+"日 "+hours+":"+minutes+":"+seconds;
            //获取id=result的内容
            var obj=document.getElementById(id);
            obj.innerHTML=str;
            //延时器
            window.setTimeout("simpleClock()",1000);
        }
    }
});