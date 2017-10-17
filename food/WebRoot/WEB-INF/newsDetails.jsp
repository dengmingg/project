<%@page import="com.util.PageSupport"%>
<%@page import="com.entity.News"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="newsService" class="com.serviceImpl.NewsServiceImpl"/>
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
                <div class="newsDetailsTitle">${news.title}</div>
                <div class="newsDetailsDate">${news.publishDate}</div>
                <div class="newsContent">
                    ${news.content}
                </div>
                <div class="pager">
                <a href="NewsDetailsServlet?id=${id-1 }">上一篇</a>&nbsp;&nbsp;
                <a href="NewsDetailsServlet?id=${id+1 }">下一篇</a>
                </div>
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

