package com.inspur.springboot.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.inspur.springboot.model.User;
import com.inspur.springboot.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/framework/demo/user")
public class UserController {

	@Autowired
	UserServiceImpl userService;

	@RequestMapping("/query")
	@ResponseBody
	public Map query(@RequestBody Map<String, Object> parameters) {
		Map<String, Object> userdata = new HashMap<String, Object>();
		List<User> users = userService.findAll(parameters);
		PageInfo<User> userPage = new PageInfo<User>(users);
		List<User> userInfo = userPage.getList();
		long total = userPage.getTotal();
		userdata.put("data", userInfo);

		// int total = users.size();
		userdata.put("total", total);
		return userdata;
	}

	@RequestMapping("/delete/{ids}")
	public String deleteUser(@PathVariable String ids) {
		if (ids != null) {
			String[] idArray = ids.split(",");
			userService.delete(idArray);
		}
		return "redirect:/";
	}

	@RequestMapping("/edit")
	public ModelAndView editPage(@RequestParam(value = "id", required = false) String id) {
		User user = null;
		if (id != null && !"".equals(id)) {
			user = userService.findOne(id);
			if (user != null) {
				user.setArchive(userService.findArchive(id));
			}
		}
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", user);
		return new ModelAndView("userdetailedit", model);
	}

	/**
	 * 新增、修改用户的保存操作
	 * 
	 * @param user
	 * 
	 * @return 用户列表页面路径
	 * 
	 */
	@RequestMapping(value = "/save")
	public String saveUser(User user, @RequestParam(value = "icon", required = false) MultipartFile icon) {
		try {
			if (icon != null) {
				user.getArchive().setIcon(icon.getBytes());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userService.save(user);

		return "redirect:/";
	}
}
