<%@ page import="java.util.Date" %>
<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/16
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>支付测试</title>
    <link type="text/css" href="css/bootstrap.css" rel="stylesheet"/>
    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="js/bootstrap.js" ></script>
    <script type="text/javascript">
        $(function () {
            //将表单数据传递给controller
            $("#submit").click(function(){
                alert($('#out_trade_no').val());
                $.ajax({
                    url:"/testalipay/pay",
                    type:"post",
                    data:{
                        out_trade_no:$('#out_trade_no').val(),
                        subject:$('#subject').val(),
                        total_amount:$('#total_amount').val()
                    },
                    dataType:"text",
                    success:function(data) {
                        $("#returnForm").append(data);
                    }
                });
            });
        });
    </script>
</head>
<body>
<%--存放返回的表单--%>
<div id="returnForm"></div>

<%
    //生成订单编号
    Object obj=new Date().getTime();
    int in=new Random().nextInt(99999);
    String orderNum=obj.toString()+in;
    request.setAttribute("orderNum",orderNum);
%>

<center style="margin-top: 50px">
    <!-- Button trigger modal -->
    <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
        点击我测试支付
    </button>
</center>


<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">扫码支付测试</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="out_trade_no" class="col-sm-2 control-label">订单编号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="out_trade_no" value="${orderNum}" required readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="subject" class="col-sm-2 control-label">订单名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="subject" value="测试" placeholder="请输入您的订单名称" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="total_amount" class="col-sm-2 control-label">金额(单位：元)</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="total_amount" value="0.01" placeholder="请输入金额">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="submit">提交</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>
