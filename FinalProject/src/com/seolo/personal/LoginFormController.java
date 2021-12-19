/*==========================
   LoginFormController.java
   - 사용자 정의 컨트롤러
==========================*/

package com.seolo.personal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LoginFormController implements Controller
{

   @Override
   public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
   {
      ModelAndView mav = new ModelAndView();
      
      // 세션 처리-------------------------------------------------------------------------------
      HttpSession session = request.getSession();
      
      if (session.getAttribute("userLogin")!=null)   // 로그인 폼은 로그인 된사람이 접근하면 안 됨
      {
         mav.setViewName("redirect:main.action");
         return mav;
      }
      // 세션 처리-------------------------------------------------------------------------------
      
      int errMsg = 0;
      if (request.getParameter("errMsg") != null)   // 로그인 실패 후 재로그인일 경우 errMsg=1
         errMsg = Integer.parseInt(request.getParameter("errMsg"));
      
      mav.addObject("errMsg", errMsg);

      mav.setViewName("WEB-INF/view/Login.jsp");
      return mav;

   }
}