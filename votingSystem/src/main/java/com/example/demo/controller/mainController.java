package com.example.demo.controller;

import java.sql.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Party;
import com.example.demo.entity.User;
import com.example.demo.entity.Vote;
import com.example.demo.service.AdminService;
import com.example.demo.service.PartyService;
import com.example.demo.service.UserService;
import com.example.demo.service.VoteService;

@RestController
@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET, RequestMethod.DELETE, RequestMethod.PUT })
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

	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");

		return mv;

	}

	@GetMapping("/Logout")
	public ModelAndView logout() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

	@GetMapping("/searchUser")
	public ModelAndView searchUser(@RequestParam String name) {
		ModelAndView mv = new ModelAndView("userall");
		List<User> ls1 = userservice.searchUser(name);
		System.out.println(ls1);
		mv.addObject("ls", ls1);
		if (ls1.isEmpty()) {
			List<User> ls = userservice.listall();
			ModelAndView mv1 = new ModelAndView("userall");
			mv1.addObject("ls", ls);
			return mv1;

		}
		return mv;
	}

	@RequestMapping(value = "/updateUserDet/{id}", method = RequestMethod.GET)
	public ModelAndView saveStudent(@PathVariable(value = "id") int uid, @ModelAttribute("user") User user) {
		System.out.println("post");
		User existingUser = userservice.findbyid(uid);
		existingUser.setAddress(user.getAddress());
		existingUser.setDob(user.getDob());
		existingUser.setFname(user.getFname());
		existingUser.setLname(user.getLname());
		existingUser.setMno(user.getMno());
		existingUser.setPermission(false);
		userservice.save(existingUser);
		List<User> ls = userservice.listall();
		ModelAndView mv = new ModelAndView("userall");
		mv.addObject("ls", ls);
		return mv;
	}

//    @RequestMapping(value= "/UpdateUser/{id}", method= RequestMethod.GET)
	@GetMapping("/students/edit/{id}")
	public ModelAndView editStudentForm(@PathVariable(value = "id") int a) {

		User user = userservice.findbyid(a);
		System.out.println(user.toString());
		ModelAndView mv = new ModelAndView("updateUser");
		mv.addObject("obj", user);
		return mv;
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
		u.setPermission(false);
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

	@GetMapping("/finduser")
	public ModelAndView find(@RequestParam int uid) {
		if (userservice.find(uid)) {
			if ( voteservice.votedorno(uid)) {
				ModelAndView mv=new ModelAndView("voted");
				return mv;
			}
			ModelAndView mv = new ModelAndView("userDashboard");
			List<Party> ls = partyservice.listall();
			mv.addObject("uid", uid);
			mv.addObject("partys", ls);
			System.out.println("found");
			return mv;
		} else {
			ModelAndView mv1 = new ModelAndView("login");
			return mv1;
		}

	}

	@RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.GET)
	public ModelAndView deleteuser(@PathVariable(value = "id") int uid) {
		ModelAndView mv = new ModelAndView("userall");
		userservice.deleteuser(uid);
		List<User> ls = userservice.listall();
		mv.addObject("ls", ls);
		System.out.println("deleted");
		return mv;
	}

	@RequestMapping(value = "/BacktoDashboard")
	public ModelAndView Backbutton() {
		ModelAndView mv = new ModelAndView("adminDashboard");
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
		Party p = new Party(partyname);
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

	@DeleteMapping("/admin/delete/{id}")
	public ModelAndView deleteAdmin(@PathVariable(value = "id") int id) {
		adminservice.deleteAdmin(id);
		ModelAndView mv = new ModelAndView("/adminDashboard");
		return mv;
	}

	@GetMapping("findAdmin")
	public ModelAndView findAdmin(@RequestParam String name, String password) {
		try {
			String a = adminservice.findAdmin(name, password);
			System.out.println(a);
			ModelAndView mv = new ModelAndView("adminDashboard");
			if (a.equals(name)) {

				System.out.println("match");
				return mv;

			} else {
				ModelAndView mv1 = new ModelAndView("login");
				return mv1;
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			ModelAndView mv1 = new ModelAndView("login");
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
		Party p = new Party(partyname);
		partyservice.save(p);
		List<Party> ls = partyservice.listall();
		ModelAndView mv = new ModelAndView("/partyall");
		mv.addObject("ls", ls);
		return mv;
	}

	@GetMapping("/partyall")
	public ModelAndView ls4() {

		List<Party> ls = partyservice.listall();
		ModelAndView mv = new ModelAndView("partyall");
		mv.addObject("ls", ls);

		return mv;
	}

	@RequestMapping("/deleteparty/{id}")
	public ModelAndView deleteparty(@PathVariable(value = ("id")) String partyname) {
		System.out.println(partyname);
		partyservice.deleteParty(partyname);
		List<Party> ls = partyservice.listall();
		ModelAndView mv = new ModelAndView("/partyall");
		mv.addObject("ls", ls);
		return mv;
	}

}
