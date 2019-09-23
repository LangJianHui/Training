<%--
  Created by IntelliJ IDEA.
  User: MrLang
  Date: 2019/9/21
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户录入</title>
    <%@include file="../../common/header.jsp"%>
    <%@include file="../../common/datatable.jsp"%>
</head>
<body>
<div class="main-content">
    <form id="form-user-add" class="form-horizontal">
        <input name="deptId" type="hidden" id="treeId"/>
        <h4 class="form-header h4">基本信息</h4>
        <div class="row">
            <div class="col-sm-6">
                <div class="form-group">
                    <label class="col-sm-4 control-label"><span style="color: red; ">*</span>用户名称：</label>
                    <div class="col-sm-8">
                        <input name="userName" placeholder="请输入用户名称" class="form-control" type="text" maxlength="30" required>
                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="form-group">
                    <label class="col-sm-4 control-label"><span style="color: red; ">*</span>归属部门：</label>
                    <div class="col-sm-8">
                        <div class="input-group">
                            <input name="deptName" onclick="selectDeptTree()" id="treeName" type="text" placeholder="请选择归属部门" class="form-control" required>
                            <span class="input-group-addon"><i class="fa fa-search"></i></span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-6">
                <div class="form-group">
                    <label class="col-sm-4 control-label"><span style="color: red; ">*</span>手机号码：</label>
                    <div class="col-sm-8">
                        <input name="phonenumber" placeholder="请输入手机号码" class="form-control" type="text" maxlength="11" required>
                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="form-group">
                    <label class="col-sm-4 control-label"><span style="color: red; ">*</span>邮箱：</label>
                    <div class="col-sm-8">
                        <input name="email" class="form-control email" type="text" maxlength="50" placeholder="请输入邮箱" required>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-6">
                <div class="form-group">
                    <label class="col-sm-4 control-label"><span style="color: red; ">*</span>登录账号：</label>
                    <div class="col-sm-8">
                        <input name="loginName" placeholder="请输入登录账号" class="form-control" type="text" maxlength="30" required>
                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="form-group">
                    <label class="col-sm-4 control-label"><span style="color: red; ">*</span>登录密码：</label>
                    <div class="col-sm-8">
                        <input name="password" placeholder="请输入登录密码" class="form-control" type="password"required>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-6">
                <div class="form-group">
                    <label class="col-sm-4 control-label">用户性别：</label>
                    <div class="col-sm-8">
                        <select name="sex" class="form-control m-b" >
                            <option ></option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="form-group">
                    <label class="col-sm-4 control-label">用户状态：</label>
                    <div class="col-sm-8">
                        <label class="toggle-switch switch-solid">
                            <input type="checkbox" id="status" checked>
                            <span></span>
                        </label>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-12">
                <div class="form-group">
                    <label class="col-xs-2 control-label">岗位：</label>
                    <div class="col-xs-4">
                        <select id="post" class="form-control select2-multiple" multiple>
                            <option ></option>
                        </select>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-12">
                <div class="form-group">
                    <label class="col-xs-2 control-label">角色：</label>
                    <div class="col-xs-10">
                        <label class="check-box">
                            <input name="role" type="checkbox" >
                        </label>
                    </div>
                </div>
            </div>
        </div>
        <h4 class="form-header h4">其他信息</h4>
        <div class="row">
            <div class="col-sm-12">
                <div class="form-group">
                    <label class="col-xs-2 control-label">备注：</label>
                    <div class="col-xs-10">
                        <textarea name="remark" maxlength="500" class="form-control" rows="3"></textarea>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>

<div class="row">
    <div class="col-sm-offset-5 col-sm-10">
        <button type="button" class="btn btn-sm btn-primary" onclick="submitHandler()"><i class="fa fa-check"></i>保 存</button>&nbsp;
        <button type="button" class="btn btn-sm btn-danger" onclick="closeItem()"><i class="fa fa-reply-all"></i>关 闭 </button>
    </div>
</div>
</body>
</html>
