<%@page pageEncoding="UTF-8" isELIgnored="false"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<script>
    $(function () {
        //点击搜索按钮
        $("#btnId").click(function () {
            //清空表单
            $("#queryTable").empty();
            //添加标题
            $("#queryTable").append("<tr>\n" +
                "            <td>ID</td>\n" +
                "            <td>标题</td>\n" +
                "            <td>简介</td>\n" +
                "            <td>封面</td>\n" +
                "            <td>上传时间</td>\n" +
                "        </tr>");
            //文本框内容
            var content=$("#contentId").val();
            //向后台发送请求 搜索数据
            $.ajax({
                url:"${path}/video/querySearch",
                type:"post",
                dataType:"JSON",
                data:{"content":content},
                success:function (data) {
                    //向表格中填充数据
                    $.each(data,function (index,video) {
                        //获取数据 渲染页面
                        $("#queryTable").append(" <tr>\n" +
                            "            <td>"+video.id+"</td>\n" +
                            "            <td>"+video.title+"</td>\n" +
                            "            <td>"+video.biref+"</td>\n" +
                            "            <td><img style='width: 100px;height: 100px' src='"+video.cover+"'/></td>\n" +
                            "            <td>"+video.publishDate+"</td>\n" +
                            "        </tr>");
                    })
                }
            })
        })
    })
</script>
<!--搜索框-->
<div align="center">
    <div class="input-group" style="width: 300px">
        <input id="contentId" type="text" class="form-control" placeholder="请输入搜索条件" aria-describedby="basic-addon2">
        <span class="input-group-btn" id="basic-addon2">
            <button class="btn btn-success" id="btnId">百度一下</button>
        </span>
    </div>
</div>
<!--展示搜索内容-->
<div class="panel panel-default">
    <!--面板标题-->
    <div class="panel-heading">搜索结果</div>
    <!--搜索内容-->
    <table class="table" id="queryTable">

    </table>
</div>


