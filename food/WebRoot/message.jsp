<%@page import="com.entity.Message"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="messageService" class="com.serviceImpl.MessageServiceImpl"></jsp:useBean>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <link href="css/base.css" rel="stylesheet" />
</head>
<body>
    <div id="page">
        <div id="header">
            <div id="menu">
                <div id="corpTitle">美食前线</div>
                <div id="fastNav">
                    <ul>
                        <li>首页</li>
                        <li>产品展示</li>
                        <li>新闻动态</li>
                        <li>留言板</li>
                        <li>联系我们</li>
                    </ul>
                </div>
                <div class="clear"></div>
            </div>
            <div id="logo"></div>
            <div class="clear"></div>
        </div>
        <div id="main">
            <div id="nav">
                <div class="search">
                    产品搜索
                </div>
                <div class="searchTitle">
                    <table>
                        <tr>
                            <td><input type="text" class="title" /></td>
                            <td><img src="images/go.gif" /></td>
                        </tr>

                    </table>

                </div>
                <div class="category">
                    <ul>
                        <li>精品粤菜</li>
                        <li>麻辣川菜</li>
                        <li>经典湘菜</li>
                        <li>咸香鲁菜</li>
                    </ul>
                </div>
                <div class="onlineService">在线客服</div>
                <hr />
                <a><span class="searchOnline">&nbsp;</span>在线客服一</a>
                <a><span class="searchOnline">&nbsp;</span>在线客服二</a>
                <hr />
                <div class="worktime">
                    <span class="worker-header-img">&nbsp;</span>
                    <span><b>工作时间</b></span>
                </div>
                <div class="serOnline-list-h "><span>周一至周五 ：8:30-17:30</span></div>
                <div class="serOnline-list-h lastData"><span>周六至周日 ：9:00-17:00</span></div>
                <hr />
                <div class="serOnline-contact"><div class="marBL-10"><span class="contact-header-img">&nbsp;</span><span style="font-size:15px;"><b>联系方式</b></span></div><div class="serOnline-list-h"><span>陈经理：13000000000</span></div></div>
                <div class="clear"></div>

            </div>
            <div id="container">
                <span class="title">留言板</span>
                <hr class="solid" />
                <div class="message">
                    <span>发表您的留言:</span>
                    <table class="tbMessage">
                        <tr><td>姓名:</td><td><input type="text" /></td><td><span>*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></td><td>邮箱:</td><td><input type="text" /></td></tr>
                        <tr><td>电话:</td><td><input type="text" /></td><td></td><td></td><td></td></tr>
                        <tr><td>内容:</td><td colspan="4"><textarea></textarea></td></tr>
                    </table>
                    <a href=""><div class="messageButton">提交留言</div></a>
                </div>
                <br/>
                <span class="title">留言：</span>
                <hr />
                <div class="messageList">
                    <table class="tbMessageList">
                    
                    <%
                    	List<Message> list = messageService.getMessageList();
                    		int i = 0;
                    		for(Message message :list){
                    
                     %>
                        <tr>
                            <td class="content"><%=message.getContent()%></td>
                            <td><%=message.getUserName()%></td>
                        </tr>
                        <%
                        i++;
                        }
                         %>
                       
                    </table>
                </div>
                <div class="pager"><a href="">上一页</a><a href="">下一页</a>&nbsp;&nbsp;共1页，当前第1页</div>
            </div>
            <div class="clear"></div>
        </div>
        <div id="footer">
            <p><a>首页|</a><a>关于我们|</a><a>联系我们</a></p>
            <p>@©2016 网站样板-餐饮 版权所有</p>
            <p>技术支持：广州广力 | 手机版 | 管理登录</p>
        </div>
    </div>
</body>
</html>

