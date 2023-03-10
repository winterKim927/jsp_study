/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.70
 * Generated at: 2023-01-16 12:24:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.news;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import news.util.PagingManager;
import java.util.List;
import news.domain.Comments;
import news.repository.CommentsDAO;
import news.domain.News;
import news.repository.NewsDAO;

public final class content_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

 NewsDAO dao = new NewsDAO();
 CommentsDAO cdao = new CommentsDAO();
 PagingManager pm = new PagingManager(); 
  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/inc/header_link.jsp", Long.valueOf(1673868347091L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("news.domain.News");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("news.util.PagingManager");
    _jspx_imports_classes.add("news.domain.Comments");
    _jspx_imports_classes.add("news.repository.CommentsDAO");
    _jspx_imports_classes.add("news.repository.NewsDAO");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP?????? ?????? GET, POST ?????? HEAD ??????????????? ???????????????. Jasper??? OPTIONS ????????? ?????? ???????????????.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');

int news_idx = Integer.parseInt(request.getParameter("news_idx")); 
dao.updateHit(news_idx);
News news = dao.select(news_idx);
List<Comments> list = cdao.selectAllByFkey(news_idx);
pm.init(list, request);

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css\">\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js\"></script>");
      out.write("\r\n");
      out.write("<title>????????????</title>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("	let showCommentsList = function(result) {\r\n");
      out.write("		let cmList = JSON.parse(result);\r\n");
      out.write("		let innerhtml = \"\";\r\n");
      out.write("		for(let i = 0; i < cmList.length; i++){\r\n");
      out.write("			let cm = cmList[i];\r\n");
      out.write("			innerhtml += \"<tr name='test'>\";\r\n");
      out.write("			innerhtml += \"<td class='col-5' name='gMsg'>\"+cm.msg+\"</td>\";\r\n");
      out.write("			innerhtml += \"<td class='col-1' name='gAuthor'>\"+cm.author+\"</td>\";\r\n");
      out.write("			innerhtml += \"<td class='col-2' name='gWritedate'>\"+cm.writedate.substring(0,19)+\"</td>\";\r\n");
      out.write("			innerhtml += \"<td class='col-1'><button type='button' class='btn btn-danger btn-sm' name='comDel' style='display:none' value='\"+cm.comments_idx+\"' onclick='del(this.value);'>??????</button></td>\";\r\n");
      out.write("			innerhtml += \"</tr>\";\r\n");
      out.write("		}\r\n");
      out.write("		$(\"#commentsList\").html(innerhtml);\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	function addBt(){\r\n");
      out.write("		for(let i=0; i<$(\"tr[name='test']\").length; i++ ){\r\n");
      out.write("			$($(\"tr[name='test']\")[i]).on(\"mouseover\", function() {\r\n");
      out.write("				$($(\"button[name='comDel']\")[i]).show();\r\n");
      out.write("			});\r\n");
      out.write("			\r\n");
      out.write("			$($(\"tr[name='test']\")[i]).on(\"mouseout\", function() {\r\n");
      out.write("				$($(\"button[name='comDel']\")[i]).hide();\r\n");
      out.write("			});\r\n");
      out.write("		}\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	function getComments() {\r\n");
      out.write("		let idx = $(\"input[name='news_idx']\").val();\r\n");
      out.write("		$.ajax({\r\n");
      out.write("			type : \"GET\",\r\n");
      out.write("			url : \"getComments.jsp?news_idx=\" + idx,\r\n");
      out.write("			success : function(result, status, xhr) {\r\n");
      out.write("				showCommentsList(result);\r\n");
      out.write("				addBt();\r\n");
      out.write("			}				\r\n");
      out.write("		});\r\n");
      out.write("		\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	function del(comments_idx) {\r\n");
      out.write("		if(!confirm(\"????????? ????????????????\")) return;\r\n");
      out.write("		$.ajax({\r\n");
      out.write("			type : \"get\",\r\n");
      out.write("			url : \"delete_com.jsp?comments_idx=\"+comments_idx,\r\n");
      out.write("			success : function(result, status, xhr) {\r\n");
      out.write("				getComments();\r\n");
      out.write("			}					\r\n");
      out.write("		});\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write(" 	function registComments() {\r\n");
      out.write(" 		$.ajax({\r\n");
      out.write(" 			type : \"post\",\r\n");
      out.write(" 			url : \"registComments.jsp\",\r\n");
      out.write(" 			data : {\r\n");
      out.write(" 			 	msg : $(\"input[name='msg']\").val(),\r\n");
      out.write(" 				author : $(\"input[name='author']\").val(),\r\n");
      out.write(" 				news_idx : $(\"input[name='news_idx']\").val() \r\n");
      out.write(" 			},\r\n");
      out.write(" 			success : function(result, status, xhr) {\r\n");
      out.write(" 				getComments();\r\n");
      out.write("			}\r\n");
      out.write(" 		});\r\n");
      out.write("	} \r\n");
      out.write("\r\n");
      out.write("	$(function() {\r\n");
      out.write("		getComments();\r\n");
      out.write("		\r\n");
      out.write("		$($(\"button\")[0]).click(function() { //????????????\r\n");
      out.write("			$(\"#form1\").attr({\r\n");
      out.write("				\"action\" : \"/news/update\",\r\n");
      out.write("				\"method\" : \"post\"\r\n");
      out.write("			});\r\n");
      out.write("			$(\"#form1\").submit();\r\n");
      out.write("		});\r\n");
      out.write("		\r\n");
      out.write("		$($(\"button\")[1]).click(function() { //????????????\r\n");
      out.write("			if(confirm(\"???????????? ????????????????\")){\r\n");
      out.write("				$(\"#form1\").attr({\r\n");
      out.write("					\"action\" : \"/news/delete\",\r\n");
      out.write("					\"method\" : \"post\"\r\n");
      out.write("				});\r\n");
      out.write("				$(\"#form1\").submit();\r\n");
      out.write("			}\r\n");
      out.write("		});\r\n");
      out.write("		\r\n");
      out.write("		$($(\"button\")[2]).click(function() { //????????????\r\n");
      out.write("			location.href=\"/news/list.jsp\";\r\n");
      out.write("		});\r\n");
      out.write("		\r\n");
      out.write("		$(\"#form2 button\").click(function() {//??????????????????\r\n");
      out.write("			registComments();\r\n");
      out.write("		});\r\n");
      out.write("	});\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<div class=\"container\">\r\n");
      out.write("		<h2>????????????</h2>\r\n");
      out.write("		<p></p>\r\n");
      out.write("		<form id=\"form1\">\r\n");
      out.write("			<input type=\"hidden\" name=\"news_idx\" value=\"");
      out.print(news.getNews_idx());
      out.write("\">\r\n");
      out.write("			<input type=\"hidden\" name=\"commentsCnt\" value=\"");
      out.print(list.size());
      out.write("\">\r\n");
      out.write("			<div class=\"form-group\">\r\n");
      out.write("				<label for=\"title\">??????</label>\r\n");
      out.write("				<input type=\"text\" class=\"form-control\" id=\"title\" name=\"title\" value=\"");
      out.print(news.getTitle());
      out.write("\">\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"form-group\">\r\n");
      out.write("				<label for=\"writer\">?????????</label>\r\n");
      out.write("				<input type=\"text\" class=\"form-control\" id=\"writer\" name=\"writer\" value=\"");
      out.print(news.getWriter());
      out.write("\" readonly>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"form-group\">\r\n");
      out.write("				<label for=\"content\">??????</label>\r\n");
      out.write("				<textarea class=\"form-control\" rows=\"5\" id=\"content\" name=\"content\">");
      out.print(news.getContent());
      out.write("</textarea>\r\n");
      out.write("			</div>\r\n");
      out.write("			<button type=\"button\" class=\"btn btn-warning\">??????</button>\r\n");
      out.write("			<button type=\"button\" class=\"btn btn-danger\">??????</button>\r\n");
      out.write("			<button type=\"button\" class=\"btn btn-primary\">??????</button>\r\n");
      out.write("		</form>\r\n");
      out.write("		<p>\r\n");
      out.write("		<form id=\"form2\">\r\n");
      out.write("			<input type=\"hidden\" name=\"news_idx2\" value=\"");
      out.print(news.getNews_idx());
      out.write("\">\r\n");
      out.write("				<label for=\"comments\">??????</label>\r\n");
      out.write("			<div class=\"form-group row\">\r\n");
      out.write("				<div class=\"col-md-8\">\r\n");
      out.write("				 	<input type=\"text\" class=\"form-control\" id=\"msg\" name=\"msg\" placeholder=\"?????? ??????\">\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"col-md-3\">\r\n");
      out.write("					<input type=\"text\" class=\"form-control\" id=\"author\" name=\"author\" placeholder=\"????????? ??????\">\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"col-md-1\">\r\n");
      out.write("					<button type=\"button\" class=\"btn btn-warning\">??????</button>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</form>\r\n");
      out.write("		\r\n");
      out.write("			<table class=\"table table-hover\" id=\"table2\">\r\n");
      out.write("			    <thead>\r\n");
      out.write("			      <tr>\r\n");
      out.write("			        <th class=\"col-4\">??????</th>\r\n");
      out.write("			        <th class=\"col-1\">?????????</th>\r\n");
      out.write("			        <th class=\"col-2\">?????????</th>\r\n");
      out.write("			      </tr>\r\n");
      out.write("			    </thead>\r\n");
      out.write("			    <tbody id=\"commentsList\">\r\n");
      out.write("			    </tbody>\r\n");
      out.write("	  		</table>\r\n");
      out.write("  		\r\n");
      out.write("	</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
