/**
 * 文件名：MyController.java
 * 修改人：rongcf
 * 修改时间：2017—06—21
 * 修改内容：添加toIndex方法
 */

package com.rajh.rcf.controller;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Rule;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.rajh.rcf.pojo.User_t;
import com.rajh.rcf.service.User_tMapperService;

import cn.dsna.util.images.ValidateCode;

/**
 * 该类是实现提交表单及列表展示的测试类
 * @author tonytan
 * @since JDK1.8
 * @history 2017-06-21 
 */

@Controller
@RequestMapping("/user")
public class MyController {
	@Resource
	private User_tMapperService user_tMapperService;
	
	private String vo;
	
/**
 * 将id提交返回表中对应的字段
 * @param request
 * @param model
 * @return 
 */
	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request,Model model){
		int userID = Integer.parseInt(request.getParameter("id"));
		User_t user = this.user_tMapperService.getUserById(userID);
		System.out.println("进入了！");
		model.addAttribute("user",user);
		return "showUser";
	}
	
	/**
	 * 主页跳转至注册页面
	 * @return 
	 */
	@RequestMapping("/zhuCe")
	public String toZhuCe(){
		return "zhuce";
	}
	
	
	/**
	 * 注册，将注册信息存入数据库
	 * @param request
	 * @return 
	 */
	@RequestMapping("/register")
	public ModelAndView register(HttpServletRequest request){
		String iva = request.getParameter("ivcode");
		System.out.println(iva);
		String username = request.getParameter("iusername");
		String password = request.getParameter("ipassword");
		int age = Integer.parseInt(request.getParameter("iage"));
		ModelAndView mav = new ModelAndView();
		mav.setViewName("result");
		vo = (String) request.getSession().getAttribute("validatecode");
		System.out.println(vo);
		if(iva.equals(vo)){
			int i = this.user_tMapperService.add(username, password, age);
		if(i==1){
		mav.addObject("result", "恭喜您，注册成功");
		
		}else{
			mav.addObject("result","抱歉,注册失败，稍后请重新注册");
			
		}
		}else{
			mav.addObject("result", "验证码错误，请重新输入验证码");
			
		}
		return mav;
	}
	
	/**
	 * 生成验证码图片并返回前端
	 * @param response
	 * @return 
	 */

	@RequestMapping("/validatecode")
	public void validatecode(HttpServletResponse response,HttpServletRequest request){
		//告诉客户端不使用缓存  
        response.setHeader("param", "no-cache");  
        response.setHeader("cache-control", "no-cache");  
        response.setIntHeader("expires", 0); 
        
		ValidateCode vcode = new ValidateCode(150, 25, 4, 4);
		vo = vcode.getCode();
		System.out.println(vo);
		request.getSession().setAttribute("validatecode", vo);
		try {
			vcode.write(response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
