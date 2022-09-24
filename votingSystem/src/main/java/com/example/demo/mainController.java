package com.example.demo;

import java.io.Serial;
import java.sql.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.MvcNamespaceHandler;

@RestController
public class mainController {
	/*
	 * 
	 * user controller
	 * 
	 * 
	 * 
	 */
	@Autowired
	UserService userservice;
	@Autowired
	AdminService adminservice;
	@Autowired
	PartyService partyservice;
	@Autowired
	VoteService voteservice;

	@PostMapping("adduser")
	public String save1(@RequestBody User u) {
		userservice.save(u);
		return "save";
	}

	@RequestMapping("/addUser")
	public ModelAndView save(@RequestParam int uid, String fname, String lname, long mno, String address, Date dob) {
		ModelAndView mv = new ModelAndView("login");
		User u = new User();
		u.setUid(uid);
		u.setFname(fname);
		u.setLname(lname);
		u.setMno(mno);
		u.setAddress(address);
		u.setDob(dob);
		userservice.save(u);
		return mv;

	}

	@GetMapping("/userall")
	public ModelAndView ls1() {
		System.out.println("get all...");

		List<User> ls = userservice.listall();
		ModelAndView mv = new ModelAndView("userall");
		mv.addObject("ls", ls);

		return mv;
	}

	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");

		return mv;

	}

	@GetMapping("/finduser")
	public ModelAndView find(@RequestParam int uid) {
		ModelAndView mv = new ModelAndView("userDashboard");
		int a = userservice.findUser(uid);
		List<Party> ls = partyservice.listall();
		mv.addObject("uid", uid);
		mv.addObject("partys", ls);
		System.out.println(a + "found");
//		int b = voteservice.votedorno(uid);
//		System.out.println(b);
//		if (b != 0) {
//			ModelAndView mv1 = new ModelAndView("voted");
//			return mv1;
//		}
		if (a == uid) {
			return mv;
		}
		return null;
	}

	@RequestMapping(value = "/deleteuser", method = RequestMethod.GET)
	public ModelAndView deleteuser(@RequestParam int uid) {
		ModelAndView mv = new ModelAndView("adminDashboard");
		userservice.deleteuser(uid);
		System.out.println("deleted");
		return mv;
	}

	@GetMapping("/newuser")
	public ModelAndView newuserpage() {
		ModelAndView mv = new ModelAndView("newuser");

		return mv;
	}
	/*
	 * 
	 * 
	 * vote controller
	 * 
	 * 
	 */

	@PostMapping("/vote")
	public void save(@RequestBody Vote vote) {
		System.out.println("save...");

		voteservice.save(vote);

	}

	@GetMapping("/voteAll")
	public List<Vote> ls() {
		System.out.println("get all...");

		return voteservice.listall();
	}

	@GetMapping("/countvote")
	public ModelAndView countvots() {
		ModelAndView mv = new ModelAndView("votecount");
		List<Party> partylist = partyservice.listall();
		Iterator<Party> itr = partylist.iterator();
		List<Integer> countedvotes = new LinkedList<>();
		while (itr.hasNext()) {
			countedvotes.add(voteservice.count(itr.next().getPartyname()));
		}
		mv.addObject("counts", countedvotes);
		mv.addObject("partylist", partylist);

		return mv;
	}

	@GetMapping("/voteto")
	public ModelAndView voteto(@RequestParam String partyname, int uid) {
		ModelAndView mv = new ModelAndView("login");
		Vote vote = new Vote();
//		 List<User> listUser=userservice.repo.findUserObject(uid);
//		System.out.println(listUser);
		User user = new User();
		user.setUid(uid);
		Party p = new Party();
		p.setPartyname(partyname);
		vote.setParty(p);
		vote.setUser(user);
		voteservice.save(vote);
		return mv;
	}
	/*
	 * 
	 * 
	 * 
	 * 
	 * admin controller
	 * 
	 * 
	 * 
	 */

	@PostMapping("/admin")
	public void save(@RequestBody Admin admin) {
		System.out.println("save...");

		adminservice.save(admin);

	}

	@GetMapping("/adminall")
	public ModelAndView ls2() {
		System.out.println("get all...");

		List<Admin> ls = adminservice.listall();
//		 Iterator<Admin> itr=ls.iterator();
//		 for (Admin admin : ls) {
//			System.out.println(admin.getAid());
//		}
		ModelAndView mv = new ModelAndView("adminall");
		mv.addObject("ls", ls);

		return mv;
	}

	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("findAdmin")
	public ModelAndView findAdmin(@RequestParam String name, String password) {
		int a = adminservice.findAdmin(name, password);
		ModelAndView mv = new ModelAndView("adminDashboard");
		if (a == 1) {
			return mv;
		} else {
			ModelAndView mv1 = new ModelAndView("login.jsp");
			return mv1;
		}
	}
	/*
	 *
	 * party controller
	 *
	 * 
	 */

	@RequestMapping("/addparty")
	public ModelAndView save11(@RequestParam String partyname) {
		System.out.println("save...");
		Party p = new Party();
		p.setPartyname(partyname);
		ModelAndView mv = new ModelAndView("adminDashboard");
		partyservice.save(p);
		return mv;
	}

	@GetMapping("/partyall")
	public ModelAndView ls4() {

		List<Party> ls = partyservice.listall();
		System.out.println(ls);
		ModelAndView mv = new ModelAndView("partyall");
		mv.addObject("ls", ls);

		return mv;
	}

}
