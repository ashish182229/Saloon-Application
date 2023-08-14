package com.cts.salon.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cts.salon.Dao.AppointmentDao;
import com.cts.salon.Dao.FacilityDao;
import com.cts.salon.Dao.UserDao;
import com.cts.salon.Model.Appointment;
import com.cts.salon.Model.Facility;
import com.cts.salon.Model.User;
import java.util.Date;


@Controller
public class SalonController {

	@Autowired
	private FacilityDao hairDao;
	
	@Autowired
	private UserDao userDao;
	
/*	@Autowired
	private AppointmentDao appoint; */
	
	
	@RequestMapping("/salon")
	public String Salon()
	{
		return "salon";
	}
	
	@RequestMapping("/hair")
	public String Hair(Model model)
	{
		List<Facility> members = hairDao.allservices();
		List<Facility> mem = hairDao.allservicesColor();
		model.addAttribute("style",members);
		model.addAttribute("color",mem);
		return "hair";
	}
	
	@RequestMapping("/checkout")
	public String Hairs(/* @RequestParam(required=false,name="haircut") Integer h, @RequestParam(required=false,name="date") Date d,@RequestParam(required=false,name="haircolor") Integer c,@RequestParam(required=false,name="spa") Integer s, */ Model model)
	{
		List<Facility> members = hairDao.allservicesCheckout();
		List<Facility> mem = hairDao.allservicesColorCheckout();
		List<Facility> mems = hairDao.allservicesSpa();
		model.addAttribute("spas",mems);
		model.addAttribute("style",members);
		model.addAttribute("color",mem);
		
		/* int ha=h.intValue();
		int sp=s.intValue();
		int hc=c.intValue();
		Appointment app= new Appointment();
		app.setAppointment(d);
		app.setPrice(ha+sp+hc);
		appoint.setData(app); */
		
		return "checkout";
	}
	
	
	
	@RequestMapping("/spa")
	public String Spa(Model model)
	{
		List<Facility> mem = hairDao.allservicesSpa();
		model.addAttribute("spas",mem);
		return "spa";
	}
	
	@RequestMapping("/confirmation")
	public String con()
	{
		
		return "confirmation";
		
	}
	
	@RequestMapping(value = "/login")
	public ModelAndView Login(@RequestParam(required=false,name="mail") String email, @RequestParam(required=false,name="pass") String password)
	{
		ModelAndView mv = new ModelAndView();
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		String name = userDao.loginUser(user);
		if (name != null) 
		{
			mv.setViewName("salon");
		}
		
		else
		{
			mv.addObject("ms", "Invalid user id or password...");
			mv.setViewName("login");
		}
		
		return mv;
		
	}
	
	@RequestMapping(value = "/registration")
	public ModelAndView  Registration(@RequestParam(required=false,name="email") String email,
			@RequestParam(required=false,name="password") String password,@RequestParam(required=false,name="lname") String lname,
			@RequestParam(required=false,name="fname") String fname)
	{
		ModelAndView mv = new ModelAndView();
		
		User user = new User();
		user.setFname(fname);
		user.setLname(lname);
		user.setEmail(email);
		user.setPassword(password);
		
		int count =userDao.registerUser(user);
		
		if (count > 0) {
			mv.addObject("msg", "User registration successful.");
		} 
		else {
			mv.addObject("msg", "Error- check the console log.");
		}

		mv.setViewName("registration");

		return mv;
		
	}
	
}
