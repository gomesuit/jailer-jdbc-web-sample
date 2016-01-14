package jailer.jdbc.web.sample.web;

import jailer.jdbc.web.sample.mapper.SampleMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManagerTopController {
	@Autowired
	private SampleMapper sampleMapper;
    
    @RequestMapping("/")
    private String top(Model model){
    	model.addAttribute("number", sampleMapper.selectNumber());
        return "sample";
    }
}
