package g7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import g7.model.webInfo;
import g7.service.WebInfoService;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class ApplicationController {

	 
    @Autowired
    WebInfoService webInfoService;

    @RequestMapping("/")
    public String listUploadedFiles(Model model) throws IOException
    {
    	webInfo slideBarList=webInfoService.findById(21);
    	model.addAttribute("slidebar", slideBarList);
    	webInfo home=webInfoService.findById(19);
    	model.addAttribute("home",home);
        return "jsp/home";
    }

    @RequestMapping("/admin")
    public String admin(Model model) throws IOException
    {
    	List<webInfo> webpages=webInfoService.findAllWebPages();
    	model.addAttribute("webpages",webpages);
    	webInfo slideBarList=webInfoService.findById(21);
    	model.addAttribute("slidebar", slideBarList);
        return "jsp/example";
    }
    
    
    
    @RequestMapping(value = { "/callpaper" }, method = RequestMethod.GET)
    public String callpaper(Model model){
    
    	webInfo callpaper=webInfoService.findById(10);
    	model.addAttribute("callpaper",callpaper);
    	webInfo slideBarList=webInfoService.findById(21);
    	model.addAttribute("slidebar", slideBarList);
		return "jsp/Default789b";
    }
    
    @RequestMapping(value = { "/submission" }, method = RequestMethod.GET)
    public String submission(Model model){
    	webInfo submission=webInfoService.findById(15);
    	model.addAttribute("submission",submission);
    	webInfo slideBarList=webInfoService.findById(21);
    	model.addAttribute("slidebar", slideBarList);
		return "jsp/Defaultd478";
    	
    	
    }
    
    @RequestMapping(value = { "/registation" }, method = RequestMethod.GET)
    public String registation(Model model)
    {
    	
    	webInfo registration=webInfoService.findById(16);
    	model.addAttribute("registration",registration);
    	webInfo slideBarList=webInfoService.findById(21);
    	model.addAttribute("slidebar", slideBarList);
		return "jsp/Defaulta8ef";	
    }
    
    @RequestMapping(value = { "/keynotespeaker" }, method = RequestMethod.GET)
    public String keynotespeaker(Model model){
    	webInfo keynotespeaker=webInfoService.findById(17);
    	model.addAttribute("keynotespeaker",keynotespeaker);
    	webInfo slideBarList=webInfoService.findById(21);
    	model.addAttribute("slidebar", slideBarList);
		return "jsp/Default6b73";	
    }
    
    @RequestMapping(value = { "/contact" }, method = RequestMethod.GET)
    public String contact(Model model){
    	webInfo contact=webInfoService.findById(20);
    	model.addAttribute("contact",contact);
    	webInfo slideBarList=webInfoService.findById(21);
    	model.addAttribute("slidebar", slideBarList);
		return "jsp/Default84ba";	
    }
    @RequestMapping(value = { "/slidebar" }, method = RequestMethod.GET)
    public String sliderBar(Model model){
    	webInfo contact=webInfoService.findById(21);
    	model.addAttribute("slidebar",contact);
    	webInfo slideBarList=webInfoService.findById(21);
    	model.addAttribute("slidebar", slideBarList);
		return "jsp/Default84ba";	
    }
    
    @RequestMapping(value = { "/home_page" }, method = RequestMethod.GET)
    public String homepage(Model model){
    	webInfo slideBarList=webInfoService.findById(21);
    	model.addAttribute("slidebar", slideBarList);
		return "jsp/Default71a5.jsp?PageId=8cb7e0c5-10f3-438b-8881-a74c24b373e3";	
    }
    @RequestMapping(value = { "/venuehotel" }, method = RequestMethod.GET)
    public String hotelmapping(Model model){
    	webInfo venuehotel=webInfoService.findById(18);
    	model.addAttribute("venuehotel",venuehotel);
    	webInfo slideBarList=webInfoService.findById(21);
    	model.addAttribute("slidebar", slideBarList);
		return "jsp/Venue_Hotel";	
    }
    
    @RequestMapping(value = { "/latestnewsFirst" }, method = RequestMethod.GET)
    public String latestnewsFirst(Model model){
    	webInfo slideBarList=webInfoService.findById(21);
    	model.addAttribute("slidebar", slideBarList);
		return "jsp/index52be.jsp?ArticleId=3af2fa01-2645-4516-a65a-67bfec768e13";	
    }
    
    
    @RequestMapping(value = { "/latestnewsSecond" }, method = RequestMethod.GET)
    public String latestnewsSecond(Model model){
    	webInfo slideBarList=webInfoService.findById(21);
    	model.addAttribute("slidebar", slideBarList);
		return "jsp/indexe41c.jsp?ArticleId=bc474489-26ce-4997-a1c0-b37dce27b202";	
    }
    
    
    @RequestMapping(value = { "/latestnewsThird" }, method = RequestMethod.GET)
    public String latestnewsThird(Model model){
    	webInfo slideBarList=webInfoService.findById(21);
    	model.addAttribute("slidebar", slideBarList);
		return "jsp/indexc489.jsp?ArticleId=f796f938-0681-4d25-b47e-6bcd24536152";	
    }
    
    
	@RequestMapping(value = { "/delete-page-{pageID}" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable String pageID) {
		int id=Integer.parseInt(pageID);
		webInfoService.deleteUserById(id);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = { "/new-webpage" }, method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		webInfo webInfo = new webInfo();
		model.addAttribute("webInfo", webInfo);
		return "jsp/regist";
	}

	
	@RequestMapping(value = { "/new-webpage" }, method = RequestMethod.POST)
	public String saveUser(@Valid webInfo webInfo, BindingResult result,
			ModelMap model) 
	{
		webInfoService.saveWebpage(webInfo);
		return "redirect:/";
	}
    
    
	@RequestMapping(value = { "/edit-webpage-{pageID}" }, method = RequestMethod.GET)
	public String editUser(@PathVariable String pageID, ModelMap model) {
		int id=Integer.parseInt(pageID);
		webInfo webInfo = webInfoService.findById(id);
		model.addAttribute("webInfo", webInfo);
	
		return "jsp/regist";
	}
	
	@RequestMapping(value = { "/edit-webpage-{pageID}" }, method = RequestMethod.POST)
	public String updateUser(@Valid webInfo webInfo, 
			ModelMap model, @PathVariable int pageID) {

	

		webInfoService.updateWebpage(webInfo);

		
		return "redirect:/";
	}
	@RequestMapping(value = { "/edit" }, method = RequestMethod.GET)
	public String newfile(ModelMap model) {
		webInfo webInfo = new webInfo();
		model.addAttribute("webInfo", webInfo);
		return "jsp/regist";
	}
	
	@RequestMapping(value = { "/edit" }, method = RequestMethod.POST)
	public String upload(@Valid webInfo webInfo, BindingResult result,
			ModelMap model) 
	{
		webInfoService.saveWebpage(webInfo);
		return "redirect:/";
	}

    
    @RequestMapping(value = { "/upfile-webpage-{pageID}" }, method = RequestMethod.GET)
	public String upload(@PathVariable String pageID, ModelMap model) {
		
	
		return "jsp/uploadnews";
	}
}
