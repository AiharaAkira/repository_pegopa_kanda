/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.32
 * Generated at: 2023-06-28 05:51:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import bean.Account;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("bean.Account");
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

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
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
      response.setContentType("text/html; charset=UTF-8");
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

	String cmd = (String) request.getAttribute("cmd");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>ログイン画面</title>\r\n");
      out.write("\r\n");
      out.write("<header\r\n");
      out.write("\t\t\tstyle=\"width: 900px; display: flex; justify-content: center; align-items: center; margin: 50px auto 0 auto;\">\r\n");
      out.write("\t\t\t<img src=\"https://postfiles.pstatic.net/MjAyMzA2MjdfMjcy/MDAxNjg3ODMxMTk3NzMx.y2U6FThvXwdOi9XToRwE2N4H_hRXqdkBoCeK2m9852Mg.qxG3IdUM9aHf2hR4frt1B7kkSVwn5eb_OthgeJAIE04g.PNG.hyh3700/logo.png?type=w773\" alt=\"logo\" width=\"70\" height=\"70\">\r\n");
      out.write("\t\t\t<h1 style=\"padding-top: 20px; margin-left: 12px; color: hotpink;\">\r\n");
      out.write("\t\t\t\t<span style=\"font-size: 0.8em; color: gray;\">株式会社</span>神田ユニフォーム\r\n");
      out.write("\t\t\t</h1>\r\n");
      out.write("\t\t</header>\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.4.1.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<hr size=\"8\" color=\"LightPink\" width=\"90%\"></hr>\r\n");
      out.write("\t<h2 style=\"padding-top: 20px; text-align: center; color: gray;\">ログイン</h2>\r\n");
      out.write("\r\n");
      out.write("\t<form action=\"");
      out.print(request.getContextPath());
      out.write("/login\" method=\"post\"\r\n");
      out.write("\t\tonsubmit=\"return call();\">\r\n");
      out.write("\r\n");
      out.write("\t\t<p style=\"text-align: center; color: gray; font-weight: 900;\">\r\n");
      out.write("\t\t\tユーザーID：<input id=\"name\" placeholder=\"メールアドレス\"\r\n");
      out.write("\t\t\t\tstyle=\"width: 220px; height: 22px; border-radius: 12px; border: 3px solid pink; outline: none; padding: 2px 4px;\"\r\n");
      out.write("\t\t\t\ttype=\"email\" name=\"name\">\r\n");
      out.write("\t\t</p>\r\n");
      out.write("\t\t<p style=\"text-align: center; color: gray; font-weight: 900;\">\r\n");
      out.write("\t\t\tパスワード：<input id=\"pw\" placeholder=\"パスワードを入力してください。\"\r\n");
      out.write("\t\t\t\tstyle=\"width: 220px; height: 22px; border-radius: 12px; border: 3px solid pink; outline: none; padding: 2px 4px;\"\r\n");
      out.write("\t\t\t\ttype=\"password\" name=\"pw\">\r\n");
      out.write("\t\t</p>\r\n");
      out.write("\t\t<p style=\"text-align: center; color: gray; font-weight: 900;\">\r\n");
      out.write("\t\t\t<input class=\"button\" id=\"l_btn\"\r\n");
      out.write("\t\t\t\tstyle=\"margin-top: 50px; background: none; border-radius: 8px; border: 3px solid pink; padding: 2px 6px; font-weight: 900; color: gray;\"\r\n");
      out.write("\t\t\t\ttype=\"submit\" value=\"ログイン\">\r\n");
      out.write("\t\t</p>\r\n");
      out.write("\r\n");
      out.write("\t\t");

			if (cmd != null) {
		
      out.write("\r\n");
      out.write("\t\t<h4 style=\"text-align: center;\">");
      out.print(request.getAttribute("cmd"));
      out.write("</h4>\r\n");
      out.write("\t\t");

			}
		
      out.write("\r\n");
      out.write("\t</form>\r\n");
      out.write("\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<br>\r\n");
      out.write("\r\n");
      out.write("\t<p align=\"center\">\r\n");
      out.write("\t\t<a style=\"color: gray;\"\r\n");
      out.write("\t\t\thref=\"");
      out.print(request.getContextPath());
      out.write("/accountInsert\">新規会員登録はこちら</a>\r\n");
      out.write("\t</p>\r\n");
      out.write("\t<p align=\"center\">\r\n");
      out.write("\t\t<a style=\"color: grey;\"\r\n");
      out.write("\t\t\thref=\"");
      out.print(request.getContextPath());
      out.write("/uniformList\">会員登録をせずに購入する</a>\r\n");
      out.write("\t</p>\r\n");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\tfunction isEmpty(input) {\r\n");
      out.write("\r\n");
      out.write("\t\t\treturn !input.value;\r\n");
      out.write("\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction lessThan(input, length) {\r\n");
      out.write("\r\n");
      out.write("\t\t\treturn input.value.length < length;\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction moreThan(input, length) {\r\n");
      out.write("\t\t\treturn input.value.length > length;\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction containKr(input) {\r\n");
      out.write("\r\n");
      out.write("\t\t\tlet ok = \"qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890@._/\";\r\n");
      out.write("\r\n");
      out.write("\t\t\tfor (let i = 0; i < input.value.length; i++) {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tif (ok.indexOf(input.value[i]) == -1) {\r\n");
      out.write("\t\t\t\t\treturn true;\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction equalData(input1, input2) {\r\n");
      out.write("\t\t\treturn !(input1.value == input2.value)\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction notContains(input, set) {\r\n");
      out.write("\r\n");
      out.write("\t\t\tfor (let i = 0; i < set.length; i++) {\r\n");
      out.write("\t\t\t\tif (input.value.indexOf(set[i]) != -1)\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction notCheck(input) {\r\n");
      out.write("\t\t\tif (input.checked) {\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction isNotNumber(input) {\r\n");
      out.write("\t\t\treturn isNaN(input.value);\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction isNotType(input, type) {\r\n");
      out.write("\t\t\ttype = \".\" + type; //.jpg\r\n");
      out.write("\r\n");
      out.write("\t\t\treturn input.value.indexOf(type) == -1;\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tvar pattern_spc = /[~!@#$%^&*()_+|<>?:{}]/;\r\n");
      out.write("\r\n");
      out.write("\t\tfunction checkKor(str) {\r\n");
      out.write("\t\t\tconst regExp = /[ㄱ-ㅎㅏ-ㅣ가-힣]/g;\r\n");
      out.write("\t\t\tif (regExp.test(str)) {\r\n");
      out.write("\t\t\t\treturn true;\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction checkNum(str) {\r\n");
      out.write("\t\t\tconst regExp = /[0-9]/g;\r\n");
      out.write("\t\t\tif (regExp.test(str)) {\r\n");
      out.write("\t\t\t\treturn true;\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction checkEng(str) {\r\n");
      out.write("\t\t\tconst regExp = /[a-zA-Z]/g;\r\n");
      out.write("\t\t\tif (regExp.test(str)) {\r\n");
      out.write("\t\t\t\treturn true;\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction checkEngNum(str) {\r\n");
      out.write("\t\t\tconst regExp = /[a-zA-Z0-9]/g;\r\n");
      out.write("\t\t\tif (regExp.test(str)) {\r\n");
      out.write("\t\t\t\treturn true;\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction checkSpace(str) {\r\n");
      out.write("\t\t\tif (str.search(/\\s/) !== -1) {\r\n");
      out.write("\t\t\t\treturn true;\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction equalCheck(input1, input2) {\r\n");
      out.write("\t\t\tif (input1.value != input2.value) {\r\n");
      out.write("\t\t\t\treturn true;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tlet u_id = document.getElementById('name');\r\n");
      out.write("\t\tlet u_pw = document.getElementById('pw');\r\n");
      out.write("\r\n");
      out.write("\t\tfunction call() {\r\n");
      out.write("\r\n");
      out.write("\t\t\tif (isEmpty(u_id)) {\r\n");
      out.write("\t\t\t\talert(\"ユーザーIDを入力してください。\");\r\n");
      out.write("\t\t\t\tu_id.value = \"\";\r\n");
      out.write("\t\t\t\tu_id.focus();\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\tif (isEmpty(u_pw)) {\r\n");
      out.write("\t\t\t\talert(\"パスワードを入力してください。\");\r\n");
      out.write("\t\t\t\tu_pw.value = \"\";\r\n");
      out.write("\t\t\t\tu_pw.focus();\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\tif (cnt == 1) {\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
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
