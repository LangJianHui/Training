<%--
  Created by IntelliJ IDEA.
  User: MrLang
  Date: 2019/9/21
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理</title>
    <%@include file="../../common/header.jsp"%>
    <%@include file="../../common/datatable.jsp"%>
</head>
<body style="background: white">

<a href="add.jsp">add</a>

<table id="example" class="display" style="width:100%">
    <thead>
    <tr>
        <th>编号</th>
        <th>部门</th>
        <th>名字</th>
        <th>邮箱</th>
        <th>电话</th>
        <th>性别</th>
        <th>操作</th>
    </tr>
    </thead>
</table>

<script>
    $(document).ready(function() {
        var table = $('#example').DataTable(
            {
                //开启服务器端数据处理
                serverSide:true,
                ajax:{
                    url:"../../user.action",
                    type:"post",
                  /*  "data": function (d) {
                        /!*var searchParams= {

                        };
                        //附加查询参数
                        if(searchParams){
                            $.extend(d,searchParams); //给d扩展参数
                        }*!/
                    },*/
                    "dataType" : "json"
                },
                "searching" : false,//关闭自动搜索
                //给table内自定义按钮
                "columnDefs": [
                    {
                        // targets用于指定操作的列，从第0列开始，-1为最后一列，这里第六列
                        // return后边是我们希望在指定列填入的按钮代码
                        "targets": -1,
                        "render": function ( data, type, row, meta ) {
                            var html=$("#template").html();
                            return html;
                        }
                    }
                ],
                "columns": [
                    { "data": "user_id" },
                    { "data": "dept_id" },
                    { "data": "user_name" },
                    { "data": "email" },
                    { "data": "phonenumber" },
                    { "data": "sex" },
                    { "data": null }
                ]
            }
        );



        $('#example tbody').on( 'click', 'tr', function () {
            $(this).toggleClass('selected');
        } );

       /* $('#button').click( function () {
            alert( table.rows('.selected').data().length +' row(s) selected' );
        } );*/

        $('#example tbody').on( 'click', '.view', function () {
            //alert($(this).parents('tr') .html());
            var data = table.row( $(this).parents('tr') ).data();
             alert( data["user_id"] );
            // var data= table.rows('.selected').data();
            //alert(data[0]["user_id"]);
        } );
    } );
</script>
<script type="text/html" id="template">
    <div class="hidden-sm hidden-xs action-buttons">
    <a class="view blue" href="#">
        <i class="ace-icon fa fa-search-plus bigger-130"></i>
    </a>

    <a class="green" href="#">
        <i class="ace-icon fa fa-pencil bigger-130"></i>
    </a>

    <a class="red" href="#">
        <i class="ace-icon fa fa-trash-o bigger-130"></i>
    </a>
</div>
</script>
</body>
</html>
