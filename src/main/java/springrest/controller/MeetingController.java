package springrest.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springrest.entity.Meeting;
import springrest.service.MeetingService;

//@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/meeting")
public class MeetingController {
	
	@Autowired
	private MeetingService meetingService;
	
	@GetMapping("/list")
	public List<Meeting> listMeetings() {
//		TODO delete later, this is just to see better hoe the loading image looks like in frontend
//		try {
//			TimeUnit.SECONDS.sleep(3);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		return meetingService.getMeetings();
	}
	
	@DeleteMapping
	public void deleteMeeting(@RequestParam int id) {
		System.out.println("delete in controller");
		meetingService.deleteMeeting(id);
	}
	
}
